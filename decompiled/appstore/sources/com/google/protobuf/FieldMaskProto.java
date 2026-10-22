package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class FieldMaskProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_FieldMask_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_FieldMask_fieldAccessorTable = null;

    static {
        Descriptors.FileDescriptor[] r10 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n google/protobuf/field_mask.proto\u0012\u000fgoogle.protobuf\"\u001a\n\tFieldMask\u0012\r\n\u0005paths\u0018\u0001 \u0003(\tBQ\n\u0013com.google.protobufB\u000eFieldMaskProtoP\u0001 \u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, r10, new AnonymousClass1());
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_FieldMask_descriptor = r11;
        internal_static_google_protobuf_FieldMask_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Paths"});
    }

    private FieldMaskProto() {
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$002(Descriptors.FileDescriptor r10) {
        descriptor = r10;
        return r10;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite r10) {
    }

    public static void registerAllExtensions(ExtensionRegistry r10) {
        registerAllExtensions(r10);
    }
}
