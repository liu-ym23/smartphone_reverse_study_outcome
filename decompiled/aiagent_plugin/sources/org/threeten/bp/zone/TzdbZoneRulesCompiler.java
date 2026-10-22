package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: loaded from: classes5.dex */
final class TzdbZoneRulesCompiler {
    private static final DateTimeFormatter TIME_PARSER = null;
    private final SortedMap<String, ZoneRules> builtZones;
    private Map<Object, Object> deduplicateMap;
    private final SortedMap<LocalDate, Byte> leapSeconds;
    private final File leapSecondsFile;
    private final Map<String, String> links;
    private final Map<String, List<TZDBRule>> rules;
    private final List<File> sourceFiles;
    private final boolean verbose;
    private final String version;
    private final Map<String, List<TZDBZone>> zones;

    static final class LeapSecondRule {
        final LocalDate leapDate;
        byte secondAdjustment;

        public LeapSecondRule(LocalDate r1, byte r2) {
            this.leapDate = r1;
            this.secondAdjustment = r2;
        }
    }

    abstract class TZDBMonthDayTime {
        boolean adjustForwards;
        int dayOfMonth;
        DayOfWeek dayOfWeek;
        boolean endOfDay;
        Month month;
        final /* synthetic */ TzdbZoneRulesCompiler this$0;
        LocalTime time;
        ZoneOffsetTransitionRule.TimeDefinition timeDefinition;

        TZDBMonthDayTime(TzdbZoneRulesCompiler r1) {
            this.this$0 = r1;
            this.month = Month.JANUARY;
            this.dayOfMonth = 1;
            this.adjustForwards = true;
            this.time = LocalTime.MIDNIGHT;
            this.timeDefinition = ZoneOffsetTransitionRule.TimeDefinition.WALL;
        }

        void adjustToFowards(int r3) {
            if (this.adjustForwards == true) goto L8;
            int r0 = this.dayOfMonth;
            if (r0 <= 0) goto L9;
            LocalDate r4 = LocalDate.of(r3, this.month, r0).minusDays(6);
            this.dayOfMonth = r4.getDayOfMonth();
            this.month = r4.getMonth();
            this.adjustForwards = true;
            return;
        L9:
            return;
        }
    }

    final class TZDBRule extends TZDBMonthDayTime {
        int endYear;
        int savingsAmount;
        int startYear;
        String text;
        final /* synthetic */ TzdbZoneRulesCompiler this$0;

        TZDBRule(TzdbZoneRulesCompiler r1) {
            this.this$0 = r1;
            super(r1);
        }

        void addToBuilder(ZoneRulesBuilder r12) {
            adjustToFowards(2004);
            r12.addRuleToWindow(this.startYear, this.endYear, this.month, this.dayOfMonth, this.dayOfWeek, this.time, this.endOfDay, this.timeDefinition, this.savingsAmount);
        }
    }

    final class TZDBZone extends TZDBMonthDayTime {
        Integer fixedSavingsSecs;
        String savingsRule;
        ZoneOffset standardOffset;
        String text;
        final /* synthetic */ TzdbZoneRulesCompiler this$0;
        Year year;

        TZDBZone(TzdbZoneRulesCompiler r1) {
            this.this$0 = r1;
            super(r1);
        }

        ZoneRulesBuilder addToBuilder(ZoneRulesBuilder r5, Map<String, List<TZDBRule>> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            Year r0 = this.year;
            if (r0 == null) goto L5;
            r5.addWindow(this.standardOffset, toDateTime(r0.getValue()), this.timeDefinition);
        L6:
            Integer r1 = this.fixedSavingsSecs;
            if (r1 == null) goto L9;
            r5.setFixedSavingsToWindow(r1.intValue());
        L15:
            return r5;
        L9:
            List r8 = (List) ZeusTransformUtils.preCheckCast(r7.get(this.savingsRule), List.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L17;
            Iterator r4 = r8.iterator();
        L13:
            if (r4.hasNext() == false) goto L15;
            ((TZDBRule) ZeusTransformUtils.preCheckCast(r4.next(), TZDBRule.class, "com.obric.aiagent.plugin")).addToBuilder(r5);
            goto L13
        L17:
            throw new IllegalArgumentException("Rule not found: " + this.savingsRule);
        L5:
            r5.addWindowForever(this.standardOffset);
            goto L6
        }

        private LocalDateTime toDateTime(int r4) {
            adjustToFowards(r4);
            if (this.dayOfMonth != (-1)) goto L7;
            this.dayOfMonth = this.month.length(Year.isLeap(r4));
            LocalDate r5 = LocalDate.of(r4, this.month, this.dayOfMonth);
            if (this.dayOfWeek == null) goto L10;
            r5 = r5.with(TemporalAdjusters.previousOrSame(this.dayOfWeek));
        L10:
            LocalDateTime r6 = LocalDateTime.of((LocalDate) ZeusTransformUtils.preCheckCast(this.this$0.deduplicate(r5), LocalDate.class, "com.obric.aiagent.plugin"), this.time);
            if (this.endOfDay == true) goto L13;
            return r6;
        L13:
            return r6.plusDays(1);
        L7:
            r5 = LocalDate.of(r4, this.month, this.dayOfMonth);
            if (this.dayOfWeek == null) goto L10;
            r5 = r5.with(TemporalAdjusters.nextOrSame(this.dayOfWeek));
            goto L10
        }
    }

