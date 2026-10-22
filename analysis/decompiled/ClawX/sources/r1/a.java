package r1;

import android.graphics.Typeface;
import androidx.emoji2.text.m;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends z {

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f5065b;

    /* renamed from: c, reason: collision with root package name */
    public final m f5066c;
    public boolean d;

    public a(m mVar, Typeface typeface) {
        this.f5065b = typeface;
        this.f5066c = mVar;
    }

    @Override // k4.z
    public final void A(Typeface typeface, boolean z) {
        if (this.d) {
            return;
        }
        p1.b bVar = (p1.b) this.f5066c.f621a;
        if (bVar.l(typeface)) {
            bVar.j(false);
        }
    }

    @Override // k4.z
    public final void z(int i8) {
        if (this.d) {
            return;
        }
        p1.b bVar = (p1.b) this.f5066c.f621a;
        if (bVar.l(this.f5065b)) {
            bVar.j(false);
        }
    }
}
