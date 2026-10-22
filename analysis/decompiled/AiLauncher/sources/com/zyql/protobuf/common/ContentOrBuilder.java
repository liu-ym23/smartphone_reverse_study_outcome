package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface ContentOrBuilder extends MessageLiteOrBuilder {
    Part getParts(int i10);

    int getPartsCount();

    List<Part> getPartsList();

    String getRole();

    ByteString getRoleBytes();
}
