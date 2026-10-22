package com.android.server.input.debug;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class RotaryInputGraphView extends View {
    private static final float DEFAULT_FRAME_CENTER_POSITION = 0.0f;
    private static final int FRAME_BORDER_GAP_SP = 10;
    private static final int FRAME_COLOR = -1082909881;
    private static final int FRAME_TEXT_OFFSET_SP = 2;
    private static final int FRAME_TEXT_SIZE_SP = 10;
    private static final int FRAME_WIDTH_SP = 2;
    private static final int GRAPH_COLOR = -65281;
    private static final int GRAPH_LINE_WIDTH_SP = 1;
    private static final int GRAPH_POINT_RADIUS_SP = 4;
    private static final long MAX_GESTURE_TIME = 0;
    private static final int MAX_GRAPH_VALUES_SIZE = 400;
    private static final long MAX_SHOWN_TIME_INTERVAL = 0;
    private final Locale mDefaultLocale;
    private final DisplayMetrics mDm;
    private float mFrameCenterPosition;
    private final float mFrameCenterToBorderDistance;
    private final Paint mFramePaint;
    private final Paint mFrameTextPaint;
    private final Paint mGraphLinePaint;
    private final Paint mGraphPointPaint;
    private final CyclicBuffer mGraphValues;
    private final float mScaledVerticalScrollFactor;

    private static class CyclicBuffer {
        private final int mCapacity;
        private int mIteratorCount;
        private int mIteratorIndex;
        private int mLastIndex;
        private final Iterator<GraphValue> mReverseIterator;
        private int mSize;
        private final GraphValue[] mValues;

        /* JADX INFO: renamed from: -$$Nest$fgetmCapacity, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4613$$Nest$fgetmCapacity(CyclicBuffer r0) {
            return r0.mCapacity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIteratorCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4614$$Nest$fgetmIteratorCount(CyclicBuffer r0) {
            return r0.mIteratorCount;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIteratorIndex, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4615$$Nest$fgetmIteratorIndex(CyclicBuffer r0) {
            return r0.mIteratorIndex;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSize, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4616$$Nest$fgetmSize(CyclicBuffer r0) {
            return r0.mSize;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmValues, reason: not valid java name */
        static /* bridge */ /* synthetic */ GraphValue[] m4617$$Nest$fgetmValues(CyclicBuffer r0) {
            return r0.mValues;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIteratorCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4618$$Nest$fputmIteratorCount(CyclicBuffer r0, int r1) {
            r0.mIteratorCount = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIteratorIndex, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4619$$Nest$fputmIteratorIndex(CyclicBuffer r0, int r1) {
            r0.mIteratorIndex = r1;
        }

        CyclicBuffer(int capacity) {
            this.mSize = 0;
            this.mLastIndex = 0;
            this.mReverseIterator = new AnonymousClass1(this);
            this.mCapacity = capacity;
            this.mValues = new GraphValue[capacity];
        }

        void add(float pos, long time) {
            this.mLastIndex = (this.mLastIndex + 1) % this.mCapacity;
            if (this.mValues[this.mLastIndex] != null) goto L5;
            this.mValues[this.mLastIndex] = new GraphValue(pos, time);
        L7:
            if (this.mSize == this.mCapacity) goto L10;
            this.mSize++;
            return;
        L10:
            return;
        L5:
            GraphValue oldValue = this.mValues[this.mLastIndex];
            oldValue.mPos = pos;
            oldValue.mTime = time;
            goto L7
        }

        int getSize() {
            return this.mSize;
        }

        GraphValue getFirst() {
            int distanceBetweenLastAndFirst = (this.mCapacity - this.mSize) + 1;
            int firstIndex = (this.mLastIndex + distanceBetweenLastAndFirst) % this.mCapacity;
            return this.mValues[firstIndex];
        }

        GraphValue getLast() {
            return this.mValues[this.mLastIndex];
        }

        void removeFirst() {
            this.mSize--;
        }

        Iterator<GraphValue> reverseIterator() {
            this.mIteratorIndex = this.mLastIndex;
            this.mIteratorCount = 1;
            return this.mReverseIterator;
        }
    }

    private static class GraphValue {
        float mPos;
        long mTime;

        GraphValue(float pos, long time) {
            this.mPos = pos;
            this.mTime = time;
        }
    }

    static {
        MAX_SHOWN_TIME_INTERVAL = TimeUnit.SECONDS.toMillis(5);
        MAX_GESTURE_TIME = TimeUnit.SECONDS.toMillis(1);
    }

    public RotaryInputGraphView(Context c) {
        super(c);
        this.mDefaultLocale = Locale.getDefault();
        this.mFramePaint = new Paint();
        this.mFrameTextPaint = new Paint();
        this.mGraphLinePaint = new Paint();
        this.mGraphPointPaint = new Paint();
        this.mGraphValues = new CyclicBuffer(400);
        this.mFrameCenterPosition = DEFAULT_FRAME_CENTER_POSITION;
        this.mDm = ((View) this).mContext.getResources().getDisplayMetrics();
        this.mFrameCenterToBorderDistance = this.mDm.heightPixels;
        this.mScaledVerticalScrollFactor = ViewConfiguration.get(c).getScaledVerticalScrollFactor();
        this.mFramePaint.setColor(FRAME_COLOR);
        this.mFramePaint.setStrokeWidth(applyDimensionSp(2, this.mDm));
        this.mFrameTextPaint.setColor(GRAPH_COLOR);
        this.mFrameTextPaint.setTextSize(applyDimensionSp(10, this.mDm));
        this.mGraphLinePaint.setColor(GRAPH_COLOR);
        this.mGraphLinePaint.setStrokeWidth(applyDimensionSp(1, this.mDm));
        this.mGraphLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mGraphLinePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mGraphPointPaint.setColor(GRAPH_COLOR);
        this.mGraphPointPaint.setStrokeWidth(applyDimensionSp(4, this.mDm));
        this.mGraphPointPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mGraphPointPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    public void addValue(float scrollAxisValue, long eventTime) {
    L3:
        if (this.mGraphValues.getSize() <= 0) goto L8;
        if ((eventTime - this.mGraphValues.getFirst().mTime) <= MAX_SHOWN_TIME_INTERVAL) goto L8;
        this.mGraphValues.removeFirst();
    L8:
        if (this.mGraphValues.getSize() != 0) goto L10;
        this.mFrameCenterPosition = DEFAULT_FRAME_CENTER_POSITION;
    L10:
        float displacement = this.mScaledVerticalScrollFactor * scrollAxisValue;
        if (this.mGraphValues.getSize() != 0) goto L13;
        float prevPos = 0.0f;
    L14:
        float pos = prevPos + displacement;
        this.mGraphValues.add(pos, eventTime);
        float verticalDiff = Math.abs(pos - this.mFrameCenterPosition) - this.mFrameCenterToBorderDistance;
        if (verticalDiff > DEFAULT_FRAME_CENTER_POSITION) goto L17;
    L21:
        invalidate();
        return;
    L17:
        if ((pos - this.mFrameCenterPosition) >= DEFAULT_FRAME_CENTER_POSITION) goto L19;
        int sign = -1;
    L20:
        this.mFrameCenterPosition += sign * verticalDiff;
        goto L21
    L19:
        sign = 1;
        goto L20
    L13:
        prevPos = this.mGraphValues.getLast().mPos;
        goto L14
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int verticalMargin = applyDimensionSp(10, this.mDm);
        int bottomY = getHeight() - verticalMargin;
        int middleY = (verticalMargin + bottomY) / 2;
        int rightX = getWidth();
        Canvas r1 = canvas;
        r1.drawLine(DEFAULT_FRAME_CENTER_POSITION, verticalMargin, rightX, verticalMargin, this.mFramePaint);
        r1.drawLine(DEFAULT_FRAME_CENTER_POSITION, middleY, rightX, middleY, this.mFramePaint);
        r1.drawLine(DEFAULT_FRAME_CENTER_POSITION, bottomY, rightX, bottomY, this.mFramePaint);
        int frameTextOffset = applyDimensionSp(2, this.mDm);
        Paint r5 = this.mFrameTextPaint;
        float r14 = DEFAULT_FRAME_CENTER_POSITION;
        r1.drawText(String.format(this.mDefaultLocale, "%.1f", new Object[]{Float.valueOf(this.mFrameCenterPosition + this.mFrameCenterToBorderDistance)}), DEFAULT_FRAME_CENTER_POSITION, verticalMargin - frameTextOffset, r5);
        r1.drawText(String.format(this.mDefaultLocale, "%.1f", new Object[]{Float.valueOf(this.mFrameCenterPosition)}), DEFAULT_FRAME_CENTER_POSITION, middleY - frameTextOffset, this.mFrameTextPaint);
        r1.drawText(String.format(this.mDefaultLocale, "%.1f", new Object[]{Float.valueOf(this.mFrameCenterPosition - this.mFrameCenterToBorderDistance)}), DEFAULT_FRAME_CENTER_POSITION, bottomY - frameTextOffset, this.mFrameTextPaint);
        if (this.mGraphValues.getSize() != 0) goto L5;
        return;
    L5:
        long mostRecentTime = this.mGraphValues.getLast().mTime;
        float coordX = DEFAULT_FRAME_CENTER_POSITION;
        float prevCoordY = DEFAULT_FRAME_CENTER_POSITION;
        Iterator<GraphValue> iter = this.mGraphValues.reverseIterator();
        float prevAge = 0.0f;
    L7:
        if (iter.hasNext() == false) goto L17;
        GraphValue value = iter.next();
        float r17 = r14;
        Iterator<GraphValue> iter2 = iter;
        int age = (int) (mostRecentTime - value.mTime);
        float pos = value.mPos;
        long mostRecentTime2 = mostRecentTime;
        long mostRecentTime3 = age;
        float coordX2 = (((MAX_SHOWN_TIME_INTERVAL - mostRecentTime3) / MAX_SHOWN_TIME_INTERVAL) * (rightX + 0)) + r17;
        float coordY = middleY - ((middleY - verticalMargin) * ((pos - this.mFrameCenterPosition) / this.mFrameCenterToBorderDistance));
        float prevCoordX = coordX;
        r1.drawPoint(coordX2, coordY, this.mGraphPointPaint);
        if (age != 0) goto L11;
        prevCoordY = coordY;
        coordX = coordX2;
    L15:
        float prevCoordY2 = age;
        prevAge = prevCoordY2;
        r14 = r17;
        iter = iter2;
        mostRecentTime = mostRecentTime2;
        r1 = canvas;
        goto L7
    L11:
        if ((age - prevAge) > MAX_GESTURE_TIME) goto L13;
        float prevCoordY3 = prevCoordY;
        prevCoordY = coordY;
        coordX = coordX2;
        canvas.drawLine(prevCoordX, prevCoordY3, coordX, prevCoordY, this.mGraphLinePaint);
        goto L15
    L13:
        prevCoordY = coordY;
        coordX = coordX2;
        goto L15
    }

    public float getFrameCenterPosition() {
        return this.mFrameCenterPosition;
    }

    private static int applyDimensionSp(int dimensionSp, DisplayMetrics dm) {
        return (int) TypedValue.applyDimension(2, dimensionSp, dm);
    }
}
