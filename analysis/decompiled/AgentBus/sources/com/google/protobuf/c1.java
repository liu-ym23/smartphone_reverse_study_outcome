package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class c1 extends i2 implements DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder {
    public static final int BEGIN_FIELD_NUMBER = 3;
    private static final c1 DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 4;
    private static volatile p3 PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    public static final int SEMANTIC_FIELD_NUMBER = 5;
    public static final int SOURCE_FILE_FIELD_NUMBER = 2;
    private int begin_;
    private int bitField0_;
    private int end_;
    private int semantic_;
    private int pathMemoizedSerializedSize = -1;
    private Internal$IntList path_ = j2.f2413j;
    private String sourceFile_ = "";

    static {
        c1 c1Var = new c1();
        DEFAULT_INSTANCE = c1Var;
        i2.n(c1.class, c1Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002\u0005᠌\u0003", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_", "semantic_", v.f2579q});
            case 3:
                return new c1();
            case 4:
                return new b7.a(19, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (c1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final int getBegin() {
        return this.begin_;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final int getEnd() {
        return this.end_;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getPath(int i2) {
        return this.path_.getInt(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final int getPathCount() {
        return this.path_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public final List getPathList() {
        return this.path_;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final b1 getSemantic() {
        b1 b1VarA = b1.a(this.semantic_);
        return b1VarA == null ? b1.NONE : b1VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final String getSourceFile() {
        return this.sourceFile_;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final l getSourceFileBytes() {
        return l.i(this.sourceFile_);
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final boolean hasBegin() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final boolean hasEnd() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final boolean hasSemantic() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final boolean hasSourceFile() {
        return (this.bitField0_ & 1) != 0;
    }
}
