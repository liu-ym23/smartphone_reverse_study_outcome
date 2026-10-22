package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.livesdk.chatroom.model.f3;
import com.bytedance.android.livesdk.chatroom.viewmodel.LinkRequestMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.live.datacontext.DataContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public interface u {
    com.bytedance.live.datacontext.m<Boolean> A();

    void B();

    com.bytedance.live.datacontext.n<Pair<Integer, String>> C();

    com.bytedance.live.datacontext.j<LinkMicRoomDataSyncModel> D();

    void E(String r100);

    com.bytedance.live.datacontext.n<List<Integer>> F();

    com.bytedance.live.datacontext.m<Boolean> G();

    com.bytedance.live.datacontext.j<LinkRequestMonitor> H();

    com.bytedance.live.datacontext.n<Integer> I();

    com.bytedance.live.datacontext.m<Boolean> I1();

    com.bytedance.live.datacontext.j<LivePlayModeLogContext> J();

    com.bytedance.live.datacontext.m<String> K();

    com.bytedance.live.datacontext.k<Unit> L();

    com.bytedance.live.datacontext.n<ArrayList<Integer>> a();

    com.bytedance.live.datacontext.n<DataContext> b();

    com.bytedance.live.datacontext.m<Integer> c();

    com.bytedance.live.datacontext.n<Object> getLinkmicReturnRoomParams();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> getVideoTalkRoomSubScene();

    String i();

    com.bytedance.live.datacontext.m<Boolean> j();

    com.bytedance.live.datacontext.m<Boolean> k();

    com.bytedance.live.datacontext.n<List<com.bytedance.android.livesdk.chatroom.model.k1>> l();

    com.bytedance.live.datacontext.m<Boolean> m();

    com.bytedance.live.datacontext.m<Boolean> n();

    com.bytedance.live.datacontext.m<Boolean> o();

    com.bytedance.live.datacontext.m<String> p();

    com.bytedance.live.datacontext.m<nd> q();

    com.bytedance.live.datacontext.n<List<Long>> r();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> s();

    com.bytedance.live.datacontext.n<List<com.bytedance.android.livesdk.chatroom.model.k1>> t();

    com.bytedance.live.datacontext.m<Integer> u();

    com.bytedance.live.datacontext.n<List<Integer>> v();

    String w();

    com.bytedance.live.datacontext.n<Object> x();

    com.bytedance.live.datacontext.m<Boolean> y();

    com.bytedance.live.datacontext.m<Boolean> y1();

    com.bytedance.live.datacontext.n<List<f3>> z();
}
