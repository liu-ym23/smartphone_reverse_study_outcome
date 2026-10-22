package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.t1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/v;", "", "Lcom/bytedance/android/ec/model/response/t1;", "background", "Lcom/bytedance/android/ec/model/response/t1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/t1;", "leftIcon", "c", "rightIcon", "d", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "textSize", "I", "f", "()I", "jumpUrl", "b", "Lcom/bytedance/android/ec/model/response/s1;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/ec/model/response/s1;", ce.f26391f, "()Lcom/bytedance/android/ec/model/response/s1;", "setTrack", "(Lcom/bytedance/android/ec/model/response/s1;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("background")
    private final t1 background;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("left_icon")
    private final t1 leftIcon;

    @SerializedName("right_icon")
    private final t1 rightIcon;

    @SerializedName("text")
    private final String text;

    @SerializedName("font_size")
    private final int textSize;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private s1 track;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L20;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightIcon, r101.rightIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L14;
        return false;
    L14:
        if (this.textSize == r101.textSize) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        t1 r100 = this.background;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t1 r104 = this.leftIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        t1 r107 = this.rightIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.text;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.textSize) * 31;
        String r113 = this.jumpUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        s1 r116 = this.track;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "IntroImageBottomBanner(background=" + this.background + ", leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", text=" + this.text + ", textSize=" + this.textSize + ", jumpUrl=" + this.jumpUrl + ", track=" + this.track + ")";
    }

    public v() {
        this.background = null;
        this.leftIcon = null;
        this.rightIcon = null;
        this.text = null;
        this.textSize = 0;
        this.jumpUrl = null;
        this.track = null;
    }

    public final t1 a() {
        return this.background;
    }

    public final String b() {
        return this.jumpUrl;
    }

    public final t1 c() {
        return this.leftIcon;
    }

    public final t1 d() {
        return this.rightIcon;
    }

    public final String e() {
        return this.text;
    }

    public final int f() {
        return this.textSize;
    }

    public final s1 g() {
        return this.track;
    }
}
