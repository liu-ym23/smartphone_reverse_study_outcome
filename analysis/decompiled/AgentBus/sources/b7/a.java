package b7;

import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder;
import com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.a0;
import com.google.protobuf.a1;
import com.google.protobuf.a2;
import com.google.protobuf.a4;
import com.google.protobuf.b0;
import com.google.protobuf.b1;
import com.google.protobuf.c0;
import com.google.protobuf.c1;
import com.google.protobuf.d0;
import com.google.protobuf.d1;
import com.google.protobuf.e1;
import com.google.protobuf.f0;
import com.google.protobuf.f2;
import com.google.protobuf.g1;
import com.google.protobuf.h1;
import com.google.protobuf.i1;
import com.google.protobuf.i2;
import com.google.protobuf.i3;
import com.google.protobuf.j1;
import com.google.protobuf.k1;
import com.google.protobuf.l;
import com.google.protobuf.l1;
import com.google.protobuf.m0;
import com.google.protobuf.m1;
import com.google.protobuf.n0;
import com.google.protobuf.n1;
import com.google.protobuf.n4;
import com.google.protobuf.o0;
import com.google.protobuf.o1;
import com.google.protobuf.o3;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.q1;
import com.google.protobuf.s;
import com.google.protobuf.s0;
import com.google.protobuf.t;
import com.google.protobuf.t0;
import com.google.protobuf.u;
import com.google.protobuf.w;
import com.google.protobuf.w2;
import com.google.protobuf.x;
import com.google.protobuf.x0;
import com.google.protobuf.y;
import com.google.protobuf.y0;
import com.google.protobuf.y1;
import com.google.protobuf.z1;
import com.stepos.protobuf.connection.HeadOrBuilder;
import com.stepos.protobuf.connection.StreamMsgOrBuilder;
import com.stepos.protobuf.connection.ToolCallOrBuilder;
import com.stepos.protobuf.connection.ToolCallParamsOrBuilder;
import com.stepos.protobuf.connection.ToolCallResultOrBuilder;
import com.stepos.protobuf.connection.ToolOrBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends f2 implements HeadOrBuilder, StreamMsgOrBuilder, ToolOrBuilder, ToolCallOrBuilder, ToolCallParamsOrBuilder, ToolCallResultOrBuilder, AnyOrBuilder, DescriptorProtos$DescriptorProtoOrBuilder, DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, DescriptorProtos$EnumDescriptorProtoOrBuilder, DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, DescriptorProtos$EnumValueDescriptorProtoOrBuilder, DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder, DescriptorProtos$FieldDescriptorProtoOrBuilder, DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, DescriptorProtos$FieldOptions$FeatureSupportOrBuilder, DescriptorProtos$FileDescriptorProtoOrBuilder, DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, DescriptorProtos$MethodDescriptorProtoOrBuilder, DescriptorProtos$OneofDescriptorProtoOrBuilder, DescriptorProtos$ServiceDescriptorProtoOrBuilder, DescriptorProtos$SourceCodeInfo$LocationOrBuilder, DescriptorProtos$UninterpretedOptionOrBuilder, DescriptorProtos$UninterpretedOption$NamePartOrBuilder, EnumValueOrBuilder, FieldOrBuilder, ListValueOrBuilder, MethodOrBuilder {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f1544h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2, i2 i2Var) {
        super(i2Var);
        this.f1544h = i2;
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public boolean containsMeta(String str) {
        str.getClass();
        return ((c) this.f2351g).getMetaMap().containsKey(str);
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public boolean containsParameters(String str) {
        str.getClass();
        return ((f) this.f2351g).getParametersMap().containsKey(str);
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public String getAggregateValue() {
        return ((o1) this.f2351g).getAggregateValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public l getAggregateValueBytes() {
        return ((o1) this.f2351g).getAggregateValueBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public int getBegin() {
        return ((c1) this.f2351g).getBegin();
    }

    @Override // com.stepos.protobuf.connection.StreamMsgOrBuilder
    public l getBody() {
        return ((d) this.f2351g).getBody();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public String getCallId() {
        return ((g) this.f2351g).getCallId();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public l getCallIdBytes() {
        return ((g) this.f2351g).getCallIdBytes();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public y1 getCardinality() {
        return ((a2) this.f2351g).getCardinality();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return ((a2) this.f2351g).getCardinalityValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public boolean getClientStreaming() {
        return ((e1) this.f2351g).getClientStreaming();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public String getCommand() {
        return ((c) this.f2351g).getCommand();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public l getCommandBytes() {
        return ((c) this.f2351g).getCommandBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        switch (this.f1544h) {
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getDefaultValue();
            default:
                return ((a2) this.f2351g).getDefaultValue();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public l getDefaultValueBytes() {
        switch (this.f1544h) {
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getDefaultValueBytes();
            default:
                return ((a2) this.f2351g).getDefaultValueBytes();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public String getDependency(int i2) {
        return ((y0) this.f2351g).getDependency(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public l getDependencyBytes(int i2) {
        return ((y0) this.f2351g).getDependencyBytes(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getDependencyCount() {
        return ((y0) this.f2351g).getDependencyCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getDependencyList() {
        return Collections.unmodifiableList(((y0) this.f2351g).getDependencyList());
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public String getDeprecationWarning() {
        return ((t0) this.f2351g).getDeprecationWarning();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public l getDeprecationWarningBytes() {
        return ((t0) this.f2351g).getDeprecationWarningBytes();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public String getDescription() {
        return ((f) this.f2351g).getDescription();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public l getDescriptionBytes() {
        return ((f) this.f2351g).getDescriptionBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public double getDoubleValue() {
        return ((o1) this.f2351g).getDoubleValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public w getEdition() {
        switch (this.f1544h) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return ((n0) this.f2351g).getEdition();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            default:
                return ((y0) this.f2351g).getEdition();
            case 16:
                return ((s0) this.f2351g).getEdition();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public w getEditionDeprecated() {
        return ((t0) this.f2351g).getEditionDeprecated();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public w getEditionIntroduced() {
        return ((t0) this.f2351g).getEditionIntroduced();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public w getEditionRemoved() {
        return ((t0) this.f2351g).getEditionRemoved();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public int getEnd() {
        switch (this.f1544h) {
            case 8:
                return ((s) this.f2351g).getEnd();
            case 9:
                return ((t) this.f2351g).getEnd();
            case 10:
            default:
                return ((c1) this.f2351g).getEnd();
            case 11:
                return ((x) this.f2351g).getEnd();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public y getEnumType(int i2) {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getEnumType(i2);
            default:
                return ((y0) this.f2351g).getEnumType(i2);
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getEnumTypeCount() {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getEnumTypeCount();
            default:
                return ((y0) this.f2351g).getEnumTypeCount();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getEnumTypeList() {
        switch (this.f1544h) {
            case 7:
                return Collections.unmodifiableList(((u) this.f2351g).getEnumTypeList());
            default:
                return Collections.unmodifiableList(((y0) this.f2351g).getEnumTypeList());
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public String getExtendee() {
        return ((q0) this.f2351g).getExtendee();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public l getExtendeeBytes() {
        return ((q0) this.f2351g).getExtendeeBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public q0 getExtension(int i2) {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getExtension(i2);
            default:
                return ((y0) this.f2351g).getExtension(i2);
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getExtensionCount() {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getExtensionCount();
            default:
                return ((y0) this.f2351g).getExtensionCount();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getExtensionList() {
        switch (this.f1544h) {
            case 7:
                return Collections.unmodifiableList(((u) this.f2351g).getExtensionList());
            default:
                return Collections.unmodifiableList(((y0) this.f2351g).getExtensionList());
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public s getExtensionRange(int i2) {
        return ((u) this.f2351g).getExtensionRange(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public int getExtensionRangeCount() {
        return ((u) this.f2351g).getExtensionRangeCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public List getExtensionRangeList() {
        return Collections.unmodifiableList(((u) this.f2351g).getExtensionRangeList());
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public q0 getField(int i2) {
        return ((u) this.f2351g).getField(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public int getFieldCount() {
        return ((u) this.f2351g).getFieldCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public List getFieldList() {
        return Collections.unmodifiableList(((u) this.f2351g).getFieldList());
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public m0 getFixedFeatures() {
        return ((n0) this.f2351g).getFixedFeatures();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public int getFrameType() {
        return ((c) this.f2351g).getFrameType();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public String getFullName() {
        return ((d0) this.f2351g).getFullName();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public l getFullNameBytes() {
        return ((d0) this.f2351g).getFullNameBytes();
    }

    @Override // com.stepos.protobuf.connection.StreamMsgOrBuilder
    public c getHead() {
        return ((d) this.f2351g).getHead();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public String getId() {
        return ((f) this.f2351g).getId();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public l getIdBytes() {
        return ((f) this.f2351g).getIdBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public String getIdentifierValue() {
        return ((o1) this.f2351g).getIdentifierValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public l getIdentifierValueBytes() {
        return ((o1) this.f2351g).getIdentifierValueBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public String getInputType() {
        return ((e1) this.f2351g).getInputType();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public l getInputTypeBytes() {
        return ((e1) this.f2351g).getInputTypeBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public boolean getIsExtension() {
        return ((n1) this.f2351g).getIsExtension();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        switch (this.f1544h) {
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getJsonName();
            default:
                return ((a2) this.f2351g).getJsonName();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public l getJsonNameBytes() {
        switch (this.f1544h) {
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getJsonNameBytes();
            default:
                return ((a2) this.f2351g).getJsonNameBytes();
        }
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public z1 getKind() {
        return ((a2) this.f2351g).getKind();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return ((a2) this.f2351g).getKindValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public o0 getLabel() {
        return ((q0) this.f2351g).getLabel();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public String getLeadingComments() {
        return ((l1) this.f2351g).getLeadingComments();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public l getLeadingCommentsBytes() {
        return ((l1) this.f2351g).getLeadingCommentsBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public String getLeadingDetachedComments(int i2) {
        return ((l1) this.f2351g).getLeadingDetachedComments(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public l getLeadingDetachedCommentsBytes(int i2) {
        return ((l1) this.f2351g).getLeadingDetachedCommentsBytes(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public int getLeadingDetachedCommentsCount() {
        return ((l1) this.f2351g).getLeadingDetachedCommentsCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public List getLeadingDetachedCommentsList() {
        return Collections.unmodifiableList(((l1) this.f2351g).getLeadingDetachedCommentsList());
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public u getMessageType(int i2) {
        return ((y0) this.f2351g).getMessageType(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getMessageTypeCount() {
        return ((y0) this.f2351g).getMessageTypeCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getMessageTypeList() {
        return Collections.unmodifiableList(((y0) this.f2351g).getMessageTypeList());
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public Map getMeta() {
        return getMetaMap();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public int getMetaCount() {
        return ((c) this.f2351g).getMetaMap().size();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public Map getMetaMap() {
        return Collections.unmodifiableMap(((c) this.f2351g).getMetaMap());
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        Map metaMap = ((c) this.f2351g).getMetaMap();
        return metaMap.containsKey(str) ? (String) metaMap.get(str) : str2;
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public String getMetaOrThrow(String str) {
        str.getClass();
        Map metaMap = ((c) this.f2351g).getMetaMap();
        if (metaMap.containsKey(str)) {
            return (String) metaMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public e1 getMethod(int i2) {
        return ((j1) this.f2351g).getMethod(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public int getMethodCount() {
        return ((j1) this.f2351g).getMethodCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public List getMethodList() {
        return Collections.unmodifiableList(((j1) this.f2351g).getMethodList());
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public String getModule() {
        return ((c) this.f2351g).getModule();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public l getModuleBytes() {
        return ((c) this.f2351g).getModuleBytes();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public String getMsgId() {
        return ((c) this.f2351g).getMsgId();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public l getMsgIdBytes() {
        return ((c) this.f2351g).getMsgIdBytes();
    }

    @Override // com.stepos.protobuf.connection.HeadOrBuilder
    public int getMsgType() {
        return ((c) this.f2351g).getMsgType();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public String getName() {
        switch (this.f1544h) {
            case 2:
                return ((f) this.f2351g).getName();
            case 7:
                return ((u) this.f2351g).getName();
            case 10:
                return ((y) this.f2351g).getName();
            case 12:
                return ((b0) this.f2351g).getName();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getName();
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                return ((y0) this.f2351g).getName();
            case 20:
                return ((e1) this.f2351g).getName();
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                return ((h1) this.f2351g).getName();
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                return ((j1) this.f2351g).getName();
            case 26:
                return ((q1) this.f2351g).getName();
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return ((a2) this.f2351g).getName();
            default:
                return ((i3) this.f2351g).getName();
        }
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public l getNameBytes() {
        switch (this.f1544h) {
            case 2:
                return ((f) this.f2351g).getNameBytes();
            case 7:
                return ((u) this.f2351g).getNameBytes();
            case 10:
                return ((y) this.f2351g).getNameBytes();
            case 12:
                return ((b0) this.f2351g).getNameBytes();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getNameBytes();
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                return ((y0) this.f2351g).getNameBytes();
            case 20:
                return ((e1) this.f2351g).getNameBytes();
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                return ((h1) this.f2351g).getNameBytes();
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                return ((j1) this.f2351g).getNameBytes();
            case 26:
                return ((q1) this.f2351g).getNameBytes();
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return ((a2) this.f2351g).getNameBytes();
            default:
                return ((i3) this.f2351g).getNameBytes();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public int getNameCount() {
        return ((o1) this.f2351g).getNameCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public List getNameList() {
        return Collections.unmodifiableList(((o1) this.f2351g).getNameList());
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public String getNamePart() {
        return ((n1) this.f2351g).getNamePart();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public l getNamePartBytes() {
        return ((n1) this.f2351g).getNamePartBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public long getNegativeIntValue() {
        return ((o1) this.f2351g).getNegativeIntValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public u getNestedType(int i2) {
        return ((u) this.f2351g).getNestedType(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public int getNestedTypeCount() {
        return ((u) this.f2351g).getNestedTypeCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public List getNestedTypeList() {
        return Collections.unmodifiableList(((u) this.f2351g).getNestedTypeList());
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        switch (this.f1544h) {
            case 12:
                return ((b0) this.f2351g).getNumber();
            case 13:
                return ((d0) this.f2351g).getNumber();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getNumber();
            case 26:
                return ((q1) this.f2351g).getNumber();
            default:
                return ((a2) this.f2351g).getNumber();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public h1 getOneofDecl(int i2) {
        return ((u) this.f2351g).getOneofDecl(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public int getOneofDeclCount() {
        return ((u) this.f2351g).getOneofDeclCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public List getOneofDeclList() {
        return Collections.unmodifiableList(((u) this.f2351g).getOneofDeclList());
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        switch (this.f1544h) {
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).getOneofIndex();
            default:
                return ((a2) this.f2351g).getOneofIndex();
        }
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public o3 getOptions(int i2) {
        switch (this.f1544h) {
            case 26:
                return ((q1) this.f2351g).getOptions(i2);
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return ((a2) this.f2351g).getOptions(i2);
            default:
                return ((i3) this.f2351g).getOptions(i2);
        }
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public int getOptionsCount() {
        switch (this.f1544h) {
            case 26:
                return ((q1) this.f2351g).getOptionsCount();
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return ((a2) this.f2351g).getOptionsCount();
            default:
                return ((i3) this.f2351g).getOptionsCount();
        }
    }

    @Override // com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public List getOptionsList() {
        switch (this.f1544h) {
            case 26:
                return Collections.unmodifiableList(((q1) this.f2351g).getOptionsList());
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return Collections.unmodifiableList(((a2) this.f2351g).getOptionsList());
            default:
                return Collections.unmodifiableList(((i3) this.f2351g).getOptionsList());
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public String getOutputType() {
        return ((e1) this.f2351g).getOutputType();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public l getOutputTypeBytes() {
        return ((e1) this.f2351g).getOutputTypeBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public m0 getOverridableFeatures() {
        return ((n0) this.f2351g).getOverridableFeatures();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public String getPackage() {
        return ((y0) this.f2351g).getPackage();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public l getPackageBytes() {
        return ((y0) this.f2351g).getPackageBytes();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return ((a2) this.f2351g).getPacked();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public Map getParameters() {
        return getParametersMap();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public int getParametersCount() {
        return ((f) this.f2351g).getParametersMap().size();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public Map getParametersMap() {
        return Collections.unmodifiableMap(((f) this.f2351g).getParametersMap());
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public String getParametersOrDefault(String str, String str2) {
        str.getClass();
        Map parametersMap = ((f) this.f2351g).getParametersMap();
        return parametersMap.containsKey(str) ? (String) parametersMap.get(str) : str2;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public String getParametersOrThrow(String str) {
        str.getClass();
        Map parametersMap = ((f) this.f2351g).getParametersMap();
        if (parametersMap.containsKey(str)) {
            return (String) parametersMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.stepos.protobuf.connection.ToolCallParamsOrBuilder
    /* renamed from: getParams, reason: collision with other method in class */
    public String mo8getParams() {
        return ((h) this.f2351g).mo8getParams();
    }

    @Override // com.stepos.protobuf.connection.ToolCallParamsOrBuilder
    public l getParamsBytes() {
        return ((h) this.f2351g).getParamsBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public int getPath(int i2) {
        switch (this.f1544h) {
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                return ((c1) this.f2351g).getPath(i2);
            default:
                return ((l1) this.f2351g).getPath(i2);
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public int getPathCount() {
        switch (this.f1544h) {
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                return ((c1) this.f2351g).getPathCount();
            default:
                return ((l1) this.f2351g).getPathCount();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder, com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public List getPathList() {
        switch (this.f1544h) {
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                return Collections.unmodifiableList(((c1) this.f2351g).getPathList());
            default:
                return Collections.unmodifiableList(((l1) this.f2351g).getPathList());
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public long getPositiveIntValue() {
        return ((o1) this.f2351g).getPositiveIntValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean getProto3Optional() {
        return ((q0) this.f2351g).getProto3Optional();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getPublicDependency(int i2) {
        return ((y0) this.f2351g).getPublicDependency(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getPublicDependencyCount() {
        return ((y0) this.f2351g).getPublicDependencyCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getPublicDependencyList() {
        return Collections.unmodifiableList(((y0) this.f2351g).getPublicDependencyList());
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public boolean getRepeated() {
        return ((d0) this.f2351g).getRepeated();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getRequestStreaming() {
        return ((i3) this.f2351g).getRequestStreaming();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getRequestTypeUrl() {
        return ((i3) this.f2351g).getRequestTypeUrl();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public l getRequestTypeUrlBytes() {
        return ((i3) this.f2351g).getRequestTypeUrlBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public boolean getReserved() {
        return ((d0) this.f2351g).getReserved();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public String getReservedName(int i2) {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getReservedName(i2);
            default:
                return ((y) this.f2351g).getReservedName(i2);
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public l getReservedNameBytes(int i2) {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getReservedNameBytes(i2);
            default:
                return ((y) this.f2351g).getReservedNameBytes(i2);
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public int getReservedNameCount() {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getReservedNameCount();
            default:
                return ((y) this.f2351g).getReservedNameCount();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public List getReservedNameList() {
        switch (this.f1544h) {
            case 7:
                return Collections.unmodifiableList(((u) this.f2351g).getReservedNameList());
            default:
                return Collections.unmodifiableList(((y) this.f2351g).getReservedNameList());
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public t getReservedRange(int i2) {
        return ((u) this.f2351g).getReservedRange(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public int getReservedRangeCount() {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).getReservedRangeCount();
            default:
                return ((y) this.f2351g).getReservedRangeCount();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public List getReservedRangeList() {
        switch (this.f1544h) {
            case 7:
                return Collections.unmodifiableList(((u) this.f2351g).getReservedRangeList());
            default:
                return Collections.unmodifiableList(((y) this.f2351g).getReservedRangeList());
        }
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return ((i3) this.f2351g).getResponseStreaming();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        return ((i3) this.f2351g).getResponseTypeUrl();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public l getResponseTypeUrlBytes() {
        return ((i3) this.f2351g).getResponseTypeUrlBytes();
    }

    @Override // com.stepos.protobuf.connection.ToolCallResultOrBuilder
    /* renamed from: getResult, reason: collision with other method in class */
    public String mo10getResult() {
        return ((i) this.f2351g).mo10getResult();
    }

    @Override // com.stepos.protobuf.connection.ToolCallResultOrBuilder
    public l getResultBytes() {
        return ((i) this.f2351g).getResultBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public b1 getSemantic() {
        return ((c1) this.f2351g).getSemantic();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public boolean getServerStreaming() {
        return ((e1) this.f2351g).getServerStreaming();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public j1 getService(int i2) {
        return ((y0) this.f2351g).getService(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getServiceCount() {
        return ((y0) this.f2351g).getServiceCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getServiceList() {
        return Collections.unmodifiableList(((y0) this.f2351g).getServiceList());
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public m1 getSourceCodeInfo() {
        return ((y0) this.f2351g).getSourceCodeInfo();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public String getSourceFile() {
        return ((c1) this.f2351g).getSourceFile();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public l getSourceFileBytes() {
        return ((c1) this.f2351g).getSourceFileBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public int getSpan(int i2) {
        return ((l1) this.f2351g).getSpan(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public int getSpanCount() {
        return ((l1) this.f2351g).getSpanCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public List getSpanList() {
        return Collections.unmodifiableList(((l1) this.f2351g).getSpanList());
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder
    public int getStart() {
        switch (this.f1544h) {
            case 8:
                return ((s) this.f2351g).getStart();
            case 9:
                return ((t) this.f2351g).getStart();
            default:
                return ((x) this.f2351g).getStart();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public l getStringValue() {
        return ((o1) this.f2351g).getStringValue();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public a4 getSyntax() {
        return ((i3) this.f2351g).getSyntax();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public l getSyntaxBytes() {
        return ((y0) this.f2351g).getSyntaxBytes();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return ((i3) this.f2351g).getSyntaxValue();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public f getTool() {
        return ((g) this.f2351g).getTool();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public String getTrailingComments() {
        return ((l1) this.f2351g).getTrailingComments();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public l getTrailingCommentsBytes() {
        return ((l1) this.f2351g).getTrailingCommentsBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    /* renamed from: getType, reason: collision with other method in class */
    public String mo12getType() {
        return ((d0) this.f2351g).mo12getType();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public l getTypeBytes() {
        return ((d0) this.f2351g).getTypeBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public String getTypeName() {
        return ((q0) this.f2351g).getTypeName();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public l getTypeNameBytes() {
        return ((q0) this.f2351g).getTypeNameBytes();
    }

    @Override // com.google.protobuf.AnyOrBuilder, com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        switch (this.f1544h) {
            case 6:
                return ((com.google.protobuf.f) this.f2351g).getTypeUrl();
            default:
                return ((a2) this.f2351g).getTypeUrl();
        }
    }

    @Override // com.google.protobuf.AnyOrBuilder, com.google.protobuf.FieldOrBuilder
    public l getTypeUrlBytes() {
        switch (this.f1544h) {
            case 6:
                return ((com.google.protobuf.f) this.f2351g).getTypeUrlBytes();
            default:
                return ((a2) this.f2351g).getTypeUrlBytes();
        }
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public l getValue() {
        return ((com.google.protobuf.f) this.f2351g).getValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder
    public l getValueBytes() {
        return ((s0) this.f2351g).getValueBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public int getValueCount() {
        return ((y) this.f2351g).getValueCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public List getValueList() {
        return Collections.unmodifiableList(((y) this.f2351g).getValueList());
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public n4 getValues(int i2) {
        return ((w2) this.f2351g).getValues(i2);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public int getValuesCount() {
        return ((w2) this.f2351g).getValuesCount();
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List getValuesList() {
        return Collections.unmodifiableList(((w2) this.f2351g).getValuesList());
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public String getVersion() {
        return ((f) this.f2351g).getVersion();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public l getVersionBytes() {
        return ((f) this.f2351g).getVersionBytes();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getWeakDependency(int i2) {
        return ((y0) this.f2351g).getWeakDependency(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public int getWeakDependencyCount() {
        return ((y0) this.f2351g).getWeakDependencyCount();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public List getWeakDependencyList() {
        return Collections.unmodifiableList(((y0) this.f2351g).getWeakDependencyList());
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public boolean hasAggregateValue() {
        return ((o1) this.f2351g).hasAggregateValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public boolean hasBegin() {
        return ((c1) this.f2351g).hasBegin();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public boolean hasClientStreaming() {
        return ((e1) this.f2351g).hasClientStreaming();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasDefaultValue() {
        return ((q0) this.f2351g).hasDefaultValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public boolean hasDeprecationWarning() {
        return ((t0) this.f2351g).hasDeprecationWarning();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public boolean hasDoubleValue() {
        return ((o1) this.f2351g).hasDoubleValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public boolean hasEdition() {
        switch (this.f1544h) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return ((n0) this.f2351g).hasEdition();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            default:
                return ((y0) this.f2351g).hasEdition();
            case 16:
                return ((s0) this.f2351g).hasEdition();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public boolean hasEditionDeprecated() {
        return ((t0) this.f2351g).hasEditionDeprecated();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public boolean hasEditionIntroduced() {
        return ((t0) this.f2351g).hasEditionIntroduced();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public boolean hasEditionRemoved() {
        return ((t0) this.f2351g).hasEditionRemoved();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public boolean hasEnd() {
        switch (this.f1544h) {
            case 8:
                return ((s) this.f2351g).hasEnd();
            case 9:
                return ((t) this.f2351g).hasEnd();
            case 10:
            default:
                return ((c1) this.f2351g).hasEnd();
            case 11:
                return ((x) this.f2351g).hasEnd();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasExtendee() {
        return ((q0) this.f2351g).hasExtendee();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public boolean hasFixedFeatures() {
        return ((n0) this.f2351g).hasFixedFeatures();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public boolean hasFullName() {
        return ((d0) this.f2351g).hasFullName();
    }

    @Override // com.stepos.protobuf.connection.StreamMsgOrBuilder
    public boolean hasHead() {
        return ((d) this.f2351g).hasHead();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public boolean hasIdentifierValue() {
        return ((o1) this.f2351g).hasIdentifierValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public boolean hasInputType() {
        return ((e1) this.f2351g).hasInputType();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public boolean hasIsExtension() {
        return ((n1) this.f2351g).hasIsExtension();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasJsonName() {
        return ((q0) this.f2351g).hasJsonName();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasLabel() {
        return ((q0) this.f2351g).hasLabel();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public boolean hasLeadingComments() {
        return ((l1) this.f2351g).hasLeadingComments();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public boolean hasName() {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).hasName();
            case 10:
                return ((y) this.f2351g).hasName();
            case 12:
                return ((b0) this.f2351g).hasName();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).hasName();
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                return ((y0) this.f2351g).hasName();
            case 20:
                return ((e1) this.f2351g).hasName();
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                return ((h1) this.f2351g).hasName();
            default:
                return ((j1) this.f2351g).hasName();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public boolean hasNamePart() {
        return ((n1) this.f2351g).hasNamePart();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public boolean hasNegativeIntValue() {
        return ((o1) this.f2351g).hasNegativeIntValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasNumber() {
        switch (this.f1544h) {
            case 12:
                return ((b0) this.f2351g).hasNumber();
            case 13:
                return ((d0) this.f2351g).hasNumber();
            default:
                return ((q0) this.f2351g).hasNumber();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasOneofIndex() {
        return ((q0) this.f2351g).hasOneofIndex();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public boolean hasOptions() {
        switch (this.f1544h) {
            case 7:
                return ((u) this.f2351g).hasOptions();
            case 8:
                return ((s) this.f2351g).hasOptions();
            case 9:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            default:
                return ((j1) this.f2351g).hasOptions();
            case 10:
                return ((y) this.f2351g).hasOptions();
            case 12:
                return ((b0) this.f2351g).hasOptions();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return ((q0) this.f2351g).hasOptions();
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                return ((y0) this.f2351g).hasOptions();
            case 20:
                return ((e1) this.f2351g).hasOptions();
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                return ((h1) this.f2351g).hasOptions();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public boolean hasOutputType() {
        return ((e1) this.f2351g).hasOutputType();
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public boolean hasOverridableFeatures() {
        return ((n0) this.f2351g).hasOverridableFeatures();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public boolean hasPackage() {
        return ((y0) this.f2351g).hasPackage();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public boolean hasParams() {
        return ((g) this.f2351g).hasParams();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public boolean hasPositiveIntValue() {
        return ((o1) this.f2351g).hasPositiveIntValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasProto3Optional() {
        return ((q0) this.f2351g).hasProto3Optional();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public boolean hasRepeated() {
        return ((d0) this.f2351g).hasRepeated();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public boolean hasReserved() {
        return ((d0) this.f2351g).hasReserved();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public boolean hasResult() {
        return ((g) this.f2351g).hasResult();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public boolean hasSemantic() {
        return ((c1) this.f2351g).hasSemantic();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public boolean hasServerStreaming() {
        return ((e1) this.f2351g).hasServerStreaming();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public boolean hasSourceCodeInfo() {
        return ((y0) this.f2351g).hasSourceCodeInfo();
    }

    @Override // com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public boolean hasSourceFile() {
        return ((c1) this.f2351g).hasSourceFile();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder
    public boolean hasStart() {
        switch (this.f1544h) {
            case 8:
                return ((s) this.f2351g).hasStart();
            case 9:
                return ((t) this.f2351g).hasStart();
            default:
                return ((x) this.f2351g).hasStart();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public boolean hasStringValue() {
        return ((o1) this.f2351g).hasStringValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public boolean hasSyntax() {
        return ((y0) this.f2351g).hasSyntax();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public boolean hasTool() {
        return ((g) this.f2351g).hasTool();
    }

    @Override // com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder
    public boolean hasTrailingComments() {
        return ((l1) this.f2351g).hasTrailingComments();
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasType() {
        switch (this.f1544h) {
            case 13:
                return ((d0) this.f2351g).hasType();
            default:
                return ((q0) this.f2351g).hasType();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public boolean hasTypeName() {
        return ((q0) this.f2351g).hasTypeName();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder
    public boolean hasValue() {
        return ((s0) this.f2351g).hasValue();
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public h getParams() {
        return ((g) this.f2351g).getParams();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    /* renamed from: getReservedRange, reason: collision with other method in class */
    public x mo9getReservedRange(int i2) {
        return ((y) this.f2351g).mo9getReservedRange(i2);
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public i getResult() {
        return ((g) this.f2351g).getResult();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    /* renamed from: getSyntax, reason: collision with other method in class */
    public String mo11getSyntax() {
        return ((y0) this.f2351g).mo11getSyntax();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public p0 getType() {
        return ((q0) this.f2351g).getType();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public b0 getValue(int i2) {
        return ((y) this.f2351g).getValue(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder
    /* renamed from: getValue, reason: collision with other method in class */
    public String mo13getValue() {
        return ((s0) this.f2351g).mo13getValue();
    }

    @Override // com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public a1 mo0getOptions() {
        return ((y0) this.f2351g).mo0getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public f0 mo3getOptions() {
        return ((s) this.f2351g).mo3getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public d1 mo2getOptions() {
        return ((u) this.f2351g).mo2getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public x0 mo7getOptions() {
        return ((q0) this.f2351g).mo7getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public i1 mo5getOptions() {
        return ((h1) this.f2351g).mo5getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public a0 getOptions() {
        return ((y) this.f2351g).getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public c0 mo1getOptions() {
        return ((b0) this.f2351g).mo1getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public k1 mo6getOptions() {
        return ((j1) this.f2351g).mo6getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    /* renamed from: getOptions, reason: collision with other method in class */
    public g1 mo4getOptions() {
        return ((e1) this.f2351g).mo4getOptions();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public n1 getName(int i2) {
        return ((o1) this.f2351g).getName(i2);
    }
}
