package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private static final int IS_EDITION_BIT = 4;
    private static final int IS_PROTO2_BIT = 1;
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite r4, String r5, Object[] r6) {
        this.defaultInstance = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.aiagent.plugin");
        this.info = r5;
        this.objects = r6;
        char r7 = r5.charAt(0);
        if (r7 >= 55296) goto L5;
        this.flags = r7;
        return;
    L5:
        int r8 = r7 & 8191;
        int r0 = 13;
        int r1 = 1;
    L6:
        int r2 = r1 + 1;
        char r3 = r5.charAt(r1);
        if (r3 < 55296) goto L9;
        r8 = r8 | ((r3 & 8191) << r0);
        r0 = r0 + 13;
        r1 = r2;
        goto L6
    L9:
        this.flags = r8 | (r3 << r0);
    }

    String getStringInfo() {
        return this.info;
    }

    Object[] getObjects() {
        return this.objects;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        int r1 = this.flags;
        if ((r1 & 1) == 0) goto L7;
        return ProtoSyntax.PROTO2;
    L7:
        if ((r1 & 4) != 4) goto L11;
        return ProtoSyntax.EDITIONS;
    L11:
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        if ((this.flags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
