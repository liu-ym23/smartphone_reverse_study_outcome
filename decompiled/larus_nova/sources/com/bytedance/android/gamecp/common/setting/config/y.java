package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/y;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "", "legalDomain", "Ljava/util/List;", "getLegalDomain", "()Ljava/util/List;", "setLegalDomain", "(Ljava/util/List;)V", "blockLaunch", "getBlockLaunch", "setBlockLaunch", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("block_launch")
    private boolean blockLaunch;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("legal_domain")
    private List<String> legalDomain;

    public y() {
        List<String> r100 = CollectionsKt.listOf(new String[]{"https://p3-webcast-game-sign.byteimg.com/", "https://p6-webcast-game-sign.byteimg.com/", "https://p9-webcast-game-sign.byteimg.com/", "https://lf3-cgp.dailygn.com/", "https://lf6-cgp.dailygn.com/", "https://lf9-cgp.dailygn.com/"});
        this.enable = true;
        this.legalDomain = r100;
        this.blockLaunch = false;
    }
}
