package B8;

import Zb.d;
import android.graphics.drawable.Drawable;
import u8.AbstractC5589a;
import u8.k;
import u8.m;

/* loaded from: classes4.dex */
public class c extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f1469a;

    public class a implements m.c<b> {
        public a() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, b bVar) {
            int length = mVar.length();
            mVar.g(bVar);
            e.f1472a.e(mVar.r(), Boolean.valueOf(bVar.n()));
            mVar.b(bVar, length);
            if (mVar.h(bVar)) {
                mVar.C();
            }
        }
    }

    public c(Drawable drawable) {
        this.f1469a = drawable;
    }

    public static c l(Drawable drawable) {
        return new c(drawable);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void a(k.a aVar) {
        aVar.a(b.class, new g(this.f1469a));
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        bVar.a(b.class, new a());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void h(d.b bVar) {
        bVar.l(new d());
    }
}
