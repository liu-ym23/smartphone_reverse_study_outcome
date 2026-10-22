package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import h9.InterfaceC4149a;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationResult;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0003./-B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ0\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b,\u0010\u001a¨\u00060"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "Lio/modelcontextprotocol/kotlin/sdk/ClientResult;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;", "action", "Lqb/D;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "_meta", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;Lqb/D;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;Lqb/D;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;", "component2", "()Lqb/D;", "component3", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;Lqb/D;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;", "getAction", "Lqb/D;", "getContent", "get_meta", "Companion", "Action", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CreateElicitationResult implements ClientResult {
    private final qb.D _meta;
    private final Action action;
    private final qb.D content;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.f
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CreateElicitationResult._childSerializers$_anonymous_();
        }
    }), null, null};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "accept", "decline", "cancel", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final class Action {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Action[] $VALUES;
        private static final Y8.h<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Action accept = new Action("accept", 0);
        public static final Action decline = new Action("decline", 1);
        public static final Action cancel = new Action("cancel", 2);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Action;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Action.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Action> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{accept, decline, cancel};
        }

        static {
            Action[] actionArr$values = $values();
            $VALUES = actionArr$values;
            $ENTRIES = kotlin.enums.a.a(actionArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.g
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CreateElicitationResult.Action._init_$_anonymous_();
                }
            });
        }

        private Action(String str, int i10) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return pb.I.a("io.modelcontextprotocol.kotlin.sdk.CreateElicitationResult.Action", values());
        }

        public static InterfaceC4149a<Action> getEntries() {
            return $ENTRIES;
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateElicitationResult> serializer() {
            return CreateElicitationResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CreateElicitationResult(int i10, Action action, qb.D d10, qb.D d11, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, CreateElicitationResult$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.content = (i10 & 2) == 0 ? null : d10;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d11;
        }
        if (action != Action.accept && this.content != null) {
            throw new IllegalArgumentException("Content can only be provided for an 'accept' action");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return Action.INSTANCE.serializer();
    }

    public static /* synthetic */ CreateElicitationResult copy$default(CreateElicitationResult createElicitationResult, Action action, qb.D d10, qb.D d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            action = createElicitationResult.action;
        }
        if ((i10 & 2) != 0) {
            d10 = createElicitationResult.content;
        }
        if ((i10 & 4) != 0) {
            d11 = createElicitationResult._meta;
        }
        return createElicitationResult.copy(action, d10, d11);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CreateElicitationResult self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.action);
        if (output.y(serialDesc, 1) || self.content != null) {
            output.k(serialDesc, 1, qb.E.f38623a, self.content);
        }
        if (!output.y(serialDesc, 2) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
    }

    /* renamed from: component1, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.D getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CreateElicitationResult copy(Action action, qb.D content, qb.D _meta) {
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CreateElicitationResult(action, content, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateElicitationResult)) {
            return false;
        }
        CreateElicitationResult createElicitationResult = (CreateElicitationResult) other;
        return this.action == createElicitationResult.action && kotlin.jvm.internal.p.d(this.content, createElicitationResult.content) && kotlin.jvm.internal.p.d(this._meta, createElicitationResult._meta);
    }

    public final Action getAction() {
        return this.action;
    }

    public final qb.D getContent() {
        return this.content;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = this.action.hashCode() * 31;
        qb.D d10 = this.content;
        return ((iHashCode + (d10 == null ? 0 : d10.hashCode())) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CreateElicitationResult(action=" + this.action + ", content=" + this.content + ", _meta=" + this._meta + ')';
    }

    public CreateElicitationResult(Action action, qb.D d10, qb.D _meta) {
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.action = action;
        this.content = d10;
        this._meta = _meta;
        if (action != Action.accept && d10 != null) {
            throw new IllegalArgumentException("Content can only be provided for an 'accept' action");
        }
    }

    public /* synthetic */ CreateElicitationResult(Action action, qb.D d10, qb.D d11, int i10, kotlin.jvm.internal.i iVar) {
        this(action, (i10 & 2) != 0 ? null : d10, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d11);
    }
}
