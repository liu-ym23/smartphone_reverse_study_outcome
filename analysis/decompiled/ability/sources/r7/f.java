package r7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.connection.Head$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends GeneratedMessageLite implements Y1 {
    public static final int COMMAND_FIELD_NUMBER = 5;
    private static final f DEFAULT_INSTANCE;
    public static final int FRAME_TYPE_FIELD_NUMBER = 1;
    public static final int META_FIELD_NUMBER = 6;
    public static final int MODULE_FIELD_NUMBER = 4;
    public static final int MSG_ID_FIELD_NUMBER = 3;
    public static final int MSG_TYPE_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private int frameType_;
    private int msgType_;
    private MapFieldLite<String, String> meta_ = MapFieldLite.b;
    private String msgId_ = "";
    private String module_ = "";
    private String command_ = "";

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.C(f.class, fVar);
    }

    public static void D(f fVar) {
        fVar.getClass();
        fVar.command_ = DEFAULT_INSTANCE.command_;
    }

    public static void E(f fVar) {
        fVar.frameType_ = 0;
    }

    public static void F(f fVar) {
        fVar.getClass();
        fVar.module_ = DEFAULT_INSTANCE.module_;
    }

    public static void G(f fVar) {
        fVar.getClass();
        fVar.msgId_ = DEFAULT_INSTANCE.msgId_;
    }

    public static void H(f fVar) {
        fVar.msgType_ = 0;
    }

    public static MapFieldLite I(f fVar) {
        MapFieldLite<String, String> mapFieldLite = fVar.meta_;
        if (!mapFieldLite.f2856a) {
            fVar.meta_ = mapFieldLite.h();
        }
        return fVar.meta_;
    }

    public static void J(f fVar, String str) {
        fVar.getClass();
        str.getClass();
        fVar.command_ = str;
    }

    public static void K(f fVar, ByteString byteString) {
        fVar.getClass();
        AbstractC0932e.g(byteString);
        fVar.command_ = byteString.q();
    }

    public static void L(f fVar, int i) {
        fVar.frameType_ = i;
    }

    public static void M(f fVar, String str) {
        fVar.getClass();
        str.getClass();
        fVar.module_ = str;
    }

    public static void N(f fVar, ByteString byteString) {
        fVar.getClass();
        AbstractC0932e.g(byteString);
        fVar.module_ = byteString.q();
    }

    public static void O(f fVar, String str) {
        fVar.getClass();
        str.getClass();
        fVar.msgId_ = str;
    }

    public static void P(f fVar, ByteString byteString) {
        fVar.getClass();
        AbstractC0932e.g(byteString);
        fVar.msgId_ = byteString.q();
    }

    public static void Q(f fVar, int i) {
        fVar.msgType_ = i;
    }

    public static f V() {
        return DEFAULT_INSTANCE;
    }

    public static Head$Builder e0() {
        return (Head$Builder) DEFAULT_INSTANCE.p();
    }

    public static Head$Builder f0(f fVar) {
        return (Head$Builder) DEFAULT_INSTANCE.q(fVar);
    }

    public final boolean S(String str) {
        return this.meta_.containsKey("resume_token");
    }

    public final String T() {
        return this.command_;
    }

    public final ByteString U() {
        return ByteString.f(this.command_);
    }

    public final int W() {
        return this.frameType_;
    }

    public final Map X() {
        return Collections.unmodifiableMap(this.meta_);
    }

    public final String Y(String str, String str2) {
        MapFieldLite<String, String> mapFieldLite = this.meta_;
        return mapFieldLite.containsKey("resume_token") ? mapFieldLite.get("resume_token") : "";
    }

    public final String Z() {
        return this.module_;
    }

    public final ByteString a0() {
        return ByteString.f(this.module_);
    }

    public final String b0() {
        return this.msgId_;
    }

    public final ByteString c0() {
        return ByteString.f(this.msgId_);
    }

    public final int d0() {
        return this.msgType_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001\u000b\u0002\u000b\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"frameType_", "msgType_", "msgId_", "module_", "command_", "meta_", e.f5678a});
            case 3:
                return new f();
            case 4:
                return new Head$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (f.class) {
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
