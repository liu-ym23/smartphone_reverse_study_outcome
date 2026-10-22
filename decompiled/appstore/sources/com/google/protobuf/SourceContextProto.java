package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class SourceContextProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_SourceContext_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable = null;

    static {
        Descriptors.FileDescriptor[] r10 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\"\"\n\rSourceContext\u0012\u0011\n\tfile_name\u0018\u0001 \u0001(\tBU\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001 \u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, r10, new AnonymousClass1());
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_SourceContext_descriptor = r11;
        internal_static_google_protobuf_SourceContext_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"FileName"});
    }

    private SourceContextProto() {
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
