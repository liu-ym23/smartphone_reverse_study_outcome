package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite defaultInstance, String info, Object[] objects) {
        this.defaultInstance = defaultInstance;
        this.info = info;
        this.objects = objects;
        int position = 0 + 1;
        int value = info.charAt(0);
        if (value >= 55296) goto L5;
        this.flags = value;
        return;
    L5:
        int result = value & 8191;
        int shift = 13;
    L6:
        int position2 = position + 1;
        int value2 = info.charAt(position);
        if (value2 < 55296) goto L9;
        result = result | ((value2 & 8191) << shift);
        shift = shift + 13;
        position = position2;
        goto L6
    L9:
        this.flags = (value2 << shift) | result;
    }

    String getStringInfo() {
        return this.info;
    }

    Object[] getObjects() {
        return this.objects;
    }

    @Override // com.bytedance.location.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    @Override // com.bytedance.location.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        if ((this.flags & 1) != 1) goto L6;
        return ProtoSyntax.PROTO2;
    L6:
        return ProtoSyntax.PROTO3;
    }

    @Override // com.bytedance.location.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        if ((this.flags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
