package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class TimestampProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_Timestamp_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Timestamp_fieldAccessorTable = null;

    static {
        Descriptors.FileDescriptor[] r10 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fgoogle/protobuf/timestamp.proto\u0012\u000fgoogle.protobuf\"+\n\tTimestamp\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005B\u0081\u0001\n\u0013com.google.protobufB\u000eTimestampProtoP\u0001Z+github.com/golang/protobuf/ptypes/timestamp \u0001\u0001ø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, r10, new AnonymousClass1());
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Timestamp_descriptor = r11;
        internal_static_google_protobuf_Timestamp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Seconds", "Nanos"});
    }

    private TimestampProto() {
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
