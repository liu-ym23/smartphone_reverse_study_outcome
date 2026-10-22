package com.stepos.core.common.cloudconfig;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.BaseDumpProvider;
import com.stepos.core.common.log.LogModule;
import java.io.PrintWriter;
import java.util.Iterator;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConfigDumpProvider extends BaseDumpProvider {
    public CloudConfigDumpProvider() {
        super("CloudConfig", LogModule.CLOUDCONFIG);
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider
    public void dumpContent(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        Iterator<T> it = CloudConfigManager.INSTANCE.dump().iterator();
        while (it.hasNext()) {
            writer.println((String) it.next());
        }
        writer.println();
        writer.println("--- 日志流水 (LogModule.CLOUDCONFIG; --last=N / --level=WARN 可过滤) ---");
        AIEngineLogger.dumpModuleLogs(writer, getLogModule(), args);
    }

    @Override // com.stepos.core.common.log.BaseDumpProvider, com.stepos.core.common.log.IDumpProvider
    public String getHelp() {
        return "CloudConfig: 订阅状态 / 推送计数 / 落盘 version+sha / 生效明细 / 跨重启 marker / 日志流水";
    }
}
