package com.typesafe.config.impl;

import b8.InterfaceC1456b;
import com.autonavi.aps.amapapi.config.Const;
import com.networknt.schema.keyword.PropertiesValidator;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;

/* loaded from: classes4.dex */
public abstract class C implements b8.m {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<LinkedList<C>> f31725d = new a();

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1456b f31726a;

    /* renamed from: b, reason: collision with root package name */
    public b8.l f31727b;

    /* renamed from: c, reason: collision with root package name */
    public b8.k f31728c;

    public static class a extends ThreadLocal<LinkedList<C>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LinkedList<C> initialValue() {
            return new LinkedList<>();
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31729a;

        static {
            int[] iArr = new int[ConfigSyntax.values().length];
            f31729a = iArr;
            try {
                iArr[ConfigSyntax.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31729a[ConfigSyntax.CONF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31729a[ConfigSyntax.PROPERTIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class c extends C {

        /* renamed from: e, reason: collision with root package name */
        public final File f31730e;

        public c(File file, b8.l lVar) {
            this.f31730e = file;
            v(lVar);
        }

        @Override // com.typesafe.config.impl.C
        public b8.m a(String str) {
            File file = new File(str).isAbsolute() ? new File(str) : C.C(this.f31730e, str);
            if (file == null) {
                return null;
            }
            if (file.exists()) {
                C.E(file + " exists, so loading it as a file");
                return C.l(file, c().k(null));
            }
            C.E(file + " does not exist, so trying it as a classpath resource");
            return super.a(str);
        }

        @Override // com.typesafe.config.impl.C
        public b8.k g() {
            return M.o(this.f31730e.getPath());
        }

        @Override // com.typesafe.config.impl.C
        public ConfigSyntax j() {
            return C3904j.i(this.f31730e.getName());
        }

        @Override // com.typesafe.config.impl.C
        public String toString() {
            return c.class.getSimpleName() + "(" + this.f31730e.getPath() + ")";
        }

        @Override // com.typesafe.config.impl.C
        public Reader y() throws IOException {
            if (C3903i.B()) {
                C.E("Loading config from a file: " + this.f31730e);
            }
            return C.A(new FileInputStream(this.f31730e));
        }
    }

    public static final class d extends C {

        /* renamed from: e, reason: collision with root package name */
        public final String f31731e;

        /* renamed from: f, reason: collision with root package name */
        public final String f31732f;

        public d(String str, String str2, b8.l lVar) {
            this.f31731e = str;
            this.f31732f = str2;
            v(lVar);
        }

        @Override // com.typesafe.config.impl.C
        public b8.k g() {
            return M.r(this.f31731e);
        }

        @Override // com.typesafe.config.impl.C
        public Reader y() throws IOException {
            throw new FileNotFoundException(this.f31732f);
        }
    }

    public static final class e extends C {

        /* renamed from: e, reason: collision with root package name */
        public final Properties f31733e;

        public e(Properties properties, b8.l lVar) {
            this.f31733e = properties;
            v(lVar);
        }

        @Override // com.typesafe.config.impl.C
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public AbstractC3897c w(b8.k kVar, b8.l lVar) {
            if (C3903i.B()) {
                C.E("Loading config from properties " + this.f31733e);
            }
            return G.e(kVar, this.f31733e);
        }

        @Override // com.typesafe.config.impl.C
        public b8.k g() {
            return M.r(PropertiesValidator.PROPERTY);
        }

        @Override // com.typesafe.config.impl.C
        public ConfigSyntax j() {
            return ConfigSyntax.PROPERTIES;
        }

        @Override // com.typesafe.config.impl.C
        public String toString() {
            return e.class.getSimpleName() + "(" + this.f31733e.size() + " props)";
        }

        @Override // com.typesafe.config.impl.C
        public Reader y() throws IOException {
            throw new ConfigException.BugOrBroken("reader() should not be called on props");
        }
    }

    public static final class f extends h {

        /* renamed from: g, reason: collision with root package name */
        public final i f31734g;

        /* renamed from: h, reason: collision with root package name */
        public final String f31735h;

        public f(URL url, b8.l lVar, String str, i iVar) {
            super(url);
            this.f31734g = iVar;
            this.f31735h = str;
            v(lVar);
        }

        @Override // com.typesafe.config.impl.C.h, com.typesafe.config.impl.C
        public b8.m a(String str) {
            return this.f31734g.a(str);
        }

        @Override // com.typesafe.config.impl.C.h, com.typesafe.config.impl.C
        public b8.k g() {
            return M.q(this.f31735h, this.f31737e);
        }
    }

    public static final class g extends C implements i {

        /* renamed from: e, reason: collision with root package name */
        public final String f31736e;

        public g(String str, b8.l lVar) {
            this.f31736e = str;
            v(lVar);
        }

        public static String F(String str) {
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf < 0) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        }

        @Override // com.typesafe.config.impl.C
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public AbstractC3897c w(b8.k kVar, b8.l lVar) throws IOException {
            ClassLoader classLoaderD = lVar.d();
            if (classLoaderD == null) {
                throw new ConfigException.BugOrBroken("null class loader; pass in a class loader or use Thread.currentThread().setContextClassLoader()");
            }
            Enumeration<URL> resources = classLoaderD.getResources(this.f31736e);
            if (!resources.hasMoreElements()) {
                if (C3903i.B()) {
                    C.E("Loading config from class loader " + classLoaderD + " but there were no resources called " + this.f31736e);
                }
                throw new IOException("resource not found on classpath: " + this.f31736e);
            }
            AbstractC3897c abstractC3897cK0 = SimpleConfigObject.K0(kVar);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                if (C3903i.B()) {
                    C.E("Loading config from resource '" + this.f31736e + "' URL " + urlNextElement.toExternalForm() + " from class loader " + classLoaderD);
                }
                abstractC3897cK0 = abstractC3897cK0.n0(C.o(urlNextElement, lVar, this.f31736e, this).s());
            }
            return abstractC3897cK0;
        }

        @Override // com.typesafe.config.impl.C
        public b8.m a(String str) {
            if (str.startsWith("/")) {
                return C.p(str.substring(1), c().k(null));
            }
            String strF = F(this.f31736e);
            if (strF == null) {
                return C.p(str, c().k(null));
            }
            return C.p(strF + "/" + str, c().k(null));
        }

        @Override // com.typesafe.config.impl.C
        public b8.k g() {
            return M.p(this.f31736e);
        }

        @Override // com.typesafe.config.impl.C
        public ConfigSyntax j() {
            return C3904j.i(this.f31736e);
        }

        @Override // com.typesafe.config.impl.C
        public String toString() {
            return g.class.getSimpleName() + "(" + this.f31736e + ")";
        }

        @Override // com.typesafe.config.impl.C
        public Reader y() throws IOException {
            throw new ConfigException.BugOrBroken("reader() should not be called on resources");
        }
    }

    public interface i {
        b8.m a(String str);
    }

    public static Reader A(InputStream inputStream) {
        return B(inputStream, "UTF-8");
    }

    public static Reader B(InputStream inputStream, String str) {
        try {
            return new BufferedReader(new InputStreamReader(inputStream, str));
        } catch (UnsupportedEncodingException e10) {
            throw new ConfigException.BugOrBroken("Java runtime does not support UTF-8", e10);
        }
    }

    public static File C(File file, String str) {
        File parentFile;
        if (new File(str).isAbsolute() || (parentFile = file.getParentFile()) == null) {
            return null;
        }
        return new File(parentFile, str);
    }

    public static URL D(URL url, String str) {
        if (new File(str).isAbsolute()) {
            return null;
        }
        try {
            return url.toURI().resolve(new URI(str)).toURL();
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            return null;
        }
    }

    public static void E(String str) {
        if (C3903i.B()) {
            C3903i.A(str);
        }
    }

    public static AbstractC3897c i(b8.p pVar) {
        if (pVar instanceof AbstractC3897c) {
            return (AbstractC3897c) pVar;
        }
        throw new ConfigException.WrongType(pVar.e(), "", "object at file root", pVar.c().name());
    }

    public static C l(File file, b8.l lVar) {
        return new c(file, lVar);
    }

    public static C m(String str, String str2, b8.l lVar) {
        return new d(str, str2, lVar);
    }

    public static C n(Properties properties, b8.l lVar) {
        return new e(properties, lVar);
    }

    public static C o(URL url, b8.l lVar, String str, i iVar) {
        return new f(url, lVar, str, iVar);
    }

    public static C p(String str, b8.l lVar) {
        if (lVar.d() != null) {
            return new g(str, lVar);
        }
        throw new ConfigException.BugOrBroken("null class loader; pass in a class loader or use Thread.currentThread().setContextClassLoader()");
    }

    public static C q(URL url, b8.l lVar) {
        return url.getProtocol().equals(Const.STR_FILE) ? l(C3904j.l(url), lVar) : new h(url, lVar);
    }

    public b8.m a(String str) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        return p(str, c().k(null));
    }

    @Override // b8.m
    public b8.j b(b8.l lVar) {
        ThreadLocal<LinkedList<C>> threadLocal = f31725d;
        LinkedList<C> linkedList = threadLocal.get();
        if (linkedList.size() >= 50) {
            throw new ConfigException.Parse(this.f31728c, "include statements nested more than 50 times, you probably have a cycle in your includes. Trace: " + linkedList);
        }
        linkedList.addFirst(this);
        try {
            AbstractC3897c abstractC3897cI = i(u(lVar));
            linkedList.removeFirst();
            if (linkedList.isEmpty()) {
                threadLocal.remove();
            }
            return abstractC3897cI;
        } catch (Throwable th) {
            linkedList.removeFirst();
            if (linkedList.isEmpty()) {
                f31725d.remove();
            }
            throw th;
        }
    }

    @Override // b8.m
    public b8.l c() {
        return this.f31727b;
    }

    public ConfigSyntax f() {
        return null;
    }

    public abstract b8.k g();

    public final b8.l h(b8.l lVar) {
        ConfigSyntax configSyntaxG = lVar.g();
        if (configSyntaxG == null) {
            configSyntaxG = j();
        }
        if (configSyntaxG == null) {
            configSyntaxG = ConfigSyntax.CONF;
        }
        b8.l lVarA = lVar.l(configSyntaxG).a(C3903i.f());
        return lVarA.j(O.l(lVarA.e()));
    }

    public ConfigSyntax j() {
        return null;
    }

    public InterfaceC1456b k() {
        return this.f31726a;
    }

    public b8.j r() {
        return i(u(c()));
    }

    public AbstractConfigValue s() {
        return u(c());
    }

    public final AbstractConfigValue t(b8.k kVar, b8.l lVar) {
        try {
            return w(kVar, lVar);
        } catch (IOException e10) {
            if (lVar.c()) {
                E(e10.getMessage() + ". Allowing Missing File, this can be turned off by setting ConfigParseOptions.allowMissing = false");
                return SimpleConfigObject.L0(kVar);
            }
            E("exception loading " + kVar.description() + ": " + e10.getClass().getName() + ": " + e10.getMessage());
            throw new ConfigException.IO(kVar, e10.getClass().getName() + ": " + e10.getMessage(), e10);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final AbstractConfigValue u(b8.l lVar) {
        b8.l lVarH = h(lVar);
        return t(lVarH.f() != null ? M.r(lVarH.f()) : this.f31728c, lVarH);
    }

    public void v(b8.l lVar) {
        this.f31727b = h(lVar);
        this.f31726a = new N(this);
        if (this.f31727b.f() != null) {
            this.f31728c = M.r(this.f31727b.f());
        } else {
            this.f31728c = g();
        }
    }

    public AbstractConfigValue w(b8.k kVar, b8.l lVar) throws IOException {
        Reader readerZ = z(lVar);
        ConfigSyntax configSyntaxF = f();
        if (configSyntaxF != null) {
            if (C3903i.B() && lVar.g() != null) {
                E("Overriding syntax " + lVar.g() + " with Content-Type which specified " + configSyntaxF);
            }
            lVar = lVar.l(configSyntaxF);
        }
        try {
            return x(readerZ, kVar, lVar);
        } finally {
            readerZ.close();
        }
    }

    public final AbstractConfigValue x(Reader reader, b8.k kVar, b8.l lVar) throws IOException {
        return lVar.g() == ConfigSyntax.PROPERTIES ? G.i(reader, kVar) : v.a(C3902h.a(Tokenizer.d(kVar, reader, lVar.g()), kVar, lVar), kVar, lVar, k());
    }

    public abstract Reader y() throws IOException;

    public Reader z(b8.l lVar) throws IOException {
        return y();
    }

    public static class h extends C {

        /* renamed from: e, reason: collision with root package name */
        public final URL f31737e;

        /* renamed from: f, reason: collision with root package name */
        public String f31738f;

        public h(URL url) {
            this.f31738f = null;
            this.f31737e = url;
        }

        public static String F(b8.l lVar) {
            if (lVar.g() == null) {
                return null;
            }
            int i10 = b.f31729a[lVar.g().ordinal()];
            if (i10 == 1) {
                return "application/json";
            }
            if (i10 == 2) {
                return "application/hocon";
            }
            if (i10 != 3) {
                return null;
            }
            return "text/x-java-properties";
        }

        @Override // com.typesafe.config.impl.C
        public b8.m a(String str) {
            URL urlD = C.D(this.f31737e, str);
            if (urlD == null) {
                return null;
            }
            return C.q(urlD, c().k(null));
        }

        @Override // com.typesafe.config.impl.C
        public ConfigSyntax f() {
            String str = this.f31738f;
            if (str != null) {
                if (str.equals("application/json")) {
                    return ConfigSyntax.JSON;
                }
                if (this.f31738f.equals("text/x-java-properties")) {
                    return ConfigSyntax.PROPERTIES;
                }
                if (this.f31738f.equals("application/hocon")) {
                    return ConfigSyntax.CONF;
                }
                if (C3903i.B()) {
                    C.E("'" + this.f31738f + "' isn't a known content type");
                }
            }
            return null;
        }

        @Override // com.typesafe.config.impl.C
        public b8.k g() {
            return M.s(this.f31737e);
        }

        @Override // com.typesafe.config.impl.C
        public ConfigSyntax j() {
            return C3904j.i(this.f31737e.getPath());
        }

        @Override // com.typesafe.config.impl.C
        public String toString() {
            return getClass().getSimpleName() + "(" + this.f31737e.toExternalForm() + ")";
        }

        @Override // com.typesafe.config.impl.C
        public Reader y() throws IOException {
            throw new ConfigException.BugOrBroken("reader() without options should not be called on ParseableURL");
        }

        @Override // com.typesafe.config.impl.C
        public Reader z(b8.l lVar) throws IOException {
            try {
                if (C3903i.B()) {
                    C.E("Loading config from a URL: " + this.f31737e.toExternalForm());
                }
                URLConnection uRLConnectionOpenConnection = this.f31737e.openConnection();
                String strF = F(lVar);
                if (strF != null) {
                    uRLConnectionOpenConnection.setRequestProperty("Accept", strF);
                }
                uRLConnectionOpenConnection.connect();
                String contentType = uRLConnectionOpenConnection.getContentType();
                this.f31738f = contentType;
                if (contentType != null) {
                    if (C3903i.B()) {
                        C.E("URL sets Content-Type: '" + this.f31738f + "'");
                    }
                    String strTrim = this.f31738f.trim();
                    this.f31738f = strTrim;
                    int iIndexOf = strTrim.indexOf(59);
                    if (iIndexOf >= 0) {
                        this.f31738f = this.f31738f.substring(0, iIndexOf);
                    }
                }
                return C.A(uRLConnectionOpenConnection.getInputStream());
            } catch (FileNotFoundException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new ConfigException.BugOrBroken("Cannot load config from URL: " + this.f31737e.toExternalForm(), e11);
            }
        }

        public h(URL url, b8.l lVar) {
            this(url);
            v(lVar);
        }
    }
}
