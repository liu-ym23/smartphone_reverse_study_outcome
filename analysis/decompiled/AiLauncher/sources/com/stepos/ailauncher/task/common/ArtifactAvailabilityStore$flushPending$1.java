package com.stepos.ailauncher.task.common;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.common.ArtifactAvailabilityStore", f = "ArtifactAvailabilityStore.kt", l = {122}, m = "flushPending", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactAvailabilityStore$flushPending$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactAvailabilityStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactAvailabilityStore$flushPending$1(ArtifactAvailabilityStore artifactAvailabilityStore, InterfaceC4014c<? super ArtifactAvailabilityStore$flushPending$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = artifactAvailabilityStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(this);
    }
}
