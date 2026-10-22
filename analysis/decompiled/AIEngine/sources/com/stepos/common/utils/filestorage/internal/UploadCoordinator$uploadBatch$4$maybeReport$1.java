package com.stepos.common.utils.filestorage.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4", f = "UploadCoordinator.kt", l = {63}, m = "invokeSuspend$maybeReport")
/* loaded from: classes.dex */
final class UploadCoordinator$uploadBatch$4$maybeReport$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6711a;

    /* renamed from: b, reason: collision with root package name */
    public int f6712b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6711a = obj;
        this.f6712b |= Integer.MIN_VALUE;
        return UploadCoordinator$uploadBatch$4.b(null, 0L, null, null, this);
    }
}
