package r7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.connection.LogoutReq$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j extends GeneratedMessageLite implements Y1 {
    private static final j DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RESERVED_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> reserved_ = MapFieldLite.b;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        GeneratedMessageLite.C(j.class, jVar);
    }

    public static MapFieldLite D(j jVar) {
        MapFieldLite<String, String> mapFieldLite = jVar.reserved_;
        if (!mapFieldLite.f2856a) {
            jVar.reserved_ = mapFieldLite.h();
        }
        return jVar.reserved_;
    }

    public final Map F() {
        return Collections.unmodifiableMap(this.reserved_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"reserved_", i.f5679a});
            case 3:
                return new j();
            case 4:
                return new LogoutReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (j.class) {
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
