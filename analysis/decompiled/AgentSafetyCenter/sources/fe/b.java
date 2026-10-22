package fe;

import b8.z;
import com.fasterxml.jackson.core.JsonFactory;
import ge.g;
import ge.k;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import vd.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f4079l = Pattern.compile("[^0-9A-Fa-f]");

    /* renamed from: m, reason: collision with root package name */
    public static final HashMap f4080m;

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap f4081n;

    /* renamed from: a, reason: collision with root package name */
    public de.b f4082a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4083b;

    /* renamed from: c, reason: collision with root package name */
    public int f4084c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f4085d;

    /* renamed from: e, reason: collision with root package name */
    public k f4086e;

    /* renamed from: f, reason: collision with root package name */
    public int f4087f;

    /* renamed from: g, reason: collision with root package name */
    public int f4088g;

    /* renamed from: h, reason: collision with root package name */
    public ne.b f4089h;
    public e i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4090j;

    /* renamed from: k, reason: collision with root package name */
    public LinkedHashMap f4091k;

    static {
        HashMap map = new HashMap();
        f4080m = map;
        HashMap map2 = new HashMap();
        f4081n = map2;
        map.put('0', "\u0000");
        map.put('a', "\u0007");
        map.put('b', "\b");
        map.put('t', "\t");
        map.put('n', "\n");
        map.put('v', "\u000b");
        map.put('f', "\f");
        map.put('r', "\r");
        map.put('e', "\u001b");
        map.put(' ', " ");
        map.put(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR), "\"");
        map.put('\\', "\\");
        map.put('N', "\u0085");
        map.put('_', " ");
        map.put('L', "\u2028");
        map.put('P', "\u2029");
        map2.put('x', 2);
        map2.put('u', 4);
        map2.put('U', 8);
    }

    public final boolean a(int i) {
        int i3 = this.f4088g;
        if (i3 >= i) {
            return false;
        }
        this.f4089h.g(Integer.valueOf(i3));
        this.f4088g = i;
        return true;
    }

    public final void b(k kVar) {
        this.f4086e = kVar;
        this.f4085d.add(kVar);
    }

    public final boolean c(int i) {
        ArrayList arrayList = this.f4085d;
        while (l()) {
            j();
        }
        return !arrayList.isEmpty() && ((k) arrayList.get(0)).a() == i;
    }

    public final boolean d(int... iArr) throws IOException, NumberFormatException {
        ArrayList arrayList = this.f4085d;
        while (l()) {
            j();
        }
        if (!arrayList.isEmpty()) {
            if (iArr.length == 0) {
                return true;
            }
            int iA = ((k) arrayList.get(0)).a();
            for (int i : iArr) {
                if (iA == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void e(char c9) throws NumberFormatException {
        Boolean bool;
        int i;
        int i3;
        int iMax;
        String str;
        yd.a aVar;
        yd.a aVar2;
        this.f4090j = true;
        n();
        de.b bVar = this.f4082a;
        boolean z10 = c9 == '>';
        StringBuilder sb2 = new StringBuilder();
        yd.a aVarC = bVar.c();
        bVar.b(1);
        int iE = bVar.e();
        if (iE == 45 || iE == 43) {
            Boolean bool2 = iE == 43 ? Boolean.TRUE : Boolean.FALSE;
            bVar.b(1);
            int iE2 = bVar.e();
            if (Character.isDigit(iE2)) {
                int i10 = Integer.parseInt(String.valueOf(Character.toChars(iE2)));
                if (i10 == 0) {
                    z.t("while scanning a block scalar", aVarC, "expected indentation indicator in the range 1-9, but found 0", bVar.c());
                    return;
                } else {
                    bVar.b(1);
                    bool = bool2;
                    i = i10;
                }
            } else {
                bool = bool2;
                i = -1;
            }
        } else {
            if (Character.isDigit(iE)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(iE)));
                if (i == 0) {
                    z.t("while scanning a block scalar", aVarC, "expected indentation indicator in the range 1-9, but found 0", bVar.c());
                    return;
                }
                bVar.b(1);
                int iE3 = bVar.e();
                if (iE3 == 45 || iE3 == 43) {
                    bool = iE3 == 43 ? Boolean.TRUE : Boolean.FALSE;
                    bVar.b(1);
                }
            } else {
                i = -1;
            }
            bool = null;
        }
        int iE4 = bVar.e();
        if (a.f4072f.c(iE4)) {
            z.t("while scanning a block scalar", aVarC, "expected chomping or indentation indicators, but found " + String.valueOf(Character.toChars(iE4)) + "(" + iE4 + ")", bVar.c());
            return;
        }
        while (bVar.e() == 32) {
            bVar.b(1);
        }
        ge.e eVarR = bVar.e() == 35 ? r(3) : null;
        int iE5 = bVar.e();
        if (u().isEmpty() && iE5 != 0) {
            z.t("while scanning a block scalar", aVarC, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(iE5)) + "(" + iE5 + ")", bVar.c());
            return;
        }
        int i11 = this.f4088g + 1;
        if (i11 < 1) {
            i11 = 1;
        }
        if (i == -1) {
            StringBuilder sb3 = new StringBuilder();
            yd.a aVarC2 = bVar.c();
            int i12 = 0;
            while (true) {
                i3 = 2;
                if (!a.f4070d.b(bVar.e(), " \r")) {
                    break;
                }
                if (bVar.e() != 32) {
                    sb3.append(u());
                    aVarC2 = bVar.c();
                } else {
                    bVar.b(1);
                    int i13 = bVar.i;
                    if (i13 > i12) {
                        i12 = i13;
                    }
                }
            }
            Object[] objArr = {sb3.toString(), Integer.valueOf(i12), aVarC2};
            str = (String) objArr[0];
            int iIntValue = ((Integer) objArr[1]).intValue();
            aVar = (yd.a) objArr[2];
            iMax = Math.max(i11, iIntValue);
        } else {
            i3 = 2;
            iMax = (i11 + i) - 1;
            Object[] objArrQ = q(iMax);
            str = (String) objArrQ[0];
            aVar = (yd.a) objArrQ[1];
        }
        String strU = "";
        while (bVar.i == iMax && bVar.e() != 0) {
            sb2.append(str);
            boolean z11 = " \t".indexOf(bVar.e()) == -1;
            int i14 = 0;
            while (a.f4071e.c(bVar.f(i14))) {
                i14++;
            }
            sb2.append(bVar.h(i14));
            strU = u();
            Object[] objArrQ2 = q(iMax);
            String str2 = (String) objArrQ2[0];
            aVar2 = (yd.a) objArrQ2[1];
            if (bVar.i != iMax || bVar.e() == 0) {
                str = str2;
                break;
            }
            if (z10 && "\n".equals(strU) && z11) {
                if (" \t".indexOf(bVar.e()) == -1) {
                    if (str2.isEmpty()) {
                        sb2.append(' ');
                    }
                }
                aVar = aVar2;
                str = str2;
            }
            sb2.append(strU);
            aVar = aVar2;
            str = str2;
        }
        aVar2 = aVar;
        if (bool == null || bool.booleanValue()) {
            sb2.append(strU);
        }
        if (bool != null && bool.booleanValue()) {
            sb2.append(str);
        }
        g gVar = new g(sb2.toString(), false, aVarC, aVar2, vd.b.a(Character.valueOf(c9)));
        int i15 = i3;
        k[] kVarArr = new k[i15];
        kVarArr[0] = eVarR;
        kVarArr[1] = gVar;
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < i15; i16++) {
            k kVar = kVarArr[i16];
            if (kVar != null && !(kVar instanceof ge.e)) {
                arrayList.add(kVar);
            }
        }
        this.f4086e = (k) arrayList.get(arrayList.size() - 1);
        this.f4085d.addAll(arrayList);
    }

    public final void f(boolean z10) {
        z(-1);
        n();
        this.f4090j = false;
        de.b bVar = this.f4082a;
        yd.a aVarC = bVar.c();
        bVar.b(3);
        yd.a aVarC2 = bVar.c();
        b(z10 ? new ge.c(aVarC, aVarC2, 4) : new ge.c(aVarC, aVarC2, 3));
    }

    public final void g(boolean z10) {
        n();
        this.f4084c--;
        this.f4090j = false;
        de.b bVar = this.f4082a;
        yd.a aVarC = bVar.c();
        bVar.b(1);
        yd.a aVarC2 = bVar.c();
        b(z10 ? new ge.c(aVarC, aVarC2, 6) : new ge.c(aVarC, aVarC2, 8));
    }

    public final void h(boolean z10) {
        o();
        this.f4084c++;
        this.f4090j = true;
        de.b bVar = this.f4082a;
        yd.a aVarC = bVar.c();
        bVar.b(1);
        yd.a aVarC2 = bVar.c();
        b(z10 ? new ge.c(aVarC, aVarC2, 7) : new ge.c(aVarC, aVarC2, 9));
    }

    public final void i(char c9) throws IOException {
        o();
        this.f4090j = false;
        de.b bVar = this.f4082a;
        boolean z10 = c9 == '\"';
        StringBuilder sb2 = new StringBuilder();
        yd.a aVarC = bVar.c();
        int iE = bVar.e();
        bVar.b(1);
        t(z10, aVarC, sb2);
        while (bVar.e() != iE) {
            int i = 0;
            while (" \t".indexOf(bVar.f(i)) != -1) {
                i++;
            }
            String strH = bVar.h(i);
            if (bVar.e() == 0) {
                z.t("while scanning a quoted scalar", aVarC, "found unexpected end of stream", bVar.c());
                return;
            }
            String strU = u();
            if (strU.isEmpty()) {
                sb2.append(strH);
            } else {
                String strS = s(aVarC);
                if (!"\n".equals(strU)) {
                    sb2.append(strU);
                } else if (strS.isEmpty()) {
                    sb2.append(' ');
                }
                sb2.append(strS);
            }
            t(z10, aVarC, sb2);
        }
        bVar.b(1);
        b(new g(sb2.toString(), false, aVarC, bVar.c(), vd.b.a(Character.valueOf(c9))));
    }

    /* JADX WARN: Removed duplicated region for block: B:232:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x068d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.b.j():void");
    }

    public final k k() {
        this.f4087f++;
        return (k) this.f4085d.remove(0);
    }

    public final boolean l() {
        if (this.f4083b) {
            return false;
        }
        if (this.f4085d.isEmpty()) {
            return true;
        }
        y();
        LinkedHashMap linkedHashMap = this.f4091k;
        return (!linkedHashMap.isEmpty() ? ((c) linkedHashMap.values().iterator().next()).f4092a : -1) == this.f4087f;
    }

    public final k m() {
        while (l()) {
            j();
        }
        return (k) this.f4085d.get(0);
    }

    public final void n() {
        c cVar = (c) this.f4091k.remove(Integer.valueOf(this.f4084c));
        if (cVar == null || !cVar.f4093b) {
            return;
        }
        z.t("while scanning a simple key", cVar.f4097f, "could not find expected ':'", this.f4082a.c());
    }

    public final void o() {
        de.b bVar = this.f4082a;
        boolean z10 = this.f4084c == 0 && this.f4088g == bVar.i;
        boolean z11 = this.f4090j;
        if (!z11 && z10) {
            throw new yd.c("A simple key is required only if it is the first token in the current line");
        }
        if (z11) {
            n();
            int size = this.f4085d.size() + this.f4087f;
            int i = bVar.f3327f;
            int i3 = bVar.f3329h;
            int i10 = bVar.i;
            yd.a aVarC = bVar.c();
            c cVar = new c();
            cVar.f4092a = size;
            cVar.f4093b = z10;
            cVar.f4094c = i;
            cVar.f4095d = i3;
            cVar.f4096e = i10;
            cVar.f4097f = aVarC;
            VarHandle.storeStoreFence();
            this.f4091k.put(Integer.valueOf(this.f4084c), cVar);
        }
    }

    public final k p(boolean z10) throws IOException {
        a aVar;
        de.b bVar = this.f4082a;
        yd.a aVarC = bVar.c();
        String str = bVar.e() == 42 ? "alias" : "anchor";
        bVar.b(1);
        int i = 0;
        int iF = bVar.f(0);
        while (true) {
            aVar = a.f4073g;
            if (aVar.b(iF, ":,[]{}/.*&")) {
                break;
            }
            i++;
            iF = bVar.f(i);
        }
        if (i == 0) {
            String strValueOf = String.valueOf(Character.toChars(iF));
            z.t("while scanning an ".concat(str), aVarC, "unexpected character found " + strValueOf + "(" + iF + ")", bVar.c());
            return null;
        }
        String strH = bVar.h(i);
        int iE = bVar.e();
        if (!aVar.b(iE, "?:,]}%@`")) {
            String strValueOf2 = String.valueOf(Character.toChars(iE));
            z.t("while scanning an ".concat(str), aVarC, "unexpected character found " + strValueOf2 + "(" + iE + ")", bVar.c());
            return null;
        }
        yd.a aVarC2 = bVar.c();
        if (z10) {
            ge.b bVar2 = new ge.b(aVarC, aVarC2);
            bVar2.f4734c = strH;
            VarHandle.storeStoreFence();
            return bVar2;
        }
        ge.a aVar2 = new ge.a(aVarC, aVarC2);
        aVar2.f4733c = strH;
        VarHandle.storeStoreFence();
        return aVar2;
    }

    public final Object[] q(int i) {
        StringBuilder sb2 = new StringBuilder();
        de.b bVar = this.f4082a;
        yd.a aVarC = bVar.c();
        for (int i3 = bVar.i; i3 < i && bVar.e() == 32; i3++) {
            bVar.b(1);
        }
        while (true) {
            String strU = u();
            if (strU.isEmpty()) {
                return new Object[]{sb2.toString(), aVarC};
            }
            sb2.append(strU);
            aVarC = bVar.c();
            for (int i10 = bVar.i; i10 < i && bVar.e() == 32; i10++) {
                bVar.b(1);
            }
        }
    }

    public final ge.e r(int i) throws IOException {
        de.b bVar = this.f4082a;
        yd.a aVarC = bVar.c();
        bVar.b(1);
        int i3 = 0;
        while (a.f4071e.c(bVar.f(i3))) {
            i3++;
        }
        String strH = bVar.h(i3);
        ge.e eVar = new ge.e(aVarC, bVar.c());
        if (i == 0) {
            throw null;
        }
        eVar.f4736c = i;
        eVar.f4737d = strH;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public final String s(yd.a aVar) throws IOException {
        de.b bVar = this.f4082a;
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String strG = bVar.g(3);
            if (("---".equals(strG) || "...".equals(strG)) && a.f4073g.a(bVar.f(3))) {
                z.t("while scanning a quoted scalar", aVar, "found unexpected document separator", bVar.c());
                return null;
            }
            while (" \t".indexOf(bVar.e()) != -1) {
                bVar.b(1);
            }
            String strU = u();
            if (strU.isEmpty()) {
                return sb2.toString();
            }
            sb2.append(strU);
        }
    }

    public final void t(boolean z10, yd.a aVar, StringBuilder sb2) throws IOException {
        de.b bVar = this.f4082a;
        while (true) {
            int i = 0;
            while (!a.f4073g.b(bVar.f(i), "'\"\\")) {
                i++;
            }
            if (i != 0) {
                sb2.append(bVar.h(i));
            }
            int iE = bVar.e();
            if (!z10 && iE == 39 && bVar.f(1) == 39) {
                sb2.append('\'');
                bVar.b(2);
            } else if ((z10 && iE == 39) || (!z10 && "\"\\".indexOf(iE) != -1)) {
                sb2.appendCodePoint(iE);
                bVar.b(1);
            } else {
                if (!z10 || iE != 92) {
                    return;
                }
                bVar.b(1);
                int iE2 = bVar.e();
                if (!Character.isSupplementaryCodePoint(iE2)) {
                    char c9 = (char) iE2;
                    Character chValueOf = Character.valueOf(c9);
                    HashMap map = f4080m;
                    if (map.containsKey(chValueOf)) {
                        sb2.append((String) map.get(Character.valueOf(c9)));
                        bVar.b(1);
                    }
                }
                if (!Character.isSupplementaryCodePoint(iE2)) {
                    char c10 = (char) iE2;
                    Character chValueOf2 = Character.valueOf(c10);
                    HashMap map2 = f4081n;
                    if (map2.containsKey(chValueOf2)) {
                        int iIntValue = ((Integer) map2.get(Character.valueOf(c10))).intValue();
                        bVar.b(1);
                        String strG = bVar.g(iIntValue);
                        if (f4079l.matcher(strG).find()) {
                            z.t("while scanning a double-quoted scalar", aVar, "expected escape sequence of " + iIntValue + " hexadecimal numbers, but found: " + strG, bVar.c());
                            return;
                        }
                        try {
                            sb2.appendCodePoint(Integer.parseInt(strG, 16));
                            bVar.b(iIntValue);
                        } catch (IllegalArgumentException unused) {
                            z.t("while scanning a double-quoted scalar", aVar, "found unknown escape character ".concat(strG), bVar.c());
                            return;
                        }
                    }
                }
                if (u().isEmpty()) {
                    z.t("while scanning a double-quoted scalar", aVar, "found unknown escape character " + String.valueOf(Character.toChars(iE2)) + "(" + iE2 + ")", bVar.c());
                    return;
                }
                sb2.append(s(aVar));
            }
        }
    }

    public final String u() {
        de.b bVar = this.f4082a;
        int iE = bVar.e();
        if (iE != 13 && iE != 10 && iE != 133) {
            if (iE != 8232 && iE != 8233) {
                return "";
            }
            bVar.b(1);
            return String.valueOf(Character.toChars(iE));
        }
        if (iE == 13 && 10 == bVar.f(1)) {
            bVar.b(2);
            return "\n";
        }
        bVar.b(1);
        return "\n";
    }

    public final String v(String str, yd.a aVar) {
        de.b bVar = this.f4082a;
        int iE = bVar.e();
        if (iE != 33) {
            String strValueOf = String.valueOf(Character.toChars(iE));
            z.t("while scanning a ".concat(str), aVar, "expected '!', but found " + strValueOf + "(" + iE + ")", bVar.c());
            return null;
        }
        int i = 1;
        int iF = bVar.f(1);
        if (iF != 32) {
            int i3 = 1;
            while (a.f4075j.a(iF)) {
                i3++;
                iF = bVar.f(i3);
            }
            if (iF != 33) {
                bVar.b(i3);
                String strValueOf2 = String.valueOf(Character.toChars(iF));
                z.t("while scanning a ".concat(str), aVar, "expected '!', but found " + strValueOf2 + "(" + iF + ")", bVar.c());
                return null;
            }
            i = 1 + i3;
        }
        return bVar.h(i);
    }

    public final String w(String str, yd.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        de.b bVar = this.f4082a;
        int iF = bVar.f(0);
        int i = 0;
        while (a.i.a(iF)) {
            if (iF == 37) {
                sb2.append(bVar.h(i));
                int i3 = 1;
                while (bVar.f(i3 * 3) == 37) {
                    i3++;
                }
                yd.a aVarC = bVar.c();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3);
                while (bVar.e() == 37) {
                    bVar.b(1);
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(bVar.g(2), 16));
                        bVar.b(2);
                    } catch (NumberFormatException unused) {
                        int iE = bVar.e();
                        String strValueOf = String.valueOf(Character.toChars(iE));
                        int iF2 = bVar.f(1);
                        String strValueOf2 = String.valueOf(Character.toChars(iF2));
                        z.t("while scanning a ".concat(str), aVar, "expected URI escape sequence of 2 hexadecimal numbers, but found " + strValueOf + "(" + iE + ") and " + strValueOf2 + "(" + iF2 + ")", bVar.c());
                        return null;
                    }
                }
                byteBufferAllocate.flip();
                try {
                    sb2.append(he.a.f5590a.decode(byteBufferAllocate).toString());
                    i = 0;
                } catch (CharacterCodingException e10) {
                    throw new ce.a("while scanning a ".concat(str), aVar, "expected URI in UTF-8: " + e10.getMessage(), aVarC);
                }
            } else {
                i++;
            }
            iF = bVar.f(i);
        }
        if (i != 0) {
            sb2.append(bVar.h(i));
        }
        if (sb2.length() != 0) {
            return sb2.toString();
        }
        String strValueOf3 = String.valueOf(Character.toChars(iF));
        z.t("while scanning a ".concat(str), aVar, "expected URI, but found " + strValueOf3 + "(" + iF + ")", bVar.c());
        return null;
    }

    public final Integer x(yd.a aVar) throws IOException {
        de.b bVar = this.f4082a;
        int iE = bVar.e();
        if (Character.isDigit(iE)) {
            int i = 0;
            while (Character.isDigit(bVar.f(i))) {
                i++;
            }
            String strH = bVar.h(i);
            if (i <= 3) {
                return Integer.valueOf(Integer.parseInt(strH));
            }
            z.t("while scanning a YAML directive", aVar, "found a number which cannot represent a valid version: ".concat(strH), bVar.c());
            return null;
        }
        z.t("while scanning a directive", aVar, "expected a digit, but found " + String.valueOf(Character.toChars(iE)) + "(" + iE + ")", bVar.c());
        return null;
    }

    public final void y() {
        LinkedHashMap linkedHashMap = this.f4091k;
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int i = cVar.f4095d;
            de.b bVar = this.f4082a;
            if (i != bVar.f3329h || bVar.f3327f - cVar.f4094c > 1024) {
                if (cVar.f4093b) {
                    z.t("while scanning a simple key", cVar.f4097f, "could not find expected ':'", bVar.c());
                    return;
                }
                it.remove();
            }
        }
    }

    public final void z(int i) {
        if (this.f4084c != 0) {
            return;
        }
        while (this.f4088g > i) {
            yd.a aVarC = this.f4082a.c();
            this.f4088g = ((Integer) this.f4089h.f()).intValue();
            b(new ge.c(aVarC, aVarC, 0));
        }
    }
}
