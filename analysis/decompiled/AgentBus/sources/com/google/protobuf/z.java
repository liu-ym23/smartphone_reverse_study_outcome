package com.google.protobuf;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class z extends f2 implements DescriptorProtos$EnumOptionsOrBuilder, DescriptorProtos$EnumValueOptionsOrBuilder, DescriptorProtos$ExtensionRangeOptionsOrBuilder, DescriptorProtos$FeatureSetOrBuilder, DescriptorProtos$FieldOptionsOrBuilder, DescriptorProtos$FileOptionsOrBuilder, DescriptorProtos$MessageOptionsOrBuilder, DescriptorProtos$MethodOptionsOrBuilder, DescriptorProtos$OneofOptionsOrBuilder, DescriptorProtos$ServiceOptionsOrBuilder, DescriptorProtos$SourceCodeInfoOrBuilder, GeneratedMessageLite$ExtendableMessageOrBuilder {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2637h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(int i2, i2 i2Var) {
        super(i2Var);
        this.f2637h = i2;
    }

    @Override // com.google.protobuf.f2
    public final void e() {
        super.e();
        i2 i2Var = this.f2351g;
        if (((h2) i2Var).extensions != b2.f2317c) {
            ((h2) i2Var).extensions = ((h2) i2Var).extensions.clone();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean getAllowAlias() {
        return ((a0) this.f2351g).getAllowAlias();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getCcEnableArenas() {
        return ((a1) this.f2351g).getCcEnableArenas();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getCcGenericServices() {
        return ((a1) this.f2351g).getCcGenericServices();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getCsharpNamespace() {
        return ((a1) this.f2351g).getCsharpNamespace();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getCsharpNamespaceBytes() {
        return ((a1) this.f2351g).getCsharpNamespaceBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public r0 getCtype() {
        return ((x0) this.f2351g).getCtype();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public boolean getDebugRedact() {
        switch (this.f2637h) {
            case 1:
                return ((c0) this.f2351g).getDebugRedact();
            default:
                return ((x0) this.f2351g).getDebugRedact();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public d0 getDeclaration(int i2) {
        return ((f0) this.f2351g).getDeclaration(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public int getDeclarationCount() {
        return ((f0) this.f2351g).getDeclarationCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public List getDeclarationList() {
        return Collections.unmodifiableList(((f0) this.f2351g).getDeclarationList());
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean getDeprecated() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).getDeprecated();
            case 1:
                return ((c0) this.f2351g).getDeprecated();
            case 2:
            case 3:
            default:
                return ((k1) this.f2351g).getDeprecated();
            case 4:
                return ((x0) this.f2351g).getDeprecated();
            case 5:
                return ((a1) this.f2351g).getDeprecated();
            case 6:
                return ((d1) this.f2351g).getDeprecated();
            case 7:
                return ((g1) this.f2351g).getDeprecated();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean getDeprecatedLegacyJsonFieldConflicts() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).getDeprecatedLegacyJsonFieldConflicts();
            default:
                return ((d1) this.f2351g).getDeprecatedLegacyJsonFieldConflicts();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public s0 getEditionDefaults(int i2) {
        return ((x0) this.f2351g).getEditionDefaults(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public int getEditionDefaultsCount() {
        return ((x0) this.f2351g).getEditionDefaultsCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public List getEditionDefaultsList() {
        return Collections.unmodifiableList(((x0) this.f2351g).getEditionDefaultsList());
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public g0 getEnumType() {
        return ((m0) this.f2351g).getEnumType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final Object getExtension(r1 r1Var) {
        ((h2) this.f2351g).getClass();
        throw null;
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final int getExtensionCount(r1 r1Var) {
        ((h2) this.f2351g).getClass();
        throw null;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public t0 getFeatureSupport() {
        switch (this.f2637h) {
            case 1:
                return ((c0) this.f2351g).getFeatureSupport();
            default:
                return ((x0) this.f2351g).getFeatureSupport();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public m0 getFeatures() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).getFeatures();
            case 1:
                return ((c0) this.f2351g).getFeatures();
            case 2:
                return ((f0) this.f2351g).getFeatures();
            case 3:
            default:
                return ((k1) this.f2351g).getFeatures();
            case 4:
                return ((x0) this.f2351g).getFeatures();
            case 5:
                return ((a1) this.f2351g).getFeatures();
            case 6:
                return ((d1) this.f2351g).getFeatures();
            case 7:
                return ((g1) this.f2351g).getFeatures();
            case 8:
                return ((i1) this.f2351g).getFeatures();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public h0 getFieldPresence() {
        return ((m0) this.f2351g).getFieldPresence();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getGoPackage() {
        return ((a1) this.f2351g).getGoPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getGoPackageBytes() {
        return ((a1) this.f2351g).getGoPackageBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public f1 getIdempotencyLevel() {
        return ((g1) this.f2351g).getIdempotencyLevel();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getJavaGenerateEqualsAndHash() {
        return ((a1) this.f2351g).getJavaGenerateEqualsAndHash();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getJavaGenericServices() {
        return ((a1) this.f2351g).getJavaGenericServices();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getJavaMultipleFiles() {
        return ((a1) this.f2351g).getJavaMultipleFiles();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getJavaOuterClassname() {
        return ((a1) this.f2351g).getJavaOuterClassname();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getJavaOuterClassnameBytes() {
        return ((a1) this.f2351g).getJavaOuterClassnameBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getJavaPackage() {
        return ((a1) this.f2351g).getJavaPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getJavaPackageBytes() {
        return ((a1) this.f2351g).getJavaPackageBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getJavaStringCheckUtf8() {
        return ((a1) this.f2351g).getJavaStringCheckUtf8();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public i0 getJsonFormat() {
        return ((m0) this.f2351g).getJsonFormat();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public u0 getJstype() {
        return ((x0) this.f2351g).getJstype();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean getLazy() {
        return ((x0) this.f2351g).getLazy();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder
    public l1 getLocation(int i2) {
        return ((m1) this.f2351g).getLocation(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder
    public int getLocationCount() {
        return ((m1) this.f2351g).getLocationCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder
    public List getLocationList() {
        return Collections.unmodifiableList(((m1) this.f2351g).getLocationList());
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public boolean getMapEntry() {
        return ((d1) this.f2351g).getMapEntry();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public j0 getMessageEncoding() {
        return ((m0) this.f2351g).getMessageEncoding();
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public boolean getMessageSetWireFormat() {
        return ((d1) this.f2351g).getMessageSetWireFormat();
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public boolean getNoStandardDescriptorAccessor() {
        return ((d1) this.f2351g).getNoStandardDescriptorAccessor();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getObjcClassPrefix() {
        return ((a1) this.f2351g).getObjcClassPrefix();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getObjcClassPrefixBytes() {
        return ((a1) this.f2351g).getObjcClassPrefixBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public z0 getOptimizeFor() {
        return ((a1) this.f2351g).getOptimizeFor();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean getPacked() {
        return ((x0) this.f2351g).getPacked();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getPhpClassPrefix() {
        return ((a1) this.f2351g).getPhpClassPrefix();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getPhpClassPrefixBytes() {
        return ((a1) this.f2351g).getPhpClassPrefixBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getPhpMetadataNamespace() {
        return ((a1) this.f2351g).getPhpMetadataNamespace();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getPhpMetadataNamespaceBytes() {
        return ((a1) this.f2351g).getPhpMetadataNamespaceBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getPhpNamespace() {
        return ((a1) this.f2351g).getPhpNamespace();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getPhpNamespaceBytes() {
        return ((a1) this.f2351g).getPhpNamespaceBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean getPyGenericServices() {
        return ((a1) this.f2351g).getPyGenericServices();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public k0 getRepeatedFieldEncoding() {
        return ((m0) this.f2351g).getRepeatedFieldEncoding();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public v0 getRetention() {
        return ((x0) this.f2351g).getRetention();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getRubyPackage() {
        return ((a1) this.f2351g).getRubyPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getRubyPackageBytes() {
        return ((a1) this.f2351g).getRubyPackageBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public String getSwiftPrefix() {
        return ((a1) this.f2351g).getSwiftPrefix();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public l getSwiftPrefixBytes() {
        return ((a1) this.f2351g).getSwiftPrefixBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public w0 getTargets(int i2) {
        return ((x0) this.f2351g).getTargets(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public int getTargetsCount() {
        return ((x0) this.f2351g).getTargetsCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public List getTargetsList() {
        return ((x0) this.f2351g).getTargetsList();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public o1 getUninterpretedOption(int i2) {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).getUninterpretedOption(i2);
            case 1:
                return ((c0) this.f2351g).getUninterpretedOption(i2);
            case 2:
                return ((f0) this.f2351g).getUninterpretedOption(i2);
            case 3:
            default:
                return ((k1) this.f2351g).getUninterpretedOption(i2);
            case 4:
                return ((x0) this.f2351g).getUninterpretedOption(i2);
            case 5:
                return ((a1) this.f2351g).getUninterpretedOption(i2);
            case 6:
                return ((d1) this.f2351g).getUninterpretedOption(i2);
            case 7:
                return ((g1) this.f2351g).getUninterpretedOption(i2);
            case 8:
                return ((i1) this.f2351g).getUninterpretedOption(i2);
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public int getUninterpretedOptionCount() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).getUninterpretedOptionCount();
            case 1:
                return ((c0) this.f2351g).getUninterpretedOptionCount();
            case 2:
                return ((f0) this.f2351g).getUninterpretedOptionCount();
            case 3:
            default:
                return ((k1) this.f2351g).getUninterpretedOptionCount();
            case 4:
                return ((x0) this.f2351g).getUninterpretedOptionCount();
            case 5:
                return ((a1) this.f2351g).getUninterpretedOptionCount();
            case 6:
                return ((d1) this.f2351g).getUninterpretedOptionCount();
            case 7:
                return ((g1) this.f2351g).getUninterpretedOptionCount();
            case 8:
                return ((i1) this.f2351g).getUninterpretedOptionCount();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public List getUninterpretedOptionList() {
        switch (this.f2637h) {
            case 0:
                return Collections.unmodifiableList(((a0) this.f2351g).getUninterpretedOptionList());
            case 1:
                return Collections.unmodifiableList(((c0) this.f2351g).getUninterpretedOptionList());
            case 2:
                return Collections.unmodifiableList(((f0) this.f2351g).getUninterpretedOptionList());
            case 3:
            default:
                return Collections.unmodifiableList(((k1) this.f2351g).getUninterpretedOptionList());
            case 4:
                return Collections.unmodifiableList(((x0) this.f2351g).getUninterpretedOptionList());
            case 5:
                return Collections.unmodifiableList(((a1) this.f2351g).getUninterpretedOptionList());
            case 6:
                return Collections.unmodifiableList(((d1) this.f2351g).getUninterpretedOptionList());
            case 7:
                return Collections.unmodifiableList(((g1) this.f2351g).getUninterpretedOptionList());
            case 8:
                return Collections.unmodifiableList(((i1) this.f2351g).getUninterpretedOptionList());
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean getUnverifiedLazy() {
        return ((x0) this.f2351g).getUnverifiedLazy();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public l0 getUtf8Validation() {
        return ((m0) this.f2351g).getUtf8Validation();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public e0 getVerification() {
        return ((f0) this.f2351g).getVerification();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean getWeak() {
        return ((x0) this.f2351g).getWeak();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean hasAllowAlias() {
        return ((a0) this.f2351g).hasAllowAlias();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasCcEnableArenas() {
        return ((a1) this.f2351g).hasCcEnableArenas();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasCcGenericServices() {
        return ((a1) this.f2351g).hasCcGenericServices();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasCsharpNamespace() {
        return ((a1) this.f2351g).hasCsharpNamespace();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasCtype() {
        return ((x0) this.f2351g).hasCtype();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public boolean hasDebugRedact() {
        switch (this.f2637h) {
            case 1:
                return ((c0) this.f2351g).hasDebugRedact();
            default:
                return ((x0) this.f2351g).hasDebugRedact();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean hasDeprecated() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).hasDeprecated();
            case 1:
                return ((c0) this.f2351g).hasDeprecated();
            case 2:
            case 3:
            default:
                return ((k1) this.f2351g).hasDeprecated();
            case 4:
                return ((x0) this.f2351g).hasDeprecated();
            case 5:
                return ((a1) this.f2351g).hasDeprecated();
            case 6:
                return ((d1) this.f2351g).hasDeprecated();
            case 7:
                return ((g1) this.f2351g).hasDeprecated();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean hasDeprecatedLegacyJsonFieldConflicts() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).hasDeprecatedLegacyJsonFieldConflicts();
            default:
                return ((d1) this.f2351g).hasDeprecatedLegacyJsonFieldConflicts();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public boolean hasEnumType() {
        return ((m0) this.f2351g).hasEnumType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final boolean hasExtension(r1 r1Var) {
        ((h2) this.f2351g).getClass();
        throw null;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder
    public boolean hasFeatureSupport() {
        switch (this.f2637h) {
            case 1:
                return ((c0) this.f2351g).hasFeatureSupport();
            default:
                return ((x0) this.f2351g).hasFeatureSupport();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder
    public boolean hasFeatures() {
        switch (this.f2637h) {
            case 0:
                return ((a0) this.f2351g).hasFeatures();
            case 1:
                return ((c0) this.f2351g).hasFeatures();
            case 2:
                return ((f0) this.f2351g).hasFeatures();
            case 3:
            default:
                return ((k1) this.f2351g).hasFeatures();
            case 4:
                return ((x0) this.f2351g).hasFeatures();
            case 5:
                return ((a1) this.f2351g).hasFeatures();
            case 6:
                return ((d1) this.f2351g).hasFeatures();
            case 7:
                return ((g1) this.f2351g).hasFeatures();
            case 8:
                return ((i1) this.f2351g).hasFeatures();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public boolean hasFieldPresence() {
        return ((m0) this.f2351g).hasFieldPresence();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasGoPackage() {
        return ((a1) this.f2351g).hasGoPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder
    public boolean hasIdempotencyLevel() {
        return ((g1) this.f2351g).hasIdempotencyLevel();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasJavaGenerateEqualsAndHash() {
        return ((a1) this.f2351g).hasJavaGenerateEqualsAndHash();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasJavaGenericServices() {
        return ((a1) this.f2351g).hasJavaGenericServices();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasJavaMultipleFiles() {
        return ((a1) this.f2351g).hasJavaMultipleFiles();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasJavaOuterClassname() {
        return ((a1) this.f2351g).hasJavaOuterClassname();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasJavaPackage() {
        return ((a1) this.f2351g).hasJavaPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasJavaStringCheckUtf8() {
        return ((a1) this.f2351g).hasJavaStringCheckUtf8();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public boolean hasJsonFormat() {
        return ((m0) this.f2351g).hasJsonFormat();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasJstype() {
        return ((x0) this.f2351g).hasJstype();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasLazy() {
        return ((x0) this.f2351g).hasLazy();
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public boolean hasMapEntry() {
        return ((d1) this.f2351g).hasMapEntry();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public boolean hasMessageEncoding() {
        return ((m0) this.f2351g).hasMessageEncoding();
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public boolean hasMessageSetWireFormat() {
        return ((d1) this.f2351g).hasMessageSetWireFormat();
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public boolean hasNoStandardDescriptorAccessor() {
        return ((d1) this.f2351g).hasNoStandardDescriptorAccessor();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasObjcClassPrefix() {
        return ((a1) this.f2351g).hasObjcClassPrefix();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasOptimizeFor() {
        return ((a1) this.f2351g).hasOptimizeFor();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasPacked() {
        return ((x0) this.f2351g).hasPacked();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasPhpClassPrefix() {
        return ((a1) this.f2351g).hasPhpClassPrefix();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasPhpMetadataNamespace() {
        return ((a1) this.f2351g).hasPhpMetadataNamespace();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasPhpNamespace() {
        return ((a1) this.f2351g).hasPhpNamespace();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasPyGenericServices() {
        return ((a1) this.f2351g).hasPyGenericServices();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public boolean hasRepeatedFieldEncoding() {
        return ((m0) this.f2351g).hasRepeatedFieldEncoding();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasRetention() {
        return ((x0) this.f2351g).hasRetention();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasRubyPackage() {
        return ((a1) this.f2351g).hasRubyPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder
    public boolean hasSwiftPrefix() {
        return ((a1) this.f2351g).hasSwiftPrefix();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasUnverifiedLazy() {
        return ((x0) this.f2351g).hasUnverifiedLazy();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public boolean hasUtf8Validation() {
        return ((m0) this.f2351g).hasUtf8Validation();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder
    public boolean hasVerification() {
        return ((f0) this.f2351g).hasVerification();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder
    public boolean hasWeak() {
        return ((x0) this.f2351g).hasWeak();
    }

    @Override // com.google.protobuf.f2
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final h2 buildPartial() {
        if (!((h2) this.f2351g).h()) {
            return (h2) this.f2351g;
        }
        ((h2) this.f2351g).extensions.e();
        return (h2) super.buildPartial();
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final Object getExtension(r1 r1Var, int i2) {
        ((h2) this.f2351g).getClass();
        throw null;
    }
}
