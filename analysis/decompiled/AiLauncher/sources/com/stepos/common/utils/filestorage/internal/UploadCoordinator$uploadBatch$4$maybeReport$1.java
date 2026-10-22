package com.stepos.common.utils.filestorage.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4", f = "UploadCoordinator.kt", l = {63}, m = "invokeSuspend$maybeReport")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadBatch$4$maybeReport$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public UploadCoordinator$uploadBatch$4$maybeReport$1(InterfaceC4014c<? super UploadCoordinator$uploadBatch$4$maybeReport$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UploadCoordinator$uploadBatch$4.i(null, 0L, null, null, null, this);
    }
}
