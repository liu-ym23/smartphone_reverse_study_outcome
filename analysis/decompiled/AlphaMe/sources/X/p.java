package X;

import android.text.Spannable;
import android.text.SpannableString;

/* loaded from: classes.dex */
public final class p implements q {

    /* renamed from: a, reason: collision with root package name */
    public D f2073a;

    /* renamed from: b, reason: collision with root package name */
    public final y1.f f2074b;

    public p(D d4, y1.f fVar) {
        this.f2073a = d4;
        this.f2074b = fVar;
    }

    @Override // X.q
    public final Object b() {
        return this.f2073a;
    }

    @Override // X.q
    public final boolean c(CharSequence charSequence, int i4, int i5, B b4) {
        if ((b4.f2036c & 4) > 0) {
            return true;
        }
        if (this.f2073a == null) {
            this.f2073a = new D(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        this.f2074b.getClass();
        this.f2073a.setSpan(new C(b4), i4, i5, 33);
        return true;
    }
}
