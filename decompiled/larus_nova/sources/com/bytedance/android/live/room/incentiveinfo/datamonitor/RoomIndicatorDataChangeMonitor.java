package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/RoomIndicatorDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "Lcom/bytedance/android/live/base/model/message/a4;", "message", "", "update", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIndicatorDataChangeMonitor extends BaseItemDataChangeMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w81.a f99662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f99663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f99664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f99665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<Long, w81.a> f99666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<Long, Boolean> f99667m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<Long, w81.a> f99668n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<Long, Disposable> f99669o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<Long, Long> f99670p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return CollectionsKt.listOf("WebcastRoomIndicatorMessage");
    }

    private final void update(a4 r100) {
        Long r101 = r100.G();
        Disposable r102 = null;
        if (Intrinsics.areEqual(this.f99667m.get(r101), Boolean.TRUE) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L18;
        long r103 = r101.longValue();
        g(r100);
        Disposable r104 = this.f99669o.get(Long.valueOf(r103));
        if (r104 != null) goto L10;
    L14:
        w81.a r105 = this.f99666l.get(Long.valueOf(r103));
        if (r105 == null) goto L19;
        int r106 = w81.b.f558614e;
        f(w81.b.a.c(r105));
        return;
    L19:
        return;
    L10:
        if ((!r104.isDisposed()) == false) goto L12;
        r102 = r104;
    L12:
        if (r102 == null) goto L14;
        r102.dispose();
        goto L14
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof a4) == false) goto L138;
        a4 r111 = (a4) r110;
        Long r100 = r111.G();
        Disposable r101 = null;
        Disposable r102 = null;
        String r103 = null;
        if (r100 == null) goto L51;
        r100.longValue();
        w81.a r104 = this.f99666l.get(r111.G());
        if (r104 == null) goto L9;
        tlc.d r105 = r104.f558609a;
    L11:
        if ((r105 instanceof a4) == true) goto L13;
        r105 = null;
    L13:
        a4 r106 = (a4) r105;
        if (r106 == null) goto L16;
        Long r107 = r106.getStatus();
    L17:
        Long r108 = r111.getStatus();
        BizStatus r109 = BizStatus.NEW_ORDER;
        long r112 = r109.getValue();
        if (r108 == null) goto L51;
        if (r108.longValue() != r112) goto L51;
        long r113 = r109.getValue();
        if (r107 != null) goto L26;
    L27:
        w81.a r114 = this.f99668n.get(r111.G());
        if (r114 == null) goto L30;
        tlc.d r115 = r114.f558609a;
    L32:
        if ((r115 instanceof a4) == true) goto L34;
        r115 = null;
    L34:
        a4 r116 = (a4) r115;
        if (r116 == null) goto L37;
        Long r117 = r116.getStatus();
    L38:
        BizStatus r118 = BizStatus.UPDATE;
        long r119 = r118.getValue();
        if (r107 != null) goto L42;
    L43:
        long r120 = r118.getValue();
        if (r117 != null) goto L47;
    L48:
        w81.a r121 = this.f99666l.get(r111.G());
        if (r121 == null) goto L51;
        HashMap<Long, w81.a> r122 = this.f99668n;
        Long r123 = r111.G();
        Intrinsics.checkNotNull(r123);
        r122.put(r123, r121);
        goto L51
    L47:
        if (r117.longValue() == r120) goto L51;
    L42:
        if (r107.longValue() == r119) goto L48;
    L37:
        r117 = null;
        goto L38
    L30:
        r115 = null;
        goto L32
    L26:
        if (r107.longValue() == r113) goto L51;
    L16:
        r107 = null;
        goto L17
    L9:
        r105 = null;
    L51:
        Long r124 = r111.getStatus();
        long r125 = BizStatus.START.getValue();
        if (r124 != null) goto L55;
    L71:
        long r126 = BizStatus.UPDATE.getValue();
        if (r124 != null) goto L75;
    L77:
        long r127 = BizStatus.END.getValue();
        if (r124 != null) goto L81;
    L114:
        long r128 = BizStatus.NEW_ORDER.getValue();
        if (r124 != null) goto L118;
        return;
    L118:
        if (r124.longValue() != r128) goto L144;
        Long r129 = r111.G();
        if (Intrinsics.areEqual(this.f99667m.get(r129), Boolean.TRUE) == true) goto L123;
        r129 = null;
    L123:
        if (r129 == null) goto L145;
        long r130 = r129.longValue();
        g(r111);
        Disposable r131 = this.f99669o.get(Long.valueOf(r130));
        if (r131 != null) goto L127;
    L131:
        w81.a r132 = this.f99666l.get(Long.valueOf(r130));
        if (r132 == null) goto L134;
        int r133 = w81.b.f558614e;
        f(w81.b.a.a(r132));
    L134:
        w81.a r134 = this.f99668n.get(Long.valueOf(r130));
        if (r134 == null) goto L146;
        int r135 = w81.b.f558614e;
        f(w81.b.a.c(r134));
        return;
    L146:
        return;
    L127:
        if ((!r131.isDisposed()) == false) goto L129;
        r101 = r131;
    L129:
        if (r101 == null) goto L131;
        r101.dispose();
        goto L131
    L145:
        return;
    L144:
        return;
    L81:
        if (r124.longValue() != r127) goto L114;
        Long r136 = r111.G();
        if (Intrinsics.areEqual(this.f99667m.get(r136), Boolean.TRUE) == true) goto L86;
        r136 = null;
    L86:
        if (r136 == null) goto L99;
        long r137 = r136.longValue();
        g(r111);
        w81.a r138 = this.f99666l.get(Long.valueOf(r137));
        if (r138 == null) goto L90;
        int r139 = w81.b.f558614e;
        f(w81.b.a.a(r138));
    L90:
        this.f99667m.put(Long.valueOf(r137), Boolean.FALSE);
        Disposable r140 = this.f99669o.get(Long.valueOf(r137));
        if (r140 != null) goto L93;
    L98:
        HashMap<Long, Disposable> r141 = this.f99669o;
        Long r142 = Long.valueOf(r137);
        Disposable r143 = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r137, this));
        c(r143);
        r141.put(r142, r143);
        goto L99
    L93:
        if ((!r140.isDisposed()) == true) goto L96;
        r140 = null;
    L96:
        if (r140 == null) goto L98;
        r140.dispose();
    L99:
        HashMap r144 = new HashMap();
        Long r145 = this.f99670p.get(r111.G());
        if (r145 == null) goto L102;
        long r146 = r145.longValue();
    L104:
        if (r146 <= 0) goto L106;
        String r147 = String.valueOf(System.currentTimeMillis() - r146);
    L107:
        r144.put("duration", r147);
        if (r111.G() == null) goto L110;
        HashMap<Long, Long> r148 = this.f99670p;
        Long r149 = r111.G();
        Intrinsics.checkNotNull(r149);
        r148.put(r149, -1L);
    L110:
        r144.put("biz_type", String.valueOf(r111.G()));
        int r150 = x81.c.f562885a;
        DataCenter r151 = this.f99644e;
        mm2.b r152 = r111.E();
        if (r152 == null) goto L113;
        r103 = r152.extra;
    L113:
        x81.c.a("livesdk_new_anchor_support_plan_exit", r151, r103, r144);
        return;
    L106:
        r147 = "-1";
        goto L107
    L102:
        r146 = -1;
        goto L104
    L75:
        if (r124.longValue() != r126) goto L77;
        update(r111);
        return;
    L55:
        if (r124.longValue() != r125) goto L71;
        Long r153 = r111.G();
        Boolean r154 = this.f99667m.get(r153);
        Boolean r155 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r154, r155)) == true) goto L60;
        r153 = null;
    L60:
        if (r153 == null) goto L139;
        long r156 = r153.longValue();
        g(r111);
        Disposable r157 = this.f99669o.get(Long.valueOf(r156));
        if (r157 != null) goto L64;
    L68:
        this.f99667m.put(Long.valueOf(r156), r155);
        this.f99670p.put(Long.valueOf(r156), Long.valueOf(System.currentTimeMillis()));
        w81.a r158 = this.f99666l.get(Long.valueOf(r156));
        if (r158 == null) goto L140;
        int r159 = w81.b.f558614e;
        f(w81.b.a.a(r158));
        return;
    L140:
        return;
    L64:
        if ((!r157.isDisposed()) == false) goto L66;
        r102 = r157;
    L66:
        if (r102 == null) goto L68;
        r102.dispose();
        goto L68
    L139:
        return;
    }

    public final void g(a4 r100) {
        Long r101 = r100.G();
        if (r101 == null) goto L6;
        HashMap<Long, w81.a> r102 = this.f99666l;
        w81.a r103 = new w81.a(CarouselTabType.ROOM_INDICATOR);
        r103.f558609a = r100;
        r103.f558612d = Integer.valueOf((int) r101.longValue());
        Unit r104 = Unit.INSTANCE;
        r102.put(r101, r103);
        return;
    }

    public RoomIndicatorDataChangeMonitor(DataCenter r100, IRoom r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        super(r100, r101, r102);
        this.f99662h = new w81.a(CarouselTabType.ROOM_INDICATOR);
        this.f99663i = LazyKt.lazy(new RoomIndicatorDataChangeMonitor$addParams$2(this));
        this.f99664j = LazyKt.lazy(new RoomIndicatorDataChangeMonitor$removeParams$2(this));
        this.f99665k = LazyKt.lazy(new RoomIndicatorDataChangeMonitor$updateParams$2(this));
        this.f99666l = new HashMap();
        this.f99667m = new HashMap();
        this.f99668n = new HashMap();
        this.f99669o = new HashMap();
        this.f99670p = new HashMap();
    }
}
