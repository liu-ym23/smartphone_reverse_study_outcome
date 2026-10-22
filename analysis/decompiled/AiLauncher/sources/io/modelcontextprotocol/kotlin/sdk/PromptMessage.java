package io.modelcontextprotocol.kotlin.sdk;

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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*)B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u0019¨\u0006+"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptMessage;", "", "Lio/modelcontextprotocol/kotlin/sdk/Role;", BundleContentBridge.KEY_ROLE, "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Role;Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/Role;Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/PromptMessage;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/Role;", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/Role;Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;)Lio/modelcontextprotocol/kotlin/sdk/PromptMessage;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/Role;", "getRole", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", "getContent", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class PromptMessage {
    private final PromptMessageContent content;
    private final Role role;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.D
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PromptMessage._childSerializers$_anonymous_();
        }
    }), null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptMessage$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessage;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PromptMessage> serializer() {
            return PromptMessage$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ PromptMessage(int i10, Role role, PromptMessageContent promptMessageContent, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, PromptMessage$$serializer.INSTANCE.getDescriptor());
        }
        this.role = role;
        this.content = promptMessageContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return Role.INSTANCE.serializer();
    }

    public static /* synthetic */ PromptMessage copy$default(PromptMessage promptMessage, Role role, PromptMessageContent promptMessageContent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            role = promptMessage.role;
        }
        if ((i10 & 2) != 0) {
            promptMessageContent = promptMessage.content;
        }
        return promptMessage.copy(role, promptMessageContent);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(PromptMessage self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.role);
        output.x(serialDesc, 1, PromptMessageContentPolymorphicSerializer.INSTANCE, self.content);
    }

    /* renamed from: component1, reason: from getter */
    public final Role getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final PromptMessageContent getContent() {
        return this.content;
    }

    public final PromptMessage copy(Role role, PromptMessageContent content) {
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(content, "content");
        return new PromptMessage(role, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromptMessage)) {
            return false;
        }
        PromptMessage promptMessage = (PromptMessage) other;
        return this.role == promptMessage.role && kotlin.jvm.internal.p.d(this.content, promptMessage.content);
    }

    public final PromptMessageContent getContent() {
        return this.content;
    }

    public final Role getRole() {
        return this.role;
    }

    public int hashCode() {
        return (this.role.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        return "PromptMessage(role=" + this.role + ", content=" + this.content + ')';
    }

    public PromptMessage(Role role, PromptMessageContent content) {
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(content, "content");
        this.role = role;
        this.content = content;
    }
}
