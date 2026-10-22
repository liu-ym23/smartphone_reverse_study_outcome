package com.android.server.input.debug;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Slog;
import android.view.View;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.input.TouchpadFingerState;
import com.android.server.input.TouchpadHardwareProperties;
import com.android.server.input.TouchpadHardwareState;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TouchpadVisualizationView extends View {
    private static final boolean DEBUG = true;
    private static final float DEFAULT_RES_X = 47.0f;
    private static final float DEFAULT_RES_Y = 45.0f;
    private static final float MAX_TRACE_HISTORY_DURATION_SECONDS = 1.0f;
    private static final String TAG = "TouchpadVizMain";
    private final Paint mCenterPointPaint;
    private final ArrayDeque<TouchpadHardwareState> mHardwareStateHistory;
    private final Paint mOvalFillPaint;
    private final Paint mOvalStrokePaint;
    private final Paint mPressureTextPaint;
    private float mScaleFactor;
    private final Map<Integer, TouchpadFingerState> mTempFingerStatesByTrackingId;
    private final RectF mTempOvalRect;
    private final TouchpadHardwareProperties mTouchpadHardwareProperties;
    private final Paint mTracePaint;

    public TouchpadVisualizationView(Context context, TouchpadHardwareProperties touchpadHardwareProperties) {
        super(context);
        this.mHardwareStateHistory = new ArrayDeque();
        this.mTempFingerStatesByTrackingId = new HashMap();
        this.mTempOvalRect = new RectF();
        this.mTouchpadHardwareProperties = touchpadHardwareProperties;
        this.mScaleFactor = 1.0f;
        this.mOvalStrokePaint = new Paint();
        this.mOvalStrokePaint.setAntiAlias(true);
        this.mOvalStrokePaint.setStyle(Paint.Style.STROKE);
        this.mOvalFillPaint = new Paint();
        this.mOvalFillPaint.setAntiAlias(true);
        this.mTracePaint = new Paint();
        this.mTracePaint.setAntiAlias(false);
        this.mTracePaint.setARGB(255, 0, 0, 255);
        this.mTracePaint.setStyle(Paint.Style.STROKE);
        this.mTracePaint.setStrokeWidth(2.0f);
        this.mCenterPointPaint = new Paint();
        this.mCenterPointPaint.setAntiAlias(true);
        this.mCenterPointPaint.setARGB(255, 255, 0, 0);
        this.mCenterPointPaint.setStrokeWidth(2.0f);
        this.mPressureTextPaint = new Paint();
        this.mPressureTextPaint.setAntiAlias(true);
    }

    private void removeOldPoints() {
        float latestTimestamp = this.mHardwareStateHistory.getLast().getTimestamp();
    L4:
        if (this.mHardwareStateHistory.isEmpty() == true) goto L8;
        TouchpadHardwareState oldestPoint = this.mHardwareStateHistory.getFirst();
        float onScreenTime = latestTimestamp - oldestPoint.getTimestamp();
        if (onScreenTime < 1.0f) goto L11;
        this.mHardwareStateHistory.removeFirst();
        goto L4
    L11:
        return;
    }

    private void drawOval(Canvas canvas, float x, float y, float major, float minor, float angle) {
        canvas.save(1);
        canvas.rotate(angle, x, y);
        float r2 = x - (minor / 2.0f);
        this.mTempOvalRect.left = r2;
        float r3 = (minor / 2.0f) + x;
        this.mTempOvalRect.right = r3;
        float r4 = y - (major / 2.0f);
        this.mTempOvalRect.top = r4;
        float r1 = (major / 2.0f) + y;
        this.mTempOvalRect.bottom = r1;
        canvas.drawOval(this.mTempOvalRect, this.mOvalStrokePaint);
        canvas.drawOval(this.mTempOvalRect, this.mOvalFillPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        TouchpadVisualizationView r0 = this;
        if (r0.mHardwareStateHistory.isEmpty() == false) goto L5;
        return;
    L5:
        TouchpadHardwareState latestHardwareState = r0.mHardwareStateHistory.getLast();
        TouchpadFingerState[] r2 = latestHardwareState.getFingerStates();
        int r3 = r2.length;
        float maximumPressure = 0.0f;
        int r1 = 0;
    L6:
        if (r1 >= r3) goto L8;
        maximumPressure = Math.max(maximumPressure, r2[r1].getPressure());
        r1 = r1 + 1;
        goto L6
    L8:
        TouchpadFingerState[] r9 = latestHardwareState.getFingerStates();
        int r10 = r9.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L19;
        TouchpadFingerState touchpadFingerState = r9[r11];
        float newX = r0.translateX(touchpadFingerState.getPositionX());
        float newY = r0.translateY(touchpadFingerState.getPositionY());
        float newAngle = r0.translateRange(0.0f, r0.mTouchpadHardwareProperties.getOrientationMaximum(), 0.0f, 90.0f, touchpadFingerState.getOrientation());
        if (r0.mTouchpadHardwareProperties.getResX() != 0.0f) goto L13;
        float r4 = DEFAULT_RES_X;
    L14:
        float resX = r4;
        if (r0.mTouchpadHardwareProperties.getResY() != 0.0f) goto L17;
        float r5 = DEFAULT_RES_Y;
    L18:
        float resY = r5;
        float newTouchMajor = (touchpadFingerState.getTouchMajor() * r0.mScaleFactor) / resY;
        float newTouchMinor = (touchpadFingerState.getTouchMinor() * r0.mScaleFactor) / resX;
        float maximumPressure2 = maximumPressure;
        float pressureToOpacity = r0.translateRange(0.0f, maximumPressure2, 0.0f, 255.0f, touchpadFingerState.getPressure());
        r0.mOvalFillPaint.setAlpha((int) pressureToOpacity);
        r0.drawOval(canvas, newX, newY, newTouchMajor, newTouchMinor, newAngle);
        TouchpadVisualizationView r6 = r0;
        String formattedPressure = String.format(Locale.getDefault(), "Ps: %.2f", new Object[]{Float.valueOf(touchpadFingerState.getPressure())});
        float textWidth = r6.mPressureTextPaint.measureText(formattedPressure);
        float newAngle2 = newY - (newTouchMajor / 2.0f);
        canvas.drawText(formattedPressure, newX - (textWidth / 2.0f), newAngle2, r6.mPressureTextPaint);
        r11 = r11 + 1;
        r0 = r6;
        maximumPressure = maximumPressure2;
        goto L9
    L17:
        r5 = r0.mTouchpadHardwareProperties.getResY();
        goto L18
    L13:
        r4 = r0.mTouchpadHardwareProperties.getResX();
        goto L14
    L19:
        TouchpadVisualizationView r7 = r0;
        r7.mTempFingerStatesByTrackingId.clear();
        Iterator<TouchpadHardwareState> r8 = r7.mHardwareStateHistory.iterator();
    L21:
        if (r8.hasNext() == false) goto L31;
        TouchpadHardwareState currentHardwareState = r8.next();
        TouchpadFingerState[] r12 = currentHardwareState.getFingerStates();
        int r13 = r12.length;
        int r14 = 0;
    L24:
        if (r14 >= r13) goto L21;
        TouchpadFingerState currentFingerState = r12[r14];
        TouchpadFingerState prevFingerState = r7.mTempFingerStatesByTrackingId.put(Integer.valueOf(currentFingerState.getTrackingId()), currentFingerState);
        if (prevFingerState == null) goto L29;
        float currentX = r7.translateX(currentFingerState.getPositionX());
        float currentY = r7.translateY(currentFingerState.getPositionY());
        float prevX = r7.translateX(prevFingerState.getPositionX());
        float prevY = r7.translateY(prevFingerState.getPositionY());
        canvas.drawLine(prevX, prevY, currentX, currentY, r7.mTracePaint);
        canvas.drawPoint(currentX, currentY, r7.mCenterPointPaint);
    L29:
        r14 = r14 + 1;
        goto L24
    }

    public void onTouchpadHardwareStateNotified(TouchpadHardwareState schs) {
        logHardwareState(schs);
        if (this.mHardwareStateHistory.isEmpty() == false) goto L5;
    L9:
        this.mHardwareStateHistory.addLast(schs);
        removeOldPoints();
        logFingerTrace();
        invalidate();
        return;
    L5:
        if (this.mHardwareStateHistory.getLast().getFingerCount() != 0) goto L9;
        if (schs.getFingerCount() <= 0) goto L9;
        this.mHardwareStateHistory.clear();
        goto L9
    }

    public void updateScaleFactor(float scaleFactor) {
        this.mScaleFactor = scaleFactor;
    }

    public void setLightModeTheme() {
        setBackgroundColor(Color.rgb(20, 20, 20));
        this.mPressureTextPaint.setARGB(255, 255, 255, 255);
        this.mOvalFillPaint.setARGB(255, 255, 255, 255);
        this.mOvalStrokePaint.setARGB(255, 255, 255, 255);
    }

    public void setNightModeTheme() {
        setBackgroundColor(Color.rgb(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED));
        this.mPressureTextPaint.setARGB(255, 0, 0, 0);
        this.mOvalFillPaint.setARGB(255, 0, 0, 0);
        this.mOvalStrokePaint.setARGB(255, 0, 0, 0);
    }

    private float translateX(float x) {
        return translateRange(this.mTouchpadHardwareProperties.getLeft(), this.mTouchpadHardwareProperties.getRight(), 0.0f, getWidth(), x);
    }

    private float translateY(float y) {
        return translateRange(this.mTouchpadHardwareProperties.getTop(), this.mTouchpadHardwareProperties.getBottom(), 0.0f, getHeight(), y);
    }

    private float translateRange(float rangeBeforeMin, float rangeBeforeMax, float rangeAfterMin, float rangeAfterMax, float value) {
        return (((value - rangeBeforeMin) / (rangeBeforeMax - rangeBeforeMin)) * (rangeAfterMax - rangeAfterMin)) + rangeAfterMin;
    }

    private void logHardwareState(TouchpadHardwareState schs) {
        Slog.d(TAG, "notifyTouchpadHardwareState: Time: " + schs.getTimestamp() + ", No. Buttons: " + schs.getButtonsDown() + ", No. Fingers: " + schs.getFingerCount() + ", No. Touch: " + schs.getTouchCount());
        TouchpadFingerState[] r0 = schs.getFingerStates();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        TouchpadFingerState finger = r0[r3];
        Slog.d(TAG, "Finger #" + finger.getTrackingId() + ": touchMajor= " + finger.getTouchMajor() + ", touchMinor= " + finger.getTouchMinor() + ", widthMajor= " + finger.getWidthMajor() + ", widthMinor= " + finger.getWidthMinor() + ", pressure= " + finger.getPressure() + ", orientation= " + finger.getOrientation() + ", positionX= " + finger.getPositionX() + ", positionY= " + finger.getPositionY());
        r3 = r3 + 1;
        goto L3
    }

    private void logFingerTrace() {
        Slog.d(TAG, "Trace size= " + this.mHardwareStateHistory.size());
        TouchpadFingerState[] r0 = this.mHardwareStateHistory.getLast().getFingerStates();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        TouchpadFingerState tfs = r0[r3];
        Slog.d(TAG, "ID= " + tfs.getTrackingId());
        r3 = r3 + 1;
        goto L3
    }
}
