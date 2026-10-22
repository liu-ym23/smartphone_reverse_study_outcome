package N4;

import N4.c;
import O4.i;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected final Set<String> f4265a;

    /* renamed from: b, reason: collision with root package name */
    protected final c.b f4266b;

    /* renamed from: c, reason: collision with root package name */
    protected final c.a f4267c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f4268d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f4269e;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4271b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4272c;

        a(Context context, String str, String str2, c.InterfaceC0066c interfaceC0066c) {
            this.f4270a = context;
            this.f4271b = str;
            this.f4272c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r4 = this;
                r0 = 0
                N4.d r1 = N4.d.this     // Catch: N4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r4.f4270a     // Catch: N4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r4.f4271b     // Catch: N4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r4.f4272c     // Catch: N4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                N4.d.b(r1, r2, r3, r4)     // Catch: N4.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: N4.d.a.run():void");
        }
    }

    class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4274a;

        b(String str) {
            this.f4274a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f4274a);
        }
    }

    protected d() {
        this(new e(), new N4.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context, String str, String str2) throws Throwable {
        d dVar;
        Context context2;
        Throwable th;
        i iVar;
        if (this.f4265a.contains(str) && !this.f4268d) {
            g("%s already loaded previously!", str);
            return;
        }
        try {
            this.f4266b.d(str);
            this.f4265a.add(str);
            g("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e6) {
            g("Loading the library normally failed: %s", Log.getStackTraceString(e6));
            g("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileH = h(context, str, str2);
            if (!fileH.exists() || this.f4268d) {
                if (this.f4268d) {
                    g("Forcing a re-link of %s (%s)...", str, str2);
                }
                d(context, str, str2);
                dVar = this;
                context2 = context;
                this.f4267c.a(context2, this.f4266b.a(), this.f4266b.e(str), fileH, dVar);
            } else {
                dVar = this;
                context2 = context;
            }
            try {
                if (dVar.f4269e) {
                    try {
                        iVar = new i(fileH);
                        try {
                            List<String> listR = iVar.r();
                            iVar.close();
                            Iterator<String> it = listR.iterator();
                            while (it.hasNext()) {
                                dVar.c(context2, dVar.f4266b.c(it.next()));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            iVar.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iVar = null;
                    }
                }
            } catch (IOException unused) {
            }
            dVar.f4266b.b(fileH.getAbsolutePath());
            dVar.f4265a.add(str);
            dVar.g("%s (%s) was re-linked!", str, str2);
        }
    }

    protected File a(Context context) {
        return context.getDir("lib", 0);
    }

    public void c(Context context, String str) {
        e(context, str, null, null);
    }

    protected void d(Context context, String str, String str2) {
        File fileA = a(context);
        File fileH = h(context, str, str2);
        File[] fileArrListFiles = fileA.listFiles(new b(this.f4266b.e(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f4268d || !file.getAbsolutePath().equals(fileH.getAbsolutePath())) {
                try {
                    file.delete();
                } catch (SecurityException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public void e(Context context, String str, String str2, c.InterfaceC0066c interfaceC0066c) {
        c.InterfaceC0066c interfaceC0066c2;
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        g("Beginning load of %s...", str);
        if (interfaceC0066c == null) {
            i(context, str, str2);
            return;
        }
        try {
            interfaceC0066c2 = interfaceC0066c;
        } catch (Error | Exception e6) {
            e = e6;
            interfaceC0066c2 = interfaceC0066c;
        }
        try {
            new Thread(new a(context, str, str2, interfaceC0066c2)).start();
        } catch (Error | Exception e7) {
            e = e7;
            interfaceC0066c2.a(e);
        }
    }

    public void f(String str) {
    }

    public void g(String str, Object... objArr) {
        f(String.format(Locale.US, str, objArr));
    }

    protected File h(Context context, String str, String str2) {
        String strE = this.f4266b.e(str);
        if (f.a(str2)) {
            return new File(a(context), strE);
        }
        return new File(a(context), strE + "." + str2);
    }

    protected d(c.b bVar, c.a aVar) {
        this.f4265a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f4266b = bVar;
        this.f4267c = aVar;
    }
}
