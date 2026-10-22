package com.stepos.policy.sdk.bean;

import B7.a;
import androidx.core.app.NotificationCompat;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "", "code", "", SettingsConfig.KEY_DATA, "Lcom/stepos/policy/sdk/bean/PolicyResponse;", NotificationCompat.CATEGORY_MESSAGE, "", "(ILcom/stepos/policy/sdk/bean/PolicyResponse;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/stepos/policy/sdk/bean/PolicyResponse;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PolicyNewestResponse {
    private final int code;
    private final PolicyResponse data;
    private final String msg;

    public PolicyNewestResponse(int i, PolicyResponse data, String msg) {
        k.f(data, "data");
        k.f(msg, "msg");
        this.code = i;
        this.data = data;
        this.msg = msg;
    }

    public static /* synthetic */ PolicyNewestResponse copy$default(PolicyNewestResponse policyNewestResponse, int i, PolicyResponse policyResponse, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = policyNewestResponse.code;
        }
        if ((i6 & 2) != 0) {
            policyResponse = policyNewestResponse.data;
        }
        if ((i6 & 4) != 0) {
            str = policyNewestResponse.msg;
        }
        return policyNewestResponse.copy(i, policyResponse, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final PolicyResponse getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final PolicyNewestResponse copy(int code, PolicyResponse data, String msg) {
        k.f(data, "data");
        k.f(msg, "msg");
        return new PolicyNewestResponse(code, data, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyNewestResponse)) {
            return false;
        }
        PolicyNewestResponse policyNewestResponse = (PolicyNewestResponse) other;
        return this.code == policyNewestResponse.code && k.b(this.data, policyNewestResponse.data) && k.b(this.msg, policyNewestResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final PolicyResponse getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + ((this.data.hashCode() + (Integer.hashCode(this.code) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyNewestResponse(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", msg=");
        return a.g(')', this.msg, sb);
    }
}
