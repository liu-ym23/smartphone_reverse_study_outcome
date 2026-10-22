package d8;

import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class l1 {

    /* renamed from: c, reason: collision with root package name */
    public final String f2064c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public String f2065e;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2062a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2063b = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public int f2066f = Integer.MAX_VALUE;

    public l1(String str, int i8) {
        this.f2064c = str;
        this.d = i8;
    }

    public final void a(int i8, String str) {
        c(i8);
        String strE = e(str);
        this.f2062a.put(strE, Integer.valueOf(i8));
        this.f2063b.put(Integer.valueOf(i8), strE);
    }

    public final void b(int i8, String str) {
        c(i8);
        this.f2062a.put(e(str), Integer.valueOf(i8));
    }

    public void c(int i8) {
        if (i8 < 0 || i8 > this.f2066f) {
            throw new IllegalArgumentException(this.f2064c + " " + i8 + " is out of range");
        }
    }

    public final String d(int i8) {
        c(i8);
        String str = (String) this.f2063b.get(Integer.valueOf(i8));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i8);
        return this.f2065e != null ? m0.f.f(new StringBuilder(), this.f2065e, string) : string;
    }

    public final String e(String str) {
        int i8 = this.d;
        return i8 == 2 ? str.toUpperCase() : i8 == 3 ? str.toLowerCase() : str;
    }

    public final void f(String str) {
        this.f2065e = e(str);
    }
}
