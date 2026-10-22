package com.bytedance.android.anniex.lite.flow.model;

import com.bytedance.android.anniex.lite.flow.base.d;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes43.dex */
public final class PreTaskSchemaModel extends d<pa.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f40933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f40934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1 f40935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f40936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f40937f;

    public PreTaskSchemaModel() {
        Boolean r100 = Boolean.FALSE;
        StateFlowImpl r101 = j1.a(r100);
        this.f40933b = r101;
        e.b(r101);
        StateFlowImpl r102 = j1.a(r100);
        this.f40934c = r102;
        this.f40935d = e.b(r102);
        StateFlowImpl r103 = j1.a(r100);
        this.f40936e = r103;
        this.f40937f = e.b(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(pa.a r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof PreTaskSchemaModel$initWithData$1) == false) goto L7;
        PreTaskSchemaModel$initWithData$1 r102 = (PreTaskSchemaModel$initWithData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L47:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (pa.a) r102.L$1;
        PreTaskSchemaModel r107 = (PreTaskSchemaModel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L37:
        y36.a r108 = r100.f528336c;
        if (r108 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("enableEnginePreload");
        r108 = null;
    L41:
        Boolean r109 = (Boolean) r108.f565862b;
        if (r109 == null) goto L47;
        boolean r110 = r109.booleanValue();
        StateFlowImpl r111 = r107.f40936e;
        Boolean r112 = Boxing.boxBoolean(r110);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 3;
        r111.setValue(r112);
        if (Unit.INSTANCE != r105) goto L47;
        return r105;
    L17:
        r100 = (pa.a) r102.L$1;
        r107 = (PreTaskSchemaModel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L28:
        y36.a r113 = r100.f528335b;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("enableModelPreCreate");
        r113 = null;
    L32:
        Boolean r114 = (Boolean) r113.f565862b;
        if (r114 == null) goto L37;
        boolean r115 = r114.booleanValue();
        StateFlowImpl r116 = r107.f40934c;
        Boolean r117 = Boxing.boxBoolean(r115);
        r102.L$0 = r107;
        r102.L$1 = r100;
        r102.label = 2;
        r116.setValue(r117);
        if (Unit.INSTANCE != r105) goto L37;
        return r105;
    L18:
        ResultKt.throwOnFailure(r104);
        y36.a r118 = r100.f528334a;
        if (r118 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("enablePrefetch");
        r118 = null;
    L22:
        Boolean r119 = (Boolean) r118.f565862b;
        if (r119 == null) goto L27;
        boolean r120 = r119.booleanValue();
        StateFlowImpl r121 = this.f40933b;
        Boolean r122 = Boxing.boxBoolean(r120);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        r121.setValue(r122);
        if (Unit.INSTANCE != r105) goto L27;
        return r105;
    L27:
        r107 = this;
    L7:
        r102 = new PreTaskSchemaModel$initWithData$1(this, r101);
        goto L8
    }
}
