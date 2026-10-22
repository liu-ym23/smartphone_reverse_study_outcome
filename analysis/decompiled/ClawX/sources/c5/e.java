package c5;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends f implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final f f1081a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1082b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1083c;

    public e(f fVar, int i8, int i9) {
        this.f1081a = fVar;
        this.f1082b = i8;
        a.a.k(i8, i9, fVar.f());
        this.f1083c = i9 - i8;
    }

    @Override // c5.b
    public final int f() {
        return this.f1083c;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        int i9 = this.f1083c;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return this.f1081a.get(this.f1082b + i8);
    }

    @Override // c5.f, java.util.List
    public final List subList(int i8, int i9) {
        a.a.k(i8, i9, this.f1083c);
        int i10 = this.f1082b;
        return new e(this.f1081a, i8 + i10, i10 + i9);
    }
}
