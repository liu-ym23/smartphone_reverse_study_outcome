package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LettersBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LettersBar extends View {
    public static final a Companion = null;
    public static final int POPUP_CONTAINER_MARGIN_DP = 10;
    private static final String TAG = "LettersBar";
    private final Runnable dismissPopupTask;
    private float dotLetterTextSizePx;
    private float downX;
    private float downY;
    private String lastPopupLetter;
    private c mBackgroundChangeListener;
    private final Paint mBitmapPaint;
    private int mChosenLetterIndex;
    private Context mContext;
    private Bitmap mDotIcon;
    private int mDotIconX;
    private int mHasChosenLetterFontColor;
    private Bitmap mHighlightIcon;
    private int mHighlightIconHeight;
    private int mHighlightIconStartX;
    private Bitmap[] mIconsForSymbolsSelected;
    private int mLetterBarHeight;
    private int mLetterFontCenterX;
    private int mLetterFontSize;
    private int mLetterLocaleFontSize;
    private final Paint mLetterPaint;
    private List<com.obric.oui.indexscrollbar.b> mLetters;
    private int mLettersBarWidth;
    private b mListener;
    private int mNoChosenLetterFontColor;
    private final d mPopupWindow;
    private int mScreenWidth;
    private boolean mSettled;
    private boolean mShowBg;
    private int mSingleLetterMinHeight;
    private int newChosen;
    private int oldChosen;
    private final Runnable showPopupTask;
    private long showPopupTaskStartTime;
    private int touchSlop;

    /* JADX INFO: compiled from: LettersBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LettersBar.kt */
    public interface b {
        boolean a(String r1, int r2);
    }

    /* JADX INFO: compiled from: LettersBar.kt */
    public interface c {
        void a(boolean r1);
    }

    static {
        Companion = new a(null);
    }

    public LettersBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public LettersBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$I6G7-ZDujXoZKNjGlrt0eGXragg, reason: not valid java name */
    public static /* synthetic */ void m1084lambda$I6G7ZDujXoZKNjGlrt0eGXragg(LettersBar r0) {
        m1086showPopupTask$lambda1(r0);
    }

    /* JADX INFO: renamed from: lambda$bj7aFOA1-n25WP6RBlJmP1oY3rc, reason: not valid java name */
    public static /* synthetic */ void m1085lambda$bj7aFOA1n25WP6RBlJmP1oY3rc(LettersBar r0) {
        m1083dismissPopupTask$lambda2(r0);
    }

    public /* synthetic */ LettersBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public LettersBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.mChosenLetterIndex = -1;
        this.mSettled = true;
        this.mLetterPaint = new Paint();
        Paint r0 = new Paint(1);
        r0.setFilterBitmap(true);
        r0.setDither(true);
        this.mBitmapPaint = r0;
        this.mPopupWindow = new d(r6);
        init(r6);
        this.oldChosen = -1;
        this.newChosen = -1;
        this.showPopupTask = new $$Lambda$LettersBar$I6G7ZDujXoZKNjGlrt0eGXragg(this);
        this.dismissPopupTask = new $$Lambda$LettersBar$bj7aFOA1n25WP6RBlJmP1oY3rc(this);
        this.showPopupTaskStartTime = -1;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.mHasChosenLetterFontColor;
    }

    public final void setMHasChosenLetterFontColor(int r1) {
        this.mHasChosenLetterFontColor = r1;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.mNoChosenLetterFontColor;
    }

    public final void setMNoChosenLetterFontColor(int r1) {
        this.mNoChosenLetterFontColor = r1;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        invalidate();
    }

    public final void setLetters(List<com.obric.oui.indexscrollbar.b> r3) {
        this.mLetters = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setBitmapsSelected(Bitmap[] r1) {
        this.mIconsForSymbolsSelected = r1;
    }

    public final void setListener(b r3) {
        this.mListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final void setSettled(boolean r1) {
        this.mSettled = r1;
        if (r1 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r4) {
        if (this.mShowBg == r4) goto L12;
        this.mShowBg = r4;
        if (r4 == false) goto L7;
        Drawable r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.letters_bar_background, "drawable", "letters_bar_background"));
    L8:
        setBackground(r5);
        c r6 = this.mBackgroundChangeListener;
        if (r6 == null) goto L13;
        o.a(r6);
        r6.a(this.mShowBg);
        return;
    L13:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void setOnBackgroundVisibleChangedListener(c r3) {
        this.mBackgroundChangeListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public final void setPopupWindowStyle(int r1, Drawable r2) {
        this.mPopupWindow.a(r1, r2);
    }

    public final void setLetterFontColor(int r1, int r2) {
        this.mHasChosenLetterFontColor = r1;
        this.mNoChosenLetterFontColor = r2;
    }

    private final void init(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        refreshDimensionCache();
        Context r0 = this.mContext;
        o.a(r0);
        Resources r1 = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin");
        this.mSingleLetterMinHeight = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.letters_bar_single_letter_min_height, "dimen", "letters_bar_single_letter_min_height"));
        this.mLettersBarWidth = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 14);
        this.mLetterFontSize = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.letters_bar_letter_font_size, "dimen", "letters_bar_letter_font_size"));
        this.mLetterLocaleFontSize = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.letters_bar_letter_locale_font_size, "dimen", "letters_bar_letter_locale_font_size"));
        this.mLetterFontCenterX = (this.mLettersBarWidth / 2) + getPaddingLeft();
        this.mHighlightIcon = BitmapFactory.decodeResource(r1, ZeusTransformUtils.mapRes(R.drawable.letters_bar_highlight_icon, "drawable", "letters_bar_highlight_icon"));
        Drawable r2 = r1.getDrawable(ZeusTransformUtils.mapRes(R.drawable.letters_bar_highlight_icon, "drawable", "letters_bar_highlight_icon"));
        this.mHighlightIconStartX = this.mLetterFontCenterX - (r2.getIntrinsicWidth() / 2);
        this.mHighlightIconHeight = r2.getIntrinsicHeight();
        this.mHasChosenLetterFontColor = r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6"));
        this.mNoChosenLetterFontColor = r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3b, "color", "oui_text_3b"));
        Bitmap r3 = BitmapFactory.decodeResource(r1, ZeusTransformUtils.mapRes(R.drawable.letters_bar_dot, "drawable", "letters_bar_dot"));
        this.mDotIcon = r3;
        int r4 = this.mLetterFontCenterX;
        o.a(r3);
        this.mDotIconX = r4 - (r3.getWidth() / 2);
        this.mLetterPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.mLetterPaint.setTextSize(this.mLetterFontSize);
        this.mLetterPaint.setAntiAlias(true);
        this.mScreenWidth = ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
    }

    private final void refreshDimensionCache() {
        this.dotLetterTextSizePx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10);
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.mLetterBarHeight = (measureHeight(r2) - getPaddingTop()) - getPaddingBottom();
    }

    public final float getDownX() {
        return this.downX;
    }

    public final void setDownX(float r1) {
        this.downX = r1;
    }

    public final float getDownY() {
        return this.downY;
    }

    public final void setDownY(float r1) {
        this.downY = r1;
    }

    public final int getTouchSlop() {
        return this.touchSlop;
    }

    public final void setTouchSlop(int r1) {
        this.touchSlop = r1;
    }

    public final int getOldChosen() {
        return this.oldChosen;
    }

    public final void setOldChosen(int r1) {
        this.oldChosen = r1;
    }

    public final int getNewChosen() {
        return this.newChosen;
    }

    public final void setNewChosen(int r1) {
        this.newChosen = r1;
    }

    public final Runnable getShowPopupTask() {
        return this.showPopupTask;
    }

    /* JADX INFO: renamed from: showPopupTask$lambda-1, reason: not valid java name */
    private static final void m1086showPopupTask$lambda1(LettersBar r4) {
        o.e(r4, "this$0");
        int r0 = r4.oldChosen;
        int r1 = r4.newChosen;
        if (r0 == r1) goto L11;
        if (r1 < 0) goto L11;
        List<com.obric.oui.indexscrollbar.b> r2 = r4.mLetters;
        o.a(r2);
        if (r1 >= r2.size()) goto L11;
        r4.showPopupWindow("ACTION_DOWN", r4.newChosen);
        b r3 = r4.mListener;
        if (r3 == null) goto L10;
        o.a(r3);
        List<com.obric.oui.indexscrollbar.b> r5 = r4.mLetters;
        o.a(r5);
        r3.a(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r5.get(r4.newChosen), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).a(), 1);
    L10:
        com.obric.oui.b.a.f34003a.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 26);
        r4.setTouchedLetter(r4.newChosen);
    L11:
        r4.showPopupTaskStartTime = -1;
    }

    public final Runnable getDismissPopupTask() {
        return this.dismissPopupTask;
    }

    /* JADX INFO: renamed from: dismissPopupTask$lambda-2, reason: not valid java name */
    private static final void m1083dismissPopupTask$lambda2(LettersBar r1) {
        o.e(r1, "this$0");
        if (r1.mPopupWindow.b() == false) goto L6;
        r1.mPopupWindow.a();
        r1.setTouchedLetter(-1);
        r1.setShowBg(false);
        return;
    }

    public final long getShowPopupTaskStartTime() {
        return this.showPopupTaskStartTime;
    }

    public final void setShowPopupTaskStartTime(long r1) {
        this.showPopupTaskStartTime = r1;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r13) {
        o.e(r13, "event");
        super.dispatchTouchEvent(r13);
        int r0 = r13.getAction();
        float r1 = r13.getY();
        this.oldChosen = this.mChosenLetterIndex;
        float r2 = (r1 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<com.obric.oui.indexscrollbar.b> r3 = this.mLetters;
        o.a(r3);
        int r4 = (int) (r2 * r3.size());
        this.newChosen = r4;
        if (r0 != 0) goto L5;
        removeCallbacks(this.dismissPopupTask);
        this.downX = r13.getX();
        this.downY = r13.getY();
        this.touchSlop = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledTouchSlop();
        if (this.mPopupWindow.b() == true) goto L49;
        this.showPopupTaskStartTime = System.currentTimeMillis();
        postDelayed(this.showPopupTask, 200);
    L49:
        this.lastPopupLetter = null;
        setShowBg(false);
    L50:
        return true;
    L5:
        if (r0 != 1) goto L7;
        removeCallbacks(this.showPopupTask);
        if ((System.currentTimeMillis() - this.showPopupTaskStartTime) >= 100) goto L39;
        if (this.mPopupWindow.b() == true) goto L39;
        this.showPopupTaskStartTime = -1;
        this.showPopupTask.run();
        postDelayed(this.dismissPopupTask, 200);
        return true;
    L39:
        if (this.mPopupWindow.b() == false) goto L41;
        removeCallbacks(this.dismissPopupTask);
    L41:
        this.showPopupTaskStartTime = -1;
        if (this.mSettled == false) goto L44;
        this.mPopupWindow.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L45:
        invalidate();
        goto L50
    L44:
        this.mPopupWindow.a();
        goto L45
    L7:
        if (r0 == 2) goto L16;
        if (r0 != 3) goto L50;
        removeCallbacks(this.showPopupTask);
        if (this.mPopupWindow.b() == false) goto L14;
        removeCallbacks(this.dismissPopupTask);
    L14:
        this.showPopupTaskStartTime = -1;
        this.mPopupWindow.a();
        setTouchedLetter(-1);
        goto L50
    L16:
        if (Math.sqrt(Math.pow(r13.getX() - this.downX, 2.0d) + Math.pow(r13.getY() - this.downY, 2.0d)) >= this.touchSlop) goto L19;
        return true;
    L19:
        if (this.mPopupWindow.b() == false) goto L31;
        if (r4 < 0) goto L31;
        List<com.obric.oui.indexscrollbar.b> r14 = this.mLetters;
        o.a(r14);
        if (r4 >= r14.size()) goto L31;
        if (this.mSettled == true) goto L26;
    L30:
        setTouchedLetter(r4);
        goto L31
    L26:
        if (this.oldChosen == r4) goto L30;
        if (this.mListener == null) goto L30;
        removeCallbacks(this.dismissPopupTask);
        showPopupWindow("ACTION_MOVE", r4);
        com.obric.oui.b.a.f34003a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 26);
        b r15 = this.mListener;
        o.a(r15);
        List<com.obric.oui.indexscrollbar.b> r5 = this.mLetters;
        o.a(r5);
        r15.a(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r5.get(r4), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).a(), 0);
    L31:
        setShowBg(false);
        goto L50
    }

    private final void showPopupWindow(String r12, int r13) {
        float r0 = getSingleLetterHeight(this.mLetterBarHeight, calculateVisibleLettersIndexes());
        List<com.obric.oui.indexscrollbar.b> r1 = this.mLetters;
        o.a(r1);
        String r2 = ((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r1.get(r13), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).a();
        if (o.a(r2, this.lastPopupLetter) == false) goto L5;
        return;
    L5:
        com.obric.oui.d.a.b.b(TAG, "showPopupWindow, scene: " + r12 + ", c = " + r13 + ", letter = " + r2 + ", lastPopupLetter = " + this.lastPopupLetter);
        Bitmap[] r14 = this.mIconsForSymbolsSelected;
        if (r14 != null) goto L8;
        Integer r15 = null;
    L9:
        List<com.obric.oui.indexscrollbar.b> r4 = this.mLetters;
        o.a(r4);
        if (((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r4.get(r13), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).getType() != 2) goto L15;
        if (r15 == null) goto L15;
        if (Integer.parseInt(r2) > r15.intValue()) goto L15;
        Bitmap[] r16 = this.mIconsForSymbolsSelected;
        o.a(r16);
        Bitmap r7 = r16[Integer.parseInt(r2) - 1];
    L16:
        int r17 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_h_title_bar_window, "dimen", "oui_h_title_bar_window"));
        int r8 = (this.mScreenWidth - getWidth()) - g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 68);
        int r3 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), "status_bar_height", "dimen", "android", "com.obric.aiagent.plugin");
        if (r3 <= 0) goto L19;
        r17 = r17 + ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r3);
    L19:
        int r10 = r17;
        int[] r18 = new int[2];
        getLocationInWindow(r18);
        this.mPopupWindow.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r2, r7, r8, (int) (((r18[1] + getPaddingTop()) + (r13 * r0)) + (r0 / 2)), r10);
        this.lastPopupLetter = r2;
        return;
    L15:
        r7 = null;
        goto L16
    L8:
        r15 = Integer.valueOf(r14.length);
        goto L9
    }

    @Override // android.view.View
    public void onDraw(Canvas r11) {
        o.e(r11, "canvas");
        super.onDraw(r11);
        r11.save();
        r11.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r0 = calculateVisibleLettersIndexes();
        float r1 = getSingleLetterHeight(this.mLetterBarHeight, r0);
        Iterator<Integer> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.aiagent.plugin");
        o.c(r4, "index");
        setLetterPaint(r4.intValue());
        float r5 = this.mLetterFontCenterX;
        Paint r6 = this.mLetterPaint;
        List<com.obric.oui.indexscrollbar.b> r7 = this.mLetters;
        o.a(r7);
        float r8 = 2;
        float r9 = r5 - (r6.measureText(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r7.get(r4.intValue()), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).a()) / r8);
        float r10 = (r3 * r1) + (r1 / r8);
        drawHighlightBackground(r4.intValue(), r11, r9, r10);
        List<com.obric.oui.indexscrollbar.b> r12 = this.mLetters;
        o.a(r12);
        if (((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r12.get(r4.intValue()), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).getType() != 2) goto L8;
        drawSymbol(r4.intValue(), r11, r9, r10);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        drawLetter(r4.intValue(), r11, r9, r10);
        goto L9
    L10:
        r11.restore();
    }

    private final void setLetterPaint(int r7) {
        if (isTouchedLetter(r7) == false) goto L5;
        this.mLetterPaint.setColor(this.mHasChosenLetterFontColor);
    L6:
        this.mLetterPaint.setFakeBoldText(false);
        this.mLetterPaint.setTextSize(this.dotLetterTextSizePx);
        List<com.obric.oui.indexscrollbar.b> r0 = this.mLetters;
        o.a(r0);
        if (d.o.o.b(((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r0.get(r7), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).a(), ".", false, 2, null) == true) goto L13;
        List<com.obric.oui.indexscrollbar.b> r1 = this.mLetters;
        o.a(r1);
        if (((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r1.get(r7), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).getType() != 1) goto L11;
        this.mLetterPaint.setTextSize(this.mLetterLocaleFontSize);
        this.mLetterPaint.setFakeBoldText(true);
        return;
    L11:
        this.mLetterPaint.setTextSize(this.mLetterFontSize);
        return;
    L13:
        return;
    L5:
        this.mLetterPaint.setColor(this.mNoChosenLetterFontColor);
        goto L6
    }

    private final void drawHighlightIcon(int r2, Canvas r3, float r4, float r5) {
        if (isTouchedLetter(r2) == true) goto L5;
        return;
    L5:
        if (this.mSettled == false) goto L9;
        Bitmap r6 = this.mHighlightIcon;
        o.a(r6);
        r3.drawBitmap(r6, this.mHighlightIconStartX, r5 - (this.mHighlightIconHeight / 2), getBitmapTintPaint(this.mHasChosenLetterFontColor));
        return;
    }

    private final void drawHighlightBackground(int r5, Canvas r6, float r7, float r8) {
        if (isTouchedLetter(r5) == true) goto L5;
        return;
    L5:
        if (this.mSettled == false) goto L9;
        Paint r9 = new Paint();
        r9.setColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        int r10 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 14);
        g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 14);
        float r11 = r10 / 2.0f;
        int r4 = this.mLetterFontCenterX;
        r6.drawRoundRect(new RectF(r4 - r11, r8 - r11, r4 + r11, r8 + r11), r11, r11, r9);
        return;
    }

    private final void drawSymbol(int r5, Canvas r6, float r7, float r8) {
        List<com.obric.oui.indexscrollbar.b> r9 = this.mLetters;
        if (r9 != null) goto L5;
        com.obric.oui.indexscrollbar.b r10 = null;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        Bitmap[] r11 = r10.b();
        if (r11 != null) goto L12;
        return;
    L12:
        if (isTouchedLetter(r5) == true) goto L14;
    L16:
        boolean r12 = false;
    L18:
        if (isHolderState() == false) goto L20;
    L23:
        boolean r2 = true;
    L25:
        if (r12 == false) goto L27;
        Bitmap r0 = r11[2];
    L30:
        if (r0 != null) goto L34;
        r0 = r11[0];
        if (r0 != null) goto L34;
        return;
    L34:
        if (r12 == false) goto L36;
        int r13 = this.mHasChosenLetterFontColor;
    L37:
        r6.drawBitmap(r0, this.mLetterFontCenterX - (r0.getWidth() / 2), r8 - (r0.getHeight() / 2), getBitmapTintPaint(r13));
        return;
    L36:
        r13 = this.mNoChosenLetterFontColor;
        goto L37
    L27:
        if (r2 == false) goto L29;
        r0 = r11[1];
        goto L30
    L29:
        r0 = r11[0];
        goto L30
    L20:
        if (this.mSettled == false) goto L23;
        r2 = false;
        goto L25
    L14:
        if (this.mSettled == false) goto L16;
        r12 = true;
        goto L18
    L5:
        r10 = (com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(p.d(r9, r5), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private final void drawLetter(int r6, Canvas r7, float r8, float r9) {
        List<com.obric.oui.indexscrollbar.b> r0 = this.mLetters;
        o.a(r0);
        String r1 = ((com.obric.oui.indexscrollbar.b) ZeusTransformUtils.preCheckCast(r0.get(r6), com.obric.oui.indexscrollbar.b.class, "com.obric.aiagent.plugin")).a();
        if (d.o.o.b(r1, ".", false, 2, null) == false) goto L5;
        drawDot(r6, r7, r8, r9);
        return;
    L5:
        Paint.FontMetricsInt r10 = this.mLetterPaint.getFontMetricsInt();
        r7.drawText(r1, r8, (r9 - ((r10.bottom - r10.top) / 2)) - r10.top, this.mLetterPaint);
    }

    private final void drawDot(int r2, Canvas r3, float r4, float r5) {
        Bitmap r6 = this.mDotIcon;
        if (r6 == null) goto L7;
        r3.drawBitmap(r6, this.mDotIconX, r5 - (r6.getHeight() / 2), getBitmapTintPaint(this.mLetterPaint.getColor()));
        return;
    }

    private final Paint getBitmapTintPaint(int r4) {
        this.mBitmapPaint.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.aiagent.plugin"));
        return this.mBitmapPaint;
    }

    private final int measureHeight(int r2) {
        int r1 = View.MeasureSpec.getMode(r2);
        int r3 = View.MeasureSpec.getSize(r2);
        if (r1 != Integer.MIN_VALUE) goto L5;
        return r3;
    L5:
        if (r1 == 1073741824) goto L9;
        return 0;
    L9:
        return r3;
    }

    private final float getSingleLetterHeight(int r3, ArrayList<Integer> r4) {
        return (float) Math.max(r3 / r4.size(), this.mSingleLetterMinHeight);
    }

    private final ArrayList<Integer> calculateVisibleLettersIndexes() {
        ArrayList<Integer> r0 = new ArrayList();
        int r1 = this.mLetterBarHeight;
        List<com.obric.oui.indexscrollbar.b> r2 = this.mLetters;
        o.a(r2);
        if ((r1 / r2.size()) >= this.mSingleLetterMinHeight) goto L5;
        List<com.obric.oui.indexscrollbar.b> r4 = this.mLetters;
        o.a(r4);
        int r3 = (int) Math.max(2.0d, ((int) Math.ceil(r4.size() / ((this.mLetterBarHeight / this.mSingleLetterMinHeight) - 2))) * 2);
    L6:
        r0.add(0);
        List<com.obric.oui.indexscrollbar.b> r5 = this.mLetters;
        o.a(r5);
        if (r3 >= (r5.size() / 2)) goto L12;
        int r6 = r3;
    L9:
        List<com.obric.oui.indexscrollbar.b> r7 = this.mLetters;
        o.a(r7);
        if (r6 >= (r7.size() - 1)) goto L12;
        r0.add(Integer.valueOf(r6));
        r6 = r6 + r3;
    L12:
        List<com.obric.oui.indexscrollbar.b> r8 = this.mLetters;
        o.a(r8);
        if (r3 >= r8.size()) goto L15;
        List<com.obric.oui.indexscrollbar.b> r9 = this.mLetters;
        o.a(r9);
        r0.add(Integer.valueOf(r9.size() - 1));
    L15:
        return r0;
    L5:
        r3 = 1;
        goto L6
    }

    private final boolean isHolderState() {
        if (this.mChosenLetterIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isTouchedLetter(int r1) {
        if (this.mChosenLetterIndex != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setTouchedLetter(int r1) {
        this.mChosenLetterIndex = r1;
        invalidate();
    }
}
