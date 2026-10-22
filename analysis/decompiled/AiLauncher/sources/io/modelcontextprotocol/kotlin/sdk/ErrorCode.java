package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import h9.InterfaceC4149a;
import io.modelcontextprotocol.kotlin.sdk.ErrorCode;
import io.modelcontextprotocol.spec.McpSchema;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00062\u00020\u0001:\u0003\u0007\b\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "", "", "getCode", "()I", "code", "Companion", "Defined", "Unknown", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Defined;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Unknown;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l(with = ErrorCodeSerializer.class)
/* loaded from: classes4.dex */
public interface ErrorCode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<ErrorCode> serializer() {
            return ErrorCodeSerializer.INSTANCE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u0000 \n2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Defined;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", "ConnectionClosed", "RequestTimeout", "ParseError", "InvalidRequest", "MethodNotFound", "InvalidParams", "InternalError", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final class Defined implements ErrorCode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Defined[] $VALUES;
        private static final Y8.h<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int code;
        public static final Defined ConnectionClosed = new Defined("ConnectionClosed", 0, -1);
        public static final Defined RequestTimeout = new Defined("RequestTimeout", 1, -2);
        public static final Defined ParseError = new Defined("ParseError", 2, McpSchema.ErrorCodes.PARSE_ERROR);
        public static final Defined InvalidRequest = new Defined("InvalidRequest", 3, McpSchema.ErrorCodes.INVALID_REQUEST);
        public static final Defined MethodNotFound = new Defined("MethodNotFound", 4, McpSchema.ErrorCodes.METHOD_NOT_FOUND);
        public static final Defined InvalidParams = new Defined("InvalidParams", 5, McpSchema.ErrorCodes.INVALID_PARAMS);
        public static final Defined InternalError = new Defined("InternalError", 6, McpSchema.ErrorCodes.INTERNAL_ERROR);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Defined$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Defined;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Defined.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Defined> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        private static final /* synthetic */ Defined[] $values() {
            return new Defined[]{ConnectionClosed, RequestTimeout, ParseError, InvalidRequest, MethodNotFound, InvalidParams, InternalError};
        }

        static {
            Defined[] definedArr$values = $values();
            $VALUES = definedArr$values;
            $ENTRIES = kotlin.enums.a.a(definedArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.m
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ErrorCode.Defined._init_$_anonymous_();
                }
            });
        }

        private Defined(String str, int i10, int i11) {
            this.code = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return pb.I.a("io.modelcontextprotocol.kotlin.sdk.ErrorCode.Defined", values());
        }

        public static InterfaceC4149a<Defined> getEntries() {
            return $ENTRIES;
        }

        public static Defined valueOf(String str) {
            return (Defined) Enum.valueOf(Defined.class, str);
        }

        public static Defined[] values() {
            return (Defined[]) $VALUES.clone();
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.ErrorCode
        public int getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\tJ'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Unknown;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "", "code", "<init>", "(I)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IILpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Unknown;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", ChatTracker.CLICK_COPY, "(I)Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Unknown;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Unknown implements ErrorCode {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int code;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Unknown$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode$Unknown;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Unknown> serializer() {
                return ErrorCode$Unknown$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Unknown(int i10, int i11, T0 t02) {
            if (1 != (i10 & 1)) {
                E0.a(i10, 1, ErrorCode$Unknown$$serializer.INSTANCE.getDescriptor());
            }
            this.code = i11;
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = unknown.code;
            }
            return unknown.copy(i10);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public final Unknown copy(int code) {
            return new Unknown(code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknown) && this.code == ((Unknown) other).code;
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.ErrorCode
        public int getCode() {
            return this.code;
        }

        public int hashCode() {
            return Integer.hashCode(this.code);
        }

        public String toString() {
            return "Unknown(code=" + this.code + ')';
        }

        public Unknown(int i10) {
            this.code = i10;
        }
    }

    int getCode();
}
