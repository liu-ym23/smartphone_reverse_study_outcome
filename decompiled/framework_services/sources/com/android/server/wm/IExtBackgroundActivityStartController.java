package com.android.server.wm;

import android.content.Intent;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtBackgroundActivityStartController extends IExtBase {
    default boolean checkBackgroundActivityPermission(ActivityTaskManagerService service, int callingUid, String callingPackage, Intent intent) {
        return true;
    }
}
