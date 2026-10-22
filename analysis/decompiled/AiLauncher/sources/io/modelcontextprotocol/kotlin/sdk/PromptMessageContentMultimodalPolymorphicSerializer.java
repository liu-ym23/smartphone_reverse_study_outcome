package io.modelcontextprotocol.kotlin.sdk;

import kotlin.Metadata;
import lb.InterfaceC4883a;
import qb.AbstractC5177g;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodalPolymorphicSerializer;", "Lqb/g;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "<init>", "()V", "Lqb/i;", "element", "Llb/a;", "selectDeserializer", "(Lqb/i;)Llb/a;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromptMessageContentMultimodalPolymorphicSerializer extends AbstractC5177g<PromptMessageContentMultimodal> {
    public static final PromptMessageContentMultimodalPolymorphicSerializer INSTANCE = new PromptMessageContentMultimodalPolymorphicSerializer();

    private PromptMessageContentMultimodalPolymorphicSerializer() {
        super(kotlin.jvm.internal.t.b(PromptMessageContentMultimodal.class));
    }

    @Override // qb.AbstractC5177g
    public InterfaceC4883a<PromptMessageContentMultimodal> selectDeserializer(qb.i element) {
        kotlin.jvm.internal.p.i(element, "element");
        String content = qb.j.k((qb.i) kotlin.collections.a.j(qb.j.j(element), "type")).getContent();
        int iHashCode = content.hashCode();
        if (iHashCode != 3556653) {
            if (iHashCode != 93166550) {
                if (iHashCode == 100313435 && content.equals("image")) {
                    return ImageContent.INSTANCE.serializer();
                }
            } else if (content.equals("audio")) {
                return AudioContent.INSTANCE.serializer();
            }
        } else if (content.equals("text")) {
            return TextContent.INSTANCE.serializer();
        }
        return UnknownContent.INSTANCE.serializer();
    }
}
