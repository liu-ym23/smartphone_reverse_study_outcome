package com.bytedance.android.ec.model.live;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/android/ec/model/live/e;", "", "", "backgroundColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "radius", "I", "h", "()I", "height", "f", "", "Lcom/bytedance/android/ec/model/live/b;", "content", "Ljava/util/List;", "e", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/live/p;", Notice.CLICK_TYPE_JUMP, "Lcom/bytedance/android/ec/model/live/p;", ce.f26391f, "()Lcom/bytedance/android/ec/model/live/p;", "Lcom/bytedance/android/ec/model/live/t;", "showTrackInfo", "Lcom/bytedance/android/ec/model/live/t;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/model/live/t;", "setShowTrackInfo", "(Lcom/bytedance/android/ec/model/live/t;)V", "clickTrackInfo", "d", "setClickTrackInfo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "backgroundImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setBackgroundImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "btm", "c", "setBtm", "(Ljava/lang/String;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("background_image")
    private ECUrlModel backgroundImage;

    @SerializedName("btm")
    private String btm;

    @SerializedName("click_track_info")
    private t clickTrackInfo;

    @SerializedName("content")
    private final List<b> content;

    @SerializedName("height")
    private final int height;

    @SerializedName(Notice.CLICK_TYPE_JUMP)
    private final p jump;

    @SerializedName("corner_radius")
    private final int radius;

    @SerializedName("show_track_info")
    private t showTrackInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L8;
        return false;
    L8:
        if (this.radius == r101.radius) goto L10;
        return false;
    L10:
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jump, r101.jump) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.showTrackInfo, r101.showTrackInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickTrackInfo, r101.clickTrackInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.backgroundImage, r101.backgroundImage) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.radius) * 31) + this.height) * 31;
        List<b> r104 = this.content;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        p r107 = this.jump;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        t r110 = this.showTrackInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        t r113 = this.clickTrackInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.backgroundImage;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.btm;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "ECElementBlockGroup(backgroundColor=" + this.backgroundColor + ", radius=" + this.radius + ", height=" + this.height + ", content=" + this.content + ", jump=" + this.jump + ", showTrackInfo=" + this.showTrackInfo + ", clickTrackInfo=" + this.clickTrackInfo + ", backgroundImage=" + this.backgroundImage + ", btm=" + this.btm + ")";
    }

    public e() {
        this.backgroundColor = null;
        this.radius = 0;
        this.height = -1;
        this.content = null;
        this.jump = null;
        this.showTrackInfo = null;
        this.clickTrackInfo = null;
        this.backgroundImage = null;
        this.btm = null;
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final ECUrlModel b() {
        return this.backgroundImage;
    }

    public final String c() {
        return this.btm;
    }

    public final t d() {
        return this.clickTrackInfo;
    }

    public final List<b> e() {
        return this.content;
    }

    public final int f() {
        return this.height;
    }

    public final p g() {
        return this.jump;
    }

    public final int h() {
        return this.radius;
    }

    public final t i() {
        return this.showTrackInfo;
    }
}
