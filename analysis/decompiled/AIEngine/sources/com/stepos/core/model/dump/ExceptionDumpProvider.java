package com.stepos.core.model.dump;

import a0.a;
import com.stepos.core.common.debug.DebugInjectionGate;
import com.stepos.core.common.log.IDumpProvider;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.EmsReporter;
import com.stepos.core.common.telemetry.ExceptionLogStore;
import com.stepos.core.ota.d;
import gc.o;
import gc.q;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExceptionDumpProvider implements IDumpProvider {
    private final String moduleName = "Exception";
    private final LogModule logModule = LogModule.MODEL;

    private final void dumpClear(PrintWriter printWriter) {
        if (!DebugInjectionGate.INSTANCE.isDeviceInjectionAllowed()) {
            printWriter.println("--exp-clear is debug-build only");
            return;
        }
        printWriter.println("cleared " + ExceptionLogStore.INSTANCE.clear() + " snapshot(s)");
    }

    private final void dumpLast(PrintWriter printWriter) {
        String lastJson = ExceptionLogStore.INSTANCE.readLastJson();
        if (lastJson == null) {
            lastJson = "{}";
        }
        printWriter.println(lastJson);
    }

    private final void dumpOne(PrintWriter printWriter, String str) {
        String json = ExceptionLogStore.INSTANCE.readJson(str);
        if (json == null) {
            json = "{}";
        }
        printWriter.println(json);
    }

    private final void dumpOverview(PrintWriter printWriter) {
        printWriter.println("=== Inference Exception Snapshots ===");
        dumpSummaryLine(printWriter);
        printWriter.println();
        List<File> listListSnapshots = ExceptionLogStore.INSTANCE.listSnapshots();
        if (listListSnapshots.isEmpty()) {
            printWriter.println("(none)");
            return;
        }
        printWriter.println("expLogId | bytes | lastModified");
        for (File file : listListSnapshots) {
            String name = file.getName();
            g.e(name, "getName(...)");
            String strA0 = q.A0(name, ".json");
            long length = file.length();
            long jLastModified = file.lastModified();
            StringBuilder sbL = d.l("  ", length, strA0, " | ");
            sbL.append(" | ");
            sbL.append(jLastModified);
            printWriter.println(sbL.toString());
        }
    }

    private final void dumpSummaryLine(PrintWriter printWriter) {
        List<File> listListSnapshots = ExceptionLogStore.INSTANCE.listSnapshots();
        Pair<Long, Long> pairEmsExceptionStats = EmsReporter.INSTANCE.emsExceptionStats();
        long jLongValue = pairEmsExceptionStats.f9985a.longValue();
        long jLongValue2 = pairEmsExceptionStats.f9986b.longValue();
        int size = listListSnapshots.size();
        Iterator<T> it = listListSnapshots.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += ((File) it.next()).length();
        }
        long suppressedCount = ExceptionLogStore.INSTANCE.getSuppressedCount();
        StringBuilder sb2 = new StringBuilder("Inference exceptions: snapshots=");
        sb2.append(size);
        sb2.append(" bytes=");
        sb2.append(length);
        a.s(suppressedCount, " suppressed=", " emsOk=", sb2);
        sb2.append(jLongValue);
        sb2.append(" emsFail=");
        sb2.append(jLongValue2);
        printWriter.println(sb2.toString());
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dump(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        if (l.a0("--exp", args)) {
            dumpOverview(writer);
            return;
        }
        if (l.a0("--exp-last", args)) {
            dumpLast(writer);
            return;
        }
        if (l.a0("--exp-clear", args)) {
            dumpClear(writer);
            return;
        }
        for (String str : args) {
            if (o.k0(str, "--exp=", false)) {
                for (String str2 : args) {
                    if (o.k0(str2, "--exp=", false)) {
                        dumpOne(writer, q.z0(str2, "--exp="));
                        return;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
        dumpSummaryLine(writer);
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        dumpSummaryLine(writer);
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "Inference exceptions: --exp, --exp-last, --exp=<expLogId>, --exp-clear (debug only)";
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public LogModule getLogModule() {
        return this.logModule;
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public String getModuleName() {
        return this.moduleName;
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public boolean supportsArg(String arg) {
        g.f(arg, "arg");
        return o.k0(arg, "--exp", false);
    }
}
