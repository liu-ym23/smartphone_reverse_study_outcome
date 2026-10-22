package com.stepos.policy.sdk.bean;

import B7.a;
import androidx.core.app.NotificationCompat;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "", "code", "", SettingsConfig.KEY_DATA, "", NotificationCompat.CATEGORY_MESSAGE, "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PolicyOperateRecordResponse {
    private final int code;
    private final String data;
    private final String msg;

    public PolicyOperateRecordResponse(int i, String data, String msg) {
        k.f(data, "data");
        k.f(msg, "msg");
        this.code = i;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyOperateRecordResponse copy$default(PolicyOperateRecordResponse policyOperateRecordResponse, int i, String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = policyOperateRecordResponse.code;
        }
        if ((i6 & 2) != 0) {
            str = policyOperateRecordResponse.data;
        }
        if ((i6 & 4) != 0) {
            str2 = policyOperateRecordResponse.msg;
        }
        return policyOperateRecordResponse.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final PolicyOperateRecordResponse copy(int code, String data, String msg) {
        k.f(data, "data");
        k.f(msg, "msg");
        return new PolicyOperateRecordResponse(code, data, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyOperateRecordResponse)) {
            return false;
        }
        PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) other;
        return this.code == policyOperateRecordResponse.code && k.b(this.data, policyOperateRecordResponse.data) && k.b(this.msg, policyOperateRecordResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + a.c(Integer.hashCode(this.code) * 31, 31, this.data);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyOperateRecordResponse(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", msg=");
        return a.g(')', this.msg, sb);
    }
}
