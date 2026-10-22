package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class F extends IOException {
    public static F a() {
        return new F("Protocol message had invalid UTF-8.");
    }

    public static E b() {
        return new E("Protocol message tag had invalid wire type.");
    }

    public static F c() {
        return new F("CodedInputStream encountered a malformed varint.");
    }

    public static F d() {
        return new F("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static F e() {
        return new F("Failed to parse the message.");
    }

    public static F f() {
        return new F("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
