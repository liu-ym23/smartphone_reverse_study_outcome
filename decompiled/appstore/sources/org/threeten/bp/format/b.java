package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Locale f23183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f23184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.threeten.bp.chrono.e f23185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ZoneId f23186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f23189g;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: org.threeten.bp.format.b$b, reason: collision with other inner class name */
    public final class C0333b extends ig.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.threeten.bp.chrono.e f23190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZoneId f23191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map f23192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f23193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Period f23194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f23195f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f23196g;

        public /* synthetic */ C0333b(b r10, a r11) {
            this(r10);
        }

        public C0333b a() {
            C0333b r10 = new C0333b(this.f23196g);
            r10.f23190a = this.f23190a;
            r10.f23191b = this.f23191b;
            r10.f23192c.putAll(this.f23192c);
            r10.f23193d = this.f23193d;
            return r10;
        }

        public org.threeten.bp.format.a b() {
            org.threeten.bp.format.a r10 = new org.threeten.bp.format.a();
            r10.f23176a.putAll(this.f23192c);
            r10.f23177b = this.f23196g.h();
            ZoneId r11 = this.f23191b;
            if (r11 == null) goto L5;
            r10.f23178c = r11;
        L6:
            r10.f23181f = this.f23193d;
            r10.f23182g = this.f23194e;
            return r10;
        L5:
            r10.f23178c = b.a(this.f23196g);
            goto L6
        }

        @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
        public int get(TemporalField r10) {
            if (this.f23192c.containsKey(r10) == false) goto L7;
            return ig.d.p(((Long) this.f23192c.get(r10)).longValue());
        L7:
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField r10) {
            if (this.f23192c.containsKey(r10) == false) goto L7;
            return ((Long) this.f23192c.get(r10)).longValue();
        L7:
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField r10) {
            return this.f23192c.containsKey(r10);
        }

        @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
        public Object query(TemporalQuery r10) {
            if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
            return this.f23190a;
        L7:
            if (r10 == org.threeten.bp.temporal.b.g()) goto L14;
            if (r10 == org.threeten.bp.temporal.b.f()) goto L14;
            return super.query(r10);
        L14:
            return this.f23191b;
        }

        public String toString() {
            return this.f23192c.toString() + "," + this.f23190a + "," + this.f23191b;
        }

        public C0333b(b r10) {
            this.f23196g = r10;
            this.f23190a = null;
            this.f23191b = null;
            this.f23192c = new HashMap();
            this.f23194e = Period.ZERO;
        }
    }

    public b(DateTimeFormatter r10) {
        this.f23187e = true;
        this.f23188f = true;
        ArrayList r11 = new ArrayList();
        this.f23189g = r11;
        this.f23183a = r10.h();
        this.f23184b = r10.g();
        this.f23185c = r10.f();
        this.f23186d = r10.k();
        r11.add(new C0333b(this, null));
    }

    public static /* synthetic */ ZoneId a(b r10) {
        return r10.f23186d;
    }

    public static boolean d(char r10, char r11) {
        if (r10 != r11) goto L4;
    L9:
        return true;
    L4:
        if (Character.toUpperCase(r10) == Character.toUpperCase(r11)) goto L9;
        if (Character.toLowerCase(r10) == Character.toLowerCase(r11)) goto L9;
        return false;
    }

    public void b(DateTimeFormatterBuilder.n r10, long r11, int r12, int r13) {
        C0333b r14 = f();
        if (r14.f23195f != null) goto L5;
        r14.f23195f = new ArrayList(2);
    L5:
        r14.f23195f.add(new Object[]{r10, Long.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});
    }

    public boolean c(char r10, char r11) {
        if (l() == false) goto L9;
        if (r10 != r11) goto L6;
        return true;
    L6:
        return false;
    L9:
        return d(r10, r11);
    }

    public b e() {
        return new b(this);
    }

    public final C0333b f() {
        ArrayList r10 = this.f23189g;
        return (C0333b) r10.get(r10.size() - 1);
    }

    public void g(boolean r10) {
        if (r10 == false) goto L4;
        ArrayList r11 = this.f23189g;
        r11.remove(r11.size() - 2);
        return;
    L4:
        ArrayList r12 = this.f23189g;
        r12.remove(r12.size() - 1);
    }

    public org.threeten.bp.chrono.e h() {
        org.threeten.bp.chrono.e r10 = f().f23190a;
        if (r10 != null) goto L8;
        org.threeten.bp.chrono.e r11 = this.f23185c;
        if (r11 == null) goto L7;
        return r11;
    L7:
        return IsoChronology.INSTANCE;
    L8:
        return r10;
    }

    public Locale i() {
        return this.f23183a;
    }

    public Long j(TemporalField r10) {
        return (Long) f().f23192c.get(r10);
    }

    public e k() {
        return this.f23184b;
    }

    public boolean l() {
        return this.f23187e;
    }

    public boolean m() {
        return this.f23188f;
    }

    public void n(boolean r10) {
        this.f23187e = r10;
    }

    public void o(ZoneId r10) {
        ig.d.h(r10, "zone");
        f().f23191b = r10;
    }

    public void p(org.threeten.bp.chrono.e r10) {
        ig.d.h(r10, "chrono");
        C0333b r11 = f();
        r11.f23190a = r10;
        if (r11.f23195f == null) goto L8;
        ArrayList r12 = new ArrayList(r11.f23195f);
        r11.f23195f.clear();
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Object[] r14 = (Object[]) r13.next();
        ((DateTimeFormatterBuilder.n) r14[0]).c(this, ((Long) r14[1]).longValue(), ((Integer) r14[2]).intValue(), ((Integer) r14[3]).intValue());
        goto L6
    L10:
        return;
    }

    public int q(TemporalField r10, long r11, int r12, int r13) {
        ig.d.h(r10, "field");
        Long r14 = (Long) f().f23192c.put(r10, Long.valueOf(r11));
        if (r14 != null) goto L5;
        return r13;
    L5:
        if (r14.longValue() != r11) goto L7;
        return r13;
    L7:
        return ~r12;
    }

    public void r() {
        f().f23193d = true;
    }

    public void s(boolean r10) {
        this.f23188f = r10;
    }

    public void t() {
        this.f23189g.add(f().a());
    }

    public String toString() {
        return f().toString();
    }

    public boolean u(CharSequence r10, int r11, CharSequence r12, int r13, int r14) {
        if ((r11 + r14) <= r10.length()) goto L5;
    L27:
        return false;
    L5:
        if ((r13 + r14) > r12.length()) goto L27;
        if (l() == false) goto L15;
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L25;
        if (r10.charAt(r11 + r15) != r12.charAt(r13 + r15)) goto L13;
        r15 = r15 + 1;
        goto L10
    L13:
        return false;
    L25:
        return true;
    L15:
        int r16 = 0;
    L16:
        if (r16 >= r14) goto L35;
        char r17 = r10.charAt(r11 + r16);
        char r18 = r12.charAt(r13 + r16);
        if (r17 == r18) goto L24;
        if (Character.toUpperCase(r17) == Character.toUpperCase(r18)) goto L24;
        if (Character.toLowerCase(r17) == Character.toLowerCase(r18)) goto L24;
        return false;
    L24:
        r16 = r16 + 1;
        goto L16
    L35:
        return true;
    }

    public C0333b v() {
        return f();
    }

    public b(b r10) {
        this.f23187e = true;
        this.f23188f = true;
        ArrayList r11 = new ArrayList();
        this.f23189g = r11;
        this.f23183a = r10.f23183a;
        this.f23184b = r10.f23184b;
        this.f23185c = r10.f23185c;
        this.f23186d = r10.f23186d;
        this.f23187e = r10.f23187e;
        this.f23188f = r10.f23188f;
        r11.add(new C0333b(this, null));
    }
}
