package com.google.protobuf;

import fi.iki.elonen.NanoHTTPD;
import java.util.List;

/* loaded from: classes.dex */
public final class a1 extends h2 implements DescriptorProtos$FileOptionsOrBuilder {
    public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
    private static final a1 DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 23;
    public static final int FEATURES_FIELD_NUMBER = 50;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
    public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    private static volatile p3 PARSER = null;
    public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
    public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
    public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
    public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean ccGenericServices_;
    private boolean deprecated_;
    private m0 features_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaGenericServices_;
    private boolean javaMultipleFiles_;
    private boolean javaStringCheckUtf8_;
    private boolean pyGenericServices_;
    private byte memoizedIsInitialized = 2;
    private String javaPackage_ = "";
    private String javaOuterClassname_ = "";
    private int optimizeFor_ = 1;
    private String goPackage_ = "";
    private boolean ccEnableArenas_ = true;
    private String objcClassPrefix_ = "";
    private String csharpNamespace_ = "";
    private String swiftPrefix_ = "";
    private String phpClassPrefix_ = "";
    private String phpNamespace_ = "";
    private String phpMetadataNamespace_ = "";
    private String rubyPackage_ = "";
    private o2 uninterpretedOption_ = r3.f2514j;

    static {
        a1 a1Var = new a1();
        DEFAULT_INSTANCE = a1Var;
        i2.n(a1.class, a1Var);
    }

    public static a1 q() {
        return DEFAULT_INSTANCE;
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0002\u0001ဈ\u0000\bဈ\u0001\t᠌\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\n\u001bဇ\u0004\u001fဇ\u000b$ဈ\f%ဈ\r'ဈ\u000e(ဈ\u000f)ဈ\u0010,ဈ\u0011-ဈ\u00122ᐉ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", v.f2578p, "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpMetadataNamespace_", "rubyPackage_", "features_", "uninterpretedOption_", o1.class});
            case 3:
                return new a1();
            case 4:
                return new z(5, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (a1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getCsharpNamespace() {
        return this.csharpNamespace_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getCsharpNamespaceBytes() {
        return l.i(this.csharpNamespace_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getGoPackage() {
        return this.goPackage_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getGoPackageBytes() {
        return l.i(this.goPackage_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getJavaOuterClassname() {
        return this.javaOuterClassname_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getJavaOuterClassnameBytes() {
        return l.i(this.javaOuterClassname_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getJavaPackage() {
        return this.javaPackage_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getJavaPackageBytes() {
        return l.i(this.javaPackage_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getObjcClassPrefix() {
        return this.objcClassPrefix_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getObjcClassPrefixBytes() {
        return l.i(this.objcClassPrefix_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final z0 getOptimizeFor() {
        z0 z0VarA = z0.a(this.optimizeFor_);
        return z0VarA == null ? z0.SPEED : z0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getPhpClassPrefix() {
        return this.phpClassPrefix_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getPhpClassPrefixBytes() {
        return l.i(this.phpClassPrefix_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getPhpMetadataNamespace() {
        return this.phpMetadataNamespace_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getPhpMetadataNamespaceBytes() {
        return l.i(this.phpMetadataNamespace_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getPhpNamespace() {
        return this.phpNamespace_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getPhpNamespaceBytes() {
        return l.i(this.phpNamespace_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getRubyPackage() {
        return this.rubyPackage_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getRubyPackageBytes() {
        return l.i(this.rubyPackage_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final String getSwiftPrefix() {
        return this.swiftPrefix_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final l getSwiftPrefixBytes() {
        return l.i(this.swiftPrefix_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasCcEnableArenas() {
        return (this.bitField0_ & 2048) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasCcGenericServices() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasCsharpNamespace() {
        return (this.bitField0_ & NanoHTTPD.HTTPSession.BUFSIZE) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasDeprecated() {
        return (this.bitField0_ & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 524288) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasGoPackage() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasJavaGenerateEqualsAndHash() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasJavaGenericServices() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasJavaMultipleFiles() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasJavaOuterClassname() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasJavaPackage() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasJavaStringCheckUtf8() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasObjcClassPrefix() {
        return (this.bitField0_ & 4096) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasOptimizeFor() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasPhpClassPrefix() {
        return (this.bitField0_ & 32768) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasPhpMetadataNamespace() {
        return (this.bitField0_ & 131072) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasPhpNamespace() {
        return (this.bitField0_ & 65536) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasPyGenericServices() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasRubyPackage() {
        return (this.bitField0_ & 262144) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public final boolean hasSwiftPrefix() {
        return (this.bitField0_ & 16384) != 0;
    }
}
