package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.LogLevel;
import com.zyql.protobuf.common.LogMessage$Builder;
import com.zyql.protobuf.common.LogSender;

/* renamed from: q7.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1824w extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_FIELD_NUMBER = 3;
    private static final C1824w DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SENDER_FIELD_NUMBER = 1;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private String content_ = "";
    private int level_;
    private int sender_;
    private long timestamp_;

    static {
        C1824w c1824w = new C1824w();
        DEFAULT_INSTANCE = c1824w;
        GeneratedMessageLite.C(C1824w.class, c1824w);
    }

    public static void D(C1824w c1824w) {
        c1824w.getClass();
        c1824w.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void E(C1824w c1824w) {
        c1824w.level_ = 0;
    }

    public static void F(C1824w c1824w) {
        c1824w.sender_ = 0;
    }

    public static void G(C1824w c1824w) {
        c1824w.timestamp_ = 0L;
    }

    public static void H(C1824w c1824w, String str) {
        c1824w.getClass();
        str.getClass();
        c1824w.content_ = str;
    }

    public static void I(C1824w c1824w, ByteString byteString) {
        c1824w.getClass();
        AbstractC0932e.g(byteString);
        c1824w.content_ = byteString.q();
    }

    public static void J(C1824w c1824w, LogLevel logLevel) {
        c1824w.getClass();
        c1824w.level_ = logLevel.getNumber();
    }

    public static void K(C1824w c1824w, int i) {
        c1824w.level_ = i;
    }

    public static void L(C1824w c1824w, LogSender logSender) {
        c1824w.getClass();
        c1824w.sender_ = logSender.getNumber();
    }

    public static void M(C1824w c1824w, int i) {
        c1824w.sender_ = i;
    }

    public static void N(C1824w c1824w, long j5) {
        c1824w.timestamp_ = j5;
    }

    public static C1824w R() {
        return DEFAULT_INSTANCE;
    }

    public static LogMessage$Builder X(C1824w c1824w) {
        return (LogMessage$Builder) DEFAULT_INSTANCE.q(c1824w);
    }

    public final String P() {
        return this.content_;
    }

    public final ByteString Q() {
        return ByteString.f(this.content_);
    }

    public final LogLevel S() {
        LogLevel logLevelA = LogLevel.a(this.level_);
        return logLevelA == null ? LogLevel.UNRECOGNIZED : logLevelA;
    }

    public final int T() {
        return this.level_;
    }

    public final LogSender U() {
        int i = this.sender_;
        LogSender logSender = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : LogSender.LOG_SENDER_AGENT : LogSender.LOG_SENDER_RUNTIME : LogSender.LOG_SENDER_APP : LogSender.LOG_SENDER_UNSPECIFIED;
        return logSender == null ? LogSender.UNRECOGNIZED : logSender;
    }

    public final int V() {
        return this.sender_;
    }

    public final long W() {
        return this.timestamp_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ\u0004\u0002", new Object[]{"sender_", "level_", "content_", "timestamp_"});
            case 3:
                return new C1824w();
            case 4:
                return new LogMessage$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1824w.class) {
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
