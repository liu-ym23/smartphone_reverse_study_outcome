package com.bytedance.android.live.core.tetris.componentx.schedule;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public abstract class ComponentBatchBaseLoadState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f65548a;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState$a$a, reason: collision with other inner class name */
        public static final class C1077a extends a {
            public C1077a() {
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

        public a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f65549a;

        public static final class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f65550b = null;

            static {
                f65550b = new a();
            }

            public a() {
                super("OnAllBatchEnd");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState$b$b, reason: collision with other inner class name */
        public static final class C1078b extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C1078b f65551b = null;

            static {
                f65551b = new C1078b();
            }

            public C1078b() {
                super("OnComponentInit");
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f65552b = null;

            static {
                f65552b = new c();
            }

            public c() {
                super("OnComponentLoad");
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f65553b = null;

            static {
                f65553b = new d();
            }

            public d() {
                super("OnDestory");
            }
        }

        public b(String r100) {
            this.f65549a = r100;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f65554a = null;

            static {
                f65554a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState$c$c, reason: collision with other inner class name */
        public static final class C1079c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1079c f65555a = null;

            static {
                f65555a = new C1079c();
            }

            public C1079c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f65556a = null;

            static {
                f65556a = new d();
            }

            public d() {
            }
        }

        public c() {
        }
    }

    public abstract com.bytedance.android.live.core.tetris.componentx.schedule.b b();

    public abstract void c(BatchTogetherConditionManager.BatchLoadConditionType r100);

    public abstract void d();

    public void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        ((Handler) this.f65548a.getValue()).removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
        d();     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public ComponentBatchBaseLoadState() {
        this.f65548a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ComponentBatchBaseLoadState$sHandler$2.INSTANCE);
    }
}
