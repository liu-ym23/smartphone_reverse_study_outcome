package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements bq1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f117734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Float> f117735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f117736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f117737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f117738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f117739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m<Boolean> f117740g;

    public final Map<String, Float> e() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("scale", Float.valueOf(this.f117739f.getScaleX())), TuplesKt.to(LiveDegradeFpsAnimator.TRANSLATION_X, Float.valueOf(this.f117739f.getTranslationX())), TuplesKt.to(LiveDegradeFpsAnimator.TRANSLATION_Y, Float.valueOf(this.f117739f.getTranslationY()))});
    }

    @Override // bq1.a
    public final boolean a(MotionEvent r110, Function1<? super MotionEvent, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, CloudControlInf.SP);
        if (r110.getAction() != 0) goto L6;
        this.f117735b = e();
        return r111.invoke(r110).booleanValue();
    L6:
        float r100 = 1.0f;
        if (r110.getAction() != 1) goto L9;
    L39:
        boolean r112 = r111.invoke(r110).booleanValue();
        Map<String, Float> r113 = e();
        Float r101 = this.f117735b.get("scale");
        if (r101 == null) goto L42;
        float r102 = r101.floatValue();
    L44:
        if (r102 < 1.0f) goto L86;
        Float r103 = r113.get("scale");
        if (r103 == null) goto L48;
        float r104 = r103.floatValue();
    L50:
        if (r104 < 1.0f) goto L86;
        if (Intrinsics.areEqual(this.f117735b.get("scale"), 1.0f) == false) goto L58;
        if (Intrinsics.areEqual(r113.get("scale"), 1.0f) == false) goto L58;
        return r112;
    L58:
        if ((!Intrinsics.areEqual(r113.get("scale"), this.f117735b.get("scale"))) == false) goto L71;
        if (Intrinsics.areEqual(r113.get("scale"), 1.0f) == false) goto L62;
        g("finger", this.f117735b);
        goto L86
    L62:
        Map<String, Float> r105 = this.f117735b;
        DataCenter r106 = this.f117738e;
        Pair[] r107 = new Pair[1];
        Float r108 = r113.get("scale");
        if (r108 == null) goto L65;
        float r109 = r108.floatValue();
    L66:
        r107[0] = TuplesKt.to("enlarge_ratio", String.valueOf(Math.abs(r109)));
        Map r114 = MapsKt.mutableMapOf(r107);
        r114.putAll(this.f117734a);
        Unit r115 = Unit.INSTANCE;
        h(r106, "livesdk_vs_enlarge", r114);
        if ((!Intrinsics.areEqual(r105.get("scale"), 1.0f)) == false) goto L69;
        f(r105, r113);
        goto L86
    L69:
        this.f117737d = Long.valueOf(System.currentTimeMillis());
        goto L86
    L65:
        r109 = 1.0f;
        goto L66
    L71:
        if ((!Intrinsics.areEqual(r113.get(LiveDegradeFpsAnimator.TRANSLATION_X), this.f117735b.get(LiveDegradeFpsAnimator.TRANSLATION_X))) == false) goto L73;
    L74:
        Map<String, Float> r116 = this.f117735b;
        Map<String, Float> r117 = d(r116, r113);
        DataCenter r118 = this.f117738e;
        Pair[] r119 = new Pair[3];
        Float r120 = r113.get("scale");
        if (r120 == null) goto L77;
        r100 = r120.floatValue();
    L77:
        r119[0] = TuplesKt.to("enlarge_ratio", String.valueOf(Math.abs(r100)));
        Float r121 = r117.get("x");
        if (r121 == null) goto L80;
        Number r122 = new BigDecimal(String.valueOf(r121.floatValue()));
    L81:
        r119[1] = TuplesKt.to("move_distance_x", r122.toString());
        Float r123 = r117.get("y");
        if (r123 == null) goto L84;
        Number r124 = new BigDecimal(String.valueOf(r123.floatValue()));
    L85:
        r119[2] = TuplesKt.to("move_distance_y", r124.toString());
        Map r125 = MapsKt.mutableMapOf(r119);
        r125.putAll(this.f117734a);
        Unit r126 = Unit.INSTANCE;
        h(r118, "livesdk_vs_enlarge_move", r125);
        f(r116, r113);
        goto L86
    L84:
        r124 = Float.valueOf(0.0f);
        goto L85
    L80:
        r122 = Float.valueOf(0.0f);
        goto L81
    L73:
        if ((!Intrinsics.areEqual(r113.get(LiveDegradeFpsAnimator.TRANSLATION_Y), this.f117735b.get(LiveDegradeFpsAnimator.TRANSLATION_Y))) == false) goto L86;
    L48:
        r104 = 1.0f;
    L86:
        return r112;
    L42:
        r102 = 1.0f;
        goto L44
    L9:
        if (r110.getAction() == 3) goto L39;
        boolean r127 = r111.invoke(r110).booleanValue();
        Map<String, Float> r128 = e();
        Float r129 = this.f117735b.get("scale");
        if (r129 == null) goto L14;
        float r130 = r129.floatValue();
    L16:
        if (r130 < 1.0f) goto L38;
        Float r131 = r128.get("scale");
        if (r131 == null) goto L20;
        float r132 = r131.floatValue();
    L22:
        if (r132 < 1.0f) goto L38;
        Float r133 = this.f117735b.get("scale");
        if (r133 == null) goto L27;
        float r134 = r133.floatValue();
    L29:
        if (r134 != 1.0f) goto L31;
        return r127;
    L31:
        Float r135 = r128.get("scale");
        if (r135 == null) goto L34;
        float r136 = r135.floatValue();
    L36:
        if (r136 != 1.0f) goto L38;
        g("finger", this.f117735b);
        this.f117736c = this.f117735b.hashCode();
        goto L38
    L34:
        r136 = 1.0f;
        goto L36
    L27:
        r134 = 1.0f;
        goto L29
    L20:
        r132 = 1.0f;
    L38:
        return r127;
    L14:
        r130 = 1.0f;
        goto L16
    }

    @Override // bq1.a
    public final void b(boolean r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.SP);
        m<Boolean> r102 = this.f117740g;
        if (r102 == null) goto L6;
        r102.setValue(Boolean.valueOf(r100));
        return;
    }

    @Override // bq1.a
    public final boolean c(String r100, Function1<? super String, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "resetType");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.SP);
        Map<String, Float> r102 = e();
        boolean r103 = r101.invoke(r100).booleanValue();
        if (r103 == true) goto L6;
        return false;
    L6:
        g(r100, r102);
        return r103;
    }

    public final Map<String, Float> d(Map<String, Float> r110, Map<String, Float> r111) {
        Float r100 = r110.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        float r101 = 0.0f;
        Float r102 = Float.valueOf(0.0f);
        if (r100 == null) goto L5;
        float r103 = r100.floatValue();
    L6:
        Float r104 = r110.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        if (r104 == null) goto L9;
        float r105 = r104.floatValue();
    L10:
        Float r112 = r110.get("scale");
        float r106 = 1.0f;
        if (r112 == null) goto L13;
        float r113 = r112.floatValue();
    L14:
        if (r111 == null) goto L32;
        Float r114 = r111.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        if (r114 == null) goto L18;
        float r115 = r114.floatValue();
    L19:
        r103 = r115 - r103;
        Float r116 = r111.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        if (r116 == null) goto L22;
        r101 = r116.floatValue();
    L22:
        r105 = r101 - r105;
        Float r117 = r111.get("scale");
        if (r117 == null) goto L25;
        r106 = r117.floatValue();
    L25:
        r113 = r106;
        goto L32
    L18:
        r115 = 0.0f;
    L32:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Float.valueOf((r103 / r113) / this.f117739f.getWidth())), TuplesKt.to("y", Float.valueOf((r105 / r113) / this.f117739f.getHeight()))});
    L29:
        th = move-exception;
        ALogger.e("getMoveDistance", th);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("x", r102), TuplesKt.to("y", r102)});
    L13:
        r113 = 1.0f;
        goto L14
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0.0f;
        goto L6
    }

    public final void f(Map<String, Float> r100, Map<String, Float> r101) {
        Long r102 = this.f117737d;
        long r103 = 0;
        if (r102 == null) goto L5;
        long r104 = r102.longValue();
    L7:
        if (r104 > 0) goto L10;
        this.f117737d = Long.valueOf(System.currentTimeMillis());
        return;
    L10:
        Map<String, Float> r105 = d(r100, r101);
        DataCenter r106 = this.f117738e;
        Pair[] r107 = new Pair[4];
        long r108 = System.currentTimeMillis();
        Long r109 = this.f117737d;
        if (r109 == null) goto L13;
        r103 = r109.longValue();
    L13:
        r107[0] = TuplesKt.to("enlarge_duartion", String.valueOf(r108 - r103));
        Float r110 = r100.get("scale");
        if (r110 == null) goto L16;
        float r111 = r110.floatValue();
    L17:
        r107[1] = TuplesKt.to("previous_enlarge_ratio", String.valueOf(Math.abs(r111)));
        Float r112 = r105.get("x");
        if (r112 == null) goto L20;
        Number r113 = new BigDecimal(String.valueOf(r112.floatValue()));
    L21:
        r107[2] = TuplesKt.to("move_distance_x", r113.toString());
        Float r114 = r105.get("y");
        if (r114 == null) goto L24;
        Number r115 = new BigDecimal(String.valueOf(r114.floatValue()));
    L25:
        r107[3] = TuplesKt.to("move_distance_y", r115.toString());
        Map r116 = MapsKt.mutableMapOf(r107);
        r116.putAll(this.f117734a);
        Unit r117 = Unit.INSTANCE;
        h(r106, "livesdk_vs_enlarge_duration", r116);
        this.f117737d = Long.valueOf(System.currentTimeMillis());
        return;
    L24:
        r115 = Float.valueOf(0.0f);
        goto L25
    L20:
        r113 = Float.valueOf(0.0f);
        goto L21
    L16:
        r111 = 1.0f;
        goto L17
    L5:
        r104 = 0;
        goto L7
    }

    public final void g(String r100, Map<String, Float> r101) {
        if (r101.hashCode() != this.f117736c) goto L5;
        return;
    L5:
        Map<String, Float> r102 = d(r101, null);
        DataCenter r103 = this.f117738e;
        Pair[] r104 = new Pair[4];
        r104[0] = TuplesKt.to("restore_type", r100);
        Float r105 = r101.get("scale");
        if (r105 == null) goto L8;
        float r106 = r105.floatValue();
    L9:
        r104[1] = TuplesKt.to("previous_enlarge_ratio", String.valueOf(Math.abs(r106)));
        Float r107 = r102.get("x");
        if (r107 == null) goto L12;
        Number r108 = new BigDecimal(String.valueOf(r107.floatValue()));
    L13:
        r104[2] = TuplesKt.to("move_distance_x", r108.toString());
        Float r109 = r102.get("y");
        if (r109 == null) goto L16;
        Number r110 = new BigDecimal(String.valueOf(r109.floatValue()));
    L17:
        r104[3] = TuplesKt.to("move_distance_y", r110.toString());
        Map r111 = MapsKt.mutableMapOf(r104);
        r111.putAll(this.f117734a);
        Unit r112 = Unit.INSTANCE;
        h(r103, "livesdk_vs_enlarge_restore", r111);
        f(r101, null);
        return;
    L16:
        r110 = Float.valueOf(0.0f);
        goto L17
    L12:
        r108 = Float.valueOf(0.0f);
        goto L13
    L8:
        r106 = 1.0f;
        goto L9
    }

    public g(DataCenter r100, View r101, m<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        this.f117738e = r100;
        this.f117739f = r101;
        this.f117740g = r102;
        Map<String, String> r103 = r.l().g(r100);
        this.f117734a = r103;
        r103.put("vs_screen_type", "landscape");
        this.f117735b = MapsKt.emptyMap();
        this.f117736c = -1;
        this.f117737d = 0L;
    }

    public static void h(DataCenter r100, String r101, Map r102) {
        ReplayDataContext.Companion.getClass();
        if (ReplayDataContext.a.b(r100) != null) goto L5;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "0");
        r.l().sendLog(r101, r102, new Object[]{IRoom.class});
        return;
    L5:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "1");
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r100).e(r101, r102, new Object[0]);
    }
}
