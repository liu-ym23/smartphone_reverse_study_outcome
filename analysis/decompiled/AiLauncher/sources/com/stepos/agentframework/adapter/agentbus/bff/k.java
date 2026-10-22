package com.stepos.agentframework.adapter.agentbus.bff;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/k;", "", "<init>", "()V", "", "faviconEnabled", "Z", Const.INTENT_KEY_APIKEY, "()Z", "setFaviconEnabled", "(Z)V", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class k {
    public static final k INSTANCE = new k();
    private static volatile boolean faviconEnabled = true;

    public final boolean a() {
        return faviconEnabled;
    }
}
