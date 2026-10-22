package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class b0 extends IOException {

    /* renamed from: f, reason: collision with root package name */
    public boolean f2177f;

    public static b0 a() {
        return new b0("Protocol message contained an invalid tag (zero).");
    }

    public static b0 b() {
        return new b0("Protocol message had invalid UTF-8.");
    }

    public static a0 c() {
        return new a0("Protocol message tag had invalid wire type.");
    }

    public static b0 d() {
        return new b0("CodedInputStream encountered a malformed varint.");
    }

    public static b0 e() {
        return new b0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static b0 f() {
        return new b0("Failed to parse the message.");
    }

    public static b0 g() {
        return new b0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
