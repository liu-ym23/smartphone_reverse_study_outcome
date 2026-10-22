package com.obric.aiagent.skill.manager.impl.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.keva.Keva;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.impl.cx;
import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.ee;
import com.obric.aiagent.skill.manager.impl.hd;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f20507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.am f20508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.am f20509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.m<aj, at, d.x> f20510e;
    private final d.h.a.b<com.obric.aiagent.skill.manager.impl.cf, d.x> f;
    private final d.h.a.m<aj, com.obric.aiagent.skill.manager.impl.cb, d.x> g;
    private final d.h.a.q<aj, String, Throwable, d.x> h;
    private final d.h.a.b<aj, com.obric.aiagent.skill.manager.api.e> i;
    private final hd j;
    private final d.f k;
    private OAlertDialog l;
    private aj m;
    private kotlinx.coroutines.ca n;
    private aj o;
    private StatusDialog p;
    private aj q;
    private c r;
    private ea s;
    private com.obric.aiagent.skill.manager.api.e t;
    private volatile long u;

    /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
    private static abstract class b {

        /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.aiagent.skill.manager.impl.cb f20512a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f20512a, r6.f20512a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f20512a.hashCode();
            }

            public String toString() {
                return "Form(draft=" + this.f20512a + ')';
            }

            public a(com.obric.aiagent.skill.manager.impl.cb r2) {
                d.h.b.o.e(r2, "draft");
                super(null);
                this.f20512a = r2;
            }

            public final com.obric.aiagent.skill.manager.impl.cb a() {
                return this.f20512a;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.ai$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
        public static final class C0433b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.aiagent.skill.manager.impl.cf f20513a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0433b.class) == true) goto L8;
                return false;
            L8:
                C0433b r6 = (C0433b) ZeusTransformUtils.preCheckCast(r5, C0433b.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f20513a, r6.f20513a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f20513a.hashCode();
            }

            public String toString() {
                return "Package(draft=" + this.f20513a + ')';
            }

            public C0433b(com.obric.aiagent.skill.manager.impl.cf r2) {
                d.h.b.o.e(r2, "draft");
                super(null);
                this.f20513a = r2;
            }

            public final com.obric.aiagent.skill.manager.impl.cf a() {
                return this.f20513a;
            }
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.a<d.x> f20514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.a<d.x> f20515b;

        /* JADX INFO: renamed from: lambda$Wb6wrwxSH-gVv_j__SBfRS0Afx8, reason: not valid java name */
        public static /* synthetic */ d.x m327lambda$Wb6wrwxSHgVv_j__SBfRS0Afx8() {
            return c();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20514a, r6.f20514a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20515b, r6.f20515b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20514a.hashCode() * 31) + this.f20515b.hashCode();
        }

        public String toString() {
            return "PendingParsingCompletion(dispatch=" + this.f20514a + ", discard=" + this.f20515b + ')';
        }

        public c(d.h.a.a<d.x> r3, d.h.a.a<d.x> r4) {
            d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "dispatch");
            d.h.b.o.e(r6, "discard");
            this.f20514a = r5;
            this.f20515b = r6;
        }

        public final d.h.a.a<d.x> a() {
            return this.f20514a;
        }

        public /* synthetic */ c(d.h.a.a r2, d.h.a.a r3, int r4, d.h.b.h r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r7 = $$Lambda$ai$c$Wb6wrwxSHgVv_j__SBfRS0Afx8.INSTANCE;
        L5:
            this(r6, r7);
        }

        private static final d.x c() {
            return d.x.f38692a;
        }

        public final d.h.a.a<d.x> b() {
            return this.f20515b;
        }
    }

    /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20516a = null;

        static {
            int[] r0 = new int[aj.values().length];
            r0[aj.f20529b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[aj.f20530c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[aj.f20531d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f20516a = r0;
        }
    }

    /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
    @d.c.b.a.f(b = "SkillFilePickerCoordinator.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillFilePickerCoordinator$onActivityResult$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ aj f20518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ai f20519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f20520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f20521e;
        final /* synthetic */ ea f;
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e g;
        final /* synthetic */ String h;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.ai$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
        @d.c.b.a.f(b = "SkillFilePickerCoordinator.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillFilePickerCoordinator$onActivityResult$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20522a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f20523b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ai f20524c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f20525d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Object f20526e;
            final /* synthetic */ ea f;
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e g;
            final /* synthetic */ aj h;
            final /* synthetic */ String i;

            AnonymousClass1(long r3, ai r5, b r6, Object r7, ea r8, com.obric.aiagent.skill.manager.api.e r9, aj r10, String r11, d.c.d<? super AnonymousClass1> r12) {
                d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20523b = r3;
                this.f20524c = r5;
                this.f20525d = r6;
                this.f20526e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                super(2, r13);
            }

            public static /* synthetic */ d.x lambda$D62fh64GT1EAmF1Si3CYYx5Nc8o(b r0) {
                return a(r0);
            }

            public static /* synthetic */ d.x lambda$Dk45WVdto0GwQvaQ4OGKM_KR88s(ai r0, aj r1, String r2, Throwable r3) {
                return a(r0, r1, r2, r3);
            }

            public static /* synthetic */ d.x lambda$dNCEXWcU2HDn9u3HVpUd3BYIw7I(b r0, ai r1, aj r2) {
                return a(r0, r1, r2);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r13, d.c.d<?> r14) {
                d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20523b, this.f20524c, this.f20525d, this.f20526e, this.f, this.g, this.h, this.i, r11), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r3v4 */
            /* JADX WARN: Type inference failed for: r3v5, types: [d.h.a.a, d.h.b.h] */
            /* JADX WARN: Type inference failed for: r3v6 */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r24) {
                d.c.a.b.a();
                if (this.f20522a != 0) goto L29;
                d.o.a(r24);
                b.C0433b r3 = null;
                if (this.f20523b == ai.b(this.f20524c)) goto L15;
                b r0 = this.f20525d;
                if (ZeusTransformUtils.instanceOf(r0, b.C0433b.class) == false) goto L9;
                r3 = (b.C0433b) ZeusTransformUtils.preCheckCast(r0, b.C0433b.class, "com.obric.aiagent.plugin");
            L9:
                if (r3 == null) goto L14;
                com.obric.aiagent.skill.manager.impl.cf r1 = r3.a();
                if (r1 == null) goto L14;
                r1.e();
            L14:
                return d.x.f38692a;
            L15:
                ai.a(this.f20524c, null);
                ai.a(this.f20524c, null);
                Object r2 = this.f20526e;
                ea r15 = this.f;
                com.obric.aiagent.skill.manager.api.e r6 = this.g;
                final ai r14 = this.f20524c;
                final aj r13 = this.h;
                final String r4 = this.i;
                final Throwable r12 = d.n.c(r2);
                if (r12 != null) goto L21;
                final b r5 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
                ea.a(r15, dz.f19791a, r6, null, null, null, null, null, null, d.c.b.a.b.a(false), d.c.b.a.b.a(false), d.a.ao.a(d.s.a("file_target", ai.b(r14, r13))), 252, null);
                if (ai.g(r14) != r15) goto L20;
                ai.a(r14, null);
                ai.a(r14, null);
            L20:
                ai.a(r14, r13, new c(new $$Lambda$ai$e$1$dNCEXWcU2HDn9u3HVpUd3BYIw7I(r5, r14, r13), new $$Lambda$ai$e$1$D62fh64GT1EAmF1Si3CYYx5Nc8o(r5)));
            L27:
                return d.x.f38692a;
            L21:
                com.obric.aiagent.skill.manager.impl.bt r7 = com.obric.aiagent.skill.manager.impl.bv.a(r12);
                ea.a(r15, dz.f19792b, r6, null, null, null, null, eb.a(r12), "file_parse", d.c.b.a.b.a(eb.a(r7)), d.c.b.a.b.a(false), d.a.ao.a(new d.m[]{d.s.a("file_target", ai.b(r14, r13)), d.s.a("failure_reason", r7.a())}), 60, null);
                if (ai.g(r14) != r15) goto L24;
                ?? r8 = 0;
                ai.a(r14, null);
                ai.a(r14, null);
            L25:
                ai.a(r14, r13, new c(new $$Lambda$ai$e$1$Dk45WVdto0GwQvaQ4OGKM_KR88s(r14, r13, r4, r12), r8, 2, r8));
                goto L27
            L24:
                r8 = 0;
                goto L25
            L29:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            private static final d.x a(b r4, ai r5, aj r6) {
                if (ZeusTransformUtils.instanceOf(r4, b.C0433b.class) == false) goto L6;
                String r0 = ((b.C0433b) ZeusTransformUtils.preCheckCast(r4, b.C0433b.class, "com.obric.aiagent.plugin")).a().a();
            L8:
                ai.d(r5).invoke(r6, new at.d(r0));
                if (ZeusTransformUtils.instanceOf(r4, b.C0433b.class) == false) goto L12;
                ai.e(r5).invoke(((b.C0433b) ZeusTransformUtils.preCheckCast(r4, b.C0433b.class, "com.obric.aiagent.plugin")).a());
            L15:
                return d.x.f38692a;
            L12:
                if (ZeusTransformUtils.instanceOf(r4, b.a.class) == false) goto L17;
                ai.f(r5).invoke(r6, ((b.a) ZeusTransformUtils.preCheckCast(r4, b.a.class, "com.obric.aiagent.plugin")).a());
                goto L15
            L17:
                throw new d.k();
            L6:
                if (ZeusTransformUtils.instanceOf(r4, b.a.class) == false) goto L19;
                r0 = ((b.a) ZeusTransformUtils.preCheckCast(r4, b.a.class, "com.obric.aiagent.plugin")).a().a();
                goto L8
            L19:
                throw new d.k();
            }

            private static final d.x a(b r2) {
                if (ZeusTransformUtils.instanceOf(r2, b.C0433b.class) == false) goto L5;
                b.C0433b r3 = (b.C0433b) ZeusTransformUtils.preCheckCast(r2, b.C0433b.class, "com.obric.aiagent.plugin");
            L6:
                if (r3 == null) goto L11;
                com.obric.aiagent.skill.manager.impl.cf r4 = r3.a();
                if (r4 == null) goto L11;
                r4.e();
            L11:
                return d.x.f38692a;
            L5:
                r3 = null;
                goto L6
            }

            private static final d.x a(ai r3, aj r4, String r5, Throwable r6) {
                ai.d(r3).invoke(r4, new at.a(r5, com.obric.aiagent.skill.manager.impl.bv.a(r6)));
                ai.h(r3).invoke(r4, r5, r6);
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20527a = null;

            static {
                int[] r0 = new int[aj.values().length];
                r0[aj.f20529b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[aj.f20530c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[aj.f20531d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f20527a = r0;
            }
        }

        /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
        /* synthetic */ class b extends d.h.b.l implements d.h.a.a<d.x> {
            b(Object r8) {
                super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
            }

            public final void a() {
                kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SkillFilePickerCoordinator.kt */
        /* synthetic */ class c extends d.h.b.l implements d.h.a.a<d.x> {
            c(Object r8) {
                super(0, r8, kotlinx.coroutines.ce.class, "ensureActive", "ensureActive(Lkotlin/coroutines/CoroutineContext;)V", 1);
            }

            public final void a() {
                kotlinx.coroutines.ce.b((d.c.g) ZeusTransformUtils.preCheckCast(this.receiver, d.c.g.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }
        }

        e(aj r3, ai r4, Intent r5, long r6, ea r8, com.obric.aiagent.skill.manager.api.e r9, String r10, d.c.d<? super e> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20518b = r3;
            this.f20519c = r4;
            this.f20520d = r5;
            this.f20521e = r6;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            super(2, r12);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f20518b, this.f20519c, this.f20520d, this.f20521e, this.f, this.g, this.h, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            d.c.a.b.a();
            if (this.f20517a != 0) goto L44;
            d.o.a(r17);
            b.C0433b r3 = null;
            d.c.g r0 = getContext();     // Catch: Exception -> L22 CancellationException -> L41
            com.obric.aiagent.skill.manager.api.al r4 = com.obric.aiagent.skill.manager.api.al.f19195a.a();     // Catch: Exception -> L22 CancellationException -> L41
            com.obric.aiagent.skill.manager.impl.bx r9 = com.obric.aiagent.skill.manager.impl.bx.f19625a.a(r4);     // Catch: Exception -> L22 CancellationException -> L41
            ee.a(ee.f19808a, "SkillManager", "Skill file limits ready target=" + this.f20518b + ", max_source_bytes=" + r9.a() + ", max_entry_bytes=" + r9.c() + ", max_uncompressed_bytes=" + r9.d(), null, 4, null);     // Catch: Exception -> L22 CancellationException -> L41
            d.n.a r5 = d.n.f38560a;     // Catch: Exception -> L22 CancellationException -> L41
            int r6 = a.f20527a[this.f20518b.ordinal()];     // Catch: Exception -> L22 CancellationException -> L41
            if (r6 != 1) goto L8;
            b r1 = (b) ZeusTransformUtils.preCheckCast(new b.C0433b(com.obric.aiagent.skill.manager.impl.by.f19630a.a((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ai.a(this.f20519c), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f20520d, r9, (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r0), d.h.a.a.class, "com.obric.aiagent.plugin"))), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22 CancellationException -> L41
        L20:
            Object r2 = d.n.f(r1);     // Catch: Exception -> L22 CancellationException -> L41
        L24:
            Object r10 = r2;
            if (d.n.b(r10) == false) goto L27;
            Object r7 = null;
        L28:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (this.f20521e != ai.b(this.f20519c)) goto L31;
            kotlinx.coroutines.i.a(ai.c(this.f20519c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20521e, this.f20519c, r8, r10, this.f, this.g, this.f20518b, this.h, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            return d.x.f38692a;
        L31:
            if (ZeusTransformUtils.instanceOf(r8, b.C0433b.class) == false) goto L33;
            r3 = (b.C0433b) ZeusTransformUtils.preCheckCast(r8, b.C0433b.class, "com.obric.aiagent.plugin");
        L33:
            if (r3 == null) goto L38;
            com.obric.aiagent.skill.manager.impl.cf r11 = r3.a();
            if (r11 == null) goto L38;
            r11.e();
        L38:
            return d.x.f38692a;
        L27:
            r7 = r10;
            goto L28
        L8:
            if (r6 != 2) goto L10;
        L14:
            com.obric.aiagent.skill.manager.impl.by r12 = com.obric.aiagent.skill.manager.impl.by.f19630a;     // Catch: Exception -> L22 CancellationException -> L41
            Context r13 = (Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ai.a(this.f20519c), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22 CancellationException -> L41
            Intent r14 = this.f20520d;     // Catch: Exception -> L22 CancellationException -> L41
            if (this.f20518b != aj.f20530c) goto L17;
            Integer r15 = d.c.b.a.b.a(r4.j());     // Catch: Exception -> L22 CancellationException -> L41
        L18:
            r1 = (b) ZeusTransformUtils.preCheckCast(new b.a(r12.a(r13, r14, r9, r15, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r0), d.h.a.a.class, "com.obric.aiagent.plugin"))), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22 CancellationException -> L41
            goto L20
        L17:
            r15 = null;
            goto L18
        L10:
            if (r6 == 3) goto L14;
            throw new d.k();     // Catch: Exception -> L22 CancellationException -> L41
        L41:
            e = move-exception;
            throw e;
        L22:
            e = move-exception;
            d.n.a r16 = d.n.f38560a;
            r2 = d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
            goto L24
        L44:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f20506a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-XeDIcJvFez11svbc-12a07n-QI, reason: not valid java name */
    public static /* synthetic */ d.x m326lambda$XeDIcJvFez11svbc12a07nQI(d.h.a.a r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$AksoUo4vOaO5zbzemjbP1ltIxZ4(OCheckBox r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Keva lambda$TshIBOBQVc3yxuP0vYZ37p2RcmQ() {
        return e();
    }

    public static /* synthetic */ d.x lambda$dl1Wrn2qUGagtvHmM5o6kRvLuEU(ai r0, aj r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ d.x lambda$kWji89VzduQllwXhKrfcFWGsXXE(ai r0, aj r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ d.x lambda$nhYVuARnpJQiD8NcpYWIgHqgZPw(ai r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$oAeg82zBP5RFxIPLJjJSF5UqCHU(ai r0, d.h.a.b r1, OCheckBox r2, aj r3, DialogInterface r4, int r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ d.x lambda$tGYx9goArHUXJEqnR1FrazWFuks(View r0, com.obric.oui.dialog.v2.alert.style.c r1) {
        return a(r0, r1);
    }

    public ai(FragmentActivity r3, kotlinx.coroutines.am r4, kotlinx.coroutines.am r5, d.h.a.m<? super aj, ? super at, d.x> r6, d.h.a.b<? super com.obric.aiagent.skill.manager.impl.cf, d.x> r7, d.h.a.m<? super aj, ? super com.obric.aiagent.skill.manager.impl.cb, d.x> r8, d.h.a.q<? super aj, ? super String, ? super Throwable, d.x> r9, d.h.a.b<? super aj, com.obric.aiagent.skill.manager.api.e> r10, hd r11) {
        FragmentActivity r12 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r13 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r14 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.a.m<aj, at, d.x> r15 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.aiagent.skill.manager.impl.cf, d.x> r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<aj, com.obric.aiagent.skill.manager.impl.cb, d.x> r17 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.q<aj, String, Throwable, d.x> r18 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.h.a.b<aj, com.obric.aiagent.skill.manager.api.e> r19 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "activity");
        d.h.b.o.e(r13, "ioScope");
        d.h.b.o.e(r14, "mainScope");
        d.h.b.o.e(r15, "onStateChanged");
        d.h.b.o.e(r16, "onPackageReady");
        d.h.b.o.e(r17, "onFormReady");
        d.h.b.o.e(r18, "onFailure");
        d.h.b.o.e(r19, "performanceSkillProvider");
        d.h.b.o.e(r11, "trackingReporter");
        this.f20507b = r12;
        this.f20508c = r13;
        this.f20509d = r14;
        this.f20510e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r11;
        this.k = d.g.a($$Lambda$ai$TshIBOBQVc3yxuP0vYZ37p2RcmQ.INSTANCE);
    }

    public static final /* synthetic */ FragmentActivity a(ai r0) {
        return r0.f20507b;
    }

    public static final /* synthetic */ void a(ai r0, com.obric.aiagent.skill.manager.api.e r1) {
        r0.t = r1;
    }

    public static final /* synthetic */ void a(ai r0, ea r1) {
        r0.s = r1;
    }

    public static final /* synthetic */ void a(ai r0, aj r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void a(ai r0, aj r1, c r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(ai r2, kotlinx.coroutines.ca r3) {
        r2.n = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ long b(ai r2) {
        return r2.u;
    }

    public static final /* synthetic */ String b(ai r0, aj r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.am c(ai r0) {
        return r0.f20509d;
    }

    public static final /* synthetic */ d.h.a.m d(ai r0) {
        return r0.f20510e;
    }

    public static final /* synthetic */ d.h.a.b e(ai r0) {
        return r0.f;
    }

    public static final /* synthetic */ d.h.a.m f(ai r0) {
        return r0.g;
    }

    public static final /* synthetic */ ea g(ai r0) {
        return r0.s;
    }

    public static final /* synthetic */ d.h.a.q h(ai r0) {
        return r0.h;
    }

    public /* synthetic */ ai(FragmentActivity r15, kotlinx.coroutines.am r16, kotlinx.coroutines.am r17, d.h.a.m r18, d.h.a.b r19, d.h.a.m r20, d.h.a.q r21, d.h.a.b r22, hd r23, int r24, d.h.b.h r25) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r15, FragmentActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r3 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r16, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r4 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r17, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.q r8 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r24 & 128) == 0) goto L6;
        r9 = (d.h.a.b) ZeusTransformUtils.preCheckCast(AnonymousClass1.f20511a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if ((r24 & 256) == 0) goto L8;
        hd r0 = new hd(null, null, null, 7, null);
    L9:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r0);
        return;
    L8:
        r0 = r23;
        goto L9
    }

    private final Keva b() {
        return (Keva) ZeusTransformUtils.preCheckCast(this.k.b(), Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva e() {
        return cx.f19710a.a();
    }

    private static final d.x a(d.h.a.a r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "proceed");
        r3.invoke();
        return d.x.f38692a;
    }

    public static /* synthetic */ void a(ai r1, aj r2, d.h.a.b r3, int r4, Object r5) {
        d.h.a.b<? super d.h.a.a<d.x>, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = $$Lambda$ai$XeDIcJvFez11svbc12a07nQI.INSTANCE;
    L5:
        r1.a(r2, r6);
    }

    public final void a(final aj r4, d.h.a.b<? super d.h.a.a<d.x>, d.x> r5) {
        d.h.a.b<? super d.h.a.a<d.x>, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "target");
        d.h.b.o.e(r6, "launchTransition");
        boolean r0 = false;
        r0 = b().getBoolean("skip_file_safety_prompt", false);     // Catch: Exception -> L8
    L4:
        if (r0 == false) goto L6;
        r6.invoke(new $$Lambda$ai$kWji89VzduQllwXhKrfcFWGsXXE(this, r4));
        return;
    L6:
        b(r4, r6);
    }

    private static final d.x c(ai r0, aj r1) {
        r0.b(r1);
        return d.x.f38692a;
    }

    public final boolean a(int r27, int r28, Intent r29) {
        aj r1 = aj.f20528a.a(r27);
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r28 != (-1)) goto L37;
        if (r29 == null) goto L10;
        Uri r2 = r29.getData();
    L11:
        if (r2 == null) goto L37;
        if (r29 == null) goto L35;
        Uri r3 = r29.getData();
        if (r3 == null) goto L35;
        String r4 = com.obric.aiagent.skill.manager.impl.by.f19630a.a((Context) ZeusTransformUtils.preCheckCast(this.f20507b, Context.class, "com.obric.aiagent.plugin"), r3);     // Catch: Exception -> L19
    L20:
        String r8 = r4;
        String r5 = ZeusProviderTransform.getType(this.f20507b.getContentResolver(), r3, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
    L24:
        if (r5 != null) goto L26;
        r5 = "";
    L26:
        ee.f19808a.b("SkillManager", "Skill file selected target=" + r1, "Skill file selected: target=" + r1 + ", policy=" + r1.b() + ", fileName=" + r8 + ", mimeType=" + r5);
        this.u++;
        long r6 = this.u;
        aj r7 = this.o;
        ea r12 = this.s;
        if (r12 == null) goto L29;
        ea.a(r12, dz.f19793c, this.t, null, null, null, null, dw.n, "superseded", false, false, d.a.ao.a(d.s.a("file_target", c(r7))), 60, null);
    L29:
        this.s = null;
        this.t = null;
        kotlinx.coroutines.ca r9 = this.n;
        if (r9 == null) goto L32;
        kotlinx.coroutines.ca.a.a(r9, null, 1, null);
    L32:
        this.n = null;
        c();
        d();
        this.o = r1;
        ea r10 = new ea(dy.f19787b, this.j, null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.i.invoke(r1), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        this.s = r10;
        this.t = r11;
        this.f20510e.invoke(r1, new at.c(r8));
        this.n = kotlinx.coroutines.i.a(this.f20508c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r1, this, r29, r6, r10, r11, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return true;
    L23:
        r5 = null;
    L19:
        r4 = "Skill.md";
    L35:
        return true;
    L10:
        r2 = null;
    L37:
        return true;
    }

    public final void a(aj r3) {
        d.h.b.o.e(r3, "target");
        if (this.m != r3) goto L9;
        OAlertDialog r0 = this.l;
        if (r0 == null) goto L7;
        r0.dismiss();
    L7:
        this.l = null;
        this.m = null;
    L9:
        if (this.o != r3) goto L12;
        a(r3, true);
        return;
    L12:
        if (this.q != r3) goto L16;
        a(r3, true);
        return;
    }

    public final void a() {
        this.u++;
        ea r3 = this.s;
        if (r3 == null) goto L5;
        ea.a(r3, dz.f19793c, this.t, null, null, null, null, dw.n, "destroyed", false, false, d.a.ao.a(d.s.a("file_target", c(this.o))), 60, null);
    L5:
        this.s = null;
        this.t = null;
        kotlinx.coroutines.ca r2 = this.n;
        if (r2 == null) goto L8;
        kotlinx.coroutines.ca.a.a(r2, null, 1, null);
    L8:
        this.n = null;
        this.o = null;
        c();
        d();
        OAlertDialog r4 = this.l;
        if (r4 == null) goto L11;
        r4.dismiss();
    L11:
        this.l = null;
        this.m = null;
    }

    private final void a(aj r19, boolean r20) {
        if (this.o != r19) goto L5;
    L7:
        this.u++;
        ea r4 = this.s;
        if (r4 == null) goto L10;
        ea.a(r4, dz.f19793c, this.t, null, null, null, null, dw.n, "user_cancel", false, false, d.a.ao.a(d.s.a("file_target", c(r19))), 60, null);
    L10:
        this.s = null;
        this.t = null;
        kotlinx.coroutines.ca r3 = this.n;
        if (r3 == null) goto L13;
        kotlinx.coroutines.ca.a.a(r3, null, 1, null);
    L13:
        this.n = null;
        this.o = null;
        c();
        this.f20510e.invoke(r19, at.b.f20570a);
        if (this.q != r19) goto L21;
        this.q = null;
        if (r20 == false) goto L22;
        StatusDialog r0 = this.p;
        if (r0 == null) goto L23;
        r0.dismiss();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (this.q == r19) goto L7;
    }

    private final void a(aj r3, c r4) {
        StatusDialog r0 = this.p;
        if (r0 != null) goto L5;
    L11:
        r4.a().invoke();
        return;
    L5:
        if (this.q != r3) goto L11;
        if (r0.isShowing() == false) goto L11;
        c();
        this.r = r4;
        r0.dismiss();
    }

    private final void c() {
        c r0 = this.r;
        this.r = null;
        if (r0 == null) goto L8;
        d.h.a.a<d.x> r2 = r0.b();
        if (r2 == null) goto L9;
        r2.invoke();
        return;
    L9:
        return;
    }

    private final void d() {
        StatusDialog r0 = this.p;
        this.p = null;
        this.q = null;
        if (r0 == null) goto L6;
        r0.originDismiss();
        return;
    }

    private final void b(final aj r12, d.h.a.b<? super d.h.a.a<d.x>, d.x> r13) {
        final d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        OAlertDialog r0 = this.l;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.m = r12;
        final View r1 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.f20507b, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.dialog_skill_file_safety, "layout", "dialog_skill_file_safety"), null, false, "com.obric.aiagent.plugin");
        final OCheckBox r2 = (OCheckBox) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.skill_file_safety_skip_checkbox, DbHelper.COL_ID, "skill_file_safety_skip_checkbox")), OCheckBox.class, "com.obric.aiagent.plugin");
        r2.setChecked(true);
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.skill_file_safety_skip_row, DbHelper.COL_ID, "skill_file_safety_skip_row")), ViewGroup.class, "com.obric.aiagent.plugin")).setOnClickListener(new $$Lambda$ai$AksoUo4vOaO5zbzemjbP1ltIxZ4(r2));
        OAlertDialog r15 = (OAlertDialog) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this.f20507b, Context.class, "com.obric.aiagent.plugin")).a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_safety_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_safety_title")).b((CharSequence) ZeusTransformUtils.preCheckCast(this.f20507b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_file_safety_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_safety_message")), CharSequence.class, "com.obric.aiagent.plugin")).a((com.obric.oui.dialog.v2.alert.style.e) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.style.d(new $$Lambda$ai$tGYx9goArHUXJEqnR1FrazWFuks(r1)), com.obric.oui.dialog.v2.alert.style.e.class, "com.obric.aiagent.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.obric_skill_file_safety_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_safety_cancel"), new $$Lambda$ai$nhYVuARnpJQiD8NcpYWIgHqgZPw(this)).a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_safety_continue, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_safety_continue"), new $$Lambda$ai$oAeg82zBP5RFxIPLJjJSF5UqCHU(this, r14, r2, r12)).g(), OAlertDialog.class, "com.obric.aiagent.plugin");
        this.l = r15;
        r15.show();
    }

    private static final void a(OCheckBox r0, View r1) {
        r0.toggle();
    }

    private static final d.x a(View r4, com.obric.oui.dialog.v2.alert.style.c r5) {
        com.obric.oui.dialog.v2.alert.style.c r6 = (com.obric.oui.dialog.v2.alert.style.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.dialog.v2.alert.style.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "container");
        r6.getBodySlot().addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return d.x.f38692a;
    }

    private static final d.x a(ai r1, DialogInterface r2, int r3) {
        d.h.b.o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin"), "<unused var>");
        r1.l = null;
        r1.m = null;
        return d.x.f38692a;
    }

    private static final d.x a(final ai r1, d.h.a.b r2, OCheckBox r3, final aj r4, DialogInterface r5, int r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.aiagent.plugin"), "<unused var>");
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L5
        r1.b().storeBoolean("skip_file_safety_prompt", r3.isChecked());     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        r1.l = null;
        r1.m = null;
        r7.invoke(new $$Lambda$ai$dl1Wrn2qUGagtvHmM5o6kRvLuEU(r1, r4));
        return d.x.f38692a;
    L5:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L7
    }

    private static final d.x d(ai r0, aj r1) {
        r0.b(r1);
        return d.x.f38692a;
    }

    private final void b(aj r6) {
        com.obric.aiagent.skill.manager.impl.bw r0 = r6.b();
        Intent r1 = new Intent("android.intent.action.GET_CONTENT");
        r1.setType(r0.b());
        r1.addCategory("android.intent.category.OPENABLE");
        r1.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        r1.putExtra("android.intent.extra.MIME_TYPES", (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r0.a(), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.startActivityForResult(this.f20507b, r1, r6.a(), "com.obric.aiagent.plugin");     // Catch: Exception -> L5 ActivityNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        a(r6, (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.s.f19611a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        e = move-exception;
        a(r6, (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.j.f19602a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void a(aj r4, com.obric.aiagent.skill.manager.impl.bt r5, Throwable r6) {
        this.f20510e.invoke(r4, new at.a("Skill.md", r5));
        this.h.invoke(r4, "Skill.md", new com.obric.aiagent.skill.manager.impl.bu(r5, r6));
    }

    private final String c(aj r2) {
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        if (r3 != (-1)) goto L8;
        return SensitiveType.UNKNOWN;
    L8:
        if (r3 != 1) goto L10;
        return "import_package";
    L10:
        if (r3 != 2) goto L12;
        return "create_form";
    L12:
        if (r3 != 3) goto L15;
        return "edit_form";
    L15:
        throw new d.k();
    L5:
        r3 = d.f20516a[r2.ordinal()];
        goto L6
    }
}
