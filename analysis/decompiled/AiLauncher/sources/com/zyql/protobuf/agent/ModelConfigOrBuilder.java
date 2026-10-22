package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ModelConfigOrBuilder extends MessageLiteOrBuilder {
    boolean containsExtra(String str);

    @Deprecated
    Map<String, String> getExtra();

    int getExtraCount();

    Map<String, String> getExtraMap();

    String getExtraOrDefault(String str, String str2);

    String getExtraOrThrow(String str);

    int getMaxTokens();

    String getModel();

    ByteString getModelBytes();

    String getProvider();

    ByteString getProviderBytes();

    String getStop(int i10);

    ByteString getStopBytes(int i10);

    int getStopCount();

    List<String> getStopList();

    float getTemperature();

    float getTopP();

    boolean hasMaxTokens();

    boolean hasTemperature();

    boolean hasTopP();
}
