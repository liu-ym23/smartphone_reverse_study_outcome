package com.google.crypto.tink;

import b8.z;
import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Config {
    private Config() {
    }

    public static KeyTypeEntry getTinkKeyTypeEntry(String str, String str2, String str3, int i, boolean z10) {
        return KeyTypeEntry.newBuilder().setPrimitiveName(str2).setTypeUrl("type.googleapis.com/google.crypto.tink." + str3).setKeyManagerVersion(i).setNewKeyAllowed(z10).setCatalogueName(str).build();
    }

    public static void register(RegistryConfig registryConfig) throws GeneralSecurityException {
        Iterator<KeyTypeEntry> it = registryConfig.getEntryList().iterator();
        while (it.hasNext()) {
            registerKeyType(it.next());
        }
    }

    public static void registerKeyType(KeyTypeEntry keyTypeEntry) throws GeneralSecurityException {
        validate(keyTypeEntry);
        if (keyTypeEntry.getCatalogueName().equals("TinkAead") || keyTypeEntry.getCatalogueName().equals("TinkMac") || keyTypeEntry.getCatalogueName().equals("TinkHybridDecrypt") || keyTypeEntry.getCatalogueName().equals("TinkHybridEncrypt") || keyTypeEntry.getCatalogueName().equals("TinkPublicKeySign") || keyTypeEntry.getCatalogueName().equals("TinkPublicKeyVerify") || keyTypeEntry.getCatalogueName().equals("TinkStreamingAead") || keyTypeEntry.getCatalogueName().equals("TinkDeterministicAead")) {
            return;
        }
        Catalogue<?> catalogue = Registry.getCatalogue(keyTypeEntry.getCatalogueName());
        Registry.registerPrimitiveWrapper(catalogue.getPrimitiveWrapper());
        Registry.registerKeyManager(catalogue.getKeyManager(keyTypeEntry.getTypeUrl(), keyTypeEntry.getPrimitiveName(), keyTypeEntry.getKeyManagerVersion()), keyTypeEntry.getNewKeyAllowed());
    }

    private static void validate(KeyTypeEntry keyTypeEntry) throws GeneralSecurityException {
        if (keyTypeEntry.getTypeUrl().isEmpty()) {
            z.l("Missing type_url.");
        } else if (keyTypeEntry.getPrimitiveName().isEmpty()) {
            z.l("Missing primitive_name.");
        } else if (keyTypeEntry.getCatalogueName().isEmpty()) {
            z.l("Missing catalogue_name.");
        }
    }
}
