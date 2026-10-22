package com.stepos.agentframework.adapter.bff.handler;

import B7.a;
import V4.AbstractC0262i;
import V4.C0260g;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.protobuf.ByteString;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.ChatContentExtKt;
import com.stepos.agentframework.adapter.bff.IDataCallback;
import com.stepos.agentframework.adapter.bff.LogUtilKt;
import com.stepos.agentframework.adapter.netcore.ExtKt;
import com.stepos.agentframework.adapter.netcore.ILogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import r7.f;
import t7.C2023f;
import v7.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/handler/ChatCommandHandler;", "Lcom/stepos/agentframework/adapter/bff/handler/IBffCommandHandler;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bffClient", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lr7/f;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", "cacheBean", "LC7/r;", "handle", "(Lr7/f;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/CacheBean;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "Companion", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatCommandHandler implements IBffCommandHandler {
    private static final String TAG = "ChatCommandHandler";
    private final BffClient bffClient;

    public ChatCommandHandler(BffClient bffClient) {
        k.f(bffClient, "bffClient");
        this.bffClient = bffClient;
    }

    @Override // com.stepos.agentframework.adapter.bff.handler.IBffCommandHandler
    public void handle(f head, ByteString bodyRaw, CacheBean cacheBean) {
        IDataCallback iDataCallback;
        String str;
        k.f(head, "head");
        k.f(bodyRaw, "bodyRaw");
        C2023f c2023fX0 = C2023f.x0(bodyRaw);
        ArrayList arrayList = new ArrayList();
        String strV = c2023fX0.m0().V();
        if (strV != null && strV.length() != 0) {
            String strV2 = c2023fX0.m0().V();
            k.e(strV2, "getText(...)");
            arrayList.add(new C0260g(strV2));
        }
        List<l> listW = c2023fX0.l0().W();
        if (listW != null) {
            for (l lVar : listW) {
                k.c(lVar);
                AbstractC0262i chatContent = ChatContentExtKt.toChatContent(lVar);
                if (chatContent != null) {
                    arrayList.add(chatContent);
                }
            }
        }
        ILogger logger = LogUtilKt.getLogger();
        String strT = head.T();
        String strG0 = c2023fX0.g0();
        String json = ExtKt.toJson(c2023fX0);
        StringBuilder sbW = a.w("receive_content commad: ", strT, ", chatId: ", strG0, ", body:");
        sbW.append(json);
        logger.d(TAG, sbW.toString());
        if (cacheBean == null || (iDataCallback = cacheBean.getCallback().get()) == null) {
            return;
        }
        String strB0 = head.b0();
        k.e(strB0, "getMsgId(...)");
        V4.l chatRequestInfo = cacheBean.getChatRequestInfo();
        if (chatRequestInfo == null || (str = chatRequestInfo.f1364a) == null) {
            str = "";
        }
        String str2 = str;
        V4.l chatRequestInfo2 = cacheBean.getChatRequestInfo();
        iDataCallback.onDataReceived(strB0, new V4.k(arrayList, "assistant", c2023fX0.g0(), "text", null, str2, null, 1, c2023fX0.m0().Q(), chatRequestInfo2 != null ? Integer.valueOf(chatRequestInfo2.h) : null, 0, c2023fX0.m0().R(), null, null, -680730640));
    }
}
