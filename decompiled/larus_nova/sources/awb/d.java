package awb;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f16607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f16608c;

    public d() {
        this(false, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f16606a == r101.f16606a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16607b, r101.f16607b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16608c, r101.f16608c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f16606a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Function1<String, Unit> r102 = this.f16607b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Integer r106 = this.f16608c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "TextSelectionConfig(enableSelection=" + this.f16606a + ", onTextSelected=" + this.f16607b + ", highlightColor=" + this.f16608c + ')';
    }

    public d(boolean r100, Function1 r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f16606a = r100;
        this.f16607b = r101;
        this.f16608c = null;
    }
}
