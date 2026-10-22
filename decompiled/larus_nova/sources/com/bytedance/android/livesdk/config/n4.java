package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/n4;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "enterMerge", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "enterType", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n4 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enter_merge")
    private final String enterMerge;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE)
    private final String enterType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n4) == false) goto L12;
        n4 r101 = (n4) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterMerge, r101.enterMerge) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterType, r101.enterType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.enterMerge;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.enterType;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "EnableEnterConfig(enable=" + this.enable + ", enterMerge=" + this.enterMerge + ", enterType=" + this.enterType + ")";
    }

    public n4() {
        Intrinsics.checkNotNullParameter("", "enterMerge");
        Intrinsics.checkNotNullParameter("", "enterType");
        this.enable = false;
        this.enterMerge = "";
        this.enterType = "";
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.enterMerge;
    }

    public final String c() {
        return this.enterType;
    }
}
