package io.modelcontextprotocol.kotlin.sdk;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", "Companion", "Lio/modelcontextprotocol/kotlin/sdk/AudioContent;", "Lio/modelcontextprotocol/kotlin/sdk/ImageContent;", "Lio/modelcontextprotocol/kotlin/sdk/TextContent;", "Lio/modelcontextprotocol/kotlin/sdk/UnknownContent;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l(with = PromptMessageContentMultimodalPolymorphicSerializer.class)
/* loaded from: classes4.dex */
public interface PromptMessageContentMultimodal extends PromptMessageContent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<PromptMessageContentMultimodal> serializer() {
            return PromptMessageContentMultimodalPolymorphicSerializer.INSTANCE;
        }
    }
}
