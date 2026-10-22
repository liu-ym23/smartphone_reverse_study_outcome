package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface Reader {
    public static final int READ_DONE = Integer.MAX_VALUE;
    public static final int TAG_UNKNOWN = 0;

    int getFieldNumber() throws IOException;

    int getTag();

    <T> void mergeGroupField(T r1, Schema<T> r2, ExtensionRegistryLite r3) throws IOException;

    <T> void mergeMessageField(T r1, Schema<T> r2, ExtensionRegistryLite r3) throws IOException;

    boolean readBool() throws IOException;

    void readBoolList(List<Boolean> r1) throws IOException;

    ByteString readBytes() throws IOException;

    void readBytesList(List<ByteString> r1) throws IOException;

    double readDouble() throws IOException;

    void readDoubleList(List<Double> r1) throws IOException;

    int readEnum() throws IOException;

    void readEnumList(List<Integer> r1) throws IOException;

    int readFixed32() throws IOException;

    void readFixed32List(List<Integer> r1) throws IOException;

    long readFixed64() throws IOException;

    void readFixed64List(List<Long> r1) throws IOException;

    float readFloat() throws IOException;

    void readFloatList(List<Float> r1) throws IOException;

    @Deprecated
    <T> T readGroup(Class<T> r1, ExtensionRegistryLite r2) throws IOException;

    @Deprecated
    <T> T readGroupBySchemaWithCheck(Schema<T> r1, ExtensionRegistryLite r2) throws IOException;

    @Deprecated
    <T> void readGroupList(List<T> r1, Schema<T> r2, ExtensionRegistryLite r3) throws IOException;

    @Deprecated
    <T> void readGroupList(List<T> r1, Class<T> r2, ExtensionRegistryLite r3) throws IOException;

    int readInt32() throws IOException;

    void readInt32List(List<Integer> r1) throws IOException;

    long readInt64() throws IOException;

    void readInt64List(List<Long> r1) throws IOException;

    <K, V> void readMap(Map<K, V> r1, MapEntryLite.Metadata<K, V> r2, ExtensionRegistryLite r3) throws IOException;

    <T> T readMessage(Class<T> r1, ExtensionRegistryLite r2) throws IOException;

    <T> T readMessageBySchemaWithCheck(Schema<T> r1, ExtensionRegistryLite r2) throws IOException;

    <T> void readMessageList(List<T> r1, Schema<T> r2, ExtensionRegistryLite r3) throws IOException;

    <T> void readMessageList(List<T> r1, Class<T> r2, ExtensionRegistryLite r3) throws IOException;

    int readSFixed32() throws IOException;

    void readSFixed32List(List<Integer> r1) throws IOException;

    long readSFixed64() throws IOException;

    void readSFixed64List(List<Long> r1) throws IOException;

    int readSInt32() throws IOException;

    void readSInt32List(List<Integer> r1) throws IOException;

    long readSInt64() throws IOException;

    void readSInt64List(List<Long> r1) throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> r1) throws IOException;

    void readStringListRequireUtf8(List<String> r1) throws IOException;

    String readStringRequireUtf8() throws IOException;

    int readUInt32() throws IOException;

    void readUInt32List(List<Integer> r1) throws IOException;

    long readUInt64() throws IOException;

    void readUInt64List(List<Long> r1) throws IOException;

    boolean shouldDiscardUnknownFields();

    boolean skipField() throws IOException;
}
