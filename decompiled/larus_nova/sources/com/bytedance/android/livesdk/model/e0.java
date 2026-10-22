package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/model/e0;", "", "", "enabled", "Z", "", "lynxUrl", "Ljava/lang/String;", "lynxSchema", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("enable_use_lynx")
    public boolean enabled;

    @SerializedName("schema")
    public String lynxSchema;

    @SerializedName("url")
    public String lynxUrl;

    public e0() {
        this(7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L12;
        e0 r101 = (e0) r100;
        if (this.enabled == r101.enabled) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxSchema, r101.lynxSchema) == true) goto L19;
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
        boolean r100 = this.enabled;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.lynxUrl;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.lynxSchema;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "MultiLinkLynxEffectEntrance(enabled=" + this.enabled + ", lynxUrl=" + this.lynxUrl + ", lynxSchema=" + this.lynxSchema + ")";
    }

    public e0(int r100) {
        if ((r100 & 1) == 0) goto L5;
        boolean r101 = true;
    L6:
        String r102 = null;
        if ((r100 & 2) == 0) goto L9;
        String r103 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/common_effect_lynx_douyin/pages/multilink_effect/template.js";
    L11:
        if ((r100 & 4) == 0) goto L13;
        r102 = "sslocal://webcast_lynxview?enable_dynamic_v8=1&enable_canvas=1&type=popup&gravity=bottom&width_percent=100&height_percent=100&open_animate=0&enable_canvas_optimize=1&enable_latch=1";
    L13:
        Intrinsics.checkNotNullParameter(r103, "lynxUrl");
        Intrinsics.checkNotNullParameter(r102, "lynxSchema");
        this.enabled = r101;
        this.lynxUrl = r103;
        this.lynxSchema = r102;
        return;
    L9:
        r103 = null;
        goto L11
    L5:
        r101 = false;
        goto L6
    }
}
