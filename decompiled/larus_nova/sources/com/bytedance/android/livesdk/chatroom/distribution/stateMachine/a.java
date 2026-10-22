package com.bytedance.android.livesdk.chatroom.distribution.stateMachine;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.distribution.EnterParams;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    void a();

    void b();

    void c();

    void d(String r100, EndReason r101);

    void e(EnterParams r100, boolean r101);

    void f(EnterParams r100, boolean r101);

    void g(EnterParams r100, boolean r101);

    void h();

    void pauseLive();

    void resumeLive();
}
