package com.bytedance.android.livesdk.chatroom.broadcast.startlive;

import com.bytedance.android.live.broadcast.api.scope.service.e;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends e {
    HSImageView Gb();

    boolean Rt();

    void dA(Map<String, String> r100);

    com.bytedance.android.live.pushstream.d getLiveStream();

    void restartLiveFragment();
}
