package com.stepos.core.common.log;

import com.stepos.core.common.log.IDumpProvider;
import gc.q;
import java.io.PrintWriter;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SimpleDumpProvider implements IDumpProvider {
    private final zb.a<String> contentProvider;
    private final LogModule logModule;
    private final String moduleName;

    public SimpleDumpProvider(String moduleName, LogModule logModule, zb.a<String> contentProvider) {
        g.f(moduleName, "moduleName");
        g.f(logModule, "logModule");
        g.f(contentProvider, "contentProvider");
        this.moduleName = moduleName;
        this.logModule = logModule;
        this.contentProvider = contentProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0() {
        return "";
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dump(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        writer.println("----- " + getModuleName() + " -----");
        String strInvoke = this.contentProvider.invoke();
        if (!q.t0(strInvoke)) {
            writer.println(strInvoke);
        }
        AIEngineLogger.dumpModuleLogs(writer, getLogModule(), args);
        writer.println();
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        int moduleStats = AIEngineLogger.getModuleStats(getLogModule());
        writer.println(getModuleName() + ": " + moduleStats + " logs");
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return IDumpProvider.DefaultImpls.getHelp(this);
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
    public boolean supportsArg(String str) {
        return IDumpProvider.DefaultImpls.supportsArg(this, str);
    }

    public /* synthetic */ SimpleDumpProvider(String str, LogModule logModule, zb.a aVar, int i10, e eVar) {
        this(str, logModule, (i10 & 4) != 0 ? new a9.a(10) : aVar);
    }
}
