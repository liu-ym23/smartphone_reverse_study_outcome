package h2;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f4558a;
    public volatile int b;
    public int c;
    public A0.d d;
    public long e;
    public long f;
    public int g;
    public long h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f4559j;
    public e k;
    public volatile boolean l;

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] strArrSplit = str.split(":");
            String str3 = strArrSplit.length == 2 ? strArrSplit[1] : "";
            if (str.contains("{") && str.contains("}")) {
                str2 = str.split("\\{")[0];
                try {
                    str = str2 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str2;
                }
            } else {
                str2 = str;
            }
            if (str.contains("@")) {
                String[] strArrSplit2 = str.split("@");
                if (strArrSplit2.length > 1) {
                    str = strArrSplit2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] strArrSplit3 = str.split("\\(");
                if (strArrSplit3.length > 1) {
                    str = strArrSplit3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str3;
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static void c(g gVar, boolean z10, long j5) {
        String str;
        boolean z11;
        int i;
        g gVar2;
        String str2;
        boolean z12;
        int i6;
        int i10 = gVar.b + 1;
        gVar.b = i10;
        gVar.b = i10 & 65535;
        if (gVar.e < 0) {
            gVar.e = j5;
        }
        if (gVar.f < 0) {
            gVar.f = j5;
        }
        if (gVar.g < 0) {
            gVar.g = Process.myTid();
            gVar.h = SystemClock.currentThreadTimeMillis();
        }
        long j6 = j5 - gVar.e;
        long j10 = gVar.c;
        if (j6 > j10) {
            long j11 = gVar.f;
            if (j5 - j11 > j10) {
                if (z10) {
                    if (gVar.f4558a == 0) {
                        str = "no message running";
                        z11 = true;
                        i = 1;
                    } else {
                        gVar2 = gVar;
                        gVar2.b(j11, gVar.i, true, 9);
                        str2 = "no message running";
                        z12 = false;
                        i6 = 1;
                    }
                } else if (gVar.f4558a == 0) {
                    str2 = gVar.f4559j;
                    z12 = true;
                    i6 = 8;
                    gVar2 = gVar;
                } else {
                    gVar2 = gVar;
                    gVar2.b(j11, gVar.i, false, 9);
                    str2 = gVar.f4559j;
                    z12 = true;
                    i6 = 8;
                }
                gVar2.b(j5, str2, z12, i6);
            } else {
                str = gVar.f4559j;
                z11 = true;
                i = 9;
            }
            gVar.b(j5, str, z11, i);
        }
        gVar.f = j5;
    }

    public final void b(long j5, String str, boolean z10, int i) {
        A0.d dVar = this.d;
        f fVar = (f) dVar.c;
        if (fVar != null) {
            fVar.d = i;
            dVar.c = null;
        } else {
            fVar = new f();
            fVar.d = i;
        }
        fVar.f = j5 - this.e;
        if (z10) {
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            fVar.g = jCurrentThreadTimeMillis - this.h;
            this.h = jCurrentThreadTimeMillis;
        } else {
            fVar.g = -1L;
        }
        fVar.e = this.f4558a;
        fVar.h = str;
        fVar.f4557a = this.e;
        fVar.b = j5;
        fVar.c = this.f;
        A0.d dVar2 = this.d;
        ArrayList arrayList = (ArrayList) dVar2.d;
        int size = arrayList.size();
        int i6 = dVar2.f70a;
        if (size < i6) {
            arrayList.add(fVar);
            dVar2.b = arrayList.size();
        } else {
            int i10 = dVar2.b % i6;
            dVar2.b = i10;
            f fVar2 = (f) arrayList.set(i10, fVar);
            fVar2.d = -1;
            fVar2.e = -1;
            fVar2.f = -1L;
            fVar2.h = null;
            dVar2.c = fVar2;
            dVar2.b++;
        }
        this.f4558a = 0;
        this.e = j5;
    }
}
