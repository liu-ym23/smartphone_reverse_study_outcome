package com.lynx.markdown;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class MarkdownView extends View implements com.lynx.markdown.a.b {
    private static final int DEFAULT_TEXT_CURSOR_COLOR = 0;
    private static final int DEFAULT_TEXT_SELECTION_COLOR = 0;
    private static final float RESPONSE_TOUCH_RADIUS = 50.0f;
    private h mBundle;
    private a mCheckForLongPress;
    Canvas mCurrentCanvas;
    private int mDrawCharCount;
    private boolean mEnableCustomLayout;
    private boolean mEnableTextSelection;
    private final PointF mEndHandlerPos;
    private Paint mHighlightPaint;
    private Path mHighlightPath;
    private boolean mIsAdjustEndPos;
    private boolean mIsAdjustStartPos;
    private boolean mIsForward;
    private boolean mIsInSelection;
    private int mLastSelectEnd;
    private int mLastSelectStart;
    private MarkdownParser mMarkdownParser;
    private int mSelectEnd;
    private final PointF mSelectEndPos;
    private int mSelectStart;
    private final PointF mSelectStartPos;
    private Drawable mSelectionLeftCursor;
    private Drawable mSelectionRightCursor;
    private boolean mShouldResponseMove;
    private final PointF mStartHandlerPos;
    private ColorStateList mTextSelectionCursorColor;
    private b mViewCallback;
    private WeakReference<f> mWeakMarkdownLayout;

    private final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MarkdownView f13866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f13868c;

        static /* synthetic */ float a(a r0) {
            return r0.f13867b;
        }

        static /* synthetic */ float b(a r0) {
            return r0.f13868c;
        }

        public a(MarkdownView r1, float r2, float r3) {
            this.f13866a = r1;
            this.f13867b = r2;
            this.f13868c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            MarkdownView.access$002(this.f13866a, true);
            MarkdownView.access$100(this.f13866a).set(this.f13867b, this.f13868c);
            MarkdownView.access$200(this.f13866a).set(this.f13867b, this.f13868c);
            MarkdownView r0 = this.f13866a;
            MarkdownView.access$302(r0, MarkdownView.access$402(r0, MarkdownView.access$500(r0, this.f13867b, this.f13868c)));
            MarkdownView.access$602(this.f13866a, true);
            a("linxs", "MarkdownView logPress");
            MarkdownView.access$702(this.f13866a, null);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public interface b {
        Drawable getLeftCursorDrawable(Context r1);

        Drawable getRightCursorDrawable(Context r1);

        void requestDisallowInterceptTouchEvent(boolean r1);
    }

    static /* synthetic */ boolean access$002(MarkdownView r0, boolean r1) {
        r0.mIsInSelection = r1;
        return r1;
    }

    static /* synthetic */ PointF access$100(MarkdownView r0) {
        return r0.mSelectStartPos;
    }

    static /* synthetic */ PointF access$200(MarkdownView r0) {
        return r0.mSelectEndPos;
    }

    static /* synthetic */ int access$302(MarkdownView r0, int r1) {
        r0.mSelectEnd = r1;
        return r1;
    }

    static /* synthetic */ int access$402(MarkdownView r0, int r1) {
        r0.mSelectStart = r1;
        return r1;
    }

    static /* synthetic */ int access$500(MarkdownView r0, float r1, float r2) {
        return r0.getOffsetForPosition(r1, r2);
    }

    static /* synthetic */ boolean access$602(MarkdownView r0, boolean r1) {
        r0.mIsAdjustEndPos = r1;
        return r1;
    }

    static /* synthetic */ a access$702(MarkdownView r0, a r1) {
        r0.mCheckForLongPress = r1;
        return r1;
    }

    static {
        DEFAULT_TEXT_SELECTION_COLOR = Color.argb(20, 27, 125, 240);
        DEFAULT_TEXT_CURSOR_COLOR = Color.argb(255, 27, 125, 240);
    }

    public MarkdownView(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        super(r5);
        this.mIsForward = true;
        this.mEnableTextSelection = false;
        this.mHighlightPath = new Path();
        this.mHighlightPaint = new Paint();
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        this.mSelectStartPos = new PointF(-1.0f, -1.0f);
        this.mSelectEndPos = new PointF(-1.0f, -1.0f);
        this.mStartHandlerPos = new PointF(-1.0f, -1.0f);
        this.mEndHandlerPos = new PointF(-1.0f, -1.0f);
        this.mIsInSelection = false;
        this.mShouldResponseMove = false;
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mCheckForLongPress = null;
        this.mDrawCharCount = 0;
        Markdown.ensureInitialized();
        setWillNotDraw(false);
        this.mViewCallback = r6;
    }

    public void setLayoutBundle(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L14;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        this.mBundle = r4;
        this.mMarkdownParser = r4.f13900a;
        this.mWeakMarkdownLayout = this.mBundle.f13904e;
        this.mBundle.f13903d.setView(this);
        if (this.mBundle.f13902c != 0) goto L7;
        int r5 = this.mBundle.f13900a.getPageCharCount();
    L8:
        this.mDrawCharCount = r5;
        if (this.mIsInSelection == false) goto L11;
        clearSelection();
    L12:
        invalidate();
        return;
    L11:
        resetSelectionState();
        goto L12
    L7:
        r5 = this.mBundle.f13900a.typewriterStepToChar(this.mBundle.f13902c);
        goto L8
    }

    private void resetSelectionState() {
        this.mLastSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mSelectEnd = -1;
        this.mSelectStart = -1;
        this.mShouldResponseMove = false;
        this.mIsAdjustEndPos = false;
        this.mIsAdjustStartPos = false;
        this.mIsInSelection = false;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
    }

    public void enableCustomLayout(boolean r1) {
        this.mEnableCustomLayout = r1;
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.mEnableCustomLayout == true) goto L7;
        h r0 = this.mBundle;
        if (r0 == null) goto L7;
        setMeasuredDimension(r0.h, this.mBundle.i);
        return;
    L7:
        setMeasuredDimension(View.MeasureSpec.getSize(r2), View.MeasureSpec.getSize(r3));
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        if (this.mMarkdownParser == null) goto L12;
        Markdown.ensureInitialized();
        this.mCurrentCanvas = r7;
        int r0 = r7.getSaveCount();
        com.lynx.markdown.a.d r1 = new com.lynx.markdown.a.d(r7, this.mMarkdownParser.getResourceManager(), this);
        if (this.mBundle.f13901b != 1) goto L9;
        this.mBundle.f13900a.drawWithCursor(r1, this.mBundle.f13902c, true ^ this.mBundle.f);
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.mBundle.f13904e.get(), f.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L10;
        r6.b();
    L10:
        r7.restoreToCount(r0);
        return;
    L9:
        this.mMarkdownParser.draw(r1);
        goto L10
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r3) {
        super.dispatchDraw(r3);
        if (this.mHighlightPath.isEmpty() == true) goto L6;
        r3.drawPath(this.mHighlightPath, this.mHighlightPaint);
        drawSelectionCursor(r3);
        return;
    }

    @Override // com.lynx.markdown.a.b
    public void drawRunDelegate(com.lynx.markdown.a.c r4, Rect r5) {
        i r6 = (i) ZeusTransformUtils.preCheckCast((com.lynx.markdown.a.c) ZeusTransformUtils.wrapperContextForParams(r4, com.lynx.markdown.a.c.class, "com.obric.aiagent.plugin"), i.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, e.class) == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.aiagent.plugin")).a(this.mCurrentCanvas, r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, d.class) == false) goto L9;
        d r7 = (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin");
        r5.left = 0;
        r5.top = 0;
        r7.a(this.mCurrentCanvas, r5);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, c.class) == false) goto L16;
        Drawable r8 = ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin")).g_();
        if (r8 == null) goto L17;
        r8.setBounds(0, 0, r5.width(), r5.height());
        r8.draw(this.mCurrentCanvas);
        return;
    L17:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mMarkdownParser == null) goto L41;
        WeakReference<f> r0 = this.mWeakMarkdownLayout;
        if (r0 == null) goto L41;
        if (r0.get() == null) goto L41;
        if (((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin")).f() == null) goto L12;
    L15:
        float r1 = r10.getX();
        float r2 = r10.getY();
        if (r10.getAction() != 1) goto L25;
        if (this.mIsInSelection == true) goto L25;
        String[] r3 = this.mMarkdownParser.getLinkByTouchPosition(r1, r2);
        if (r3 == null) goto L25;
        if (r3.length < 2) goto L25;
        ((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin")).a((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin"), r3[0], r3[1]);
    L25:
        if (this.mEnableTextSelection == true) goto L27;
    L39:
        return true;
    L27:
        if (r10.getAction() != 0) goto L30;
        performBeginSelection(r1, r2);
        goto L39
    L30:
        if (r10.getAction() != 2) goto L33;
        performMovingSelection(r1, r2);
        goto L39
    L33:
        if (r10.getAction() != 1) goto L36;
        performEndSelection(r1, r2);
        goto L39
    L36:
        if (this.mShouldResponseMove == false) goto L38;
        performEndSelection(r1, r2);
        goto L39
    L38:
        removeCheckLongPressCallback();
        goto L39
    L12:
        if (this.mEnableTextSelection == true) goto L15;
        return super.onTouchEvent(r10);
    L41:
        return super.onTouchEvent(r10);
    }

    public void setEnableTextSelection(boolean r1) {
        this.mEnableTextSelection = r1;
    }

    public int getMaxStep() {
        WeakReference<f> r0 = this.mWeakMarkdownLayout;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.get() != null) goto L8;
        return 0;
    L8:
        return ((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin")).e();
    }

    public String getParsedContent() {
        WeakReference<f> r0 = this.mWeakMarkdownLayout;
        if (r0 != null) goto L5;
    L14:
        return "";
    L5:
        if (r0.get() == null) goto L14;
        int r1 = ((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin")).c();
        int r2 = ((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin")).d();
        if (r1 > r2) goto L14;
        if (r2 == Integer.MAX_VALUE) goto L14;
        return this.mMarkdownParser.getContentByCharRange(r1, r2);
    }

    private void onSelectionChange() {
        if (this.mWeakMarkdownLayout.get() == null) goto L6;
        ((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin")).a((f) ZeusTransformUtils.preCheckCast(this.mWeakMarkdownLayout.get(), f.class, "com.obric.aiagent.plugin"), this.mSelectStart, this.mSelectEnd, this.mIsForward);
        return;
    }

    public ArrayList<RectF> setTextSelection(float r3, float r4, float r5, float r6) {
        if (r3 >= 0.0f) goto L5;
    L30:
        clearSelection();
        return new ArrayList();
    L5:
        if (r4 < 0.0f) goto L30;
        if (r5 < 0.0f) goto L30;
        if (r6 < 0.0f) goto L30;
        if (this.mMarkdownParser == null) goto L30;
        int r7 = getOffsetForPosition(r3, r4);
        int r8 = getOffsetForPosition(r5, r6);
        if (r7 < 0) goto L28;
        if (r8 < 0) goto L28;
        if (r7 == r8) goto L19;
    L26:
        this.mIsInSelection = true;
        updateSelectionRange(r7, r8);
        updateSelectStartEnd();
        return getTextBoundingBoxes(this.mSelectStart, this.mSelectEnd);
    L19:
        if (r7 == this.mDrawCharCount) goto L25;
        if (r7 > 0) goto L22;
    L24:
        r8 = r8 + 1;
        goto L26
    L22:
        if (r3 >= r5) goto L24;
    L25:
        r7 = r7 - 1;
    L28:
        clearSelection();
        return new ArrayList();
    }

    public ArrayList<RectF> getTextBoundingBoxes(int r3, int r4) {
        if (r3 > r4) goto L8;
        if (r3 < 0) goto L8;
        return this.mMarkdownParser.getSelectionRectByCharPos(r3, r4);
    L8:
        return new ArrayList();
    }

    public ArrayList<Float>[] getHandlesInfo() {
        if (this.mIsInSelection == false) goto L5;
        ArrayList<Float> r2 = new ArrayList();
        r2.add(Float.valueOf(this.mStartHandlerPos.x));
        r2.add(Float.valueOf(this.mStartHandlerPos.y));
        r2.add(Float.valueOf(RESPONSE_TOUCH_RADIUS));
        ArrayList<Float> r1 = new ArrayList();
        r1.add(Float.valueOf(this.mEndHandlerPos.x));
        r1.add(Float.valueOf(this.mEndHandlerPos.y));
        r1.add(Float.valueOf(RESPONSE_TOUCH_RADIUS));
        return new ArrayList[]{r2, r1};
    L5:
        return new ArrayList[0];
    }

    public String getSelectedText() {
        int r0 = this.mSelectStart;
        if (r0 < 0) goto L9;
        int r1 = this.mSelectEnd;
        if (r1 <= 0) goto L11;
        if (r1 > r0) goto L8;
        return "";
    L8:
        return this.mMarkdownParser.getContentByCharRange(r0, r1);
    L11:
        return "";
    L9:
        return "";
    }

    private void initSelectionCursor(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.mTextSelectionCursorColor = ColorStateList.valueOf(DEFAULT_TEXT_CURSOR_COLOR);
        this.mSelectionLeftCursor = this.mViewCallback.getLeftCursorDrawable(r5);
        this.mSelectionRightCursor = this.mViewCallback.getRightCursorDrawable(r5);
        Drawable r6 = this.mSelectionLeftCursor;
        r6.setBounds(0, 0, r6.getIntrinsicWidth() / 2, this.mSelectionLeftCursor.getIntrinsicHeight() / 2);
        Drawable r7 = this.mSelectionRightCursor;
        r7.setBounds(0, 0, r7.getIntrinsicWidth() / 2, this.mSelectionRightCursor.getIntrinsicHeight() / 2);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mSelectionLeftCursor.setTint(this.mTextSelectionCursorColor.getColorForState(getDrawableState(), 0));
        this.mSelectionRightCursor.setTint(this.mTextSelectionCursorColor.getColorForState(getDrawableState(), 0));
        return;
    }

    private void updateSelectionHighlight(int r5) {
        int r0 = Color.red(r5);
        int r1 = Color.green(r5);
        int r2 = Color.blue(r5);
        int r6 = Color.alpha(r5);
        if (r6 != 0) goto L6;
        return;
    L6:
        if (r6 <= 128) goto L8;
        r6 = 128;
    L8:
        this.mHighlightPaint.setColor((((r6 << 24) | (r0 << 16)) | (r1 << 8)) | r2);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
    }

    private int getOffsetForPosition(float r2, float r3) {
        return Math.min(this.mMarkdownParser.getCharPosByPoint(r2, r3), this.mDrawCharCount);
    }

    private void updateSelectionRange(int r8, int r9) {
        if (this.mSelectionLeftCursor != null) goto L5;
        updateSelectionHighlight(DEFAULT_TEXT_SELECTION_COLOR);
        initSelectionCursor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L5:
        int r0 = this.mLastSelectStart;
        int r3 = 0;
        if (r0 != (-1)) goto L10;
        if (r9 > r8) goto L13;
    L9:
        boolean r1 = false;
    L14:
        this.mIsForward = r1;
        this.mLastSelectStart = this.mSelectStart;
        this.mLastSelectEnd = this.mSelectEnd;
        this.mSelectStart = r8;
        this.mSelectEnd = r9;
        if (r8 < 0) goto L33;
        if (r9 < 0) goto L34;
        ArrayList<RectF> r10 = this.mMarkdownParser.getSelectionRectByCharPos(Math.min(r8, r9), Math.max(this.mSelectStart, this.mSelectEnd));
        if (r10.size() <= 0) goto L35;
        this.mHighlightPath.reset();
        RectF r11 = null;
        RectF r2 = null;
    L21:
        if (r3 >= r10.size()) goto L28;
        if (r3 != 0) goto L25;
        r11 = (RectF) ZeusTransformUtils.preCheckCast(r10.get(r3), RectF.class, "com.obric.aiagent.plugin");
    L25:
        if (r3 != (r10.size() - 1)) goto L27;
        r2 = (RectF) ZeusTransformUtils.preCheckCast(r10.get(r3), RectF.class, "com.obric.aiagent.plugin");
    L27:
        this.mHighlightPath.addRect((RectF) ZeusTransformUtils.preCheckCast(r10.get(r3), RectF.class, "com.obric.aiagent.plugin"), Path.Direction.CW);
        r3 = r3 + 1;
        goto L21
    L28:
        this.mHighlightPath.close();
        invalidate();
        this.mSelectStartPos.set(r11.left, r11.bottom);
        this.mSelectEndPos.set(r2.right, r2.bottom);
        this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mSelectStartPos.y + (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mEndHandlerPos.set(this.mSelectEndPos.x + (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mSelectEndPos.y + (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L13:
        r1 = true;
        goto L14
    L10:
        if (r0 < r8) goto L13;
        if (this.mLastSelectEnd >= r9) goto L9;
        goto L9
    }

    private void updateSelectStartEnd() {
        int r0 = Math.min(this.mSelectStart, this.mSelectEnd);
        this.mSelectEnd = Math.max(this.mSelectStart, this.mSelectEnd);
        this.mSelectStart = r0;
        onSelectionChange();
    }

    private void performBeginSelection(float r6, float r7) {
        if (this.mIsInSelection == false) goto L12;
        this.mShouldResponseMove = true;
        if (distanceBetweenPoints(this.mStartHandlerPos, r6, r7) >= 50.0d) goto L8;
        adjustStartPosition(r6, r7);
        this.mViewCallback.requestDisallowInterceptTouchEvent(true);
        goto L12
    L8:
        if (distanceBetweenPoints(this.mEndHandlerPos, r6, r7) >= 50.0d) goto L10;
        adjustEndPosition(r6, r7);
        this.mViewCallback.requestDisallowInterceptTouchEvent(true);
        goto L12
    L10:
        this.mShouldResponseMove = false;
    L12:
        if (this.mIsAdjustEndPos == false) goto L14;
        return;
    L14:
        if (this.mIsAdjustStartPos == true) goto L18;
        removeCheckLongPressCallback();
        a r0 = new a(this, r6, r7);
        this.mCheckForLongPress = r0;
        postDelayed(r0, ViewConfiguration.getLongPressTimeout());
        return;
    }

    private void adjustStartPosition(float r2, float r3) {
        this.mIsAdjustStartPos = true;
        int r4 = getOffsetForPosition(r2, r3);
        if (this.mSelectEnd == r4) goto L5;
    L12:
        updateSelectionRange(r4, this.mSelectEnd);
        return;
    L5:
        if (r4 != this.mDrawCharCount) goto L7;
    L11:
        r4 = r4 - 1;
        goto L12
    L7:
        if (r2 >= this.mSelectEndPos.x) goto L10;
        if (r4 > 0) goto L11;
    L10:
        r4 = r4 + 1;
        goto L12
    }

    private void adjustEndPosition(float r2, float r3) {
        this.mIsAdjustEndPos = true;
        int r4 = getOffsetForPosition(r2, r3);
        if (r4 == this.mSelectStart) goto L5;
    L12:
        updateSelectionRange(this.mSelectStart, r4);
        return;
    L5:
        if (r4 != this.mDrawCharCount) goto L7;
    L11:
        r4 = r4 - 1;
        goto L12
    L7:
        if (r2 >= this.mSelectStartPos.x) goto L10;
        if (r4 > 0) goto L11;
    L10:
        r4 = r4 + 1;
        goto L12
    }

    private void performMovingSelection(float r3, float r4) {
        a r0 = this.mCheckForLongPress;
        if (r0 == null) goto L10;
        if (Math.abs(r3 - a.a(r0)) <= 1.0f) goto L7;
    L8:
        removeCheckLongPressCallback();
        goto L10
    L7:
        if (Math.abs(r4 - a.b(this.mCheckForLongPress)) > 1.0f) goto L8;
    L10:
        if (this.mIsAdjustStartPos == false) goto L13;
        adjustStartPosition(r3, r4);
        return;
    L13:
        if (this.mIsAdjustEndPos == false) goto L17;
        adjustEndPosition(r3, r4);
        return;
    }

    private void performEndSelection(float r4, float r5) {
        this.mViewCallback.requestDisallowInterceptTouchEvent(false);
        if (this.mIsInSelection == true) goto L6;
        removeCheckLongPressCallback();
        return;
    L6:
        boolean r0 = this.mIsAdjustEndPos;
        if (r0 == true) goto L13;
        if (this.mIsAdjustStartPos == true) goto L13;
        clearSelection();
        return;
    L13:
        if (this.mIsAdjustStartPos == false) goto L15;
        adjustStartPosition(r4, r5);
        updateSelectStartEnd();
    L17:
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        return;
    L15:
        if (r0 == false) goto L17;
        adjustEndPosition(r4, r5);
        updateSelectStartEnd();
        goto L17
    }

    private void clearSelection() {
        removeCheckLongPressCallback();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mShouldResponseMove = false;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        this.mHighlightPath.reset();
        if (this.mIsInSelection == false) goto L5;
        invalidate();
        onSelectionChange();
    L5:
        this.mIsInSelection = false;
    }

    private double distanceBetweenPoints(PointF r5, float r6, float r7) {
        return Math.sqrt(Math.pow(r5.x - r6, 2.0d) + Math.pow(r5.y - r7, 2.0d));
    }

    private void removeCheckLongPressCallback() {
        a r0 = this.mCheckForLongPress;
        if (r0 != null) goto L5;
        return;
    L5:
        removeCallbacks(r0);
        this.mCheckForLongPress = null;
    }

    private void drawSelectionCursor(Canvas r5) {
        r5.save();
        r5.translate(this.mStartHandlerPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mStartHandlerPos.y - (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mSelectionLeftCursor.draw(r5);
        r5.restore();
        r5.save();
        r5.translate(this.mEndHandlerPos.x - (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mEndHandlerPos.y - (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        this.mSelectionRightCursor.draw(r5);
        r5.restore();
    }
}
