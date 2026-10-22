package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/r;", "", "<init>", "()V", "", "inquiryId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "outboundId", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "PREFIX", "Ljava/lang/String;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class r {
    public static final r INSTANCE = new r();
    private static final String PREFIX = "taskv2-inquiry-answer:";

    public final String a(String inquiryId) {
        kotlin.jvm.internal.p.i(inquiryId, "inquiryId");
        return PREFIX + inquiryId;
    }

    public final boolean b(String outboundId) {
        return (outboundId == null || outboundId.length() == 0 || !La.D.X(outboundId, PREFIX, false, 2, null)) ? false : true;
    }
}
