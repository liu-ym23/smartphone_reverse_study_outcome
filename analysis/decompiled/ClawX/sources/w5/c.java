package w5;

import c5.y;
import java.util.Iterator;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements i, d {

    /* renamed from: a, reason: collision with root package name */
    public final i f6205a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6206b;

    public c(i sequence, int i8) {
        p.e(sequence, "sequence");
        this.f6205a = sequence;
        this.f6206b = i8;
        if (i8 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i8 + '.').toString());
    }

    @Override // w5.d
    public final i a(int i8) {
        int i9 = this.f6206b + i8;
        return i9 < 0 ? new c(this, i8) : new c(this.f6205a, i9);
    }

    @Override // w5.i
    public final Iterator iterator() {
        return new y(this);
    }
}
