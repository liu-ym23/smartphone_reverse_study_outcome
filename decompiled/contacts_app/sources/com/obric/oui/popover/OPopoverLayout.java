package com.obric.oui.popover;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OPopoverLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 {2\u00020\u0001:\u0002{|B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010N\u001a\u00020\tJ\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001eJ\u0006\u0010S\u001a\u00020\tJ\u0006\u0010T\u001a\u00020\u001eJ\u0006\u0010U\u001a\u00020\u001eJ\u0006\u0010V\u001a\u00020 J\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020GJ\u0018\u0010Y\u001a\u00020Z2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020]H\u0002J\u0016\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020,2\u0006\u0010`\u001a\u00020\tJ\u0010\u0010a\u001a\u00020Z2\u0006\u0010b\u001a\u00020#H\u0015J\u0018\u0010c\u001a\u00020Z2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\tH\u0015J(\u0010f\u001a\u00020Z2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020\tH\u0014J\b\u0010k\u001a\u00020ZH\u0002J\u000e\u0010l\u001a\u00020Z2\u0006\u0010m\u001a\u00020\tJ\u000e\u0010n\u001a\u00020Z2\u0006\u0010Q\u001a\u00020\tJ\u000e\u0010o\u001a\u00020Z2\u0006\u0010p\u001a\u00020\tJ\u0016\u0010q\u001a\u00020Z2\u0006\u0010p\u001a\u00020\t2\u0006\u0010r\u001a\u00020\u001eJ\u0010\u0010s\u001a\u00020Z2\b\b\u0001\u0010t\u001a\u00020\u001eJ\u000e\u0010u\u001a\u00020Z2\u0006\u0010v\u001a\u00020\tJ\u000e\u0010w\u001a\u00020Z2\u0006\u0010x\u001a\u00020;J\u000e\u0010y\u001a\u00020Z2\u0006\u0010z\u001a\u00020,R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u00020\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\u000e\u00107\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u000e\u0010C\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010.\"\u0004\bM\u00100¨\u0006}"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "additionalHeight", "arrowPadding", "borderColor", "borderWidth", "defaultHeight", "defaultWidth", "mAdjustHeight", "getMAdjustHeight", "()I", "setMAdjustHeight", "(I)V", "mArrowPressedPaint", "Landroid/graphics/Paint;", "mBgColor", "getMBgColor", "setMBgColor", "mBitmap", "Landroid/graphics/Bitmap;", "mBubbleArrowOffset", "", "mBubbleArrowPath", "Landroid/graphics/Path;", "mBubbleOrientation", "mCanvas", "Landroid/graphics/Canvas;", "mCornerRadius", "mFillPaint", "mHeight", "getMHeight", "()F", "setMHeight", "(F)V", "mNeedArrow", "", "getMNeedArrow", "()Z", "setMNeedArrow", "(Z)V", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mPadding", "getMPadding", "setMPadding", "mPath", "mRoundRect", "Landroid/graphics/RectF;", "mSubTitle", "", "getMSubTitle", "()Ljava/lang/String;", "setMSubTitle", "(Ljava/lang/String;)V", "mWidth", "getMWidth", "setMWidth", "maxWidth", "minArrowDistance", "pressStateColor", "shadowConfig", "Lcom/obric/oui/popover/OPopoverLayout$ShadowConfig;", "strokePaint", "tempArrowPath", "tempRectPath", "useDefaultView", "getUseDefaultView", "setUseDefaultView", "arrowDirection", "calculateBubbleArrowMatrix", "Landroid/graphics/Matrix;", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "getArrowHeight", "getBubbleOffset", "getCornerRadius", "getFullPath", "getPadding", "getShadowConfig", "init", "", "measureTextViewWidth", "textView", "Landroid/widget/TextView;", "notifyPressed", "pressed", "pressedColor", "onDraw", "canvas", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "renderBubbleLegPrototype", "setBorderColor", "color", "setBorderWidth", "setBubbleOrientation", "bubbleOrientation", "setBubbleParams", "bubbleArrowOffset", "setCornerRadius", "cornerRadius", "setCornerRadiusDp", "cornerRadiusDp", "setSubText", "str", "setTransparentBg", "transparent", "Companion", "ShadowConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout {
    private static int ADDITIONAL_HEIGHT_DP = 0;
    private static int ARROW_PADDING_DP = 0;
    public static final int BOTTOM = 3;
    private static int CORNER_RADIUS_DOUBLE_DP = 0;
    private static int CORNER_RADIUS_DP = 0;
    private static int CORNER_RADIUS_SINGLE_DP = 0;
    public static final Companion Companion = null;
    private static int DEFAULT_HEIGHT_DP = 0;
    private static int DEFAULT_PADDING_DP = 0;
    private static int DEFAULT_WIDTH_DP = 0;
    public static final int LEFT = 1;
    private static int MAX_WIDTH_DP = 0;
    private static int MIN_ARROW_DISTANCE_DP = 0;
    public static final int RIGHT = 2;
    private static final String TAG = "OPopoverLayout";
    public static final int TOP = 0;
    private int additionalHeight;
    private int arrowPadding;
    private int borderColor;
    private int borderWidth;
    private int defaultHeight;
    private int defaultWidth;
    private int mAdjustHeight;
    private Paint mArrowPressedPaint;
    private int mBgColor;
    private Bitmap mBitmap;
    private float mBubbleArrowOffset;
    private Path mBubbleArrowPath;
    private int mBubbleOrientation;
    private Canvas mCanvas;
    private float mCornerRadius;
    private Paint mFillPaint;
    private float mHeight;
    private boolean mNeedArrow;
    private boolean mNeedShadow;
    private int mPadding;
    private Path mPath;
    private RectF mRoundRect;
    private String mSubTitle;
    private float mWidth;
    private int maxWidth;
    private float minArrowDistance;
    private int pressStateColor;
    private ShadowConfig shadowConfig;
    private Paint strokePaint;
    private final Path tempArrowPath;
    private final Path tempRectPath;
    private boolean useDefaultView;

    /* JADX INFO: compiled from: OPopoverLayout.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout$Companion;", "", "()V", "ADDITIONAL_HEIGHT_DP", "", "getADDITIONAL_HEIGHT_DP", "()I", "setADDITIONAL_HEIGHT_DP", "(I)V", "ARROW_PADDING_DP", "getARROW_PADDING_DP", "setARROW_PADDING_DP", "BOTTOM", "CORNER_RADIUS_DOUBLE_DP", "getCORNER_RADIUS_DOUBLE_DP", "setCORNER_RADIUS_DOUBLE_DP", "CORNER_RADIUS_DP", "getCORNER_RADIUS_DP", "setCORNER_RADIUS_DP", "CORNER_RADIUS_SINGLE_DP", "getCORNER_RADIUS_SINGLE_DP", "setCORNER_RADIUS_SINGLE_DP", "DEFAULT_HEIGHT_DP", "getDEFAULT_HEIGHT_DP", "setDEFAULT_HEIGHT_DP", "DEFAULT_PADDING_DP", "getDEFAULT_PADDING_DP", "setDEFAULT_PADDING_DP", "DEFAULT_WIDTH_DP", "getDEFAULT_WIDTH_DP", "setDEFAULT_WIDTH_DP", "LEFT", "MAX_WIDTH_DP", "getMAX_WIDTH_DP", "setMAX_WIDTH_DP", "MIN_ARROW_DISTANCE_DP", "getMIN_ARROW_DISTANCE_DP", "setMIN_ARROW_DISTANCE_DP", "RIGHT", "TAG", "", "TOP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getARROW_PADDING_DP() {
            return OPopoverLayout.access$getARROW_PADDING_DP$cp();
        }

        public final void setARROW_PADDING_DP(int r1) {
            OPopoverLayout.access$setARROW_PADDING_DP$cp(r1);
        }

        public final int getCORNER_RADIUS_DP() {
            return OPopoverLayout.access$getCORNER_RADIUS_DP$cp();
        }

        public final void setCORNER_RADIUS_DP(int r1) {
            OPopoverLayout.access$setCORNER_RADIUS_DP$cp(r1);
        }

        public final int getCORNER_RADIUS_SINGLE_DP() {
            return OPopoverLayout.access$getCORNER_RADIUS_SINGLE_DP$cp();
        }

        public final void setCORNER_RADIUS_SINGLE_DP(int r1) {
            OPopoverLayout.access$setCORNER_RADIUS_SINGLE_DP$cp(r1);
        }

        public final int getCORNER_RADIUS_DOUBLE_DP() {
            return OPopoverLayout.access$getCORNER_RADIUS_DOUBLE_DP$cp();
        }

        public final void setCORNER_RADIUS_DOUBLE_DP(int r1) {
            OPopoverLayout.access$setCORNER_RADIUS_DOUBLE_DP$cp(r1);
        }

        public final int getMIN_ARROW_DISTANCE_DP() {
            return OPopoverLayout.access$getMIN_ARROW_DISTANCE_DP$cp();
        }

        public final void setMIN_ARROW_DISTANCE_DP(int r1) {
            OPopoverLayout.access$setMIN_ARROW_DISTANCE_DP$cp(r1);
        }

        public final int getDEFAULT_WIDTH_DP() {
            return OPopoverLayout.access$getDEFAULT_WIDTH_DP$cp();
        }

        public final void setDEFAULT_WIDTH_DP(int r1) {
            OPopoverLayout.access$setDEFAULT_WIDTH_DP$cp(r1);
        }

        public final int getDEFAULT_HEIGHT_DP() {
            return OPopoverLayout.access$getDEFAULT_HEIGHT_DP$cp();
        }

        public final void setDEFAULT_HEIGHT_DP(int r1) {
            OPopoverLayout.access$setDEFAULT_HEIGHT_DP$cp(r1);
        }

        public final int getADDITIONAL_HEIGHT_DP() {
            return OPopoverLayout.access$getADDITIONAL_HEIGHT_DP$cp();
        }

        public final void setADDITIONAL_HEIGHT_DP(int r1) {
            OPopoverLayout.access$setADDITIONAL_HEIGHT_DP$cp(r1);
        }

        public final int getDEFAULT_PADDING_DP() {
            return OPopoverLayout.access$getDEFAULT_PADDING_DP$cp();
        }

        public final void setDEFAULT_PADDING_DP(int r1) {
            OPopoverLayout.access$setDEFAULT_PADDING_DP$cp(r1);
        }

        public final int getMAX_WIDTH_DP() {
            return OPopoverLayout.access$getMAX_WIDTH_DP$cp();
        }

        public final void setMAX_WIDTH_DP(int r1) {
            OPopoverLayout.access$setMAX_WIDTH_DP$cp(r1);
        }
    }

    /* JADX INFO: compiled from: OPopoverLayout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout$ShadowConfig;", "", "radius", "", "dx", "dy", "color", "", "(FFFI)V", "getColor", "()I", "setColor", "(I)V", "getDx", "()F", "setDx", "(F)V", "getDy", "setDy", "getRadius", "setRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShadowConfig {
        private int color;
        private float dx;
        private float dy;
        private float radius;

        public ShadowConfig() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public static /* synthetic */ ShadowConfig copy$default(ShadowConfig r0, float r1, float r2, float r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.radius;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.dx;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.dy;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.color;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final float component1() {
            return this.radius;
        }

        public final float component2() {
            return this.dx;
        }

        public final float component3() {
            return this.dy;
        }

        public final int component4() {
            return this.color;
        }

        public final ShadowConfig copy(float r1, float r2, float r3, int r4) {
            return new ShadowConfig(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ShadowConfig) == true) goto L8;
            return false;
        L8:
            ShadowConfig r6 = (ShadowConfig) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(r6.radius)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.dx), Float.valueOf(r6.dx)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.dy), Float.valueOf(r6.dy)) == true) goto L18;
            return false;
        L18:
            if (this.color == r6.color) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.radius) * 31) + Float.hashCode(this.dx)) * 31) + Float.hashCode(this.dy)) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.radius + ", dx=" + this.dx + ", dy=" + this.dy + ", color=" + this.color + ')';
        }

        public ShadowConfig(float r1, float r2, float r3, int r4) {
            this.radius = r1;
            this.dx = r2;
            this.dy = r3;
            this.color = r4;
        }

        public /* synthetic */ ShadowConfig(float r2, float r3, float r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 2.0f;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 2.0f;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 5.0f;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = -16777216;
        L14:
            this(r2, r3, r4, r5);
        }

        public final float getRadius() {
            return this.radius;
        }

        public final void setRadius(float r1) {
            this.radius = r1;
        }

        public final float getDx() {
            return this.dx;
        }

        public final void setDx(float r1) {
            this.dx = r1;
        }

        public final float getDy() {
            return this.dy;
        }

        public final void setDy(float r1) {
            this.dy = r1;
        }

        public final int getColor() {
            return this.color;
        }

        public final void setColor(int r1) {
            this.color = r1;
        }
    }

    public static final /* synthetic */ int access$getADDITIONAL_HEIGHT_DP$cp() {
        return ADDITIONAL_HEIGHT_DP;
    }

    public static final /* synthetic */ int access$getARROW_PADDING_DP$cp() {
        return ARROW_PADDING_DP;
    }

    public static final /* synthetic */ int access$getCORNER_RADIUS_DOUBLE_DP$cp() {
        return CORNER_RADIUS_DOUBLE_DP;
    }

    public static final /* synthetic */ int access$getCORNER_RADIUS_DP$cp() {
        return CORNER_RADIUS_DP;
    }

    public static final /* synthetic */ int access$getCORNER_RADIUS_SINGLE_DP$cp() {
        return CORNER_RADIUS_SINGLE_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_HEIGHT_DP$cp() {
        return DEFAULT_HEIGHT_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_PADDING_DP$cp() {
        return DEFAULT_PADDING_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_WIDTH_DP$cp() {
        return DEFAULT_WIDTH_DP;
    }

    public static final /* synthetic */ int access$getMAX_WIDTH_DP$cp() {
        return MAX_WIDTH_DP;
    }

    public static final /* synthetic */ int access$getMIN_ARROW_DISTANCE_DP$cp() {
        return MIN_ARROW_DISTANCE_DP;
    }

    public static final /* synthetic */ void access$setADDITIONAL_HEIGHT_DP$cp(int r0) {
        ADDITIONAL_HEIGHT_DP = r0;
    }

    public static final /* synthetic */ void access$setARROW_PADDING_DP$cp(int r0) {
        ARROW_PADDING_DP = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_DOUBLE_DP$cp(int r0) {
        CORNER_RADIUS_DOUBLE_DP = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_DP$cp(int r0) {
        CORNER_RADIUS_DP = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_SINGLE_DP$cp(int r0) {
        CORNER_RADIUS_SINGLE_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_HEIGHT_DP$cp(int r0) {
        DEFAULT_HEIGHT_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_PADDING_DP$cp(int r0) {
        DEFAULT_PADDING_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_WIDTH_DP$cp(int r0) {
        DEFAULT_WIDTH_DP = r0;
    }

    public static final /* synthetic */ void access$setMAX_WIDTH_DP$cp(int r0) {
        MAX_WIDTH_DP = r0;
    }

    public static final /* synthetic */ void access$setMIN_ARROW_DISTANCE_DP$cp(int r0) {
        MIN_ARROW_DISTANCE_DP = r0;
    }

    static {
        Companion = new Companion(null);
        ARROW_PADDING_DP = 7;
        CORNER_RADIUS_DP = 28;
        CORNER_RADIUS_SINGLE_DP = 99;
        CORNER_RADIUS_DOUBLE_DP = 12;
        MIN_ARROW_DISTANCE_DP = 18;
        DEFAULT_WIDTH_DP = 40;
        DEFAULT_HEIGHT_DP = 36;
        ADDITIONAL_HEIGHT_DP = 20;
        DEFAULT_PADDING_DP = 12;
        MAX_WIDTH_DP = 276;
    }

    public final String getMSubTitle() {
        return this.mSubTitle;
    }

    public final void setMSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSubTitle = r2;
    }

    public final int getMPadding() {
        return this.mPadding;
    }

    public final void setMPadding(int r1) {
        this.mPadding = r1;
    }

    public final float getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(float r1) {
        this.mWidth = r1;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    public final void setMHeight(float r1) {
        this.mHeight = r1;
    }

    public final void setMBgColor(int r1) {
        this.mBgColor = r1;
    }

    public final int getMBgColor() {
        int r0 = this.pressStateColor;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.mBgColor;
    }

    public final boolean getMNeedShadow() {
        return this.mNeedShadow;
    }

    public final void setMNeedShadow(boolean r1) {
        this.mNeedShadow = r1;
    }

    public final boolean getMNeedArrow() {
        return this.mNeedArrow;
    }

    public final void setMNeedArrow(boolean r1) {
        this.mNeedArrow = r1;
    }

    public final boolean getUseDefaultView() {
        return this.useDefaultView;
    }

    public final void setUseDefaultView(boolean r1) {
        this.useDefaultView = r1;
    }

    public final int getMAdjustHeight() {
        return this.mAdjustHeight;
    }

    public final void setMAdjustHeight(int r1) {
        this.mAdjustHeight = r1;
    }

    public OPopoverLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public OPopoverLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OPopoverLayout(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.mSubTitle = "";
        this.shadowConfig = new ShadowConfig(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedArrow = true;
        this.useDefaultView = true;
        this.tempRectPath = new Path();
        this.tempArrowPath = new Path();
        init(r8, r9);
    }

    public final void init(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        OPopoverLayout r6 = this;
        this.arrowPadding = OUnitExtensionKt.vdp(r6, ARROW_PADDING_DP);
        this.minArrowDistance = OUnitExtensionKt.vdpFloat(r6, MIN_ARROW_DISTANCE_DP);
        this.defaultWidth = OUnitExtensionKt.vdp(r6, DEFAULT_WIDTH_DP);
        this.defaultHeight = OUnitExtensionKt.vdp(r6, DEFAULT_HEIGHT_DP);
        this.additionalHeight = OUnitExtensionKt.vdp(r6, ADDITIONAL_HEIGHT_DP);
        this.mPadding = OUnitExtensionKt.vdp(r6, DEFAULT_PADDING_DP);
        this.maxWidth = OUnitExtensionKt.vdp(r6, MAX_WIDTH_DP);
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        Paint r7 = this.mFillPaint;
        Paint r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r7 = null;
    L5:
        r7.setStyle(Paint.Style.FILL);
        Paint r8 = this.mFillPaint;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r8 = null;
    L8:
        r8.setStrokeCap(Paint.Cap.BUTT);
        Paint r9 = this.mFillPaint;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r9 = null;
    L11:
        r9.setAntiAlias(true);
        Paint r10 = this.mFillPaint;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L14:
        r10.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.mBgColor = ContextCompat.getColor(r4, R.color.SDPrimary);
    L17:
        Paint r11 = this.mFillPaint;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r0.setColor(getMBgColor());
        renderBubbleLegPrototype();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L20:
        r0 = r11;
        goto L21
    }

    public final void setCornerRadiusDp(int r2) {
        this.mCornerRadius = OUnitExtensionKt.vdpFloat(this, r2);
    }

    public final void setCornerRadius(float r1) {
        this.mCornerRadius = r1;
    }

    public final float getCornerRadius() {
        return this.mCornerRadius;
    }

    public final void setSubText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.mSubTitle = r2;
    }

    public final void setBorderColor(int r1) {
        this.borderColor = r1;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.borderWidth = r4;
        if (this.strokePaint != null) goto L7;
        this.strokePaint = new Paint();
    L7:
        Paint r5 = this.strokePaint;
        if (r5 == null) goto L11;
        r5.setStyle(Paint.Style.STROKE);
    L11:
        Paint r6 = this.strokePaint;
        if (r6 == null) goto L15;
        r6.setStrokeWidth(this.borderWidth);
    L15:
        Paint r7 = this.strokePaint;
        if (r7 == null) goto L19;
        r7.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r8 = this.strokePaint;
        if (r8 == null) goto L23;
        r8.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r9 = this.strokePaint;
        if (r9 == null) goto L27;
        r9.setAntiAlias(true);
    L27:
        Paint r10 = this.strokePaint;
        if (r10 == null) goto L31;
        r10.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r11 = this.strokePaint;
        if (r11 == null) goto L35;
        r11.setColor(this.borderColor);
    L35:
        Paint r12 = this.mFillPaint;
        Paint r0 = null;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L38:
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r13 = this.mFillPaint;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r0.setStrokeWidth(this.borderWidth);
        return;
    L41:
        r0 = r13;
        goto L42
    }

    public final void setTransparentBg(boolean r1) {
        if (r1 == false) goto L5;
        this.mBgColor = 0;
        return;
    }

    private final void renderBubbleLegPrototype() {
        Path r0 = this.mBubbleArrowPath;
        Path r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r0 = null;
    L5:
        r0.moveTo(0.0f, 0.0f);
        float r2 = this.arrowPadding / 7.0f;
        Path r5 = this.mBubbleArrowPath;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r6 = null;
    L9:
        float r13 = r2 * 0.0f;
        float r3 = r2 * 7.0f;
        r6.cubicTo(r13, r2 * (-2.5f), r3, r2 * (-4.0f), r3, r2 * (-10.0f));
        Path r4 = this.mBubbleArrowPath;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r4 = null;
    L12:
        r4.lineTo(r3, 10.0f * r2);
        Path r7 = this.mBubbleArrowPath;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r8 = null;
    L16:
        r8.cubicTo(r3, r2 * 4.0f, r13, r2 * 2.5f, r13, r13);
        Path r14 = this.mBubbleArrowPath;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L20:
        r1.close();
        return;
    L19:
        r1 = r14;
        goto L20
    L15:
        r8 = r7;
        goto L16
    L8:
        r6 = r5;
        goto L9
    }

    public final void setBubbleParams(int r1, float r2) {
        this.mBubbleArrowOffset = r2;
        this.mBubbleOrientation = r1;
    }

    public final void setBubbleOrientation(int r1) {
        this.mBubbleOrientation = r1;
    }

    public final Matrix calculateBubbleArrowMatrix(float r9, float r10) {
        float r0 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance + this.arrowPadding);
        Matrix r1 = new Matrix();
        int r2 = this.borderWidth;
        int r3 = r2 / 2;
        int r4 = this.mBubbleOrientation;
        if (r4 != 0) goto L5;
        float r11 = Math.min(r0, (r9 - this.arrowPadding) - this.minArrowDistance);
        float r12 = this.borderWidth;
        r1.postRotate(90.0f);
        setPadding(0, r3, 0, 0);
    L15:
        setGravity(17);
        int r5 = this.arrowPadding;
        int r6 = this.borderWidth;
        this.mRoundRect = new RectF(r5 + (r6 / 2), r5 + (r6 / 2), (this.mWidth - r5) - r6, (this.mHeight - r5) - r6);
        r1.postTranslate(r11, r12);
        Path r13 = this.mPath;
        Path r7 = null;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r13 = null;
    L18:
        r13.reset();
        this.tempRectPath.reset();
        SmoothCornerH r14 = SmoothCornerH.INSTANCE;
        Path r8 = this.tempRectPath;
        RectF r15 = this.mRoundRect;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r15 = null;
    L21:
        r14.addRoundRect(r8, r15, this.mCornerRadius);
        if (this.mNeedArrow == false) goto L27;
        this.tempArrowPath.reset();
        Path r16 = this.tempArrowPath;
        Path r17 = this.mBubbleArrowPath;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r17 = null;
    L26:
        r16.addPath(r17, r1);
        this.tempRectPath.op(this.tempArrowPath, Path.Op.UNION);
    L27:
        Path r18 = this.mPath;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L31:
        r7.addPath(this.tempRectPath);
        return r1;
    L30:
        r7 = r18;
        goto L31
    L5:
        if (r4 != 1) goto L7;
        r11 = r2;
        r12 = Math.min(r0, (r10 - this.arrowPadding) - this.minArrowDistance);
        setPadding(r3, 0, 0, 0);
        goto L15
    L7:
        if (r4 != 2) goto L9;
        r11 = r9 - r2;
        r12 = Math.min(r0, (r10 - this.arrowPadding) - this.minArrowDistance);
        r1.postRotate(180.0f);
        setPadding(0, 0, r3, 0);
        goto L15
    L9:
        if (r4 == 3) goto L11;
        r11 = 0.0f;
        r12 = 0.0f;
        goto L15
    L11:
        r11 = Math.min(r0, (r9 - this.arrowPadding) - this.minArrowDistance);
        r12 = r10 - this.borderWidth;
        r1.postRotate(270.0f);
        setPadding(0, 0, 0, r3);
        goto L15
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance);
        int r1 = this.mBubbleOrientation;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    L18:
        return Math.min(r0, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L19:
        return Math.min(r0, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L15:
        return Math.min(r0, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        int r0 = 0;
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        TextView r2 = (TextView) r1;
    L10:
        int r3 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r4 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        if (r2 == null) goto L17;
        int r5 = measureTextViewWidth(r2);
        int r6 = this.maxWidth;
        if (r5 > r6) goto L16;
        r6 = measureTextViewWidth(r2);
    L16:
        int r7 = (r6 + r2.getPaddingLeft()) + r2.getPaddingRight();
    L19:
        if (this.useDefaultView == false) goto L28;
        int r12 = this.defaultWidth;
        if (r7 <= r12) goto L23;
        r12 = (this.mPadding * 2) + r7;
    L23:
        int r13 = this.arrowPadding;
        int r14 = this.borderWidth;
        int r15 = (r12 + (r13 * 2)) + (r14 * 2);
        int r16 = (this.defaultHeight + (r13 * 2)) + (r14 * 2);
        if (Intrinsics.areEqual(this.mSubTitle, "") == true) goto L27;
        r0 = this.additionalHeight;
    L27:
        int r17 = r16 + r0;
    L30:
        if (r3 != Integer.MIN_VALUE) goto L33;
        if (r4 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r15, r17);
    L38:
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        return;
    L33:
        if (r3 != Integer.MIN_VALUE) goto L35;
        setMeasuredDimension(r15, r11);
        goto L38
    L35:
        if (r4 != Integer.MIN_VALUE) goto L37;
        setMeasuredDimension(r10, r17);
        goto L38
    L37:
        setMeasuredDimension(r10, r11);
        goto L38
    L28:
        PopupWindow r18 = new PopupWindow(getChildAt(0), -2, -2, true);
        r18.getContentView().measure(0, 0);
        r15 = (this.arrowPadding * 2) + r18.getContentView().getMeasuredWidth();
        r17 = r18.getContentView().getMeasuredHeight() + (this.arrowPadding * 2);
        goto L30
    L17:
        r7 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r2 = null;
        goto L10
    }

    private final int measureTextViewWidth(TextView r8) {
        String r7 = r8.getText().toString();
        TextPaint r9 = r8.getPaint();
        if (r9 == null) goto L16;
        String r0 = r7;
        int r6 = 0;
        if (StringsKt.contains$default(r0, "\n", false, 2, null) == false) goto L7;
        Iterator r10 = StringsKt.split$default(r0, new String[]{"\n"}, false, 0, 6, null).iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        int r1 = (int) r9.measureText((String) r10.next());
        if (r1 <= r6) goto L10;
        r6 = r1;
        goto L10
    L14:
        return r6;
    L7:
        return (int) r9.measureText(r7);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.text.TextPaint");
    }

    @Override // android.view.View
    protected void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        if (r5 <= 0) goto L17;
        if (r6 <= 0) goto L18;
        Bitmap r0 = this.mBitmap;
        if (r0 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r0.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Bitmap r1 = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(r1);
        this.mBitmap = r1;
        L.w(TAG, "onSizeChanged, init new bg, w: " + r5 + ", h: " + r6 + ", oldw: " + r7 + ", oldh: " + r8);
        return;
    L14:
        if (r0.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.mBitmap != null) goto L5;
        this.mBitmap = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r1 = this.mBitmap;
        Intrinsics.checkNotNull(r1);
        this.mCanvas = new Canvas(r1);
    L5:
        Paint r0 = this.mFillPaint;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L8:
        r0.setColor(getMBgColor());
        calculateBubbleArrowMatrix(this.mWidth, this.mHeight);
        if (this.mNeedShadow == false) goto L14;
        Paint r2 = this.mFillPaint;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r2 = null;
    L13:
        r2.setShadowLayer(this.shadowConfig.getRadius(), this.shadowConfig.getDx(), this.shadowConfig.getDy(), this.shadowConfig.getColor());
    L14:
        Canvas r3 = this.mCanvas;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r3 = null;
    L17:
        Path r4 = this.mPath;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r4 = null;
    L20:
        Paint r6 = this.mFillPaint;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r6 = null;
    L23:
        r3.drawPath(r4, r6);
        if (this.strokePaint == null) goto L35;
        if (this.borderWidth <= 0) goto L35;
        Canvas r5 = this.mCanvas;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r5 = null;
    L30:
        Path r7 = this.mPath;
        if (r7 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r7 = null;
    L33:
        Paint r9 = this.strokePaint;
        Intrinsics.checkNotNull(r9);
        r5.drawPath(r7, r9);
    L35:
        if (this.mArrowPressedPaint == null) goto L40;
        Canvas r10 = this.mCanvas;
        if (r10 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r10 = null;
    L39:
        Path r11 = this.tempArrowPath;
        Paint r12 = this.mArrowPressedPaint;
        Intrinsics.checkNotNull(r12);
        r10.drawPath(r11, r12);
    L40:
        Bitmap r13 = this.mBitmap;
        Intrinsics.checkNotNull(r13);
        r8.drawBitmap(r13, 0.0f, 0.0f, null);
    }

    public final void notifyPressed(boolean r2, int r3) {
        if (r2 == true) goto L4;
        Paint r1 = this.mArrowPressedPaint;
        if (r1 == null) goto L28;
        r1.setColor(0);
        return;
    L28:
        return;
    L4:
        if (this.mArrowPressedPaint != null) goto L17;
        Paint r4 = new Paint();
        this.mArrowPressedPaint = r4;
        r4.setStyle(Paint.Style.FILL);
        Paint r5 = this.mArrowPressedPaint;
        if (r5 == null) goto L9;
        r5.setStrokeCap(Paint.Cap.BUTT);
    L9:
        Paint r6 = this.mArrowPressedPaint;
        if (r6 == null) goto L13;
        r6.setStrokeJoin(Paint.Join.MITER);
    L13:
        Paint r7 = this.mArrowPressedPaint;
        if (r7 == null) goto L17;
        r7.setAntiAlias(true);
    L17:
        Paint r8 = this.mArrowPressedPaint;
        if (r8 == null) goto L27;
        r8.setColor(r3);
        return;
    }

    public final int arrowDirection() {
        return this.mBubbleOrientation;
    }

    public final int getPadding() {
        return this.arrowPadding / 2;
    }

    public final int getArrowHeight() {
        return this.arrowPadding;
    }

    public final Path getFullPath() {
        Path r0 = this.mPath;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r0;
    }

    public final ShadowConfig getShadowConfig() {
        return this.shadowConfig;
    }
}
