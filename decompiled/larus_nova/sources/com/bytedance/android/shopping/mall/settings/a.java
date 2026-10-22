package com.bytedance.android.shopping.mall.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/settings/a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "getPageName", "()Ljava/util/ArrayList;", "", "useWhiteBoard", "Ljava/lang/Integer;", "getUseWhiteBoard", "()Ljava/lang/Integer;", "pauseToStop", "getPauseToStop", "delayRemoveUnExposure", "getDelayRemoveUnExposure", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("delay_remove_un_exposure")
    private final Integer delayRemoveUnExposure;

    @SerializedName("page_name")
    private final ArrayList<String> pageName;

    @SerializedName("pause_to_stop")
    private final Integer pauseToStop;

    @SerializedName("use_white_board")
    private final Integer useWhiteBoard;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.settings.a$a, reason: collision with other inner class name */
    public static final class C2651a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.useWhiteBoard, r101.useWhiteBoard) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pauseToStop, r101.pauseToStop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.delayRemoveUnExposure, r101.delayRemoveUnExposure) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ArrayList<String> r100 = this.pageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.useWhiteBoard;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.pauseToStop;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.delayRemoveUnExposure;
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
        return "EnterPdOptSetting(pageName=" + this.pageName + ", useWhiteBoard=" + this.useWhiteBoard + ", pauseToStop=" + this.pauseToStop + ", delayRemoveUnExposure=" + this.delayRemoveUnExposure + ")";
    }

    public a(Object r100) {
        this.pageName = null;
        this.useWhiteBoard = null;
        this.pauseToStop = null;
        this.delayRemoveUnExposure = null;
    }

    public final boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r101 = this.pageName;
        if (r101 != null) goto L8;
    L9:
        ArrayList<String> r102 = this.pageName;
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.contains(r100) != true) goto L21;
    L13:
        Integer r103 = this.delayRemoveUnExposure;
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        if (r101.contains("all_page") == true) goto L13;
        goto L9
    }

    public final boolean b(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r101 = this.pageName;
        if (r101 != null) goto L8;
    L9:
        ArrayList<String> r102 = this.pageName;
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.contains(r100) != true) goto L21;
    L13:
        Integer r103 = this.pauseToStop;
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        if (r101.contains("all_page") == true) goto L13;
        goto L9
    }

    public final boolean c(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r101 = this.pageName;
        if (r101 != null) goto L8;
    L9:
        ArrayList<String> r102 = this.pageName;
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.contains(r100) != true) goto L21;
    L13:
        Integer r103 = this.useWhiteBoard;
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        if (r101.contains("all_page") == true) goto L13;
        goto L9
    }
}
