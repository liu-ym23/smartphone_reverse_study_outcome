package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.C5094f;
import pb.C5100i;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002$#B7\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b\b\u0010!R\u001a\u0010\t\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\"\u0010\u001f¨\u0006%"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResultBase;", "", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lqb/D;", "structuredContent", "", "isError", "_meta", "<init>", "(Ljava/util/List;Lqb/D;Ljava/lang/Boolean;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Lqb/D;Ljava/lang/Boolean;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "Lqb/D;", "getStructuredContent", "()Lqb/D;", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "get_meta", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class CallToolResult implements CallToolResultBase {
    private final qb.D _meta;
    private final List<PromptMessageContent> content;
    private final Boolean isError;
    private final qb.D structuredContent;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CallToolResult._childSerializers$_anonymous_();
        }
    }), null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CallToolResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CallToolResult> serializer() {
            return CallToolResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CallToolResult(int i10, List list, qb.D d10, Boolean bool, qb.D d11, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, CallToolResult$$serializer.INSTANCE.getDescriptor());
        }
        this.content = list;
        if ((i10 & 2) == 0) {
            this.structuredContent = null;
        } else {
            this.structuredContent = d10;
        }
        if ((i10 & 4) == 0) {
            this.isError = Boolean.FALSE;
        } else {
            this.isError = bool;
        }
        if ((i10 & 8) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new C5094f(PromptMessageContentPolymorphicSerializer.INSTANCE);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CallToolResult self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.getContent());
        if (output.y(serialDesc, 1) || self.getStructuredContent() != null) {
            output.k(serialDesc, 1, qb.E.f38623a, self.getStructuredContent());
        }
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.getIsError(), Boolean.FALSE)) {
            output.k(serialDesc, 2, C5100i.f38363a, self.getIsError());
        }
        if (!output.y(serialDesc, 3) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 3, qb.E.f38623a, self.get_meta());
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.CallToolResultBase
    public List<PromptMessageContent> getContent() {
        return this.content;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.CallToolResultBase
    public qb.D getStructuredContent() {
        return this.structuredContent;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.CallToolResultBase
    /* renamed from: isError, reason: from getter */
    public Boolean getIsError() {
        return this.isError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallToolResult(List<? extends PromptMessageContent> content, qb.D d10, Boolean bool, qb.D _meta) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.content = content;
        this.structuredContent = d10;
        this.isError = bool;
        this._meta = _meta;
    }

    public /* synthetic */ CallToolResult(List list, qb.D d10, Boolean bool, qb.D d11, int i10, kotlin.jvm.internal.i iVar) {
        this(list, (i10 & 2) != 0 ? null : d10, (i10 & 4) != 0 ? Boolean.FALSE : bool, (i10 & 8) != 0 ? Types_utilKt.getEmptyJsonObject() : d11);
    }
}
