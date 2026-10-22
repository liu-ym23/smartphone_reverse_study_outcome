package com.android.server.accessibility;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public interface EventStreamTransformation {
    EventStreamTransformation getNext();

    void setNext(EventStreamTransformation r1);

    default void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        EventStreamTransformation next = getNext();
        if (next == null) goto L6;
        next.onMotionEvent(event, rawEvent, policyFlags);
        return;
    }

    default void onKeyEvent(KeyEvent event, int policyFlags) {
        EventStreamTransformation next = getNext();
        if (next == null) goto L6;
        next.onKeyEvent(event, policyFlags);
        return;
    }

    default void onAccessibilityEvent(AccessibilityEvent event) {
        EventStreamTransformation next = getNext();
        if (next == null) goto L6;
        next.onAccessibilityEvent(event);
        return;
    }

    default void clearEvents(int inputSource) {
        EventStreamTransformation next = getNext();
        if (next == null) goto L6;
        next.clearEvents(inputSource);
        return;
    }

    default void onDestroy() {
    }
}
