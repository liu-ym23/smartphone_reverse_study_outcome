package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class z extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public boolean f587a;

    public static z a() {
        return new z("Protocol message had invalid UTF-8.");
    }

    public static y b() {
        return new y("Protocol message tag had invalid wire type.");
    }

    public static z c() {
        return new z("CodedInputStream encountered a malformed varint.");
    }

    public static z d() {
        return new z("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static z e() {
        return new z("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
