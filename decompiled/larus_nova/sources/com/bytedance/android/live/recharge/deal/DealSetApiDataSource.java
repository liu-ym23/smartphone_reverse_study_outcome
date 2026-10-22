package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class DealSetApiDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f89686a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f89687a = null;

        public a() {
        }

        static {
            f89687a = new a();
        }

        @Override // com.bytedance.android.live.recharge.deal.DealSetApiDataSource.b
        public final void a(m r100) {
            Intrinsics.checkNotNullParameter(r100, "requestParams");
            Map<String, String> r101 = r100.f89721a;
            HashMap r102 = (HashMap) r101;
            r102.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, String.valueOf(r100.f89724d.getValue()));
            r102.put("need_recharge_price", String.valueOf(r100.f89723c));
            r102.put("fetch_diamond_list_from", String.valueOf(r100.f89725e.getValue()));
        }
    }

    public interface b {
        void a(m r100);
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f89688a;

        public c(long r100) {
            this.f89688a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.live.kmp.util.c r101 = com.bytedance.live.kmp.util.c.f255167a;
            long r102 = System.currentTimeMillis() - this.f89688a;
            com.bytedance.android.live.recharge.utils.o.a(true, r102, null);
            jy0.b.d("Recharge/DealSetApiDataSource", "request finished in " + r102 + " ms");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f89689a;

        public d(long r100) {
            this.f89689a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            com.bytedance.live.kmp.util.c r102 = com.bytedance.live.kmp.util.c.f255167a;
            long r103 = System.currentTimeMillis() - this.f89689a;
            int r104 = com.bytedance.android.live.recharge.utils.o.f90493a;
            new LinkedHashMap();
            com.bytedance.android.live.recharge.utils.o.a(false, r103, r101);
            jy0.b.c("Recharge/DealSetApiDataSource", "request failed in " + r103 + " ms: " + r101, null, 4);
        }
    }

    public DealSetApiDataSource() {
    }

    static {
        f89686a = new ArrayList();
        b(a.f89687a);
        b(cw0.b.f465561a);
        b(cw0.c.f465562a);
    }

    public static void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        f89686a.add(r100);
    }

    public static String c(m r100) {
        return "lackingMoney = " + r100.f89723c + ", entrance = " + r100.f89724d + ", fetchFrom = " + r100.f89725e;
    }

    public static Single d(final m r100) {
        Intrinsics.checkNotNullParameter(r100, "requestParams");
        jy0.b.a("Recharge/DealSetApiDataSource", "requestDealSetRawData, " + c(r100));
        return e(new DealSetApiDataSource$requestDealSetRawData$1(r100));
    }

    public static Single e(Function0 r100) {
        com.bytedance.live.kmp.util.c r101 = com.bytedance.live.kmp.util.c.f255167a;
        long r102 = System.currentTimeMillis();
        Single r103 = (Single) r100.invoke();
        int r104 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        return r103.observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new c(r102)).doOnError(new d(r102));
    }

    public static final Single a(Map r110, Map r111) {
        JSONObject r100 = new JSONObject();
        Iterator r112 = ((HashMap) r111).entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r112.next();
        r100.put((String) r101.getKey(), r101.getValue());
        goto L4
    L6:
        tz0.b r113 = tz0.b.f548039a;
        uz0.c r102 = new uz0.c();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r102, "$this$beforeConfigureRequest");
        Iterator r114 = ((HashMap) r110).entrySet().iterator();
    L8:
        if (r114.hasNext() == false) goto L10;
        Map.Entry r115 = (Map.Entry) r114.next();
        r102.query((String) r115.getKey(), (String) r115.getValue());
        goto L8
    L10:
        r102.query("extra", r100.toString());
        x.a(r102, false);
        r102.a(new zw0.b());
        Intrinsics.checkNotNullParameter(r102, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/diamond/", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(IChargeDeal.class)))), com.bytedance.android.live.recharge.model.diamond.a.class, r102.f552163d, r102.f552160a, r102.f552161b, r102.f552162c).singleOrError();
    }
}
