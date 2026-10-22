package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: DateDeserializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f12423a = null;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.b.j$1, reason: invalid class name */
    /* JADX INFO: compiled from: DateDeserializers.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12424a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.b.values().length];
            f12424a = r0;
            r0[com.fasterxml.jackson.databind.a.b.f12188d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12424a[com.fasterxml.jackson.databind.a.b.f12187c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12424a[com.fasterxml.jackson.databind.a.b.f12186b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: DateDeserializers.java */
    @JacksonStdImpl
    public static class a extends b<Calendar> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Constructor<Calendar> f12425a;

        @Override // com.fasterxml.jackson.databind.b.b.j.b, com.fasterxml.jackson.databind.b.i
        public /* synthetic */ com.fasterxml.jackson.databind.l a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
            return super.a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.j.b
        public /* synthetic */ b<Calendar> b(DateFormat r1, String r2) {
            return a(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.j.b, com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ com.fasterxml.jackson.databind.k.f b() {
            return super.b();
        }

        public a() {
            super(Calendar.class);
            this.f12425a = null;
        }

        public a(Class<? extends Calendar> r2) {
            super(r2);
            this.f12425a = com.fasterxml.jackson.databind.l.h.c(r2, false);
        }

        public a(a r1, DateFormat r2, String r3) {
            super(r1, r2, r3);
            this.f12425a = r1.f12425a;
        }

        public a a(DateFormat r2, String r3) {
            return new a(this, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r3) {
            GregorianCalendar r2 = new GregorianCalendar();
            r2.setTimeInMillis(0);
            return r2;
        }

        public Calendar b(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
            Date r7 = a_(r5, r6);
            if (r7 != null) goto L6;
            return null;
        L6:
            Constructor<Calendar> r1 = this.f12425a;
            if (r1 != null) goto L18;
            return r6.a(r7);
        L18:
            Calendar r2 = (Calendar) ZeusTransformUtils.preCheckCast(r1.newInstance(new Object[0]), Calendar.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
            r2.setTimeInMillis(r7.getTime());     // Catch: Exception -> L15
            TimeZone r3 = r6.h();     // Catch: Exception -> L15
            if (r3 == null) goto L14;
            r2.setTimeZone(r3);     // Catch: Exception -> L15
        L14:
            return r2;
        L15:
            e = move-exception;
            return (Calendar) ZeusTransformUtils.preCheckCast(r6.a(a(), r7, e), Calendar.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DateDeserializers.java */
    protected static abstract class b<T> extends ae<T> implements com.fasterxml.jackson.databind.b.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final DateFormat f12426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final String f12427c;

        public abstract b<T> b(DateFormat r1, String r2);

        public b(Class<?> r1) {
            super(r1);
            this.f12426b = null;
            this.f12427c = null;
        }

        public b(b<T> r1, DateFormat r2, String r3) {
            super(r1.B);
            this.f12426b = r2;
            this.f12427c = r3;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.l;
        }

        public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.d r8) {
            JsonFormat.Value r9 = a(r7, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
            if (r9 == null) goto L44;
            TimeZone r0 = r9.getTimeZone();
            Boolean r2 = r9.getLenient();
            if (r9.hasPattern() == false) goto L18;
            String r1 = r9.getPattern();
            if (r9.hasLocale() == false) goto L9;
            Locale r10 = r9.getLocale();
        L10:
            SimpleDateFormat r3 = new SimpleDateFormat(r1, r10);
            if (r0 != null) goto L13;
            r0 = r7.h();
        L13:
            r3.setTimeZone(r0);
            if (r2 == null) goto L17;
            r3.setLenient(r2.booleanValue());
        L17:
            return b(r3, r1);
        L9:
            r10 = r7.g();
            goto L10
        L18:
            if (r0 == null) goto L33;
            DateFormat r4 = r7.c().r();
            if (r4.getClass() == com.fasterxml.jackson.databind.l.x.class) goto L22;
            DateFormat r11 = (DateFormat) ZeusTransformUtils.preCheckCast(r4.clone(), DateFormat.class, "com.obric.aiagent.plugin");
            r11.setTimeZone(r0);
            DateFormat r12 = r11;
            if (r2 == null) goto L32;
            r11.setLenient(r2.booleanValue());
            r12 = r11;
        L32:
            return b(r12, this.f12427c);
        L22:
            if (r9.hasLocale() == false) goto L24;
            Locale r13 = r9.getLocale();
        L25:
            com.fasterxml.jackson.databind.l.x r14 = ((com.fasterxml.jackson.databind.l.x) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.l.x.class, "com.obric.aiagent.plugin")).a(r0).a(r13);
            r12 = r14;
            if (r2 == null) goto L32;
            r12 = r14.a(r2);
            goto L32
        L24:
            r13 = r7.g();
            goto L25
        L33:
            if (r2 == null) goto L45;
            DateFormat r15 = r7.c().r();
            String r16 = this.f12427c;
            if (r15.getClass() != com.fasterxml.jackson.databind.l.x.class) goto L37;
            com.fasterxml.jackson.databind.l.x r17 = ((com.fasterxml.jackson.databind.l.x) ZeusTransformUtils.preCheckCast(r15, com.fasterxml.jackson.databind.l.x.class, "com.obric.aiagent.plugin")).a(r2);
            r16 = r17.b();
            DateFormat r18 = r17;
        L40:
            if (r16 != null) goto L43;
            r16 = "[unknown]";
        L43:
            return b(r18, r16);
        L37:
            DateFormat r19 = (DateFormat) ZeusTransformUtils.preCheckCast(r15.clone(), DateFormat.class, "com.obric.aiagent.plugin");
            r19.setLenient(r2.booleanValue());
            boolean r5 = ZeusTransformUtils.instanceOf(r19, SimpleDateFormat.class);
            r18 = r19;
            if (r5 == false) goto L40;
            ((SimpleDateFormat) ZeusTransformUtils.preCheckCast(r19, SimpleDateFormat.class, "com.obric.aiagent.plugin")).toPattern();
            r18 = r19;
            goto L40
        L45:
            return this;
        L44:
            return this;
        }

        @Override // com.fasterxml.jackson.databind.b.b.ab
        public Date a_(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
            if (this.f12426b == null) goto L27;
            if (r6.a(com.fasterxml.jackson.a.n.h) == false) goto L27;
            String r8 = r6.x().trim();
            if (r8.isEmpty() == true) goto L9;
            DateFormat r0 = this.f12426b;
            monitor-enter(r0);
            Date r5 = this.f12426b.parse(r8);     // Catch: Throwable -> L19 ParseException -> L21
            monitor-exit(r0);     // Catch: Throwable -> L19
            return r5;
        L19:
            th = move-exception;
            throw th;
        L23:
            return (Date) ZeusTransformUtils.preCheckCast(r7.b(a(), r8, "expected format \"%s\"", new Object[]{this.f12427c}), Date.class, "com.obric.aiagent.plugin");
        L9:
            if (AnonymousClass1.f12424a[g(r7, r8).ordinal()] == 1) goto L13;
            return null;
        L13:
            return new Date(0);
        L27:
            return super.a_(r6, r7);
        }
    }

    /* JADX INFO: compiled from: DateDeserializers.java */
    @JacksonStdImpl
    public static class c extends b<Date> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12428a = null;

        @Override // com.fasterxml.jackson.databind.b.b.j.b, com.fasterxml.jackson.databind.b.i
        public /* synthetic */ com.fasterxml.jackson.databind.l a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
            return super.a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return b(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.j.b
        public /* synthetic */ b<Date> b(DateFormat r1, String r2) {
            return a(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.j.b, com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
        public /* bridge */ /* synthetic */ com.fasterxml.jackson.databind.k.f b() {
            return super.b();
        }

        static {
            f12428a = new c();
        }

        public c() {
            super(Date.class);
        }

        public c(c r1, DateFormat r2, String r3) {
            super(r1, r2, r3);
        }

        public c a(DateFormat r2, String r3) {
            return new c(this, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object c(com.fasterxml.jackson.databind.h r3) {
            return new Date(0);
        }

        public Date b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return a_(r1, r2);
        }
    }

    static {
        HashSet<String> r0 = new HashSet();
        f12423a = r0;
        r0.add("java.util.Calendar");
        r0.add("java.util.GregorianCalendar");
        r0.add("java.util.Date");
    }

    public static com.fasterxml.jackson.databind.l<?> a(Class<?> r1, String r2) {
        if (f12423a.contains(r2) == true) goto L5;
        return null;
    L5:
        if (r1 != Calendar.class) goto L9;
        return new a();
    L9:
        if (r1 != Date.class) goto L13;
        return c.f12428a;
    L13:
        if (r1 == GregorianCalendar.class) goto L15;
        return null;
    L15:
        return new a(GregorianCalendar.class);
    }
}
