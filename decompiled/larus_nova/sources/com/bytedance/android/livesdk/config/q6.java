package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/q6;", "", "", "enable", "Z", "getEnable", "()Z", "fullLog", "getFullLog", "", "Lcom/bytedance/android/livesdk/config/bb1;", "filters", "Ljava/util/List;", "getFilters", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/config/p01;", "legalMessage", "getLegalMessage", "Lcom/bytedance/android/livesdk/config/ii1;", "uiStyle", "Lcom/bytedance/android/livesdk/config/ii1;", "getUiStyle", "()Lcom/bytedance/android/livesdk/config/ii1;", "debugFront", "getDebugFront", "debugMessageWindow", "getDebugMessageWindow", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f121031a;

    @SerializedName("debug_front")
    private final boolean debugFront;

    @SerializedName("debug_message_window")
    private final boolean debugMessageWindow;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("filters")
    private final List<bb1> filters;

    @SerializedName("full_log")
    private final boolean fullLog;

    @SerializedName("legal_message")
    private final List<p01> legalMessage;

    @SerializedName("ui_style")
    private final ii1 uiStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q6) == false) goto L22;
        q6 r101 = (q6) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.fullLog == r101.fullLog) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.filters, r101.filters) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.legalMessage, r101.legalMessage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uiStyle, r101.uiStyle) == true) goto L16;
        return false;
    L16:
        if (this.debugFront == r101.debugFront) goto L18;
        return false;
    L18:
        if (this.debugMessageWindow == r101.debugMessageWindow) goto L20;
        return false;
    L20:
        if (this.f121031a == r101.f121031a) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.fullLog;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        List<bb1> r107 = this.filters;
        int r108 = 0;
        if (r107 == null) goto L11;
        int r109 = r107.hashCode();
    L12:
        int r110 = (r106 + r109) * 31;
        List<p01> r111 = this.legalMessage;
        if (r111 == null) goto L15;
        int r112 = r111.hashCode();
    L16:
        int r113 = (r110 + r112) * 31;
        ii1 r114 = this.uiStyle;
        if (r114 == null) goto L19;
        r108 = r114.hashCode();
    L19:
        int r115 = (r113 + r108) * 31;
        boolean r116 = this.debugFront;
        ?? r117 = r116;
        if (r116 == false) goto L22;
        r117 = 1;
    L22:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.debugMessageWindow;
        ?? r120 = r119;
        if (r119 == false) goto L25;
        r120 = 1;
    L25:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f121031a;
        if (r122 == true) goto L30;
        r101 = r122;
    L30:
        return r121 + r101;
    L15:
        r112 = 0;
        goto L16
    L11:
        r109 = 0;
        goto L12
    }

    public final String toString() {
        return "GameNewFloatWindowConfig(enable=" + this.enable + ", fullLog=" + this.fullLog + ", filters=" + this.filters + ", legalMessage=" + this.legalMessage + ", uiStyle=" + this.uiStyle + ", debugFront=" + this.debugFront + ", debugMessageWindow=" + this.debugMessageWindow + ", messageDebug=" + this.f121031a + ")";
    }

    public q6() {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        ii1 r102 = new ii1(null);
        Intrinsics.checkNotNullParameter(r100, "filters");
        Intrinsics.checkNotNullParameter(r101, "legalMessage");
        Intrinsics.checkNotNullParameter(r102, "uiStyle");
        this.enable = false;
        this.fullLog = false;
        this.filters = r100;
        this.legalMessage = r101;
        this.uiStyle = r102;
        this.debugFront = false;
        this.debugMessageWindow = false;
        this.f121031a = false;
    }
}
