package J1;

import H1.g;
import N1.h;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.common.util.HighContrastRegister;
import dalvik.system.DexFile;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f3198c;

    /* renamed from: a, reason: collision with root package name */
    private Handler f3199a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private Context f3200b;

    /* renamed from: J1.a$a, reason: collision with other inner class name */
    class RunnableC0043a implements Runnable {
        RunnableC0043a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            a.f3198c.g();
        }
    }

    private a(Application application) {
        this.f3200b = application;
    }

    public static void c(Application application) {
        if (application != null && f3198c == null) {
            f3198c = new a(application);
            Log.i("HighContrast_Common", "sInstance init success");
            new Thread(new RunnableC0043a()).start();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("init return application is null :");
            sb.append(application == null);
            Log.i("HighContrast_Common", sb.toString());
        }
    }

    private void e() throws Resources.NotFoundException {
        d(g.f2205u);
        d(g.f2193i);
        d(g.f2206v);
        d(g.f2209y);
        d(g.f2207w);
        d(g.f2208x);
        d(g.f2197m);
        d(g.f2196l);
        d(g.f2198n);
        d(g.f2199o);
        d(g.f2202r);
        d(g.f2210z);
        d(g.f2166B);
        d(g.f2167C);
        d(g.f2169E);
        d(g.f2170F);
        d(g.f2171G);
        d(g.f2172H);
        d(g.f2174J);
        d(g.f2176L);
        d(g.f2177M);
        d(g.f2180P);
        d(g.f2181Q);
    }

    private List<Class> f() throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<String> enumerationEntries = new DexFile(this.f3200b.getPackageCodePath()).entries();
            while (enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (strNextElement.contains("com.stepos.contrast")) {
                    Class<?> cls = Class.forName(strNextElement);
                    if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                        arrayList.add(cls);
                    }
                }
            }
            return arrayList;
        } catch (Exception e6) {
            e6.printStackTrace();
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws Resources.NotFoundException {
        e();
        for (Class cls : f()) {
            try {
                h.a(cls).a(((HighContrastRegister) cls.getAnnotation(HighContrastRegister.class)).registerImpl(), new Class[0]).a(null, new Object[0]);
            } catch (Exception e6) {
                Log.e("HighContrast_Common", BuildConfig.FLAVOR + e6.getMessage());
            }
        }
    }

    public void d(int i5) throws Resources.NotFoundException {
        this.f3200b.getResources().getResourceName(i5);
    }
}
