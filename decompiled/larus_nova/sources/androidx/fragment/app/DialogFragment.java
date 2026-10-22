package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes17.dex */
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

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    public void onCancel(DialogInterface r100) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(this, r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onStart(this);
    }

    public DialogFragment() {
        this.mDismissRunnable = new AnonymousClass1(this);
        this.mOnCancelListener = new AnonymousClass2(this);
        this.mOnDismissListener = new AnonymousClass3(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new AnonymousClass4(this);
        this.mDialogCreated = false;
    }

    public void androidx_fragment_app_DialogFragment__onStart$___twin___() {
        super.onStart();
        Dialog r100 = this.mDialog;
        if (r100 == null) goto L6;
        this.mViewDestroyed = false;
        INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
        View r101 = INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mDialog.getWindow());
        ViewTreeLifecycleOwner.set(r101, this);
        ViewTreeViewModelStoreOwner.set(r101, this);
        ViewTreeSavedStateRegistryOwner.set(r101, this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public FragmentContainer createFragmentContainer() {
        final FragmentContainer r100 = super.createFragmentContainer();
        return new AnonymousClass5(this, r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog r100 = this.mDialog;
        if (r100 == null) goto L9;
        this.mViewDestroyed = true;
        r100.setOnDismissListener(null);
        INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.mDialog);
        if (this.mDismissed == true) goto L7;
        onDismiss(this.mDialog);
    L7:
        this.mDialog = null;
        this.mDialogCreated = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mShownByMe == false) goto L5;
    L7:
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
        return;
    L5:
        if (this.mDismissed == true) goto L7;
        this.mDismissed = true;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog r100 = this.mDialog;
        if (r100 == null) goto L6;
        r100.hide();
        return;
    }

    public final Dialog requireDialog() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    public DialogFragment(int r100) {
        super(r100);
        this.mDismissRunnable = new AnonymousClass1(this);
        this.mOnCancelListener = new AnonymousClass2(this);
        this.mOnDismissListener = new AnonymousClass3(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new AnonymousClass4(this);
        this.mDialogCreated = false;
    }

    public static View INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static /* synthetic */ Dialog access$000(DialogFragment r100) {
        return r100.mDialog;
    }

    public static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment r100) {
        return r100.mOnDismissListener;
    }

    public static /* synthetic */ boolean access$200(DialogFragment r100) {
        return r100.mShowsDialog;
    }

    public static void androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onStart(DialogFragment r100) {
        if ((r100 instanceof DialogFragment) == false) goto L5;
        PopupOrDialogVisibilityTracker.bindDialogFragment(r100);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(r100);
    L5:
        r100.androidx_fragment_app_DialogFragment__onStart$___twin___();
    }

    private void prepareDialog(Bundle r100) {
        if (this.mShowsDialog == true) goto L6;
        return;
    L6:
        if (this.mDialogCreated == false) goto L20;
        return;
    L20:
        this.mCreatingDialog = true;     // Catch: Throwable -> L16
        Dialog r101 = onCreateDialog(r100);     // Catch: Throwable -> L16
        this.mDialog = r101;     // Catch: Throwable -> L16
        if (this.mShowsDialog == false) goto L14;
        setupDialog(r101, this.mStyle);     // Catch: Throwable -> L16
        Context r102 = getContext();     // Catch: Throwable -> L16
        if ((r102 instanceof Activity) == false) goto L13;
        this.mDialog.setOwnerActivity((Activity) r102);     // Catch: Throwable -> L16
    L13:
        this.mDialog.setCancelable(this.mCancelable);     // Catch: Throwable -> L16
        this.mDialog.setOnCancelListener(this.mOnCancelListener);     // Catch: Throwable -> L16
        this.mDialog.setOnDismissListener(this.mOnDismissListener);     // Catch: Throwable -> L16
        this.mDialogCreated = true;     // Catch: Throwable -> L16
    L15:
        this.mCreatingDialog = false;
        return;
    L14:
        this.mDialog = null;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mCreatingDialog = false;
        throw th;
    }

    public void androidx_fragment_app_DialogFragment__onDismiss$___twin___(DialogInterface r100) {
        if (this.mViewDestroyed == false) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L7;
        toString();
    L7:
        dismissInternal(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        super.onAttach(r100);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mHandler = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r101 = true;
    L6:
        this.mShowsDialog = r101;
        if (r100 == null) goto L10;
        this.mStyle = r100.getInt("android:style", 0);
        this.mTheme = r100.getInt("android:theme", 0);
        this.mCancelable = r100.getBoolean("android:cancelable", true);
        this.mShowsDialog = r100.getBoolean("android:showsDialog", this.mShowsDialog);
        this.mBackStackId = r100.getInt("android:backStackId", -1);
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public Dialog onCreateDialog(Bundle r100) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        toString();
    L6:
        return new Dialog(requireContext(), getTheme());
    }

    View onFindViewById(int r100) {
        Dialog r101 = this.mDialog;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.findViewById(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle r100) {
        LayoutInflater r101 = super.onGetLayoutInflater(r100);
        if (this.mShowsDialog == false) goto L15;
        if (this.mCreatingDialog == true) goto L15;
        prepareDialog(r100);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L10;
        toString();
    L10:
        Dialog r102 = this.mDialog;
        if (r102 != null) goto L13;
        return r101;
    L13:
        return r101.cloneInContext(r102.getContext());
    L15:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        new StringBuilder("getting layout inflater for DialogFragment ").append(this);
        if (this.mShowsDialog == false) goto L20;
    L20:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        Dialog r101 = this.mDialog;
        if (r101 == null) goto L5;
        Bundle r102 = r101.onSaveInstanceState();
        r102.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
        r100.putBundle("android:savedDialogState", r102);
    L5:
        int r103 = this.mStyle;
        if (r103 == 0) goto L8;
        r100.putInt("android:style", r103);
    L8:
        int r104 = this.mTheme;
        if (r104 == 0) goto L11;
        r100.putInt("android:theme", r104);
    L11:
        boolean r105 = this.mCancelable;
        if (r105 == true) goto L14;
        r100.putBoolean("android:cancelable", r105);
    L14:
        boolean r106 = this.mShowsDialog;
        if (r106 == true) goto L17;
        r100.putBoolean("android:showsDialog", r106);
    L17:
        int r107 = this.mBackStackId;
        if (r107 == (-1)) goto L21;
        r100.putInt("android:backStackId", r107);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r100) {
        super.onViewStateRestored(r100);
        if (this.mDialog == null) goto L9;
        if (r100 == null) goto L10;
        Bundle r101 = r100.getBundle("android:savedDialogState");
        if (r101 == null) goto L11;
        this.mDialog.onRestoreInstanceState(r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setCancelable(boolean r100) {
        this.mCancelable = r100;
        Dialog r101 = this.mDialog;
        if (r101 == null) goto L6;
        r101.setCancelable(r100);
        return;
    }

    public void setShowsDialog(boolean r100) {
        this.mShowsDialog = r100;
    }

    public static void androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(DialogFragment r100, DialogInterface r101) {
        r100.androidx_fragment_app_DialogFragment__onDismiss$___twin___(r101);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r100.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r100);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r100);
        return;
    L5:
        th = move-exception;
        if ((r100 instanceof DialogFragment) == false) goto L9;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r100.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r100);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r100);
    L9:
        throw th;
    }

    private void dismissInternal(boolean r100, boolean r101) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog r102 = this.mDialog;
        if (r102 == null) goto L13;
        r102.setOnDismissListener(null);
        INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.mDialog);
        if (r101 == true) goto L13;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L12;
        onDismiss(this.mDialog);
        goto L13
    L12:
        this.mHandler.post(this.mDismissRunnable);
    L13:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L16;
        getParentFragmentManager().popBackStack(this.mBackStackId, 1, r100);
        this.mBackStackId = -1;
        return;
    L16:
        FragmentTransaction r103 = getParentFragmentManager().beginTransaction();
        r103.setReorderingAllowed(true);
        r103.remove(this);
        if (r100 == false) goto L19;
        r103.commitAllowingStateLoss();
        return;
    L19:
        r103.commit();
    }

    public void setStyle(int r100, int r101) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        toString();
    L5:
        this.mStyle = r100;
        if (r100 != 2) goto L8;
    L9:
        this.mTheme = R.style.Theme.Panel;
    L10:
        if (r101 == 0) goto L13;
        this.mTheme = r101;
        return;
    L13:
        return;
    L8:
        if (r100 != 3) goto L10;
        goto L9
    }

    public void setupDialog(Dialog r100, int r101) {
        if (r101 != 1) goto L5;
    L12:
        r100.requestWindowFeature(1);
        return;
    L5:
        if (r101 == 2) goto L12;
        if (r101 != 3) goto L14;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L12;
        r102.addFlags(24);
        goto L12
    }

    public void show(FragmentManager r100, String r101) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r102 = r100.beginTransaction();
        r102.setReorderingAllowed(true);
        INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r102, this, r101);
        r102.commit();
    }

    public void showNow(FragmentManager r100, String r101) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r102 = r100.beginTransaction();
        r102.setReorderingAllowed(true);
        INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r102, this, r101);
        r102.commitNow();
    }

    public int show(FragmentTransaction r100, String r101) {
        this.mDismissed = false;
        this.mShownByMe = true;
        INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100, this, r101);
        this.mViewDestroyed = false;
        int r102 = r100.commit();
        this.mBackStackId = r102;
        return r102;
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_DialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        super.performCreateView(r100, r101, r102);
        if (this.mView == null) goto L5;
        return;
    L5:
        if (this.mDialog == null) goto L12;
        if (r102 == null) goto L13;
        Bundle r103 = r102.getBundle("android:savedDialogState");
        if (r103 == null) goto L14;
        this.mDialog.onRestoreInstanceState(r103);
        return;
    L14:
        return;
    L13:
        return;
    }
}
