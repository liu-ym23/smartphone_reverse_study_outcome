package axc;

import bxc.e;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f16649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f16650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f16655g;

    public final int hashCode() {
        return (Arrays.hashCode(this.f16650b) * 31) + this.f16651c;
    }

    public final String toString() {
        return "PermissionRequest{mHelper=" + this.f16649a + ", mPerms=" + Arrays.toString(this.f16650b) + ", mRequestCode=" + this.f16651c + ", mRationale='" + this.f16652d + "', mPositiveButtonText='" + this.f16653e + "', mNegativeButtonText='" + this.f16654f + "', mTheme=" + this.f16655g + '}';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L17;
        a r101 = (a) r100;
        if (Arrays.equals(this.f16650b, r101.f16650b) == true) goto L13;
    L15:
        return false;
    L13:
        if (this.f16651c != r101.f16651c) goto L15;
        return true;
    }

    public a(e r100, String[] r101, int r102, String r103, String r104, String r105, int r106) {
        this.f16649a = r100;
        this.f16650b = (String[]) r101.clone();
        this.f16651c = r102;
        this.f16652d = r103;
        this.f16653e = r104;
        this.f16654f = r105;
        this.f16655g = r106;
    }
}
