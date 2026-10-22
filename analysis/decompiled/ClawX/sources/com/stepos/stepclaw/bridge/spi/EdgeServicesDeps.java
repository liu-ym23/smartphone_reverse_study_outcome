package com.stepos.stepclaw.bridge.spi;

import android.content.Context;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\b\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001e\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/EdgeServicesDeps;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/bridge/spi/GatewayInvoker;", "gatewayInvoker", "Lkotlin/Function0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isForeground", "debugBuild", "Ljava/lang/Class;", "installResultReceiverClass", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getMainSessionKey", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/bridge/spi/GatewayInvoker;Lp5/a;ZLjava/lang/Class;Lp5/a;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/stepos/stepclaw/bridge/spi/GatewayInvoker;", "getGatewayInvoker", "()Lcom/stepos/stepclaw/bridge/spi/GatewayInvoker;", "Lp5/a;", "()Lp5/a;", "Z", "getDebugBuild", "()Z", "Ljava/lang/Class;", "getInstallResultReceiverClass", "()Ljava/lang/Class;", "getGetMainSessionKey", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EdgeServicesDeps {
    private final Context context;
    private final boolean debugBuild;
    private final GatewayInvoker gatewayInvoker;
    private final a getMainSessionKey;
    private final Class<?> installResultReceiverClass;
    private final a isForeground;

    public EdgeServicesDeps(Context context, GatewayInvoker gatewayInvoker, a isForeground, boolean z, Class<?> installResultReceiverClass, a getMainSessionKey) {
        p.e(context, "context");
        p.e(gatewayInvoker, "gatewayInvoker");
        p.e(isForeground, "isForeground");
        p.e(installResultReceiverClass, "installResultReceiverClass");
        p.e(getMainSessionKey, "getMainSessionKey");
        this.context = context;
        this.gatewayInvoker = gatewayInvoker;
        this.isForeground = isForeground;
        this.debugBuild = z;
        this.installResultReceiverClass = installResultReceiverClass;
        this.getMainSessionKey = getMainSessionKey;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean getDebugBuild() {
        return this.debugBuild;
    }

    public final GatewayInvoker getGatewayInvoker() {
        return this.gatewayInvoker;
    }

    public final a getGetMainSessionKey() {
        return this.getMainSessionKey;
    }

    public final Class<?> getInstallResultReceiverClass() {
        return this.installResultReceiverClass;
    }

    /* renamed from: isForeground, reason: from getter */
    public final a getIsForeground() {
        return this.isForeground;
    }
}
