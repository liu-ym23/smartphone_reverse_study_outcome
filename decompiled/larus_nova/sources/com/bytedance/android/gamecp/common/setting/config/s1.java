package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.android.livesdkapi.util.ILivePreInflateService;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/s1;", "", "", "", "liveHostActivity", "Ljava/util/List;", "getLiveHostActivity", "()Ljava/util/List;", "setLiveHostActivity", "(Ljava/util/List;)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s1 {

    @SerializedName("live_host_activity")
    private List<String> liveHostActivity;

    public s1() {
        this.liveHostActivity = CollectionsKt.arrayListOf(new String[]{ILivePreInflateService.LIVE_PLAY_ACTIVITY, "LivePlayActivityV2", "DetailActivity", "HotSpotDetailActivity"});
    }
}
