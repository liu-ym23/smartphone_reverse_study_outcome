package u8;

import Yb.x;
import u8.m;

/* loaded from: classes4.dex */
public class t extends AbstractC5589a {

    public class a implements m.c<x> {
        public a() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, x xVar) {
            mVar.C();
        }
    }

    public static t l() {
        return new t();
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        bVar.a(x.class, new a());
    }
}
