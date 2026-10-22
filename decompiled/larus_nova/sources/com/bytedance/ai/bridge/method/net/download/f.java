package com.bytedance.ai.bridge.method.net.download;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f35734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f35735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f35736c;

    public /* synthetic */ f(Ref.LongRef r100, a.b r101, long r102) {
        this.f35734a = r100;
        this.f35735b = r101;
        this.f35736c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Ref.LongRef r101 = this.f35734a;
        a.b r102 = this.f35735b;
        long r103 = this.f35736c;
        long r104 = ((Long) r100).longValue();
        r101.element = r104;
        r102.d(new a.d.e(r104, r103));
        return Unit.INSTANCE;
    }
}
