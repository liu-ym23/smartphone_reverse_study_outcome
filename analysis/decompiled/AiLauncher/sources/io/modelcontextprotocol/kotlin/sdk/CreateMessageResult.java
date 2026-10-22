package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0002;:B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rBM\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b$\u0010%JD\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u001dJ\u0010\u0010)\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010.\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u0010!R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b7\u0010#R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u00108\u001a\u0004\b9\u0010%¨\u0006<"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;", "Lio/modelcontextprotocol/kotlin/sdk/ClientResult;", "", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "stopReason", "Lio/modelcontextprotocol/kotlin/sdk/Role;", BundleContentBridge.KEY_ROLE, "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/StopReason;Lio/modelcontextprotocol/kotlin/sdk/Role;Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/StopReason;Lio/modelcontextprotocol/kotlin/sdk/Role;Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "component3", "()Lio/modelcontextprotocol/kotlin/sdk/Role;", "component4", "()Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "component5", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/StopReason;Lio/modelcontextprotocol/kotlin/sdk/Role;Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getModel", "Lio/modelcontextprotocol/kotlin/sdk/StopReason;", "getStopReason", "Lio/modelcontextprotocol/kotlin/sdk/Role;", "getRole", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "getContent", "Lqb/D;", "get_meta", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CreateMessageResult implements ClientResult {
    private final qb.D _meta;
    private final PromptMessageContentMultimodal content;
    private final String model;
    private final Role role;
    private final StopReason stopReason;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.l
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CreateMessageResult._childSerializers$_anonymous_();
        }
    }), null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateMessageResult> serializer() {
            return CreateMessageResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CreateMessageResult(int i10, String str, StopReason stopReason, Role role, PromptMessageContentMultimodal promptMessageContentMultimodal, qb.D d10, T0 t02) {
        if (13 != (i10 & 13)) {
            E0.a(i10, 13, CreateMessageResult$$serializer.INSTANCE.getDescriptor());
        }
        this.model = str;
        if ((i10 & 2) == 0) {
            this.stopReason = null;
        } else {
            this.stopReason = stopReason;
        }
        this.role = role;
        this.content = promptMessageContentMultimodal;
        if ((i10 & 16) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return Role.INSTANCE.serializer();
    }

    public static /* synthetic */ CreateMessageResult copy$default(CreateMessageResult createMessageResult, String str, StopReason stopReason, Role role, PromptMessageContentMultimodal promptMessageContentMultimodal, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = createMessageResult.model;
        }
        if ((i10 & 2) != 0) {
            stopReason = createMessageResult.stopReason;
        }
        if ((i10 & 4) != 0) {
            role = createMessageResult.role;
        }
        if ((i10 & 8) != 0) {
            promptMessageContentMultimodal = createMessageResult.content;
        }
        if ((i10 & 16) != 0) {
            d10 = createMessageResult._meta;
        }
        qb.D d11 = d10;
        Role role2 = role;
        return createMessageResult.copy(str, stopReason, role2, promptMessageContentMultimodal, d11);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CreateMessageResult self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.w(serialDesc, 0, self.model);
        if (output.y(serialDesc, 1) || self.stopReason != null) {
            output.k(serialDesc, 1, StopReasonSerializer.INSTANCE, self.stopReason);
        }
        output.x(serialDesc, 2, hVarArr[2].getValue(), self.role);
        output.x(serialDesc, 3, PromptMessageContentMultimodalPolymorphicSerializer.INSTANCE, self.content);
        if (!output.y(serialDesc, 4) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 4, qb.E.f38623a, self.get_meta());
    }

    /* renamed from: component1, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component2, reason: from getter */
    public final StopReason getStopReason() {
        return this.stopReason;
    }

    /* renamed from: component3, reason: from getter */
    public final Role getRole() {
        return this.role;
    }

    /* renamed from: component4, reason: from getter */
    public final PromptMessageContentMultimodal getContent() {
        return this.content;
    }

    /* renamed from: component5, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CreateMessageResult copy(String model, StopReason stopReason, Role role, PromptMessageContentMultimodal content, qb.D _meta) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CreateMessageResult(model, stopReason, role, content, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateMessageResult)) {
            return false;
        }
        CreateMessageResult createMessageResult = (CreateMessageResult) other;
        return kotlin.jvm.internal.p.d(this.model, createMessageResult.model) && kotlin.jvm.internal.p.d(this.stopReason, createMessageResult.stopReason) && this.role == createMessageResult.role && kotlin.jvm.internal.p.d(this.content, createMessageResult.content) && kotlin.jvm.internal.p.d(this._meta, createMessageResult._meta);
    }

    public final PromptMessageContentMultimodal getContent() {
        return this.content;
    }

    public final String getModel() {
        return this.model;
    }

    public final Role getRole() {
        return this.role;
    }

    public final StopReason getStopReason() {
        return this.stopReason;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = this.model.hashCode() * 31;
        StopReason stopReason = this.stopReason;
        return ((((((iHashCode + (stopReason == null ? 0 : stopReason.hashCode())) * 31) + this.role.hashCode()) * 31) + this.content.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CreateMessageResult(model=" + this.model + ", stopReason=" + this.stopReason + ", role=" + this.role + ", content=" + this.content + ", _meta=" + this._meta + ')';
    }

    public CreateMessageResult(String model, StopReason stopReason, Role role, PromptMessageContentMultimodal content, qb.D _meta) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.model = model;
        this.stopReason = stopReason;
        this.role = role;
        this.content = content;
        this._meta = _meta;
    }

    public /* synthetic */ CreateMessageResult(String str, StopReason stopReason, Role role, PromptMessageContentMultimodal promptMessageContentMultimodal, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? null : stopReason, role, promptMessageContentMultimodal, (i10 & 16) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
