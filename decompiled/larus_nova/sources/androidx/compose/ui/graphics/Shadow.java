package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J+\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blurRadius", "", "<init>", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU$annotations", "()V", "getColor-0d7_KjU", "()J", "J", "getOffset-F1C5BW0$annotations", "getOffset-F1C5BW0", "getBlurRadius$annotations", "getBlurRadius", "()F", "equals", "", "other", "hashCode", "", "toString", "", "copy", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Shadow {
    public static final Companion Companion = null;
    private static final Shadow None = null;
    private final float blurRadius;
    private final long color;
    private final long offset;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/Shadow$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        public final Shadow getNone() {
            return Shadow.access$getNone$cp();
        }
    }

    public /* synthetic */ Shadow(long r100, long r101, float r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m5173getColor0d7_KjU$annotations() {
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0$annotations, reason: not valid java name */
    public static /* synthetic */ void m5174getOffsetF1C5BW0$annotations() {
    }

    static {
        Companion = new Companion(null);
        None = new Shadow(0, 0, 0.0f, 7, null);
    }

    public int hashCode() {
        return (((Color.m4834hashCodeimpl(this.color) * 31) + Offset.m4584hashCodeimpl(this.offset)) * 31) + Float.floatToIntBits(this.blurRadius);
    }

    public String toString() {
        return "Shadow(color=" + Color.m4835toStringimpl(this.color) + ", offset=" + Offset.m4590toStringimpl(this.offset) + ", blurRadius=" + this.blurRadius + ')';
    }

    public static final /* synthetic */ Shadow access$getNone$cp() {
        return None;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m5176getColor0d7_KjU() {
        return this.color;
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m5177getOffsetF1C5BW0() {
        return this.offset;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Shadow) == true) goto L8;
        return false;
    L8:
        Shadow r101 = (Shadow) r100;
        if (Color.m4828equalsimpl0(this.color, r101.color) == true) goto L12;
        return false;
    L12:
        if (Offset.m4579equalsimpl0(this.offset, r101.offset) == true) goto L15;
        return false;
    L15:
        if (this.blurRadius != r101.blurRadius) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == true) goto L20;
        return false;
    L20:
        return true;
    L17:
        r102 = false;
        goto L18
    }

    private Shadow(long r100, long r101, float r102) {
        this.color = r100;
        this.offset = r101;
        this.blurRadius = r102;
    }

    /* JADX INFO: renamed from: copy-qcb84PM, reason: not valid java name */
    public final Shadow m5175copyqcb84PM(long r100, long r110, float r111) {
        return new Shadow(r100, r110, r111, null);
    }

    public /* synthetic */ Shadow(long r100, long r110, float r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = ColorKt.Color(4278190080L);
    L5:
        long r101 = r100;
        if ((r112 & 2) == 0) goto L8;
        r110 = Offset.Companion.m4598getZeroF1C5BW0();
    L8:
        long r102 = r110;
        if ((r112 & 4) == 0) goto L11;
        float r103 = 0.0f;
    L12:
        this(r101, r102, r103, null);
        return;
    L11:
        r103 = r111;
        goto L12
    }

    /* JADX INFO: renamed from: copy-qcb84PM$default, reason: not valid java name */
    public static /* synthetic */ Shadow m5172copyqcb84PM$default(Shadow r100, long r101, long r102, float r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.color;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.offset;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.blurRadius;
    L12:
        return r100.m5175copyqcb84PM(r103, r104, r110);
    }
}
