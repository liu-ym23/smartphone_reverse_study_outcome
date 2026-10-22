package w4;

import android.graphics.Typeface;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends androidx.datastore.preferences.protobuf.f {

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f13578b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.b f13579c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13580d;

    public a(androidx.lifecycle.b bVar, Typeface typeface) {
        this.f13578b = typeface;
        this.f13579c = bVar;
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final void g(int i10) {
        if (this.f13580d) {
            return;
        }
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.f13579c.h;
        if (bVar.l(this.f13578b)) {
            bVar.j(false);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final void h(Typeface typeface, boolean z) {
        if (this.f13580d) {
            return;
        }
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.f13579c.h;
        if (bVar.l(typeface)) {
            bVar.j(false);
        }
    }
}
