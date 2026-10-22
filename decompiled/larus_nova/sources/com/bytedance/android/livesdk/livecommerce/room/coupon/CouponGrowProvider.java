package com.bytedance.android.livesdk.livecommerce.room.coupon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.event.j0;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEnterRequestData;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import vi2.v0;
import xi2.s;

/* JADX INFO: loaded from: classes10.dex */
public final class CouponGrowProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CouponGrowProvider f151730f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f151731g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f151732h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f151733i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f151734j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, Long> f151735k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f151736l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f151737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f151738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f151739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f151740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f151741e;

    public static final class Companion {

        public static final class a implements v0<s> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f151742a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0 f151743b;

            @Override // vi2.v0
            public final void onError(Throwable r100) {
                i.f48124a.e(ECAppInfoService.f48114e.getApplicationContext(), "网络异常，券领取失败", false, false);
                CouponGrowProvider.f151736l.getClass();
                Companion.a("ac-fail");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // vi2.v0
            public final void onSuccess(s r100) {
                s r101 = r100;
                boolean r102 = false;
                if (r101 == null) goto L14;
                ECEnterRequestData r103 = r101.a();
                if (r103 == null) goto L14;
                String r104 = r103.getToast();
                if (r104 == null) goto L14;
                HashMap<String, JSONObject> r105 = j.f44312a;
                if (j.e(r104) == true) goto L12;
                r104 = null;
            L12:
                if (r104 == null) goto L14;
                i.f48124a.e(ECAppInfoService.f48114e.getApplicationContext(), r104, false, false);
            L14:
                Companion r106 = CouponGrowProvider.f151736l;
                String r107 = (String) this.f151742a.element;
                r106.getClass();
                if (r107 != null) goto L29;
            L24:
                Function0 r108 = this.f151743b;
                if (r108 == null) goto L27;
                Unit r109 = (Unit) r108.invoke();
            L27:
                CouponGrowProvider.f151736l.getClass();
                Companion.a("ac-succ");
                return;
            L29:
            L22:
                th = move-exception;
                ECExceptionMonitor.e(th);
                goto L24
            L17:
                if (r107.length() <= 0) goto L19;
                r102 = true;
            L19:
                if (r102 == false) goto L24;
                q.f48131a.c(CouponGrowProvider.f151734j + r107, true);     // Catch: Throwable -> L22
                goto L24
            }

            public a(Ref.ObjectRef r100, Function0 r101) {
                this.f151742a = r100;
                this.f151743b = r101;
            }
        }

        public static final class b implements ih2.d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ih2.d f151744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f151745b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f151746c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f151747d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ PromotionListController f151748e;

            @Override // ih2.d.a
            public final void b() {
                j0 r100 = new j0("livesdk_coupon_expansion_task_click");
                HashMap r101 = new HashMap();
                r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "reject");
                r100.n(r101);
                r100.k();
                Companion.h(CouponGrowProvider.f151736l, this.f151745b, this.f151746c, this.f151747d, false, 24);
                ih2.d r102 = this.f151744a;
                r102.getClass();
                ih2.d.a(r102);     // Catch: Throwable -> L5
                return;
            }

            @Override // ih2.d.a
            public final void a(long r110) {
                CouponGrowProvider.f151736l.getClass();
                Companion.a("entogro");
                j0 r100 = new j0("livesdk_coupon_expansion_task_click");
                HashMap r101 = new HashMap();
                r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "accept");
                r100.n(r101);
                r100.k();
                CouponGrowProvider r102 = CouponGrowProvider.f151730f;
                Context r103 = this.f151745b;
                JSONObject r104 = this.f151746c;
                String r105 = this.f151747d;
                PromotionListController r111 = this.f151748e;
                r102.getClass();
                Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
                Intrinsics.checkNotNullParameter(r104, "ecomLiveParam");
                Intrinsics.checkNotNullParameter(r105, "roomId");
                Intrinsics.checkNotNullParameter(r111, "listController");
                if (r110 <= 0) goto L6;
                r102.f151739c = r105;
                long r106 = r110 * CouponGrowProvider.f151733i;
                long r112 = System.currentTimeMillis() + r106;
                CouponGrowProvider.f151735k.put(r105, Long.valueOf(r112));
                r102.f151741e = r104;
                r102.c(r103, r104, r105, r106, r111);
                r102.a(r103, r105, r104, r111);
            L6:
                i.f48124a.e(this.f151745b, "已接受券膨胀任务，计时开始～", false, false);
                ih2.d r113 = this.f151744a;
                r113.getClass();
                ih2.d.a(r113);     // Catch: Throwable -> L9
                return;
            }

            public b(ih2.d r100, Context r101, JSONObject r102, String r103, PromotionListController r104) {
                this.f151744a = r100;
                this.f151745b = r101;
                this.f151746c = r102;
                this.f151747d = r103;
                this.f151748e = r104;
            }
        }

        public static final class c implements DialogInterface.OnCancelListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f151749a = null;

            static {
                f151749a = new c();
            }

            public c() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface r100) {
                j0 r101 = new j0("livesdk_coupon_expansion_task_click");
                HashMap r102 = new HashMap();
                r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "cancel");
                r101.n(r102);
                r101.k();
            }
        }

        public static final class d implements ih2.h.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ih2.h f151750a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f151751b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f151752c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f151753d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Runnable f151754e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ PromotionListController f151755f;

            @Override // ih2.h.a
            public final void a() {
                j0 r100 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r101 = new HashMap();
                r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "keep");
                r100.n(r101);
                r100.k();
                ih2.h r102 = this.f151750a;
                r102.getClass();
                ih2.h.a(r102);     // Catch: Throwable -> L5
                return;
            }

            @Override // ih2.h.a
            public final void b() {
                j0 r100 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r101 = new HashMap();
                r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, NameKeys.LoadStrategy_Use);
                r100.n(r101);
                r100.k();
                ih2.h r102 = this.f151750a;
                r102.getClass();
                ih2.h.a(r102);     // Catch: Throwable -> L6
            L4:
                Companion r103 = CouponGrowProvider.f151736l;
                Context r104 = this.f151751b;
                JSONObject r105 = this.f151753d;
                String r106 = this.f151752c;
                PromotionListController r107 = this.f151755f;
                r103.getClass();
                Companion.f(r104, r105, r106, true, r107);
            }

            @Override // ih2.h.a
            public final void onDismiss() {
                int r100 = RoomContextController.f151593h;     // Catch: Throwable -> L6
                if (RoomContextController.a.a().M() == false) goto L9;
                Companion.h(CouponGrowProvider.f151736l, this.f151751b, this.f151753d, this.f151752c, true, 16);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            }

            @Override // ih2.h.a
            public final void onExitRoom() {
                j0 r100 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r101 = new HashMap();
                r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "sign_out");
                r100.n(r101);
                r100.k();
                ih2.h r102 = this.f151750a;
                r102.getClass();
                ih2.h.a(r102);     // Catch: Throwable -> L5
            L6:
                Runnable r103 = this.f151754e;
                if (r103 == null) goto L12;
                r103.run();
                return;
            }

            public d(ih2.h r100, Context r101, String r102, JSONObject r103, Runnable r104, PromotionListController r105) {
                this.f151750a = r100;
                this.f151751b = r101;
                this.f151752c = r102;
                this.f151753d = r103;
                this.f151754e = r104;
                this.f151755f = r105;
            }
        }

        public static final class e implements DialogInterface.OnCancelListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f151756a = null;

            static {
                f151756a = new e();
            }

            public e() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface r100) {
                j0 r101 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r102 = new HashMap();
                r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "cancel");
                r101.n(r102);
                r101.k();
            }
        }

        public static final class f implements zk.b {
            public f() {
            }

            @Override // zk.b
            public final String entryName() {
                return com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL;
            }

            @Override // zk.b
            public final String getCouponId() {
                return null;
            }
        }

        public Companion() {
        }

        public static void a(String r100) {
            dm.a.b r101 = dm.a.a("lqmt");
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r101.a(r100);
        }

        public static long b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Long r101 = (Long) ((LinkedHashMap) CouponGrowProvider.f151735k).get(r100);
            if (r101 == null) goto L9;
            long r102 = r101.longValue();
            if (r102 <= CouponGrowProvider.f151732h) goto L8;
            r102 = r102 - System.currentTimeMillis();
        L8:
            return r102 / CouponGrowProvider.f151733i;
        L9:
            return 0;
        }

        public static JSONObject c(JSONObject r100) {
            JSONArray r101 = r100.optJSONArray("incr_coupon");
            if (r101 == null) goto L11;
            int r102 = r101.length();
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L11;
            JSONObject r104 = r101.optJSONObject(r103);
            if (JSONObjectProtectorUtils.getInt(r104, com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE) == 1) goto L15;
            r103 = r103 + 1;
            goto L6
        L15:
            return r104;
        L11:
            return null;
        }

        public static boolean d(String r100) {
            if (r100 != null) goto L14;
        L13:
            return false;
        L14:
        L11:
            th = move-exception;
            ECExceptionMonitor.e(th);
            goto L13
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L13;
            return q.f48131a.getBoolean(CouponGrowProvider.f151734j + r100, false);
        L7:
            r101 = false;
            goto L8
        }

        public static boolean e(JSONObject r110) {
            if (r110 != null) goto L23;
        L21:
            return false;
        L23:
            int r100 = r110.optInt(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE);     // Catch: Throwable -> L22
            JSONArray r111 = r110.optJSONArray("incr_coupon");     // Catch: Throwable -> L22
            if (r111 != null) goto L8;
            return false;
        L8:
            if (r100 == CouponGrowProvider.f151731g) goto L10;
            return false;
        L10:
            int r101 = r111.length();     // Catch: Throwable -> L22
            int r102 = 0;
        L11:
            if (r102 >= r101) goto L21;
            JSONObject r103 = r111.optJSONObject(r102);     // Catch: Throwable -> L22
            if (Intrinsics.areEqual(r103.get(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE), 1) == false) goto L20;
            if (r103.optLong("task_time") <= 0) goto L20;
            if (r103.optLong("value") <= 0) goto L20;
            return true;
        L20:
            r102 = r102 + 1;
            goto L11
        }

        public static void k(Context r110, String r111, PromotionListController r112) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "roomId");
            Intrinsics.checkNotNullParameter(r112, "listController");
            int r100 = RoomContextController.f151593h;     // Catch: Exception -> L7
            if (Intrinsics.areEqual(RoomContextController.a.a().B(), r111) == false) goto L12;
            PromotionListController.a r101 = PromotionListController.T;     // Catch: Exception -> L7
            String r113 = r112.D();     // Catch: Exception -> L7
            r101.getClass();     // Catch: Exception -> L7
            PromotionListController.N(PromotionListController.a.c(r111, r113), r110, com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, new f(), null, false, null, null, null, 248);     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }

        public static void f(final Context r110, final JSONObject r111, final String r112, final boolean r113, final PromotionListController r114) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "ecomLiveParam");
            Intrinsics.checkNotNullParameter(r112, "roomId");
            Intrinsics.checkNotNullParameter(r114, "listController");
            int r100 = RoomContextController.f151593h;
            if (RoomContextController.a.a().M() == false) goto L6;
            g(r110, r111, r112, true, new CouponGrowProvider$Companion$processApplyCoupon$1(r113, r110, r112, r114));
            return;
        L6:
            if ((r110 instanceof Activity) == false) goto L10;
            r.f48132a.showLogin((Activity) r110, "live_detail", "livesdk_click_product", new CouponGrowProvider$Companion$processApplyCoupon$2(r110, r111, r112, r113, r114), CouponGrowProvider$Companion$processApplyCoupon$3.INSTANCE);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.String] */
        public static void g(Context r100, JSONObject r101, String r102, boolean r103, Function0 r110) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "roomId");
            if (r101 == null) goto L32;
            String r104 = r101.optString("host");     // Catch: Throwable -> L27
            HashMap<String, JSONObject> r105 = j.f44312a;     // Catch: Throwable -> L27
            LinkedHashMap r106 = null;
            if (j.e(r104) == true) goto L8;
            r104 = null;
        L8:
            if (r104 != null) goto L10;
            r104 = si2.g.f542149a;     // Catch: Throwable -> L27
        L10:
            String r107 = r101.optString("api");     // Catch: Throwable -> L27
            if (r107 != null) goto L13;
            return;
        L13:
            Ref.ObjectRef r108 = new Ref.ObjectRef();     // Catch: Throwable -> L27
            r108.element = "";     // Catch: Throwable -> L27
            JSONObject r109 = r101.optJSONObject("params");     // Catch: Throwable -> L27
            if (r109 == null) goto L21;
            r108.element = r109.optString("token");     // Catch: Throwable -> L27
            r106 = new LinkedHashMap();     // Catch: Throwable -> L27
            Iterator<String> r111 = r109.keys();     // Catch: Throwable -> L27
        L17:
            if (r111.hasNext() == false) goto L19;
            String r112 = r111.next();     // Catch: Throwable -> L27
            r106.put(r112, r109.optString(r112));     // Catch: Throwable -> L27
            goto L17
        L19:
            if (r103 == false) goto L21;
            JSONArray r113 = new JSONArray();     // Catch: Throwable -> L27
            r113.put(1);     // Catch: Throwable -> L27
            r106.put("completed_interaction_type", r113.toString());     // Catch: Throwable -> L27
        L21:
            Companion r114 = CouponGrowProvider.f151736l;     // Catch: Throwable -> L27
            String r115 = (String) r108.element;     // Catch: Throwable -> L27
            r114.getClass();     // Catch: Throwable -> L27
            if (d(r115) == false) goto L25;
            a("aplyed..");     // Catch: Throwable -> L27
            return;
        L25:
            CompositeDisposable r116 = CoreRequests.f151395a;     // Catch: Throwable -> L27
            CoreRequests.a("https://" + r104 + r107, r102, r106, new a(r108, r110));     // Catch: Throwable -> L27
            return;
        L27:
            th = move-exception;
            ECExceptionMonitor.e(th);
            return;
        }

        public static /* synthetic */ void h(Companion r100, Context r101, JSONObject r102, String r103, boolean r104, int r105) {
            if ((r105 & 8) == 0) goto L5;
            r104 = false;
        L5:
            r100.getClass();
            g(r101, r102, r103, r104, null);
        }

        public static ih2.d i(Context r110, boolean r111, Map r112, String r210, boolean r211, PromotionListController r212) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r112, "ecomParams");
            Intrinsics.checkNotNullParameter(r210, "roomId");
            Intrinsics.checkNotNullParameter(r212, "listController");
            a("enst");
            if (r111 == true) goto L6;
            a("en-" + r111);
            return null;
        L6:
            if (r211 == true) goto L9;
            a("ennofir");
            return null;
        L9:
            int r100 = RoomContextController.f151593h;
            if (RoomContextController.a.a().M() == true) goto L13;
            a("enunaut");
            return null;
        L13:
            HashMap<String, JSONObject> r101 = j.f44312a;
            JSONObject r102 = j.i((String) r112.get("enter_request"));
            CouponGrowProvider.f151736l.getClass();
            if (e(r102) == true) goto L17;
            a("ennogro");
            return null;
        L17:
            a("enprepup..");
            if (r102 == null) goto L35;
            JSONObject r103 = r102.optJSONObject("params");
            if (r103 == null) goto L35;
            if (d(r103.optString("token")) == false) goto L25;
            a("enaplyed");
            return null;
        L25:
            final ih2.d r104 = new ih2.d(r110);
            JSONObject r105 = c(r102);     // Catch: Throwable -> L36
            if (r105 == null) goto L33;
            JSONObject r106 = JSONObjectProtectorUtils.getJSONObject(r102, "params");     // Catch: Throwable -> L36
            long r107 = r106.optLong("coupon_amount");     // Catch: Throwable -> L36
            long r113 = r106.optLong("coupon_threshold");     // Catch: Throwable -> L36
            long r114 = r105.optLong("value");     // Catch: Throwable -> L36
            long r115 = r105.optLong("threshold");     // Catch: Throwable -> L36
            long r108 = r105.optLong("task_time");     // Catch: Throwable -> L36
            r104.f489784h = r108;     // Catch: Throwable -> L36
            long r116 = r114 + r107;     // Catch: Throwable -> L36
            r104.f489777a.setText(ih2.d.b(r108, r116));     // Catch: Throwable -> L36
            r104.f489779c.setText(String.valueOf(r107));     // Catch: Throwable -> L36
            r104.f489781e.setText(String.valueOf(r116));     // Catch: Throwable -> L36
            if (r106.optInt(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE) != 26) goto L32;
            r104.f489778b.setText(String.format("满%s可用", new Object[]{Long.valueOf(r113)}));     // Catch: Throwable -> L36
            r104.f489780d.setText(String.format("满%s可用", new Object[]{Long.valueOf(r113 + r115)}));     // Catch: Throwable -> L36
        L32:
            r104.f489782f.setText(String.format("直接领取%s元", new Object[]{Long.valueOf(r107)}));     // Catch: Throwable -> L36
        L33:
            r104.f489783g = new b(r104, r110, r102, r210, r212);
            r104.setOnCancelListener(c.f151749a);
            r104.setCanceledOnTouchOutside(true);
            r104.setCancelable(true);
            UtilityKotlinExtentionsKt.j(1000, new CouponGrowProvider$Companion$showEnterRoomCouponExpandDialog$1$3(r104), 2);
            return r104;
        L35:
            return null;
        }

        public static ih2.h j(Context r210, boolean r211, Map r212, String r213, PromotionListController r214, Runnable r215) {
            Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r212, "ecomParams");
            Intrinsics.checkNotNullParameter(r213, "roomId");
            Intrinsics.checkNotNullParameter(r214, "listController");
            a("etst");
            if (r211 == true) goto L6;
            a("et-" + r211);
            return null;
        L6:
            CouponGrowProvider.f151736l.getClass();
            if (b(r213) > 0) goto L10;
            a("et0");
            return null;
        L10:
            HashMap<String, JSONObject> r100 = j.f44312a;
            JSONObject r101 = j.i((String) r212.get("enter_request"));
            if (r101 != null) goto L13;
            r101 = CouponGrowProvider.f151730f.d(r213);
        L13:
            JSONObject r102 = r101;
            if (e(r102) == true) goto L17;
            a("etnogro");
            return null;
        L17:
            a("etprepup");
            if (r102 == null) goto L38;
            JSONObject r103 = r102.optJSONObject("params");
            if (r103 == null) goto L38;
            if (d(r103.optString("token")) == false) goto L25;
            a("etaplyed");
            return null;
        L25:
            final ih2.h r110 = new ih2.h(r210);
            r110.f489796i = r213;
            JSONObject r104 = c(r102);     // Catch: Exception -> L34
            if (r104 == null) goto L36;
            JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r102, "params");     // Catch: Exception -> L34
            long r111 = r105.optLong("coupon_amount");     // Catch: Exception -> L34
            long r112 = r105.optLong("coupon_threshold");     // Catch: Exception -> L34
            long r113 = r104.optLong("value");     // Catch: Exception -> L34
            long r114 = r104.optLong("threshold");     // Catch: Exception -> L34
            r110.f489795h = r113 + r111;     // Catch: Exception -> L34
            r110.f489788a.setText(r110.c(b(r213), r110.f489795h));     // Catch: Exception -> L34
            if (r105.optInt(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE) != 26) goto L32;
            r110.f489789b.setText(String.format("满%s可用", new Object[]{Long.valueOf(r112)}));     // Catch: Exception -> L34
            r110.f489791d.setText(String.format("满%s可用", new Object[]{Long.valueOf(r112 + r114)}));     // Catch: Exception -> L34
        L32:
            r110.f489790c.setText(String.valueOf(r111));     // Catch: Exception -> L34
            r110.f489792e.setText(String.valueOf(r110.f489795h));     // Catch: Exception -> L34
            r110.b();     // Catch: Exception -> L34
        L36:
            r110.f489794g = new d(r110, r210, r213, r102, r215, r214);
            r110.setCanceledOnTouchOutside(true);
            r110.setCancelable(true);
            r110.setOnCancelListener(e.f151756a);
            UtilityKotlinExtentionsKt.j(0, new CouponGrowProvider$Companion$showExitRoomCouponExpandDialog$1$3(r110), 3);
            return r110;
        L34:
            e = move-exception;
            ECExceptionMonitor.e(e);
        L38:
            return null;
        }
    }

    public interface a {
        void onFinish();

        void onTick(long r100);
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CouponGrowProvider f151757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f151758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f151759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f151760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PromotionListController f151761e;

        public b(CouponGrowProvider r100, String r101, Context r102, JSONObject r103, PromotionListController r104) {
            this.f151757a = r100;
            this.f151758b = r101;
            this.f151759c = r102;
            this.f151760d = r103;
            this.f151761e = r104;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L7;
            CouponGrowProvider.f151736l.getClass();
            Companion.a("bgd");
            this.f151757a.f(this.f151758b, false);
            return;
        L7:
            CouponGrowProvider.f151736l.getClass();
            Companion.a("fgd");
            this.f151757a.e(this.f151759c, this.f151758b, this.f151760d, false, this.f151761e);
        }
    }

    public static final class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CouponGrowProvider f151762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f151763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f151764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f151765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PromotionListController f151766e;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            CouponGrowProvider.f151736l.getClass();
            Companion.a("fin");
            if (this.f151762a.f151738b.containsKey(this.f151763b) == true) goto L5;
            Companion.f(this.f151764c, this.f151765d, this.f151763b, false, this.f151766e);
        L9:
            CouponGrowProvider.f151735k.remove(this.f151763b);
            this.f151762a.b();
            return;
        L5:
            Map<String, a> r100 = this.f151762a.f151738b;
            LinkedHashMap r101 = (LinkedHashMap) r100;
            a r102 = (a) r101.get(this.f151763b);
            if (r102 == null) goto L8;
            r102.onFinish();
        L8:
            this.f151762a.f151738b.remove(this.f151763b);
            goto L9
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            long r101 = r100 / CouponGrowProvider.f151733i;
            Map<String, a> r102 = this.f151762a.f151738b;
            LinkedHashMap r103 = (LinkedHashMap) r102;
            a r104 = (a) r103.get(this.f151763b);
            if (r104 == null) goto L6;
            r104.onTick(r101);
            return;
        }

        public c(CouponGrowProvider r100, String r101, Context r102, JSONObject r103, PromotionListController r104, long r105, long r106) {
            this.f151762a = r100;
            this.f151763b = r101;
            this.f151764c = r102;
            this.f151765d = r103;
            this.f151766e = r104;
            super(r105, r106);
        }
    }

    static {
        f151736l = new Companion();
        f151730f = new CouponGrowProvider();
        f151731g = 1;
        f151732h = 604800000;
        f151733i = 1000;
        f151734j = "COUPON_";
        f151735k = new LinkedHashMap();
    }

    public final void b() {
        c r100 = this.f151737a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f151737a = null;
        this.f151739c = "";
        this.f151741e = null;
        g();
    }

    public final void g() {
        b r100 = this.f151740d;     // Catch: Throwable -> L11
        if (r100 == null) goto L16;
        f151736l.getClass();     // Catch: Throwable -> L11
        Companion.a("rmob");     // Catch: Throwable -> L11
        int r101 = ECSdk.f48106a;     // Catch: Throwable -> L11
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        MutableLiveData<Boolean> r103 = r102.getAppEnterBackgroundOb();     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        r103.removeObserver(r100);     // Catch: Throwable -> L11
    L9:
        this.f151740d = null;     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }

    public CouponGrowProvider() {
        this.f151738b = new LinkedHashMap();
        this.f151739c = "";
    }

    public final JSONObject d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        if (this.f151739c.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(this.f151739c, r100) == true) goto L10;
        return null;
    L10:
        return this.f151741e;
    L5:
        r101 = false;
        goto L6
    }

    public final void f(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Map<String, Long> r102 = f151735k;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        Long r104 = (Long) r103.get(r100);
        if (r104 == null) goto L25;
        long r105 = r104.longValue();
        if (r105 >= f151732h) goto L7;
        return;
    L7:
        long r106 = System.currentTimeMillis();
        if (r106 <= r105) goto L10;
        r102.remove(r100);
    L11:
        Companion r107 = f151736l;
        String r108 = "et: " + ((Long) r103.get(r100));
        r107.getClass();
        Companion.a(r108);
        if (this.f151739c.length() <= 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == true) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(this.f151739c, r100) == false) goto L27;
        c r110 = this.f151737a;
        if (r110 == null) goto L21;
        r110.cancel();
    L21:
        this.f151737a = null;
        if (r101 == false) goto L28;
        g();
        return;
    L28:
        return;
    L27:
        return;
    L14:
        r109 = false;
        goto L15
    L10:
        r102.put(r100, Long.valueOf(r105 - r106));
        goto L11
    }

    public final void a(Context r100, String r110, JSONObject r111, PromotionListController r112) {
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L5;
        MutableLiveData<Boolean> r103 = r102.getAppEnterBackgroundOb();
    L6:
        g();
        this.f151740d = new b(this, r110, r100, r111, r112);
        f151736l.getClass();
        Companion.a("adob");
        if (r103 == null) goto L13;
        b r104 = this.f151740d;
        if (r104 == null) goto L12;
        r103.observeForever(r104);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.compat.nullable.Observer<kotlin.Boolean>");
    L13:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void c(Context r110, JSONObject r111, String r112, long r113, PromotionListController r114) {
        c r100 = this.f151737a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        c r115 = new c(this, r112, r110, r111, r114, r113, f151733i);
        this.f151737a = r115;
        r115.start();
    }

    public final void e(Context r110, String r111, JSONObject r112, boolean r113, PromotionListController r114) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "roomId");
        Intrinsics.checkNotNullParameter(r114, "listController");
        Map<String, Long> r100 = f151735k;
        Long r101 = (Long) ((LinkedHashMap) r100).get(r111);
        if (r101 == null) goto L26;
        long r102 = r101.longValue();
        if (r102 <= f151732h) goto L7;
        r102 = r102 - System.currentTimeMillis();
    L8:
        long r103 = r102;
        f151736l.getClass();
        Companion.a("en-" + r103);
        if (r112 != null) goto L11;
        JSONObject r115 = d(r111);
    L13:
        if (this.f151739c.length() <= 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(this.f151739c, r111) == false) goto L28;
        if (r115 != null) goto L21;
        return;
    L21:
        if (r103 <= 0) goto L30;
        c(r110, r115, r111, r103, r114);
        if (r113 == false) goto L31;
        a(r110, r111, r115, r114);
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L15:
        r104 = false;
        goto L16
    L11:
        r115 = r112;
        goto L13
    L7:
        r100.put(r111, Long.valueOf(System.currentTimeMillis() + r102));
        goto L8
    }
}
