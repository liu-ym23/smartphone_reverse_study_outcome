package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface HookEventOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetadata(String str);

    String getAgentId();

    ByteString getAgentIdBytes();

    boolean getBlockedExecution();

    long getDurationMs();

    String getError();

    ByteString getErrorBytes();

    String getHookId();

    ByteString getHookIdBytes();

    String getHookName();

    ByteString getHookNameBytes();

    HookPoint getHookPoint();

    int getHookPointValue();

    String getInvocationId();

    ByteString getInvocationIdBytes();

    @Deprecated
    Map<String, String> getMetadata();

    int getMetadataCount();

    Map<String, String> getMetadataMap();

    String getMetadataOrDefault(String str, String str2);

    String getMetadataOrThrow(String str);

    boolean getModifiedData();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean getSuccess();

    long getTimestamp();
}
