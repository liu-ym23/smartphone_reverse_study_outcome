package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class WrappersProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_BoolValue_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_BoolValue_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_BytesValue_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_BytesValue_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_DoubleValue_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DoubleValue_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_FloatValue_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FloatValue_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Int32Value_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_Int32Value_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Int64Value_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_Int64Value_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_StringValue_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_StringValue_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_UInt32Value_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UInt32Value_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_UInt64Value_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UInt64Value_fieldAccessorTable = null;

    public static void registerAllExtensions(ExtensionRegistryLite r0) {
    }

    private WrappersProto() {
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", WrappersProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001egoogle/protobuf/wrappers.proto\u0012\u000fgoogle.protobuf\"#\n\u000bDoubleValue\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\u0001R\u0005value\"\"\n\nFloatValue\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\u0002R\u0005value\"\"\n\nInt64Value\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\u0003R\u0005value\"#\n\u000bUInt64Value\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\u0004R\u0005value\"\"\n\nInt32Value\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\u0005R\u0005value\"#\n\u000bUInt32Value\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\rR\u0005value\"!\n\tBoolValue\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\bR\u0005value\"#\n\u000bStringValue\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\tR\u0005value\"\"\n\nBytesValue\u0012\u0014\n\u0005value\u0018\u0001 \u0001(\fR\u0005valueB\u0083\u0001\n\u0013com.google.protobufB\rWrappersProtoP\u0001Z1google.golang.org/protobuf/types/known/wrapperspbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r0 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(0), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_DoubleValue_descriptor = r0;
        internal_static_google_protobuf_DoubleValue_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r0, new String[]{"Value"});
        Descriptors.Descriptor r1 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(1), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_FloatValue_descriptor = r1;
        internal_static_google_protobuf_FloatValue_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r1, new String[]{"Value"});
        Descriptors.Descriptor r2 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(2), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_Int64Value_descriptor = r2;
        internal_static_google_protobuf_Int64Value_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r2, new String[]{"Value"});
        Descriptors.Descriptor r3 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(3), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_UInt64Value_descriptor = r3;
        internal_static_google_protobuf_UInt64Value_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r3, new String[]{"Value"});
        Descriptors.Descriptor r4 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(4), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_Int32Value_descriptor = r4;
        internal_static_google_protobuf_Int32Value_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r4, new String[]{"Value"});
        Descriptors.Descriptor r5 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(5), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_UInt32Value_descriptor = r5;
        internal_static_google_protobuf_UInt32Value_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r5, new String[]{"Value"});
        Descriptors.Descriptor r6 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(6), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_BoolValue_descriptor = r6;
        internal_static_google_protobuf_BoolValue_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r6, new String[]{"Value"});
        Descriptors.Descriptor r7 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(7), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_StringValue_descriptor = r7;
        internal_static_google_protobuf_StringValue_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r7, new String[]{"Value"});
        Descriptors.Descriptor r8 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(8), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_BytesValue_descriptor = r8;
        internal_static_google_protobuf_BytesValue_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r8, new String[]{"Value"});
        descriptor.resolveAllFeaturesImmutable();
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
