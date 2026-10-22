package com.bytedance.android.live.soloktv.view;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.soloktv.api.SoloMvApi;
import com.bytedance.android.livesdk.message.model.KtvTypetv;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f101841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f101842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f101843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f101844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<od> f101845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f101846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f101847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f101848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<ArrayList<od>, Unit> f101849i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f101850a;

        public a(o r100) {
            this.f101850a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            ALogger.i("requestRemoteMvList", "logid:" + r101.logId);
            o r102 = this.f101850a;
            boolean r103 = false;
            r102.f101846f = false;
            com.bytedance.android.live.soloktv.model.b r104 = (com.bytedance.android.live.soloktv.model.b) r101.data;
            Integer r105 = null;
            if (r102.getType() != KtvTypetv.KTVMVType_PERSONAL.ordinal()) goto L5;
            o r106 = this.f101850a;
            r106.f101841a = null;
            r106.f101842b = r104.b();
        L6:
            this.f101850a.f101843c = r104.a();
            o r107 = this.f101850a;
            if (r107.f101845e != null) goto L9;
            r107.f101845e = new ArrayList();
        L9:
            List<od> r108 = r104.d();
            o r109 = this.f101850a;
            if (r109.f101848h == null) goto L31;
            ArrayList<od> r110 = r109.f101845e;
            if (r110 == null) goto L31;
            if ((!r110.isEmpty()) != true) goto L31;
            if (r108 == null) goto L31;
            Iterator<od> r111 = r108.iterator();
            int r112 = 0;
        L18:
            if (r111.hasNext() == false) goto L23;
            if (Intrinsics.areEqual(r111.next().f(), this.f101850a.f101848h) == true) goto L24;
            r112 = r112 + 1;
        L24:
            Integer r113 = Integer.valueOf(r112);
            if (r113.intValue() <= (-1)) goto L27;
            r103 = true;
        L27:
            if (r103 == false) goto L29;
            r105 = r113;
        L29:
            if (r105 == null) goto L31;
            od r114 = (od) ListProtector.remove(r108, r105.intValue());
            goto L31
        L23:
            r112 = -1;
        L31:
            if (r108 == null) goto L35;
            ArrayList<od> r115 = this.f101850a.f101845e;
            if (r115 == null) goto L35;
            r115.addAll(r108);
        L35:
            o r116 = this.f101850a;
            r116.f101849i.invoke(r116.f101845e);
            return;
        L5:
            this.f101850a.f101841a = Long.valueOf(r104.c());
            this.f101850a.f101842b = r104.b();
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f101851a;

        public b(o r100) {
            this.f101851a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            o r102 = this.f101851a;
            r102.f101846f = false;
            r102.f101849i.invoke(null);
            ALogger.i("MvControlTabWrapper", "getMVList error");
        }
    }

    public final void a() {
        if (this.f101843c == true) goto L5;
    L16:
        com.bytedance.android.live.ktv.common.util.g.f("requestRemoteMvList error. hasmore is false." + this.f101846f);
        return;
    L5:
        if (this.f101846f == true) goto L16;
        Disposable r100 = this.f101844d;
        if (r100 == null) goto L11;
        r100.dispose();
    L11:
        if (this.f101842b != 0) goto L13;
        String r101 = this.f101848h;
    L14:
        this.f101846f = true;
        this.f101844d = ((SoloMvApi) com.bytedance.android.live.network.c.b().e(SoloMvApi.class)).getKaraokeBgMVList(this.f101841a, this.f101842b, this.f101847g, r101, 18).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        return;
    L13:
        r101 = null;
        goto L14
    }

    public final int getType() {
        return this.f101847g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(int r100, String r101, Function1<? super ArrayList<od>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "dataUpdateCb");
        this.f101847g = r100;
        this.f101848h = r101;
        this.f101849i = r102;
        this.f101841a = 0L;
        this.f101843c = true;
    }
}
