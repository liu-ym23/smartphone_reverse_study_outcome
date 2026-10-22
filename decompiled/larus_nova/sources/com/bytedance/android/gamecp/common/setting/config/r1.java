package com.bytedance.android.gamecp.common.setting.config;

import android.graphics.Bitmap;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\tR\u001e\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/r1;", "", "", "enable", "Z", "b", "()Z", "", "_width", "I", "_height", "", "", "_lynxPaths", "Ljava/util/List;", "_bitmapConfig", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r1 {

    @SerializedName("bitmapConfig")
    private final int _bitmapConfig;

    @SerializedName("height")
    private final int _height;

    @SerializedName("lynxPaths")
    private final List<String> _lynxPaths;

    @SerializedName("width")
    private final int _width;

    @SerializedName("enable")
    private final boolean enable;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r1) == false) goto L16;
        r1 r101 = (r1) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this._width == r101._width) goto L10;
        return false;
    L10:
        if (this._height == r101._height) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this._lynxPaths, r101._lynxPaths) == true) goto L14;
        return false;
    L14:
        if (this._bitmapConfig == r101._bitmapConfig) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((((r101 * 31) + this._width) * 31) + this._height) * 31;
        List<String> r103 = this._lynxPaths;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return ((r102 + r104) * 31) + this._bitmapConfig;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "GamePromoteIconPreloadItemConfig(enable=" + this.enable + ", _width=" + this._width + ", _height=" + this._height + ", _lynxPaths=" + this._lynxPaths + ", _bitmapConfig=" + this._bitmapConfig + ")";
    }

    public final Bitmap.Config a() {
        int r100 = this._bitmapConfig;
        if (r100 != Bitmap.Config.ARGB_8888.ordinal()) goto L6;
        return Bitmap.Config.ARGB_8888;
    L6:
        if (r100 != Bitmap.Config.ALPHA_8.ordinal()) goto L9;
        return Bitmap.Config.ALPHA_8;
    L9:
        if (r100 != Bitmap.Config.RGB_565.ordinal()) goto L12;
        return Bitmap.Config.RGB_565;
    L12:
        return Bitmap.Config.ARGB_8888;
    }

    public final int c() {
        return UtilityKotlinExtentionsKt.c(this._height);
    }

    public final int e() {
        return UtilityKotlinExtentionsKt.c(this._width);
    }

    public final boolean f() {
        if (this._width > 0) goto L5;
    L7:
        return false;
    L5:
        if (this._height <= 0) goto L7;
        return true;
    }

    public r1() {
        this.enable = false;
        this._width = 50;
        this._height = 50;
        this._lynxPaths = null;
        this._bitmapConfig = 5;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> d() {
        return this._lynxPaths;
    }
}
