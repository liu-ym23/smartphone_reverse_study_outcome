package e4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.r;
import com.zyql.protobuf.connection.Head;
import com.zyql.protobuf.connection.HeartbeatResp;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Le4/e;", "Le4/f;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bffClient", "<init>", "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lcom/zyql/protobuf/connection/Head;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/l;", "cacheBean", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/protobuf/connection/Head;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/l;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: e4.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3991e implements InterfaceC3992f {
    private final BffClient bffClient;

    public C3991e(BffClient bffClient) {
        p.i(bffClient, "bffClient");
        this.bffClient = bffClient;
    }

    @Override // e4.InterfaceC3992f
    public void a(Head head, ByteString bodyRaw, CacheBean cacheBean) throws InvalidProtocolBufferException {
        p.i(head, "head");
        p.i(bodyRaw, "bodyRaw");
        HeartbeatResp from = HeartbeatResp.parseFrom(bodyRaw);
        this.bffClient.getHeartbeatManager().e(from.getInterval());
        r.a().a("BffClient", "Update heartbeat interval: " + from.getInterval());
    }
}
