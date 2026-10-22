package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import android.content.Context;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.r5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface f {
    void a(vlc.d r100, Map<String, String> r101);

    vlc.d c(Context r100, long r101, String r102, ylc.e r103, String r104);

    void d(vlc.d r100);

    ylc.e f(long r100);

    void g();

    void h(vlc.d r100, String r101);

    q5 i();

    r5 j();

    void k();

    vlc.d n(DataCenter r100);

    vlc.d provideSeekMessageManager(Context r100, DataCenter r101, boolean r102, long r103, long r104, int r105, long r106);
}
