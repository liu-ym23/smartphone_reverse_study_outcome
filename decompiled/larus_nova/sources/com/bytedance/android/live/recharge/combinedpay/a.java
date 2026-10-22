package com.bytedance.android.live.recharge.combinedpay;

import com.bytedance.android.live.recharge.utils.i;
import com.bytedance.android.live.revenue.common.reactive.b;
import com.bytedance.android.live.revenue.common.reactive.c;
import com.bytedance.android.live.revenue.common.reactive.f;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1374a f89668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KMutableProperty0 f89669b = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.combinedpay.a$a, reason: collision with other inner class name */
    public static final class C1374a implements b<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f89670a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.revenue.common.reactive.b, com.bytedance.android.live.revenue.common.reactive.e
        public final Object getValue() {
            return Boolean.valueOf(((Boolean) i.f90462c.getValue(null, i.f90460a[1])).booleanValue());
        }

        public C1374a() {
            this.f89670a = new c(Boolean.FALSE);
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.e
        public final Disposable a(f<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            return this.f89670a.a(r100);
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.b
        public final void setValue(Boolean r100) {
            boolean r101 = r100.booleanValue();
            i.f90462c.setValue(null, i.f90460a[1], Boolean.valueOf(r101));
            this.f89670a.setValue(Boolean.valueOf(r101));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a() {
        return ((Boolean) f89669b.get()).booleanValue();
    }

    static {
        final C1374a r100 = new C1374a();
        f89668a = r100;
        f89669b = new CombinedPaySelectionProvider$value$2(r100);
    }
}
