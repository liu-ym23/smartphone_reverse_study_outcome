package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class LaunchParamsController {
    private final List<LaunchParamsModifier> mModifiers;
    private final LaunchParamsPersister mPersister;
    private final ActivityTaskManagerService mService;
    private final LaunchParams mTmpCurrent;
    private final LaunchParams mTmpParams;
    private final LaunchParams mTmpResult;

    static class LaunchParams {
        final Rect mAppBounds;
        final Rect mBounds;
        Boolean mNeedsSafeRegionBounds;
        TaskDisplayArea mPreferredTaskDisplayArea;
        int mWindowingMode;

        LaunchParams() {
            this.mBounds = new Rect();
            this.mAppBounds = new Rect();
            this.mNeedsSafeRegionBounds = null;
        }

        void reset() {
            this.mBounds.setEmpty();
            this.mAppBounds.setEmpty();
            this.mPreferredTaskDisplayArea = null;
            this.mWindowingMode = 0;
            this.mNeedsSafeRegionBounds = null;
        }

        void set(LaunchParams params) {
            this.mBounds.set(params.mBounds);
            this.mAppBounds.set(params.mAppBounds);
            this.mPreferredTaskDisplayArea = params.mPreferredTaskDisplayArea;
            this.mWindowingMode = params.mWindowingMode;
            this.mNeedsSafeRegionBounds = params.mNeedsSafeRegionBounds;
        }

        void merge(LaunchParams params) {
            this.mBounds.set(params.mBounds);
            this.mAppBounds.set(params.mAppBounds);
            this.mPreferredTaskDisplayArea = params.mPreferredTaskDisplayArea;
            this.mWindowingMode = params.mWindowingMode;
            if (params.mNeedsSafeRegionBounds == null) goto L6;
            this.mNeedsSafeRegionBounds = params.mNeedsSafeRegionBounds;
            return;
        }

        boolean isEmpty() {
            if (this.mBounds.isEmpty() == true) goto L5;
        L13:
            return false;
        L5:
            if (this.mAppBounds.isEmpty() == false) goto L13;
            if (this.mPreferredTaskDisplayArea != null) goto L13;
            if (this.mWindowingMode != 0) goto L13;
            if (this.mNeedsSafeRegionBounds != null) goto L13;
            return true;
        }

        boolean hasWindowingMode() {
            if (this.mWindowingMode == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasPreferredTaskDisplayArea() {
            if (this.mPreferredTaskDisplayArea == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L27:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L27;
            LaunchParams that = (LaunchParams) o;
            if (this.mPreferredTaskDisplayArea == that.mPreferredTaskDisplayArea) goto L14;
            return false;
        L14:
            if (this.mWindowingMode == that.mWindowingMode) goto L17;
            return false;
        L17:
            if (this.mAppBounds.equals(that.mAppBounds) == true) goto L20;
            return false;
        L20:
            if (Objects.equals(this.mNeedsSafeRegionBounds, that.mNeedsSafeRegionBounds) == true) goto L23;
            return false;
        L23:
            if (this.mBounds.isEmpty() == true) goto L26;
            return this.mBounds.equals(that.mBounds);
        L26:
            return that.mBounds.isEmpty();
        }

        public int hashCode() {
            int r1 = 0;
            if (this.mBounds.isEmpty() == true) goto L5;
            int result = this.mBounds.hashCode();
        L6:
            int result2 = ((result * 31) + this.mAppBounds.hashCode()) * 31;
            if (this.mPreferredTaskDisplayArea == null) goto L9;
            int r3 = this.mPreferredTaskDisplayArea.hashCode();
        L10:
            int result3 = (((result2 + r3) * 31) + this.mWindowingMode) * 31;
            if (this.mNeedsSafeRegionBounds == null) goto L15;
            r1 = Boolean.hashCode(this.mNeedsSafeRegionBounds.booleanValue());
        L15:
            return result3 + r1;
        L9:
            r3 = 0;
            goto L10
        L5:
            result = 0;
            goto L6
        }
    }

    interface LaunchParamsModifier {
        public static final int PHASE_BOUNDS = 3;
        public static final int PHASE_DISPLAY = 0;
        public static final int PHASE_DISPLAY_AREA = 2;
        public static final int PHASE_WINDOWING_MODE = 1;
        public static final int RESULT_CONTINUE = 2;
        public static final int RESULT_DONE = 1;
        public static final int RESULT_SKIP = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Phase {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface Result {
        }

        int onCalculate(Task r1, ActivityInfo.WindowLayout r2, ActivityRecord r3, ActivityRecord r4, ActivityOptions r5, ActivityStarter.Request r6, int r7, LaunchParams r8, LaunchParams r9);
    }

    LaunchParamsController(ActivityTaskManagerService service, LaunchParamsPersister persister) {
        this.mModifiers = new ArrayList();
        this.mTmpParams = new LaunchParams();
        this.mTmpCurrent = new LaunchParams();
        this.mTmpResult = new LaunchParams();
        this.mService = service;
        this.mPersister = persister;
    }

    void registerDefaultModifiers(ActivityTaskSupervisor supervisor) {
        registerModifier(new TaskLaunchParamsModifier(supervisor));
        registerModifier(new DesktopModeLaunchParamsModifier(this.mService.mContext));
    }

    void calculate(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityRecord source, ActivityOptions options, ActivityStarter.Request request, int phase, LaunchParams result) {
        result.reset();
        if (task != null) goto L5;
        if (activity != null) goto L5;
    L6:
        int i = this.mModifiers.size() - 1;
    L7:
        if (i < 0) goto L17;
        this.mTmpCurrent.set(result);
        this.mTmpResult.reset();
        LaunchParamsModifier modifier = this.mModifiers.get(i);
        switch(modifier.onCalculate(task, layout, activity, source, options, request, phase, this.mTmpCurrent, this.mTmpResult)) {
            case 0: goto L15;
            case 1: goto L12;
            case 2: goto L11;
            default: goto L15;
        };
    L11:
        result.merge(this.mTmpResult);
        goto L15
    L12:
        result.merge(this.mTmpResult);
        return;
    L15:
        i = i - 1;
        goto L7
    L17:
        if (activity == null) goto L22;
        if (activity.requestedVrComponent == null) goto L22;
        result.mPreferredTaskDisplayArea = this.mService.mRootWindowContainer.getDefaultTaskDisplayArea();
        return;
    L22:
        if (this.mService.mVr2dDisplayId == (-1)) goto L30;
        result.mPreferredTaskDisplayArea = this.mService.mRootWindowContainer.getDisplayContent(this.mService.mVr2dDisplayId).getDefaultTaskDisplayArea();
        return;
    L30:
        return;
    L5:
        this.mPersister.getLaunchParams(task, activity, result);
        goto L6
    }

    boolean layoutTask(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityRecord source, ActivityOptions options) {
        calculate(task, layout, activity, source, options, null, 3, this.mTmpParams);
        if (this.mTmpParams.isEmpty() == false) goto L5;
    L23:
        return false;
    L5:
        if (this.mTmpParams.mBounds.isEmpty() == true) goto L23;
        this.mService.deferWindowLayout();
    L13:
        th = move-exception;
        this.mService.continueWindowLayout();
        throw th;
    L9:
        if (task.getRootTask().inMultiWindowMode() == true) goto L11;
        task.setLastNonFullscreenBounds(this.mTmpParams.mBounds);     // Catch: Throwable -> L13
        this.mService.continueWindowLayout();
        return false;
    L11:
        if (this.mTmpParams.mAppBounds.isEmpty() == true) goto L15;
        task.getRequestedOverrideConfiguration().windowConfiguration.setAppBounds(this.mTmpParams.mAppBounds);     // Catch: Throwable -> L13
    L15:
        task.setBounds(this.mTmpParams.mBounds);     // Catch: Throwable -> L13
        this.mService.continueWindowLayout();
        return true;
    }

    void registerModifier(LaunchParamsModifier modifier) {
        if (this.mModifiers.contains(modifier) == false) goto L5;
        return;
    L5:
        this.mModifiers.add(modifier);
    }
}
