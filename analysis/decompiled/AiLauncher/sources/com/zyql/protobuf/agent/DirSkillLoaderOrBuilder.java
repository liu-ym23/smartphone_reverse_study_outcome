package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes4.dex */
public interface DirSkillLoaderOrBuilder extends MessageLiteOrBuilder {
    boolean getIsSeparate();

    String getPath();

    ByteString getPathBytes();

    boolean hasIsSeparate();
}
