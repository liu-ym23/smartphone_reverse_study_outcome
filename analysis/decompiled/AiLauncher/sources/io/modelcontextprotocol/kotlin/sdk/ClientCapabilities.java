package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u000301/B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J@\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u0019R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b.\u0010\u0019¨\u00062"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "", "Lqb/D;", "experimental", "sampling", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;", "roots", "elicitation", "<init>", "(Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lqb/D;", "component2", "component3", "()Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;", "component4", ChatTracker.CLICK_COPY, "(Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lqb/D;", "getExperimental", "getSampling", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;", "getRoots", "getElicitation", "Companion", "Roots", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ClientCapabilities {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D elicitation;
    private final qb.D experimental;
    private final Roots roots;
    private final qb.D sampling;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ClientCapabilities> serializer() {
            return ClientCapabilities$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;", "", "", "listChanged", "<init>", "(Ljava/lang/Boolean;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Boolean;", ChatTracker.CLICK_COPY, "(Ljava/lang/Boolean;)Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getListChanged", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Roots {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean listChanged;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities$Roots;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Roots> serializer() {
                return ClientCapabilities$Roots$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Roots(int i10, Boolean bool, T0 t02) {
            if (1 != (i10 & 1)) {
                E0.a(i10, 1, ClientCapabilities$Roots$$serializer.INSTANCE.getDescriptor());
            }
            this.listChanged = bool;
        }

        public static /* synthetic */ Roots copy$default(Roots roots, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = roots.listChanged;
            }
            return roots.copy(bool);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getListChanged() {
            return this.listChanged;
        }

        public final Roots copy(Boolean listChanged) {
            return new Roots(listChanged);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Roots) && kotlin.jvm.internal.p.d(this.listChanged, ((Roots) other).listChanged);
        }

        public final Boolean getListChanged() {
            return this.listChanged;
        }

        public int hashCode() {
            Boolean bool = this.listChanged;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "Roots(listChanged=" + this.listChanged + ')';
        }

        public Roots(Boolean bool) {
            this.listChanged = bool;
        }
    }

    public ClientCapabilities() {
        this((qb.D) null, (qb.D) null, (Roots) null, (qb.D) null, 15, (kotlin.jvm.internal.i) null);
    }

    public static /* synthetic */ ClientCapabilities copy$default(ClientCapabilities clientCapabilities, qb.D d10, qb.D d11, Roots roots, qb.D d12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = clientCapabilities.experimental;
        }
        if ((i10 & 2) != 0) {
            d11 = clientCapabilities.sampling;
        }
        if ((i10 & 4) != 0) {
            roots = clientCapabilities.roots;
        }
        if ((i10 & 8) != 0) {
            d12 = clientCapabilities.elicitation;
        }
        return clientCapabilities.copy(d10, d11, roots, d12);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ClientCapabilities self, ob.d output, SerialDescriptor serialDesc) {
        if (output.y(serialDesc, 0) || !kotlin.jvm.internal.p.d(self.experimental, Types_utilKt.getEmptyJsonObject())) {
            output.k(serialDesc, 0, qb.E.f38623a, self.experimental);
        }
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.sampling, Types_utilKt.getEmptyJsonObject())) {
            output.k(serialDesc, 1, qb.E.f38623a, self.sampling);
        }
        if (output.y(serialDesc, 2) || self.roots != null) {
            output.k(serialDesc, 2, ClientCapabilities$Roots$$serializer.INSTANCE, self.roots);
        }
        if (!output.y(serialDesc, 3) && self.elicitation == null) {
            return;
        }
        output.k(serialDesc, 3, qb.E.f38623a, self.elicitation);
    }

    /* renamed from: component1, reason: from getter */
    public final qb.D getExperimental() {
        return this.experimental;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.D getSampling() {
        return this.sampling;
    }

    /* renamed from: component3, reason: from getter */
    public final Roots getRoots() {
        return this.roots;
    }

    /* renamed from: component4, reason: from getter */
    public final qb.D getElicitation() {
        return this.elicitation;
    }

    public final ClientCapabilities copy(qb.D experimental, qb.D sampling, Roots roots, qb.D elicitation) {
        return new ClientCapabilities(experimental, sampling, roots, elicitation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientCapabilities)) {
            return false;
        }
        ClientCapabilities clientCapabilities = (ClientCapabilities) other;
        return kotlin.jvm.internal.p.d(this.experimental, clientCapabilities.experimental) && kotlin.jvm.internal.p.d(this.sampling, clientCapabilities.sampling) && kotlin.jvm.internal.p.d(this.roots, clientCapabilities.roots) && kotlin.jvm.internal.p.d(this.elicitation, clientCapabilities.elicitation);
    }

    public final qb.D getElicitation() {
        return this.elicitation;
    }

    public final qb.D getExperimental() {
        return this.experimental;
    }

    public final Roots getRoots() {
        return this.roots;
    }

    public final qb.D getSampling() {
        return this.sampling;
    }

    public int hashCode() {
        qb.D d10 = this.experimental;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        qb.D d11 = this.sampling;
        int iHashCode2 = (iHashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        Roots roots = this.roots;
        int iHashCode3 = (iHashCode2 + (roots == null ? 0 : roots.hashCode())) * 31;
        qb.D d12 = this.elicitation;
        return iHashCode3 + (d12 != null ? d12.hashCode() : 0);
    }

    public String toString() {
        return "ClientCapabilities(experimental=" + this.experimental + ", sampling=" + this.sampling + ", roots=" + this.roots + ", elicitation=" + this.elicitation + ')';
    }

    public /* synthetic */ ClientCapabilities(int i10, qb.D d10, qb.D d11, Roots roots, qb.D d12, T0 t02) {
        this.experimental = (i10 & 1) == 0 ? Types_utilKt.getEmptyJsonObject() : d10;
        if ((i10 & 2) == 0) {
            this.sampling = Types_utilKt.getEmptyJsonObject();
        } else {
            this.sampling = d11;
        }
        if ((i10 & 4) == 0) {
            this.roots = null;
        } else {
            this.roots = roots;
        }
        if ((i10 & 8) == 0) {
            this.elicitation = null;
        } else {
            this.elicitation = d12;
        }
    }

    public ClientCapabilities(qb.D d10, qb.D d11, Roots roots, qb.D d12) {
        this.experimental = d10;
        this.sampling = d11;
        this.roots = roots;
        this.elicitation = d12;
    }

    public /* synthetic */ ClientCapabilities(qb.D d10, qb.D d11, Roots roots, qb.D d12, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : d11, (i10 & 4) != 0 ? null : roots, (i10 & 8) != 0 ? null : d12);
    }
}
