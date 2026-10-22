package com.zyql.protobuf.skull;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface TaskOutputOrBuilder extends MessageLiteOrBuilder {
    Resource getArtifacts(int i10);

    int getArtifactsCount();

    List<Resource> getArtifactsList();

    Message getMessage();

    boolean hasMessage();
}
