package fb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u001a-\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lfb/a;", "", "byte", "", "startIndex", "endIndex", Const.INTENT_KEY_APIKEY, "(Lfb/a;BJJ)J", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4076c {
    public static final long a(C4074a c4074a, byte b10, long j10, long j11) {
        long j12;
        long j13;
        kotlin.jvm.internal.p.i(c4074a, "<this>");
        long jMin = Math.min(j11, c4074a.n());
        z.a(c4074a.n(), j10, jMin);
        if (j10 == jMin || c4074a.getHead() == null) {
            return -1L;
        }
        if (c4074a.n() - j10 < j10) {
            o tail = c4074a.getTail();
            j12 = c4074a.n();
            while (tail != null && j12 > j10) {
                j12 -= tail.getLimit() - tail.getPos();
                if (j12 <= j10) {
                    break;
                }
                tail = tail.getPrev();
            }
            if (j12 == -1) {
                return -1L;
            }
            while (jMin > j12) {
                kotlin.jvm.internal.p.f(tail);
                int iA = q.a(tail, b10, Math.max((int) (j10 - j12), 0), Math.min(tail.j(), (int) (jMin - j12)));
                if (iA != -1) {
                    j13 = iA;
                } else {
                    j12 += tail.j();
                    tail = tail.getNext();
                    if (tail == null || j12 >= jMin) {
                        return -1L;
                    }
                }
            }
            throw new IllegalStateException("Check failed.");
        }
        o head = c4074a.getHead();
        j12 = 0;
        while (head != null) {
            long limit = (head.getLimit() - head.getPos()) + j12;
            if (limit > j10) {
                break;
            }
            head = head.getNext();
            j12 = limit;
        }
        if (j12 == -1) {
            return -1L;
        }
        while (jMin > j12) {
            kotlin.jvm.internal.p.f(head);
            int iA2 = q.a(head, b10, Math.max((int) (j10 - j12), 0), Math.min(head.j(), (int) (jMin - j12)));
            if (iA2 != -1) {
                j13 = iA2;
            } else {
                j12 += head.j();
                head = head.getNext();
                if (head == null || j12 >= jMin) {
                    return -1L;
                }
            }
        }
        throw new IllegalStateException("Check failed.");
        return j12 + j13;
    }

    public static /* synthetic */ long b(C4074a c4074a, byte b10, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = c4074a.n();
        }
        return a(c4074a, b10, j12, j11);
    }
}
