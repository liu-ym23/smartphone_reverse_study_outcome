package com.obric.aiagent.skill.virt.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtReporting.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface VirtReportSink {
    public static final a Companion = null;

    /* JADX INFO: compiled from: VirtReporting.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f21548a = null;

        static {
            f21548a = new a();
        }

        private a() {
        }

        public final VirtReportSink a() {
            return (VirtReportSink) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(VirtReportSink.class), VirtReportSink.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f21548a;
    }

    boolean reportDiagnostics(w r1);

    void reportShell(t r1);
}
