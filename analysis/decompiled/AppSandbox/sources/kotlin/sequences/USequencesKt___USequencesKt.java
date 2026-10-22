package kotlin.sequences;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import stepos.com.android.os.StatsLogEnums;

/* compiled from: _USequences.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {MetricsSQLiteCacheKt.METRICS_SUM, "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_MATCHER_UPDATE_STATUS_UNKNOWN_VALUE, xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes.dex */
class USequencesKt___USequencesKt {
    public static final int sumOfUInt(Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UInt> it = sequence.iterator();
        int iM512constructorimpl = 0;
        while (it.hasNext()) {
            iM512constructorimpl = UInt.m512constructorimpl(iM512constructorimpl + it.next().getData());
        }
        return iM512constructorimpl;
    }

    public static final long sumOfULong(Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<ULong> it = sequence.iterator();
        long jM591constructorimpl = 0;
        while (it.hasNext()) {
            jM591constructorimpl = ULong.m591constructorimpl(jM591constructorimpl + it.next().getData());
        }
        return jM591constructorimpl;
    }

    public static final int sumOfUByte(Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UByte> it = sequence.iterator();
        int iM512constructorimpl = 0;
        while (it.hasNext()) {
            iM512constructorimpl = UInt.m512constructorimpl(iM512constructorimpl + UInt.m512constructorimpl(it.next().getData() & UByte.MAX_VALUE));
        }
        return iM512constructorimpl;
    }

    public static final int sumOfUShort(Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UShort> it = sequence.iterator();
        int iM512constructorimpl = 0;
        while (it.hasNext()) {
            iM512constructorimpl = UInt.m512constructorimpl(iM512constructorimpl + UInt.m512constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM512constructorimpl;
    }
}
