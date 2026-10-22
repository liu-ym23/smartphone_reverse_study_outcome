package com.typesafe.config.impl;

import b8.InterfaceC1456b;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class v {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31894a;

        static {
            int[] iArr = new int[ConfigIncludeKind.values().length];
            f31894a = iArr;
            try {
                iArr[ConfigIncludeKind.URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31894a[ConfigIncludeKind.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31894a[ConfigIncludeKind.CLASSPATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31894a[ConfigIncludeKind.HEURISTIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public final C3912s f31896b;

        /* renamed from: c, reason: collision with root package name */
        public final z f31897c;

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC1456b f31898d;

        /* renamed from: e, reason: collision with root package name */
        public final ConfigSyntax f31899e;

        /* renamed from: f, reason: collision with root package name */
        public final b8.k f31900f;

        /* renamed from: a, reason: collision with root package name */
        public int f31895a = 1;

        /* renamed from: g, reason: collision with root package name */
        public final LinkedList<D> f31901g = new LinkedList<>();

        /* renamed from: h, reason: collision with root package name */
        public int f31902h = 0;

        public b(ConfigSyntax configSyntax, b8.k kVar, C3912s c3912s, z zVar, InterfaceC1456b interfaceC1456b) {
            this.f31896b = c3912s;
            this.f31899e = configSyntax;
            this.f31900f = kVar;
            this.f31897c = zVar;
            this.f31898d = interfaceC1456b;
        }

        public static AbstractC3897c a(D d10, AbstractConfigValue abstractConfigValue) {
            ArrayList arrayList = new ArrayList();
            String strB = d10.b();
            D dJ = d10.j();
            while (strB != null) {
                arrayList.add(strB);
                if (dJ == null) {
                    break;
                }
                strB = dJ.b();
                dJ = dJ.j();
            }
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            SimpleConfigObject simpleConfigObject = new SimpleConfigObject(abstractConfigValue.e().y(null), Collections.singletonMap((String) listIterator.previous(), abstractConfigValue));
            while (listIterator.hasPrevious()) {
                simpleConfigObject = new SimpleConfigObject(abstractConfigValue.e().y(null), Collections.singletonMap(listIterator.previous(), simpleConfigObject));
            }
            return simpleConfigObject;
        }

        public final D b() {
            if (this.f31901g.isEmpty()) {
                throw new ConfigException.BugOrBroken("Bug in parser; tried to get current path when at root");
            }
            return new D(this.f31901g.descendingIterator());
        }

        public final M c() {
            return ((M) this.f31900f).b(this.f31895a);
        }

        public AbstractConfigValue d() {
            ArrayList arrayList = new ArrayList();
            AbstractConfigValue abstractConfigValueK = null;
            while (true) {
                boolean z10 = false;
                for (AbstractC3895a abstractC3895a : this.f31896b.c()) {
                    if (abstractC3895a instanceof C3906l) {
                        arrayList.add(((C3906l) abstractC3895a).d());
                    } else if (abstractC3895a instanceof u) {
                        if (S.h(((u) abstractC3895a).c())) {
                            this.f31895a++;
                            if (z10 && abstractConfigValueK == null) {
                                arrayList.clear();
                            } else if (abstractConfigValueK != null) {
                                AbstractConfigValue abstractConfigValueP0 = abstractConfigValueK.p0(abstractConfigValueK.e().c(new ArrayList<>(arrayList)));
                                arrayList.clear();
                                return abstractConfigValueP0;
                            }
                            z10 = true;
                        } else {
                            continue;
                        }
                    } else if (abstractC3895a instanceof AbstractC3907m) {
                        abstractConfigValueK = k((AbstractC3907m) abstractC3895a, arrayList);
                    }
                }
                return abstractConfigValueK;
            }
        }

        public final SimpleConfigList e(C3905k c3905k) {
            this.f31902h++;
            M mC = c();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z10 = false;
            AbstractConfigValue abstractConfigValueK = null;
            for (AbstractC3895a abstractC3895a : c3905k.c()) {
                if (abstractC3895a instanceof C3906l) {
                    arrayList2.add(((C3906l) abstractC3895a).d());
                } else if ((abstractC3895a instanceof u) && S.h(((u) abstractC3895a).c())) {
                    this.f31895a++;
                    if (z10 && abstractConfigValueK == null) {
                        arrayList2.clear();
                    } else if (abstractConfigValueK != null) {
                        arrayList.add(abstractConfigValueK.p0(abstractConfigValueK.e().c(new ArrayList(arrayList2))));
                        arrayList2.clear();
                        abstractConfigValueK = null;
                    }
                    z10 = true;
                } else if (abstractC3895a instanceof AbstractC3896b) {
                    if (abstractConfigValueK != null) {
                        arrayList.add(abstractConfigValueK.p0(abstractConfigValueK.e().c(new ArrayList(arrayList2))));
                        arrayList2.clear();
                    }
                    abstractConfigValueK = k((AbstractC3896b) abstractC3895a, arrayList2);
                }
                z10 = false;
            }
            if (abstractConfigValueK != null) {
                arrayList.add(abstractConfigValueK.p0(abstractConfigValueK.e().c(new ArrayList(arrayList2))));
            }
            this.f31902h--;
            return new SimpleConfigList(mC, arrayList);
        }

        public final AbstractConfigValue f(C3908n c3908n) {
            if (this.f31899e == ConfigSyntax.JSON) {
                throw new ConfigException.BugOrBroken("Found a concatenation node in JSON");
            }
            ArrayList arrayList = new ArrayList(c3908n.c().size());
            for (AbstractC3895a abstractC3895a : c3908n.c()) {
                if (abstractC3895a instanceof AbstractC3896b) {
                    arrayList.add(k((AbstractC3896b) abstractC3895a, null));
                }
            }
            return C3899e.q0(arrayList);
        }

        public final ConfigException g(String str) {
            return h(str, null);
        }

        public final ConfigException h(String str, Throwable th) {
            return new ConfigException.Parse(c(), str, th);
        }

        public final void i(Map<String, AbstractConfigValue> map, C3910p c3910p) {
            AbstractC3897c abstractC3897cE0;
            boolean zC = c3910p.c();
            InterfaceC1456b interfaceC1456b = this.f31898d;
            InterfaceC1456b interfaceC1456bC = interfaceC1456b.c(interfaceC1456b.b().h(!zC));
            int i10 = a.f31894a[c3910p.d().ordinal()];
            if (i10 == 1) {
                try {
                    abstractC3897cE0 = (AbstractC3897c) this.f31897c.b(interfaceC1456bC, new URL(c3910p.e()));
                } catch (MalformedURLException e10) {
                    throw h("include url() specifies an invalid URL: " + c3910p.e(), e10);
                }
            } else if (i10 == 2) {
                abstractC3897cE0 = (AbstractC3897c) this.f31897c.a(interfaceC1456bC, new File(c3910p.e()));
            } else if (i10 == 3) {
                abstractC3897cE0 = (AbstractC3897c) this.f31897c.d(interfaceC1456bC, c3910p.e());
            } else {
                if (i10 != 4) {
                    throw new ConfigException.BugOrBroken("should not be reached");
                }
                abstractC3897cE0 = (AbstractC3897c) this.f31897c.c(interfaceC1456bC, c3910p.e());
            }
            if (this.f31902h > 0 && abstractC3897cE0.j0() != ResolveStatus.RESOLVED) {
                throw g("Due to current limitations of the config parser, when an include statement is nested inside a list value, ${} substitutions inside the included file cannot be resolved correctly. Either move the include outside of the list value or remove the ${} statements from the included file.");
            }
            if (!this.f31901g.isEmpty()) {
                abstractC3897cE0 = abstractC3897cE0.e0(b());
            }
            for (String str : abstractC3897cE0.keySet()) {
                AbstractConfigValue abstractConfigValue = abstractC3897cE0.get(str);
                AbstractConfigValue abstractConfigValue2 = map.get(str);
                if (abstractConfigValue2 != null) {
                    map.put(str, abstractConfigValue.n0(abstractConfigValue2));
                } else {
                    map.put(str, abstractConfigValue);
                }
            }
        }

        public final AbstractC3897c j(C3911q c3911q) {
            Map<String, AbstractConfigValue> map = new HashMap<>();
            M mC = c();
            ArrayList arrayList = new ArrayList(c3911q.c());
            List<String> arrayList2 = new ArrayList<>();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < arrayList.size()) {
                AbstractC3895a abstractC3895a = (AbstractC3895a) arrayList.get(i10);
                if (abstractC3895a instanceof C3906l) {
                    arrayList2.add(((C3906l) abstractC3895a).d());
                } else {
                    if ((abstractC3895a instanceof u) && S.h(((u) abstractC3895a).c())) {
                        this.f31895a++;
                        if (z10) {
                            arrayList2.clear();
                        }
                        z10 = true;
                    } else if (this.f31899e != ConfigSyntax.JSON && (abstractC3895a instanceof C3910p)) {
                        i(map, (C3910p) abstractC3895a);
                    } else if (abstractC3895a instanceof C3909o) {
                        C3909o c3909o = (C3909o) abstractC3895a;
                        D dC = c3909o.d().c();
                        arrayList2.addAll(c3909o.c());
                        this.f31901g.push(dC);
                        Q qE = c3909o.e();
                        Q q10 = S.f31796j;
                        if (qE == q10) {
                            int i11 = this.f31902h;
                            if (i11 > 0) {
                                throw g("Due to current limitations of the config parser, += does not work nested inside a list. += expands to a ${} substitution and the path in ${} cannot currently refer to list elements. You might be able to move the += outside of the list and then refer to it from inside the list with ${}.");
                            }
                            this.f31902h = i11 + 1;
                        }
                        AbstractConfigValue abstractConfigValueK = k(c3909o.f(), arrayList2);
                        if (c3909o.e() == q10) {
                            this.f31902h--;
                            ArrayList arrayList3 = new ArrayList(2);
                            w wVar = new w(abstractConfigValueK.e(), new P(b(), true));
                            SimpleConfigList simpleConfigList = new SimpleConfigList(abstractConfigValueK.e(), Collections.singletonList(abstractConfigValueK));
                            arrayList3.add(wVar);
                            arrayList3.add(simpleConfigList);
                            abstractConfigValueK = C3899e.q0(arrayList3);
                        }
                        if (i10 < arrayList.size() - 1) {
                            while (true) {
                                i10++;
                                if (i10 < arrayList.size()) {
                                    if (!(arrayList.get(i10) instanceof C3906l)) {
                                        if (!(arrayList.get(i10) instanceof u)) {
                                            break;
                                        }
                                        u uVar = (u) arrayList.get(i10);
                                        if (uVar.c() != S.f31789c && !S.g(uVar.c())) {
                                            break;
                                        }
                                    } else {
                                        abstractConfigValueK = abstractConfigValueK.p0(abstractConfigValueK.e().c(Collections.singletonList(((C3906l) arrayList.get(i10)).d())));
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i10--;
                        }
                        this.f31901g.pop();
                        String strB = dC.b();
                        D dJ = dC.j();
                        if (dJ == null) {
                            AbstractConfigValue abstractConfigValue = map.get(strB);
                            if (abstractConfigValue != null) {
                                if (this.f31899e == ConfigSyntax.JSON) {
                                    throw g("JSON does not allow duplicate fields: '" + strB + "' was already seen at " + abstractConfigValue.e().description());
                                }
                                abstractConfigValueK = abstractConfigValueK.n0(abstractConfigValue);
                            }
                            map.put(strB, abstractConfigValueK);
                        } else {
                            if (this.f31899e == ConfigSyntax.JSON) {
                                throw new ConfigException.BugOrBroken("somehow got multi-element path in JSON mode");
                            }
                            AbstractConfigValue abstractConfigValueA = a(dJ, abstractConfigValueK);
                            AbstractConfigValue abstractConfigValue2 = map.get(strB);
                            if (abstractConfigValue2 != null) {
                                abstractConfigValueA = abstractConfigValueA.n0(abstractConfigValue2);
                            }
                            map.put(strB, abstractConfigValueA);
                        }
                    } else {
                        continue;
                    }
                    i10++;
                }
                z10 = false;
                i10++;
            }
            return new SimpleConfigObject(mC, map);
        }

        public final AbstractConfigValue k(AbstractC3896b abstractC3896b, List<String> list) {
            AbstractConfigValue abstractConfigValueF;
            int i10 = this.f31902h;
            if (abstractC3896b instanceof C3913t) {
                abstractConfigValueF = ((C3913t) abstractC3896b).d();
            } else if (abstractC3896b instanceof C3911q) {
                abstractConfigValueF = j((C3911q) abstractC3896b);
            } else if (abstractC3896b instanceof C3905k) {
                abstractConfigValueF = e((C3905k) abstractC3896b);
            } else {
                if (!(abstractC3896b instanceof C3908n)) {
                    throw g("Expecting a value but got wrong node type: " + abstractC3896b.getClass());
                }
                abstractConfigValueF = f((C3908n) abstractC3896b);
            }
            if (list != null && !list.isEmpty()) {
                abstractConfigValueF = abstractConfigValueF.p0(abstractConfigValueF.e().u(new ArrayList(list)));
                list.clear();
            }
            if (this.f31902h == i10) {
                return abstractConfigValueF;
            }
            throw new ConfigException.BugOrBroken("Bug in config parser: unbalanced array count");
        }
    }

    public static AbstractConfigValue a(C3912s c3912s, b8.k kVar, b8.l lVar, InterfaceC1456b interfaceC1456b) {
        return new b(lVar.g(), kVar, c3912s, O.l(lVar.e()), interfaceC1456b).d();
    }
}
