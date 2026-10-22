package com.stepos.stepclaw.edge.spi;

import b.a;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.EdgeServices;
import com.stepos.stepclaw.bridge.spi.EdgeServicesDeps;
import com.stepos.stepclaw.bridge.spi.EdgeServicesEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/edge/spi/EdgeServicesEntryPointImpl;", "Lcom/stepos/stepclaw/bridge/spi/EdgeServicesEntryPoint;", "<init>", "()V", "build", "Lcom/stepos/stepclaw/bridge/spi/EdgeServices;", "deps", "Lcom/stepos/stepclaw/bridge/spi/EdgeServicesDeps;", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@a
/* loaded from: classes.dex */
public final class EdgeServicesEntryPointImpl implements EdgeServicesEntryPoint {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/stepos/stepclaw/edge/spi/EdgeServicesEntryPointImpl$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "create", "Lcom/stepos/stepclaw/bridge/spi/EdgeServicesEntryPoint;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final EdgeServicesEntryPoint create() {
            return new EdgeServicesEntryPointImpl();
        }

        private Companion() {
        }
    }

    public static final EdgeServicesEntryPoint create() {
        return INSTANCE.create();
    }

    @Override // com.stepos.stepclaw.bridge.spi.EdgeServicesEntryPoint
    public EdgeServices build(EdgeServicesDeps deps) {
        p.e(deps, "deps");
        return new EdgeServicesImpl();
    }
}
