package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface c {

    public interface a {
        void a();

        boolean isPortrait();
    }

    public interface b {
        void a(String r100, Map r101);

        void b(ll1.a r100);
    }

    void dismissAllowingStateLoss();

    void dismissInputDialog();

    void iM(ReplayDanmakuSendWidget.c r100);

    void jS();

    void show(Activity r100, String r101);

    void updateInput(String r100);
}
