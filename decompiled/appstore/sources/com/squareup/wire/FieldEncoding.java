package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes4.dex */
public final enum FieldEncoding extends Enum<FieldEncoding> {
    private static final /* synthetic */ FieldEncoding[] $VALUES = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    final int value;

    /* JADX INFO: renamed from: com.squareup.wire.FieldEncoding$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding = null;

        static {
            int[] r10 = new int[FieldEncoding.values().length];
            $SwitchMap$com$squareup$wire$FieldEncoding = r10;
            r10[FieldEncoding.VARINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        FieldEncoding r10 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r10;
        FieldEncoding r11 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r11;
        FieldEncoding r12 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r12;
        FieldEncoding r13 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r13;
        $VALUES = new FieldEncoding[]{r10, r11, r12, r13};
    }

    private FieldEncoding(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static FieldEncoding get(int r10) throws IOException {
        if (r10 == 0) goto L18;
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L14;
        if (r10 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException("Unexpected FieldEncoding: " + r10);
    L14:
        return LENGTH_DELIMITED;
    L16:
        return FIXED64;
    L18:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r10) {
        return (FieldEncoding) Enum.valueOf(FieldEncoding.class, r10);
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) $VALUES.clone();
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int r10 = AnonymousClass1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L13;
        return ProtoAdapter.BYTES;
    L13:
        throw new AssertionError();
    L15:
        return ProtoAdapter.FIXED64;
    L17:
        return ProtoAdapter.FIXED32;
    L19:
        return ProtoAdapter.UINT64;
    }
}
