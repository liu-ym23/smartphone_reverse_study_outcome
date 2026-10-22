package com.stepos.stepclaw.config;

import android.content.Context;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/config/GatewayAuthConstants;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "AUTH_MODE", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "PLACEHOLDER_TOKEN", "expectedToken", "context", "Landroid/content/Context;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayAuthConstants {
    public static final String AUTH_MODE = "token";
    public static final GatewayAuthConstants INSTANCE = new GatewayAuthConstants();
    public static final String PLACEHOLDER_TOKEN = "stepclaw-dev-placeholder-v1";

    private GatewayAuthConstants() {
    }

    public final String expectedToken(Context context) {
        p.e(context, "context");
        return DeviceGatewayTokenStore.INSTANCE.getOrCreate(context);
    }
}
