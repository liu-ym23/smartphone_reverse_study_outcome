package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.skull.Message;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ChatRequestOrBuilder extends MessageLiteOrBuilder {
    boolean containsMeta(String str);

    Audio getAudio();

    String getChatId();

    ByteString getChatIdBytes();

    String getEventId();

    ByteString getEventIdBytes();

    boolean getIsMock();

    Message getMessage();

    @Deprecated
    Map<String, String> getMeta();

    int getMetaCount();

    Map<String, String> getMetaMap();

    String getMetaOrDefault(String str, String str2);

    String getMetaOrThrow(String str);

    boolean getNeedTts();

    String getTaskId();

    ByteString getTaskIdBytes();

    boolean hasAudio();

    boolean hasMessage();
}
