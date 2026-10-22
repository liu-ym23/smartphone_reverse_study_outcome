package com.bytedance.android.live.profit.dress.config;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/LinkmicPlayMode;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Default", "StarWish", "VIDEO_CHAT_FLOAT_WINDOW_LAYOUT", "DYNAMIC_WINDOW_LAYOUT", "C_POSITION_LAYOUT", "VIDEO_TEAM_FIGHT_LAYOUT", "LINK_ROOM_FIGHT", "RealTimeChorus", "REALTIME_CHORUS_CONCERT", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicPlayMode extends Enum<LinkmicPlayMode> {
    public static final LinkmicPlayMode C_POSITION_LAYOUT = null;
    public static final a Companion = null;
    public static final LinkmicPlayMode DYNAMIC_WINDOW_LAYOUT = null;
    public static final LinkmicPlayMode Default = null;
    public static final LinkmicPlayMode LINK_ROOM_FIGHT = null;
    public static final LinkmicPlayMode REALTIME_CHORUS_CONCERT = null;
    public static final LinkmicPlayMode RealTimeChorus = null;
    public static final LinkmicPlayMode StarWish = null;
    public static final LinkmicPlayMode VIDEO_CHAT_FLOAT_WINDOW_LAYOUT = null;
    public static final LinkmicPlayMode VIDEO_TEAM_FIGHT_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicPlayMode[] f87089a = null;
    private final int value;

    public static LinkmicPlayMode valueOf(String r100) {
        return (LinkmicPlayMode) r27.a.a(LinkmicPlayMode.class, r100);
    }

    public static LinkmicPlayMode[] values() {
        return (LinkmicPlayMode[]) f87089a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.LinkmicPlayMode$a] */
    static {
        LinkmicPlayMode r100 = new LinkmicPlayMode("Default", 0, 0);
        Default = r100;
        LinkmicPlayMode r101 = new LinkmicPlayMode("StarWish", 1, 1);
        StarWish = r101;
        LinkmicPlayMode r102 = new LinkmicPlayMode("VIDEO_CHAT_FLOAT_WINDOW_LAYOUT", 2, 2);
        VIDEO_CHAT_FLOAT_WINDOW_LAYOUT = r102;
        LinkmicPlayMode r103 = new LinkmicPlayMode("DYNAMIC_WINDOW_LAYOUT", 3, 4);
        DYNAMIC_WINDOW_LAYOUT = r103;
        LinkmicPlayMode r104 = new LinkmicPlayMode("C_POSITION_LAYOUT", 4, 13);
        C_POSITION_LAYOUT = r104;
        LinkmicPlayMode r105 = new LinkmicPlayMode("VIDEO_TEAM_FIGHT_LAYOUT", 5, 14);
        VIDEO_TEAM_FIGHT_LAYOUT = r105;
        LinkmicPlayMode r106 = new LinkmicPlayMode("LINK_ROOM_FIGHT", 6, 16);
        LINK_ROOM_FIGHT = r106;
        LinkmicPlayMode r107 = new LinkmicPlayMode("RealTimeChorus", 7, 36);
        RealTimeChorus = r107;
        LinkmicPlayMode r108 = new LinkmicPlayMode("REALTIME_CHORUS_CONCERT", 8, 39);
        REALTIME_CHORUS_CONCERT = r108;
        f87089a = new LinkmicPlayMode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicPlayMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
