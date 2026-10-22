package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final j1.b f1966a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f1967b;

    /* renamed from: c, reason: collision with root package name */
    public final a f1968c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f1969d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f1970a;

        /* renamed from: b, reason: collision with root package name */
        public i1.g f1971b;

        public a() {
            this(1);
        }

        public final void a(i1.g gVar, int i10, int i11) {
            int iA = gVar.a(i10);
            SparseArray<a> sparseArray = this.f1970a;
            a aVar = sparseArray == null ? null : sparseArray.get(iA);
            if (aVar == null) {
                aVar = new a();
                sparseArray.put(gVar.a(i10), aVar);
            }
            if (i11 > i10) {
                aVar.a(gVar, i10 + 1, i11);
            } else {
                aVar.f1971b = gVar;
            }
        }

        public a(int i10) {
            this.f1970a = new SparseArray<>(i10);
        }
    }

    public h(Typeface typeface, j1.b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        this.f1969d = typeface;
        this.f1966a = bVar;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i14 = iA + bVar.f9652a;
            i10 = bVar.f9653b.getInt(bVar.f9653b.getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        this.f1967b = new char[i10 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i15 = iA2 + bVar.f9652a;
            i11 = bVar.f9653b.getInt(bVar.f9653b.getInt(i15) + i15);
        } else {
            i11 = 0;
        }
        for (int i16 = 0; i16 < i11; i16++) {
            i1.g gVar = new i1.g(this, i16);
            j1.a aVarB = gVar.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? aVarB.f9653b.getInt(iA3 + aVarB.f9652a) : 0, this.f1967b, i16 * 2);
            j1.a aVarB2 = gVar.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i17 = iA4 + aVarB2.f9652a;
                i12 = aVarB2.f9653b.getInt(aVarB2.f9653b.getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            y.l("invalid metadata codepoint length", i12 > 0);
            a aVar = this.f1968c;
            j1.a aVarB3 = gVar.b();
            int iA5 = aVarB3.a(16);
            if (iA5 != 0) {
                int i18 = iA5 + aVarB3.f9652a;
                i13 = aVarB3.f9653b.getInt(aVarB3.f9653b.getInt(i18) + i18);
            } else {
                i13 = 0;
            }
            aVar.a(gVar, 0, i13 - 1);
        }
    }
}
