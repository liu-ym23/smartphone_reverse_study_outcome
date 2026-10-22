package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import h9.InterfaceC4149a;
import io.modelcontextprotocol.kotlin.sdk.CreateMessageRequest;
import io.modelcontextprotocol.kotlin.sdk.Method;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.C5083B;
import pb.C5094f;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0003RSQBi\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001bJ'\u0010$\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b\"\u0010#J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b/\u0010&J\u0010\u00100\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b4\u00101J\u0080\u0001\u00105\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b7\u0010(J\u0010\u00108\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b8\u0010.J\u001a\u0010<\u001a\u00020;2\b\u0010:\u001a\u0004\u0018\u000109HÖ\u0003¢\u0006\u0004\b<\u0010=R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010>\u001a\u0004\b?\u0010&R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010@\u001a\u0004\bA\u0010(R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010*R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010D\u001a\u0004\bE\u0010,R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010F\u001a\u0004\bG\u0010.R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\bH\u0010&R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010I\u001a\u0004\bJ\u00101R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010K\u001a\u0004\bL\u00103R\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010I\u001a\u0004\bM\u00101R\u001a\u0010\u0018\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010N\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ServerRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "Lio/modelcontextprotocol/kotlin/sdk/SamplingMessage;", "messages", "", "systemPrompt", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;", "includeContext", "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "maxTokens", "stopSequences", "Lqb/D;", "metadata", "Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "modelPreferences", "_meta", "<init>", "(Ljava/util/List;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;Ljava/lang/Double;ILjava/util/List;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;Lqb/D;)V", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;Ljava/lang/Double;ILjava/util/List;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "component3", "()Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;", "component4", "()Ljava/lang/Double;", "component5", "()I", "component6", "component7", "()Lqb/D;", "component8", "()Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "component9", ChatTracker.CLICK_COPY, "(Ljava/util/List;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;Ljava/lang/Double;ILjava/util/List;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMessages", "Ljava/lang/String;", "getSystemPrompt", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;", "getIncludeContext", "Ljava/lang/Double;", "getTemperature", "I", "getMaxTokens", "getStopSequences", "Lqb/D;", "getMetadata", "Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "getModelPreferences", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "IncludeContext", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CreateMessageRequest implements ServerRequest, WithMeta {
    private static final Y8.h<KSerializer<Object>>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final IncludeContext includeContext;
    private final int maxTokens;
    private final List<SamplingMessage> messages;
    private final qb.D metadata;
    private final Method method;
    private final ModelPreferences modelPreferences;
    private final List<String> stopSequences;
    private final String systemPrompt;
    private final Double temperature;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateMessageRequest> serializer() {
            return CreateMessageRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "none", "thisServer", "allServers", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final class IncludeContext {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ IncludeContext[] $VALUES;
        private static final Y8.h<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final IncludeContext none = new IncludeContext("none", 0);
        public static final IncludeContext thisServer = new IncludeContext("thisServer", 1);
        public static final IncludeContext allServers = new IncludeContext("allServers", 2);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest$IncludeContext;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) IncludeContext.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<IncludeContext> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        private static final /* synthetic */ IncludeContext[] $values() {
            return new IncludeContext[]{none, thisServer, allServers};
        }

        static {
            IncludeContext[] includeContextArr$values = $values();
            $VALUES = includeContextArr$values;
            $ENTRIES = kotlin.enums.a.a(includeContextArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.k
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CreateMessageRequest.IncludeContext._init_$_anonymous_();
                }
            });
        }

        private IncludeContext(String str, int i10) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return pb.I.a("io.modelcontextprotocol.kotlin.sdk.CreateMessageRequest.IncludeContext", values());
        }

        public static InterfaceC4149a<IncludeContext> getEntries() {
            return $ENTRIES;
        }

        public static IncludeContext valueOf(String str) {
            return (IncludeContext) Enum.valueOf(IncludeContext.class, str);
        }

        public static IncludeContext[] values() {
            return (IncludeContext[]) $VALUES.clone();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Y8.h[]{C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CreateMessageRequest._childSerializers$_anonymous_();
            }
        }), null, C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CreateMessageRequest._childSerializers$_anonymous_$0();
            }
        }), null, null, C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CreateMessageRequest._childSerializers$_anonymous_$1();
            }
        }), null, null, null, null};
    }

    public /* synthetic */ CreateMessageRequest(int i10, List list, String str, IncludeContext includeContext, Double d10, int i11, List list2, qb.D d11, ModelPreferences modelPreferences, qb.D d12, Method method, T0 t02) {
        if (191 != (i10 & 191)) {
            E0.a(i10, 191, CreateMessageRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.messages = list;
        this.systemPrompt = str;
        this.includeContext = includeContext;
        this.temperature = d10;
        this.maxTokens = i11;
        this.stopSequences = list2;
        if ((i10 & 64) == 0) {
            this.metadata = Types_utilKt.getEmptyJsonObject();
        } else {
            this.metadata = d11;
        }
        this.modelPreferences = modelPreferences;
        if ((i10 & 256) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d12;
        }
        if ((i10 & 512) == 0) {
            this.method = Method.Defined.SamplingCreateMessage;
        } else {
            this.method = method;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new C5094f(SamplingMessage$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return IncludeContext.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new C5094f(Y0.f38329a);
    }

    public static /* synthetic */ CreateMessageRequest copy$default(CreateMessageRequest createMessageRequest, List list, String str, IncludeContext includeContext, Double d10, int i10, List list2, qb.D d11, ModelPreferences modelPreferences, qb.D d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = createMessageRequest.messages;
        }
        if ((i11 & 2) != 0) {
            str = createMessageRequest.systemPrompt;
        }
        if ((i11 & 4) != 0) {
            includeContext = createMessageRequest.includeContext;
        }
        if ((i11 & 8) != 0) {
            d10 = createMessageRequest.temperature;
        }
        if ((i11 & 16) != 0) {
            i10 = createMessageRequest.maxTokens;
        }
        if ((i11 & 32) != 0) {
            list2 = createMessageRequest.stopSequences;
        }
        if ((i11 & 64) != 0) {
            d11 = createMessageRequest.metadata;
        }
        if ((i11 & 128) != 0) {
            modelPreferences = createMessageRequest.modelPreferences;
        }
        if ((i11 & 256) != 0) {
            d12 = createMessageRequest._meta;
        }
        ModelPreferences modelPreferences2 = modelPreferences;
        qb.D d13 = d12;
        List list3 = list2;
        qb.D d14 = d11;
        int i12 = i10;
        IncludeContext includeContext2 = includeContext;
        return createMessageRequest.copy(list, str, includeContext2, d10, i12, list3, d14, modelPreferences2, d13);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CreateMessageRequest self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.x(serialDesc, 0, hVarArr[0].getValue(), self.messages);
        output.k(serialDesc, 1, Y0.f38329a, self.systemPrompt);
        output.k(serialDesc, 2, hVarArr[2].getValue(), self.includeContext);
        output.k(serialDesc, 3, C5083B.f38260a, self.temperature);
        output.t(serialDesc, 4, self.maxTokens);
        output.k(serialDesc, 5, hVarArr[5].getValue(), self.stopSequences);
        if (output.y(serialDesc, 6) || !kotlin.jvm.internal.p.d(self.metadata, Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 6, qb.E.f38623a, self.metadata);
        }
        output.k(serialDesc, 7, ModelPreferences$$serializer.INSTANCE, self.modelPreferences);
        if (output.y(serialDesc, 8) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 8, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 9) && self.getMethod() == Method.Defined.SamplingCreateMessage) {
            return;
        }
        output.x(serialDesc, 9, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    public final List<SamplingMessage> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    /* renamed from: component3, reason: from getter */
    public final IncludeContext getIncludeContext() {
        return this.includeContext;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getTemperature() {
        return this.temperature;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMaxTokens() {
        return this.maxTokens;
    }

    public final List<String> component6() {
        return this.stopSequences;
    }

    /* renamed from: component7, reason: from getter */
    public final qb.D getMetadata() {
        return this.metadata;
    }

    /* renamed from: component8, reason: from getter */
    public final ModelPreferences getModelPreferences() {
        return this.modelPreferences;
    }

    /* renamed from: component9, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CreateMessageRequest copy(List<SamplingMessage> messages, String systemPrompt, IncludeContext includeContext, Double temperature, int maxTokens, List<String> stopSequences, qb.D metadata, ModelPreferences modelPreferences, qb.D _meta) {
        kotlin.jvm.internal.p.i(messages, "messages");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CreateMessageRequest(messages, systemPrompt, includeContext, temperature, maxTokens, stopSequences, metadata, modelPreferences, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateMessageRequest)) {
            return false;
        }
        CreateMessageRequest createMessageRequest = (CreateMessageRequest) other;
        return kotlin.jvm.internal.p.d(this.messages, createMessageRequest.messages) && kotlin.jvm.internal.p.d(this.systemPrompt, createMessageRequest.systemPrompt) && this.includeContext == createMessageRequest.includeContext && kotlin.jvm.internal.p.d(this.temperature, createMessageRequest.temperature) && this.maxTokens == createMessageRequest.maxTokens && kotlin.jvm.internal.p.d(this.stopSequences, createMessageRequest.stopSequences) && kotlin.jvm.internal.p.d(this.metadata, createMessageRequest.metadata) && kotlin.jvm.internal.p.d(this.modelPreferences, createMessageRequest.modelPreferences) && kotlin.jvm.internal.p.d(this._meta, createMessageRequest._meta);
    }

    public final IncludeContext getIncludeContext() {
        return this.includeContext;
    }

    public final int getMaxTokens() {
        return this.maxTokens;
    }

    public final List<SamplingMessage> getMessages() {
        return this.messages;
    }

    public final qb.D getMetadata() {
        return this.metadata;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public final ModelPreferences getModelPreferences() {
        return this.modelPreferences;
    }

    public final List<String> getStopSequences() {
        return this.stopSequences;
    }

    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    public final Double getTemperature() {
        return this.temperature;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = this.messages.hashCode() * 31;
        String str = this.systemPrompt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        IncludeContext includeContext = this.includeContext;
        int iHashCode3 = (iHashCode2 + (includeContext == null ? 0 : includeContext.hashCode())) * 31;
        Double d10 = this.temperature;
        int iHashCode4 = (((iHashCode3 + (d10 == null ? 0 : d10.hashCode())) * 31) + Integer.hashCode(this.maxTokens)) * 31;
        List<String> list = this.stopSequences;
        int iHashCode5 = (((iHashCode4 + (list == null ? 0 : list.hashCode())) * 31) + this.metadata.hashCode()) * 31;
        ModelPreferences modelPreferences = this.modelPreferences;
        return ((iHashCode5 + (modelPreferences != null ? modelPreferences.hashCode() : 0)) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CreateMessageRequest(messages=" + this.messages + ", systemPrompt=" + this.systemPrompt + ", includeContext=" + this.includeContext + ", temperature=" + this.temperature + ", maxTokens=" + this.maxTokens + ", stopSequences=" + this.stopSequences + ", metadata=" + this.metadata + ", modelPreferences=" + this.modelPreferences + ", _meta=" + this._meta + ')';
    }

    public CreateMessageRequest(List<SamplingMessage> messages, String str, IncludeContext includeContext, Double d10, int i10, List<String> list, qb.D metadata, ModelPreferences modelPreferences, qb.D _meta) {
        kotlin.jvm.internal.p.i(messages, "messages");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.messages = messages;
        this.systemPrompt = str;
        this.includeContext = includeContext;
        this.temperature = d10;
        this.maxTokens = i10;
        this.stopSequences = list;
        this.metadata = metadata;
        this.modelPreferences = modelPreferences;
        this._meta = _meta;
        this.method = Method.Defined.SamplingCreateMessage;
    }

    public /* synthetic */ CreateMessageRequest(List list, String str, IncludeContext includeContext, Double d10, int i10, List list2, qb.D d11, ModelPreferences modelPreferences, qb.D d12, int i11, kotlin.jvm.internal.i iVar) {
        this(list, str, includeContext, d10, i10, list2, (i11 & 64) != 0 ? Types_utilKt.getEmptyJsonObject() : d11, modelPreferences, (i11 & 256) != 0 ? Types_utilKt.getEmptyJsonObject() : d12);
    }
}
