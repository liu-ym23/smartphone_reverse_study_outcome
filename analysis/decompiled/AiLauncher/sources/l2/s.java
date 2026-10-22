package l2;

import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class s implements B.d {

    /* renamed from: a, reason: collision with root package name */
    public final H f36933a;

    public s(H h10) {
        this.f36933a = h10;
    }

    public static B.d a(H h10) {
        return new s(h10);
    }

    @Override // l2.B.d
    public Object produce() {
        return this.f36933a.getWritableDatabase();
    }
}
