package com.bytedance.android.livesdk.business.douplus;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f104375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f104376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f104377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f104378d;

    public /* synthetic */ a(String r100, int r101, String r102, String r103) {
        this.f104375a = r100;
        this.f104376b = r101;
        this.f104377c = r102;
        this.f104378d = r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final String r101 = this.f104375a;
        final int r102 = this.f104376b;
        final String r103 = this.f104377c;
        final String r104 = this.f104378d;
        return ((kjc.c) r100).c(new f(r101, r102, r103, r104));
    }
}
