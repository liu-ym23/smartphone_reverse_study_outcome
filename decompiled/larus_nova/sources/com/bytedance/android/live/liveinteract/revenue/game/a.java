package com.bytedance.android.live.liveinteract.revenue.game;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f78312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f78313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f78314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ne0.c f78315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f78316e;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.game.a$a, reason: collision with other inner class name */
    public static final class C1218a {
    }

    static {
    }

    public final String b() {
        Long r100 = this.f78314c;
        oi0.a.C7057a r101 = oi0.a.f523343a;
        r101.getClass();
        if (r100 != null) goto L6;
    L8:
        r101.getClass();
        if (r100 != null) goto L12;
    L14:
        return null;
    L12:
        if (r100.longValue() != 1) goto L14;
        return "seat_expand";
    L6:
        if (r100.longValue() != 2) goto L8;
        return "seat_collapse";
    }

    public final boolean c() {
        ne0.g r100 = this.f78315d.a();
        if (r100 == null) goto L5;
        int r101 = ti0.e.f545994a;
        Boolean r102 = (Boolean) r100.a("danmu_game_is_on");
    L7:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L5:
        r102 = null;
        goto L7
    }

    public final void a(boolean r110) {
        long r100 = 0;
        long r101 = 0L;
        String r102 = "";
        if (c() == true) goto L59;
        if (r110 == false) goto L59;
        if (this.f78316e == true) goto L68;
        ALogger.d("DanmuGameController", "startObserveMicSeatStatus");
        this.f78314c = 0L;
        e r103 = this.f78312a;
        if (r103 == null) goto L51;
        long r104 = r103.f78329h;
        long r111 = 15;
        if (r104 != r111) goto L51;
        int r105 = r103.f78330i;
        long r106 = 1;
        if (r105 != 0) goto L14;
        Room r107 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        String r112 = null;
        if (r107 == null) goto L24;
        z5 r108 = r107.getLinkerDetail();
        if (r108 == null) goto L24;
        Integer r109 = Integer.valueOf(r108.getUiLayout());
    L25:
        Room r113 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r113 == null) goto L30;
        z5 r114 = r113.getLinkerDetail();
        if (r114 == null) goto L30;
        r112 = r114.getClientUiInfo();
    L30:
        if (r109 != null) goto L33;
    L41:
        this.f78314c = r101;
    L42:
        LinkMicRoomDataSyncModel r115 = LinkWRDSHelper.b();
        if (r115 == null) goto L51;
        dc2.c<IRoomLinkMicSyncData> r116 = r115.getTalkRoomListUserInfoPb();
        if (r116 == null) goto L51;
        Observable<IRoomLinkMicSyncData> r117 = r116.f467852d;
        if (r117 == null) goto L51;
        Disposable r118 = r117.subscribe(new b(this));
        if (r118 == null) goto L51;
        RxUtilKt.c(r118, this.f78313b);
        goto L51
    L33:
        if (r109.intValue() != 15) goto L41;
        r100 = JSONObjectProtectorUtils.getLong(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r112), "video_chat_dynamic_1v7"), "Status");     // Catch: Exception -> L36
    L37:
        oi0.a.f523343a.getClass();
        if (r100 != 2) goto L40;
        r106 = 2;
    L40:
        r101 = Long.valueOf(r106);
    L36:
        ALogger.e("DanmuGameController", "startObserveMicSeatStatus, parse clientUiInfo failed");
    L24:
        r109 = null;
        goto L25
    L14:
        if (r105 != 1) goto L42;
        if (r104 != r111) goto L18;
        oi0.a.f523343a.getClass();
        r101 = 1L;
    L18:
        this.f78314c = r101;
    L51:
        ALogger.i("DanmuGameController", "danmu game start: " + this.f78312a);
        LinkedHashMap r119 = new LinkedHashMap();
        e r120 = this.f78312a;
        if (r120 == null) goto L57;
        String r121 = r120.f78323b;
        if (r121 == null) goto L57;
        r102 = r121;
    L57:
        r119.put("game_id", r102);
        TalkRoomLogUtils.O(b(), 31, r119, false, 17);
        String r122 = qi0.a.f533075a;
        qi0.a.f533082h = System.currentTimeMillis();
    L68:
        ne0.c r123 = this.f78315d;
        int r124 = ti0.e.f545994a;
        r123.b("danmu_game_is_on", Boolean.valueOf(r110));
        return;
    L59:
        if (c() == false) goto L68;
        if (r110 == true) goto L68;
        ALogger.i("DanmuGameController", "danmu game end: " + this.f78312a);
        LinkedHashMap r125 = new LinkedHashMap();
        e r126 = this.f78312a;
        if (r126 == null) goto L67;
        String r127 = r126.f78323b;
        if (r127 == null) goto L67;
        r102 = r127;
    L67:
        r125.put("game_id", r102);
        TalkRoomLogUtils.N(b(), 31, r125, 0, 17);
        String r128 = qi0.c.f533088b;
        qi0.c.m(this.f78312a);
        ALogger.d("DanmuGameController", "stopObserveMicSeatStatus");
        this.f78314c = 0L;
        this.f78313b.clear();
        goto L68
    }

    public a(Context r100, ne0.c r101, DataCenter r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mStore");
        Intrinsics.checkNotNullParameter(r102, "mDataCenter");
        this.f78315d = r101;
        this.f78316e = r103;
        this.f78313b = new CompositeDisposable();
        this.f78314c = 0L;
    }
}
