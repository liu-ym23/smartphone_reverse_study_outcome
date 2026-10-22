package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/material3/carousel/CarouselAlignment;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class CarouselAlignment {
    private static final int Center = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int Start = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/carousel/CarouselAlignment$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/material3/carousel/CarouselAlignment;", "getStart-NUL3oTo", "()I", "I", "Center", "getCenter-NUL3oTo", "End", "getEnd-NUL3oTo", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-NUL3oTo, reason: not valid java name */
        public final int m3103getCenterNUL3oTo() {
            return CarouselAlignment.access$getCenter$cp();
        }

        /* JADX INFO: renamed from: getEnd-NUL3oTo, reason: not valid java name */
        public final int m3104getEndNUL3oTo() {
            return CarouselAlignment.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getStart-NUL3oTo, reason: not valid java name */
        public final int m3105getStartNUL3oTo() {
            return CarouselAlignment.access$getStart$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CarouselAlignment m3096boximpl(int r100) {
        return new CarouselAlignment(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3097constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3098equalsimpl(int r100, Object r101) {
        if ((r101 instanceof CarouselAlignment) == true) goto L6;
        return false;
    L6:
        if (r100 == ((CarouselAlignment) r101).m3102unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3099equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3100hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3101toStringimpl(int r100) {
        return "CarouselAlignment(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m3098equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m3100hashCodeimpl(this.value);
    }

    public String toString() {
        return m3101toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3102unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Start = m3097constructorimpl(-1);
        Center = m3097constructorimpl(0);
        End = m3097constructorimpl(1);
    }

    public static final /* synthetic */ int access$getCenter$cp() {
        return Center;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getStart$cp() {
        return Start;
    }

    private /* synthetic */ CarouselAlignment(int r100) {
        this.value = r100;
    }
}
