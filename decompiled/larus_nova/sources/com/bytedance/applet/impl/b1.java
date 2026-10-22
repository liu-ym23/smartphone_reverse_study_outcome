package com.bytedance.applet.impl;

import com.larus.platform.api.MusicOperateResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class b1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f191884a;

    public /* synthetic */ b1(k1 r100) {
        this.f191884a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function1 r101 = this.f191884a;
        MusicOperateResult r102 = (MusicOperateResult) r100;
        int r103 = AppletV2ServiceImpl.f191836a;
        Intrinsics.checkNotNullParameter(r102, "it");
        r101.invoke(c1.a(r102));
        return Unit.INSTANCE;
    }
}
