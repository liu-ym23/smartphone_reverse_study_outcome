package com.bytedance.android.live.core.tetris.task;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y70.a;

/* JADX INFO: loaded from: classes45.dex */
public final class TaskState<T extends y70.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f65899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f65900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f65901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<d, a, c> f65902d;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$a$a, reason: collision with other inner class name */
        public static final class C1087a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1087a f65903a = null;

            static {
                f65903a = new C1087a();
            }

            public C1087a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f65904a = null;

            static {
                f65904a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f65905a = null;

            static {
                f65905a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    public static final class b<T extends y70.a> implements y70.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y70.b<T> f65906a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f65907a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y70.a f65908b;

            public a(b r100, y70.a r101) {
                this.f65907a = r100;
                this.f65908b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f65907a.f65906a.a(this.f65908b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$b$b, reason: collision with other inner class name */
        public static final class RunnableC1088b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f65909a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y70.a f65910b;

            public RunnableC1088b(b r100, y70.a r101) {
                this.f65909a = r100;
                this.f65910b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f65909a.f65906a.d(this.f65910b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f65911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y70.a f65912b;

            public c(b r100, y70.a r101) {
                this.f65911a = r100;
                this.f65912b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f65911a.f65906a.c(this.f65912b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f65913a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y70.a f65914b;

            public d(b r100, y70.a r101) {
                this.f65913a = r100;
                this.f65914b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f65913a.f65906a.b(this.f65914b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(y70.b<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            this.f65906a = r100;
        }

        @Override // y70.b
        public final void a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            MainThreadPostUtils.e(new a(this, r100));
        }

        @Override // y70.b
        public final void b(T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            MainThreadPostUtils.e(new d(this, r100));
        }

        @Override // y70.b
        public final void c(T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            MainThreadPostUtils.e(new c(this, r100));
        }

        @Override // y70.b
        public final void d(T r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            MainThreadPostUtils.e(new RunnableC1088b(this, r100));
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f65915a = null;

            static {
                f65915a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f65916a = null;

            static {
                f65916a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$c$c, reason: collision with other inner class name */
        public static final class C1089c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1089c f65917a = null;

            static {
                f65917a = new C1089c();
            }

            public C1089c() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f65918a = null;

            static {
                f65918a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f65919a = null;

            static {
                f65919a = new b();
            }

            public b() {
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f65920a = null;

            static {
                f65920a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.task.TaskState$d$d, reason: collision with other inner class name */
        public static final class C1090d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1090d f65921a = null;

            static {
                f65921a = new C1090d();
            }

            public C1090d() {
            }
        }

        public d() {
        }
    }

    public final boolean b() {
        if (Intrinsics.areEqual(this.f65902d.b(), d.C1090d.f65921a) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f65902d.b(), d.a.f65918a) == true) goto L8;
        return false;
    }

    public TaskState() {
        StateMachine.a r100 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r101 = new TaskState$stateMachine$1(this);
        r100.getClass();
        this.f65902d = StateMachine.a.a(r101);
    }

    public static final /* synthetic */ y70.a a(TaskState r100) {
        T r101 = r100.f65899a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L5:
        return r101;
    }
}
