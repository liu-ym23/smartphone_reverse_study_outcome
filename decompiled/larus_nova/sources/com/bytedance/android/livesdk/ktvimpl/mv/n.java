package com.bytedance.android.livesdk.ktvimpl.mv;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements fd2.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f146083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f146084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f146085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f146086d;

    public static final class a {
    }

    static {
    }

    public n() {
    }

    @Override // fd2.q
    public final n a() {
        this.f146085c = 1;
        return this;
    }

    public final MvServiceImpl b() {
        Long r100 = this.f146084b;
        MvServiceImpl r101 = new MvServiceImpl(this.f146083a, this.f146085c);
        r101.f146028i = r100;
        r101.f146020a = this.f146086d;
        return r101;
    }

    public final n c(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        this.f146086d = r100;
        return this;
    }
}
