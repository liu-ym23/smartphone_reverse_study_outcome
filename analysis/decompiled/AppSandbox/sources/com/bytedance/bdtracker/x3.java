package com.bytedance.bdtracker;

import com.bytedance.applog.profile.UserProfileCallback;

/* loaded from: classes.dex */
public class x3 implements Runnable {
    public final /* synthetic */ y3 a;

    public x3(y3 y3Var) {
        this.a = y3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.a.d;
        if (userProfileCallback != null) {
            userProfileCallback.onSuccess();
        }
    }
}
