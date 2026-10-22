package androidx.compose.ui.semantics;

import i1.w0;
import kotlin.Metadata;
import n0.k;
import n0.l;
import p1.b;
import q7.m;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/semantics/AppendedSemanticsElement;", "Li1/w0;", "Lp1/b;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppendedSemanticsElement extends w0 implements k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f774a;

    /* renamed from: b, reason: collision with root package name */
    public final m f775b;

    /* JADX WARN: Multi-variable type inference failed */
    public AppendedSemanticsElement(p7.k kVar, boolean z4) {
        this.f774a = z4;
        this.f775b = (m) kVar;
    }

    @Override // i1.w0
    public final l d() {
        b bVar = new b();
        bVar.f8268t = this.f774a;
        bVar.f8269u = this.f775b;
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        return this.f774a == appendedSemanticsElement.f774a && this.f775b == appendedSemanticsElement.f775b;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        b bVar = (b) lVar;
        bVar.f8268t = this.f774a;
        bVar.f8269u = this.f775b;
    }

    public final int hashCode() {
        return this.f775b.hashCode() + (Boolean.hashCode(this.f774a) * 31);
    }
}
