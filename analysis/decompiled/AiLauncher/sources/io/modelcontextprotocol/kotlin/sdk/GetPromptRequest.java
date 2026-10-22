package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Method;
import java.util.Map;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.C5089c0;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000254B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nBO\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J<\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010\u001cR%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010-\u001a\u0004\b.\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b0\u0010 R\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "name", "", "arguments", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/Map;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", "component3", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/util/Map;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/util/Map;", "getArguments", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class GetPromptRequest implements ClientRequest, WithMeta {
    private final qb.D _meta;
    private final Map<String, String> arguments;
    private final Method method;
    private final String name;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.n
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return GetPromptRequest._childSerializers$_anonymous_();
        }
    }), null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GetPromptRequest> serializer() {
            return GetPromptRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ GetPromptRequest(int i10, String str, Map map, qb.D d10, Method method, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, GetPromptRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.arguments = map;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 8) == 0) {
            this.method = Method.Defined.PromptsGet;
        } else {
            this.method = method;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        Y0 y02 = Y0.f38329a;
        return new C5089c0(y02, y02);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetPromptRequest copy$default(GetPromptRequest getPromptRequest, String str, Map map, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getPromptRequest.name;
        }
        if ((i10 & 2) != 0) {
            map = getPromptRequest.arguments;
        }
        if ((i10 & 4) != 0) {
            d10 = getPromptRequest._meta;
        }
        return getPromptRequest.copy(str, map, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(GetPromptRequest self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.w(serialDesc, 0, self.name);
        output.k(serialDesc, 1, hVarArr[1].getValue(), self.arguments);
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 3) && self.getMethod() == Method.Defined.PromptsGet) {
            return;
        }
        output.x(serialDesc, 3, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, String> component2() {
        return this.arguments;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final GetPromptRequest copy(String name, Map<String, String> arguments, qb.D _meta) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new GetPromptRequest(name, arguments, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetPromptRequest)) {
            return false;
        }
        GetPromptRequest getPromptRequest = (GetPromptRequest) other;
        return kotlin.jvm.internal.p.d(this.name, getPromptRequest.name) && kotlin.jvm.internal.p.d(this.arguments, getPromptRequest.arguments) && kotlin.jvm.internal.p.d(this._meta, getPromptRequest._meta);
    }

    public final Map<String, String> getArguments() {
        return this.arguments;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public final String getName() {
        return this.name;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        Map<String, String> map = this.arguments;
        return ((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "GetPromptRequest(name=" + this.name + ", arguments=" + this.arguments + ", _meta=" + this._meta + ')';
    }

    public GetPromptRequest(String name, Map<String, String> map, qb.D _meta) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.name = name;
        this.arguments = map;
        this._meta = _meta;
        this.method = Method.Defined.PromptsGet;
    }

    public /* synthetic */ GetPromptRequest(String str, Map map, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, map, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
