package com.android.server.wm;

import android.app.ResultInfo;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
final class ActivityResult extends ResultInfo {
    final ActivityRecord mFrom;

    public ActivityResult(ActivityRecord from, String resultWho, int requestCode, int resultCode, Intent data, IBinder callerToken) {
        super(resultWho, requestCode, resultCode, data, callerToken);
        this.mFrom = from;
    }
}
