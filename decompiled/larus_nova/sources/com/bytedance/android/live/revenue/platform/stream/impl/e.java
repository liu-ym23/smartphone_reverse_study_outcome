package com.bytedance.android.live.revenue.platform.stream.impl;

import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.io.File;
import java.io.FileFilter;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StreamCaptureServiceImpl f91698a;

    public static final class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f91699a;

        public a(PolarisFileWrapper r100) {
            this.f91699a = r100;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            if (r100.isDirectory() == true) goto L5;
        L7:
            return false;
        L5:
            if ((!Intrinsics.areEqual(r100, this.f91699a)) == false) goto L7;
            return true;
        }
    }

    public e(StreamCaptureServiceImpl r100) {
        this.f91698a = r100;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        StreamCaptureServiceImpl r101 = this.f91698a;     // Catch: Throwable -> L10
        r101.getClass();     // Catch: Throwable -> L10
        File[] r102 = this.f91698a.c().listFiles(new a(new PolarisFileWrapper(r101.c(), String.valueOf(Process.myPid()))));     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        int r103 = r102.length;     // Catch: Throwable -> L10
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        File r105 = r102[r104];     // Catch: Throwable -> L10
        jy0.b.a("StreamCaptureService", "cleanStaleBitmapCache: " + r105.getAbsolutePath());     // Catch: Throwable -> L10
        FilesKt.deleteRecursively(r105);     // Catch: Throwable -> L10
        r104 = r104 + 1;     // Catch: Throwable -> L10
    L8:
        r100.onComplete();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        r100.onError(th);
    }
}
