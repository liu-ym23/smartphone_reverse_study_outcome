package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.ec.model.response.IconShowStrategy;
import com.bytedance.android.ec.model.response.LocalIconState;
import com.bytedance.android.ec.model.response.TimeLimitScope;
import com.bytedance.android.ec.model.response.r;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.t0;
import com.bytedance.android.livesdk.livecommerce.event.v0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes10.dex */
public final class EnterRequestHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f151767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LocalEnterRoomInfoState f151768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile r f151769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IconItem f151770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f151771e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnterRequestHandler f151772f = null;

    public static final class a implements j {
        public a() {
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            dm.a.a("EnterRequestHandler").i("receive event, params = " + r100);
            Lazy r101 = EnterRequestHandler.f151767a;
            String r102 = r100.optString("limit_key");
            boolean r103 = r100.optBoolean("is_single_room");
            long r104 = r100.optLong("expired_timestamp");
            r r105 = EnterRequestHandler.f151769c;
            if (r105 == null) goto L21;
            com.bytedance.android.ec.model.response.e r106 = r105.b();
            if (r106 == null) goto L21;
            List<IconItem> r107 = r106.a();
            if (r107 == null) goto L21;
            Iterator<T> r108 = r107.iterator();
        L10:
            if (r108.hasNext() == false) goto L21;
            LocalIconState r109 = ((IconItem) r108.next()).getLocalIconState();
            if (r109 == null) goto L10;
            if (Intrinsics.areEqual(r109.getLimitKey(), r102) == true) goto L17;
            r109 = null;
        L17:
            if (r109 == null) goto L10;
            if (r103 == true) goto L19;
            r109.setSkipTimestamp(r104);
            goto L10
        L19:
            r109.setCurRoomSkipTimestamp(r104);
        L21:
            EnterRequestHandler.l(EnterRequestHandler.f151768b);
        }
    }

    public EnterRequestHandler() {
    }

    static {
        f151772f = new EnterRequestHandler();
        f151767a = LazyKt.lazy(EnterRequestHandler$KEY_LOCAL_STATE_SP_NAME$2.INSTANCE);
        f151771e = LazyKt.lazy(EnterRequestHandler$calendar$2.INSTANCE);
        ECLiveHybridUtil.m("ecom.event.cart.cancel_anim", new a());
    }

    public static final LocalEnterRoomInfoState c() {
        EnterRequestHandler r100 = f151772f;
        monitor-enter(r100);
        LocalEnterRoomInfoState r101 = f151768b;     // Catch: Throwable -> L15
        if (r101 == null) goto L18;
    L10:
        if (r101 != null) goto L12;
        r101 = new LocalEnterRoomInfoState();     // Catch: Throwable -> L15
    L12:
        f151768b = r101;     // Catch: Throwable -> L15
        monitor-exit(r100);
        return r101;
    L18:
        r101 = (LocalEnterRoomInfoState) u0.b(q.f48131a.getString((String) f151767a.getValue(), ""), LocalEnterRoomInfoState.class);     // Catch: Exception -> L8 Throwable -> L15
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L15
        r101 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public static void e() {
        r r100 = f151769c;
        if (r100 == null) goto L12;
        com.bytedance.android.ec.model.response.e r101 = r100.b();
        if (r101 == null) goto L12;
        List<IconItem> r102 = r101.a();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        IconItem r104 = (IconItem) r103.next();
        UtilityKotlinExtentionsKt.f(r104.getLocalIconState(), r104.getShowStrategy(), EnterRequestHandler$clickCart$1$1.INSTANCE);
    L12:
        l(f151768b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "should use consumeCartIconV2() instead")
    public static String f() {
        IconItem r100 = f151770d;
        if (r100 != null) goto L5;
    L11:
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        r r102 = f151769c;
        if (r102 == null) goto L22;
        com.bytedance.android.ec.model.response.e r103 = r102.b();
        if (r103 == null) goto L22;
        List<IconItem> r104 = r103.a();
        if (r104 == null) goto L22;
        Iterator<T> r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L22;
        final IconItem r106 = (IconItem) r105.next();
        UtilityKotlinExtentionsKt.f(r106.getLocalIconState(), r106.getShowStrategy(), new EnterRequestHandler$consumeCartIcon$$inlined$apply$lambda$1(r106, r101));
        if (cg4.a.a((String) r101.element) == false) goto L19;
    L22:
        l(f151768b);
        return (String) r101.element;
    L5:
        if (cg4.a.a(r100.getAnimatedIcon()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        f151770d = null;
        m(r100);
        return r100.getAnimatedIcon();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IconItem g() {
        EnterRequestHandler$consumeCartIconV2$1 r100 = EnterRequestHandler$consumeCartIconV2$1.INSTANCE;
        IconItem r101 = f151770d;
        if (r101 != null) goto L5;
    L11:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        r r103 = f151769c;
        if (r103 == null) goto L22;
        com.bytedance.android.ec.model.response.e r104 = r103.b();
        if (r104 == null) goto L22;
        List<IconItem> r105 = r104.a();
        if (r105 == null) goto L22;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L22;
        final IconItem r107 = (IconItem) r106.next();
        UtilityKotlinExtentionsKt.f(r107.getLocalIconState(), r107.getShowStrategy(), new EnterRequestHandler$consumeCartIconV2$$inlined$apply$lambda$1(r107, r102));
        if (EnterRequestHandler$consumeCartIconV2$1.INSTANCE.invoke2((IconItem) r102.element) == false) goto L19;
    L22:
        l(f151768b);
        return (IconItem) r102.element;
    L5:
        if (EnterRequestHandler$consumeCartIconV2$1.INSTANCE.invoke2(r101) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        f151770d = null;
        m(r101);
        return r101;
    }

    public static JSONObject h() {
        LocalEnterRoomInfoState r100 = f151768b;
        JSONObject r101 = null;
        if (r100 == null) goto L37;
        Map<String, LocalIconState> r102 = r100.getIconMap();
        if (r102 == null) goto L37;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, LocalIconState>> r104 = r102.entrySet().iterator();
    L7:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L20;
        Map.Entry<String, LocalIconState> r106 = r104.next();
        if (r106 == null) goto L16;
        LocalIconState r107 = r106.getValue();
        if (r107 == null) goto L16;
        if (r107.isOutOfTimes() != true) goto L16;
    L17:
        if (r105 == false) goto L7;
        r103.put(r106.getKey(), r106.getValue());
    L16:
        r105 = false;
        goto L17
    L20:
        if ((!r103.isEmpty()) == true) goto L23;
        r103 = null;
    L23:
        if (r103 == null) goto L37;
        r101 = new JSONObject();
        JSONArray r108 = new JSONArray();
        Iterator r109 = r103.entrySet().iterator();
    L26:
        if (r109.hasNext() == false) goto L38;
        Map.Entry r110 = (Map.Entry) r109.next();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L30
        Result.m9449constructorimpl(r108.put(new JSONObject().put(SpeechEngineDefines.PARAMS_KEY_BUSINESS_KEY_STRING, ((LocalIconState) r110.getValue()).getBusinessKey()).put("icon_key", ((LocalIconState) r110.getValue()).getIconKey())));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L38:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L34
        Object r114 = Result.m9449constructorimpl(r101.put("limited_cart_icons", r108));     // Catch: Throwable -> L34
    L36:
        Result.m9448boximpl(r114);
    L34:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L37:
        return r101;
    }

    public static final void a(LocalEnterRoomInfoState r100) {
        long r101 = System.currentTimeMillis() / ((long) 1000);
        Map<String, LocalIconState> r102 = r100.getIconMap();
        if (r102 == null) goto L13;
        Iterator<Map.Entry<String, LocalIconState>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L21;
        Map.Entry<String, LocalIconState> r104 = r103.next();
        if (r101 <= r104.getValue().getExpiredTimestamp()) goto L12;
        if (r101 <= r104.getValue().getSkipTimestamp()) goto L12;
        r103.remove();
    L12:
        r104.getValue().setCurRoomTimes(0);
        r104.getValue().setCurRoomSkipTimestamp(0);
        goto L6
    L21:
        return;
    }

    public static final void d(LocalEnterRoomInfoState r100) {
        if (r100 == null) goto L5;
        q.f48131a.putString((String) f151767a.getValue(), u0.d(r100));
        return;
    }

    public static long k(TimeLimitScope r100) {
        if (r100 == null) goto L4;
        Long r101 = r100.getPeriod();
    L5:
        if (r101 == null) goto L11;
        r101.longValue();
        long r102 = System.currentTimeMillis() / ((long) 1000);
        if (r100.isNaturalTime() == false) goto L9;
        Lazy r103 = f151771e;
        ((Calendar) r103.getValue()).setTimeInMillis(r102);
        int r104 = ((Calendar) r103.getValue()).get(11);
        int r105 = ((Calendar) r103.getValue()).get(12);
        int r106 = ((r104 * 60) + r105) * 60;
        r102 = r102 - ((long) (r106 + ((Calendar) r103.getValue()).get(13)));
        long r107 = r101.longValue();
    L13:
        return r102 + r107;
    L9:
        r107 = r101.longValue();
        goto L13
    L11:
        return 0;
    L4:
        r101 = null;
        goto L5
    }

    public static void l(final LocalEnterRoomInfoState r100) {
        UtilityKotlinExtentionsKt.i(new EnterRequestHandler$setLocalStateAsync$1(r100));
    }

    public static void m(IconItem r100) {
        t0 r101 = new t0("livesdk_coupon_effect_show");
        String r102 = r100.getBusinessKey();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.f(SpeechEngineDefines.PARAMS_KEY_BUSINESS_KEY_STRING, r102);
        String r104 = r100.getIconKey();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101.f("icon_key", r104);
        r101.k();
        v0 r105 = new v0("live_coupon_effect_show");
        r105.o();
        Pair[] r106 = new Pair[3];
        Map<String, String> r107 = r100.getReportParams();
        if (r107 == null) goto L12;
        String r108 = r107.get("anchor_id");
        if (r108 == null) goto L12;
    L13:
        r106[0] = TuplesKt.to("anchor_id", r108);
        Map<String, String> r109 = r100.getReportParams();
        if (r109 == null) goto L17;
        String r110 = r109.get("room_id");
        if (r110 == null) goto L17;
    L18:
        r106[1] = TuplesKt.to("room_id", r110);
        String r111 = r100.getAnimatedIcon();
        if (r111 != null) goto L21;
        r111 = "";
    L21:
        r106[2] = TuplesKt.to("image_url", r111);
        r105.n(MapsKt.mapOf(r106));
        Map<String, String> r112 = r100.getReportParams();
        if (r112 == null) goto L25;
        String r113 = r112.get("creative_id");
        if (r113 == null) goto L25;
    L26:
        Intrinsics.checkNotNullParameter(r113, "creativeId");
        r105.f("value", r113);
        Map<String, String> r114 = r100.getReportParams();
        if (r114 == null) goto L32;
        String r115 = r114.get("log_extra");
        if (r115 == null) goto L32;
        r103 = r115;
    L32:
        Intrinsics.checkNotNullParameter(r103, "logExtra");
        r105.f("log_extra", r103);
        r105.k();
        return;
    L25:
        r113 = "";
    L17:
        r110 = "";
    L12:
        r108 = "";
        goto L13
    }

    public static void i(final r r100, final com.bytedance.android.ec.adapter.api.state.a r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "roomState");
        f151769c = null;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SHOPPING_CART_NEW().booleanValue() == false) goto L6;
        UtilityKotlinExtentionsKt.i(EnterRequestHandler$handleResponse$1.INSTANCE);
    L6:
        if (r100.a() == null) goto L8;
    L10:
        UtilityKotlinExtentionsKt.i(new EnterRequestHandler$handleResponse$2(r100, r101));
        return;
    L8:
        if (r100.b() != null) goto L10;
    }

    public static void j(final r r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "reportParams");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SHOPPING_CART_NEW().booleanValue() == true) goto L5;
        return;
    L5:
        com.bytedance.android.ec.model.response.e r102 = r100.b();
        if (r102 == null) goto L12;
        final List<IconItem> r103 = r102.a();
        if (r103 == null) goto L13;
        UtilityKotlinExtentionsKt.i(new EnterRequestHandler$handleSupplementResponse$1(r100, r101, r103));
        return;
    L13:
        return;
    }

    public static final void b(LocalEnterRoomInfoState r100, r r101, Map r102) {
        EnterRequestHandler r103 = f151772f;
        monitor-enter(r103);
        com.bytedance.android.ec.model.response.e r104 = r101.b();     // Catch: Throwable -> L50
        if (r104 == null) goto L48;
        List<IconItem> r105 = r104.a();     // Catch: Throwable -> L50
        if (r105 == null) goto L48;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L50
    L9:
        if (r106.hasNext() == false) goto L48;
        IconItem r107 = (IconItem) r106.next();     // Catch: Throwable -> L50
        Map<String, LocalIconState> r108 = r100.getIconMap();     // Catch: Throwable -> L50
        String r109 = null;
        if (r108 == null) goto L18;
        IconShowStrategy r110 = r107.getShowStrategy();     // Catch: Throwable -> L50
        if (r110 == null) goto L16;
        String r111 = r110.getLimitKey();     // Catch: Throwable -> L50
    L17:
        LocalIconState r112 = r108.get(r111);     // Catch: Throwable -> L50
    L19:
        IconShowStrategy r113 = r107.getShowStrategy();     // Catch: Throwable -> L50
        if (r113 == null) goto L22;
        String r114 = r113.getLimitKey();     // Catch: Throwable -> L50
    L24:
        if (cg4.a.a(r114) == false) goto L46;
        if (r112 != null) goto L45;
        r112 = new LocalIconState();     // Catch: Throwable -> L50
        IconShowStrategy r115 = r107.getShowStrategy();     // Catch: Throwable -> L50
        if (r115 == null) goto L29;
        TimeLimitScope r116 = r115.getTimesLimitScope();     // Catch: Throwable -> L50
    L30:
        r112.setExpiredTimestamp(k(r116));     // Catch: Throwable -> L50
        IconShowStrategy r117 = r107.getShowStrategy();     // Catch: Throwable -> L50
        if (r117 == null) goto L33;
        String r118 = r117.getLimitKey();     // Catch: Throwable -> L50
    L34:
        r112.setLimitKey(r118);     // Catch: Throwable -> L50
        if (r100.getIconMap() != null) goto L37;
        r100.setIconMap(new LinkedHashMap());     // Catch: Throwable -> L50
    L37:
        Map<String, LocalIconState> r119 = r100.getIconMap();     // Catch: Throwable -> L50
        if (r119 == null) goto L45;
        IconShowStrategy r120 = r107.getShowStrategy();     // Catch: Throwable -> L50
        if (r120 == null) goto L42;
        r109 = r120.getLimitKey();     // Catch: Throwable -> L50
    L42:
        if (r109 != null) goto L44;
        r109 = "";
    L44:
        LocalIconState r121 = r119.put(r109, r112);     // Catch: Throwable -> L50
        goto L45
    L33:
        r118 = null;
        goto L34
    L29:
        r116 = null;
    L45:
        r112.setBusinessKey(r107.getBusinessKey());     // Catch: Throwable -> L50
        r112.setIconKey(r107.getIconKey());     // Catch: Throwable -> L50
        r107.setLocalIconState(r112);     // Catch: Throwable -> L50
    L46:
        r107.setReportParams(r102);     // Catch: Throwable -> L50
        goto L9
    L22:
        r114 = null;
        goto L24
    L16:
        r111 = null;
        goto L17
    L18:
        r112 = null;
    L48:
        monitor-exit(r103);
        return;
    L50:
        th = move-exception;
        throw th;
    }
}
