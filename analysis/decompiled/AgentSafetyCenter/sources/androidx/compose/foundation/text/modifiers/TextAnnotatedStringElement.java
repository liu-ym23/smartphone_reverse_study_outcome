package androidx.compose.foundation.text.modifiers;

import c0.h;
import d2.g;
import d2.l0;
import g2.d;
import java.util.List;
import k0.a;
import s.f;
import u1.y0;
import xb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class TextAnnotatedStringElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public g f927c;

    /* renamed from: f, reason: collision with root package name */
    public l0 f928f;

    /* renamed from: g, reason: collision with root package name */
    public d f929g;

    /* renamed from: h, reason: collision with root package name */
    public l f930h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f931j;

    /* renamed from: k, reason: collision with root package name */
    public int f932k;

    /* renamed from: l, reason: collision with root package name */
    public int f933l;

    /* renamed from: m, reason: collision with root package name */
    public List f934m;

    /* renamed from: n, reason: collision with root package name */
    public l f935n;

    /* renamed from: o, reason: collision with root package name */
    public l f936o;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return k.a(this.f927c, textAnnotatedStringElement.f927c) && k.a(this.f928f, textAnnotatedStringElement.f928f) && k.a(this.f934m, textAnnotatedStringElement.f934m) && k.a(this.f929g, textAnnotatedStringElement.f929g) && this.f930h == textAnnotatedStringElement.f930h && this.f936o == textAnnotatedStringElement.f936o && this.i == textAnnotatedStringElement.i && this.f931j == textAnnotatedStringElement.f931j && this.f932k == textAnnotatedStringElement.f932k && this.f933l == textAnnotatedStringElement.f933l && this.f935n == textAnnotatedStringElement.f935n;
    }

    @Override // u1.y0
    public final w0.l g() {
        g gVar = this.f927c;
        l0 l0Var = this.f928f;
        d dVar = this.f929g;
        l lVar = this.f930h;
        int i = this.i;
        boolean z10 = this.f931j;
        int i3 = this.f932k;
        int i10 = this.f933l;
        List list = this.f934m;
        l lVar2 = this.f935n;
        l lVar3 = this.f936o;
        h hVar = new h();
        hVar.f2139s = gVar;
        hVar.f2140t = l0Var;
        hVar.f2141u = dVar;
        hVar.f2142v = lVar;
        hVar.f2143w = i;
        hVar.f2144x = z10;
        hVar.f2145y = i3;
        hVar.f2146z = i10;
        hVar.A = list;
        hVar.B = lVar2;
        hVar.C = lVar3;
        return hVar;
    }

    public final int hashCode() {
        int iHashCode = (this.f929g.hashCode() + ((this.f928f.hashCode() + (this.f927c.hashCode() * 31)) * 31)) * 31;
        l lVar = this.f930h;
        int iH = (((a.h(f.b(this.i, (iHashCode + (lVar != null ? lVar.hashCode() : 0)) * 31, 31), 31, this.f931j) + this.f932k) * 31) + this.f933l) * 31;
        List list = this.f934m;
        int iHashCode2 = (iH + (list != null ? list.hashCode() : 0)) * 31;
        l lVar2 = this.f935n;
        int iHashCode3 = (iHashCode2 + (lVar2 != null ? lVar2.hashCode() : 0)) * 29791;
        l lVar3 = this.f936o;
        return iHashCode3 + (lVar3 != null ? lVar3.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @Override // u1.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(w0.l r14) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement.i(w0.l):void");
    }
}
