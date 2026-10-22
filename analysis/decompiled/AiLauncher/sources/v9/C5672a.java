package v9;

import Z8.AbstractC1171t;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import i9.C4180c;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lv9/a;", "", "", "start", "endInclusive", "", "step", "<init>", "(CCI)V", "LZ8/t;", "e", "()LZ8/t;", Const.INTENT_KEY_APIKEY, "C", Const.INTENT_KEY_PKGNAME, "()C", AMapLocationStaticsEntity.FIRST_LOCATE, "c", "last", "I", "getStep", "()I", Const.INTENT_KEY_UMID, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5672a implements Iterable<Character>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final char first;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final char last;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int step;

    public C5672a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = c10;
        this.last = (char) C4180c.c(c10, c11, i10);
        this.step = i10;
    }

    /* renamed from: b, reason: from getter */
    public final char getFirst() {
        return this.first;
    }

    /* renamed from: c, reason: from getter */
    public final char getLast() {
        return this.last;
    }

    @Override // java.lang.Iterable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC1171t iterator() {
        return new C5673b(this.first, this.last, this.step);
    }
}
