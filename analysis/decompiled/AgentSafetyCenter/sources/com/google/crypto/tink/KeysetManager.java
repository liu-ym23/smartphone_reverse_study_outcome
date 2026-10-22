package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyStatusTypeProtoConverter;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class KeysetManager {

    @GuardedBy("this")
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder builder) {
        this.keysetBuilder = builder;
    }

    private synchronized Keyset.Key createKeysetKey(KeyData keyData, OutputPrefixType outputPrefixType) {
        int iNewKeyId;
        iNewKeyId = newKeyId();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return Keyset.Key.newBuilder().setKeyData(keyData).setKeyId(iNewKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
    }

    private synchronized boolean keyIdExists(int i) {
        Iterator<Keyset.Key> it = this.keysetBuilder.getKeyList().iterator();
        while (it.hasNext()) {
            if (it.next().getKeyId() == i) {
                return true;
            }
        }
        return false;
    }

    private synchronized Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        return createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());
    }

    private synchronized int newKeyId() {
        int iRandKeyId;
        iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
        while (keyIdExists(iRandKeyId)) {
            iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
        }
        return iRandKeyId;
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager(keysetHandle.getKeyset().toBuilder());
    }

    public synchronized KeysetManager add(KeyHandle keyHandle) {
        try {
            ProtoKey protoKey = (ProtoKey) keyHandle.getKey(com.google.crypto.tink.tinkkey.SecretKeyAccess.insecureSecretAccess());
            if (keyIdExists(keyHandle.getId())) {
                throw new GeneralSecurityException("Trying to add a key with an ID already contained in the keyset.");
            }
            this.keysetBuilder.addKey(Keyset.Key.newBuilder().setKeyData(protoKey.getProtoKey()).setKeyId(keyHandle.getId()).setStatus(KeyStatusTypeProtoConverter.toProto(keyHandle.getStatus())).setOutputPrefixType(KeyTemplate.toProto(protoKey.getOutputPrefixType())).build());
        } catch (ClassCastException e10) {
            throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e10);
        }
        return this;
    }

    @Deprecated
    public synchronized int addNewKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean z10) {
        Keyset.Key keyNewKey;
        try {
            keyNewKey = newKey(keyTemplate);
            this.keysetBuilder.addKey(keyNewKey);
            if (z10) {
                this.keysetBuilder.setPrimaryKeyId(keyNewKey.getKeyId());
            }
        } catch (Throwable th) {
            throw th;
        }
        return keyNewKey.getKeyId();
    }

    public synchronized KeysetManager delete(int i) {
        if (i == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot delete the primary key");
        }
        for (int i3 = 0; i3 < this.keysetBuilder.getKeyCount(); i3++) {
            if (this.keysetBuilder.getKey(i3).getKeyId() == i) {
                this.keysetBuilder.removeKey(i3);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetManager destroy(int i) {
        try {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot destroy the primary key");
            }
            for (int i3 = 0; i3 < this.keysetBuilder.getKeyCount(); i3++) {
                Keyset.Key key = this.keysetBuilder.getKey(i3);
                if (key.getKeyId() == i) {
                    if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED && key.getStatus() != KeyStatusType.DESTROYED) {
                        throw new GeneralSecurityException("cannot destroy key with id " + i);
                    }
                    this.keysetBuilder.setKey(i3, key.toBuilder().setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized KeysetManager disable(int i) {
        try {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot disable the primary key");
            }
            for (int i3 = 0; i3 < this.keysetBuilder.getKeyCount(); i3++) {
                Keyset.Key key = this.keysetBuilder.getKey(i3);
                if (key.getKeyId() == i) {
                    if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                        throw new GeneralSecurityException("cannot disable key with id " + i);
                    }
                    this.keysetBuilder.setKey(i3, key.toBuilder().setStatus(KeyStatusType.DISABLED).build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized KeysetManager enable(int i) {
        for (int i3 = 0; i3 < this.keysetBuilder.getKeyCount(); i3++) {
            try {
                Keyset.Key key = this.keysetBuilder.getKey(i3);
                if (key.getKeyId() == i) {
                    KeyStatusType status = key.getStatus();
                    KeyStatusType keyStatusType = KeyStatusType.ENABLED;
                    if (status != keyStatusType && key.getStatus() != KeyStatusType.DISABLED) {
                        throw new GeneralSecurityException("cannot enable key with id " + i);
                    }
                    this.keysetBuilder.setKey(i3, key.toBuilder().setStatus(keyStatusType).build());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() {
        return KeysetHandle.fromKeyset(this.keysetBuilder.build());
    }

    @Deprecated
    public synchronized KeysetManager promote(int i) {
        return setPrimary(i);
    }

    @Deprecated
    public synchronized KeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        addNewKey(keyTemplate, true);
        return this;
    }

    public synchronized KeysetManager setPrimary(int i) {
        for (int i3 = 0; i3 < this.keysetBuilder.getKeyCount(); i3++) {
            Keyset.Key key = this.keysetBuilder.getKey(i3);
            if (key.getKeyId() == i) {
                if (!key.getStatus().equals(KeyStatusType.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                }
                this.keysetBuilder.setPrimaryKeyId(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) {
        addNewKey(keyTemplate.getProto(), false);
        return this;
    }

    @Deprecated
    public synchronized KeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        addNewKey(keyTemplate, false);
        return this;
    }

    public synchronized KeysetManager add(KeyHandle keyHandle, KeyAccess keyAccess) {
        return add(keyHandle);
    }
}
