package B8;

import android.graphics.drawable.Drawable;
import u8.r;
import u8.u;

/* loaded from: classes4.dex */
public class g implements u {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f1473a;

    public g(Drawable drawable) {
        this.f1473a = drawable;
    }

    @Override // u8.u
    public Object a(u8.g gVar, r rVar) {
        return new f(gVar.g(), this.f1473a, e.f1472a.b(rVar, Boolean.FALSE).booleanValue());
    }
}
