package K0;

import C0.v;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import z0.C1342h;

/* loaded from: classes.dex */
public class o implements z0.i<Uri, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final M0.d f3560a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.d f3561b;

    public o(M0.d dVar, D0.d dVar2) {
        this.f3560a = dVar;
        this.f3561b = dVar2;
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Bitmap> a(Uri uri, int i5, int i6, C1342h c1342h) {
        v<Drawable> vVarA = this.f3560a.a(uri, i5, i6, c1342h);
        if (vVarA == null) {
            return null;
        }
        return i.a(this.f3561b, vVarA.get(), i5, i6);
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, C1342h c1342h) {
        return "android.resource".equals(uri.getScheme());
    }
}
