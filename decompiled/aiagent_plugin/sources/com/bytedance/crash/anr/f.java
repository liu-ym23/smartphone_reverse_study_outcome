package com.bytedance.crash.anr;

import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.o.s;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnrProfiler.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7223a;

    /* JADX INFO: compiled from: AnrProfiler.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f7226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f7227b;

        private static Pair<Long, Long> b(JSONObject r9) {
            JSONObject r0 = r9.optJSONObject("logcat_anr_info");
            if (r0 == null) goto L9;
            long r3 = r0.optLong("cost");
            long r5 = r0.optLong("longMsgEnd");
            if (r3 < 1000) goto L9;
            if (r5 <= r3) goto L9;
            long r4 = r5 - r3;
        L11:
            if (r4 != (-1)) goto L16;
            JSONObject r10 = r9.optJSONObject("history_details");
            if (r10 == null) goto L16;
            r4 = r10.optLong("longestMsgStartWallTime");
            r5 = r10.optLong("longestMsgEndWallTime");
        L16:
            return new Pair(Long.valueOf(r4), Long.valueOf(r5));
        L9:
            r4 = -1;
            r5 = -1;
            goto L11
        }

        long[] a(JSONObject r8, i r9, d r10) {
            long[] r7 = new long[9];
            int r2 = 0;
            r7[0] = r8.optLong("crash_time");
            Pair<Long, Long> r0 = b(r8);
            r7[2] = ((Long) ZeusTransformUtils.preCheckCast(r0.first, Long.class, "com.obric.aiagent.plugin")).longValue();
            r7[1] = ((Long) ZeusTransformUtils.preCheckCast(r0.second, Long.class, "com.obric.aiagent.plugin")).longValue();
            if (r10.c() == false) goto L8;
            long r1 = 4294967296L;
            if (r10.f7194c == null) goto L7;
            r1 = 4294967296L | ((long) ((int) r10.f7194c.s));
        L7:
            r7[3] = r1;
        L8:
            JSONObject r11 = r8.optJSONObject("app_memory_info");
            long r3 = 0;
            if (r11 != null) goto L11;
        L13:
            long r5 = 0;
        L15:
            if (r5 > 0) goto L17;
        L18:
            r5 = (Runtime.getRuntime().maxMemory() / 1024) / 1024;
        L19:
            r7[4] = r5;
            if (r9.a() == true) goto L22;
        L37:
            JSONObject r12 = r8.optJSONObject("logcat_gc_info");
            if (r12 == null) goto L40;
            r2 = r12.optInt("gcScore");
        L40:
            r7[8] = r2;
            return r7;
        L22:
            if (r9.h() == false) goto L24;
            long r6 = 2;
        L25:
            long r4 = 1 | r6;
            if (r9.g() == false) goto L28;
            long r13 = 4;
        L29:
            long r14 = r4 | r13;
            if (r9.e() == false) goto L32;
            long r15 = 8;
        L33:
            long r16 = r14 | r15;
            if (r9.f() == false) goto L36;
            r3 = 16;
        L36:
            r7[5] = r16 | r3;
            r7[6] = r9.c();
            r7[7] = r9.d();
            goto L37
        L32:
            r15 = 0;
            goto L33
        L28:
            r13 = 0;
            goto L29
        L24:
            r6 = 0;
            goto L25
        L17:
            if (r5 <= 1024) goto L19;
        L11:
            if (r11.has("max_memory") == false) goto L13;
            r5 = (r11.optLong("max_memory") / 1024) / 1024;
            goto L15
        }

        a(File r2, JSONObject r3, i r4, d r5) {
            this.f7227b = false;
            this.f7226a = r2;
            NativeBridge.nAnrNativeProfilerFormat(r2 + "/anr_profiler.inf", a(r3, r4, r5));
        }

        private void a(JSONObject r31, String r32) {
            Matcher r1 = Pattern.compile("^ Exec \\d+\\.\\d+\\((\\d+)%\\), Wait (.*), Sleep (.*), IOWait (.*)$").matcher(r32);
            if (r1.find() == false) goto L23;
            char r3 = 4;
            if (r1.groupCount() != 4) goto L27;
            s r2 = new s("%");
            r2.a(new Long[]{0L, 1L, 10L, 25L, 50L, 75L, 100L});
            l.a(r31, "npth_profiler_exec_ratio", r2.a(Integer.parseInt(r1.group(1))));
            String[] r5 = {"wait_ratio", "sleep_ratio", "iowait_ratio"};
            int r8 = 0;
        L8:
            if (r8 >= 3) goto L28;
            String r13 = r1.group(r8 + 2);
            String r14 = "---";
            if ("---".equals(r13) == true) goto L20;
            Matcher r4 = Pattern.compile("^\\d+\\.\\d+\\((\\d+)%\\)$").matcher(r13);
            if (r4.find() == true) goto L14;
        L19:
            char r28 = 4;
        L22:
            l.a(r31, "npth_profiler_" + r5[r8], r14);
            r8 = r8 + 1;
            r3 = r28;
            goto L8
        L14:
            if (r4.groupCount() != 1) goto L19;
            if (r8 != 2) goto L17;
            r28 = 4;
            r2.a(new Long[]{0L, 1L, 5L, 10L, 25L, 50L, 75L, 100L});
        L18:
            r14 = r2.a(Integer.parseInt(r4.group(1)));
            goto L22
        L17:
            r28 = 4;
            goto L18
        L20:
            r28 = r3;
            goto L22
        L28:
            return;
        L27:
            return;
        }

        private void b(JSONObject r6, String r7) {
            Matcher r5 = Pattern.compile("^ (\\d+)\\.\\d{2} \\(.*\\)$").matcher(r7);
            if (r5.find() == true) goto L5;
            return;
        L5:
            if (r5.groupCount() != 1) goto L10;
            int r8 = Integer.parseInt(r5.group(1));
            s r9 = new s("");
            r9.a(new Long[]{0L, 4L, 10L, 30L, 60L, 100L, 150L, 200L});
            l.a(r6, "npth_profiler_loads", r9.a(r8));
            return;
        }

        private void c(JSONObject r11, String r12) {
            Matcher r10 = Pattern.compile("^ (\\d{1,2})% (.+)$").matcher(r12);
            if (r10.find() == true) goto L6;
            l.a(r11, "npth_profiler_cpu_efficiency", "unavailable");
            return;
        L6:
            int r1 = Integer.parseInt(r10.group(1));
            s r9 = new s("%");
            r9.a(0, 100, 10);
            l.a(r11, "npth_profiler_cpu_efficiency", r9.a(r1));
            Matcher r13 = Pattern.compile("\\[(\\d+\\.\\d+)-\\d+\\.\\d+\\]\\{([\\d-]+)\\}(?:,\\\\s*)?").matcher(r10.group(2));
            double r2 = 0.0d;
        L8:
            if (r13.find() == false) goto L16;
            double r3 = Double.parseDouble(r13.group(1));
            String r5 = r13.group(2);
            if (r5 != null) goto L12;
        L14:
            int r6 = 1;
        L15:
            r2 = r2 + (r3 * ((double) r6));
            goto L8
        L12:
            if (r5.contains("-") == false) goto L14;
            String[] r7 = r5.split("-");
            r6 = (Integer.parseInt(r7[1]) - Integer.parseInt(r7[0])) + 1;
            goto L15
        L16:
            l.a(r11, "npth_profiler_cpu_total_power", Long.valueOf((long) r2));
        }

        private void d(JSONObject r12, String r13) {
            Matcher r11 = Pattern.compile("^ Thread \\d+ = (\\d+) \\+ (\\d+), Process \\d+ = (\\d+) \\+ (\\d+)$").matcher(r13);
            if (r11.find() == true) goto L5;
            return;
        L5:
            if (r11.groupCount() != 4) goto L18;
            int r1 = Integer.parseInt(r11.group(1));
            int r3 = Integer.parseInt(r11.group(2));
            int r5 = Integer.parseInt(r11.group(3));
            int r14 = Integer.parseInt(r11.group(4));
            s r6 = new s("%");
            r6.a(new Long[]{0L, 1L, 10L, 25L, 50L, 75L, 100L});
            int r15 = r14 + r5;
            if (r15 == 0) goto L10;
            l.a(r12, "npth_profiler_jiff_thread_ratio", r6.a(((r1 + r3) * 100) / r15));
        L10:
            int r4 = r3 + r1;
            if (r4 == 0) goto L13;
            l.a(r12, "npth_profiler_jiff_thread_user_ratio", r6.a((r1 * 100) / r4));
        L13:
            if (r15 == 0) goto L17;
            l.a(r12, "npth_profiler_jiff_process_user_ratio", r6.a((r5 * 100) / r15));
            return;
        L17:
            return;
        }

        private void e(JSONObject r9, String r10) {
            Matcher r8 = Pattern.compile("^ Thread (\\d+) (\\d+), Process (\\d+) (\\d+)$").matcher(r10);
            if (r8.find() == true) goto L5;
            return;
        L5:
            if (r8.groupCount() != 4) goto L12;
            s r11 = new s("");
            int r3 = 0;
            r11.a(new Long[]{0L, 1L, 10L, 100L, 1000L, 10000L, 100000L});
            String[] r1 = {"thread_minor", "thread_major", "process_minor", "process_major"};
        L8:
            if (r3 >= 4) goto L13;
            int r2 = r3 + 1;
            l.a(r9, "npth_profiler_fault_" + r1[r3], r11.a(Long.parseLong(r8.group(r2))));
            r3 = r2;
            goto L8
        L13:
            return;
        }

        private void f(JSONObject r8, String r9) {
            Matcher r7 = Pattern.compile("^ VSS \\d+\\([+-]\\d+\\)MB, RSS (\\d+)\\([+-]\\d+\\)MB, SWAP (\\d+)\\([+-]\\d+\\)MB$").matcher(r9);
            if (r7.find() == true) goto L5;
            return;
        L5:
            if (r7.groupCount() != 2) goto L10;
            long r1 = Long.parseLong(r7.group(1)) + Long.parseLong(r7.group(2));
            s r10 = new s("MB");
            r10.a(new Long[]{0L, 1L, 64L, 128L, 256L, 512L, 768L, 1024L, 1536L, Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)});
            l.a(r8, "npth_profiler_procram_total", r10.a(r1));
            return;
        }

        private void g(JSONObject r30, String r31) {
            Matcher r1 = Pattern.compile("^ Total (\\d+)MB, Used \\d+\\([+-]\\d+\\)MB, Free \\d+\\([+-]\\d+\\)MB, Swapped (\\d+)\\(([+-])(\\d+)\\)MB$").matcher(r31);
            if (r1.find() == true) goto L5;
            return;
        L5:
            if (r1.groupCount() != 4) goto L10;
            long r4 = Long.parseLong(r1.group(1));
            long r7 = Long.parseLong(r1.group(2));
            String r10 = r1.group(3);
            long r11 = Long.parseLong(r1.group(4));
            l.a(r30, "npth_profiler_sysram_total_size", ((r4 / 1024) + 1) + "GB");
            s r2 = new s("MB");
            r2.a(new Long[]{0L, 1L, 128L, 256L, 512L, 1024L, 1536L, Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH), 3072L, Long.valueOf(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)});
            l.a(r30, "npth_profiler_sysram_swapped_size", r2.a(r7));
            r2.a(new Long[]{0L, 1L, 16L, 32L, 64L, 128L, 256L, 512L});
            l.a(r30, "npth_profiler_sysram_swapped_delta", r10 + " " + r2.a(r11));
            return;
        }

        private void h(JSONObject r30, String r31) {
            Matcher r1 = Pattern.compile("^ JavaHeap \\d+MB, Time (\\d+)\\.(\\d+), BlockTime (\\d+)\\.(\\d+), Count (\\d+), BlockCount (\\d+), MainWaitGcTime (\\d+)\\.(\\d+), MainGcTime (\\d+)\\.(\\d+)$").matcher(r31);
            if (r1.find() == true) goto L5;
            return;
        L5:
            if (r1.groupCount() != 10) goto L10;
            long r4 = (Long.parseLong(r1.group(1)) * 1000) + Long.parseLong(r1.group(2));
            long r10 = (Long.parseLong(r1.group(3)) * 1000) + Long.parseLong(r1.group(4));
            long r14 = Long.parseLong(r1.group(5));
            long r13 = Long.parseLong(r1.group(6));
            long r12 = (Long.parseLong(r1.group(7)) * 1000) + Long.parseLong(r1.group(8));
            long r9 = (Long.parseLong(r1.group(9)) * 1000) + Long.parseLong(r1.group(10));
            s r3 = new s("ms");
            r3.a(new Long[]{0L, 1L, 500L, 1000L, 1500L, 2000L, Long.valueOf(WsConstants.EXIT_DELAY_TIME), 5000L});
            l.a(r30, "npth_profiler_gc_time", r3.a(r4));
            l.a(r30, "npth_profiler_gc_block_time", r3.a(r10));
            l.a(r30, "npth_profiler_main_wait_gc_time", r3.a(r12));
            l.a(r30, "npth_profiler_main_gc_time", r3.a(r9));
            s r5 = new s("");
            r5.a(new Long[]{0L, 1L, 5L, 10L, 50L, 100L});
            l.a(r30, "npth_profiler_gc_count", r5.a(r14));
            l.a(r30, "npth_profiler_gc_block_count", r5.a(r13));
            return;
        }

        private void i(JSONObject r2, String r3) {
            Matcher r1 = Pattern.compile("^ JavaLock (.*)$").matcher(r3);
            if (r1.find() == true) goto L5;
            return;
        L5:
            if (r1.groupCount() != 1) goto L10;
            l.a(r2, "npth_profiler_java_lock_owner", r1.group(1));
            return;
        }

        private void j(JSONObject r1, String r2) {
            l.a(r1, "npth_profiler_anr_reason", r2.trim());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(JSONObject r13) {
            File r1 = new File(this.f7226a + "/anr_profiler.txt");
            if (r1.exists() == true) goto L5;
            return;
        L5:
            BufferedReader r2 = null;
            String r3 = null;
            BufferedReader r4 = new BufferedReader(new FileReader(r1));     // Catch: Throwable -> L85
            Object[] r5 = false;
            String r6 = null;
        L90:
            String r7 = r4.readLine();     // Catch: Throwable -> L80
            if (r7 == null) goto L79;
            String[] r8 = r7.split(">");     // Catch: Throwable -> L80
            byte r9 = 2;
            if (r8.length != 2) goto L12;
            String r10 = r8[0].trim();     // Catch: Throwable -> L80
            switch(r10.hashCode()) {
                case -1771995437: goto L56;
                case -1427608066: goto L53;
                case -1276471214: goto L50;
                case -1209385580: goto L47;
                case -892691330: goto L44;
                case -523188726: goto L41;
                case -315273688: goto L38;
                case 1317675854: goto L35;
                case 1367485235: goto L32;
                case 2060837732: goto L29;
                case 2064264317: goto L26;
                case 2066285238: goto L23;
                case 2072399136: goto L20;
                default: goto L58;
            };     // Catch: Throwable -> L83
        L58:
            r9 = -1;
        L59:
            switch(r9) {
                case 0: goto L73;
                case 1: goto L72;
                case 2: goto L71;
                case 3: goto L70;
                case 4: goto L69;
                case 5: goto L68;
                case 6: goto L67;
                case 7: goto L66;
                case 8: goto L64;
                case 9: goto L65;
                case 10: goto L63;
                case 11: goto L62;
                case 12: goto L61;
                default: goto L90;
            };     // Catch: Throwable -> L83
        L61:
            r5 = false;
            goto L90
        L62:
            r5 = true;
            goto L90
        L63:
            g(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L64:
            j(r13, r8[1]);     // Catch: Throwable -> L83
        L65:
            f(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L66:
            i(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L67:
            h(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L68:
            e(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L69:
            c(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L70:
            d(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L71:
            a(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L72:
            b(r13, r8[1]);     // Catch: Throwable -> L83
            goto L90
        L73:
            Pair r11 = f.a(r8[1]);     // Catch: Throwable -> L83
            if (r11 == null) goto L90;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.second, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L83
            r3 = (String) ZeusTransformUtils.preCheckCast(r11.first, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        L78:
            r6 = r12;
            goto L90
        L20:
            if (r10.equals("CPU_SCHED") == false) goto L58;
        L23:
            if (r10.equals("CPU_LOADS") == false) goto L58;
            r9 = 1;
            goto L59
        L26:
            if (r10.equals("CPU_JIFFS") == false) goto L58;
            r9 = 3;
            goto L59
        L29:
            if (r10.equals("CPU_FREQS") == false) goto L58;
            r9 = 4;
            goto L59
        L32:
            if (r10.equals("JVM_STATE") == false) goto L58;
            r9 = 7;
            goto L59
        L35:
            if (r10.equals("GC_STATE") == false) goto L58;
            r9 = 6;
            goto L59
        L38:
            if (r10.equals("SCHED_STREAM") == false) goto L58;
            r9 = 11;
            goto L59
        L41:
            if (r10.equals("PROC_MEMORY") == false) goto L58;
            r9 = 9;
            goto L59
        L44:
            if (r10.equals("MEMORY_STREAM") == false) goto L58;
            r9 = 12;
            goto L59
        L47:
            if (r10.equals("DURATION") == false) goto L58;
            r9 = 0;
            goto L59
        L50:
            if (r10.equals("PAGE_FAULT") == false) goto L58;
            r9 = 5;
            goto L59
        L53:
            if (r10.equals("ANR_REASON") == false) goto L58;
            r9 = 8;
            goto L59
        L56:
            if (r10.equals("SYS_MEMORY") == false) goto L58;
            r9 = 10;
            goto L59
        L12:
            if (r5 == false) goto L90;
            a(r13, r7, r3, r6);     // Catch: Throwable -> L80
            goto L90
        L79:
            com.bytedance.crash.o.i.a(r4);
            return;
        L80:
            r2 = r4;
        L81:
            com.bytedance.crash.o.i.a(r2);
        }

        public void a(JSONObject r3, File r4) {
            String r0 = com.bytedance.crash.o.i.d(new File(r4, "anr_ml_features.json"));
            if (r0 == null) goto L18;
            l.b(r3, new JSONObject(r0));     // Catch: Throwable -> L14
        L18:
            String r5 = j.d(new File(r4, "/anr_profiler.txt"));     // Catch: Throwable -> L15
            l.a(r3, "anr_profiler", r5);     // Catch: Throwable -> L15
            if (r5.isEmpty() == false) goto L8;
            return;
        L8:
            if (r5.length() <= 10) goto L21;
            JSONObject r6 = r3.optJSONObject("filters");     // Catch: Throwable -> L15
            if (r6 != null) goto L12;
            r6 = new JSONObject();     // Catch: Throwable -> L15
            r3.put("filters", r6);     // Catch: Throwable -> L15
        L12:
            l.a(r6, "has_anr_profiler", "true");     // Catch: Throwable -> L15
            return;
        L21:
            return;
        }

        private void a(JSONObject r9, String r10, String r11, String r12) {
            if (this.f7227b == false) goto L44;
            return;
        L44:
            String[] r13 = r10.trim().split(" ");     // Catch: Throwable -> L33
            boolean r0 = false;
            String r1 = r13[0];     // Catch: Throwable -> L33
            int r3 = Integer.parseInt(r13[3]);     // Catch: Throwable -> L33
            if (r1.startsWith(r11) == false) goto L28;
            if (r9.has("lifecycle_from_adj") == false) goto L42;
            boolean r14 = r9.optBoolean("is_background_from_adj");     // Catch: Throwable -> L33
            if (r3 <= 200) goto L13;
            r0 = true;
        L13:
            StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L33
            String r2 = "b";
            if (r0 == false) goto L17;
            String r4 = "b";
        L18:
            r15.append(r4);     // Catch: Throwable -> L33
            r15.append("_");     // Catch: Throwable -> L33
            if (r14 == true) goto L22;
            r2 = com.bytedance.apm.util.f.f4978a;
        L22:
            r15.append(r2);     // Catch: Throwable -> L33
            r9.put("anr_process_lifecycle", r15);     // Catch: Throwable -> L33
            goto L42
        L17:
            r4 = com.bytedance.apm.util.f.f4978a;
        L42:
            r9.put("npth_profiler_main_nice", String.valueOf(r13[4]));     // Catch: Throwable -> L36
        L47:
            r9.put("npth_profiler_main_group", r13[2]);     // Catch: Throwable -> L37
        L40:
            r9.put("npth_profiler_process_adj", r13[3]);     // Catch: Throwable -> L38
        L26:
            this.f7227b = true;     // Catch: Throwable -> L33
            return;
        L28:
            if (r1.startsWith(r12) == false) goto L50;
            if (r3 <= 200) goto L45;
            r0 = true;
        L45:
            r9.put("is_background_from_adj", r0);     // Catch: Throwable -> L39
            r9.put("lifecycle_from_adj", 1);     // Catch: Throwable -> L39
            return;
        L52:
            return;
        L50:
            return;
        L33:
            th = move-exception;
            com.bytedance.crash.c.b.b("pushLifecycleFilters", th);
        }
    }

    public f() {
    }

    static /* synthetic */ long a(f r0, long r1) {
        r0.f7223a = r1;
        return r1;
    }

    static /* synthetic */ Pair a(String r0) {
        return b(r0);
    }

    public void a() {
        DefaultWorkThread.post(new AnonymousClass1(this));
    }

    public static void a(boolean r0) {
        if (r0 == true) goto L4;
        return;
    L4:
        DefaultWorkThread.post(new AnonymousClass2());
    }

    public static synchronized void b() {
        monitor-enter(f.class);
        Thread r1 = Looper.getMainLooper().getThread();     // Catch: Throwable -> L10
        Field r2 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L10
        r2.setAccessible(true);     // Catch: Throwable -> L10
        int r3 = NativeBridge.nAnrNativeProfilerJvmStart(r2.getLong(r1));     // Catch: Throwable -> L10
        int r4 = NativeBridge.l();     // Catch: Throwable -> L10
        int r5 = NativeBridge.m();     // Catch: Throwable -> L10
        com.bytedance.crash.monitor.a r6 = com.bytedance.crash.monitor.h.a();     // Catch: Throwable -> L10
        if (r6 == null) goto L7;
        r6.a("jvm_monitor_state", String.valueOf(r4));     // Catch: Throwable -> L10
        r6.a("apex_version", String.valueOf(r5));     // Catch: Throwable -> L10
    L7:
        r.a("setMonitorJvm " + r3 + ", " + r4);     // Catch: Throwable -> L10
    L8:
        monitor-exit(f.class);
    }

    public void c() {
        long r0 = this.f7223a;
        if (r0 == 0) goto L6;
        NativeBridge.nAnrNativeProfilerExit(r0);
        return;
    }

    public void a(File r5, long r6) {
        long r0 = this.f7223a;
        if (r0 == 0) goto L6;
        NativeBridge.nAnrNativeProfilerDump(r0, r5 + "/anr_profiler.inf", r6);
        return;
    }

    private static Pair<String, String> b(String r4) {
        int r0 = r4.indexOf(40);     // Catch: Exception -> L5
        int r1 = r4.lastIndexOf(41);     // Catch: Exception -> L5
        int r2 = r4.indexOf("to");     // Catch: Exception -> L5
        return new Pair(r4.substring(r0 + 12, r2 - 5), r4.substring(r2 + 14, r1 - 4));
    L5:
        e = move-exception;
        com.bytedance.crash.c.b.b("getANRTime", e);
        return null;
    }
}
