package com.stepos.agentframework.adapter.dify.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentframework.adapter.bff.BffConstant;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/LikeBody;", "", AppAgent.CONSTRUCT, "()V", "rating", "", "getRating", "()Ljava/lang/String;", "setRating", "(Ljava/lang/String;)V", BffConstant.Role.User, "getUser", "setUser", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LikeBody {

    @SerializedName("rating")
    private String rating;

    @SerializedName(BffConstant.Role.User)
    private String user;

    public final String getRating() {
        return this.rating;
    }

    public final String getUser() {
        return this.user;
    }

    public final void setRating(String str) {
        this.rating = str;
    }

    public final void setUser(String str) {
        this.user = str;
    }
}
