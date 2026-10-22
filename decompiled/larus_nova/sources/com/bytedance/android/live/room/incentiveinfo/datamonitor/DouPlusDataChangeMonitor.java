package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.s0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.x;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/DouPlusDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DouPlusDataChangeMonitor extends BaseItemDataChangeMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f99647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w81.a f99648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f99649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f99650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f99651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f99652m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DouPlusDataChangeMonitor f99653a;

        public b(DouPlusDataChangeMonitor r100) {
            this.f99653a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            DouPlusDataChangeMonitor r102 = this.f99653a;
            r102.f((w81.b) r102.f99651l.getValue());
            this.f99653a.f99643d = false;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor, u81.h
    public final void a() {
        super.a();
        c(xs2.b.a().b(x.class).subscribe(new c(this)));
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return this.f99647h;
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof s0) == false) goto L42;
        this.f99648i.f558609a = r100;
        Disposable r101 = this.f99649j;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        s0 r102 = (s0) r100;
        Long r103 = r102.getStatus();
        if (r103 == null) goto L10;
        long r104 = r103.longValue();
    L12:
        switch(((int) r104)) {
            case 1: goto L38;
            case 2: goto L34;
            case 3: goto L18;
            case 4: goto L38;
            case 5: goto L14;
            case 6: goto L14;
            default: goto L49;
        };
    L14:
        String r105 = r102.getToast();
        if (r105 == null) goto L43;
        String r106 = rm3.c.f538539a;
        rm3.c.g(getContext(), r105, 0, false, 28);
        return;
    L43:
        return;
    L49:
        return;
    L18:
        if (this.f99643d == false) goto L45;
        f((w81.b) this.f99650k.getValue());
        tlc.d r107 = this.f99648i.f558609a;
        tlc.d r108 = null;
        if ((r107 instanceof s0) == true) goto L22;
        r107 = null;
    L22:
        s0 r109 = (s0) r107;
        if (r109 == null) goto L25;
        r109.setStatus(1L);
    L25:
        tlc.d r110 = this.f99648i.f558609a;
        if ((r110 instanceof s0) == false) goto L29;
        r108 = r110;
    L29:
        s0 r111 = (s0) r108;
        if (r111 == null) goto L32;
        r111.setBuyerNickname("");
    L32:
        f((w81.b) this.f99652m.getValue());
        return;
    L45:
        return;
    L34:
        if (this.f99643d == true) goto L36;
        return;
    L36:
        f((w81.b) this.f99650k.getValue());
        this.f99649j = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        return;
    L38:
        if (this.f99643d == true) goto L40;
        this.f99643d = true;
        f((w81.b) this.f99650k.getValue());
        return;
    L40:
        f((w81.b) this.f99652m.getValue());
        return;
    L10:
        r104 = 0;
        goto L12
    }

    public DouPlusDataChangeMonitor(DataCenter r100, IRoom r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        super(r100, r101, r102);
        this.f99647h = CollectionsKt.listOf("WebcastDouplusIndicatorMessage");
        this.f99648i = new w81.a(CarouselTabType.DOU_PLUS);
        this.f99650k = LazyKt.lazy(new DouPlusDataChangeMonitor$addParams$2(this));
        this.f99651l = LazyKt.lazy(new DouPlusDataChangeMonitor$removeParams$2(this));
        this.f99652m = LazyKt.lazy(new DouPlusDataChangeMonitor$updateParams$2(this));
    }
}
