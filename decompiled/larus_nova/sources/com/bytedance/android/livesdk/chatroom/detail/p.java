package com.bytedance.android.livesdk.chatroom.detail;

import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public interface p {

    public interface a {
        void a(int r100, String r101, String r102, String r103);

        void b(Object r100);

        void c(EnterRoomInfoResult r100);

        void d(Room r100);
    }

    void a(boolean r100);

    void b();

    void c(long r100);

    boolean d();

    EnterRoomExtra e();

    void f();

    void finishRoomAbnormal();

    boolean g();

    Object getResult();

    long getRoomId();

    void h();

    void i(long r100, Function1<Object, Unit> r101);

    void j();

    void stop();
}
