package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/TileMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TileMode {
    private static final int Clamp = 0;
    public static final Companion Companion = null;
    private static final int Decal = 0;
    private static final int Mirror = 0;
    private static final int Repeated = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/TileMode$Companion;", "", "<init>", "()V", "Clamp", "Landroidx/compose/ui/graphics/TileMode;", "getClamp-3opZhB0", "()I", "I", "Repeated", "getRepeated-3opZhB0", "Mirror", "getMirror-3opZhB0", "Decal", "getDecal-3opZhB0", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getClamp-3opZhB0, reason: not valid java name */
        public final int m5226getClamp3opZhB0() {
            return TileMode.access$getClamp$cp();
        }

        /* JADX INFO: renamed from: getDecal-3opZhB0, reason: not valid java name */
        public final int m5227getDecal3opZhB0() {
            return TileMode.access$getDecal$cp();
        }

        /* JADX INFO: renamed from: getMirror-3opZhB0, reason: not valid java name */
        public final int m5228getMirror3opZhB0() {
            return TileMode.access$getMirror$cp();
        }

        /* JADX INFO: renamed from: getRepeated-3opZhB0, reason: not valid java name */
        public final int m5229getRepeated3opZhB0() {
            return TileMode.access$getRepeated$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TileMode m5219boximpl(int r100) {
        return new TileMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5220constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5221equalsimpl(int r100, Object r101) {
        if ((r101 instanceof TileMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TileMode) r101).m5225unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5222equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5223hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5221equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5223hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5225unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Clamp = m5220constructorimpl(0);
        Repeated = m5220constructorimpl(1);
        Mirror = m5220constructorimpl(2);
        Decal = m5220constructorimpl(3);
    }

    public String toString() {
        return m5224toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getClamp$cp() {
        return Clamp;
    }

    public static final /* synthetic */ int access$getDecal$cp() {
        return Decal;
    }

    public static final /* synthetic */ int access$getMirror$cp() {
        return Mirror;
    }

    public static final /* synthetic */ int access$getRepeated$cp() {
        return Repeated;
    }

    private /* synthetic */ TileMode(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5224toStringimpl(int r100) {
        if (m5222equalsimpl0(r100, Clamp) == false) goto L6;
        return "Clamp";
    L6:
        if (m5222equalsimpl0(r100, Repeated) == false) goto L9;
        return "Repeated";
    L9:
        if (m5222equalsimpl0(r100, Mirror) == false) goto L12;
        return "Mirror";
    L12:
        if (m5222equalsimpl0(r100, Decal) == false) goto L14;
        return "Decal";
    L14:
        return "Unknown";
    }
}
