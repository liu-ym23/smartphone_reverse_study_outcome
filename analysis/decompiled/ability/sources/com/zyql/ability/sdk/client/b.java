package com.zyql.ability.sdk.client;

import M0.i;
import N9.j;
import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import g7.C1464a;
import java.io.File;
import kotlin.jvm.internal.k;
import q2.C1797b;
import q2.C1798c;
import u1.d;
import y2.e;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4238a;
    public final Context b;

    public /* synthetic */ b(Context context, int i) {
        this.f4238a = i;
        this.b = context;
    }

    public void a(long j5, Thread thread, Throwable th, String str, String str2, boolean z10) {
        switch (this.f4238a) {
            case 1:
                File file = new File(j.f(this.b), str);
                C1797b c1797bC = C1797b.c();
                c1797bC.f.put(file.getName(), new Object());
                file.mkdirs();
                M.a.T(file);
                n2.a aVarO = d.s().o(CrashType.JAVA, new C1798c(this, th, e.p(th), j5, str2, z10, thread, str, file, 0));
                long jCurrentTimeMillis = System.currentTimeMillis() - j5;
                try {
                    aVarO.f("crash_type", "normal");
                    aVarO.n("crash_cost", String.valueOf(jCurrentTimeMillis));
                    aVarO.f("crash_cost", String.valueOf(jCurrentTimeMillis / 1000));
                    return;
                } catch (Throwable th2) {
                    int i = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", th2);
                    return;
                }
            default:
                synchronized (this) {
                    File file2 = new File(j.f(this.b), str);
                    C1797b c1797bC2 = C1797b.c();
                    c1797bC2.f.put(file2.getName(), new Object());
                    file2.mkdirs();
                    M.a.T(file2);
                    n2.a aVarO2 = d.s().o(CrashType.LAUNCH, new C1798c(this, th, e.p(th), j5, str2, z10, thread, str, file2, 1));
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - j5;
                    try {
                        aVarO2.f("crash_type", "normal");
                        aVarO2.n("crash_cost", String.valueOf(jCurrentTimeMillis2));
                        aVarO2.f("crash_cost", String.valueOf(jCurrentTimeMillis2 / 1000));
                    } catch (Throwable th3) {
                        int i6 = com.apm.insight.b.f2156a;
                        i.k("NPTH_CATCH", th3);
                    }
                    Npth.isStopUpload();
                }
                return;
        }
    }

    public b(Context context, R5.d dVar, C1464a caller) {
        this.f4238a = 0;
        k.f(caller, "caller");
        this.b = context;
    }
}
