package t4;

import com.stepos.ability.report.event.LogLevel;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6657a;

    static {
        int[] iArr = new int[LogLevel.values().length];
        try {
            iArr[LogLevel.INFO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[LogLevel.WARN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[LogLevel.ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f6657a = iArr;
    }
}
