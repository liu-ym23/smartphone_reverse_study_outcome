package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ColorModel {
    private static final long Cmyk = 0;
    public static final Companion Companion = null;
    private static final long Lab = 0;
    private static final long Rgb = 0;
    private static final long Xyz = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "<init>", "()V", "Rgb", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "getRgb-xdoWZVw", "()J", "J", "Xyz", "getXyz-xdoWZVw", "Lab", "getLab-xdoWZVw", "Cmyk", "getCmyk-xdoWZVw", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getCmyk-xdoWZVw, reason: not valid java name */
        public final long m5266getCmykxdoWZVw() {
            return ColorModel.access$getCmyk$cp();
        }

        /* JADX INFO: renamed from: getLab-xdoWZVw, reason: not valid java name */
        public final long m5267getLabxdoWZVw() {
            return ColorModel.access$getLab$cp();
        }

        /* JADX INFO: renamed from: getRgb-xdoWZVw, reason: not valid java name */
        public final long m5268getRgbxdoWZVw() {
            return ColorModel.access$getRgb$cp();
        }

        /* JADX INFO: renamed from: getXyz-xdoWZVw, reason: not valid java name */
        public final long m5269getXyzxdoWZVw() {
            return ColorModel.access$getXyz$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorModel m5258boximpl(long r100) {
        return new ColorModel(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5259constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5260equalsimpl(long r100, Object r101) {
        if ((r101 instanceof ColorModel) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ColorModel) r101).m5265unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5261equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* JADX INFO: renamed from: getComponentCount-impl, reason: not valid java name */
    public static final int m5262getComponentCountimpl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5263hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m5260equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m5263hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5265unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        long r100 = 3;
        long r101 = r100 << 32;
        Rgb = m5259constructorimpl((((long) 0) & BodyPartID.bodyIdMax) | r101);
        Xyz = m5259constructorimpl((((long) 1) & BodyPartID.bodyIdMax) | r101);
        Lab = m5259constructorimpl(r101 | (((long) 2) & BodyPartID.bodyIdMax));
        Cmyk = m5259constructorimpl((r100 & BodyPartID.bodyIdMax) | (((long) 4) << 32));
    }

    public String toString() {
        return m5264toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getCmyk$cp() {
        return Cmyk;
    }

    public static final /* synthetic */ long access$getLab$cp() {
        return Lab;
    }

    public static final /* synthetic */ long access$getRgb$cp() {
        return Rgb;
    }

    public static final /* synthetic */ long access$getXyz$cp() {
        return Xyz;
    }

    private /* synthetic */ ColorModel(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5264toStringimpl(long r100) {
        if (m5261equalsimpl0(r100, Rgb) == false) goto L6;
        return "Rgb";
    L6:
        if (m5261equalsimpl0(r100, Xyz) == false) goto L9;
        return "Xyz";
    L9:
        if (m5261equalsimpl0(r100, Lab) == false) goto L12;
        return "Lab";
    L12:
        if (m5261equalsimpl0(r100, Cmyk) == false) goto L14;
        return "Cmyk";
    L14:
        return "Unknown";
    }
}
