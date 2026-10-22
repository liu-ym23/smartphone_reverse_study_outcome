package com.bytedance.android.shopping.anchorv4.dto.base;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.google.gson.annotations.SerializedName;
import f73.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b8\u00109J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jg\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b#\u0010\"R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010/R$\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/base/LocalImage;", "component3", "Lf73/a;", "component4", "", "component5", "", "component6", "Lcom/bytedance/android/shopping/anchorv4/monitor/ImageMonitorMeta;", "component7", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "component8", "remote", "preview", "local", "gecko", "roundCorner", "tintColor", "imageMonitorMeta", "border", "copy", "toString", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getRemote", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getPreview", "Lcom/bytedance/android/shopping/anchorv4/dto/base/LocalImage;", "getLocal", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/LocalImage;", "Lf73/a;", "getGecko", "()Lf73/a;", "I", "getRoundCorner", "()I", "Ljava/lang/String;", "getTintColor", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/monitor/ImageMonitorMeta;", "getImageMonitorMeta", "()Lcom/bytedance/android/shopping/anchorv4/monitor/ImageMonitorMeta;", "setImageMonitorMeta", "(Lcom/bytedance/android/shopping/anchorv4/monitor/ImageMonitorMeta;)V", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "getBorder", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "<init>", "(Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/LocalImage;Lf73/a;ILjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/monitor/ImageMonitorMeta;Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageModel implements Serializable {

    @SerializedName("border")
    private final Border border;

    @SerializedName("gecko_model")
    private final a gecko;
    private ImageMonitorMeta imageMonitorMeta;

    @SerializedName("native_model")
    private final LocalImage local;

    @SerializedName("preview_model")
    private final ECUrlModel preview;

    @SerializedName("url_model")
    private final ECUrlModel remote;

    @SerializedName("round_corner")
    private final int roundCorner;

    @SerializedName("tint_color")
    private final String tintColor;

    public ImageModel() {
        this(null, null, null, null, 0, null, null, null, 255, null);
    }

    public static /* synthetic */ ImageModel copy$default(ImageModel r100, ECUrlModel r110, ECUrlModel r111, LocalImage r112, a r113, int r114, String r115, ImageMonitorMeta r116, Border r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        ECUrlModel r101 = r100.remote;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ECUrlModel r102 = r100.preview;
    L11:
        if ((r118 & 4) == 0) goto L13;
        LocalImage r103 = r100.local;
    L15:
        if ((r118 & 8) == 0) goto L17;
        a r104 = r100.gecko;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.roundCorner;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.tintColor;
    L27:
        if ((r118 & 64) == 0) goto L29;
        ImageMonitorMeta r107 = r100.imageMonitorMeta;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Border r108 = r100.border;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final ECUrlModel component1() {
        return this.remote;
    }

    public final ECUrlModel component2() {
        return this.preview;
    }

    public final LocalImage component3() {
        return this.local;
    }

    public final a component4() {
        return this.gecko;
    }

    public final int component5() {
        return this.roundCorner;
    }

    public final String component6() {
        return this.tintColor;
    }

    public final ImageMonitorMeta component7() {
        return this.imageMonitorMeta;
    }

    public final Border component8() {
        return this.border;
    }

    public final ImageModel copy(ECUrlModel r110, ECUrlModel r111, LocalImage r112, a r113, int r114, String r115, ImageMonitorMeta r116, Border r117) {
        return new ImageModel(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageModel) == false) goto L22;
        ImageModel r101 = (ImageModel) r100;
        if (Intrinsics.areEqual(this.remote, r101.remote) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preview, r101.preview) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.local, r101.local) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.gecko, r101.gecko) == true) goto L14;
        return false;
    L14:
        if (this.roundCorner == r101.roundCorner) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.tintColor, r101.tintColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageMonitorMeta, r101.imageMonitorMeta) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.border, r101.border) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        ECUrlModel r100 = this.remote;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.preview;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LocalImage r107 = this.local;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.gecko;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.roundCorner) * 31;
        String r113 = this.tintColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ImageMonitorMeta r116 = this.imageMonitorMeta;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Border r119 = this.border;
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

    public String toString() {
        return "ImageModel(remote=" + this.remote + ", preview=" + this.preview + ", local=" + this.local + ", gecko=" + this.gecko + ", roundCorner=" + this.roundCorner + ", tintColor=" + this.tintColor + ", imageMonitorMeta=" + this.imageMonitorMeta + ", border=" + this.border + ")";
    }

    public final Border getBorder() {
        return this.border;
    }

    public final a getGecko() {
        return this.gecko;
    }

    public final ImageMonitorMeta getImageMonitorMeta() {
        return this.imageMonitorMeta;
    }

    public final LocalImage getLocal() {
        return this.local;
    }

    public final ECUrlModel getPreview() {
        return this.preview;
    }

    public final ECUrlModel getRemote() {
        return this.remote;
    }

    public final int getRoundCorner() {
        return this.roundCorner;
    }

    public final String getTintColor() {
        return this.tintColor;
    }

    public final void setImageMonitorMeta(ImageMonitorMeta r100) {
        this.imageMonitorMeta = r100;
    }

    public ImageModel(ECUrlModel r100, ECUrlModel r101, LocalImage r102, a r103, int r104, String r105, ImageMonitorMeta r106, Border r107) {
        this.remote = r100;
        this.preview = r101;
        this.local = r102;
        this.gecko = r103;
        this.roundCorner = r104;
        this.tintColor = r105;
        this.imageMonitorMeta = r106;
        this.border = r107;
    }

    public /* synthetic */ ImageModel(ECUrlModel r110, ECUrlModel r111, LocalImage r112, a r113, int r114, String r115, ImageMonitorMeta r116, Border r117, int r118, DefaultConstructorMarker r119) {
        Border r100 = null;
        if ((r118 & 1) == 0) goto L5;
        ECUrlModel r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ECUrlModel r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        LocalImage r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        a r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        ImageMonitorMeta r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
