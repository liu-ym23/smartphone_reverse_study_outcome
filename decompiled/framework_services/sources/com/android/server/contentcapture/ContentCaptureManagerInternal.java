package com.android.server.contentcapture;

import android.app.assist.ActivityId;
import android.content.ComponentName;
import android.content.ContentCaptureOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContentCaptureManagerInternal {
    public abstract ContentCaptureOptions getOptionsForPackage(int r1, String r2);

    public abstract boolean isContentCaptureServiceForUser(int r1, int r2);

    public abstract void notifyActivityEvent(int r1, ComponentName r2, int r3, ActivityId r4);

    public abstract boolean sendActivityAssistData(int r1, IBinder r2, Bundle r3);

    public abstract boolean sendActivityStartAssistData(int r1, IBinder r2, Intent r3);

    public ContentCaptureManagerInternal() {
    }
}
