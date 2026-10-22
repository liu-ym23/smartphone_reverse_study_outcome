package com.bytedance.android.ecom.arch.slice.render.bindinfo;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/bindinfo/c;", "", "", "indexKey", "Ljava/lang/String;", "itemKey", PickerReporterConstants.KEY.TARGET, "start", "end", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f50128a = 0;

    @SerializedName("end")
    public final String end;

    @SerializedName("index")
    public final String indexKey;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    public final String itemKey;

    @SerializedName("start")
    public final String start;

    @SerializedName("items")
    public final String target;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.indexKey, r101.indexKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.itemKey, r101.itemKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.indexKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.itemKey;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.target;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.start;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.end;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "SlcBindForConfig(indexKey=" + this.indexKey + ", itemKey=" + this.itemKey + ", target=" + this.target + ", start=" + this.start + ", end=" + this.end + ")";
    }

    public c(String r100, String r101, String r102, String r103, String r104) {
        this.indexKey = r100;
        this.itemKey = r101;
        this.target = r102;
        this.start = r103;
        this.end = r104;
    }
}
