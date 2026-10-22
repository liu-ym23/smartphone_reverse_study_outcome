package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Q.b f10367a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f10368b;

    /* renamed from: c, reason: collision with root package name */
    private final a f10369c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    private final Typeface f10370d;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<a> f10371a;

        /* renamed from: b, reason: collision with root package name */
        private o f10372b;

        private a() {
            this(1);
        }

        a a(int i5) {
            SparseArray<a> sparseArray = this.f10371a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i5);
        }

        final o b() {
            return this.f10372b;
        }

        void c(o oVar, int i5, int i6) {
            a aVarA = a(oVar.b(i5));
            if (aVarA == null) {
                aVarA = new a();
                this.f10371a.put(oVar.b(i5), aVarA);
            }
            if (i6 > i5) {
                aVarA.c(oVar, i5 + 1, i6);
            } else {
                aVarA.f10372b = oVar;
            }
        }

        a(int i5) {
            this.f10371a = new SparseArray<>(i5);
        }
    }

    private m(Typeface typeface, Q.b bVar) {
        this.f10370d = typeface;
        this.f10367a = bVar;
        this.f10368b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(Q.b bVar) {
        int iK = bVar.k();
        for (int i5 = 0; i5 < iK; i5++) {
            o oVar = new o(this, i5);
            Character.toChars(oVar.f(), this.f10368b, i5 * 2);
            h(oVar);
        }
    }

    public static m b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            androidx.core.os.i.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            androidx.core.os.i.b();
        }
    }

    public char[] c() {
        return this.f10368b;
    }

    public Q.b d() {
        return this.f10367a;
    }

    int e() {
        return this.f10367a.l();
    }

    a f() {
        return this.f10369c;
    }

    Typeface g() {
        return this.f10370d;
    }

    void h(o oVar) {
        D.h.f(oVar, "emoji metadata cannot be null");
        D.h.b(oVar.c() > 0, "invalid metadata codepoint length");
        this.f10369c.c(oVar, 0, oVar.c() - 1);
    }
}
