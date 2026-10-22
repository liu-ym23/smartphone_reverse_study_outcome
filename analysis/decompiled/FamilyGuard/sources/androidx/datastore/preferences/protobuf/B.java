package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class B extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private S f9910a;

    public static class a extends B {
        public a(String str) {
            super(str);
        }
    }

    public B(String str) {
        super(str);
        this.f9910a = null;
    }

    static B a() {
        return new B("Protocol message end-group tag did not match expected tag.");
    }

    static B b() {
        return new B("Protocol message contained an invalid tag (zero).");
    }

    static B c() {
        return new B("Protocol message had invalid UTF-8.");
    }

    static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    static B e() {
        return new B("CodedInputStream encountered a malformed varint.");
    }

    static B f() {
        return new B("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static B g() {
        return new B("Failed to parse the message.");
    }

    static B h() {
        return new B("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static B j() {
        return new B("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static B k() {
        return new B("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public B i(S s5) {
        this.f9910a = s5;
        return this;
    }
}
