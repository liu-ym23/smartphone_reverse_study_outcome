package com.stepos.agentbus.agents.bff.proto;

import com.google.protobuf.MessageLite;
import com.google.protobuf.l;
import java.util.Map;

/* loaded from: classes.dex */
public interface HeadOrBuilder {
    boolean containsMeta(String str);

    String getCommand();

    l getCommandBytes();

    /* synthetic */ MessageLite getDefaultInstanceForType();

    int getFrameType();

    @Deprecated
    Map<String, String> getMeta();

    int getMetaCount();

    Map<String, String> getMetaMap();

    String getMetaOrDefault(String str, String str2);

    String getMetaOrThrow(String str);

    String getModule();

    l getModuleBytes();

    String getMsgId();

    l getMsgIdBytes();

    int getMsgType();

    /* synthetic */ boolean isInitialized();
}
