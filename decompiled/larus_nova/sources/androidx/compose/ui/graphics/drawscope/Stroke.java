package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", "", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "<init>", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth", "()F", "getMiter", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Stroke extends DrawStyle {
    public static final Companion Companion = null;
    private static final int DefaultCap = 0;
    private static final int DefaultJoin = 0;
    public static final float DefaultMiter = 4.0f;
    public static final float HairlineWidth = 0.0f;
    private final int cap;
    private final int join;
    private final float miter;
    private final PathEffect pathEffect;
    private final float width;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke$Companion;", "", "<init>", "()V", "HairlineWidth", "", "DefaultMiter", "DefaultCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultCap-KaPHkGw", "()I", "I", "DefaultJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultJoin-LxFBmk8", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getDefaultCap-KaPHkGw, reason: not valid java name */
        public final int m5481getDefaultCapKaPHkGw() {
            return Stroke.access$getDefaultCap$cp();
        }

        /* JADX INFO: renamed from: getDefaultJoin-LxFBmk8, reason: not valid java name */
        public final int m5482getDefaultJoinLxFBmk8() {
            return Stroke.access$getDefaultJoin$cp();
        }
    }

    public /* synthetic */ Stroke(float r100, float r101, int r102, int r103, PathEffect r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    static {
        Companion = new Companion(null);
        DefaultCap = StrokeCap.Companion.m5206getButtKaPHkGw();
        DefaultJoin = StrokeJoin.Companion.m5217getMiterLxFBmk8();
    }

    public int hashCode() {
        int r100 = ((((((Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.miter)) * 31) + StrokeCap.m5203hashCodeimpl(this.cap)) * 31) + StrokeJoin.m5213hashCodeimpl(this.join)) * 31;
        PathEffect r101 = this.pathEffect;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + StrokeCap.m5204toStringimpl(this.cap) + ", join=" + StrokeJoin.m5214toStringimpl(this.join) + ", pathEffect=" + this.pathEffect + ')';
    }

    public static final /* synthetic */ int access$getDefaultCap$cp() {
        return DefaultCap;
    }

    public static final /* synthetic */ int access$getDefaultJoin$cp() {
        return DefaultJoin;
    }

    /* JADX INFO: renamed from: getCap-KaPHkGw, reason: not valid java name */
    public final int m5479getCapKaPHkGw() {
        return this.cap;
    }

    /* JADX INFO: renamed from: getJoin-LxFBmk8, reason: not valid java name */
    public final int m5480getJoinLxFBmk8() {
        return this.join;
    }

    public final float getMiter() {
        return this.miter;
    }

    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final float getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Stroke) == true) goto L8;
        return false;
    L8:
        Stroke r101 = (Stroke) r100;
        if (this.width != r101.width) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (this.miter != r101.miter) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (StrokeCap.m5202equalsimpl0(this.cap, r101.cap) == true) goto L24;
        return false;
    L24:
        if (StrokeJoin.m5212equalsimpl0(this.join, r101.join) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pathEffect, r101.pathEffect) == true) goto L29;
        return false;
    L29:
        return true;
    L17:
        r103 = false;
        goto L18
    L11:
        r102 = false;
        goto L12
    }

    private Stroke(float r100, float r101, int r102, int r103, PathEffect r104) {
        super(null);
        this.width = r100;
        this.miter = r101;
        this.cap = r102;
        this.join = r103;
        this.pathEffect = r104;
    }

    public /* synthetic */ Stroke(float r100, float r101, int r110, int r111, PathEffect r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        float r102 = 0.0f;
    L7:
        if ((r113 & 2) == 0) goto L9;
        float r103 = 4.0f;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r110 = DefaultCap;
    L13:
        int r104 = r110;
        if ((r113 & 8) == 0) goto L16;
        r111 = DefaultJoin;
    L16:
        int r105 = r111;
        if ((r113 & 16) == 0) goto L19;
        r112 = null;
    L19:
        this(r102, r103, r104, r105, r112, null);
        return;
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
