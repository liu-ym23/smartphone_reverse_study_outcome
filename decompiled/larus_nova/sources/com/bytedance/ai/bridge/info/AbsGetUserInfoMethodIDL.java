package com.bytedance.ai.bridge.info;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetUserInfoResultModel", "UserInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetUserInfoMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35337a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000b\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "", "userID", "", "shortID", "secUserID", "uniqueID", InstantPlayContext.NICKNAME, "avatarURL", "hasBoundPhone", "", "isBoundPhone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getUserID", "()Ljava/lang/String;", "getShortID", "getSecUserID", "getUniqueID", "getNickname", "getAvatarURL", "getHasBoundPhone", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$UserInfo;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserInfo {

        @SerializedName("avatarURL")
        private final String avatarURL;

        @SerializedName("hasBoundPhone")
        private final Boolean hasBoundPhone;

        @SerializedName("isBoundPhone")
        private final Boolean isBoundPhone;

        @SerializedName(InstantPlayContext.NICKNAME)
        private final String nickname;

        @SerializedName("secUserID")
        private final String secUserID;

        @SerializedName("shortID")
        private final String shortID;

        @SerializedName("uniqueID")
        private final String uniqueID;

        @SerializedName("userID")
        private final String userID;

        public UserInfo() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ UserInfo copy$default(UserInfo r100, String r110, String r111, String r112, String r113, String r114, String r115, Boolean r116, Boolean r117, int r118, Object r119) {
            if ((r118 & 1) == 0) goto L5;
            String r101 = r100.userID;
        L7:
            if ((r118 & 2) == 0) goto L9;
            String r102 = r100.shortID;
        L11:
            if ((r118 & 4) == 0) goto L13;
            String r103 = r100.secUserID;
        L15:
            if ((r118 & 8) == 0) goto L17;
            String r104 = r100.uniqueID;
        L19:
            if ((r118 & 16) == 0) goto L21;
            String r105 = r100.nickname;
        L23:
            if ((r118 & 32) == 0) goto L25;
            String r106 = r100.avatarURL;
        L27:
            if ((r118 & 64) == 0) goto L29;
            Boolean r107 = r100.hasBoundPhone;
        L31:
            if ((r118 & 128) == 0) goto L33;
            Boolean r108 = r100.isBoundPhone;
        L35:
            return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
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

        public final String component1() {
            return this.userID;
        }

        public final String component2() {
            return this.shortID;
        }

        public final String component3() {
            return this.secUserID;
        }

        public final String component4() {
            return this.uniqueID;
        }

        public final String component5() {
            return this.nickname;
        }

        public final String component6() {
            return this.avatarURL;
        }

        public final Boolean component7() {
            return this.hasBoundPhone;
        }

        public final Boolean component8() {
            return this.isBoundPhone;
        }

        public final UserInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, Boolean r116, Boolean r117) {
            return new UserInfo(r110, r111, r112, r113, r114, r115, r116, r117);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof UserInfo) == true) goto L8;
            return false;
        L8:
            UserInfo r101 = (UserInfo) r100;
            if (Intrinsics.areEqual(this.userID, r101.userID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.shortID, r101.shortID) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.secUserID, r101.secUserID) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.uniqueID, r101.uniqueID) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.avatarURL, r101.avatarURL) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.hasBoundPhone, r101.hasBoundPhone) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isBoundPhone, r101.isBoundPhone) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            String r100 = this.userID;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.shortID;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.secUserID;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.uniqueID;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.nickname;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.avatarURL;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            Boolean r119 = this.hasBoundPhone;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            Boolean r122 = this.isBoundPhone;
            if (r122 == null) goto L35;
            r101 = r122.hashCode();
        L35:
            return r121 + r101;
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "UserInfo(userID=" + this.userID + ", shortID=" + this.shortID + ", secUserID=" + this.secUserID + ", uniqueID=" + this.uniqueID + ", nickname=" + this.nickname + ", avatarURL=" + this.avatarURL + ", hasBoundPhone=" + this.hasBoundPhone + ", isBoundPhone=" + this.isBoundPhone + ')';
        }

        public final String getAvatarURL() {
            return this.avatarURL;
        }

        public final Boolean getHasBoundPhone() {
            return this.hasBoundPhone;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getSecUserID() {
            return this.secUserID;
        }

        public final String getShortID() {
            return this.shortID;
        }

        public final String getUniqueID() {
            return this.uniqueID;
        }

        public final String getUserID() {
            return this.userID;
        }

        public final Boolean isBoundPhone() {
            return this.isBoundPhone;
        }

        public UserInfo(String r100, String r101, String r102, String r103, String r104, String r105, Boolean r106, Boolean r107) {
            this.userID = r100;
            this.shortID = r101;
            this.secUserID = r102;
            this.uniqueID = r103;
            this.nickname = r104;
            this.avatarURL = r105;
            this.hasBoundPhone = r106;
            this.isBoundPhone = r107;
        }

        public /* synthetic */ UserInfo(String r110, String r111, String r112, String r113, String r114, String r115, Boolean r116, Boolean r117, int r118, DefaultConstructorMarker r119) {
            Boolean r100 = null;
            if ((r118 & 1) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r118 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r118 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r118 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r118 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r118 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r118 & 64) == 0) goto L29;
            Boolean r107 = null;
        L31:
            if ((r118 & 128) != 0) goto L34;
            r100 = r117;
        L34:
            this(r101, r102, r103, r104, r105, r106, r107, r100);
            return;
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
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

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "hasLoggedIn", required = true)
        void setHasLoggedIn(boolean r100);

        @AIBridgeParamField(keyPath = Keys.API_RETURN_KEY_IS_LOGIN, required = true)
        void setLogin(boolean r100);

        @AIBridgeParamField(keyPath = "userInfo", required = false)
        void setUserInfo(UserInfo r100);
    }

    public AbsGetUserInfoMethodIDL() {
        this.f35337a = "applet.getUserInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35337a;
    }
}
