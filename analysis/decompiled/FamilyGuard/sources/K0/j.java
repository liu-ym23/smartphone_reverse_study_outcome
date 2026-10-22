package K0;

import C0.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;
import v0.ComponentCallbacks2C1180c;

/* loaded from: classes.dex */
public class j implements z0.k<Drawable> {

    /* renamed from: b, reason: collision with root package name */
    private final z0.k<Bitmap> f3546b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3547c;

    public j(z0.k<Bitmap> kVar, boolean z5) {
        this.f3546b = kVar;
        this.f3547c = z5;
    }

    private v<Drawable> d(Context context, v<Bitmap> vVar) {
        return m.f(context.getResources(), vVar);
    }

    @Override // z0.k
    public v<Drawable> a(Context context, v<Drawable> vVar, int i5, int i6) {
        D0.d dVarF = ComponentCallbacks2C1180c.c(context).f();
        Drawable drawable = vVar.get();
        v<Bitmap> vVarA = i.a(dVarF, drawable, i5, i6);
        if (vVarA != null) {
            v<Bitmap> vVarA2 = this.f3546b.a(context, vVarA, i5, i6);
            if (!vVarA2.equals(vVarA)) {
                return d(context, vVarA2);
            }
            vVarA2.b();
            return vVar;
        }
        if (!this.f3547c) {
            return vVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        this.f3546b.b(messageDigest);
    }

    public z0.k<BitmapDrawable> c() {
        return this;
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f3546b.equals(((j) obj).f3546b);
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        return this.f3546b.hashCode();
    }
}
