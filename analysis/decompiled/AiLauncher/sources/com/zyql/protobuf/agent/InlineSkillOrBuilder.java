package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface InlineSkillOrBuilder extends MessageLiteOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    FileContent getFiles(int i10);

    int getFilesCount();

    List<FileContent> getFilesList();

    String getName();

    ByteString getNameBytes();
}
