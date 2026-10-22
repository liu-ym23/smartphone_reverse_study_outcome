package androidx.compose.foundation.text.modifiers;

import i1.w0;
import kotlin.Metadata;
import m.x;
import n.f;
import n0.l;
import q7.k;
import s1.h0;
import v.g;
import v1.d;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleElement;", "Li1/w0;", "Lv/g;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextStringSimpleElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f746a;

    /* renamed from: b, reason: collision with root package name */
    public final h0 f747b;

    /* renamed from: c, reason: collision with root package name */
    public final d f748c;

    /* renamed from: d, reason: collision with root package name */
    public final int f749d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f750e;

    /* renamed from: f, reason: collision with root package name */
    public final int f751f;

    /* renamed from: g, reason: collision with root package name */
    public final int f752g;

    public TextStringSimpleElement(String str, h0 h0Var, d dVar, int i2, boolean z4, int i10, int i11) {
        this.f746a = str;
        this.f747b = h0Var;
        this.f748c = dVar;
        this.f749d = i2;
        this.f750e = z4;
        this.f751f = i10;
        this.f752g = i11;
    }

    @Override // i1.w0
    public final l d() {
        g gVar = new g();
        gVar.f10255t = this.f746a;
        gVar.f10256u = this.f747b;
        gVar.f10257v = this.f748c;
        gVar.f10258w = this.f749d;
        gVar.f10259x = this.f750e;
        gVar.f10260y = this.f751f;
        gVar.f10261z = this.f752g;
        return gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return k.a(this.f746a, textStringSimpleElement.f746a) && k.a(this.f747b, textStringSimpleElement.f747b) && k.a(this.f748c, textStringSimpleElement.f748c) && this.f749d == textStringSimpleElement.f749d && this.f750e == textStringSimpleElement.f750e && this.f751f == textStringSimpleElement.f751f && this.f752g == textStringSimpleElement.f752g;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // i1.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(n0.l r11) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextStringSimpleElement.f(n0.l):void");
    }

    public final int hashCode() {
        return (((x.e(f.b(this.f749d, (this.f748c.hashCode() + ((this.f747b.hashCode() + (this.f746a.hashCode() * 31)) * 31)) * 31, 31), 31, this.f750e) + this.f751f) * 31) + this.f752g) * 31;
    }
}
