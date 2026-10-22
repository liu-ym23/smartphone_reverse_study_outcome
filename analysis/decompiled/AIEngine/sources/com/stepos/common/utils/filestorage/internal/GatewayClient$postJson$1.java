package com.stepos.common.utils.filestorage.internal;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.GatewayClient", f = "GatewayClient.kt", l = {ErrorCodes.API_VERSION_CODE_TOO_HIGH, ErrorCodes.API_VERSION_CODE_TOO_HIGH}, m = "postJson")
/* loaded from: classes.dex */
final class GatewayClient$postJson$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6670a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6671b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f6672c;

    /* renamed from: d, reason: collision with root package name */
    public int f6673d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayClient$postJson$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6672c = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6671b = obj;
        this.f6673d |= Integer.MIN_VALUE;
        return this.f6672c.e(null, null, this);
    }
}
