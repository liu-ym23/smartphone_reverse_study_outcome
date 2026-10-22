package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ImplementedBy;
import com.stepos.stepclaw.base.framework.Lifecycle;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@ImplementedBy(implClass = "com.stepos.stepclaw.edge.spi.EdgeServicesEntryPointImpl", lifecycle = Lifecycle.SINGLETON)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/EdgeServicesEntryPoint;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "build", "Lcom/stepos/stepclaw/bridge/spi/EdgeServices;", "deps", "Lcom/stepos/stepclaw/bridge/spi/EdgeServicesDeps;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface EdgeServicesEntryPoint {
    EdgeServices build(EdgeServicesDeps deps);
}
