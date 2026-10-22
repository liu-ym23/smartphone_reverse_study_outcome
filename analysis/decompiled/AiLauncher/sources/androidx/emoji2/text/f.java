package androidx.emoji2.text;

import B0.h;
import O0.g;
import O0.i;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import x0.l;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final P0.b f13805a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f13806b;

    /* renamed from: c, reason: collision with root package name */
    public final a f13807c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f13808d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f13809a;

        /* renamed from: b, reason: collision with root package name */
        public i f13810b;

        public a() {
            this(1);
        }

        public a a(int i10) {
            SparseArray<a> sparseArray = this.f13809a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        public final i b() {
            return this.f13810b;
        }

        public void c(i iVar, int i10, int i11) {
            a aVarA = a(iVar.b(i10));
            if (aVarA == null) {
                aVarA = new a();
                this.f13809a.put(iVar.b(i10), aVarA);
            }
            if (i11 > i10) {
                aVarA.c(iVar, i10 + 1, i11);
            } else {
                aVarA.f13810b = iVar;
            }
        }

        public a(int i10) {
            this.f13809a = new SparseArray<>(i10);
        }
    }

    public f(Typeface typeface, P0.b bVar) {
        this.f13808d = typeface;
        this.f13805a = bVar;
        this.f13806b = new char[bVar.k() * 2];
        a(bVar);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            l.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, g.b(byteBuffer));
        } finally {
            l.b();
        }
    }

    public final void a(P0.b bVar) {
        int iK = bVar.k();
        for (int i10 = 0; i10 < iK; i10++) {
            i iVar = new i(this, i10);
            Character.toChars(iVar.f(), this.f13806b, i10 * 2);
            h(iVar);
        }
    }

    public char[] c() {
        return this.f13806b;
    }

    public P0.b d() {
        return this.f13805a;
    }

    public int e() {
        return this.f13805a.l();
    }

    public a f() {
        return this.f13807c;
    }

    public Typeface g() {
        return this.f13808d;
    }

    public void h(i iVar) {
        h.g(iVar, "emoji metadata cannot be null");
        h.b(iVar.c() > 0, "invalid metadata codepoint length");
        this.f13807c.c(iVar, 0, iVar.c() - 1);
    }
}
