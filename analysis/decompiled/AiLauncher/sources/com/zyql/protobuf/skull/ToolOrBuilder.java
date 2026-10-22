package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ToolOrBuilder extends MessageLiteOrBuilder {
    boolean containsParameters(String str);

    String getDescription();

    ByteString getDescriptionBytes();

    String getId();

    ByteString getIdBytes();

    String getName();

    ByteString getNameBytes();

    @Deprecated
    Map<String, String> getParameters();

    int getParametersCount();

    Map<String, String> getParametersMap();

    String getParametersOrDefault(String str, String str2);

    String getParametersOrThrow(String str);

    String getVersion();

    ByteString getVersionBytes();
}
