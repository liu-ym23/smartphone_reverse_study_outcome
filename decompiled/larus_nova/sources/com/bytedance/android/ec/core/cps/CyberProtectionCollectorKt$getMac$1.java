package com.bytedance.android.ec.core.cps;

import com.ss.bduploader.UploadKeys;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0082@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "getMac"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt", f = "CyberProtectionCollector.kt", i = {1}, l = {432, UploadKeys.KeyIsEstimatedVideoInfo}, m = "getMac", n = {"macAddress"}, s = {"L$0"})
final class CyberProtectionCollectorKt$getMac$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public CyberProtectionCollectorKt$getMac$1(Continuation r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return b.h(this);
    }
}
