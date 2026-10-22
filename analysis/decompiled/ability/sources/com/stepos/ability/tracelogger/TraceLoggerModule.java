package com.stepos.ability.tracelogger;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/stepos/ability/tracelogger/TraceLoggerModule;", "", AppAgent.CONSTRUCT, "()V", "bindTraceLogger", "Lcom/stepos/ability/tracelogger/ITraceLogger;", "impl", "Lcom/stepos/ability/tracelogger/TraceLogger;", "tracelogger_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@InstallIn({SingletonComponent.class})
/* loaded from: classes3.dex */
public abstract class TraceLoggerModule {
    @Singleton
    public abstract ITraceLogger bindTraceLogger(TraceLogger impl);
}
