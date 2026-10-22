package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface AgentOrBuilder extends MessageLiteOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    String getId();

    ByteString getIdBytes();

    String getName();

    ByteString getNameBytes();

    String getVersion();

    ByteString getVersionBytes();
}
