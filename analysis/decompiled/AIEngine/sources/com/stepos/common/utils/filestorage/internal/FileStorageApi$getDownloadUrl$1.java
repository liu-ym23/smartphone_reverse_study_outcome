package com.stepos.common.utils.filestorage.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.FileStorageApi", f = "FileStorageApi.kt", l = {42}, m = "getDownloadUrl")
/* loaded from: classes.dex */
final class FileStorageApi$getDownloadUrl$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6651a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f6652b;

    /* renamed from: c, reason: collision with root package name */
    public int f6653c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageApi$getDownloadUrl$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6652b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6651a = obj;
        this.f6653c |= Integer.MIN_VALUE;
        return this.f6652b.b(null, null, this);
    }
}
