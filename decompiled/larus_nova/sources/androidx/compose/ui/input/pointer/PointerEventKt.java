package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\u000f\u0010\b\u001a\u00020\t*\u00020\u0002¢\u0006\u0002\u0010\n\u001a\u000f\u0010\u000b\u001a\u00020\t*\u00020\u0002¢\u0006\u0002\u0010\n\u001a\u001b\u0010\f\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u000e\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0007\u001a\f\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0007\u001a\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0002H\u0007\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u001f*\u00020\u0001H\u0082\b¨\u0006 "}, d2 = {"changedToDown", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "positionChanged", "positionChangedIgnoreConsumed", "positionChange", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "positionChangeConsumed", "anyChangeConsumed", "consumeDownChange", "", "consumePositionChange", "consumeAllChanges", "isOutOfBounds", "size", "Landroidx/compose/ui/unit/IntSize;", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "isOutOfBounds-jwHxaWs", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJ)Z", "toInt", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointerEventKt {
    private static final int toInt(boolean r100) {
        return r100 ? 1 : 0;
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean anyChangeConsumed(PointerInputChange r100) {
        return r100.isConsumed();
    }

    public static final boolean changedToDown(PointerInputChange r100) {
        if (r100.isConsumed() == false) goto L5;
    L9:
        return false;
    L5:
        if (r100.getPreviousPressed() == true) goto L9;
        if (r100.getPressed() == false) goto L9;
        return true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange r100) {
        if (r100.getPreviousPressed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.getPressed() == false) goto L7;
        return true;
    }

    public static final boolean changedToUp(PointerInputChange r100) {
        if (r100.isConsumed() == false) goto L5;
    L9:
        return false;
    L5:
        if (r100.getPreviousPressed() == false) goto L9;
        if (r100.getPressed() == true) goto L9;
        return true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange r100) {
        if (r100.getPreviousPressed() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getPressed() == true) goto L7;
        return true;
    }

    @Deprecated(message = "Use consume() instead", replaceWith = @ReplaceWith(expression = "consume()", imports = {}))
    public static final void consumeAllChanges(PointerInputChange r100) {
        r100.consume();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (pressed != previousPressed) consume()", imports = {}))
    public static final void consumeDownChange(PointerInputChange r100) {
        if (r100.getPressed() == r100.getPreviousPressed()) goto L6;
        r100.consume();
        return;
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (positionChange() != Offset.Zero) consume()", imports = {}))
    public static final void consumePositionChange(PointerInputChange r100) {
        if (Offset.m4579equalsimpl0(positionChange(r100), Offset.Companion.m4598getZeroF1C5BW0()) == true) goto L6;
        r100.consume();
        return;
    }

    public static final long positionChange(PointerInputChange r100) {
        return positionChangeInternal(r100, false);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean positionChangeConsumed(PointerInputChange r100) {
        return r100.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange r100) {
        return positionChangeInternal(r100, true);
    }

    public static final boolean positionChanged(PointerInputChange r100) {
        return !Offset.m4579equalsimpl0(positionChangeInternal(r100, false), Offset.Companion.m4598getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange r100) {
        return !Offset.m4579equalsimpl0(positionChangeInternal(r100, true), Offset.Companion.m4598getZeroF1C5BW0());
    }

    @Deprecated(message = "Use isOutOfBounds() that supports minimum touch target", replaceWith = @ReplaceWith(expression = "this.isOutOfBounds(size, extendedTouchPadding)", imports = {}))
    /* JADX INFO: renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m6070isOutOfBoundsO0kMr_c(PointerInputChange r100, long r101) {
        long r102 = r100.m6126getPositionF1C5BW0();
        float r103 = Float.intBitsToFloat((int) (r102 >> 32));
        float r104 = Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax));
        int r105 = (int) (r101 >> 32);
        int r106 = (int) (r101 & BodyPartID.bodyIdMax);
        boolean r107 = true;
        if (r103 >= 0.0f) goto L5;
        boolean r108 = true;
    L7:
        if (r103 <= r105) goto L9;
        boolean r109 = true;
    L10:
        boolean r110 = r109 | r108;
        if (r104 >= 0.0f) goto L13;
        boolean r111 = true;
    L14:
        boolean r112 = r110 | r111;
        if (r104 > r106) goto L19;
        r107 = false;
    L19:
        return r112 | r107;
    L13:
        r111 = false;
        goto L14
    L9:
        r109 = false;
        goto L10
    L5:
        r108 = false;
        goto L7
    }

    private static final long positionChangeInternal(PointerInputChange r100, boolean r101) {
        long r102 = r100.m6127getPreviousPositionF1C5BW0();
        long r103 = Offset.m4586minusMKHz9U(r100.m6126getPositionF1C5BW0(), r102);
        if (r101 == false) goto L5;
        return r103;
    L5:
        if (r100.isConsumed() == true) goto L7;
        return r103;
    L7:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m6071isOutOfBoundsjwHxaWs(PointerInputChange r100, long r101, long r110) {
        boolean r102 = PointerType.m6198equalsimpl0(r100.m6129getTypeT8wyACA(), PointerType.Companion.m6205getTouchT8wyACA());
        long r103 = r100.m6126getPositionF1C5BW0();
        float r104 = Float.intBitsToFloat((int) (r103 >> 32));
        float r105 = Float.intBitsToFloat((int) (r103 & BodyPartID.bodyIdMax));
        float r106 = Float.intBitsToFloat((int) (r110 >> 32));
        float r107 = r102 ? 1.0f : 0.0f;
        float r108 = r106 * r107;
        float r109 = ((int) (r101 >> 32)) + r108;
        float r111 = Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)) * r107;
        float r112 = ((int) (r101 & BodyPartID.bodyIdMax)) + r111;
        boolean r113 = true;
        if (r104 >= (-r108)) goto L5;
        boolean r114 = true;
    L7:
        if (r104 <= r109) goto L9;
        boolean r115 = true;
    L10:
        boolean r116 = r115 | r114;
        if (r105 >= (-r111)) goto L13;
        boolean r117 = true;
    L14:
        boolean r118 = r116 | r117;
        if (r105 > r112) goto L19;
        r113 = false;
    L19:
        return r118 | r113;
    L13:
        r117 = false;
        goto L14
    L9:
        r115 = false;
        goto L10
    L5:
        r114 = false;
        goto L7
    }

    public static /* synthetic */ long positionChangeInternal$default(PointerInputChange r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return positionChangeInternal(r100, r101);
    }
}
