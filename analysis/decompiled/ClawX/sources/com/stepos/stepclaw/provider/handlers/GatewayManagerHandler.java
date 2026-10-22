package com.stepos.stepclaw.provider.handlers;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.backend.IGatewayManager;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/GatewayManagerHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "gatewayManager", "Lcom/stepos/stepclaw/provider/backend/IGatewayManager;", "<init>", "(Lcom/stepos/stepclaw/provider/backend/IGatewayManager;)V", "query", "Landroid/database/Cursor;", "restart", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayManagerHandler {
    private final IGatewayManager gatewayManager;

    public GatewayManagerHandler(IGatewayManager gatewayManager) {
        p.e(gatewayManager, "gatewayManager");
        this.gatewayManager = gatewayManager;
    }

    public final Cursor query() {
        boolean zIsReady = this.gatewayManager.isReady();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"ready"});
        matrixCursor.addRow(new Integer[]{Integer.valueOf(zIsReady ? 1 : 0)});
        return matrixCursor;
    }

    public final boolean restart() {
        return this.gatewayManager.restart();
    }
}
