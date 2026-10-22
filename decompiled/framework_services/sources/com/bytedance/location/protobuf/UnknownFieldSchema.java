package com.bytedance.location.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
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

    abstract void writeAsMessageSetTo(T r1, Writer r2) throws IOException;

    abstract void writeTo(T r1, Writer r2) throws IOException;

    UnknownFieldSchema() {
    }

    final boolean mergeOneFieldFrom(B unknownFields, Reader reader) throws IOException {
        int tag = reader.getTag();
        int fieldNumber = WireFormat.getTagFieldNumber(tag);
        switch(WireFormat.getTagWireType(tag)) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        addFixed32(unknownFields, fieldNumber, reader.readFixed32());
        return true;
    L8:
        return false;
    L10:
        B subFields = newBuilder();
        int endGroupTag = WireFormat.makeTag(fieldNumber, 4);
        mergeFrom(subFields, reader);
        if (endGroupTag != reader.getTag()) goto L15;
        addGroup(unknownFields, fieldNumber, toImmutable(subFields));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidEndTag();
    L16:
        addLengthDelimited(unknownFields, fieldNumber, reader.readBytes());
        return true;
    L18:
        addFixed64(unknownFields, fieldNumber, reader.readFixed64());
        return true;
    L20:
        addVarint(unknownFields, fieldNumber, reader.readInt64());
        return true;
    L5:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    final void mergeFrom(B unknownFields, Reader reader) throws IOException {
    L3:
        if (reader.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (mergeOneFieldFrom(unknownFields, reader) == true) goto L3;
        return;
    }
}
