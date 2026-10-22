package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class y0 extends i2 implements DescriptorProtos$FileDescriptorProtoOrBuilder {
    private static final y0 DEFAULT_INSTANCE;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    public static final int EDITION_FIELD_NUMBER = 14;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    private static volatile p3 PARSER = null;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    public static final int SERVICE_FIELD_NUMBER = 6;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    public static final int SYNTAX_FIELD_NUMBER = 12;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private int bitField0_;
    private o2 dependency_;
    private int edition_;
    private o2 enumType_;
    private o2 extension_;
    private o2 messageType_;
    private a1 options_;
    private Internal$IntList publicDependency_;
    private o2 service_;
    private m1 sourceCodeInfo_;
    private String syntax_;
    private Internal$IntList weakDependency_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private String package_ = "";

    static {
        y0 y0Var = new y0();
        DEFAULT_INSTANCE = y0Var;
        i2.n(y0.class, y0Var);
    }

    public y0() {
        r3 r3Var = r3.f2514j;
        this.dependency_ = r3Var;
        j2 j2Var = j2.f2413j;
        this.publicDependency_ = j2Var;
        this.weakDependency_ = j2Var;
        this.messageType_ = r3Var;
        this.enumType_ = r3Var;
        this.service_ = r3Var;
        this.extension_ = r3Var;
        this.syntax_ = "";
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 1:
                this.memoizedIsInitialized = (byte) (i2Var == null ? 0 : 1);
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\u000e\r\u0000\u0007\u0006\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tᐉ\u0003\n\u0016\u000b\u0016\fဈ\u0004\u000e᠌\u0005", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", u.class, "enumType_", y.class, "service_", j1.class, "extension_", q0.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_", "edition_", v.f2564b});
            case 3:
                return new y0();
            case 4:
                return new b7.a(18, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (y0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final String getDependency(int i2) {
        return (String) this.dependency_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final l getDependencyBytes(int i2) {
        return l.i((String) this.dependency_.get(i2));
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getDependencyCount() {
        return this.dependency_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getDependencyList() {
        return this.dependency_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final w getEdition() {
        w wVarA = w.a(this.edition_);
        return wVarA == null ? w.EDITION_UNKNOWN : wVarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final y getEnumType(int i2) {
        return (y) this.enumType_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getEnumTypeCount() {
        return this.enumType_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getEnumTypeList() {
        return this.enumType_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final q0 getExtension(int i2) {
        return (q0) this.extension_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getExtensionCount() {
        return this.extension_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getExtensionList() {
        return this.extension_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final u getMessageType(int i2) {
        return (u) this.messageType_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getMessageTypeCount() {
        return this.messageType_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getMessageTypeList() {
        return this.messageType_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    /* renamed from: getOptions */
    public final a1 mo0getOptions() {
        a1 a1Var = this.options_;
        return a1Var == null ? a1.q() : a1Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final String getPackage() {
        return this.package_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final l getPackageBytes() {
        return l.i(this.package_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getPublicDependency(int i2) {
        return this.publicDependency_.getInt(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getPublicDependencyList() {
        return this.publicDependency_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final j1 getService(int i2) {
        return (j1) this.service_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getServiceCount() {
        return this.service_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getServiceList() {
        return this.service_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final m1 getSourceCodeInfo() {
        m1 m1Var = this.sourceCodeInfo_;
        return m1Var == null ? m1.q() : m1Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    /* renamed from: getSyntax */
    public final String mo11getSyntax() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final l getSyntaxBytes() {
        return l.i(this.syntax_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getWeakDependency(int i2) {
        return this.weakDependency_.getInt(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getWeakDependencyList() {
        return this.weakDependency_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final boolean hasEdition() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final boolean hasPackage() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final boolean hasSourceCodeInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final boolean hasSyntax() {
        return (this.bitField0_ & 16) != 0;
    }
}
