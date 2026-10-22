package io.modelcontextprotocol.kotlin.sdk;

import kotlin.Metadata;
import lb.InterfaceC4883a;
import p9.InterfaceC5063a;
import qb.AbstractC5177g;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/RequestPolymorphicSerializer;", "Lqb/g;", "Lio/modelcontextprotocol/kotlin/sdk/Request;", "<init>", "()V", "Lqb/i;", "element", "Llb/a;", "selectDeserializer", "(Lqb/i;)Llb/a;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestPolymorphicSerializer extends AbstractC5177g<Request> {
    public static final RequestPolymorphicSerializer INSTANCE = new RequestPolymorphicSerializer();

    private RequestPolymorphicSerializer() {
        super(kotlin.jvm.internal.t.b(Request.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object selectDeserializer$lambda$2$lambda$1(qb.i iVar) {
        return "No method in " + iVar;
    }

    @Override // qb.AbstractC5177g
    public InterfaceC4883a<Request> selectDeserializer(final qb.i element) {
        qb.F fK;
        String strB;
        kotlin.jvm.internal.p.i(element, "element");
        qb.i iVar = qb.j.j(element).get("method");
        if (iVar == null) {
            iVar = null;
        }
        qb.i iVar2 = iVar;
        if (iVar2 == null || (fK = qb.j.k(iVar2)) == null || (strB = fK.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String()) == null) {
            Types_utilKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.F
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return RequestPolymorphicSerializer.selectDeserializer$lambda$2$lambda$1(element);
                }
            });
            throw new IllegalStateException(("No method in " + element).toString());
        }
        InterfaceC4883a<ClientRequest> interfaceC4883aSelectClientRequestDeserializer = Types_utilKt.selectClientRequestDeserializer(strB);
        if (interfaceC4883aSelectClientRequestDeserializer != null) {
            return interfaceC4883aSelectClientRequestDeserializer;
        }
        InterfaceC4883a<ServerRequest> interfaceC4883aSelectServerRequestDeserializer = Types_utilKt.selectServerRequestDeserializer(strB);
        return interfaceC4883aSelectServerRequestDeserializer == null ? UnknownMethodRequestOrNotification.INSTANCE.serializer() : interfaceC4883aSelectServerRequestDeserializer;
    }
}
