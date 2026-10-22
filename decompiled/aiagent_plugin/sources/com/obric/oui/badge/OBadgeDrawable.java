package com.obric.oui.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.l.n;

/* JADX INFO: compiled from: OBadgeDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBadgeDrawable extends Drawable {
    private static final float BADGE_HORIZONTAL_PADDING_DP = 4.0f;
    private static final float BADGE_MIN_SIZE_DP = 18.0f;
    private static final float BADGE_VERTICAL_PADDING_DP = 4.0f;
    public static final b Companion = null;
    public static final int DEFAULT_MAX_COUNT = 9999;
    public static final float DEFAULT_TEXT_SIZE_SP = 12.0f;
    private static final float DOT_DIAMETER_DP = 8.0f;
    private static final int ELLIPSIS_CIRCLE_DRAW_OFFSET_DP = 5;
    private static final double ELLIPSIS_CIRCLE_RADIUS_DP = 1.5d;
    private static final float ELLIPSIS_HEIGHT_DP = 18.0f;
    private static final float ELLIPSIS_WIDTH_DP = 23.0f;
    private static final float MAX_OVERFLOW_DP = 5.0f;
    private static final float TEXT_WIDTH_EXTRA_DP = 1.0f;
    private int backgroundColor;
    private final Paint backgroundPaint;
    private float badgeCenterX;
    private float badgeCenterY;
    private a badgeGravity;
    private float badgeHeight;
    private float badgeMinSize;
    private int badgeTextColor;
    private float badgeWidth;
    private CharSequence contentDescription;
    private final Context context;
    private float dotDiameter;
    private float ellipsisCircleDrawOffset;
    private float ellipsisCircleRadius;
    private float ellipsisHeight;
    private float ellipsisWidth;
    private boolean enableFontScale;
    private boolean hasCenter;
    private int horizontalOffset;
    private float horizontalPadding;
    private String internalBadgeText;
    private Integer internalEllipsisColor;
    private final TextPaint internalTextPaint;
    private Rect lastAnchorRect;
    private View lastAnchorView;
    private View lastOverlayHost;
    private int maxNumber;
    private float maxOverFlow;
    private boolean needsLayout;
    private final RectF rectF;
    private float textSizeSp;
    private float textWidthExtra;
    private final Rect tmpTextBounds;
    private int verticalOffset;
    private float verticalPadding;

    /* JADX INFO: compiled from: OBadgeDrawable.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34006a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f34007b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f34008c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f34009d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f34006a, f34007b, f34008c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f34009d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34006a = new a("TOP_START", 0);
            f34007b = new a("TOP_END", 1);
            f34008c = new a("CENTER", 2);
            f34009d = a();
        }
    }

    /* JADX INFO: compiled from: OBadgeDrawable.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public final OBadgeDrawable a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            return new OBadgeDrawable(r1, null);
        }
    }

    /* JADX INFO: compiled from: OBadgeDrawable.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34010a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f34006a.ordinal()] = 1;
            r0[a.f34007b.ordinal()] = 2;
            r0[a.f34008c.ordinal()] = 3;
            f34010a = r0;
        }
    }

    static {
        Companion = new b(null);
    }

    public /* synthetic */ OBadgeDrawable(Context r2, h r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    public static final OBadgeDrawable create(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return Companion.a(r3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private OBadgeDrawable(Context r8) {
        Context r9 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.context = r9;
        this.horizontalPadding = g.c(r9, 4.0f);
        this.verticalPadding = g.c(r9, 4.0f);
        this.dotDiameter = g.c(r9, 8.0f);
        this.maxOverFlow = g.c(r9, MAX_OVERFLOW_DP);
        this.badgeMinSize = g.c(r9, 18.0f);
        this.ellipsisCircleRadius = g.a(r9, 1.5d);
        this.ellipsisCircleDrawOffset = g.b(r9, 5);
        this.ellipsisWidth = g.c(r9, ELLIPSIS_WIDTH_DP);
        this.ellipsisHeight = g.c(r9, 18.0f);
        this.textWidthExtra = g.c(r9, TEXT_WIDTH_EXTRA_DP);
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        r0.setColor(androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.oui_red_6, "color", "oui_red_6")));
        this.backgroundPaint = r0;
        TextPaint r1 = new TextPaint(1);
        r1.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r1.setTypeface(Typeface.create(r1.getTypeface(), 500, false));
    L6:
        r1.setColor(androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.white, "color", "white")));
        r1.setTextSize(g.d(r9, 12.0f));
        this.internalTextPaint = r1;
        this.tmpTextBounds = new Rect();
        this.rectF = new RectF();
        this.needsLayout = true;
        this.maxNumber = 9999;
        this.badgeGravity = a.f34007b;
        this.backgroundColor = androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.oui_red_6, "color", "oui_red_6"));
        this.badgeTextColor = androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.white, "color", "white"));
        this.enableFontScale = true;
        this.textSizeSp = 12.0f;
        return;
    L5:
        r1.setFakeBoldText(true);
        goto L6
    }

    public final String getBadgeText() {
        return this.internalBadgeText;
    }

    public final void setBadgeText(String r3) {
        if (o.a(this.internalBadgeText, r3) == false) goto L5;
        return;
    L5:
        String r4 = parseNumber(r3);
        this.internalBadgeText = r4;
        if (r4 == null) goto L13;
        o.a(r4);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        this.internalEllipsisColor = null;
        goto L13
    L10:
        r5 = false;
    L13:
        invalidateBadge();
    }

    public final int getMaxNumber() {
        return this.maxNumber;
    }

    public final void setMaxNumber(int r2) {
        if (r2 >= 1) goto L6;
        r2 = 1;
    L6:
        if (this.maxNumber != r2) goto L8;
        return;
    L8:
        this.maxNumber = r2;
        this.internalBadgeText = parseNumber(this.internalBadgeText);
        invalidateBadge();
    }

    public final a getBadgeGravity() {
        return this.badgeGravity;
    }

    public final void setBadgeGravity(a r2) {
        o.e(r2, "value");
        if (this.badgeGravity != r2) goto L5;
        return;
    L5:
        this.badgeGravity = r2;
        invalidateBadge();
    }

    public final int getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public final void setHorizontalOffset(int r2) {
        if (this.horizontalOffset != r2) goto L5;
        return;
    L5:
        this.horizontalOffset = r2;
        invalidateBadge();
    }

    public final int getVerticalOffset() {
        return this.verticalOffset;
    }

    public final void setVerticalOffset(int r2) {
        if (this.verticalOffset != r2) goto L5;
        return;
    L5:
        this.verticalOffset = r2;
        invalidateBadge();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int r2) {
        if (this.backgroundColor != r2) goto L5;
        return;
    L5:
        this.backgroundColor = r2;
        this.backgroundPaint.setColor(r2);
        invalidateSelf();
    }

    public final int getBadgeTextColor() {
        return this.badgeTextColor;
    }

    public final void setBadgeTextColor(int r2) {
        if (this.badgeTextColor != r2) goto L5;
        return;
    L5:
        this.badgeTextColor = r2;
        this.internalTextPaint.setColor(r2);
        invalidateSelf();
    }

    public final Integer getEllipsisColor() {
        return this.internalEllipsisColor;
    }

    public final void setEllipsisColor(Integer r2) {
        if (o.a(this.internalEllipsisColor, r2) == false) goto L5;
        return;
    L5:
        this.internalEllipsisColor = r2;
        this.internalBadgeText = null;
        invalidateBadge();
    }

    public final boolean getEnableFontScale() {
        return this.enableFontScale;
    }

    public final void setEnableFontScale(boolean r4) {
        if (this.enableFontScale != r4) goto L5;
        return;
    L5:
        this.enableFontScale = r4;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.context, "com.obric.aiagent.plugin").getDisplayMetrics();
        TextPaint r0 = this.internalTextPaint;
        if (this.enableFontScale == false) goto L8;
        float r6 = TypedValue.applyDimension(2, this.textSizeSp, r5);
    L9:
        r0.setTextSize(r6);
        invalidateBadge();
        return;
    L8:
        r6 = TypedValue.applyDimension(1, this.textSizeSp, r5);
        goto L9
    }

    public final float getTextSizeSp() {
        return this.textSizeSp;
    }

    public final void setTextSizeSp(float r4) {
        if (this.textSizeSp != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.textSizeSp = r4;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.context, "com.obric.aiagent.plugin").getDisplayMetrics();
        TextPaint r1 = this.internalTextPaint;
        if (this.enableFontScale == false) goto L11;
        float r6 = TypedValue.applyDimension(2, this.textSizeSp, r5);
    L12:
        r1.setTextSize(r6);
        invalidateBadge();
        return;
    L11:
        r6 = TypedValue.applyDimension(1, this.textSizeSp, r5);
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final TextPaint getTextPaint() {
        return this.internalTextPaint;
    }

    public final void setContentDescription(CharSequence r3) {
        this.contentDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final CharSequence getContentDescription() {
        return this.contentDescription;
    }

    private final String parseNumber(String r4) {
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L15;
    L13:
        return r4;
    L15:
        Integer r0 = Integer.valueOf(String.valueOf(r4));     // Catch: Exception -> L11
        o.c(r0, WsChannelMultiProcessSharedProvider.INT_TYPE);     // Catch: Exception -> L11
        if (r0.intValue() <= this.maxNumber) goto L8;
        r4 = new StringBuilder().append(this.maxNumber).append('+').toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r0.intValue() >= 0) goto L14;
        r4 = "";
    L12:
        throw new IllegalArgumentException(o.a("Excepted a int but get ", this.internalBadgeText));
    }

    public final void clearText() {
        this.internalBadgeText = null;
        invalidateBadge();
    }

    public final void updateBadgeCoordinates(View r8, View r9) {
        o.e(r8, "anchor");
        this.lastAnchorView = r8;
        this.lastOverlayHost = r9;
        Rect r0 = new Rect();
        boolean r1 = false;
        if (r9 == null) goto L5;
        int[] r4 = new int[2];
        int[] r5 = new int[2];
        r8.getLocationInWindow(r4);
        r9.getLocationInWindow(r5);
        int r10 = r4[0] - r5[0];
        int r6 = r4[1] - r5[1];
        r0.set(r10, r6, r8.getWidth() + r10, r8.getHeight() + r6);
    L6:
        this.lastAnchorRect = new Rect(r0);
        if (ViewCompat.i(r8) != 1) goto L9;
        r1 = true;
    L9:
        int r11 = c.f34010a[this.badgeGravity.ordinal()];
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L16;
        if (r11 != 3) goto L15;
        int r12 = r0.right - ((r0.right - r0.left) / 2);
    L23:
        if (c.f34010a[this.badgeGravity.ordinal()] != 3) goto L25;
        int r13 = r0.bottom - ((r0.bottom - r0.top) / 2);
    L26:
        this.badgeCenterX = r12 + this.horizontalOffset;
        this.badgeCenterY = r13 + this.verticalOffset;
        this.hasCenter = true;
        this.needsLayout = true;
        updateBoundsInternal();
        return;
    L25:
        r13 = r0.top;
        goto L26
    L15:
        throw new k();
    L16:
        if (r1 == false) goto L18;
        r12 = r0.left;
        goto L23
    L18:
        r12 = r0.right;
        goto L23
    L19:
        if (r1 == false) goto L21;
        r12 = r0.right;
        goto L23
    L21:
        r12 = r0.left;
        goto L23
    L5:
        r8.getDrawingRect(r0);
        goto L6
    }

    public final void updateBadgeCoordinates(View r2) {
        o.e(r2, "anchor");
        updateBadgeCoordinates(r2, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        o.e(r9, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.hasCenter == true) goto L9;
        return;
    L9:
        if (this.needsLayout == false) goto L12;
        updateBoundsInternal();
    L12:
        if (this.badgeWidth > 0.0f) goto L14;
        return;
    L14:
        if (this.badgeHeight <= 0.0f) goto L37;
        this.rectF.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r0 = this.badgeHeight / 2.0f;
        r9.drawRoundRect(this.rectF, r0, r0, this.backgroundPaint);
        String r1 = this.internalBadgeText;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L26;
        r9.drawText(r1, this.rectF.centerX(), this.rectF.centerY() - ((this.internalTextPaint.ascent() + this.internalTextPaint.descent()) / 2.0f), (Paint) ZeusTransformUtils.preCheckCast(this.internalTextPaint, Paint.class, "com.obric.aiagent.plugin"));
    L26:
        if (getEllipsisColor() == null) goto L35;
        Integer r4 = getEllipsisColor();
        if (r4 != null) goto L31;
    L32:
        float r5 = this.rectF.centerX();
        float r6 = this.rectF.centerY();
        float r7 = this.ellipsisCircleRadius;
        Paint r8 = new Paint();
        Integer r10 = getEllipsisColor();
        o.a(r10);
        r8.setColor(r10.intValue());
        r8.setAntiAlias(true);
        r9.drawCircle(r5, r6, r7, r8);
        r9.drawCircle(r5 - this.ellipsisCircleDrawOffset, r6, r7, r8);
        r9.drawCircle(r5 + this.ellipsisCircleDrawOffset, r6, r7, r8);
        return;
    L31:
        if (r4.intValue() != 0) goto L32;
        return;
    L35:
        return;
    L19:
        if (r2.length() == 0) goto L22;
        r3 = false;
        goto L23
    }

    private final void updateBoundsInternal() {
        if (this.hasCenter == true) goto L5;
        return;
    L5:
        calculateBadgeSize(this.internalBadgeText);
        float r0 = this.badgeWidth / 2.0f;
        float r2 = this.badgeHeight / 2.0f;
        int r1 = d.i.a.a(this.badgeCenterX - r0);
        int r3 = d.i.a.a(this.badgeCenterY - r2);
        int r4 = d.i.a.a(this.badgeCenterX + r0);
        int r5 = d.i.a.a(this.badgeCenterY + r2);
        Rect r6 = this.lastAnchorRect;
        if (r6 == null) goto L21;
        float r7 = this.maxOverFlow;
        int r8 = c.f34010a[this.badgeGravity.ordinal()];
        if (r8 != 1) goto L10;
        float r9 = r6.left - r1;
        if (r9 <= r7) goto L18;
        int r10 = d.i.a.a(r9 - r7);
        r1 = r1 + r10;
        r4 = r4 + r10;
    L18:
        float r11 = r6.top - r3;
        if (r11 <= r7) goto L21;
        int r12 = d.i.a.a(r11 - r7);
        r3 = r3 + r12;
        r5 = r5 + r12;
        goto L21
    L10:
        if (r8 != 2) goto L18;
        float r13 = r4 - r6.right;
        if (r13 <= r7) goto L18;
        int r14 = d.i.a.a(r13 - r7);
        r1 = r1 - r14;
        r4 = r4 - r14;
    L21:
        setBounds(r1, r3, r4, r5);
        this.needsLayout = false;
    }

    private final void calculateBadgeSize(String r5) {
        if (getEllipsisColor() == null) goto L10;
        Integer r0 = getEllipsisColor();
        if (r0 != null) goto L8;
    L9:
        this.badgeWidth = this.ellipsisWidth;
        this.badgeHeight = this.ellipsisHeight;
        return;
    L8:
        if (r0.intValue() != 0) goto L9;
    L10:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        float r6 = this.dotDiameter;
        this.badgeWidth = r6;
        this.badgeHeight = r6;
        return;
    L19:
        this.internalTextPaint.getTextBounds(r5, 0, r5.length(), this.tmpTextBounds);
        float r7 = this.tmpTextBounds.width() + this.textWidthExtra;
        float r3 = this.horizontalPadding;
        float r4 = this.badgeMinSize;
        float r8 = n.a(r7 + (2 * r3), r4);
        if (r8 > r4) goto L22;
        float r9 = Math.max(r8, r4);
        this.badgeWidth = r9;
        this.badgeHeight = r9;
        return;
    L22:
        this.badgeWidth = r8;
        this.badgeHeight = r4;
        return;
    L13:
        if (r1.length() == 0) goto L16;
        r2 = false;
        goto L17
    }

    private final void invalidateBadge() {
        this.needsLayout = true;
        invalidateSelf();
        View r0 = this.lastAnchorView;
        if (r0 == null) goto L6;
        o.a(r0);
        updateBadgeCoordinates(r0, this.lastOverlayHost);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.backgroundPaint.setAlpha(r2);
        this.internalTextPaint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.backgroundPaint.setColorFilter(r2);
        this.internalTextPaint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r1, boolean r2) {
        boolean r3 = super.setVisible(r1, r2);
        if (r3 == false) goto L5;
        invalidateSelf();
    L5:
        return r3;
    }
}
