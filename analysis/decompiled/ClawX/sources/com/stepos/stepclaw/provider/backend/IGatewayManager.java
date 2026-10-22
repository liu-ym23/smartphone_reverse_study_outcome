package com.stepos.stepclaw.provider.backend;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/provider/backend/IGatewayManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isReady", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "restart", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IGatewayManager {
    boolean isReady();

    boolean restart();
}
