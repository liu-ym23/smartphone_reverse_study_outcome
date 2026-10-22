package com.bytedance.android.anniex.container.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXDialog extends DialogFragment implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ia.f f40523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f40524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f40525f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieXDialog f40526a;

        public b(AnnieXDialog r100) {
            this.f40526a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f40526a.isAdded() == true) goto L5;
            return;
        L5:
            if (this.f40526a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
            this.f40526a.getParentFragmentManager().beginTransaction().remove(this.f40526a).commitNowAllowingStateLoss();     // Catch: Throwable -> L8
            return;
        }
    }

    public static final class c extends ia.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieXDialog f40527a;

        @Override // ia.j
        public final void a() {
            this.f40527a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // ia.j
        public final View b() {
            ia.f r100 = this.f40527a.f40523d;
            if (r100 != null) goto L7;
            return null;
        L7:
            return com.bytedance.android.anniex.container.util.e.a(r100);
        }

        @Override // ia.j
        public final View c() {
            ia.f r100 = this.f40527a.f40523d;
            if (r100 != null) goto L7;
            return null;
        L7:
            return com.bytedance.android.anniex.container.util.e.b(r100);
        }

        public c(AnnieXDialog r100) {
            this.f40527a = r100;
        }

        @Override // ia.f.a
        public final Dialog g(Bundle r100) {
            return AnnieXDialog.T90(this.f40527a, r100);
        }
    }

    static {
    }

    public AnnieXDialog() {
        this.f40525f = new c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ia.f r100 = this.f40523d;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f40523d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ia.f r100 = this.f40523d;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ia.f r100 = this.f40523d;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    public final void U90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L5;
        r101.onDismiss(r100);
    L5:
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);
        if (r103 == null) goto L12;
        w26.e r104 = (w26.e) r103.n0(w26.e.class);
        if (r104 == null) goto L12;
        Boolean r105 = r104.U0();
        if (r105 == null) goto L12;
        boolean r106 = r105.booleanValue();
    L13:
        if (r106 == false) goto L18;
        View r107 = getView();
        if (r107 == null) goto L19;
        r107.post(new b(this));
        return;
    L19:
        return;
    L18:
        return;
    L12:
        r106 = true;
        goto L13
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L6;
        r101.onActivityCreated(r100);
    L6:
        if (getShowsDialog() == false) goto L11;
        Dialog r102 = getDialog();
        if (r102 == null) goto L12;
        r102.setOnShowListener(this);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L6;
        r101.d(this.f40525f);
        r101.o(this);
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L6;
        r101.onConfigurationChanged(r100);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f40523d != null) goto L33;
        Bundle r101 = getArguments();
        ia.f r102 = null;
        if (r101 == null) goto L30;
        boolean r103 = BulletSdk.f246267a;
        BulletSdk.c(requireContext());
        boolean r104 = false;
        boolean r105 = r101.getBoolean("bundle_annie_x_flow", false);
        com.bytedance.android.anniex.base.builder.c r106 = new com.bytedance.android.anniex.base.builder.c();
        String r107 = r101.getString("bundle_annie_x_bid");
        if (r107 != null) goto L9;
        r107 = "default_bid";
    L9:
        r106.a(r107);
        r106.b(r101);
        r106.d(requireActivity());
        r106.f40266i = r105;
        r106.f40260c.putBoolean("bundle_annie_x_flow", r105);
        if (r105 == false) goto L12;
        r102 = new AnnieXFlowPopupContainer(r106);
        goto L30
    L12:
        com.bytedance.android.anniex.container.d r108 = new com.bytedance.android.anniex.container.d(r106);
        if (r100 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L29;
        Map<String, Map<Class<?>, Object>> r110 = x26.a.f562251a;
        w26.g r111 = (w26.g) x26.a.a(w26.g.class);
        if (r111 == null) goto L25;
        w26.e r112 = (w26.e) r111.n0(w26.e.class);
        if (r112 == null) goto L25;
        r104 = Intrinsics.areEqual(r112.U1(), Boolean.FALSE);
    L25:
        if ((!r104) == false) goto L29;
        String r113 = r101.getString("__x_inner_schema");
        if (r113 == null) goto L29;
        r108.loadSchema(r113, null);
    L29:
        r102 = r108;
        goto L30
    L15:
        if (r100.getBoolean("on_recreate") != true) goto L17;
        r109 = true;
    L30:
        this.f40523d = r102;
        if (r102 == null) goto L33;
        r102.d(this.f40525f);
        r102.o(this);
    L33:
        ia.f r114 = this.f40523d;
        if (r114 == null) goto L37;
        r114.onCreate(r100);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L7;
        Dialog r102 = r101.h(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return super.onCreateDialog(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        U90(r100);     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putBoolean("on_recreate", true);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L6;
        r101.onShow(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        ia.f r101 = this.f40523d;
        if (r101 == null) goto L6;
        r101.setUserVisibleHint(r100);
        return;
    }

    public static final Dialog T90(AnnieXDialog r100, Bundle r101) {
        return super.onCreateDialog(r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ia.f r102 = this.f40523d;
        if (r102 == null) goto L5;
        r102.b(r100, r101);
    L5:
        Bundle r103 = getArguments();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.getBoolean("bundle_annie_x_flow", false) == false) goto L16;
        String r104 = r103.getString("__x_inner_schema");
        if (r104 == null) goto L17;
        ia.f r105 = this.f40523d;
        if (r105 == null) goto L18;
        r105.loadSchema(r104, null);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        HybridLogger.m("AnnieXDialog", "===show()===", null, null, 12);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        if (r100.isDestroyed() == false) goto L7;
        return;
    L7:
        if (com.bytedance.ies.bullet.service.base.h.v() == true) goto L10;
        r100.beginTransaction().remove(this).commit();     // Catch: Throwable -> L22
        S90(this, r100, r101);     // Catch: Throwable -> L22
        Object r103 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L22
    L24:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L30;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXDialog", "===show error:" + r105.getMessage() + "===", null, 12);
        return;
    L30:
        return;
    L10:
        if (isAdded() == false) goto L13;
        r100.beginTransaction().remove(this).commit();     // Catch: Throwable -> L22
    L13:
        if (r100.isStateSaved() == true) goto L15;
        S90(this, r100, r101);     // Catch: Throwable -> L22
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L15:
        Field r107 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Throwable -> L22
        r107.setAccessible(true);     // Catch: Throwable -> L22
        r107.set(this, Boolean.FALSE);     // Catch: Throwable -> L22
        Field r108 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Throwable -> L22
        r108.setAccessible(true);     // Catch: Throwable -> L22
        r108.set(this, Boolean.TRUE);     // Catch: Throwable -> L22
        FragmentTransaction r109 = r100.beginTransaction();     // Catch: Throwable -> L22
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, 0) == true) goto L19;
        r109 = r109.add(this, r101);     // Catch: Throwable -> L22
    L19:
        r103 = Integer.valueOf(r109.commitAllowingStateLoss());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public static void S90(DialogFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        DialogFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        super.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        super.onCreateView(r100, r101, r102);
        View r103 = r100.inflate(R.layout.annie_x_dialog, r101, false);
        this.f40524e = r103;
        ia.f r104 = this.f40523d;
        if (r104 == null) goto L5;
        r104.a(r103);
    L5:
        Dialog r105 = getDialog();
        if (r105 == null) goto L9;
        r105.setOnKeyListener(new com.bytedance.android.anniex.container.ui.a(this));
    L9:
        return this.f40524e;
    }
}
