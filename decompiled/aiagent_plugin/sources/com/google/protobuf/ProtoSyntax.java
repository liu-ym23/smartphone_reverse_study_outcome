package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ProtoSyntax extends java.lang.Enum<ProtoSyntax> {
    private static final /* synthetic */ ProtoSyntax[] $VALUES = null;
    public static final ProtoSyntax EDITIONS = null;
    public static final ProtoSyntax PROTO2 = null;
    public static final ProtoSyntax PROTO3 = null;

    private static /* synthetic */ ProtoSyntax[] $values() {
        return new ProtoSyntax[]{PROTO2, PROTO3, EDITIONS};
    }

    public static ProtoSyntax valueOf(String r2) {
        return (ProtoSyntax) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(ProtoSyntax.class, r2), ProtoSyntax.class, "com.obric.aiagent.plugin");
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProtoSyntax[].class, "com.obric.aiagent.plugin");
    }

    private ProtoSyntax(String r1, int r2) {
        super(r1, r2);
    }

    static {
        PROTO2 = new ProtoSyntax("PROTO2", 0);
        PROTO3 = new ProtoSyntax("PROTO3", 1);
        EDITIONS = new ProtoSyntax("EDITIONS", 2);
        $VALUES = $values();
    }
}
