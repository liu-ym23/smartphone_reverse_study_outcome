package t7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.Audio$Builder;
import com.zyql.protobuf.omni.ChatRequest$Builder;
import com.zyql.protobuf.skull.Message$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class h extends GeneratedMessageLite implements Y1 {
    public static final int AUDIO_FIELD_NUMBER = 3;
    public static final int CHAT_ID_FIELD_NUMBER = 1;
    private static final h DEFAULT_INSTANCE;
    public static final int EVENT_ID_FIELD_NUMBER = 6;
    public static final int ISMOCK_FIELD_NUMBER = 100;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    public static final int META_FIELD_NUMBER = 102;
    public static final int NEEDTTS_FIELD_NUMBER = 101;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 4;
    private C2020c audio_;
    private int bitField0_;
    private boolean isMock_;
    private v7.i message_;
    private boolean needTts_;
    private MapFieldLite<String, String> meta_ = MapFieldLite.b;
    private String chatId_ = "";
    private String taskId_ = "";
    private String eventId_ = "";

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        GeneratedMessageLite.C(h.class, hVar);
    }

    public static void D(h hVar) {
        hVar.audio_ = null;
        hVar.bitField0_ &= -3;
    }

    public static void E(h hVar) {
        hVar.getClass();
        hVar.chatId_ = DEFAULT_INSTANCE.chatId_;
    }

    public static void F(h hVar) {
        hVar.getClass();
        hVar.eventId_ = DEFAULT_INSTANCE.eventId_;
    }

    public static void G(h hVar) {
        hVar.isMock_ = false;
    }

    public static void H(h hVar) {
        hVar.message_ = null;
        hVar.bitField0_ &= -2;
    }

    public static void I(h hVar) {
        hVar.needTts_ = false;
    }

    public static void J(h hVar) {
        hVar.getClass();
        hVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static MapFieldLite K(h hVar) {
        MapFieldLite<String, String> mapFieldLite = hVar.meta_;
        if (!mapFieldLite.f2856a) {
            hVar.meta_ = mapFieldLite.h();
        }
        return hVar.meta_;
    }

    public static void L(h hVar, C2020c c2020c) {
        hVar.getClass();
        c2020c.getClass();
        C2020c c2020c2 = hVar.audio_;
        if (c2020c2 == null || c2020c2 == C2020c.J()) {
            hVar.audio_ = c2020c;
        } else {
            hVar.audio_ = (C2020c) ((Audio$Builder) C2020c.L(hVar.audio_).mergeFrom((GeneratedMessageLite) c2020c)).m();
        }
        hVar.bitField0_ |= 2;
    }

    public static void M(h hVar, v7.i iVar) {
        hVar.getClass();
        iVar.getClass();
        v7.i iVar2 = hVar.message_;
        if (iVar2 == null || iVar2 == v7.i.T()) {
            hVar.message_ = iVar;
        } else {
            hVar.message_ = (v7.i) ((Message$Builder) v7.i.a0(hVar.message_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        hVar.bitField0_ |= 1;
    }

    public static void N(h hVar, C2020c c2020c) {
        hVar.getClass();
        c2020c.getClass();
        hVar.audio_ = c2020c;
        hVar.bitField0_ |= 2;
    }

    public static void O(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.chatId_ = str;
    }

    public static void P(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.chatId_ = byteString.q();
    }

    public static void Q(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.eventId_ = str;
    }

    public static void R(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.eventId_ = byteString.q();
    }

    public static void S(h hVar, boolean z10) {
        hVar.isMock_ = z10;
    }

    public static void T(h hVar, v7.i iVar) {
        hVar.getClass();
        iVar.getClass();
        hVar.message_ = iVar;
        hVar.bitField0_ |= 1;
    }

    public static void U(h hVar, boolean z10) {
        hVar.needTts_ = z10;
    }

    public static void V(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.taskId_ = str;
    }

    public static void W(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.taskId_ = byteString.q();
    }

    public static ChatRequest$Builder l0() {
        return (ChatRequest$Builder) DEFAULT_INSTANCE.p();
    }

    public final C2020c Y() {
        C2020c c2020c = this.audio_;
        return c2020c == null ? C2020c.J() : c2020c;
    }

    public final String Z() {
        return this.chatId_;
    }

    public final ByteString a0() {
        return ByteString.f(this.chatId_);
    }

    public final String b0() {
        return this.eventId_;
    }

    public final ByteString c0() {
        return ByteString.f(this.eventId_);
    }

    public final boolean d0() {
        return this.isMock_;
    }

    public final v7.i e0() {
        v7.i iVar = this.message_;
        return iVar == null ? v7.i.T() : iVar;
    }

    public final Map f0() {
        return Collections.unmodifiableMap(this.meta_);
    }

    public final boolean g0() {
        return this.needTts_;
    }

    public final String h0() {
        return this.taskId_;
    }

    public final ByteString i0() {
        return ByteString.f(this.taskId_);
    }

    public final boolean j0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean k0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001f\b\u0001\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004Ȉ\u0006Ȉd\u0007e\u0007f2", new Object[]{"bitField0_", "chatId_", "message_", "audio_", "taskId_", "eventId_", "isMock_", "needTts_", "meta_", g.f6669a});
            case 3:
                return new h();
            case 4:
                return new ChatRequest$Builder(0);
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
}
