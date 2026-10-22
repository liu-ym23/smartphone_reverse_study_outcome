package com.bytedance.android.livesdk.chatroom.progressbar;

import com.bytedance.android.livesdk.chatroom.progressbar.widget.PlayerProgressBarWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;

/* JADX INFO: loaded from: classes7.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.progressbar.a$a, reason: collision with other inner class name */
    public interface InterfaceC1638a {
        boolean a();

        IQuality b();

        long c();
    }

    void a(long r100, long r101, boolean r102);

    void b(PlayerProgressBarWidget.PlayerProgressListener r100);

    void clear();

    void start();
}
