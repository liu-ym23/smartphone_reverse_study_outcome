package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface TaskContextOrBuilder extends MessageLiteOrBuilder {
    boolean containsMeta(String str);

    String getContextId();

    ByteString getContextIdBytes();

    @Deprecated
    Map<String, String> getMeta();

    int getMetaCount();

    Map<String, String> getMetaMap();

    String getMetaOrDefault(String str, String str2);

    String getMetaOrThrow(String str);

    String getSessionId();

    ByteString getSessionIdBytes();
}
