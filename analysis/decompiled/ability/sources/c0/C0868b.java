package c0;

import H.h;
import L0.d;
import M0.k;
import a0.AbstractC0293b;
import android.util.Log;
import com.google.protobuf.C0946h1;
import com.google.protobuf.C0950i1;
import com.google.protobuf.C0954j1;
import com.google.protobuf.C0958k1;
import com.google.protobuf.C0962l1;
import com.google.protobuf.C0966m1;
import com.google.protobuf.C1004w0;
import com.google.protobuf.D0;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.F1;
import com.google.protobuf.H0;
import com.google.protobuf.InterfaceC0938f1;
import com.google.protobuf.InterfaceC0942g1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import m0.C1668b;
import y1.C2127a;

/* renamed from: c0.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0868b {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f2068a;
    public Object b;
    public Serializable c;
    public Object d;
    public final Object e;

    public C0868b() {
        this.f2068a = false;
        this.b = "";
        this.e = new LinkedList();
    }

    public static boolean d(C0869c c0869c, List list) {
        ConcurrentHashMap concurrentHashMap = AbstractC0293b.f1624a.g;
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        String str = null;
        while (it.hasNext()) {
            C1668b c1668b = (C1668b) it.next();
            if (str == null || !str.equals(c1668b.l)) {
                str = c1668b.l;
                sb.append(str);
            }
            String str2 = c1668b.d;
            long j5 = c1668b.g;
            if (!"ground_record".equals(str2)) {
            } else if (c1668b.b) {
                c0869c.f2070a += j5;
            } else {
                c0869c.b += j5;
            }
        }
        C1668b c1668b2 = (C1668b) list.get(0);
        boolean z10 = c1668b2.k;
        c0869c.m = z10;
        if (!z10 || (c0869c.f2070a > 60000 && c0869c.b > 5000)) {
            c0869c.n = c1668b2.f5293j;
            c0869c.o = sb.toString();
            return c0869c.b(true);
        }
        c0869c.a();
        if (h.b) {
            Log.w("<monitor><battery>", U7.a.e(new String[]{"main process front or back duration is not valid, stop report "}));
        }
        return false;
    }

    public static InterfaceC0942g1 e(C0868b c0868b, H0 h02) {
        c0868b.getClass();
        if (h02.e == ((C1004w0) c0868b.b)) {
            return ((InterfaceC0942g1[]) c0868b.e)[h02.f2839a];
        }
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    public static InterfaceC0938f1 f(C0868b c0868b, D0 d02) {
        c0868b.getClass();
        if (d02.h != ((C1004w0) c0868b.b)) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        if (d02.b.L()) {
            throw new IllegalArgumentException("This type does not have extensions.");
        }
        return ((InterfaceC0938f1[]) c0868b.c)[d02.f2762a];
    }

    public List a(long j5, boolean z10) {
        List listE;
        try {
            C2127a c2127aB = b();
            synchronized (c2127aB) {
                try {
                    listE = z10 ? c2127aB.e("main_process = 1 AND delete_flag = 0", null, "_id", c2127aB) : c2127aB.e("main_process = 0 AND delete_flag = 0 AND timestamp <= ? ", new String[]{String.valueOf(j5)}, "_id", c2127aB);
                } finally {
                }
            }
            return listE;
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public C2127a b() {
        if (((C2127a) this.d) == null) {
            if (C2127a.f == null) {
                synchronized (C2127a.class) {
                    try {
                        if (C2127a.f == null) {
                            C2127a.f = new C2127a();
                        }
                    } finally {
                    }
                }
            }
            this.d = C2127a.f;
        }
        return (C2127a) this.d;
    }

    public void c(C1668b c1668b) {
        if (c1668b == null) {
            return;
        }
        if (h.b) {
            Log.i("<monitor><battery>", U7.a.e(new String[]{"record batteryLog: " + c1668b.toString()}));
        }
        d.f925a.b(new A.a(9, this, c1668b));
    }

    public void g(Class cls, Class cls2) {
        Class cls3;
        Class cls4;
        if (this.f2068a) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f2068a) {
                    return;
                }
                int length = ((InterfaceC0938f1[]) this.c).length;
                int i = 0;
                while (true) {
                    String str = null;
                    if (i >= length) {
                        break;
                    }
                    D0 d02 = (D0) ((C1004w0) this.b).h().get(i);
                    H0 h02 = d02.f2763j;
                    if (h02 != null) {
                        int i6 = h02.f2839a + length;
                        String[] strArr = (String[]) this.d;
                        if (i6 < strArr.length) {
                            str = strArr[i6];
                        }
                    }
                    String str2 = str;
                    if (d02.isRepeated()) {
                        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = d02.g.f2824a;
                        if (descriptors$FieldDescriptor$JavaType == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                            if (d02.k()) {
                                ((InterfaceC0938f1[]) this.c)[i] = new k(d02, cls);
                            } else {
                                ((InterfaceC0938f1[]) this.c)[i] = new C0950i1(((String[]) this.d)[i], cls, cls2);
                            }
                        } else if (descriptors$FieldDescriptor$JavaType == Descriptors$FieldDescriptor$JavaType.ENUM) {
                            ((InterfaceC0938f1[]) this.c)[i] = new C0946h1(d02, ((String[]) this.d)[i], cls, cls2);
                        } else {
                            ((InterfaceC0938f1[]) this.c)[i] = new O2.a(((String[]) this.d)[i], cls, cls2);
                        }
                        cls3 = cls;
                        cls4 = cls2;
                    } else {
                        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2 = d02.g.f2824a;
                        if (descriptors$FieldDescriptor$JavaType2 == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                            cls3 = cls;
                            cls4 = cls2;
                            ((InterfaceC0938f1[]) this.c)[i] = new C0962l1(d02, ((String[]) this.d)[i], cls3, cls4, str2);
                        } else {
                            cls3 = cls;
                            cls4 = cls2;
                            if (descriptors$FieldDescriptor$JavaType2 == Descriptors$FieldDescriptor$JavaType.ENUM) {
                                ((InterfaceC0938f1[]) this.c)[i] = new C0954j1(d02, ((String[]) this.d)[i], cls3, cls4, str2);
                            } else if (descriptors$FieldDescriptor$JavaType2 == Descriptors$FieldDescriptor$JavaType.STRING) {
                                ((InterfaceC0938f1[]) this.c)[i] = new C0966m1(d02, ((String[]) this.d)[i], cls3, cls4, str2);
                            } else {
                                ((InterfaceC0938f1[]) this.c)[i] = new C0958k1(d02, ((String[]) this.d)[i], cls3, cls4, str2);
                            }
                        }
                    }
                    i++;
                    cls = cls3;
                    cls2 = cls4;
                }
                Class cls5 = cls;
                Class cls6 = cls2;
                for (int i10 = 0; i10 < ((C1004w0) this.b).j().size(); i10++) {
                    C1004w0 c1004w0 = (C1004w0) this.b;
                    if (i10 < Collections.unmodifiableList(Arrays.asList(c1004w0.i).subList(0, c1004w0.f2983j)).size()) {
                        ((InterfaceC0942g1[]) this.e)[i10] = new A5.c((C1004w0) this.b, ((String[]) this.d)[i10 + length], cls5, cls6);
                    } else {
                        ((InterfaceC0942g1[]) this.e)[i10] = new F1((C1004w0) this.b, i10);
                    }
                }
                this.f2068a = true;
                this.d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.f1[], java.io.Serializable] */
    public C0868b(C1004w0 c1004w0, String[] strArr) {
        this.b = c1004w0;
        this.d = strArr;
        this.c = new InterfaceC0938f1[c1004w0.h().size()];
        this.e = new InterfaceC0942g1[c1004w0.j().size()];
        this.f2068a = false;
    }
}
