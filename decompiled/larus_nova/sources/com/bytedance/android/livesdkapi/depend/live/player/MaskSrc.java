package com.bytedance.android.livesdkapi.depend.live.player;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Js\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\fHÆ\u0001J\u0013\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/player/MaskSrc;", "", "name", "", "type", "", "width", "height", "text", "textColor", "textSize", "isBold", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "isUseBitmapSize", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;IZLandroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getHeight", "()I", "()Z", "getName", "()Ljava/lang/String;", "getText", "getTextColor", "getTextSize", "getType", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MaskSrc {
    public static final Companion Companion = null;
    public static final int TypeImage = 1;
    public static final int TypeText = 0;
    private final Bitmap bitmap;
    private final int height;
    private final boolean isBold;
    private final boolean isUseBitmapSize;
    private final String name;
    private final String text;
    private final String textColor;
    private final int textSize;
    private final int type;
    private final int width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/player/MaskSrc$Companion;", "", "()V", "TypeImage", "", "TypeText", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ MaskSrc copy$default(MaskSrc r110, String r111, int r112, int r113, int r114, String r115, String r116, int r117, boolean r118, Bitmap r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.type;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = r110.width;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.height;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.text;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.textColor;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.textSize;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.isBold;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Bitmap r119 = r110.bitmap;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.isUseBitmapSize;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component10() {
        return this.isUseBitmapSize;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final String component5() {
        return this.text;
    }

    public final String component6() {
        return this.textColor;
    }

    public final int component7() {
        return this.textSize;
    }

    public final boolean component8() {
        return this.isBold;
    }

    public final Bitmap component9() {
        return this.bitmap;
    }

    public final MaskSrc copy(String r110, int r111, int r112, int r113, String r114, String r115, int r116, boolean r210, Bitmap r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r110, "name");
        return new MaskSrc(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MaskSrc) == false) goto L26;
        MaskSrc r101 = (MaskSrc) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (this.width == r101.width) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L18;
        return false;
    L18:
        if (this.textSize == r101.textSize) goto L20;
        return false;
    L20:
        if (this.isBold == r101.isBold) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bitmap, r101.bitmap) == true) goto L24;
        return false;
    L24:
        if (this.isUseBitmapSize == r101.isUseBitmapSize) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + this.type) * 31) + this.width) * 31) + this.height) * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.textSize) * 31;
        boolean r110 = this.isBold;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        Bitmap r114 = this.bitmap;
        if (r114 == null) goto L20;
        r101 = r114.hashCode();
    L20:
        int r115 = (r113 + r101) * 31;
        boolean r116 = this.isUseBitmapSize;
        if (r116 == true) goto L25;
        r111 = r116;
    L25:
        return r115 + r111;
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
        return "MaskSrc(name=" + this.name + ", type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", text=" + this.text + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", isBold=" + this.isBold + ", bitmap=" + this.bitmap + ", isUseBitmapSize=" + this.isUseBitmapSize + ")";
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getName() {
        return this.name;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public final boolean isUseBitmapSize() {
        return this.isUseBitmapSize;
    }

    public MaskSrc(String r100, int r101, int r102, int r103, String r104, String r105, int r106, boolean r107, Bitmap r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
        this.type = r101;
        this.width = r102;
        this.height = r103;
        this.text = r104;
        this.textColor = r105;
        this.textSize = r106;
        this.isBold = r107;
        this.bitmap = r110;
        this.isUseBitmapSize = r111;
    }

    public /* synthetic */ MaskSrc(String r110, int r111, int r112, int r113, String r114, String r210, int r211, boolean r212, Bitmap r213, boolean r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 64) == 0) goto L13;
        int r115 = 0;
    L15:
        if ((r215 & 128) == 0) goto L17;
        boolean r116 = false;
    L19:
        if ((r215 & 256) == 0) goto L21;
        Bitmap r117 = null;
    L23:
        if ((r215 & 512) == 0) goto L25;
        boolean r118 = true;
    L26:
        this(r110, r111, r112, r113, r100, r101, r115, r116, r117, r118);
        return;
    L25:
        r118 = r214;
        goto L26
    L21:
        r117 = r213;
        goto L23
    L17:
        r116 = r212;
        goto L19
    L13:
        r115 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
