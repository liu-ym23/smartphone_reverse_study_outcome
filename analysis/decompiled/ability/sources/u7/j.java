package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Content$Builder;
import com.zyql.protobuf.runtime.LLMResponse$Builder;
import q7.C1808f;

/* loaded from: classes2.dex */
public final class j extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_FIELD_NUMBER = 1;
    private static final j DEFAULT_INSTANCE;
    public static final int FINISH_REASON_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PARTIAL_FIELD_NUMBER = 2;
    public static final int SEQUENCE_INDEX_FIELD_NUMBER = 5;
    public static final int TURN_COMPLETE_FIELD_NUMBER = 3;
    private int bitField0_;
    private C1808f content_;
    private String finishReason_ = "";
    private Struct metadata_;
    private boolean partial_;
    private long sequenceIndex_;
    private boolean turnComplete_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        GeneratedMessageLite.C(j.class, jVar);
    }

    public static void D(j jVar) {
        jVar.content_ = null;
        jVar.bitField0_ &= -2;
    }

    public static void E(j jVar) {
        jVar.bitField0_ &= -3;
        jVar.finishReason_ = DEFAULT_INSTANCE.finishReason_;
    }

    public static void F(j jVar) {
        jVar.metadata_ = null;
        jVar.bitField0_ &= -9;
    }

    public static void G(j jVar) {
        jVar.partial_ = false;
    }

    public static void H(j jVar) {
        jVar.bitField0_ &= -5;
        jVar.sequenceIndex_ = 0L;
    }

    public static void I(j jVar) {
        jVar.turnComplete_ = false;
    }

    public static void J(j jVar, C1808f c1808f) {
        jVar.getClass();
        c1808f.getClass();
        C1808f c1808f2 = jVar.content_;
        if (c1808f2 == null || c1808f2 == C1808f.O()) {
            jVar.content_ = c1808f;
        } else {
            jVar.content_ = (C1808f) ((Content$Builder) C1808f.V(jVar.content_).mergeFrom((GeneratedMessageLite) c1808f)).m();
        }
        jVar.bitField0_ |= 1;
    }

    public static void K(j jVar, C1808f c1808f) {
        jVar.getClass();
        c1808f.getClass();
        jVar.content_ = c1808f;
        jVar.bitField0_ |= 1;
    }

    public static void L(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.bitField0_ |= 2;
        jVar.finishReason_ = str;
    }

    public static void M(j jVar, ByteString byteString) {
        jVar.getClass();
        AbstractC0932e.g(byteString);
        jVar.finishReason_ = byteString.q();
        jVar.bitField0_ |= 2;
    }

    public static void N(j jVar, Struct struct) {
        jVar.getClass();
        struct.getClass();
        jVar.metadata_ = struct;
        jVar.bitField0_ |= 8;
    }

    public static void O(j jVar, boolean z10) {
        jVar.partial_ = z10;
    }

    public static void P(j jVar, long j5) {
        jVar.bitField0_ |= 4;
        jVar.sequenceIndex_ = j5;
    }

    public static void Q(j jVar, boolean z10) {
        jVar.turnComplete_ = z10;
    }

    public static j T() {
        return DEFAULT_INSTANCE;
    }

    public static LLMResponse$Builder f0(j jVar) {
        return (LLMResponse$Builder) DEFAULT_INSTANCE.q(jVar);
    }

    public final C1808f S() {
        C1808f c1808f = this.content_;
        return c1808f == null ? C1808f.O() : c1808f;
    }

    public final String U() {
        return this.finishReason_;
    }

    public final ByteString V() {
        return ByteString.f(this.finishReason_);
    }

    public final Struct W() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.e : struct;
    }

    public final boolean X() {
        return this.partial_;
    }

    public final long Y() {
        return this.sequenceIndex_;
    }

    public final boolean Z() {
        return this.turnComplete_;
    }

    public final boolean a0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean b0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean c0() {
        return (this.bitField0_ & 8) != 0;
    }

    public final boolean d0() {
        return (this.bitField0_ & 4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e0(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.e) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = (Struct) ((C1014y2) Struct.F(struct2).mergeFrom((GeneratedMessageLite) struct)).m();
        }
        this.bitField0_ |= 8;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007\u0003\u0007\u0004ለ\u0001\u0005ဃ\u0002\u0006ဉ\u0003", new Object[]{"bitField0_", "content_", "partial_", "turnComplete_", "finishReason_", "sequenceIndex_", "metadata_"});
            case 3:
                return new j();
            case 4:
                return new LLMResponse$Builder(0);
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
