package C;

import C.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import q.i;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    static final q.h<String, Typeface> f260a = new q.h<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f261b = h.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f262c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final i<String, ArrayList<D.a<e>>> f263d = new i<>();

    class a implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f264a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f265b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ C.e f266c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f267d;

        a(String str, Context context, C.e eVar, int i5) {
            this.f264a = str;
            this.f265b = context;
            this.f266c = eVar;
            this.f267d = i5;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f264a, this.f265b, this.f266c, this.f267d);
        }
    }

    class b implements D.a<e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C.a f268a;

        b(C.a aVar) {
            this.f268a = aVar;
        }

        @Override // D.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f268a.b(eVar);
        }
    }

    class c implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f269a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f270b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ C.e f271c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f272d;

        c(String str, Context context, C.e eVar, int i5) {
            this.f269a = str;
            this.f270b = context;
            this.f271c = eVar;
            this.f272d = i5;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f269a, this.f270b, this.f271c, this.f272d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements D.a<e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f273a;

        d(String str) {
            this.f273a = str;
        }

        @Override // D.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f262c) {
                try {
                    i<String, ArrayList<D.a<e>>> iVar = f.f263d;
                    ArrayList<D.a<e>> arrayList = iVar.get(this.f273a);
                    if (arrayList == null) {
                        return;
                    }
                    iVar.remove(this.f273a);
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        arrayList.get(i5).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(C.e eVar, int i5) {
        return eVar.d() + "-" + i5;
    }

    private static int b(g.a aVar) {
        int i5 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i5 = 0;
            for (g.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i5;
    }

    static e c(String str, Context context, C.e eVar, int i5) {
        q.h<String, Typeface> hVar = f260a;
        Typeface typefaceC = hVar.c(str);
        if (typefaceC != null) {
            return new e(typefaceC);
        }
        try {
            g.a aVarE = C.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = androidx.core.graphics.e.b(context, null, aVarE.b(), i5);
            if (typefaceB == null) {
                return new e(-3);
            }
            hVar.d(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(Context context, C.e eVar, int i5, Executor executor, C.a aVar) {
        String strA = a(eVar, i5);
        Typeface typefaceC = f260a.c(strA);
        if (typefaceC != null) {
            aVar.b(new e(typefaceC));
            return typefaceC;
        }
        b bVar = new b(aVar);
        synchronized (f262c) {
            try {
                i<String, ArrayList<D.a<e>>> iVar = f263d;
                ArrayList<D.a<e>> arrayList = iVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList<D.a<e>> arrayList2 = new ArrayList<>();
                arrayList2.add(bVar);
                iVar.put(strA, arrayList2);
                c cVar = new c(strA, context, eVar, i5);
                if (executor == null) {
                    executor = f261b;
                }
                h.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, C.e eVar, C.a aVar, int i5, int i6) {
        String strA = a(eVar, i5);
        Typeface typefaceC = f260a.c(strA);
        if (typefaceC != null) {
            aVar.b(new e(typefaceC));
            return typefaceC;
        }
        if (i6 == -1) {
            e eVarC = c(strA, context, eVar, i5);
            aVar.b(eVarC);
            return eVarC.f274a;
        }
        try {
            e eVar2 = (e) h.c(f261b, new a(strA, context, eVar, i5), i6);
            aVar.b(eVar2);
            return eVar2.f274a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f274a;

        /* renamed from: b, reason: collision with root package name */
        final int f275b;

        e(int i5) {
            this.f274a = null;
            this.f275b = i5;
        }

        boolean a() {
            return this.f275b == 0;
        }

        e(Typeface typeface) {
            this.f274a = typeface;
            this.f275b = 0;
        }
    }
}
