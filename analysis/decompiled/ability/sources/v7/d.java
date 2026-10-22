package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Event$Builder;
import com.zyql.protobuf.skull.Event$DataCase;
import com.zyql.protobuf.skull.Item$Builder;
import com.zyql.protobuf.skull.MessageDelta$Builder;
import com.zyql.protobuf.skull.Task$Builder;

/* loaded from: classes2.dex */
public final class d extends GeneratedMessageLite implements Y1 {
    private static final d DEFAULT_INSTANCE;
    public static final int EVENT_ID_FIELD_NUMBER = 1;
    public static final int ITEM_FIELD_NUMBER = 4;
    public static final int MESSAGE_DELTA_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASK_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 101;
    public static final int TYPE_FIELD_NUMBER = 2;
    private Object data_;
    private int dataCase_ = 0;
    private String eventId_ = "";
    private String type_ = "";
    private String taskId_ = "";

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.C(d.class, dVar);
    }

    public static void D(d dVar) {
        dVar.dataCase_ = 0;
        dVar.data_ = null;
    }

    public static void E(d dVar) {
        dVar.getClass();
        dVar.eventId_ = DEFAULT_INSTANCE.eventId_;
    }

    public static void F(d dVar) {
        if (dVar.dataCase_ == 4) {
            dVar.dataCase_ = 0;
            dVar.data_ = null;
        }
    }

    public static void G(d dVar) {
        if (dVar.dataCase_ == 5) {
            dVar.dataCase_ = 0;
            dVar.data_ = null;
        }
    }

    public static void H(d dVar) {
        if (dVar.dataCase_ == 3) {
            dVar.dataCase_ = 0;
            dVar.data_ = null;
        }
    }

    public static void I(d dVar) {
        dVar.getClass();
        dVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void J(d dVar) {
        dVar.getClass();
        dVar.type_ = DEFAULT_INSTANCE.type_;
    }

    public static void K(d dVar, h hVar) {
        dVar.getClass();
        hVar.getClass();
        if (dVar.dataCase_ != 4 || dVar.data_ == h.i0()) {
            dVar.data_ = hVar;
        } else {
            dVar.data_ = ((Item$Builder) h.A0((h) dVar.data_).mergeFrom((GeneratedMessageLite) hVar)).m();
        }
        dVar.dataCase_ = 4;
    }

    public static void L(d dVar, j jVar) {
        dVar.getClass();
        jVar.getClass();
        if (dVar.dataCase_ != 5 || dVar.data_ == j.H()) {
            dVar.data_ = jVar;
        } else {
            dVar.data_ = ((MessageDelta$Builder) j.K((j) dVar.data_).mergeFrom((GeneratedMessageLite) jVar)).m();
        }
        dVar.dataCase_ = 5;
    }

    public static void M(d dVar, o oVar) {
        dVar.getClass();
        oVar.getClass();
        if (dVar.dataCase_ != 3 || dVar.data_ == o.y0()) {
            dVar.data_ = oVar;
        } else {
            dVar.data_ = ((Task$Builder) o.U0((o) dVar.data_).mergeFrom((GeneratedMessageLite) oVar)).m();
        }
        dVar.dataCase_ = 3;
    }

    public static void N(d dVar, String str) {
        dVar.getClass();
        str.getClass();
        dVar.eventId_ = str;
    }

    public static void O(d dVar, ByteString byteString) {
        dVar.getClass();
        AbstractC0932e.g(byteString);
        dVar.eventId_ = byteString.q();
    }

    public static void P(d dVar, h hVar) {
        dVar.getClass();
        hVar.getClass();
        dVar.data_ = hVar;
        dVar.dataCase_ = 4;
    }

    public static void Q(d dVar, j jVar) {
        dVar.getClass();
        jVar.getClass();
        dVar.data_ = jVar;
        dVar.dataCase_ = 5;
    }

    public static void R(d dVar, o oVar) {
        dVar.getClass();
        oVar.getClass();
        dVar.data_ = oVar;
        dVar.dataCase_ = 3;
    }

    public static void S(d dVar, String str) {
        dVar.getClass();
        str.getClass();
        dVar.taskId_ = str;
    }

    public static void T(d dVar, ByteString byteString) {
        dVar.getClass();
        AbstractC0932e.g(byteString);
        dVar.taskId_ = byteString.q();
    }

    public static void U(d dVar, String str) {
        dVar.getClass();
        str.getClass();
        dVar.type_ = str;
    }

    public static void V(d dVar, ByteString byteString) {
        dVar.getClass();
        AbstractC0932e.g(byteString);
        dVar.type_ = byteString.q();
    }

    public final Event$DataCase X() {
        int i = this.dataCase_;
        if (i == 0) {
            return Event$DataCase.d;
        }
        if (i == 3) {
            return Event$DataCase.f4279a;
        }
        if (i == 4) {
            return Event$DataCase.b;
        }
        if (i != 5) {
            return null;
        }
        return Event$DataCase.c;
    }

    public final String Y() {
        return this.eventId_;
    }

    public final ByteString Z() {
        return ByteString.f(this.eventId_);
    }

    public final h a0() {
        return this.dataCase_ == 4 ? (h) this.data_ : h.i0();
    }

    public final j b0() {
        return this.dataCase_ == 5 ? (j) this.data_ : j.H();
    }

    public final o c0() {
        return this.dataCase_ == 3 ? (o) this.data_ : o.y0();
    }

    public final String d0() {
        return this.taskId_;
    }

    public final ByteString e0() {
        return ByteString.f(this.taskId_);
    }

    public final String f0() {
        return this.type_;
    }

    public final ByteString g0() {
        return ByteString.f(this.type_);
    }

    public final boolean h0() {
        return this.dataCase_ == 4;
    }

    public final boolean i0() {
        return this.dataCase_ == 5;
    }

    public final boolean j0() {
        return this.dataCase_ == 3;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001e\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003<\u0000\u0004<\u0000\u0005<\u0000eȈ", new Object[]{"data_", "dataCase_", "eventId_", "type_", o.class, h.class, j.class, "taskId_"});
            case 3:
                return new d();
            case 4:
                return new Event$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (d.class) {
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
