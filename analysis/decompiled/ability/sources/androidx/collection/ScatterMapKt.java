package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000l\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0001\n\u0002\b\u000b\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001aQ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u0006\u0010\u000b\u001a \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001a\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001c\u0010\u0018\u001a\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001d\u0010\u0018\u001a\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001e\u0010\u0018\u001a \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u000eH\u0081\b¢\u0006\u0004\b\"\u0010#\u001a0\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010$\u001a\u00020!H\u0080\b¢\u0006\u0004\b%\u0010&\u001a(\u0010'\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010$\u001a\u00020!H\u0080\b¢\u0006\u0004\b'\u0010(\u001a \u0010+\u001a\u00020*2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b+\u0010,\u001a \u0010-\u001a\u00020*2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b-\u0010,\u001a \u0010.\u001a\u00020*2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b.\u0010,\u001a\u0018\u0010.\u001a\u00020*2\u0006\u0010$\u001a\u00020!H\u0081\b¢\u0006\u0004\b.\u0010/\u001a\u0018\u00101\u001a\u00020\u000e*\u00060!j\u0002`0H\u0081\b¢\u0006\u0004\b1\u00102\u001a\u0018\u00104\u001a\u00020\u000e*\u00060!j\u0002`3H\u0080\b¢\u0006\u0004\b4\u00102\u001a\u0018\u00105\u001a\u00020!*\u00060!j\u0002`3H\u0080\b¢\u0006\u0004\b5\u00106\u001a\u0018\u00107\u001a\u00020**\u00060!j\u0002`3H\u0080\b¢\u0006\u0004\b7\u0010/\u001a$\u00109\u001a\u00060!j\u0002`82\u0006\u0010\r\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u000eH\u0080\b¢\u0006\u0004\b9\u0010#\u001a$\u0010;\u001a\u00060!j\u0002`3*\u00060!j\u0002`82\u0006\u0010:\u001a\u00020\u000eH\u0081\b¢\u0006\u0004\b;\u0010<\u001a\u001c\u0010=\u001a\u00060!j\u0002`3*\u00060!j\u0002`8H\u0080\b¢\u0006\u0004\b=\u00106\u001a\u001c\u0010>\u001a\u00060!j\u0002`3*\u00060!j\u0002`8H\u0081\b¢\u0006\u0004\b>\u00106\"\u0014\u0010?\u001a\u00020!8\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u0010@\"\u0014\u0010A\u001a\u00020!8\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u0010@\"\u0014\u0010B\u001a\u00020!8\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u0010@\"\u001a\u0010C\u001a\u00020!8\u0000X\u0081T¢\u0006\f\n\u0004\bC\u0010@\u0012\u0004\bD\u0010E\"\u0014\u0010F\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bF\u0010G\"\u0014\u0010H\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\u0006\n\u0004\bH\u0010I\"\u0014\u0010J\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\u0006\n\u0004\bJ\u0010I\"\u0014\u0010K\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\u0006\n\u0004\bK\u0010I\"\"\u0010M\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020L0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N\"\u0014\u0010O\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\u0006\n\u0004\bO\u0010I\"\u001a\u0010P\u001a\u00020!8\u0000X\u0081T¢\u0006\f\n\u0004\bP\u0010@\u0012\u0004\bQ\u0010E\"\u001a\u0010R\u001a\u00020!8\u0000X\u0081T¢\u0006\f\n\u0004\bR\u0010@\u0012\u0004\bS\u0010E*\f\b\u0000\u0010T\"\u00020!2\u00020!*\f\b\u0000\u0010U\"\u00020!2\u00020!*\f\b\u0000\u0010V\"\u00020!2\u00020!¨\u0006W"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/ScatterMap;", "emptyScatterMap", "()Landroidx/collection/ScatterMap;", "Landroidx/collection/MutableScatterMap;", "mutableScatterMapOf", "()Landroidx/collection/MutableScatterMap;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Landroidx/collection/MutableScatterMap;", "", "metadata", "", "capacity", "LC7/r;", "convertMetadataForCleanup", "([JI)V", "", "k", "hash", "(Ljava/lang/Object;)I", "h1", "(I)I", "h2", "nextCapacity", "n", "normalizeCapacity", "loadedCapacity", "unloadedCapacity", SettingsConfig.KEY_DATA, TypedValues.CycleType.S_WAVE_OFFSET, "", "readRawMetadata", "([JI)J", "value", "writeMetadata", "([JIIJ)V", "writeRawMetadata", "([JIJ)V", "index", "", "isEmpty", "([JI)Z", "isDeleted", "isFull", "(J)Z", "Landroidx/collection/StaticBitmask;", "lowestBitSet", "(J)I", "Landroidx/collection/Bitmask;", "get", "next", "(J)J", "hasNext", "Landroidx/collection/Group;", "group", "m", "match", "(JI)J", "maskEmpty", "maskEmptyOrDeleted", "AllEmpty", "J", "Empty", "Deleted", "Sentinel", "getSentinel$annotations", "()V", "EmptyGroup", "[J", "GroupWidth", "I", "ClonedMetadataCount", "DefaultScatterCapacity", "", "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", "MurmurHashC1", "BitmaskLsb", "getBitmaskLsb$annotations", "BitmaskMsb", "getBitmaskMsb$annotations", "Bitmask", "Group", "StaticBitmask", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final void convertMetadataForCleanup(long[] metadata, int i) {
        k.f(metadata, "metadata");
        int i6 = (i + 7) >> 3;
        for (int i10 = 0; i10 < i6; i10++) {
            long j5 = metadata[i10] & (-9187201950435737472L);
            metadata[i10] = (-72340172838076674L) & ((~j5) + (j5 >>> 7));
        }
        int length = metadata.length;
        int i11 = length - 1;
        int i12 = length - 2;
        metadata[i12] = (metadata[i12] & 72057594037927935L) | (-72057594037927936L);
        metadata[i11] = metadata[0];
    }

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        k.d(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int get(long j5) {
        return Long.numberOfTrailingZeros(j5) >> 3;
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final long group(long[] metadata, int i) {
        k.f(metadata, "metadata");
        int i6 = i >> 3;
        int i10 = (i & 7) << 3;
        return (((-i10) >> 63) & (metadata[i6 + 1] << (64 - i10))) | (metadata[i6] >>> i10);
    }

    public static final int h1(int i) {
        return i >>> 7;
    }

    public static final int h2(int i) {
        return i & 127;
    }

    public static final boolean hasNext(long j5) {
        return j5 != 0;
    }

    public static final int hash(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final boolean isDeleted(long[] metadata, int i) {
        k.f(metadata, "metadata");
        return ((metadata[i >> 3] >> ((i & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(long[] metadata, int i) {
        k.f(metadata, "metadata");
        return ((metadata[i >> 3] >> ((i & 7) << 3)) & 255) == 128;
    }

    public static final boolean isFull(long j5) {
        return j5 < 128;
    }

    public static final int loadedCapacity(int i) {
        if (i == 7) {
            return 6;
        }
        return i - (i / 8);
    }

    public static final int lowestBitSet(long j5) {
        return Long.numberOfTrailingZeros(j5) >> 3;
    }

    public static final long maskEmpty(long j5) {
        return j5 & ((~j5) << 6) & (-9187201950435737472L);
    }

    public static final long maskEmptyOrDeleted(long j5) {
        return j5 & ((~j5) << 7) & (-9187201950435737472L);
    }

    public static final long match(long j5, int i) {
        long j6 = j5 ^ (i * BitmaskLsb);
        return (~j6) & (j6 - BitmaskLsb) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final long next(long j5) {
        return j5 & (j5 - 1);
    }

    public static final int nextCapacity(int i) {
        if (i == 0) {
            return 6;
        }
        return (i * 2) + 1;
    }

    public static final int normalizeCapacity(int i) {
        if (i > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    public static final long readRawMetadata(long[] data, int i) {
        k.f(data, "data");
        return (data[i >> 3] >> ((i & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i) {
        if (i == 7) {
            return 8;
        }
        return ((i - 1) / 7) + i;
    }

    public static final void writeMetadata(long[] data, int i, int i6, long j5) {
        k.f(data, "data");
        int i10 = i6 >> 3;
        int i11 = (i6 & 7) << 3;
        long j6 = (j5 << i11) | (data[i10] & (~(255 << i11)));
        data[i10] = j6;
        data[(((i6 - 7) & i) + (i & 7)) >> 3] = j6;
    }

    public static final void writeRawMetadata(long[] data, int i, long j5) {
        k.f(data, "data");
        int i6 = i >> 3;
        int i10 = (i & 7) << 3;
        data[i6] = (j5 << i10) | (data[i6] & (~(255 << i10)));
    }

    public static final boolean isFull(long[] metadata, int i) {
        k.f(metadata, "metadata");
        return ((metadata[i >> 3] >> ((i & 7) << 3)) & 255) < 128;
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(Pair<? extends K, ? extends V>... pairs) {
        k.f(pairs, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairs.length);
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }
}
