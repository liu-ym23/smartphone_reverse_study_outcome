package Nb;

import La.D;
import La.H;
import Mb.AbstractC0969g;
import Mb.AbstractC0971i;
import Mb.C0970h;
import Mb.G;
import Mb.I;
import Mb.z;
import Z8.A;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 :2\u00020\u0001:\u0001;B#\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020!2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020!2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010#J\u0013\u0010*\u001a\u00020)*\u00020\tH\u0002¢\u0006\u0004\b*\u0010+J%\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0,0\u000e*\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010.J!\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010,*\u00020/H\u0002¢\u0006\u0004\b0\u00101J!\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010,*\u00020/H\u0002¢\u0006\u0004\b2\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00103R\u0014\u0010\u0006\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R-\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0,0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"LNb/l;", "LMb/i;", "Ljava/lang/ClassLoader;", "classLoader", "", "indexEagerly", "systemFileSystem", "<init>", "(Ljava/lang/ClassLoader;ZLMb/i;)V", "LMb/z;", "path", "R0", "(LMb/z;)LMb/z;", Const.JSON_KEY_DIR, "", "U", "(LMb/z;)Ljava/util/List;", Const.STR_FILE, "LMb/g;", "e0", "(LMb/z;)LMb/g;", "LMb/h;", "Y", "(LMb/z;)LMb/h;", "LMb/I;", "v0", "(LMb/z;)LMb/I;", "mustCreate", "LMb/G;", "k0", "(LMb/z;Z)LMb/G;", "mustExist", "e", "LY8/t;", "m", "(LMb/z;Z)V", "source", "target", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/z;LMb/z;)V", "G", "", "k1", "(LMb/z;)Ljava/lang/String;", "Lkotlin/Pair;", SdCardDbCreator.FIELD_LASTLOC_ID, "(Ljava/lang/ClassLoader;)Ljava/util/List;", "Ljava/net/URL;", "b1", "(Ljava/net/URL;)Lkotlin/Pair;", "f1", "Ljava/lang/ClassLoader;", "f", "LMb/i;", "LY8/h;", "T0", "()Ljava/util/List;", "roots", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class l extends AbstractC0971i {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    public static final z f5059i = z.Companion.e(z.INSTANCE, "/", false, 1, null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ClassLoader classLoader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final AbstractC0971i systemFileSystem;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Y8.h roots;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LNb/l$a;", "", "<init>", "()V", "LMb/z;", "base", Const.INTENT_KEY_UMID, "(LMb/z;LMb/z;)LMb/z;", "path", "", "c", "(LMb/z;)Z", "ROOT", "LMb/z;", Const.INTENT_KEY_PKGNAME, "()LMb/z;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Nb.l$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final z b() {
            return l.f5059i;
        }

        public final boolean c(z path) {
            return !D.J(path.i(), ".class", true);
        }

        public final z d(z zVar, z base) {
            kotlin.jvm.internal.p.i(zVar, "<this>");
            kotlin.jvm.internal.p.i(base, "base");
            return b().n(D.S(H.R0(zVar.toString(), base.toString()), '\\', JsonPointer.SEPARATOR, false, 4, null));
        }

        public Companion() {
        }
    }

    public l(ClassLoader classLoader, boolean z10, AbstractC0971i systemFileSystem) {
        kotlin.jvm.internal.p.i(classLoader, "classLoader");
        kotlin.jvm.internal.p.i(systemFileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = systemFileSystem;
        this.roots = C4848b.b(new InterfaceC5063a() { // from class: Nb.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return l.Y0(this.f5057a);
            }
        });
        if (z10) {
            T0().size();
        }
    }

    private final z R0(z path) {
        return f5059i.m(path, true);
    }

    public static final List Y0(l lVar) {
        return lVar.a1(lVar.classLoader);
    }

    public static final boolean h1(n entry) {
        kotlin.jvm.internal.p.i(entry, "entry");
        return INSTANCE.c(entry.getCanonicalPath());
    }

    @Override // Mb.AbstractC0971i
    public void G(z path, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        throw new IOException(this + " is read-only");
    }

    public final List<Pair<AbstractC0971i, z>> T0() {
        return (List) this.roots.getValue();
    }

    @Override // Mb.AbstractC0971i
    public List<z> U(z dir) throws FileNotFoundException {
        kotlin.jvm.internal.p.i(dir, "dir");
        String strK1 = k1(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (Pair<AbstractC0971i, z> pair : T0()) {
            AbstractC0971i abstractC0971iA = pair.a();
            z zVarB = pair.b();
            try {
                List<z> listU = abstractC0971iA.U(zVarB.n(strK1));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listU) {
                    if (INSTANCE.c((z) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(INSTANCE.d((z) it.next(), zVarB));
                }
                A.E(linkedHashSet, arrayList2);
                z10 = true;
            } catch (IOException unused) {
            }
        }
        if (z10) {
            return F.m1(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // Mb.AbstractC0971i
    public C0970h Y(z path) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        if (!INSTANCE.c(path)) {
            return null;
        }
        String strK1 = k1(path);
        for (Pair<AbstractC0971i, z> pair : T0()) {
            C0970h c0970hY = pair.a().Y(pair.b().n(strK1));
            if (c0970hY != null) {
                return c0970hY;
            }
        }
        return null;
    }

    public final List<Pair<AbstractC0971i, z>> a1(ClassLoader classLoader) throws IOException {
        Enumeration<URL> resources = classLoader.getResources("");
        kotlin.jvm.internal.p.h(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        kotlin.jvm.internal.p.h(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            kotlin.jvm.internal.p.f(url);
            Pair<AbstractC0971i, z> pairB1 = b1(url);
            if (pairB1 != null) {
                arrayList.add(pairB1);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        kotlin.jvm.internal.p.h(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        kotlin.jvm.internal.p.h(list2, "list(...)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            kotlin.jvm.internal.p.f(url2);
            Pair<AbstractC0971i, z> pairF1 = f1(url2);
            if (pairF1 != null) {
                arrayList2.add(pairF1);
            }
        }
        return F.S0(arrayList, arrayList2);
    }

    public final Pair<AbstractC0971i, z> b1(URL url) {
        if (kotlin.jvm.internal.p.d(url.getProtocol(), Const.STR_FILE)) {
            return Y8.j.a(this.systemFileSystem, z.Companion.d(z.INSTANCE, new File(url.toURI()), false, 1, null));
        }
        return null;
    }

    @Override // Mb.AbstractC0971i
    public G e(z file, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // Mb.AbstractC0971i
    public AbstractC0969g e0(z file) throws FileNotFoundException {
        kotlin.jvm.internal.p.i(file, "file");
        if (!INSTANCE.c(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String strK1 = k1(file);
        Iterator<Pair<AbstractC0971i, z>> it = T0().iterator();
        while (it.hasNext()) {
            Pair<AbstractC0971i, z> next = it.next();
            try {
                return next.a().e0(next.b().n(strK1));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    public final Pair<AbstractC0971i, z> f1(URL url) {
        int iB0;
        String string = url.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        if (!D.X(string, "jar:file:", false, 2, null) || (iB0 = H.B0(string, "!", 0, false, 6, null)) == -1) {
            return null;
        }
        z.Companion companion = z.INSTANCE;
        String strSubstring = string.substring(4, iB0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return Y8.j.a(r.h(z.Companion.d(companion, new File(URI.create(strSubstring)), false, 1, null), this.systemFileSystem, new InterfaceC5074l() { // from class: Nb.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(l.h1((n) obj));
            }
        }), f5059i);
    }

    @Override // Mb.AbstractC0971i
    public void g(z source, z target) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // Mb.AbstractC0971i
    public G k0(z file, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        throw new IOException(this + " is read-only");
    }

    public final String k1(z zVar) {
        return R0(zVar).l(f5059i).toString();
    }

    @Override // Mb.AbstractC0971i
    public void m(z dir, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // Mb.AbstractC0971i
    public I v0(z file) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        if (!INSTANCE.c(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        z zVar = f5059i;
        URL resource = this.classLoader.getResource(z.o(zVar, file, false, 2, null).l(zVar).toString());
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + file);
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        kotlin.jvm.internal.p.h(inputStream, "getInputStream(...)");
        return Mb.u.l(inputStream);
    }

    public /* synthetic */ l(ClassLoader classLoader, boolean z10, AbstractC0971i abstractC0971i, int i10, kotlin.jvm.internal.i iVar) {
        this(classLoader, z10, (i10 & 4) != 0 ? AbstractC0971i.f4735b : abstractC0971i);
    }
}
