package com.bytedance.bdtracker;

import com.bytedance.applog.profile.UserProfileCallback;

/* loaded from: classes.dex */
public class w3 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ y3 b;

    public w3(y3 y3Var, int i) {
        this.b = y3Var;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.b.d;
        if (userProfileCallback != null) {
            userProfileCallback.onFail(this.a);
        }
    }
}
