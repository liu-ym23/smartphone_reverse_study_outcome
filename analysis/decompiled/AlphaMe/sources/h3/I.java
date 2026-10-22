package h3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes2.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public String f12713a;

    /* renamed from: d, reason: collision with root package name */
    public String f12716d;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f12718f;

    /* renamed from: g, reason: collision with root package name */
    public List f12719g;

    /* renamed from: h, reason: collision with root package name */
    public String f12720h;

    /* renamed from: b, reason: collision with root package name */
    public String f12714b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f12715c = "";

    /* renamed from: e, reason: collision with root package name */
    public int f12717e = -1;

    public I() {
        ArrayList arrayList = new ArrayList();
        this.f12718f = arrayList;
        arrayList.add("");
    }

    public final void a(String encodedName, String str) {
        Intrinsics.checkNotNullParameter(encodedName, "encodedName");
        if (this.f12719g == null) {
            this.f12719g = new ArrayList();
        }
        List list = this.f12719g;
        Intrinsics.checkNotNull(list);
        char[] cArr = J.f12721k;
        list.add(C0611u.c(encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
        List list2 = this.f12719g;
        Intrinsics.checkNotNull(list2);
        list2.add(str == null ? null : C0611u.c(str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
    }

    public final void b(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.f12719g == null) {
            this.f12719g = new ArrayList();
        }
        List list = this.f12719g;
        Intrinsics.checkNotNull(list);
        char[] cArr = J.f12721k;
        list.add(C0611u.c(name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
        List list2 = this.f12719g;
        Intrinsics.checkNotNull(list2);
        list2.add(str == null ? null : C0611u.c(str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
    }

    public final J c() {
        ArrayList arrayList;
        String strW;
        String str = this.f12713a;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        char[] cArr = J.f12721k;
        String strW2 = C0611u.w(this.f12714b, 0, 0, false, 7);
        String strW3 = C0611u.w(this.f12715c, 0, 0, false, 7);
        String str2 = this.f12716d;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iJ = this.f12717e;
        if (iJ == -1) {
            String str3 = this.f12713a;
            Intrinsics.checkNotNull(str3);
            iJ = C0611u.j(str3);
        }
        int i4 = iJ;
        ArrayList arrayList2 = this.f12718f;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.e(arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str4 = (String) it.next();
            char[] cArr2 = J.f12721k;
            arrayList3.add(C0611u.w(str4, 0, 0, false, 7));
        }
        List list = this.f12719g;
        String strW4 = null;
        if (list == null) {
            arrayList = null;
        } else {
            List<String> list2 = list;
            arrayList = new ArrayList(CollectionsKt.e(list2));
            for (String str5 : list2) {
                if (str5 == null) {
                    strW = null;
                } else {
                    char[] cArr3 = J.f12721k;
                    strW = C0611u.w(str5, 0, 0, true, 3);
                }
                arrayList.add(strW);
            }
        }
        String str6 = this.f12720h;
        if (str6 != null) {
            char[] cArr4 = J.f12721k;
            strW4 = C0611u.w(str6, 0, 0, false, 7);
        }
        return new J(str, strW2, strW3, str2, i4, arrayList3, arrayList, strW4, toString());
    }

    public final void d(String str) {
        ArrayList arrayListX = null;
        if (str != null) {
            char[] cArr = J.f12721k;
            String strC = C0611u.c(str, 0, 0, " \"'<>#", true, false, true, false, null, 211);
            if (strC != null) {
                arrayListX = C0611u.x(strC);
            }
        }
        this.f12719g = arrayListX;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(h3.J r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.I.e(h3.J, java.lang.String):void");
    }

    public final void f(String str, int i4, int i5, boolean z4, boolean z5) {
        char[] cArr = J.f12721k;
        String strC = C0611u.c(str, i4, i5, " \"<>^`{}|/\\?#", z5, false, false, false, null, 240);
        if (Intrinsics.areEqual(strC, ".") || StringsKt__StringsJVMKt.equals(strC, "%2e", true)) {
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(strC, "..");
        ArrayList arrayList = this.f12718f;
        if (zAreEqual || StringsKt__StringsJVMKt.equals(strC, "%2e.", true) || StringsKt__StringsJVMKt.equals(strC, ".%2e", true) || StringsKt__StringsJVMKt.equals(strC, "%2e%2e", true)) {
            if (((String) arrayList.remove(arrayList.size() - 1)).length() == 0 && (!arrayList.isEmpty())) {
                arrayList.set(arrayList.size() - 1, "");
                return;
            } else {
                arrayList.add("");
                return;
            }
        }
        if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
            arrayList.set(arrayList.size() - 1, strC);
        } else {
            arrayList.add(strC);
        }
        if (z4) {
            arrayList.add("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r6.f12713a
            if (r1 == 0) goto L12
            r0.append(r1)
            java.lang.String r1 = "://"
            r0.append(r1)
            goto L17
        L12:
            java.lang.String r1 = "//"
            r0.append(r1)
        L17:
            java.lang.String r1 = r6.f12714b
            int r1 = r1.length()
            r2 = 58
            if (r1 <= 0) goto L22
            goto L2a
        L22:
            java.lang.String r1 = r6.f12715c
            int r1 = r1.length()
            if (r1 <= 0) goto L44
        L2a:
            java.lang.String r1 = r6.f12714b
            r0.append(r1)
            java.lang.String r1 = r6.f12715c
            int r1 = r1.length()
            if (r1 <= 0) goto L3f
            r0.append(r2)
            java.lang.String r1 = r6.f12715c
            r0.append(r1)
        L3f:
            r1 = 64
            r0.append(r1)
        L44:
            java.lang.String r1 = r6.f12716d
            if (r1 == 0) goto L66
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = kotlin.text.StringsKt.b(r1, r2)
            if (r1 == 0) goto L61
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = r6.f12716d
            r0.append(r1)
            r1 = 93
            r0.append(r1)
            goto L66
        L61:
            java.lang.String r1 = r6.f12716d
            r0.append(r1)
        L66:
            int r1 = r6.f12717e
            r3 = -1
            if (r1 != r3) goto L6f
            java.lang.String r4 = r6.f12713a
            if (r4 == 0) goto L92
        L6f:
            if (r1 == r3) goto L72
            goto L7d
        L72:
            char[] r1 = h3.J.f12721k
            java.lang.String r1 = r6.f12713a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = h3.C0611u.j(r1)
        L7d:
            java.lang.String r3 = r6.f12713a
            if (r3 == 0) goto L8c
            char[] r4 = h3.J.f12721k
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = h3.C0611u.j(r3)
            if (r1 == r3) goto L92
        L8c:
            r0.append(r2)
            r0.append(r1)
        L92:
            char[] r1 = h3.J.f12721k
            java.util.ArrayList r1 = r6.f12718f
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            int r2 = r1.size()
            r3 = 0
        La5:
            if (r3 >= r2) goto Lb9
            int r4 = r3 + 1
            r5 = 47
            r0.append(r5)
            java.lang.Object r3 = r1.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            r3 = r4
            goto La5
        Lb9:
            java.util.List r1 = r6.f12719g
            if (r1 == 0) goto Lcc
            r1 = 63
            r0.append(r1)
            char[] r1 = h3.J.f12721k
            java.util.List r1 = r6.f12719g
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            h3.C0611u.y(r1, r0)
        Lcc:
            java.lang.String r1 = r6.f12720h
            if (r1 == 0) goto Lda
            r1 = 35
            r0.append(r1)
            java.lang.String r6 = r6.f12720h
            r0.append(r6)
        Lda:
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.I.toString():java.lang.String");
    }
}
