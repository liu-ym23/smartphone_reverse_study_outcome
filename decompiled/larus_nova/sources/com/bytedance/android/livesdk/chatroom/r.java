package com.bytedance.android.livesdk.chatroom;

import android.app.Dialog;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.message.model.fl;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public interface r {
    com.bytedance.live.datacontext.n<Float> A();

    boolean A1();

    com.bytedance.live.datacontext.j<? extends Object> B();

    com.bytedance.live.datacontext.j<Object> C();

    com.bytedance.live.datacontext.m<Map<String, String>> C1();

    com.bytedance.live.datacontext.j<? extends Object> D();

    com.bytedance.live.datacontext.m<Boolean> D1();

    boolean E(DataCenter r100);

    void F(long r100);

    com.bytedance.live.datacontext.n<Boolean> G();

    boolean H(DataCenter r100);

    void I(fl r100);

    com.bytedance.live.datacontext.m<Boolean> J();

    com.bytedance.live.datacontext.n<Boolean> K();

    String L(DataCenter r100);

    com.bytedance.live.datacontext.n<Pair<Long, Object>> M();

    void dataMapping(String r100, String r101, Map<String, String> r102);

    com.bytedance.live.datacontext.i<Long> getEnterRoomTime();

    com.bytedance.live.datacontext.j<vlc.d> getMessageManager();

    com.bytedance.live.datacontext.j<ViewModel> i();

    boolean isInVrLandscape(DataCenter r100);

    boolean isMergeVSMediaRoom(IRoom r100);

    boolean j(String r100);

    boolean k();

    com.bytedance.live.datacontext.n<ArrayList<ph1.a>> l();

    com.bytedance.live.datacontext.n<Pair<Long, Object>> m();

    com.bytedance.live.datacontext.j<d9> n();

    void o(Dialog r100, boolean r101);

    com.bytedance.live.datacontext.n<lk> p();

    com.bytedance.live.datacontext.n<Boolean> q();

    void r(boolean r100);

    com.bytedance.live.datacontext.j<ViewModel> s();

    com.bytedance.live.datacontext.j<ViewModel> t();

    com.bytedance.live.datacontext.n<mk> u();

    com.bytedance.live.datacontext.n<Boolean> v();

    com.bytedance.live.datacontext.m<Boolean> w();

    com.bytedance.live.datacontext.m<Boolean> x();

    com.bytedance.live.datacontext.n<Pair<Long, Object>> y();

    int z();
}
