package com.bytedance.android.live.platformplayer.effect;

import android.os.Build;
import com.bytedance.android.livesdkapi.roomplayer.PlayerEffectLogLevel;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectCallback;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectMessageListener;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ VideoEffectInitConfigBuilder a(b r100, String r110, boolean r111, String r112, String r113, PlayerEffectLogLevel r114, VideoEffectMessageListener r115, VideoEffectCallback r116, VrEffectDownloader.d r117, int r118) {
            if ((r118 & 1) == 0) goto L5;
            String r101 = "live";
        L7:
            if ((r118 & 2) == 0) goto L9;
            boolean r102 = true;
        L11:
            if ((r118 & 4) == 0) goto L13;
            String r103 = Build.MODEL;
        L15:
            if ((r118 & 8) == 0) goto L17;
            String r104 = "live_player_sdk";
        L19:
            if ((r118 & 16) == 0) goto L21;
            PlayerEffectLogLevel r105 = PlayerEffectLogLevel.LevelDebug;
        L22:
            VrEffectDownloader.d r106 = null;
            if ((r118 & 32) == 0) goto L25;
            VideoEffectMessageListener r107 = null;
        L27:
            if ((r118 & 64) == 0) goto L29;
            VideoEffectCallback r108 = null;
        L31:
            if ((r118 & 128) != 0) goto L35;
            r106 = r117;
        L35:
            return r100.a(r101, r102, r103, r104, r105, r107, r108, r106);
        L29:
            r108 = r116;
            goto L31
        L25:
            r107 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L22
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    VideoEffectInitConfigBuilder a(String r100, boolean r101, String r102, String r103, PlayerEffectLogLevel r104, VideoEffectMessageListener r105, VideoEffectCallback r106, VideoEffectResourceFinder r107);

    void prepare();

    void release();
}
