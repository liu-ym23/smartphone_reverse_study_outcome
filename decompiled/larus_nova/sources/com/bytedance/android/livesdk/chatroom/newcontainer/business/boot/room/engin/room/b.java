package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.room.state.LiveRoomNewState;
import com.bytedance.android.livesdk.room.state.WidgetLevel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import io.reactivex.functions.Consumer;
import ts2.h;
import ts2.m;

/* JADX INFO: loaded from: classes7.dex */
public interface b extends ILiveRoomPlayFragment, pg2.b, tw2.b, IAbility {
    void By(boolean r100);

    void Di();

    void Dq(com.bytedance.android.livesdk.room.g r100);

    <T> void L7(Class<T> r100, Consumer<T> r101);

    boolean NP();

    AbsRoomEngine S70();

    void Sg();

    RoomSession Uq();

    void V30();

    void Vn(LiveRoomNewState r100);

    void Vq();

    void WX();

    void Xs();

    void Z30(WidgetLevel r100, boolean r101);

    void g50(boolean r100);

    String getUniqueId();

    boolean isVisible();

    Boolean l4();

    void n30();

    void nw();

    void pu(h r100);

    void q5();

    void wv(String r100);

    <T> void xV(Class<T> r100, Consumer<T> r101);

    void z80(m r100);
}
