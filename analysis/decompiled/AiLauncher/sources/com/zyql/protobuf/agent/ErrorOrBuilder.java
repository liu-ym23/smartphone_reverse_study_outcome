package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ErrorOrBuilder extends MessageLiteOrBuilder {
    boolean containsDetails(String str);

    ErrorCode getCode();

    int getCodeValue();

    @Deprecated
    Map<String, String> getDetails();

    int getDetailsCount();

    Map<String, String> getDetailsMap();

    String getDetailsOrDefault(String str, String str2);

    String getDetailsOrThrow(String str);

    String getMessage();

    ByteString getMessageBytes();
}
