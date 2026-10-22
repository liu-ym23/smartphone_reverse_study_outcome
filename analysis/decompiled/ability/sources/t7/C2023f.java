package t7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.Audio$Builder;
import com.zyql.protobuf.omni.ChatDelta$Builder;
import com.zyql.protobuf.omni.Error$Builder;
import com.zyql.protobuf.omni.MessageDelta$Builder;
import com.zyql.protobuf.omni.TaskStatus;
import com.zyql.protobuf.skull.Message$Builder;

/* renamed from: t7.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2023f extends GeneratedMessageLite implements Y1 {
    public static final int AUDIO_FIELD_NUMBER = 5;
    public static final int CHAT_ID_FIELD_NUMBER = 1;
    private static final C2023f DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 100;
    public static final int EVENT_ID_FIELD_NUMBER = 8;
    public static final int MESSAGE_DELTA_FIELD_NUMBER = 6;
    public static final int MESSAGE_FIELD_NUMBER = 4;
    public static final int MESSAGE_ID_FIELD_NUMBER = 7;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 2;
    private C2020c audio_;
    private int bitField0_;
    private i error_;
    private j messageDelta_;
    private v7.i message_;
    private int status_;
    private String chatId_ = "";
    private String taskId_ = "";
    private String messageId_ = "";
    private String eventId_ = "";

    static {
        C2023f c2023f = new C2023f();
        DEFAULT_INSTANCE = c2023f;
        GeneratedMessageLite.C(C2023f.class, c2023f);
    }

    public static void D(C2023f c2023f) {
        c2023f.audio_ = null;
        c2023f.bitField0_ &= -3;
    }

    public static void E(C2023f c2023f) {
        c2023f.getClass();
        c2023f.chatId_ = DEFAULT_INSTANCE.chatId_;
    }

    public static void F(C2023f c2023f) {
        c2023f.error_ = null;
        c2023f.bitField0_ &= -9;
    }

    public static void G(C2023f c2023f) {
        c2023f.getClass();
        c2023f.eventId_ = DEFAULT_INSTANCE.eventId_;
    }

    public static void H(C2023f c2023f) {
        c2023f.message_ = null;
        c2023f.bitField0_ &= -2;
    }

    public static void I(C2023f c2023f) {
        c2023f.messageDelta_ = null;
        c2023f.bitField0_ &= -5;
    }

    public static void J(C2023f c2023f) {
        c2023f.getClass();
        c2023f.messageId_ = DEFAULT_INSTANCE.messageId_;
    }

    public static void K(C2023f c2023f) {
        c2023f.status_ = 0;
    }

    public static void L(C2023f c2023f) {
        c2023f.getClass();
        c2023f.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void M(C2023f c2023f, C2020c c2020c) {
        c2023f.getClass();
        c2020c.getClass();
        C2020c c2020c2 = c2023f.audio_;
        if (c2020c2 == null || c2020c2 == C2020c.J()) {
            c2023f.audio_ = c2020c;
        } else {
            c2023f.audio_ = (C2020c) ((Audio$Builder) C2020c.L(c2023f.audio_).mergeFrom((GeneratedMessageLite) c2020c)).m();
        }
        c2023f.bitField0_ |= 2;
    }

    public static void N(C2023f c2023f, i iVar) {
        c2023f.getClass();
        iVar.getClass();
        i iVar2 = c2023f.error_;
        if (iVar2 == null || iVar2 == i.J()) {
            c2023f.error_ = iVar;
        } else {
            c2023f.error_ = (i) ((Error$Builder) i.N(c2023f.error_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        c2023f.bitField0_ |= 8;
    }

    public static void O(C2023f c2023f, v7.i iVar) {
        c2023f.getClass();
        iVar.getClass();
        v7.i iVar2 = c2023f.message_;
        if (iVar2 == null || iVar2 == v7.i.T()) {
            c2023f.message_ = iVar;
        } else {
            c2023f.message_ = (v7.i) ((Message$Builder) v7.i.a0(c2023f.message_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        c2023f.bitField0_ |= 1;
    }

    public static void P(C2023f c2023f, j jVar) {
        c2023f.getClass();
        jVar.getClass();
        j jVar2 = c2023f.messageDelta_;
        if (jVar2 == null || jVar2 == j.P()) {
            c2023f.messageDelta_ = jVar;
        } else {
            c2023f.messageDelta_ = (j) ((MessageDelta$Builder) j.X(c2023f.messageDelta_).mergeFrom((GeneratedMessageLite) jVar)).m();
        }
        c2023f.bitField0_ |= 4;
    }

    public static void Q(C2023f c2023f, C2020c c2020c) {
        c2023f.getClass();
        c2020c.getClass();
        c2023f.audio_ = c2020c;
        c2023f.bitField0_ |= 2;
    }

    public static void R(C2023f c2023f, String str) {
        c2023f.getClass();
        str.getClass();
        c2023f.chatId_ = str;
    }

    public static void S(C2023f c2023f, ByteString byteString) {
        c2023f.getClass();
        AbstractC0932e.g(byteString);
        c2023f.chatId_ = byteString.q();
    }

    public static void T(C2023f c2023f, i iVar) {
        c2023f.getClass();
        iVar.getClass();
        c2023f.error_ = iVar;
        c2023f.bitField0_ |= 8;
    }

    public static void U(C2023f c2023f, String str) {
        c2023f.getClass();
        str.getClass();
        c2023f.eventId_ = str;
    }

    public static void V(C2023f c2023f, ByteString byteString) {
        c2023f.getClass();
        AbstractC0932e.g(byteString);
        c2023f.eventId_ = byteString.q();
    }

    public static void W(C2023f c2023f, v7.i iVar) {
        c2023f.getClass();
        iVar.getClass();
        c2023f.message_ = iVar;
        c2023f.bitField0_ |= 1;
    }

    public static void X(C2023f c2023f, j jVar) {
        c2023f.getClass();
        jVar.getClass();
        c2023f.messageDelta_ = jVar;
        c2023f.bitField0_ |= 4;
    }

    public static void Y(C2023f c2023f, String str) {
        c2023f.getClass();
        str.getClass();
        c2023f.messageId_ = str;
    }

    public static void Z(C2023f c2023f, ByteString byteString) {
        c2023f.getClass();
        AbstractC0932e.g(byteString);
        c2023f.messageId_ = byteString.q();
    }

    public static void a0(C2023f c2023f, TaskStatus taskStatus) {
        c2023f.getClass();
        c2023f.status_ = taskStatus.getNumber();
    }

    public static void b0(C2023f c2023f, int i) {
        c2023f.status_ = i;
    }

    public static void c0(C2023f c2023f, String str) {
        c2023f.getClass();
        str.getClass();
        c2023f.taskId_ = str;
    }

    public static void d0(C2023f c2023f, ByteString byteString) {
        c2023f.getClass();
        AbstractC0932e.g(byteString);
        c2023f.taskId_ = byteString.q();
    }

    public static C2023f x0(ByteString byteString) {
        return (C2023f) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString);
    }

    public final C2020c f0() {
        C2020c c2020c = this.audio_;
        return c2020c == null ? C2020c.J() : c2020c;
    }

    public final String g0() {
        return this.chatId_;
    }

    public final ByteString h0() {
        return ByteString.f(this.chatId_);
    }

    public final i i0() {
        i iVar = this.error_;
        return iVar == null ? i.J() : iVar;
    }

    public final String j0() {
        return this.eventId_;
    }

    public final ByteString k0() {
        return ByteString.f(this.eventId_);
    }

    public final v7.i l0() {
        v7.i iVar = this.message_;
        return iVar == null ? v7.i.T() : iVar;
    }

    public final j m0() {
        j jVar = this.messageDelta_;
        return jVar == null ? j.P() : jVar;
    }

    public final String n0() {
        return this.messageId_;
    }

    public final ByteString o0() {
        return ByteString.f(this.messageId_);
    }

    public final TaskStatus p0() {
        TaskStatus taskStatus;
        switch (this.status_) {
            case 0:
                taskStatus = TaskStatus.UNKNOWN;
                break;
            case 1:
                taskStatus = TaskStatus.PROGRESS;
                break;
            case 2:
                taskStatus = TaskStatus.COMPLETED;
                break;
            case 3:
                taskStatus = TaskStatus.FAILED;
                break;
            case 4:
                taskStatus = TaskStatus.CANCELLED;
                break;
            case 5:
                taskStatus = TaskStatus.PAUSED;
                break;
            case 6:
                taskStatus = TaskStatus.ASK_FOR_INPUT;
                break;
            case 7:
                taskStatus = TaskStatus.AUTHENTICATION;
                break;
            default:
                taskStatus = null;
                break;
        }
        return taskStatus == null ? TaskStatus.UNRECOGNIZED : taskStatus;
    }

    public final int q0() {
        return this.status_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001d\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002\u0007Ȉ\bȈdဉ\u0003", new Object[]{"bitField0_", "chatId_", "taskId_", "status_", "message_", "audio_", "messageDelta_", "messageId_", "eventId_", "error_"});
            case 3:
                return new C2023f();
            case 4:
                return new ChatDelta$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2023f.class) {
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

    public final String r0() {
        return this.taskId_;
    }

    public final ByteString s0() {
        return ByteString.f(this.taskId_);
    }

    public final boolean t0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean u0() {
        return (this.bitField0_ & 8) != 0;
    }

    public final boolean v0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean w0() {
        return (this.bitField0_ & 4) != 0;
    }
}
