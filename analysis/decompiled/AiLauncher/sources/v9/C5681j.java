package v9;

import Z8.N;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import i9.C4180c;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0014"}, d2 = {"Lv9/j;", "", "", "start", "endInclusive", "step", "<init>", "(JJJ)V", "LZ8/N;", "e", "()LZ8/N;", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", AMapLocationStaticsEntity.FIRST_LOCATE, "c", "last", "getStep", Const.INTENT_KEY_UMID, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5681j implements Iterable<Long>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long first;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long last;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long step;

    public C5681j(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = j10;
        this.last = C4180c.d(j10, j11, j12);
        this.step = j12;
    }

    /* renamed from: b, reason: from getter */
    public final long getFirst() {
        return this.first;
    }

    /* renamed from: c, reason: from getter */
    public final long getLast() {
        return this.last;
    }

    @Override // java.lang.Iterable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public N iterator() {
        return new C5682k(this.first, this.last, this.step);
    }
}
