package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class y implements z {
    public y() {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void e(List r100, WaitingListUser r101) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void f(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.z
    public void onOnlineListChanged(List<? extends LinkPlayerInfo> r100) {
    }
}
