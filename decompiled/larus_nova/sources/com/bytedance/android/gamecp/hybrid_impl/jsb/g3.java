package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/g3;", "", "", "label", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "refer", "c", "setRefer", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/g3$a;", "ad_extra_data", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/g3$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/g3$a;", "setAd_extra_data", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/g3$a;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g3 {

    @SerializedName("ad_extra_data")
    private a ad_extra_data;

    @SerializedName("label")
    private String label;

    @SerializedName("refer")
    private String refer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/g3$a;", "", "", "anchor_id", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAnchor_id", "(Ljava/lang/String;)V", "room_id", "e", "setRoom_id", "game_id", "b", "setGame_id", EventConstants.ExtraJson.GAME_NAME, "c", "setGame_name", "", "game_status", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setGame_status", "(Ljava/lang/Integer;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("anchor_id")
        private String anchor_id;

        @SerializedName("game_id")
        private String game_id;

        @SerializedName(EventConstants.ExtraJson.GAME_NAME)
        private String game_name;

        @SerializedName("game_status")
        private Integer game_status;

        @SerializedName("room_id")
        private String room_id;

        public a() {
        }

        public final String a() {
            return this.anchor_id;
        }

        public final String b() {
            return this.game_id;
        }

        public final String c() {
            return this.game_name;
        }

        public final Integer d() {
            return this.game_status;
        }

        public final String e() {
            return this.room_id;
        }
    }

    public g3() {
    }

    public final a a() {
        return this.ad_extra_data;
    }

    public final String b() {
        return this.label;
    }

    public final String c() {
        return this.refer;
    }
}
