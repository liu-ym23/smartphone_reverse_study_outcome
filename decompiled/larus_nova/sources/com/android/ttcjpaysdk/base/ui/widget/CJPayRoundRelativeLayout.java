package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00142\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayRoundRelativeLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerRadii", "", "mHeight", "", "mLastRadius", "mPath", "Landroid/graphics/Path;", "mRadius", "mRoundMode", "", "mWidth", "checkPathChanged", "", "draw", "canvas", "Landroid/graphics/Canvas;", "init", "setCornerRadius", "radius", "setRoundMode", "roundMode", "updateCornerRadii", "radii", "Mode", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRoundRelativeLayout extends RelativeLayout {
    private float[] cornerRadii;
    private int mHeight;
    private int mLastRadius;
    private Path mPath;
    private int mRadius;
    private String mRoundMode;
    private int mWidth;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayRoundRelativeLayout$Mode;", "", "mode", "", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getMode", "MODE_NONE", "MODE_CUSTOM", "MODE_ALL", "MODE_LEFT", "MODE_TOP", "MODE_RIGHT", "MODE_BOTTOM", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode MODE_ALL = null;
        public static final Mode MODE_BOTTOM = null;
        public static final Mode MODE_CUSTOM = null;
        public static final Mode MODE_LEFT = null;
        public static final Mode MODE_NONE = null;
        public static final Mode MODE_RIGHT = null;
        public static final Mode MODE_TOP = null;
        private final String desc;
        private final String mode;

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{MODE_NONE, MODE_CUSTOM, MODE_ALL, MODE_LEFT, MODE_TOP, MODE_RIGHT, MODE_BOTTOM};
        }

        public static Mode valueOf(String r100) {
            return (Mode) a.a(Mode.class, r100);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            MODE_NONE = new Mode("MODE_NONE", 0, "none", "无圆角");
            MODE_CUSTOM = new Mode("MODE_CUSTOM", 1, "custom", "自定义");
            MODE_ALL = new Mode("MODE_ALL", 2, "all", "四个圆角");
            MODE_LEFT = new Mode("MODE_LEFT", 3, "left", "左边两个圆角");
            MODE_TOP = new Mode("MODE_TOP", 4, "top", "上面两个圆角");
            MODE_RIGHT = new Mode("MODE_RIGHT", 5, "right", "右边两个圆角");
            MODE_BOTTOM = new Mode("MODE_BOTTOM", 6, "bottom", "下面两个圆角");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getMode() {
            return this.mode;
        }

        private Mode(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.mode = r102;
            this.desc = r103;
        }
    }

    private final void checkPathChanged() {
        if (getWidth() == this.mWidth) goto L5;
    L9:
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.mLastRadius = this.mRadius;
        Path r100 = this.mPath;
        if (r100 == null) goto L12;
        r100.reset();
    L12:
        RectF r101 = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
        Path.Direction r102 = Path.Direction.CW;
        String r103 = this.mRoundMode;
        if (Intrinsics.areEqual(r103, Mode.MODE_ALL.getMode()) == false) goto L18;
        Path r104 = this.mPath;
        if (r104 == null) goto L45;
        int r105 = this.mRadius;
        r104.addRoundRect(r101, r105, r105, r102);
        return;
    L45:
        return;
    L18:
        if (Intrinsics.areEqual(r103, Mode.MODE_LEFT.getMode()) == false) goto L23;
        Path r106 = this.mPath;
        if (r106 == null) goto L47;
        int r110 = this.mRadius;
        r106.addRoundRect(r101, new float[]{r110, r110, 0.0f, 0.0f, 0.0f, 0.0f, r110, r110}, r102);
        return;
    L47:
        return;
    L23:
        if (Intrinsics.areEqual(r103, Mode.MODE_TOP.getMode()) == false) goto L28;
        Path r107 = this.mPath;
        if (r107 == null) goto L49;
        int r111 = this.mRadius;
        r107.addRoundRect(r101, new float[]{r111, r111, r111, r111, 0.0f, 0.0f, 0.0f, 0.0f}, r102);
        return;
    L49:
        return;
    L28:
        if (Intrinsics.areEqual(r103, Mode.MODE_RIGHT.getMode()) == false) goto L33;
        Path r108 = this.mPath;
        if (r108 == null) goto L51;
        int r112 = this.mRadius;
        r108.addRoundRect(r101, new float[]{0.0f, 0.0f, r112, r112, r112, r112, 0.0f, 0.0f}, r102);
        return;
    L51:
        return;
    L33:
        if (Intrinsics.areEqual(r103, Mode.MODE_BOTTOM.getMode()) == false) goto L38;
        Path r109 = this.mPath;
        if (r109 == null) goto L53;
        int r113 = this.mRadius;
        r109.addRoundRect(r101, new float[]{0.0f, 0.0f, 0.0f, 0.0f, r113, r113, r113, r113}, r102);
        return;
    L53:
        return;
    L38:
        if (Intrinsics.areEqual(r103, Mode.MODE_CUSTOM.getMode()) == false) goto L55;
        float[] r114 = this.cornerRadii;
        if (r114 == null) goto L56;
        Path r115 = this.mPath;
        if (r115 == null) goto L57;
        r115.addRoundRect(r101, r114, r102);
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L5:
        if (getHeight() != this.mHeight) goto L9;
        if (this.mLastRadius != this.mRadius) goto L9;
    }

    public CJPayRoundRelativeLayout(Context r100) {
        super(r100);
        this.mRoundMode = Mode.MODE_ALL.getMode();
        init(r100, null);
    }

    private final void setCornerRadius(int r100) {
        if (r100 < 0) goto L5;
        this.mRadius = r100;
        return;
    }

    private final void setRoundMode(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L14;
        this.mRoundMode = r100;
        return;
    L14:
        return;
    L6:
        r101 = false;
        goto L7
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (Intrinsics.areEqual(this.mRoundMode, Mode.MODE_NONE.getMode()) == true) goto L8;
        int r101 = r100.save();
        checkPathChanged();
        Path r102 = this.mPath;
        if (r102 == null) goto L7;
        r100.clipPath(r102);
    L7:
        super.draw(r100);
        r100.restoreToCount(r101);
        return;
    L8:
        super.draw(r100);
    }

    public final void updateCornerRadii(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "radii");
        this.cornerRadii = r100;
        postInvalidate();
    }

    public CJPayRoundRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mRoundMode = Mode.MODE_ALL.getMode();
        init(r100, r101);
    }

    private final void init(Context r100, AttributeSet r101) {
        Path r102 = new Path();
        r102.setFillType(Path.FillType.EVEN_ODD);
        this.mPath = r102;
        if (r100 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.radius, R.attr.roundMode});
    L6:
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.getIndexCount();
    L10:
        if (r105 < 0) goto L20;
    L11:
        if (r103 == null) goto L18;
        int r106 = r103.getIndex(r104);
        if (r106 != 0) goto L16;
        setCornerRadius((int) r103.getDimension(r106, CJPayBasicExtensionKt.dip2pxF(0.0f, r100)));
        goto L18
    L16:
        if (r106 != 1) goto L18;
        setRoundMode(r103.getString(r106));
    L18:
        if (r104 == r105) goto L22;
        r104 = r104 + 1;
        goto L11
    L22:
        return;
    L20:
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
