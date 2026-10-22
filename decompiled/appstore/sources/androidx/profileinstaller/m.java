package androidx.profileinstaller;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f3973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f3974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f3975c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f3976d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f3977e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f3978f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f3979g = null;

    static {
        f3973a = new byte[]{48, 49, 53, 0};
        f3974b = new byte[]{48, 49, 48, 0};
        f3975c = new byte[]{48, 48, 57, 0};
        f3976d = new byte[]{48, 48, 53, 0};
        f3977e = new byte[]{48, 48, 49, 0};
        f3978f = new byte[]{48, 48, 49, 0};
        f3979g = new byte[]{48, 48, 50, 0};
    }

    public static String a(byte[] r10) {
        if (Arrays.equals(r10, f3977e) == false) goto L6;
        return ":";
    L6:
        if (Arrays.equals(r10, f3976d) == false) goto L8;
        return ":";
    L8:
        return "!";
    }
}
