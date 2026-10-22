package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/LeagueInfo;", "", "()V", "cnnName", "", "getCnnName", "()Ljava/lang/String;", "setCnnName", "(Ljava/lang/String;)V", "ennName", "getEnnName", "setEnnName", "leagueId", "", "getLeagueId", "()J", "setLeagueId", "(J)V", "season", "getSeason", "setSeason", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LeagueInfo implements h {

    @SerializedName("cnn_name")
    protected String cnnName;

    @SerializedName("enn_name")
    protected String ennName;

    @SerializedName("league_id")
    protected long leagueId;

    @SerializedName("season")
    protected String season;

    public LeagueInfo() {
        this.cnnName = "";
        this.ennName = "";
        this.season = "";
    }

    public final String getCnnName() {
        return this.cnnName;
    }

    public final String getEnnName() {
        return this.ennName;
    }

    public final long getLeagueId() {
        return this.leagueId;
    }

    public final String getSeason() {
        return this.season;
    }

    public LeagueInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.leagueId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.cnnName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.ennName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.season = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.cnnName != null) goto L22;
        this.cnnName = "";
    L22:
        if (this.ennName != null) goto L25;
        this.ennName = "";
    L25:
        if (this.season != null) goto L43;
        this.season = "";
        return;
    }

    public final void setCnnName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cnnName = r100;
    }

    public final void setEnnName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ennName = r100;
    }

    public final void setLeagueId(long r100) {
        this.leagueId = r100;
    }

    public final void setSeason(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.season = r100;
    }
}
