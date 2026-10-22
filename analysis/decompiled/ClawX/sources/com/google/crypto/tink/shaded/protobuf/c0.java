package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class c0 extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1436a;

    public static c0 a() {
        return new c0("Protocol message contained an invalid tag (zero).");
    }

    public static c0 b() {
        return new c0("Protocol message had invalid UTF-8.");
    }

    public static b0 c() {
        return new b0("Protocol message tag had invalid wire type.");
    }

    public static c0 d() {
        return new c0("CodedInputStream encountered a malformed varint.");
    }

    public static c0 e() {
        return new c0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static c0 f() {
        return new c0("Failed to parse the message.");
    }

    public static c0 g() {
        return new c0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
