package com.stepos.stepclaw.gateway;

import c5.l;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0017\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceAuthPayload;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "buildV3", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deviceId", "clientId", "clientMode", "role", "scopes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "signedAtMs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, GatewayAuthConstants.AUTH_MODE, "nonce", "platform", "deviceFamily", "normalizeMetadataField", "value", "normalizeMetadataField$step_runtime_release", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceAuthPayload {
    public static final DeviceAuthPayload INSTANCE = new DeviceAuthPayload();

    private DeviceAuthPayload() {
    }

    public final String buildV3(String deviceId, String clientId, String clientMode, String role, List<String> scopes, long signedAtMs, String token, String nonce, String platform, String deviceFamily) {
        p.e(deviceId, "deviceId");
        p.e(clientId, "clientId");
        p.e(clientMode, "clientMode");
        p.e(role, "role");
        p.e(scopes, "scopes");
        p.e(nonce, "nonce");
        return m.A0(l.S(new String[]{"v3", deviceId, clientId, clientMode, role, m.A0(scopes, ",", null, null, null, 62), String.valueOf(signedAtMs), token == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : token, nonce, normalizeMetadataField$step_runtime_release(platform), normalizeMetadataField$step_runtime_release(deviceFamily)}), "|", null, null, null, 62);
    }

    public final String normalizeMetadataField$step_runtime_release(String value) {
        String string = value != null ? n.T1(value).toString() : null;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string.length() == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        StringBuilder sb = new StringBuilder(string.length());
        int length = string.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = string.charAt(i8);
            if ('A' > cCharAt || cCharAt >= '[') {
                sb.append(cCharAt);
            } else {
                sb.append((char) (cCharAt + ' '));
            }
        }
        String string2 = sb.toString();
        p.d(string2, "toString(...)");
        return string2;
    }
}
