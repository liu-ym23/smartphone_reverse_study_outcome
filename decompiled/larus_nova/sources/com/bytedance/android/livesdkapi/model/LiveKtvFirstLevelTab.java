package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveKtvFirstLevelTab;", "", "tabName", "", "userType", "isNeedCartAnim", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getTabName", "()Ljava/lang/String;", "getUserType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveKtvFirstLevelTab {

    @SerializedName("is_need_cart_anim")
    private final boolean isNeedCartAnim;

    @SerializedName(a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("user_type")
    private final String userType;

    public LiveKtvFirstLevelTab() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ LiveKtvFirstLevelTab copy$default(LiveKtvFirstLevelTab r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tabName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.userType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isNeedCartAnim;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.tabName;
    }

    public final String component2() {
        return this.userType;
    }

    public final boolean component3() {
        return this.isNeedCartAnim;
    }

    public final LiveKtvFirstLevelTab copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r101, "userType");
        return new LiveKtvFirstLevelTab(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveKtvFirstLevelTab) == false) goto L12;
        LiveKtvFirstLevelTab r101 = (LiveKtvFirstLevelTab) r100;
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L10;
        return false;
    L10:
        if (this.isNeedCartAnim == r101.isNeedCartAnim) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.tabName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.userType;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.isNeedCartAnim;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveKtvFirstLevelTab(tabName=" + this.tabName + ", userType=" + this.userType + ", isNeedCartAnim=" + this.isNeedCartAnim + ")";
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final boolean isNeedCartAnim() {
        return this.isNeedCartAnim;
    }

    public LiveKtvFirstLevelTab(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r101, "userType");
        this.tabName = r100;
        this.userType = r101;
        this.isNeedCartAnim = r102;
    }

    public /* synthetic */ LiveKtvFirstLevelTab(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = TabName.UNKNOWN.getValue();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = UserType.UNKNOWN.getValue();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
