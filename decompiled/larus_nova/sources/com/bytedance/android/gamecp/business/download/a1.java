package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import com.bytedance.android.gamecp.business.GameCPService;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a1 implements com.bytedance.android.gamecp.base.core.service.depend.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.e f52450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f52451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f52452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f52453d;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.e
    public final void onContinue() {
        this.f52450a.onContinue();
        this.f52451b.put("only_wifi", false);
        Lazy r100 = GameResDownloader.f52430a;
        Context r101 = this.f52452c;
        JSONObject r102 = this.f52453d;
        ((h1) GameResDownloader.f52430a.getValue()).a(r101, r102);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.e
    public final void onWaitWifi() {
        this.f52450a.onWaitWifi();
        this.f52451b.put("only_wifi", true);
        Lazy r100 = GameResDownloader.f52430a;
        Context r101 = this.f52452c;
        JSONObject r102 = this.f52453d;
        ((h1) GameResDownloader.f52430a.getValue()).a(r101, r102);
        int r103 = ns.a.f520280a;
        String r104 = this.f52451b.toString();
        ns.a.a();
        com.bytedance.gamecenter.base.q.l().getClass();
        my5.c.a("pre_fail_start", r104, 4);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.e
    public final void onError(Integer r100, String r101) {
        this.f52450a.onError(r100, r101);
    }

    public a1(GameCPService.c r100, JSONObject r101, Context r102, JSONObject r103) {
        this.f52450a = r100;
        this.f52451b = r101;
        this.f52452c = r102;
        this.f52453d = r103;
    }
}
