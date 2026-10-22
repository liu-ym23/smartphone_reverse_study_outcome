package com.bytedance.android.live.recharge;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class RechargeDialogFactoryImpl {

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k.a f89562a;

        @Override // com.bytedance.android.live.recharge.j
        public final void a() {
            k.a r100 = this.f89562a;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        public a(k.a r100) {
            this.f89562a = r100;
        }

        @Override // com.bytedance.android.live.recharge.j
        public final void b(int r100, int r101, long r102) {
            k.a r103 = this.f89562a;
            if (r103 == null) goto L6;
            r103.b(r100, r101, r102);
            return;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k.a f89563a;

        public b(k.a r100) {
            this.f89563a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            k.a r101 = this.f89563a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    static {
    }

    public static DialogFragment a(Context r100, com.bytedance.android.live.recharge.model.d r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L7;
        RxUtilKt.r(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(r100, RechargeDialogFactoryImpl$provide$1.INSTANCE), "RechargeDialogFactoryImpl");
        return null;
    L7:
        if (com.bytedance.android.live.core.utils.v.b() == false) goto L18;
        String r103 = r101.f90013b;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        f2.g();
        goto L18
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
    L18:
        if (com.bytedance.android.live.recharge.model.g.a(com.bytedance.android.live.recharge.model.g.f90033a) == false) goto L23;
        com.bytedance.android.live.recharge.core.d r105 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r105, "$this$dynamicRechargePanelProvider");
        zy0.d r106 = ((com.bytedance.android.live.recharge.panel.dynamic.d) r105.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.panel.dynamic.d.class))).d(r100, r101, new a(r102));
        if (r106 != null) goto L22;
        return null;
    L22:
        return r106.p1();
    L23:
        com.bytedance.android.live.recharge.trace.session.a r107 = new com.bytedance.android.live.recharge.trace.session.a();
        r107.f90396d.put(ShareConstants.KEY_PANEL_TYPE, "native");
        int r108 = RechargeDialogFragmentV2.f89564n;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        Intrinsics.checkNotNullParameter(r107, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        RechargeDialogFragmentV2 r109 = new RechargeDialogFragmentV2();
        r109.f89565d = r100;
        r109.f89567f = r102;
        r109.f89568g = r101;
        r109.f89569h = r107;
        r109.setOnDismissListener(new b(r102));
        r107.c(com.bytedance.android.live.recharge.trace.session.d.f90402a);
        FragmentActivity r110 = (FragmentActivity) r100;
        if (r110.getSupportFragmentManager().findFragmentByTag("RechargeDialogFragment") != null) goto L31;
        FragmentManager r111 = r110.getSupportFragmentManager();
        LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r109, "RechargeDialogFragment", r112);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r111, r109, r112) == false) goto L33;
    L30:
        return r109;
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L29:
        r109.show(r111, "RechargeDialogFragment");
        goto L30
    L31:
        return null;
    }
}
