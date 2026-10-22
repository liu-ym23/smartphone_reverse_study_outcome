package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public final class ActivityEvent {
    private static final byte CREATE = 1;
    private static final byte DESTROY = 2;
    private static final byte PAUSE = 6;
    private static final byte RESUME = 5;
    private static final byte START = 3;
    private static final byte STOP = 4;
    public final WeakReference<Activity> activity;
    public final byte event;

    public Activity activity() {
        return this.activity.get();
    }

    public boolean isCreate() {
        if (this.event == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isDestroy() {
        if (this.event != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPause() {
        if (this.event != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isResume() {
        if (this.event != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStart() {
        if (this.event != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStop() {
        if (this.event != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static ActivityEvent ofCreate(Activity r100) {
        return new ActivityEvent(r100, (byte) 1);
    }

    public static ActivityEvent ofDestroy(Activity r100) {
        return new ActivityEvent(r100, (byte) 2);
    }

    public static ActivityEvent ofPause(Activity r100) {
        return new ActivityEvent(r100, (byte) 6);
    }

    public static ActivityEvent ofResume(Activity r100) {
        return new ActivityEvent(r100, (byte) 5);
    }

    public static ActivityEvent ofStart(Activity r100) {
        return new ActivityEvent(r100, (byte) 3);
    }

    public static ActivityEvent ofStop(Activity r100) {
        return new ActivityEvent(r100, (byte) 4);
    }

    private ActivityEvent(Activity r100, byte r101) {
        this.activity = new WeakReference(r100);
        this.event = r101;
    }
}
