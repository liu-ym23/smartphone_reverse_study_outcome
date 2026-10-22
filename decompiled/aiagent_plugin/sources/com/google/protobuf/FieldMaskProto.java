package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class FieldMaskProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_FieldMask_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldMask_fieldAccessorTable = null;

    public static void registerAllExtensions(ExtensionRegistryLite r0) {
    }

    private FieldMaskProto() {
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", FieldMaskProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n google/protobuf/field_mask.proto\u0012\u000fgoogle.protobuf\"!\n\tFieldMask\u0012\u0014\n\u0005paths\u0018\u0001 \u0003(\tR\u0005pathsB\u0085\u0001\n\u0013com.google.protobufB\u000eFieldMaskProtoP\u0001Z2google.golang.org/protobuf/types/known/fieldmaskpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r0 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(0), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
        internal_static_google_protobuf_FieldMask_descriptor = r0;
        internal_static_google_protobuf_FieldMask_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r0, new String[]{"Paths"});
        descriptor.resolveAllFeaturesImmutable();
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
