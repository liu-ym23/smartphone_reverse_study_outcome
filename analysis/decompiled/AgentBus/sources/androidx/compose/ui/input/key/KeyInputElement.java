package androidx.compose.ui.input.key;

import a1.e;
import i1.w0;
import j1.u;
import kotlin.Metadata;
import n0.l;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputElement;", "Li1/w0;", "La1/e;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class KeyInputElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final u f764a;

    public KeyInputElement(u uVar) {
        this.f764a = uVar;
    }

    @Override // i1.w0
    public final l d() {
        e eVar = new e();
        eVar.f156t = this.f764a;
        return eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyInputElement) {
            return this.f764a == ((KeyInputElement) obj).f764a;
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        ((e) lVar).f156t = this.f764a;
    }

    public final int hashCode() {
        return this.f764a.hashCode() * 31;
    }
}
