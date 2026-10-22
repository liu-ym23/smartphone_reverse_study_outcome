package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.o0;
import androidx.lifecycle.p0;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;

    @Nullable
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private Observer<LifecycleOwner> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogFragment f3128a;

        public a(DialogFragment r10) {
            this.f3128a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogFragment.access$100(this.f3128a).onDismiss(DialogFragment.access$000(this.f3128a));
        }
    }

    public class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogFragment f3129a;

        public b(DialogFragment r10) {
            this.f3129a = r10;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r10) {
            if (DialogFragment.access$000(this.f3129a) == null) goto L6;
            DialogFragment r11 = this.f3129a;
            r11.onCancel(DialogFragment.access$000(r11));
            return;
        }
    }

    public class c implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogFragment f3130a;

        public c(DialogFragment r10) {
            this.f3130a = r10;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface r10) {
            if (DialogFragment.access$000(this.f3130a) == null) goto L6;
            DialogFragment r11 = this.f3130a;
            r11.onDismiss(DialogFragment.access$000(r11));
            return;
        }
    }

    public class d implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogFragment f3131a;

        public d(DialogFragment r10) {
            this.f3131a = r10;
        }

        public void a(LifecycleOwner r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (DialogFragment.access$200(this.f3131a) == false) goto L16;
            View r11 = this.f3131a.requireView();
            if (r11.getParent() != null) goto L14;
            if (DialogFragment.access$000(this.f3131a) != null) goto L10;
            return;
        L10:
            if (FragmentManager.L0(3) == false) goto L12;
            Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogFragment.access$000(this.f3131a));
        L12:
            DialogFragment.access$000(this.f3131a).setContentView(r11);
            return;
        L14:
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }

        @Override // androidx.lifecycle.Observer
        public /* bridge */ /* synthetic */ void onChanged(Object r10) {
            a((LifecycleOwner) r10);
        }
    }

    public class e extends FragmentContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentContainer f3132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogFragment f3133b;

        public e(DialogFragment r10, FragmentContainer r11) {
            this.f3133b = r10;
            this.f3132a = r11;
        }

        @Override // androidx.fragment.app.FragmentContainer
        public View b(int r10) {
            if (this.f3132a.c() == false) goto L7;
            return this.f3132a.b(r10);
        L7:
            return this.f3133b.onFindViewById(r10);
        }

        @Override // androidx.fragment.app.FragmentContainer
        public boolean c() {
            if (this.f3132a.c() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f3133b.onHasView() == true) goto L8;
            return false;
        }
    }

    public DialogFragment() {
        this.mDismissRunnable = new a(this);
        this.mOnCancelListener = new b(this);
        this.mOnDismissListener = new c(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new d(this);
        this.mDialogCreated = false;
    }

    public static /* synthetic */ Dialog access$000(DialogFragment r10) {
        return r10.mDialog;
    }

    public static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment r10) {
        return r10.mOnDismissListener;
    }

    public static /* synthetic */ boolean access$200(DialogFragment r10) {
        return r10.mShowsDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public FragmentContainer createFragmentContainer() {
        return new e(this, super.createFragmentContainer());
    }

    public void dismiss() {
        i(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        i(true, false, false);
    }

    @MainThread
    public void dismissNow() {
        i(false, false, true);
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public final void i(boolean r10, boolean r11, boolean r12) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog r13 = this.mDialog;
        if (r13 == null) goto L13;
        r13.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (r11 == true) goto L13;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L12;
        onDismiss(this.mDialog);
        goto L13
    L12:
        this.mHandler.post(this.mDismissRunnable);
    L13:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L19;
        if (r12 == false) goto L17;
        getParentFragmentManager().j1(this.mBackStackId, 1);
    L18:
        this.mBackStackId = -1;
        return;
    L17:
        getParentFragmentManager().g1(this.mBackStackId, 1, r10);
        goto L18
    L19:
        FragmentTransaction r14 = getParentFragmentManager().o();
        r14.z(true);
        r14.t(this);
        if (r12 == false) goto L22;
        r14.l();
        return;
    L22:
        if (r10 == false) goto L24;
        r14.k();
        return;
    L24:
        r14.j();
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public final void j(Bundle r10) {
        if (this.mShowsDialog == true) goto L6;
        return;
    L6:
        if (this.mDialogCreated == false) goto L21;
        return;
    L21:
        this.mCreatingDialog = true;     // Catch: Throwable -> L13
        Dialog r11 = onCreateDialog(r10);     // Catch: Throwable -> L13
        this.mDialog = r11;     // Catch: Throwable -> L13
        if (this.mShowsDialog == false) goto L16;
        setupDialog(r11, this.mStyle);     // Catch: Throwable -> L13
        Context r12 = getContext();     // Catch: Throwable -> L13
        if ((r12 instanceof Activity) == false) goto L15;
        this.mDialog.setOwnerActivity((Activity) r12);     // Catch: Throwable -> L13
    L15:
        this.mDialog.setCancelable(this.mCancelable);     // Catch: Throwable -> L13
        this.mDialog.setOnCancelListener(this.mOnCancelListener);     // Catch: Throwable -> L13
        this.mDialog.setOnDismissListener(this.mOnDismissListener);     // Catch: Throwable -> L13
        this.mDialogCreated = true;     // Catch: Throwable -> L13
    L17:
        this.mCreatingDialog = false;
        return;
    L16:
        this.mDialog = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.mCreatingDialog = false;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle r10) {
        super.onActivityCreated(r10);
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onAttach(@NonNull Context r10) {
        super.onAttach(r10);
        getViewLifecycleOwnerLiveData().j(this.mObserver);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface r10) {
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        this.mHandler = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r11 = true;
    L6:
        this.mShowsDialog = r11;
        if (r10 == null) goto L10;
        this.mStyle = r10.getInt(SAVED_STYLE, 0);
        this.mTheme = r10.getInt(SAVED_THEME, 0);
        this.mCancelable = r10.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = r10.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = r10.getInt(SAVED_BACK_STACK_ID, -1);
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public Dialog onCreateDialog(Bundle r10) {
        if (FragmentManager.L0(3) == false) goto L6;
        Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
    L6:
        return new ComponentDialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L9;
        this.mViewDestroyed = true;
        r10.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (this.mDismissed == true) goto L7;
        onDismiss(this.mDialog);
    L7:
        this.mDialog = null;
        this.mDialogCreated = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDetach() {
        super.onDetach();
        if (this.mShownByMe == false) goto L5;
    L7:
        getViewLifecycleOwnerLiveData().n(this.mObserver);
        return;
    L5:
        if (this.mDismissed == true) goto L7;
        this.mDismissed = true;
        goto L7
    }

    @Override // android.content.DialogInterface.OnDismissListener
    @CallSuper
    public void onDismiss(@NonNull DialogInterface r10) {
        if (this.mViewDestroyed == false) goto L5;
        return;
    L5:
        if (FragmentManager.L0(3) == false) goto L7;
        Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
    L7:
        i(true, true, false);
    }

    @Nullable
    public View onFindViewById(int r10) {
        Dialog r11 = this.mDialog;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.findViewById(r10);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r10) {
        LayoutInflater r11 = super.onGetLayoutInflater(r10);
        if (this.mShowsDialog == false) goto L15;
        if (this.mCreatingDialog == true) goto L15;
        j(r10);
        if (FragmentManager.L0(2) == false) goto L10;
        Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
    L10:
        Dialog r12 = this.mDialog;
        if (r12 != null) goto L13;
        return r11;
    L13:
        return r11.cloneInContext(r12.getContext());
    L15:
        if (FragmentManager.L0(2) == false) goto L20;
        String r13 = "getting layout inflater for DialogFragment " + this;
        if (this.mShowsDialog == true) goto L19;
        Log.d("FragmentManager", "mShowsDialog = false: " + r13);
        goto L20
    L19:
        Log.d("FragmentManager", "mCreatingDialog = true: " + r13);
    L20:
        return r11;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        Dialog r11 = this.mDialog;
        if (r11 == null) goto L5;
        Bundle r12 = r11.onSaveInstanceState();
        r12.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
        r10.putBundle(SAVED_DIALOG_STATE_TAG, r12);
    L5:
        int r13 = this.mStyle;
        if (r13 == 0) goto L8;
        r10.putInt(SAVED_STYLE, r13);
    L8:
        int r14 = this.mTheme;
        if (r14 == 0) goto L11;
        r10.putInt(SAVED_THEME, r14);
    L11:
        boolean r15 = this.mCancelable;
        if (r15 == true) goto L14;
        r10.putBoolean(SAVED_CANCELABLE, r15);
    L14:
        boolean r16 = this.mShowsDialog;
        if (r16 == true) goto L17;
        r10.putBoolean(SAVED_SHOWS_DIALOG, r16);
    L17:
        int r17 = this.mBackStackId;
        if (r17 == (-1)) goto L21;
        r10.putInt(SAVED_BACK_STACK_ID, r17);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStart() {
        super.onStart();
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L6;
        this.mViewDestroyed = false;
        r10.show();
        View r11 = this.mDialog.getWindow().getDecorView();
        o0.a(r11, this);
        p0.a(r11, this);
        androidx.savedstate.c.a(r11, this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStop() {
        super.onStop();
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L6;
        r10.hide();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r10) {
        super.onViewStateRestored(r10);
        if (this.mDialog == null) goto L9;
        if (r10 == null) goto L10;
        Bundle r11 = r10.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r11 == null) goto L11;
        this.mDialog.onRestoreInstanceState(r11);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        super.performCreateView(r10, r11, r12);
        if (this.mView == null) goto L5;
        return;
    L5:
        if (this.mDialog == null) goto L12;
        if (r12 == null) goto L13;
        Bundle r13 = r12.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r13 == null) goto L14;
        this.mDialog.onRestoreInstanceState(r13);
        return;
    L14:
        return;
    L13:
        return;
    }

    @NonNull
    public final ComponentDialog requireComponentDialog() {
        Dialog r10 = requireDialog();
        if ((r10 instanceof ComponentDialog) == false) goto L7;
        return (ComponentDialog) r10;
    L7:
        throw new IllegalStateException("DialogFragment " + this + " did not return a ComponentDialog instance from requireDialog(). The actual Dialog is " + r10);
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog r10 = getDialog();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean r10) {
        this.mCancelable = r10;
        Dialog r11 = this.mDialog;
        if (r11 == null) goto L6;
        r11.setCancelable(r10);
        return;
    }

    public void setShowsDialog(boolean r10) {
        this.mShowsDialog = r10;
    }

    public void setStyle(int r10, @StyleRes int r11) {
        if (FragmentManager.L0(2) == false) goto L5;
        Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + r10 + ", " + r11);
    L5:
        this.mStyle = r10;
        if (r10 != 2) goto L8;
    L9:
        this.mTheme = R.style.Theme.Panel;
    L10:
        if (r11 == 0) goto L13;
        this.mTheme = r11;
        return;
    L13:
        return;
    L8:
        if (r10 != 3) goto L10;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r10, int r11) {
        if (r11 != 1) goto L5;
    L12:
        r10.requestWindowFeature(1);
        return;
    L5:
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L14;
        Window r12 = r10.getWindow();
        if (r12 == null) goto L12;
        r12.addFlags(24);
        goto L12
    }

    public void show(@NonNull FragmentManager r10, @Nullable String r11) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r12 = r10.o();
        r12.z(true);
        r12.e(this, r11);
        r12.j();
    }

    public void showNow(@NonNull FragmentManager r10, @Nullable String r11) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r12 = r10.o();
        r12.z(true);
        r12.e(this, r11);
        r12.l();
    }

    public int show(@NonNull FragmentTransaction r10, @Nullable String r11) {
        this.mDismissed = false;
        this.mShownByMe = true;
        r10.e(this, r11);
        this.mViewDestroyed = false;
        int r12 = r10.j();
        this.mBackStackId = r12;
        return r12;
    }
}
