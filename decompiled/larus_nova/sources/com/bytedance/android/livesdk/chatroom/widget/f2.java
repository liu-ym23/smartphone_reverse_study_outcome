package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v6;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.config.ff1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class f2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Long> f118799f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kc0.t f118800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f118801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f118802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f118803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f118804e;

    public static final class a {
    }

    public f2() {
    }

    static {
        f118799f = CollectionsKt.listOf(new Long[]{Long.valueOf(6), Long.valueOf(2)});
    }

    public static long a(String r100, int r101) {
        int r102 = r100.length();
        long r103 = 0;
        if (r101 >= 0) goto L5;
        return 0;
    L5:
        if (r101 >= r102) goto L9;
        if (Character.isDigit(r100.charAt(r101)) == true) goto L9;
        r101 = r101 + 1;
    L9:
        if (r101 >= r102) goto L13;
        if (Character.isDigit(r100.charAt(r101)) == false) goto L13;
        r103 = (r103 * ((long) 10)) + ((long) (r100.charAt(r101) - '0'));
        r101 = r101 + 1;
    L13:
        return r103;
    }

    public final void b(Context r210, DataCenter r211, String r212, RoomSession r213) {
        String r100 = "";
        if (ff1.f120199a.getValue().booleanValue() == true) goto L6;
        return;
    L6:
        if (v6.f65441a.getValue().booleanValue() == false) goto L16;
        ILivePlayerClient r101 = LivePlatformPlayerManager.f();
        if (r101 == null) goto L12;
        LivePlayerClientContext r102 = r101.context();
        if (r102 == null) goto L12;
        String r103 = r102.getLastLayoutSei();
    L14:
        if (com.bytedance.android.livesdk.utils.r2.a(r103) == false) goto L16;
        String r110 = r103;
    L18:
        if (r110 != null) goto L20;
    L23:
        boolean r104 = true;
    L24:
        if (r104 == false) goto L27;
        return;
    L27:
        if (Intrinsics.areEqual(r110, this.f118803d) == false) goto L29;
        return;
    L29:
        int r111 = StringsKt.indexOf$default(r110, "app_data", 0, false, 6, null);
        if (r111 >= 0) goto L32;
        return;
    L32:
        int r105 = StringsKt.indexOf$default(r110, "ver", r111, false, 4, null);
        if (r105 >= 0) goto L35;
        return;
    L35:
        long r214 = a(r110, r105);
        if (f118799f.contains(Long.valueOf(r214)) == true) goto L118;
        return;
    L118:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L40
        String r107 = new JSONObject(r110).optString("app_data", "");     // Catch: Throwable -> L40
    L46:
        if (Intrinsics.areEqual(r107, this.f118804e) == false) goto L48;
        return;
    L48:
        int r108 = StringsKt.indexOf$default(r110, "channel_id", r111, false, 4, null);
        if (r108 >= 0) goto L51;
        return;
    L51:
        long r112 = a(r110, r108);
        if (r112 != 0) goto L54;
        return;
    L54:
        this.f118803d = r110;
        this.f118804e = r107;
        if (r213 == null) goto L57;
        long r113 = r213.getRoomId();
    L58:
        if (r213 == null) goto L63;
        Room r109 = r213.getPreLoadRoom();
        if (r109 == null) goto L63;
        String r114 = r109.getOwnerUserIdString();
        if (r114 == null) goto L63;
    L64:
        if (r213 == null) goto L71;
        Room r115 = r213.getPreLoadRoom();
        if (r115 == null) goto L71;
        User r116 = r115.mo8271getOwner();
        if (r116 == null) goto L71;
        String r117 = r116.getCastSecUid();
        if (r117 == null) goto L71;
    L72:
        IUserService r118 = (IUserService) jc1.k.f(IUserService.class);
        if (r118 == null) goto L78;
        com.bytedance.android.livesdk.user.f r119 = r118.user();
        if (r119 == null) goto L78;
        String r120 = r119.n();
        if (r120 == null) goto L78;
    L79:
        IUserService r121 = (IUserService) jc1.k.f(IUserService.class);
        if (r121 == null) goto L88;
        com.bytedance.android.livesdk.user.f r122 = r121.user();
        if (r122 == null) goto L88;
        String r123 = r122.a(r120);
        if (r123 == null) goto L88;
        r100 = r123;
    L88:
        if ((!Intrinsics.areEqual(r114, r120)) == false) goto L90;
        String r124 = "0";
    L91:
        ALogger.e("MultiLinkPreloadWidget", "update info channelID: " + r112 + " roomID: " + r113 + " ownerID: " + r114 + " sei: " + r110);
        if (this.f118800a != null) goto L101;
        ILinkServiceExternal r125 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r125 == null) goto L98;
        lc0.b r126 = r125.getMultiAnchorServiceExternal();
        if (r126 == null) goto L98;
        kc0.t r127 = r126.e();
    L99:
        this.f118800a = r127;
    L98:
        r127 = null;
    L101:
        if (this.f118802c == false) goto L103;
    L108:
        kc0.t r128 = this.f118800a;
        if (r128 == null) goto L115;
        if (r213 == null) goto L112;
        long r129 = r213.getRoomId();
    L113:
        r128.b(r210, r112, r129, r114, r214, r110, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("anchor_id", r114), TuplesKt.to("sec_anchor_id", r117), TuplesKt.to("user_id", r120), TuplesKt.to("sec_user_id", r100), TuplesKt.to(IPerformanceManager.Params.is_anchor, r124)}));
        goto L115
    L112:
        r129 = 0;
    L115:
        if (r211 == null) goto L120;
        r211.put("DATA_MULTI_REVENUE_PRELOAD_INFO", new h2(r113, r112, r214));
        return;
    L120:
        return;
    L103:
        if (this.f118801b == false) goto L108;
        kc0.t r130 = this.f118800a;
        if (r130 == null) goto L108;
        this.f118802c = true;
        r130.c(r113);
        goto L108
    L90:
        r124 = "1";
    L78:
        r120 = "";
    L71:
        r117 = "";
    L63:
        r114 = "";
        goto L64
    L57:
        r113 = 0;
    L40:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        Object r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r132) == false) goto L44;
        r132 = null;
    L44:
        r107 = (String) r132;
        goto L46
    L20:
        if (r110.length() == 0) goto L23;
        r104 = false;
    L12:
        r103 = null;
    L16:
        r110 = r212;
        goto L18
    }
}
