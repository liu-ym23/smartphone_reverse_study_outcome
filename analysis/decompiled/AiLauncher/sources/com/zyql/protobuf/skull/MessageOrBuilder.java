package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    String getContent();

    ByteString getContentBytes();

    Resource getResources(int i10);

    int getResourcesCount();

    List<Resource> getResourcesList();

    String getRole();

    ByteString getRoleBytes();
}
