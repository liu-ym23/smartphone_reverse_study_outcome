package com.bytedance.ai.resource.core.bean;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoItem;", "", "packageName", "", RuleConditionBean.VERSION_CODE_KEY, "baseUrls", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getVersionCode", "setVersionCode", "getBaseUrls", "()Ljava/util/List;", "setBaseUrls", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageGeckoInfoItem {
    private List<String> baseUrls;
    private String packageName;
    private String versionCode;

    public AIPackageGeckoInfoItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageGeckoInfoItem copy$default(AIPackageGeckoInfoItem r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.packageName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.versionCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.baseUrls;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionCode;
    }

    public final List<String> component3() {
        return this.baseUrls;
    }

    public final AIPackageGeckoInfoItem copy(String r100, String r101, List<String> r102) {
        return new AIPackageGeckoInfoItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIPackageGeckoInfoItem) == true) goto L8;
        return false;
    L8:
        AIPackageGeckoInfoItem r101 = (AIPackageGeckoInfoItem) r100;
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionCode, r101.versionCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.baseUrls, r101.baseUrls) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.packageName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.versionCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.baseUrls;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AIPackageGeckoInfoItem(packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", baseUrls=" + this.baseUrls + ')';
    }

    public final List<String> getBaseUrls() {
        return this.baseUrls;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final void setBaseUrls(List<String> r100) {
        this.baseUrls = r100;
    }

    public final void setPackageName(String r100) {
        this.packageName = r100;
    }

    public final void setVersionCode(String r100) {
        this.versionCode = r100;
    }

    public AIPackageGeckoInfoItem(String r100, String r101, List<String> r102) {
        this.packageName = r100;
        this.versionCode = r101;
        this.baseUrls = r102;
    }

    public /* synthetic */ AIPackageGeckoInfoItem(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
