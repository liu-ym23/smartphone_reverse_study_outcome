package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvSearchHotKeywordsEntity;", "", "keyword", "", "packageName", ServerElements.SORT, "", ServerElements.ADS_IMPRESSION, ServerElements.ADS_CLICK, ServerElements.ADS_DOWNLOAD_REPORT, ServerElements.SSTJ, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClick", "()Ljava/lang/String;", "getDownload_report", "getImpression", "getKeyword", "getPackageName", "getSort", "()I", "getSstj", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvSearchHotKeywordsEntity {

    @NotNull
    private final String click;

    @NotNull
    private final String download_report;

    @NotNull
    private final String impression;

    @NotNull
    private final String keyword;

    @SerializedName("package")
    @NotNull
    private final String packageName;
    private final int sort;

    @NotNull
    private final String sstj;

    public TvSearchHotKeywordsEntity(@NotNull String r10, @NotNull String r11, int r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16) {
        q.g(r10, "keyword");
        q.g(r11, "packageName");
        q.g(r13, ServerElements.ADS_IMPRESSION);
        q.g(r14, ServerElements.ADS_CLICK);
        q.g(r15, ServerElements.ADS_DOWNLOAD_REPORT);
        q.g(r16, ServerElements.SSTJ);
        this.keyword = r10;
        this.packageName = r11;
        this.sort = r12;
        this.impression = r13;
        this.click = r14;
        this.download_report = r15;
        this.sstj = r16;
    }

    public static /* synthetic */ TvSearchHotKeywordsEntity copy$default(TvSearchHotKeywordsEntity r10, String r11, String r12, int r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.keyword;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.packageName;
    L8:
        String r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.sort;
    L11:
        int r20 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.impression;
    L14:
        String r21 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.click;
    L17:
        String r22 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.download_report;
    L20:
        String r23 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.sstj;
    L23:
        String r24 = r11;
        return r10.copy(r24, r110, r20, r21, r22, r23, r17);
    }

    @NotNull
    public final String component1() {
        return this.keyword;
    }

    @NotNull
    public final String component2() {
        return this.packageName;
    }

    public final int component3() {
        return this.sort;
    }

    @NotNull
    public final String component4() {
        return this.impression;
    }

    @NotNull
    public final String component5() {
        return this.click;
    }

    @NotNull
    public final String component6() {
        return this.download_report;
    }

    @NotNull
    public final String component7() {
        return this.sstj;
    }

    @NotNull
    public final TvSearchHotKeywordsEntity copy(@NotNull String r10, @NotNull String r11, int r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16) {
        q.g(r10, "keyword");
        q.g(r11, "packageName");
        q.g(r13, ServerElements.ADS_IMPRESSION);
        q.g(r14, ServerElements.ADS_CLICK);
        q.g(r15, ServerElements.ADS_DOWNLOAD_REPORT);
        q.g(r16, ServerElements.SSTJ);
        return new TvSearchHotKeywordsEntity(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvSearchHotKeywordsEntity) == true) goto L8;
        return false;
    L8:
        TvSearchHotKeywordsEntity r11 = (TvSearchHotKeywordsEntity) r10;
        if (q.b(this.keyword, r11.keyword) == true) goto L12;
        return false;
    L12:
        if (q.b(this.packageName, r11.packageName) == true) goto L15;
        return false;
    L15:
        if (this.sort == r11.sort) goto L18;
        return false;
    L18:
        if (q.b(this.impression, r11.impression) == true) goto L21;
        return false;
    L21:
        if (q.b(this.click, r11.click) == true) goto L24;
        return false;
    L24:
        if (q.b(this.download_report, r11.download_report) == true) goto L27;
        return false;
    L27:
        if (q.b(this.sstj, r11.sstj) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @NotNull
    public final String getClick() {
        return this.click;
    }

    @NotNull
    public final String getDownload_report() {
        return this.download_report;
    }

    @NotNull
    public final String getImpression() {
        return this.impression;
    }

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final int getSort() {
        return this.sort;
    }

    @NotNull
    public final String getSstj() {
        return this.sstj;
    }

    public int hashCode() {
        return (((((((((((this.keyword.hashCode() * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.sort)) * 31) + this.impression.hashCode()) * 31) + this.click.hashCode()) * 31) + this.download_report.hashCode()) * 31) + this.sstj.hashCode();
    }

    @NotNull
    public String toString() {
        return "TvSearchHotKeywordsEntity(keyword=" + this.keyword + ", packageName=" + this.packageName + ", sort=" + this.sort + ", impression=" + this.impression + ", click=" + this.click + ", download_report=" + this.download_report + ", sstj=" + this.sstj + ')';
    }
}
