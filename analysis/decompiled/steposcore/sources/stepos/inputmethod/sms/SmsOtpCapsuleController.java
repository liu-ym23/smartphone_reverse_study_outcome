package stepos.inputmethod.sms;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.Region;
import android.inputmethodservice.InputMethodService;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import stepos.app.IStepOSWindowManager;
import stepos.app.StepOSWindowManager;
import stepos.inputmethod.sms.ISmsOtpCapsuleListener;
import stepos.inputmethod.sms.ISmsOtpCapsuleService;

/* loaded from: classes.dex */
public final class SmsOtpCapsuleController {
    private static final boolean DEBUG = false;
    private static final String SERVICE_NAME = "sms_otp_capsule";
    private static final String TAG = "SmsOtpCapsuleController";
    private boolean mAddedToWindow;
    private boolean mAttached;
    private final View mCapsuleView;
    private SmsOtp mCurrent;
    private final ImageView mIconView;
    private boolean mImeVisible;
    private final InputMethodService mIms;
    private final View mInputArea;
    private final TextView mLabelView;
    private final int mOffsetBottomPx;
    private ISmsOtpCapsuleService mService;
    private final View.OnLayoutChangeListener mInputAreaLayoutListener = new View.OnLayoutChangeListener() { // from class: stepos.inputmethod.sms.SmsOtpCapsuleController$$ExternalSyntheticLambda0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f$0.lambda$new$0(view, i, i2, i3, i4, i5, i6, i7, i8);
        }
    };
    private final ViewTreeObserver.OnComputeInternalInsetsListener mInsetsListener = new ViewTreeObserver.OnComputeInternalInsetsListener() { // from class: stepos.inputmethod.sms.SmsOtpCapsuleController$$ExternalSyntheticLambda1
        public final void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
            this.f$0.onComputeCapsuleInsets(internalInsetsInfo);
        }
    };
    private final ISmsOtpCapsuleListener.Stub mListener = new AnonymousClass1();
    private final Handler mMain = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (bottom - top != oldBottom - oldTop) {
            updateCapsuleBottomMargin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onComputeCapsuleInsets(ViewTreeObserver.InternalInsetsInfo info) {
        if (this.mCapsuleView.getVisibility() != 0) {
            return;
        }
        int[] loc = new int[2];
        this.mCapsuleView.getLocationInWindow(loc);
        int capsuleLeft = loc[0];
        int capsuleTop = loc[1];
        int capsuleRight = this.mCapsuleView.getWidth() + capsuleLeft;
        int capsuleBottom = this.mCapsuleView.getHeight() + capsuleTop;
        Dialog dlg = this.mIms.getWindow();
        if (dlg == null || dlg.getWindow() == null) {
            return;
        }
        View decor = dlg.getWindow().getDecorView();
        Region region = info.touchableRegion;
        region.set(0, info.visibleInsets.top, decor.getWidth(), decor.getHeight());
        region.union(new Rect(capsuleLeft, capsuleTop, capsuleRight, capsuleBottom));
        info.setTouchableInsets(3);
    }

    /* renamed from: stepos.inputmethod.sms.SmsOtpCapsuleController$1, reason: invalid class name */
    class AnonymousClass1 extends ISmsOtpCapsuleListener.Stub {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCapsuleUpdate$0(SmsOtp otp) {
            SmsOtpCapsuleController.this.applyState(otp);
        }

        @Override // stepos.inputmethod.sms.ISmsOtpCapsuleListener
        public void onCapsuleUpdate(final SmsOtp otp) {
            SmsOtpCapsuleController.this.mMain.post(new Runnable() { // from class: stepos.inputmethod.sms.SmsOtpCapsuleController$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCapsuleUpdate$0(otp);
                }
            });
        }
    }

    public static SmsOtpCapsuleController attach(InputMethodService ims, View rootView, LayoutInflater inflater) {
        SmsOtpCapsuleController c = new SmsOtpCapsuleController(ims, rootView, inflater);
        c.doAttach();
        return c;
    }

    private SmsOtpCapsuleController(InputMethodService ims, View rootView, LayoutInflater inflater) {
        this.mIms = ims;
        this.mCapsuleView = inflater.inflate(17367490, (ViewGroup) null);
        this.mIconView = (ImageView) this.mCapsuleView.findViewById(16909986);
        this.mLabelView = (TextView) this.mCapsuleView.findViewById(16909987);
        this.mCapsuleView.setOnClickListener(new View.OnClickListener() { // from class: stepos.inputmethod.sms.SmsOtpCapsuleController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        this.mCapsuleView.setVisibility(8);
        this.mInputArea = rootView.findViewById(R.id.inputArea);
        this.mOffsetBottomPx = this.mCapsuleView.getResources().getDimensionPixelSize(17106765);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View v) {
        onCapsuleClicked();
    }

    public void onImeWindowVisibilityChanged(boolean visible) {
        this.mImeVisible = visible;
        applyVisibility();
    }

    public void detach() {
        if (this.mAttached) {
            this.mAttached = false;
            if (this.mInputArea != null) {
                this.mInputArea.removeOnLayoutChangeListener(this.mInputAreaLayoutListener);
            }
            ViewTreeObserver vto = this.mCapsuleView.getViewTreeObserver();
            if (vto.isAlive()) {
                vto.removeOnComputeInternalInsetsListener(this.mInsetsListener);
            }
            removeCapsuleFromWindow();
            try {
                if (this.mService != null) {
                    this.mService.unregisterListener(this.mListener);
                }
            } catch (RemoteException e) {
            }
            this.mService = null;
        }
    }

    private void doAttach() {
        this.mAttached = true;
        addCapsuleToWindow();
        if (this.mInputArea != null) {
            this.mInputArea.addOnLayoutChangeListener(this.mInputAreaLayoutListener);
            updateCapsuleBottomMargin();
        }
        this.mCapsuleView.getViewTreeObserver().addOnComputeInternalInsetsListener(this.mInsetsListener);
        ISmsOtpCapsuleService svc = ensureService();
        if (svc == null) {
            Log.w(TAG, "doAttach: service is null, cannot registerListener");
            return;
        }
        try {
            svc.registerListener(this.mListener);
        } catch (RemoteException e) {
            Log.w(TAG, "registerListener", e);
            this.mService = null;
        }
    }

    private void addCapsuleToWindow() {
        if (this.mAddedToWindow) {
            return;
        }
        Dialog dlg = this.mIms.getWindow();
        if (dlg == null) {
            Log.w(TAG, "addCapsuleToWindow: ims.getWindow() is null");
            return;
        }
        Window window = dlg.getWindow();
        if (window == null) {
            Log.w(TAG, "addCapsuleToWindow: dlg.getWindow() is null");
            return;
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        lp.gravity = 81;
        lp.bottomMargin = computeBottomMargin();
        window.addContentView(this.mCapsuleView, lp);
        this.mAddedToWindow = true;
    }

    private void removeCapsuleFromWindow() {
        if (this.mAddedToWindow) {
            ViewGroup parent = (ViewGroup) this.mCapsuleView.getParent();
            if (parent != null) {
                parent.removeView(this.mCapsuleView);
            }
            this.mAddedToWindow = false;
        }
    }

    private int computeBottomMargin() {
        try {
            InputMethodService.Insets insets = new InputMethodService.Insets();
            this.mIms.onComputeInsets(insets);
            int visibleTop = insets.visibleTopInsets;
            View parent = this.mCapsuleView.getParent() instanceof View ? (View) this.mCapsuleView.getParent() : null;
            int parentHeight = parent != null ? parent.getHeight() : 0;
            if (visibleTop > 0 && parentHeight > 0) {
                return (parentHeight - visibleTop) + this.mOffsetBottomPx;
            }
        } catch (Exception e) {
            Log.w(TAG, "computeBottomMargin: onComputeInsets failed", e);
        }
        int inputAreaHeight = 0;
        if (this.mInputArea != null && this.mInputArea.getVisibility() != 8) {
            inputAreaHeight = this.mInputArea.getHeight();
        }
        return this.mOffsetBottomPx + inputAreaHeight;
    }

    private void updateCapsuleBottomMargin() {
        ViewGroup.LayoutParams params = this.mCapsuleView.getLayoutParams();
        if (params instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) params;
            int newMargin = computeBottomMargin();
            if (lp.bottomMargin != newMargin) {
                lp.bottomMargin = newMargin;
                this.mCapsuleView.setLayoutParams(lp);
            }
        }
    }

    private ISmsOtpCapsuleService ensureService() {
        IStepOSWindowManager wm;
        if (this.mService != null && this.mService.asBinder().isBinderAlive()) {
            return this.mService;
        }
        this.mService = null;
        try {
            wm = StepOSWindowManager.getInstance().getService();
        } catch (RemoteException e) {
            Log.w(TAG, "ensureService", e);
        } catch (Throwable t) {
            Log.w(TAG, "ensureService: StepOSWindowManager not available", t);
        }
        if (wm == null) {
            Log.w(TAG, "ensureService: StepOSWindowManager.getService() returned null");
            return null;
        }
        IBinder b = wm.getSubService(SERVICE_NAME);
        if (b == null) {
            Log.w(TAG, "ensureService: getSubService('sms_otp_capsule') returned null");
            return null;
        }
        this.mService = ISmsOtpCapsuleService.Stub.asInterface(b);
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyState(SmsOtp otp) {
        this.mCurrent = otp;
        if (otp != null) {
            this.mLabelView.setText(otp.getLabel());
            if (otp.getIcon() != null) {
                this.mIconView.setImageIcon(otp.getIcon());
            } else {
                this.mIconView.setImageResource(17304939);
            }
            this.mIconView.setVisibility(0);
        }
        applyVisibility();
    }

    private void applyVisibility() {
        boolean show = this.mImeVisible && this.mCurrent != null && SystemClock.elapsedRealtime() < this.mCurrent.getExpiryRealtimeMs();
        this.mCapsuleView.setVisibility(show ? 0 : 8);
        if (show) {
            updateCapsuleBottomMargin();
        }
    }

    private void onCapsuleClicked() {
        SmsOtp current = this.mCurrent;
        if (current == null) {
            return;
        }
        try {
            InputConnection ic = this.mIms.getCurrentInputConnection();
            if (ic != null && current.getCode() != null) {
                ic.commitText(current.getCode(), 1);
            }
            try {
                ISmsOtpCapsuleService svc = this.mService;
                if (svc != null) {
                    svc.clear();
                }
            } catch (RemoteException e) {
                Log.w(TAG, "clear after commit", e);
            }
        } catch (Throwable th) {
            try {
                ISmsOtpCapsuleService svc2 = this.mService;
                if (svc2 != null) {
                    svc2.clear();
                }
            } catch (RemoteException e2) {
                Log.w(TAG, "clear after commit", e2);
            }
            throw th;
        }
    }
}
