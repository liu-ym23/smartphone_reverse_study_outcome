package com.stepos.stepclaw.chroot;

import a.a;
import c5.n;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/chroot/RootfsHealthChecker;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "runtimeConfig", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "<init>", "(Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;)V", "check", "Lcom/stepos/stepclaw/chroot/HealthCheckResult;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RootfsHealthChecker {
    private final OpenClawRuntimeConfig runtimeConfig;
    private static final List<String> CRITICAL_PATHS = n.k0("usr/local/bin/node", "usr/local/lib/node_modules/openclaw/package.json");
    private static final List<String> WARNING_PATHS = a.S("root/.openclaw");

    public RootfsHealthChecker(OpenClawRuntimeConfig runtimeConfig) {
        p.e(runtimeConfig, "runtimeConfig");
        this.runtimeConfig = runtimeConfig;
    }

    public final HealthCheckResult check() {
        if (!this.runtimeConfig.getRootfsRoot().isDirectory()) {
            return new HealthCheckResult(HealthStatus.FATAL, "Rootfs not mounted at " + this.runtimeConfig.getRootfsRoot(), a.S("mount"));
        }
        List<String> list = CRITICAL_PATHS;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!this.runtimeConfig.resolveRootfsPath((String) obj).exists()) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            return new HealthCheckResult(HealthStatus.CRITICAL, "Critical paths missing: " + arrayList, arrayList);
        }
        List<String> list2 = WARNING_PATHS;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (!this.runtimeConfig.resolveRootfsPath((String) obj2).exists()) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.isEmpty()) {
            return new HealthCheckResult(HealthStatus.OK, "Rootfs healthy", s.f1092a);
        }
        return new HealthCheckResult(HealthStatus.WARNING, "Warning paths missing: " + arrayList2, arrayList2);
    }
}
