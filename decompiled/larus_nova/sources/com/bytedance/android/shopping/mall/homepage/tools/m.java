package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.retrofit2.Converter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements yj.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f178532b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yj.n f178533a;

    @Override // yj.n
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        return this.f178533a.a(r100);
    }

    @Override // yj.n
    public final Map<String, String> b() {
        return this.f178533a.b();
    }

    @Override // yj.n
    public final <T> T c(String r100, Class<T> r101, Converter.Factory r102) {
        return (T) this.f178533a.c(r100, r101, r102);
    }

    @Override // yj.n
    public final Map<String, String> commonParams() {
        return this.f178533a.commonParams();
    }

    @Override // yj.n
    public final void connect(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f178533a.connect(r100);
    }

    @Override // yj.n
    public final <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, ? extends Object> r103) {
        return (T) this.f178533a.create(r100, r101, r102, r103);
    }

    @Override // yj.n
    public final com.bytedance.android.chunkstreamprediction.network.h d() {
        return this.f178533a.d();
    }

    static {
        f178532b = new m();
    }

    public m() {
        this.f178533a = com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getIHybridHostNetService();
    }
}
