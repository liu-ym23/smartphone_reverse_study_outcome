package com.bytedance.android.livesdk.summer;

import com.bytedance.android.livesdkapi.service.ISummerService;
import com.bytedance.android.livesdkapi.summer.ISummerTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class j<R> extends c<R> implements ISummerTask {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f158472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f158473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f158474j;

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public int getPriority() {
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public int getTaskType() {
        return 1;
    }

    @ISummerService.TaskID
    public abstract int h();

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void cancelTask() {
        if (this.f158472h != 0) goto L6;
        this.f158472h = 3;
    L9:
        return;
    L6:
        if (this.f158472h != 1) goto L9;
        this.f158473i = true;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final boolean isInterrupt() {
        if (this.f158473i == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f158474j == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void processTask() {
        if (this.f158472h != 0) goto L11;
        this.f158472h = 1;
        run();
        this.f158472h = 2;
        if (this.f158473i == false) goto L8;
        this.f158473i = false;
        this.f158472h = 3;
    L8:
        if (this.f158474j == false) goto L12;
        this.f158474j = false;
        this.f158472h = 4;
        onRelease();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void releaseTask() {
        if (this.f158472h != 1) goto L5;
        this.f158474j = true;
        return;
    L5:
        this.f158472h = 4;
        onRelease();
    }

    public j() {
        String r100 = "summer:" + h();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f158448g = r100;
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final int c() {
        return h();
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final int getStatus() {
        return this.f158472h;
    }
}
