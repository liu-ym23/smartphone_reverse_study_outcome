package com.bytedance.android.ec.store.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b%\u0010\u000bR\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR$\u0010(\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u0001008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R0\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/m;", "", "", "id", "J", "e", "()J", "", "name", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "", "isCurrent", "Z", OfficeSDKRequestTag.KEY_NEW_USER, "()Z", "canReverse", "b", "", "defaultSort", "I", "c", "()I", "Lcom/bytedance/android/ec/store/repository/dto/a;", IAllianceService.CONTENT_TYPE_BADGE, "Lcom/bytedance/android/ec/store/repository/dto/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/store/repository/dto/a;", "Lcom/bytedance/android/ec/store/repository/dto/e;", "imageInfo", "Lcom/bytedance/android/ec/store/repository/dto/e;", "f", "()Lcom/bytedance/android/ec/store/repository/dto/e;", "selectedTitle", "l", "selectedBackground", ce.f26396k, "normalBackground", "h", "selectParams", ce.f26395j, "setSelectParams", "(Ljava/lang/String;)V", "isSelect", "o", "setSelect", "(Z)V", "Lcom/bytedance/android/ec/store/repository/dto/c;", "selectButton", "Lcom/bytedance/android/ec/store/repository/dto/c;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/store/repository/dto/c;", "", "extraInfo", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "", "subSortFilterDTOList", "Ljava/util/List;", "m", "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("badge_info")
    private final a badge;

    @SerializedName("can_reverse")
    private final boolean canReverse;

    @SerializedName("default_sort")
    private final int defaultSort;

    @SerializedName("extra_info")
    private Map<String, String> extraInfo;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f48393id;

    @SerializedName("image_info")
    private final e imageInfo;

    @SerializedName("is_current")
    private final boolean isCurrent;

    @SerializedName("is_select")
    private boolean isSelect;

    @SerializedName("name")
    private final String name;

    @SerializedName("normal_background")
    private final String normalBackground;

    @SerializedName("select_button")
    private final c selectButton;

    @SerializedName("select_params")
    private String selectParams;

    @SerializedName("selected_background")
    private final String selectedBackground;

    @SerializedName("selected_title")
    private final String selectedTitle;

    @SerializedName("sub_sorts")
    private final List<m> subSortFilterDTOList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L36;
        m r101 = (m) r100;
        if (this.f48393id == r101.f48393id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (this.isCurrent == r101.isCurrent) goto L12;
        return false;
    L12:
        if (this.canReverse == r101.canReverse) goto L14;
        return false;
    L14:
        if (this.defaultSort == r101.defaultSort) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.badge, r101.badge) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageInfo, r101.imageInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.selectedTitle, r101.selectedTitle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.selectedBackground, r101.selectedBackground) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.normalBackground, r101.normalBackground) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.selectParams, r101.selectParams) == true) goto L28;
        return false;
    L28:
        if (this.isSelect == r101.isSelect) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectButton, r101.selectButton) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.subSortFilterDTOList, r101.subSortFilterDTOList) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        long r100 = this.f48393id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.name;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.isCurrent;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L9;
        r108 = 1;
    L9:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.canReverse;
        ?? r111 = r110;
        if (r110 == false) goto L12;
        r111 = 1;
    L12:
        int r112 = (((r109 + r111) * 31) + this.defaultSort) * 31;
        a r113 = this.badge;
        if (r113 == null) goto L15;
        int r114 = r113.hashCode();
    L16:
        int r115 = (r112 + r114) * 31;
        e r116 = this.imageInfo;
        if (r116 == null) goto L19;
        int r117 = r116.hashCode();
    L20:
        int r118 = (r115 + r117) * 31;
        String r119 = this.selectedTitle;
        if (r119 == null) goto L23;
        int r120 = r119.hashCode();
    L24:
        int r121 = (r118 + r120) * 31;
        String r122 = this.selectedBackground;
        if (r122 == null) goto L27;
        int r123 = r122.hashCode();
    L28:
        int r124 = (r121 + r123) * 31;
        String r125 = this.normalBackground;
        if (r125 == null) goto L31;
        int r126 = r125.hashCode();
    L32:
        int r127 = (r124 + r126) * 31;
        String r128 = this.selectParams;
        if (r128 == null) goto L35;
        int r129 = r128.hashCode();
    L36:
        int r130 = (r127 + r129) * 31;
        boolean r131 = this.isSelect;
        if (r131 == true) goto L40;
        r107 = r131;
    L40:
        int r132 = (r130 + r107) * 31;
        c r133 = this.selectButton;
        if (r133 == null) goto L43;
        int r134 = r133.hashCode();
    L44:
        int r135 = (r132 + r134) * 31;
        Map<String, String> r136 = this.extraInfo;
        if (r136 == null) goto L47;
        int r137 = r136.hashCode();
    L48:
        int r138 = (r135 + r137) * 31;
        List<m> r139 = this.subSortFilterDTOList;
        if (r139 == null) goto L52;
        r103 = r139.hashCode();
    L52:
        return r138 + r103;
    L47:
        r137 = 0;
        goto L48
    L43:
        r134 = 0;
        goto L44
    L35:
        r129 = 0;
        goto L36
    L31:
        r126 = 0;
        goto L32
    L27:
        r123 = 0;
        goto L28
    L23:
        r120 = 0;
        goto L24
    L19:
        r117 = 0;
        goto L20
    L15:
        r114 = 0;
        goto L16
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreV2SortTypeDTO(id=" + this.f48393id + ", name=" + this.name + ", isCurrent=" + this.isCurrent + ", canReverse=" + this.canReverse + ", defaultSort=" + this.defaultSort + ", badge=" + this.badge + ", imageInfo=" + this.imageInfo + ", selectedTitle=" + this.selectedTitle + ", selectedBackground=" + this.selectedBackground + ", normalBackground=" + this.normalBackground + ", selectParams=" + this.selectParams + ", isSelect=" + this.isSelect + ", selectButton=" + this.selectButton + ", extraInfo=" + this.extraInfo + ", subSortFilterDTOList=" + this.subSortFilterDTOList + ")";
    }

    public m() {
        ArrayList r100 = new ArrayList();
        Intrinsics.checkNotNullParameter("", "name");
        this.f48393id = 0;
        this.name = "";
        this.isCurrent = false;
        this.canReverse = false;
        this.defaultSort = 0;
        this.badge = null;
        this.imageInfo = null;
        this.selectedTitle = null;
        this.selectedBackground = null;
        this.normalBackground = null;
        this.selectParams = "";
        this.isSelect = false;
        this.selectButton = null;
        this.extraInfo = null;
        this.subSortFilterDTOList = r100;
    }

    public final a a() {
        return this.badge;
    }

    public final boolean b() {
        return this.canReverse;
    }

    public final int c() {
        return this.defaultSort;
    }

    public final Map<String, String> d() {
        return this.extraInfo;
    }

    public final long e() {
        return this.f48393id;
    }

    public final e f() {
        return this.imageInfo;
    }

    public final String g() {
        return this.name;
    }

    public final String h() {
        return this.normalBackground;
    }

    public final c i() {
        return this.selectButton;
    }

    public final String j() {
        return this.selectParams;
    }

    public final String k() {
        return this.selectedBackground;
    }

    public final String l() {
        return this.selectedTitle;
    }

    public final List<m> m() {
        return this.subSortFilterDTOList;
    }

    public final boolean n() {
        return this.isCurrent;
    }

    public final boolean o() {
        return this.isSelect;
    }
}
