package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayModeEnterInfoConfig;", "", "()V", "supportPlayModes", "", "", "Lcom/bytedance/android/livesdkapi/model/PlayModeConfig;", "totalEnable", "", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayModeEnterInfoConfig {
    public static final Companion Companion = null;
    public static final int GUEST_BATTLE = 5;
    public static final int LINK_ROOM_FIGHT = 16;
    public static final int TEAM_FIGHT = 7;

    @SerializedName("support_play_modes")
    public Map<Integer, PlayModeConfig> supportPlayModes;

    @SerializedName("total_enable")
    public boolean totalEnable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayModeEnterInfoConfig$Companion;", "", "()V", "GUEST_BATTLE", "", "LINK_ROOM_FIGHT", "TEAM_FIGHT", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/PlayModeEnterInfoConfig;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final PlayModeEnterInfoConfig defaultConfig() {
            PlayModeEnterInfoConfig r100 = new PlayModeEnterInfoConfig();
            r100.totalEnable = true;
            PlayModeConfig.Companion r101 = PlayModeConfig.Companion;
            r100.supportPlayModes = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(5, r101.defaultConfig()), TuplesKt.to(16, r101.defaultConfig()), TuplesKt.to(7, r101.defaultConfig())});
            return r100;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PlayModeEnterInfoConfig() {
        this.supportPlayModes = new LinkedHashMap();
    }
}
