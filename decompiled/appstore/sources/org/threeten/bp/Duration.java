package org.threeten.bp;

import com.blankj.utilcode.constant.CacheConstants;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes4.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final BigInteger BI_NANOS_PER_SECOND = null;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final Pattern PATTERN = null;
    public static final Duration ZERO = null;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23066a = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23066a = r10;
            r10[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f23066a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f23066a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f23066a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        ZERO = new Duration(0, 0);
        BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
        PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private Duration(long r10, int r11) {
        this.seconds = r10;
        this.nanos = r11;
    }

    public static Duration between(Temporal r14, Temporal r15) {
        ChronoUnit r10 = ChronoUnit.SECONDS;
        long r11 = r14.until(r15, r10);
        ChronoField r12 = ChronoField.NANO_OF_SECOND;
        long r13 = 0;
        if (r14.isSupported(r12) == false) goto L23;
        if (r15.isSupported(r12) == false) goto L23;
        long r16 = r14.getLong(r12);     // Catch: Throwable -> L25
        long r17 = r15.getLong(r12) - r16;
        if (r11 > 0) goto L10;
    L13:
        if (r11 < 0) goto L15;
    L17:
        if (r11 == 0) goto L19;
    L12:
        r13 = r17;
        goto L23
    L19:
        if (r17 == 0) goto L12;
        r11 = r14.until(r15.with(r12, r16), r10);     // Catch: Throwable -> L24
        goto L12
    L15:
        if (r17 <= 0) goto L17;
        r17 = r17 - 1000000000;
        goto L12
    L10:
        if (r17 >= 0) goto L13;
        r17 = r17 + 1000000000;
    L23:
        return ofSeconds(r11, r13);
    }

    private static Duration create(boolean r10, long r11, long r12, long r13, long r14, int r15) {
        long r16 = d.j(r11, d.j(r12, d.j(r13, r14)));
        if (r10 == false) goto L7;
        return ofSeconds(r16, r15).negated();
    L7:
        return ofSeconds(r16, r15);
    }

    public static Duration from(TemporalAmount r10) {
        d.h(r10, "amount");
        Duration r11 = ZERO;
        Iterator<TemporalUnit> r12 = r10.getUnits().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        TemporalUnit r13 = r12.next();
        r11 = r11.plus(r10.get(r13), r13);
        goto L4
    L6:
        return r11;
    }

    public static Duration of(long r10, TemporalUnit r11) {
        return ZERO.plus(r10, r11);
    }

    public static Duration ofDays(long r10) {
        return create(d.l(r10, CacheConstants.DAY), 0);
    }

    public static Duration ofHours(long r10) {
        return create(d.l(r10, CacheConstants.HOUR), 0);
    }

    public static Duration ofMillis(long r10) {
        long r11 = r10 / 1000;
        int r12 = (int) (r10 % 1000);
        if (r12 >= 0) goto L6;
        r12 = r12 + 1000;
        r11 = r11 - 1;
    L6:
        return create(r11, r12 * 1000000);
    }

    public static Duration ofMinutes(long r10) {
        return create(d.l(r10, 60), 0);
    }

    public static Duration ofNanos(long r10) {
        long r11 = r10 / 1000000000;
        int r12 = (int) (r10 % 1000000000);
        if (r12 >= 0) goto L6;
        r12 = r12 + NANOS_PER_SECOND;
        r11 = r11 - 1;
    L6:
        return create(r11, r12);
    }

    public static Duration ofSeconds(long r10) {
        return create(r10, 0);
    }

    public static Duration parse(CharSequence r17) {
        d.h(r17, "text");
        Matcher r10 = PATTERN.matcher(r17);
        if (r10.matches() == false) goto L23;
        if ("T".equals(r10.group(3)) == true) goto L23;
        int r11 = 1;
        boolean r12 = "-".equals(r10.group(1));
        String r13 = r10.group(2);
        String r14 = r10.group(4);
        String r15 = r10.group(5);
        String r16 = r10.group(6);
        String r18 = r10.group(7);
        if (r13 != null) goto L11;
        if (r14 != null) goto L11;
        if (r15 != null) goto L11;
        if (r16 == null) goto L23;
    L11:
        long r19 = parseNumber(r17, r13, CacheConstants.DAY, "days");
        long r110 = parseNumber(r17, r14, CacheConstants.HOUR, "hours");
        long r111 = parseNumber(r17, r15, 60, "minutes");
        long r112 = parseNumber(r17, r16, 1, "seconds");
        if (r16 == null) goto L24;
        if (r16.charAt(0) != '-') goto L24;
        r11 = -1;
    L24:
        return create(r12, r19, r110, r111, r112, parseFraction(r17, r18, r11));
    L19:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", r17, 0).initCause(e));
    L23:
        throw new DateTimeParseException("Text cannot be parsed to a Duration", r17, 0);
    }

    private static int parseFraction(CharSequence r10, String r11, int r12) {
        if (r11 != null) goto L5;
    L18:
        return 0;
    L5:
        if (r11.length() == 0) goto L18;
    L9:
        return Integer.parseInt((r11 + "000000000").substring(0, 9)) * r12;
    L10:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r10, 0).initCause(e));
    L12:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r10, 0).initCause(e));
    }

    private static long parseNumber(CharSequence r10, String r11, int r12, String r13) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.String r0 = "Text cannot be parsed to a Duration: "
            if (r5 != 0) goto L7
            r4 = 0
            return r4
        L7:
            r1 = 0
            java.lang.String r2 = "+"
            boolean r2 = r5.startsWith(r2)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            if (r2 == 0) goto L1a
            r2 = 1
            java.lang.String r5 = r5.substring(r2)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            goto L1a
        L16:
            r5 = move-exception
            goto L23
        L18:
            r5 = move-exception
            goto L3e
        L1a:
            long r2 = java.lang.Long.parseLong(r5)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            long r4 = ig.d.l(r2, r6)     // Catch: java.lang.ArithmeticException -> L16 java.lang.NumberFormatException -> L18
            return r4
        L23:
            org.threeten.bp.format.DateTimeParseException r6 = new org.threeten.bp.format.DateTimeParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r6.<init>(r7, r4, r1)
            java.lang.Throwable r4 = r6.initCause(r5)
            org.threeten.bp.format.DateTimeParseException r4 = (org.threeten.bp.format.DateTimeParseException) r4
            throw r4
        L3e:
            org.threeten.bp.format.DateTimeParseException r6 = new org.threeten.bp.format.DateTimeParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r6.<init>(r7, r4, r1)
            java.lang.Throwable r4 = r6.initCause(r5)
            org.threeten.bp.format.DateTimeParseException r4 = (org.threeten.bp.format.DateTimeParseException) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.parseNumber(java.lang.CharSequence, java.lang.String, int, java.lang.String):long");
    }

    public static Duration readExternal(DataInput r10) throws IOException {
        return ofSeconds(r10.readLong(), r10.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public Duration abs() {
        if (isNegative() == true) goto L5;
        return this;
    L5:
        return negated();
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal r10) {
        long r11 = this.seconds;
        if (r11 == 0) goto L5;
        r10 = r10.plus(r11, ChronoUnit.SECONDS);
    L5:
        int r12 = this.nanos;
        if (r12 != 0) goto L8;
        return r10;
    L8:
        return r10.plus(r12, ChronoUnit.NANOS);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r10) {
        return compareTo2(r10);
    }

    public Duration dividedBy(long r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return this;
    L8:
        return create(toSeconds().divide(BigDecimal.valueOf(r10), RoundingMode.DOWN));
    L10:
        throw new ArithmeticException("Cannot divide by zero");
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Duration) == false) goto L14;
        Duration r11 = (Duration) r10;
        if (this.seconds != r11.seconds) goto L13;
        if (this.nanos != r11.nanos) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit r10) {
        if (r10 != ChronoUnit.SECONDS) goto L7;
        return this.seconds;
    L7:
        if (r10 != ChronoUnit.NANOS) goto L11;
        return this.nanos;
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    public int hashCode() {
        long r10 = this.seconds;
        return ((int) (r10 ^ (r10 >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        if (this.seconds >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isZero() {
        if ((this.seconds | ((long) this.nanos)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Duration minus(Duration r10) {
        long r11 = r10.getSeconds();
        int r12 = r10.getNano();
        if (r11 != Long.MIN_VALUE) goto L7;
        return plus(Long.MAX_VALUE, -r12).plus(1, 0);
    L7:
        return plus(-r11, -r12);
    }

    public Duration minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Duration minusHours(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plusHours(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusHours(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Duration minusMillis(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plusMillis(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMillis(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Duration minusMinutes(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plusMinutes(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMinutes(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Duration minusNanos(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plusNanos(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusNanos(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Duration minusSeconds(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plusSeconds(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusSeconds(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Duration multipliedBy(long r10) {
        if (r10 != 0) goto L7;
        return ZERO;
    L7:
        if (r10 != 1) goto L10;
        return this;
    L10:
        return create(toSeconds().multiply(BigDecimal.valueOf(r10)));
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public Duration plus(Duration r10) {
        return plus(r10.getSeconds(), r10.getNano());
    }

    public Duration plusDays(long r10) {
        return plus(d.l(r10, CacheConstants.DAY), 0);
    }

    public Duration plusHours(long r10) {
        return plus(d.l(r10, CacheConstants.HOUR), 0);
    }

    public Duration plusMillis(long r10) {
        return plus(r10 / 1000, (r10 % 1000) * BatteryFactorConfig.WIFI_BPS);
    }

    public Duration plusMinutes(long r10) {
        return plus(d.l(r10, 60), 0);
    }

    public Duration plusNanos(long r10) {
        return plus(0, r10);
    }

    public Duration plusSeconds(long r10) {
        return plus(r10, 0);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal r10) {
        long r11 = this.seconds;
        if (r11 == 0) goto L5;
        r10 = r10.minus(r11, ChronoUnit.SECONDS);
    L5:
        int r12 = this.nanos;
        if (r12 != 0) goto L8;
        return r10;
    L8:
        return r10.minus(r12, ChronoUnit.NANOS);
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public long toMillis() {
        return d.j(d.l(this.seconds, 1000), this.nanos / 1000000);
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toNanos() {
        return d.j(d.l(this.seconds, NANOS_PER_SECOND), this.nanos);
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "PT0S";
    L6:
        long r10 = this.seconds;
        long r11 = r10 / 3600;
        int r12 = (int) ((r10 % 3600) / 60);
        int r13 = (int) (r10 % 60);
        StringBuilder r14 = new StringBuilder(24);
        r14.append("PT");
        if (r11 == 0) goto L9;
        r14.append(r11);
        r14.append('H');
    L9:
        if (r12 == 0) goto L11;
        r14.append(r12);
        r14.append('M');
    L11:
        if (r13 == 0) goto L13;
    L18:
        if (r13 < 0) goto L20;
    L25:
        r14.append(r13);
    L27:
        if (this.nanos <= 0) goto L36;
        int r15 = r14.length();
        if (r13 >= 0) goto L31;
        r14.append(2000000000 - this.nanos);
    L33:
        if (r14.charAt(r14.length() - 1) != '0') goto L35;
        r14.setLength(r14.length() - 1);
        goto L33
    L35:
        r14.setCharAt(r15, '.');
        goto L36
    L31:
        r14.append(this.nanos + NANOS_PER_SECOND);
    L36:
        r14.append('S');
        return r14.toString();
    L20:
        if (this.nanos <= 0) goto L25;
        if (r13 != (-1)) goto L24;
        r14.append("-0");
        goto L27
    L24:
        r14.append(r13 + 1);
        goto L27
    L13:
        if (this.nanos != 0) goto L18;
        if (r14.length() <= 2) goto L18;
        return r14.toString();
    }

    public Duration withNanos(int r10) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(r10);
        return create(this.seconds, r10);
    }

    public Duration withSeconds(long r10) {
        return create(r10, this.nanos);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeLong(this.seconds);
        r10.writeInt(this.nanos);
    }

    public static Duration ofSeconds(long r10, long r11) {
        return create(d.j(r10, d.d(r11, 1000000000)), d.f(r11, NANOS_PER_SECOND));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Duration r10) {
        int r11 = d.b(this.seconds, r10.seconds);
        if (r11 == 0) goto L6;
        return r11;
    L6:
        return this.nanos - r10.nanos;
    }

    public Duration plus(long r10, TemporalUnit r11) {
        d.h(r11, "unit");
        if (r11 != ChronoUnit.DAYS) goto L7;
        return plus(d.l(r10, CacheConstants.DAY), 0);
    L7:
        if (r11.isDurationEstimated() == true) goto L34;
        if (r10 != 0) goto L12;
        return this;
    L12:
        if ((r11 instanceof ChronoUnit) == false) goto L31;
        int r12 = a.f23066a[((ChronoUnit) r11).ordinal()];
        if (r12 == 1) goto L30;
        if (r12 == 2) goto L28;
        if (r12 == 3) goto L26;
        if (r12 == 4) goto L24;
        return plusSeconds(d.m(r11.getDuration().seconds, r10));
    L24:
        return plusSeconds(r10);
    L26:
        return plusMillis(r10);
    L28:
        return plusSeconds((r10 / 1000000000) * 1000).plusNanos((r10 % 1000000000) * 1000);
    L30:
        return plusNanos(r10);
    L31:
        Duration r13 = r11.getDuration().multipliedBy(r10);
        return plusSeconds(r13.getSeconds()).plusNanos(r13.getNano());
    L34:
        throw new DateTimeException("Unit must not have an estimated duration");
    }

    private static Duration create(long r10, int r11) {
        if ((((long) r11) | r10) != 0) goto L7;
        return ZERO;
    L7:
        return new Duration(r10, r11);
    }

    public Duration minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Duration this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    private static Duration create(BigDecimal r10) {
        BigInteger r11 = r10.movePointRight(9).toBigIntegerExact();
        BigInteger[] r12 = r11.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (r12[0].bitLength() > 63) goto L7;
        return ofSeconds(r12[0].longValue(), r12[1].intValue());
    L7:
        throw new ArithmeticException("Exceeds capacity of Duration: " + r11);
    }

    private Duration plus(long r10, long r11) {
        if ((r10 | r11) != 0) goto L6;
        return this;
    L6:
        return ofSeconds(d.j(d.j(this.seconds, r10), r11 / 1000000000), this.nanos + (r11 % 1000000000));
    }
}
