package u7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.PingRequest$Builder;

/* loaded from: classes2.dex */
public final class k extends GeneratedMessageLite implements Y1 {
    private static final k DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private long timestamp_;

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        GeneratedMessageLite.C(k.class, kVar);
    }

    public static void D(k kVar) {
        kVar.timestamp_ = 0L;
    }

    public static void E(k kVar, long j5) {
        kVar.timestamp_ = j5;
    }

    public final long G() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"timestamp_"});
            case 3:
                return new k();
            case 4:
                return new PingRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (k.class) {
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
