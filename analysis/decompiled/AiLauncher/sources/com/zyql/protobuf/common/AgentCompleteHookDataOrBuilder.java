package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface AgentCompleteHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetadata(String str);

    String getAgentId();

    ByteString getAgentIdBytes();

    String getAgentName();

    ByteString getAgentNameBytes();

    long getDurationMs();

    @Deprecated
    Map<String, String> getMetadata();

    int getMetadataCount();

    Map<String, String> getMetadataMap();

    String getMetadataOrDefault(String str, String str2);

    String getMetadataOrThrow(String str);

    String getOutputText();

    ByteString getOutputTextBytes();

    String getRunId();

    ByteString getRunIdBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    int getTurnsTaken();
}
