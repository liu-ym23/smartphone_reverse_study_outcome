package com.bytedance.android.livesdkapi.minigame;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003JI\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/CurrentRankListResponse;", "Ljava/io/Serializable;", "ranks", "", "Lcom/bytedance/android/livesdkapi/minigame/RankItem;", "musicWave", "", "total", "", "currency", "rulesUrl", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getMusicWave", "setMusicWave", "getRanks", "()Ljava/util/List;", "setRanks", "(Ljava/util/List;)V", "getRulesUrl", "setRulesUrl", "getTotal", "()J", "setTotal", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CurrentRankListResponse implements Serializable {

    @SerializedName("currency")
    private String currency;

    @SerializedName("music_wave")
    private String musicWave;

    @SerializedName("ranks")
    private List<RankItem> ranks;

    @SerializedName("rules_url")
    private String rulesUrl;

    @SerializedName("total")
    private long total;

    public CurrentRankListResponse() {
        this(null, null, 0, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CurrentRankListResponse copy$default(CurrentRankListResponse r100, List r101, String r102, long r103, String r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.ranks;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.musicWave;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.total;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.currency;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.rulesUrl;
    L17:
        List r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final List<RankItem> component1() {
        return this.ranks;
    }

    public final String component2() {
        return this.musicWave;
    }

    public final long component3() {
        return this.total;
    }

    public final String component4() {
        return this.currency;
    }

    public final String component5() {
        return this.rulesUrl;
    }

    public final CurrentRankListResponse copy(List<RankItem> r100, String r110, long r111, String r112, String r113) {
        return new CurrentRankListResponse(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CurrentRankListResponse) == false) goto L16;
        CurrentRankListResponse r101 = (CurrentRankListResponse) r100;
        if (Intrinsics.areEqual(this.ranks, r101.ranks) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.musicWave, r101.musicWave) == true) goto L10;
        return false;
    L10:
        if (this.total == r101.total) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currency, r101.currency) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rulesUrl, r101.rulesUrl) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<RankItem> r100 = this.ranks;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.musicWave;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.total;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.currency;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.rulesUrl;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CurrentRankListResponse(ranks=" + this.ranks + ", musicWave=" + this.musicWave + ", total=" + this.total + ", currency=" + this.currency + ", rulesUrl=" + this.rulesUrl + ")";
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getMusicWave() {
        return this.musicWave;
    }

    public final List<RankItem> getRanks() {
        return this.ranks;
    }

    public final String getRulesUrl() {
        return this.rulesUrl;
    }

    public final long getTotal() {
        return this.total;
    }

    public final void setCurrency(String r100) {
        this.currency = r100;
    }

    public final void setMusicWave(String r100) {
        this.musicWave = r100;
    }

    public final void setRanks(List<RankItem> r100) {
        this.ranks = r100;
    }

    public final void setRulesUrl(String r100) {
        this.rulesUrl = r100;
    }

    public final void setTotal(long r100) {
        this.total = r100;
    }

    public CurrentRankListResponse(List<RankItem> r100, String r101, long r102, String r103, String r104) {
        this.ranks = r100;
        this.musicWave = r101;
        this.total = r102;
        this.currency = r103;
        this.rulesUrl = r104;
    }

    public /* synthetic */ CurrentRankListResponse(List r100, String r101, long r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        List r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r104 = r102;
        if ((r112 & 8) == 0) goto L16;
        String r105 = null;
    L18:
        if ((r112 & 16) == 0) goto L20;
        String r115 = null;
    L21:
        this(r114, r103, r104, r105, r115);
        return;
    L20:
        r115 = r111;
        goto L21
    L16:
        r105 = r110;
        goto L18
    L9:
        r103 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
