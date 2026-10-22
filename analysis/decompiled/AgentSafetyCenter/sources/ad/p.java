package ad;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public String f550a;

    /* renamed from: d, reason: collision with root package name */
    public String f553d;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f555f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f556g;

    /* renamed from: h, reason: collision with root package name */
    public String f557h;

    /* renamed from: b, reason: collision with root package name */
    public String f551b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f552c = "";

    /* renamed from: e, reason: collision with root package name */
    public int f554e = -1;

    public p() {
        ArrayList arrayList = new ArrayList();
        this.f555f = arrayList;
        arrayList.add("");
    }

    public final q a() {
        ArrayList arrayList;
        String str = this.f550a;
        if (str == null) {
            od.f.e("scheme == null");
            return null;
        }
        String strE = b.e(this.f551b, 0, 0, 7);
        String strE2 = b.e(this.f552c, 0, 0, 7);
        String str2 = this.f553d;
        if (str2 == null) {
            od.f.e("host == null");
            return null;
        }
        int iB = b();
        ArrayList arrayList2 = this.f555f;
        ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList2, 10));
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList3.add(b.e((String) obj, 0, 0, 7));
        }
        ArrayList arrayList4 = this.f556g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(kb.m.m0(arrayList4, 10));
            int size2 = arrayList4.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList4.get(i3);
                i3++;
                String str3 = (String) obj2;
                arrayList.add(str3 != null ? b.e(str3, 0, 0, 3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.f557h;
        String strE3 = str4 != null ? b.e(str4, 0, 0, 7) : null;
        String string = toString();
        q qVar = new q();
        qVar.f559a = str;
        qVar.f560b = strE;
        qVar.f561c = strE2;
        qVar.f562d = str2;
        qVar.f563e = iB;
        qVar.f564f = arrayList3;
        qVar.f565g = arrayList;
        qVar.f566h = strE3;
        qVar.i = string;
        qVar.f567j = str.equals("https");
        VarHandle.storeStoreFence();
        return qVar;
    }

    public final int b() {
        int i = this.f554e;
        if (i != -1) {
            return i;
        }
        String str = this.f550a;
        str.getClass();
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(ad.q r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.p.c(ad.q, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r6.f550a
            if (r1 == 0) goto L12
            r0.append(r1)
            java.lang.String r1 = "://"
            r0.append(r1)
            goto L17
        L12:
            java.lang.String r1 = "//"
            r0.append(r1)
        L17:
            java.lang.String r1 = r6.f551b
            int r1 = r1.length()
            r2 = 58
            if (r1 <= 0) goto L22
            goto L2a
        L22:
            java.lang.String r1 = r6.f552c
            int r1 = r1.length()
            if (r1 <= 0) goto L44
        L2a:
            java.lang.String r1 = r6.f551b
            r0.append(r1)
            java.lang.String r1 = r6.f552c
            int r1 = r1.length()
            if (r1 <= 0) goto L3f
            r0.append(r2)
            java.lang.String r1 = r6.f552c
            r0.append(r1)
        L3f:
            r1 = 64
            r0.append(r1)
        L44:
            java.lang.String r1 = r6.f553d
            if (r1 == 0) goto L63
            boolean r1 = hc.h.Y(r1, r2)
            if (r1 == 0) goto L5e
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = r6.f553d
            r0.append(r1)
            r1 = 93
            r0.append(r1)
            goto L63
        L5e:
            java.lang.String r1 = r6.f553d
            r0.append(r1)
        L63:
            int r1 = r6.f554e
            r3 = -1
            if (r1 != r3) goto L6c
            java.lang.String r1 = r6.f550a
            if (r1 == 0) goto L91
        L6c:
            int r1 = r6.b()
            java.lang.String r4 = r6.f550a
            if (r4 == 0) goto L8b
            java.lang.String r5 = "http"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L7f
            r3 = 80
            goto L89
        L7f:
            java.lang.String r5 = "https"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L89
            r3 = 443(0x1bb, float:6.21E-43)
        L89:
            if (r1 == r3) goto L91
        L8b:
            r0.append(r2)
            r0.append(r1)
        L91:
            java.util.ArrayList r1 = r6.f555f
            r1.getClass()
            int r2 = r1.size()
            r3 = 0
        L9b:
            if (r3 >= r2) goto Lae
            r4 = 47
            r0.append(r4)
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            int r3 = r3 + 1
            goto L9b
        Lae:
            java.util.ArrayList r1 = r6.f556g
            if (r1 == 0) goto Lbf
            r1 = 63
            r0.append(r1)
            java.util.ArrayList r1 = r6.f556g
            r1.getClass()
            ad.b.g(r0, r1)
        Lbf:
            java.lang.String r1 = r6.f557h
            if (r1 == 0) goto Lcd
            r1 = 35
            r0.append(r1)
            java.lang.String r6 = r6.f557h
            r0.append(r6)
        Lcd:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.p.toString():java.lang.String");
    }
}
