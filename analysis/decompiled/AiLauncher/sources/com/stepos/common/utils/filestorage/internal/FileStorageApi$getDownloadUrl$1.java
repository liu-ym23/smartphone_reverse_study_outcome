package com.stepos.common.utils.filestorage.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.FileStorageApi", f = "FileStorageApi.kt", l = {67}, m = "getDownloadUrl")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileStorageApi$getDownloadUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileStorageApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageApi$getDownloadUrl$1(FileStorageApi fileStorageApi, InterfaceC4014c<? super FileStorageApi$getDownloadUrl$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = fileStorageApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, this);
    }
}
