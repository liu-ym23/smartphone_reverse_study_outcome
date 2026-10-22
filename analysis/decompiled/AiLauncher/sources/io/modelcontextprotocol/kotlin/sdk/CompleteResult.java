package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.CompleteResult;
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
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0003+,*B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u0019¨\u0006-"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteResult;", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;", "completion", "Lqb/D;", "_meta", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CompleteResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;", "component2", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CompleteResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;", "getCompletion", "Lqb/D;", "get_meta", "Companion", "Completion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CompleteResult implements ServerResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final Completion completion;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CompleteResult> serializer() {
            return CompleteResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CompleteResult(int i10, Completion completion, qb.D d10, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, CompleteResult$$serializer.INSTANCE.getDescriptor());
        }
        this.completion = completion;
        if ((i10 & 2) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
    }

    public static /* synthetic */ CompleteResult copy$default(CompleteResult completeResult, Completion completion, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            completion = completeResult.completion;
        }
        if ((i10 & 2) != 0) {
            d10 = completeResult._meta;
        }
        return completeResult.copy(completion, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CompleteResult self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, CompleteResult$Completion$$serializer.INSTANCE, self.completion);
        if (!output.y(serialDesc, 1) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 1, qb.E.f38623a, self.get_meta());
    }

    /* renamed from: component1, reason: from getter */
    public final Completion getCompletion() {
        return this.completion;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CompleteResult copy(Completion completion, qb.D _meta) {
        kotlin.jvm.internal.p.i(completion, "completion");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CompleteResult(completion, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompleteResult)) {
            return false;
        }
        CompleteResult completeResult = (CompleteResult) other;
        return kotlin.jvm.internal.p.d(this.completion, completeResult.completion) && kotlin.jvm.internal.p.d(this._meta, completeResult._meta);
    }

    public final Completion getCompletion() {
        return this.completion;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (this.completion.hashCode() * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CompleteResult(completion=" + this.completion + ", _meta=" + this._meta + ')';
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002\"!B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;", "", "", "", "values", "", "total", "", "hasMore", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "Ljava/lang/Integer;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @lb.l
    public static final class Completion {
        private final Boolean hasMore;
        private final Integer total;
        private final List<String> values;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CompleteResult.Completion._childSerializers$_anonymous_();
            }
        }), null, null};

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteResult$Completion;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Completion> serializer() {
                return CompleteResult$Completion$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }
        }

        public /* synthetic */ Completion(int i10, List list, Integer num, Boolean bool, T0 t02) {
            if (7 != (i10 & 7)) {
                E0.a(i10, 7, CompleteResult$Completion$$serializer.INSTANCE.getDescriptor());
            }
            this.values = list;
            this.total = num;
            this.hasMore = bool;
            if (list.size() > 100) {
                throw new IllegalArgumentException("'values' field must not exceed 100 items");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new C5094f(Y0.f38329a);
        }

        public static final /* synthetic */ void write$Self$kotlin_sdk(Completion self, ob.d output, SerialDescriptor serialDesc) {
            output.x(serialDesc, 0, $childSerializers[0].getValue(), self.values);
            output.k(serialDesc, 1, X.f38325a, self.total);
            output.k(serialDesc, 2, C5100i.f38363a, self.hasMore);
        }

        public final Boolean getHasMore() {
            return this.hasMore;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final List<String> getValues() {
            return this.values;
        }

        public Completion(List<String> values, Integer num, Boolean bool) {
            kotlin.jvm.internal.p.i(values, "values");
            this.values = values;
            this.total = num;
            this.hasMore = bool;
            if (values.size() > 100) {
                throw new IllegalArgumentException("'values' field must not exceed 100 items");
            }
        }
    }

    public CompleteResult(Completion completion, qb.D _meta) {
        kotlin.jvm.internal.p.i(completion, "completion");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.completion = completion;
        this._meta = _meta;
    }

    public /* synthetic */ CompleteResult(Completion completion, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(completion, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
