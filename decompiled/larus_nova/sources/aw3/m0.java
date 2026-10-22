package aw3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m0 f16448c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m0 f16449d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m0 f16450e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m0 f16451f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m0 f16452g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m0 f16453h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m0 f16454i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m0 f16455j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16457b;

    public static final class a {
        public static m0 a(String r100) {
            String r101 = null;
            if (r100 != null) goto L5;
        L10:
            if (r101 != null) goto L13;
            r101 = "";
        L13:
            return new m0(-1002, "background audio play failed".concat(r101));
        L5:
            if ((!StringsKt.isBlank(r100)) == true) goto L8;
            r100 = null;
        L8:
            if (r100 == null) goto L10;
            r101 = ": ".concat(r100);
            goto L10
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (this.f16456a == r101.f16456a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16457b, r101.f16457b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f16456a * 31) + this.f16457b.hashCode();
    }

    public final String toString() {
        return "BackgroundAudioError(errCode=" + this.f16456a + ", errMsg=" + this.f16457b + ')';
    }

    static {
        f16448c = new m0(-1001, "background audio src is empty");
        f16449d = new m0(-1002, "background audio play failed");
        f16450e = new m0(-1003, "background audio seek failed");
        f16451f = new m0(-1004, "background audio player unavailable");
        f16452g = new m0(-1005, "background audio is occupied by another applet");
        f16453h = new m0(-1006, "background audio action is invalid");
        f16454i = new m0(-1007, "background audio params are invalid");
        f16455j = new m0(-1008, "background audio appletId is empty");
    }

    public m0(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        this.f16456a = r100;
        this.f16457b = r101;
    }
}
