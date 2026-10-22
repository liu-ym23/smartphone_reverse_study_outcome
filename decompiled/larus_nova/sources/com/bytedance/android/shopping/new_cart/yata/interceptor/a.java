package com.bytedance.android.shopping.new_cart.yata.interceptor;

import aa6.b;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Pair<Long, e>> f179617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b> f179618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CartObjectContainer f179619c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.yata.interceptor.a$a, reason: collision with other inner class name */
    public static final class C2676a {
    }

    static {
    }

    public final long a() {
        Pair<Long, e> r100 = this.f179617a.get();
        if (r100 == null) goto L7;
        Long r101 = r100.getFirst();
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        dm.a.a("RollBackImpl").i("getRollBackVersion: " + r102);
        return r102;
    L7:
        r102 = Long.MIN_VALUE;
        goto L8
    }

    public a(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f179619c = r100;
        this.f179617a = new AtomicReference(new Pair(Long.MIN_VALUE, null));
        this.f179618b = new AtomicReference(null);
    }
}
