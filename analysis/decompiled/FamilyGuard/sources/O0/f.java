package O0;

import C0.v;
import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import v0.ComponentCallbacks2C1180c;
import z0.k;

/* loaded from: classes.dex */
public class f implements k<c> {

    /* renamed from: b, reason: collision with root package name */
    private final k<Bitmap> f4316b;

    public f(k<Bitmap> kVar) {
        this.f4316b = (k) X0.j.d(kVar);
    }

    @Override // z0.k
    public v<c> a(Context context, v<c> vVar, int i5, int i6) {
        c cVar = vVar.get();
        v<Bitmap> dVar = new K0.d(cVar.e(), ComponentCallbacks2C1180c.c(context).f());
        v<Bitmap> vVarA = this.f4316b.a(context, dVar, i5, i6);
        if (!dVar.equals(vVarA)) {
            dVar.b();
        }
        cVar.m(this.f4316b, vVarA.get());
        return vVar;
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        this.f4316b.b(messageDigest);
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f4316b.equals(((f) obj).f4316b);
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        return this.f4316b.hashCode();
    }
}
