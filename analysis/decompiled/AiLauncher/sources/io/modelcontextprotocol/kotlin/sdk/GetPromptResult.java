package io.modelcontextprotocol.kotlin.sdk;

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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#\"B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult;", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "", "description", "", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessage;", "messages", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Ljava/util/List;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Ljava/util/List;", "getMessages", "()Ljava/util/List;", "Lqb/D;", "get_meta", "()Lqb/D;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class GetPromptResult implements ServerResult {
    private final qb.D _meta;
    private final String description;
    private final List<PromptMessage> messages;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.o
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return GetPromptResult._childSerializers$_anonymous_();
        }
    }), null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GetPromptResult> serializer() {
            return GetPromptResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ GetPromptResult(int i10, String str, List list, qb.D d10, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, GetPromptResult$$serializer.INSTANCE.getDescriptor());
        }
        this.description = str;
        this.messages = list;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new C5094f(PromptMessage$$serializer.INSTANCE);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(GetPromptResult self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.k(serialDesc, 0, Y0.f38329a, self.description);
        output.x(serialDesc, 1, hVarArr[1].getValue(), self.messages);
        if (!output.y(serialDesc, 2) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<PromptMessage> getMessages() {
        return this.messages;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public GetPromptResult(String str, List<PromptMessage> messages, qb.D _meta) {
        kotlin.jvm.internal.p.i(messages, "messages");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.description = str;
        this.messages = messages;
        this._meta = _meta;
    }

    public /* synthetic */ GetPromptResult(String str, List list, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, list, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
