package io.modelcontextprotocol.kotlin.sdk;

import com.networknt.schema.keyword.PropertiesValidator;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationRequest;
import io.modelcontextprotocol.kotlin.sdk.Method;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0003564B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J.\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010-\u001a\u0004\b.\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b0\u0010 R\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ServerRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "message", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "requestedSchema", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "component3", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "getRequestedSchema", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "RequestedSchema", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CreateElicitationRequest implements ServerRequest, WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final String message;
    private final Method method;
    private final RequestedSchema requestedSchema;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateElicitationRequest> serializer() {
            return CreateElicitationRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0019R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u001bR \u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u000b\u0010*\u0012\u0004\b,\u0010-\u001a\u0004\b+\u0010\u001f¨\u00060"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "", "Lqb/D;", PropertiesValidator.PROPERTY, "", "", "required", "<init>", "(Lqb/D;Ljava/util/List;)V", "", "seen0", "type", "Lpb/T0;", "serializationConstructorMarker", "(ILqb/D;Ljava/util/List;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lqb/D;", "component2", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(Lqb/D;Ljava/util/List;)Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lqb/D;", "getProperties", "Ljava/util/List;", "getRequired", "Ljava/lang/String;", "getType", "getType$annotations", "()V", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class RequestedSchema {
        private final qb.D properties;
        private final List<String> required;
        private final String type;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CreateElicitationRequest.RequestedSchema._childSerializers$_anonymous_();
            }
        }), null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<RequestedSchema> serializer() {
                return CreateElicitationRequest$RequestedSchema$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RequestedSchema() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new C5094f(Y0.f38329a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestedSchema copy$default(RequestedSchema requestedSchema, qb.D d10, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                d10 = requestedSchema.properties;
            }
            if ((i10 & 2) != 0) {
                list = requestedSchema.required;
            }
            return requestedSchema.copy(d10, list);
        }

        public static /* synthetic */ void getType$annotations() {
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(RequestedSchema self, ob.d output, SerialDescriptor serialDesc) {
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

        public final RequestedSchema copy(qb.D properties, List<String> required) {
            kotlin.jvm.internal.p.i(properties, "properties");
            return new RequestedSchema(properties, required);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestedSchema)) {
                return false;
            }
            RequestedSchema requestedSchema = (RequestedSchema) other;
            return kotlin.jvm.internal.p.d(this.properties, requestedSchema.properties) && kotlin.jvm.internal.p.d(this.required, requestedSchema.required);
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
            return "RequestedSchema(properties=" + this.properties + ", required=" + this.required + ')';
        }

        public /* synthetic */ RequestedSchema(int i10, qb.D d10, List list, String str, T0 t02) {
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

        public RequestedSchema(qb.D properties, List<String> list) {
            kotlin.jvm.internal.p.i(properties, "properties");
            this.properties = properties;
            this.required = list;
            this.type = "object";
        }

        public /* synthetic */ RequestedSchema(qb.D d10, List list, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, (i10 & 2) != 0 ? null : list);
        }
    }

    public /* synthetic */ CreateElicitationRequest(int i10, String str, RequestedSchema requestedSchema, qb.D d10, Method method, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, CreateElicitationRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.message = str;
        this.requestedSchema = requestedSchema;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 8) == 0) {
            this.method = Method.Defined.ElicitationCreate;
        } else {
            this.method = method;
        }
    }

    public static /* synthetic */ CreateElicitationRequest copy$default(CreateElicitationRequest createElicitationRequest, String str, RequestedSchema requestedSchema, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = createElicitationRequest.message;
        }
        if ((i10 & 2) != 0) {
            requestedSchema = createElicitationRequest.requestedSchema;
        }
        if ((i10 & 4) != 0) {
            d10 = createElicitationRequest._meta;
        }
        return createElicitationRequest.copy(str, requestedSchema, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CreateElicitationRequest self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.message);
        output.x(serialDesc, 1, CreateElicitationRequest$RequestedSchema$$serializer.INSTANCE, self.requestedSchema);
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 3) && self.getMethod() == Method.Defined.ElicitationCreate) {
            return;
        }
        output.x(serialDesc, 3, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final RequestedSchema getRequestedSchema() {
        return this.requestedSchema;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CreateElicitationRequest copy(String message, RequestedSchema requestedSchema, qb.D _meta) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(requestedSchema, "requestedSchema");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CreateElicitationRequest(message, requestedSchema, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateElicitationRequest)) {
            return false;
        }
        CreateElicitationRequest createElicitationRequest = (CreateElicitationRequest) other;
        return kotlin.jvm.internal.p.d(this.message, createElicitationRequest.message) && kotlin.jvm.internal.p.d(this.requestedSchema, createElicitationRequest.requestedSchema) && kotlin.jvm.internal.p.d(this._meta, createElicitationRequest._meta);
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public final RequestedSchema getRequestedSchema() {
        return this.requestedSchema;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.requestedSchema.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CreateElicitationRequest(message=" + this.message + ", requestedSchema=" + this.requestedSchema + ", _meta=" + this._meta + ')';
    }

    public CreateElicitationRequest(String message, RequestedSchema requestedSchema, qb.D _meta) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(requestedSchema, "requestedSchema");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.message = message;
        this.requestedSchema = requestedSchema;
        this._meta = _meta;
        this.method = Method.Defined.ElicitationCreate;
    }

    public /* synthetic */ CreateElicitationRequest(String str, RequestedSchema requestedSchema, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, requestedSchema, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
