package H;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.appcompat.app.C0186l;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q.l;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final q.k f675a = new q.k(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f676b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f677c;

    /* renamed from: d, reason: collision with root package name */
    public static final l f678d;

    static {
        k kVar = new k();
        kVar.f685a = "fonts-androidx";
        kVar.f686b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), kVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f676b = threadPoolExecutor;
        f677c = new Object();
        f678d = new l(0);
    }

    public static g a(String str, Context context, d dVar, int i4) throws Throwable {
        q.k kVar = f675a;
        Typeface typeface = (Typeface) kVar.a(str);
        if (typeface != null) {
            return new g(typeface);
        }
        try {
            C0186l c0186lA = c.a(context, dVar);
            int i5 = c0186lA.f2660b;
            int i6 = 1;
            if (i5 != 0) {
                i6 = i5 != 1 ? -3 : -2;
            } else {
                i[] iVarArr = (i[]) c0186lA.f2661c;
                if (iVarArr != null && iVarArr.length != 0) {
                    int length = iVarArr.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            i6 = 0;
                            break;
                        }
                        int i8 = iVarArr[i7].f683e;
                        if (i8 == 0) {
                            i7++;
                        } else if (i8 >= 0) {
                            i6 = i8;
                        }
                    }
                }
            }
            if (i6 != 0) {
                return new g(i6);
            }
            Typeface typefaceH = D.g.f364a.H(context, (i[]) c0186lA.f2661c, i4);
            if (typefaceH == null) {
                return new g(-3);
            }
            kVar.b(str, typefaceH);
            return new g(typefaceH);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(-1);
        }
    }
}
