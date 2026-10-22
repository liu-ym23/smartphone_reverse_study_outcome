package androidx.collection;

import Z8.C1168p;
import c0.C1484d;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0005¨\u0006\u0013"}, d2 = {"Landroidx/collection/m;", "Landroidx/collection/g;", "", "initialCapacity", "<init>", "(I)V", "", "element", "", "c", "(J)Z", "index", "", "elements", Const.INTENT_KEY_UMID, "(I[J)Z", "capacity", "LY8/t;", "e", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m extends g {
    public m(int i10) {
        super(i10, null);
    }

    public final boolean c(long element) {
        e(this._size + 1);
        long[] jArr = this.content;
        int i10 = this._size;
        jArr[i10] = element;
        this._size = i10 + 1;
        return true;
    }

    public final boolean d(int index, long[] elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        if (index < 0 || index > this._size) {
            C1484d.c("");
        }
        if (elements.length == 0) {
            return false;
        }
        e(this._size + elements.length);
        long[] jArr = this.content;
        int i10 = this._size;
        if (index != i10) {
            C1168p.h(jArr, jArr, elements.length + index, index, i10);
        }
        C1168p.m(elements, jArr, index, 0, 0, 12, null);
        this._size += elements.length;
        return true;
    }

    public final void e(int capacity) {
        long[] jArr = this.content;
        if (jArr.length < capacity) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(capacity, (jArr.length * 3) / 2));
            kotlin.jvm.internal.p.h(jArrCopyOf, "copyOf(...)");
            this.content = jArrCopyOf;
        }
    }

    public /* synthetic */ m(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }
}
