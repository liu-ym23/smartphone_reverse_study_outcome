package l4;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final m4.c f3804a;

    /* renamed from: b, reason: collision with root package name */
    public int f3805b;

    /* renamed from: c, reason: collision with root package name */
    public int f3806c;
    public c d;

    public d(m4.c builder) {
        p.e(builder, "builder");
        this.f3804a = builder;
        this.d = (c) e.f3808b.p();
    }

    public final m4.b a(String str) {
        if (this.f3805b == 0) {
            return null;
        }
        int i8 = m4.f.f3907a;
        int iAbs = Math.abs(m4.f.a(str, 0, str.length()));
        int i9 = this.f3806c;
        while (true) {
            int i10 = iAbs % i9;
            int i11 = i10 * 6;
            if (this.d.a(i11) == -1) {
                return null;
            }
            if (b(str, i11)) {
                return (m4.b) this.f3804a.subSequence(this.d.a(i11 + 3), this.d.a(i11 + 4));
            }
            iAbs = i10 + 1;
            i9 = this.f3806c;
        }
    }

    public final boolean b(CharSequence charSequence, int i8) {
        int iA = this.d.a(i8 + 1);
        int iA2 = this.d.a(i8 + 2);
        int i9 = m4.f.f3907a;
        m4.c cVar = this.f3804a;
        p.e(cVar, "<this>");
        if (iA2 - iA != charSequence.length()) {
            return false;
        }
        for (int i10 = iA; i10 < iA2; i10++) {
            int iCharAt = cVar.charAt(i10);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            int iCharAt2 = charSequence.charAt(i10 - iA);
            if (65 <= iCharAt2 && iCharAt2 < 91) {
                iCharAt2 += 32;
            }
            if (iCharAt != iCharAt2) {
                return false;
            }
        }
        return true;
    }

    public final void c(int i8, int i9, int i10, int i11) {
        int i12;
        int i13 = this.f3805b;
        double d = i13;
        int i14 = this.f3806c;
        if (d >= i14 * 0.75d) {
            c cVar = this.d;
            this.f3805b = 0;
            this.f3806c = (i14 * 2) | 128;
            c cVar2 = (c) e.f3808b.p();
            int size = (cVar.f3803a.size() * 2) | 1;
            for (int i15 = 0; i15 < size; i15++) {
                cVar2.f3803a.add(e.f3807a.p());
            }
            this.d = cVar2;
            b bVar = new b(cVar, null);
            w5.j jVar = new w5.j();
            jVar.f6220c = b8.h.k(jVar, jVar, bVar);
            while (jVar.hasNext()) {
                int iIntValue = ((Number) jVar.next()).intValue();
                c(cVar.a(iIntValue + 1), cVar.a(iIntValue + 2), cVar.a(iIntValue + 3), cVar.a(iIntValue + 4));
            }
            e.f3808b.y(cVar);
            if (i13 != this.f3805b) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        m4.c cVar3 = this.f3804a;
        int iAbs = Math.abs(m4.f.a(cVar3, i8, i9));
        CharSequence charSequenceSubSequence = cVar3.subSequence(i8, i9);
        int i16 = iAbs % this.f3806c;
        int i17 = -1;
        while (true) {
            i12 = i16 * 6;
            if (this.d.a(i12) == -1) {
                break;
            }
            if (b(charSequenceSubSequence, i12)) {
                i17 = i16;
            }
            i16 = (i16 + 1) % this.f3806c;
        }
        this.d.b(i12, iAbs);
        this.d.b(i12 + 1, i8);
        this.d.b(i12 + 2, i9);
        this.d.b(i12 + 3, i10);
        this.d.b(i12 + 4, i11);
        this.d.b(i12 + 5, -1);
        if (i17 != -1) {
            this.d.b((i17 * 6) + 5, i16);
        }
        this.f3805b++;
    }

    public final void d() {
        this.f3805b = 0;
        this.f3806c = 0;
        a5.a aVar = e.f3808b;
        aVar.y(this.d);
        this.d = (c) aVar.p();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        a5.a aVar = e.f3807a;
        c cVar = this.d;
        cVar.getClass();
        b bVar = new b(cVar, null);
        w5.j jVar = new w5.j();
        jVar.f6220c = b8.h.k(jVar, jVar, bVar);
        while (jVar.hasNext()) {
            int iIntValue = ((Number) jVar.next()).intValue();
            sb.append((CharSequence) SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            int iA = this.d.a(iIntValue + 1);
            int iA2 = this.d.a(iIntValue + 2);
            sb.append(this.f3804a.subSequence(iA, iA2));
            sb.append((CharSequence) " => ");
            sb.append(r5.subSequence(this.d.a(iIntValue + 3), this.d.a(iIntValue + 4)));
            sb.append((CharSequence) "\n");
        }
        return sb.toString();
    }
}
