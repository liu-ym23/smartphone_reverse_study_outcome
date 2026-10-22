package com.android.server.wm;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes3.dex */
public interface IWindowAnimatorOpt {
    public static final int ANIMATION_BOOST_ENABLE = 1;
    public static final int ANIMATION_BOOST_RELEASE = 2;
    public static final int ANIMATION_BOOST_TIMEINTERVAL = 800;
    public static final int ANIMATION_BOOST_TIMEOUT = 2000;

    default void scheduleAnimationBoost() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
