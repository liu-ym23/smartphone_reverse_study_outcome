package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.Error$Builder;
import com.zyql.protobuf.agent.ErrorCode;
import java.util.Collections;
import java.util.Map;

/* renamed from: o7.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1773i extends GeneratedMessageLite implements Y1 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final C1773i DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private int code_;
    private MapFieldLite<String, String> details_ = MapFieldLite.b;
    private String message_ = "";

    static {
        C1773i c1773i = new C1773i();
        DEFAULT_INSTANCE = c1773i;
        GeneratedMessageLite.C(C1773i.class, c1773i);
    }

    public static void D(C1773i c1773i) {
        c1773i.code_ = 0;
    }

    public static void E(C1773i c1773i) {
        c1773i.getClass();
        c1773i.message_ = DEFAULT_INSTANCE.message_;
    }

    public static MapFieldLite F(C1773i c1773i) {
        MapFieldLite<String, String> mapFieldLite = c1773i.details_;
        if (!mapFieldLite.f2856a) {
            c1773i.details_ = mapFieldLite.h();
        }
        return c1773i.details_;
    }

    public static void G(C1773i c1773i, ErrorCode errorCode) {
        c1773i.getClass();
        c1773i.code_ = errorCode.getNumber();
    }

    public static void H(C1773i c1773i, int i) {
        c1773i.code_ = i;
    }

    public static void I(C1773i c1773i, String str) {
        c1773i.getClass();
        str.getClass();
        c1773i.message_ = str;
    }

    public static void J(C1773i c1773i, ByteString byteString) {
        c1773i.getClass();
        AbstractC0932e.g(byteString);
        c1773i.message_ = byteString.q();
    }

    public static C1773i N() {
        return DEFAULT_INSTANCE;
    }

    public static Error$Builder R(C1773i c1773i) {
        return (Error$Builder) DEFAULT_INSTANCE.q(c1773i);
    }

    public final ErrorCode L() {
        ErrorCode errorCode;
        switch (this.code_) {
            case 0:
                errorCode = ErrorCode.ERROR_UNSPECIFIED;
                break;
            case 1:
                errorCode = ErrorCode.ERROR_TIMEOUT;
                break;
            case 2:
                errorCode = ErrorCode.ERROR_NOT_FOUND;
                break;
            case 3:
                errorCode = ErrorCode.ERROR_INVALID_ARGUMENT;
                break;
            case 4:
                errorCode = ErrorCode.ERROR_PERMISSION_DENIED;
                break;
            case 5:
                errorCode = ErrorCode.ERROR_INTERNAL;
                break;
            case 6:
                errorCode = ErrorCode.ERROR_UNAVAILABLE;
                break;
            case 7:
                errorCode = ErrorCode.ERROR_CANCELLED;
                break;
            default:
                errorCode = null;
                break;
        }
        return errorCode == null ? ErrorCode.UNRECOGNIZED : errorCode;
    }

    public final int M() {
        return this.code_;
    }

    public final Map O() {
        return Collections.unmodifiableMap(this.details_);
    }

    public final String P() {
        return this.message_;
    }

    public final ByteString Q() {
        return ByteString.f(this.message_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object r(GeneratedMessageLite.MethodToInvoke methodToInvoke) {
        InterfaceC0955j2 c0922b1;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001\f\u0002Ȉ\u00032", new Object[]{"code_", "message_", "details_", AbstractC1772h.f5445a});
            case 3:
                return new C1773i();
            case 4:
                return new Error$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1773i.class) {
                    try {
                        c0922b1 = PARSER;
                        if (c0922b1 == null) {
                            c0922b1 = new C0922b1(DEFAULT_INSTANCE);
                            PARSER = c0922b1;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c0922b1;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
