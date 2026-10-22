package hb;

import android.util.Log;
import vc.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9386a = true;

    /* renamed from: b, reason: collision with root package name */
    public Object f9387b;

    public c(l5.a aVar) {
        this.f9387b = aVar;
    }

    public void a(String message) {
        kotlin.jvm.internal.g.f(message, "message");
        if (this.f9386a) {
            Log.d(c(), message);
        }
    }

    public void b(String message, Exception exc) {
        kotlin.jvm.internal.g.f(message, "message");
        if (this.f9386a) {
            Log.e(c(), message, exc);
        }
    }

    public String c() {
        return ((String) this.f9387b).length() > 23 ? "fetch2" : (String) this.f9387b;
    }

    public void d() {
        this.f9386a = false;
    }

    public void e(byte b10) {
        ((l5.a) this.f9387b).l(b10);
    }

    public void f(char c9) {
        l5.a aVar = (l5.a) this.f9387b;
        aVar.g(aVar.f10233b, 1);
        char[] cArr = (char[]) aVar.f10234c;
        int i10 = aVar.f10233b;
        aVar.f10233b = i10 + 1;
        cArr[i10] = c9;
    }

    public void g(int i10) {
        ((l5.a) this.f9387b).l(i10);
    }

    public void h(long j10) {
        ((l5.a) this.f9387b).l(j10);
    }

    public void i(String v3) {
        kotlin.jvm.internal.g.f(v3, "v");
        ((l5.a) this.f9387b).k(v3);
    }

    public void j(short s8) {
        ((l5.a) this.f9387b).l(s8);
    }

    public void k(String value) {
        byte b10;
        kotlin.jvm.internal.g.f(value, "value");
        l5.a aVar = (l5.a) this.f9387b;
        aVar.g(aVar.f10233b, value.length() + 2);
        char[] cArr = (char[]) aVar.f10234c;
        int i10 = aVar.f10233b;
        int i11 = i10 + 1;
        cArr[i10] = '\"';
        int length = value.length();
        value.getChars(0, length, cArr, i11);
        int i12 = length + i11;
        int i13 = i11;
        while (i13 < i12) {
            char c9 = cArr[i13];
            byte[] bArr = n.f13521b;
            if (c9 < bArr.length && bArr[c9] != 0) {
                int length2 = value.length();
                for (int i14 = i13 - i11; i14 < length2; i14++) {
                    aVar.g(i13, 2);
                    char cCharAt = value.charAt(i14);
                    byte[] bArr2 = n.f13521b;
                    if (cCharAt >= bArr2.length || (b10 = bArr2[cCharAt]) == 0) {
                        int i15 = i13 + 1;
                        ((char[]) aVar.f10234c)[i13] = cCharAt;
                        i13 = i15;
                    } else {
                        if (b10 == 1) {
                            String str = n.f13520a[cCharAt];
                            kotlin.jvm.internal.g.c(str);
                            aVar.g(i13, str.length());
                            str.getChars(0, str.length(), (char[]) aVar.f10234c, i13);
                            int length3 = str.length() + i13;
                            aVar.f10233b = length3;
                            i13 = length3;
                        } else {
                            char[] cArr2 = (char[]) aVar.f10234c;
                            cArr2[i13] = '\\';
                            cArr2[i13 + 1] = (char) b10;
                            i13 += 2;
                            aVar.f10233b = i13;
                        }
                    }
                }
                aVar.g(i13, 1);
                ((char[]) aVar.f10234c)[i13] = '\"';
                aVar.f10233b = i13 + 1;
                return;
            }
            i13++;
        }
        cArr[i12] = '\"';
        aVar.f10233b = i12 + 1;
    }

    public void l() {
    }

    public void m() {
    }
}
