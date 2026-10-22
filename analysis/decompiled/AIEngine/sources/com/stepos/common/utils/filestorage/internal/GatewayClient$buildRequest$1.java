package com.stepos.common.utils.filestorage.internal;

import ad.l;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.h;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.GatewayClient", f = "GatewayClient.kt", l = {63, 81}, m = "buildRequest")
/* loaded from: classes.dex */
final class GatewayClient$buildRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6654a;

    /* renamed from: b, reason: collision with root package name */
    public String f6655b;

    /* renamed from: c, reason: collision with root package name */
    public String f6656c;

    /* renamed from: d, reason: collision with root package name */
    public h.a f6657d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f6658e;
    public final /* synthetic */ b h;

    /* renamed from: j, reason: collision with root package name */
    public int f6659j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayClient$buildRequest$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6658e = obj;
        this.f6659j |= Integer.MIN_VALUE;
        l lVar = b.f6763f;
        return this.h.b(null, null, null, null, this);
    }
}
