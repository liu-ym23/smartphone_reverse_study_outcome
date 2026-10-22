package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.C5100i;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0005<=>?;BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b$\u0010%JX\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001dR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\b3\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b4\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b6\u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010%¨\u0006@"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "", "Lqb/D;", "experimental", "sampling", "logging", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;", "prompts", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "resources", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;", "tools", "<init>", "(Lqb/D;Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILqb/D;Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lqb/D;", "component2", "component3", "component4", "()Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;", "component5", "()Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "component6", "()Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;", ChatTracker.CLICK_COPY, "(Lqb/D;Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;)Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lqb/D;", "getExperimental", "getSampling", "getLogging", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;", "getPrompts", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "getResources", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;", "getTools", "Companion", "Prompts", "Resources", "Tools", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ServerCapabilities {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D experimental;
    private final qb.D logging;
    private final Prompts prompts;
    private final Resources resources;
    private final qb.D sampling;
    private final Tools tools;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ServerCapabilities> serializer() {
            return ServerCapabilities$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;", "", "", "listChanged", "<init>", "(Ljava/lang/Boolean;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Boolean;", ChatTracker.CLICK_COPY, "(Ljava/lang/Boolean;)Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getListChanged", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Prompts {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean listChanged;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Prompts;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Prompts> serializer() {
                return ServerCapabilities$Prompts$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Prompts(int i10, Boolean bool, T0 t02) {
            if (1 != (i10 & 1)) {
                E0.a(i10, 1, ServerCapabilities$Prompts$$serializer.INSTANCE.getDescriptor());
            }
            this.listChanged = bool;
        }

        public static /* synthetic */ Prompts copy$default(Prompts prompts, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = prompts.listChanged;
            }
            return prompts.copy(bool);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getListChanged() {
            return this.listChanged;
        }

        public final Prompts copy(Boolean listChanged) {
            return new Prompts(listChanged);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Prompts) && kotlin.jvm.internal.p.d(this.listChanged, ((Prompts) other).listChanged);
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
            return "Prompts(listChanged=" + this.listChanged + ')';
        }

        public Prompts(Boolean bool) {
            this.listChanged = bool;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J(\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0016¨\u0006'"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "", "", "subscribe", "listChanged", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Boolean;", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getSubscribe", "getListChanged", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Resources {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean listChanged;
        private final Boolean subscribe;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Resources> serializer() {
                return ServerCapabilities$Resources$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Resources(int i10, Boolean bool, Boolean bool2, T0 t02) {
            if (3 != (i10 & 3)) {
                E0.a(i10, 3, ServerCapabilities$Resources$$serializer.INSTANCE.getDescriptor());
            }
            this.subscribe = bool;
            this.listChanged = bool2;
        }

        public static /* synthetic */ Resources copy$default(Resources resources, Boolean bool, Boolean bool2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = resources.subscribe;
            }
            if ((i10 & 2) != 0) {
                bool2 = resources.listChanged;
            }
            return resources.copy(bool, bool2);
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(Resources self, ob.d output, SerialDescriptor serialDesc) {
            C5100i c5100i = C5100i.f38363a;
            output.k(serialDesc, 0, c5100i, self.subscribe);
            output.k(serialDesc, 1, c5100i, self.listChanged);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getSubscribe() {
            return this.subscribe;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getListChanged() {
            return this.listChanged;
        }

        public final Resources copy(Boolean subscribe, Boolean listChanged) {
            return new Resources(subscribe, listChanged);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Resources)) {
                return false;
            }
            Resources resources = (Resources) other;
            return kotlin.jvm.internal.p.d(this.subscribe, resources.subscribe) && kotlin.jvm.internal.p.d(this.listChanged, resources.listChanged);
        }

        public final Boolean getListChanged() {
            return this.listChanged;
        }

        public final Boolean getSubscribe() {
            return this.subscribe;
        }

        public int hashCode() {
            Boolean bool = this.subscribe;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.listChanged;
            return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "Resources(subscribe=" + this.subscribe + ", listChanged=" + this.listChanged + ')';
        }

        public Resources(Boolean bool, Boolean bool2) {
            this.subscribe = bool;
            this.listChanged = bool2;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;", "", "", "listChanged", "<init>", "(Ljava/lang/Boolean;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Boolean;", ChatTracker.CLICK_COPY, "(Ljava/lang/Boolean;)Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getListChanged", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final /* data */ class Tools {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean listChanged;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Tools;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Tools> serializer() {
                return ServerCapabilities$Tools$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Tools(int i10, Boolean bool, T0 t02) {
            if (1 != (i10 & 1)) {
                E0.a(i10, 1, ServerCapabilities$Tools$$serializer.INSTANCE.getDescriptor());
            }
            this.listChanged = bool;
        }

        public static /* synthetic */ Tools copy$default(Tools tools, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = tools.listChanged;
            }
            return tools.copy(bool);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getListChanged() {
            return this.listChanged;
        }

        public final Tools copy(Boolean listChanged) {
            return new Tools(listChanged);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tools) && kotlin.jvm.internal.p.d(this.listChanged, ((Tools) other).listChanged);
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
            return "Tools(listChanged=" + this.listChanged + ')';
        }

        public Tools(Boolean bool) {
            this.listChanged = bool;
        }
    }

    public ServerCapabilities() {
        this((qb.D) null, (qb.D) null, (qb.D) null, (Prompts) null, (Resources) null, (Tools) null, 63, (kotlin.jvm.internal.i) null);
    }

    public static /* synthetic */ ServerCapabilities copy$default(ServerCapabilities serverCapabilities, qb.D d10, qb.D d11, qb.D d12, Prompts prompts, Resources resources, Tools tools, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = serverCapabilities.experimental;
        }
        if ((i10 & 2) != 0) {
            d11 = serverCapabilities.sampling;
        }
        if ((i10 & 4) != 0) {
            d12 = serverCapabilities.logging;
        }
        if ((i10 & 8) != 0) {
            prompts = serverCapabilities.prompts;
        }
        if ((i10 & 16) != 0) {
            resources = serverCapabilities.resources;
        }
        if ((i10 & 32) != 0) {
            tools = serverCapabilities.tools;
        }
        Resources resources2 = resources;
        Tools tools2 = tools;
        return serverCapabilities.copy(d10, d11, d12, prompts, resources2, tools2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ServerCapabilities self, ob.d output, SerialDescriptor serialDesc) {
        if (output.y(serialDesc, 0) || !kotlin.jvm.internal.p.d(self.experimental, Types_utilKt.getEmptyJsonObject())) {
            output.k(serialDesc, 0, qb.E.f38623a, self.experimental);
        }
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.sampling, Types_utilKt.getEmptyJsonObject())) {
            output.k(serialDesc, 1, qb.E.f38623a, self.sampling);
        }
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.logging, Types_utilKt.getEmptyJsonObject())) {
            output.k(serialDesc, 2, qb.E.f38623a, self.logging);
        }
        if (output.y(serialDesc, 3) || self.prompts != null) {
            output.k(serialDesc, 3, ServerCapabilities$Prompts$$serializer.INSTANCE, self.prompts);
        }
        if (output.y(serialDesc, 4) || self.resources != null) {
            output.k(serialDesc, 4, ServerCapabilities$Resources$$serializer.INSTANCE, self.resources);
        }
        if (!output.y(serialDesc, 5) && self.tools == null) {
            return;
        }
        output.k(serialDesc, 5, ServerCapabilities$Tools$$serializer.INSTANCE, self.tools);
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
    public final qb.D getLogging() {
        return this.logging;
    }

    /* renamed from: component4, reason: from getter */
    public final Prompts getPrompts() {
        return this.prompts;
    }

    /* renamed from: component5, reason: from getter */
    public final Resources getResources() {
        return this.resources;
    }

    /* renamed from: component6, reason: from getter */
    public final Tools getTools() {
        return this.tools;
    }

    public final ServerCapabilities copy(qb.D experimental, qb.D sampling, qb.D logging, Prompts prompts, Resources resources, Tools tools) {
        return new ServerCapabilities(experimental, sampling, logging, prompts, resources, tools);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerCapabilities)) {
            return false;
        }
        ServerCapabilities serverCapabilities = (ServerCapabilities) other;
        return kotlin.jvm.internal.p.d(this.experimental, serverCapabilities.experimental) && kotlin.jvm.internal.p.d(this.sampling, serverCapabilities.sampling) && kotlin.jvm.internal.p.d(this.logging, serverCapabilities.logging) && kotlin.jvm.internal.p.d(this.prompts, serverCapabilities.prompts) && kotlin.jvm.internal.p.d(this.resources, serverCapabilities.resources) && kotlin.jvm.internal.p.d(this.tools, serverCapabilities.tools);
    }

    public final qb.D getExperimental() {
        return this.experimental;
    }

    public final qb.D getLogging() {
        return this.logging;
    }

    public final Prompts getPrompts() {
        return this.prompts;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final qb.D getSampling() {
        return this.sampling;
    }

    public final Tools getTools() {
        return this.tools;
    }

    public int hashCode() {
        qb.D d10 = this.experimental;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        qb.D d11 = this.sampling;
        int iHashCode2 = (iHashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        qb.D d12 = this.logging;
        int iHashCode3 = (iHashCode2 + (d12 == null ? 0 : d12.hashCode())) * 31;
        Prompts prompts = this.prompts;
        int iHashCode4 = (iHashCode3 + (prompts == null ? 0 : prompts.hashCode())) * 31;
        Resources resources = this.resources;
        int iHashCode5 = (iHashCode4 + (resources == null ? 0 : resources.hashCode())) * 31;
        Tools tools = this.tools;
        return iHashCode5 + (tools != null ? tools.hashCode() : 0);
    }

    public String toString() {
        return "ServerCapabilities(experimental=" + this.experimental + ", sampling=" + this.sampling + ", logging=" + this.logging + ", prompts=" + this.prompts + ", resources=" + this.resources + ", tools=" + this.tools + ')';
    }

    public /* synthetic */ ServerCapabilities(int i10, qb.D d10, qb.D d11, qb.D d12, Prompts prompts, Resources resources, Tools tools, T0 t02) {
        this.experimental = (i10 & 1) == 0 ? Types_utilKt.getEmptyJsonObject() : d10;
        if ((i10 & 2) == 0) {
            this.sampling = Types_utilKt.getEmptyJsonObject();
        } else {
            this.sampling = d11;
        }
        if ((i10 & 4) == 0) {
            this.logging = Types_utilKt.getEmptyJsonObject();
        } else {
            this.logging = d12;
        }
        if ((i10 & 8) == 0) {
            this.prompts = null;
        } else {
            this.prompts = prompts;
        }
        if ((i10 & 16) == 0) {
            this.resources = null;
        } else {
            this.resources = resources;
        }
        if ((i10 & 32) == 0) {
            this.tools = null;
        } else {
            this.tools = tools;
        }
    }

    public ServerCapabilities(qb.D d10, qb.D d11, qb.D d12, Prompts prompts, Resources resources, Tools tools) {
        this.experimental = d10;
        this.sampling = d11;
        this.logging = d12;
        this.prompts = prompts;
        this.resources = resources;
        this.tools = tools;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ ServerCapabilities(qb.D r2, qb.D r3, qb.D r4, io.modelcontextprotocol.kotlin.sdk.ServerCapabilities.Prompts r5, io.modelcontextprotocol.kotlin.sdk.ServerCapabilities.Resources r6, io.modelcontextprotocol.kotlin.sdk.ServerCapabilities.Tools r7, int r8, kotlin.jvm.internal.i r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L8
            qb.D r2 = io.modelcontextprotocol.kotlin.sdk.Types_utilKt.getEmptyJsonObject()
        L8:
            r9 = r8 & 2
            if (r9 == 0) goto L10
            qb.D r3 = io.modelcontextprotocol.kotlin.sdk.Types_utilKt.getEmptyJsonObject()
        L10:
            r9 = r8 & 4
            if (r9 == 0) goto L18
            qb.D r4 = io.modelcontextprotocol.kotlin.sdk.Types_utilKt.getEmptyJsonObject()
        L18:
            r9 = r8 & 8
            r0 = 0
            if (r9 == 0) goto L1e
            r5 = r0
        L1e:
            r9 = r8 & 16
            if (r9 == 0) goto L23
            r6 = r0
        L23:
            r8 = r8 & 32
            if (r8 == 0) goto L2f
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L36
        L2f:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L36:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.ServerCapabilities.<init>(qb.D, qb.D, qb.D, io.modelcontextprotocol.kotlin.sdk.ServerCapabilities$Prompts, io.modelcontextprotocol.kotlin.sdk.ServerCapabilities$Resources, io.modelcontextprotocol.kotlin.sdk.ServerCapabilities$Tools, int, kotlin.jvm.internal.i):void");
    }
}
