package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface ErrorTraceOrBuilder extends MessageOrBuilder {
    CloudSyncData getCloudSyncData();

    CloudSyncDataOrBuilder getCloudSyncDataOrBuilder();

    int getErrCode();

    int getEventId();

    int getModuleId();

    String getPackageName();

    ByteString getPackageNameBytes();

    boolean hasCloudSyncData();

    boolean hasErrCode();

    boolean hasEventId();

    boolean hasModuleId();

    boolean hasPackageName();
}
