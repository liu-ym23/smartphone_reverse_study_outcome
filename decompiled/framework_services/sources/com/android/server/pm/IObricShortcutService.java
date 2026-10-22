package com.android.server.pm;

import android.content.Intent;
import android.content.pm.LauncherApps;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricShortcutService extends IObricBase {
    Boolean startRequestConfirmActivity(Intent r1, int r2, LauncherApps.PinItemRequest r3);
}
