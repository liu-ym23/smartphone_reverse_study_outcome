package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/lb1;", "", "", "totalEnable", "Z", "viewPostOpt", "", "", "previewRvDisableList", "Ljava/util/List;", "previewRvLeakFix", "previewRvDisableClassicsTeamFight", "", "seatDrawProtectTime", "J", "nitaSaveMapOpt", "innerDrawWRDSPreload", "logOpt", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class lb1 {

    @SerializedName("inner_draw_wrds_preload")
    private boolean innerDrawWRDSPreload;

    @SerializedName("log_opt")
    private boolean logOpt;

    @SerializedName("nita_save_map_opt")
    private boolean nitaSaveMapOpt;

    @SerializedName("preview_rv_disable_classics_team_fight")
    private boolean previewRvDisableClassicsTeamFight;

    @SerializedName("preview_rv_disable_list")
    private List<String> previewRvDisableList;

    @SerializedName("preview_rv_leak_fix")
    private boolean previewRvLeakFix;

    @SerializedName("show_content_when_seat_draw_protect")
    private long seatDrawProtectTime;

    @SerializedName("total_enable")
    private boolean totalEnable;

    @SerializedName("view_post_opt")
    private boolean viewPostOpt;

    public final boolean b() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.innerDrawWRDSPreload == false) goto L7;
        return true;
    }

    public final boolean c() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.viewPostOpt == false) goto L7;
        return true;
    }

    public lb1() {
        this.previewRvDisableList = CollectionsKt.listOf("24");
        this.previewRvDisableClassicsTeamFight = true;
    }

    public final long a() {
        return this.seatDrawProtectTime;
    }

    public final boolean d() {
        return this.logOpt;
    }
}
