package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"getEllipsizedLeftPadding", "", "Landroid/text/Layout;", "lineIndex", "", "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "EllipsisChar", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IndentationFixSpan_androidKt {
    private static final String EllipsisChar = "…";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Layout.Alignment.values().length];
            r100[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final float getEllipsizedLeftPadding(Layout r100, int r101, Paint r102) {
        float r103 = r100.getLineLeft(r101);
        if (TextLayout_androidKt.isLineEllipsized(r100, r101) == true) goto L5;
    L17:
        return 0.0f;
    L5:
        if (r100.getParagraphDirection(r101) != 1) goto L17;
        if (r103 >= 0.0f) goto L17;
        float r104 = (r100.getPrimaryHorizontal(r100.getLineStart(r101) + r100.getEllipsisStart(r101)) - r103) + r102.measureText(EllipsisChar);
        Layout.Alignment r105 = r100.getParagraphAlignment(r101);
        if (r105 != null) goto L11;
        int r106 = -1;
    L12:
        if (r106 != 1) goto L14;
        float r107 = Math.abs(r103);
        float r108 = (r100.getWidth() - r104) / 2.0f;
    L16:
        return r107 + r108;
    L14:
        r107 = Math.abs(r103);
        r108 = r100.getWidth() - r104;
        goto L16
    L11:
        r106 = WhenMappings.$EnumSwitchMapping$0[r105.ordinal()];
        goto L12
    }

    public static final float getEllipsizedRightPadding(Layout r100, int r101, Paint r102) {
        if (TextLayout_androidKt.isLineEllipsized(r100, r101) == false) goto L18;
        int r103 = -1;
        if (r100.getParagraphDirection(r101) == (-1)) goto L7;
        return 0.0f;
    L7:
        if (r100.getWidth() >= r100.getLineRight(r101)) goto L21;
        float r104 = (r100.getLineRight(r101) - r100.getPrimaryHorizontal(r100.getLineStart(r101) + r100.getEllipsisStart(r101))) + r102.measureText(EllipsisChar);
        Layout.Alignment r105 = r100.getParagraphAlignment(r101);
        if (r105 == null) goto L13;
        r103 = WhenMappings.$EnumSwitchMapping$0[r105.ordinal()];
    L13:
        if (r103 != 1) goto L15;
        float r106 = r100.getWidth() - r100.getLineRight(r101);
        float r107 = (r100.getWidth() - r104) / 2.0f;
    L17:
        return r106 - r107;
    L15:
        r106 = r100.getWidth() - r100.getLineRight(r101);
        r107 = r100.getWidth() - r104;
        goto L17
    L21:
        return 0.0f;
    L18:
        return 0.0f;
    }

    public static /* synthetic */ float getEllipsizedLeftPadding$default(Layout r100, int r101, Paint r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100.getPaint();
    L6:
        return getEllipsizedLeftPadding(r100, r101, r102);
    }

    public static /* synthetic */ float getEllipsizedRightPadding$default(Layout r100, int r101, Paint r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100.getPaint();
    L6:
        return getEllipsizedRightPadding(r100, r101, r102);
    }
}
