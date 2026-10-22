package com.bytedance.android.gamecp.business.gamedetail.page.root;

import android.util.Log;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dt.b f55483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GameDetailPreRequestTriggerFrom f55484b;

    public d0(dt.b r100, GameDetailPreRequestTriggerFrom r101) {
        this.f55483a = r100;
        this.f55484b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = Log.getStackTraceString((Throwable) r100);
        boolean r102 = GameDetailPreRequestUtil.f55453a;
        GameDetailPreRequestUtil.f("网络预请求失败 " + r101);
        dt.b r103 = this.f55483a;
        GameDetailPreRequestTriggerFrom r104 = this.f55484b;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("game_id", r103.F);
        r105.put("scene", String.valueOf(r103.P));
        r105.put("room_id", r103.f469939J);
        r105.put("video_id", r103.R);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r105.put("fail_reason", r101);
        if (r104 != GameDetailPreRequestTriggerFrom.AI) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        String r107 = "1";
    L12:
        r105.put("is_from_ai", r107);
        GameDetailPreRequestUtil.m("dygame_tech_preload_data_failed", r105);
        return;
    L11:
        r107 = "0";
        goto L12
    L8:
        r106 = false;
        goto L9
    }
}
