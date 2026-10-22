package androidx.compose.ui.graphics.colorspace;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Illuminant;", "", "<init>", "()V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getA", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "B", "getB", "C", "getC", "D50", "getD50", "D55", "getD55", "D60", "getD60", "D65", "getD65", "D75", "getD75", ExifInterface.LONGITUDE_EAST, "getE", "D50Xyz", "", "getD50Xyz$ui_graphics_release", "()[F", "newD50Xyz", "newD50Xyz$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Illuminant {
    private static final WhitePoint A = null;
    private static final WhitePoint B = null;
    private static final WhitePoint C = null;
    private static final WhitePoint D50 = null;
    private static final float[] D50Xyz = null;
    private static final WhitePoint D55 = null;
    private static final WhitePoint D60 = null;
    private static final WhitePoint D65 = null;
    private static final WhitePoint D75 = null;
    private static final WhitePoint E = null;
    public static final Illuminant INSTANCE = null;

    private Illuminant() {
    }

    public final float[] newD50Xyz$ui_graphics_release() {
        return new float[]{0.964212f, 1.0f, 0.825188f};
    }

    static {
        INSTANCE = new Illuminant();
        A = new WhitePoint(0.44757f, 0.40745f);
        B = new WhitePoint(0.34842f, 0.35161f);
        C = new WhitePoint(0.31006f, 0.31616f);
        D50 = new WhitePoint(0.34567f, 0.3585f);
        D55 = new WhitePoint(0.33242f, 0.34743f);
        D60 = new WhitePoint(0.32168f, 0.33767f);
        D65 = new WhitePoint(0.31271f, 0.32902f);
        D75 = new WhitePoint(0.29902f, 0.31485f);
        E = new WhitePoint(0.33333f, 0.33333f);
        D50Xyz = new float[]{0.964212f, 1.0f, 0.825188f};
    }

    public final WhitePoint getA() {
        return A;
    }

    public final WhitePoint getB() {
        return B;
    }

    public final WhitePoint getC() {
        return C;
    }

    public final WhitePoint getD50() {
        return D50;
    }

    public final float[] getD50Xyz$ui_graphics_release() {
        return D50Xyz;
    }

    public final WhitePoint getD55() {
        return D55;
    }

    public final WhitePoint getD60() {
        return D60;
    }

    public final WhitePoint getD65() {
        return D65;
    }

    public final WhitePoint getD75() {
        return D75;
    }

    public final WhitePoint getE() {
        return E;
    }
}
