package com.stepos.policy.sdk.bean;

import androidx.appfunctions.metadata.a;
import androidx.core.app.NotificationCompat;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyServiceConfigResponse;", "", "code", "", SettingsConfig.KEY_DATA, "", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", NotificationCompat.CATEGORY_MESSAGE, "", "(ILjava/util/List;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PolicyServiceConfigResponse {
    private final int code;
    private final List<PolicyServiceConfigBean> data;
    private final String msg;

    public PolicyServiceConfigResponse(int i, List<PolicyServiceConfigBean> data, String msg) {
        k.f(data, "data");
        k.f(msg, "msg");
        this.code = i;
        this.data = data;
        this.msg = msg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolicyServiceConfigResponse copy$default(PolicyServiceConfigResponse policyServiceConfigResponse, int i, List list, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = policyServiceConfigResponse.code;
        }
        if ((i6 & 2) != 0) {
            list = policyServiceConfigResponse.data;
        }
        if ((i6 & 4) != 0) {
            str = policyServiceConfigResponse.msg;
        }
        return policyServiceConfigResponse.copy(i, list, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final List<PolicyServiceConfigBean> component2() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final PolicyServiceConfigResponse copy(int code, List<PolicyServiceConfigBean> data, String msg) {
        k.f(data, "data");
        k.f(msg, "msg");
        return new PolicyServiceConfigResponse(code, data, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyServiceConfigResponse)) {
            return false;
        }
        PolicyServiceConfigResponse policyServiceConfigResponse = (PolicyServiceConfigResponse) other;
        return this.code == policyServiceConfigResponse.code && k.b(this.data, policyServiceConfigResponse.data) && k.b(this.msg, policyServiceConfigResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<PolicyServiceConfigBean> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return this.msg.hashCode() + a.e(this.data, Integer.hashCode(this.code) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyServiceConfigResponse(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", msg=");
        return B7.a.g(')', this.msg, sb);
    }
}
