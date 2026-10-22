package z8;

import Zb.d;
import android.text.style.StrikethroughSpan;
import java.util.Collections;
import u8.AbstractC5589a;
import u8.g;
import u8.k;
import u8.m;
import u8.r;
import u8.u;

/* renamed from: z8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6377a extends AbstractC5589a {

    /* renamed from: z8.a$a, reason: collision with other inner class name */
    public class C0566a implements u {
        public C0566a() {
        }

        @Override // u8.u
        public Object a(g gVar, r rVar) {
            return new StrikethroughSpan();
        }
    }

    /* renamed from: z8.a$b */
    public class b implements m.c<Pb.a> {
        public b() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, Pb.a aVar) {
            int length = mVar.length();
            mVar.g(aVar);
            mVar.F(aVar, length);
        }
    }

    public static C6377a l() {
        return new C6377a();
    }

    @Override // u8.AbstractC5589a, u8.i
    public void a(k.a aVar) {
        aVar.a(Pb.a.class, new C0566a());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        bVar.a(Pb.a.class, new b());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void h(d.b bVar) {
        bVar.i(Collections.singleton(Pb.b.c()));
    }
}
