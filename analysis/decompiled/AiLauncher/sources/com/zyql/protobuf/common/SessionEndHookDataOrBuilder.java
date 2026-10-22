package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface SessionEndHookDataOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetadata(String str);

    long getDurationMs();

    int getMessageCount();

    @Deprecated
    Map<String, String> getMetadata();

    int getMetadataCount();

    Map<String, String> getMetadataMap();

    String getMetadataOrDefault(String str, String str2);

    String getMetadataOrThrow(String str);

    String getReason();

    ByteString getReasonBytes();

    String getSessionId();

    ByteString getSessionIdBytes();
}
