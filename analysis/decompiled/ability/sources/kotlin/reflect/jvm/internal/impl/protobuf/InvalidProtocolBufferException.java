package kotlin.reflect.jvm.internal.impl.protobuf;

import H8.AbstractC0241b;
import java.io.IOException;

/* loaded from: classes4.dex */
public class InvalidProtocolBufferException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC0241b f5100a;

    public InvalidProtocolBufferException(String str) {
        super(str);
        this.f5100a = null;
    }

    public static InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
