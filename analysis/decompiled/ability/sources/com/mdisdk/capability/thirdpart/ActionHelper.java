package com.mdisdk.capability.thirdpart;

import I4.l;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.dsl.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ActionHelper {
    private static final long DEFAULT_SCROLL_DURATION = 300;
    private static final long DOUBLE_CLICK_INTERVAL = 100;
    private static final long LONG_CLICK_DURATION = 500;
    private static final int MAX_SCROLL_DISTANCE = 400;
    private static final String TAG = "APEX-ActionHelper";

    private static List<MotionEvent> createClickEvents(Point point) {
        ArrayList arrayList = new ArrayList();
        long jUptimeMillis = SystemClock.uptimeMillis();
        arrayList.add(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, point.x, point.y, 0));
        arrayList.add(MotionEvent.obtain(jUptimeMillis, 50 + jUptimeMillis, 1, point.x, point.y, 0));
        return arrayList;
    }

    private static List<MotionEvent> createDoubleClickEvents(Point point) {
        ArrayList arrayList = new ArrayList();
        long jUptimeMillis = SystemClock.uptimeMillis();
        arrayList.add(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, point.x, point.y, 0));
        arrayList.add(MotionEvent.obtain(jUptimeMillis, 50 + jUptimeMillis, 1, point.x, point.y, 0));
        long j5 = jUptimeMillis + 150;
        arrayList.add(MotionEvent.obtain(j5, j5, 0, point.x, point.y, 0));
        arrayList.add(MotionEvent.obtain(j5, jUptimeMillis + 200, 1, point.x, point.y, 0));
        return arrayList;
    }

    private static List<MotionEvent> createLongClickEvents(Point point, long j5) {
        ArrayList arrayList = new ArrayList();
        long jUptimeMillis = SystemClock.uptimeMillis();
        arrayList.add(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, point.x, point.y, 0));
        arrayList.add(MotionEvent.obtain(jUptimeMillis, jUptimeMillis + j5, 1, point.x, point.y, 0));
        return arrayList;
    }

    private static List<MotionEvent> createSwipeEvents(Point point, Point point2, long j5) {
        ArrayList arrayList = new ArrayList();
        long jUptimeMillis = SystemClock.uptimeMillis();
        arrayList.add(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, point.x, point.y, 0));
        for (int i = 1; i <= 10; i++) {
            float f = i / 10;
            arrayList.add(MotionEvent.obtain(jUptimeMillis, ((long) (j5 * f)) + jUptimeMillis, 2, ((point2.x - r3) * f) + point.x, ((point2.y - r3) * f) + point.y, 0));
        }
        arrayList.add(MotionEvent.obtain(jUptimeMillis, jUptimeMillis + j5, 1, point2.x, point2.y, 0));
        return arrayList;
    }

    private static boolean dispatchEvents(@NonNull View view, @NonNull List<MotionEvent> list) {
        Iterator<MotionEvent> it = list.iterator();
        long j5 = 0;
        while (it.hasNext()) {
            view.postDelayed(new l(10, view, it.next()), j5);
            j5 += 50;
        }
        Log.d(TAG, "Dispatched " + list.size() + " motion events");
        return true;
    }

    public static Rect getBoundsOnScreen(@NonNull View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Rect rect = new Rect();
        try {
            View.class.getMethod("getBoundsOnScreen", Rect.class).invoke(view, rect);
            return rect;
        } catch (Exception unused) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            rect.set(i, iArr[1], view.getWidth() + i, view.getHeight() + iArr[1]);
            return rect;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dispatchEvents$0(View view, MotionEvent motionEvent) {
        try {
            view.dispatchTouchEvent(motionEvent);
        } finally {
            motionEvent.recycle();
        }
    }

    public static boolean performClick(@NonNull View view, int i, int i6) {
        Log.d(TAG, "performClick on " + view.getClass().getSimpleName() + " at local (" + i + ", " + i6 + ")");
        return dispatchEvents(view, createClickEvents(new Point(i, i6)));
    }

    public static boolean performDoubleClick(@NonNull View view, int i, int i6) {
        Log.d(TAG, "performDoubleClick on " + view.getClass().getSimpleName() + " at local (" + i + ", " + i6 + ")");
        return dispatchEvents(view, createDoubleClickEvents(new Point(i, i6)));
    }

    public static boolean performLongClick(@NonNull View view, int i, int i6, long j5) {
        if (j5 <= 0) {
            j5 = 500;
        }
        Log.d(TAG, "performLongClick on " + view.getClass().getSimpleName() + " at local (" + i + ", " + i6 + "), duration=" + j5);
        return dispatchEvents(view, createLongClickEvents(new Point(i, i6), j5));
    }

    public static boolean performScrollDown(@NonNull View view, @NonNull Rect rect) {
        Log.d(TAG, "performScrollDown in bounds " + rect);
        int i = rect.bottom - rect.top;
        int iMin = (i - Math.min(i, MAX_SCROLL_DISTANCE)) / 2;
        return dispatchEvents(view, createSwipeEvents(new Point(rect.centerX(), rect.top + iMin), new Point(rect.centerX(), rect.bottom - iMin), DEFAULT_SCROLL_DURATION));
    }

    public static boolean performScrollLeft(@NonNull View view, @NonNull Rect rect) {
        Log.d(TAG, "performScrollLeft in bounds " + rect);
        int i = rect.right - rect.left;
        int iMin = (i - Math.min(i, MAX_SCROLL_DISTANCE)) / 2;
        return dispatchEvents(view, createSwipeEvents(new Point(rect.left + iMin, rect.centerY()), new Point(rect.right - iMin, rect.centerY()), DEFAULT_SCROLL_DURATION));
    }

    public static boolean performScrollRight(@NonNull View view, @NonNull Rect rect) {
        Log.d(TAG, "performScrollRight in bounds " + rect);
        int i = rect.right - rect.left;
        int iMin = (i - Math.min(i, MAX_SCROLL_DISTANCE)) / 2;
        return dispatchEvents(view, createSwipeEvents(new Point(rect.right - iMin, rect.centerY()), new Point(rect.left + iMin, rect.centerY()), DEFAULT_SCROLL_DURATION));
    }

    public static boolean performScrollUp(@NonNull View view, @NonNull Rect rect) {
        Log.d(TAG, "performScrollUp in bounds " + rect);
        int i = rect.bottom - rect.top;
        int iMin = (i - Math.min(i, MAX_SCROLL_DISTANCE)) / 2;
        return dispatchEvents(view, createSwipeEvents(new Point(rect.centerX(), rect.bottom - iMin), new Point(rect.centerX(), rect.top + iMin), DEFAULT_SCROLL_DURATION));
    }

    public static boolean performSwipe(@NonNull View view, int i, int i6, int i10, int i11, long j5) {
        if (j5 <= 0) {
            j5 = DEFAULT_SCROLL_DURATION;
        }
        StringBuilder sb = new StringBuilder("performSwipe on ");
        sb.append(view.getClass().getSimpleName());
        sb.append(" from local (");
        sb.append(i);
        sb.append(", ");
        a.y(sb, i6, ") to (", i10, ", ");
        sb.append(i11);
        sb.append("), duration=");
        sb.append(j5);
        Log.d(TAG, sb.toString());
        return dispatchEvents(view, createSwipeEvents(new Point(i, i6), new Point(i10, i11), j5));
    }
}
