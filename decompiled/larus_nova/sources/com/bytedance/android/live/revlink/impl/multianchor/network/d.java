package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface d {
    void b(List<? extends IBaseUser> r100);

    void e(String r100);

    void f(long r100, List<? extends p> r101, List<? extends p> r102, List<? extends IBaseUser> r103, String r104, Map<String, Long> r105);

    void h(long r100, List<? extends p> r101, List<? extends p> r102, List<? extends IBaseUser> r103, String r104);

    void onInitPageFailed(int r100);
}
