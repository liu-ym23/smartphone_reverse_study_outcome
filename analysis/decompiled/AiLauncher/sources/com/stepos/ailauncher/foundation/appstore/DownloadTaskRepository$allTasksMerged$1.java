package com.stepos.ailauncher.foundation.appstore;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository", f = "DownloadTaskRepository.kt", l = {143, 102, 153, 153}, m = "allTasksMerged", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadTaskRepository$allTasksMerged$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadTaskRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTaskRepository$allTasksMerged$1(DownloadTaskRepository downloadTaskRepository, InterfaceC4014c<? super DownloadTaskRepository$allTasksMerged$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = downloadTaskRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
