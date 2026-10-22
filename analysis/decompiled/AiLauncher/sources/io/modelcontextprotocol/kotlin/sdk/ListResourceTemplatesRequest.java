package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00020/B!\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ,\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\"\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010\u001dR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/PaginatedRequest;", "", "Lio/modelcontextprotocol/kotlin/sdk/Cursor;", "cursor", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCursor", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ListResourceTemplatesRequest implements ClientRequest, PaginatedRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final String cursor;
    private final Method method;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ListResourceTemplatesRequest> serializer() {
            return ListResourceTemplatesRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ ListResourceTemplatesRequest(int i10, String str, qb.D d10, Method method, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, ListResourceTemplatesRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.cursor = str;
        if ((i10 & 2) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 4) == 0) {
            this.method = Method.Defined.ResourcesTemplatesList;
        } else {
            this.method = method;
        }
    }

    public static /* synthetic */ ListResourceTemplatesRequest copy$default(ListResourceTemplatesRequest listResourceTemplatesRequest, String str, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = listResourceTemplatesRequest.cursor;
        }
        if ((i10 & 2) != 0) {
            d10 = listResourceTemplatesRequest._meta;
        }
        return listResourceTemplatesRequest.copy(str, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ListResourceTemplatesRequest self, ob.d output, SerialDescriptor serialDesc) {
        output.k(serialDesc, 0, Y0.f38329a, self.getCursor());
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 1, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 2) && self.getMethod() == Method.Defined.ResourcesTemplatesList) {
            return;
        }
        output.x(serialDesc, 2, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final String getCursor() {
        return this.cursor;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final ListResourceTemplatesRequest copy(String cursor, qb.D _meta) {
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new ListResourceTemplatesRequest(cursor, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListResourceTemplatesRequest)) {
            return false;
        }
        ListResourceTemplatesRequest listResourceTemplatesRequest = (ListResourceTemplatesRequest) other;
        return kotlin.jvm.internal.p.d(this.cursor, listResourceTemplatesRequest.cursor) && kotlin.jvm.internal.p.d(this._meta, listResourceTemplatesRequest._meta);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.PaginatedRequest
    public String getCursor() {
        return this.cursor;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.PaginatedRequest, io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        String str = this.cursor;
        return ((str == null ? 0 : str.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "ListResourceTemplatesRequest(cursor=" + this.cursor + ", _meta=" + this._meta + ')';
    }

    public ListResourceTemplatesRequest(String str, qb.D _meta) {
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.cursor = str;
        this._meta = _meta;
        this.method = Method.Defined.ResourcesTemplatesList;
    }

    public /* synthetic */ ListResourceTemplatesRequest(String str, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
