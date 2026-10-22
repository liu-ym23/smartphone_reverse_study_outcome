package com.obric.autoaction.app.launcherpage.condition.location;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.BottomImmersionOSheet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.toast.OToast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.z;
import d.x;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentActivity f23131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f23132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConditionEventLocationView f23133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.f f23134e;
    private boolean f;
    private final androidx.lifecycle.m g;

    /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
        static final class C0499a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OSheet f23135a;

            C0499a(OSheet r1) {
                this.f23135a = r1;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r1) {
                a r2 = c.f23130a;
                OSheet r0 = this.f23135a;
                d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L5
                r0.dismiss();     // Catch: Throwable -> L5
                d.n.f(x.f38692a);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                d.n.a r4 = d.n.f38560a;
                d.n.f(d.o.a(th));
            }
        }

        /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
        static final class b implements d.h.a.b<ConditionLocationItemData, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.n<ConditionLocationItemData> f23136a;

            b(kotlinx.coroutines.n<? super ConditionLocationItemData> r3) {
                this.f23136a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(ConditionLocationItemData r3) {
                a((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r3, ConditionLocationItemData.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(ConditionLocationItemData r3) {
                if (this.f23136a.a() == false) goto L6;
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23136a, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r0 = d.n.f38560a;
                r2.resumeWith(d.n.f(r3));
                return;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final Object a(ComponentActivity r6, String r7, com.obric.autoaction.app.launcherpage.condition.config.condition.g r8, d.c.d<? super ConditionLocationItemData> r9) {
            ComponentActivity r5 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r6, ComponentActivity.class, "com.obric.aiagent.plugin");
            com.obric.autoaction.app.launcherpage.condition.config.condition.g r10 = (com.obric.autoaction.app.launcherpage.condition.config.condition.g) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autoaction.app.launcherpage.condition.config.condition.g.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(d.c.a.b.a(r11), 1);
            r12.e();
            kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            r1.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0499a(new c(r5).a((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin"), r7, r10, (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r1), d.h.a.b.class, "com.obric.aiagent.plugin"))), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Object r13 = r12.h();
            if (r13 != d.c.a.b.a()) goto L5;
            d.c.b.a.h.c(r11);
        L5:
            return r13;
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
    @d.c.b.a.f(b = "ConditionEventLocationComponent.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationComponent$init$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f23138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f23139c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.c$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
        @d.c.b.a.f(b = "ConditionEventLocationComponent.kt", c = {186}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationComponent$init$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23140a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f23141b;

            AnonymousClass1(c r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23141b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23141b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f23140a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                d.o.a(r6);
            L12:
                throw new d.d();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                ak<List<ConditionLocationItemData>> r7 = c.a(this.f23141b).b();
                final c r3 = this.f23141b;
                kotlinx.coroutines.b.i<? super List<ConditionLocationItemData>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new C05001(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23140a = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.c$b$2, reason: invalid class name */
        /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
        @d.c.b.a.f(b = "ConditionEventLocationComponent.kt", c = {192}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationComponent$init$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23143a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f23144b;

            AnonymousClass2(c r3, d.c.d<? super AnonymousClass2> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23144b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f23144b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f23143a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                d.o.a(r6);
            L12:
                throw new d.d();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                ak<Map<Integer, Integer>> r7 = c.a(this.f23144b).c();
                final c r3 = this.f23144b;
                kotlinx.coroutines.b.i<? super Map<Integer, Integer>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23143a = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23138b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f23138b, r5);
            r0.f23139c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f23137a != 0) goto L7;
            d.o.a(r10);
            am r11 = (am) ZeusTransformUtils.preCheckCast(this.f23139c, am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.i.a(r11, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23138b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            kotlinx.coroutines.i.a(r11, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f23138b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
    public static final class C0501c implements com.obric.oui.dialog.a.c {
        @Override // com.obric.oui.dialog.a.c
        public void b(Dialog r1) {
            d.h.b.o.e(r1, "dialog");
        }

        C0501c() {
        }

        @Override // com.obric.oui.dialog.a.c
        public void a(Dialog r2) {
            d.h.b.o.e(r2, "dialog");
            if (Build.VERSION.SDK_INT < 29) goto L8;
            Window r1 = r2.getWindow();
            if (r1 == null) goto L9;
            r1.setNavigationBarContrastEnforced(true);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
    @d.c.b.a.f(b = "ConditionEventLocationComponent.kt", c = {157, 163}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationComponent$showLocationView$5$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f23147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionLocationItemData f23148c;

        d(c r3, ConditionLocationItemData r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23147b = r3;
            this.f23148c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23147b, this.f23148c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23146a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r12);
        L19:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L22;
            OToast.a r5 = OToast.f36774a;
            Context r6 = (Context) ZeusTransformUtils.preCheckCast((ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.c(this.f23147b), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            String r7 = ((ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.c(this.f23147b), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_event_update_fail_retry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_update_fail_retry"));
            d.h.b.o.c(r7, "getString(...)");
            OToast.a.a(r5, r6, r7, 0, 4, null);
        L22:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r12);
        L13:
            ConditionLocationItemData r13 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r12, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L22;
            com.obric.autoaction.app.launcherpage.condition.location.d r2 = c.a(this.f23147b);
            ConditionLocationItemData r3 = this.f23148c;
            d.c.d<? super Boolean> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23146a = 2;
            r12 = r2.a(r3, r13, r8);
            if (r12 != r0) goto L19;
            return r0;
        L10:
            d.o.a(r12);
            com.obric.autoaction.app.launcherpage.condition.location.e.a r14 = com.obric.autoaction.app.launcherpage.condition.location.e.f23172a;
            ComponentActivity r4 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.c(this.f23147b), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            ConditionLocationItemData r9 = this.f23148c;
            d.c.d<? super ConditionLocationItemData> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23146a = 1;
            r12 = r14.a(r4, r9, r10);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.b<Editable, x> {
        e(Object r8) {
            super(1, r8, c.class, "afterTextChanged", "afterTextChanged(Landroid/text/Editable;)V", 0);
        }

        public final void a(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            c.a((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Editable r3) {
            a((Editable) ZeusTransformUtils.preCheckCast(r3, Editable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationComponent.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.b<ConditionLocationItemData, x> {
        f(Object r8) {
            super(1, r8, c.class, "onSelectLocationItem", "onSelectLocationItem(Lcom/obric/autoaction/app/launcherpage/condition/location/ConditionLocationItemData;)V", 0);
        }

        public final void a(ConditionLocationItemData r3) {
            c.a((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(ConditionLocationItemData r3) {
            a((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r3, ConditionLocationItemData.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class g extends d.h.b.p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23149a;

        public g(ComponentActivity r3) {
            this.f23149a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f23149a.getDefaultViewModelProviderFactory();
            d.h.b.o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class h extends d.h.b.p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23150a;

        public h(ComponentActivity r3) {
            this.f23150a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f23150a.getViewModelStore();
            d.h.b.o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class i extends d.h.b.p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23152b;

        public i(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f23151a = r5;
            this.f23152b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f23151a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f23152b.getDefaultViewModelCreationExtras();
            d.h.b.o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    static {
        f23130a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$A5rw4SEUTV-XDGnAf22CkgXPFlw, reason: not valid java name */
    public static /* synthetic */ void m460lambda$A5rw4SEUTVXDGnAf22CkgXPFlw(c r0, p r1, androidx.lifecycle.i.a r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$FfnRJJRt7D3x1qbS2X35Dx8gd2g(ca r0, p r1, c r2, z.a r3, d.h.a.b r4, DialogInterface r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$TI9EXTD4Ip0ypz_L3Sairen9afA(BottomImmersionOSheet r0, View r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$foENVSOb37BdX94xy91SztVChy8(p r0, c r1, ConditionLocationItemData r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$um3WW5gLETTsInT4DAE5K7LGi3s(ConditionEventLocationView r0, BottomImmersionOSheet r1, z.a r2, d.h.a.b r3, View r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public c(ComponentActivity r8) {
        ComponentActivity r9 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r8, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "activity");
        this.f23131b = r9;
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r9), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.f23134e = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.autoaction.app.launcherpage.condition.location.d.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r9), d.h.a.a.class, "com.obric.aiagent.plugin"), r0, (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(null, r9), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
        this.g = new $$Lambda$c$A5rw4SEUTVXDGnAf22CkgXPFlw(this);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.condition.location.d a(c r0) {
        return r0.a();
    }

    public static final /* synthetic */ void a(c r2, Editable r3) {
        r2.a((Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0, ConditionLocationItemData r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ ConditionEventLocationView b(c r0) {
        return r0.f23133d;
    }

    public static final /* synthetic */ ComponentActivity c(c r0) {
        return r0.f23131b;
    }

    private final com.obric.autoaction.app.launcherpage.condition.location.d a() {
        return (com.obric.autoaction.app.launcherpage.condition.location.d) ZeusTransformUtils.preCheckCast(this.f23134e.b(), com.obric.autoaction.app.launcherpage.condition.location.d.class, "com.obric.aiagent.plugin");
    }

    private static final void a(c r8, p r9, androidx.lifecycle.i.a r10) {
        d.h.b.o.e((p) ZeusTransformUtils.wrapperContextForParams(r9, p.class, "com.obric.aiagent.plugin"), "<unused var>");
        d.h.b.o.e(r10, "event");
        if (r10 == androidx.lifecycle.i.a.ON_RESUME) goto L5;
        return;
    L5:
        boolean r11 = true;
        if (r8.f == true) goto L9;
        r8.f = true;
        return;
    L9:
        r8.a().e();
        ConditionEventLocationView r12 = r8.f23133d;
        if (r12 == null) goto L12;
        CharSequence r13 = r12.getSearchText();
    L13:
        if (r13 != null) goto L15;
    L18:
        if (r11 == false) goto L21;
        com.obric.autoaction.app.launcherpage.condition.location.d.a(r8.a(), (Context) ZeusTransformUtils.preCheckCast(r8.f23131b, Context.class, "com.obric.aiagent.plugin"), true, false, 4, null);
        return;
    L21:
        return;
    L15:
        if (r13.length() == 0) goto L18;
        r11 = false;
        goto L18
    L12:
        r13 = null;
        goto L13
    }

    public final OSheet a(p r20, String r21, com.obric.autoaction.app.launcherpage.condition.config.condition.g r22, d.h.a.b<? super ConditionLocationItemData, x> r23) {
        final p r8 = (p) ZeusTransformUtils.wrapperContextForParams(r20, p.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.condition.config.condition.g r1 = (com.obric.autoaction.app.launcherpage.condition.config.condition.g) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.autoaction.app.launcherpage.condition.config.condition.g.class, "com.obric.aiagent.plugin");
        final d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "lifecycleOwner");
        d.h.b.o.e(r21, "type");
        d.h.b.o.e(r1, "locationCondition");
        d.h.b.o.e(r9, "onResult");
        ComponentActivity r2 = this.f23131b;
        if (d.h.b.o.a(r21, "from") == false) goto L5;
        int r3 = R.string.condition_event_detail_from_location;
        String r5 = "condition_event_detail_from_location";
    L6:
        String r13 = r2.getString(ZeusTransformUtils.mapRes(r3, WsChannelMultiProcessSharedProvider.STRING_TYPE, r5));
        d.h.b.o.c(r13, "getString(...)");
        final ConditionEventLocationView r6 = new ConditionEventLocationView((Context) ZeusTransformUtils.preCheckCast(this.f23131b, Context.class, "com.obric.aiagent.plugin"), null, r13, null, ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close"), false, 42, null);
        r6.configAdapter(r21, r1);
        r6.setAfterTextChangedListener((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r6.setSelectLocationItemCallback((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.f23133d = r6;
        this.f23132c = r8;
        final ca r4 = a(r8);
        final z.a r10 = new z.a();
        final BottomImmersionOSheet r11 = new BottomImmersionOSheet((Context) ZeusTransformUtils.preCheckCast(this.f23131b, Context.class, "com.obric.aiagent.plugin"));
        r11.setHeaderView(null);
        r11.setBodyView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        r11.setHeightMode(OSheet.c.f36215a);
        r11.setOnDismissListener(new $$Lambda$c$FfnRJJRt7D3x1qbS2X35Dx8gd2g(r4, r8, this, r10, r9));
        r11.show();
        r11.enableIgnoreInsetBottom(false);
        r11.setOnShowAnimListener((com.obric.oui.dialog.a.c) ZeusTransformUtils.preCheckCast(new C0501c(), com.obric.oui.dialog.a.c.class, "com.obric.aiagent.plugin"));
        r6.applyBottomNavInsetPadding();
        r6.setOnConfirmButtonListener(new $$Lambda$c$um3WW5gLETTsInT4DAE5K7LGi3s(r6, r11, r10, r9));
        r6.setOnBackClickListener(new $$Lambda$c$TI9EXTD4Ip0ypz_L3Sairen9afA(r11));
        r6.setOnUnsetItemClickListener(new $$Lambda$c$foENVSOb37BdX94xy91SztVChy8(r8, this));
        return (OSheet) ZeusTransformUtils.preCheckCast(r11, OSheet.class, "com.obric.aiagent.plugin");
    L5:
        r3 = R.string.condition_event_detail_to_location;
        r5 = "condition_event_detail_to_location";
        goto L6
    }

    private static final void a(z.a r2, d.h.a.b<? super ConditionLocationItemData, x> r3, ConditionLocationItemData r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r2.f38499a == false) goto L5;
        return;
    L5:
        r2.f38499a = true;
        r5.invoke(r4);
    }

    private static final void a(ca r2, p r3, c r4, z.a r5, d.h.a.b r6, DialogInterface r7) {
        ca r8 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        DialogInterface r11 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r7, DialogInterface.class, "com.obric.aiagent.plugin");
        a(r5, r10, null);
        ca.a.a(r8, null, 1, null);
        r9.getLifecycle().b((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(r4.g, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        r4.f23133d = null;
    }

    private static final x a(ConditionEventLocationView r2, BottomImmersionOSheet r3, z.a r4, d.h.a.b r5, View r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "it");
        a(r4, r7, r2.getSelectLocationItemData());
        r3.dismiss();
        return x.f38692a;
    }

    private static final x a(BottomImmersionOSheet r1, View r2) {
        d.h.b.o.e(r2, "it");
        r1.dismiss();
        return x.f38692a;
    }

    private static final x a(p r8, c r9, ConditionLocationItemData r10) {
        p r11 = (p) ZeusTransformUtils.wrapperContextForParams(r8, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "item");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a(r11), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return x.f38692a;
    }

    public final ca a(p r9) {
        p r10 = (p) ZeusTransformUtils.wrapperContextForParams(r9, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "lifecycleOwner");
        a().a((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), true, true);
        a().a((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"));
        r10.getLifecycle().a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this.g, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        return kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a(r10), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(ConditionLocationItemData r1) {
        ConditionEventLocationView r0 = this.f23133d;
        if (r0 == null) goto L11;
        View r2 = r0.getConfirmButton();
        if (r2 == null) goto L12;
        if (r1 == null) goto L8;
        boolean r3 = true;
    L9:
        r2.setEnabled(r3);
        return;
    L8:
        r3 = false;
        goto L9
    L12:
        return;
    }

    private final void a(Editable r9) {
        Editable r10 = (Editable) ZeusTransformUtils.wrapperContextForParams(r9, Editable.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        com.obric.autoaction.app.launcherpage.condition.location.d.a(a(), (Context) ZeusTransformUtils.preCheckCast(this.f23131b, Context.class, "com.obric.aiagent.plugin"), true, false, 4, null);
        return;
    L11:
        a().a((Context) ZeusTransformUtils.preCheckCast(this.f23131b, Context.class, "com.obric.aiagent.plugin"), r10.toString());
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
