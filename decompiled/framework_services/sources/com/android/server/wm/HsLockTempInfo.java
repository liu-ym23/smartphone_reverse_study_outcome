package com.android.server.wm;

import android.app.ActivityOptions;
import android.service.voice.IVoiceInteractionSession;
import com.android.internal.app.IVoiceInteractor;

/* JADX INFO: loaded from: classes3.dex */
public class HsLockTempInfo {
    public boolean doResume;
    public Task inTask;
    public ActivityOptions options;
    public ActivityRecord r;
    public ActivityRecord sourceRecord;
    public int startFlags;
    public IVoiceInteractor voiceInteractor;
    public IVoiceInteractionSession voiceSession;

    public HsLockTempInfo() {
    }

    public boolean isPackage(String pkgName) {
        if (this.r != null) goto L5;
        return false;
    L5:
        if (this.r.packageName != null) goto L7;
        return false;
    L7:
        if (this.r.packageName.equals(pkgName) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public void reset() {
        this.r = null;
        this.sourceRecord = null;
        this.voiceSession = null;
        this.voiceInteractor = null;
        this.startFlags = 0;
        this.doResume = false;
        this.options = null;
        this.inTask = null;
    }
}
