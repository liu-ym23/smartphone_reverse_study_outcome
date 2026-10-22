package com.bytedance.ai.model;

import com.bytedance.ai.bridge.ContainerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LynxWorkerRuntime$initializeAIBridge$modelParams$1 extends FunctionReferenceImpl implements Function2<String, ContainerType, Boolean> {
    public LynxWorkerRuntime$initializeAIBridge$modelParams$1(Object r100) {
        super(2, r100, s4.d.class, "check", "check(Ljava/lang/String;Lcom/bytedance/ai/bridge/ContainerType;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r100, ContainerType r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((s4.d) this.receiver).getClass();
        return Boolean.valueOf(s4.d.a(r100, r101));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(String r100, ContainerType r101) {
        return invoke2(r100, r101);
    }
}
