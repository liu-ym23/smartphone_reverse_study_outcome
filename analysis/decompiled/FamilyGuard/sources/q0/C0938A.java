package q0;

import java.text.SimpleDateFormat;
import java.util.Date;
import l0.AbstractC0822a;
import m0.InterfaceC0854b;
import m0.InterfaceC0856d;
import u0.C1154d;

/* renamed from: q0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0938A implements Comparable<C0938A> {

    /* renamed from: a, reason: collision with root package name */
    public final C1154d f19651a;

    /* renamed from: b, reason: collision with root package name */
    protected final boolean f19652b;

    /* renamed from: c, reason: collision with root package name */
    protected int f19653c;

    /* renamed from: d, reason: collision with root package name */
    private final String f19654d;

    /* renamed from: e, reason: collision with root package name */
    private String f19655e;

    /* renamed from: f, reason: collision with root package name */
    private String f19656f;

    /* renamed from: g, reason: collision with root package name */
    protected C0963j f19657g;

    /* renamed from: h, reason: collision with root package name */
    private String f19658h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f19659i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f19660j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f19661k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f19662l = false;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f19663m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f19664n;

    /* renamed from: o, reason: collision with root package name */
    private a f19665o;

    /* renamed from: q0.A$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final U f19666a;

        /* renamed from: b, reason: collision with root package name */
        final Class<?> f19667b;

        public a(U u5, Class<?> cls) {
            this.f19666a = u5;
            this.f19667b = cls;
        }
    }

    public C0938A(Class<?> cls, C1154d c1154d) {
        boolean z5;
        InterfaceC0856d interfaceC0856d;
        this.f19659i = false;
        this.f19660j = false;
        this.f19661k = false;
        this.f19663m = false;
        this.f19651a = c1154d;
        this.f19657g = new C0963j(cls, c1154d);
        if (cls != null && (interfaceC0856d = (InterfaceC0856d) u0.o.M(cls, InterfaceC0856d.class)) != null) {
            for (f0 f0Var : interfaceC0856d.serialzeFeatures()) {
                if (f0Var == f0.WriteEnumUsingToString) {
                    this.f19659i = true;
                } else if (f0Var == f0.WriteEnumUsingName) {
                    this.f19660j = true;
                } else if (f0Var == f0.DisableCircularReferenceDetect) {
                    this.f19661k = true;
                } else {
                    f0 f0Var2 = f0.BrowserCompatible;
                    if (f0Var == f0Var2) {
                        this.f19653c |= f0Var2.f19849a;
                        this.f19664n = true;
                    } else {
                        f0 f0Var3 = f0.WriteMapNullValue;
                        if (f0Var == f0Var3) {
                            this.f19653c |= f0Var3.f19849a;
                        }
                    }
                }
            }
        }
        c1154d.r();
        this.f19654d = '\"' + c1154d.f22730a + "\":";
        InterfaceC0854b interfaceC0854bG = c1154d.g();
        if (interfaceC0854bG != null) {
            f0[] f0VarArrSerialzeFeatures = interfaceC0854bG.serialzeFeatures();
            int length = f0VarArrSerialzeFeatures.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z5 = false;
                    break;
                } else {
                    if ((f0VarArrSerialzeFeatures[i5].b() & f0.f19822G) != 0) {
                        z5 = true;
                        break;
                    }
                    i5++;
                }
            }
            String str = interfaceC0854bG.format();
            this.f19658h = str;
            if (str.trim().length() == 0) {
                this.f19658h = null;
            }
            for (f0 f0Var4 : interfaceC0854bG.serialzeFeatures()) {
                if (f0Var4 == f0.WriteEnumUsingToString) {
                    this.f19659i = true;
                } else if (f0Var4 == f0.WriteEnumUsingName) {
                    this.f19660j = true;
                } else if (f0Var4 == f0.DisableCircularReferenceDetect) {
                    this.f19661k = true;
                } else if (f0Var4 == f0.BrowserCompatible) {
                    this.f19664n = true;
                }
            }
            this.f19653c = f0.g(interfaceC0854bG.serialzeFeatures()) | this.f19653c;
        } else {
            z5 = false;
        }
        this.f19652b = z5;
        this.f19663m = u0.o.m0(c1154d.f22731b) || u0.o.l0(c1154d.f22731b);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0938A c0938a) {
        return this.f19651a.compareTo(c0938a.f19651a);
    }

    public Object d(Object obj) {
        Class<?> cls;
        Object objE = this.f19651a.e(obj);
        if (this.f19658h == null || objE == null || !((cls = this.f19651a.f22734e) == Date.class || cls == java.sql.Date.class)) {
            return objE;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f19658h, AbstractC0822a.f18017b);
        simpleDateFormat.setTimeZone(AbstractC0822a.f18016a);
        return simpleDateFormat.format(objE);
    }

    public Object e(Object obj) {
        Object objE = this.f19651a.e(obj);
        if (!this.f19663m || u0.o.p0(objE)) {
            return objE;
        }
        return null;
    }

    public void g(C0946I c0946i) {
        e0 e0Var = c0946i.f19676k;
        if (!e0Var.f19801f) {
            if (this.f19656f == null) {
                this.f19656f = this.f19651a.f22730a + ":";
            }
            e0Var.write(this.f19656f);
            return;
        }
        if (!f0.d(e0Var.f19798c, this.f19651a.f22738i, f0.UseSingleQuotes)) {
            e0Var.write(this.f19654d);
            return;
        }
        if (this.f19655e == null) {
            this.f19655e = '\'' + this.f19651a.f22730a + "':";
        }
        e0Var.write(this.f19655e);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(q0.C0946I r14, java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.C0938A.h(q0.I, java.lang.Object):void");
    }
}
