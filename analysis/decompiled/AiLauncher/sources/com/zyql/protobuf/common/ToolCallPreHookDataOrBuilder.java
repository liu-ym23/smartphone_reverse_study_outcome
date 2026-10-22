package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ToolCallPreHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsContext(String str);

    String getAgentId();

    ByteString getAgentIdBytes();

    String getArgumentsJson();

    ByteString getArgumentsJsonBytes();

    @Deprecated
    Map<String, String> getContext();

    int getContextCount();

    Map<String, String> getContextMap();

    String getContextOrDefault(String str, String str2);

    String getContextOrThrow(String str);

    String getSessionId();

    ByteString getSessionIdBytes();

    String getToolCallId();

    ByteString getToolCallIdBytes();

    String getToolName();

    ByteString getToolNameBytes();
}
