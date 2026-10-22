package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/IdentityProvider;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getOAID", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "appVersion", "isDebugBuild", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IdentityProvider {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String appVersion(IdentityProvider identityProvider) {
            return IdentityProvider.super.appVersion();
        }

        @Deprecated
        public static boolean isDebugBuild(IdentityProvider identityProvider) {
            return IdentityProvider.super.isDebugBuild();
        }
    }

    default String appVersion() {
        return "dev";
    }

    String getOAID();

    default boolean isDebugBuild() {
        return false;
    }
}