    static {
        TIME_PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.HOUR_OF_DAY).optionalStart().appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
    }

    public static void main(String[] r17) {
        if (r17.length >= 2) goto L6;
        outputHelp();
        return;
    L6:
        File r1 = null;
        int r2 = 0;
        File r3 = null;
        String r4 = null;
        int r5 = 0;
        boolean r6 = false;
        boolean r7 = false;
    L8:
        if (r5 >= r17.length) goto L44;
        String r8 = r17[r5];
        if (r8.startsWith("-") == false) goto L44;
        if ("-srcdir".equals(r8) == false) goto L19;
        if (r1 != null) goto L42;
        r5 = r5 + 1;
        if (r5 >= r17.length) goto L42;
        r1 = new File(r17[r5]);
    L38:
        r5 = r5 + 1;
    L42:
        outputHelp();
        return;
    L19:
        if ("-dstdir".equals(r8) == false) goto L25;
        if (r3 != null) goto L42;
        r5 = r5 + 1;
        if (r5 >= r17.length) goto L42;
        r3 = new File(r17[r5]);
        goto L38
    L25:
        if ("-version".equals(r8) == false) goto L31;
        if (r4 != null) goto L42;
        r5 = r5 + 1;
        if (r5 >= r17.length) goto L42;
        r4 = r17[r5];
        goto L38
    L31:
        if ("-unpacked".equals(r8) == false) goto L35;
        if (r6 == true) goto L42;
        r6 = true;
        goto L38
    L35:
        if ("-verbose".equals(r8) == false) goto L40;
        if (r7 == true) goto L42;
        r7 = true;
        goto L38
    L40:
        if ("-help".equals(r8) == true) goto L42;
        System.out.println("Unrecognised option: " + r8);
    L44:
        if (r1 != null) goto L48;
        System.out.println("Source directory must be specified using -srcdir: " + r1);
        return;
    L48:
        if (r1.isDirectory() == true) goto L51;
        System.out.println("Source does not exist or is not a directory: " + r1);
        return;
    L51:
        if (r3 != null) goto L54;
        r3 = r1;
    L54:
        List r0 = Arrays.asList(Arrays.copyOfRange(r17, r5, r17.length));
        if (r0.isEmpty() == false) goto L57;
        System.out.println("Source filenames not specified, using default set");
        System.out.println("(africa antarctica asia australasia backward etcetera europe northamerica southamerica)");
        r0 = Arrays.asList(new String[]{"africa", "antarctica", "asia", "australasia", "backward", "etcetera", "europe", "northamerica", "southamerica"});
    L57:
        ArrayList r9 = new ArrayList();
        if (r4 == null) goto L64;
        File r10 = new File(r1, r4);
        if (r10.isDirectory() == true) goto L63;
        System.out.println("Version does not represent a valid source directory : " + r10);
        return;
    L63:
        r9.add(r10);
    L73:
        if (r9.isEmpty() == false) goto L77;
        System.out.println("Source directory contains no valid source folders: " + r1);
        return;
    L77:
        if (r3.exists() == true) goto L83;
        if (r3.mkdirs() == true) goto L83;
        System.out.println("Destination directory could not be created: " + r3);
        return;
    L83:
        if (r3.isDirectory() == true) goto L86;
        System.out.println("Destination is not a directory: " + r3);
        return;
    L86:
        process(r9, r0, r3, r6, r7);
        return;
    L64:
        File[] r11 = r1.listFiles();
        int r12 = r11.length;
    L65:
        if (r2 >= r12) goto L73;
        File r13 = r11[r2];
        if (r13.isDirectory() == false) goto L71;
        if (r13.getName().matches("[12][0-9][0-9][0-9][A-Za-z0-9._-]+") == false) goto L71;
        r9.add(r13);
    L71:
        r2 = r2 + 1;
        goto L65
    }

