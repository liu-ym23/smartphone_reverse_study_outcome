package com.bytedance.android.live.profit.profitCheck;

import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.profit.privilege.model.ReportType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.kmp.util.e;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfitCheckServiceImpl implements com.bytedance.android.live.profit.privilege.c, o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f88458h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.profit.profitCheck.c> f88459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f88460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<Function0<Unit>> f88461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f88462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f88463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.b f88464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l01.d f88465g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f88466a = null;

        static {
            f88466a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Function0) r100).invoke();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f88467a = null;

        static {
            f88467a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = x8.a.f562881a;
            int r102 = ProfitCheckServiceImpl.f88458h;
            x8.a.b("ProfitCheckServiceImpl", "report error" + ((Throwable) r100).getMessage(), false);
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(this.f88461c.toFlowable(BackpressureStrategy.BUFFER).observeOn(Schedulers.io()).subscribe(b.f88466a, c.f88467a), this.f88462d);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((CopyOnWriteArrayList) this.f88459a).clear();
        this.f88462d.clear();
        this.f88460b.removeCallbacksAndMessages(null);
    }

    public static Map f(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("consume_time", Long.valueOf(e.b()));
        String r102 = (String) r100.get(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID);
        if (r102 == null) goto L5;
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r102);
    L5:
        return r101;
    }

    public final Map<String, String> g(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        IRoom r102 = this.f88464f.getRoom();
        String r103 = "0";
        if (r102 == null) goto L6;
        String r104 = r102.getOwnerUserIdString();
        if (r104 == null) goto L6;
    L7:
        r101.put("anchor_id", r104);
        r101.put("user_id", this.f88465g.getCurrentUserId());
        IRoom r105 = this.f88464f.getRoom();
        if (r105 == null) goto L13;
        String r106 = String.valueOf(r105.getId());
        if (r106 == null) goto L13;
        r103 = r106;
    L13:
        r101.put("room_id", r103);
        r101.putAll(r100);
        return r101;
    L6:
        r104 = "0";
        goto L7
    }

    public ProfitCheckServiceImpl(com.bytedance.android.livesdk.revenue.service.room.b r100, l01.d r101) {
        Intrinsics.checkNotNullParameter(r100, "roomService");
        Intrinsics.checkNotNullParameter(r101, "userService");
        this.f88464f = r100;
        this.f88465g = r101;
        this.f88459a = new CopyOnWriteArrayList();
        this.f88460b = new Handler(Looper.getMainLooper());
        this.f88461c = PublishSubject.create();
        this.f88462d = new CompositeDisposable();
        this.f88463e = new ReentrantLock(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7, types: [org.json.JSONObject] */
    public static void h(com.bytedance.android.live.profit.profitCheck.c r100, Map r101) {
        j01.e r102 = new j01.e(r100.getType().f88478a, "default");
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "metaBuilder");
        Intrinsics.checkNotNullParameter(r104, "category");
        Intrinsics.checkNotNullParameter(r105, "metric");
        Intrinsics.checkNotNullParameter(r103, "extra");
        String r106 = r100.f88476d.get("anchor_id");
        if (r106 == null) goto L5;
        r102.a(r106);
    L5:
        String r107 = r100.f88476d.get("user_id");
        if (r107 == null) goto L8;
        r102.i(r107);
    L8:
        String r108 = r100.f88476d.get("room_id");
        if (r108 == null) goto L11;
        r102.e(r108);
    L11:
        String r109 = r100.f88476d.get(BindCardPayConfirmConstants.Key.TRACE_ID);
        if (r109 == null) goto L14;
        r102.h(r109);
    L14:
        String r110 = r100.f88476d.get("log_id");
        if (r110 == null) goto L17;
        r102.c(r110);
    L17:
        r102.b(r100.f88477e);
        r102.d(ProductId.REVENUE_PROFIT_CHECK);
        Intrinsics.checkNotNullParameter(r103, "json");
        Iterator r111 = r101.entrySet().iterator();
    L19:
        if (r111.hasNext() == false) goto L31;
        Map.Entry r112 = (Map.Entry) r111.next();
        String r113 = (String) r112.getKey();
        ?? r114 = r112.getValue();
        if ((r114 instanceof Map) == true) goto L23;
        ?? r115 = 0;
    L24:
        Map r116 = (Map) r115;
        if (r116 == null) goto L30;
        r114 = new JSONObject();
        Iterator r117 = r116.entrySet().iterator();
    L28:
        if (r117.hasNext() == false) goto L30;
        Map.Entry r118 = (Map.Entry) r117.next();
        Object r119 = r118.getKey();
        Object r120 = r118.getValue();
        d60.b.a(r114, String.valueOf(r119), r120);
    L30:
        Intrinsics.checkNotNullParameter(r113, "key");
        Intrinsics.checkNotNullParameter(r114, "value");
        j01.d.b(r103, r113, r114);
        goto L19
    L23:
        r115 = r114;
        goto L24
    L31:
        ((j01.b) f.a(j01.b.class)).R4(r102.f496788a, r104, r105, r103);
    }

    @Override // com.bytedance.android.live.profit.privilege.c
    public final void w(final Map r100, final ProfitCheckConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        Intrinsics.checkNotNullParameter(r101, "profitCheckConfigArg");
        if (r101.getNeedReport() == true) goto L5;
        return;
    L5:
        Function0<Unit> r102 = new ProfitCheckServiceImpl$createProfitCheckTasks$1(this, r101, r100);
        this.f88461c.onNext(r102);
    }

    @Override // com.bytedance.android.live.profit.privilege.c
    public final void B1(final ProfitCheckType r100, final Map<String, ? extends Object> r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "data");
        if (r100.getLocalReport() == false) goto L9;
        d r101 = new d(r100.getTypeName(), r100.getIndex());
        ReportType.Companion.getClass();
        ReportType r102 = ReportType.a.a(0);
        Map<String, String> r103 = g(new LinkedHashMap());
        if (r111 == null) goto L7;
        r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, r111);
    L7:
        Unit r104 = Unit.INSTANCE;
        h(new com.bytedance.android.live.profit.profitCheck.c(r101, r102, Long.MAX_VALUE, r103, f(new LinkedHashMap())), r110);
        return;
    L9:
        Function0<Unit> r105 = new ProfitCheckServiceImpl$collectReportTask$1(this, r100, r111, r110);
        this.f88461c.onNext(r105);
    }

    public static final void a(ProfitCheckServiceImpl r100, com.bytedance.android.live.profit.profitCheck.c r101, Map r102, long r103) {
        r100.getClass();
        long r104 = e.b();
        IRoom r105 = r100.f88464f.getRoom();
        if (r105 == null) goto L5;
        String r106 = String.valueOf(r105.getId());
    L6:
        String r107 = r100.f88465g.getCurrentUserId();
        if (r101.f88475c >= r104) goto L9;
    L13:
        boolean r108 = false;
    L14:
        if (r108 == false) goto L17;
        Map<String, Object> r109 = r101.f88477e;
        r109.put("collect_time", Long.valueOf(e.b()));
        r109.put("report_time", Long.valueOf(e.b()));
        r109.put(BdpAppEventConstant.PARAMS_UNIQUEID, Long.valueOf(r103));
        h(r101, r102);
        return;
    L17:
        return;
    L9:
        if (Intrinsics.areEqual(r101.f88476d.get("room_id"), r106) == false) goto L13;
        if (Intrinsics.areEqual(r101.f88476d.get("user_id"), r107) == false) goto L13;
        r108 = true;
        goto L14
    L5:
        r106 = null;
        goto L6
    }
}
