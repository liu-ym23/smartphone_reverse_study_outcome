package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface HandoffPreHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsContext(String str);

    @Deprecated
    Map<String, String> getContext();

    int getContextCount();

    Map<String, String> getContextMap();

    String getContextOrDefault(String str, String str2);

    String getContextOrThrow(String str);

    String getFromAgentId();

    ByteString getFromAgentIdBytes();

    String getReason();

    ByteString getReasonBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    String getToAgentId();

    ByteString getToAgentIdBytes();
}
