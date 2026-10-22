package androidx.collection;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u0086\nJ\t\u0010\u000b\u001a\u00020\u0003H\u0086\nJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/collection/LongLongPair;", "", SoloKtvContext.SOLO_PAGE_FIRST, "", "second", "<init>", "(JJ)V", "getFirst", "()J", "getSecond", "component1", "component2", "equals", "", "other", "hashCode", "", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LongLongPair {
    private final long first;
    private final long second;

    public int hashCode() {
        long r100 = this.first;
        int r101 = (int) (r100 ^ (r100 >>> 32));
        long r102 = this.second;
        return ((int) (r102 ^ (r102 >>> 32))) ^ r101;
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LongLongPair) == true) goto L5;
        return false;
    L5:
        LongLongPair r101 = (LongLongPair) r100;
        if (r101.first == this.first) goto L8;
        return false;
    L8:
        if (r101.second != this.second) goto L12;
        return true;
    L12:
        return false;
    }

    public LongLongPair(long r100, long r101) {
        this.first = r100;
        this.second = r101;
    }
}
