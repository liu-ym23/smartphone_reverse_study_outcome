package com.bytedance.android.gamecp.business.gamedetail.page.root;

import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dt.b f55479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GameDetailPreRequestTriggerFrom f55480b;

    public c0(dt.b r100, GameDetailPreRequestTriggerFrom r101) {
        this.f55479a = r100;
        this.f55480b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        z r101 = (z) r100;
        GameDetailPreRequestUtil.f("网络预请求成功");
        dt.b r102 = this.f55479a;
        GameDetailPreRequestTriggerFrom r103 = this.f55480b;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("game_id", r102.F);
        r104.put("scene", String.valueOf(r102.P));
        r104.put("room_id", r102.f469939J);
        r104.put("video_id", r102.R);
        if (r103 != GameDetailPreRequestTriggerFrom.AI) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        String r106 = "1";
    L9:
        r104.put("is_from_ai", r106);
        GameDetailPreRequestUtil.m("dygame_tech_preload_data_success", r104);
        return;
    L8:
        r106 = "0";
        goto L9
    L5:
        r105 = false;
        goto L6
    }
}
