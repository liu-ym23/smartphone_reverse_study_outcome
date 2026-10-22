package com.obric.autogui.common.api.platform.display;

import android.content.ComponentName;

/* JADX INFO: compiled from: DisplayedAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DisplayedAppInfo {
    ComponentName getBaseActivity();

    String getData();

    ComponentName getRealActivity();

    int getTaskId();

    CharSequence getTaskLabel();

    ComponentName getTopActivity();

    boolean isVisible();
}
