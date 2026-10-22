package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ImplementedBy;
import com.stepos.stepclaw.base.framework.Lifecycle;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@ImplementedBy(implClass = "com.stepos.stepclaw.gateway.DeviceIdentityProviderImpl", lifecycle = Lifecycle.SINGLETON)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/DeviceIdentityProvider;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "loadOrCreate", "Lcom/stepos/stepclaw/bridge/spi/DeviceIdentitySnapshot;", "publicKeyBase64Url", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "identity", "signPayload", "payload", "verifySelfSignature", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "signatureBase64", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DeviceIdentityProvider {
    DeviceIdentitySnapshot loadOrCreate();

    String publicKeyBase64Url(DeviceIdentitySnapshot identity);

    String signPayload(String payload, DeviceIdentitySnapshot identity);

    boolean verifySelfSignature(String payload, String signatureBase64, DeviceIdentitySnapshot identity);
}
