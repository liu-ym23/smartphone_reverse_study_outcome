package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.android.live.revenuelink.multimsg.api.c;
import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class TaskState<INPUT, OUTPUT, T extends com.bytedance.android.live.revenuelink.multimsg.api.c<INPUT, OUTPUT>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f91861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MainThreadTaskStateListener f91862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f91863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<c, a, b> f91864d;

    public static final class MainThreadTaskStateListener<INPUT, OUTPUT, T extends com.bytedance.android.live.revenuelink.multimsg.api.c<INPUT, OUTPUT>> implements d<OUTPUT, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<OUTPUT, T> f91865a;

        public MainThreadTaskStateListener(g.a r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            this.f91865a = r100;
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void b(final T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            com.bytedance.live.kmp.util.d.b(0, false, new TaskState$MainThreadTaskStateListener$onTaskInit$1(this, r100), 7);
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void c(final T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            com.bytedance.live.kmp.util.d.b(0, false, new TaskState$MainThreadTaskStateListener$onTaskStart$1(this, r100), 7);
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void a(final T r100, final e<? extends OUTPUT, ? extends Exception> r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, "result");
            com.bytedance.live.kmp.util.d.b(0, false, new TaskState$MainThreadTaskStateListener$onTaskFinished$1(this, r100, r101), 7);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.api.TaskState$a$a, reason: collision with other inner class name */
        public static final class C1427a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e<?, Exception> f91866a;

            /* JADX WARN: Multi-variable type inference failed */
            public C1427a(e<?, ? extends Exception> r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f91866a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f91867a;

            public b(Object r100) {
                this.f91867a = r100;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f91868a = null;

            static {
                f91868a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.api.TaskState$b$b, reason: collision with other inner class name */
        public static final class C1428b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1428b f91869a = null;

            static {
                f91869a = new C1428b();
            }

            public C1428b() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {
            static {
                new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f91870a = null;

            static {
                f91870a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.api.TaskState$c$c, reason: collision with other inner class name */
        public static final class C1429c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1429c f91871a = null;

            static {
                f91871a = new C1429c();
            }

            public C1429c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f91872a = null;

            static {
                f91872a = new d();
            }

            public d() {
            }
        }

        public c() {
        }
    }

    public TaskState() {
        StateMachine.a r100 = StateMachine.f255141c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r101 = new TaskState$stateMachine$1(this);
        r100.getClass();
        this.f91864d = StateMachine.a.a(r101);
    }
}
