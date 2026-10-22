package com.bytedance.android.livesdk.config.link;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/link/LinkRequestMonitorConfig;", "", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "threshold", "", "getThreshold", "()I", "setThreshold", "(I)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkRequestMonitorConfig {

    @SerializedName("black_list")
    private ArrayList<String> blackList;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("threshold")
    private int threshold;

    public LinkRequestMonitorConfig() {
        this.blackList = new ArrayList();
        this.threshold = 1;
    }

    public final ArrayList<String> getBlackList() {
        return this.blackList;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getThreshold() {
        return this.threshold;
    }

    public final void setBlackList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.blackList = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setThreshold(int r100) {
        this.threshold = r100;
    }
}
