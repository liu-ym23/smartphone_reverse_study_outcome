package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@CheckReturnValue
/* loaded from: classes.dex */
abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(B b10, int i, int i3);

    public abstract void addFixed64(B b10, int i, long j10);

    public abstract void addGroup(B b10, int i, T t10);

    public abstract void addLengthDelimited(B b10, int i, ByteString byteString);

    public abstract void addVarint(B b10, int i, long j10);

    public abstract B getBuilderFromMessage(Object obj);

    public abstract T getFromMessage(Object obj);

    public abstract int getSerializedSize(T t10);

    public abstract int getSerializedSizeAsMessageSet(T t10);

    public abstract void makeImmutable(Object obj);

    public abstract T merge(T t10, T t11);

    public final void mergeFrom(B b10, Reader reader) {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b10, reader)) {
        }
    }

    public final boolean mergeOneFieldFrom(B b10, Reader reader) throws InvalidProtocolBufferException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b10, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b10, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b10, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(b10, tagFieldNumber, reader.readFixed32());
            return true;
        }
        B bNewBuilder = newBuilder();
        int iMakeTag = WireFormat.makeTag(tagFieldNumber, 4);
        mergeFrom(bNewBuilder, reader);
        if (iMakeTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b10, tagFieldNumber, toImmutable(bNewBuilder));
        return true;
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b10);

    public abstract void setToMessage(Object obj, T t10);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    public abstract T toImmutable(B b10);

    public abstract void writeAsMessageSetTo(T t10, Writer writer);

    public abstract void writeTo(T t10, Writer writer);
}
