package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: classes5.dex */
public enum ProtoBuf$Visibility implements f.a {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);

    private static f.b<ProtoBuf$Visibility> internalValueMap = new f.b<ProtoBuf$Visibility>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProtoBuf$Visibility findValueByNumber(int i10) {
            return ProtoBuf$Visibility.valueOf(i10);
        }
    };
    private final int value;

    ProtoBuf$Visibility(int i10, int i11) {
        this.value = i11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.f.a
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Visibility valueOf(int i10) {
        if (i10 == 0) {
            return INTERNAL;
        }
        if (i10 == 1) {
            return PRIVATE;
        }
        if (i10 == 2) {
            return PROTECTED;
        }
        if (i10 == 3) {
            return PUBLIC;
        }
        if (i10 == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i10 != 5) {
            return null;
        }
        return LOCAL;
    }
}
