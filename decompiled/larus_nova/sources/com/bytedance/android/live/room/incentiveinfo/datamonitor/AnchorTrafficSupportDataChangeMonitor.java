package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.m5;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdk.config.setting.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/AnchorTrafficSupportDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorTrafficSupportDataChangeMonitor extends BaseItemDataChangeMonitor {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f99629o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w81.a f99630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<Long, w81.a> f99631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f99632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f99633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f99634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<Long, Boolean> f99635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<Long, Disposable> f99636n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f99637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnchorTrafficSupportDataChangeMonitor f99638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ tlc.d f99639c;

        public b(long r100, AnchorTrafficSupportDataChangeMonitor r101, tlc.d r102) {
            this.f99637a = r100;
            this.f99638b = r101;
            this.f99639c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            ((m5) this.f99639c).setStatus(Long.valueOf(2));
            w81.a r102 = this.f99638b.f99631i.get(Long.valueOf(this.f99637a));
            if (r102 == null) goto L5;
            r102.f558609a = this.f99639c;
        L5:
            AnchorTrafficSupportDataChangeMonitor r103 = this.f99638b;
            int r104 = w81.b.f558614e;
            w81.a r105 = r103.f99631i.get(Long.valueOf(this.f99637a));
            if (r105 != null) goto L8;
            r105 = this.f99638b.f99630h;
        L8:
            r103.f(w81.b.a.a(r105));
            HashMap<Long, Disposable> r106 = this.f99638b.f99636n;
            Long r107 = Long.valueOf(this.f99637a);
            AnchorTrafficSupportDataChangeMonitor r108 = this.f99638b;
            Disposable r109 = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.room.incentiveinfo.datamonitor.b(this));
            r108.c(r109);
            r106.put(r107, r109);
        }
    }

    static {
        int r100 = j.f121211a;
        f99629o = LiveInfraSettingKeys.LIVE_FLOW_STIMULATE_CONFIG.getValue().messageWaitTime;
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return CollectionsKt.listOf("WebcastTrafficSceneMessage");
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof m5) == false) goto L48;
        m5 r101 = (m5) r100;
        Long r102 = r101.getMType();
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
        HashMap<Long, w81.a> r104 = this.f99631i;
        Long r105 = Long.valueOf(r103);
        w81.a r106 = new w81.a(CarouselTabType.ANCHOR_TRAFFIC_SUPPORT);
        r106.f558609a = r100;
        r106.f558611c = r101.getIcon();
        r106.f558612d = Integer.valueOf((int) r103);
        Unit r107 = Unit.INSTANCE;
        w81.a r108 = r104.put(r105, r106);
    L7:
        Disposable r109 = this.f99636n.get(r101.getMType());
        if (r109 == null) goto L11;
        r109.dispose();
    L11:
        if (Intrinsics.areEqual(r101.isKeep(), Boolean.TRUE) == false) goto L41;
        Long r110 = r101.getStatus();
        if (r110 == null) goto L15;
        Integer r111 = Integer.valueOf((int) r110.longValue());
    L16:
        if (r111 != null) goto L19;
    L21:
        if (r111 != null) goto L24;
        return;
    L24:
        if (r111.intValue() != 2) goto L50;
        Long r112 = r101.getMType();
        if (r112 == null) goto L51;
        long r113 = r112.longValue();
        HashMap<Long, Boolean> r114 = this.f99635m;
        Long r115 = Long.valueOf(r113);
        Boolean r116 = r114.get(r115);
        if (r116 != null) goto L31;
        r116 = Boolean.FALSE;
        r114.put(r115, r116);
    L31:
        if (r116.booleanValue() == false) goto L55;
        int r117 = w81.b.f558614e;
        w81.a r118 = this.f99631i.get(Long.valueOf(r113));
        if (r118 != null) goto L36;
        r118 = this.f99630h;
    L36:
        f(w81.b.a.a(r118));
        HashMap<Long, Disposable> r119 = this.f99636n;
        Long r120 = r101.getMType();
        if (r120 == null) goto L39;
        long r121 = r120.longValue();
    L40:
        Long r122 = Long.valueOf(r121);
        Disposable r123 = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.room.incentiveinfo.datamonitor.a(r113, this, r101));
        c(r123);
        r119.put(r122, r123);
        return;
    L39:
        r121 = 0;
        goto L40
    L55:
        return;
    L51:
        return;
    L50:
        return;
    L19:
        if (r111.intValue() != 1) goto L21;
        g(r101);
        return;
    L15:
        r111 = null;
        goto L16
    L41:
        Long r124 = r101.getMType();
        if (r124 == null) goto L53;
        long r125 = r124.longValue();
        r101.setStatus(1L);
        w81.a r126 = this.f99631i.get(Long.valueOf(r125));
        if (r126 == null) goto L46;
        r126.f558609a = r100;
    L46:
        g(r101);
        HashMap<Long, Disposable> r127 = this.f99636n;
        Long r128 = Long.valueOf(r125);
        Disposable r129 = Observable.just("").delay(f99629o, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r125, this, r100));
        c(r129);
        r127.put(r128, r129);
        return;
    L53:
        return;
    }

    public final void g(m5 r100) {
        Long r101 = r100.getMType();
        if (r101 == null) goto L18;
        long r102 = r101.longValue();
        HashMap<Long, Boolean> r103 = this.f99635m;
        Long r104 = Long.valueOf(r102);
        Boolean r105 = r103.get(r104);
        if (r105 != null) goto L8;
        r105 = Boolean.FALSE;
        r103.put(r104, r105);
    L8:
        if (r105.booleanValue() == true) goto L13;
        this.f99635m.put(Long.valueOf(r102), Boolean.TRUE);
        int r106 = w81.b.f558614e;
        w81.a r107 = this.f99631i.get(Long.valueOf(r102));
        if (r107 != null) goto L12;
        r107 = this.f99630h;
    L12:
        f(w81.b.a.a(r107));
        return;
    L13:
        int r108 = w81.b.f558614e;
        w81.a r109 = this.f99631i.get(Long.valueOf(r102));
        if (r109 != null) goto L16;
        r109 = this.f99630h;
    L16:
        f(w81.b.a.c(r109));
        return;
    }

    public AnchorTrafficSupportDataChangeMonitor(DataCenter r100, IRoom r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        super(r100, r101, r102);
        this.f99630h = new w81.a(CarouselTabType.ANCHOR_TRAFFIC_SUPPORT);
        this.f99631i = new HashMap();
        this.f99632j = LazyKt.lazy(new AnchorTrafficSupportDataChangeMonitor$addParams$2(this));
        this.f99633k = LazyKt.lazy(new AnchorTrafficSupportDataChangeMonitor$removeParams$2(this));
        this.f99634l = LazyKt.lazy(new AnchorTrafficSupportDataChangeMonitor$updateParams$2(this));
        this.f99635m = new HashMap();
        this.f99636n = new HashMap();
    }
}
