package com.stepos.protobuf.connection;

import com.google.protobuf.MessageLite;
import com.google.protobuf.l;
import java.util.Map;

/* loaded from: classes.dex */
public interface ToolOrBuilder {
    boolean containsParameters(String str);

    /* synthetic */ MessageLite getDefaultInstanceForType();

    String getDescription();

    l getDescriptionBytes();

    String getId();

    l getIdBytes();

    String getName();

    l getNameBytes();

    @Deprecated
    Map<String, String> getParameters();

    int getParametersCount();

    Map<String, String> getParametersMap();

    String getParametersOrDefault(String str, String str2);

    String getParametersOrThrow(String str);

    String getVersion();

    l getVersionBytes();

    /* synthetic */ boolean isInitialized();
}
