package com.android.server.wm;

import android.content.ComponentName;
import android.os.IBinder;
import com.obric.utils.ObricImplFactory;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityAssistInfo {
    private final IBinder mActivityToken;
    private final IBinder mAssistToken;
    private final ComponentName mComponentName;
    private final IObricActivityAssistInfo mObricExt;
    private final int mTaskId;
    private final int mUserId;

    public ActivityAssistInfo(ActivityRecord activityRecord) {
        this.mObricExt = (IObricActivityAssistInfo) ObricImplFactory.getImpl(IObricActivityAssistInfo.class, new Object[]{this});
        this.mActivityToken = activityRecord.token;
        this.mAssistToken = activityRecord.assistToken;
        this.mTaskId = activityRecord.getTask().mTaskId;
        this.mComponentName = activityRecord.mActivityComponent;
        this.mUserId = activityRecord.mUserId;
        this.mObricExt.setWindowMode(activityRecord.getWindowingMode());
    }

    public IBinder getActivityToken() {
        return this.mActivityToken;
    }

    public IBinder getAssistToken() {
        return this.mAssistToken;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public IObricActivityAssistInfo getObricExt() {
        return this.mObricExt;
    }
}
