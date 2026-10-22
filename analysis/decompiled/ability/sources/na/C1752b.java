package na;

import com.fasterxml.jackson.core.JsonFactory;
import ea.C1429b;
import j4.C1597b;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import oa.C1788a;
import oa.e;
import oa.g;
import oa.i;
import oa.k;
import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.scanner.ScannerException;
import org.yaml.snakeyaml.tokens.Token$ID;
import pa.AbstractC1793a;

/* renamed from: na.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1752b {
    public static final Pattern l = Pattern.compile("[^0-9A-Fa-f]");
    public static final HashMap m;
    public static final HashMap n;

    /* renamed from: a, reason: collision with root package name */
    public final la.a f5374a;
    public k e;
    public final C1429b i;
    public boolean b = false;
    public int c = 0;
    public int f = 0;
    public int g = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5375j = true;
    public final ArrayList d = new ArrayList(100);
    public final C1597b h = new C1597b(10);
    public final LinkedHashMap k = new LinkedHashMap();

    static {
        HashMap map = new HashMap();
        m = map;
        HashMap map2 = new HashMap();
        n = map2;
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

    public C1752b(la.a aVar, C1429b c1429b) {
        this.f5374a = aVar;
        this.i = c1429b;
        Mark markC = aVar.c();
        b(new i(markC, markC));
    }

    public final boolean a(int i) {
        int i6 = this.g;
        if (i6 >= i) {
            return false;
        }
        this.h.b(Integer.valueOf(i6));
        this.g = i;
        return true;
    }

    public final void b(k kVar) {
        this.e = kVar;
        this.d.add(kVar);
    }

    public final boolean c(Token$ID token$ID) {
        while (l()) {
            j();
        }
        ArrayList arrayList = this.d;
        return !arrayList.isEmpty() && ((k) arrayList.get(0)).a() == token$ID;
    }

    public final boolean d(Token$ID... token$IDArr) throws NumberFormatException {
        while (l()) {
            j();
        }
        ArrayList arrayList = this.d;
        if (!arrayList.isEmpty()) {
            if (token$IDArr.length == 0) {
                return true;
            }
            Token$ID token$IDA = ((k) arrayList.get(0)).a();
            for (Token$ID token$ID : token$IDArr) {
                if (token$IDA == token$ID) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void e(char c) throws NumberFormatException {
        Boolean bool;
        int i;
        int i6;
        int iMax;
        String str;
        Mark mark;
        Mark mark2;
        this.f5375j = true;
        n();
        boolean z10 = c == '>';
        StringBuilder sb = new StringBuilder();
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        aVar.b(1);
        int iE = aVar.e();
        if (iE == 45 || iE == 43) {
            Boolean bool2 = iE == 43 ? Boolean.TRUE : Boolean.FALSE;
            aVar.b(1);
            int iE2 = aVar.e();
            if (Character.isDigit(iE2)) {
                int i10 = Integer.parseInt(String.valueOf(Character.toChars(iE2)));
                if (i10 == 0) {
                    throw new ScannerException("while scanning a block scalar", markC, "expected indentation indicator in the range 1-9, but found 0", aVar.c());
                }
                aVar.b(1);
                bool = bool2;
                i = i10;
            } else {
                bool = bool2;
                i = -1;
            }
        } else {
            if (Character.isDigit(iE)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(iE)));
                if (i == 0) {
                    throw new ScannerException("while scanning a block scalar", markC, "expected indentation indicator in the range 1-9, but found 0", aVar.c());
                }
                aVar.b(1);
                int iE3 = aVar.e();
                if (iE3 == 45 || iE3 == 43) {
                    bool = iE3 == 43 ? Boolean.TRUE : Boolean.FALSE;
                    aVar.b(1);
                }
            } else {
                i = -1;
            }
            bool = null;
        }
        int iE4 = aVar.e();
        if (C1751a.f.c(iE4)) {
            throw new ScannerException("while scanning a block scalar", markC, androidx.constraintlayout.core.dsl.a.d(iE4, "expected chomping or indentation indicators, but found ", String.valueOf(Character.toChars(iE4)), "(", ")"), aVar.c());
        }
        while (aVar.e() == 32) {
            aVar.b(1);
        }
        e eVarR = aVar.e() == 35 ? r(CommentType.c) : null;
        int iE5 = aVar.e();
        if (u().isEmpty() && iE5 != 0) {
            throw new ScannerException("while scanning a block scalar", markC, androidx.constraintlayout.core.dsl.a.d(iE5, "expected a comment or a line break, but found ", String.valueOf(Character.toChars(iE5)), "(", ")"), aVar.c());
        }
        int i11 = this.g + 1;
        if (i11 < 1) {
            i11 = 1;
        }
        if (i == -1) {
            StringBuilder sb2 = new StringBuilder();
            Mark markC2 = aVar.c();
            int i12 = 0;
            while (true) {
                i6 = 2;
                if (!C1751a.d.b(aVar.e(), " \r")) {
                    break;
                }
                if (aVar.e() != 32) {
                    sb2.append(u());
                    markC2 = aVar.c();
                } else {
                    aVar.b(1);
                    int i13 = aVar.i;
                    if (i13 > i12) {
                        i12 = i13;
                    }
                }
            }
            Object[] objArr = {sb2.toString(), Integer.valueOf(i12), markC2};
            str = (String) objArr[0];
            int iIntValue = ((Integer) objArr[1]).intValue();
            mark = (Mark) objArr[2];
            iMax = Math.max(i11, iIntValue);
        } else {
            i6 = 2;
            iMax = (i11 + i) - 1;
            Object[] objArrQ = q(iMax);
            str = (String) objArrQ[0];
            mark = (Mark) objArrQ[1];
        }
        String strU = "";
        while (aVar.i == iMax && aVar.e() != 0) {
            sb.append(str);
            boolean z11 = " \t".indexOf(aVar.e()) == -1;
            int i14 = 0;
            while (C1751a.e.c(aVar.f(i14))) {
                i14++;
            }
            sb.append(aVar.h(i14));
            strU = u();
            Object[] objArrQ2 = q(iMax);
            String str2 = (String) objArrQ2[0];
            mark2 = (Mark) objArrQ2[1];
            if (aVar.i != iMax || aVar.e() == 0) {
                str = str2;
                break;
            }
            if (z10 && "\n".equals(strU) && z11) {
                if (" \t".indexOf(aVar.e()) == -1) {
                    if (str2.isEmpty()) {
                        sb.append(' ');
                    }
                }
                mark = mark2;
                str = str2;
            }
            sb.append(strU);
            mark = mark2;
            str = str2;
        }
        mark2 = mark;
        if (bool == null || bool.booleanValue()) {
            sb.append(strU);
        }
        if (bool != null && bool.booleanValue()) {
            sb.append(str);
        }
        g gVar = new g(sb.toString(), false, markC, mark2, DumperOptions$ScalarStyle.a(Character.valueOf(c)));
        int i15 = i6;
        k[] kVarArr = new k[i15];
        kVarArr[0] = eVarR;
        kVarArr[1] = gVar;
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < i15; i16++) {
            k kVar = kVarArr[i16];
            if (kVar != null && !(kVar instanceof e)) {
                arrayList.add(kVar);
            }
        }
        this.e = (k) arrayList.get(arrayList.size() - 1);
        this.d.addAll(arrayList);
    }

    public final void f(boolean z10) {
        z(-1);
        n();
        this.f5375j = false;
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        aVar.b(3);
        Mark markC2 = aVar.c();
        b(z10 ? new oa.c(markC, markC2, 4) : new oa.c(markC, markC2, 3));
    }

    public final void g(boolean z10) {
        n();
        this.c--;
        this.f5375j = false;
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        aVar.b(1);
        Mark markC2 = aVar.c();
        b(z10 ? new oa.c(markC, markC2, 6) : new oa.c(markC, markC2, 8));
    }

    public final void h(boolean z10) {
        o();
        this.c++;
        this.f5375j = true;
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        aVar.b(1);
        Mark markC2 = aVar.c();
        b(z10 ? new oa.c(markC, markC2, 7) : new oa.c(markC, markC2, 9));
    }

    public final void i(char c) {
        o();
        this.f5375j = false;
        boolean z10 = c == '\"';
        StringBuilder sb = new StringBuilder();
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        int iE = aVar.e();
        aVar.b(1);
        t(z10, markC, sb);
        while (aVar.e() != iE) {
            int i = 0;
            while (" \t".indexOf(aVar.f(i)) != -1) {
                i++;
            }
            String strH = aVar.h(i);
            if (aVar.e() == 0) {
                throw new ScannerException("while scanning a quoted scalar", markC, "found unexpected end of stream", aVar.c());
            }
            String strU = u();
            if (strU.isEmpty()) {
                sb.append(strH);
            } else {
                String strS = s(markC);
                if (!"\n".equals(strU)) {
                    sb.append(strU);
                } else if (strS.isEmpty()) {
                    sb.append(' ');
                }
                sb.append(strS);
            }
            t(z10, markC, sb);
        }
        aVar.b(1);
        b(new g(sb.toString(), false, markC, aVar.c(), DumperOptions$ScalarStyle.a(Character.valueOf(c))));
    }

    /* JADX WARN: Removed duplicated region for block: B:224:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x05cf A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: na.C1752b.j():void");
    }

    public final k k() {
        this.f++;
        return (k) this.d.remove(0);
    }

    public final boolean l() {
        if (this.b) {
            return false;
        }
        if (this.d.isEmpty()) {
            return true;
        }
        y();
        LinkedHashMap linkedHashMap = this.k;
        return (!linkedHashMap.isEmpty() ? ((C1753c) linkedHashMap.values().iterator().next()).f5376a : -1) == this.f;
    }

    public final k m() {
        while (l()) {
            j();
        }
        return (k) this.d.get(0);
    }

    public final void n() {
        C1753c c1753c = (C1753c) this.k.remove(Integer.valueOf(this.c));
        if (c1753c != null && c1753c.b) {
            throw new ScannerException("while scanning a simple key", c1753c.f, "could not find expected ':'", this.f5374a.c());
        }
    }

    public final void o() {
        int i = this.c;
        la.a aVar = this.f5374a;
        boolean z10 = i == 0 && this.g == aVar.i;
        boolean z11 = this.f5375j;
        if (!z11 && z10) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (z11) {
            n();
            this.k.put(Integer.valueOf(this.c), new C1753c(this.d.size() + this.f, z10, aVar.f, aVar.h, aVar.i, aVar.c()));
        }
    }

    public final k p(boolean z10) {
        C1751a c1751a;
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        String str = aVar.e() == 42 ? "alias" : "anchor";
        aVar.b(1);
        int i = 0;
        int iF = aVar.f(0);
        while (true) {
            c1751a = C1751a.g;
            if (c1751a.b(iF, ":,[]{}/.*&")) {
                break;
            }
            i++;
            iF = aVar.f(i);
        }
        if (i == 0) {
            throw new ScannerException("while scanning an ".concat(str), markC, androidx.constraintlayout.core.dsl.a.d(iF, "unexpected character found ", String.valueOf(Character.toChars(iF)), "(", ")"), aVar.c());
        }
        String strH = aVar.h(i);
        int iE = aVar.e();
        if (!c1751a.b(iE, "?:,]}%@`")) {
            throw new ScannerException("while scanning an ".concat(str), markC, androidx.constraintlayout.core.dsl.a.d(iE, "unexpected character found ", String.valueOf(Character.toChars(iE)), "(", ")"), aVar.c());
        }
        Mark markC2 = aVar.c();
        return z10 ? new oa.b(strH, markC, markC2) : new C1788a(strH, markC, markC2);
    }

    public final Object[] q(int i) {
        StringBuilder sb = new StringBuilder();
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        for (int i6 = aVar.i; i6 < i && aVar.e() == 32; i6++) {
            aVar.b(1);
        }
        while (true) {
            String strU = u();
            if (strU.isEmpty()) {
                return new Object[]{sb.toString(), markC};
            }
            sb.append(strU);
            markC = aVar.c();
            for (int i10 = aVar.i; i10 < i && aVar.e() == 32; i10++) {
                aVar.b(1);
            }
        }
    }

    public final e r(CommentType commentType) {
        la.a aVar = this.f5374a;
        Mark markC = aVar.c();
        aVar.b(1);
        int i = 0;
        while (C1751a.e.c(aVar.f(i))) {
            i++;
        }
        return new e(commentType, aVar.h(i), markC, aVar.c());
    }

    public final String s(Mark mark) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            la.a aVar = this.f5374a;
            String strG = aVar.g(3);
            if (("---".equals(strG) || "...".equals(strG)) && C1751a.g.a(aVar.f(3))) {
                throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", aVar.c());
            }
            while (" \t".indexOf(aVar.e()) != -1) {
                aVar.b(1);
            }
            String strU = u();
            if (strU.isEmpty()) {
                return sb.toString();
            }
            sb.append(strU);
        }
    }

    public final void t(boolean z10, Mark mark, StringBuilder sb) {
        la.a aVar;
        while (true) {
            int i = 0;
            while (true) {
                C1751a c1751a = C1751a.g;
                aVar = this.f5374a;
                if (c1751a.b(aVar.f(i), "'\"\\")) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != 0) {
                sb.append(aVar.h(i));
            }
            int iE = aVar.e();
            if (!z10 && iE == 39 && aVar.f(1) == 39) {
                sb.append('\'');
                aVar.b(2);
            } else if ((z10 && iE == 39) || (!z10 && "\"\\".indexOf(iE) != -1)) {
                sb.appendCodePoint(iE);
                aVar.b(1);
            } else {
                if (!z10 || iE != 92) {
                    return;
                }
                aVar.b(1);
                int iE2 = aVar.e();
                if (!Character.isSupplementaryCodePoint(iE2)) {
                    char c = (char) iE2;
                    Character chValueOf = Character.valueOf(c);
                    HashMap map = m;
                    if (map.containsKey(chValueOf)) {
                        sb.append((String) map.get(Character.valueOf(c)));
                        aVar.b(1);
                    }
                }
                if (!Character.isSupplementaryCodePoint(iE2)) {
                    char c2 = (char) iE2;
                    Character chValueOf2 = Character.valueOf(c2);
                    HashMap map2 = n;
                    if (map2.containsKey(chValueOf2)) {
                        int iIntValue = ((Integer) map2.get(Character.valueOf(c2))).intValue();
                        aVar.b(1);
                        String strG = aVar.g(iIntValue);
                        if (l.matcher(strG).find()) {
                            throw new ScannerException("while scanning a double-quoted scalar", mark, androidx.constraintlayout.core.dsl.a.c(iIntValue, "expected escape sequence of ", " hexadecimal numbers, but found: ", strG), aVar.c());
                        }
                        try {
                            sb.appendCodePoint(Integer.parseInt(strG, 16));
                            aVar.b(iIntValue);
                        } catch (IllegalArgumentException unused) {
                            throw new ScannerException("while scanning a double-quoted scalar", mark, "found unknown escape character ".concat(strG), aVar.c());
                        }
                    }
                }
                if (u().isEmpty()) {
                    throw new ScannerException("while scanning a double-quoted scalar", mark, androidx.constraintlayout.core.dsl.a.d(iE2, "found unknown escape character ", String.valueOf(Character.toChars(iE2)), "(", ")"), aVar.c());
                }
                sb.append(s(mark));
            }
        }
    }

    public final String u() {
        la.a aVar = this.f5374a;
        int iE = aVar.e();
        if (iE != 13 && iE != 10 && iE != 133) {
            if (iE != 8232 && iE != 8233) {
                return "";
            }
            aVar.b(1);
            return String.valueOf(Character.toChars(iE));
        }
        if (iE == 13 && 10 == aVar.f(1)) {
            aVar.b(2);
            return "\n";
        }
        aVar.b(1);
        return "\n";
    }

    public final String v(String str, Mark mark) {
        la.a aVar = this.f5374a;
        int iE = aVar.e();
        if (iE != 33) {
            throw new ScannerException("while scanning a ".concat(str), mark, androidx.constraintlayout.core.dsl.a.d(iE, "expected '!', but found ", String.valueOf(Character.toChars(iE)), "(", ")"), aVar.c());
        }
        int i = 1;
        int iF = aVar.f(1);
        if (iF != 32) {
            int i6 = 1;
            while (C1751a.f5372j.a(iF)) {
                i6++;
                iF = aVar.f(i6);
            }
            if (iF != 33) {
                aVar.b(i6);
                throw new ScannerException("while scanning a ".concat(str), mark, androidx.constraintlayout.core.dsl.a.d(iF, "expected '!', but found ", String.valueOf(Character.toChars(iF)), "(", ")"), aVar.c());
            }
            i = 1 + i6;
        }
        return aVar.h(i);
    }

    public final String w(String str, Mark mark) {
        StringBuilder sb = new StringBuilder();
        la.a aVar = this.f5374a;
        int iF = aVar.f(0);
        int i = 0;
        while (C1751a.i.a(iF)) {
            if (iF == 37) {
                sb.append(aVar.h(i));
                int i6 = 1;
                while (aVar.f(i6 * 3) == 37) {
                    i6++;
                }
                Mark markC = aVar.c();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i6);
                while (aVar.e() == 37) {
                    aVar.b(1);
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(aVar.g(2), 16));
                        aVar.b(2);
                    } catch (NumberFormatException unused) {
                        int iE = aVar.e();
                        String strValueOf = String.valueOf(Character.toChars(iE));
                        int iF2 = aVar.f(1);
                        String strValueOf2 = String.valueOf(Character.toChars(iF2));
                        String strConcat = "while scanning a ".concat(str);
                        StringBuilder sbT = androidx.appfunctions.metadata.a.t(iE, "expected URI escape sequence of 2 hexadecimal numbers, but found ", strValueOf, "(", ") and ");
                        sbT.append(strValueOf2);
                        sbT.append("(");
                        sbT.append(iF2);
                        sbT.append(")");
                        throw new ScannerException(strConcat, mark, sbT.toString(), aVar.c());
                    }
                }
                byteBufferAllocate.flip();
                try {
                    sb.append(AbstractC1793a.f5570a.decode(byteBufferAllocate).toString());
                    i = 0;
                } catch (CharacterCodingException e) {
                    throw new ScannerException("while scanning a ".concat(str), mark, "expected URI in UTF-8: " + e.getMessage(), markC);
                }
            } else {
                i++;
            }
            iF = aVar.f(i);
        }
        if (i != 0) {
            sb.append(aVar.h(i));
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        throw new ScannerException("while scanning a ".concat(str), mark, androidx.constraintlayout.core.dsl.a.d(iF, "expected URI, but found ", String.valueOf(Character.toChars(iF)), "(", ")"), aVar.c());
    }

    public final Integer x(Mark mark) {
        la.a aVar = this.f5374a;
        int iE = aVar.e();
        if (!Character.isDigit(iE)) {
            throw new ScannerException("while scanning a directive", mark, androidx.constraintlayout.core.dsl.a.d(iE, "expected a digit, but found ", String.valueOf(Character.toChars(iE)), "(", ")"), aVar.c());
        }
        int i = 0;
        while (Character.isDigit(aVar.f(i))) {
            i++;
        }
        String strH = aVar.h(i);
        if (i <= 3) {
            return Integer.valueOf(Integer.parseInt(strH));
        }
        throw new ScannerException("while scanning a YAML directive", mark, "found a number which cannot represent a valid version: ".concat(strH), aVar.c());
    }

    public final void y() {
        LinkedHashMap linkedHashMap = this.k;
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            C1753c c1753c = (C1753c) it.next();
            int i = c1753c.d;
            la.a aVar = this.f5374a;
            if (i != aVar.h || aVar.f - c1753c.c > 1024) {
                if (c1753c.b) {
                    throw new ScannerException("while scanning a simple key", c1753c.f, "could not find expected ':'", aVar.c());
                }
                it.remove();
            }
        }
    }

    public final void z(int i) {
        if (this.c != 0) {
            return;
        }
        while (this.g > i) {
            Mark markC = this.f5374a.c();
            this.g = ((Integer) this.h.a()).intValue();
            b(new oa.c(markC, markC, 0));
        }
    }
}
