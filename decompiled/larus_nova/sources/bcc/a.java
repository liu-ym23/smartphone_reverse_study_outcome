package bcc;

import android.text.Layout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Layout f18604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout f18605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Layout f18608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18609f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f18604a, r101.f18604a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18605b, r101.f18605b) == true) goto L15;
        return false;
    L15:
        if (this.f18606c == r101.f18606c) goto L18;
        return false;
    L18:
        if (this.f18607d == r101.f18607d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Layout r100 = this.f18604a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Layout r104 = this.f18605b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f18606c) * 31;
        if (this.f18607d == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CodeBlockV2ParserResult(contentLayout=" + this.f18604a + ", lineNumLayout=" + this.f18605b + ", lineNumWidth=" + this.f18606c + ", isNightMode=" + this.f18607d + ')';
    }

    public a(Layout r100, Layout r101, int r102, boolean r103) {
        this.f18604a = r100;
        this.f18605b = r101;
        this.f18606c = r102;
        this.f18607d = r103;
    }
}
