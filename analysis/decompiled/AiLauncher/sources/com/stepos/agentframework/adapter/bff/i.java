package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import com.google.protobuf.ByteString;
import com.zyql.protobuf.connection.Head;
import e4.C3987a;
import e4.C3988b;
import e4.C3989c;
import e4.C3990d;
import e4.C3991e;
import e4.C3993g;
import e4.InterfaceC3992f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/i;", "", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "client", "<init>", "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lcom/zyql/protobuf/connection/Head;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/l;", "cacheBean", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/protobuf/connection/Head;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/l;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "", "", "Le4/f;", "handlers", "Ljava/util/Map;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {
    private final BffClient client;
    private final Map<String, InterfaceC3992f> handlers;

    public i(BffClient client) {
        kotlin.jvm.internal.p.i(client, "client");
        this.client = client;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.handlers = linkedHashMap;
        linkedHashMap.put("Auth", new C3988b(client));
        linkedHashMap.put("Heartbeat", new C3991e(client));
        linkedHashMap.put("CallTool", new C3993g(client));
        linkedHashMap.put("ChatCompletionStream", new C3987a(client));
        C3989c c3989c = new C3989c(client);
        linkedHashMap.put("Chat", c3989c);
        linkedHashMap.put("ImageLayout", c3989c);
        linkedHashMap.put("VideoHighlight", c3989c);
        linkedHashMap.put("VideoEdit", c3989c);
        linkedHashMap.put("VideoVoiceEdit", c3989c);
        C3990d c3990d = new C3990d();
        linkedHashMap.put("VideoNewEdit", c3990d);
        linkedHashMap.put("NewChat", c3990d);
    }

    public final void a(Head head, ByteString bodyRaw, CacheBean cacheBean) {
        kotlin.jvm.internal.p.i(head, "head");
        kotlin.jvm.internal.p.i(bodyRaw, "bodyRaw");
        r.a().a(BffClient.TAG, "dispatch Command: " + head.getCommand());
        InterfaceC3992f interfaceC3992f = this.handlers.get(head.getCommand());
        if (interfaceC3992f != null) {
            interfaceC3992f.a(head, bodyRaw, cacheBean);
            return;
        }
        r.a().b("BffClient", "UnSupport Command: " + head.getCommand());
    }
}
