package io.modelcontextprotocol.kotlin.sdk;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fR\u001c\u0010\u0007\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PaginatedRequest;", "Lio/modelcontextprotocol/kotlin/sdk/Request;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "Lio/modelcontextprotocol/kotlin/sdk/Cursor;", "getCursor", "()Ljava/lang/String;", "cursor", "Lqb/D;", "get_meta", "()Lqb/D;", "_meta", "Companion", "Lio/modelcontextprotocol/kotlin/sdk/ListPromptsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourcesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListToolsRequest;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public interface PaginatedRequest extends Request, WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PaginatedRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/PaginatedRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<PaginatedRequest> serializer() {
            return new lb.j("io.modelcontextprotocol.kotlin.sdk.PaginatedRequest", kotlin.jvm.internal.t.b(PaginatedRequest.class), new InterfaceC5745d[]{kotlin.jvm.internal.t.b(ListPromptsRequest.class), kotlin.jvm.internal.t.b(ListResourceTemplatesRequest.class), kotlin.jvm.internal.t.b(ListResourcesRequest.class), kotlin.jvm.internal.t.b(ListToolsRequest.class)}, new KSerializer[]{ListPromptsRequest$$serializer.INSTANCE, ListResourceTemplatesRequest$$serializer.INSTANCE, ListResourcesRequest$$serializer.INSTANCE, ListToolsRequest$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    String getCursor();

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    qb.D get_meta();
}
