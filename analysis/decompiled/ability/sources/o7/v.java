package o7;

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
import com.zyql.protobuf.agent.ModelConfig$Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class v extends GeneratedMessageLite implements Y1 {
    private static final v DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int MAX_TOKENS_FIELD_NUMBER = 4;
    public static final int MODEL_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 1;
    public static final int STOP_FIELD_NUMBER = 6;
    public static final int TEMPERATURE_FIELD_NUMBER = 3;
    public static final int TOP_P_FIELD_NUMBER = 5;
    private int bitField0_;
    private int maxTokens_;
    private float temperature_;
    private float topP_;
    private MapFieldLite<String, String> extra_ = MapFieldLite.b;
    private String provider_ = "";
    private String model_ = "";
    private InterfaceC0985r1 stop_ = C0967m2.d;

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        GeneratedMessageLite.C(v.class, vVar);
    }

    public static void D(v vVar, Iterable iterable) {
        vVar.W();
        AbstractC0928d.addAll(iterable, (List) vVar.stop_);
    }

    public static void E(v vVar, String str) {
        vVar.getClass();
        str.getClass();
        vVar.W();
        vVar.stop_.add(str);
    }

    public static void F(v vVar, ByteString byteString) {
        vVar.getClass();
        AbstractC0932e.g(byteString);
        vVar.W();
        vVar.stop_.add(byteString.q());
    }

    public static void G(v vVar) {
        vVar.bitField0_ &= -3;
        vVar.maxTokens_ = 0;
    }

    public static void H(v vVar) {
        vVar.getClass();
        vVar.model_ = DEFAULT_INSTANCE.model_;
    }

    public static void I(v vVar) {
        vVar.getClass();
        vVar.provider_ = DEFAULT_INSTANCE.provider_;
    }

    public static void J(v vVar) {
        vVar.getClass();
        vVar.stop_ = C0967m2.d;
    }

    public static void K(v vVar) {
        vVar.bitField0_ &= -2;
        vVar.temperature_ = 0.0f;
    }

    public static void L(v vVar) {
        vVar.bitField0_ &= -5;
        vVar.topP_ = 0.0f;
    }

    public static MapFieldLite M(v vVar) {
        MapFieldLite<String, String> mapFieldLite = vVar.extra_;
        if (!mapFieldLite.f2856a) {
            vVar.extra_ = mapFieldLite.h();
        }
        return vVar.extra_;
    }

    public static void N(v vVar, int i) {
        vVar.bitField0_ |= 2;
        vVar.maxTokens_ = i;
    }

    public static void O(v vVar, String str) {
        vVar.getClass();
        str.getClass();
        vVar.model_ = str;
    }

    public static void P(v vVar, ByteString byteString) {
        vVar.getClass();
        AbstractC0932e.g(byteString);
        vVar.model_ = byteString.q();
    }

    public static void Q(v vVar, String str) {
        vVar.getClass();
        str.getClass();
        vVar.provider_ = str;
    }

    public static void R(v vVar, ByteString byteString) {
        vVar.getClass();
        AbstractC0932e.g(byteString);
        vVar.provider_ = byteString.q();
    }

    public static void S(v vVar, int i, String str) {
        vVar.getClass();
        str.getClass();
        vVar.W();
        vVar.stop_.set(i, str);
    }

    public static void T(v vVar, float f) {
        vVar.bitField0_ |= 1;
        vVar.temperature_ = f;
    }

    public static void U(v vVar, float f) {
        vVar.bitField0_ |= 4;
        vVar.topP_ = f;
    }

    public static v X() {
        return DEFAULT_INSTANCE;
    }

    public static ModelConfig$Builder n0(v vVar) {
        return (ModelConfig$Builder) DEFAULT_INSTANCE.q(vVar);
    }

    public final void W() {
        InterfaceC0985r1 interfaceC0985r1 = this.stop_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.stop_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final Map Y() {
        return Collections.unmodifiableMap(this.extra_);
    }

    public final int Z() {
        return this.maxTokens_;
    }

    public final String a0() {
        return this.model_;
    }

    public final ByteString b0() {
        return ByteString.f(this.model_);
    }

    public final String c0() {
        return this.provider_;
    }

    public final ByteString d0() {
        return ByteString.f(this.provider_);
    }

    public final String e0(int i) {
        return (String) this.stop_.get(i);
    }

    public final ByteString f0(int i) {
        return ByteString.f((String) this.stop_.get(i));
    }

    public final int g0() {
        return this.stop_.size();
    }

    public final List h0() {
        return this.stop_;
    }

    public final float i0() {
        return this.temperature_;
    }

    public final float j0() {
        return this.topP_;
    }

    public final boolean k0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean l0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean m0() {
        return (this.bitField0_ & 4) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ခ\u0000\u0004င\u0001\u0005ခ\u0002\u0006Ț\u00072", new Object[]{"bitField0_", "provider_", "model_", "temperature_", "maxTokens_", "topP_", "stop_", "extra_", u.f5447a});
            case 3:
                return new v();
            case 4:
                return new ModelConfig$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (v.class) {
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
