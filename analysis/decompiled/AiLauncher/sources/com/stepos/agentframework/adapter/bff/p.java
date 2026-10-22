package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import com.zyql.protobuf.connection.StreamMsg;
import kotlin.C0917m;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/p;", "", "", "sendId", "LK6/m;", "chatReplyInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LK6/m;)V", "", "code", "reason", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "Lcom/zyql/protobuf/connection/StreamMsg;", "data", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/zyql/protobuf/connection/StreamMsg;)Z", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface p {
    void a(String sendId, C0917m chatReplyInfo);

    default boolean b(String sendId, StreamMsg data) {
        kotlin.jvm.internal.p.i(sendId, "sendId");
        return false;
    }

    void onError(String sendId, int code, String reason);
}
