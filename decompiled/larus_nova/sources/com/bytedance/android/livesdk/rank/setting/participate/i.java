package com.bytedance.android.livesdk.rank.setting.participate;

import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.lark.thirdshare.base.export.ShareAnswerType;
import cy0.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f157033a;

    public i(k r100) {
        this.f157033a = r100;
    }

    public final Map<String, String> a(g r100) {
        Pair[] r101 = new Pair[9];
        k r102 = this.f157033a;
        Long r103 = null;
        if (r102 == null) goto L7;
        IRoom r104 = r102.getRoom();
        if (r104 == null) goto L7;
        String r105 = r104.getOwnerUserIdString();
    L8:
        r101[0] = TuplesKt.to("anchor_id", String.valueOf(r105));
        k r106 = this.f157033a;
        if (r106 == null) goto L13;
        IRoom r107 = r106.getRoom();
        if (r107 == null) goto L13;
        r103 = Long.valueOf(r107.getRoomId());
    L13:
        r101[1] = TuplesKt.to("room_id", String.valueOf(r103));
        k r108 = this.f157033a;
        if (r108 == null) goto L19;
        IBaseUser r109 = r108.getUser();
        if (r109 == null) goto L19;
        String r110 = r109.getIdString();
        if (r110 == null) goto L19;
    L20:
        r101[2] = TuplesKt.to("user_id", r110);
        k r111 = this.f157033a;
        if (r111 != null) goto L23;
    L25:
        String r112 = "0";
    L26:
        r101[3] = TuplesKt.to(IPerformanceManager.Params.is_anchor, r112);
        int r113 = h.f157032a[r100.f157029e.ordinal()];
        if (r113 == 1) goto L36;
        if (r113 == 2) goto L35;
        if (r113 == 3) goto L34;
        if (r113 != 4) goto L33;
        String r114 = ShareAnswerType.BAN;
    L37:
        r101[4] = TuplesKt.to("rank_status", r114);
        r101[5] = TuplesKt.to("rank", String.valueOf(r100.f157028d));
        r101[6] = TuplesKt.to("rank_level1", r100.f157030f);
        r101[7] = TuplesKt.to("rank_level2", r100.f157031g);
        r101[8] = TuplesKt.to("source", "2");
        return MapsKt.mutableMapOf(r101);
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        r114 = TeaEventTrack.ACTION_DRAMA_NEXT;
        goto L37
    L35:
        r114 = Argument.OUT;
        goto L37
    L36:
        r114 = "in";
        goto L37
    L23:
        if (r111.isAnchor() != true) goto L25;
        r112 = "1";
    L19:
        r110 = "";
    L7:
        r105 = null;
        goto L8
    }

    public final void b(g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Map<String, String> r102 = a(r100);
        if (r101 == false) goto L5;
        String r103 = "cancel";
    L6:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r103);
        n r104 = new n();
        Map<String, String> r105 = r104.f516447a;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r105.putAll(r102);
        m r106 = new m();
        r106.b(LogCommon.ROOM);
        List<Object> r107 = r104.f516448b;
        ArrayList r108 = (ArrayList) r107;
        r108.addAll(r106.f516446a);
        cy0.e.f465759a.getClass();
        j r109 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r109).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((mz0.i) ((f80.a) r110)).w3("livesdk_anchor_hourly_rank_popup_click", r104.f516447a, r104.f516448b);
        return;
    L5:
        r103 = "off";
        goto L6
    }

    public final void c(g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Pair[] r102 = new Pair[6];
        k r103 = this.f157033a;
        Long r104 = null;
        if (r103 == null) goto L7;
        IRoom r105 = r103.getRoom();
        if (r105 == null) goto L7;
        String r106 = r105.getOwnerUserIdString();
    L8:
        r102[0] = TuplesKt.to("anchor_id", String.valueOf(r106));
        k r107 = this.f157033a;
        if (r107 == null) goto L13;
        IRoom r108 = r107.getRoom();
        if (r108 == null) goto L13;
        r104 = Long.valueOf(r108.getRoomId());
    L13:
        r102[1] = TuplesKt.to("room_id", String.valueOf(r104));
        if (r101 == false) goto L16;
        String r109 = "off";
    L17:
        r102[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r109);
        r102[3] = TuplesKt.to("rank", String.valueOf(r100.f157028d));
        r102[4] = TuplesKt.to("rank_level1", r100.f157030f);
        r102[5] = TuplesKt.to("rank_level2", r100.f157031g);
        Map<? extends String, ? extends String> r110 = MapsKt.mapOf(r102);
        n r111 = new n();
        Map<String, String> r112 = r111.f516447a;
        Intrinsics.checkNotNullParameter(r112, "map");
        Intrinsics.checkNotNullParameter(r110, "map");
        r112.putAll(r110);
        m r113 = new m();
        r113.b(LogCommon.ROOM);
        ((ArrayList) r111.f516448b).addAll(r113.f516446a);
        cy0.e.f465759a.getClass();
        j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r115);
        ((mz0.i) ((f80.a) r115)).w3("livesdk_anchor_ranklist_setting_banner_choice", r111.f516447a, r111.f516448b);
        return;
    L16:
        r109 = "on";
    L7:
        r106 = null;
        goto L8
    }
}
