package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface HeadOrBuilder extends MessageLiteOrBuilder {
    boolean containsMeta(String str);

    String getCommand();

    ByteString getCommandBytes();

    int getFrameType();

    @Deprecated
    Map<String, String> getMeta();

    int getMetaCount();

    Map<String, String> getMetaMap();

    String getMetaOrDefault(String str, String str2);

    String getMetaOrThrow(String str);

    String getModule();

    ByteString getModuleBytes();

    String getMsgId();

    ByteString getMsgIdBytes();

    int getMsgType();
}
