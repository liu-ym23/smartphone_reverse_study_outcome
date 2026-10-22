package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LinkRoomFightLynxConfig;", "", "scoreBarSchema", "", "scoreBarUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkRoomFightLynxConfig {
    public static final Companion Companion = null;

    @SerializedName("score_bar_schema")
    public String scoreBarSchema;

    @SerializedName("score_bar_url")
    public String scoreBarUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LinkRoomFightLynxConfig$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/LinkRoomFightLynxConfig;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final LinkRoomFightLynxConfig defaultConfig() {
            Object[] r100 = 0 == true ? 1 : 0;
            return new LinkRoomFightLynxConfig(null, r100, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkRoomFightLynxConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public LinkRoomFightLynxConfig(String r100, String r101) {
        this.scoreBarSchema = r100;
        this.scoreBarUrl = r101;
    }

    public /* synthetic */ LinkRoomFightLynxConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "sslocal://webcast_lynxview?business_type=team_fight_score_bar&url=";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_saas/pages/team_fight_score_bar/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=guest_battle_panel&team_fight_type=2";
    L8:
        this(r100, r101);
    }
}
