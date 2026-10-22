package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0002\u001a\u000f\u0010\t\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\n\u0010\n\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\u0002¨\u0006\f"}, d2 = {"positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInWindow", "positionOnScreen", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "positionInParent", "boundsInParent", "findRootCoordinates", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutCoordinatesKt {
    public static final Rect boundsInParent(LayoutCoordinates r100) {
        LayoutCoordinates r101 = r100.getParentLayoutCoordinates();
        if (r101 == null) goto L7;
        Rect r102 = LayoutCoordinates.CC.localBoundingBoxOf$default(r101, r100, false, 2, null);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new Rect(0.0f, 0.0f, (int) (r100.mo6258getSizeYbymL2g() >> 32), (int) (r100.mo6258getSizeYbymL2g() & BodyPartID.bodyIdMax));
    }

    public static final Rect boundsInRoot(LayoutCoordinates r100) {
        return LayoutCoordinates.CC.localBoundingBoxOf$default(findRootCoordinates(r100), r100, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates r110) {
        LayoutCoordinates r100 = findRootCoordinates(r110);
        float r101 = (int) (r100.mo6258getSizeYbymL2g() >> 32);
        float r102 = (int) (r100.mo6258getSizeYbymL2g() & BodyPartID.bodyIdMax);
        boolean r103 = false;
        Rect r104 = LayoutCoordinates.CC.localBoundingBoxOf$default(r100, r110, false, 2, null);
        float r105 = r104.getLeft();
        float r106 = 0.0f;
        if (r105 >= 0.0f) goto L6;
        r105 = 0.0f;
    L6:
        if (r105 <= r101) goto L8;
        r105 = r101;
    L8:
        float r111 = r104.getTop();
        if (r111 >= 0.0f) goto L12;
        r111 = 0.0f;
    L12:
        if (r111 <= r102) goto L14;
        r111 = r102;
    L14:
        float r112 = r104.getRight();
        if (r112 >= 0.0f) goto L18;
        r112 = 0.0f;
    L18:
        if (r112 > r101) goto L21;
        r101 = r112;
    L21:
        float r107 = r104.getBottom();
        if (r107 < 0.0f) goto L26;
        r106 = r107;
    L26:
        if (r106 > r102) goto L30;
        r102 = r106;
    L30:
        if (r105 != r101) goto L32;
        boolean r108 = true;
    L33:
        if (r108 == true) goto L42;
        if (r111 != r102) goto L37;
        r103 = true;
    L37:
        if (r103 == true) goto L42;
        long r109 = r100.mo6263localToWindowMKHz9U(Offset.m4574constructorimpl((Float.floatToRawIntBits(r105) << 32) | (((long) Float.floatToRawIntBits(r111)) & BodyPartID.bodyIdMax)));
        long r113 = r100.mo6263localToWindowMKHz9U(Offset.m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (Float.floatToRawIntBits(r111) & BodyPartID.bodyIdMax)));
        long r114 = r100.mo6263localToWindowMKHz9U(Offset.m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax)));
        long r115 = Float.floatToRawIntBits(r105);
        long r116 = r100.mo6263localToWindowMKHz9U(Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r115 << 32)));
        float r117 = Float.intBitsToFloat((int) (r109 >> 32));
        float r118 = Float.intBitsToFloat((int) (r113 >> 32));
        float r119 = Float.intBitsToFloat((int) (r116 >> 32));
        float r120 = Float.intBitsToFloat((int) (r114 >> 32));
        float r121 = Math.min(r117, Math.min(r118, Math.min(r119, r120)));
        float r122 = Math.max(r117, Math.max(r118, Math.max(r119, r120)));
        float r123 = Float.intBitsToFloat((int) (r109 & BodyPartID.bodyIdMax));
        float r124 = Float.intBitsToFloat((int) (r113 & BodyPartID.bodyIdMax));
        float r125 = Float.intBitsToFloat((int) (r116 & BodyPartID.bodyIdMax));
        float r126 = Float.intBitsToFloat((int) (r114 & BodyPartID.bodyIdMax));
        return new Rect(r121, Math.min(r123, Math.min(r124, Math.min(r125, r126))), r122, Math.max(r123, Math.max(r124, Math.max(r125, r126))));
    L42:
        return Rect.Companion.getZero();
    L32:
        r108 = false;
        goto L33
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates r100) {
        LayoutCoordinates r101 = r100.getParentLayoutCoordinates();
    L3:
        LayoutCoordinates r102 = r101;
        LayoutCoordinates r103 = r100;
        r100 = r102;
        if (r100 == null) goto L7;
        r101 = r100.getParentLayoutCoordinates();
        goto L3
    L7:
        if ((r103 instanceof NodeCoordinator) == false) goto L9;
        NodeCoordinator r104 = (NodeCoordinator) r103;
    L10:
        if (r104 != null) goto L12;
        return r103;
    L12:
        NodeCoordinator r105 = r104.getWrappedBy$ui_release();
    L13:
        NodeCoordinator r106 = r105;
        NodeCoordinator r107 = r104;
        r104 = r106;
        if (r104 == null) goto L16;
        r105 = r104.getWrappedBy$ui_release();
        goto L13
    L16:
        return r107;
    L9:
        r104 = null;
        goto L10
    }

    public static final long positionInParent(LayoutCoordinates r100) {
        LayoutCoordinates r101 = r100.getParentLayoutCoordinates();
        if (r101 == null) goto L6;
        return r101.mo6259localPositionOfR5De75A(r100, Offset.Companion.m4598getZeroF1C5BW0());
    L6:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    public static final long positionInRoot(LayoutCoordinates r100) {
        return r100.mo6261localToRootMKHz9U(Offset.Companion.m4598getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates r100) {
        return r100.mo6263localToWindowMKHz9U(Offset.Companion.m4598getZeroF1C5BW0());
    }

    public static final long positionOnScreen(LayoutCoordinates r100) {
        return r100.mo6262localToScreenMKHz9U(Offset.Companion.m4598getZeroF1C5BW0());
    }
}
