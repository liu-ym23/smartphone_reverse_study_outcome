package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface TaskDealReqOrBuilder extends MessageLiteOrBuilder {
    String getCommond();

    ByteString getCommondBytes();

    String getTaskId();

    ByteString getTaskIdBytes();
}
