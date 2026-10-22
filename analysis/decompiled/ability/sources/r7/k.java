package r7;

import com.google.protobuf.AbstractC0972o;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0968n;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.R0;
import com.google.protobuf.W2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.connection.Head$Builder;
import com.zyql.protobuf.connection.StreamMsg$Builder;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class k extends GeneratedMessageLite implements Y1 {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final k DEFAULT_INSTANCE;
    public static final int HEAD_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private int bitField0_;
    private ByteString body_ = ByteString.b;
    private f head_;

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        GeneratedMessageLite.C(k.class, kVar);
    }

    public static void D(k kVar) {
        kVar.getClass();
        kVar.body_ = DEFAULT_INSTANCE.body_;
    }

    public static void E(k kVar) {
        kVar.head_ = null;
        kVar.bitField0_ &= -2;
    }

    public static void F(k kVar, f fVar) {
        kVar.getClass();
        fVar.getClass();
        f fVar2 = kVar.head_;
        if (fVar2 == null || fVar2 == f.V()) {
            kVar.head_ = fVar;
        } else {
            kVar.head_ = (f) ((Head$Builder) f.f0(kVar.head_).mergeFrom((GeneratedMessageLite) fVar)).m();
        }
        kVar.bitField0_ |= 1;
    }

    public static void G(k kVar, ByteString byteString) {
        kVar.getClass();
        byteString.getClass();
        kVar.body_ = byteString;
    }

    public static void H(k kVar, f fVar) {
        kVar.getClass();
        fVar.getClass();
        kVar.head_ = fVar;
        kVar.bitField0_ |= 1;
    }

    public static StreamMsg$Builder M() {
        return (StreamMsg$Builder) DEFAULT_INSTANCE.p();
    }

    public static k N(ByteBuffer byteBuffer) {
        AbstractC0972o abstractC0972oH;
        k kVar = DEFAULT_INSTANCE;
        R0 r0A = R0.a();
        if (byteBuffer.hasArray()) {
            abstractC0972oH = AbstractC0972o.h(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), false);
        } else if (byteBuffer.isDirect() && W2.d) {
            abstractC0972oH = new C0968n(byteBuffer, false);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            abstractC0972oH = AbstractC0972o.h(bArr, 0, iRemaining, true);
        }
        GeneratedMessageLite generatedMessageLiteA = GeneratedMessageLite.A(kVar, abstractC0972oH, r0A);
        GeneratedMessageLite.o(generatedMessageLiteA);
        GeneratedMessageLite.o(generatedMessageLiteA);
        return (k) generatedMessageLiteA;
    }

    public final ByteString J() {
        return this.body_;
    }

    public final f K() {
        f fVar = this.head_;
        return fVar == null ? f.V() : fVar;
    }

    public final boolean L() {
        return (this.bitField0_ & 1) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n", new Object[]{"bitField0_", "head_", "body_"});
            case 3:
                return new k();
            case 4:
                return new StreamMsg$Builder(0);
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
