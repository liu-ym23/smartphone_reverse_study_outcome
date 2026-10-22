package com.bytedance.android.live.room.discovery.drawer.processor;

import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class MoreLiveMarqueeProcessorContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f99446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f99447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f99448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f99449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f99450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f99451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f99452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f99453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f99454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f99455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f99456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.live.base.model.moreliveentrance.b f99457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LiveEntranceStatus f99458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super com.bytedance.android.live.base.model.moreliveentrance.b, Unit> f99459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f99460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RoomContext f99461q;

    public final boolean a() {
        return ((Boolean) this.f99454j.getValue()).booleanValue();
    }

    public MoreLiveMarqueeProcessorContext(RoomContext r100, DataCenter r101) {
        this.f99461q = r100;
        String r102 = "";
        this.f99451g = "";
        String r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.hashCode());
    L6:
        this.f99452h = r104;
        this.f99453i = SystemClock.elapsedRealtime();
        this.f99454j = LazyKt.lazy(MoreLiveMarqueeProcessorContext$useNewShowStrategy$2.INSTANCE);
        this.f99455k = LazyKt.lazy(MoreLiveMarqueeProcessorContext$maxTimeServerConfig$2.INSTANCE);
        this.f99458n = LiveEntranceStatus.NOT_DISPLAYED;
        if (r100 == null) goto L11;
        n<String> r105 = r100.getSourceEnterFromMerge();
        if (r105 == null) goto L11;
        String r106 = r105.getValue();
    L12:
        this.f99445a = r106;
        if (r100 == null) goto L17;
        n<String> r107 = r100.getSourceEnterMethod();
        if (r107 == null) goto L17;
        String r108 = r107.getValue();
    L18:
        this.f99446b = r108;
        boolean r109 = false;
        if (r100 == null) goto L25;
        i<Boolean> r110 = r100.isFromLiveTab();
        if (r110 == null) goto L25;
        Boolean r111 = r110.getValue();
        if (r111 == null) goto L25;
        boolean r112 = r111.booleanValue();
    L26:
        this.f99447c = r112;
        if (r100 == null) goto L33;
        m<Room> r113 = r100.getRoom();
        if (r113 == null) goto L33;
        Room r114 = r113.getValue();
        if (r114 == null) goto L33;
        long r115 = r114.getRoomId();
    L34:
        this.f99450f = r115;
        if (r100 == null) goto L44;
        m<Room> r116 = r100.getRoom();
        if (r116 == null) goto L44;
        Room r117 = r116.getValue();
        if (r117 == null) goto L44;
        String r118 = r117.getAnchorId();
        if (r118 == null) goto L44;
        r102 = r118;
    L44:
        this.f99451g = r102;
        if (r100 == null) goto L51;
        i<Boolean> r119 = r100.isFirstEnterRoom();
        if (r119 == null) goto L51;
        Boolean r120 = r119.getValue();
        if (r120 == null) goto L51;
        r109 = r120.booleanValue();
    L51:
        this.f99448d = r109;
        if (r101 != null) goto L64;
    L57:
        HashMap r121 = null;
    L58:
        if (r121 == null) goto L61;
        r103 = (String) r121.get("float_view_enter_room_business_tag");
    L61:
        if (Intrinsics.areEqual(r103, "more_live") == false) goto L66;
        this.f99449e = true;
        return;
    L66:
        return;
    L64:
        r121 = (HashMap) r101.get("data_room_business_extra", null);     // Catch: Exception -> L55
    L55:
        e = move-exception;
        d.a("getBusinessExtraMap error" + e.getMessage());
    L33:
        r115 = 0;
    L25:
        r112 = false;
    L17:
        r108 = null;
    L11:
        r106 = null;
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
