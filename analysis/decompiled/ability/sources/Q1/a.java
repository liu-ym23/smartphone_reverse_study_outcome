package Q1;

import B0.f;
import D8.j;
import H.h;
import a.AbstractC0291a;
import a2.InterfaceC0300b;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import b2.C0822a;
import b2.C0823b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import s2.C1912a;

/* loaded from: classes2.dex */
public final class a {
    public static volatile Context e = null;
    public static volatile a f = null;
    public static j g = null;
    public static volatile boolean h = false;
    public static volatile String i = "";

    /* renamed from: j, reason: collision with root package name */
    public static String f1095j;

    /* renamed from: a, reason: collision with root package name */
    public final List f1096a;
    public final ExecutorService b;
    public volatile Map c;
    public long d;

    public a() {
        this.c = new HashMap();
        new Vector(10);
        this.b = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        AbstractC0291a.c = h.b;
        R1.b bVarB = R1.b.b(i);
        R5.b bVar = new R5.b();
        ArrayList arrayList = Y1.a.f1561a;
        ArrayList arrayList2 = Y1.a.b;
        ArrayList arrayList3 = Y1.a.c;
        bVar.b = h.a();
        Application application = h.f711a;
        bVar.c = e;
        bVar.f1153a = h.b;
        if (h.e() != null) {
        }
        bVar.d = new C1912a();
        if (TextUtils.isEmpty((String) bVar.b)) {
            throw new IllegalArgumentException("aid must not be empty");
        }
        if (((Context) bVar.c) == null) {
            throw new IllegalArgumentException("context must not be empty");
        }
        if (((C1912a) bVar.d) == null) {
            throw new IllegalArgumentException("SDKIDynamicParams must not be empty");
        }
        f fVar = new f();
        fVar.f177a = (String) bVar.b;
        fVar.b = bVar.f1153a;
        fVar.c = (Context) bVar.c;
        bVarB.c = fVar;
        bVarB.b = new File(((Context) fVar.c).getFilesDir(), "cloud_uploading" + ((String) fVar.f177a));
        ArrayList arrayList4 = new ArrayList(10);
        C0822a c0822a = new C0822a(2);
        c0822a.f1636a = i;
        C0822a c0822a2 = new C0822a(1);
        c0822a2.f1636a = i;
        C0822a c0822a3 = new C0822a(0);
        c0822a3.f1636a = i;
        C0823b c0823b = new C0823b();
        c0823b.f1636a = i;
        arrayList4.add(c0822a);
        arrayList4.add(c0822a2);
        arrayList4.add(c0822a3);
        arrayList4.add(c0823b);
        List<InterfaceC0300b> listUnmodifiableList = Collections.unmodifiableList(arrayList4);
        this.f1096a = listUnmodifiableList;
        j jVar = g;
        if (jVar != null) {
            for (InterfaceC0300b interfaceC0300b : listUnmodifiableList) {
                if (interfaceC0300b instanceof C0822a) {
                    ((C0822a) interfaceC0300b).c = jVar;
                }
            }
            g = null;
        }
        this.c = h.e() != null ? h.e() : new HashMap();
    }

    public static a b() {
        if (f == null) {
            synchronized (a.class) {
                try {
                    if (f == null) {
                        if (!h) {
                            throw new RuntimeException("call CloudMessageManager.init() first");
                        }
                        f = new a();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x012c, code lost:
    
        r2 = (java.lang.String) r4.getValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q1.a.a():void");
    }
}
