package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProtoSyntax extends Enum<ProtoSyntax> {
    private static final /* synthetic */ ProtoSyntax[] $VALUES = null;
    public static final ProtoSyntax PROTO2 = null;
    public static final ProtoSyntax PROTO3 = null;

    private static /* synthetic */ ProtoSyntax[] $values() {
        return new ProtoSyntax[]{PROTO2, PROTO3};
    }

    public static ProtoSyntax valueOf(String name) {
        return (ProtoSyntax) Enum.valueOf(ProtoSyntax.class, name);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) $VALUES.clone();
    }

    private ProtoSyntax(String r1, int r2) {
        super(r1, r2);
    }

    static {
        PROTO2 = new ProtoSyntax("PROTO2", 0);
        PROTO3 = new ProtoSyntax("PROTO3", 1);
        $VALUES = $values();
    }
}
