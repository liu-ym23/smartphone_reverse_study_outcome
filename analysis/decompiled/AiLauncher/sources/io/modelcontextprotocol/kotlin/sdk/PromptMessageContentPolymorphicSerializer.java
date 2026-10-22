package io.modelcontextprotocol.kotlin.sdk;

import kotlin.Metadata;
import lb.InterfaceC4883a;
import qb.AbstractC5177g;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentPolymorphicSerializer;", "Lqb/g;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContent;", "<init>", "()V", "Lqb/i;", "element", "Llb/a;", "selectDeserializer", "(Lqb/i;)Llb/a;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromptMessageContentPolymorphicSerializer extends AbstractC5177g<PromptMessageContent> {
    public static final PromptMessageContentPolymorphicSerializer INSTANCE = new PromptMessageContentPolymorphicSerializer();

    private PromptMessageContentPolymorphicSerializer() {
        super(kotlin.jvm.internal.t.b(PromptMessageContent.class));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    @Override // qb.AbstractC5177g
    public InterfaceC4883a<PromptMessageContent> selectDeserializer(qb.i element) {
        kotlin.jvm.internal.p.i(element, "element");
        String content = qb.j.k((qb.i) kotlin.collections.a.j(qb.j.j(element), "type")).getContent();
        switch (content.hashCode()) {
            case -341064690:
                if (content.equals("resource")) {
                    return EmbeddedResource.INSTANCE.serializer();
                }
                break;
            case 3556653:
                if (content.equals("text")) {
                    return TextContent.INSTANCE.serializer();
                }
                break;
            case 93166550:
                if (content.equals("audio")) {
                    return AudioContent.INSTANCE.serializer();
                }
                break;
            case 100313435:
                if (content.equals("image")) {
                    return ImageContent.INSTANCE.serializer();
                }
                break;
        }
        return UnknownContent.INSTANCE.serializer();
    }
}
