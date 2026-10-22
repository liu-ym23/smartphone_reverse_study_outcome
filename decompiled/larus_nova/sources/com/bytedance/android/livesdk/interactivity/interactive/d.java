package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f137171a = null;

    static {
        int[] r100 = new int[IBaseUser.Status.values().length];
        f137171a = r100;
        r100[IBaseUser.Status.Login.ordinal()] = 1;
        r100[IBaseUser.Status.Logout.ordinal()] = 2;
        r100[IBaseUser.Status.Update.ordinal()] = 3;
    }
}
