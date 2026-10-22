package com.stepos.core.common.log;

import com.stepos.core.common.log.IDumpProvider;
import java.io.PrintWriter;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BaseDumpProvider implements IDumpProvider {
    private final LogModule logModule;
    private final String moduleName;

    public BaseDumpProvider(String moduleName, LogModule logModule) {
        g.f(moduleName, "moduleName");
        g.f(logModule, "logModule");
        this.moduleName = moduleName;
        this.logModule = logModule;
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dump(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        writer.println("----- " + getModuleName() + " -----");
        dumpContent(writer, args);
        writer.println();
    }

    public abstract void dumpContent(PrintWriter printWriter, String[] strArr);

    @Override // com.stepos.core.common.log.IDumpProvider
    public void dumpStats(PrintWriter writer) {
        g.f(writer, "writer");
        writer.println(getModuleName() + ": No statistics available");
    }

    @Override // com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return a0.a.j(getModuleName(), ": Basic dump provider");
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
}
