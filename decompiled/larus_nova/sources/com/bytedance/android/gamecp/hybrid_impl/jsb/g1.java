package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.OpenMobileGameUtil;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "createGameRoom")
public final class g1 extends d<m1, CreateGameRoomResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f57499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f57502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57503f;

    public static final class a {
    }

    static {
    }

    public g1() {
        this.f57502e = "";
    }

    public static final void k(final g1 r100, final Context r101) {
        r100.getClass();
        if (r101 == null) goto L7;
        UtilityKotlinExtentionsKt.g(0, false, false, new CreateGameRoomMethod$showInstallGameDialog$1(r100, r101), 7);
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        m1 r112 = (m1) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callContext");
        mw.a r100 = (mw.a) xr.s.a(mw.a.class);
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getJumpGameDetailId();
    L6:
        this.f57498a = r102;
        Room r103 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r103 == null) goto L10;
        String r104 = String.valueOf(r103.getId());
        if (r104 == null) goto L10;
    L11:
        this.f57499b = r104;
        Room r105 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r105 == null) goto L14;
        r101 = r105.getOwnerUserId();
    L14:
        this.f57500c = String.valueOf(r101);
        String r106 = r112.e();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        this.f57502e = r106;
        List<String> r107 = r112.d();
        Boolean r108 = r112.g();
        if (r108 == null) goto L20;
        boolean r109 = r108.booleanValue();
    L21:
        this.f57501d = r109;
        this.f57503f = r112.a();
        List<String> r113 = r107;
        if (r113 != null) goto L24;
    L27:
        boolean r114 = true;
    L28:
        if (r114 == false) goto L33;
        String r115 = r112.c();
        if (r115 != null) goto L32;
        r115 = "";
    L32:
        r107 = CollectionsKt.listOf(r115);
    L33:
        String r116 = r112.c();
        OpenMobileGameUtil.GameStatus r117 = OpenMobileGameUtil.GameStatus.GAME_STATUS_UNINSTALL;
        if (wu.b2.f561284a.getValue().booleanValue() == false) goto L36;
        int r118 = OpenMobileGameUtil.f57180a;
        OpenMobileGameUtil.GameStatus r119 = OpenMobileGameUtil.b("", r112.f(), r111.getContext());
        r116 = "";
    L45:
        CreateGameRoomResultModel r120 = new CreateGameRoomResultModel();
        r120.a(CreateGameRoomResultModel.Code.Success);
        CreateGameRoomResultModel.a r121 = new CreateGameRoomResultModel.a();
        r121.a(Integer.valueOf(r119.getValue()));
        Unit r122 = Unit.INSTANCE;
        r120.b(r121);
        finishWithResult(r120);
        if ((!Intrinsics.areEqual(r112.b(), Boolean.TRUE)) == false) goto L62;
        int r123 = OpenMobileGameUtil.f57180a;
        String r124 = r112.f();
        if (r124 != null) goto L50;
        String r125 = "";
    L51:
        if (r116 != null) goto L53;
        String r126 = "";
    L54:
        OpenMobileGameUtil.e(r125, r126, r119, null, new CreateGameRoomMethod$invoke$2(this), 24);
        return;
    L53:
        r126 = r116;
        goto L54
    L50:
        r125 = r124;
        goto L51
    L62:
        return;
    L36:
        Iterator<String> r127 = r107.iterator();
    L38:
        if (r127.hasNext() == false) goto L44;
        String r128 = r127.next();
        if ((!StringsKt.isBlank(r128)) == false) goto L38;
        int r129 = OpenMobileGameUtil.f57180a;
        r117 = OpenMobileGameUtil.b(r128, r112.f(), r111.getContext());
        if (r117 != OpenMobileGameUtil.GameStatus.GAME_STATUS_INSTALLED) goto L38;
        r119 = r117;
        r116 = r128;
        goto L45
    L44:
        r119 = r117;
        goto L45
    L24:
        if (r113.isEmpty() == true) goto L27;
        r114 = false;
        goto L28
    L20:
        r109 = true;
    L10:
        r104 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public static final void j(g1 r100, Context r101, View r102) {
        String r103 = r100.f57498a;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L14;
        mw.a r106 = (mw.a) xr.s.a(mw.a.class);
        if (r106 == null) goto L13;
        r103 = r106.getJumpGameDetailId();
        goto L14
    L13:
        r103 = null;
    L14:
        if (r103 != null) goto L16;
    L19:
        if (r104 == true) goto L29;
        Bundle r107 = new Bundle();
        r107.putString("game_id", r100.f57498a);
        r107.putString("room_id", r100.f57499b);
        r107.putString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r100.f57500c);
        HashMap r108 = new HashMap();
        r108.put("previous_page", "play_start_page");
        r108.put("previous_module", CollectionsKt.mutableListOf(new String[]{"create_room"}));
        if (r102 == null) goto L24;
        HashMap<String, String> r109 = GamecpTracker.f56755a;
        GamecpTracker.f(r102, r108);
    L24:
        r107.putSerializable("track_previous_route", r108);
        xr.f r110 = (xr.f) xr.s.a(xr.f.class);
        if (r110 == null) goto L28;
        r110.showGamePromoteDetailDialog(r101, r107, Boolean.FALSE);
        return;
    L28:
        return;
    L29:
        return;
    L16:
        if (r103.length() == 0) goto L19;
        r104 = false;
        goto L19
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public final void l(Context r100, String r101, String r110, List r111, String r112, String r113, final Function1 r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f57498a = r110;
        this.f57499b = r112;
        this.f57500c = r113;
        boolean r115 = true;
        this.f57501d = true;
        if (r111 != null) goto L6;
        r111 = CollectionsKt.emptyList();
    L6:
        if (r111.isEmpty() == false) goto L13;
        int r116 = OpenMobileGameUtil.f57180a;
        OpenMobileGameUtil.GameStatus r102 = OpenMobileGameUtil.b("", r101, r100);
        if (r101 != null) goto L10;
        String r103 = "";
    L11:
        OpenMobileGameUtil.e(r103, "", r102, new CreateGameRoomMethod$openMobileGame$1(r114), new CreateGameRoomMethod$openMobileGame$2(this, r114), 8);
        return;
    L10:
        r103 = r101;
        goto L11
    L13:
        Iterator r117 = r111.iterator();
    L15:
        if (r117.hasNext() == false) goto L27;
        String r118 = (String) r117.next();
        if ((!StringsKt.isBlank(r118)) == false) goto L15;
        int r104 = OpenMobileGameUtil.f57180a;
        OpenMobileGameUtil.GameStatus r105 = OpenMobileGameUtil.b(r118, r101, r100);
        if (r105 != OpenMobileGameUtil.GameStatus.GAME_STATUS_INSTALLED) goto L15;
        if (r101 != null) goto L22;
        String r106 = "";
    L23:
        if (r118 != null) goto L25;
        String r107 = "";
    L26:
        OpenMobileGameUtil.e(r106, r107, r105, new CreateGameRoomMethod$openMobileGame$3(r114), new CreateGameRoomMethod$openMobileGame$4(this, r114), 8);
    L28:
        if (r115 == true) goto L37;
        int r108 = OpenMobileGameUtil.f57180a;
        OpenMobileGameUtil.e("", "", OpenMobileGameUtil.GameStatus.GAME_STATUS_CONSIDER_OPEN_FAIL, new CreateGameRoomMethod$openMobileGame$5(r114), new CreateGameRoomMethod$openMobileGame$6(this, r114), 8);
        return;
    L37:
        return;
    L25:
        r107 = r118;
        goto L26
    L22:
        r106 = r101;
        goto L23
    L27:
        r115 = false;
        goto L28
    }
}
