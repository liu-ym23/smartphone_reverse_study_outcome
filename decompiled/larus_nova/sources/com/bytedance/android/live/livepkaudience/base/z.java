package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface z {
    void a(String r100, String r101);

    void b(String r100, String r101, boolean r102);

    void e(List r100, WaitingListUser r101);

    void f(String r100, long r101, String r102);

    void onOnlineListChanged(List<? extends LinkPlayerInfo> r100);
}
