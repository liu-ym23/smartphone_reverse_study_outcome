package com.zyql.protobuf.connection;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes4.dex */
public interface LogoutReqOrBuilder extends MessageLiteOrBuilder {
    boolean containsReserved(String str);

    @Deprecated
    Map<String, String> getReserved();

    int getReservedCount();

    Map<String, String> getReservedMap();

    String getReservedOrDefault(String str, String str2);

    String getReservedOrThrow(String str);
}
