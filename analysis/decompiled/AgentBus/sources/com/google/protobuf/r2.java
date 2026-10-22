package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class r2 extends IOException {

    /* renamed from: f, reason: collision with root package name */
    public boolean f2512f;

    public static r2 a() {
        return new r2("Protocol message contained an invalid tag (zero).");
    }

    public static r2 b() {
        return new r2("Protocol message had invalid UTF-8.");
    }

    public static q2 c() {
        return new q2("Protocol message tag had invalid wire type.");
    }

    public static r2 d() {
        return new r2("CodedInputStream encountered a malformed varint.");
    }

    public static r2 e() {
        return new r2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static r2 f() {
        return new r2("Failed to parse the message.");
    }

    public static r2 g() {
        return new r2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
