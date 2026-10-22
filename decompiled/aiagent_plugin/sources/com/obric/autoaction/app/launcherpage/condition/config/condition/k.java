package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.autoaction.app.launcherpage.condition.config.ConditionConfigureDialogFragment;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.h.b.z;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: ReceiveSmsCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: compiled from: ReceiveSmsCondition.kt */
    static final class a implements d.h.a.m<OPopoverEntranceMenuView.a, d.h.a.a<? extends x>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f23061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f23062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.a f23064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ n<String> f23065e;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.config.condition.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ReceiveSmsCondition.kt */
        static final class C0498a implements d.h.a.m<View, Integer, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z.a f23066a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.a<x> f23067b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ n<String> f23068c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map<String, String> f23069d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f23070e;

            C0498a(z.a r3, d.h.a.a<x> r4, n<? super String> r5, Map<String, String> r6, String r7) {
                d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                n<String> r9 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
                Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
                this.f23066a = r3;
                this.f23067b = r8;
                this.f23068c = r9;
                this.f23069d = r10;
                this.f23070e = r7;
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(View r3, Integer r4) {
                a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
                return x.f38692a;
            }

            public final void a(View r2, int r3) {
                o.e(r2, "<unused var>");
                if (this.f23066a.f38499a == true) goto L6;
                this.f23066a.f38499a = true;
                this.f23067b.invoke();
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23068c, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r5 = d.n.f38560a;
                r4.resumeWith(d.n.f(this.f23069d.get(this.f23070e)));
                return;
            }
        }

        a(List<String> r3, Map<String, String> r4, String r5, z.a r6, n<? super String> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            n<String> r10 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.aiagent.plugin");
            this.f23061a = r8;
            this.f23062b = r9;
            this.f23063c = r5;
            this.f23064d = r6;
            this.f23065e = r10;
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(OPopoverEntranceMenuView.a r3, d.h.a.a<? extends x> r4) {
            a((OPopoverEntranceMenuView.a) ZeusTransformUtils.preCheckCast(r3, OPopoverEntranceMenuView.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(OPopoverEntranceMenuView.a r25, d.h.a.a<x> r26) {
            d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r25, "$this$showPopup");
            o.e(r1, "dismissPopup");
            r25.b();
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.f23061a, Iterable.class, "com.obric.aiagent.plugin");
            Map<String, String> r14 = this.f23062b;
            String r13 = this.f23063c;
            z.a r12 = this.f23064d;
            n<String> r0 = this.f23065e;
            Iterator r16 = r3.iterator();
        L4:
            if (r16.hasNext() == false) goto L6;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
            CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
            boolean r21 = o.a(r14.get(r8), r13);
            d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0498a(r12, r1, r0, r14, r8), d.h.a.m.class, "com.obric.aiagent.plugin");
            OPopoverEntranceMenuView.a.a(r25, null, null, null, r17, null, false, false, r21, r4, IdlErrors.E_RejectInferDeviceOverheat, null);
            r14 = r14;
            r12 = r12;
            r13 = r13;
            goto L4
        }
    }

    /* JADX INFO: compiled from: ReceiveSmsCondition.kt */
    static final class b implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.a f23071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<String> f23072b;

        b(z.a r3, n<? super String> r4) {
            n<String> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            this.f23071a = r3;
            this.f23072b = r5;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r2) {
            if (this.f23071a.f38499a == true) goto L6;
            this.f23071a.f38499a = true;
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23072b, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r1.resumeWith(d.n.f(null));
            return;
        }
    }

    public static final /* synthetic */ Object a(Context r2, String r3, View r4, d.c.d r5) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private static final Object b(Context r16, String r17, View r18, d.c.d<? super String> r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r3 = new kotlinx.coroutines.o(d.c.a.b.a(r2), 1);
        r3.e();
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Activity.class) == false) goto L5;
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
    L20:
        d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r6 = d.n.f38560a;
        r5.resumeWith(d.n.f(null));
    L21:
        Object r7 = r3.h();
        if (r7 != d.c.a.b.a()) goto L24;
        d.c.b.a.h.c(r2);
    L24:
        return r7;
    L8:
        if (r1.isFinishing() == true) goto L20;
        if (r1.isDestroyed() == true) goto L20;
        List<String> r8 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.a();
        if (r8.isEmpty() == false) goto L15;
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r9.resumeWith(d.n.f(null));
        goto L21
    L15:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.api.b.a.f22885a.a().entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r11, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.m r15 = s.a(r14.getValue(), r14.getKey());
        r12.put(r15.a(), r15.b());
        goto L17
    L19:
        z.a r110 = new z.a();
        com.obric.autoaction.app.launcherpage.module.a.h.a(com.obric.autoaction.app.launcherpage.module.a.h.f24077a, r1, ConditionConfigureDialogFragment.Companion.a(r1), r18, 17, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r8, r12, r17, r110, r4), d.h.a.m.class, "com.obric.aiagent.plugin"), 16, null);
        r4.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r110, r4), d.h.a.b.class, "com.obric.aiagent.plugin"));
        goto L21
    L5:
        r1 = null;
        goto L6
    }
}
