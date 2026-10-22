package com.bytedance.android.livesdk.ktvimpl.mv;

import com.ss.ttvideoengine.DataSource;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvPlayer f146061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f146062b;

    public i(KtvMvPlayer r100, u r101) {
        this.f146061a = r100;
        this.f146062b = r101;
    }

    @Override // com.ss.ttvideoengine.DataSource
    public final String apiForFetcher(Map<String, String> r100, int r101) {
        KtvMvPlayer r102 = this.f146061a;
        String r103 = this.f146062b.f146204b;
        r102.getClass();
        return String.format("https://open.bytedanceapi.com/?%s", new Object[]{r103});
    }
}
