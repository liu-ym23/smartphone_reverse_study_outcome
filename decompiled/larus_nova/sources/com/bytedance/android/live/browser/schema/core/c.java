package com.bytedance.android.live.browser.schema.core;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements com.bytedance.android.live.browser.schema.core.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f64200d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f64201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f64202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.browser.schema.core.b f64203c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f64204a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.c$a$a, reason: collision with other inner class name */
        public static final class C1056a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f64205b;

            @Override // com.bytedance.android.live.browser.schema.core.c.a
            public final boolean a() {
                if (SystemClock.uptimeMillis() <= this.f64205b) goto L5;
                return true;
            L5:
                return false;
            }

            public C1056a(long r100, long r101, TimeUnit r102) {
                Intrinsics.checkNotNullParameter(r102, "timeUnit");
                this.f64205b = r100 + r102.toMillis(r101);
            }
        }

        public static final class b {
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.c$a$c, reason: collision with other inner class name */
        public static final class C1057c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C1057c f64206b = null;

            @Override // com.bytedance.android.live.browser.schema.core.c.a
            public final boolean a() {
                return true;
            }

            static {
                f64206b = new C1057c();
            }

            public C1057c() {
            }
        }

        static {
        }

        public a() {
        }

        public abstract boolean a();
    }

    public static final class b {
        public static c b(d r100, com.bytedance.android.live.browser.schema.core.strategy.d r101) {
            Intrinsics.checkNotNullParameter(r100, "ruleSpec");
            Intrinsics.checkNotNullParameter(r101, "strategyRegister");
            int r102 = a.f64204a;
            return new c(r100, new a.C1056a(SystemClock.uptimeMillis(), r100.a(), TimeUnit.SECONDS), new com.bytedance.android.live.browser.schema.core.a(new RedirectRuleCreator(r100, r101)));
        }

        public static c a(d r100, com.bytedance.android.live.browser.schema.core.strategy.d r101, long r102, TimeUnit r110) {
            Intrinsics.checkNotNullParameter(r100, "ruleSpec");
            Intrinsics.checkNotNullParameter(r101, "strategyRegister");
            Intrinsics.checkNotNullParameter(r110, "timeUnit");
            int r103 = a.f64204a;
            return new c(r100, new a.C1056a(SystemClock.uptimeMillis(), r102, r110), new com.bytedance.android.live.browser.schema.core.a(new RedirectRuleCreator(r100, r101)));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.schema.core.b
    public final RedirectRule get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f64203c.get(r100);
    }

    public c(d r100, a r101, com.bytedance.android.live.browser.schema.core.b r102) {
        this.f64201a = r100;
        this.f64202b = r101;
        this.f64203c = r102;
    }
}
