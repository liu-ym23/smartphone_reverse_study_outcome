package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
    /* synthetic */ MessageLite getDefaultInstanceForType();

    String getLeadingComments();

    l getLeadingCommentsBytes();

    String getLeadingDetachedComments(int i2);

    l getLeadingDetachedCommentsBytes(int i2);

    int getLeadingDetachedCommentsCount();

    List<String> getLeadingDetachedCommentsList();

    int getPath(int i2);

    int getPathCount();

    List<Integer> getPathList();

    int getSpan(int i2);

    int getSpanCount();

    List<Integer> getSpanList();

    String getTrailingComments();

    l getTrailingCommentsBytes();

    boolean hasLeadingComments();

    boolean hasTrailingComments();

    /* synthetic */ boolean isInitialized();
}
