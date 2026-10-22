package com.bytedance.apm.insight;

import android.app.Activity;

/* loaded from: classes2.dex */
public interface IActivityLeakListener {
    void onActivityLeaked(Activity activity);
}
