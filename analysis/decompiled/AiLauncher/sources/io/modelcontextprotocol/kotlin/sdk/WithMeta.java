package io.modelcontextprotocol.kotlin.sdk;

import io.modelcontextprotocol.kotlin.sdk.LoggingMessageNotification;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u001a\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0011\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "Lqb/D;", "get_meta", "()Lqb/D;", "get_meta$annotations", "()V", "_meta", "Companion", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "Lio/modelcontextprotocol/kotlin/sdk/CancelledNotification;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "Lio/modelcontextprotocol/kotlin/sdk/CustomMeta;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListRootsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification$SetLevelRequest;", "Lio/modelcontextprotocol/kotlin/sdk/PaginatedRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;", "Lio/modelcontextprotocol/kotlin/sdk/SubscribeRequest;", "Lio/modelcontextprotocol/kotlin/sdk/UnsubscribeRequest;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public interface WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/WithMeta$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "serializer", "()Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CustomMeta;", "Empty", "Lio/modelcontextprotocol/kotlin/sdk/CustomMeta;", "getEmpty", "()Lio/modelcontextprotocol/kotlin/sdk/CustomMeta;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final CustomMeta Empty = new CustomMeta((qb.D) null, 1, (kotlin.jvm.internal.i) (0 == true ? 1 : 0));

        private Companion() {
        }

        public final CustomMeta getEmpty() {
            return Empty;
        }

        public final KSerializer<WithMeta> serializer() {
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(WithMeta.class);
            InterfaceC5745d[] interfaceC5745dArr = {kotlin.jvm.internal.t.b(CallToolRequest.class), kotlin.jvm.internal.t.b(CancelledNotification.class), kotlin.jvm.internal.t.b(CompleteRequest.class), kotlin.jvm.internal.t.b(CreateElicitationRequest.class), kotlin.jvm.internal.t.b(CreateMessageRequest.class), kotlin.jvm.internal.t.b(CustomMeta.class), kotlin.jvm.internal.t.b(GetPromptRequest.class), kotlin.jvm.internal.t.b(InitializeRequest.class), kotlin.jvm.internal.t.b(ListRootsRequest.class), kotlin.jvm.internal.t.b(LoggingMessageNotification.class), kotlin.jvm.internal.t.b(LoggingMessageNotification.SetLevelRequest.class), kotlin.jvm.internal.t.b(ListPromptsRequest.class), kotlin.jvm.internal.t.b(ListResourceTemplatesRequest.class), kotlin.jvm.internal.t.b(ListResourcesRequest.class), kotlin.jvm.internal.t.b(ListToolsRequest.class), kotlin.jvm.internal.t.b(ReadResourceRequest.class), kotlin.jvm.internal.t.b(CreateElicitationResult.class), kotlin.jvm.internal.t.b(CreateMessageResult.class), kotlin.jvm.internal.t.b(EmptyRequestResult.class), kotlin.jvm.internal.t.b(ListRootsResult.class), kotlin.jvm.internal.t.b(ListPromptsResult.class), kotlin.jvm.internal.t.b(ListResourceTemplatesResult.class), kotlin.jvm.internal.t.b(ListResourcesResult.class), kotlin.jvm.internal.t.b(ListToolsResult.class), kotlin.jvm.internal.t.b(CallToolResult.class), kotlin.jvm.internal.t.b(CompatibilityCallToolResult.class), kotlin.jvm.internal.t.b(CompleteResult.class), kotlin.jvm.internal.t.b(EmptyRequestResult.class), kotlin.jvm.internal.t.b(GetPromptResult.class), kotlin.jvm.internal.t.b(InitializeResult.class), kotlin.jvm.internal.t.b(ListPromptsResult.class), kotlin.jvm.internal.t.b(ListResourceTemplatesResult.class), kotlin.jvm.internal.t.b(ListResourcesResult.class), kotlin.jvm.internal.t.b(ListToolsResult.class), kotlin.jvm.internal.t.b(ReadResourceResult.class), kotlin.jvm.internal.t.b(ResourceUpdatedNotification.class), kotlin.jvm.internal.t.b(SubscribeRequest.class), kotlin.jvm.internal.t.b(UnsubscribeRequest.class)};
            EmptyRequestResult$$serializer emptyRequestResult$$serializer = EmptyRequestResult$$serializer.INSTANCE;
            ListPromptsResult$$serializer listPromptsResult$$serializer = ListPromptsResult$$serializer.INSTANCE;
            ListResourceTemplatesResult$$serializer listResourceTemplatesResult$$serializer = ListResourceTemplatesResult$$serializer.INSTANCE;
            ListResourcesResult$$serializer listResourcesResult$$serializer = ListResourcesResult$$serializer.INSTANCE;
            ListToolsResult$$serializer listToolsResult$$serializer = ListToolsResult$$serializer.INSTANCE;
            return new lb.j("io.modelcontextprotocol.kotlin.sdk.WithMeta", interfaceC5745dB, interfaceC5745dArr, new KSerializer[]{CallToolRequest$$serializer.INSTANCE, CancelledNotification$$serializer.INSTANCE, CompleteRequest$$serializer.INSTANCE, CreateElicitationRequest$$serializer.INSTANCE, CreateMessageRequest$$serializer.INSTANCE, CustomMeta$$serializer.INSTANCE, GetPromptRequest$$serializer.INSTANCE, InitializeRequest$$serializer.INSTANCE, ListRootsRequest$$serializer.INSTANCE, LoggingMessageNotification$$serializer.INSTANCE, LoggingMessageNotification$SetLevelRequest$$serializer.INSTANCE, ListPromptsRequest$$serializer.INSTANCE, ListResourceTemplatesRequest$$serializer.INSTANCE, ListResourcesRequest$$serializer.INSTANCE, ListToolsRequest$$serializer.INSTANCE, ReadResourceRequest$$serializer.INSTANCE, CreateElicitationResult$$serializer.INSTANCE, CreateMessageResult$$serializer.INSTANCE, emptyRequestResult$$serializer, ListRootsResult$$serializer.INSTANCE, listPromptsResult$$serializer, listResourceTemplatesResult$$serializer, listResourcesResult$$serializer, listToolsResult$$serializer, CallToolResult$$serializer.INSTANCE, CompatibilityCallToolResult$$serializer.INSTANCE, CompleteResult$$serializer.INSTANCE, emptyRequestResult$$serializer, GetPromptResult$$serializer.INSTANCE, InitializeResult$$serializer.INSTANCE, listPromptsResult$$serializer, listResourceTemplatesResult$$serializer, listResourcesResult$$serializer, listToolsResult$$serializer, ReadResourceResult$$serializer.INSTANCE, ResourceUpdatedNotification$$serializer.INSTANCE, SubscribeRequest$$serializer.INSTANCE, UnsubscribeRequest$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void get_meta$annotations() {
        }
    }

    qb.D get_meta();
}
