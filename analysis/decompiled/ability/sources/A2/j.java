package A2;

import com.apm.insight.CrashType;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f91a;

    static {
        int[] iArr = new int[CrashType.values().length];
        f91a = iArr;
        try {
            iArr[CrashType.JAVA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f91a[CrashType.LAUNCH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f91a[CrashType.NATIVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f91a[CrashType.ANR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f91a[CrashType.DART.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f91a[CrashType.CUSTOM_JAVA.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f91a[CrashType.BLOCK.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f91a[CrashType.ENSURE.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f91a[CrashType.EXIT.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f91a[CrashType.PORTRAIT.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
