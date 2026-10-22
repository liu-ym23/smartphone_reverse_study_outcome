package z2;

import com.apm.insight.CrashType;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6927a;

    static {
        int[] iArr = new int[CrashType.values().length];
        f6927a = iArr;
        try {
            iArr[CrashType.ALL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6927a[CrashType.ANR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6927a[CrashType.JAVA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6927a[CrashType.LAUNCH.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6927a[CrashType.NATIVE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
