package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;
import java.util.List;

/* loaded from: classes4.dex */
public interface GetAgentInfoResponseOrBuilder extends MessageLiteOrBuilder {
    String getAgentId();

    ByteString getAgentIdBytes();

    String getAgentName();

    ByteString getAgentNameBytes();

    String getCapabilities(int i10);

    ByteString getCapabilitiesBytes(int i10);

    int getCapabilitiesCount();

    List<String> getCapabilitiesList();

    String getDescription();

    ByteString getDescriptionBytes();

    Struct getMetadata();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasDescription();

    boolean hasMetadata();

    boolean hasVersion();
}
