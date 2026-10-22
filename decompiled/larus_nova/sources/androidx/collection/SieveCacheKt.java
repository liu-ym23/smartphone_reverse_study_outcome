package androidx.collection;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0017\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0080\b\u001a\u0011\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0080\b\u001a\u0019\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0003H\u0080\b\u001a\u0019\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0080\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0080\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003H\u0080\b\u001a\u0019\u0010+\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0003H\u0080\b\u001a\u0019\u0010,\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0003H\u0080\b\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0005\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001f\u0010\u001e\u001a\u00020\u0003*\u00020\u00018À\u0002X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u001f\u0010#\u001a\u00020\u0003*\u00020\u00018À\u0002X\u0081\u0004¢\u0006\f\u0012\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\"\u0019\u0010&\u001a\u00020\u0003*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"\"\u0019\u0010)\u001a\u00020\u0003*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\"\"\u0019\u0010*\u001a\u00020\u0003*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\"¨\u00060"}, d2 = {"MaxSize", "", "NodeInvalidLink", "", "getNodeInvalidLink$annotations", "()V", "NodeLinkMask", "getNodeLinkMask$annotations", "NodeLinksMask", "NodeVisitedBit", "NodeMetaMask", "NodeMetaAndNextMask", "NodeMetaAndPreviousMask", "EmptyNode", "EmptyNodes", "", "getEmptyNodes", "()[J", "InvalidMappingLink", "InvalidMapping", "createLinks", "node", "previous", TeaEventTrack.ACTION_DRAMA_NEXT, "mapping", "", "createLinkToNext", "setLinkToPrevious", "setLinkToNext", "clearVisitedBit", "previousNode", "getPreviousNode$annotations", "(J)V", "getPreviousNode", "(J)I", "nextNode", "getNextNode$annotations", "getNextNode", "visited", "getVisited", "createMapping", "src", "dst", "createSrcMapping", "createDstMapping", "eraseSrcMapping", "getSrc", "getDst", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SieveCacheKt {
    public static final long EmptyNode = 4611686018427387903L;
    private static final long[] EmptyNodes = null;
    public static final long InvalidMapping = 9223372034707292159L;
    public static final int InvalidMappingLink = Integer.MAX_VALUE;
    private static final long MaxSize = 2147483646;
    public static final int NodeInvalidLink = Integer.MAX_VALUE;
    public static final long NodeLinkMask = 2147483647L;
    public static final long NodeLinksMask = 4611686018427387903L;
    public static final long NodeMetaAndNextMask = -4611686016279904257L;
    public static final long NodeMetaAndPreviousMask = -2147483648L;
    public static final long NodeMetaMask = -4611686018427387904L;
    public static final long NodeVisitedBit = 4611686018427387904L;

    static {
        EmptyNodes = new long[0];
    }

    public static final long clearVisitedBit(long r100) {
        return r100 & 4611686018427387903L;
    }

    public static final long createDstMapping(long r100, int r101) {
        return (r100 & (-4294967296L)) | ((long) r101);
    }

    public static final long createLinkToNext(int r100) {
        return (((long) r100) & NodeLinkMask) | 4611686016279904256L;
    }

    public static final long createMapping(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return ((long) r101) | r102;
    }

    public static final long createSrcMapping(long r100, int r101) {
        long r102 = r100 & BodyPartID.bodyIdMax;
        return r102 | (((long) r101) << 32);
    }

    public static final long eraseSrcMapping(long r100) {
        return (r100 & BodyPartID.bodyIdMax) | (-4294967296L);
    }

    public static final int getDst(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }

    public static final int getNextNode(long r100) {
        return (int) (r100 & NodeLinkMask);
    }

    public static /* synthetic */ void getNextNode$annotations(long r100) {
    }

    public static /* synthetic */ void getNodeInvalidLink$annotations() {
    }

    public static /* synthetic */ void getNodeLinkMask$annotations() {
    }

    public static final int getPreviousNode(long r100) {
        return (int) ((r100 >> 31) & NodeLinkMask);
    }

    public static /* synthetic */ void getPreviousNode$annotations(long r100) {
    }

    public static final int getSrc(long r100) {
        return (int) ((r100 >> 32) & BodyPartID.bodyIdMax);
    }

    public static final int getVisited(long r100) {
        return (int) ((r100 >> 62) & 1);
    }

    public static final long setLinkToNext(long r100, int r101) {
        return (r100 & NodeMetaAndPreviousMask) | (((long) r101) & NodeLinkMask);
    }

    public static final long setLinkToPrevious(long r100, int r101) {
        return (r100 & NodeMetaAndNextMask) | ((((long) r101) & NodeLinkMask) << 31);
    }

    public static final long[] getEmptyNodes() {
        return EmptyNodes;
    }

    public static final long createLinks(long r100, int r101, int r102, long[] r103) {
        Intrinsics.checkNotNullParameter(r103, "mapping");
        long r104 = r100 & NodeMetaMask;
        int r105 = Integer.MAX_VALUE;
        if (r101 != Integer.MAX_VALUE) goto L5;
        int r106 = Integer.MAX_VALUE;
    L6:
        long r107 = (r104 | ((long) r106)) << 31;
        if (r102 == Integer.MAX_VALUE) goto L11;
        r105 = (int) (r103[r102] & BodyPartID.bodyIdMax);
    L11:
        return r107 | ((long) r105);
    L5:
        r106 = (int) (r103[r101] & BodyPartID.bodyIdMax);
        goto L6
    }

    public static final long createLinks(long r100, int r101, int r102, int[] r103) {
        Intrinsics.checkNotNullParameter(r103, "mapping");
        long r104 = r100 & NodeMetaMask;
        int r105 = Integer.MAX_VALUE;
        if (r101 != Integer.MAX_VALUE) goto L5;
        int r106 = Integer.MAX_VALUE;
    L6:
        long r107 = (r104 | ((long) r106)) << 31;
        if (r102 == Integer.MAX_VALUE) goto L11;
        r105 = r103[r102];
    L11:
        return r107 | ((long) r105);
    L5:
        r106 = r103[r101];
        goto L6
    }
}
