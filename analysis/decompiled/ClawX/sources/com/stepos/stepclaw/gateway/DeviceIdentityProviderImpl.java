package com.stepos.stepclaw.gateway;

import android.content.Context;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.DeviceIdentityProvider;
import com.stepos.stepclaw.bridge.spi.DeviceIdentitySnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\f\u0010\u0012\u001a\u00020\t*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0013*\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceIdentityProviderImpl;", "Lcom/stepos/stepclaw/bridge/spi/DeviceIdentityProvider;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "store", "Lcom/stepos/stepclaw/gateway/DeviceIdentityStore;", "loadOrCreate", "Lcom/stepos/stepclaw/bridge/spi/DeviceIdentitySnapshot;", "publicKeyBase64Url", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "identity", "signPayload", "payload", "verifySelfSignature", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "signatureBase64", "toSnapshot", "Lcom/stepos/stepclaw/gateway/DeviceIdentity;", "toStoreType", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceIdentityProviderImpl implements DeviceIdentityProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DeviceIdentityStore store;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/gateway/DeviceIdentityProviderImpl$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "create", "Lcom/stepos/stepclaw/bridge/spi/DeviceIdentityProvider;", "context", "Landroid/content/Context;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final DeviceIdentityProvider create(Context context) {
            p.e(context, "context");
            Context applicationContext = context.getApplicationContext();
            p.d(applicationContext, "getApplicationContext(...)");
            return new DeviceIdentityProviderImpl(applicationContext, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DeviceIdentityProviderImpl(Context context, i iVar) {
        this(context);
    }

    public static final DeviceIdentityProvider create(Context context) {
        return INSTANCE.create(context);
    }

    private final DeviceIdentitySnapshot toSnapshot(DeviceIdentity deviceIdentity) {
        return new DeviceIdentitySnapshot(deviceIdentity.getDeviceId(), deviceIdentity.getPublicKeyRawBase64(), deviceIdentity.getPrivateKeyPkcs8Base64(), deviceIdentity.getCreatedAtMs());
    }

    private final DeviceIdentity toStoreType(DeviceIdentitySnapshot deviceIdentitySnapshot) {
        return new DeviceIdentity(deviceIdentitySnapshot.getDeviceId(), deviceIdentitySnapshot.getPublicKeyRawBase64(), deviceIdentitySnapshot.getPrivateKeyPkcs8Base64(), deviceIdentitySnapshot.getCreatedAtMs());
    }

    @Override // com.stepos.stepclaw.bridge.spi.DeviceIdentityProvider
    public DeviceIdentitySnapshot loadOrCreate() {
        return toSnapshot(this.store.loadOrCreate());
    }

    @Override // com.stepos.stepclaw.bridge.spi.DeviceIdentityProvider
    public String publicKeyBase64Url(DeviceIdentitySnapshot identity) {
        p.e(identity, "identity");
        return this.store.publicKeyBase64Url(toStoreType(identity));
    }

    @Override // com.stepos.stepclaw.bridge.spi.DeviceIdentityProvider
    public String signPayload(String payload, DeviceIdentitySnapshot identity) {
        p.e(payload, "payload");
        p.e(identity, "identity");
        return this.store.signPayload(payload, toStoreType(identity));
    }

    @Override // com.stepos.stepclaw.bridge.spi.DeviceIdentityProvider
    public boolean verifySelfSignature(String payload, String signatureBase64, DeviceIdentitySnapshot identity) {
        p.e(payload, "payload");
        p.e(signatureBase64, "signatureBase64");
        p.e(identity, "identity");
        return this.store.verifySelfSignature(payload, signatureBase64, toStoreType(identity));
    }

    private DeviceIdentityProviderImpl(Context context) {
        this.store = new DeviceIdentityStore(context);
    }
}
