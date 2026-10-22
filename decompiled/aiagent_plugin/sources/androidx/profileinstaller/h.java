package androidx.profileinstaller;

import java.util.Arrays;

/* JADX INFO: compiled from: ProfileVersion.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f2269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f2270b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final byte[] f2271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final byte[] f2272d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final byte[] f2273e = null;
    static final byte[] f = null;
    static final byte[] g = null;

    static {
        f2269a = new byte[]{48, 49, 53, 0};
        f2270b = new byte[]{48, 49, 48, 0};
        f2271c = new byte[]{48, 48, 57, 0};
        f2272d = new byte[]{48, 48, 53, 0};
        f2273e = new byte[]{48, 48, 49, 0};
        f = new byte[]{48, 48, 49, 0};
        g = new byte[]{48, 48, 50, 0};
    }

    static String a(byte[] r2) {
        if (Arrays.equals(r2, f2273e) == false) goto L6;
        return ":";
    L6:
        if (Arrays.equals(r2, f2272d) == false) goto L8;
        return ":";
    L8:
        return "!";
    }
}
