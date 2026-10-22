package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ToolCallPostHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsContext(String str);

    String getAgentId();

    ByteString getAgentIdBytes();

    String getArgumentsJson();

    ByteString getArgumentsJsonBytes();

    String getContentType();

    ByteString getContentTypeBytes();

    @Deprecated
    Map<String, String> getContext();

    int getContextCount();

    Map<String, String> getContextMap();

    String getContextOrDefault(String str, String str2);

    String getContextOrThrow(String str);

    long getDurationMs();

    String getOutput();

    ByteString getOutputBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean getSuccess();

    String getToolCallId();

    ByteString getToolCallIdBytes();

    String getToolName();

    ByteString getToolNameBytes();
}
