package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0010J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00020\u0004H¦\u0002J6\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u000b0\u000fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/IntervalList;", ExifInterface.GPS_DIRECTION_TRUE, "", "size", "", "getSize", "()I", MonitorConstants.CONNECT_TYPE_GET, "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "index", "forEach", "", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "Interval", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IntervalList<T> {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.IntervalList$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static /* synthetic */ void forEach$default(IntervalList r100, int r101, int r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.getSize() - 1;
        L9:
            r100.forEach(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forEach");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", ExifInterface.GPS_DIRECTION_TRUE, "", "startIndex", "", "size", "value", "<init>", "(IILjava/lang/Object;)V", "getStartIndex", "()I", "getSize", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Interval<T> {
        public static final int $stable = 0;
        private final int size;
        private final int startIndex;
        private final T value;

        public final int getSize() {
            return this.size;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final T getValue() {
            return this.value;
        }

        public Interval(int r100, int r101, T r102) {
            this.startIndex = r100;
            this.size = r101;
            this.value = r102;
            boolean r103 = true;
            if (r100 < 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("startIndex should be >= 0");
        L8:
            if (r101 > 0) goto L11;
            r103 = false;
        L11:
            if (r103 == true) goto L14;
            InlineClassHelperKt.throwIllegalArgumentException("size should be > 0");
            return;
        L14:
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    void forEach(int r100, int r101, Function1<? super Interval<? extends T>, Unit> r102);

    Interval<T> get(int r100);

    int getSize();
}
