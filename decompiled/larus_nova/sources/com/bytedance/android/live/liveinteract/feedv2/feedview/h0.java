package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class h0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f73162a;

    public h0(g0 r100) {
        this.f73162a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        IKtvRoomFeedView r102 = this.f73162a.f73159c;
        if (r102 == null) goto L6;
        r102.onOnlineListChanged(com.bytedance.android.live.liveinteract.spatial.b.b(r101));
        return;
    }
}
