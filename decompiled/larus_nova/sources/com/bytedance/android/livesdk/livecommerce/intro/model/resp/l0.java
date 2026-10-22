package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.s1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l0;", "", "", "buttonLabel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "buttonStyle", "J", "c", "()J", "maskStyle", "e", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b;", "action", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b;", "Lcom/bytedance/android/ec/model/response/s1;", "click", "Lcom/bytedance/android/ec/model/response/s1;", "d", "()Lcom/bytedance/android/ec/model/response/s1;", "show", "f", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName("action")
    private final b action;

    @SerializedName("button_label")
    private final String buttonLabel;

    @SerializedName("style")
    private final long buttonStyle;

    @SerializedName("click")
    private final s1 click;

    @SerializedName("mask_style")
    private final long maskStyle;

    @SerializedName("show")
    private final s1 show;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L18;
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.buttonLabel, r101.buttonLabel) == true) goto L8;
        return false;
    L8:
        if (this.buttonStyle == r101.buttonStyle) goto L10;
        return false;
    L10:
        if (this.maskStyle == r101.maskStyle) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.click, r101.click) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.show, r101.show) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.buttonLabel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.buttonStyle;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.maskStyle;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        b r107 = this.action;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        s1 r110 = this.click;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        s1 r113 = this.show;
        if (r113 == null) goto L18;
        r101 = r113.hashCode();
    L18:
        return r112 + r101;
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroPurchaseButton(buttonLabel=" + this.buttonLabel + ", buttonStyle=" + this.buttonStyle + ", maskStyle=" + this.maskStyle + ", action=" + this.action + ", click=" + this.click + ", show=" + this.show + ")";
    }

    public l0() {
        this.buttonLabel = null;
        this.buttonStyle = 0;
        this.maskStyle = 0;
        this.action = null;
        this.click = null;
        this.show = null;
    }

    public final b a() {
        return this.action;
    }

    public final String b() {
        return this.buttonLabel;
    }

    public final long c() {
        return this.buttonStyle;
    }

    public final s1 d() {
        return this.click;
    }

    public final long e() {
        return this.maskStyle;
    }

    public final s1 f() {
        return this.show;
    }
}
