package com.stepos.core.common.cloud;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.common.cloud.FileStorageUploader", f = "FileStorageUploader.kt", l = {62}, m = "upload-yxL6bBk")
/* loaded from: classes.dex */
public final class FileStorageUploader$upload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileStorageUploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageUploader$upload$1(FileStorageUploader fileStorageUploader, qb.b<? super FileStorageUploader$upload$1> bVar) {
        super(bVar);
        this.this$0 = fileStorageUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo101uploadyxL6bBk = this.this$0.mo101uploadyxL6bBk(null, null, null, null, this);
        return objMo101uploadyxL6bBk == CoroutineSingletons.f10059a ? objMo101uploadyxL6bBk : new Result(objMo101uploadyxL6bBk);
    }
}
