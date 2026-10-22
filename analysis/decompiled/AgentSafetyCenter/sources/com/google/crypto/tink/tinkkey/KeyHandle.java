package com.google.crypto.tink.tinkkey;

import b8.z;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public class KeyHandle {

    /* renamed from: id, reason: collision with root package name */
    private final int f2486id;
    private final TinkKey key;
    private final KeyStatusType status;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum KeyStatusType {
        ENABLED,
        DISABLED,
        DESTROYED
    }

    private KeyHandle(TinkKey tinkKey) {
        this.key = tinkKey;
        this.status = KeyStatusType.ENABLED;
        this.f2486id = Util.randKeyId();
    }

    private void checkAccess(KeyAccess keyAccess) throws GeneralSecurityException {
        if (!hasSecret() || keyAccess.canAccessSecret()) {
            return;
        }
        z.l("No access");
    }

    @Deprecated
    public static KeyHandle createFromKey(KeyData keyData, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyHandle(new ProtoKey(keyData, outputPrefixType));
    }

    public static KeyHandle generateNew(KeyTemplate keyTemplate) {
        return new KeyHandle(new ProtoKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType()));
    }

    public int getId() {
        return this.f2486id;
    }

    public TinkKey getKey(KeyAccess keyAccess) throws GeneralSecurityException {
        checkAccess(keyAccess);
        return this.key;
    }

    public KeyTemplate getKeyTemplate() {
        return this.key.getKeyTemplate();
    }

    public KeyStatusType getStatus() {
        return this.status;
    }

    public boolean hasSecret() {
        return this.key.hasSecret();
    }

    public static KeyHandle createFromKey(TinkKey tinkKey, KeyAccess keyAccess) throws GeneralSecurityException {
        KeyHandle keyHandle = new KeyHandle(tinkKey);
        keyHandle.checkAccess(keyAccess);
        return keyHandle;
    }

    public KeyHandle(TinkKey tinkKey, KeyStatusType keyStatusType, int i) {
        this.key = tinkKey;
        this.status = keyStatusType;
        this.f2486id = i;
    }
}
