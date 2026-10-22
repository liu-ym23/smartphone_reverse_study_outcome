package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import r27.a;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomAvator")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\bY\u0010ZR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\"\u00106\u001a\u00020\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001a\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR$\u00109\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010<R\"\u0010@\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u001a\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001eR\"\u0010C\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001a\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001eR$\u0010F\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u000e\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010<R$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR,\u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010$\u001a\u0004\bU\u0010&\"\u0004\bV\u0010(R\u0011\u0010X\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bW\u0010\u0010¨\u0006\\"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAvator;", "", "Lpy/k;", "avatar", "Lpy/k;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "authenticationInfo", "getAuthenticationInfo", "setAuthenticationInfo", "", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "", "hasFansClub", "Z", "getHasFansClub", "()Z", "invalidFollowStatus", "getInvalidFollowStatus", "", "followStatus", "J", "getFollowStatus", "()J", "setFollowStatus", "(J)V", "followReportScene", "getFollowReportScene", "setFollowReportScene", "", "firstLabel", "Ljava/util/List;", "getFirstLabel", "()Ljava/util/List;", "setFirstLabel", "(Ljava/util/List;)V", "secondLabel", "getSecondLabel", "setSecondLabel", "", "fansClubType", "I", "getFansClubType", "()I", "setFansClubType", "(I)V", "animationType", "getAnimationType", "setAnimationType", "_uid", "get_uid$live_model_api_saasRelease", "set_uid$live_model_api_saasRelease", "_openId", "get_openId$live_model_api_saasRelease", "set_openId$live_model_api_saasRelease", "(Ljava/lang/String;)V", "secUid", "getSecUid", "setSecUid", "fanTicket", "getFanTicket", "setFanTicket", "likeCount", "getLikeCount", "setLikeCount", "totalUserStr", "getTotalUserStr", "setTotalUserStr", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;", "firstTabLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;", "getFirstTabLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;", "setFirstTabLabel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;)V", "secondTabLabel", "getSecondTabLabel", "setSecondTabLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/ProfileViewData;", "profileViewData", "getProfileViewData", "setProfileViewData", "getUserId", "userId", "<init>", "()V", "FollowReportScene", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomAvator implements h {

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _openId;

    @SerializedName("uid")
    protected long _uid;

    @SerializedName("animation_type")
    protected long animationType;

    @SerializedName("authentication_info")
    protected k authenticationInfo;

    @SerializedName("avatar")
    protected k avatar;

    @SerializedName("fan_ticket")
    protected long fanTicket;

    @SerializedName("fans_club_type")
    protected int fansClubType;

    @SerializedName("first_label")
    protected List<Long> firstLabel;

    @SerializedName("first_tab_label")
    protected AnchorTabLabel firstTabLabel;

    @SerializedName("follow_report_scene")
    protected long followReportScene;

    @SerializedName("follow_status")
    protected long followStatus;

    @SerializedName("has_fans_club")
    protected boolean hasFansClub;

    @SerializedName("invalid_follow_status")
    protected boolean invalidFollowStatus;

    @SerializedName("like_count")
    protected long likeCount;

    @SerializedName("nick_name")
    protected String nickName;

    @SerializedName("profile_view_data")
    protected List<ProfileViewData> profileViewData;

    @SerializedName("sec_uid")
    protected String secUid;

    @SerializedName("second_label")
    protected List<Long> secondLabel;

    @SerializedName("second_tab_label")
    protected AnchorTabLabel secondTabLabel;

    @SerializedName("total_user_str")
    protected String totalUserStr;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAvator$FollowReportScene;", "", "scene", "", "(Ljava/lang/String;IJ)V", "getScene", "()J", "FollowReportSceneDefault", "FollowReportSceneVS", "FollowReportSceneMedia", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FollowReportScene extends Enum<FollowReportScene> {
        private static final /* synthetic */ FollowReportScene[] $VALUES = null;
        public static final FollowReportScene FollowReportSceneDefault = null;
        public static final FollowReportScene FollowReportSceneMedia = null;
        public static final FollowReportScene FollowReportSceneVS = null;
        private final long scene;

        static {
            FollowReportScene r100 = new FollowReportScene("FollowReportSceneDefault", 0, 0);
            FollowReportSceneDefault = r100;
            FollowReportScene r101 = new FollowReportScene("FollowReportSceneVS", 1, 1);
            FollowReportSceneVS = r101;
            FollowReportScene r102 = new FollowReportScene("FollowReportSceneMedia", 2, 2);
            FollowReportSceneMedia = r102;
            $VALUES = new FollowReportScene[]{r100, r101, r102};
        }

        public static FollowReportScene valueOf(String r100) {
            return (FollowReportScene) a.a(FollowReportScene.class, r100);
        }

        public static FollowReportScene[] values() {
            return (FollowReportScene[]) $VALUES.clone();
        }

        public final long getScene() {
            return this.scene;
        }

        private FollowReportScene(String r100, int r101, long r102) {
            super(r100, r101);
            this.scene = r102;
        }
    }

    public final String getUserId() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this._uid);
        String r102 = this._openId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public RoomAvator() {
        this._openId = "";
    }

    public final long getAnimationType() {
        return this.animationType;
    }

    public final k getAuthenticationInfo() {
        return this.authenticationInfo;
    }

    public final k getAvatar() {
        return this.avatar;
    }

    public final long getFanTicket() {
        return this.fanTicket;
    }

    public final int getFansClubType() {
        return this.fansClubType;
    }

    public final List<Long> getFirstLabel() {
        return this.firstLabel;
    }

    public final AnchorTabLabel getFirstTabLabel() {
        return this.firstTabLabel;
    }

    public final long getFollowReportScene() {
        return this.followReportScene;
    }

    public final long getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getHasFansClub() {
        return this.hasFansClub;
    }

    public final boolean getInvalidFollowStatus() {
        return this.invalidFollowStatus;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final List<ProfileViewData> getProfileViewData() {
        return this.profileViewData;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final List<Long> getSecondLabel() {
        return this.secondLabel;
    }

    public final AnchorTabLabel getSecondTabLabel() {
        return this.secondTabLabel;
    }

    public final String getTotalUserStr() {
        return this.totalUserStr;
    }

    public final String get_openId$live_model_api_saasRelease() {
        return this._openId;
    }

    public final long get_uid$live_model_api_saasRelease() {
        return this._uid;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Object, py.k] */
    public RoomAvator(g r100) {
        this.firstLabel = new ArrayList();
        this.secondLabel = new ArrayList();
        this.profileViewData = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L33;
        if (r102 != 5000) goto L7;
        this._openId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            default: goto L8;
        };
    L25:
        this.followReportScene = r100.j();
        goto L3
    L26:
        this.invalidFollowStatus = am3.h.a(r100);
        goto L3
    L27:
        this.followStatus = r100.j();
        goto L3
    L28:
        this.hasFansClub = am3.h.a(r100);
        goto L3
    L29:
        this.nickName = am3.h.c(r100);
        goto L3
    L30:
        this.authenticationInfo = f.a(r100, k.class);
        goto L3
    L31:
        this.avatar = f.a(r100, k.class);
        goto L3
    L8:
        switch(r102) {
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L14;
            default: goto L9;
        };
    L14:
        this.totalUserStr = am3.h.c(r100);
        goto L3
    L15:
        this.likeCount = r100.j();
        goto L3
    L16:
        this.fanTicket = r100.j();
        goto L3
    L17:
        this.secUid = am3.h.c(r100);
        goto L3
    L18:
        this._uid = r100.j();
        goto L3
    L19:
        this.animationType = r100.j();
        goto L3
    L20:
        this.fansClubType = (int) r100.j();
        goto L3
    L21:
        List r103 = this.secondLabel;
    L23:
        Object r104 = Long.valueOf(r100.j());
    L24:
        r103.add(r104);
        goto L3
    L22:
        r103 = this.firstLabel;
        goto L23
    L9:
        switch(r102) {
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            default: goto L10;
        };
    L11:
        r103 = this.profileViewData;
        r104 = new ProfileViewData(r100);
        goto L24
    L12:
        this.secondTabLabel = new AnchorTabLabel(r100);
        goto L3
    L13:
        this.firstTabLabel = new AnchorTabLabel(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L33:
        r100.d(r101);
        if (this._openId != null) goto L82;
        this._openId = "";
        return;
    }

    public final void setAnimationType(long r100) {
        this.animationType = r100;
    }

    public final void setAuthenticationInfo(k r100) {
        this.authenticationInfo = r100;
    }

    public final void setAvatar(k r100) {
        this.avatar = r100;
    }

    public final void setFanTicket(long r100) {
        this.fanTicket = r100;
    }

    public final void setFansClubType(int r100) {
        this.fansClubType = r100;
    }

    public final void setFirstLabel(List<Long> r100) {
        this.firstLabel = r100;
    }

    public final void setFirstTabLabel(AnchorTabLabel r100) {
        this.firstTabLabel = r100;
    }

    public final void setFollowReportScene(long r100) {
        this.followReportScene = r100;
    }

    public final void setFollowStatus(long r100) {
        this.followStatus = r100;
    }

    public final void setLikeCount(long r100) {
        this.likeCount = r100;
    }

    public final void setProfileViewData(List<ProfileViewData> r100) {
        this.profileViewData = r100;
    }

    public final void setSecUid(String r100) {
        this.secUid = r100;
    }

    public final void setSecondLabel(List<Long> r100) {
        this.secondLabel = r100;
    }

    public final void setSecondTabLabel(AnchorTabLabel r100) {
        this.secondTabLabel = r100;
    }

    public final void setTotalUserStr(String r100) {
        this.totalUserStr = r100;
    }

    public final void set_openId$live_model_api_saasRelease(String r100) {
        this._openId = r100;
    }

    public final void set_uid$live_model_api_saasRelease(long r100) {
        this._uid = r100;
    }
}
