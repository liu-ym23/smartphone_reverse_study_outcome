package e4;

import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import com.google.protobuf.ByteString;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.r;
import com.stepos.aiengine.args.SingleFileBundle;
import com.zyql.protobuf.connection.Head;
import java.lang.ref.WeakReference;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Le4/a;", "Le4/f;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bffClient", "<init>", "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lcom/zyql/protobuf/connection/Head;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/l;", "cacheBean", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/protobuf/connection/Head;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/l;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: e4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3987a implements InterfaceC3992f {
    private final BffClient bffClient;

    public C3987a(BffClient bffClient) {
        p.i(bffClient, "bffClient");
        this.bffClient = bffClient;
    }

    @Override // e4.InterfaceC3992f
    public void a(Head head, ByteString bodyRaw, CacheBean cacheBean) {
        WeakReference<com.stepos.agentframework.adapter.bff.p> weakReferenceA;
        com.stepos.agentframework.adapter.bff.p pVar;
        String agentId;
        p.i(head, "head");
        p.i(bodyRaw, "bodyRaw");
        r.a().a(BffClient.TAG, "receive_AgentCall");
        AbstractC0913i.Bytes bytes = new AbstractC0913i.Bytes(bodyRaw.toByteArray());
        if (cacheBean == null || (weakReferenceA = cacheBean.a()) == null || (pVar = weakReferenceA.get()) == null) {
            return;
        }
        String msgId = head.getMsgId();
        p.h(msgId, "getMsgId(...)");
        C0918n chatRequestInfo = cacheBean.getChatRequestInfo();
        if (chatRequestInfo == null || (agentId = chatRequestInfo.getAgentId()) == null) {
            agentId = "";
        }
        String str = agentId;
        C0918n chatRequestInfo2 = cacheBean.getChatRequestInfo();
        Integer numValueOf = chatRequestInfo2 != null ? Integer.valueOf(chatRequestInfo2.get_id()) : null;
        C0918n chatRequestInfo3 = cacheBean.getChatRequestInfo();
        String conversationId = chatRequestInfo3 != null ? chatRequestInfo3.getConversationId() : null;
        C0918n chatRequestInfo4 = cacheBean.getChatRequestInfo();
        pVar.a(msgId, new C0917m(C1172u.e(bytes), "assistant", conversationId, SingleFileBundle.KEY_BYTES, 0, false, null, 0, null, 0L, 0, 0, false, str, null, null, 1, true, null, 0, numValueOf, 0, null, 0, null, null, null, null, null, head.getMsgId(), null, null, null, null, chatRequestInfo4 != null ? chatRequestInfo4.getChatId() : null, null, null, null, null, null, null, null, null, null, null, -680730640, 8169, null));
    }
}
