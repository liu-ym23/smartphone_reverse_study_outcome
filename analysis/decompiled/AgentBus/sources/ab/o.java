package ab;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public String f579a;

    /* renamed from: d, reason: collision with root package name */
    public String f582d;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f584f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f585g;

    /* renamed from: h, reason: collision with root package name */
    public String f586h;

    /* renamed from: b, reason: collision with root package name */
    public String f580b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f581c = "";

    /* renamed from: e, reason: collision with root package name */
    public int f583e = -1;

    public o() {
        ArrayList arrayList = new ArrayList();
        this.f584f = arrayList;
        arrayList.add("");
    }

    public final p a() {
        ArrayList arrayList;
        String str = this.f579a;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strE = b.e(this.f580b, 0, 0, 7);
        String strE2 = b.e(this.f581c, 0, 0, 7);
        String str2 = this.f582d;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iB = b();
        ArrayList arrayList2 = this.f584f;
        ArrayList arrayList3 = new ArrayList(d7.t.A0(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(b.e((String) it.next(), 0, 0, 7));
        }
        ArrayList<String> arrayList4 = this.f585g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(d7.t.A0(arrayList4, 10));
            for (String str3 : arrayList4) {
                arrayList.add(str3 != null ? b.e(str3, 0, 0, 3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.f586h;
        return new p(str, strE, strE2, str2, iB, arrayList3, arrayList, str4 != null ? b.e(str4, 0, 0, 7) : null, toString());
    }

    public final int b() {
        int i2 = this.f583e;
        if (i2 != -1) {
            return i2;
        }
        String str = this.f579a;
        q7.k.b(str);
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(ab.p r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.o.c(ab.p, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.o.toString():java.lang.String");
    }
}
