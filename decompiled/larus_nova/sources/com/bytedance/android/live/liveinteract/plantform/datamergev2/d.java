package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface d extends MessageHub, m {

    public static final class a {
        public static /* synthetic */ void a(d r100, String r101, int r102, String r103, boolean r110, int r111) {
            if ((r111 & 8) == 0) goto L5;
            boolean r104 = false;
        L6:
            r100.m(r101, r102, r103, r104, false);
            return;
        L5:
            r104 = r110;
            goto L6
        }
    }

    void a();

    void b(int r100);

    List<ILinkPlayerInfoBridge> c();

    List<LinkmicPositionItem> d();

    void f(com.bytedance.android.live.liveinteract.plantform.base.i.d r100);

    List<ILinkPlayerInfoBridge> getOnlineList();

    int getShowFrom();

    void j(boolean r100);

    void k(com.bytedance.android.live.liveinteract.plantform.base.i.d r100);

    void m(String r100, int r101, String r102, boolean r103, boolean r104);

    boolean n();

    ILivePlayerClient o(DataCenter r100);
}
