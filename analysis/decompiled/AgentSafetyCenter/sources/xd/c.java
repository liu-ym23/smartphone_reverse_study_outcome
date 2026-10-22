package xd;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.Writer;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import p5.m;
import zd.g;
import zd.i;
import zd.j;
import zd.k;
import zd.l;
import zd.n;
import zd.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {
    public static final char[] G = {' '};
    public static final Pattern H = Pattern.compile("\\s");
    public static final HashSet I;
    public static final HashMap J;
    public static final LinkedHashMap K;
    public static final Pattern L;
    public String A;
    public String B;
    public f C;
    public vd.b D;
    public final m E;
    public final m F;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f15687a;

    /* renamed from: b, reason: collision with root package name */
    public final ne.b f15688b;

    /* renamed from: c, reason: collision with root package name */
    public e f15689c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f15690d;

    /* renamed from: e, reason: collision with root package name */
    public g f15691e;

    /* renamed from: f, reason: collision with root package name */
    public final ne.b f15692f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f15693g;

    /* renamed from: h, reason: collision with root package name */
    public int f15694h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15695j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15696k;

    /* renamed from: l, reason: collision with root package name */
    public int f15697l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15698m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15699n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15700o;

    /* renamed from: p, reason: collision with root package name */
    public final Boolean f15701p;

    /* renamed from: q, reason: collision with root package name */
    public final Boolean f15702q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f15703r;

    /* renamed from: s, reason: collision with root package name */
    public final int f15704s;

    /* renamed from: t, reason: collision with root package name */
    public final int f15705t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f15706u;

    /* renamed from: v, reason: collision with root package name */
    public final int f15707v;

    /* renamed from: w, reason: collision with root package name */
    public final char[] f15708w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f15709x;

    /* renamed from: y, reason: collision with root package name */
    public final int f15710y;

    /* renamed from: z, reason: collision with root package name */
    public LinkedHashMap f15711z;

    static {
        HashSet hashSet = new HashSet();
        I = hashSet;
        hashSet.add('[');
        hashSet.add(']');
        hashSet.add('{');
        hashSet.add('}');
        hashSet.add(',');
        hashSet.add('*');
        hashSet.add('&');
        HashMap map = new HashMap();
        J = map;
        map.put((char) 0, "0");
        map.put((char) 7, "a");
        map.put('\b', "b");
        map.put('\t', "t");
        map.put('\n', "n");
        map.put((char) 11, "v");
        map.put('\f', "f");
        map.put('\r', "r");
        map.put((char) 27, "e");
        map.put(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR), "\"");
        map.put('\\', "\\");
        map.put((char) 133, "N");
        map.put((char) 160, "_");
        map.put((char) 8232, "L");
        map.put((char) 8233, "P");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        K = linkedHashMap;
        linkedHashMap.put("!", "!");
        linkedHashMap.put("tag:yaml.org,2002:", "!!");
        L = Pattern.compile("^![-_\\w]*!$");
    }

    public c(Writer writer, vd.d dVar) {
        if (writer == null) {
            g5.f.g("Writer must be provided.");
            throw null;
        }
        if (dVar == null) {
            g5.f.g("DumperOptions must be provided.");
            throw null;
        }
        this.f15687a = writer;
        this.f15688b = new ne.b(100);
        b bVar = new b(14);
        bVar.f15686b = this;
        VarHandle.storeStoreFence();
        this.f15689c = bVar;
        ArrayDeque arrayDeque = new ArrayDeque(100);
        this.f15690d = arrayDeque;
        this.f15691e = null;
        this.f15692f = new ne.b(10);
        this.f15693g = null;
        this.f15694h = 0;
        this.f15695j = false;
        this.f15696k = false;
        this.f15697l = 0;
        this.f15698m = true;
        this.f15699n = true;
        this.f15700o = false;
        this.f15701p = Boolean.valueOf(dVar.f14911b);
        this.f15702q = Boolean.FALSE;
        this.f15703r = true;
        this.f15704s = 2;
        int i = dVar.f14912c;
        if (i > 1 && i < 10) {
            this.f15704s = i;
        }
        this.f15705t = dVar.f14913d;
        this.f15706u = dVar.f14914e;
        this.f15707v = 80;
        if (80 > this.f15704s * 2) {
            this.f15707v = 80;
        }
        this.f15708w = k0.a.e(dVar.f14916g).toCharArray();
        this.f15709x = dVar.f14915f;
        this.f15710y = dVar.f14917h;
        this.f15711z = new LinkedHashMap();
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = new m(arrayDeque, new int[]{1, 2});
        this.F = new m(arrayDeque, new int[]{3});
    }

    public static void a(c cVar) {
        m mVar = cVar.E;
        if (((ArrayList) mVar.f9741f).isEmpty()) {
            return;
        }
        cVar.m();
        mVar.f9741f = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0  */
    /* JADX WARN: Type inference failed for: r2v31, types: [fe.a] */
    /* JADX WARN: Type inference failed for: r2v41, types: [fe.a] */
    /* JADX WARN: Type inference failed for: r7v67 */
    /* JADX WARN: Type inference failed for: r7v68, types: [int] */
    /* JADX WARN: Type inference failed for: r7v70 */
    /* JADX WARN: Type inference failed for: r8v40, types: [fe.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(xd.c r18, boolean r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xd.c.b(xd.c, boolean, boolean, boolean):void");
    }

    public static boolean c(c cVar) {
        int length;
        String str;
        g gVar = cVar.f15691e;
        if (!(gVar instanceof k) || (str = ((k) gVar).f16591c) == null) {
            length = 0;
        } else {
            if (cVar.A == null) {
                j(str);
                cVar.A = str;
            }
            length = cVar.A.length();
        }
        g gVar2 = cVar.f15691e;
        String str2 = gVar2 instanceof l ? ((l) gVar2).f16592d : gVar2 instanceof zd.c ? ((zd.c) gVar2).f16578d : null;
        if (str2 != null) {
            if (cVar.B == null) {
                cVar.B = cVar.k(str2);
            }
            length += cVar.B.length();
        }
        g gVar3 = cVar.f15691e;
        if (gVar3 instanceof l) {
            if (cVar.C == null) {
                cVar.C = cVar.d(((l) gVar3).f16594f);
            }
            length += cVar.C.f15712a.length();
        }
        if (length < cVar.f15710y) {
            g gVar4 = cVar.f15691e;
            if (gVar4 instanceof zd.a) {
                return true;
            }
            if (gVar4 instanceof l) {
                f fVar = cVar.C;
                if (!fVar.f15713b && !fVar.f15714c) {
                    return true;
                }
            }
            if (cVar.f() || cVar.e()) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(Iterator it, int i) {
        int i3 = 0;
        int i10 = 0;
        while (true) {
            if (it.hasNext()) {
                g gVar = (g) it.next();
                if (!(gVar instanceof zd.d)) {
                    i3++;
                    if ((gVar instanceof zd.f) || (gVar instanceof zd.c)) {
                        i10++;
                    } else if ((gVar instanceof zd.e) || (gVar instanceof zd.b)) {
                        i10--;
                    } else if (gVar instanceof o) {
                        i10 = -1;
                    }
                    if (i10 < 0) {
                        break;
                    }
                }
            } else if (i3 < i) {
                return true;
            }
        }
        return false;
    }

    public static void j(String str) {
        if (str.isEmpty()) {
            throw new d("anchor must not be empty");
        }
        Iterator it = I.iterator();
        while (it.hasNext()) {
            Character ch = (Character) it.next();
            if (str.indexOf(ch.charValue()) > -1) {
                throw new d("Invalid character '" + ch + "' in the anchor: " + str);
            }
        }
        if (H.matcher(str).find()) {
            throw new d("Anchor may not contain spaces: ".concat(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final xd.f d(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xd.c.d(java.lang.String):xd.f");
    }

    public final boolean e() {
        if (!(this.f15691e instanceof j)) {
            return false;
        }
        ArrayDeque arrayDeque = this.f15690d;
        return !arrayDeque.isEmpty() && (arrayDeque.peek() instanceof i);
    }

    public final boolean f() {
        if (!(this.f15691e instanceof n)) {
            return false;
        }
        ArrayDeque arrayDeque = this.f15690d;
        return !arrayDeque.isEmpty() && (arrayDeque.peek() instanceof zd.m);
    }

    public final String g(String str) {
        StringBuilder sb2 = new StringBuilder();
        fe.a aVar = fe.a.f4070d;
        if (aVar.b(str.charAt(0), " ")) {
            sb2.append(this.f15704s);
        }
        if (aVar.c(str.charAt(str.length() - 1))) {
            sb2.append("-");
        } else if (str.length() == 1 || aVar.a(str.charAt(str.length() - 2))) {
            sb2.append("+");
        }
        return sb2.toString();
    }

    public final void h(boolean z10, boolean z11) {
        this.f15692f.g(this.f15693g);
        Integer num = this.f15693g;
        int i = this.f15704s;
        if (num != null) {
            if (z11) {
                return;
            }
            this.f15693g = Integer.valueOf(num.intValue() + i);
        } else if (z10) {
            this.f15693g = Integer.valueOf(i);
        } else {
            this.f15693g = 0;
        }
    }

    public final String k(String str) {
        if (str.isEmpty()) {
            throw new d("tag must not be empty");
        }
        if ("!".equals(str)) {
            return str;
        }
        String str2 = null;
        for (String str3 : this.f15711z.keySet()) {
            if (str.startsWith(str3) && ("!".equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            str = str.substring(str2.length());
            str2 = (String) this.f15711z.get(str2);
        }
        return str2 != null ? str2.concat(str) : k0.a.C("!<", str, ">");
    }

    public final void l(String str) {
        String str2 = ((k) this.f15691e).f16591c;
        if (str2 == null) {
            this.A = null;
            return;
        }
        if (this.A == null) {
            j(str2);
            this.A = str2;
        }
        StringBuilder sbC = w2.c.c(str);
        sbC.append(this.A);
        n(sbC.toString(), true, false, false);
        this.A = null;
    }

    public final void m() {
        int i;
        Integer num = this.f15693g;
        int iIntValue = num != null ? num.intValue() : 0;
        if (!this.f15699n || (i = this.f15697l) > iIntValue || (i == iIntValue && !this.f15698m)) {
            p(null);
        }
        q(iIntValue - this.f15697l);
    }

    public final void n(String str, boolean z10, boolean z11, boolean z12) {
        boolean z13 = this.f15698m;
        Writer writer = this.f15687a;
        if (!z13 && z10) {
            this.f15697l++;
            writer.write(G);
        }
        this.f15698m = z11;
        this.f15699n = this.f15699n && z12;
        this.f15697l = str.length() + this.f15697l;
        this.f15700o = false;
        writer.write(str);
    }

    public final void o() {
        m mVar = this.F;
        mVar.getClass();
        mVar.f9741f = new ArrayList();
    }

    public final void p(String str) throws IOException {
        this.f15698m = true;
        this.f15699n = true;
        this.f15697l = 0;
        Writer writer = this.f15687a;
        if (str == null) {
            writer.write(this.f15708w);
        } else {
            writer.write(str);
        }
    }

    public final void q(int i) throws IOException {
        if (i <= 0) {
            return;
        }
        this.f15698m = true;
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = ' ';
        }
        this.f15697l += i;
        this.f15687a.write(cArr);
    }
}
