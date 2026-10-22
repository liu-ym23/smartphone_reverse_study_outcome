package androidx.compose.ui.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b\u001a\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\b\u001a\r\u0010\u0007\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0007\u001a\u00020\u0003*\u00020\u0005H\u0086\b¨\u0006\b"}, d2 = {"floatFromBits", "", "bits", "", "doubleFromBits", "", "", "fastRoundToInt", "ui-util"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InlineClassHelper_jvmKt {
    public static final double doubleFromBits(long r100) {
        return Double.longBitsToDouble(r100);
    }

    public static final int fastRoundToInt(double r100) {
        return (int) Math.round(r100);
    }

    public static final float floatFromBits(int r100) {
        return Float.intBitsToFloat(r100);
    }

    public static final int fastRoundToInt(float r100) {
        return Math.round(r100);
    }
}
