package io.modelcontextprotocol.kotlin.sdk;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007R\u001c\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PaginatedResult;", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "", "Lio/modelcontextprotocol/kotlin/sdk/Cursor;", "getNextCursor", "()Ljava/lang/String;", "nextCursor", "Companion", "Lio/modelcontextprotocol/kotlin/sdk/ListPromptsResult;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourcesResult;", "Lio/modelcontextprotocol/kotlin/sdk/ListToolsResult;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public interface PaginatedResult extends RequestResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PaginatedResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/PaginatedResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<PaginatedResult> serializer() {
            return new lb.j("io.modelcontextprotocol.kotlin.sdk.PaginatedResult", kotlin.jvm.internal.t.b(PaginatedResult.class), new InterfaceC5745d[]{kotlin.jvm.internal.t.b(ListPromptsResult.class), kotlin.jvm.internal.t.b(ListResourceTemplatesResult.class), kotlin.jvm.internal.t.b(ListResourcesResult.class), kotlin.jvm.internal.t.b(ListToolsResult.class)}, new KSerializer[]{ListPromptsResult$$serializer.INSTANCE, ListResourceTemplatesResult$$serializer.INSTANCE, ListResourcesResult$$serializer.INSTANCE, ListToolsResult$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    String getNextCursor();
}
