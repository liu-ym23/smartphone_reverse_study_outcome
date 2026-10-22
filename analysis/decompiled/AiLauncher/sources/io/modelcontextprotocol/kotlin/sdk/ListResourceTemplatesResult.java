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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002%$B1\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB?\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult;", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "Lio/modelcontextprotocol/kotlin/sdk/PaginatedResult;", "", "Lio/modelcontextprotocol/kotlin/sdk/ResourceTemplate;", "resourceTemplates", "", "Lio/modelcontextprotocol/kotlin/sdk/Cursor;", "nextCursor", "Lqb/D;", "_meta", "<init>", "(Ljava/util/List;Ljava/lang/String;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/String;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getResourceTemplates", "()Ljava/util/List;", "Ljava/lang/String;", "getNextCursor", "()Ljava/lang/String;", "Lqb/D;", "get_meta", "()Lqb/D;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class ListResourceTemplatesResult implements ServerResult, PaginatedResult {
    private final qb.D _meta;
    private final String nextCursor;
    private final List<ResourceTemplate> resourceTemplates;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.s
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ListResourceTemplatesResult._childSerializers$_anonymous_();
        }
    }), null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ListResourceTemplatesResult> serializer() {
            return ListResourceTemplatesResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ ListResourceTemplatesResult(int i10, List list, String str, qb.D d10, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, ListResourceTemplatesResult$$serializer.INSTANCE.getDescriptor());
        }
        this.resourceTemplates = list;
        if ((i10 & 2) == 0) {
            this.nextCursor = null;
        } else {
            this.nextCursor = str;
        }
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new C5094f(ResourceTemplate$$serializer.INSTANCE);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ListResourceTemplatesResult self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.resourceTemplates);
        if (output.y(serialDesc, 1) || self.getNextCursor() != null) {
            output.k(serialDesc, 1, Y0.f38329a, self.getNextCursor());
        }
        if (!output.y(serialDesc, 2) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.PaginatedResult
    public String getNextCursor() {
        return this.nextCursor;
    }

    public final List<ResourceTemplate> getResourceTemplates() {
        return this.resourceTemplates;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public ListResourceTemplatesResult(List<ResourceTemplate> resourceTemplates, String str, qb.D _meta) {
        kotlin.jvm.internal.p.i(resourceTemplates, "resourceTemplates");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.resourceTemplates = resourceTemplates;
        this.nextCursor = str;
        this._meta = _meta;
    }

    public /* synthetic */ ListResourceTemplatesResult(List list, String str, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
