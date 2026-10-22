package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.live.kmp.statemachine.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f91884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenuelink.multimsg.api.a f91885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f91886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f91887d;

    public static final class a implements d<Object, com.bytedance.android.live.revenuelink.multimsg.api.a<Object, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f91888a;

        public a(g r100) {
            this.f91888a = r100;
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void b(c r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.revenuelink.multimsg.api.a) r100, "task");
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void c(c r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.revenuelink.multimsg.api.a) r100, "task");
        }

        @Override // com.bytedance.android.live.revenuelink.multimsg.api.d
        public final void a(c r100, e<? extends Object, ? extends Exception> r101) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.revenuelink.multimsg.api.a) r100, "task");
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f91888a.f91886c.f(r101);
            this.f91888a.f91884a.f91878b.getAndSet(null);
            f.a(this.f91888a.f91884a, null);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f91889a;

        public b(g r100) {
            this.f91889a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g r100 = this.f91889a;     // Catch: Throwable -> L4
            com.bytedance.android.live.revenuelink.multimsg.api.a r101 = r100.f91885b;     // Catch: Throwable -> L4
            Object r102 = r100.f91887d;     // Catch: Throwable -> L4
            StateMachine.c(r101.f91873a.f91864d, new TaskState.a.b(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(f r100, com.bytedance.android.live.revenuelink.multimsg.f r101, h r102, Object r103) {
        this.f91884a = r100;
        this.f91885b = r101;
        this.f91886c = r102;
        this.f91887d = r103;
    }

    public final void a() {
        com.bytedance.android.live.revenuelink.multimsg.api.a r100 = this.f91885b;
        a r101 = new a(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "taskStateListener");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r102 = r100.f91873a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "taskStateListener");
        r102.f91861a = r100;
        TaskState.MainThreadTaskStateListener r103 = new TaskState.MainThreadTaskStateListener(r101);
        r102.f91862b = r103;
        r103.b(r100);
        f.a r104 = new f.a(this.f91885b, new b(this));
        f.a(this.f91884a, r104);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
