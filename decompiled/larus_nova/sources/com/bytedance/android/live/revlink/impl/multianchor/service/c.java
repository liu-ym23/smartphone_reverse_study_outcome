package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes47.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void b(c r100, boolean r101, IBattleConfigSetting r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.S6(r101, r102, null);
        }

        public static /* synthetic */ void a(c r100, int r101, int r102, String r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r104 & 2) == 0) goto L8;
            r102 = -1;
        L8:
            r100.Wm(r101, r102);
        }
    }

    void Bp();

    void Da();

    void Hb();

    void Md(JsonObject r100);

    void Ob();

    void S6(boolean r100, IBattleConfigSetting r101, p21.e r102);

    void U5(IBattleConfigSetting r100, p21.e r101);

    void Ul(int r100);

    void Wm(int r100, int r101);

    void eb(IBattleConfigSetting r100, com.bytedance.android.live.revlink.impl.pk.utils.l r101);

    void r6();

    void t8();
}
