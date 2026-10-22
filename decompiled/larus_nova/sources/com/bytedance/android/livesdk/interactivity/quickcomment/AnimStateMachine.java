package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class AnimStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f140526a;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.AnimStateMachine$a$a, reason: collision with other inner class name */
        public static final class C2225a extends a {
            public C2225a() {
            }
        }

        public static final class b extends a {
            public b() {
            }
        }

        public static final class c extends a {
            public c() {
            }
        }

        public static final class d extends a {
            public d() {
            }
        }

        public static final class e extends a {
            public e() {
            }
        }

        public static final class f extends a {
            public f() {
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f140527a = null;

            static {
                f140527a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.AnimStateMachine$b$b, reason: collision with other inner class name */
        public static final class C2226b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2226b f140528a = null;

            static {
                f140528a = new C2226b();
            }

            public C2226b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f140529a = null;

            static {
                f140529a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f140530a = null;

            static {
                f140530a = new d();
            }

            public d() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f140531a = null;

            static {
                f140531a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f140532a = null;

            static {
                f140532a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.AnimStateMachine$c$c, reason: collision with other inner class name */
        public static final class C2227c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2227c f140533a = null;

            static {
                f140533a = new C2227c();
            }

            public C2227c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f140534a = null;

            static {
                f140534a = new d();
            }

            public d() {
            }
        }

        public c() {
        }
    }

    public AnimStateMachine(final com.bytedance.android.livesdk.interactivity.quickcomment.a r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r102 = new AnimStateMachine$stateMachine$1(r100);
        r101.getClass();
        this.f140526a = StateMachine.a.a(r102);
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<c, a, b> r101 = this.f140526a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
