package w2;

import com.apm.insight.CrashType;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6836a;

    static {
        int[] iArr = new int[CrashType.values().length];
        f6836a = iArr;
        try {
            iArr[CrashType.JAVA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6836a[CrashType.LAUNCH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6836a[CrashType.NATIVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