    private static void outputHelp() {
        System.out.println("Usage: TzdbZoneRulesCompiler <options> <tzdb source filenames>");
        System.out.println("where options include:");
        System.out.println("   -srcdir <directory>   Where to find source directories (required)");
        System.out.println("   -dstdir <directory>   Where to output generated files (default srcdir)");
        System.out.println("   -version <version>    Specify the version, such as 2009a (optional)");
        System.out.println("   -unpacked             Generate dat files without jar files");
        System.out.println("   -help                 Print this usage message");
        System.out.println("   -verbose              Output verbose information during compilation");
        System.out.println(" There must be one directory for each version in srcdir");
        System.out.println(" Each directory must have the name of the version, such as 2009a");
        System.out.println(" Each directory must contain the unpacked tzdb files, such as asia or europe");
        System.out.println(" Directories must match the regex [12][0-9][0-9][0-9][A-Za-z0-9._-]+");
        System.out.println(" There will be one jar file for each version and one combined jar in dstdir");
        System.out.println(" If the version is specified, only that version is processed");
    }

    private static void process(List<File> r17, List<String> r18, File r19, boolean r20, boolean r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        HashMap r5 = new HashMap();
        TreeMap r6 = new TreeMap();
        TreeSet r7 = new TreeSet();
        HashSet r8 = new HashSet();
        Iterator r9 = r0.iterator();
        SortedMap<LocalDate, Byte> r11 = null;
    L4:
        if (r9.hasNext() == false) goto L45;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r9.next(), File.class, "com.obric.aiagent.plugin");
        ArrayList r12 = new ArrayList();
        Iterator r13 = r4.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        File r15 = new File(r1, (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin"));
        if (r15.exists() == false) goto L7;
        r12.add(r15);
        goto L7
    L12:
        if (r12.isEmpty() == true) goto L4;
        File r14 = new File(r1, "leapseconds");
        if (r14.exists() == true) goto L17;
        System.out.println("Version " + r1.getName() + " does not include leap seconds information.");
        r14 = null;
    L17:
        String r2 = r1.getName();
        TzdbZoneRulesCompiler r16 = new TzdbZoneRulesCompiler(r2, r12, r14, r21);
        r16.setDeduplicateMap(r5);
        r16.compile();     // Catch: Exception -> L40
        SortedMap<String, ZoneRules> r110 = r16.getZones();     // Catch: Exception -> L40
        SortedMap<LocalDate, Byte> r111 = r16.getLeapSeconds();     // Catch: Exception -> L40
        if (r20 == true) goto L31;
        List r112 = r4;
        File r113 = new File(r19, "threeten-TZDB-" + r2 + ".jar");     // Catch: Exception -> L29
        if (r21 == false) goto L27;
        HashMap r114 = r5;
        System.out.println("Outputting file: " + r113);     // Catch: Exception -> L38
    L28:
        outputFile(r113, r2, r110, r111);     // Catch: Exception -> L38
    L32:
        r6.put(r2, r110);     // Catch: Exception -> L38
        r7.addAll(r110.keySet());     // Catch: Exception -> L38
        r8.addAll(r110.values());     // Catch: Exception -> L38
        if (r16.getMostRecentLeapSecond() == null) goto L44;
        if (r11 != null) goto L36;
    L37:
        r11 = r111;
        goto L44
    L36:
        if (r16.getMostRecentLeapSecond().compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r11.lastKey(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) > 0) goto L37;
    L44:
        r4 = r112;
        r5 = r114;
    L38:
        e = e;
    L43:
        System.out.println("Failed: " + e.toString());
        e.printStackTrace();
        System.exit(1);
        goto L44
    L27:
        r114 = r5;
    L29:
        e = e;
    L42:
        r114 = r5;
        goto L43
    L31:
        r112 = r4;
        r114 = r5;
    L40:
        e = e;
        r112 = r4;
        goto L42
    L45:
        if (r20 == false) goto L49;
        if (r21 == false) goto L48;
        System.out.println("Outputting combined files: " + r19);
    L48:
        outputFilesDat(r19, r6, r7, r8, r11);
        return;
    L49:
        File r3 = new File(r19, "threeten-TZDB-all.jar");
        if (r21 == false) goto L52;
        System.out.println("Outputting combined file: " + r3);
    L52:
        outputFile(r3, r6, r7, r8, r11);
    }

    private static void outputFilesDat(File r2, Map<String, SortedMap<String, ZoneRules>> r3, Set<String> r4, Set<ZoneRules> r5, SortedMap<LocalDate, Byte> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        SortedMap r10 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r6, SortedMap.class, "com.obric.aiagent.plugin");
        File r11 = new File(r2, "TZDB.dat");
        r11.delete();
        FileOutputStream r0 = new FileOutputStream(r11);     // Catch: Throwable -> L8
        outputTzdbDat(r0, r7, r8, r9);     // Catch: Throwable -> L6
        r0.close();     // Catch: Exception -> L13
        return;
    L6:
        Throwable th = th;
    L10:
        if (r0 == null) goto L21;
        r0.close();     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L21:
        throw th;     // Catch: Exception -> L13
    L8:
        th = move-exception;
        r0 = null;
        th = th;
    L13:
        e = move-exception;
        System.out.println("Failed: " + e.toString());
        e.printStackTrace();
        System.exit(1);
    }

