package com.stepos.core.ability.speech.debug;

import android.os.SystemClock;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import com.stepos.core.common.debug.DebugInjectionGate;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manifest.ModelManifest;
import gc.o;
import gc.q;
import h0.e;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrStreamDebugInjector {
    private static final long TTL_MS = 300000;
    private static volatile Fault armedNextFeed;
    private static volatile long armedUntilMs;
    public static final AsrStreamDebugInjector INSTANCE = new AsrStreamDebugInjector();
    private static final Set<AsrCloudWsSession> sessions = Collections.newSetFromMap(new WeakHashMap());

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Fault {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Fault[] $VALUES;
        private final int code;
        private final String defaultMessage;
        public static final Fault RISK_BLOCKED = new Fault("RISK_BLOCKED", 0, AIEngineError.CLOUD_RISK_BLOCKED, "simulated risk_blocked");
        public static final Fault NETWORK = new Fault("NETWORK", 1, AIEngineError.CLOUD_NETWORK_UNAVAILABLE, "simulated network unavailable");
        public static final Fault SERVER = new Fault("SERVER", 2, AIEngineError.CLOUD_SERVER_ERROR, "simulated server error");

        private static final /* synthetic */ Fault[] $values() {
            return new Fault[]{RISK_BLOCKED, NETWORK, SERVER};
        }

        static {
            Fault[] faultArr$values = $values();
            $VALUES = faultArr$values;
            $ENTRIES = kotlin.enums.a.a(faultArr$values);
        }

        private Fault(String str, int i10, int i11, String str2) {
            this.code = i11;
            this.defaultMessage = str2;
        }

        public static a<Fault> getEntries() {
            return $ENTRIES;
        }

        public static Fault valueOf(String str) {
            return (Fault) Enum.valueOf(Fault.class, str);
        }

        public static Fault[] values() {
            return (Fault[]) $VALUES.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDefaultMessage() {
            return this.defaultMessage;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Mode {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode IMMEDIATE = new Mode("IMMEDIATE", 0);
        public static final Mode NEXT_FEED = new Mode("NEXT_FEED", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{IMMEDIATE, NEXT_FEED};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = kotlin.enums.a.a(modeArr$values);
        }

        private Mode(String str, int i10) {
        }

        public static a<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.IMMEDIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.NEXT_FEED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AsrStreamDebugInjector() {
    }

    private final void handleAsrSubArgs(List<String> list, PrintWriter printWriter) {
        Mode mode;
        String str = (String) kotlin.collections.a.v0(list);
        if (str == null || q.t0(str) || g.b(str, "help")) {
            printAsrUsage(printWriter);
            return;
        }
        Fault fault = parseFault(str);
        if (fault == null) {
            printWriter.println("ERROR: unknown asr fault '" + str + "'");
            printAsrUsage(printWriter);
            return;
        }
        if (list.isEmpty()) {
            mode = Mode.IMMEDIATE;
        } else {
            for (String str2 : list) {
                if (g.b(str2, "--next") || g.b(str2, "--next-feed")) {
                    mode = Mode.NEXT_FEED;
                    break;
                }
            }
            mode = Mode.IMMEDIATE;
        }
        printWriter.println(inject(fault, mode));
    }

    private final Fault parseFault(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        String strH0 = o.h0(lowerCase, '-', '_');
        switch (strH0.hashCode()) {
            case -2054838772:
                if (!strH0.equals("server_error")) {
                    return null;
                }
                return Fault.SERVER;
            case -1077300100:
                if (!strH0.equals("risk_blocked")) {
                    return null;
                }
                return Fault.RISK_BLOCKED;
            case -905826493:
                if (!strH0.equals("server")) {
                    return null;
                }
                return Fault.SERVER;
            case 3500751:
                if (!strH0.equals("risk")) {
                    return null;
                }
                return Fault.RISK_BLOCKED;
            case 1131920319:
                if (!strH0.equals("network_unavailable")) {
                    return null;
                }
                return Fault.NETWORK;
            case 1843485230:
                if (!strH0.equals("network")) {
                    return null;
                }
                return Fault.NETWORK;
            default:
                return null;
        }
    }

    private final void printAsrUsage(PrintWriter printWriter) {
        printWriter.println("inject asr usage:");
        printWriter.println("  risk_blocked | network | server  [--next]");
    }

    private final void printUsage(PrintWriter printWriter) {
        printWriter.println("inject usage (debug build only):");
        printWriter.println("  inject asr risk_blocked [--next]   simulate cloud risk_blocked (270007)");
        printWriter.println("  inject asr network [--next]        simulate CLOUD_NETWORK_UNAVAILABLE");
        printWriter.println("  inject asr server [--next]         simulate CLOUD_SERVER_ERROR");
        printWriter.println("  inject reset                       clear armed next-feed state");
        printWriter.println("  inject status                      show active sessions / armed fault");
        printWriter.println("  --next / --next-feed               fire on next PCM feed instead of immediately");
    }

    public final void clearForTest() {
        sessions.clear();
        reset();
    }

    public final void dump(PrintWriter writer) {
        String strName;
        g.f(writer, "writer");
        writer.println("AsrStreamDebugInjector:");
        DebugInjectionGate debugInjectionGate = DebugInjectionGate.INSTANCE;
        writer.println("  enabled=" + debugInjectionGate.isEnabled());
        writer.println("  compileTimeEnabled=" + debugInjectionGate.isCompileTimeEnabled());
        writer.println("  ro.build.type=" + debugInjectionGate.deviceBuildType());
        writer.println("  deviceInjectionAllowed=" + debugInjectionGate.isDeviceInjectionAllowed());
        writer.println("  activeSessions=" + sessions.size());
        Fault fault = armedNextFeed;
        if (fault == null || (strName = fault.name()) == null) {
            strName = ModelManifest.BACKEND_NONE;
        }
        writer.println("  armedNextFeed=".concat(strName));
        if (armedNextFeed != null) {
            long jElapsedRealtime = armedUntilMs - SystemClock.elapsedRealtime();
            if (jElapsedRealtime < 0) {
                jElapsedRealtime = 0;
            }
            e.j("  armedTtlMs=", jElapsedRealtime, writer);
        }
    }

    public final boolean fireNextFeedIfArmed(AsrCloudWsSession session) {
        g.f(session, "session");
        Fault fault = armedNextFeed;
        if (fault == null) {
            return false;
        }
        if (SystemClock.elapsedRealtime() > armedUntilMs) {
            armedNextFeed = null;
            return false;
        }
        armedNextFeed = null;
        session.injectRecoverableEvent$ability_release(fault.getCode(), fault.getDefaultMessage() + " (next-feed)");
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        if (r0.equals("help") == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleDumpArgs(java.util.List<java.lang.String> r3, java.io.PrintWriter r4) {
        /*
            r2 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.g.f(r3, r0)
            java.lang.String r0 = "writer"
            kotlin.jvm.internal.g.f(r4, r0)
            com.stepos.core.common.debug.DebugInjectionGate r0 = com.stepos.core.common.debug.DebugInjectionGate.INSTANCE
            boolean r1 = r0.isEnabled()
            if (r1 != 0) goto L2d
            java.lang.String r2 = r0.disabledReason()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "ERROR: injection disabled ("
            r3.<init>(r0)
            r3.append(r2)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r4.println(r2)
            return
        L2d:
            java.lang.Object r0 = kotlin.collections.a.v0(r3)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L94
            int r1 = r0.hashCode()
            switch(r1) {
                case -892481550: goto L69;
                case 96896: goto L57;
                case 3198785: goto L4e;
                case 108404047: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L71
        L3d:
            java.lang.String r1 = "reset"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L46
            goto L71
        L46:
            java.lang.String r2 = r2.reset()
            r4.println(r2)
            return
        L4e:
            java.lang.String r1 = "help"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L94
            goto L71
        L57:
            java.lang.String r1 = "asr"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L60
            goto L71
        L60:
            r0 = 1
            java.util.List r3 = kotlin.collections.a.p0(r0, r3)
            r2.handleAsrSubArgs(r3, r4)
            return
        L69:
            java.lang.String r1 = "status"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L90
        L71:
            r0 = 0
            java.lang.Object r3 = r3.get(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "ERROR: unknown inject subcommand '"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = "'"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.println(r3)
            r2.printUsage(r4)
            return
        L90:
            r2.dump(r4)
            return
        L94:
            r2.printUsage(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.debug.AsrStreamDebugInjector.handleDumpArgs(java.util.List, java.io.PrintWriter):void");
    }

    public final String inject(Fault fault, Mode mode) {
        g.f(fault, "fault");
        g.f(mode, "mode");
        DebugInjectionGate debugInjectionGate = DebugInjectionGate.INSTANCE;
        if (!debugInjectionGate.isEnabled()) {
            return a0.a.k("ERROR: injection disabled (", debugInjectionGate.disabledReason(), ")");
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            armedNextFeed = fault;
            armedUntilMs = SystemClock.elapsedRealtime() + 300000;
            return ai.onnxruntime.a.i("OK: armed ", sessions.size(), fault.name(), " on next feed for ", " registered session(s), TTL=300s [INJECTED]");
        }
        Set<AsrCloudWsSession> sessions2 = sessions;
        g.e(sessions2, "sessions");
        List listO0 = kotlin.collections.a.O0(sessions2);
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            ((AsrCloudWsSession) it.next()).injectRecoverableEvent$ability_release(fault.getCode(), fault.getDefaultMessage());
        }
        return ai.onnxruntime.a.i("OK: injected ", listO0.size(), fault.name(), " into ", " active session(s) [INJECTED]");
    }

    public final void register(AsrCloudWsSession session) {
        g.f(session, "session");
        if (DebugInjectionGate.INSTANCE.isEnabled()) {
            sessions.add(session);
        }
    }

    public final String reset() {
        armedNextFeed = null;
        armedUntilMs = 0L;
        return "OK: cleared armed inject state";
    }

    public final void unregister(AsrCloudWsSession session) {
        g.f(session, "session");
        sessions.remove(session);
    }
}
