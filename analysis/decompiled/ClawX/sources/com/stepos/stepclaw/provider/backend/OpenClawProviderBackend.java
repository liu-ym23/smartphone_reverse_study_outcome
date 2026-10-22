package com.stepos.stepclaw.provider.backend;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/provider/backend/OpenClawProviderBackend;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/provider/backend/OpenClawProviderBackend$Backend;", "backend", "Lb5/a0;", ExtensionCallContract.OP_INSTALL, "(Lcom/stepos/stepclaw/provider/backend/OpenClawProviderBackend$Backend;)V", "get", "()Lcom/stepos/stepclaw/provider/backend/OpenClawProviderBackend$Backend;", "getOrThrow", "instance", "Lcom/stepos/stepclaw/provider/backend/OpenClawProviderBackend$Backend;", "Backend", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawProviderBackend {
    public static final OpenClawProviderBackend INSTANCE = new OpenClawProviderBackend();
    private static volatile Backend instance;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/provider/backend/OpenClawProviderBackend$Backend;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rootfs", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "config", "Lcom/stepos/stepclaw/provider/backend/IConfigStore;", "gatewayManager", "Lcom/stepos/stepclaw/provider/backend/IGatewayManager;", "<init>", "(Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;Lcom/stepos/stepclaw/provider/backend/IConfigStore;Lcom/stepos/stepclaw/provider/backend/IGatewayManager;)V", "getRootfs", "()Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "getConfig", "()Lcom/stepos/stepclaw/provider/backend/IConfigStore;", "getGatewayManager", "()Lcom/stepos/stepclaw/provider/backend/IGatewayManager;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Backend {
        private final IConfigStore config;
        private final IGatewayManager gatewayManager;
        private final IRootfsAccess rootfs;

        public Backend(IRootfsAccess rootfs, IConfigStore config, IGatewayManager gatewayManager) {
            p.e(rootfs, "rootfs");
            p.e(config, "config");
            p.e(gatewayManager, "gatewayManager");
            this.rootfs = rootfs;
            this.config = config;
            this.gatewayManager = gatewayManager;
        }

        public static /* synthetic */ Backend copy$default(Backend backend, IRootfsAccess iRootfsAccess, IConfigStore iConfigStore, IGatewayManager iGatewayManager, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                iRootfsAccess = backend.rootfs;
            }
            if ((i8 & 2) != 0) {
                iConfigStore = backend.config;
            }
            if ((i8 & 4) != 0) {
                iGatewayManager = backend.gatewayManager;
            }
            return backend.copy(iRootfsAccess, iConfigStore, iGatewayManager);
        }

        /* renamed from: component1, reason: from getter */
        public final IRootfsAccess getRootfs() {
            return this.rootfs;
        }

        /* renamed from: component2, reason: from getter */
        public final IConfigStore getConfig() {
            return this.config;
        }

        /* renamed from: component3, reason: from getter */
        public final IGatewayManager getGatewayManager() {
            return this.gatewayManager;
        }

        public final Backend copy(IRootfsAccess rootfs, IConfigStore config, IGatewayManager gatewayManager) {
            p.e(rootfs, "rootfs");
            p.e(config, "config");
            p.e(gatewayManager, "gatewayManager");
            return new Backend(rootfs, config, gatewayManager);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Backend)) {
                return false;
            }
            Backend backend = (Backend) other;
            return p.a(this.rootfs, backend.rootfs) && p.a(this.config, backend.config) && p.a(this.gatewayManager, backend.gatewayManager);
        }

        public final IConfigStore getConfig() {
            return this.config;
        }

        public final IGatewayManager getGatewayManager() {
            return this.gatewayManager;
        }

        public final IRootfsAccess getRootfs() {
            return this.rootfs;
        }

        public int hashCode() {
            return this.gatewayManager.hashCode() + ((this.config.hashCode() + (this.rootfs.hashCode() * 31)) * 31);
        }

        public String toString() {
            return "Backend(rootfs=" + this.rootfs + ", config=" + this.config + ", gatewayManager=" + this.gatewayManager + ")";
        }
    }

    private OpenClawProviderBackend() {
    }

    public final Backend get() {
        return instance;
    }

    public final Backend getOrThrow() {
        Backend backend = instance;
        if (backend != null) {
            return backend;
        }
        throw new IllegalStateException("OpenClawProviderBackend not installed. Call install() in Application.onCreate().");
    }

    public final void install(Backend backend) {
        p.e(backend, "backend");
        instance = backend;
    }
}
