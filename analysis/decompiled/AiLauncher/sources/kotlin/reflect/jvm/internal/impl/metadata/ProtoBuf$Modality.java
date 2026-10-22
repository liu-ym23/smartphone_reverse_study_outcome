package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public enum ProtoBuf$Modality implements f.a {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);

    private static f.b<ProtoBuf$Modality> internalValueMap = new f.b<ProtoBuf$Modality>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Modality findValueByNumber(int i10) {
            return ProtoBuf$Modality.valueOf(i10);
        }
    };
    private final int value;

    ProtoBuf$Modality(int i10, int i11) {
        this.value = i11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Modality valueOf(int i10) {
        if (i10 == 0) {
            return FINAL;
        }
        if (i10 == 1) {
            return OPEN;
        }
        if (i10 == 2) {
            return ABSTRACT;
        }
        if (i10 != 3) {
            return null;
        }
        return SEALED;
    }
}
