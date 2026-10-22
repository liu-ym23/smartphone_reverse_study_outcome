package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    static {
    }

    abstract void addFixed32(B r1, int r2, int r3);

    abstract void addFixed64(B r1, int r2, long r3);

    abstract void addGroup(B r1, int r2, T r3);

    abstract void addLengthDelimited(B r1, int r2, ByteString r3);

    abstract void addVarint(B r1, int r2, long r3);

    abstract B getBuilderFromMessage(Object r1);

    abstract T getFromMessage(Object r1);

    abstract int getSerializedSize(T r1);

    abstract int getSerializedSizeAsMessageSet(T r1);

    abstract void makeImmutable(Object r1);

    abstract T merge(T r1, T r2);

    abstract B newBuilder();

    abstract void setBuilderToMessage(Object r1, B r2);

    abstract void setToMessage(Object r1, T r2);

    abstract boolean shouldDiscardUnknownFields(Reader r1);

    abstract T toImmutable(B r1);

    abstract void writeAsMessageSetTo(T r1, Writer r2);

    abstract void writeTo(T r1, Writer r2);

    UnknownFieldSchema() {
    }

    final boolean mergeOneFieldFrom(B r6, Reader r7, int r8) {
        Reader r9 = (Reader) ZeusTransformUtils.wrapperContextForParams(r7, Reader.class, "com.obric.aiagent.plugin");
        int r0 = r9.getTag();
        int r1 = WireFormat.getTagFieldNumber(r0);
        int r2 = WireFormat.getTagWireType(r0);
        if (r2 == 0) goto L35;
        if (r2 != 1) goto L6;
        addFixed64(r6, r1, r9.readFixed64());
        return true;
    L6:
        if (r2 != 2) goto L8;
        addLengthDelimited(r6, r1, r9.readBytes());
        return true;
    L8:
        if (r2 == 3) goto L21;
        if (r2 != 4) goto L11;
        if (r8 == 0) goto L20;
        return false;
    L20:
        throw InvalidProtocolBufferException.invalidEndTag();
    L11:
        if (r2 != 5) goto L15;
        addFixed32(r6, r1, r9.readFixed32());
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L21:
        B r3 = newBuilder();
        int r4 = WireFormat.makeTag(r1, 4);
        int r10 = r8 + 1;
        if (r10 >= recursionLimit) goto L30;
        mergeFrom(r3, r9, r10);
        if (r4 != r9.getTag()) goto L28;
        addGroup(r6, r1, toImmutable(r3));
        return true;
    L28:
        throw InvalidProtocolBufferException.invalidEndTag();
    L30:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    L35:
        addVarint(r6, r1, r9.readInt64());
        return true;
    }

    private final void mergeFrom(B r3, Reader r4, int r5) {
        Reader r6 = (Reader) ZeusTransformUtils.wrapperContextForParams(r4, Reader.class, "com.obric.aiagent.plugin");
    L4:
        if (r6.getFieldNumber() == Integer.MAX_VALUE) goto L7;
        if (mergeOneFieldFrom(r3, r6, r5) == true) goto L4;
        return;
    }

    public void setRecursionLimit(int r1) {
        recursionLimit = r1;
    }
}
