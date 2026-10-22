package com.bytedance.android.live.ktv.common.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvRoomFeedbackGuideDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseKtvDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseKtvDialogFragment f70705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f70706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f70707f;

    public static final class a implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f70708a = null;

        static {
            f70708a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public abstract String S90();

    public View getContentView() {
        return null;
    }

    public abstract int getLayoutId();

    public void V90() {
        BaseKtvDialogFragment r100 = this.f70705d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L7;
    L10:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
        r100 = null;
    L15:
        if (r100 == null) goto L19;
        r100.f70706e = true;
        r100.U90(getContext());
        this.f70705d = null;
        return;
    L19:
        return;
    L7:
        if (this.f70706e == false) goto L10;
        r101 = false;
        goto L12
    }

    public BaseKtvDialogFragment() {
        this.f70706e = true;
        setNoTitleAndCancelOutside(true);
    }

    public final void T90() {
        Dialog r100 = getDialog();
        Context r101 = getContext();
        if (r100 == null) goto L19;
        if (r101 == null) goto L22;
        Dialog r102 = getDialog();
        if (r102 == null) goto L21;
        View r103 = r102.getCurrentFocus();
        if (r103 == null) goto L23;
        Object r104 = r101.getSystemService("input_method");
        if (r104 == null) goto L18;
        InputMethodManager r105 = (InputMethodManager) r104;
        if (r105.isActive() == false) goto L20;
        r105.hideSoftInputFromWindow(r103.getWindowToken(), 0);
        return;
    L20:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L23:
        return;
    L21:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        Activity r100 = ContextUtil.contextToActivity(getContext());
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getSystemService("input_method");
    L7:
        if ((r102 instanceof InputMethodManager) == false) goto L10;
        r101 = r102;
    L10:
        InputMethodManager r103 = (InputMethodManager) r101;
        if (r103 != null) goto L13;
    L22:
        dismissAllowingStateLoss();     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L25;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L25:
        return true;
    L13:
        if (r103.isActive() != true) goto L22;
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public final void U90(Context r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
        r100 = null;
    L5:
        FragmentActivity r101 = (FragmentActivity) r100;
        if (r101 == null) goto L18;
        FragmentManager r102 = r101.getSupportFragmentManager();
        if (r102 == null) goto L19;
        String r103 = S90();
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r103, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, this, r104) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        show(r102, r103);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setLayout(-1, -1);
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.height = s1.w() - s1.A();
        r102.setAttributes(r103);
        r102.setGravity(80);
        r102.clearFlags(1024);
        r102.setAttributes(r102.getAttributes());
    L7:
        setBottomSheetSlideProcessor(a.f70708a);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        T90();
        this.f70705d = null;
        super.onCancel(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_ktv_dialog_with_status_bar);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        T90();     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        V90();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void W90(Context r100, KtvRoomFeedbackGuideDialog r101, boolean r102) {
        if (r101 == null) goto L4;
        r101.f70706e = false;
    L4:
        if (r102 == false) goto L12;
        if (r101 == null) goto L12;
        r101.dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L12;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L12:
        this.f70705d = r101;
        U90(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = getContentView();
        if (r103 != null) goto L5;
        r103 = r100.inflate(getLayoutId(), r101, false);
    L5:
        this.f70707f = r103;
        return r103;
    }
}
