package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.autoaction.app.launcherpage.condition.config.ConditionConfigureDialogFragment;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.toast.OToast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
    static final class a implements d.h.a.m<OPopoverEntranceMenuView.a, d.h.a.a<? extends x>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<com.obric.autoaction.app.launcherpage.api.b.b.a> f23008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.a f23011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ n<d.m<String, String>> f23012e;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.config.condition.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
        static final class C0496a implements d.h.a.m<View, Integer, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z.a f23013a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.a<x> f23014b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ n<d.m<String, String>> f23015c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.autoaction.app.launcherpage.api.b.b.a f23016d;

            C0496a(z.a r3, d.h.a.a<x> r4, n<? super d.m<String, String>> r5, com.obric.autoaction.app.launcherpage.api.b.b.a r6) {
                d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                n<d.m<String, String>> r8 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
                this.f23013a = r3;
                this.f23014b = r7;
                this.f23015c = r8;
                this.f23016d = r6;
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(View r3, Integer r4) {
                a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
                return x.f38692a;
            }

            public final void a(View r2, int r3) {
                o.e(r2, "<unused var>");
                if (this.f23013a.f38499a == true) goto L6;
                this.f23013a.f38499a = true;
                this.f23014b.invoke();
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23015c, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r5 = d.n.f38560a;
                r4.resumeWith(d.n.f(new d.m(this.f23016d.a(), this.f23016d.b())));
                return;
            }
        }

        a(List<com.obric.autoaction.app.launcherpage.api.b.b.a> r3, String r4, String r5, z.a r6, n<? super d.m<String, String>> r7) {
            List<com.obric.autoaction.app.launcherpage.api.b.b.a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            n<d.m<String, String>> r9 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.aiagent.plugin");
            this.f23008a = r8;
            this.f23009b = r4;
            this.f23010c = r5;
            this.f23011d = r6;
            this.f23012e = r9;
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(OPopoverEntranceMenuView.a r3, d.h.a.a<? extends x> r4) {
            a((OPopoverEntranceMenuView.a) ZeusTransformUtils.preCheckCast(r3, OPopoverEntranceMenuView.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(OPopoverEntranceMenuView.a r22, d.h.a.a<x> r23) {
            d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r22, "$this$showPopup");
            o.e(r1, "dismissPopup");
            r22.b();
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.f23008a, Iterable.class, "com.obric.aiagent.plugin");
            String r14 = this.f23009b;
            String r13 = this.f23010c;
            z.a r12 = this.f23011d;
            n<d.m<String, String>> r0 = this.f23012e;
            Iterator r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L12;
            com.obric.autoaction.app.launcherpage.api.b.b.a r5 = (com.obric.autoaction.app.launcherpage.api.b.b.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.autoaction.app.launcherpage.api.b.b.a.class, "com.obric.aiagent.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin");
            if (o.a(r5.a(), r14) == true) goto L8;
        L10:
            boolean r11 = false;
        L11:
            OPopoverEntranceMenuView.a.a(r22, null, null, null, r8, null, false, false, r11, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0496a(r12, r1, r0, r5), d.h.a.m.class, "com.obric.aiagent.plugin"), IdlErrors.E_RejectInferDeviceOverheat, null);
            r13 = r13;
            r14 = r14;
            r12 = r12;
            goto L4
        L8:
            if (o.a(r5.b(), r13) == false) goto L10;
            r11 = true;
            goto L11
        }
    }

    /* JADX INFO: compiled from: ConnectBluetoothCondition.kt */
    static final class b implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.a f23017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<d.m<String, String>> f23018b;

        b(z.a r3, n<? super d.m<String, String>> r4) {
            n<d.m<String, String>> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            this.f23017a = r3;
            this.f23018b = r5;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r2) {
            if (this.f23017a.f38499a == true) goto L6;
            this.f23017a.f38499a = true;
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23018b, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r1.resumeWith(d.n.f(null));
            return;
        }
    }

    public static final /* synthetic */ Object a(Context r2, String r3, String r4, View r5, d.c.d r6) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private static final Object b(Context r25, String r26, String r27, View r28, d.c.d<? super d.m<String, String>> r29) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r8 = new kotlinx.coroutines.o(d.c.a.b.a(r0), 1);
        r8.e();
        n r15 = (n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L5;
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
    L23:
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r4 = d.n.f38560a;
        r1.resumeWith(d.n.f(null));
    L24:
        Object r5 = r8.h();
        if (r5 != d.c.a.b.a()) goto L27;
        d.c.b.a.h.c(r0);
    L27:
        return r5;
    L8:
        if (r2.isFinishing() == true) goto L23;
        if (r2.isDestroyed() == true) goto L23;
        List<com.obric.autoaction.app.launcherpage.api.b.b.a> r10 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.d(r3);
        if (r10 != null) goto L16;
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r7 = d.n.f38560a;
        r6.resumeWith(d.n.f(null));
        goto L24
    L16:
        if (r10.isEmpty() == true) goto L18;
        z.a r9 = new z.a();
        com.obric.autoaction.app.launcherpage.module.a.h.a(com.obric.autoaction.app.launcherpage.module.a.h.f24077a, r2, ConditionConfigureDialogFragment.Companion.a(r2), r28, 17, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, r26, r27, r9, r15), d.h.a.m.class, "com.obric.aiagent.plugin"), 16, null);
        r15.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r9, r15), d.h.a.b.class, "com.obric.aiagent.plugin"));
        goto L24
    L18:
        if (com.obric.autoaction.app.launcherpage.api.b.b.f22886a.e(r3) == false) goto L20;
        OToast.a r11 = OToast.f36774a;
        String r12 = r3.getString(ZeusTransformUtils.mapRes(R.string.condition_event_no_bluetooth_device, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_no_bluetooth_device"));
        o.c(r12, "getString(...)");
        OToast.a.a(r11, r3, r12, 0, 4, null);
    L21:
        d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r14 = d.n.f38560a;
        r13.resumeWith(d.n.f(null));
        goto L24
    L20:
        OToast.a r16 = OToast.f36774a;
        String r17 = r3.getString(ZeusTransformUtils.mapRes(R.string.condition_event_bluetooth_switch_not_enabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_bluetooth_switch_not_enabled"));
        o.c(r17, "getString(...)");
        OToast.a.a(r16, r3, r17, 0, 4, null);
        goto L21
    L5:
        r2 = null;
        goto L6
    }
}
