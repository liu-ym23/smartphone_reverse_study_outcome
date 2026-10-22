package com.bytedance.applet.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class y0 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f192023a;

    public /* synthetic */ y0(Function2 r100) {
        this.f192023a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Function2 r102 = this.f192023a;
        boolean r103 = ((Boolean) r100).booleanValue();
        int r104 = AppletV2ServiceImpl.f191836a;
        Boolean r105 = Boolean.valueOf(r103);
        r102.invoke(r105, (String) r101);
        return Unit.INSTANCE;
    }
}
