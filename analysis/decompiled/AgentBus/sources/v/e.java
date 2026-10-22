package v;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f10249a;

    /* renamed from: b, reason: collision with root package name */
    public String f10250b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10251c = false;

    /* renamed from: d, reason: collision with root package name */
    public d f10252d = null;

    public e(String str, String str2) {
        this.f10249a = str;
        this.f10250b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.a(this.f10249a, eVar.f10249a) && k.a(this.f10250b, eVar.f10250b) && this.f10251c == eVar.f10251c && k.a(this.f10252d, eVar.f10252d);
    }

    public final int hashCode() {
        int iE = x.e(x.g(this.f10250b, this.f10249a.hashCode() * 31, 31), 31, this.f10251c);
        d dVar = this.f10252d;
        return iE + (dVar == null ? 0 : dVar.hashCode());
    }

    public final String toString() {
        return "TextSubstitution(layoutCache=" + this.f10252d + ", isShowingSubstitution=" + this.f10251c + ')';
    }
}
