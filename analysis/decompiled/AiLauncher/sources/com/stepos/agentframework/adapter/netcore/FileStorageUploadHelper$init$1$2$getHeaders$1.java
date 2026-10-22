package com.stepos.agentframework.adapter.netcore;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$init$1$2", f = "FileStorageUploadHelper.kt", l = {78}, m = "getHeaders", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileStorageUploadHelper$init$1$2$getHeaders$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileStorageUploadHelper$init$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageUploadHelper$init$1$2$getHeaders$1(FileStorageUploadHelper$init$1$2 fileStorageUploadHelper$init$1$2, InterfaceC4014c<? super FileStorageUploadHelper$init$1$2$getHeaders$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = fileStorageUploadHelper$init$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
