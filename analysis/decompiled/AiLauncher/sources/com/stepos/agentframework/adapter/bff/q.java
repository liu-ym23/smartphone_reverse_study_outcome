package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/q;", "Lcom/stepos/agentframework/adapter/bff/o;", "", "data", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", Const.INTENT_KEY_PKGNAME, "(Ljava/nio/ByteBuffer;)V", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface q extends o {
    void b(ByteBuffer data);

    void d(String data);
}
