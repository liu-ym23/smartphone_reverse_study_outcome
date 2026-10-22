package com.bytedance.android.livesdk.player.utils;

import android.os.Build;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes11.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f156228a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReentrantLock f156229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Condition f156230b;

        public a() {
            if (Build.VERSION.SDK_INT < 34) goto L6;
            ReentrantLock r100 = new ReentrantLock();
            this.f156229a = r100;
            this.f156230b = r100.newCondition();
            return;
        }
    }

    static {
    }
}
