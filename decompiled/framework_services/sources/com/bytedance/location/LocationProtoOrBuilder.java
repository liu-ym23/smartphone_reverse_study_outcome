package com.bytedance.location;

import com.bytedance.location.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface LocationProtoOrBuilder extends MessageLiteOrBuilder {
    LocationProtoData getLocationProto(int r1);

    int getLocationProtoCount();

    List<LocationProtoData> getLocationProtoList();
}
