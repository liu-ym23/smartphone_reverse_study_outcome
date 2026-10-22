package com.android.server.am;

import android.app.IObricActivityManager;
import android.app.IObricActivityManagerInternal;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes.dex */
interface IObricActivityManagerService extends IObricBase {
    IObricActivityManager getIObricExt();

    IObricActivityManagerInternal getObricActivityManagerInternal();
}
