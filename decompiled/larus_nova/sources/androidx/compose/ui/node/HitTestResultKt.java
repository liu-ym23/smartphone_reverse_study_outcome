package androidx.compose.ui.node;

import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"IS_IN_LAYER", "", "IS_IN_EXPANDED_BOUNDS", "DistanceAndFlags", "Landroidx/compose/ui/node/DistanceAndFlags;", "distance", "", "isInLayer", "", "isInExpandedBounds", "(FZZ)J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HitTestResultKt {
    private static final long IS_IN_EXPANDED_BOUNDS = 2;
    private static final long IS_IN_LAYER = 1;

    private static final long DistanceAndFlags(float r100, boolean r101, boolean r102) {
        long r103 = Float.floatToRawIntBits(r100);
        long r104 = 0;
        if (r101 == false) goto L5;
        long r105 = 1;
    L6:
        if (r102 == false) goto L9;
        r104 = 2;
    L9:
        return DistanceAndFlags.m6426constructorimpl(((r105 | r104) & BodyPartID.bodyIdMax) | (r103 << 32));
    L5:
        r105 = 0;
        goto L6
    }

    public static final /* synthetic */ long access$DistanceAndFlags(float r100, boolean r101, boolean r102) {
        return DistanceAndFlags(r100, r101, r102);
    }

    public static /* synthetic */ long DistanceAndFlags$default(float r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = false;
    L6:
        return DistanceAndFlags(r100, r101, r102);
    }
}
