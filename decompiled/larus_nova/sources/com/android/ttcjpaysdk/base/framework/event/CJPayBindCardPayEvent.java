package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayBindCardPayEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "code", "", "params", "Lorg/json/JSONObject;", "memberBizOrderNo", "isRisk", "", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "()Z", "getMemberBizOrderNo", "getParams", "()Lorg/json/JSONObject;", "setParams", "(Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardPayEvent extends BaseEvent {
    private final String code;
    private final boolean isRisk;
    private final String memberBizOrderNo;
    private JSONObject params;

    public final String getCode() {
        return this.code;
    }

    public final String getMemberBizOrderNo() {
        return this.memberBizOrderNo;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final boolean isRisk() {
        return this.isRisk;
    }

    public final void setParams(JSONObject r100) {
        this.params = r100;
    }

    public CJPayBindCardPayEvent(String r100, JSONObject r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "code");
        this.code = r100;
        this.params = r101;
        this.memberBizOrderNo = r102;
        this.isRisk = r103;
    }

    public /* synthetic */ CJPayBindCardPayEvent(String r100, JSONObject r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        this(r100, r101, r102, r103);
    }
}
