package H4;

import android.view.ViewGroup;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f735a;
    public final boolean b;
    public final boolean c;

    public c(ViewGroup viewGroup, boolean z10, boolean z11) {
        this.f735a = viewGroup;
        this.b = z10;
        this.c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.k.b(this.f735a, cVar.f735a) && this.b == cVar.b && this.c == cVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + androidx.appfunctions.metadata.a.d(this.f735a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClipState(view=");
        sb.append(this.f735a);
        sb.append(", children=");
        sb.append(this.b);
        sb.append(", padding=");
        return B7.a.s(sb, this.c, ")");
    }
}
