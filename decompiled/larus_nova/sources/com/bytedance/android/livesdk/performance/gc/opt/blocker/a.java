package com.bytedance.android.livesdk.performance.gc.opt.blocker;

/* JADX INFO: loaded from: classes11.dex */
public interface a {
    void a(GcBlockScene r100);

    void b(GcBlockScene r100);

    void prepare();

    void release();

    void requestBlockGc(int r100);
}
