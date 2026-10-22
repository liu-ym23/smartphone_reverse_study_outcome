package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.AskInput$Builder;
import com.zyql.protobuf.skull.Handoff$Builder;
import com.zyql.protobuf.skull.Interrupt$Builder;
import com.zyql.protobuf.skull.Item$Builder;
import com.zyql.protobuf.skull.Item$DataCase;
import com.zyql.protobuf.skull.Message$Builder;
import com.zyql.protobuf.skull.ToolCall$Builder;

/* loaded from: classes2.dex */
public final class h extends GeneratedMessageLite implements Y1 {
    public static final int ASK_INPUT_FIELD_NUMBER = 7;
    private static final h DEFAULT_INSTANCE;
    public static final int HANDOFF_FIELD_NUMBER = 9;
    public static final int INTERRUPT_FIELD_NUMBER = 8;
    public static final int ITEM_ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 2;
    public static final int TOOL_CALL_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 4;
    private Object data_;
    private int dataCase_ = 0;
    private String itemId_ = "";
    private String taskId_ = "";
    private String status_ = "";
    private String type_ = "";

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        GeneratedMessageLite.C(h.class, hVar);
    }

    public static Item$Builder A0(h hVar) {
        return (Item$Builder) DEFAULT_INSTANCE.q(hVar);
    }

    public static void D(h hVar) {
        if (hVar.dataCase_ == 7) {
            hVar.dataCase_ = 0;
            hVar.data_ = null;
        }
    }

    public static void E(h hVar) {
        hVar.dataCase_ = 0;
        hVar.data_ = null;
    }

    public static void F(h hVar) {
        if (hVar.dataCase_ == 9) {
            hVar.dataCase_ = 0;
            hVar.data_ = null;
        }
    }

    public static void G(h hVar) {
        if (hVar.dataCase_ == 8) {
            hVar.dataCase_ = 0;
            hVar.data_ = null;
        }
    }

    public static void H(h hVar) {
        hVar.getClass();
        hVar.itemId_ = DEFAULT_INSTANCE.itemId_;
    }

    public static void I(h hVar) {
        if (hVar.dataCase_ == 5) {
            hVar.dataCase_ = 0;
            hVar.data_ = null;
        }
    }

    public static void J(h hVar) {
        hVar.getClass();
        hVar.status_ = DEFAULT_INSTANCE.status_;
    }

    public static void K(h hVar) {
        hVar.getClass();
        hVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void L(h hVar) {
        if (hVar.dataCase_ == 6) {
            hVar.dataCase_ = 0;
            hVar.data_ = null;
        }
    }

    public static void M(h hVar) {
        hVar.getClass();
        hVar.type_ = DEFAULT_INSTANCE.type_;
    }

    public static void N(h hVar, C2064c c2064c) {
        hVar.getClass();
        c2064c.getClass();
        if (hVar.dataCase_ != 7 || hVar.data_ == C2064c.I()) {
            hVar.data_ = c2064c;
        } else {
            hVar.data_ = ((AskInput$Builder) C2064c.M((C2064c) hVar.data_).mergeFrom((GeneratedMessageLite) c2064c)).m();
        }
        hVar.dataCase_ = 7;
    }

    public static void O(h hVar, f fVar) {
        hVar.getClass();
        fVar.getClass();
        if (hVar.dataCase_ != 9 || hVar.data_ == f.H()) {
            hVar.data_ = fVar;
        } else {
            hVar.data_ = ((Handoff$Builder) f.K((f) hVar.data_).mergeFrom((GeneratedMessageLite) fVar)).m();
        }
        hVar.dataCase_ = 9;
    }

    public static void P(h hVar, g gVar) {
        hVar.getClass();
        gVar.getClass();
        if (hVar.dataCase_ != 8 || hVar.data_ == g.H()) {
            hVar.data_ = gVar;
        } else {
            hVar.data_ = ((Interrupt$Builder) g.K((g) hVar.data_).mergeFrom((GeneratedMessageLite) gVar)).m();
        }
        hVar.dataCase_ = 8;
    }

    public static void Q(h hVar, i iVar) {
        hVar.getClass();
        iVar.getClass();
        if (hVar.dataCase_ != 5 || hVar.data_ == i.T()) {
            hVar.data_ = iVar;
        } else {
            hVar.data_ = ((Message$Builder) i.a0((i) hVar.data_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        hVar.dataCase_ = 5;
    }

    public static void R(h hVar, v vVar) {
        hVar.getClass();
        vVar.getClass();
        if (hVar.dataCase_ != 6 || hVar.data_ == v.S()) {
            hVar.data_ = vVar;
        } else {
            hVar.data_ = ((ToolCall$Builder) v.Z((v) hVar.data_).mergeFrom((GeneratedMessageLite) vVar)).m();
        }
        hVar.dataCase_ = 6;
    }

    public static void S(h hVar, C2064c c2064c) {
        hVar.getClass();
        c2064c.getClass();
        hVar.data_ = c2064c;
        hVar.dataCase_ = 7;
    }

    public static void T(h hVar, f fVar) {
        hVar.getClass();
        fVar.getClass();
        hVar.data_ = fVar;
        hVar.dataCase_ = 9;
    }

    public static void U(h hVar, g gVar) {
        hVar.getClass();
        gVar.getClass();
        hVar.data_ = gVar;
        hVar.dataCase_ = 8;
    }

    public static void V(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.itemId_ = str;
    }

    public static void W(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.itemId_ = byteString.q();
    }

    public static void X(h hVar, i iVar) {
        hVar.getClass();
        iVar.getClass();
        hVar.data_ = iVar;
        hVar.dataCase_ = 5;
    }

    public static void Y(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.status_ = str;
    }

    public static void Z(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.status_ = byteString.q();
    }

    public static void a0(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.taskId_ = str;
    }

    public static void b0(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.taskId_ = byteString.q();
    }

    public static void c0(h hVar, v vVar) {
        hVar.getClass();
        vVar.getClass();
        hVar.data_ = vVar;
        hVar.dataCase_ = 6;
    }

    public static void d0(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.type_ = str;
    }

    public static void e0(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.type_ = byteString.q();
    }

    public static h i0() {
        return DEFAULT_INSTANCE;
    }

    public final C2064c g0() {
        return this.dataCase_ == 7 ? (C2064c) this.data_ : C2064c.I();
    }

    public final Item$DataCase h0() {
        int i = this.dataCase_;
        if (i == 0) {
            return Item$DataCase.f;
        }
        switch (i) {
            case 5:
                return Item$DataCase.f4280a;
            case 6:
                return Item$DataCase.b;
            case 7:
                return Item$DataCase.c;
            case 8:
                return Item$DataCase.d;
            case 9:
                return Item$DataCase.e;
            default:
                return null;
        }
    }

    public final f j0() {
        return this.dataCase_ == 9 ? (f) this.data_ : f.H();
    }

    public final g k0() {
        return this.dataCase_ == 8 ? (g) this.data_ : g.H();
    }

    public final String l0() {
        return this.itemId_;
    }

    public final ByteString m0() {
        return ByteString.f(this.itemId_);
    }

    public final i n0() {
        return this.dataCase_ == 5 ? (i) this.data_ : i.T();
    }

    public final String o0() {
        return this.status_;
    }

    public final ByteString p0() {
        return ByteString.f(this.status_);
    }

    public final String q0() {
        return this.taskId_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000", new Object[]{"data_", "dataCase_", "itemId_", "taskId_", "status_", "type_", i.class, v.class, C2064c.class, g.class, f.class});
            case 3:
                return new h();
            case 4:
                return new Item$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (h.class) {
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

    public final ByteString r0() {
        return ByteString.f(this.taskId_);
    }

    public final v s0() {
        return this.dataCase_ == 6 ? (v) this.data_ : v.S();
    }

    public final String t0() {
        return this.type_;
    }

    public final ByteString u0() {
        return ByteString.f(this.type_);
    }

    public final boolean v0() {
        return this.dataCase_ == 7;
    }

    public final boolean w0() {
        return this.dataCase_ == 9;
    }

    public final boolean x0() {
        return this.dataCase_ == 8;
    }

    public final boolean y0() {
        return this.dataCase_ == 5;
    }

    public final boolean z0() {
        return this.dataCase_ == 6;
    }
}
