package androidx.compose.ui.spatial;

import androidx.collection.SieveCacheKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a@\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0011\u001a \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a(\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a \u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u001d\u0010\u0015\u001a\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001e\u0010\u0011\u001a\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001f\u0010\u0011\u001a\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b \u0010\u0011\u001a\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\"\u0010\u0011\u001a\u0018\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b#\u0010\u0011\u001a0\u0010(\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010*\u001a\u00020\u0003*\u00020\tH\u0080\b¢\u0006\u0004\b*\u0010+\u001aW\u00105\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0000H\u0000¢\u0006\u0004\b5\u00106\u001a?\u0010=\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0000¢\u0006\u0004\b=\u0010>\"\u0014\u0010?\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u0010@\"\u0014\u0010A\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u0010@\"\u0014\u0010B\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u0010@\"\u0014\u0010C\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u0010@\"\u0014\u0010E\u001a\u00020D8\u0000X\u0080T¢\u0006\u0006\n\u0004\bE\u0010F\"\u0014\u0010G\u001a\u00020D8\u0000X\u0080T¢\u0006\u0006\n\u0004\bG\u0010F\"\u0014\u0010H\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010F\"\u0014\u0010I\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010F\"\u0014\u0010J\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bJ\u0010F\"\u0014\u0010K\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bK\u0010@\"\u0014\u0010L\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bL\u0010@\"\u0014\u0010M\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bM\u0010@\"\u0014\u0010N\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\bN\u0010@¨\u0006O"}, d2 = {"", "x", "y", "", "packXY", "(II)J", "itemId", "parentId", "lastChildOffset", "", "updated", "focusable", "gesturable", "packMeta", "(IIIZZZ)J", "meta", "unpackMetaValue", "(J)I", "unpackMetaParentId", "unpackMetaLastChildOffset", "metaWithParentId", "(JI)J", "metaWithUpdated", "(JZ)J", "metaMarkUpdated", "(J)J", "metaUnMarkUpdated", "metaMarkFlags", "(JZZ)J", "metaWithLastChildOffset", "unpackMetaFocusable", "unpackMetaGesturable", "unpackMetaUpdated", "xy", "unpackX", "unpackY", "srcLT", "srcRB", "destLT", "destRB", "rectIntersectsRect", "(JJJJ)Z", "toLong", "(Z)J", "axis", "queryL", "queryT", "queryR", "queryB", "l", "t", "r", "b", "distanceScore", "(IIIIIIIII)I", "distanceMin", "distanceMax", "queryCrossAxisMax", "queryCrossAxisMin", "crossAxisMax", "crossAxisMin", "distanceScoreAlongAxis", "(IIIIII)I", "LongsPerItem", "I", "InitialSize", "Lower26Bits", "Lower9Bits", "LC7/m;", "EverythingButParentId", "J", "EverythingButLastChildOffset", "PackedIntsLowestBit", "PackedIntsHighestBit", "TombStone", "AxisNorth", "AxisSouth", "AxisWest", "AxisEast", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
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
    private static final long PackedIntsHighestBit = -9223372034707292160L;
    private static final long PackedIntsLowestBit = 4294967297L;
    public static final long TombStone = 2305843009213693951L;

    public static final int distanceScore(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i == 0) {
            return distanceScoreAlongAxis(i10, i16, i11, i6, i15, i13);
        }
        if (i == 1) {
            return distanceScoreAlongAxis(i14, i12, i11, i6, i15, i13);
        }
        if (i == 2) {
            return distanceScoreAlongAxis(i6, i15, i12, i10, i16, i14);
        }
        if (i != 3) {
            return Integer.MAX_VALUE;
        }
        return distanceScoreAlongAxis(i13, i11, i12, i10, i16, i14);
    }

    public static final int distanceScoreAlongAxis(int i, int i6, int i10, int i11, int i12, int i13) {
        int i14 = i - i6;
        return (((Math.max(i11, i13) + (i10 - i11)) - Math.min(i10, i12)) + 1) * (i14 + 1);
    }

    public static final long metaMarkFlags(long j5, boolean z10, boolean z11) {
        return (j5 & 4611686018427387903L) | ((z10 ? 1L : 0L) * SieveCacheKt.NodeVisitedBit) | ((z11 ? 1L : 0L) * Long.MIN_VALUE);
    }

    public static final long metaMarkUpdated(long j5) {
        return j5 | 2305843009213693952L;
    }

    public static final long metaUnMarkUpdated(long j5) {
        return j5 & (-2305843009213693953L);
    }

    public static final long metaWithLastChildOffset(long j5, int i) {
        return (j5 & EverythingButLastChildOffset) | ((i & 511) << 52);
    }

    public static final long metaWithParentId(long j5, int i) {
        return (j5 & EverythingButParentId) | ((i & Lower26Bits) << 26);
    }

    public static final long metaWithUpdated(long j5, boolean z10) {
        return (j5 & (-2305843009213693953L)) | ((z10 ? 1L : 0L) << 61);
    }

    public static final long packMeta(int i, int i6, int i10, boolean z10, boolean z11, boolean z12) {
        return ((z11 ? 1L : 0L) << 62) | ((z12 ? 1L : 0L) << 63) | ((z10 ? 1L : 0L) << 61) | ((i10 & 511) << 52) | ((i6 & Lower26Bits) << 26) | (i & Lower26Bits);
    }

    public static final long packXY(int i, int i6) {
        return (i6 & 4294967295L) | (i << 32);
    }

    public static final boolean rectIntersectsRect(long j5, long j6, long j10, long j11) {
        return ((((j11 - j5) - 4294967297L) | ((j6 - j10) - 4294967297L)) & (-9223372034707292160L)) == 0;
    }

    public static final long toLong(boolean z10) {
        return z10 ? 1L : 0L;
    }

    public static final int unpackMetaFocusable(long j5) {
        return ((int) (j5 >> 62)) & 1;
    }

    public static final int unpackMetaGesturable(long j5) {
        return ((int) (j5 >> 63)) & 1;
    }

    public static final int unpackMetaLastChildOffset(long j5) {
        return ((int) (j5 >> 52)) & 511;
    }

    public static final int unpackMetaParentId(long j5) {
        return ((int) (j5 >> 26)) & Lower26Bits;
    }

    public static final int unpackMetaUpdated(long j5) {
        return ((int) (j5 >> 61)) & 1;
    }

    public static final int unpackMetaValue(long j5) {
        return ((int) j5) & Lower26Bits;
    }

    public static final int unpackX(long j5) {
        return (int) (j5 >> 32);
    }

    public static final int unpackY(long j5) {
        return (int) j5;
    }
}
