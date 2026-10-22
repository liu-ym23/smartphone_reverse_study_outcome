package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.HookExecutionResult$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class q extends GeneratedMessageLite implements Y1 {
    public static final int CONTINUE_EXECUTION_FIELD_NUMBER = 3;
    private static final q DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 8;
    public static final int MODIFIED_DATA_FIELD_NUMBER = 5;
    public static final int MODIFIED_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 2;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private boolean continueExecution_;
    private long durationMs_;
    private boolean modified_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String taskId_ = "";
    private String error_ = "";
    private ByteString modifiedData_ = ByteString.b;

    static {
        q qVar = new q();
        DEFAULT_INSTANCE = qVar;
        GeneratedMessageLite.C(q.class, qVar);
    }

    public static void D(q qVar) {
        qVar.continueExecution_ = false;
    }

    public static void E(q qVar) {
        qVar.durationMs_ = 0L;
    }

    public static void F(q qVar) {
        qVar.getClass();
        qVar.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void G(q qVar) {
        qVar.modified_ = false;
    }

    public static void H(q qVar) {
        qVar.getClass();
        qVar.modifiedData_ = DEFAULT_INSTANCE.modifiedData_;
    }

    public static void I(q qVar) {
        qVar.success_ = false;
    }

    public static void J(q qVar) {
        qVar.getClass();
        qVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static MapFieldLite K(q qVar) {
        MapFieldLite<String, String> mapFieldLite = qVar.metadata_;
        if (!mapFieldLite.f2856a) {
            qVar.metadata_ = mapFieldLite.h();
        }
        return qVar.metadata_;
    }

    public static void L(q qVar, boolean z10) {
        qVar.continueExecution_ = z10;
    }

    public static void M(q qVar, long j5) {
        qVar.durationMs_ = j5;
    }

    public static void N(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.error_ = str;
    }

    public static void O(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.error_ = byteString.q();
    }

    public static void P(q qVar, boolean z10) {
        qVar.modified_ = z10;
    }

    public static void Q(q qVar, ByteString byteString) {
        qVar.getClass();
        byteString.getClass();
        qVar.modifiedData_ = byteString;
    }

    public static void R(q qVar, boolean z10) {
        qVar.success_ = z10;
    }

    public static void S(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.taskId_ = str;
    }

    public static void T(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.taskId_ = byteString.q();
    }

    public static q W() {
        return DEFAULT_INSTANCE;
    }

    public static HookExecutionResult$Builder g0(q qVar) {
        return (HookExecutionResult$Builder) DEFAULT_INSTANCE.q(qVar);
    }

    public final boolean V() {
        return this.continueExecution_;
    }

    public final long X() {
        return this.durationMs_;
    }

    public final String Y() {
        return this.error_;
    }

    public final ByteString Z() {
        return ByteString.f(this.error_);
    }

    public final Map a0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final boolean b0() {
        return this.modified_;
    }

    public final ByteString c0() {
        return this.modifiedData_;
    }

    public final boolean d0() {
        return this.success_;
    }

    public final String e0() {
        return this.taskId_;
    }

    public final ByteString f0() {
        return ByteString.f(this.taskId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001Ȉ\u0002\u0007\u0003\u0007\u0004Ȉ\u0005\n\u0006\u0007\u0007\u0002\b2", new Object[]{"taskId_", "success_", "continueExecution_", "error_", "modifiedData_", "modified_", "durationMs_", "metadata_", p.f5446a});
            case 3:
                return new q();
            case 4:
                return new HookExecutionResult$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (q.class) {
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
