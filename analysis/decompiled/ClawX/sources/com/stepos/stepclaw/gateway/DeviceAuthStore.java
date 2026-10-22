package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceAuthStore;", "Lcom/stepos/stepclaw/gateway/DeviceAuthTokenStore;", "Lcom/stepos/stepclaw/SecurePrefs;", "prefs", "<init>", "(Lcom/stepos/stepclaw/SecurePrefs;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deviceId", "role", "tokenKey", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "loadToken", GatewayAuthConstants.AUTH_MODE, "Lb5/a0;", "saveToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clearToken", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/stepclaw/SecurePrefs;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceAuthStore implements DeviceAuthTokenStore {
    private final SecurePrefs prefs;

    public DeviceAuthStore(SecurePrefs prefs) {
        p.e(prefs, "prefs");
        this.prefs = prefs;
    }

    private final String tokenKey(String deviceId, String role) {
        String string = n.T1(deviceId).toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string.toLowerCase(locale);
        p.d(lowerCase, "toLowerCase(...)");
        String lowerCase2 = n.T1(role).toString().toLowerCase(locale);
        p.d(lowerCase2, "toLowerCase(...)");
        return a8.b.p("gateway.deviceToken.", lowerCase, ".", lowerCase2);
    }

    public final void clearToken(String deviceId, String role) {
        p.e(deviceId, "deviceId");
        p.e(role, "role");
        this.prefs.remove(tokenKey(deviceId, role));
    }

    @Override // com.stepos.stepclaw.gateway.DeviceAuthTokenStore
    public String loadToken(String deviceId, String role) {
        String string;
        p.e(deviceId, "deviceId");
        p.e(role, "role");
        String string2 = this.prefs.getString(tokenKey(deviceId, role));
        if (string2 == null || (string = n.T1(string2).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    @Override // com.stepos.stepclaw.gateway.DeviceAuthTokenStore
    public void saveToken(String deviceId, String role, String token) {
        p.e(deviceId, "deviceId");
        p.e(role, "role");
        p.e(token, "token");
        this.prefs.putString(tokenKey(deviceId, role), n.T1(token).toString());
    }
}
