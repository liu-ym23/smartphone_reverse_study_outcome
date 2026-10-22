package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class l1 extends i2 implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
    private static final l1 DEFAULT_INSTANCE;
    public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
    public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
    private static volatile p3 PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    public static final int SPAN_FIELD_NUMBER = 2;
    public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
    private int bitField0_;
    private String leadingComments_;
    private o2 leadingDetachedComments_;
    private Internal$IntList path_;
    private Internal$IntList span_;
    private String trailingComments_;
    private int pathMemoizedSerializedSize = -1;
    private int spanMemoizedSerializedSize = -1;

    static {
        l1 l1Var = new l1();
        DEFAULT_INSTANCE = l1Var;
        i2.n(l1.class, l1Var);
    }

    public l1() {
        j2 j2Var = j2.f2413j;
        this.path_ = j2Var;
        this.span_ = j2Var;
        this.leadingComments_ = "";
        this.trailingComments_ = "";
        this.leadingDetachedComments_ = r3.f2514j;
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001'\u0002'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001a", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
            case 3:
                return new l1();
            case 4:
                return new b7.a(23, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (l1.class) {
                    try {
                        g2Var = PARSER;
                        if (g2Var == null) {
                            g2Var = new g2();
                            PARSER = g2Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return g2Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final String getLeadingComments() {
        return this.leadingComments_;
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final l getLeadingCommentsBytes() {
        return l.i(this.leadingComments_);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final String getLeadingDetachedComments(int i2) {
        return (String) this.leadingDetachedComments_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final l getLeadingDetachedCommentsBytes(int i2) {
        return l.i((String) this.leadingDetachedComments_.get(i2));
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getLeadingDetachedCommentsCount() {
        return this.leadingDetachedComments_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final List getLeadingDetachedCommentsList() {
        return this.leadingDetachedComments_;
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getPath(int i2) {
        return this.path_.getInt(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getPathCount() {
        return this.path_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final List getPathList() {
        return this.path_;
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getSpan(int i2) {
        return this.span_.getInt(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getSpanCount() {
        return this.span_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final List getSpanList() {
        return this.span_;
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final String getTrailingComments() {
        return this.trailingComments_;
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final l getTrailingCommentsBytes() {
        return l.i(this.trailingComments_);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final boolean hasLeadingComments() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final boolean hasTrailingComments() {
        return (this.bitField0_ & 2) != 0;
    }
}
