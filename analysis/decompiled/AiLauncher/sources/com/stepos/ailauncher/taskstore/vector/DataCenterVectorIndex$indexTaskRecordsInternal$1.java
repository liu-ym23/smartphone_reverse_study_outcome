package com.stepos.ailauncher.taskstore.vector;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex", f = "DataCenterVectorIndex.kt", l = {296, 299, 302, 304, 305}, m = "indexTaskRecordsInternal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCenterVectorIndex$indexTaskRecordsInternal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataCenterVectorIndex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataCenterVectorIndex$indexTaskRecordsInternal$1(DataCenterVectorIndex dataCenterVectorIndex, InterfaceC4014c<? super DataCenterVectorIndex$indexTaskRecordsInternal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = dataCenterVectorIndex;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.B(null, false, this);
    }
}
