package y0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.l;
import androidx.collection.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o1.C4996a;
import y0.g;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final l<String, Typeface> f43768a = new l<>(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f43769b = h.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f43770c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final t<String, ArrayList<B0.a<e>>> f43771d = new t<>();

    public class a implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f43772a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f43773b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y0.e f43774c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f43775d;

        public a(String str, Context context, y0.e eVar, int i10) {
            this.f43772a = str;
            this.f43773b = context;
            this.f43774c = eVar;
            this.f43775d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f43772a, this.f43773b, List.of(this.f43774c), this.f43775d);
        }
    }

    public class b implements B0.a<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C5915a f43776a;

        public b(C5915a c5915a) {
            this.f43776a = c5915a;
        }

        @Override // B0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f43776a.b(eVar);
        }
    }

    public class c implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f43777a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f43778b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f43779c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f43780d;

        public c(String str, Context context, List list, int i10) {
            this.f43777a = str;
            this.f43778b = context;
            this.f43779c = list;
            this.f43780d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f43777a, this.f43778b, this.f43779c, this.f43780d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements B0.a<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f43781a;

        public d(String str) {
            this.f43781a = str;
        }

        @Override // B0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f43770c) {
                try {
                    t<String, ArrayList<B0.a<e>>> tVar = f.f43771d;
                    ArrayList<B0.a<e>> arrayList = tVar.get(this.f43781a);
                    if (arrayList == null) {
                        return;
                    }
                    tVar.remove(this.f43781a);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        arrayList.get(i10).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(List<y0.e> list, int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(list.get(i11).d());
            sb2.append(O6.l.DATE_SEPARATOR);
            sb2.append(i10);
            if (i11 < list.size() - 1) {
                sb2.append(Const.STR_MART_SEMICOLON);
            }
        }
        return sb2.toString();
    }

    @SuppressLint({"WrongConstant"})
    public static int b(g.a aVar) {
        int i10 = 1;
        if (aVar.e() != 0) {
            return aVar.e() != 1 ? -3 : -2;
        }
        g.b[] bVarArrC = aVar.c();
        if (bVarArrC != null && bVarArrC.length != 0) {
            i10 = 0;
            for (g.b bVar : bVarArrC) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i10;
    }

    public static e c(String str, Context context, List<y0.e> list, int i10) {
        C4996a.a("getFontSync");
        try {
            l<String, Typeface> lVar = f43768a;
            Typeface typeface = lVar.get(str);
            if (typeface != null) {
                return new e(typeface);
            }
            g.a aVarE = y0.d.e(context, list, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceC = aVarE.f() ? t0.h.c(context, null, aVarE.d(), i10) : t0.h.b(context, null, aVarE.c(), i10);
            if (typefaceC == null) {
                return new e(-3);
            }
            lVar.put(str, typefaceC);
            return new e(typefaceC);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            C4996a.b();
        }
    }

    public static Typeface d(Context context, List<y0.e> list, int i10, Executor executor, C5915a c5915a) {
        String strA = a(list, i10);
        Typeface typeface = f43768a.get(strA);
        if (typeface != null) {
            c5915a.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(c5915a);
        synchronized (f43770c) {
            try {
                t<String, ArrayList<B0.a<e>>> tVar = f43771d;
                ArrayList<B0.a<e>> arrayList = tVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList<B0.a<e>> arrayList2 = new ArrayList<>();
                arrayList2.add(bVar);
                tVar.put(strA, arrayList2);
                c cVar = new c(strA, context, list, i10);
                if (executor == null) {
                    executor = f43769b;
                }
                h.c(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, y0.e eVar, C5915a c5915a, int i10, int i11) {
        String strA = a(List.of(eVar), i10);
        Typeface typeface = f43768a.get(strA);
        if (typeface != null) {
            c5915a.b(new e(typeface));
            return typeface;
        }
        if (i11 == -1) {
            e eVarC = c(strA, context, List.of(eVar), i10);
            c5915a.b(eVarC);
            return eVarC.f43782a;
        }
        try {
            e eVar2 = (e) h.d(f43769b, new a(strA, context, eVar, i10), i11);
            c5915a.b(eVar2);
            return eVar2.f43782a;
        } catch (InterruptedException unused) {
            c5915a.b(new e(-3));
            return null;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f43782a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43783b;

        public e(int i10) {
            this.f43782a = null;
            this.f43783b = i10;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f43783b == 0;
        }

        @SuppressLint({"WrongConstant"})
        public e(Typeface typeface) {
            this.f43782a = typeface;
            this.f43783b = 0;
        }
    }
}
