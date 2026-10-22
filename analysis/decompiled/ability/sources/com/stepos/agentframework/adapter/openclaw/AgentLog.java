package com.stepos.agentframework.adapter.openclaw;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import com.stepos.agentframework.adapter.netcore.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000bJ)\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/AgentLog;", "", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "", "tag", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", BuildConfig.BUILD_TYPE, "(Ljava/lang/String;Ljava/lang/String;)V", "info", "warn", "", "throwable", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "openclaw_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AgentLog {
    private final ILogger logger;

    public AgentLog(ILogger logger) {
        k.f(logger, "logger");
        this.logger = logger;
    }

    public void debug(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        this.logger.d(tag, msg);
    }

    public void error(String tag, String msg, Throwable throwable) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        this.logger.e(tag, msg + " .throwable: " + (throwable != null ? throwable.getMessage() : null));
    }

    public void info(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        this.logger.i(tag, msg);
    }

    public void warn(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        this.logger.w(tag, msg);
    }
}
