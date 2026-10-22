package com.stepos.stepclaw.base.track;

import android.app.Application;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/base/track/ClawReportBridge;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/app/Application;", "application", "Lcom/stepos/stepclaw/base/track/ClawReporter;", "reporter", "Lb5/a0;", "init", "(Landroid/app/Application;Lcom/stepos/stepclaw/base/track/ClawReporter;)V", "value", "Lcom/stepos/stepclaw/base/track/ClawReporter;", "getReporter", "()Lcom/stepos/stepclaw/base/track/ClawReporter;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClawReportBridge {
    public static final ClawReportBridge INSTANCE = new ClawReportBridge();
    private static volatile ClawReporter reporter;

    private ClawReportBridge() {
    }

    public final ClawReporter getReporter() {
        return reporter;
    }

    public final void init(Application application, ClawReporter reporter2) {
        p.e(application, "application");
        p.e(reporter2, "reporter");
        AgentCacheSdk.init$default(AgentCacheSdk.INSTANCE, application, null, null, 6, null);
        reporter = reporter2;
    }
}
