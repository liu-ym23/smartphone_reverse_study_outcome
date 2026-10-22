package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RegexKt {
    public static final /* synthetic */ MatchResult access$findNext(Matcher r0, int r1, CharSequence r2) {
        return findNext(r0, r1, r2);
    }

    public static final /* synthetic */ MatchResult access$matchEntire(Matcher r0, CharSequence r1) {
        return matchEntire(r0, r1);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r0) {
        return range(r0);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r0, int r1) {
        return range(r0, r1);
    }

    public static final /* synthetic */ int access$toInt(Iterable r0) {
        return toInt(r0);
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(final int r3) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet r0 = EnumSet.allOf(Enum.class);
        Intrinsics.checkNotNull(r0);
        Intrinsics.needClassReification();
        CollectionsKt.retainAll(r0, new RegexKt$fromInt$1$1(r3));
        Set<T> r4 = Collections.unmodifiableSet(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "unmodifiableSet(...)");
        return r4;
    }

    private static final MatchResult findNext(Matcher r0, int r1, CharSequence r2) {
        if (r0.find(r1) == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r0, r2);
    }

    private static final MatchResult matchEntire(Matcher r1, CharSequence r2) {
        if (r1.matches() == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r1, r2);
    }

    private static final IntRange range(java.util.regex.MatchResult r1) {
        return RangesKt.until(r1.start(), r1.end());
    }

    private static final IntRange range(java.util.regex.MatchResult r1, int r2) {
        return RangesKt.until(r1.start(r2), r1.end(r2));
    }

    private static final int toInt(Iterable<? extends FlagEnum> r2) {
        Iterator<? extends FlagEnum> r3 = r2.iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 | r3.next().getValue();
        goto L4
    L6:
        return r0;
    }
}
