package androidx.core.graphics;

import C.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.e;
import androidx.core.content.res.h;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final g f9662a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final q.h<String, Typeface> f9663b = new q.h<>(16);

    public static class a extends g.c {

        /* renamed from: a, reason: collision with root package name */
        private h.e f9664a;

        public a(h.e eVar) {
            this.f9664a = eVar;
        }

        @Override // C.g.c
        public void a(int i5) {
            h.e eVar = this.f9664a;
            if (eVar != null) {
                eVar.f(i5);
            }
        }

        @Override // C.g.c
        public void b(Typeface typeface) {
            h.e eVar = this.f9664a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i5) {
        if (context != null) {
            return Typeface.create(typeface, i5);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i5) {
        return f9662a.b(context, cancellationSignal, bVarArr, i5);
    }

    public static Typeface c(Context context, e.b bVar, Resources resources, int i5, String str, int i6, int i7, h.e eVar, Handler handler, boolean z5) {
        Typeface typefaceA;
        if (bVar instanceof e.C0117e) {
            e.C0117e c0117e = (e.C0117e) bVar;
            Typeface typefaceG = g(c0117e.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = C.g.c(context, c0117e.b(), i7, !z5 ? eVar != null : c0117e.a() != 0, z5 ? c0117e.d() : -1, h.e.e(handler), new a(eVar));
        } else {
            typefaceA = f9662a.a(context, (e.c) bVar, resources, i7);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f9663b.d(e(resources, i5, str, i6, i7), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i5, String str, int i6, int i7) {
        Typeface typefaceC = f9662a.c(context, resources, i5, str, i7);
        if (typefaceC != null) {
            f9663b.d(e(resources, i5, str, i6, i7), typefaceC);
        }
        return typefaceC;
    }

    private static String e(Resources resources, int i5, String str, int i6, int i7) {
        return resources.getResourcePackageName(i5) + '-' + str + '-' + i6 + '-' + i5 + '-' + i7;
    }

    public static Typeface f(Resources resources, int i5, String str, int i6, int i7) {
        return f9663b.c(e(resources, i5, str, i6, i7));
    }

    private static Typeface g(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }
}
