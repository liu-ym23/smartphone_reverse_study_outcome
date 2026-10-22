package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface HookExecutionResultOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetadata(String str);

    boolean getContinueExecution();

    long getDurationMs();

    String getError();

    ByteString getErrorBytes();

    @Deprecated
    Map<String, String> getMetadata();

    int getMetadataCount();

    Map<String, String> getMetadataMap();

    String getMetadataOrDefault(String str, String str2);

    String getMetadataOrThrow(String str);

    boolean getModified();

    ByteString getModifiedData();

    boolean getSuccess();

    String getTaskId();

    ByteString getTaskIdBytes();
}
