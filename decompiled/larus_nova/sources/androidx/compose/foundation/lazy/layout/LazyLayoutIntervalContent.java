package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000bJT\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0001\u0010\u00122\u0006\u0010\u0013\u001a\u00020\u000b26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00120\u0015H\u0086\b¢\u0006\u0002\u0010\u001aR\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Interval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "<init>", "()V", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "itemCount", "", "getItemCount", "()I", "getKey", "index", "getContentType", "withInterval", ExifInterface.GPS_DIRECTION_TRUE, "globalIndex", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "localIntervalIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LazyLayoutIntervalContent<Interval extends Interval> {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R1\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR1\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "getKey", "()Lkotlin/jvm/functions/Function1;", "type", "getType", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Interval {

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Function1 $default$getKey(Interval r100) {
                return null;
            }

            public static Function1 $default$getType(Interval r100) {
                return LazyLayoutIntervalContent$Interval$type$1.INSTANCE;
            }
        }

        Function1<Integer, Object> getKey();

        Function1<Integer, Object> getType();
    }

    public LazyLayoutIntervalContent() {
    }

    public abstract IntervalList<Interval> getIntervals();

    public final int getItemCount() {
        return getIntervals().getSize();
    }

    public final Object getContentType(int r100) {
        IntervalList.Interval<Interval> r101 = getIntervals().get(r100);
        int r102 = r100 - r101.getStartIndex();
        return r101.getValue().getType().invoke(Integer.valueOf(r102));
    }

    public final Object getKey(int r100) {
        IntervalList.Interval<Interval> r101 = getIntervals().get(r100);
        int r102 = r100 - r101.getStartIndex();
        Function1<Integer, Object> r103 = r101.getValue().getKey();
        if (r103 == null) goto L7;
        Object r104 = r103.invoke(Integer.valueOf(r102));
        if (r104 == null) goto L7;
        return r104;
    L7:
        return Lazy_androidKt.getDefaultLazyLayoutKey(r100);
    }

    public final <T> T withInterval(int r100, Function2<? super Integer, ? super Interval, ? extends T> r101) {
        IntervalList.Interval<Interval> r102 = getIntervals().get(r100);
        return r101.invoke(Integer.valueOf(r100 - r102.getStartIndex()), r102.getValue());
    }
}
