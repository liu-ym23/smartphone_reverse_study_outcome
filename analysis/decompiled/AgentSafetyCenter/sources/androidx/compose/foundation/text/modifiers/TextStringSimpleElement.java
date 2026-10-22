package androidx.compose.foundation.text.modifiers;

import d2.l0;
import g2.d;
import k0.a;
import s.f;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class TextStringSimpleElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public String f937c;

    /* renamed from: f, reason: collision with root package name */
    public l0 f938f;

    /* renamed from: g, reason: collision with root package name */
    public d f939g;

    /* renamed from: h, reason: collision with root package name */
    public int f940h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f941j;

    /* renamed from: k, reason: collision with root package name */
    public int f942k;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return k.a(this.f937c, textStringSimpleElement.f937c) && k.a(this.f938f, textStringSimpleElement.f938f) && k.a(this.f939g, textStringSimpleElement.f939g) && this.f940h == textStringSimpleElement.f940h && this.i == textStringSimpleElement.i && this.f941j == textStringSimpleElement.f941j && this.f942k == textStringSimpleElement.f942k;
    }

    @Override // u1.y0
    public final l g() {
        String str = this.f937c;
        l0 l0Var = this.f938f;
        d dVar = this.f939g;
        int i = this.f940h;
        boolean z10 = this.i;
        int i3 = this.f941j;
        int i10 = this.f942k;
        c0.k kVar = new c0.k();
        kVar.f2153s = str;
        kVar.f2154t = l0Var;
        kVar.f2155u = dVar;
        kVar.f2156v = i;
        kVar.f2157w = z10;
        kVar.f2158x = i3;
        kVar.f2159y = i10;
        return kVar;
    }

    public final int hashCode() {
        return (((a.h(f.b(this.f940h, (this.f939g.hashCode() + ((this.f938f.hashCode() + (this.f937c.hashCode() * 31)) * 31)) * 31, 31), 31, this.i) + this.f941j) * 31) + this.f942k) * 31;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // u1.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(w0.l r13) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleElement.i(w0.l):void");
    }
}
