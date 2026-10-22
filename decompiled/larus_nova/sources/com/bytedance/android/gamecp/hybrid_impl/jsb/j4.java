package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.network.preload.PreloadManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class j4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreloadManager f57515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f57516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PreloadManager.b f57517c;

    public j4(PreloadManager r100, String r101, l4 r102) {
        this.f57515a = r100;
        this.f57516b = r101;
        this.f57517c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PreloadManager r101 = this.f57515a;
        String r102 = this.f57516b;
        yr.c.e("PreloadManager", "preload : " + r102);
        Object r103 = r101.f56705a.a(r102);
        if (r103 == null) goto L5;
        boolean r104 = r103 instanceof String;
    L6:
        if (r104 == false) goto L8;
        String r105 = (String) r101.f56705a.a(r102);
    L9:
        PreloadManager.b r106 = this.f57517c;
        if (r105 == null) goto L12;
        r106.U0(r105);
        return;
    L12:
        r106.onError(-1);
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = true;
        goto L6
    }
}
