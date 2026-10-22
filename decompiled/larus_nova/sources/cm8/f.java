package cm8;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f24196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f24201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f24202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f24203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f24204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f24205l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f24194a == r101.f24194a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f24195b, r101.f24195b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f24196c, r101.f24196c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f24197d, r101.f24197d) == true) goto L21;
        return false;
    L21:
        if (this.f24198e == r101.f24198e) goto L24;
        return false;
    L24:
        if (this.f24199f == r101.f24199f) goto L27;
        return false;
    L27:
        if (this.f24200g == r101.f24200g) goto L30;
        return false;
    L30:
        if (this.f24201h == r101.f24201h) goto L33;
        return false;
    L33:
        if (this.f24202i == r101.f24202i) goto L36;
        return false;
    L36:
        if (this.f24203j == r101.f24203j) goto L39;
        return false;
    L39:
        if (this.f24204k == r101.f24204k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f24205l, r101.f24205l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f24194a * 31) + this.f24195b.hashCode()) * 31;
        Message r101 = this.f24196c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f24197d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.f24198e == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f24199f == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f24200g == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f24201h == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.f24202i == true) goto L31;
        r107 = 1237;
    L31:
        return ((((((r115 + r107) * 31) + this.f24203j) * 31) + this.f24204k) * 31) + this.f24205l.hashCode();
    L25:
        r114 = 1237;
        goto L26
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MarkdownAppletContainerVMData(maxWidth=" + this.f24194a + ", renderData=" + this.f24195b + ", message=" + this.f24196c + ", templateUrl=" + this.f24197d + ", isLynx=" + this.f24198e + ", isFullBlock=" + this.f24199f + ", isInStart=" + this.f24200g + ", isInEnd=" + this.f24201h + ", isFullWidth=" + this.f24202i + ", blockMarginStart=" + this.f24203j + ", blockMarginEnd=" + this.f24204k + ", refresh=" + this.f24205l + ')';
    }

    public f(int r100, String r101, Message r102, String r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, int r111, int r112, Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r101, "renderData");
        Intrinsics.checkNotNullParameter(r113, "refresh");
        this.f24194a = r100;
        this.f24195b = r101;
        this.f24196c = r102;
        this.f24197d = r103;
        this.f24198e = r104;
        this.f24199f = r105;
        this.f24200g = r106;
        this.f24201h = r107;
        this.f24202i = r110;
        this.f24203j = r111;
        this.f24204k = r112;
        this.f24205l = r113;
    }
}
