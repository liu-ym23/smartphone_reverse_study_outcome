package com.bytedance.android.shopping.api.mall.common.feed.help;

import android.os.Handler;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.shopping.api.mall.model.ImpressionItem;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallCommonImpressionReportHelper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f170231k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f170232l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f170233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<ImpressionItem> f170234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<ImpressionItem> f170235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f170236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f170237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f170238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f170239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECMallCommonImpressionReportHelper$pollingRunnable$1 f170240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f170241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<ECHybridDataEngine> f170242j;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f170243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f170244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f170245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f170246d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f170243a == r101.f170243a) goto L8;
            return false;
        L8:
            if (this.f170244b == r101.f170244b) goto L10;
            return false;
        L10:
            if (this.f170245c == r101.f170245c) goto L12;
            return false;
        L12:
            if (this.f170246d == r101.f170246d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r100 = this.f170243a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            long r103 = this.f170244b;
            int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f170245c) * 31;
            boolean r105 = this.f170246d;
            if (r105 == true) goto L10;
            r101 = r105;
        L10:
            return r104 + r101;
        }

        public final String toString() {
            return "ECMallCommonImpressionReportConfig(enable=" + this.f170243a + ", intervalMs=" + this.f170244b + ", threshold=" + this.f170245c + ", flushOnInvisible=" + this.f170246d + ")";
        }

        public b(long r100, int r101, boolean r102) {
            this.f170243a = true;
            this.f170244b = r100;
            this.f170245c = r101;
            this.f170246d = r102;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallCommonImpressionReportHelper$c;", "", "", "", "pageNames", "Ljava/util/List;", "getPageNames", "()Ljava/util/List;", "", "intervalMs", "J", "b", "()J", "", "threshold", "I", "c", "()I", "", "flushOnInvisible", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("flush_on_invisible")
        private final boolean flushOnInvisible;

        @SerializedName("interval_ms")
        private final long intervalMs;

        @SerializedName("page_names")
        private final List<String> pageNames;

        @SerializedName("threshold")
        private final int threshold;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L14;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.pageNames, r101.pageNames) == true) goto L8;
            return false;
        L8:
            if (this.intervalMs == r101.intervalMs) goto L10;
            return false;
        L10:
            if (this.threshold == r101.threshold) goto L12;
            return false;
        L12:
            if (this.flushOnInvisible == r101.flushOnInvisible) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            List<String> r100 = this.pageNames;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.intervalMs;
            int r103 = ((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.threshold) * 31;
            boolean r104 = this.flushOnInvisible;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "ECMallCommonImpressionReportSetting(pageNames=" + this.pageNames + ", intervalMs=" + this.intervalMs + ", threshold=" + this.threshold + ", flushOnInvisible=" + this.flushOnInvisible + ")";
        }

        public final boolean a() {
            return this.flushOnInvisible;
        }

        public final long b() {
            return this.intervalMs;
        }

        public final int c() {
            return this.threshold;
        }

        public c(Object r100) {
            this.pageNames = null;
            this.intervalMs = 5000;
            this.threshold = 0;
            this.flushOnInvisible = false;
        }

        public final boolean d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "pageName");
            List<String> r101 = this.pageNames;
            if (r101 != null) goto L5;
        L6:
            List<String> r102 = this.pageNames;
            if (r102 != null) goto L9;
        L11:
            return false;
        L9:
            if (r102.contains("all_page") != true) goto L11;
            return true;
        L5:
            if (r101.contains(r100) != true) goto L6;
            return true;
        }
    }

    static {
        f170232l = new a();
        f170231k = LazyKt.lazy(ECMallCommonImpressionReportHelper$Companion$commonImpressionSetting$2.INSTANCE);
    }

    public ECMallCommonImpressionReportHelper(b r100, Function0<ECHybridDataEngine> r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "dataEngineProvider");
        this.f170241i = r100;
        this.f170242j = r101;
        this.f170233a = t93.a.b();
        this.f170234b = new LinkedHashSet();
        this.f170235c = CollectionsKt.emptyList();
        this.f170240h = new ECMallCommonImpressionReportHelper$pollingRunnable$1(this);
    }

    public static void a(final ECMallCommonImpressionReportHelper r100, boolean r101, boolean r102, final Function0 r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if (r100.f170239g == false) goto L13;
        if (r103 == null) goto L38;
        Unit r105 = (Unit) r103.invoke();
        return;
    L38:
        return;
    L13:
        if (r100.f170234b.isEmpty() == false) goto L17;
        if (r103 == null) goto L40;
        Unit r106 = (Unit) r103.invoke();
        return;
    L40:
        return;
    L17:
        if (r100.f170237e == false) goto L23;
        if (r101 == true) goto L20;
        if (r102 == true) goto L20;
    L21:
        if (r103 == null) goto L42;
        Unit r107 = (Unit) r103.invoke();
        return;
    L42:
        return;
    L20:
        r100.f170238f = true;
        goto L21
    L23:
        r100.f170237e = true;
        Set<ImpressionItem> r108 = r100.f170234b;
        final ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L25:
        if (r110.hasNext() == false) goto L27;
        ImpressionItem r111 = (ImpressionItem) r110.next();
        r109.add(new ImpressionItem(r111.getType(), r111.getId()));
        goto L25
    L27:
        r100.f170235c = r109;
        if (r109.isEmpty() == false) goto L32;
        r100.f170237e = false;
        if (r103 == null) goto L44;
        Unit r112 = (Unit) r103.invoke();
        return;
    L44:
        return;
    L32:
        Function1<Boolean, Unit> r113 = new ECMallCommonImpressionReportHelper$flushCommonImpression$1(r100, r109, r103);
        ECHybridDataEngine r114 = r100.f170242j.invoke();
        if (r114 != null) goto L35;
        r113.invoke(Boolean.FALSE);
        return;
    L35:
        r114.a(CollectionsKt.listOf("common_impression"), new com.bytedance.android.shopping.api.mall.common.feed.help.c(r100, r113));
    }
}
