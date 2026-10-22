package Q8;

import com.zyql.ai.selector.config.PictureConfig;
import io.objectbox.BoxStore;
import io.objectbox.EntityInfo;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public File f5437c;

    /* renamed from: d, reason: collision with root package name */
    public File f5438d;

    /* renamed from: e, reason: collision with root package name */
    public String f5439e;

    /* renamed from: f, reason: collision with root package name */
    public String f5440f;

    /* renamed from: h, reason: collision with root package name */
    public long f5442h;

    /* renamed from: i, reason: collision with root package name */
    public Object f5443i;

    /* renamed from: j, reason: collision with root package name */
    public Object f5444j;

    /* renamed from: k, reason: collision with root package name */
    public int f5445k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5446l;

    /* renamed from: m, reason: collision with root package name */
    public int f5447m;

    /* renamed from: n, reason: collision with root package name */
    public int f5448n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5449o;

    /* renamed from: p, reason: collision with root package name */
    public int f5450p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5451q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5452r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5453s;

    /* renamed from: t, reason: collision with root package name */
    public short f5454t;

    /* renamed from: u, reason: collision with root package name */
    public long f5455u;

    /* renamed from: v, reason: collision with root package name */
    public short f5456v;

    /* renamed from: a, reason: collision with root package name */
    public PrintStream f5435a = System.err;

    /* renamed from: g, reason: collision with root package name */
    public long f5441g = PictureConfig.MB;

    /* renamed from: w, reason: collision with root package name */
    public final List<EntityInfo<?>> f5457w = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f5436b = null;

    public static void e(Object obj, String str) {
        if (obj != null) {
            throw new IllegalStateException(str);
        }
    }

    public static String g(String str) {
        return str != null ? str : "objectbox";
    }

    public static File h(Object obj) {
        return new File(i(obj), "objectbox");
    }

    public static File i(Object obj) throws NoSuchMethodException, SecurityException {
        try {
            Method method = obj.getClass().getMethod("getFilesDir", null);
            File file = (File) method.invoke(obj, null);
            if (file == null) {
                System.err.println("getFilesDir() returned null - retrying once...");
                file = (File) method.invoke(obj, null);
            }
            if (file == null) {
                throw new IllegalStateException("Android files dir is null");
            }
            if (file.exists()) {
                return file;
            }
            throw new IllegalStateException("Android files dir does not exist");
        } catch (Exception e10) {
            throw new RuntimeException("Could not init with given Android context (must be sub class of android.content.Context)", e10);
        }
    }

    public static File k(File file, String str) {
        String strG = g(str);
        return file != null ? new File(file, strG) : new File(strG);
    }

    public c a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Context may not be null");
        }
        this.f5443i = j(obj);
        return this;
    }

    public c b(File file) {
        e(this.f5437c, "Already has directory, cannot assign base directory");
        e(this.f5440f, "Already set to in-memory database, cannot assign base directory");
        this.f5438d = file;
        return this;
    }

    public BoxStore c() {
        Object obj;
        if (this.f5440f != null) {
            this.f5437c = new File("memory:" + this.f5440f);
        }
        if (this.f5437c == null && this.f5438d == null && (obj = this.f5443i) != null) {
            File fileH = h(obj);
            if (!fileH.exists()) {
                fileH.mkdir();
                if (!fileH.exists()) {
                    throw new RuntimeException("Could not init Android base dir at " + fileH.getAbsolutePath());
                }
            }
            if (!fileH.isDirectory()) {
                throw new RuntimeException("Android base dir is not a dir: " + fileH.getAbsolutePath());
            }
            this.f5438d = fileH;
        }
        if (this.f5437c == null) {
            this.f5437c = k(this.f5438d, this.f5439e);
        }
        if (this.f5440f == null) {
            f();
        }
        return new BoxStore(this);
    }

    public byte[] d(String str) {
        S8.b bVar = new S8.b();
        bVar.r(true);
        int iL = bVar.l(str);
        R8.a.o(bVar);
        R8.a.b(bVar, iL);
        R8.a.e(bVar, this.f5441g);
        R8.a.c(bVar, this.f5447m);
        R8.a.f(bVar, this.f5448n);
        short s10 = this.f5454t;
        if (s10 != 0) {
            R8.a.m(bVar, s10);
            long j10 = this.f5455u;
            if (j10 != 0) {
                R8.a.l(bVar, j10);
            }
        }
        short s11 = this.f5456v;
        if (s11 != 0) {
            R8.a.k(bVar, s11);
        }
        if (this.f5451q) {
            R8.a.i(bVar, true);
        }
        if (this.f5453s) {
            R8.a.j(bVar, true);
        }
        if (this.f5452r) {
            R8.a.h(bVar, true);
        }
        if (this.f5449o) {
            R8.a.g(bVar, true);
        }
        int i10 = this.f5445k;
        if (i10 != 0) {
            R8.a.a(bVar, i10);
        }
        long j11 = this.f5442h;
        if (j11 > 0) {
            R8.a.d(bVar, j11);
        }
        bVar.o(R8.a.n(bVar));
        return bVar.C();
    }

    public final void f() {
    }

    public final Object j(Object obj) {
        try {
            return obj.getClass().getMethod("getApplicationContext", null).invoke(obj, null);
        } catch (Exception e10) {
            throw new RuntimeException("context must be a valid Android Context", e10);
        }
    }
}
