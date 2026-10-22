package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ame.sdk.SkillStoreKt;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u000f\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CallToolResultBase;", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", "getContent", "()Ljava/util/List;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lqb/D;", "getStructuredContent", "()Lqb/D;", "structuredContent", "", "isError", "()Ljava/lang/Boolean;", "Companion", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "Lio/modelcontextprotocol/kotlin/sdk/CompatibilityCallToolResult;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public interface CallToolResultBase extends ServerResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CallToolResultBase$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResultBase;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<CallToolResultBase> serializer() {
            return new lb.j("io.modelcontextprotocol.kotlin.sdk.CallToolResultBase", kotlin.jvm.internal.t.b(CallToolResultBase.class), new InterfaceC5745d[]{kotlin.jvm.internal.t.b(CallToolResult.class), kotlin.jvm.internal.t.b(CompatibilityCallToolResult.class)}, new KSerializer[]{CallToolResult$$serializer.INSTANCE, CompatibilityCallToolResult$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Boolean isError(CallToolResultBase callToolResultBase) {
            return CallToolResultBase.super.getIsError();
        }
    }

    List<PromptMessageContent> getContent();

    qb.D getStructuredContent();

    /* renamed from: isError */
    default Boolean getIsError() {
        return Boolean.FALSE;
    }
}
