package androidx.compose.foundation;

import i1.w0;
import kotlin.Metadata;
import m.x;
import n0.l;
import o.i;
import q7.k;
import u0.c0;
import u0.m;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Li1/w0;", "Lo/i;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class BackgroundElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f704a;

    /* renamed from: b, reason: collision with root package name */
    public final float f705b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f706c;

    public BackgroundElement(long j2, c0 c0Var) {
        this.f704a = j2;
        this.f706c = c0Var;
    }

    @Override // i1.w0
    public final l d() {
        i iVar = new i();
        iVar.f7057t = this.f704a;
        iVar.f7058u = this.f706c;
        iVar.f7059v = 9205357640488583168L;
        return iVar;
    }

    public final boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && m.c(this.f704a, backgroundElement.f704a) && this.f705b == backgroundElement.f705b && k.a(this.f706c, backgroundElement.f706c);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        i iVar = (i) lVar;
        iVar.f7057t = this.f704a;
        iVar.f7058u = this.f706c;
    }

    public final int hashCode() {
        int i2 = m.f9917g;
        return this.f706c.hashCode() + x.d(this.f705b, Long.hashCode(this.f704a) * 961, 31);
    }
}
