package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements e, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f168088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f168089b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.f168089b.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        return this.f168089b.b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.e
    public final void e() {
        this.f168088a = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final String f() {
        return this.f168089b.f();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final void g(String r110, Map<String, ? extends Object> r111, boolean r112, boolean r113, String r114, PageFinder r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        this.f168089b.g(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.e
    public final boolean i() {
        return this.f168088a;
    }

    public d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "trackDepend");
        this.f168089b = r100;
        this.f168088a = false;
    }
}
