package androidx.compose.ui.layout;

import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b\n\u0010\u0006\u001a \u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0082\b¢\u0006\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"computeFillMaxDimension", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillMaxDimension-iLBOSCw", "(JJ)F", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "computeFillHeight", "computeFillHeight-iLBOSCw", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentScaleKt {
    /* JADX INFO: renamed from: access$computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final /* synthetic */ float m6250access$computeFillMaxDimensioniLBOSCw(long r100, long r101) {
        return m6253computeFillMaxDimensioniLBOSCw(r100, r101);
    }

    /* JADX INFO: renamed from: access$computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final /* synthetic */ float m6251access$computeFillMinDimensioniLBOSCw(long r100, long r101) {
        return m6254computeFillMinDimensioniLBOSCw(r100, r101);
    }

    /* JADX INFO: renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    private static final float m6252computeFillHeightiLBOSCw(long r100, long r101) {
        return Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)) / Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    private static final float m6253computeFillMaxDimensioniLBOSCw(long r100, long r101) {
        return Math.max(Float.intBitsToFloat((int) (r101 >> 32)) / Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)) / Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    private static final float m6254computeFillMinDimensioniLBOSCw(long r100, long r101) {
        return Math.min(Float.intBitsToFloat((int) (r101 >> 32)) / Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)) / Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    private static final float m6255computeFillWidthiLBOSCw(long r100, long r101) {
        return Float.intBitsToFloat((int) (r101 >> 32)) / Float.intBitsToFloat((int) (r100 >> 32));
    }
}
