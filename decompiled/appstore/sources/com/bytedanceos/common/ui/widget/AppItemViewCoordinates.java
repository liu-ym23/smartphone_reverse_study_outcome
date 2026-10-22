package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.google.common.primitives.Ints;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AppItemViewCoordinates {
    protected static final int APP_CATEGORY_LEFT_MARGIN_BIG_FONT = 0;
    protected static final int APP_CATEGORY_TOP_MARGIN_BIG_FONT = 0;
    protected static final int APP_LABEL_0_RIGHT_MARGIN = 0;
    protected static final int APP_LABEL_0_RIGHT_MARGIN_BIG_FONT = 0;
    protected static final int APP_LABEL_PADDING = 0;
    protected static final int APP_NAME_LEFT_MARGIN_BIG_FONT = 0;
    protected static final int APP_NAME_TOP_PADDING_BIG_FONT = 0;
    protected static final int APP_STATUS_VIEW_TOP_MARGIN_BIG_FOUNT = 0;
    public static final int ITEM_HEIGHT = 0;
    public static final int ITEM_HEIGHT_BIG_FONT = 0;
    protected static final int LABEL_INTERVAL = 0;
    protected static final int MARGIN_HORIZONTAL = 0;
    protected static final int MAX_CATEGORY_WIDTH = 0;
    private static final int NUMBER_WIDTH = 0;
    private static final int NUMBER_WIDTH_BIG_FONT = 0;
    protected static final int NUM_MARGIN_LEFT = 0;
    protected static final int NUM_MAX_LENGTH = 0;
    protected static final int NUM_MAX_WIDTH = 0;
    protected static final int NUM_MIN_WIDTH = 0;
    public final int briefBaseline;
    public final int briefHeight;
    public final int briefMaxWidth;
    public final int briefTextColor;
    public final float briefTextSize;
    public final int briefWidth;
    public final int briefX;
    public final int briefY;
    public final int categoryBaseline;
    public final int categoryHeight;
    public final int categoryPaddingRight;
    public final int categoryTextColor;
    public final float categoryTextSize;
    public final int categoryWidth;
    public final int categoryX;
    public final int categoryY;
    public final int iconHeight;
    public final int iconWidth;
    public final int iconX;
    public final int iconY;
    public final int labelABaseline;
    public final int labelAHeight;
    public final int labelAMarginLeft;
    public final int labelAMarginRight;
    public final int labelAPadding;
    public final float labelATextSize;
    public final int labelAWidth;
    public final int labelAX;
    public final int labelAY;
    public final int labelBBaseline;
    public final int labelBHeight;
    public final int labelBMarginLeft;
    public final float labelBTextSize;
    public final int labelBWidth;
    public final int labelBX;
    public final int labelBY;
    public final int lineHeight;
    public final int lineWidth;
    public final int lineX;
    public final int lineY;
    public final int mWidth;
    public final int nameBaseline;
    public final int nameHeight;
    public final int nameMaxWidth;
    public final int nameTextColor;
    public final float nameTextSize;
    public final Typeface nameTypeface;
    public final int nameWidth;
    public final int nameX;
    public final int nameY;
    public final int numberBaseline;
    public final int numberHeight;
    public final int numberLayoutRight;
    public final int numberTextColor;
    public final float numberTextSize;
    public final Typeface numberTypeface;
    public final int numberWidth;
    public final int numberX;
    public final int numberY;
    public final int rateHeight;
    public final int rateWidth;
    public final int rateX;
    public final int rateY;
    public final int sourceBaseline;
    public final int sourceCompoundDrawablePadding;
    public final int sourceHeight;
    public final int sourceTextColor;
    public final float sourceTextSize;
    public final String sourceTextString;
    public final int sourceWidth;
    public final int sourceX;
    public final int sourceY;
    public final int statusHeight;
    public final int statusViewId;
    public final int statusWidth;
    public final int statusX;
    public final int statusY;

    public static class Cache {
        private static Cache mInstance;
        private SparseArray<SoftReference<Bitmap>> mBitmapCache;
        private SparseArray<AppItemViewCoordinates> mCoordinatesCache;
        private SparseArray<String> mEllipsizeCache;
        private HashMap<Float, Integer> mRateResIdCache;
        private SparseArray<View> mViewCache;

        private Cache() {
            this.mViewCache = new SparseArray();
            this.mCoordinatesCache = new SparseArray();
            this.mEllipsizeCache = new SparseArray();
            this.mRateResIdCache = new HashMap();
            this.mBitmapCache = new SparseArray();
        }

        public static Cache getInstance() {
            if (mInstance != null) goto L6;
            mInstance = new Cache();
        L6:
            return mInstance;
        }

        public void clear() {
            this.mViewCache.clear();
            this.mCoordinatesCache.clear();
            this.mEllipsizeCache.clear();
            this.mRateResIdCache.clear();
            this.mBitmapCache.clear();
        }

        public Bitmap getBitmap(int r10) {
            if (this.mBitmapCache.get(r10) != null) goto L5;
            return null;
        L5:
            return this.mBitmapCache.get(r10).get();
        }

        public AppItemViewCoordinates getCoordinates(int r10) {
            return this.mCoordinatesCache.get(r10);
        }

        public String getEllipsize(String r10, float r11, float r12) {
            return this.mEllipsizeCache.get(EllipsizeKey.getKey(r10, r11, r12));
        }

        public int getRateResId(float r10) {
            if (this.mRateResIdCache.get(Float.valueOf(r10)) != null) goto L7;
            return 0;
        L7:
            return this.mRateResIdCache.get(Float.valueOf(r10)).intValue();
        }

        public View getView(int r10) {
            return this.mViewCache.get(r10);
        }

        public void putBitmap(int r10, Bitmap r11) {
            this.mBitmapCache.put(r10, new SoftReference(r11));
        }

        public void putCoordinates(int r10, AppItemViewCoordinates r11) {
            this.mCoordinatesCache.put(r10, r11);
        }

        public void putEllipsize(String r10, float r11, float r12) {
            this.mEllipsizeCache.put(EllipsizeKey.getKey(r10, r11, r12), r10);
        }

        public void putRate(float r10, int r11) {
            this.mRateResIdCache.put(Float.valueOf(r10), Integer.valueOf(r11));
        }

        public void putView(int r10, View r11) {
            this.mViewCache.put(r10, r11);
        }
    }

    public static final class Config {
        private boolean hasBrief;
        private boolean hasCategory;
        private boolean hasLabelA;
        private boolean hasLabelB;
        private boolean hasLine;
        private boolean hasNumber;
        private boolean hasRate;
        private boolean hasSource;
        private int mHeight;
        private int mWidth;

        public Config() {
            this.hasLine = true;
        }

        public int getCacheKey() {
            return hashCode();
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public boolean hasBrief() {
            return this.hasBrief;
        }

        public boolean hasCategory() {
            return this.hasCategory;
        }

        public boolean hasLabelA() {
            return this.hasLabelA;
        }

        public boolean hasLabelB() {
            return this.hasLabelB;
        }

        public boolean hasLine() {
            return this.hasLine;
        }

        public boolean hasNumber() {
            return this.hasNumber;
        }

        public boolean hasRate() {
            return this.hasRate;
        }

        public boolean hasSource() {
            return this.hasSource;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Boolean.valueOf(this.hasNumber), Boolean.valueOf(this.hasLabelA), Boolean.valueOf(this.hasLabelB), Boolean.valueOf(this.hasBrief), Boolean.valueOf(this.hasRate), Boolean.valueOf(this.hasSource), Boolean.valueOf(this.hasLine), Boolean.valueOf(this.hasCategory)});
        }

        public Config setHasBrief(boolean r10) {
            this.hasBrief = r10;
            return this;
        }

        public Config setHasCategory(boolean r10) {
            this.hasCategory = r10;
            return this;
        }

        public Config setHasLabelA(boolean r10) {
            this.hasLabelA = r10;
            return this;
        }

        public Config setHasLabelB(boolean r10) {
            this.hasLabelB = r10;
            return this;
        }

        public Config setHasLine(boolean r10) {
            this.hasLine = r10;
            return this;
        }

        public Config setHasNumber(boolean r10) {
            this.hasNumber = r10;
            return this;
        }

        public Config setHasRate(boolean r10) {
            this.hasRate = r10;
            return this;
        }

        public Config setHasSource(boolean r10) {
            this.hasSource = r10;
            return this;
        }

        public Config setHeight(int r10) {
            this.mHeight = r10;
            return this;
        }

        public Config setWidth(int r10) {
            this.mWidth = r10;
            return this;
        }
    }

    public static class EllipsizeKey {
        public EllipsizeKey() {
        }

        public static int getKey(String r10, float r11, float r12) {
            return Objects.hash(new Object[]{r10, Float.valueOf(r11), Float.valueOf(r12)});
        }
    }

    static {
        ITEM_HEIGHT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_app_list_height);
        ITEM_HEIGHT_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_list_height_1X4);
        NUMBER_WIDTH = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_number_width);
        NUMBER_WIDTH_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_number_width_1X4);
        MARGIN_HORIZONTAL = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.checkbox_margin);
        NUM_MAX_WIDTH = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.app_no_max_width);
        NUM_MIN_WIDTH = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.app_no_min_width);
        MAX_CATEGORY_WIDTH = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.max_category_width);
        Resources r10 = BaseApplication.c().getResources();
        int r11 = R$dimen.label_interval;
        LABEL_INTERVAL = r10.getDimensionPixelSize(r11);
        NUM_MARGIN_LEFT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.appnum_margin_left);
        NUM_MAX_LENGTH = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.appnum_width);
        APP_STATUS_VIEW_TOP_MARGIN_BIG_FOUNT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_item_status_view_margin_top);
        APP_NAME_LEFT_MARGIN_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_name_margin_left_1X4);
        APP_NAME_TOP_PADDING_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.show_app_item_name_padding);
        APP_CATEGORY_TOP_MARGIN_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_category_margin_top_1X4);
        APP_CATEGORY_LEFT_MARGIN_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_category_margin_left_1X4);
        APP_LABEL_0_RIGHT_MARGIN = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.label_margin_right);
        APP_LABEL_PADDING = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.label_padding);
        APP_LABEL_0_RIGHT_MARGIN_BIG_FONT = BaseApplication.c().getResources().getDimensionPixelSize(r11);
    }

    public AppItemViewCoordinates(Context r10, Config r11, Cache r12) {
        if (BaseApplication.c().f9554j == false) goto L5;
        int r13 = R$layout.abstract_app_item_view_1x4;
    L6:
        View r14 = r12.getView(r13);
        int r15 = 0;
        if (r14 != null) goto L9;
        r14 = LayoutInflater.from(r10).inflate(r13, null, false);
        r12.putView(r13, r14);
    L9:
        View r16 = r14.findViewById(R$id.app_no_layout);
        int r17 = 8;
        if (r11.hasNumber() == false) goto L12;
        int r18 = 0;
    L13:
        r16.setVisibility(r18);
        TextView r19 = (TextView) r14.findViewById(R$id.appCategory);
        if (r11.hasCategory() == false) goto L16;
        int r20 = 0;
    L17:
        r19.setVisibility(r20);
        TextView r21 = (TextView) r14.findViewById(R$id.label_0);
        if (r11.hasLabelA() == false) goto L20;
        int r22 = 0;
    L21:
        r21.setVisibility(r22);
        TextView r23 = (TextView) r14.findViewById(R$id.label_1);
        if (r11.hasLabelB() == false) goto L24;
        int r24 = 0;
    L25:
        r23.setVisibility(r24);
        TextView r25 = (TextView) r14.findViewById(R$id.appBrief);
        if (r11.hasBrief() == false) goto L28;
        int r26 = 0;
    L29:
        r25.setVisibility(r26);
        View r27 = r14.findViewById(R$id.appRate);
        if (r11.hasRate() == false) goto L32;
        int r28 = 0;
    L33:
        r27.setVisibility(r28);
        TextView r29 = (TextView) r14.findViewById(R$id.appSource);
        if (r11.hasSource() == false) goto L36;
        r17 = 0;
    L36:
        r29.setVisibility(r17);
        r14.measure(View.MeasureSpec.makeMeasureSpec(r11.getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(0, 0));
        r14.layout(0, 0, r14.getMeasuredWidth(), r14.getMeasuredHeight());
        this.mWidth = r14.getWidth();
        TextView r30 = (TextView) r14.findViewById(R$id.appNo);
        this.numberX = getX(r30);
        this.numberY = getY(r30);
        this.numberBaseline = r30.getBaseline();
        this.numberWidth = r30.getWidth();
        this.numberHeight = r30.getHeight();
        this.numberTextColor = r30.getCurrentTextColor();
        this.numberTextSize = r30.getTextSize();
        this.numberTypeface = r30.getTypeface();
        this.numberLayoutRight = r16.getRight();
        View r110 = r14.findViewById(R$id.appIcon);
        this.iconX = getX(r110);
        this.iconY = getY(r110);
        this.iconWidth = r110.getWidth();
        this.iconHeight = r110.getHeight();
        TextView r111 = (TextView) r14.findViewById(R$id.appName);
        this.nameX = getX(r111);
        this.nameY = getY(r111);
        this.nameBaseline = r111.getBaseline();
        this.nameWidth = r111.getWidth();
        this.nameHeight = r111.getHeight();
        this.nameTextColor = r111.getCurrentTextColor();
        this.nameTextSize = r111.getTextSize();
        this.nameTypeface = r111.getTypeface();
        if (r11.hasNumber() == false) goto L39;
        int r112 = NUM_MARGIN_LEFT + NUM_MAX_LENGTH;
    L40:
        this.nameMaxWidth = r111.getMaxWidth() - r112;
        this.categoryX = getX(r19);
        this.categoryY = getY(r19);
        this.categoryPaddingRight = r19.getPaddingRight();
        this.categoryBaseline = r19.getBaseline();
        this.categoryWidth = r19.getWidth();
        this.categoryHeight = r19.getHeight();
        this.categoryTextColor = r19.getCurrentTextColor();
        this.categoryTextSize = r19.getTextSize();
        this.labelAX = getX(r21);
        this.labelAY = getY(r21);
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r21.getLayoutParams();
        this.labelAMarginLeft = r113.leftMargin;
        this.labelAMarginRight = r113.rightMargin;
        this.labelABaseline = r21.getBaseline();
        this.labelAWidth = r21.getWidth();
        this.labelAHeight = r21.getHeight();
        this.labelATextSize = r21.getTextSize();
        this.labelAPadding = r21.getPaddingLeft();
        this.labelBX = getX(r23);
        this.labelBY = getY(r23);
        this.labelBMarginLeft = ((ViewGroup.MarginLayoutParams) r23.getLayoutParams()).leftMargin;
        this.labelBBaseline = r23.getBaseline();
        this.labelBWidth = r23.getWidth();
        this.labelBHeight = r23.getHeight();
        this.labelBTextSize = r23.getTextSize();
        this.briefX = getX(r25);
        this.briefY = getY(r25);
        this.briefBaseline = r25.getBaseline();
        this.briefWidth = r25.getWidth();
        this.briefHeight = r25.getHeight();
        this.briefTextColor = r25.getCurrentTextColor();
        this.briefTextSize = r25.getTextSize();
        this.briefMaxWidth = r25.getMaxWidth();
        this.rateX = getX(r27);
        this.rateY = getY(r27);
        this.rateWidth = r27.getWidth();
        this.rateHeight = r27.getHeight();
        this.sourceX = getX(r29);
        this.sourceY = getY(r29);
        this.sourceBaseline = r29.getBaseline();
        this.sourceWidth = r29.getWidth();
        this.sourceHeight = r29.getHeight();
        this.sourceTextColor = r29.getCurrentTextColor();
        this.sourceTextSize = r29.getTextSize();
        this.sourceCompoundDrawablePadding = r29.getCompoundDrawablePadding();
        this.sourceTextString = r29.getText().toString();
        View r114 = r14.findViewById(R$id.app_list_space);
        this.lineX = getX(r114);
        this.lineY = getY(r114);
        this.lineWidth = r114.getWidth();
        this.lineHeight = r114.getHeight();
        AppStatusView r115 = (AppStatusView) r14.findViewById(R$id.appStatusLay);
        this.statusX = getX(r115);
        this.statusY = getY(r115);
        this.statusWidth = Math.max(r115.getWidth(), r115.getMinimumWidth());
        int r116 = r115.getHeight();
        if (BaseApplication.c().f9554j == false) goto L43;
        r15 = APP_STATUS_VIEW_TOP_MARGIN_BIG_FOUNT;
    L43:
        this.statusHeight = r116 - r15;
        this.statusViewId = r115.getId();
        return;
    L39:
        r112 = 0;
        goto L40
    L32:
        r28 = 8;
        goto L33
    L28:
        r26 = 8;
        goto L29
    L24:
        r24 = 8;
        goto L25
    L20:
        r22 = 8;
        goto L21
    L16:
        r20 = 8;
        goto L17
    L12:
        r18 = 8;
        goto L13
    L5:
        r13 = R$layout.abstract_app_item_view;
        goto L6
    }

    public static AppItemViewCoordinates forConfig(Context r10, Config r11, Cache r12) {
        int r13 = r11.getCacheKey();
        AppItemViewCoordinates r14 = r12.getCoordinates(r13);
        if (r14 == null) goto L5;
        return r14;
    L5:
        AppItemViewCoordinates r15 = new AppItemViewCoordinates(r10, r11, r12);
        r12.putCoordinates(r13, r15);
        return r15;
    }

    private static int getX(View r10) {
        int r11 = 0;
    L3:
        if (r10 == null) goto L5;
        r11 = r11 + ((int) r10.getX());
        r10 = (View) r10.getParent();
        goto L3
    L5:
        return r11;
    }

    private static int getY(View r10) {
        int r11 = 0;
    L3:
        if (r10 == null) goto L5;
        r11 = r11 + ((int) r10.getY());
        r10 = (View) r10.getParent();
        goto L3
    L5:
        return r11;
    }
}
