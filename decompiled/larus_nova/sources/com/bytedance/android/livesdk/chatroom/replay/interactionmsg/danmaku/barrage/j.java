package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f109016a = null;

    static {
        f109016a = new j();
    }

    public j() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        double r101 = r100;
        return (float) ((Math.pow(2.0d, (-10.0d) * r101) * Math.sin(((r101 - (1.5d / ((double) 4))) * 6.283185307179586d) / 1.5d)) + ((double) 1));
    }
}
