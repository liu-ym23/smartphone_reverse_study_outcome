package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PrivilegedRegistry {
    private PrivilegedRegistry() {
    }

    public static KeyData deriveKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, InputStream inputStream) {
        return Registry.deriveKey(keyTemplate, inputStream);
    }

    public static MessageLite parseKeyData(KeyData keyData) {
        return Registry.parseKeyData(keyData);
    }
}
