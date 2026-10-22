package com.typesafe.config.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes4.dex */
public final class Tokenizer {

    public static class ProblemException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final Q f31833a;

        public ProblemException(Q q10) {
            this.f31833a = q10;
        }

        public Q a() {
            return this.f31833a;
        }
    }

    public static class a implements Iterator<Q> {

        /* renamed from: a, reason: collision with root package name */
        public final M f31834a;

        /* renamed from: b, reason: collision with root package name */
        public final Reader f31835b;

        /* renamed from: c, reason: collision with root package name */
        public final LinkedList<Integer> f31836c = new LinkedList<>();

        /* renamed from: d, reason: collision with root package name */
        public int f31837d = 1;

        /* renamed from: e, reason: collision with root package name */
        public b8.k f31838e;

        /* renamed from: f, reason: collision with root package name */
        public final Queue<Q> f31839f;

        /* renamed from: g, reason: collision with root package name */
        public final C0381a f31840g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f31841h;

        /* renamed from: com.typesafe.config.impl.Tokenizer$a$a, reason: collision with other inner class name */
        public static class C0381a {

            /* renamed from: a, reason: collision with root package name */
            public StringBuilder f31842a = new StringBuilder();

            /* renamed from: b, reason: collision with root package name */
            public boolean f31843b = false;

            public void a(int i10) {
                this.f31842a.appendCodePoint(i10);
            }

            public Q b(Q q10, b8.k kVar, int i10) {
                return a.d(q10) ? d(kVar, i10) : e(kVar, i10);
            }

            public final Q c(b8.k kVar, int i10) {
                if (this.f31842a.length() <= 0) {
                    return null;
                }
                Q qX = this.f31843b ? S.x(a.g(kVar, i10), this.f31842a.toString()) : S.q(a.g(kVar, i10), this.f31842a.toString());
                this.f31842a.setLength(0);
                return qX;
            }

            public final Q d(b8.k kVar, int i10) {
                Q qC = c(kVar, i10);
                if (!this.f31843b) {
                    this.f31843b = true;
                }
                return qC;
            }

            public final Q e(b8.k kVar, int i10) {
                this.f31843b = false;
                return c(kVar, i10);
            }
        }

        public a(b8.k kVar, Reader reader, boolean z10) {
            M m10 = (M) kVar;
            this.f31834a = m10;
            this.f31835b = reader;
            this.f31841h = z10;
            this.f31838e = m10.b(1);
            LinkedList linkedList = new LinkedList();
            this.f31839f = linkedList;
            linkedList.add(S.f31787a);
            this.f31840g = new C0381a();
        }

        public static boolean d(Q q10) {
            return S.i(q10) || S.j(q10) || S.k(q10);
        }

        public static boolean e(int i10) {
            return C3904j.e(i10);
        }

        public static boolean f(int i10) {
            return i10 != 10 && C3904j.e(i10);
        }

        public static b8.k g(b8.k kVar, int i10) {
            return ((M) kVar).b(i10);
        }

        public static ProblemException k(b8.k kVar, String str) {
            return l(kVar, "", str, null);
        }

        public static ProblemException l(b8.k kVar, String str, String str2, Throwable th) {
            return m(kVar, str, str2, false, th);
        }

        public static ProblemException m(b8.k kVar, String str, String str2, boolean z10, Throwable th) {
            if (str == null || str2 == null) {
                throw new ConfigException.BugOrBroken("internal error, creating bad ProblemException");
            }
            return new ProblemException(S.u(kVar, str, str2, z10, th));
        }

        public final void A(int i10) {
            if (this.f31836c.size() > 2) {
                throw new ConfigException.BugOrBroken("bug: putBack() three times, undesirable look-ahead");
            }
            this.f31836c.push(Integer.valueOf(i10));
        }

        public final void B() throws ProblemException {
            Q qU = u(this.f31840g);
            Q qB = this.f31840g.b(qU, this.f31834a, this.f31837d);
            if (qB != null) {
                this.f31839f.add(qB);
            }
            this.f31839f.add(qU);
        }

        public final boolean C(int i10) {
            if (i10 != -1 && this.f31841h) {
                if (i10 == 35) {
                    return true;
                }
                if (i10 == 47) {
                    int iJ = j();
                    A(iJ);
                    if (iJ == 47) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void c(StringBuilder sb2, StringBuilder sb3) throws ProblemException {
            int i10 = 0;
            while (true) {
                int iJ = j();
                if (iJ == 34) {
                    i10++;
                } else if (i10 >= 3) {
                    sb2.setLength(sb2.length() - 3);
                    A(iJ);
                    return;
                } else {
                    if (iJ == -1) {
                        throw n("End of input but triple-quoted string was still open");
                    }
                    if (iJ == 10) {
                        int i11 = this.f31837d + 1;
                        this.f31837d = i11;
                        this.f31838e = this.f31834a.b(i11);
                    }
                    i10 = 0;
                }
                sb2.appendCodePoint(iJ);
                sb3.appendCodePoint(iJ);
            }
        }

        @Override // java.util.Iterator
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Q next() {
            Q qRemove = this.f31839f.remove();
            if (this.f31839f.isEmpty() && qRemove != S.f31788b) {
                try {
                    B();
                } catch (ProblemException e10) {
                    this.f31839f.add(e10.a());
                }
                if (this.f31839f.isEmpty()) {
                    throw new ConfigException.BugOrBroken("bug: tokens queue should not be empty here");
                }
            }
            return qRemove;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f31839f.isEmpty();
        }

        public final int i(C0381a c0381a) {
            while (true) {
                int iJ = j();
                if (iJ == -1) {
                    return -1;
                }
                if (!f(iJ)) {
                    return iJ;
                }
                c0381a.a(iJ);
            }
        }

        public final int j() {
            if (!this.f31836c.isEmpty()) {
                return this.f31836c.pop().intValue();
            }
            try {
                return this.f31835b.read();
            } catch (IOException e10) {
                throw new ConfigException.IO(this.f31834a, "read error: " + e10.getMessage(), e10);
            }
        }

        public final ProblemException n(String str) {
            return p("", str, null);
        }

        public final ProblemException o(String str, String str2) {
            return p(str, str2, null);
        }

        public final ProblemException p(String str, String str2, Throwable th) {
            return l(this.f31838e, str, str2, th);
        }

        public final ProblemException q(String str, String str2, boolean z10) {
            return r(str, str2, z10, null);
        }

        public final ProblemException r(String str, String str2, boolean z10, Throwable th) {
            return m(this.f31838e, str, str2, z10, th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Does not make sense to remove items from token stream");
        }

        public final Q s(int i10) {
            boolean z10;
            int iJ;
            if (i10 != 47) {
                z10 = false;
            } else {
                if (j() != 47) {
                    throw new ConfigException.BugOrBroken("called pullComment but // not seen");
                }
                z10 = true;
            }
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                iJ = j();
                if (iJ == -1 || iJ == 10) {
                    break;
                }
                sb2.appendCodePoint(iJ);
            }
            A(iJ);
            return z10 ? S.n(this.f31838e, sb2.toString()) : S.o(this.f31838e, sb2.toString());
        }

        public final void t(StringBuilder sb2, StringBuilder sb3) throws ProblemException {
            int iJ = j();
            if (iJ == -1) {
                throw n("End of input but backslash in string had nothing after it");
            }
            sb3.appendCodePoint(92);
            sb3.appendCodePoint(iJ);
            if (iJ == 34) {
                sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                return;
            }
            if (iJ == 47) {
                sb2.append(JsonPointer.SEPARATOR);
                return;
            }
            if (iJ == 92) {
                sb2.append('\\');
                return;
            }
            if (iJ == 98) {
                sb2.append('\b');
                return;
            }
            if (iJ == 102) {
                sb2.append('\f');
                return;
            }
            if (iJ == 110) {
                sb2.append('\n');
                return;
            }
            if (iJ == 114) {
                sb2.append('\r');
                return;
            }
            if (iJ == 116) {
                sb2.append('\t');
                return;
            }
            if (iJ != 117) {
                throw o(Tokenizer.b(iJ), String.format("backslash followed by '%s', this is not a valid escape sequence (quoted strings use JSON escaping, so use double-backslash \\\\ for literal backslash)", Tokenizer.b(iJ)));
            }
            char[] cArr = new char[4];
            for (int i10 = 0; i10 < 4; i10++) {
                int iJ2 = j();
                if (iJ2 == -1) {
                    throw n("End of input but expecting 4 hex digits for \\uXXXX escape");
                }
                cArr[i10] = (char) iJ2;
            }
            String str = new String(cArr);
            sb3.append(cArr);
            try {
                sb2.appendCodePoint(Integer.parseInt(str, 16));
            } catch (NumberFormatException e10) {
                throw p(str, String.format("Malformed hex digits after \\u escape in string: '%s'", str), e10);
            }
        }

        public final Q u(C0381a c0381a) throws ProblemException {
            Q qZ;
            int i10 = i(c0381a);
            if (i10 == -1) {
                return S.f31788b;
            }
            if (i10 == 10) {
                Q qR = S.r(this.f31838e);
                int i11 = this.f31837d + 1;
                this.f31837d = i11;
                this.f31838e = this.f31834a.b(i11);
                return qR;
            }
            if (C(i10)) {
                qZ = s(i10);
            } else {
                Q qW = i10 != 34 ? i10 != 36 ? i10 != 58 ? i10 != 61 ? i10 != 91 ? i10 != 93 ? i10 != 123 ? i10 != 125 ? i10 != 43 ? i10 != 44 ? null : S.f31789c : w() : S.f31793g : S.f31792f : S.f31795i : S.f31794h : S.f31790d : S.f31791e : y() : x();
                if (qW != null) {
                    qZ = qW;
                } else if ("0123456789-".indexOf(i10) >= 0) {
                    qZ = v(i10);
                } else {
                    if ("$\"{}[]:=,+#`^?!@*&\\".indexOf(i10) >= 0) {
                        throw q(Tokenizer.b(i10), "Reserved character '" + Tokenizer.b(i10) + "' is not allowed outside quotes", true);
                    }
                    A(i10);
                    qZ = z();
                }
            }
            if (qZ != null) {
                return qZ;
            }
            throw new ConfigException.BugOrBroken("bug: failed to generate next token");
        }

        public final Q v(int i10) throws ProblemException {
            StringBuilder sb2 = new StringBuilder();
            sb2.appendCodePoint(i10);
            int iJ = j();
            boolean z10 = false;
            while (iJ != -1 && "0123456789eE+-.".indexOf(iJ) >= 0) {
                if (iJ == 46 || iJ == 101 || iJ == 69) {
                    z10 = true;
                }
                sb2.appendCodePoint(iJ);
                iJ = j();
            }
            A(iJ);
            String string = sb2.toString();
            try {
                return z10 ? S.p(this.f31838e, Double.parseDouble(string), string) : S.s(this.f31838e, Long.parseLong(string), string);
            } catch (NumberFormatException unused) {
                for (char c10 : string.toCharArray()) {
                    if ("$\"{}[]:=,+#`^?!@*&\\".indexOf(c10) >= 0) {
                        throw q(Tokenizer.b(c10), "Reserved character '" + Tokenizer.b(c10) + "' is not allowed outside quotes", true);
                    }
                }
                return S.x(this.f31838e, string);
            }
        }

        public final Q w() throws ProblemException {
            int iJ = j();
            if (iJ == 61) {
                return S.f31796j;
            }
            throw q(Tokenizer.b(iJ), "'+' not followed by =, '" + Tokenizer.b(iJ) + "' not allowed after '+'", true);
        }

        public final Q x() throws ProblemException {
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            sb3.appendCodePoint(34);
            while (true) {
                int iJ = j();
                if (iJ == -1) {
                    throw n("End of input but string quote was still open");
                }
                if (iJ == 92) {
                    t(sb2, sb3);
                } else {
                    if (iJ == 34) {
                        sb3.appendCodePoint(iJ);
                        if (sb2.length() == 0) {
                            int iJ2 = j();
                            if (iJ2 == 34) {
                                sb3.appendCodePoint(iJ2);
                                c(sb2, sb3);
                            } else {
                                A(iJ2);
                            }
                        }
                        return S.v(this.f31838e, sb2.toString(), sb3.toString());
                    }
                    if (C3904j.d(iJ)) {
                        throw o(Tokenizer.b(iJ), "JSON does not allow unescaped " + Tokenizer.b(iJ) + " in quoted strings, use a backslash escape");
                    }
                    sb2.appendCodePoint(iJ);
                    sb3.appendCodePoint(iJ);
                }
            }
        }

        public final Q y() throws ProblemException {
            b8.k kVar = this.f31838e;
            int iJ = j();
            boolean z10 = true;
            if (iJ != 123) {
                throw q(Tokenizer.b(iJ), "'$' not followed by {, '" + Tokenizer.b(iJ) + "' not allowed after '$'", true);
            }
            int iJ2 = j();
            if (iJ2 != 63) {
                A(iJ2);
                z10 = false;
            }
            C0381a c0381a = new C0381a();
            ArrayList arrayList = new ArrayList();
            while (true) {
                Q qU = u(c0381a);
                if (qU == S.f31793g) {
                    return S.w(kVar, z10, arrayList);
                }
                if (qU == S.f31788b) {
                    throw k(kVar, "Substitution ${ was not closed with a }");
                }
                Q qB = c0381a.b(qU, kVar, this.f31837d);
                if (qB != null) {
                    arrayList.add(qB);
                }
                arrayList.add(qU);
            }
        }

        public final Q z() {
            b8.k kVar = this.f31838e;
            StringBuilder sb2 = new StringBuilder();
            int iJ = j();
            while (iJ != -1 && "$\"{}[]:=,+#`^?!@*&\\".indexOf(iJ) < 0 && !e(iJ) && !C(iJ)) {
                sb2.appendCodePoint(iJ);
                if (sb2.length() == 4) {
                    String string = sb2.toString();
                    if (string.equals("true")) {
                        return S.m(kVar, true);
                    }
                    if (string.equals("null")) {
                        return S.t(kVar);
                    }
                } else if (sb2.length() == 5 && sb2.toString().equals("false")) {
                    return S.m(kVar, false);
                }
                iJ = j();
            }
            A(iJ);
            return S.x(kVar, sb2.toString());
        }
    }

    public static String b(int i10) {
        return i10 == 10 ? "newline" : i10 == 9 ? "tab" : i10 == -1 ? "end of file" : C3904j.d(i10) ? String.format("control character 0x%x", Integer.valueOf(i10)) : String.format("%c", Integer.valueOf(i10));
    }

    public static String c(Iterator<Q> it) {
        StringBuilder sb2 = new StringBuilder();
        while (it.hasNext()) {
            sb2.append(it.next().e());
        }
        return sb2.toString();
    }

    public static Iterator<Q> d(b8.k kVar, Reader reader, ConfigSyntax configSyntax) {
        return new a(kVar, reader, configSyntax != ConfigSyntax.JSON);
    }
}
