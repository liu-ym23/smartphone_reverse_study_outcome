package com.stepos.common.utils.filestorage.internal;

import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator", f = "UploadCoordinator.kt", l = {F.LOOP_END_FRAME, 193}, m = "uploadOneWithRetry")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadOneWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadOneWithRetry$1(UploadCoordinator uploadCoordinator, InterfaceC4014c<? super UploadCoordinator$uploadOneWithRetry$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = uploadCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, null, null, null, this);
    }
}
