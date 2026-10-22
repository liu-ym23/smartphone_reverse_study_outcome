package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/MarketBizException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "I", Const.INTENT_KEY_APIKEY, "()I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MarketBizException extends Exception {
    private final int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketBizException(int i10, String message) {
        super(message);
        kotlin.jvm.internal.p.i(message, "message");
        this.code = i10;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }
}
