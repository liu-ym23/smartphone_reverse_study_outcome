package com.zyql.protobuf.skull;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface AskInputOrBuilder extends MessageLiteOrBuilder {
    boolean containsParams(String str);

    Message getMessage();

    @Deprecated
    Map<String, String> getParams();

    int getParamsCount();

    Map<String, String> getParamsMap();

    String getParamsOrDefault(String str, String str2);

    String getParamsOrThrow(String str);

    boolean hasMessage();
}
