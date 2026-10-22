package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import android.content.Context;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f54819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f54820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.f f54821c;

    public a(Context r100, q r101, com.bytedance.android.gamecp.base.core.service.depend.f r102) {
        this.f54819a = r100;
        this.f54820b = r101;
        this.f54821c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.base.network.response.c r101 = (com.bytedance.android.gamecp.base.network.response.c) r100;
        yr.b.b(3, "GameOrder-AudienceOrder", "自动下载请求成功");
        com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().E();
        com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().orderGame(this.f54819a, this.f54820b.a());
        com.bytedance.android.gamecp.base.core.service.depend.f r102 = this.f54821c;
        if (r102 == null) goto L6;
        r102.onSuccess();
        return;
    }
}
