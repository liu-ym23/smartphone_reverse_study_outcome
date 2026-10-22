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
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.ChatMessage$Builder;
import com.zyql.protobuf.agent.CompletionResponse$Builder;
import com.zyql.protobuf.agent.TokenUsage$Builder;
import java.util.List;
import q7.C1810h;

/* renamed from: o7.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1770f extends GeneratedMessageLite implements Y1 {
    private static final C1770f DEFAULT_INSTANCE;
    public static final int FINISH_REASON_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PROVIDER_ERROR_FIELD_NUMBER = 5;
    public static final int TOKEN_USAGE_FIELD_NUMBER = 4;
    public static final int TOOL_CALLS_FIELD_NUMBER = 2;
    private int bitField0_;
    private C1768d message_;
    private y tokenUsage_;
    private InterfaceC0985r1 toolCalls_ = C0967m2.d;
    private String finishReason_ = "";
    private String providerError_ = "";

    static {
        C1770f c1770f = new C1770f();
        DEFAULT_INSTANCE = c1770f;
        GeneratedMessageLite.C(C1770f.class, c1770f);
    }

    public static void D(C1770f c1770f, Iterable iterable) {
        c1770f.W();
        AbstractC0928d.addAll(iterable, (List) c1770f.toolCalls_);
    }

    public static void E(C1770f c1770f, int i, C1810h c1810h) {
        c1770f.getClass();
        c1810h.getClass();
        c1770f.W();
        c1770f.toolCalls_.add(i, c1810h);
    }

    public static void F(C1770f c1770f, C1810h c1810h) {
        c1770f.getClass();
        c1810h.getClass();
        c1770f.W();
        c1770f.toolCalls_.add(c1810h);
    }

    public static void G(C1770f c1770f) {
        c1770f.getClass();
        c1770f.finishReason_ = DEFAULT_INSTANCE.finishReason_;
    }

    public static void H(C1770f c1770f) {
        c1770f.message_ = null;
        c1770f.bitField0_ &= -2;
    }

    public static void I(C1770f c1770f) {
        c1770f.bitField0_ &= -5;
        c1770f.providerError_ = DEFAULT_INSTANCE.providerError_;
    }

    public static void J(C1770f c1770f) {
        c1770f.tokenUsage_ = null;
        c1770f.bitField0_ &= -3;
    }

    public static void K(C1770f c1770f) {
        c1770f.getClass();
        c1770f.toolCalls_ = C0967m2.d;
    }

    public static void L(C1770f c1770f, C1768d c1768d) {
        c1770f.getClass();
        c1768d.getClass();
        C1768d c1768d2 = c1770f.message_;
        if (c1768d2 == null || c1768d2 == C1768d.P()) {
            c1770f.message_ = c1768d;
        } else {
            c1770f.message_ = (C1768d) ((ChatMessage$Builder) C1768d.V(c1770f.message_).mergeFrom((GeneratedMessageLite) c1768d)).m();
        }
        c1770f.bitField0_ |= 1;
    }

    public static void M(C1770f c1770f, y yVar) {
        c1770f.getClass();
        yVar.getClass();
        y yVar2 = c1770f.tokenUsage_;
        if (yVar2 == null || yVar2 == y.L()) {
            c1770f.tokenUsage_ = yVar;
        } else {
            c1770f.tokenUsage_ = (y) ((TokenUsage$Builder) y.O(c1770f.tokenUsage_).mergeFrom((GeneratedMessageLite) yVar)).m();
        }
        c1770f.bitField0_ |= 2;
    }

    public static void N(C1770f c1770f, int i) {
        c1770f.W();
        c1770f.toolCalls_.remove(i);
    }

    public static void O(C1770f c1770f, String str) {
        c1770f.getClass();
        str.getClass();
        c1770f.finishReason_ = str;
    }

    public static void P(C1770f c1770f, ByteString byteString) {
        c1770f.getClass();
        AbstractC0932e.g(byteString);
        c1770f.finishReason_ = byteString.q();
    }

    public static void Q(C1770f c1770f, C1768d c1768d) {
        c1770f.getClass();
        c1768d.getClass();
        c1770f.message_ = c1768d;
        c1770f.bitField0_ |= 1;
    }

    public static void R(C1770f c1770f, String str) {
        c1770f.getClass();
        str.getClass();
        c1770f.bitField0_ |= 4;
        c1770f.providerError_ = str;
    }

    public static void S(C1770f c1770f, ByteString byteString) {
        c1770f.getClass();
        AbstractC0932e.g(byteString);
        c1770f.providerError_ = byteString.q();
        c1770f.bitField0_ |= 4;
    }

    public static void T(C1770f c1770f, y yVar) {
        c1770f.getClass();
        yVar.getClass();
        c1770f.tokenUsage_ = yVar;
        c1770f.bitField0_ |= 2;
    }

    public static void U(C1770f c1770f, int i, C1810h c1810h) {
        c1770f.getClass();
        c1810h.getClass();
        c1770f.W();
        c1770f.toolCalls_.set(i, c1810h);
    }

    public final void W() {
        InterfaceC0985r1 interfaceC0985r1 = this.toolCalls_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.toolCalls_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String X() {
        return this.finishReason_;
    }

    public final ByteString Y() {
        return ByteString.f(this.finishReason_);
    }

    public final C1768d Z() {
        C1768d c1768d = this.message_;
        return c1768d == null ? C1768d.P() : c1768d;
    }

    public final String a0() {
        return this.providerError_;
    }

    public final ByteString b0() {
        return ByteString.f(this.providerError_);
    }

    public final y c0() {
        y yVar = this.tokenUsage_;
        return yVar == null ? y.L() : yVar;
    }

    public final C1810h d0(int i) {
        return (C1810h) this.toolCalls_.get(i);
    }

    public final int e0() {
        return this.toolCalls_.size();
    }

    public final List f0() {
        return this.toolCalls_;
    }

    public final boolean g0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean h0() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean i0() {
        return (this.bitField0_ & 2) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003Ȉ\u0004ဉ\u0001\u0005ለ\u0002", new Object[]{"bitField0_", "message_", "toolCalls_", C1810h.class, "finishReason_", "tokenUsage_", "providerError_"});
            case 3:
                return new C1770f();
            case 4:
                return new CompletionResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1770f.class) {
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
