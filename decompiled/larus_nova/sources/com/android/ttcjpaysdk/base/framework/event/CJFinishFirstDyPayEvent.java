package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJFinishFirstDyPayEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "code", "", "callBackInfo", "", "", "configId", "", "(ILjava/util/Map;J)V", "getCallBackInfo", "()Ljava/util/Map;", "getCode", "()I", "getConfigId", "()J", "isGiveUpPayAgain", "", "isPaySuccess", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJFinishFirstDyPayEvent extends BaseEvent {
    private final Map<String, String> callBackInfo;
    private final int code;
    private final long configId;

    public final boolean isGiveUpPayAgain() {
        if (this.code != 113) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPaySuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Map<String, String> getCallBackInfo() {
        return this.callBackInfo;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getConfigId() {
        return this.configId;
    }

    public CJFinishFirstDyPayEvent(int r100, Map<String, String> r101, long r102) {
        this.code = r100;
        this.callBackInfo = r101;
        this.configId = r102;
    }
}
