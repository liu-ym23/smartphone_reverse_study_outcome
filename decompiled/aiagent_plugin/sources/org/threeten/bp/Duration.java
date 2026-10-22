package org.threeten.bp;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
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
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes5.dex */
public final class Duration implements Serializable, Comparable<Duration>, TemporalAmount {
    private static final BigInteger BI_NANOS_PER_SECOND = null;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final Pattern PATTERN = null;
    public static final Duration ZERO = null;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    /* JADX INFO: renamed from: org.threeten.bp.Duration$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Duration r3) {
        return compareTo2((Duration) ZeusTransformUtils.preCheckCast(r3, Duration.class, "com.obric.aiagent.plugin"));
    }

    static {
        ZERO = new Duration(0, 0);
        BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
        PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    public static Duration ofDays(long r1) {
        return create(Jdk8Methods.safeMultiply(r1, 86400), 0);
    }

    public static Duration ofHours(long r1) {
        return create(Jdk8Methods.safeMultiply(r1, 3600), 0);
    }

    public static Duration ofMinutes(long r1) {
        return create(Jdk8Methods.safeMultiply(r1, 60), 0);
    }

    public static Duration ofSeconds(long r1) {
        return create(r1, 0);
    }

    public static Duration ofSeconds(long r2, long r4) {
        return create(Jdk8Methods.safeAdd(r2, Jdk8Methods.floorDiv(r4, 1000000000)), Jdk8Methods.floorMod(r4, NANOS_PER_SECOND));
    }

    public static Duration ofMillis(long r4) {
        long r2 = r4 / 1000;
        int r5 = (int) (r4 % 1000);
        if (r5 >= 0) goto L6;
        r5 = r5 + 1000;
        r2 = r2 - 1;
    L6:
        return create(r2, r5 * NANOS_PER_MILLI);
    }

    public static Duration ofNanos(long r4) {
        long r2 = r4 / 1000000000;
        int r5 = (int) (r4 % 1000000000);
        if (r5 >= 0) goto L6;
        r5 = r5 + NANOS_PER_SECOND;
        r2 = r2 - 1;
    L6:
        return create(r2, r5);
    }

    public static Duration of(long r2, TemporalUnit r4) {
        TemporalUnit r5 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin");
        return ZERO.plus(r2, r5);
    }

    public static Duration from(TemporalAmount r6) {
        TemporalAmount r7 = (TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r6, TemporalAmount.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r7, "amount");
        Duration r0 = ZERO;
        Iterator<TemporalUnit> r2 = r7.getUnits().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        TemporalUnit r3 = (TemporalUnit) ZeusTransformUtils.preCheckCast(r2.next(), TemporalUnit.class, "com.obric.aiagent.plugin");
        r0 = r0.plus(r7.get(r3), r3);
        goto L4
    L6:
        return r0;
    }

    public static Duration between(Temporal r12, Temporal r13) {
        Temporal r14 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r12, Temporal.class, "com.obric.aiagent.plugin");
        Temporal r15 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r13, Temporal.class, "com.obric.aiagent.plugin");
        long r0 = r14.until(r15, ChronoUnit.SECONDS);
        long r3 = 0;
        if (r14.isSupported(ChronoField.NANO_OF_SECOND) == false) goto L23;
        if (r15.isSupported(ChronoField.NANO_OF_SECOND) == false) goto L23;
        long r5 = r14.getLong(ChronoField.NANO_OF_SECOND);     // Catch: Throwable -> L25
        long r7 = r15.getLong(ChronoField.NANO_OF_SECOND) - r5;
        if (r0 > 0) goto L10;
    L12:
        if (r0 < 0) goto L14;
    L16:
        if (r0 == 0) goto L18;
    L21:
        r3 = r7;
        goto L23
    L18:
        if (r7 == 0) goto L21;
        r0 = r14.until(r15.with(ChronoField.NANO_OF_SECOND, r5), ChronoUnit.SECONDS);     // Catch: Throwable -> L24
        goto L21
    L14:
        if (r7 <= 0) goto L16;
        r7 = r7 - 1000000000;
        goto L21
    L10:
        if (r7 >= 0) goto L12;
        r7 = r7 + 1000000000;
    L23:
        return ofSeconds(r0, r3);
    }

    public static Duration parse(CharSequence r17) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r2, "text");
        Matcher r0 = PATTERN.matcher(r2);
        if (r0.matches() == false) goto L26;
        if ("T".equals(r0.group(3)) == true) goto L26;
        int r3 = 1;
        boolean r7 = "-".equals(r0.group(1));
        String r5 = r0.group(2);
        String r6 = r0.group(4);
        String r8 = r0.group(5);
        String r9 = r0.group(6);
        String r1 = r0.group(7);
        if (r5 != null) goto L11;
        if (r6 != null) goto L11;
        if (r8 != null) goto L11;
        if (r9 == null) goto L26;
    L11:
        long r10 = parseNumber(r2, r5, 86400, "days");
        long r11 = parseNumber(r2, r6, 3600, "hours");
        long r12 = parseNumber(r2, r8, 60, "minutes");
        long r14 = parseNumber(r2, r9, 1, "seconds");
        if (r9 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 == false) goto L27;
        r3 = -1;
    L27:
        return create(r7, r10, r11, r12, r14, parseFraction(r2, r1, r3));
    L22:
        e = move-exception;
        throw ((DateTimeParseException) ZeusTransformUtils.preCheckCast(new DateTimeParseException("Text cannot be parsed to a Duration: overflow", r2, 0).initCause(e), DateTimeParseException.class, "com.obric.aiagent.plugin"));
    L14:
        if (r9.charAt(0) != '-') goto L16;
        r13 = true;
    L26:
        throw new DateTimeParseException("Text cannot be parsed to a Duration", r2, 0);
    }

    private static long parseNumber(CharSequence r5, String r6, int r7, String r8) {
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
            java.lang.Class<java.lang.CharSequence> r1 = java.lang.CharSequence.class
            java.lang.String r2 = "com.obric.aiagent.plugin"
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContextForParams(r5, r1, r2)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r6 != 0) goto L11
            r5 = 0
            return r5
        L11:
            r1 = 0
            java.lang.String r3 = "+"
            boolean r3 = r6.startsWith(r3)     // Catch: java.lang.ArithmeticException -> L28 java.lang.NumberFormatException -> L4c
            if (r3 == 0) goto L1f
            r3 = 1
            java.lang.String r6 = r6.substring(r3)     // Catch: java.lang.ArithmeticException -> L28 java.lang.NumberFormatException -> L4c
        L1f:
            long r3 = java.lang.Long.parseLong(r6)     // Catch: java.lang.ArithmeticException -> L28 java.lang.NumberFormatException -> L4c
            long r5 = org.threeten.bp.jdk8.Jdk8Methods.safeMultiply(r3, r7)     // Catch: java.lang.ArithmeticException -> L28 java.lang.NumberFormatException -> L4c
            return r5
        L28:
            r6 = move-exception
            org.threeten.bp.format.DateTimeParseException r7 = new org.threeten.bp.format.DateTimeParseException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r8 = r0.append(r8)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8, r5, r1)
            java.lang.Throwable r5 = r7.initCause(r6)
            java.lang.Class<org.threeten.bp.format.DateTimeParseException> r6 = org.threeten.bp.format.DateTimeParseException.class
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r6, r2)
            org.threeten.bp.format.DateTimeParseException r5 = (org.threeten.bp.format.DateTimeParseException) r5
            throw r5
        L4c:
            r6 = move-exception
            org.threeten.bp.format.DateTimeParseException r7 = new org.threeten.bp.format.DateTimeParseException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r8 = r0.append(r8)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8, r5, r1)
            java.lang.Throwable r5 = r7.initCause(r6)
            java.lang.Class<org.threeten.bp.format.DateTimeParseException> r6 = org.threeten.bp.format.DateTimeParseException.class
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r6, r2)
            org.threeten.bp.format.DateTimeParseException r5 = (org.threeten.bp.format.DateTimeParseException) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.parseNumber(java.lang.CharSequence, java.lang.String, int, java.lang.String):long");
    }

    private static int parseFraction(CharSequence r4, String r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L16:
        return 0;
    L5:
        if (r5.length() == 0) goto L16;
    L9:
        return Integer.parseInt((r5 + "000000000").substring(0, 9)) * r6;
    L10:
        e = move-exception;
        throw ((DateTimeParseException) ZeusTransformUtils.preCheckCast(new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r7, 0).initCause(e), DateTimeParseException.class, "com.obric.aiagent.plugin"));
    L13:
        e = move-exception;
        throw ((DateTimeParseException) ZeusTransformUtils.preCheckCast(new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r7, 0).initCause(e), DateTimeParseException.class, "com.obric.aiagent.plugin"));
    }

    private static Duration create(boolean r0, long r1, long r3, long r5, long r7, int r9) {
        long r2 = Jdk8Methods.safeAdd(r1, Jdk8Methods.safeAdd(r3, Jdk8Methods.safeAdd(r5, r7)));
        if (r0 == false) goto L7;
        return ofSeconds(r2, r9).negated();
    L7:
        return ofSeconds(r2, r9);
    }

    private static Duration create(long r4, int r6) {
        if ((((long) r6) | r4) != 0) goto L7;
        return ZERO;
    L7:
        return new Duration(r4, r6);
    }

    private Duration(long r1, int r3) {
        this.seconds = r1;
        this.nanos = r3;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (r4 != ChronoUnit.SECONDS) goto L7;
        return this.seconds;
    L7:
        if (r4 != ChronoUnit.NANOS) goto L11;
        return this.nanos;
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r4);
    }

    public boolean isZero() {
        if ((this.seconds | ((long) this.nanos)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNegative() {
        if (this.seconds >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int getNano() {
        return this.nanos;
    }

    public Duration withSeconds(long r1) {
        return create(r1, this.nanos);
    }

    public Duration withNanos(int r4) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(r4);
        return create(this.seconds, r4);
    }

    public Duration plus(Duration r5) {
        return plus(r5.getSeconds(), r5.getNano());
    }

    public Duration plus(long r7, TemporalUnit r9) {
        TemporalUnit r10 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r9, TemporalUnit.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r10, Scraps.INNER_UNIT);
        if (r10 != ChronoUnit.DAYS) goto L7;
        return plus(Jdk8Methods.safeMultiply(r7, 86400), 0);
    L7:
        if (r10.isDurationEstimated() == true) goto L34;
        if (r7 != 0) goto L12;
        return this;
    L12:
        if (ZeusTransformUtils.instanceOf(r10, ChronoUnit.class) == false) goto L31;
        int r0 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r10, ChronoUnit.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r0 == 1) goto L30;
        if (r0 == 2) goto L28;
        if (r0 == 3) goto L26;
        if (r0 == 4) goto L24;
        return plusSeconds(Jdk8Methods.safeMultiply(r10.getDuration().seconds, r7));
    L24:
        return plusSeconds(r7);
    L26:
        return plusMillis(r7);
    L28:
        return plusSeconds((r7 / 1000000000) * 1000).plusNanos((r7 % 1000000000) * 1000);
    L30:
        return plusNanos(r7);
    L31:
        Duration r8 = r10.getDuration().multipliedBy(r7);
        return plusSeconds(r8.getSeconds()).plusNanos(r8.getNano());
    L34:
        throw new DateTimeException("Unit must not have an estimated duration");
    }

    public Duration plusDays(long r3) {
        return plus(Jdk8Methods.safeMultiply(r3, 86400), 0);
    }

    public Duration plusHours(long r3) {
        return plus(Jdk8Methods.safeMultiply(r3, 3600), 0);
    }

    public Duration plusMinutes(long r3) {
        return plus(Jdk8Methods.safeMultiply(r3, 60), 0);
    }

    public Duration plusSeconds(long r3) {
        return plus(r3, 0);
    }

    public Duration plusMillis(long r5) {
        return plus(r5 / 1000, (r5 % 1000) * 1000000);
    }

    public Duration plusNanos(long r3) {
        return plus(0, r3);
    }

    private Duration plus(long r5, long r7) {
        if ((r5 | r7) != 0) goto L6;
        return this;
    L6:
        return ofSeconds(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, r5), r7 / 1000000000), this.nanos + (r7 % 1000000000));
    }

    public Duration minus(Duration r5) {
        long r0 = r5.getSeconds();
        int r6 = r5.getNano();
        if (r0 != Long.MIN_VALUE) goto L7;
        return plus(Long.MAX_VALUE, -r6).plus(1, 0);
    L7:
        return plus(-r0, -r6);
    }

    public Duration minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration minusHours(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plusHours(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusHours(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration minusMinutes(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plusMinutes(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMinutes(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration minusSeconds(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plusSeconds(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusSeconds(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration minusMillis(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plusMillis(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMillis(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration minusNanos(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Duration this = plusNanos(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusNanos(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public Duration multipliedBy(long r3) {
        if (r3 != 0) goto L7;
        return ZERO;
    L7:
        if (r3 != 1) goto L10;
        return this;
    L10:
        return create(toSeconds().multiply(BigDecimal.valueOf(r3)));
    }

    public Duration dividedBy(long r3) {
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L8;
        return this;
    L8:
        return create(toSeconds().divide(BigDecimal.valueOf(r3), RoundingMode.DOWN));
    L10:
        throw new ArithmeticException("Cannot divide by zero");
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    private static Duration create(BigDecimal r5) {
        BigInteger r6 = r5.movePointRight(9).toBigIntegerExact();
        BigInteger[] r0 = r6.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (r0[0].bitLength() > 63) goto L7;
        return ofSeconds(r0[0].longValue(), r0[1].intValue());
    L7:
        throw new ArithmeticException("Exceeds capacity of Duration: " + r6);
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public Duration abs() {
        if (isNegative() == true) goto L5;
        return this;
    L5:
        return negated();
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal r5) {
        Temporal r6 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r5, Temporal.class, "com.obric.aiagent.plugin");
        long r0 = this.seconds;
        if (r0 == 0) goto L5;
        r6 = r6.plus(r0, ChronoUnit.SECONDS);
    L5:
        int r4 = this.nanos;
        if (r4 != 0) goto L8;
        return r6;
    L8:
        return r6.plus(r4, ChronoUnit.NANOS);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal r5) {
        Temporal r6 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r5, Temporal.class, "com.obric.aiagent.plugin");
        long r0 = this.seconds;
        if (r0 == 0) goto L5;
        r6 = r6.minus(r0, ChronoUnit.SECONDS);
    L5:
        int r4 = this.nanos;
        if (r4 != 0) goto L8;
        return r6;
    L8:
        return r6.minus(r4, ChronoUnit.NANOS);
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toMillis() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000), this.nanos / NANOS_PER_MILLI);
    }

    public long toNanos() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, NANOS_PER_SECOND), this.nanos);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Duration r5) {
        int r0 = Jdk8Methods.compareLongs(this.seconds, r5.seconds);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.nanos - r5.nanos;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Duration.class) == false) goto L14;
        Duration r10 = (Duration) ZeusTransformUtils.preCheckCast(r9, Duration.class, "com.obric.aiagent.plugin");
        if (this.seconds != r10.seconds) goto L13;
        if (this.nanos != r10.nanos) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        long r0 = this.seconds;
        return ((int) (r0 ^ (r0 >>> 32))) + (this.nanos * 51);
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "PT0S";
    L6:
        long r0 = this.seconds;
        long r4 = r0 / 3600;
        int r2 = (int) ((r0 % 3600) / 60);
        int r1 = (int) (r0 % 60);
        StringBuilder r3 = new StringBuilder(24);
        r3.append("PT");
        if (r4 == 0) goto L9;
        r3.append(r4).append('H');
    L9:
        if (r2 == 0) goto L11;
        r3.append(r2).append('M');
    L11:
        if (r1 == 0) goto L13;
    L18:
        if (r1 < 0) goto L20;
    L25:
        r3.append(r1);
    L27:
        if (this.nanos <= 0) goto L36;
        int r5 = r3.length();
        if (r1 >= 0) goto L31;
        r3.append(2000000000 - this.nanos);
    L33:
        if (r3.charAt(r3.length() - 1) != '0') goto L35;
        r3.setLength(r3.length() - 1);
        goto L33
    L35:
        r3.setCharAt(r5, '.');
        goto L36
    L31:
        r3.append(this.nanos + NANOS_PER_SECOND);
    L36:
        r3.append('S');
        return r3.toString();
    L20:
        if (this.nanos <= 0) goto L25;
        if (r1 != (-1)) goto L24;
        r3.append("-0");
        goto L27
    L24:
        r3.append(r1 + 1);
        goto L27
    L13:
        if (this.nanos != 0) goto L18;
        if (r3.length() <= 2) goto L18;
        return r3.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin");
        r4.writeLong(this.seconds);
        r4.writeInt(this.nanos);
    }

    static Duration readExternal(DataInput r4) {
        DataInput r5 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r4, DataInput.class, "com.obric.aiagent.plugin");
        return ofSeconds(r5.readLong(), r5.readInt());
    }
}
