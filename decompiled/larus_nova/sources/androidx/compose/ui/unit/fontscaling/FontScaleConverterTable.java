package androidx.compose.ui.unit.fontscaling;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fromSp", "", "toDp", "<init>", "([F[F)V", "mFromSpValues", "getMFromSpValues$annotations", "()V", "getMFromSpValues", "()[F", "mToDpValues", "getMToDpValues$annotations", "getMToDpValues", "convertDpToSp", "", "dp", "convertSpToDp", CloudControlInf.SP, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontScaleConverterTable implements FontScaleConverter {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final float[] mFromSpValues;
    private final float[] mToDpValues;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable$Companion;", "", "<init>", "()V", "lookupAndInterpolate", "", "sourceValue", "sourceValues", "", "targetValues", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final float lookupAndInterpolate(float r100, float[] r101, float[] r110) {
            float r102 = Math.abs(r100);
            float r103 = Math.signum(r100);
            int r104 = Arrays.binarySearch(r101, r102);
            if (r104 < 0) goto L6;
            float r105 = r110[r104];
        L21:
            return r103 * r105;
        L6:
            boolean r106 = true;
            int r107 = (-(r104 + 1)) - 1;
            if (r107 < (r101.length - 1)) goto L17;
            float r108 = r101[r101.length - 1];
            float r109 = r110[r101.length - 1];
            if (r108 == 0.0f) goto L12;
            r106 = false;
        L12:
            if (r106 == false) goto L15;
            return 0.0f;
        L15:
            return r100 * (r109 / r108);
        L17:
            if (r107 != (-1)) goto L19;
            float r111 = r101[0];
            float r112 = r111;
            float r113 = r110[0];
            float r114 = 0.0f;
            float r115 = 0.0f;
        L20:
            r105 = MathUtils.INSTANCE.constrainedMap(r114, r113, r115, r112, r102);
            goto L21
        L19:
            float r116 = r101[r107];
            int r117 = r107 + 1;
            float r118 = r101[r117];
            float r119 = r110[r107];
            r115 = r116;
            r112 = r118;
            r113 = r110[r117];
            r114 = r119;
            goto L20
        }

        public static final /* synthetic */ float access$lookupAndInterpolate(Companion r100, float r101, float[] r102, float[] r103) {
            return r100.lookupAndInterpolate(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static /* synthetic */ void getMFromSpValues$annotations() {
    }

    public static /* synthetic */ void getMToDpValues$annotations() {
    }

    public int hashCode() {
        return (Arrays.hashCode(this.mFromSpValues) * 31) + Arrays.hashCode(this.mToDpValues);
    }

    public String toString() {
        return "FontScaleConverter{fromSpValues=" + Arrays.toString(this.mFromSpValues) + ", toDpValues=" + Arrays.toString(this.mToDpValues) + '}';
    }

    public final float[] getMFromSpValues() {
        return this.mFromSpValues;
    }

    public final float[] getMToDpValues() {
        return this.mToDpValues;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertDpToSp(float r100) {
        return Companion.access$lookupAndInterpolate(Companion, r100, this.mToDpValues, this.mFromSpValues);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertSpToDp(float r100) {
        return Companion.access$lookupAndInterpolate(Companion, r100, this.mFromSpValues, this.mToDpValues);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof FontScaleConverterTable) == true) goto L11;
        return false;
    L11:
        FontScaleConverterTable r101 = (FontScaleConverterTable) r100;
        if (Arrays.equals(this.mFromSpValues, r101.mFromSpValues) == true) goto L14;
    L16:
        return false;
    L14:
        if (Arrays.equals(this.mToDpValues, r101.mToDpValues) == false) goto L16;
        return true;
    }

    public FontScaleConverterTable(float[] r100, float[] r101) {
        boolean r102 = false;
        if (r100.length == r101.length) goto L5;
    L10:
        if (r102 == false) goto L14;
        this.mFromSpValues = r100;
        this.mToDpValues = r101;
        return;
    L14:
        throw new IllegalArgumentException("Array lengths must match and be nonzero".toString());
    L5:
        if (r100.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        r102 = true;
        goto L10
    L7:
        r103 = false;
        goto L8
    }
}
