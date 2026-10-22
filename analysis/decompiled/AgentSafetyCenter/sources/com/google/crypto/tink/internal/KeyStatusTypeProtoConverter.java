package com.google.crypto.tink.internal;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.tinkkey.KeyHandle;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class KeyStatusTypeProtoConverter {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.internal.KeyStatusTypeProtoConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType;

        static {
            int[] iArr = new int[KeyHandle.KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType = iArr;
            try {
                iArr[KeyHandle.KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType[KeyHandle.KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType[KeyHandle.KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr2;
            try {
                iArr2[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private KeyStatusTypeProtoConverter() {
    }

    public static KeyHandle.KeyStatusType fromProto(KeyStatusType keyStatusType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyHandle.KeyStatusType.ENABLED;
        }
        if (i == 2) {
            return KeyHandle.KeyStatusType.DISABLED;
        }
        if (i == 3) {
            return KeyHandle.KeyStatusType.DESTROYED;
        }
        f.s("Unknown key status type.");
        return null;
    }

    public static KeyStatusType toProto(KeyHandle.KeyStatusType keyStatusType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyStatusType.ENABLED;
        }
        if (i == 2) {
            return KeyStatusType.DISABLED;
        }
        if (i == 3) {
            return KeyStatusType.DESTROYED;
        }
        f.s("Unknown key status type.");
        return null;
    }
}
