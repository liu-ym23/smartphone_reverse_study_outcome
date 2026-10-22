package com.bytedance.android.livesdk.chatroom.utils.pngloader;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/pngloader/FlexData;", "", "flexSetting", "", "textSetting", "width", "", "height", "([F[FII)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlexData {

    @SerializedName("flex_setting")
    public final float[] flexSetting;

    @SerializedName("height")
    public final int height;

    @SerializedName("text_setting")
    public final float[] textSetting;

    @SerializedName("width")
    public final int width;

    public FlexData() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ FlexData copy$default(FlexData r100, float[] r101, float[] r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.flexSetting;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.textSetting;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.width;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.height;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final float[] component1() {
        return this.flexSetting;
    }

    public final float[] component2() {
        return this.textSetting;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final FlexData copy(float[] r100, float[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "flexSetting");
        Intrinsics.checkNotNullParameter(r101, "textSetting");
        return new FlexData(r100, r101, r102, r103);
    }

    public String toString() {
        return "FlexData(flexSetting=" + Arrays.toString(this.flexSetting) + ", textSetting=" + Arrays.toString(this.textSetting) + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.flexSetting) * 31) + Arrays.hashCode(this.textSetting)) * 31) + this.width) * 31) + this.height;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(FlexData.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L27;
        FlexData r102 = (FlexData) r100;
        if (Arrays.equals(this.flexSetting, r102.flexSetting) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.textSetting, r102.textSetting) == true) goto L20;
        return false;
    L20:
        if (this.width == r102.width) goto L23;
        return false;
    L23:
        if (this.height == r102.height) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData");
    L8:
        r101 = null;
        goto L10
    }

    public FlexData(float[] r100, float[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "flexSetting");
        Intrinsics.checkNotNullParameter(r101, "textSetting");
        this.flexSetting = r100;
        this.textSetting = r101;
        this.width = r102;
        this.height = r103;
    }

    public /* synthetic */ FlexData(float[] r100, float[] r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new float[4];
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new float[4];
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
