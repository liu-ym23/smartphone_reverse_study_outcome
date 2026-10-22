package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdk.player.utils.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "", "scaleWidth", "", "scaleHeight", "(II)V", "getScaleHeight", "()I", "getScaleWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayRatio {
    public static final Companion Companion = null;
    private final int scaleHeight;
    private final int scaleWidth;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J?\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0003¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/DisplayRatio$Companion;", "", "()V", "calculateRenderViewInfo", "Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "displayRatio", "Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "videoW", "", "videoH", "getRatioType", "getScaleCropConfig", "Lkotlin/Pair;", "scaleW", "scaleH", "(Ljava/lang/Integer;Ljava/lang/Integer;II)Lkotlin/Pair;", "isValid", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        private final boolean isValid(int r100, int r101, int r102, int r103) {
            if (r100 == 0) goto L11;
            if (r101 == 0) goto L11;
            if (((r102 * 1.0f) / r103) >= ((r100 * 1.0f) / r101)) goto L9;
            return false;
        L9:
            return true;
        L11:
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final int getRatioType(DisplayRatio r100) {
            if (r100 != null) goto L4;
            return 0;
        L4:
            if (r100.getScaleWidth() != 16) goto L9;
            if (r100.getScaleHeight() != 9) goto L9;
            return 1;
        L9:
            if (r100.getScaleWidth() != 4) goto L15;
            if (r100.getScaleHeight() != 3) goto L15;
            return 2;
        L15:
            if (r100.getScaleWidth() == 1) goto L17;
            return 0;
        L17:
            if (r100.getScaleHeight() != 1) goto L22;
            return 3;
        L22:
            return 0;
        }

        @JvmStatic
        public final RenderViewInfo calculateRenderViewInfo(DisplayRatio r110, int r111, int r210) {
            Intrinsics.checkNotNullParameter(r110, "displayRatio");
            int r100 = h.e();
            int r101 = h.d();
            if (r100 > r101) goto L24;
            if (r100 == 0) goto L24;
            if (r101 == 0) goto L24;
            if (r111 < r210) goto L22;
            if (r111 == 0) goto L22;
            if (r210 == 0) goto L22;
            int r102 = r110.getScaleWidth();
            int r103 = r110.getScaleHeight();
            if (isValid(r102, r103, r111, r210) == true) goto L14;
            return null;
        L14:
            int r104 = (int) (((r100 * r103) * 1.0f) / r102);
            int r105 = (int) (((r111 * r104) * 1.0f) / r210);
            if (r105 <= 0) goto L20;
            if (r104 <= 0) goto L20;
            RenderViewInfo r106 = new RenderViewInfo(null, 0, 0, 0, 0, null, false, 127, null);
            r106.setViewWidth(r105);
            r106.setViewHeight(r104);
            return r106;
        L20:
            return null;
        L22:
            return null;
        L24:
            return null;
        }

        @JvmStatic
        public final Pair<DisplayRatio, RenderViewInfo> getScaleCropConfig(Integer r100, Integer r101, int r102, int r103) {
            int r104 = 0;
            if (r100 == null) goto L5;
            int r105 = r100.intValue();
        L6:
            if (r101 == null) goto L8;
            r104 = r101.intValue();
        L8:
            DisplayRatio r106 = new DisplayRatio(r105, r104);
            RenderViewInfo r107 = calculateRenderViewInfo(r106, r102, r103);
            if (r107 != null) goto L13;
            return null;
        L13:
            return TuplesKt.to(r106, r107);
        L5:
            r105 = 0;
            goto L6
        }

        public static final /* synthetic */ boolean access$isValid(Companion r100, int r101, int r102, int r103, int r104) {
            return r100.isValid(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final RenderViewInfo calculateRenderViewInfo(DisplayRatio r100, int r101, int r102) {
        return Companion.calculateRenderViewInfo(r100, r101, r102);
    }

    public static /* synthetic */ DisplayRatio copy$default(DisplayRatio r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.scaleWidth;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.scaleHeight;
    L9:
        return r100.copy(r101, r102);
    }

    @JvmStatic
    public static final int getRatioType(DisplayRatio r100) {
        return Companion.getRatioType(r100);
    }

    @JvmStatic
    public static final Pair<DisplayRatio, RenderViewInfo> getScaleCropConfig(Integer r100, Integer r101, int r102, int r103) {
        return Companion.getScaleCropConfig(r100, r101, r102, r103);
    }

    @JvmStatic
    private static final boolean isValid(int r100, int r101, int r102, int r103) {
        return Companion.access$isValid(Companion, r100, r101, r102, r103);
    }

    public final int component1() {
        return this.scaleWidth;
    }

    public final int component2() {
        return this.scaleHeight;
    }

    public final DisplayRatio copy(int r100, int r101) {
        return new DisplayRatio(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DisplayRatio) == false) goto L10;
        DisplayRatio r101 = (DisplayRatio) r100;
        if (this.scaleWidth == r101.scaleWidth) goto L8;
        return false;
    L8:
        if (this.scaleHeight == r101.scaleHeight) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.scaleWidth * 31) + this.scaleHeight;
    }

    public String toString() {
        return "DisplayRatio(scaleWidth=" + this.scaleWidth + ", scaleHeight=" + this.scaleHeight + ')';
    }

    public final int getScaleHeight() {
        return this.scaleHeight;
    }

    public final int getScaleWidth() {
        return this.scaleWidth;
    }

    public DisplayRatio(int r100, int r101) {
        this.scaleWidth = r100;
        this.scaleHeight = r101;
    }
}
