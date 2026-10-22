package com.bytedance.android.gamecp.business.download.ai;

import com.bytedance.android.gamecp.host_api.model.Room;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f52514a;

    public s(q r100) {
        this.f52514a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Room r102 = this.f52514a.c();
        if (r102 != null) goto L5;
    L7:
        q r103 = this.f52514a;
        if (r103.f52501c == true) goto L10;
        yr.b.b(6, "AiDownloadPreviewPredictor", "延迟期间，轮询算法包功能被关闭，不再触发智能讲解");
        return;
    L10:
        q.b(r103);
        return;
    L5:
        if (r102.isGameCPRoom() == true) goto L7;
        yr.b.b(6, "AiDownloadPreviewPredictor", "非联运直播间，跳过");
    }
}
