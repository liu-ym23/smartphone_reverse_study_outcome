package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/j;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/i;", "header", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/i;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/i;", "", "isUseGameInfoV4", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "isUseNewTab", "h", "isUseNewConvertArea", "f", "isUseNewHeaderSection", ce.f26391f, "supportDownloadWhilePlay", "c", "setSupportDownloadWhilePlay", "(Ljava/lang/Boolean;)V", "supportMapPlay", "d", "setSupportMapPlay", "halfHeader", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f53489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f53490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f53491c;

    @SerializedName("half_header")
    private final i halfHeader;

    @SerializedName("header")
    private final i header;

    @SerializedName("use_new_top_area")
    private final Boolean isUseGameInfoV4;

    @SerializedName("use_new_convert_area")
    private final Boolean isUseNewConvertArea;

    @SerializedName("is_new_header_section")
    private final Boolean isUseNewHeaderSection;

    @SerializedName("use_new_tab")
    private final Boolean isUseNewTab;

    @SerializedName("support_download_while_play")
    private Boolean supportDownloadWhilePlay;

    @SerializedName("support_map_play")
    private Boolean supportMapPlay;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L22;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isUseGameInfoV4, r101.isUseGameInfoV4) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isUseNewTab, r101.isUseNewTab) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isUseNewConvertArea, r101.isUseNewConvertArea) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isUseNewHeaderSection, r101.isUseNewHeaderSection) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.supportDownloadWhilePlay, r101.supportDownloadWhilePlay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportMapPlay, r101.supportMapPlay) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.halfHeader, r101.halfHeader) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        i r100 = this.header;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isUseGameInfoV4;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isUseNewTab;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isUseNewConvertArea;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isUseNewHeaderSection;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.supportDownloadWhilePlay;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.supportMapPlay;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        i r122 = this.halfHeader;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailCommonStyleInfo(header=" + this.header + ", isUseGameInfoV4=" + this.isUseGameInfoV4 + ", isUseNewTab=" + this.isUseNewTab + ", isUseNewConvertArea=" + this.isUseNewConvertArea + ", isUseNewHeaderSection=" + this.isUseNewHeaderSection + ", supportDownloadWhilePlay=" + this.supportDownloadWhilePlay + ", supportMapPlay=" + this.supportMapPlay + ", halfHeader=" + this.halfHeader + ")";
    }

    public j() {
        Boolean r100 = Boolean.FALSE;
        this.header = null;
        this.isUseGameInfoV4 = r100;
        this.isUseNewTab = r100;
        this.isUseNewConvertArea = r100;
        this.isUseNewHeaderSection = r100;
        this.supportDownloadWhilePlay = r100;
        this.supportMapPlay = r100;
        this.halfHeader = null;
    }

    public final boolean i() {
        i r100 = this.header;
        if (r100 == null) goto L9;
        if (r100.c() == 0) goto L9;
        if (this.header.c() == 1) goto L9;
    L11:
        return false;
    L9:
        if ((!Intrinsics.areEqual(this.isUseNewHeaderSection, Boolean.TRUE)) == false) goto L11;
        return true;
    }

    public final i a() {
        return this.halfHeader;
    }

    public final i b() {
        return this.header;
    }

    public final Boolean c() {
        return this.supportDownloadWhilePlay;
    }

    public final Boolean d() {
        return this.supportMapPlay;
    }

    public final Boolean e() {
        return this.isUseGameInfoV4;
    }

    public final Boolean f() {
        return this.isUseNewConvertArea;
    }

    public final Boolean g() {
        return this.isUseNewHeaderSection;
    }

    public final Boolean h() {
        return this.isUseNewTab;
    }
}
