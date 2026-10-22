package M8;

import O8.h;
import android.text.SpannableStringBuilder;

/* loaded from: classes4.dex */
public class b extends O8.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4655a;

    /* renamed from: b, reason: collision with root package name */
    public final c f4656b;

    /* renamed from: c, reason: collision with root package name */
    public final SpannableStringBuilder f4657c;

    public b(String str, c cVar, SpannableStringBuilder spannableStringBuilder) {
        this.f4655a = str;
        this.f4656b = cVar;
        this.f4657c = spannableStringBuilder;
    }

    @Override // O8.a
    public void b(h.d dVar) {
        int length = this.f4657c.length();
        a(dVar.b());
        int length2 = this.f4657c.length();
        if (length2 != length) {
            this.f4656b.b(this.f4655a, dVar, this.f4657c, length, length2);
        }
    }

    @Override // O8.a
    public void c(h.e eVar) {
        this.f4657c.append((CharSequence) eVar.f());
    }
}
