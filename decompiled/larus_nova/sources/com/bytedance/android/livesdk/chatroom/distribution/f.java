package com.bytedance.android.livesdk.chatroom.distribution;

import android.os.Bundle;
import com.bytedance.android.livesdk.room.data.EndReason;

/* JADX INFO: loaded from: classes7.dex */
public interface f {
    void a();

    void b();

    void c();

    void d(String r100, EndReason r101);

    void e(String r100, Bundle r101);

    void pauseLive();

    void resumeLive();
}
