package com.obric.agent.trace.toolmetrics;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IOmniClientToolTraceService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IOmniClientToolTraceService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IOmniClientToolTraceService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15861a = null;

        static {
            f15861a = new a();
        }

        private a() {
        }

        public final IOmniClientToolTraceService a() {
            return (IOmniClientToolTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniClientToolTraceService.class), IOmniClientToolTraceService.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f15861a;
    }

    void append(z r1, n r2);

    z begin();

    void cancel(z r1);

    z findByMessageId(String r1);

    void finish(z r1);

    void initialize();

    void markCorePoint(z r1, j r2);

    void markProgress(z r1, String r2);
}
