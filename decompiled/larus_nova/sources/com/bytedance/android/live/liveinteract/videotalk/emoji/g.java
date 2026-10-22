package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79354a;

    public g(d r100) {
        this.f79354a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        d1 r102 = (d1) r101.data;
        if (r102 == null) goto L9;
        List<ILinkmicInteractEntrance> r103 = r102.getEntranceList();
        if (r103 == null) goto L9;
        d.a r104 = (d.a) this.f79354a.f531633a;
        if (r104 == null) goto L9;
        r104.j9(r103);
    L9:
        d1 r105 = (d1) r101.data;
        if (r105 == null) goto L16;
        List<j1> r106 = r105.getEntrancePosList();
        if (r106 == null) goto L16;
        d.a r107 = (d.a) this.f79354a.f531633a;
        if (r107 == null) goto L16;
        r107.A2(r106);
    L16:
        d1 r108 = (d1) r101.data;
        if (r108 == null) goto L29;
        List<ILinkmicInteractEntrance> r109 = r108.getBannerList();
        if (r109 != null) goto L21;
        return;
    L21:
        if ((!r109.isEmpty()) == true) goto L24;
        r109 = null;
    L24:
        if (r109 == null) goto L31;
        d.a r110 = (d.a) this.f79354a.f531633a;
        if (r110 == null) goto L32;
        r110.Lu(r109);
        return;
    L32:
        return;
    L31:
        return;
    }
}
