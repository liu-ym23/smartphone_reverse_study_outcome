package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevLinkPreloadService f94664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f94665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f94666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f94667d;

    public j(RevLinkPreloadService r100, long r101, long r102, long r103) {
        this.f94664a = r100;
        this.f94665b = r101;
        this.f94666c = r102;
        this.f94667d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse<r, Extra> r101 = (ExtraResponse) r100;
        StringBuilder r102 = new StringBuilder("preload linkmic/list success channelID: ");
        r102.append(this.f94665b);
        r102.append(" roomID: ");
        r102.append(this.f94666c);
        r102.append(" logId=");
        if (r101 == null) goto L5;
        String r103 = r101.logId;
    L6:
        r102.append(r103);
        jy0.b.c("MultiLinkPreloadWidget", r102.toString(), null, 4);
        RevLinkPreloadService r104 = this.f94664a;
        i97.a r105 = i97.a.f488802a;
        r104.f94659q = System.currentTimeMillis() - this.f94667d;
        RevLinkPreloadService r106 = this.f94664a;
        r106.f94653k = false;
        r106.f94644b = r101;
        h.b r107 = r106.f94651i;
        if (r107 == null) goto L10;
        r107.b(r106.f94659q, r106.f94657o, r101, false);
        RevLinkPreloadService r108 = this.f94664a;
        r108.f94644b = null;
        r108.f94657o = 0;
        r108.f94659q = 0;
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
