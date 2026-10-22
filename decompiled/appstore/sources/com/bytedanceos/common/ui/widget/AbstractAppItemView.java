package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Trace;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.glide.GlideRoundTransform;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractAppItemView extends RelativeLayout {
    private static Bitmap BITMAP_DEFAULT_ICON = null;
    private static Bitmap BITMAP_LINE = null;
    private static Bitmap BITMAP_NUMBER = null;
    private static Bitmap BITMAP_SOURCE = null;
    private static final int CONSTANT_RGB = 255;
    private static final int CONSTANT_RGB15 = 15;
    private static final int CONSTANT_RGB17 = 17;
    private static final float CONSTANT_TEXTSIZE = 32.0f;
    private static final float INITIAL_RATIO = 0.7f;
    private static final float INITIAL_REST_RATIO = 0.3f;
    private static final int OFFSET_RIGHT = 15;
    private static final float OFFSET_Y = 10.0f;
    private static AppItemViewCoordinates.Cache mCache;
    protected AppInfo mAppInfo;
    protected OUIAppStatusView mAppStatusView;
    private int mAppStatusViewRightMargin;
    private AppItemViewCoordinates.Config mConfig;
    private AppItemViewCoordinates mCoordinates;
    private Bitmap mIconBitmap;
    private Paint mIconPaint;
    private Rect mIconRect;
    private int mLineLeftMargin;
    private Rect mLineRect;
    private int mLineRightMargin;
    private int mNameRlMargin;
    private Object mNumber;
    private View.OnClickListener mOnBtnClickListener;
    private View.OnClickListener mOnItemClickListener;
    private int mPosition;
    private float mRatio;
    private boolean mRetryBindIcon;
    private GlideRoundTransform[] mRoundTransform;
    private Target<Bitmap> mTarget;
    private int mWidth;
    private TextPaint sPaint;

    public static class BitmapTarget implements Target<Bitmap> {
        private AbstractAppItemView appItemView;
        Request mRequest;

        public BitmapTarget(AbstractAppItemView r10) {
            this.appItemView = r10;
        }

        @Override // com.bumptech.glide.request.target.Target
        @Nullable
        public Request getRequest() {
            return this.mRequest;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback r10) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable r10) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable r10) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable r10) {
            AbstractAppItemView r11 = this.appItemView;
            if (r11 == null) goto L6;
            AbstractAppItemView.access$002(r11, null);
            this.appItemView.invalidate();
            return;
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Bitmap r10, @Nullable Transition<? super Bitmap> r11) {
            onResourceReady2(r10, r11);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback r10) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(@Nullable Request r10) {
            this.mRequest = r10;
        }

        /* JADX INFO: renamed from: onResourceReady, reason: avoid collision after fix types in other method */
        public void onResourceReady2(@NonNull Bitmap r10, @Nullable Transition<? super Bitmap> r11) {
            AbstractAppItemView.access$002(this.appItemView, r10);
            this.appItemView.invalidate();
        }
    }

    static {
        mCache = AppItemViewCoordinates.Cache.getInstance();
    }

    public AbstractAppItemView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ Bitmap access$002(AbstractAppItemView r10, Bitmap r11) {
        r10.mIconBitmap = r11;
        return r11;
    }

    public static void clearCache() {
        mCache.clear();
    }

    private Bitmap getBitmap(int r10) {
        Bitmap r11 = mCache.getBitmap(r10);
        if (r11 != null) goto L6;
        Bitmap r12 = BitmapFactory.decodeResource(getContext().getResources(), r10);
        mCache.putBitmap(r10, r12);
        return r12;
    L6:
        return r11;
    }

    private Bitmap getBitmapDefaultIcon() {
        Bitmap r10 = BITMAP_DEFAULT_ICON;
        if (r10 != null) goto L5;
    L6:
        BITMAP_DEFAULT_ICON = getBitmap(R$drawable.oui_default_app_icon);
    L8:
        return BITMAP_DEFAULT_ICON;
    L5:
        if (r10.isRecycled() == false) goto L8;
        goto L6
    }

    private Bitmap getBitmapLine() {
        Bitmap r10 = BITMAP_LINE;
        if (r10 != null) goto L5;
    L6:
        int r11 = R$drawable.line;
        AppItemViewCoordinates r12 = this.mCoordinates;
        int r13 = 0;
        if (r12 == null) goto L9;
        int r14 = r12.lineWidth;
    L10:
        if (r12 == null) goto L12;
        r13 = r12.lineHeight;
    L12:
        BITMAP_LINE = getNinePatchBitmap(r11, r14, r13);
    L14:
        return BITMAP_LINE;
    L9:
        r14 = 0;
        goto L10
    L5:
        if (r10.isRecycled() == false) goto L14;
        goto L6
    }

    private Bitmap getBitmapNumber() {
        Bitmap r10 = BITMAP_NUMBER;
        if (r10 != null) goto L5;
    L6:
        int r11 = R$drawable.circle_num;
        AppItemViewCoordinates r12 = this.mCoordinates;
        int r13 = 0;
        if (r12 == null) goto L9;
        int r14 = r12.numberWidth;
    L10:
        if (r12 == null) goto L12;
        r13 = r12.numberHeight;
    L12:
        BITMAP_NUMBER = getNinePatchBitmap(r11, r14, r13);
    L14:
        return BITMAP_NUMBER;
    L9:
        r14 = 0;
        goto L10
    L5:
        if (r10.isRecycled() == false) goto L14;
        goto L6
    }

    private Bitmap getBitmapSource() {
        Bitmap r10 = BITMAP_SOURCE;
        if (r10 != null) goto L5;
    L6:
        BITMAP_SOURCE = getBitmap(R$drawable.list_yyb);
    L8:
        return BITMAP_SOURCE;
    L5:
        if (r10.isRecycled() == false) goto L8;
        goto L6
    }

    private int getColor(int r10) {
        return getContext().getResources().getColor(r10);
    }

    private String getEllipsizeText(String r10, float r11) {
        if (r10 != null) goto L5;
        return "";
    L5:
        float r12 = this.sPaint.getTextSize();
        String r13 = mCache.getEllipsize(r10, r12, r11);
        if (TextUtils.isEmpty(r13) == false) goto L9;
        String r14 = TextUtils.ellipsize(r10, this.sPaint, r11, TextUtils.TruncateAt.END).toString();
        mCache.putEllipsize(r14, r12, r11);
        return r14;
    L9:
        return r13;
    }

    private float getMaxCategoryWidth(float r13, float r14) {
        float r10 = AppItemViewCoordinates.MAX_CATEGORY_WIDTH;
        float r11 = AppItemViewCoordinates.LABEL_INTERVAL;
        if (r13 <= 0.0f) goto L6;
        r10 = (float) (((double) r10) - ((((double) r13) + 0.5d) - ((double) r11)));
    L6:
        if (r14 <= 0.0f) goto L9;
        r10 = (float) (((double) r10) - ((((double) r14) + 0.5d) - ((double) r11)));
    L9:
        if (getNumber() != null) goto L11;
        return r10;
    L11:
        return r10 - (AppItemViewCoordinates.NUM_MARGIN_LEFT + AppItemViewCoordinates.NUM_MAX_LENGTH);
    }

    private Bitmap getNinePatchBitmap(int r10, int r11, int r12) {
        Bitmap r13 = mCache.getBitmap(r10);
        if (r13 == null) goto L5;
        return r13;
    L5:
        NinePatchDrawable r14 = (NinePatchDrawable) getContext().getResources().getDrawable(r10);
        if (r11 == 0) goto L9;
        if (r12 == 0) goto L9;
    L11:
        if (r14.getOpacity() == (-1)) goto L13;
        Bitmap.Config r15 = Bitmap.Config.ARGB_8888;
    L14:
        Bitmap r16 = Bitmap.createBitmap(r11, r12, r15);
        Canvas r17 = new Canvas(r16);
        r14.setBounds(0, 0, r11, r12);
        r14.draw(r17);
        mCache.putBitmap(r10, r16);
        return r16;
    L13:
        r15 = Bitmap.Config.ARGB_8888;
    L9:
        r11 = r14.getIntrinsicWidth();
        r12 = r14.getIntrinsicHeight();
        goto L11
    }

    private String getString(int r10) {
        return getContext().getResources().getString(r10);
    }

    private void initAppStatus() {
        if (this.mAppStatusView == null) goto L5;
        return;
    L5:
        if (this.mCoordinates == null) goto L12;
        OUIAppStatusView r10 = new OUIAppStatusView(BaseApplication.c());
        this.mAppStatusView = r10;
        r10.setId(this.mCoordinates.statusViewId);
        this.mAppStatusView.showAppSize();
        AppItemViewCoordinates r11 = this.mCoordinates;
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(r11.statusWidth, r11.statusHeight);
        r12.addRule(11);
        if (BaseApplication.c().f9554j == false) goto L9;
        r12.topMargin = AppItemViewCoordinates.APP_STATUS_VIEW_TOP_MARGIN_BIG_FOUNT;
    L9:
        addView(this.mAppStatusView, r12);
        return;
    }

    private void initBitmaps() {
        AppItemViewCoordinates.Config r10 = this.mConfig;
        if (r10 != null) goto L5;
    L7:
        AppItemViewCoordinates.Config r11 = this.mConfig;
        if (r11 != null) goto L10;
    L12:
        AppItemViewCoordinates.Config r12 = this.mConfig;
        if (r12 != null) goto L15;
    L17:
        getBitmapDefaultIcon();
        return;
    L15:
        if (r12.hasSource() == false) goto L17;
        getBitmapSource();
        goto L17
    L10:
        if (r11.hasNumber() == false) goto L12;
        getBitmapNumber();
        goto L12
    L5:
        if (r10.hasLine() == false) goto L7;
        getBitmapLine();
        goto L7
    }

    private void initCoordinates() {
        this.mCoordinates = AppItemViewCoordinates.forConfig(getContext(), this.mConfig, mCache);
    }

    public static void traceBeginSection(String r10) {
        Trace.beginSection(r10);
    }

    public static void traceEndSection() {
        Trace.endSection();
    }

    private void updateItemWidth(int r10) {
        this.mWidth = r10;
        this.mConfig.setWidth(r10);
    }

    public void addLeftMarginForLine() {
        this.mLineLeftMargin = AppItemViewCoordinates.MARGIN_HORIZONTAL;
        invalidate();
    }

    public void addNameRlMargin() {
        this.mNameRlMargin = AppItemViewCoordinates.MARGIN_HORIZONTAL;
        invalidate();
    }

    public void addRightMarginForAppStatusView() {
        OUIAppStatusView r10 = this.mAppStatusView;
        if (r10 == null) goto L8;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r12 = r11.rightMargin;
        int r13 = AppItemViewCoordinates.MARGIN_HORIZONTAL;
        if (r12 == r13) goto L9;
        this.mAppStatusViewRightMargin = r13;
        r11.rightMargin = r13;
        this.mAppStatusView.setLayoutParams(r11);
        return;
    L9:
        return;
    }

    public void addRightMarginForLine() {
        this.mLineRightMargin = AppItemViewCoordinates.MARGIN_HORIZONTAL;
        invalidate();
    }

    public void bindAppStatus() {
        OUIAppStatusView r10 = this.mAppStatusView;
        if (r10 == null) goto L10;
        AppInfo r11 = this.mAppInfo;
        if (r11 == null) goto L11;
        r10.updateDownloadStatus(r11);
        this.mAppStatusView.setTag(this.mAppInfo);
        this.mAppStatusView.setTag(R$id.page_button_pos, Integer.valueOf(this.mPosition));
        this.mAppStatusView.setTag(R$id.appinfo, this.mAppInfo);
        this.mAppStatusView.setTag(R$id.app_row_index, Integer.valueOf(this.mPosition));
        View.OnClickListener r12 = this.mOnBtnClickListener;
        if (r12 == null) goto L12;
        this.mAppStatusView.setOnClickListener(r12);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void bindData(AppInfo r10) {
        updateItemView(r10);
    }

    public void bindIcon() {
        if (this.mAppInfo != null) goto L5;
        return;
    L5:
        if (this.mCoordinates != null) goto L7;
        return;
    L7:
        if (this.mTarget != null) goto L9;
        this.mTarget = new BitmapTarget(this);
    L9:
        Context r10 = getContext();
        AppInfo r11 = this.mAppInfo;
        String r12 = r11.appIcon;
        AppItemViewCoordinates r13 = this.mCoordinates;
        int r14 = r13.iconWidth;
        int r15 = r13.iconHeight;
        if (e.F0(r11) == false) goto L13;
        GlideRoundTransform[] r16 = null;
    L12:
        GlideRoundTransform[] r17 = r16;
        this.mTarget = com.bytedanceos.common.toolbox.glide.b.f(r10, r12, 0, r14, r15, r17, this.mTarget);
        return;
    L13:
        r16 = this.mRoundTransform;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r14) {
        super.dispatchDraw(r14);
        if (this.mAppInfo != null) goto L7;
        j.b("mAppInfo == null, do not draw");
        return;
    L7:
        if (this.mConfig.hasNumber() == false) goto L11;
        String r10 = String.valueOf(getNumber());
        if (TextUtils.isEmpty(r10) == true) goto L11;
        traceBeginSection("AAIV.drawNumber");
        r14.save();
        this.sPaint.setColor(this.mCoordinates.numberTextColor);
        this.sPaint.setTextSize(this.mCoordinates.numberTextSize);
        this.sPaint.setTypeface(this.mCoordinates.numberTypeface);
        float r11 = this.mCoordinates.numberX + ((getBitmapNumber().getWidth() - this.sPaint.measureText(r10)) / 2.0f);
        Bitmap r12 = getBitmapNumber();
        AppItemViewCoordinates r13 = this.mCoordinates;
        r14.drawBitmap(r12, r13.numberX, r13.numberY, null);
        AppItemViewCoordinates r15 = this.mCoordinates;
        r14.drawText(r10, r11, r15.numberY + r15.numberBaseline, this.sPaint);
        r14.restore();
        traceEndSection();
    L11:
        traceBeginSection("AAIV.drawIcon");
        r14.save();
        float r16 = 0.0f;
        r14.translate(0.0f, OFFSET_Y);
        Rect r17 = this.mIconRect;
        AppItemViewCoordinates r18 = this.mCoordinates;
        int r19 = r18.iconX;
        int r20 = r18.iconY;
        r17.set(r19, r20 - 10, r18.iconWidth + r19, (r20 + r18.iconHeight) - 10);
        Bitmap r21 = this.mIconBitmap;
        int r22 = 0;
        if (r21 != null) goto L14;
    L18:
        this.mRetryBindIcon = false;
        Bitmap r23 = this.mIconBitmap;
        if (r23 != null) goto L21;
    L23:
        Bitmap r24 = getBitmapDefaultIcon();
    L24:
        r14.drawBitmap(r24, null, this.mIconRect, this.mIconPaint);
    L25:
        r14.restore();
        traceEndSection();
        traceBeginSection("AAIV.drawName");
        if (TextUtils.isEmpty(this.mAppInfo.appName) == true) goto L29;
        r14.save();
        this.sPaint.setColor(this.mCoordinates.nameTextColor);
        this.sPaint.setAlpha((int) (this.mRatio * 255.0f));
        this.sPaint.setTextSize(this.mCoordinates.nameTextSize);
        this.sPaint.setTypeface(this.mCoordinates.nameTypeface);
        String r25 = getEllipsizeText(this.mAppInfo.appName, (this.mCoordinates.nameMaxWidth - this.mAppStatusViewRightMargin) - this.mNameRlMargin);
        AppItemViewCoordinates r26 = this.mCoordinates;
        r14.drawText(r25, r26.nameX, r26.nameY + r26.nameBaseline, this.sPaint);
        r14.restore();
        traceEndSection();
        setContentDescription(this.mAppInfo.appName);
    L29:
        if (this.mConfig.hasRate() == false) goto L35;
        traceBeginSection("AAIV.drawRate");
        r14.save();
        int r27 = mCache.getRateResId(this.mAppInfo.appScores);
        if (r27 != 0) goto L33;
        r27 = e.b0(getContext(), this.mAppInfo.appScores, false);
        mCache.putRate(this.mAppInfo.appScores, r27);
    L33:
        Bitmap r28 = getBitmap(r27);
        AppItemViewCoordinates r29 = this.mCoordinates;
        r14.drawBitmap(r28, r29.rateX, r29.rateY, null);
        r14.restore();
        traceEndSection();
    L35:
        if (this.mConfig.hasLabelA() == false) goto L41;
        traceBeginSection("AAIV.measureLabelA");
        e.c r30 = e.O(this.mAppInfo.mLabels.get(0).intValue());
        this.sPaint.setTextSize(this.mCoordinates.labelATextSize);
        String r31 = getString(r30.f10026a);
        if (TextUtils.isEmpty(r31) == true) goto L39;
        float r32 = this.sPaint.measureText(r31);
    L40:
        traceEndSection();
    L43:
        if (this.mConfig.hasLabelB() == false) goto L48;
        traceBeginSection("AAIV.measureLabelB");
        e.c r33 = e.O(this.mAppInfo.mLabels.get(1).intValue());
        this.sPaint.setTextSize(this.mCoordinates.labelBTextSize);
        String r34 = getString(r33.f10026a);
        if (TextUtils.isEmpty(r34) == true) goto L47;
        r16 = this.sPaint.measureText(r34);
    L47:
        traceEndSection();
    L49:
        String r110 = getEllipsizeText(this.mAppInfo.appCategoryName, getMaxCategoryWidth(r32, r16));
        if (TextUtils.isEmpty(r110) == true) goto L53;
        traceBeginSection("AAIV.drawCategory");
        r14.save();
        this.sPaint.setColor(this.mCoordinates.categoryTextColor);
        this.sPaint.setAlpha((int) (this.mRatio * 255.0f));
        this.sPaint.setTextSize(this.mCoordinates.categoryTextSize);
        this.sPaint.setTypeface(null);
        AppItemViewCoordinates r35 = this.mCoordinates;
        r14.drawText(r110, r35.categoryX, r35.categoryY + r35.categoryBaseline, this.sPaint);
        r14.restore();
        traceEndSection();
    L53:
        if (this.mConfig.hasLabelA() == false) goto L68;
        traceBeginSection("AAIV.drawLabelA");
        int r36 = this.mCoordinates.categoryX;
        if (TextUtils.isEmpty(r110) == false) goto L57;
        int r111 = 0;
    L58:
        int r37 = r36 + r111;
        AppItemViewCoordinates r112 = this.mCoordinates;
        int r38 = (r37 + r112.categoryPaddingRight) + r112.labelAMarginLeft;
        this.sPaint.setTextSize(r112.labelATextSize);
        this.sPaint.setColor(getColor(r30.f10027b));
        r14.save();
        AppItemViewCoordinates r113 = this.mCoordinates;
        Bitmap r39 = getNinePatchBitmap(r30.f10028c, (int) ((r113.labelAPadding * 2) + r32), r113.labelAHeight);
        if (r39 != null) goto L61;
    L63:
        int r40 = 0;
    L65:
        if (TextUtils.isEmpty(r31) == true) goto L67;
        AppItemViewCoordinates r41 = this.mCoordinates;
        r14.drawText(r31, r38 + r41.labelAPadding, r41.labelABaseline + r41.labelAY, this.sPaint);
    L67:
        r14.restore();
        traceEndSection();
    L70:
        if (this.mConfig.hasLabelB() == false) goto L89;
        traceBeginSection("AAIV.drawLabelB");
        if (r40 <= 0) goto L74;
        int r42 = r40 + this.mCoordinates.labelAMarginRight;
    L79:
        this.sPaint.setTextSize(this.mCoordinates.labelBTextSize);
        this.sPaint.setColor(getColor(r33.f10027b));
        r14.save();
        AppItemViewCoordinates r43 = this.mCoordinates;
        Bitmap r44 = getNinePatchBitmap(r33.f10028c, (int) ((r43.labelAPadding * 2) + r16), r43.labelBHeight);
        if (r44 == null) goto L85;
        if (r44.isRecycled() == true) goto L85;
        r14.drawBitmap(r44, r42, this.mCoordinates.labelBY, null);
    L85:
        if (TextUtils.isEmpty(r34) == true) goto L87;
        AppItemViewCoordinates r45 = this.mCoordinates;
        r14.drawText(r34, r42 + r45.labelAPadding, r45.labelBBaseline + r45.labelBY, this.sPaint);
    L87:
        r14.restore();
        traceEndSection();
        goto L89
    L74:
        int r46 = this.mCoordinates.categoryX;
        if (TextUtils.isEmpty(r110) == true) goto L78;
        r22 = (int) this.sPaint.measureText(r110);
    L78:
        int r47 = r46 + r22;
        AppItemViewCoordinates r48 = this.mCoordinates;
        r42 = (r47 + r48.categoryPaddingRight) + r48.labelBMarginLeft;
    L89:
        if (this.mConfig.hasBrief() == false) goto L96;
        traceBeginSection("AAIV.drawBrief");
        this.sPaint.setColor(this.mCoordinates.briefTextColor);
        this.sPaint.setTextSize(this.mCoordinates.briefTextSize);
        r14.save();
        if (TextUtils.isEmpty(this.mAppInfo.recmd_brief) == false) goto L93;
        String r49 = getString(R$string.no_comment);
    L94:
        AppItemViewCoordinates r50 = this.mCoordinates;
        r14.drawText(r49, r50.briefX, r50.briefY + r50.briefBaseline, this.sPaint);
        r14.restore();
        traceEndSection();
        goto L96
    L93:
        r49 = getEllipsizeText(this.mAppInfo.recmd_brief, this.mCoordinates.briefMaxWidth);
    L96:
        if (this.mConfig.hasSource() == false) goto L99;
        traceBeginSection("AAIV.drawSource");
        this.sPaint.setColor(this.mCoordinates.sourceTextColor);
        this.sPaint.setTextSize(this.mCoordinates.sourceTextSize);
        r14.save();
        Bitmap r51 = getBitmapSource();
        AppItemViewCoordinates r52 = this.mCoordinates;
        r14.drawBitmap(r51, r52.sourceX, r52.sourceY + ((r52.sourceHeight - getBitmapSource().getHeight()) / 2.0f), null);
        int r53 = this.mCoordinates.sourceX + getBitmapSource().getWidth();
        AppItemViewCoordinates r54 = this.mCoordinates;
        r14.drawText(r54.sourceTextString, r53 + r54.sourceCompoundDrawablePadding, r54.sourceY + r54.sourceBaseline, this.sPaint);
        r14.restore();
        traceEndSection();
    L99:
        if (this.mConfig.hasLine() == false) goto L102;
        traceBeginSection("AAIV.drawLine");
        r14.save();
        Rect r55 = this.mLineRect;
        AppItemViewCoordinates r56 = this.mCoordinates;
        int r57 = r56.lineX + this.mLineLeftMargin;
        int r58 = r56.lineY;
        r55.set(r57, r58, this.mWidth - this.mLineRightMargin, r56.lineHeight + r58);
        r14.drawBitmap(getBitmapLine(), null, this.mLineRect, null);
        r14.restore();
        traceEndSection();
        return;
    L102:
        return;
    L61:
        if (r39.isRecycled() == true) goto L63;
        r40 = r39.getWidth() + r38;
        r14.drawBitmap(r39, r38, this.mCoordinates.labelAY, null);
        goto L65
    L57:
        r111 = (int) this.sPaint.measureText(r110);
        goto L58
    L68:
        r40 = 0;
        goto L70
    L48:
        r33 = null;
        r34 = null;
        goto L49
    L39:
        r32 = 0.0f;
        goto L40
    L41:
        r30 = null;
        r31 = null;
        r32 = 0.0f;
        goto L43
    L21:
        if (r23.isRecycled() == true) goto L23;
        r24 = this.mIconBitmap;
        goto L24
    L14:
        if (r21.isRecycled() == false) goto L18;
        if (this.mRetryBindIcon == true) goto L18;
        this.mRetryBindIcon = true;
        bindIcon();
        goto L25
    }

    public OUIAppStatusView getAppStatusView() {
        return this.mAppStatusView;
    }

    public Bitmap getIconBitmap() {
        return this.mIconBitmap;
    }

    public Object getNumber() {
        return this.mNumber;
    }

    public void init() {
        if (this.mRoundTransform != null) goto L5;
        this.mRoundTransform = new GlideRoundTransform[]{new GlideRoundTransform()};
        this.mRoundTransform[0].f(15).e(f.i(30));
    L5:
        this.mIconPaint.setFilterBitmap(true);
        setDescendantFocusability(393216);
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(false);
        if (BaseApplication.c().f9554j == false) goto L8;
        int r10 = AppItemViewCoordinates.ITEM_HEIGHT_BIG_FONT;
    L9:
        setLayoutParams(new ViewGroup.LayoutParams(-1, r10));
        initCoordinates();
        initAppStatus();
        return;
    L8:
        r10 = AppItemViewCoordinates.ITEM_HEIGHT;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Target<Bitmap> r10 = this.mTarget;
        if (r10 != null) goto L10;
    L8:
        super.onDetachedFromWindow();
        return;
    L10:
        com.bytedanceos.common.toolbox.glide.b.d(this, r10);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r12 == this.mWidth) goto L5;
        updateItemWidth(r12);
    L5:
        initBitmaps();
    }

    public void setNumber(Object r10) {
        this.mNumber = r10;
    }

    public void setOnClickListener(View.OnClickListener r10, View.OnClickListener r11) {
        this.mOnBtnClickListener = r10;
        this.mOnItemClickListener = r11;
    }

    public void setRatio(float r10) {
        this.mRatio = r10;
    }

    public void showLine(boolean r10) {
        this.mConfig.setHasLine(r10);
        invalidate();
    }

    public void updateAppStatus(AppInfo r10) {
        OUIAppStatusView r11 = this.mAppStatusView;
        if (r11 == null) goto L6;
        r11.updateDownloadStatus(r10);
        return;
    }

    public void updateItemView(AppInfo r10) {
        this.mAppInfo = r10;
        setTag(R$id.appinfo, r10);
        View.OnClickListener r11 = this.mOnItemClickListener;
        if (r11 == null) goto L5;
        setOnClickListener(r11);
    L5:
        boolean r12 = false;
        if (TextUtils.isEmpty(r10.recmd_brief) == true) goto L8;
    L10:
        boolean r13 = false;
    L11:
        AppItemViewCoordinates.Config r14 = this.mConfig.setHasRate(r13).setHasBrief(!r13);
        if (r10.mLabels.size() > 0) goto L14;
    L16:
        boolean r15 = false;
    L17:
        AppItemViewCoordinates.Config r16 = r14.setHasLabelA(r15);
        if (r10.mLabels.size() > 1) goto L20;
    L22:
        boolean r17 = false;
    L23:
        AppItemViewCoordinates.Config r18 = r16.setHasLabelB(r17);
        if (getNumber() == null) goto L26;
        r12 = true;
    L26:
        r18.setHasNumber(r12).setHasSource(r10.mHasSourceView).setHasCategory(!TextUtils.isEmpty(r10.appCategoryName));
        initCoordinates();
        bindIcon();
        bindAppStatus();
        invalidate();
        return;
    L20:
        if (e.H0(r10.mLabels.get(1).intValue()) == false) goto L22;
        r17 = true;
        goto L23
    L14:
        if (e.H0(r10.mLabels.get(0).intValue()) == false) goto L16;
        r15 = true;
        goto L17
    L8:
        if (r10.appScores <= 0.0f) goto L10;
        r13 = true;
        goto L11
    }

    public AbstractAppItemView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public AbstractAppItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mIconRect = new Rect();
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        this.mConfig = new AppItemViewCoordinates.Config();
        this.mRatio = 1.0f;
        this.mRetryBindIcon = false;
        this.sPaint = new TextPaint(1);
        this.mLineRect = new Rect();
        this.mIconPaint = new Paint(1);
        init();
    }

    public void updateItemView(AppInfo r10, int r11) {
        this.mPosition = r11;
        updateItemView(r10);
    }
}
