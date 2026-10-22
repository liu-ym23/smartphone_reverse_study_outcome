package com.bytedance.android.latch.prefetch.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class NativePrefetchProcess$createStateHolder$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public NativePrefetchProcess$createStateHolder$2(Object r100) {
        super(1, r100, NativePrefetchProcess.class, "handleTemplateLatchJsonVersion", "handleTemplateLatchJsonVersion(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        NativePrefetchProcess.k((NativePrefetchProcess) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
