package com.bytedance.location.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed32(UnknownFieldSetLite r1, int r2, int r3) {
        addFixed322(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed64(UnknownFieldSetLite r1, int r2, long r3) {
        addFixed642(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addGroup(UnknownFieldSetLite r1, int r2, UnknownFieldSetLite r3) {
        addGroup2(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addLengthDelimited(UnknownFieldSetLite r1, int r2, ByteString r3) {
        addLengthDelimited2(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addVarint(UnknownFieldSetLite r1, int r2, long r3) {
        addVarint2(r1, r2, r3);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getBuilderFromMessage(Object r1) {
        return getBuilderFromMessage(r1);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getFromMessage(Object r1) {
        return getFromMessage(r1);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSize(UnknownFieldSetLite r1) {
        return getSerializedSize2(r1);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSetLite r1) {
        return getSerializedSizeAsMessageSet2(r1);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite merge(UnknownFieldSetLite r1, UnknownFieldSetLite r2) {
        return merge2(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite newBuilder() {
        return newBuilder();
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setBuilderToMessage(Object r1, UnknownFieldSetLite r2) {
        setBuilderToMessage2(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setToMessage(Object r1, UnknownFieldSetLite r2) {
        setToMessage2(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite toImmutable(UnknownFieldSetLite r1) {
        return toImmutable2(r1);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeAsMessageSetTo(UnknownFieldSetLite r1, Writer r2) throws IOException {
        writeAsMessageSetTo2(r1, r2);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeTo(UnknownFieldSetLite r1, Writer r2) throws IOException {
        writeTo2(r1, r2);
    }

    UnknownFieldSetLiteSchema() {
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    void addVarint2(UnknownFieldSetLite fields, int number, long value) {
        fields.storeField(WireFormat.makeTag(number, 0), Long.valueOf(value));
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    void addFixed322(UnknownFieldSetLite fields, int number, int value) {
        fields.storeField(WireFormat.makeTag(number, 5), Integer.valueOf(value));
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    void addFixed642(UnknownFieldSetLite fields, int number, long value) {
        fields.storeField(WireFormat.makeTag(number, 1), Long.valueOf(value));
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    void addLengthDelimited2(UnknownFieldSetLite fields, int number, ByteString value) {
        fields.storeField(WireFormat.makeTag(number, 2), value);
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    void addGroup2(UnknownFieldSetLite fields, int number, UnknownFieldSetLite subFieldSet) {
        fields.storeField(WireFormat.makeTag(number, 3), subFieldSet);
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite toImmutable2(UnknownFieldSetLite fields) {
        fields.makeImmutable();
        return fields;
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    void setToMessage2(Object message, UnknownFieldSetLite fields) {
        ((GeneratedMessageLite) message).unknownFields = fields;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getFromMessage(Object message) {
        return ((GeneratedMessageLite) message).unknownFields;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getBuilderFromMessage(Object message) {
        UnknownFieldSetLite unknownFields = getFromMessage(message);
        if (unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite unknownFields2 = UnknownFieldSetLite.newInstance();
        setToMessage2(message, unknownFields2);
        return unknownFields2;
    L6:
        return unknownFields;
    }

    /* JADX INFO: renamed from: setBuilderToMessage, reason: avoid collision after fix types in other method */
    void setBuilderToMessage2(Object message, UnknownFieldSetLite fields) {
        setToMessage2(message, fields);
    }

    @Override // com.bytedance.location.protobuf.UnknownFieldSchema
    void makeImmutable(Object message) {
        getFromMessage(message).makeImmutable();
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    void writeTo2(UnknownFieldSetLite fields, Writer writer) throws IOException {
        fields.writeTo(writer);
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    void writeAsMessageSetTo2(UnknownFieldSetLite fields, Writer writer) throws IOException {
        fields.writeAsMessageSetTo(writer);
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite merge2(UnknownFieldSetLite target, UnknownFieldSetLite source) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(source) == false) goto L6;
        return target;
    L6:
        if (UnknownFieldSetLite.getDefaultInstance().equals(target) == false) goto L10;
        return UnknownFieldSetLite.mutableCopyOf(target, source);
    L10:
        return target.mergeFrom(source);
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    int getSerializedSize2(UnknownFieldSetLite unknowns) {
        return unknowns.getSerializedSize();
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    int getSerializedSizeAsMessageSet2(UnknownFieldSetLite unknowns) {
        return unknowns.getSerializedSizeAsMessageSet();
    }
}
