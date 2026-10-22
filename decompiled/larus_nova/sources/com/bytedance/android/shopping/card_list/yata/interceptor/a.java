package com.bytedance.android.shopping.card_list.yata.interceptor;

import aa6.b;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Pair<Long, e>> f172063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b> f172064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardListObjectContainer f172065c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.yata.interceptor.a$a, reason: collision with other inner class name */
    public static final class C2578a {
    }

    static {
    }

    public final long a() {
        Pair<Long, e> r100 = this.f172063a.get();
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

    public a(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f172065c = r100;
        this.f172063a = new AtomicReference(new Pair(Long.MIN_VALUE, null));
        this.f172064b = new AtomicReference(null);
    }
}
