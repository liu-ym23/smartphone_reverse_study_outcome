package com.bytedance.android.live.broadcastgame.api.model.response;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.stamp.MicroAppEntrancePermissionResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001e\u0010\"\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R,\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/response/MiniAppEntrancePermissionResponse;", "Ljava/io/Serializable;", "()V", "introImgUrl", "", "getIntroImgUrl", "()Ljava/lang/String;", "setIntroImgUrl", "(Ljava/lang/String;)V", "introInfo", "", "Lcom/bytedance/android/live/broadcastgame/api/model/response/MiniAppEntrancePermissionResponse$PermissionThresholdInfo;", "getIntroInfo", "()Ljava/util/List;", "setIntroInfo", "(Ljava/util/List;)V", "permit", "", "getPermit", "()Z", "setPermit", "(Z)V", "permitStatus", "", "getPermitStatus", "()I", "setPermitStatus", "(I)V", "showIntroPanel", "getShowIntroPanel", "setShowIntroPanel", "showNewPanel", "getShowNewPanel", "setShowNewPanel", "showYellowPoint", "getShowYellowPoint", "setShowYellowPoint", ScoreTags.STAR_URL_LIST, "", "getUrl_list", "()Ljava/util/Map;", "setUrl_list", "(Ljava/util/Map;)V", "PermissionThresholdInfo", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppEntrancePermissionResponse implements Serializable, h {

    @SerializedName("intro_img_url")
    protected String introImgUrl;

    @SerializedName(LocationMonitorConst.PERMISSION_STATUS)
    protected List<PermissionThresholdInfo> introInfo;

    @SerializedName("permit")
    protected boolean permit;

    @SerializedName("permit_status")
    protected int permitStatus;

    @SerializedName("show_intro_panel")
    protected boolean showIntroPanel;

    @SerializedName("show_new_panel")
    protected boolean showNewPanel;

    @SerializedName("show_yellow_point")
    protected boolean showYellowPoint;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected Map<String, String> url_list;

    @ProtoMessage("webcast.api.stamp.PermissionThresholdInfo")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/response/MiniAppEntrancePermissionResponse$PermissionThresholdInfo;", "Ljava/io/Serializable;", "()V", SocialConstants.PARAM_APP_DESC, "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PermissionThresholdInfo implements Serializable, h {

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        protected String desc;

        @SerializedName("status")
        protected String status;

        public PermissionThresholdInfo() {
            this.desc = "";
            this.status = "";
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getStatus() {
            return this.status;
        }

        public PermissionThresholdInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.desc = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.status = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.desc != null) goto L16;
            this.desc = "";
        L16:
            if (this.status != null) goto L28;
            this.status = "";
            return;
        }

        public final void setDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.desc = r100;
        }

        public final void setStatus(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.status = r100;
        }
    }

    public MiniAppEntrancePermissionResponse() {
        this.introImgUrl = "";
    }

    public final String getIntroImgUrl() {
        return this.introImgUrl;
    }

    public final List<PermissionThresholdInfo> getIntroInfo() {
        return this.introInfo;
    }

    public final boolean getPermit() {
        return this.permit;
    }

    public final int getPermitStatus() {
        return this.permitStatus;
    }

    public final boolean getShowIntroPanel() {
        return this.showIntroPanel;
    }

    public final boolean getShowNewPanel() {
        return this.showNewPanel;
    }

    public final boolean getShowYellowPoint() {
        return this.showYellowPoint;
    }

    public final Map<String, String> getUrl_list() {
        return this.url_list;
    }

    public MiniAppEntrancePermissionResponse(g r110) {
        this.introInfo = new ArrayList();
        this.url_list = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L32;
        switch(r101) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L8:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L8
    L13:
        if (r105 != 2) goto L14;
        r104 = am3.h.c(r110);
        goto L8
    L14:
        am3.h.e(r110);
        goto L8
    L17:
        r110.d(r102);
        Map<String, String> r106 = this.url_list;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.showNewPanel = am3.h.a(r110);
        goto L3
    L26:
        this.permitStatus = r110.i();
        goto L3
    L27:
        this.introInfo.add(new PermissionThresholdInfo(r110));
        goto L3
    L28:
        this.introImgUrl = am3.h.c(r110);
        goto L3
    L29:
        this.showYellowPoint = am3.h.a(r110);
        goto L3
    L30:
        this.showIntroPanel = am3.h.a(r110);
        goto L3
    L31:
        this.permit = am3.h.a(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L32:
        r110.d(r100);
        if (this.introImgUrl != null) goto L67;
        this.introImgUrl = "";
        return;
    }

    public final void setIntroImgUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.introImgUrl = r100;
    }

    public final void setIntroInfo(List<PermissionThresholdInfo> r100) {
        this.introInfo = r100;
    }

    public final void setPermit(boolean r100) {
        this.permit = r100;
    }

    public final void setPermitStatus(int r100) {
        this.permitStatus = r100;
    }

    public final void setShowIntroPanel(boolean r100) {
        this.showIntroPanel = r100;
    }

    public final void setShowNewPanel(boolean r100) {
        this.showNewPanel = r100;
    }

    public final void setShowYellowPoint(boolean r100) {
        this.showYellowPoint = r100;
    }

    public final void setUrl_list(Map<String, String> r100) {
        this.url_list = r100;
    }
}
