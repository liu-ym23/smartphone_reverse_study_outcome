package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.o2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC0975o2 {
    void a(List list, InterfaceC0979p2 interfaceC0979p2, R0 r02);

    void b(List list, InterfaceC0979p2 interfaceC0979p2, R0 r02);

    void c(Map map, u1.d dVar, R0 r02);

    void d(Object obj, InterfaceC0979p2 interfaceC0979p2, R0 r02);

    void e(Object obj, InterfaceC0979p2 interfaceC0979p2, R0 r02);

    int getFieldNumber();

    int getTag();

    boolean readBool();

    void readBoolList(List list);

    ByteString readBytes();

    void readBytesList(List list);

    double readDouble();

    void readDoubleList(List list);

    int readEnum();

    void readEnumList(List list);

    int readFixed32();

    void readFixed32List(List list);

    long readFixed64();

    void readFixed64List(List list);

    float readFloat();

    void readFloatList(List list);

    int readInt32();

    void readInt32List(List list);

    long readInt64();

    void readInt64List(List list);

    int readSFixed32();

    void readSFixed32List(List list);

    long readSFixed64();

    void readSFixed64List(List list);

    int readSInt32();

    void readSInt32List(List list);

    long readSInt64();

    void readSInt64List(List list);

    String readString();

    void readStringList(List list);

    void readStringListRequireUtf8(List list);

    String readStringRequireUtf8();

    int readUInt32();

    void readUInt32List(List list);

    long readUInt64();

    void readUInt64List(List list);

    boolean skipField();
}
