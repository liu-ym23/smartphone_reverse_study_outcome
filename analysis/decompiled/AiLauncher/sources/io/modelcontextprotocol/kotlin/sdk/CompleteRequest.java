package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0003786B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J.\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b.\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u0010 R\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "Lio/modelcontextprotocol/kotlin/sdk/Reference;", "ref", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;", "argument", "Lqb/D;", "_meta", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Reference;Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/Reference;Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/Reference;", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;", "component3", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/Reference;Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/Reference;", "getRef", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;", "getArgument", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "Argument", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CompleteRequest implements ClientRequest, WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final Argument argument;
    private final Method method;
    private final Reference ref;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J$\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0016¨\u0006&"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;", "", "", "name", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getValue", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Argument {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String name;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Argument;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Argument> serializer() {
                return CompleteRequest$Argument$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Argument(int i10, String str, String str2, T0 t02) {
            if (3 != (i10 & 3)) {
                E0.a(i10, 3, CompleteRequest$Argument$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
            this.value = str2;
        }

        public static /* synthetic */ Argument copy$default(Argument argument, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = argument.name;
            }
            if ((i10 & 2) != 0) {
                str2 = argument.value;
            }
            return argument.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(Argument self, ob.d output, SerialDescriptor serialDesc) {
            output.w(serialDesc, 0, self.name);
            output.w(serialDesc, 1, self.value);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Argument copy(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            return new Argument(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Argument)) {
                return false;
            }
            Argument argument = (Argument) other;
            return kotlin.jvm.internal.p.d(this.name, argument.name) && kotlin.jvm.internal.p.d(this.value, argument.value);
        }

        public final String getName() {
            return this.name;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Argument(name=" + this.name + ", value=" + this.value + ')';
        }

        public Argument(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.name = name;
            this.value = value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CompleteRequest> serializer() {
            return CompleteRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CompleteRequest(int i10, Reference reference, Argument argument, qb.D d10, Method method, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, CompleteRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.ref = reference;
        this.argument = argument;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 8) == 0) {
            this.method = Method.Defined.CompletionComplete;
        } else {
            this.method = method;
        }
    }

    public static /* synthetic */ CompleteRequest copy$default(CompleteRequest completeRequest, Reference reference, Argument argument, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            reference = completeRequest.ref;
        }
        if ((i10 & 2) != 0) {
            argument = completeRequest.argument;
        }
        if ((i10 & 4) != 0) {
            d10 = completeRequest._meta;
        }
        return completeRequest.copy(reference, argument, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CompleteRequest self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, ReferencePolymorphicSerializer.INSTANCE, self.ref);
        output.x(serialDesc, 1, CompleteRequest$Argument$$serializer.INSTANCE, self.argument);
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 3) && self.getMethod() == Method.Defined.CompletionComplete) {
            return;
        }
        output.x(serialDesc, 3, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final Reference getRef() {
        return this.ref;
    }

    /* renamed from: component2, reason: from getter */
    public final Argument getArgument() {
        return this.argument;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CompleteRequest copy(Reference ref, Argument argument, qb.D _meta) {
        kotlin.jvm.internal.p.i(ref, "ref");
        kotlin.jvm.internal.p.i(argument, "argument");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CompleteRequest(ref, argument, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompleteRequest)) {
            return false;
        }
        CompleteRequest completeRequest = (CompleteRequest) other;
        return kotlin.jvm.internal.p.d(this.ref, completeRequest.ref) && kotlin.jvm.internal.p.d(this.argument, completeRequest.argument) && kotlin.jvm.internal.p.d(this._meta, completeRequest._meta);
    }

    public final Argument getArgument() {
        return this.argument;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public final Reference getRef() {
        return this.ref;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (((this.ref.hashCode() * 31) + this.argument.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CompleteRequest(ref=" + this.ref + ", argument=" + this.argument + ", _meta=" + this._meta + ')';
    }

    public CompleteRequest(Reference ref, Argument argument, qb.D _meta) {
        kotlin.jvm.internal.p.i(ref, "ref");
        kotlin.jvm.internal.p.i(argument, "argument");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.ref = ref;
        this.argument = argument;
        this._meta = _meta;
        this.method = Method.Defined.CompletionComplete;
    }

    public /* synthetic */ CompleteRequest(Reference reference, Argument argument, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(reference, argument, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
