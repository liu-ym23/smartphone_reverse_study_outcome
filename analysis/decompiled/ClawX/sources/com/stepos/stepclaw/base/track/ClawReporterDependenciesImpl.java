package com.stepos.stepclaw.base.track;

import b5.h;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.StepAccount;
import j3.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/base/track/ClawReporterDependenciesImpl;", "Lcom/stepos/stepclaw/base/track/ClawReporterDependencies;", "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "traceId", "nodeName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "commonFields", "bizData", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "statusCode", "Lb5/a0;", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;I)V", "generateTraceId", "()Ljava/lang/String;", "getUserId", "getAppVersion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClawReporterDependenciesImpl implements ClawReporterDependencies {
    @Override // com.stepos.stepclaw.base.track.ClawReporterDependencies
    public String generateTraceId() {
        return a.a();
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporterDependencies
    public String getAppVersion() {
        String string = n.T1("1.0.11").toString();
        return string.length() == 0 ? "dev" : string;
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporterDependencies
    public String getUserId() {
        Object objO;
        try {
            objO = StepAccount.INSTANCE.getOAID();
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        if (objO instanceof h) {
            objO = "unknown";
        }
        return (String) objO;
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporterDependencies
    public void reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, int statusCode) {
        p.e(traceId, "traceId");
        p.e(nodeName, "nodeName");
        p.e(commonFields, "commonFields");
        p.e(bizData, "bizData");
        AgentCacheSdk.reportEvent$default(AgentCacheSdk.INSTANCE, traceId, nodeName, commonFields, bizData, null, null, statusCode, 48, null);
    }
}
