package com.stepos.ailauncher.taskstore.artifact;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger", f = "TaskArtifactPartMerger.kt", l = {123, 134, 156}, m = "mergeIntoCard", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskArtifactPartMerger$mergeIntoCard$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskArtifactPartMerger this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskArtifactPartMerger$mergeIntoCard$1(TaskArtifactPartMerger taskArtifactPartMerger, InterfaceC4014c<? super TaskArtifactPartMerger$mergeIntoCard$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskArtifactPartMerger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, null, null, null, this);
    }
}
