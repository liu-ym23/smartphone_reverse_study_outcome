package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;

    public class DisallowIntercept implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ForwardingListener$DisallowIntercept_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ForwardingListener$DisallowIntercept__run$___twin___() {
            ViewParent r100 = this.this$0.mSrc.getParent();
            if (r100 == null) goto L6;
            r100.requestDisallowInterceptTouchEvent(true);
            return;
        }

        public DisallowIntercept(ForwardingListener r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ForwardingListener$DisallowIntercept_com_larus_apm_impl_protector_RunnableLancet_run(DisallowIntercept r100) {
            r100.androidx_appcompat_widget_ForwardingListener$DisallowIntercept__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class TriggerLongPress implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ForwardingListener$TriggerLongPress_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ForwardingListener$TriggerLongPress__run$___twin___() {
            this.this$0.onLongPress();
        }

        public TriggerLongPress(ForwardingListener r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ForwardingListener$TriggerLongPress_com_larus_apm_impl_protector_RunnableLancet_run(TriggerLongPress r100) {
            r100.androidx_appcompat_widget_ForwardingListener$TriggerLongPress__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract ShowableListMenu getPopup();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
    }

    private void clearCallbacks() {
        Runnable r100 = this.mTriggerLongPress;
        if (r100 == null) goto L5;
        this.mSrc.removeCallbacks(r100);
    L5:
        Runnable r101 = this.mDisallowIntercept;
        if (r101 == null) goto L9;
        this.mSrc.removeCallbacks(r101);
        return;
    }

    public boolean onForwardingStarted() {
        ShowableListMenu r100 = getPopup();
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.isShowing() == true) goto L10;
        r100.show();
        return true;
    L10:
        return true;
    }

    public boolean onForwardingStopped() {
        ShowableListMenu r100 = getPopup();
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.isShowing() == false) goto L10;
        r100.dismiss();
        return true;
    L10:
        return true;
    }

    public void onLongPress() {
        clearCallbacks();
        View r100 = this.mSrc;
        if (r100.isEnabled() == true) goto L5;
        return;
    L5:
        if (r100.isLongClickable() == false) goto L8;
        return;
    L8:
        if (onForwardingStarted() == true) goto L10;
        return;
    L10:
        r100.getParent().requestDisallowInterceptTouchEvent(true);
        long r101 = SystemClock.uptimeMillis();
        MotionEvent r102 = MotionEvent.obtain(r101, r101, 3, 0.0f, 0.0f, 0);
        r100.onTouchEvent(r102);
        r102.recycle();
        this.mForwarding = true;
    }

    public ForwardingListener(View r100) {
        this.mTmpLocation = new int[2];
        this.mSrc = r100;
        r100.setLongClickable(true);
        r100.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        int r101 = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = r101;
        this.mLongPressTimeout = (r101 + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean onTouchForwarded(MotionEvent r100) {
        View r101 = this.mSrc;
        ShowableListMenu r102 = getPopup();
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.isShowing() == false) goto L26;
        DropDownListView r103 = (DropDownListView) r102.getListView();
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.isShown() == false) goto L27;
        MotionEvent r104 = MotionEvent.obtainNoHistory(r100);
        toGlobalMotionEvent(r101, r104);
        toLocalMotionEvent(r103, r104);
        boolean r105 = r103.onForwardedEvent(r104, this.mActivePointerId);
        r104.recycle();
        int r106 = r100.getActionMasked();
        if (r106 != 1) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r105 == false) goto L24;
        if (r107 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L15:
        if (r106 == 3) goto L17;
        r107 = true;
        goto L18
    L27:
        return false;
    L26:
        return false;
    }

    private boolean onTouchObserved(MotionEvent r100) {
        View r101 = this.mSrc;
        if (r101.isEnabled() == true) goto L5;
        return false;
    L5:
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L8;
        this.mActivePointerId = r100.getPointerId(0);
        if (this.mDisallowIntercept != null) goto L24;
        this.mDisallowIntercept = new DisallowIntercept(this);
    L24:
        r101.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
        if (this.mTriggerLongPress != null) goto L27;
        this.mTriggerLongPress = new TriggerLongPress(this);
    L27:
        r101.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
    L28:
        return false;
    L8:
        if (r102 != 1) goto L10;
    L20:
        clearCallbacks();
        goto L28
    L10:
        if (r102 != 2) goto L12;
        int r103 = r100.findPointerIndex(this.mActivePointerId);
        if (r103 < 0) goto L28;
        if (pointInView(r101, r100.getX(r103), r100.getY(r103), this.mScaledTouchSlop) == true) goto L28;
        clearCallbacks();
        r101.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        if (r102 == 3) goto L20;
        goto L20
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable r101 = this.mDisallowIntercept;
        if (r101 == null) goto L6;
        this.mSrc.removeCallbacks(r101);
        return;
    }

    private boolean toGlobalMotionEvent(View r100, MotionEvent r101) {
        int[] r102 = this.mTmpLocation;
        r100.getLocationOnScreen(r102);
        r101.offsetLocation(r102[0], r102[1]);
        return true;
    }

    private boolean toLocalMotionEvent(View r100, MotionEvent r101) {
        int[] r102 = this.mTmpLocation;
        r100.getLocationOnScreen(r102);
        r101.offsetLocation(-r102[0], -r102[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r110, MotionEvent r111) {
        boolean r112 = this.mForwarding;
        if (r112 == false) goto L12;
        if (onTouchForwarded(r111) == false) goto L7;
    L10:
        boolean r113 = true;
    L19:
        this.mForwarding = r113;
        if (r113 == true) goto L25;
        if (r112 == true) goto L26;
        return false;
    L26:
        return true;
    L25:
        return true;
    L7:
        if (onForwardingStopped() == false) goto L10;
        r113 = false;
        goto L19
    L12:
        if (onTouchObserved(r111) == true) goto L14;
    L16:
        r113 = false;
    L17:
        if (r113 == false) goto L19;
        long r100 = SystemClock.uptimeMillis();
        MotionEvent r101 = MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0);
        this.mSrc.onTouchEvent(r101);
        r101.recycle();
        goto L19
    L14:
        if (onForwardingStarted() == false) goto L16;
        r113 = true;
        goto L17
    }

    private static boolean pointInView(View r100, float r101, float r102, float r103) {
        float r104 = -r103;
        if (r101 >= r104) goto L5;
    L11:
        return false;
    L5:
        if (r102 < r104) goto L11;
        if (r101 >= ((r100.getRight() - r100.getLeft()) + r103)) goto L11;
        if (r102 >= ((r100.getBottom() - r100.getTop()) + r103)) goto L11;
        return true;
    }
}
