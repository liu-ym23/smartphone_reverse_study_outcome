package com.bytedance.android.shopping.yata.ability;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class YataConfirmAlertConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f187481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f187482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f187483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f187484d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f187485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Float f187486b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f187485a, r101.f187485a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f187486b, r101.f187486b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f187485a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Float r104 = this.f187486b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "HeaderImageInfo(headImage=" + this.f187485a + ", headWhRatio=" + this.f187486b + ")";
        }

        public a(String r100, Float r101) {
            this.f187485a = r100;
            this.f187486b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f187487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f187488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f187489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f187490d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f187487a, r101.f187487a) == true) goto L8;
            return false;
        L8:
            if (this.f187488b == r101.f187488b) goto L10;
            return false;
        L10:
            if (Float.compare(this.f187489c, r101.f187489c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f187490d, r101.f187490d) == 0) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            String r100 = this.f187487a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f187488b;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return ((((r102 + r104) * 31) + Float.floatToIntBits(this.f187489c)) * 31) + Float.floatToIntBits(this.f187490d);
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "IconImageInfo(iconImage=" + this.f187487a + ", round=" + this.f187488b + ", radius=" + this.f187489c + ", edge=" + this.f187490d + ")";
        }

        public b(String r100, boolean r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, "iconImage");
            this.f187487a = r100;
            this.f187488b = r101;
            this.f187489c = r102;
            this.f187490d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f187491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f187492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f187493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f187494d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L14;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f187491a, r101.f187491a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f187492b, r101.f187492b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f187493c, r101.f187493c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f187494d, r101.f187494d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f187491a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f187492b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f187493c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f187494d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "StandardInfo(title=" + this.f187491a + ", message=" + this.f187492b + ", primaryBtn=" + this.f187493c + ", secondaryBtn=" + this.f187494d + ")";
        }

        public c(String r100, String r101, String r102, String r103) {
            this.f187491a = r100;
            this.f187492b = r101;
            this.f187493c = r102;
            this.f187494d = r103;
        }
    }

    public final c a() {
        return (c) this.f187481a.getValue();
    }

    public YataConfirmAlertConfig(Map<String, ? extends Object> r100) {
        this.f187484d = r100;
        this.f187481a = LazyKt.lazy(new YataConfirmAlertConfig$standardInfo$2(this));
        this.f187482b = LazyKt.lazy(new YataConfirmAlertConfig$headerImageInfo$2(this));
        this.f187483c = LazyKt.lazy(new YataConfirmAlertConfig$iconImageInfo$2(this));
    }
}
