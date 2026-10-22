package f6;

import com.stepos.aicgroup.memory.PressureLevel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8763a;

    static {
        int[] iArr = new int[PressureLevel.values().length];
        try {
            iArr[PressureLevel.LOW.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[PressureLevel.ULTRA_LOW.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[PressureLevel.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f8763a = iArr;
    }
}
