package aq8;

import com.larus.im.bean.message.Image;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f15941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f15942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f15944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f15946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f15947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f15948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Image f15949j;

    public e() {
        this(null, null, null, null, null, false, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f15940a, r101.f15940a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f15941b, r101.f15941b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f15942c, r101.f15942c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f15943d, r101.f15943d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f15944e, r101.f15944e) == true) goto L24;
        return false;
    L24:
        if (this.f15945f == r101.f15945f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f15946g, r101.f15946g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f15947h, r101.f15947h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f15948i, r101.f15948i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f15949j, r101.f15949j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f15940a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f15941b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f15942c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f15943d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f15944e.hashCode()) * 31;
        if (this.f15945f == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        String r115 = this.f15946g;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f15947h;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f15948i;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Image r124 = this.f15949j;
        if (r124 == null) goto L39;
        r101 = r124.hashCode();
    L39:
        return r123 + r101;
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionExtraData(inputContent=" + this.f15940a + ", selectStartPosition=" + this.f15941b + ", selectEndPosition=" + this.f15942c + ", instructionDefaultParams=" + this.f15943d + ", msgExtMap=" + this.f15944e + ", isForceUpdateWhenSame=" + this.f15945f + ", enterMethod=" + this.f15946g + ", scene=" + this.f15947h + ", imageScene=" + this.f15948i + ", image=" + this.f15949j + ')';
    }

    public e(String r100, Integer r101, Integer r102, String r103, Map r104, boolean r105, String r106, String r110, String r111, Image r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = new LinkedHashMap();
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = false;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r110 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r111 = null;
    L30:
        if ((r113 & 512) == 0) goto L32;
        r112 = null;
    L32:
        Intrinsics.checkNotNullParameter(r104, "msgExtMap");
        this.f15940a = r100;
        this.f15941b = r101;
        this.f15942c = r102;
        this.f15943d = r103;
        this.f15944e = r104;
        this.f15945f = r105;
        this.f15946g = r106;
        this.f15947h = r110;
        this.f15948i = r111;
        this.f15949j = r112;
    }
}
