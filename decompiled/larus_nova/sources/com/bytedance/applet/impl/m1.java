package com.bytedance.applet.impl;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class m1 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f191970a;

    public /* synthetic */ m1(DouyinGeneralAuthHelper.a r100) {
        this.f191970a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Function2 r102 = this.f191970a;
        Boolean r103 = Boolean.valueOf(((Boolean) r100).booleanValue());
        r102.invoke(r103, (String) r101);
        return Unit.INSTANCE;
    }
}
