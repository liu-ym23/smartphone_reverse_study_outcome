package com.bytedance.android.annie.monitor.common.performance;

import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f39609b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f39610a;

    static {
        f39609b = new a();
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f39610a.a(r100);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void b(String r100, String r101, String r102) {
        this.f39610a.b(r100, r101, r102);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void c(String r100, String r101, AnnieCard r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "view");
        this.f39610a.c(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void d(String r100, String r101, String r102) {
        this.f39610a.d(r100, r101, r102);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void e() {
        this.f39610a.e();
    }

    public a() {
        if (AnnieConfigSettingKeys.PERFORMANCE_CONFIG.a().b() == false) goto L5;
        c r100 = Perf.f39593a;
    L6:
        this.f39610a = r100;
        return;
    L5:
        r100 = b.f39611a;
        goto L6
    }
}
