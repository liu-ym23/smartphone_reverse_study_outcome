package com.bytedance.android.live.room.api.panel;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/api/panel/PanelName;", "", "", "panelName", "Ljava/lang/String;", "getPanelName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UnKnown", "Profile", "LongPress", "More", "AudienceList", "RightCard", "GameCp", "Predictor", "PublicScreenOperatePanel", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelName extends Enum<PanelName> {
    public static final PanelName AudienceList = null;
    public static final a Companion = null;
    public static final PanelName GameCp = null;
    public static final PanelName LongPress = null;
    public static final PanelName More = null;
    public static final PanelName Predictor = null;
    public static final PanelName Profile = null;
    public static final PanelName PublicScreenOperatePanel = null;
    public static final PanelName RightCard = null;
    public static final PanelName UnKnown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelName[] f99045a = null;
    private final String panelName;

    public static final class a {
        public a() {
        }
    }

    public static PanelName valueOf(String r100) {
        return (PanelName) r27.a.a(PanelName.class, r100);
    }

    public static PanelName[] values() {
        return (PanelName[]) f99045a.clone();
    }

    static {
        PanelName r100 = new PanelName("UnKnown", 0, "unknown");
        UnKnown = r100;
        PanelName r101 = new PanelName("Profile", 1, "profile");
        Profile = r101;
        PanelName r102 = new PanelName("LongPress", 2, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
        LongPress = r102;
        PanelName r103 = new PanelName("More", 3, "more");
        More = r103;
        PanelName r104 = new PanelName("AudienceList", 4, "audience_list");
        AudienceList = r104;
        PanelName r105 = new PanelName("RightCard", 5, "right_card");
        RightCard = r105;
        PanelName r106 = new PanelName("GameCp", 6, "game_cp");
        GameCp = r106;
        PanelName r107 = new PanelName("Predictor", 7, "predictor");
        Predictor = r107;
        PanelName r108 = new PanelName("PublicScreenOperatePanel", 8, "public_screen_operate_panel");
        PublicScreenOperatePanel = r108;
        f99045a = new PanelName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        Companion = new a();
    }

    public final String getPanelName() {
        return this.panelName;
    }

    public PanelName(String r100, int r101, String r102) {
        super(r100, r101);
        this.panelName = r102;
    }
}
