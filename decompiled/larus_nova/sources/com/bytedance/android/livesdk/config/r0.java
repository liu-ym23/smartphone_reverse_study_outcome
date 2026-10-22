package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/r0;", "", "", "", "blackList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "multiList", "b", "setMultiList", "singleList", "c", "setSingleList", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("black_list")
    private List<String> blackList;

    @SerializedName("multi_list")
    private List<String> multiList;

    @SerializedName("single_list")
    private List<String> singleList;

    public r0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r0) == false) goto L12;
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.blackList, r101.blackList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.multiList, r101.multiList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.singleList, r101.singleList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.blackList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.multiList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.singleList;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BackRoomListSettingConfig(blackList=" + this.blackList + ", multiList=" + this.multiList + ", singleList=" + this.singleList + ")";
    }

    public final List<String> a() {
        return this.blackList;
    }

    public final List<String> b() {
        return this.multiList;
    }

    public final List<String> c() {
        return this.singleList;
    }

    public r0(Object r100) {
        this.blackList = null;
        this.multiList = null;
        this.singleList = null;
    }
}
