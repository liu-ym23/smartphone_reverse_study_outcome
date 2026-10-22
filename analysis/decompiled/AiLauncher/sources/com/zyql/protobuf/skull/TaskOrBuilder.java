package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface TaskOrBuilder extends MessageLiteOrBuilder {
    boolean containsMetaData(String str);

    Agent getAgent();

    String getChildTaskIds(int i10);

    ByteString getChildTaskIdsBytes(int i10);

    int getChildTaskIdsCount();

    List<String> getChildTaskIdsList();

    String getError();

    ByteString getErrorBytes();

    Item getExecution(int i10);

    int getExecutionCount();

    List<Item> getExecutionList();

    TaskInput getInput();

    @Deprecated
    Map<String, String> getMetaData();

    int getMetaDataCount();

    Map<String, String> getMetaDataMap();

    String getMetaDataOrDefault(String str, String str2);

    String getMetaDataOrThrow(String str);

    String getOriginTaskId();

    ByteString getOriginTaskIdBytes();

    TaskOutput getOutput();

    String getParentTaskId();

    ByteString getParentTaskIdBytes();

    String getStatus();

    ByteString getStatusBytes();

    String getTaskId();

    ByteString getTaskIdBytes();

    User getUser();

    boolean hasAgent();

    boolean hasInput();

    boolean hasOutput();

    boolean hasUser();
}
