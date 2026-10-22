package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface HookResultOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetadata(String str);

    String getBlockReason();

    ByteString getBlockReasonBytes();

    boolean getContinueExecution();

    long getDurationMs();

    String getError();

    ByteString getErrorBytes();

    String getHookId();

    ByteString getHookIdBytes();

    String getInvocationId();

    ByteString getInvocationIdBytes();

    @Deprecated
    Map<String, String> getMetadata();

    int getMetadataCount();

    Map<String, String> getMetadataMap();

    String getMetadataOrDefault(String str, String str2);

    String getMetadataOrThrow(String str);

    boolean getModified();

    ByteString getModifiedData();

    PostToolCallMode getPostMode();

    int getPostModeValue();

    PreToolCallMode getPreMode();

    int getPreModeValue();

    String getReason();

    ByteString getReasonBytes();

    boolean getSuccess();
}
