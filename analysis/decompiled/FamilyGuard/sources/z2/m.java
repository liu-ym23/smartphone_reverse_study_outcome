package z2;

import A2.C0269h;
import android.content.Context;

/* loaded from: classes.dex */
public class m extends g {

    /* renamed from: e, reason: collision with root package name */
    private int[] f24066e;

    public m(int[] iArr) {
        this.f24066e = iArr;
    }

    @Override // z2.e
    public void d(Context context, int i5, y2.g gVar) {
        if (gVar instanceof A2.m) {
            f fVarB = b();
            ((A2.m) gVar).f((float) (fVarB.e(i5) / fVarB.a()));
        }
    }

    @Override // z2.e
    public y2.g f(Context context, int i5) {
        C0269h c0269h;
        int[] iArr = this.f24066e;
        if (iArr != null) {
            c0269h = new C0269h(context, iArr);
            c0269h.p(g());
        } else {
            c0269h = null;
        }
        d(context, i5, c0269h);
        return c0269h;
    }
}
