package com.bytedance.android.live.liveinteract.revenue.fight;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import java.util.List;
import xh0.g;

/* JADX INFO: loaded from: classes46.dex */
public interface c {
    void Cm(int r100);

    void F1(Object r100, SceneType r101);

    g M5(long r100, String r101, List r102);

    boolean Rh();

    com.bytedance.android.live.liveinteract.multiscene.a X2();

    boolean ck();

    void d3(String r100);

    void d6(JsonObject r100);

    JsonObject e2(JsonObject r100);

    void e5(int r100, int r101, long r102, String r103);

    String g3();

    li0.b.a g4();

    boolean isTeamFightShowing();

    void n5(DataCenter r100);

    TeamFightContext o3();

    g rl();

    boolean z3();

    boolean zh();
}
