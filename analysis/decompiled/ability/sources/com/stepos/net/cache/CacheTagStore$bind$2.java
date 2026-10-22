package com.stepos.net.cache;

import S7.k;
import j9.m;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class CacheTagStore$bind$2 extends FunctionReferenceImpl implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheTagStore$bind$2 f3881a = new CacheTagStore$bind$2();

    public CacheTagStore$bind$2() {
        super(1, m.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        String p02 = (String) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return Boolean.valueOf(p02.length() > 0);
    }
}
