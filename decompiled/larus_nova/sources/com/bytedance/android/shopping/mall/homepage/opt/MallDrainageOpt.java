package com.bytedance.android.shopping.mall.homepage.opt;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.e0;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallDrainageOpt {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f178228f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f178229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f178230h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f178231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f178232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f178233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f178234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f178235e;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.opt.MallDrainageOpt$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/opt/MallDrainageOpt$a$a;", "", "", "delayTime", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "delayHeader", "Ljava/lang/Integer;", "getDelayHeader", "()Ljava/lang/Integer;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2643a {

            @SerializedName("delay_draw_header")
            private final Integer delayHeader;

            @SerializedName("delay_to_top_time")
            private final Long delayTime;

            public C2643a() {
                this(0);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2643a) == false) goto L10;
                C2643a r101 = (C2643a) r100;
                if (Intrinsics.areEqual(this.delayTime, r101.delayTime) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.delayHeader, r101.delayHeader) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                Long r100 = this.delayTime;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Integer r104 = this.delayHeader;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "GylPinToTopParams(delayTime=" + this.delayTime + ", delayHeader=" + this.delayHeader + ")";
            }

            public final Long a() {
                return this.delayTime;
            }

            public C2643a(int r100) {
                this.delayTime = 500L;
                this.delayHeader = null;
            }
        }

        public a() {
        }
    }

    public MallDrainageOpt() {
        throw null;
    }

    static {
        f178230h = new a();
        f178228f = LazyKt.lazy(MallDrainageOpt$Companion$isNeedGulPinToTop$2.INSTANCE);
    }

    public MallDrainageOpt(Map r100) {
        this.f178235e = r100;
        this.f178233c = LazyKt.lazy(MallDrainageOpt$service$2.INSTANCE);
        this.f178234d = LazyKt.lazy(MallDrainageOpt$nativeGylTop$2.INSTANCE);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        Object r102 = r100.get("mall_lynx_config");     // Catch: Throwable -> L16
        Object r103 = null;
        if ((r102 instanceof Map) == true) goto L6;
        r102 = null;
    L6:
        Map r104 = (Map) r102;     // Catch: Throwable -> L16
        if (r104 == null) goto L9;
        Object r105 = r104.get("gyl_pin_to_top_native");     // Catch: Throwable -> L16
    L11:
        if ((r105 instanceof String) == false) goto L14;
        r103 = r105;
    L14:
        this.f178231a = (String) r103;     // Catch: Throwable -> L16
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
        return;
    L9:
        r105 = null;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void a(ECHybridListEngine r100) {
        if (this.f178232b == false) goto L5;
        return;
    L5:
        this.f178232b = true;
        long r101 = System.currentTimeMillis();
        e0 r102 = (e0) r100.getAbility(e0.class);
        Object r103 = null;
        if (r102 == null) goto L8;
        r102.a("favorite_section", 0, true, null);
    L8:
        long r104 = System.currentTimeMillis();
        Object r105 = this.f178235e.get("delivery_session_id");
        if ((r105 instanceof String) == false) goto L12;
        r103 = r105;
    L12:
        String r106 = (String) r103;
        if (r106 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        if (r107 == true) goto L26;
        Map<String, ? extends Object> r108 = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_show_start_time", Long.valueOf(r101)), TuplesKt.to("request_show_end_time", Long.valueOf(r104))});
        y93.b r109 = (y93.b) this.f178233c.getValue();
        if (r109 == null) goto L25;
        r109.g(r106, true, r108);
        return;
    L25:
        return;
    L26:
        return;
    L15:
        if (r106.length() == 0) goto L18;
        r107 = false;
        goto L19
    }
}
