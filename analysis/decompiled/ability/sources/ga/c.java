package ga;

import com.fasterxml.jackson.core.JsonFactory;
import ea.C1428a;
import ha.AbstractC1546b;
import ha.AbstractC1547c;
import ha.AbstractC1551g;
import ha.C1545a;
import ha.C1548d;
import ha.C1549e;
import ha.C1550f;
import ha.i;
import ha.j;
import ha.k;
import ha.l;
import ha.m;
import ha.n;
import ha.o;
import j4.C1597b;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import na.C1751a;
import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.emitter.EmitterException;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: G, reason: collision with root package name */
    public static final char[] f4512G = {' '};

    /* renamed from: H, reason: collision with root package name */
    public static final Pattern f4513H = Pattern.compile("\\s");

    /* renamed from: I, reason: collision with root package name */
    public static final HashSet f4514I;

    /* renamed from: J, reason: collision with root package name */
    public static final HashMap f4515J;

    /* renamed from: K, reason: collision with root package name */
    public static final LinkedHashMap f4516K;

    /* renamed from: L, reason: collision with root package name */
    public static final Pattern f4517L;

    /* renamed from: A, reason: collision with root package name */
    public String f4518A;

    /* renamed from: B, reason: collision with root package name */
    public String f4519B;

    /* renamed from: C, reason: collision with root package name */
    public e f4520C;

    /* renamed from: D, reason: collision with root package name */
    public DumperOptions$ScalarStyle f4521D;
    public final A5.c E;

    /* renamed from: F, reason: collision with root package name */
    public final A5.c f4522F;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f4523a;
    public final C1597b b;
    public d c;
    public final ArrayDeque d;
    public AbstractC1551g e;
    public final C1597b f;
    public Integer g;
    public int h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4524j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Boolean p;

    /* renamed from: q, reason: collision with root package name */
    public final Boolean f4525q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f4526r;

    /* renamed from: s, reason: collision with root package name */
    public final int f4527s;

    /* renamed from: t, reason: collision with root package name */
    public final int f4528t;
    public final boolean u;

    /* renamed from: v, reason: collision with root package name */
    public final int f4529v;

    /* renamed from: w, reason: collision with root package name */
    public final char[] f4530w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f4531x;
    public final int y;

    /* renamed from: z, reason: collision with root package name */
    public LinkedHashMap f4532z;

    static {
        HashSet hashSet = new HashSet();
        f4514I = hashSet;
        hashSet.add('[');
        hashSet.add(']');
        hashSet.add('{');
        hashSet.add('}');
        hashSet.add(',');
        hashSet.add('*');
        hashSet.add('&');
        HashMap map = new HashMap();
        f4515J = map;
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
        f4516K = linkedHashMap;
        linkedHashMap.put("!", "!");
        linkedHashMap.put("tag:yaml.org,2002:", "!!");
        f4517L = Pattern.compile("^![-_\\w]*!$");
    }

    public c(Writer writer, C1428a c1428a) {
        if (writer == null) {
            throw new NullPointerException("Writer must be provided.");
        }
        if (c1428a == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.f4523a = writer;
        this.b = new C1597b(100);
        this.c = new b(this, 14);
        ArrayDeque arrayDeque = new ArrayDeque(100);
        this.d = arrayDeque;
        this.e = null;
        this.f = new C1597b(10);
        this.g = null;
        this.h = 0;
        this.f4524j = false;
        this.k = false;
        this.l = 0;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = Boolean.valueOf(c1428a.b);
        this.f4525q = Boolean.FALSE;
        this.f4526r = true;
        this.f4527s = 2;
        int i = c1428a.c;
        if (i > 1 && i < 10) {
            this.f4527s = i;
        }
        this.f4528t = c1428a.d;
        this.u = c1428a.e;
        this.f4529v = 80;
        if (80 > this.f4527s * 2) {
            this.f4529v = 80;
        }
        this.f4530w = c1428a.g.f5519a.toCharArray();
        this.f4531x = c1428a.f;
        this.y = c1428a.h;
        this.f4532z = new LinkedHashMap();
        this.f4518A = null;
        this.f4519B = null;
        this.f4520C = null;
        this.f4521D = null;
        this.E = new A5.c(arrayDeque, new CommentType[]{CommentType.f5522a, CommentType.b});
        this.f4522F = new A5.c(arrayDeque, new CommentType[]{CommentType.c});
    }

    public static void a(c cVar) throws IOException {
        A5.c cVar2 = cVar.E;
        if (((ArrayList) cVar2.b).isEmpty()) {
            return;
        }
        cVar.m();
        cVar2.b = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ca  */
    /* JADX WARN: Type inference failed for: r2v37, types: [na.a] */
    /* JADX WARN: Type inference failed for: r2v47, types: [na.a] */
    /* JADX WARN: Type inference failed for: r6v67 */
    /* JADX WARN: Type inference failed for: r6v68, types: [int] */
    /* JADX WARN: Type inference failed for: r6v70 */
    /* JADX WARN: Type inference failed for: r8v40, types: [na.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(ga.c r18, boolean r19, boolean r20, boolean r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.c.b(ga.c, boolean, boolean, boolean):void");
    }

    public static boolean c(c cVar) {
        int length;
        String str;
        AbstractC1551g abstractC1551g = cVar.e;
        if (!(abstractC1551g instanceof k) || (str = ((k) abstractC1551g).c) == null) {
            length = 0;
        } else {
            if (cVar.f4518A == null) {
                j(str);
                cVar.f4518A = str;
            }
            length = cVar.f4518A.length();
        }
        AbstractC1551g abstractC1551g2 = cVar.e;
        String str2 = abstractC1551g2 instanceof l ? ((l) abstractC1551g2).d : abstractC1551g2 instanceof AbstractC1547c ? ((AbstractC1547c) abstractC1551g2).d : null;
        if (str2 != null) {
            if (cVar.f4519B == null) {
                cVar.f4519B = cVar.k(str2);
            }
            length += cVar.f4519B.length();
        }
        AbstractC1551g abstractC1551g3 = cVar.e;
        if (abstractC1551g3 instanceof l) {
            if (cVar.f4520C == null) {
                cVar.f4520C = cVar.d(((l) abstractC1551g3).f);
            }
            length += cVar.f4520C.f4533a.length();
        }
        if (length < cVar.y) {
            AbstractC1551g abstractC1551g4 = cVar.e;
            if (abstractC1551g4 instanceof C1545a) {
                return true;
            }
            if (abstractC1551g4 instanceof l) {
                e eVar = cVar.f4520C;
                if (!eVar.b && !eVar.c) {
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
        int i6 = 0;
        int i10 = 0;
        while (true) {
            if (it.hasNext()) {
                AbstractC1551g abstractC1551g = (AbstractC1551g) it.next();
                if (!(abstractC1551g instanceof C1548d)) {
                    i6++;
                    if ((abstractC1551g instanceof C1550f) || (abstractC1551g instanceof AbstractC1547c)) {
                        i10++;
                    } else if ((abstractC1551g instanceof C1549e) || (abstractC1551g instanceof AbstractC1546b)) {
                        i10--;
                    } else if (abstractC1551g instanceof o) {
                        i10 = -1;
                    }
                    if (i10 < 0) {
                        break;
                    }
                }
            } else if (i6 < i) {
                return true;
            }
        }
        return false;
    }

    public static void j(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("anchor must not be empty");
        }
        Iterator it = f4514I.iterator();
        while (it.hasNext()) {
            Character ch = (Character) it.next();
            if (str.indexOf(ch.charValue()) > -1) {
                throw new EmitterException("Invalid character '" + ch + "' in the anchor: " + str);
            }
        }
        if (f4513H.matcher(str).find()) {
            throw new EmitterException("Anchor may not contain spaces: ".concat(str));
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
    public final ga.e d(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.c.d(java.lang.String):ga.e");
    }

    public final boolean e() {
        if (!(this.e instanceof j)) {
            return false;
        }
        ArrayDeque arrayDeque = this.d;
        return !arrayDeque.isEmpty() && (arrayDeque.peek() instanceof i);
    }

    public final boolean f() {
        if (!(this.e instanceof n)) {
            return false;
        }
        ArrayDeque arrayDeque = this.d;
        return !arrayDeque.isEmpty() && (arrayDeque.peek() instanceof m);
    }

    public final String g(String str) {
        StringBuilder sb = new StringBuilder();
        C1751a c1751a = C1751a.d;
        if (c1751a.b(str.charAt(0), " ")) {
            sb.append(this.f4527s);
        }
        if (c1751a.c(str.charAt(str.length() - 1))) {
            sb.append("-");
        } else if (str.length() == 1 || c1751a.a(str.charAt(str.length() - 2))) {
            sb.append("+");
        }
        return sb.toString();
    }

    public final void h(boolean z10, boolean z11) {
        this.f.b(this.g);
        Integer num = this.g;
        int i = this.f4527s;
        if (num != null) {
            if (z11) {
                return;
            }
            this.g = Integer.valueOf(num.intValue() + i);
        } else if (z10) {
            this.g = Integer.valueOf(i);
        } else {
            this.g = 0;
        }
    }

    public final String k(String str) {
        if (str.isEmpty()) {
            throw new EmitterException("tag must not be empty");
        }
        if ("!".equals(str)) {
            return str;
        }
        String str2 = null;
        for (String str3 : this.f4532z.keySet()) {
            if (str.startsWith(str3) && ("!".equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            str = str.substring(str2.length());
            str2 = (String) this.f4532z.get(str2);
        }
        return str2 != null ? androidx.appfunctions.metadata.a.l(str2, str) : B7.a.m("!<", str, ">");
    }

    public final void l(String str) throws IOException {
        String str2 = ((k) this.e).c;
        if (str2 == null) {
            this.f4518A = null;
            return;
        }
        if (this.f4518A == null) {
            j(str2);
            this.f4518A = str2;
        }
        StringBuilder sbV = androidx.compose.foundation.b.v(str);
        sbV.append(this.f4518A);
        n(sbV.toString(), true, false, false);
        this.f4518A = null;
    }

    public final void m() throws IOException {
        int i;
        Integer num = this.g;
        int iIntValue = num != null ? num.intValue() : 0;
        if (!this.n || (i = this.l) > iIntValue || (i == iIntValue && !this.m)) {
            p(null);
        }
        q(iIntValue - this.l);
    }

    public final void n(String str, boolean z10, boolean z11, boolean z12) throws IOException {
        boolean z13 = this.m;
        Writer writer = this.f4523a;
        if (!z13 && z10) {
            this.l++;
            writer.write(f4512G);
        }
        this.m = z11;
        this.n = this.n && z12;
        this.l = str.length() + this.l;
        this.o = false;
        writer.write(str);
    }

    public final void o() {
        A5.c cVar = this.f4522F;
        cVar.getClass();
        cVar.b = new ArrayList();
    }

    public final void p(String str) throws IOException {
        this.m = true;
        this.n = true;
        this.l = 0;
        Writer writer = this.f4523a;
        if (str == null) {
            writer.write(this.f4530w);
        } else {
            writer.write(str);
        }
    }

    public final void q(int i) throws IOException {
        if (i <= 0) {
            return;
        }
        this.m = true;
        char[] cArr = new char[i];
        for (int i6 = 0; i6 < i; i6++) {
            cArr[i6] = ' ';
        }
        this.l += i;
        this.f4523a.write(cArr);
    }
}
