package io.modelcontextprotocol.kotlin.sdk;

import com.networknt.schema.keyword.PropertiesValidator;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Tool;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.C5094f;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 62\u00020\u0001:\u00047896B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\"\u0010#JH\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u001cJ\u0010\u0010'\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u001cR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b/\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b1\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b3\u0010!R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b5\u0010#¨\u0006:"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Tool;", "", "", "name", "description", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "inputSchema", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "outputSchema", "Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/Tool;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "component4", "()Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "component5", "()Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;)Lio/modelcontextprotocol/kotlin/sdk/Tool;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getDescription", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "getInputSchema", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "getOutputSchema", "Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "getAnnotations", "Companion", "Input", "Output", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class Tool {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ToolAnnotations annotations;
    private final String description;
    private final Input inputSchema;
    private final String name;
    private final Output outputSchema;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Tool$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Tool;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Tool> serializer() {
            return Tool$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0019R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u001bR \u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u000b\u0010*\u0012\u0004\b,\u0010-\u001a\u0004\b+\u0010\u001f¨\u00060"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "", "Lqb/D;", PropertiesValidator.PROPERTY, "", "", "required", "<init>", "(Lqb/D;Ljava/util/List;)V", "", "seen0", "type", "Lpb/T0;", "serializationConstructorMarker", "(ILqb/D;Ljava/util/List;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lqb/D;", "component2", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(Lqb/D;Ljava/util/List;)Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lqb/D;", "getProperties", "Ljava/util/List;", "getRequired", "Ljava/lang/String;", "getType", "getType$annotations", "()V", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Input {
        private final qb.D properties;
        private final List<String> required;
        private final String type;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.L
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Tool.Input._childSerializers$_anonymous_();
            }
        }), null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Tool$Input$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Input> serializer() {
                return Tool$Input$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Input() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new C5094f(Y0.f38329a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Input copy$default(Input input, qb.D d10, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                d10 = input.properties;
            }
            if ((i10 & 2) != 0) {
                list = input.required;
            }
            return input.copy(d10, list);
        }

        public static /* synthetic */ void getType$annotations() {
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(Input self, ob.d output, SerialDescriptor serialDesc) {
            Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
            if (output.y(serialDesc, 0) || !kotlin.jvm.internal.p.d(self.properties, Types_utilKt.getEmptyJsonObject())) {
                output.x(serialDesc, 0, qb.E.f38623a, self.properties);
            }
            if (output.y(serialDesc, 1) || self.required != null) {
                output.k(serialDesc, 1, hVarArr[1].getValue(), self.required);
            }
            output.w(serialDesc, 2, self.type);
        }

        /* renamed from: component1, reason: from getter */
        public final qb.D getProperties() {
            return this.properties;
        }

        public final List<String> component2() {
            return this.required;
        }

        public final Input copy(qb.D properties, List<String> required) {
            kotlin.jvm.internal.p.i(properties, "properties");
            return new Input(properties, required);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Input)) {
                return false;
            }
            Input input = (Input) other;
            return kotlin.jvm.internal.p.d(this.properties, input.properties) && kotlin.jvm.internal.p.d(this.required, input.required);
        }

        public final qb.D getProperties() {
            return this.properties;
        }

        public final List<String> getRequired() {
            return this.required;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = this.properties.hashCode() * 31;
            List<String> list = this.required;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "Input(properties=" + this.properties + ", required=" + this.required + ')';
        }

        public /* synthetic */ Input(int i10, qb.D d10, List list, String str, T0 t02) {
            this.properties = (i10 & 1) == 0 ? Types_utilKt.getEmptyJsonObject() : d10;
            if ((i10 & 2) == 0) {
                this.required = null;
            } else {
                this.required = list;
            }
            if ((i10 & 4) == 0) {
                this.type = "object";
            } else {
                this.type = str;
            }
        }

        public Input(qb.D properties, List<String> list) {
            kotlin.jvm.internal.p.i(properties, "properties");
            this.properties = properties;
            this.required = list;
            this.type = "object";
        }

        public /* synthetic */ Input(qb.D d10, List list, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, (i10 & 2) != 0 ? null : list);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0019R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u001bR \u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u000b\u0010*\u0012\u0004\b,\u0010-\u001a\u0004\b+\u0010\u001f¨\u00060"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "", "Lqb/D;", PropertiesValidator.PROPERTY, "", "", "required", "<init>", "(Lqb/D;Ljava/util/List;)V", "", "seen0", "type", "Lpb/T0;", "serializationConstructorMarker", "(ILqb/D;Ljava/util/List;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lqb/D;", "component2", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(Lqb/D;Ljava/util/List;)Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lqb/D;", "getProperties", "Ljava/util/List;", "getRequired", "Ljava/lang/String;", "getType", "getType$annotations", "()V", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Output {
        private final qb.D properties;
        private final List<String> required;
        private final String type;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Tool.Output._childSerializers$_anonymous_();
            }
        }), null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Tool$Output$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Output> serializer() {
                return Tool$Output$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Output() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new C5094f(Y0.f38329a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Output copy$default(Output output, qb.D d10, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                d10 = output.properties;
            }
            if ((i10 & 2) != 0) {
                list = output.required;
            }
            return output.copy(d10, list);
        }

        public static /* synthetic */ void getType$annotations() {
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(Output self, ob.d output, SerialDescriptor serialDesc) {
            Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
            if (output.y(serialDesc, 0) || !kotlin.jvm.internal.p.d(self.properties, Types_utilKt.getEmptyJsonObject())) {
                output.x(serialDesc, 0, qb.E.f38623a, self.properties);
            }
            if (output.y(serialDesc, 1) || self.required != null) {
                output.k(serialDesc, 1, hVarArr[1].getValue(), self.required);
            }
            output.w(serialDesc, 2, self.type);
        }

        /* renamed from: component1, reason: from getter */
        public final qb.D getProperties() {
            return this.properties;
        }

        public final List<String> component2() {
            return this.required;
        }

        public final Output copy(qb.D properties, List<String> required) {
            kotlin.jvm.internal.p.i(properties, "properties");
            return new Output(properties, required);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Output)) {
                return false;
            }
            Output output = (Output) other;
            return kotlin.jvm.internal.p.d(this.properties, output.properties) && kotlin.jvm.internal.p.d(this.required, output.required);
        }

        public final qb.D getProperties() {
            return this.properties;
        }

        public final List<String> getRequired() {
            return this.required;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = this.properties.hashCode() * 31;
            List<String> list = this.required;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "Output(properties=" + this.properties + ", required=" + this.required + ')';
        }

        public /* synthetic */ Output(int i10, qb.D d10, List list, String str, T0 t02) {
            this.properties = (i10 & 1) == 0 ? Types_utilKt.getEmptyJsonObject() : d10;
            if ((i10 & 2) == 0) {
                this.required = null;
            } else {
                this.required = list;
            }
            if ((i10 & 4) == 0) {
                this.type = "object";
            } else {
                this.type = str;
            }
        }

        public Output(qb.D properties, List<String> list) {
            kotlin.jvm.internal.p.i(properties, "properties");
            this.properties = properties;
            this.required = list;
            this.type = "object";
        }

        public /* synthetic */ Output(qb.D d10, List list, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, (i10 & 2) != 0 ? null : list);
        }
    }

    public /* synthetic */ Tool(int i10, String str, String str2, Input input, Output output, ToolAnnotations toolAnnotations, T0 t02) {
        if (31 != (i10 & 31)) {
            E0.a(i10, 31, Tool$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.description = str2;
        this.inputSchema = input;
        this.outputSchema = output;
        this.annotations = toolAnnotations;
    }

    public static /* synthetic */ Tool copy$default(Tool tool, String str, String str2, Input input, Output output, ToolAnnotations toolAnnotations, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tool.name;
        }
        if ((i10 & 2) != 0) {
            str2 = tool.description;
        }
        if ((i10 & 4) != 0) {
            input = tool.inputSchema;
        }
        if ((i10 & 8) != 0) {
            output = tool.outputSchema;
        }
        if ((i10 & 16) != 0) {
            toolAnnotations = tool.annotations;
        }
        ToolAnnotations toolAnnotations2 = toolAnnotations;
        Input input2 = input;
        return tool.copy(str, str2, input2, output, toolAnnotations2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(Tool self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.name);
        output.k(serialDesc, 1, Y0.f38329a, self.description);
        output.x(serialDesc, 2, Tool$Input$$serializer.INSTANCE, self.inputSchema);
        output.k(serialDesc, 3, Tool$Output$$serializer.INSTANCE, self.outputSchema);
        output.k(serialDesc, 4, ToolAnnotations$$serializer.INSTANCE, self.annotations);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final Input getInputSchema() {
        return this.inputSchema;
    }

    /* renamed from: component4, reason: from getter */
    public final Output getOutputSchema() {
        return this.outputSchema;
    }

    /* renamed from: component5, reason: from getter */
    public final ToolAnnotations getAnnotations() {
        return this.annotations;
    }

    public final Tool copy(String name, String description, Input inputSchema, Output outputSchema, ToolAnnotations annotations) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(inputSchema, "inputSchema");
        return new Tool(name, description, inputSchema, outputSchema, annotations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tool)) {
            return false;
        }
        Tool tool = (Tool) other;
        return kotlin.jvm.internal.p.d(this.name, tool.name) && kotlin.jvm.internal.p.d(this.description, tool.description) && kotlin.jvm.internal.p.d(this.inputSchema, tool.inputSchema) && kotlin.jvm.internal.p.d(this.outputSchema, tool.outputSchema) && kotlin.jvm.internal.p.d(this.annotations, tool.annotations);
    }

    public final ToolAnnotations getAnnotations() {
        return this.annotations;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Input getInputSchema() {
        return this.inputSchema;
    }

    public final String getName() {
        return this.name;
    }

    public final Output getOutputSchema() {
        return this.outputSchema;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.description;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.inputSchema.hashCode()) * 31;
        Output output = this.outputSchema;
        int iHashCode3 = (iHashCode2 + (output == null ? 0 : output.hashCode())) * 31;
        ToolAnnotations toolAnnotations = this.annotations;
        return iHashCode3 + (toolAnnotations != null ? toolAnnotations.hashCode() : 0);
    }

    public String toString() {
        return "Tool(name=" + this.name + ", description=" + this.description + ", inputSchema=" + this.inputSchema + ", outputSchema=" + this.outputSchema + ", annotations=" + this.annotations + ')';
    }

    public Tool(String name, String str, Input inputSchema, Output output, ToolAnnotations toolAnnotations) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(inputSchema, "inputSchema");
        this.name = name;
        this.description = str;
        this.inputSchema = inputSchema;
        this.outputSchema = output;
        this.annotations = toolAnnotations;
    }
}
