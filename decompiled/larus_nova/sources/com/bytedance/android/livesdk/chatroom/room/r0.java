package com.bytedance.android.livesdk.chatroom.room;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.live.vs.VSLoggerExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LinkerDetail;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class r0 {
    public final int A;
    public final int B;
    public final long C;
    public final int D;
    public final Bundle E;
    public final long F;
    public final boolean G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f111125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f111126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f111127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f111128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f111129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f111130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f111131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f111132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f111133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f111134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f111135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f111136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f111137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f111138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkerDetail f111139o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f111140p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f111141q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final VSLoggerExtra f111142r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f111143s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f111144t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Bundle f111145u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f111146v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f111147w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f111148x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f111149y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f111150z;

    public r0(Bundle r110) {
        Intrinsics.checkNotNullParameter(r110, "args");
        this.f111125a = r110.getString("live.intent.extra.ENTER_TYPE", "click");
        this.f111126b = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE, "");
        this.f111127c = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND);
        this.f111128d = r110.getString("enter_from_merge");
        String r100 = null;
        if (TextUtils.isEmpty(r110.getString("enter_from_ad_type")) == false) goto L8;
        Bundle r101 = com.bytedance.android.livesdk.chatroom.m0.a(r110);
        if (r101 == null) goto L7;
        String r102 = r101.getString("enter_from_ad_type");
    L9:
        this.f111129e = r102;
        this.f111130f = r110.getString("enter_method");
        if (r110.getBundle("MERGE_WIDGET_ENTER_BUNDLE") == null) goto L19;
        Bundle r103 = r110.getBundle("MERGE_WIDGET_ENTER_BUNDLE");
        if (r103 == null) goto L19;
        if (r103.containsKey("click_method") != true) goto L19;
        Bundle r104 = r110.getBundle("MERGE_WIDGET_ENTER_BUNDLE");
        if (r104 == null) goto L18;
        String r105 = r104.getString("click_method");
    L20:
        this.f111131g = r105;
        this.f111132h = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_SOURCE_TYPE);
        com.bytedance.android.live.base.model.user.o0.f58946a.getClass();
        this.f111133i = com.bytedance.android.live.base.model.user.o0.a.c(r110, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_USER_ID, "0");
        this.f111134j = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID, null);
        this.f111135k = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_PB, null);
        this.f111136l = r110.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_FROM, 0);
        this.f111137m = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ROOM_LINKER_MAP, null);
        this.f111138n = r110.getInt(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ROOM_UI_LAYOUT, 0);
        this.f111139o = (LinkerDetail) jc1.g.a(r110, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ROOM_LINKER_DETAIL);
        this.f111140p = r110.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_LOYAL_AUDIENCE, false);
        this.f111141q = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTER_ROOM_HANDLE_SCHEMA);
        this.f111142r = new VSLoggerExtra(r110);
        String r106 = r110.getString("source");
        if (r106 != null) goto L23;
        r106 = "";
    L23:
        this.f111143s = r106;
        this.f111144t = r110.getString("tag_id", null);
        this.f111145u = r110;
        this.f111146v = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_REN_QI_BAO_SEC_BUYER_ID, "");
        this.f111147w = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_DOU_PLUS_SEC_BUYER_ID, "");
        this.f111148x = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_VIDEO_GOODS_IDS, null);
        this.f111149y = r110.getInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_AUTO, 0);
        r110.getLong(VSConstants.EXTRA_VS_MATCH_ID, 0);
        String r107 = r110.getString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, null);
        if (r107 != null) goto L26;
    L29:
        boolean r111 = true;
    L31:
        if (r111 == false) goto L97;
    L36:
        String r108 = null;
    L37:
        this.f111150z = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID, r108);
        this.A = r110.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        this.B = r110.getInt("room_controller_unique_key");
        String r109 = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SHARE_USER_ID);
        if (r109 == null) goto L42;
        Long r112 = StringsKt.toLongOrNull(r109);
        if (r112 == null) goto L42;
        long r113 = r112.longValue();
    L43:
        this.C = r113;
        this.D = r110.getInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_SCENARIO, 0);
        Bundle r114 = com.bytedance.android.livesdk.chatroom.m0.a(r110);
        this.E = r114;
        if (r114 == null) goto L46;
        long r115 = r114.getLong("video_id", 0);
    L47:
        this.F = r115;
        this.G = r110.getBoolean("from_notification", false);
        this.H = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, null);
        this.I = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_JOINT_ANCHOR_ID, null);
        TextUtils.isEmpty(r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_JOINT_ANCHOR_ID, null));
        if (TextUtils.isEmpty(this.f111134j) == false) goto L57;
        if (r114 == null) goto L52;
        String r116 = r114.getString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID);
        if (r116 == null) goto L52;
    L55:
        this.f111134j = r116;
    L52:
        if (r114 == null) goto L54;
        r116 = r114.getString("request_id", "");
        goto L55
    L54:
        r116 = null;
    L57:
        if (TextUtils.isEmpty(this.f111135k) == false) goto L66;
        if (r114 == null) goto L61;
        String r117 = r114.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_PB);
        if (r117 == null) goto L61;
    L64:
        this.f111135k = r117;
    L61:
        if (r114 == null) goto L63;
        r117 = r114.getString("log_pb", "");
        goto L64
    L63:
        r117 = null;
    L66:
        if (this.f111136l != 0) goto L72;
        if (r114 == null) goto L69;
        long r118 = r114.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_FROM, 0);
    L70:
        this.f111136l = r118;
        goto L72
    L69:
        r118 = 0;
    L72:
        if (this.f111127c != null) goto L78;
        if (r114 == null) goto L75;
        String r119 = r114.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "");
    L76:
        this.f111127c = r119;
        goto L78
    L75:
        r119 = null;
    L78:
        if (com.bytedance.android.livesdk.chatroom.m0.d(r110) != null) goto L80;
    L92:
        VSLoggerExtra r120 = this.f111142r;
        if (r114 == null) goto L95;
        r100 = r114.getString("live_reason", "");
    L95:
        r120.setLiveReason(r100);
        return;
    L80:
        if (r110.getLong(VSConstants.EXTRA_ITEM_ID, 0) <= 0) goto L92;
        if (r110.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.VS_DEFAULT) == VSConstants.VS_DEFAULT) goto L92;
        if (TextUtils.isEmpty(r110.getString(VSConstants.EXTRA_VS_ENTER_TYPE, "")) == false) goto L92;
        Bundle r121 = yt2.a.b(r110, "live.intent.extra.ENTER_LIVE_EXTRA");
        if (r121 == null) goto L88;
        String r122 = r121.getString(VSConstants.EXTRA_VS_ENTER_TYPE, "");
    L90:
        if (TextUtils.isEmpty(r122) == false) goto L92;
        this.f111142r.setVsEnterType(VSConstants.EXTRA_VS_ENTER_TYPE_EPISODE_DATA);
        goto L92
    L88:
        r122 = null;
        goto L90
    L46:
        r115 = 0;
    L42:
        r113 = 0;
        goto L43
    L97:
        r108 = new JSONObject(new JSONObject(r107).optString("pass_through_log_data")).optString(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID);     // Catch: Exception -> L35
    L26:
        if (r107.length() == 0) goto L29;
        r111 = false;
        goto L31
    L18:
        r105 = null;
    L19:
        r105 = "";
        goto L20
    L7:
        r102 = null;
        goto L9
    L8:
        r102 = r110.getString("enter_from_ad_type");
        goto L9
    }
}
