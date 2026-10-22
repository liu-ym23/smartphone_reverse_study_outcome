package com.stepos.agentframework.adapter.dify.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/SuggestResult;", "", AppAgent.CONSTRUCT, "()V", SettingsConfig.KEY_DATA, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SuggestResult {

    @SerializedName(SettingsConfig.KEY_DATA)
    private ArrayList<String> data;

    public final ArrayList<String> getData() {
        return this.data;
    }

    public final void setData(ArrayList<String> arrayList) {
        this.data = arrayList;
    }
}
