package com.bytedance.android.livesdk.chatroom.distribution.stateMachine;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.distribution.EnterParams;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<AbstractC1603c, a, b> f105838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.distribution.stateMachine.a f105839b;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f105840a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$a$a, reason: collision with other inner class name */
        public static final class C1599a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EnterParams f105841b;

            public C1599a(EnterParams r100) {
                Intrinsics.checkNotNullParameter(r100, "enterParams");
                super(true);
                this.f105841b = r100;
            }
        }

        public static final class b extends a {
            public b() {
                super(true);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$a$c, reason: collision with other inner class name */
        public static final class C1600c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EnterParams f105842b;

            public C1600c(EnterParams r100) {
                Intrinsics.checkNotNullParameter(r100, "enterParams");
                super(true);
                this.f105842b = r100;
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EnterParams f105843b;

            public d(EnterParams r100) {
                Intrinsics.checkNotNullParameter(r100, "enterParams");
                super(true);
                this.f105843b = r100;
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f105844b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final EndReason f105845c;

            public e(boolean r100, String r101, EndReason r102) {
                super(r100);
                this.f105844b = r101;
                this.f105845c = r102;
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f105846b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final EndReason f105847c;

            public f(String r100, EndReason.LIVE_DISTRIBUTION_EXIT r101) {
                super(true);
                this.f105846b = r100;
                this.f105847c = r101;
            }
        }

        public static final class g extends a {
            public g() {
                this(true);
            }

            public g(boolean r100) {
                super(r100);
            }
        }

        public static final class h extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f105848b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final EndReason f105849c;

            public h(String r100, EndReason.LIVE_DISTRIBUTION_EXIT r101) {
                super(true);
                this.f105848b = r100;
                this.f105849c = r101;
            }
        }

        public static final class i extends a {
            public i() {
                this(true);
            }

            public i(boolean r100) {
                super(r100);
            }
        }

        public a(boolean r100) {
            this.f105840a = r100;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f105850a = null;

            static {
                f105850a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$b$b, reason: collision with other inner class name */
        public static final class C1601b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1601b f105851a = null;

            static {
                f105851a = new C1601b();
            }

            public C1601b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$b$c, reason: collision with other inner class name */
        public static final class C1602c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1602c f105852a = null;

            static {
                f105852a = new C1602c();
            }

            public C1602c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f105853a = null;

            static {
                f105853a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f105854a = null;

            static {
                f105854a = new e();
            }

            public e() {
            }
        }

        public static final class f extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f105855a = null;

            static {
                f105855a = new f();
            }

            public f() {
            }
        }

        public static final class g extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f105856a = null;

            static {
                f105856a = new g();
            }

            public g() {
            }
        }

        public static final class h extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final h f105857a = null;

            static {
                f105857a = new h();
            }

            public h() {
            }
        }

        public static final class i extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final i f105858a = null;

            static {
                f105858a = new i();
            }

            public i() {
            }
        }

        public static final class j extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final j f105859a = null;

            static {
                f105859a = new j();
            }

            public j() {
            }
        }

        public static final class k extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final k f105860a = null;

            static {
                f105860a = new k();
            }

            public k() {
            }
        }

        public static final class l extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final l f105861a = null;

            static {
                f105861a = new l();
            }

            public l() {
            }
        }

        public static final class m extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final m f105862a = null;

            static {
                f105862a = new m();
            }

            public m() {
            }
        }

        public static final class n extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final n f105863a = null;

            static {
                f105863a = new n();
            }

            public n() {
            }
        }

        public static final class o extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final o f105864a = null;

            static {
                f105864a = new o();
            }

            public o() {
            }
        }

        public static final class p extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final p f105865a = null;

            static {
                f105865a = new p();
            }

            public p() {
            }
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC1603c {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$a */
        public static final class a extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f105866a = null;

            static {
                f105866a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$b */
        public static final class b extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f105867a = null;

            static {
                f105867a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$c, reason: collision with other inner class name */
        public static final class C1604c extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1604c f105868a = null;

            static {
                f105868a = new C1604c();
            }

            public C1604c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$d */
        public static final class d extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f105869a = null;

            static {
                f105869a = new d();
            }

            public d() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$e */
        public static final class e extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f105870a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EndReason f105871b;

            public e(String r100, EndReason r101) {
                this.f105870a = r100;
                this.f105871b = r101;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$f */
        public static final class f extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f105872a = null;

            static {
                f105872a = new f();
            }

            public f() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.stateMachine.c$c$g */
        public static final class g extends AbstractC1603c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f105873a = null;

            static {
                f105873a = new g();
            }

            public g() {
            }
        }

        public AbstractC1603c() {
        }
    }

    public c(com.bytedance.android.livesdk.chatroom.distribution.stateMachine.b r100) {
        Intrinsics.checkNotNullParameter(r100, "flowAction");
        this.f105839b = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        RoomStateMachine$stateMachine$1 r102 = new RoomStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f105838a = StateMachine.a.a(r102);
    }

    public final void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<AbstractC1603c, a, b> r101 = this.f105838a;     // Catch: Exception -> L5
        StateMachine.a r102 = StateMachine.f66079c;     // Catch: Exception -> L5
        r101.d(r100, null);     // Catch: Exception -> L5
        return;
    }

    public static final void b(c r100, boolean r101, Function0 r102) {
        r100.getClass();
        if (r101 == false) goto L6;
        r102.invoke();
        return;
    }

    public static final void a(c r100, boolean r101, a r102, Function1 r103) {
        r100.getClass();
        if (r101 == false) goto L8;
        if (r102 == null) goto L7;
        r103.invoke(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
