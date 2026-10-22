package w1;

import android.graphics.Typeface;
import com.google.android.gms.common.api.internal.p;
import f1.AbstractC0557a;

/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0970a extends AbstractC0557a {

    /* renamed from: i, reason: collision with root package name */
    public final Typeface f15804i;

    /* renamed from: j, reason: collision with root package name */
    public final p f15805j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15806k;

    public C0970a(p pVar, Typeface typeface) {
        this.f15804i = typeface;
        this.f15805j = pVar;
    }

    @Override // f1.AbstractC0557a
    public final void O(int i4) {
        if (this.f15806k) {
            return;
        }
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.f15805j.f9664b;
        if (bVar.l(this.f15804i)) {
            bVar.j(false);
        }
    }

    @Override // f1.AbstractC0557a
    public final void P(Typeface typeface, boolean z4) {
        if (this.f15806k) {
            return;
        }
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.f15805j.f9664b;
        if (bVar.l(typeface)) {
            bVar.j(false);
        }
    }
}
