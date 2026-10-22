package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import com.typesafe.config.ConfigValueType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.typesafe.config.impl.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3902h {

    /* renamed from: com.typesafe.config.impl.h$a */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public final Iterator<Q> f31858c;

        /* renamed from: d, reason: collision with root package name */
        public final ConfigSyntax f31859d;

        /* renamed from: e, reason: collision with root package name */
        public final b8.k f31860e;

        /* renamed from: g, reason: collision with root package name */
        public final String f31862g = "expecting a close parentheses ')' here, not: ";

        /* renamed from: a, reason: collision with root package name */
        public int f31856a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final Stack<Q> f31857b = new Stack<>();

        /* renamed from: f, reason: collision with root package name */
        public int f31861f = 0;

        public a(ConfigSyntax configSyntax, b8.k kVar, Iterator<Q> it) {
            this.f31858c = it;
            this.f31859d = configSyntax;
            this.f31860e = kVar;
        }

        public static boolean e(Q q10) {
            return S.j(q10) && S.d(q10).equals("include");
        }

        public static boolean g(Q q10) {
            if (!S.j(q10)) {
                return false;
            }
            String strD = S.d(q10);
            for (int i10 = 0; i10 < strD.length(); i10++) {
                if (!C3904j.e(strD.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        public final String a(D d10, boolean z10, String str, String str2) {
            String str3;
            String strK = d10 != null ? d10.k() : null;
            if (str.equals(S.f31788b.toString())) {
                if (strK == null) {
                    return str2;
                }
                str3 = str2 + " (if you intended '" + strK + "' to be part of a value, instead of a key, try adding double quotes around the whole value";
            } else if (strK != null) {
                str3 = str2 + " (if you intended " + str + " to be part of the value for '" + strK + "', try enclosing the value in double quotes";
            } else {
                str3 = str2 + " (if you intended " + str + " to be part of a key or string value, try enclosing the key or value in double quotes";
            }
            if (z10) {
                return str3 + ", or you may be able to rename the file .properties rather than .conf)";
            }
            return str3 + ")";
        }

        public final String b(String str, String str2) {
            return a(null, this.f31861f > 0, str, str2);
        }

        public final boolean c(Collection<AbstractC3895a> collection) {
            boolean z10 = false;
            if (this.f31859d == ConfigSyntax.JSON) {
                Q qI = i(collection);
                if (qI == S.f31789c) {
                    collection.add(new u(qI));
                    return true;
                }
                t(qI);
                return false;
            }
            Q qH = h();
            while (true) {
                if (!S.g(qH) && !g(qH)) {
                    if (!S.f(qH)) {
                        if (!S.h(qH)) {
                            break;
                        }
                        this.f31856a++;
                        collection.add(new u(qH));
                        z10 = true;
                    } else {
                        collection.add(new C3906l(qH));
                    }
                } else {
                    collection.add(new u(qH));
                }
                qH = h();
            }
            if (qH == S.f31789c) {
                collection.add(new u(qH));
                return true;
            }
            t(qH);
            return z10;
        }

        public final AbstractC3896b d(Collection<AbstractC3895a> collection) {
            AbstractC3896b abstractC3896b = null;
            if (this.f31859d == ConfigSyntax.JSON) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Q qI = i(collection);
            int i10 = 0;
            while (true) {
                if (S.g(qI)) {
                    arrayList.add(new u(qI));
                    qI = h();
                } else {
                    if (!S.k(qI) && !S.j(qI) && !S.i(qI) && qI != S.f31792f && qI != S.f31794h) {
                        t(qI);
                        if (i10 >= 2) {
                            for (int size = arrayList.size() - 1; size >= 0 && (arrayList.get(size) instanceof u); size--) {
                                t(((u) arrayList.get(size)).c());
                                arrayList.remove(size);
                            }
                            return new C3908n(arrayList);
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            AbstractC3895a abstractC3895a = (AbstractC3895a) it.next();
                            if (abstractC3895a instanceof AbstractC3896b) {
                                abstractC3896b = (AbstractC3896b) abstractC3895a;
                            } else if (abstractC3896b == null) {
                                collection.add(abstractC3895a);
                            } else {
                                t((Q) new ArrayList(abstractC3895a.b()).get(0));
                            }
                        }
                        return abstractC3896b;
                    }
                    AbstractC3896b abstractC3896bR = r(qI);
                    i10++;
                    if (abstractC3896bR == null) {
                        throw new ConfigException.BugOrBroken("no value");
                    }
                    arrayList.add(abstractC3896bR);
                    qI = h();
                }
            }
        }

        public final boolean f(Q q10) {
            return this.f31859d == ConfigSyntax.JSON ? q10 == S.f31791e : q10 == S.f31791e || q10 == S.f31790d || q10 == S.f31796j;
        }

        public final Q h() {
            Q qS = s();
            if (this.f31859d == ConfigSyntax.JSON) {
                if (S.j(qS) && !g(qS)) {
                    throw l("Token not allowed in valid JSON: '" + S.d(qS) + "'");
                }
                if (S.i(qS)) {
                    throw l("Substitutions (${} syntax) not allowed in JSON");
                }
            }
            return qS;
        }

        public final Q i(Collection<AbstractC3895a> collection) {
            Q qH;
            while (true) {
                qH = h();
                if (!S.g(qH) && !S.h(qH) && !g(qH)) {
                    if (!S.f(qH)) {
                        break;
                    }
                    collection.add(new C3906l(qH));
                } else {
                    collection.add(new u(qH));
                    if (S.h(qH)) {
                        this.f31856a = qH.b() + 1;
                    }
                }
            }
            int iB = qH.b();
            if (iB >= 0) {
                this.f31856a = iB;
            }
            return qH;
        }

        public C3912s j() {
            AbstractC3896b abstractC3896bR;
            ArrayList arrayList = new ArrayList();
            Q qH = h();
            if (qH != S.f31787a) {
                throw new ConfigException.BugOrBroken("token stream did not begin with START, had " + qH);
            }
            Q qI = i(arrayList);
            boolean z10 = false;
            if (qI == S.f31792f || qI == S.f31794h) {
                abstractC3896bR = r(qI);
            } else {
                if (this.f31859d == ConfigSyntax.JSON) {
                    if (qI == S.f31788b) {
                        throw l("Empty document");
                    }
                    throw l("Document must have an object or array at root, unexpected token: " + qI);
                }
                t(qI);
                abstractC3896bR = q(false);
                z10 = true;
            }
            if ((abstractC3896bR instanceof C3911q) && z10) {
                arrayList.addAll(((AbstractC3907m) abstractC3896bR).c());
            } else {
                arrayList.add(abstractC3896bR);
            }
            Q qI2 = i(arrayList);
            if (qI2 == S.f31788b) {
                return z10 ? new C3912s(Collections.singletonList(new C3911q(arrayList)), this.f31860e) : new C3912s(arrayList, this.f31860e);
            }
            throw l("Document has trailing tokens after first object or array: " + qI2);
        }

        public final AbstractC3907m k() {
            ArrayList arrayList = new ArrayList();
            Q q10 = S.f31794h;
            arrayList.add(new u(q10));
            AbstractC3896b abstractC3896bD = d(arrayList);
            if (abstractC3896bD != null) {
                arrayList.add(abstractC3896bD);
            } else {
                Q qI = i(arrayList);
                if (qI == S.f31795i) {
                    arrayList.add(new u(qI));
                    return new C3905k(arrayList);
                }
                if (!S.k(qI) && qI != S.f31792f && qI != q10 && !S.j(qI) && !S.i(qI)) {
                    throw l("List should have ] or a first element after the open [, instead had token: " + qI + " (if you want " + qI + " to be part of a string value, then double-quote it)");
                }
                arrayList.add(r(qI));
            }
            while (c(arrayList)) {
                AbstractC3896b abstractC3896bD2 = d(arrayList);
                if (abstractC3896bD2 != null) {
                    arrayList.add(abstractC3896bD2);
                } else {
                    Q qI2 = i(arrayList);
                    if (S.k(qI2) || qI2 == S.f31792f || qI2 == S.f31794h || S.j(qI2) || S.i(qI2)) {
                        arrayList.add(r(qI2));
                    } else {
                        if (this.f31859d == ConfigSyntax.JSON || qI2 != S.f31795i) {
                            throw l("List should have had new element after a comma, instead had token: " + qI2 + " (if you want the comma or " + qI2 + " to be part of a string value, then double-quote it)");
                        }
                        t(qI2);
                    }
                }
            }
            Q qI3 = i(arrayList);
            if (qI3 == S.f31795i) {
                arrayList.add(new u(qI3));
                return new C3905k(arrayList);
            }
            throw l("List should have ended with ] or had a comma, instead had token: " + qI3 + " (if you want " + qI3 + " to be part of a string value, then double-quote it)");
        }

        public final ConfigException l(String str) {
            return m(str, null);
        }

        public final ConfigException m(String str, Throwable th) {
            return new ConfigException.Parse(this.f31860e.b(this.f31856a), str, th);
        }

        public final C3910p n(ArrayList<AbstractC3895a> arrayList) {
            Q qI = i(arrayList);
            if (!S.j(qI)) {
                t(qI);
                return o(arrayList, false);
            }
            String strD = S.d(qI);
            if (!strD.startsWith("required(")) {
                t(qI);
                return o(arrayList, false);
            }
            String strReplaceFirst = strD.replaceFirst("required\\(", "");
            if (strReplaceFirst.length() > 0) {
                t(S.x(qI.d(), strReplaceFirst));
            }
            arrayList.add(new u(qI));
            C3910p c3910pO = o(arrayList, true);
            Q qI2 = i(arrayList);
            if (S.j(qI2) && S.d(qI2).equals(")")) {
                return c3910pO;
            }
            throw l("expecting a close parentheses ')' here, not: " + qI2);
        }

        public final C3910p o(ArrayList<AbstractC3895a> arrayList, boolean z10) {
            ConfigIncludeKind configIncludeKind;
            Q qI = i(arrayList);
            if (!S.j(qI)) {
                if (S.l(qI, ConfigValueType.STRING)) {
                    arrayList.add(new C3913t(qI));
                    return new C3910p(arrayList, ConfigIncludeKind.HEURISTIC, z10);
                }
                throw l("include keyword is not followed by a quoted string, but by: " + qI);
            }
            String strD = S.d(qI);
            String str = "url(";
            if (strD.startsWith("url(")) {
                configIncludeKind = ConfigIncludeKind.URL;
            } else {
                str = "file(";
                if (strD.startsWith("file(")) {
                    configIncludeKind = ConfigIncludeKind.FILE;
                } else {
                    str = "classpath(";
                    if (!strD.startsWith("classpath(")) {
                        throw l("expecting include parameter to be quoted filename, file(), classpath(), or url(). No spaces are allowed before the open paren. Not expecting: " + qI);
                    }
                    configIncludeKind = ConfigIncludeKind.CLASSPATH;
                }
            }
            String strReplaceFirst = strD.replaceFirst("[^(]*\\(", "");
            if (strReplaceFirst.length() > 0) {
                t(S.x(qI.d(), strReplaceFirst));
            }
            arrayList.add(new u(qI));
            Q qI2 = i(arrayList);
            if (!S.l(qI2, ConfigValueType.STRING)) {
                throw l("expecting include " + str + ") parameter to be a quoted string, rather than: " + qI2);
            }
            arrayList.add(new C3913t(qI2));
            Q qI3 = i(arrayList);
            if (S.j(qI3) && S.d(qI3).startsWith(")")) {
                String strSubstring = S.d(qI3).substring(1);
                if (strSubstring.length() > 0) {
                    t(S.x(qI3.d(), strSubstring));
                }
                return new C3910p(arrayList, configIncludeKind, z10);
            }
            throw l("expecting a close parentheses ')' here, not: " + qI3);
        }

        public final r p(Q q10) {
            if (this.f31859d == ConfigSyntax.JSON) {
                if (S.l(q10, ConfigValueType.STRING)) {
                    return F.h(Collections.singletonList(q10).iterator(), this.f31860e.b(this.f31856a));
                }
                throw l("Expecting close brace } or a field name here, got " + q10);
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                if (!S.k(q10) && !S.j(q10)) {
                    break;
                }
                arrayList.add(q10);
                q10 = h();
            }
            if (!arrayList.isEmpty()) {
                t(q10);
                return F.h(arrayList.iterator(), this.f31860e.b(this.f31856a));
            }
            throw l("expecting a close parentheses ')' here, not: " + q10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:71:0x015b, code lost:
        
            return new com.typesafe.config.impl.C3911q(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.typesafe.config.impl.AbstractC3907m q(boolean r14) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.typesafe.config.impl.C3902h.a.q(boolean):com.typesafe.config.impl.m");
        }

        public final AbstractC3896b r(Q q10) {
            AbstractC3896b c3913t;
            int i10 = this.f31861f;
            if (S.k(q10) || S.j(q10) || S.i(q10)) {
                c3913t = new C3913t(q10);
            } else if (q10 == S.f31792f) {
                c3913t = q(true);
            } else {
                if (q10 != S.f31794h) {
                    throw l(b(q10.toString(), "Expecting a value but got wrong token: " + q10));
                }
                c3913t = k();
            }
            if (this.f31861f == i10) {
                return c3913t;
            }
            throw new ConfigException.BugOrBroken("Bug in config parser: unbalanced equals count");
        }

        public final Q s() {
            return this.f31857b.isEmpty() ? this.f31858c.next() : this.f31857b.pop();
        }

        public final void t(Q q10) {
            this.f31857b.push(q10);
        }
    }

    public static C3912s a(Iterator<Q> it, b8.k kVar, b8.l lVar) {
        return new a(lVar.g() == null ? ConfigSyntax.CONF : lVar.g(), kVar, it).j();
    }
}
