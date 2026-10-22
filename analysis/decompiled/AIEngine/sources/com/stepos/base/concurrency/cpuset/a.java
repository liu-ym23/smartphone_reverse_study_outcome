package com.stepos.base.concurrency.cpuset;

import com.stepos.base.concurrency.data.PoolType;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends kotlin.coroutines.a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0043a f6212b = new C0043a();

    /* renamed from: a, reason: collision with root package name */
    public final PoolType f6213a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.base.concurrency.cpuset.a$a, reason: collision with other inner class name */
    public static final class C0043a implements d.b<a> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PoolType tier) {
        super(f6212b);
        g.f(tier, "tier");
        this.f6213a = tier;
    }

    public final String toString() {
        return "InferenceTierContext(" + this.f6213a + ")";
    }
}
