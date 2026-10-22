package androidx.compose.ui.spatial;

import androidx.collection.SieveCacheKt;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b*\u001a\u0019\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a9\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0080\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010 \u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0019\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0080\b\u001a\u0011\u0010#\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010$\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a!\u0010%\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0080\b\u001a\u0019\u0010&\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010(\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000bH\u0080\b\u001a\u0011\u0010,\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000bH\u0080\b\u001a)\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH\u0080\b\u001a\r\u00102\u001a\u00020\u000b*\u00020\u001aH\u0080\b\u001aP\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001H\u0000\u001a8\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0007X\u0080T¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"LongsPerItem", "", "InitialSize", "Lower26Bits", "Lower9Bits", "MaxSupportedLastChildOffset", "EverythingButParentId", "Lkotlin/ULong;", "J", "EverythingButLastChildOffset", "PackedIntsLowestBit", "", "PackedIntsHighestBit", "TombStone", "AxisNorth", "AxisSouth", "AxisWest", "AxisEast", "packXY", "x", "y", "packMeta", "itemId", "parentId", "lastChildOffset", "updated", "", "focusable", "gesturable", "unpackMetaValue", "meta", "unpackMetaParentId", "unpackMetaLastChildOffset", "metaWithParentId", "metaWithUpdated", "metaMarkUpdated", "metaUnMarkUpdated", "metaMarkFlags", "metaWithLastChildOffset", "unpackMetaFocusable", "unpackMetaGesturable", "unpackMetaUpdated", "unpackX", "xy", "unpackY", "rectIntersectsRect", "srcLT", "srcRB", "destLT", "destRB", "toLong", "distanceScore", "axis", "queryL", "queryT", "queryR", "queryB", "l", "t", "r", "b", "distanceScoreAlongAxis", "distanceMin", "distanceMax", "queryCrossAxisMax", "queryCrossAxisMin", "crossAxisMax", "crossAxisMin", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RectListKt {
    public static final int AxisEast = 3;
    public static final int AxisNorth = 0;
    public static final int AxisSouth = 1;
    public static final int AxisWest = 2;
    public static final long EverythingButLastChildOffset = -2301339409586323457L;
    public static final long EverythingButParentId = -4503599560261633L;
    public static final int InitialSize = 64;
    public static final int LongsPerItem = 3;
    public static final int Lower26Bits = 67108863;
    public static final int Lower9Bits = 511;
    public static final int MaxSupportedLastChildOffset = 511;
    private static final long PackedIntsHighestBit = -9223372034707292160L;
    private static final long PackedIntsLowestBit = 4294967297L;
    public static final long TombStone = 2305843009213693951L;

    public static final long metaMarkFlags(long r100, boolean r101, boolean r102) {
        return (((r100 & (-4611686018427387905L)) & Long.MAX_VALUE) | ((r101 ? 1 : 0) * SieveCacheKt.NodeVisitedBit)) | ((r102 ? 1 : 0) * Long.MIN_VALUE);
    }

    public static final long metaMarkUpdated(long r100) {
        return r100 | 2305843009213693952L;
    }

    public static final long metaUnMarkUpdated(long r100) {
        return r100 & (-2305843009213693953L);
    }

    public static final long metaWithParentId(long r100, int r101) {
        return (r100 & EverythingButParentId) | (((long) (r101 & Lower26Bits)) << 26);
    }

    public static final long metaWithUpdated(long r100, boolean r101) {
        return (r100 & (-2305843009213693953L)) | ((r101 ? 1 : 0) << 61);
    }

    public static final long packXY(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return (((long) r101) & BodyPartID.bodyIdMax) | r102;
    }

    public static final boolean rectIntersectsRect(long r100, long r101, long r102, long r103) {
        if (((((r103 - r100) - 4294967297L) | ((r101 - r102) - 4294967297L)) & (-9223372034707292160L)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final long toLong(boolean r100) {
        return r100 ? 1 : 0;
    }

    public static final int unpackMetaFocusable(long r100) {
        return ((int) (r100 >> 62)) & 1;
    }

    public static final int unpackMetaGesturable(long r100) {
        return ((int) (r100 >> 63)) & 1;
    }

    public static final int unpackMetaLastChildOffset(long r100) {
        return ((int) (r100 >> 52)) & 511;
    }

    public static final int unpackMetaParentId(long r100) {
        return 67108863 & ((int) (r100 >> 26));
    }

    public static final int unpackMetaUpdated(long r100) {
        return ((int) (r100 >> 61)) & 1;
    }

    public static final int unpackMetaValue(long r100) {
        return 67108863 & ((int) r100);
    }

    public static final int unpackX(long r100) {
        return (int) (r100 >> 32);
    }

    public static final int unpackY(long r100) {
        return (int) r100;
    }

    public static final long metaWithLastChildOffset(long r100, int r101) {
        return (r100 & EverythingButLastChildOffset) | (((long) Math.min(r101, 511)) << 52);
    }

    public static final int distanceScoreAlongAxis(int r100, int r101, int r102, int r103, int r104, int r105) {
        int r106 = r100 - r101;
        return (r106 + 1) * ((((r102 - r103) + Math.max(r103, r105)) - Math.min(r102, r104)) + 1);
    }

    public static final long packMeta(int r100, int r101, int r102, boolean r103, boolean r104, boolean r105) {
        long r106 = (r105 ? 1 : 0) << 63;
        return ((((((r104 ? 1 : 0) << 62) | r106) | ((r103 ? 1 : 0) << 61)) | (((long) Math.min(r102, 511)) << 52)) | (((long) (r101 & Lower26Bits)) << 26)) | (((long) (r100 & Lower26Bits)) << 0);
    }

    public static final int distanceScore(int r100, int r101, int r102, int r103, int r110, int r111, int r112, int r113, int r114) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L16;
        return Integer.MAX_VALUE;
    L16:
        return distanceScoreAlongAxis(r111, r103, r110, r102, r114, r112);
    L17:
        return distanceScoreAlongAxis(r101, r113, r110, r102, r114, r112);
    L18:
        return distanceScoreAlongAxis(r112, r110, r103, r101, r113, r111);
    L14:
        return distanceScoreAlongAxis(r102, r114, r103, r101, r113, r111);
    }
}
