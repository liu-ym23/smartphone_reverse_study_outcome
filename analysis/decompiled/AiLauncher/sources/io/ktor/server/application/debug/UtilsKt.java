package io.ktor.server.application.debug;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.server.application.debug.UtilsKt;
import io.ktor.util.debug.ContextUtilsKt;
import io.ktor.util.debug.plugins.PluginTraceElement;
import io.ktor.util.debug.plugins.PluginsTrace;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0080@¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0080@¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"", "pluginName", "handler", "LY8/t;", "ijDebugReportHandlerStarted", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "ijDebugReportHandlerFinished", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final Object ijDebugReportHandlerFinished(final String str, final String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objUseContextElementInDebugMode = ContextUtilsKt.useContextElementInDebugMode(PluginsTrace.INSTANCE, new InterfaceC5074l() { // from class: q8.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UtilsKt.ijDebugReportHandlerFinished$lambda$1(str, str2, (PluginsTrace) obj);
            }
        }, interfaceC4014c);
        return objUseContextElementInDebugMode == C4063a.g() ? objUseContextElementInDebugMode : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t ijDebugReportHandlerFinished$lambda$1(String str, String str2, PluginsTrace trace) {
        p.i(trace, "trace");
        trace.getEventOrder().add(new PluginTraceElement(str, str2, PluginTraceElement.PluginEvent.FINISHED));
        return t.f7040a;
    }

    public static final Object ijDebugReportHandlerStarted(final String str, final String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objUseContextElementInDebugMode = ContextUtilsKt.useContextElementInDebugMode(PluginsTrace.INSTANCE, new InterfaceC5074l() { // from class: q8.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UtilsKt.ijDebugReportHandlerStarted$lambda$0(str, str2, (PluginsTrace) obj);
            }
        }, interfaceC4014c);
        return objUseContextElementInDebugMode == C4063a.g() ? objUseContextElementInDebugMode : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t ijDebugReportHandlerStarted$lambda$0(String str, String str2, PluginsTrace trace) {
        p.i(trace, "trace");
        trace.getEventOrder().add(new PluginTraceElement(str, str2, PluginTraceElement.PluginEvent.STARTED));
        return t.f7040a;
    }
}
