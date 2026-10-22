package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.LoggingMessageNotification;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0003897B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\n\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\"\u0010!J:\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b%\u0010\u001fJ\u0010\u0010&\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b.\u0010\u001dR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u0010!R\u001a\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b3\u0010!R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u00104\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ServerNotification;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "level", "", "logger", "Lqb/D;", "data", "_meta", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Ljava/lang/String;Lqb/D;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Ljava/lang/String;Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "component2", "()Ljava/lang/String;", "component3", "()Lqb/D;", "component4", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Ljava/lang/String;Lqb/D;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "getLevel", "Ljava/lang/String;", "getLogger", "Lqb/D;", "getData", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "SetLevelRequest", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class LoggingMessageNotification implements ServerNotification, WithMeta {
    private final qb.D _meta;
    private final qb.D data;
    private final LoggingLevel level;
    private final String logger;
    private final Method method;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.x
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return LoggingMessageNotification._childSerializers$_anonymous_();
        }
    }), null, null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<LoggingMessageNotification> serializer() {
            return LoggingMessageNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ LoggingMessageNotification(int i10, LoggingLevel loggingLevel, String str, qb.D d10, qb.D d11, Method method, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, LoggingMessageNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.level = loggingLevel;
        if ((i10 & 2) == 0) {
            this.logger = null;
        } else {
            this.logger = str;
        }
        if ((i10 & 4) == 0) {
            this.data = Types_utilKt.getEmptyJsonObject();
        } else {
            this.data = d10;
        }
        if ((i10 & 8) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d11;
        }
        if ((i10 & 16) == 0) {
            this.method = Method.Defined.NotificationsMessage;
        } else {
            this.method = method;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return LoggingLevel.INSTANCE.serializer();
    }

    public static /* synthetic */ LoggingMessageNotification copy$default(LoggingMessageNotification loggingMessageNotification, LoggingLevel loggingLevel, String str, qb.D d10, qb.D d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            loggingLevel = loggingMessageNotification.level;
        }
        if ((i10 & 2) != 0) {
            str = loggingMessageNotification.logger;
        }
        if ((i10 & 4) != 0) {
            d10 = loggingMessageNotification.data;
        }
        if ((i10 & 8) != 0) {
            d11 = loggingMessageNotification._meta;
        }
        return loggingMessageNotification.copy(loggingLevel, str, d10, d11);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(LoggingMessageNotification self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.level);
        if (output.y(serialDesc, 1) || self.logger != null) {
            output.k(serialDesc, 1, Y0.f38329a, self.logger);
        }
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.data, Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self.data);
        }
        if (output.y(serialDesc, 3) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 3, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 4) && self.getMethod() == Method.Defined.NotificationsMessage) {
            return;
        }
        output.x(serialDesc, 4, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final LoggingLevel getLevel() {
        return this.level;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLogger() {
        return this.logger;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D getData() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final LoggingMessageNotification copy(LoggingLevel level, String logger, qb.D data, qb.D _meta) {
        kotlin.jvm.internal.p.i(level, "level");
        kotlin.jvm.internal.p.i(data, "data");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new LoggingMessageNotification(level, logger, data, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoggingMessageNotification)) {
            return false;
        }
        LoggingMessageNotification loggingMessageNotification = (LoggingMessageNotification) other;
        return this.level == loggingMessageNotification.level && kotlin.jvm.internal.p.d(this.logger, loggingMessageNotification.logger) && kotlin.jvm.internal.p.d(this.data, loggingMessageNotification.data) && kotlin.jvm.internal.p.d(this._meta, loggingMessageNotification._meta);
    }

    public final qb.D getData() {
        return this.data;
    }

    public final LoggingLevel getLevel() {
        return this.level;
    }

    public final String getLogger() {
        return this.logger;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Notification
    public Method getMethod() {
        return this.method;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = this.level.hashCode() * 31;
        String str = this.logger;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.data.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "LoggingMessageNotification(level=" + this.level + ", logger=" + this.logger + ", data=" + this.data + ", _meta=" + this._meta + ')';
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000210B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0007\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010\u001cR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$SetLevelRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "level", "Lqb/D;", "_meta", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$SetLevelRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "component2", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$SetLevelRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "getLevel", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class SetLevelRequest implements ClientRequest, WithMeta {
        private final qb.D _meta;
        private final LoggingLevel level;
        private final Method method;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return LoggingMessageNotification.SetLevelRequest._childSerializers$_anonymous_();
            }
        }), null, null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$SetLevelRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$SetLevelRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SetLevelRequest> serializer() {
                return LoggingMessageNotification$SetLevelRequest$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ SetLevelRequest(int i10, LoggingLevel loggingLevel, qb.D d10, Method method, T0 t02) {
            if (1 != (i10 & 1)) {
                E0.a(i10, 1, LoggingMessageNotification$SetLevelRequest$$serializer.INSTANCE.getDescriptor());
            }
            this.level = loggingLevel;
            if ((i10 & 2) == 0) {
                this._meta = Types_utilKt.getEmptyJsonObject();
            } else {
                this._meta = d10;
            }
            if ((i10 & 4) == 0) {
                this.method = Method.Defined.LoggingSetLevel;
            } else {
                this.method = method;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return LoggingLevel.INSTANCE.serializer();
        }

        public static /* synthetic */ SetLevelRequest copy$default(SetLevelRequest setLevelRequest, LoggingLevel loggingLevel, qb.D d10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                loggingLevel = setLevelRequest.level;
            }
            if ((i10 & 2) != 0) {
                d10 = setLevelRequest._meta;
            }
            return setLevelRequest.copy(loggingLevel, d10);
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(SetLevelRequest self, ob.d output, SerialDescriptor serialDesc) {
            output.x(serialDesc, 0, $childSerializers[0].getValue(), self.level);
            if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
                output.x(serialDesc, 1, qb.E.f38623a, self.get_meta());
            }
            if (!output.y(serialDesc, 2) && self.getMethod() == Method.Defined.LoggingSetLevel) {
                return;
            }
            output.x(serialDesc, 2, RequestMethodSerializer.INSTANCE, self.getMethod());
        }

        /* renamed from: component1, reason: from getter */
        public final LoggingLevel getLevel() {
            return this.level;
        }

        /* renamed from: component2, reason: from getter */
        public final qb.D get_meta() {
            return this._meta;
        }

        public final SetLevelRequest copy(LoggingLevel level, qb.D _meta) {
            kotlin.jvm.internal.p.i(level, "level");
            kotlin.jvm.internal.p.i(_meta, "_meta");
            return new SetLevelRequest(level, _meta);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetLevelRequest)) {
                return false;
            }
            SetLevelRequest setLevelRequest = (SetLevelRequest) other;
            return this.level == setLevelRequest.level && kotlin.jvm.internal.p.d(this._meta, setLevelRequest._meta);
        }

        public final LoggingLevel getLevel() {
            return this.level;
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.Request
        public Method getMethod() {
            return this.method;
        }

        @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
        public qb.D get_meta() {
            return this._meta;
        }

        public int hashCode() {
            return (this.level.hashCode() * 31) + this._meta.hashCode();
        }

        public String toString() {
            return "SetLevelRequest(level=" + this.level + ", _meta=" + this._meta + ')';
        }

        public SetLevelRequest(LoggingLevel level, qb.D _meta) {
            kotlin.jvm.internal.p.i(level, "level");
            kotlin.jvm.internal.p.i(_meta, "_meta");
            this.level = level;
            this._meta = _meta;
            this.method = Method.Defined.LoggingSetLevel;
        }

        public /* synthetic */ SetLevelRequest(LoggingLevel loggingLevel, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
            this(loggingLevel, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
        }
    }

    public LoggingMessageNotification(LoggingLevel level, String str, qb.D data, qb.D _meta) {
        kotlin.jvm.internal.p.i(level, "level");
        kotlin.jvm.internal.p.i(data, "data");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.level = level;
        this.logger = str;
        this.data = data;
        this._meta = _meta;
        this.method = Method.Defined.NotificationsMessage;
    }

    public /* synthetic */ LoggingMessageNotification(LoggingLevel loggingLevel, String str, qb.D d10, qb.D d11, int i10, kotlin.jvm.internal.i iVar) {
        this(loggingLevel, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, (i10 & 8) != 0 ? Types_utilKt.getEmptyJsonObject() : d11);
    }
}
