package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/i;", "", "", ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE, "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "mallSearchPitayaBusinessName", "Ljava/lang/String;", "getMallSearchPitayaBusinessName", "()Ljava/lang/String;", "mallSearchPitayaRuleName", "getMallSearchPitayaRuleName", "", "pageNameList", "Ljava/util/List;", "b", "()Ljava/util/List;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE)
    private final Integer enter_type;

    @SerializedName("business_name")
    private final String mallSearchPitayaBusinessName;

    @SerializedName("rule_name")
    private final String mallSearchPitayaRuleName;

    @SerializedName("page_name_list")
    private final List<String> pageNameList;

    public static final class a {
    }

    static {
    }

    public i() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.enter_type, r101.enter_type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mallSearchPitayaBusinessName, r101.mallSearchPitayaBusinessName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mallSearchPitayaRuleName, r101.mallSearchPitayaRuleName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageNameList, r101.pageNameList) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.enter_type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.mallSearchPitayaBusinessName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mallSearchPitayaRuleName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.pageNameList;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "MallSearchPitayaRefreshConfig(enter_type=" + this.enter_type + ", mallSearchPitayaBusinessName=" + this.mallSearchPitayaBusinessName + ", mallSearchPitayaRuleName=" + this.mallSearchPitayaRuleName + ", pageNameList=" + this.pageNameList + ")";
    }

    public final Integer a() {
        return this.enter_type;
    }

    public final List<String> b() {
        return this.pageNameList;
    }

    public i(Object r100) {
        this.enter_type = 0;
        this.mallSearchPitayaBusinessName = "";
        this.mallSearchPitayaRuleName = "";
        this.pageNameList = null;
    }
}
