package v0;

import A0.k;
import H0.a;
import H0.b;
import H0.d;
import H0.e;
import H0.f;
import H0.k;
import H0.s;
import H0.t;
import H0.u;
import H0.v;
import H0.w;
import H0.x;
import I0.a;
import I0.b;
import I0.c;
import I0.d;
import I0.e;
import K0.o;
import K0.p;
import K0.r;
import K0.s;
import L0.a;
import Q0.l;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x0.InterfaceC1277a;
import z0.EnumC1336b;

/* renamed from: v0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ComponentCallbacks2C1180c implements ComponentCallbacks2 {

    /* renamed from: l, reason: collision with root package name */
    private static volatile ComponentCallbacks2C1180c f23214l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f23215m;

    /* renamed from: a, reason: collision with root package name */
    private final C0.k f23216a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.d f23217b;

    /* renamed from: c, reason: collision with root package name */
    private final E0.h f23218c;

    /* renamed from: d, reason: collision with root package name */
    private final G0.a f23219d;

    /* renamed from: e, reason: collision with root package name */
    private final e f23220e;

    /* renamed from: f, reason: collision with root package name */
    private final h f23221f;

    /* renamed from: g, reason: collision with root package name */
    private final D0.b f23222g;

    /* renamed from: h, reason: collision with root package name */
    private final l f23223h;

    /* renamed from: i, reason: collision with root package name */
    private final Q0.d f23224i;

    /* renamed from: j, reason: collision with root package name */
    private final List<j> f23225j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private f f23226k = f.NORMAL;

    ComponentCallbacks2C1180c(Context context, C0.k kVar, E0.h hVar, D0.d dVar, D0.b bVar, l lVar, Q0.d dVar2, int i5, T0.h hVar2, Map<Class<?>, k<?, ?>> map, List<T0.g<Object>> list, boolean z5) {
        this.f23216a = kVar;
        this.f23217b = dVar;
        this.f23222g = bVar;
        this.f23218c = hVar;
        this.f23223h = lVar;
        this.f23224i = dVar2;
        this.f23219d = new G0.a(hVar, dVar, (EnumC1336b) hVar2.q().c(K0.h.f3532f));
        Resources resources = context.getResources();
        h hVar3 = new h();
        this.f23221f = hVar3;
        hVar3.p(new K0.f());
        hVar3.p(new K0.k());
        List<ImageHeaderParser> listG = hVar3.g();
        K0.h hVar4 = new K0.h(listG, resources.getDisplayMetrics(), dVar, bVar);
        O0.a aVar = new O0.a(context, listG, dVar, bVar);
        z0.i<ParcelFileDescriptor, Bitmap> iVarG = s.g(dVar);
        K0.e eVar = new K0.e(hVar4);
        p pVar = new p(hVar4, bVar);
        M0.d dVar3 = new M0.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar4 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        K0.c cVar2 = new K0.c(bVar);
        P0.a aVar3 = new P0.a();
        P0.d dVar5 = new P0.d();
        ContentResolver contentResolver = context.getContentResolver();
        h hVarO = hVar3.c(ByteBuffer.class, new H0.c()).c(InputStream.class, new t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, eVar).e("Bitmap", InputStream.class, Bitmap.class, pVar).e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, iVarG).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, K0.s.c(dVar)).a(Bitmap.class, Bitmap.class, v.a.c()).e("Bitmap", Bitmap.class, Bitmap.class, new r()).d(Bitmap.class, cVar2).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new K0.a(resources, eVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new K0.a(resources, pVar)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new K0.a(resources, iVarG)).d(BitmapDrawable.class, new K0.b(dVar, cVar2)).e("Gif", InputStream.class, O0.c.class, new O0.j(listG, aVar, bVar)).e("Gif", ByteBuffer.class, O0.c.class, aVar).d(O0.c.class, new O0.d()).a(InterfaceC1277a.class, InterfaceC1277a.class, v.a.c()).e("Bitmap", InterfaceC1277a.class, Bitmap.class, new O0.h(dVar)).b(Uri.class, Drawable.class, dVar3).b(Uri.class, Bitmap.class, new o(dVar3, dVar)).o(new a.C0056a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).b(File.class, File.class, new N0.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.c()).o(new k.a(bVar));
        Class cls = Integer.TYPE;
        hVarO.a(cls, InputStream.class, cVar).a(cls, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar4).a(cls, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(cls, Uri.class, dVar4).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context)).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context)).a(H0.g.class, InputStream.class, new a.C0037a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.c()).a(Drawable.class, Drawable.class, v.a.c()).b(Drawable.class, Drawable.class, new M0.e()).q(Bitmap.class, BitmapDrawable.class, new P0.b(resources)).q(Bitmap.class, byte[].class, aVar3).q(Drawable.class, byte[].class, new P0.c(dVar, aVar3, dVar5)).q(O0.c.class, byte[].class, dVar5);
        this.f23220e = new e(context, bVar, hVar3, new U0.b(), hVar2, map, list, kVar, z5, i5);
    }

    private static void a(Context context) {
        if (f23215m) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f23215m = true;
        m(context);
        f23215m = false;
    }

    public static ComponentCallbacks2C1180c c(Context context) {
        if (f23214l == null) {
            synchronized (ComponentCallbacks2C1180c.class) {
                try {
                    if (f23214l == null) {
                        a(context);
                    }
                } finally {
                }
            }
        }
        return f23214l;
    }

    private static AbstractC1178a d() {
        try {
            return (AbstractC1178a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e6) {
            q(e6);
            return null;
        } catch (InstantiationException e7) {
            q(e7);
            return null;
        } catch (NoSuchMethodException e8) {
            q(e8);
            return null;
        } catch (InvocationTargetException e9) {
            q(e9);
            return null;
        }
    }

    private static l l(Context context) {
        X0.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context) {
        n(context, new d());
    }

    private static void n(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        AbstractC1178a abstractC1178aD = d();
        List<R0.b> listA = Collections.EMPTY_LIST;
        if (abstractC1178aD == null || abstractC1178aD.c()) {
            listA = new R0.d(applicationContext).a();
        }
        if (abstractC1178aD != null && !abstractC1178aD.d().isEmpty()) {
            Set<Class<?>> setD = abstractC1178aD.d();
            Iterator<R0.b> it = listA.iterator();
            while (it.hasNext()) {
                R0.b next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<R0.b> it2 = listA.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.b(abstractC1178aD != null ? abstractC1178aD.e() : null);
        Iterator<R0.b> it3 = listA.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, dVar);
        }
        if (abstractC1178aD != null) {
            abstractC1178aD.b(applicationContext, dVar);
        }
        ComponentCallbacks2C1180c componentCallbacks2C1180cA = dVar.a(applicationContext);
        Iterator<R0.b> it4 = listA.iterator();
        while (it4.hasNext()) {
            it4.next().b(applicationContext, componentCallbacks2C1180cA, componentCallbacks2C1180cA.f23221f);
        }
        if (abstractC1178aD != null) {
            abstractC1178aD.a(applicationContext, componentCallbacks2C1180cA, componentCallbacks2C1180cA.f23221f);
        }
        applicationContext.registerComponentCallbacks(componentCallbacks2C1180cA);
        f23214l = componentCallbacks2C1180cA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static j t(Context context) {
        return l(context).d(context);
    }

    public void b() {
        X0.k.b();
        this.f23218c.b();
        this.f23217b.b();
        this.f23222g.b();
    }

    public D0.b e() {
        return this.f23222g;
    }

    public D0.d f() {
        return this.f23217b;
    }

    Q0.d g() {
        return this.f23224i;
    }

    public Context h() {
        return this.f23220e.getBaseContext();
    }

    e i() {
        return this.f23220e;
    }

    public h j() {
        return this.f23221f;
    }

    public l k() {
        return this.f23223h;
    }

    void o(j jVar) {
        synchronized (this.f23225j) {
            try {
                if (this.f23225j.contains(jVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f23225j.add(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        r(i5);
    }

    boolean p(U0.e<?> eVar) {
        synchronized (this.f23225j) {
            try {
                Iterator<j> it = this.f23225j.iterator();
                while (it.hasNext()) {
                    if (it.next().w(eVar)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i5) {
        X0.k.b();
        this.f23218c.a(i5);
        this.f23217b.a(i5);
        this.f23222g.a(i5);
    }

    void s(j jVar) {
        synchronized (this.f23225j) {
            try {
                if (!this.f23225j.contains(jVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f23225j.remove(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
