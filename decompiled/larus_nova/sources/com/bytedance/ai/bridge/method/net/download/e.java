package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.retrofit2.Call;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f35732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Call f35733b;

    public /* synthetic */ e(a.b r100, Call r101) {
        this.f35732a = r100;
        this.f35733b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final a.b r100 = this.f35732a;
        final Call r101 = this.f35733b;
        return Boolean.valueOf(((Boolean) r100.f35657l.a(new i(r100, r101))).booleanValue());
    }
}
