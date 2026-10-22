package com.stepos.common.utils.filestorage.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4", f = "UploadCoordinator.kt", l = {92}, m = "invokeSuspend$maybeReportFile")
/* loaded from: classes.dex */
final class UploadCoordinator$uploadBatch$4$maybeReportFile$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6713a;

    /* renamed from: b, reason: collision with root package name */
    public int f6714b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6713a = obj;
        this.f6714b |= Integer.MIN_VALUE;
        return UploadCoordinator$uploadBatch$4.c(null, null, null, null, 0, this);
    }
}
