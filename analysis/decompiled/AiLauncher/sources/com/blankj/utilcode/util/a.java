package com.blankj.utilcode.util;

import android.app.Activity;

/* loaded from: classes.dex */
public final class a {
    public static boolean a(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
