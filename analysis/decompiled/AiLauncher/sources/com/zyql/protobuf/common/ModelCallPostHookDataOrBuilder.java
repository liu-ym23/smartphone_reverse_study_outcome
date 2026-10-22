package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ModelCallPostHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetadata(String str);

    String getAgentId();

    ByteString getAgentIdBytes();

    long getDurationMs();

    int getInputTokens();

    @Deprecated
    Map<String, String> getMetadata();

    int getMetadataCount();

    Map<String, String> getMetadataMap();

    String getMetadataOrDefault(String str, String str2);

    String getMetadataOrThrow(String str);

    String getModelName();

    ByteString getModelNameBytes();

    int getOutputTokens();

    String getProvider();

    ByteString getProviderBytes();

    String getResponseText();

    ByteString getResponseTextBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean getSuccess();
}
