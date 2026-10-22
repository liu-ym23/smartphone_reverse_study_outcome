package n6;

import android.util.StateSet;
import com.stepos.stepclaw.SecurePrefs;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4055a;

    /* renamed from: b, reason: collision with root package name */
    public int f4056b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4057c;
    public Serializable d;

    /* renamed from: e, reason: collision with root package name */
    public Serializable f4058e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4059f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4060g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4061h;

    /* renamed from: i, reason: collision with root package name */
    public Object f4062i;

    public l(t1.n nVar) {
        this.f4055a = 1;
        d();
        a(StateSet.WILD_CARD, nVar);
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (i8 <= str.length()) {
            int iQ1 = x5.n.q1(str, '&', i8, 4);
            if (iQ1 == -1) {
                iQ1 = str.length();
            }
            int iQ12 = x5.n.q1(str, '=', i8, 4);
            if (iQ12 == -1 || iQ12 > iQ1) {
                String strSubstring = str.substring(i8, iQ1);
                kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i8, iQ12);
                kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iQ12 + 1, iQ1);
                kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                arrayList.add(strSubstring3);
            }
            i8 = iQ1 + 1;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Serializable, java.lang.Object, t1.n[]] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int[][], java.io.Serializable, java.lang.Object] */
    public void a(int[] iArr, t1.n nVar) {
        int i8 = this.f4056b;
        if (i8 == 0 || iArr.length == 0) {
            this.f4057c = nVar;
        }
        int[][] iArr2 = (int[][]) this.d;
        if (i8 >= iArr2.length) {
            int i9 = i8 + 10;
            ?? r3 = new int[i9][];
            System.arraycopy(iArr2, 0, r3, 0, i8);
            this.d = r3;
            ?? r12 = new t1.n[i9];
            System.arraycopy((t1.n[]) this.f4058e, 0, r12, 0, i8);
            this.f4058e = r12;
        }
        int[][] iArr3 = (int[][]) this.d;
        int i10 = this.f4056b;
        iArr3[i10] = iArr;
        ((t1.n[]) this.f4058e)[i10] = nVar;
        this.f4056b = i10 + 1;
    }

    public m b() {
        ArrayList arrayList;
        String str = (String) this.f4057c;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strC = a7.a.c((String) this.d, 0, 0, 7);
        String strC2 = a7.a.c((String) this.f4058e, 0, 0, 7);
        String str2 = (String) this.f4059f;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iC = c();
        ArrayList arrayList2 = (ArrayList) this.f4061h;
        ArrayList arrayList3 = new ArrayList(c5.o.n0(arrayList2, 10));
        int size = arrayList2.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList2.get(i8);
            i8++;
            arrayList3.add(a7.a.c((String) obj, 0, 0, 7));
        }
        ArrayList arrayList4 = (ArrayList) this.f4062i;
        if (arrayList4 != null) {
            ArrayList arrayList5 = new ArrayList(c5.o.n0(arrayList4, 10));
            int size2 = arrayList4.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj2 = arrayList4.get(i9);
                i9++;
                String str3 = (String) obj2;
                arrayList5.add(str3 != null ? a7.a.c(str3, 0, 0, 3) : null);
            }
            arrayList = arrayList5;
        } else {
            arrayList = null;
        }
        String str4 = (String) this.f4060g;
        return new m(str, strC, strC2, str2, iC, arrayList, str4 != null ? a7.a.c(str4, 0, 0, 7) : null, toString());
    }

    public int c() {
        int i8 = this.f4056b;
        if (i8 != -1) {
            return i8;
        }
        String str = (String) this.f4057c;
        kotlin.jvm.internal.p.b(str);
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Serializable, t1.n[]] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int[][], java.io.Serializable] */
    public void d() {
        this.f4057c = new t1.n();
        this.d = new int[10][];
        this.f4058e = new t1.n[10];
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(n6.m r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 936
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n6.l.e(n6.m, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n6.l.toString():java.lang.String");
    }

    public l(int i8) {
        this.f4055a = i8;
        switch (i8) {
            case 1:
                break;
            default:
                this.d = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                this.f4058e = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                this.f4056b = -1;
                this.f4061h = new ArrayList(new c5.i(new String[]{SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID}, true));
                break;
        }
    }
}
