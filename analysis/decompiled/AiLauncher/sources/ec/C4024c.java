package ec;

import android.content.Context;
import android.util.Log;
import ec.AbstractC4023b;
import fc.i;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: ec.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4024c {

    /* renamed from: a, reason: collision with root package name */
    public final Set f32446a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4023b.InterfaceC0400b f32447b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4023b.a f32448c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f32449d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f32450e;

    /* renamed from: ec.c$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f32451a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32452b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f32453c;

        public a(Context context, String str, String str2, AbstractC4023b.c cVar) {
            this.f32451a = context;
            this.f32452b = str;
            this.f32453c = str2;
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
        public void run() {
            /*
                r4 = this;
                r0 = 0
                ec.c r1 = ec.C4024c.this     // Catch: org.extra.relinker.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r4.f32451a     // Catch: org.extra.relinker.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r4.f32452b     // Catch: org.extra.relinker.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r4.f32453c     // Catch: org.extra.relinker.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                ec.C4024c.e(r1, r2, r3, r4)     // Catch: org.extra.relinker.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ec.C4024c.a.run():void");
        }
    }

    /* renamed from: ec.c$b */
    public class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f32455a;

        public b(String str) {
            this.f32455a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f32455a);
        }
    }

    public C4024c() {
        this(new C4025d(), new C4022a());
    }

    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    public void b(Context context, String str) {
        d(context, str, null, null);
    }

    public void c(Context context, String str, String str2) {
        File fileA = a(context);
        File fileH = h(context, str, str2);
        File[] fileArrListFiles = fileA.listFiles(new b(this.f32447b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f32449d || !file.getAbsolutePath().equals(fileH.getAbsolutePath())) {
                try {
                    file.delete();
                } catch (SecurityException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public void d(Context context, String str, String str2, AbstractC4023b.c cVar) {
        AbstractC4023b.c cVar2;
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (AbstractC4026e.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        g("Beginning load of %s...", str);
        if (cVar == null) {
            i(context, str, str2);
            return;
        }
        try {
            cVar2 = cVar;
        } catch (Error | Exception e10) {
            e = e10;
            cVar2 = cVar;
        }
        try {
            new Thread(new a(context, str, str2, cVar2)).start();
        } catch (Error | Exception e11) {
            e = e11;
            cVar2.a(e);
        }
    }

    public void f(String str) {
    }

    public void g(String str, Object... objArr) {
        f(String.format(Locale.US, str, objArr));
    }

    public File h(Context context, String str, String str2) {
        String strA = this.f32447b.a(str);
        if (AbstractC4026e.a(str2)) {
            return new File(a(context), strA);
        }
        return new File(a(context), strA + "." + str2);
    }

    public final void i(Context context, String str, String str2) {
        C4024c c4024c;
        Context context2;
        Throwable th;
        if (this.f32446a.contains(str) && !this.f32449d) {
            g("%s already loaded previously!", str);
            return;
        }
        try {
            this.f32447b.h(str);
            this.f32446a.add(str);
            g("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e10) {
            g("Loading the library normally failed: %s", Log.getStackTraceString(e10));
            g("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileH = h(context, str, str2);
            if (!fileH.exists() || this.f32449d) {
                if (this.f32449d) {
                    g("Forcing a re-link of %s (%s)...", str, str2);
                }
                c(context, str, str2);
                c4024c = this;
                context2 = context;
                this.f32448c.a(context2, this.f32447b.a(), this.f32447b.a(str), fileH, c4024c);
            } else {
                c4024c = this;
                context2 = context;
            }
            try {
                if (c4024c.f32450e) {
                    i iVar = null;
                    try {
                        i iVar2 = new i(fileH);
                        try {
                            List listM = iVar2.m();
                            iVar2.close();
                            Iterator it = listM.iterator();
                            while (it.hasNext()) {
                                c4024c.b(context2, c4024c.f32447b.c((String) it.next()));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            iVar = iVar2;
                            iVar.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (IOException unused) {
            }
            c4024c.f32447b.b(fileH.getAbsolutePath());
            c4024c.f32446a.add(str);
            c4024c.g("%s (%s) was re-linked!", str, str2);
        }
    }

    public C4024c(AbstractC4023b.InterfaceC0400b interfaceC0400b, AbstractC4023b.a aVar) {
        this.f32446a = new HashSet();
        if (interfaceC0400b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f32447b = interfaceC0400b;
        this.f32448c = aVar;
    }
}
