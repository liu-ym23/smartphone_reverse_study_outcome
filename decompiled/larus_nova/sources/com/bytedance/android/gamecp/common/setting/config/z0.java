package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/z0;", "", "", "", "pageList", "Ljava/util/List;", "b", "()Ljava/util/List;", "downloadManageUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("download_manage_url")
    private final String downloadManageUrl;

    @SerializedName("page_list")
    private final List<String> pageList;

    public z0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z0) == false) goto L10;
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.pageList, r101.pageList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.downloadManageUrl, r101.downloadManageUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.pageList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.downloadManageUrl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameCPDownloadPausePageConfig(pageList=" + this.pageList + ", downloadManageUrl=" + this.downloadManageUrl + ")";
    }

    public final String a() {
        return this.downloadManageUrl;
    }

    public final List<String> b() {
        return this.pageList;
    }

    public z0(Object r110) {
        this.pageList = CollectionsKt.arrayListOf(new String[]{"promote_detail", "game_ad", "search", com.bytedance.android.ec.core.event.a.KEY_COMMENT_DETAIL, "strategy_detail", "game_benefit_detail", "platform_benefit_detail", "floating_window", "quit_end", "recruit_page"});
        this.downloadManageUrl = "https://apps.bytesfield.com/app/download?from_scene=dygame_pause_dialog";
    }
}
