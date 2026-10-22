package q7;

import com.google.protobuf.AbstractC0928d;
import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.AbstractC0940g;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0967m2;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.InterfaceC0985r1;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.ModelCallPreHookData$Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class F extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 5;
    private static final F DEFAULT_INSTANCE;
    public static final int MODEL_NAME_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 2;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int SETTINGS_FIELD_NUMBER = 6;
    public static final int TOOL_CALLS_FIELD_NUMBER = 3;
    private MapFieldLite<String, String> settings_ = MapFieldLite.b;
    private String modelName_ = "";
    private String provider_ = "";
    private InterfaceC0985r1 toolCalls_ = C0967m2.d;
    private String sessionId_ = "";
    private String agentId_ = "";

    static {
        F f = new F();
        DEFAULT_INSTANCE = f;
        GeneratedMessageLite.C(F.class, f);
    }

    public static void D(F f, Iterable iterable) {
        f.X();
        AbstractC0928d.addAll(iterable, (List) f.toolCalls_);
    }

    public static void E(F f, int i, C1810h c1810h) {
        f.getClass();
        c1810h.getClass();
        f.X();
        f.toolCalls_.add(i, c1810h);
    }

    public static void F(F f, C1810h c1810h) {
        f.getClass();
        c1810h.getClass();
        f.X();
        f.toolCalls_.add(c1810h);
    }

    public static void G(F f) {
        f.getClass();
        f.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void H(F f) {
        f.getClass();
        f.modelName_ = DEFAULT_INSTANCE.modelName_;
    }

    public static void I(F f) {
        f.getClass();
        f.provider_ = DEFAULT_INSTANCE.provider_;
    }

    public static void J(F f) {
        f.getClass();
        f.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void K(F f) {
        f.getClass();
        f.toolCalls_ = C0967m2.d;
    }

    public static MapFieldLite L(F f) {
        MapFieldLite<String, String> mapFieldLite = f.settings_;
        if (!mapFieldLite.f2856a) {
            f.settings_ = mapFieldLite.h();
        }
        return f.settings_;
    }

    public static void M(F f, int i) {
        f.X();
        f.toolCalls_.remove(i);
    }

    public static void N(F f, String str) {
        f.getClass();
        str.getClass();
        f.agentId_ = str;
    }

    public static void O(F f, ByteString byteString) {
        f.getClass();
        AbstractC0932e.g(byteString);
        f.agentId_ = byteString.q();
    }

    public static void P(F f, String str) {
        f.getClass();
        str.getClass();
        f.modelName_ = str;
    }

    public static void Q(F f, ByteString byteString) {
        f.getClass();
        AbstractC0932e.g(byteString);
        f.modelName_ = byteString.q();
    }

    public static void R(F f, String str) {
        f.getClass();
        str.getClass();
        f.provider_ = str;
    }

    public static void S(F f, ByteString byteString) {
        f.getClass();
        AbstractC0932e.g(byteString);
        f.provider_ = byteString.q();
    }

    public static void T(F f, String str) {
        f.getClass();
        str.getClass();
        f.sessionId_ = str;
    }

    public static void U(F f, ByteString byteString) {
        f.getClass();
        AbstractC0932e.g(byteString);
        f.sessionId_ = byteString.q();
    }

    public static void V(F f, int i, C1810h c1810h) {
        f.getClass();
        c1810h.getClass();
        f.X();
        f.toolCalls_.set(i, c1810h);
    }

    public static F a0() {
        return DEFAULT_INSTANCE;
    }

    public static ModelCallPreHookData$Builder l0(F f) {
        return (ModelCallPreHookData$Builder) DEFAULT_INSTANCE.q(f);
    }

    public final void X() {
        InterfaceC0985r1 interfaceC0985r1 = this.toolCalls_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.toolCalls_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String Y() {
        return this.agentId_;
    }

    public final ByteString Z() {
        return ByteString.f(this.agentId_);
    }

    public final String b0() {
        return this.modelName_;
    }

    public final ByteString c0() {
        return ByteString.f(this.modelName_);
    }

    public final String d0() {
        return this.provider_;
    }

    public final ByteString e0() {
        return ByteString.f(this.provider_);
    }

    public final String f0() {
        return this.sessionId_;
    }

    public final ByteString g0() {
        return ByteString.f(this.sessionId_);
    }

    public final Map h0() {
        return Collections.unmodifiableMap(this.settings_);
    }

    public final C1810h i0(int i) {
        return (C1810h) this.toolCalls_.get(i);
    }

    public final int j0() {
        return this.toolCalls_.size();
    }

    public final List k0() {
        return this.toolCalls_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"modelName_", "provider_", "toolCalls_", C1810h.class, "sessionId_", "agentId_", "settings_", E.f5583a});
            case 3:
                return new F();
            case 4:
                return new ModelCallPreHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (F.class) {
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
