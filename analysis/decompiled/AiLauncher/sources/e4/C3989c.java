package e4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.m;
import com.stepos.agentframework.adapter.bff.r;
import com.stepos.agentframework.adapter.netcore.j;
import com.zyql.protobuf.connection.Head;
import com.zyql.protobuf.omni.ChatDelta;
import com.zyql.protobuf.skull.Resource;
import java.util.ArrayList;
import java.util.List;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0011"}, d2 = {"Le4/c;", "Le4/f;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bffClient", "<init>", "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lcom/zyql/protobuf/connection/Head;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/l;", "cacheBean", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/protobuf/connection/Head;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/l;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "Companion", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: e4.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3989c implements InterfaceC3992f {
    private static final String TAG = "ChatCommandHandler";
    private final BffClient bffClient;

    public C3989c(BffClient bffClient) {
        p.i(bffClient, "bffClient");
        this.bffClient = bffClient;
    }

    @Override // e4.InterfaceC3992f
    public void a(Head head, ByteString bodyRaw, CacheBean cacheBean) throws InvalidProtocolBufferException {
        com.stepos.agentframework.adapter.bff.p pVar;
        String agentId;
        p.i(head, "head");
        p.i(bodyRaw, "bodyRaw");
        ChatDelta from = ChatDelta.parseFrom(bodyRaw);
        ArrayList arrayList = new ArrayList();
        String text = from.getMessageDelta().getText();
        if (text != null && text.length() != 0) {
            String text2 = from.getMessageDelta().getText();
            p.h(text2, "getText(...)");
            arrayList.add(new AbstractC0913i.Text(text2));
        }
        List<Resource> resourcesList = from.getMessage().getResourcesList();
        if (resourcesList != null) {
            for (Resource resource : resourcesList) {
                p.f(resource);
                AbstractC0913i abstractC0913iC = m.c(resource);
                if (abstractC0913iC != null) {
                    arrayList.add(abstractC0913iC);
                }
            }
        }
        r.a().a(TAG, "receive_content commad: " + head.getCommand() + ", chatId: " + from.getChatId() + ", body:" + j.b(from));
        if (cacheBean == null || (pVar = cacheBean.a().get()) == null) {
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
        pVar.a(msgId, new C0917m(arrayList, "assistant", from.getChatId(), "text", 0, false, null, 0, null, 0L, 0, 0, false, str, null, null, 1, from.getMessageDelta().getIsEnd(), null, 0, chatRequestInfo2 != null ? Integer.valueOf(chatRequestInfo2.get_id()) : null, 0, null, 0, null, null, null, null, null, from.getMessageDelta().getMessageId(), null, null, null, null, from.getChatId(), null, null, null, null, null, null, null, null, null, null, -680730640, 8169, null));
    }
}
