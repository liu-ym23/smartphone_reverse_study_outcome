package y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements t1.g {
    public static final n i = new n();

    /* renamed from: c, reason: collision with root package name */
    public x.d f15810c;

    /* renamed from: f, reason: collision with root package name */
    public stepos.support.v7.app.f f15811f;

    /* renamed from: g, reason: collision with root package name */
    public o2.l f15812g;

    /* renamed from: h, reason: collision with root package name */
    public u.f0 f15813h;

    public final boolean g(m mVar, int i3) {
        u.f0 f0Var = this.f15813h;
        if (i3 == 5 || i3 == 6) {
            if (f0Var == u.f0.f13454f) {
                return false;
            }
        } else if (i3 == 3 || i3 == 4) {
            if (f0Var == u.f0.f13453c) {
                return false;
            }
        } else if (i3 != 1 && i3 != 2) {
            od.f.e("Lazy list does not support beyond bounds layout for the specified direction");
            return false;
        }
        if (i(i3)) {
            if (mVar.f15789b >= this.f15810c.f15404a.i().f15450m - 1) {
                return false;
            }
        } else if (mVar.f15788a <= 0) {
            return false;
        }
        return true;
    }

    @Override // t1.g
    public final t1.i getKey() {
        return s1.f.f11240a;
    }

    public final boolean i(int i3) {
        o2.l lVar = this.f15812g;
        if (i3 == 1) {
            return false;
        }
        if (i3 != 2) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 == 3) {
                        int iOrdinal = lVar.ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal != 1) {
                                g5.f.a();
                                return false;
                            }
                        }
                    } else {
                        if (i3 != 4) {
                            od.f.e("Lazy list does not support beyond bounds layout for the specified direction");
                            return false;
                        }
                        int iOrdinal2 = lVar.ordinal();
                        if (iOrdinal2 != 0) {
                            if (iOrdinal2 != 1) {
                                g5.f.a();
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // t1.g
    public final Object getValue() {
        return this;
    }
}
