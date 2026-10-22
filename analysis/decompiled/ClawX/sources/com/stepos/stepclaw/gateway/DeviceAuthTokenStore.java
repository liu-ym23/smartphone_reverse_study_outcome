package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceAuthTokenStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deviceId", "role", "loadToken", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", GatewayAuthConstants.AUTH_MODE, "Lb5/a0;", "saveToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DeviceAuthTokenStore {
    String loadToken(String deviceId, String role);

    void saveToken(String deviceId, String role, String token);
}
