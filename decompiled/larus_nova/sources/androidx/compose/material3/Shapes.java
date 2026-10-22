package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import com.lynx.canvas.KryptonCamera;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BY\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fB;\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\rJ]\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0018J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\n\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", KryptonCamera.Config.RESOLUTION_MEDIUM, "large", "extraLarge", "largeIncreased", "extraLargeIncreased", "extraExtraLarge", "<init>", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraSmall", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getSmall", "getMedium", "getLarge", "getExtraLarge", "getLargeIncreased$material3", "getExtraLargeIncreased$material3", "getExtraExtraLarge$material3", "copy", "copy$material3", "defaultVerticalDragHandleShapesCached", "Landroidx/compose/material3/DragHandleShapes;", "getDefaultVerticalDragHandleShapesCached$material3", "()Landroidx/compose/material3/DragHandleShapes;", "setDefaultVerticalDragHandleShapesCached$material3", "(Landroidx/compose/material3/DragHandleShapes;)V", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Shapes {
    public static final int $stable = 0;
    private DragHandleShapes defaultVerticalDragHandleShapesCached;
    private final CornerBasedShape extraExtraLarge;
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraLargeIncreased;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape largeIncreased;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public int hashCode() {
        return (((((((((((((this.extraSmall.hashCode() * 31) + this.small.hashCode()) * 31) + this.medium.hashCode()) * 31) + this.large.hashCode()) * 31) + this.extraLarge.hashCode()) * 31) + this.largeIncreased.hashCode()) * 31) + this.extraLargeIncreased.hashCode()) * 31) + this.extraExtraLarge.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", largeIncreased=" + this.largeIncreased + ", extraLarge=" + this.extraLarge + ", extralargeIncreased=" + this.extraLargeIncreased + ", extraExtraLarge=" + this.extraExtraLarge + ')';
    }

    public final DragHandleShapes getDefaultVerticalDragHandleShapesCached$material3() {
        return this.defaultVerticalDragHandleShapesCached;
    }

    public final CornerBasedShape getExtraExtraLarge$material3() {
        return this.extraExtraLarge;
    }

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public final CornerBasedShape getExtraLargeIncreased$material3() {
        return this.extraLargeIncreased;
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public final CornerBasedShape getLargeIncreased$material3() {
        return this.largeIncreased;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Shapes) == true) goto L8;
        return false;
    L8:
        Shapes r101 = (Shapes) r100;
        if (Intrinsics.areEqual(this.extraSmall, r101.extraSmall) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.small, r101.small) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.medium, r101.medium) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.large, r101.large) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraLarge, r101.extraLarge) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.largeIncreased, r101.largeIncreased) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extraLargeIncreased, r101.extraLargeIncreased) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraExtraLarge, r101.extraExtraLarge) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final void setDefaultVerticalDragHandleShapesCached$material3(DragHandleShapes r100) {
        this.defaultVerticalDragHandleShapesCached = r100;
    }

    public Shapes(CornerBasedShape r110, CornerBasedShape r111, CornerBasedShape r112, CornerBasedShape r113, CornerBasedShape r114) {
        ShapeDefaults r100 = ShapeDefaults.INSTANCE;
        this(r110, r111, r112, r113, r114, r100.getLargeIncreased$material3(), r100.getExtraLargeIncreased$material3(), r100.getExtraExtraLarge$material3());
    }

    public final Shapes copy(CornerBasedShape r100, CornerBasedShape r101, CornerBasedShape r110, CornerBasedShape r111, CornerBasedShape r112) {
        return new Shapes(r100, r101, r110, r111, r112);
    }

    public /* synthetic */ Shapes(CornerBasedShape r100, CornerBasedShape r101, CornerBasedShape r102, CornerBasedShape r103, CornerBasedShape r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = ShapeDefaults.INSTANCE.getExtraSmall();
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = ShapeDefaults.INSTANCE.getSmall();
    L8:
        CornerBasedShape r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = ShapeDefaults.INSTANCE.getMedium();
    L11:
        CornerBasedShape r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = ShapeDefaults.INSTANCE.getLarge();
    L14:
        CornerBasedShape r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        r104 = ShapeDefaults.INSTANCE.getExtraLarge();
    L17:
        CornerBasedShape r108 = r100;
        this(r108, r111, r106, r107, r104);
    }

    public Shapes(CornerBasedShape r100, CornerBasedShape r101, CornerBasedShape r102, CornerBasedShape r103, CornerBasedShape r104, CornerBasedShape r105, CornerBasedShape r106, CornerBasedShape r107) {
        this.extraSmall = r100;
        this.small = r101;
        this.medium = r102;
        this.large = r103;
        this.extraLarge = r104;
        this.largeIncreased = r105;
        this.extraLargeIncreased = r106;
        this.extraExtraLarge = r107;
    }

    public static /* synthetic */ Shapes copy$default(Shapes r100, CornerBasedShape r101, CornerBasedShape r102, CornerBasedShape r103, CornerBasedShape r104, CornerBasedShape r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.extraSmall;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.small;
    L8:
        CornerBasedShape r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.medium;
    L11:
        CornerBasedShape r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.large;
    L14:
        CornerBasedShape r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.extraLarge;
    L17:
        CornerBasedShape r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Shapes copy$material3(CornerBasedShape r110, CornerBasedShape r111, CornerBasedShape r112, CornerBasedShape r113, CornerBasedShape r114, CornerBasedShape r115, CornerBasedShape r116, CornerBasedShape r117) {
        return new Shapes(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public /* synthetic */ Shapes(CornerBasedShape r100, CornerBasedShape r110, CornerBasedShape r111, CornerBasedShape r112, CornerBasedShape r113, CornerBasedShape r114, CornerBasedShape r115, CornerBasedShape r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        CornerBasedShape r101 = ShapeDefaults.INSTANCE.getExtraSmall();
    L7:
        if ((r117 & 2) == 0) goto L9;
        CornerBasedShape r102 = ShapeDefaults.INSTANCE.getSmall();
    L11:
        if ((r117 & 4) == 0) goto L13;
        CornerBasedShape r103 = ShapeDefaults.INSTANCE.getMedium();
    L15:
        if ((r117 & 8) == 0) goto L17;
        CornerBasedShape r104 = ShapeDefaults.INSTANCE.getLarge();
    L19:
        if ((r117 & 16) == 0) goto L21;
        CornerBasedShape r105 = ShapeDefaults.INSTANCE.getExtraLarge();
    L23:
        if ((r117 & 32) == 0) goto L25;
        CornerBasedShape r106 = ShapeDefaults.INSTANCE.getLargeIncreased$material3();
    L27:
        if ((r117 & 64) == 0) goto L29;
        CornerBasedShape r107 = ShapeDefaults.INSTANCE.getExtraLargeIncreased$material3();
    L31:
        if ((r117 & 128) == 0) goto L33;
        CornerBasedShape r108 = ShapeDefaults.INSTANCE.getExtraExtraLarge$material3();
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r108);
        return;
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public static /* synthetic */ Shapes copy$material3$default(Shapes r100, CornerBasedShape r110, CornerBasedShape r111, CornerBasedShape r112, CornerBasedShape r113, CornerBasedShape r114, CornerBasedShape r115, CornerBasedShape r116, CornerBasedShape r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        CornerBasedShape r101 = r100.extraSmall;
    L7:
        if ((r118 & 2) == 0) goto L9;
        CornerBasedShape r102 = r100.small;
    L11:
        if ((r118 & 4) == 0) goto L13;
        CornerBasedShape r103 = r100.medium;
    L15:
        if ((r118 & 8) == 0) goto L17;
        CornerBasedShape r104 = r100.large;
    L19:
        if ((r118 & 16) == 0) goto L21;
        CornerBasedShape r105 = r100.extraLarge;
    L23:
        if ((r118 & 32) == 0) goto L25;
        CornerBasedShape r106 = r100.largeIncreased;
    L27:
        if ((r118 & 64) == 0) goto L29;
        CornerBasedShape r107 = r100.extraLargeIncreased;
    L31:
        if ((r118 & 128) == 0) goto L33;
        CornerBasedShape r108 = r100.extraExtraLarge;
    L35:
        return r100.copy$material3(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
