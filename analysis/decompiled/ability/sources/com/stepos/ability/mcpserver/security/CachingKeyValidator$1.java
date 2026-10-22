package com.stepos.ability.mcpserver.security;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class CachingKeyValidator$1 extends FunctionReferenceImpl implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public static final CachingKeyValidator$1 f3199a = new CachingKeyValidator$1();

    public CachingKeyValidator$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    @Override // S7.a
    public final Object invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
