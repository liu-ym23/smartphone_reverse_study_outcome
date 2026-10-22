package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ModelCallPreHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsSettings(String str);

    String getAgentId();

    ByteString getAgentIdBytes();

    String getModelName();

    ByteString getModelNameBytes();

    String getProvider();

    ByteString getProviderBytes();

    String getSessionId();

    ByteString getSessionIdBytes();

    @Deprecated
    Map<String, String> getSettings();

    int getSettingsCount();

    Map<String, String> getSettingsMap();

    String getSettingsOrDefault(String str, String str2);

    String getSettingsOrThrow(String str);

    FunctionCall getToolCalls(int i10);

    int getToolCallsCount();

    List<FunctionCall> getToolCallsList();
}
