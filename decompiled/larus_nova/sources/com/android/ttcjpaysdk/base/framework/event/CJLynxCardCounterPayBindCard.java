package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJLynxCardCounterPayBindCard;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "bankCardId", "", "assetInfo", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getAssetInfo", "()Lorg/json/JSONObject;", "getBankCardId", "()Ljava/lang/String;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJLynxCardCounterPayBindCard extends BaseEvent {
    private final JSONObject assetInfo;
    private final String bankCardId;

    public final JSONObject getAssetInfo() {
        return this.assetInfo;
    }

    public final String getBankCardId() {
        return this.bankCardId;
    }

    public CJLynxCardCounterPayBindCard(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "bankCardId");
        this.bankCardId = r100;
        this.assetInfo = r101;
    }

    public /* synthetic */ CJLynxCardCounterPayBindCard(String r100, JSONObject r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