    private static void outputFile(File r2, String r3, SortedMap<String, ZoneRules> r4, SortedMap<LocalDate, Byte> r5) {
        SortedMap r6 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r4, SortedMap.class, "com.obric.aiagent.plugin");
        SortedMap r7 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r5, SortedMap.class, "com.obric.aiagent.plugin");
        TreeMap r0 = new TreeMap();
        r0.put(r3, r6);
        outputFile(r2, r0, new TreeSet(r6.keySet()), new HashSet(r6.values()), r7);
    }

    private static void outputFile(File r2, Map<String, SortedMap<String, ZoneRules>> r3, Set<String> r4, Set<ZoneRules> r5, SortedMap<LocalDate, Byte> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        SortedMap r10 = (SortedMap) ZeusTransformUtils.wrapperContextForParams(r6, SortedMap.class, "com.obric.aiagent.plugin");
        JarOutputStream r11 = null;
        JarOutputStream r0 = new JarOutputStream(new FileOutputStream(r2));     // Catch: Throwable -> L11 Exception -> L13
        outputTzdbEntry(r0, r7, r8, r9);     // Catch: Throwable -> L7 Exception -> L9
        r0.close();     // Catch: IOException -> L21
    L23:
        return;
    L9:
        e = e;
        r11 = r0;
    L14:
        System.out.println("Failed: " + e.toString());     // Catch: Throwable -> L11
        e.printStackTrace();     // Catch: Throwable -> L11
        System.exit(1);     // Catch: Throwable -> L11
        if (r11 == null) goto L32;
        r11.close();     // Catch: IOException -> L21
        goto L23
    L32:
        return;
    L7:
        th = th;
        r11 = r0;
    L18:
        if (r11 != null) goto L28;
    L20:
        throw th;
    L28:
        r11.close();     // Catch: IOException -> L22
    L13:
        e = e;
    L11:
        th = th;
    }

    private static void outputTzdbEntry(JarOutputStream r2, Map<String, SortedMap<String, ZoneRules>> r3, Set<String> r4, Set<ZoneRules> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        r2.putNextEntry(new ZipEntry("org/threeten/bp/TZDB.dat"));     // Catch: Exception -> L5
        outputTzdbDat(r2, r6, r7, r8);     // Catch: Exception -> L5
        r2.closeEntry();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        System.out.println("Failed: " + e.toString());
        e.printStackTrace();
        System.exit(1);
    }

    private static void outputTzdbDat(OutputStream r6, Map<String, SortedMap<String, ZoneRules>> r7, Set<String> r8, Set<ZoneRules> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        DataOutputStream r0 = new DataOutputStream(r6);
        r0.writeByte(1);
        r0.writeUTF("TZDB");
        String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(r10.keySet().toArray(new String[r10.size()]), String[].class, "com.obric.aiagent.plugin");
        r0.writeShort(r13.length);
        int r2 = r13.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r0.writeUTF(r13[r4]);
        r4 = r4 + 1;
        goto L3
    L5:
        String[] r14 = (String[]) ZeusTransformUtils.preCheckCast(r11.toArray(new String[r11.size()]), String[].class, "com.obric.aiagent.plugin");
        r0.writeShort(r14.length);
        int r15 = r14.length;
    L6:
        if (r3 >= r15) goto L8;
        r0.writeUTF(r14[r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        ArrayList r16 = new ArrayList(r12);
        r0.writeShort(r16.size());
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(1024);
        Iterator r5 = r16.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ZoneRules r18 = (ZoneRules) ZeusTransformUtils.preCheckCast(r5.next(), ZoneRules.class, "com.obric.aiagent.plugin");
        r17.reset();
        DataOutputStream r19 = new DataOutputStream(r17);
        Ser.write(r18, r19);
        r19.close();
        byte[] r20 = r17.toByteArray();
        r0.writeShort(r20.length);
        r0.write(r20);
        goto L10
    L12:
        Iterator r21 = r10.keySet().iterator();
    L14:
        if (r21.hasNext() == false) goto L19;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin");
        r0.writeShort(((SortedMap) ZeusTransformUtils.preCheckCast(r10.get(r22), SortedMap.class, "com.obric.aiagent.plugin")).size());
        Iterator r23 = ((SortedMap) ZeusTransformUtils.preCheckCast(r10.get(r22), SortedMap.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L17:
        if (r23.hasNext() == false) goto L14;
        Map.Entry r24 = (Map.Entry) ZeusTransformUtils.preCheckCast(r23.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r25 = Arrays.binarySearch(r14, r24.getKey());
        int r26 = r16.indexOf(r24.getValue());
        r0.writeShort(r25);
        r0.writeShort(r26);
        goto L17
    L19:
        r0.flush();
    }

    public TzdbZoneRulesCompiler(String r3, List<File> r4, File r5, boolean r6) {
        List<File> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.rules = new HashMap();
        this.zones = new HashMap();
        this.links = new HashMap();
        this.builtZones = new TreeMap();
        this.deduplicateMap = new HashMap();
        this.leapSeconds = new TreeMap();
        this.version = r3;
        this.sourceFiles = r7;
        this.leapSecondsFile = r5;
        this.verbose = r6;
    }

    public void compile() {
        printVerbose("Compiling TZDB version " + this.version);
        parseFiles();
        parseLeapSecondsFile();
        buildZoneRules();
        printVerbose("Compiled TZDB version " + this.version);
    }

    public SortedMap<String, ZoneRules> getZones() {
        return this.builtZones;
    }

    public SortedMap<LocalDate, Byte> getLeapSeconds() {
        return this.leapSeconds;
    }

    private LocalDate getMostRecentLeapSecond() {
        if (this.leapSeconds.isEmpty() == false) goto L6;
        return null;
    L6:
        return (LocalDate) ZeusTransformUtils.preCheckCast(this.leapSeconds.lastKey(), LocalDate.class, "com.obric.aiagent.plugin");
    }

    void setDeduplicateMap(Map<Object, Object> r3) {
        this.deduplicateMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    private void parseFiles() {
        Iterator<File> r0 = this.sourceFiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.aiagent.plugin");
        printVerbose("Parsing file: " + r1);
        parseFile(r1);
        goto L4
    }

    private void parseLeapSecondsFile() {
        printVerbose("Parsing leap second file: " + this.leapSecondsFile);
        BufferedReader r0 = null;
        String r1 = null;
        r1 = null;
        int r2 = 1;
        BufferedReader r3 = new BufferedReader(new FileReader(this.leapSecondsFile));     // Catch: Throwable -> L18 Exception -> L20
    L33:
        r1 = r3.readLine();     // Catch: Exception -> L16 Throwable -> L24
        if (r1 == null) goto L35;
        int r4 = r1.indexOf(35);     // Catch: Exception -> L16 Throwable -> L24
        if (r4 < 0) goto L10;
        r1 = r1.substring(0, r4);     // Catch: Exception -> L16 Throwable -> L24
    L10:
        if (r1.trim().length() == 0) goto L13;
        LeapSecondRule r5 = parseLeapSecondRule(r1);     // Catch: Exception -> L16 Throwable -> L24
        this.leapSeconds.put(r5.leapDate, Byte.valueOf(r5.secondAdjustment));     // Catch: Exception -> L16 Throwable -> L24
    L13:
        r2 = r2 + 1;
        goto L33
    L35:
        r3.close();     // Catch: Exception -> L29
        return;
    L42:
        return;
    L16:
        e = e;
    L23:
        throw new Exception("Failed while processing file '" + this.leapSecondsFile + "' on line " + r2 + " '" + r1 + "'", e);     // Catch: Throwable -> L24
    L24:
        th = th;
        r0 = r3;
    L26:
        if (r0 != null) goto L31;
    L28:
        throw th;
    L31:
        r0.close();     // Catch: Exception -> L30
        goto L28
    L20:
        e = e;
        r3 = null;
    L18:
        th = th;
        goto L26
    }

    private LeapSecondRule parseLeapSecondRule(String r4) {
        StringTokenizer r0 = new StringTokenizer(r4, " \t");
        if (r0.nextToken().equals("Leap") == false) goto L31;
        if (r0.countTokens() < 6) goto L28;
        LocalDate r3 = LocalDate.of(Integer.parseInt(r0.nextToken()), parseMonth(r0.nextToken()), Integer.parseInt(r0.nextToken()));
        String r5 = r0.nextToken();
        String r1 = r0.nextToken();
        if (r1.equals("+") == false) goto L14;
        if ("23:59:60".equals(r5) == false) goto L12;
        byte r6 = 1;
    L18:
        String r2 = r0.nextToken();
        if ("S".equalsIgnoreCase(r2) == false) goto L23;
        return new LeapSecondRule(r3, r6);
    L23:
        throw new IllegalArgumentException("Only stationary ('S') leap seconds are supported, not '" + r2 + "'");
    L12:
        throw new IllegalArgumentException("Leap seconds can only be inserted at 23:59:60 - Date:" + r3);
    L14:
        if (r1.equals("-") == false) goto L27;
        if ("23:59:59".equals(r5) == false) goto L25;
        r6 = -1;
        goto L18
    L25:
        throw new IllegalArgumentException("Leap seconds can only be removed at 23:59:59 - Date:" + r3);
    L27:
        throw new IllegalArgumentException("Invalid adjustment '" + r1 + "' in leap second rule for " + r3);
    L28:
        printVerbose("Invalid leap second line in file: " + this.leapSecondsFile + ", line: " + r4);
        throw new IllegalArgumentException("Invalid leap second line");
    L31:
        throw new IllegalArgumentException("Unknown line");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x016e: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:62:0x016e */
    private void parseFile(File r9) {
        int r0 = 1;
        BufferedReader r1 = null;
        String r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader(r9));     // Catch: Throwable -> L55 Exception -> L57
        ArrayList r4 = null;
        String r5 = null;
    L67:
        r5 = r3.readLine();     // Catch: Exception -> L53 Throwable -> L61
        if (r5 == null) goto L51;
        int r6 = r5.indexOf(35);     // Catch: Exception -> L53 Throwable -> L61
        if (r6 < 0) goto L11;
        r5 = r5.substring(0, r6);     // Catch: Exception -> L53 Throwable -> L61
    L11:
        if (r5.trim().length() == 0) goto L50;
        StringTokenizer r7 = new StringTokenizer(r5, " \t");     // Catch: Exception -> L53 Throwable -> L61
        if (r4 == null) goto L23;
        if (Character.isWhitespace(r5.charAt(0)) == false) goto L23;
        if (r7.hasMoreTokens() == false) goto L23;
        if (parseZoneLine(r7, r4) == false) goto L50;
    L21:
        r4 = null;
    L23:
        if (r7.hasMoreTokens() == false) goto L50;
        String r8 = r7.nextToken();     // Catch: Exception -> L53 Throwable -> L61
        if (r8.equals("Zone") == false) goto L35;
        if (r7.countTokens() < 3) goto L32;
        r4 = new ArrayList();     // Catch: Exception -> L53 Throwable -> L61
        this.zones.put(r7.nextToken(), r4);     // Catch: Exception -> L53 Throwable -> L61
        if (parseZoneLine(r7, r4) == false) goto L50;
    L32:
        printVerbose("Invalid Zone line in file: " + r9 + ", line: " + r5);     // Catch: Exception -> L53 Throwable -> L61
        throw new IllegalArgumentException("Invalid Zone line");     // Catch: Exception -> L53 Throwable -> L61
    L35:
        if (r8.equals("Rule") == false) goto L42;
        if (r7.countTokens() < 9) goto L39;
        parseRuleLine(r7);     // Catch: Exception -> L53 Throwable -> L61
        goto L21
    L39:
        printVerbose("Invalid Rule line in file: " + r9 + ", line: " + r5);     // Catch: Exception -> L53 Throwable -> L61
        throw new IllegalArgumentException("Invalid Rule line");     // Catch: Exception -> L53 Throwable -> L61
    L42:
        if (r8.equals("Link") == false) goto L49;
        if (r7.countTokens() < 2) goto L46;
        String r10 = r7.nextToken();     // Catch: Exception -> L53 Throwable -> L61
        this.links.put(r7.nextToken(), r10);     // Catch: Exception -> L53 Throwable -> L61
        goto L21
    L46:
        printVerbose("Invalid Link line in file: " + r9 + ", line: " + r5);     // Catch: Exception -> L53 Throwable -> L61
        throw new IllegalArgumentException("Invalid Link line");     // Catch: Exception -> L53 Throwable -> L61
    L49:
        throw new IllegalArgumentException("Unknown line");     // Catch: Exception -> L53 Throwable -> L61
    L50:
        r0 = r0 + 1;
        goto L67
    L51:
        r3.close();
        return;
    L53:
        e = e;
        r2 = r5;
    L60:
        throw new Exception("Failed while processing file '" + r9 + "' on line " + r0 + " '" + r2 + "'", e);     // Catch: Throwable -> L61
    L61:
        th = th;
        r1 = r2;
    L63:
        if (r1 == null) goto L65;
        r1.close();
    L65:
        throw th;
    L57:
        e = e;
    L55:
        th = th;
        goto L63
    }

    private void parseRuleLine(StringTokenizer r5) {
        TZDBRule r0 = new TZDBRule(this);
        String r1 = r5.nextToken();
        if (this.rules.containsKey(r1) == true) goto L5;
        this.rules.put(r1, new ArrayList());
    L5:
        ((List) ZeusTransformUtils.preCheckCast(this.rules.get(r1), List.class, "com.obric.aiagent.plugin")).add(r0);
        r0.startYear = parseYear(r5.nextToken(), 0);
        r0.endYear = parseYear(r5.nextToken(), r0.startYear);
        if (r0.startYear > r0.endYear) goto L10;
        parseOptional(r5.nextToken());
        parseMonthDayTime(r5, r0);
        r0.savingsAmount = parsePeriod(r5.nextToken());
        r0.text = parseOptional(r5.nextToken());
        return;
    L10:
        throw new IllegalArgumentException("Year order invalid: " + r0.startYear + " > " + r0.endYear);
    }

    private boolean parseZoneLine(StringTokenizer r5, List<TZDBZone> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        TZDBZone r0 = new TZDBZone(this);
        r7.add(r0);
        r0.standardOffset = parseOffset(r5.nextToken());
        String r8 = parseOptional(r5.nextToken());
        if (r8 != null) goto L16;
        r0.fixedSavingsSecs = 0;
        r0.savingsRule = null;
    L8:
        r0.text = r5.nextToken();
        if (r5.hasMoreTokens() == false) goto L14;
        r0.year = Year.of(Integer.parseInt(r5.nextToken()));
        if (r5.hasMoreTokens() == false) goto L13;
        parseMonthDayTime(r5, r0);
    L13:
        return false;
    L14:
        return true;
    L16:
        r0.fixedSavingsSecs = Integer.valueOf(parsePeriod(r8));     // Catch: Exception -> L7
        r0.savingsRule = null;     // Catch: Exception -> L7
    L7:
        r0.fixedSavingsSecs = null;
        r0.savingsRule = r8;
        goto L8
    }

    private void parseMonthDayTime(StringTokenizer r5, TZDBMonthDayTime r6) {
        r6.month = parseMonth(r5.nextToken());
        if (r5.hasMoreTokens() == false) goto L22;
        String r0 = r5.nextToken();
        int r2 = 0;
        if (r0.startsWith("last") == false) goto L7;
        r6.dayOfMonth = -1;
        r6.dayOfWeek = parseDayOfWeek(r0.substring(4));
        r6.adjustForwards = false;
    L15:
        if (r5.hasMoreTokens() == false) goto L23;
        String r7 = r5.nextToken();
        int r1 = parseSecs(r7);
        if (r1 != 86400) goto L19;
        r6.endOfDay = true;
    L20:
        r6.time = (LocalTime) ZeusTransformUtils.preCheckCast(deduplicate(LocalTime.ofSecondOfDay(r2)), LocalTime.class, "com.obric.aiagent.plugin");
        r6.timeDefinition = parseTimeDefinition(r7.charAt(r7.length() - 1));
        return;
    L19:
        r2 = r1;
        goto L20
    L23:
        return;
    L7:
        int r3 = r0.indexOf(">=");
        if (r3 <= 0) goto L10;
        r6.dayOfWeek = parseDayOfWeek(r0.substring(0, r3));
        r0 = r0.substring(r3 + 2);
    L13:
        r6.dayOfMonth = Integer.parseInt(r0);
        goto L15
    L10:
        int r4 = r0.indexOf("<=");
        if (r4 <= 0) goto L13;
        r6.dayOfWeek = parseDayOfWeek(r0.substring(0, r4));
        r6.adjustForwards = false;
        r0 = r0.substring(r4 + 2);
        goto L13
    }

    private int parseYear(String r2, int r3) {
        String r4 = r2.toLowerCase();
        if (matches(r4, "minimum") == false) goto L7;
        return Year.MIN_VALUE;
    L7:
        if (matches(r4, "maximum") == false) goto L11;
        return Year.MAX_VALUE;
    L11:
        if (r4.equals("only") == false) goto L14;
        return r3;
    L14:
        return Integer.parseInt(r4);
    }

    private Month parseMonth(String r6) {
        String r7 = r6.toLowerCase();
        Month[] r0 = Month.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Month r3 = r0[r2];
        if (matches(r7, r3.name().toLowerCase()) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Unknown month: " + r7);
    }

    private DayOfWeek parseDayOfWeek(String r6) {
        String r7 = r6.toLowerCase();
        DayOfWeek[] r0 = DayOfWeek.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        DayOfWeek r3 = r0[r2];
        if (matches(r7, r3.name().toLowerCase()) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Unknown day-of-week: " + r7);
    }

    private boolean matches(String r2, String r3) {
        if (r2.startsWith(r3.substring(0, 3)) == true) goto L5;
        return false;
    L5:
        if (r3.startsWith(r2) == true) goto L7;
        return false;
    L7:
        if (r2.length() > r3.length()) goto L12;
        return true;
    L12:
        return false;
    }

    private String parseOptional(String r1) {
        if (r1.equals("-") == false) goto L6;
        return null;
    L6:
        return r1;
    }

    private int parseSecs(String r11) {
        if (r11.equals("-") == false) goto L6;
        return 0;
    L6:
        boolean r10 = r11.startsWith("-");
        ParsePosition r0 = new ParsePosition(r10 ? 1 : 0);
        TemporalAccessor r1 = TIME_PARSER.parseUnresolved(r11, r0);
        if (r1 == null) goto L29;
        if (r0.getErrorIndex() >= 0) goto L29;
        long r2 = r1.getLong(ChronoField.HOUR_OF_DAY);
        Long r3 = null;
        if (r1.isSupported(ChronoField.MINUTE_OF_HOUR) == false) goto L13;
        Long r12 = Long.valueOf(r1.getLong(ChronoField.MINUTE_OF_HOUR));
    L15:
        if (r1.isSupported(ChronoField.SECOND_OF_MINUTE) == false) goto L17;
        r3 = Long.valueOf(r1.getLong(ChronoField.SECOND_OF_MINUTE));
    L17:
        long r4 = (r2 * 60) * 60;
        long r6 = 0;
        if (r12 == null) goto L20;
        long r8 = r12.longValue();
    L21:
        long r5 = r4 + (r8 * 60);
        if (r3 == null) goto L24;
        r6 = r3.longValue();
    L24:
        int r13 = (int) (r5 + r6);
        if (r10 == true) goto L27;
        return r13;
    L27:
        return -r13;
    L20:
        r8 = 0;
        goto L21
    L13:
        r12 = null;
    L29:
        throw new IllegalArgumentException(r11);
    }

    private ZoneOffset parseOffset(String r1) {
        return ZoneOffset.ofTotalSeconds(parseSecs(r1));
    }

    private int parsePeriod(String r1) {
        return parseSecs(r1);
    }

    private ZoneOffsetTransitionRule.TimeDefinition parseTimeDefinition(char r1) {
        if (r1 == 'G') goto L23;
        if (r1 == 'S') goto L21;
        if (r1 == 'U') goto L23;
        if (r1 == 'Z') goto L23;
        if (r1 == 'g') goto L23;
        if (r1 == 's') goto L21;
        if (r1 == 'u') goto L23;
        if (r1 == 'z') goto L23;
        return ZoneOffsetTransitionRule.TimeDefinition.WALL;
    L21:
        return ZoneOffsetTransitionRule.TimeDefinition.STANDARD;
    L23:
        return ZoneOffsetTransitionRule.TimeDefinition.UTC;
    }

    private void buildZoneRules() {
        Iterator<String> r0 = this.zones.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        printVerbose("Building zone " + r1);
        String r2 = (String) ZeusTransformUtils.preCheckCast(deduplicate(r1), String.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.zones.get(r2), List.class, "com.obric.aiagent.plugin");
        ZoneRulesBuilder r4 = new ZoneRulesBuilder();
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r4 = ((TZDBZone) ZeusTransformUtils.preCheckCast(r5.next(), TZDBZone.class, "com.obric.aiagent.plugin")).addToBuilder(r4, this.rules);
        goto L7
    L9:
        this.builtZones.put(r2, (ZoneRules) deduplicate(r4.toRules(r2, this.deduplicateMap)));
        goto L4
    L10:
        Iterator<String> r6 = this.links.keySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(deduplicate((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(this.links.get(r7), String.class, "com.obric.aiagent.plugin");
        printVerbose("Linking alias " + r7 + " to " + r8);
        ZoneRules r9 = (ZoneRules) ZeusTransformUtils.preCheckCast(this.builtZones.get(r8), ZoneRules.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L20;
        String r10 = (String) ZeusTransformUtils.preCheckCast(this.links.get(r8), String.class, "com.obric.aiagent.plugin");
        printVerbose("Relinking alias " + r7 + " to " + r10);
        r9 = (ZoneRules) ZeusTransformUtils.preCheckCast(this.builtZones.get(r10), ZoneRules.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L20;
        throw new IllegalArgumentException("Alias '" + r7 + "' links to invalid zone '" + r10 + "' for '" + this.version + "'");
    L20:
        this.builtZones.put(r7, r9);
        goto L12
    L21:
        this.builtZones.remove("UTC");
        this.builtZones.remove("GMT");
        this.builtZones.remove("GMT0");
        this.builtZones.remove("GMT+0");
        this.builtZones.remove("GMT-0");
    }

    <T> T deduplicate(T r2) {
        if (this.deduplicateMap.containsKey(r2) == true) goto L6;
        this.deduplicateMap.put(r2, r2);
    L6:
        return (T) this.deduplicateMap.get(r2);
    }

    private void printVerbose(String r1) {
        if (this.verbose == false) goto L6;
        System.out.println(r1);
        return;
    }
}
