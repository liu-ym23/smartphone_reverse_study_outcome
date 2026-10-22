package com.a.c.c;

import com.a.c.b.c.g;
import com.a.c.c.a.h;
import com.a.c.c.a.i;
import com.a.c.c.a.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: SingleExecutionTime.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LocalTime f3171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.a.c f3172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f3173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.c.b.a f3174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.c.b.a f3175e;
    private final com.a.c.b.a f;
    private final f g;
    private final f h;
    private final f i;
    private final f j;

    /* JADX INFO: renamed from: com.a.c.c.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: SingleExecutionTime.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: SingleExecutionTime.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ZonedDateTime f3176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3177b;

        /* synthetic */ a(ZonedDateTime r1, boolean r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private a(ZonedDateTime r1, boolean r2) {
            this.f3176a = r1;
            this.f3177b = r2;
        }

        public ZonedDateTime a() {
            return this.f3176a;
        }

        public boolean b() {
            return this.f3177b;
        }

        public String toString() {
            return "ExecutionTimeResult{time=" + this.f3176a + ", isMatch=" + this.f3177b + '}';
        }
    }

    public static /* synthetic */ Integer lambda$8qjhNQVUwshI0mLgd_d0ItNigaU(ZonedDateTime r0, Integer r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$Mx35eW2xasEs30iyNPCpFYTlvd0(ZonedDateTime r0, Integer r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$n8HsN8HPjsCtHipyIQvGeDEAMLA(int r0, int r1, Integer r2) {
        return a(r0, r1, r2);
    }

    static {
        f3171a = LocalTime.MAX.truncatedTo(ChronoUnit.SECONDS);
    }

    e(com.a.c.a.c r5, com.a.c.b.a r6, com.a.c.b.a r7, com.a.c.b.a r8, com.a.c.b.a r9, f r10, f r11, f r12, f r13) {
        this.f3172b = (com.a.c.a.c) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r5), com.a.c.a.c.class, "com.obric.aiagent.plugin");
        if (r5.b(com.a.c.b.b.g) == true) goto L5;
        this.f3173c = i.a(new com.a.c.b.a(com.a.c.b.b.g, com.a.c.b.c.a.d(), com.a.c.b.a.b.h().g()));
    L12:
        this.f3174d = (com.a.c.b.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r7), com.a.c.b.a.class, "com.obric.aiagent.plugin");
        this.f3175e = (com.a.c.b.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r8), com.a.c.b.a.class, "com.obric.aiagent.plugin");
        this.f = r9;
        this.g = (f) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r10), f.class, "com.obric.aiagent.plugin");
        this.h = (f) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r11), f.class, "com.obric.aiagent.plugin");
        this.i = (f) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r12), f.class, "com.obric.aiagent.plugin");
        this.j = (f) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r13), f.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r5.a(com.a.c.b.b.g).d() == true) goto L7;
        com.a.e.a.a(r6);
    L7:
        if (r6 != null) goto L9;
        h r14 = i.a(new com.a.c.b.a(com.a.c.b.b.g, com.a.c.b.c.a.d(), r5.a(com.a.c.b.b.g).c()));
    L10:
        this.f3173c = r14;
        goto L12
    L9:
        r14 = i.b(r6);
        goto L10
    }

    @Override // com.a.c.c.b
    public Optional<ZonedDateTime> a(ZonedDateTime r7) {
        com.a.e.a.a(r7);
        ZonedDateTime r0 = b(r7);     // Catch: j -> L20
        if (r0.equals(r7) == false) goto L18;
        ZonedDateTime r2 = b(r7.plusSeconds(1));     // Catch: j -> L20
        if (r2.getOffset().compareTo(r7.getOffset()) <= 0) goto L17;
        Optional r3 = Optional.empty();     // Catch: j -> L20
        r3 = Optional.of(b(r2.plusSeconds(1)));     // Catch: j -> L22
    L10:
        if (r3.isPresent() == false) goto L17;
        if (Duration.between(r2, (Temporal) ZeusTransformUtils.preCheckCast(r3.get(), Temporal.class, "com.obric.aiagent.plugin")).toHours() <= 1) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        r0 = b(r7.plusSeconds(1).plusHours(1));     // Catch: j -> L20
        goto L18
    L14:
        r4 = false;
    L17:
        r0 = r2;
    L18:
        return Optional.of(r0);
    L21:
        return Optional.empty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ZonedDateTime b(ZonedDateTime r5) {
        int r1 = 0;
        Object[] r2 = 0 == true ? 1 : 0;
        a r0 = new a(r5, r2, null);
    L4:
        if (r1 >= 100000) goto L15;
        r0 = c(r0.a());
        if (r0.b() == true) goto L8;
        if ((r0.a().getYear() - r5.getYear()) > 100) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        throw new j();
    L8:
        return r0.a();
    L15:
        throw new j();
    }

    private static /* synthetic */ boolean b(ZonedDateTime r0, Integer r1) {
        if (r1.intValue() < r0.getYear()) goto L5;
        return true;
    L5:
        return false;
    }

    private a c(final ZonedDateTime r14) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.f3173c.b(r14.getYear(), r14.getYear()).stream().filter(new $$Lambda$e$Mx35eW2xasEs30iyNPCpFYTlvd0(r14)).collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(this.g.a().get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(this.h.a().get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r10 = ((Integer) ZeusTransformUtils.preCheckCast(this.i.a().get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(this.j.a().get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (r0.isEmpty() == false) goto L7;
        return a(r14, r6, r9, r10, r11);
    L7:
        if (this.g.a().contains(Integer.valueOf(r14.getMonthValue())) == false) goto L9;
        Optional<f> r1 = a(this.f3172b, r14);
        AnonymousClass1 r4 = null;
        if (r1.isPresent() == false) goto L13;
        f r12 = (f) ZeusTransformUtils.preCheckCast(r1.get(), f.class, "com.obric.aiagent.plugin");
        if (r12.a().contains(Integer.valueOf(r14.getDayOfMonth())) == true) goto L19;
        return a(r14, r9, r10, r11, r12);
    L19:
        if (this.h.a().contains(Integer.valueOf(r14.getHour())) == true) goto L23;
        return d(r14);
    L23:
        if (this.i.a().contains(Integer.valueOf(r14.getMinute())) == true) goto L27;
        return e(r14);
    L27:
        if (this.j.a().contains(Integer.valueOf(r14.getSecond())) == true) goto L31;
        return f(r14);
    L31:
        return new a(r14, true, r4);
    L13:
        return new a(g(r14), r3, r4);
    L9:
        return a(r14, r9, r10, r11);
    }

    private a a(ZonedDateTime r7, int r8, int r9, int r10, int r11) {
        int r0 = this.f3173c.a(r7.getYear());
        Optional<f> r1 = a(this.f3172b, ZonedDateTime.of(LocalDate.of(r0, r8, 1), LocalTime.MIN, r7.getZone()));
        AnonymousClass1 r3 = null;
        boolean r4 = false;
        if (r1.isPresent() == false) goto L7;
        return new a(ZonedDateTime.of(LocalDate.of(r0, r8, ((Integer) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r1.get(), f.class, "com.obric.aiagent.plugin")).a().get(0), Integer.class, "com.obric.aiagent.plugin")).intValue()), LocalTime.of(r9, r10, r11), r7.getZone()), r4, r3);
    L7:
        return new a(g(r7), r4, r3);
    }

    private a a(ZonedDateTime r7, int r8, int r9, int r10) {
        boolean r2 = false;
        d r0 = this.g.a(r7.getMonthValue(), 0);
        int r1 = r0.a();
        AnonymousClass1 r4 = null;
        if (r0.b() > 0) goto L5;
        Optional<f> r3 = a(this.f3172b, ZonedDateTime.of(LocalDateTime.of(r7.getYear(), r1, 1, 0, 0), r7.getZone()));
        if (r3.isPresent() == false) goto L11;
        return new a(r7.truncatedTo(ChronoUnit.SECONDS).withMonth(r1).withDayOfMonth(((Integer) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r3.get(), f.class, "com.obric.aiagent.plugin")).a().get(0), Integer.class, "com.obric.aiagent.plugin")).intValue()).with(LocalTime.of(r8, r9, r10)), r2, r4);
    L11:
        return new a(g(r7), r2, r4);
    L5:
        return new a(r7.truncatedTo(ChronoUnit.DAYS).withMonth(1).withDayOfMonth(1).plusYears(r0.b()), r2, r4);
    }

    private a a(ZonedDateTime r4, int r5, int r6, int r7, f r8) {
        boolean r0 = false;
        d r3 = r8.a(r4.getDayOfMonth(), 0);
        AnonymousClass1 r1 = null;
        if (r3.b() <= 0) goto L7;
        return new a(r4.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1).plusMonths(r3.b()), r0, r1);
    L7:
        return new a(r4.truncatedTo(ChronoUnit.SECONDS).withDayOfMonth(r3.a()).with(LocalTime.of(r5, r6, r7)), r0, r1);
    }

    private a d(ZonedDateTime r2) {
        return a(r2, this.h, ChronoField.HOUR_OF_DAY);
    }

    private a e(ZonedDateTime r2) {
        return a(r2, this.i, ChronoField.MINUTE_OF_HOUR);
    }

    private a f(ZonedDateTime r2) {
        return a(r2, this.j, ChronoField.SECOND_OF_MINUTE);
    }

    private static a a(ZonedDateTime r8, f r9, TemporalField r10) {
        TemporalField r11 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r10, TemporalField.class, "com.obric.aiagent.plugin");
        HashSet r0 = new HashSet(r9.f3178a);
        TemporalUnit r12 = r11.getBaseUnit();
        long r1 = r11.range().getMaximum() - r11.range().getMinimum();
        long r3 = 0;
    L4:
        if (r3 >= (2 * r1)) goto L11;
        r8 = r8.plus(1, r12);
        if (r0.contains(Integer.valueOf(r8.get(r11))) == true) goto L8;
        r3 = r3 + 1;
        goto L4
    L8:
        return new a(r8.truncatedTo(r12), false, null);
    L11:
        throw new j();
    }

    private ZonedDateTime g(ZonedDateTime r3) {
        return r3.truncatedTo(ChronoUnit.DAYS).plusMonths(1).withDayOfMonth(1);
    }

    private Optional<f> a(com.a.c.a.c r3, ZonedDateTime r4) {
        if (a(r3) == false) goto L7;
        return h(r4);
    L7:
        if (r3.a(com.a.c.b.b.f) == null) goto L13;
        if (r3.a(com.a.c.b.b.f3107d) == null) goto L13;
        return b(r3, r4);
    L13:
        if (r3.a(com.a.c.b.b.f) != null) goto L17;
        return i(r4);
    L17:
        return Optional.of(a(r4, ((com.a.c.b.b.a) ZeusTransformUtils.preCheckCast(r3.a(com.a.c.b.b.f), com.a.c.b.b.a.class, "com.obric.aiagent.plugin")).a()));
    }

    private boolean a(com.a.c.a.c r2) {
        if (r2.b(com.a.c.b.b.h) == true) goto L7;
        return false;
    L7:
        if (r2.a(com.a.c.b.b.h).c().c().contains(com.a.c.b.d.c.f3136e) == true) goto L10;
        return true;
    L10:
        return !ZeusTransformUtils.instanceOf(this.f.b(), g.class);
    }

    private Optional<f> h(final ZonedDateTime r6) {
        int r0 = r6.getYear();
        int r1 = r6.getMonthValue();
        int r3 = LocalDate.of(r0, 1, 1).lengthOfYear();
        List<Integer> r5 = i.a(this.f, r0).b(1, r3);
        final int r4 = LocalDate.of(r0, r1, 1).getDayOfYear();
        if (r1 != 12) goto L5;
        final int r2 = LocalDate.of(r0, 12, 31).getDayOfYear() + 1;
    L7:
        return Optional.of((List) ZeusTransformUtils.preCheckCast(r5.stream().filter(new $$Lambda$e$n8HsN8HPjsCtHipyIQvGeDEAMLA(r4, r2)).map(new $$Lambda$e$8qjhNQVUwshI0mLgd_d0ItNigaU(r6)).collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin")).filter(com.a.e.b.a($$Lambda$uXXlsNStXk0AvsHwzsQzoC1L1U.INSTANCE)).map($$Lambda$UTEldi7UvDrpYSXKQ3gflAlw2p0.INSTANCE);
    L5:
        r2 = LocalDate.of(r0, r1 + 1, 1).getDayOfYear();
        goto L7
    }

    private static /* synthetic */ boolean a(int r1, int r2, Integer r3) {
        if (r3.intValue() >= r1) goto L5;
    L7:
        return false;
    L5:
        if (r3.intValue() >= r2) goto L7;
        return true;
    }

    private static /* synthetic */ Integer a(ZonedDateTime r0, Integer r1) {
        return Integer.valueOf(LocalDate.ofYearDay(r0.getYear(), r1.intValue()).getDayOfMonth());
    }

    private Optional<f> b(com.a.c.a.c r4, ZonedDateTime r5) {
        if (r4.a(com.a.c.b.b.f).c().c().contains(com.a.c.b.d.c.f3136e) == false) goto L7;
        return Optional.of(b(r5.getYear(), r5.getMonthValue(), ((com.a.c.b.b.a) ZeusTransformUtils.preCheckCast(r4.a(com.a.c.b.b.f), com.a.c.b.b.a.class, "com.obric.aiagent.plugin")).a())).filter(com.a.e.b.a($$Lambda$uXXlsNStXk0AvsHwzsQzoC1L1U.INSTANCE)).map($$Lambda$UTEldi7UvDrpYSXKQ3gflAlw2p0.INSTANCE);
    L7:
        return Optional.of(a(r5.getYear(), r5.getMonthValue(), ((com.a.c.b.b.a) ZeusTransformUtils.preCheckCast(r4.a(com.a.c.b.b.f), com.a.c.b.b.a.class, "com.obric.aiagent.plugin")).a())).filter(com.a.e.b.a($$Lambda$uXXlsNStXk0AvsHwzsQzoC1L1U.INSTANCE)).map($$Lambda$UTEldi7UvDrpYSXKQ3gflAlw2p0.INSTANCE);
    }

    private List<Integer> a(int r6, int r7, com.a.b.b r8) {
        int r1 = LocalDate.of(r6, r7, 1).lengthOfMonth();
        if (ZeusTransformUtils.instanceOf(this.f3175e.b(), com.a.c.b.c.a.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(this.f3174d.b(), com.a.c.b.c.a.class) == false) goto L9;
        return (List) ZeusTransformUtils.preCheckCast(i.a(this.f3175e, r6, r7).b(1, r1).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(this.f3175e.b(), com.a.c.b.c.a.class) == false) goto L13;
        return (List) ZeusTransformUtils.preCheckCast(i.a(this.f3174d, r6, r7, r8).b(1, r1).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(this.f3174d.b(), com.a.c.b.c.a.class) == true) goto L15;
        List<Integer> r9 = i.a(this.f3174d, r6, r7, r8).b(1, r1);
        List<Integer> r10 = i.a(this.f3175e, r6, r7).b(1, r1);
        if (this.f3172b.a() == false) goto L21;
        final HashSet r5 = new HashSet(r9);
        return (List) ZeusTransformUtils.preCheckCast(r10.stream().filter(new $$Lambda$vbQivBKgZNtGUIub04UkQ3Ify7Y(r5)).distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L21:
        return (List) ZeusTransformUtils.preCheckCast(Stream.concat(r9.stream(), r10.stream()).distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L15:
        return (List) ZeusTransformUtils.preCheckCast(i.a(this.f3175e, r6, r7).b(1, r1).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    }

    private List<Integer> b(int r6, int r7, com.a.b.b r8) {
        int r1 = LocalDate.of(r6, r7, 1).lengthOfMonth();
        if (ZeusTransformUtils.instanceOf(this.f3175e.b(), com.a.c.b.c.a.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(this.f3174d.b(), com.a.c.b.c.a.class) == false) goto L9;
        return (List) ZeusTransformUtils.preCheckCast(i.a(this.f3175e, r6, r7).b(1, r1).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(this.f3175e.b(), g.class) == false) goto L13;
        return (List) ZeusTransformUtils.preCheckCast(i.a(this.f3174d, r6, r7, r8).b(1, r1).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(this.f3174d.b(), g.class) == true) goto L15;
        HashSet r2 = new HashSet(i.a(this.f3175e, r6, r7).b(1, r1));
        r2.retainAll(new HashSet(i.a(this.f3174d, r6, r7, r8).b(1, r1)));
        return (List) ZeusTransformUtils.preCheckCast(r2.stream().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L15:
        return (List) ZeusTransformUtils.preCheckCast(i.a(this.f3175e, r6, r7).b(1, r1).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    }

    private Optional<f> i(ZonedDateTime r4) {
        int r0 = LocalDate.of(r4.getYear(), r4.getMonthValue(), 1).lengthOfMonth();
        List r3 = (List) ZeusTransformUtils.preCheckCast(i.a(this.f3175e, r4.getYear(), r4.getMonthValue()).b(1, r0).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
        if (r3.isEmpty() == false) goto L6;
        return Optional.empty();
    L6:
        return Optional.of(new f(r3));
    }

    private f a(ZonedDateTime r4, com.a.b.b r5) {
        int r0 = LocalDate.of(r4.getYear(), r4.getMonthValue(), 1).lengthOfMonth();
        return new f((List) ZeusTransformUtils.preCheckCast(i.a(this.f3174d, r4.getYear(), r4.getMonthValue(), r5).b(1, r0).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin"));
    }
}
