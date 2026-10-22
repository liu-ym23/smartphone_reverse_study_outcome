package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f187407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187408b;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public final String b() {
        StringBuilder r100 = new StringBuilder("PlayerTask");
        r100.append(hashCode());
        r100.append(" type = ");
        int r101 = this.f187408b;
        if (r101 == 10) goto L15;
        switch(r101) {
            case -1: goto L14;
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L5:
        String r102 = "";
    L16:
        r100.append(r102);
        return r100.toString();
    L6:
        r102 = "seek_task";
        goto L16
    L7:
        r102 = "error_task";
        goto L16
    L8:
        r102 = "complete_task";
        goto L16
    L9:
        r102 = "set_url_task";
        goto L16
    L10:
        r102 = "release_task";
        goto L16
    L11:
        r102 = "stop_task";
        goto L16
    L12:
        r102 = "pause_task";
        goto L16
    L13:
        r102 = "play_task";
        goto L16
    L14:
        r102 = "init_task";
        goto L16
    L15:
        r102 = "set_surface_task";
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L7
        k r100 = this.f187407a;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");     // Catch: Throwable -> L7
    L5:
        r100.d(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public final int getType() {
        return this.f187408b;
    }

    public j(int r100) {
        this.f187408b = r100;
    }
}
