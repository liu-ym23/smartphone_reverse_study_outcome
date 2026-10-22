package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.retrofit2.Call;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class d implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f35730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Call f35731b;

    public /* synthetic */ d(a.b r100, Call r101) {
        this.f35730a = r100;
        this.f35731b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final a.b r100 = this.f35730a;
        final Call r101 = this.f35731b;
        return Boolean.valueOf(!((Boolean) r100.f35657l.a(new j(r100, r101))).booleanValue());
    }
}
