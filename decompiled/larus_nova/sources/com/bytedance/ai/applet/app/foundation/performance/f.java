package com.bytedance.ai.applet.app.foundation.performance;

import com.ss.texturerender.TextureRenderKeys;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ai.applet.app.foundation.performance.g.a f34297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f34298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppletPerformanceNavigationType f34299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AppletPerformanceMetric f34300f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f34295a == r101.f34295a) goto L12;
            return false;
        L12:
            if (this.f34296b == r101.f34296b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34297c, r101.f34297c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f34298d, r101.f34298d) == true) goto L21;
            return false;
        L21:
            if (this.f34299e == r101.f34299e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34295a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f34296b;
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f34297c.hashCode()) * 31;
            Long r104 = this.f34298d;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            AppletPerformanceNavigationType r108 = this.f34299e;
            if (r108 == null) goto L11;
            r105 = r108.hashCode();
        L11:
            return r107 + r105;
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public final String toString() {
            return "AppLaunch(startTime=" + this.f34295a + ", duration=" + this.f34296b + ", source=" + this.f34297c + ", navigationStart=" + this.f34298d + ", navigationType=" + this.f34299e + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.f34296b).longValue() < 0) goto L13;
            Long r100 = this.f34298d;
            if (r100 != null) goto L7;
        L9:
            boolean r101 = false;
        L10:
            if (r101 == true) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(r100.longValue()) == true) goto L9;
            r101 = true;
            goto L10
        L13:
            return false;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f34300f;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.f34297c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.f34295a;
        }

        public a(long r100, long r101, com.bytedance.ai.applet.app.foundation.performance.g.a r102, Long r103, AppletPerformanceNavigationType r104) {
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f34295a = r100;
            this.f34296b = r101;
            this.f34297c = r102;
            this.f34298d = r103;
            this.f34299e = r104;
            this.f34300f = AppletPerformanceMetric.APP_LAUNCH;
        }
    }

    public static final class b extends f {
        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final /* bridge */ /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.g b() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DownloadPackage(startTime=0, duration=0, source=null, packageName=null, packageSize=0)";
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            Long r100 = 0L;
            if (r100.longValue() >= 0) goto L5;
        L7:
            return false;
        L5:
            if ((!StringsKt.isBlank(null)) == false) goto L7;
            return true;
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ai.applet.app.foundation.performance.g f34303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f34304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AppletPerformanceMetric f34305e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f34301a == r101.f34301a) goto L12;
            return false;
        L12:
            if (this.f34302b == r101.f34302b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34303c, r101.f34303c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f34304d, r101.f34304d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34301a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f34302b;
            return ((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f34303c.hashCode()) * 31) + this.f34304d.hashCode();
        }

        public final String toString() {
            return "EvaluateScript(startTime=" + this.f34301a + ", duration=" + this.f34302b + ", source=" + this.f34303c + ", moduleName=" + this.f34304d + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.f34302b).longValue() >= 0) goto L5;
        L7:
            return false;
        L5:
            if ((!StringsKt.isBlank(this.f34304d)) == false) goto L7;
            return true;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f34305e;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.f34303c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.f34301a;
        }

        public c(long r100, long r101, com.bytedance.ai.applet.app.foundation.performance.g r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "source");
            Intrinsics.checkNotNullParameter(r103, TextureRenderKeys.KEY_MODULE_NAME);
            this.f34301a = r100;
            this.f34302b = r101;
            this.f34303c = r102;
            this.f34304d = r103;
            this.f34305e = AppletPerformanceMetric.EVALUATE_SCRIPT;
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f34307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppletPerformanceMetric f34308c;

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            return true;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f34306a == r101.f34306a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34307b, r101.f34307b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34306a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f34307b.hashCode();
        }

        public final String toString() {
            return "FirstContentfulPaint(startTime=" + this.f34306a + ", source=" + this.f34307b + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f34308c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.f34307b;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.f34306a;
        }

        public d(long r100, i r101) {
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f34306a = r100;
            this.f34307b = r101;
            this.f34308c = AppletPerformanceMetric.FIRST_CONTENTFUL_PAINT;
        }
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f34310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppletPerformanceMetric f34311c;

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            return true;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f34309a == r101.f34309a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34310b, r101.f34310b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34309a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f34310b.hashCode();
        }

        public final String toString() {
            return "FirstPaint(startTime=" + this.f34309a + ", source=" + this.f34310b + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f34311c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.f34310b;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.f34309a;
        }

        public e(long r100, i r101) {
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f34309a = r100;
            this.f34310b = r101;
            this.f34311c = AppletPerformanceMetric.FIRST_PAINT;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.applet.app.foundation.performance.f$f, reason: collision with other inner class name */
    public static final class C0680f extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i f34314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f34315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f34316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Long f34317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AppletPerformanceMetric f34318g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0680f) == true) goto L8;
            return false;
        L8:
            C0680f r101 = (C0680f) r100;
            if (this.f34312a == r101.f34312a) goto L12;
            return false;
        L12:
            if (this.f34313b == r101.f34313b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34314c, r101.f34314c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f34315d, r101.f34315d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f34316e, r101.f34316e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f34317f, r101.f34317f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34312a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f34313b;
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f34314c.hashCode()) * 31;
            Long r104 = this.f34315d;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            Long r108 = this.f34316e;
            if (r108 != null) goto L9;
            int r109 = 0;
        L10:
            int r110 = (r107 + r109) * 31;
            Long r111 = this.f34317f;
            if (r111 == null) goto L15;
            r105 = r111.hashCode();
        L15:
            return r110 + r105;
        L9:
            r109 = r108.hashCode();
            goto L10
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public final String toString() {
            return "FirstRender(startTime=" + this.f34312a + ", duration=" + this.f34313b + ", source=" + this.f34314c + ", viewLayerReadyTime=" + this.f34315d + ", viewLayerRenderStartTime=" + this.f34316e + ", viewLayerRenderEndTime=" + this.f34317f + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.f34313b).longValue() < 0) goto L22;
            List r100 = CollectionsKt.listOfNotNull(new Long[]{this.f34315d, this.f34316e, this.f34317f});
            if ((r100 instanceof Collection) == true) goto L7;
        L9:
            Iterator r101 = r100.iterator();
        L11:
            if (r101.hasNext() == false) goto L15;
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(((Number) r101.next()).longValue()) == true) goto L11;
            boolean r102 = false;
        L16:
            if (r102 == false) goto L23;
            return true;
        L23:
            return false;
        L15:
            r102 = true;
            goto L16
        L7:
            if (r100.isEmpty() == false) goto L9;
        L22:
            return false;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f34318g;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.f34314c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.f34312a;
        }

        public C0680f(long r100, long r101, i r102, Long r103, Long r104, Long r105) {
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f34312a = r100;
            this.f34313b = r101;
            this.f34314c = r102;
            this.f34315d = r103;
            this.f34316e = r104;
            this.f34317f = r105;
            this.f34318g = AppletPerformanceMetric.FIRST_RENDER;
        }
    }

    public static final class g extends f {
        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final /* bridge */ /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.g b() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            ((g) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(null, null) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(null, null) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ResourceTiming(startTime=0, duration=0, source=null, uri=null, initiatorType=null, transferSize=null, domainLookupStart=null, domainLookupEnd=null)";
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            Long r100 = 0L;
            if (r100.longValue() >= 0) goto L5;
            return false;
        L5:
            if ((!StringsKt.isBlank(null)) == false) goto L25;
            List r101 = CollectionsKt.listOfNotNull(new Long[]{null, null});
            if ((r101 instanceof Collection) == true) goto L9;
        L11:
            Iterator r102 = r101.iterator();
        L13:
            if (r102.hasNext() == false) goto L17;
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(((Number) r102.next()).longValue()) == true) goto L13;
            boolean r103 = false;
        L18:
            if (r103 == false) goto L26;
            return true;
        L26:
            return false;
        L17:
            r103 = true;
            goto L18
        L9:
            if (r101.isEmpty() == false) goto L11;
        L25:
            return false;
        }
    }

    public static final class h extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ai.applet.app.foundation.performance.g.a f34321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f34322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f34323e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Long f34324f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AppletPerformanceNavigationType f34325g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AppletPerformanceMetric f34326h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f34319a == r101.f34319a) goto L12;
            return false;
        L12:
            if (this.f34320b == r101.f34320b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34321c, r101.f34321c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f34322d, r101.f34322d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f34323e, r101.f34323e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f34324f, r101.f34324f) == true) goto L27;
            return false;
        L27:
            if (this.f34325g == r101.f34325g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f34319a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f34320b;
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f34321c.hashCode()) * 31;
            String r104 = this.f34322d;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            Long r108 = this.f34323e;
            if (r108 != null) goto L9;
            int r109 = 0;
        L10:
            int r110 = (r107 + r109) * 31;
            Long r111 = this.f34324f;
            if (r111 != null) goto L13;
            int r112 = 0;
        L14:
            int r113 = (r110 + r112) * 31;
            AppletPerformanceNavigationType r114 = this.f34325g;
            if (r114 == null) goto L19;
            r105 = r114.hashCode();
        L19:
            return r113 + r105;
        L13:
            r112 = r111.hashCode();
            goto L14
        L9:
            r109 = r108.hashCode();
            goto L10
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public final String toString() {
            return "Route(startTime=" + this.f34319a + ", duration=" + this.f34320b + ", source=" + this.f34321c + ", referrerPath=" + this.f34322d + ", referrerTraceId=" + this.f34323e + ", navigationStart=" + this.f34324f + ", navigationType=" + this.f34325g + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.f34320b).longValue() < 0) goto L23;
            Long r100 = this.f34324f;
            if (r100 != null) goto L7;
        L9:
            boolean r101 = false;
        L10:
            if (r101 == true) goto L24;
            Long r102 = this.f34323e;
            if (r102 != null) goto L14;
        L19:
            boolean r103 = false;
        L20:
            if (r103 == true) goto L25;
            return true;
        L25:
            return false;
        L14:
            if (r102.longValue() <= 0) goto L16;
            boolean r104 = true;
        L17:
            if (r104 == true) goto L19;
            r103 = true;
            goto L20
        L16:
            r104 = false;
            goto L17
        L24:
            return false;
        L7:
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(r100.longValue()) == true) goto L9;
            r101 = true;
            goto L10
        L23:
            return false;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f34326h;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.f34321c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.f34319a;
        }

        public h(long r100, long r101, com.bytedance.ai.applet.app.foundation.performance.g.a r102, String r103, Long r104, Long r105, AppletPerformanceNavigationType r110) {
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f34319a = r100;
            this.f34320b = r101;
            this.f34321c = r102;
            this.f34322d = r103;
            this.f34323e = r104;
            this.f34324f = r105;
            this.f34325g = r110;
            this.f34326h = AppletPerformanceMetric.ROUTE;
        }
    }

    public f() {
    }

    public abstract AppletPerformanceMetric a();

    public abstract com.bytedance.ai.applet.app.foundation.performance.g b();

    public abstract long c();

    public abstract boolean d();

    public final boolean e() {
        if (com.bytedance.ai.applet.app.foundation.performance.h.a(c()) == false) goto L32;
        com.bytedance.ai.applet.app.foundation.performance.g r100 = b();
        if (r100.getTraceId() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
    L25:
        boolean r102 = false;
    L26:
        if (r102 == true) goto L28;
        return false;
    L28:
        if (d() == false) goto L34;
        return true;
    L34:
        return false;
    L11:
        if ((r100 instanceof com.bytedance.ai.applet.app.foundation.performance.g.a) == false) goto L16;
        if (StringsKt.isBlank(((com.bytedance.ai.applet.app.foundation.performance.g.a) r100).f34328b) == true) goto L25;
    L24:
        r102 = true;
        goto L26
    L16:
        if ((r100 instanceof com.bytedance.ai.applet.app.foundation.performance.g.b) == true) goto L24;
        if ((r100 instanceof com.bytedance.ai.applet.app.foundation.performance.g.c) == false) goto L31;
        com.bytedance.ai.applet.app.foundation.performance.g.c r103 = (com.bytedance.ai.applet.app.foundation.performance.g.c) r100;
        if ((!StringsKt.isBlank(r103.f34331b)) == false) goto L25;
        if ((!StringsKt.isBlank(r103.f34332c)) == false) goto L25;
    L31:
        throw new NoWhenBranchMatchedException();
    L7:
        r101 = false;
        goto L8
    L32:
        return false;
    }
}
