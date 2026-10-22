package com.bytedance.android.ec.host.impl;

import com.bytedance.bdlocation.BDLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ECLocationService$getLocationWithDialog$1 extends FunctionReferenceImpl implements Function5<Boolean, BDLocation, Integer, String, String, Unit> {
    public ECLocationService$getLocationWithDialog$1(Object r100) {
        super(5, r100, w.class, "onBridgeResult", "onBridgeResult(ZLcom/bytedance/bdlocation/BDLocation;ILjava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, BDLocation r101, Integer r102, String r110, String r111) {
        invoke(r100.booleanValue(), r101, r102.intValue(), r110, r111);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100, BDLocation r101, int r102, String r103, String r104) {
        w.i((w) this.receiver, r100, r101, r102);
    }
}
