package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.ss.android.download.api.constant.BaseConstants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f54882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f54885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f54890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f54891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f54892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f54893l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L30;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f54882a, r101.f54882a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54883b, r101.f54883b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54884c, r101.f54884c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54885d, r101.f54885d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54886e, r101.f54886e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54887f, r101.f54887f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54888g, r101.f54888g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54889h, r101.f54889h) == true) goto L22;
        return false;
    L22:
        if (this.f54890i == r101.f54890i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f54891j, r101.f54891j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f54892k, r101.f54892k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f54893l, r101.f54893l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f54882a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54883b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54884c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f54885d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54886e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54887f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f54888g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f54889h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (((r121 + r123) * 31) + this.f54890i) * 31;
        String r125 = this.f54891j;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f54892k;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f54893l;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderInfo(orderId=" + this.f54882a + ", gameId=" + this.f54883b + ", gameName=" + this.f54884c + ", extra=" + this.f54885d + ", scene=" + this.f54886e + ", videoId=" + this.f54887f + ", anchorId=" + this.f54888g + ", orderUrl=" + this.f54889h + ", reserveType=" + this.f54890i + ", reserveVersionNum=" + this.f54891j + ", gamePackageName=" + this.f54892k + ", planId=" + this.f54893l + ")";
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        Room r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r101 == null) goto L5;
        Object r102 = r101.getRoomId();
    L6:
        r100.put("order_id", this.f54882a);
        r100.put("order_url", this.f54889h);
        JSONObject r103 = new JSONObject();
        r103.put("id", this.f54883b);
        r103.put("name", this.f54884c);
        JSONObject r104 = this.f54885d;
        r104.put("product_type", BaseConstants.GAME_INFO_LIVE_UNION);
        r104.put("app_type", "2");
        String r105 = this.f54888g;
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        r104.put("from_author_id", r105);
        if (r102 != null) goto L12;
        r102 = this.f54887f;
    L12:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r102);
        r104.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, this.f54886e);
        r104.put("reserve_type", this.f54890i);
        r104.put("reserve_version_num", this.f54891j);
        r104.put("game_package_name", this.f54892k);
        String r106 = this.f54893l;
        if (r106 == null) goto L15;
        r104.put("plan_id", r106);
    L15:
        Unit r107 = Unit.INSTANCE;
        r103.put("extra", r104);
        r103.put("event_tag", "book_download");
        r100.put("download_model", r103);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public q(String r110, String r111, String r112, JSONObject r113, String r210, String r211, String r212, int r213, String r214, String r215, String r216, int r217) {
        String r100 = "";
        if ((r217 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r217 & 16) == 0) goto L9;
        String r102 = "0";
    L11:
        if ((r217 & 32) == 0) goto L13;
        String r103 = "";
    L14:
        String r114 = null;
        if ((r217 & 64) == 0) goto L22;
        Room r104 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r104 == null) goto L21;
        String r105 = r104.getOwnerUserId();
        if (r105 == null) goto L21;
    L24:
        if ((r217 & 128) == 0) goto L26;
        String r115 = "https://webcast.amemv.com/webcast/gamecp/user/auto_download/check/";
    L28:
        if ((r217 & 256) == 0) goto L30;
        int r116 = 1;
    L32:
        if ((r217 & 512) == 0) goto L34;
        String r117 = "";
    L36:
        if ((r217 & 1024) != 0) goto L40;
        r100 = r215;
    L40:
        if ((r217 & 2048) != 0) goto L43;
        r114 = r216;
    L43:
        Intrinsics.checkNotNullParameter(r101, "orderId");
        Intrinsics.checkNotNullParameter(r111, "gameId");
        Intrinsics.checkNotNullParameter(r112, "gameName");
        Intrinsics.checkNotNullParameter(r113, "extra");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, "videoId");
        Intrinsics.checkNotNullParameter(r115, "orderUrl");
        this.f54882a = r101;
        this.f54883b = r111;
        this.f54884c = r112;
        this.f54885d = r113;
        this.f54886e = r102;
        this.f54887f = r103;
        this.f54888g = r105;
        this.f54889h = r115;
        this.f54890i = r116;
        this.f54891j = r117;
        this.f54892k = r100;
        this.f54893l = r114;
        return;
    L34:
        r117 = r214;
        goto L36
    L30:
        r116 = r213;
        goto L32
    L26:
        r115 = null;
    L21:
        r105 = null;
        goto L24
    L22:
        r105 = r212;
        goto L24
    L13:
        r103 = r211;
        goto L14
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
