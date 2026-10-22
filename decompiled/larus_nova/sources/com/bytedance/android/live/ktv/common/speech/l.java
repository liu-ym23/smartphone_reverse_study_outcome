package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f70466a;

    public l(String r100) {
        this.f70466a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = this.f70466a;
        monitor-enter(n.class);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L29
        if (r102.exists() == true) goto L7;
    L27:
        monitor-exit(n.class);
        return;
    L7:
        if (r102.isDirectory() == false) goto L27;
        List r103 = ArraysKt.toList(r102.listFiles());     // Catch: Throwable -> L29
        int r104 = r103.size();     // Catch: Throwable -> L29
        if (r104 > 300) goto L13;
        monitor-exit(n.class);
        return;
    L13:
        ALogger.i("SpeechFileUtils", "delete same files, fileNum: " + r104);     // Catch: Throwable -> L29
        int r105 = r104 - 300;     // Catch: Throwable -> L29
        if ((!r103.isEmpty()) == false) goto L27;
        List r106 = CollectionsKt.sortedWith(r103, new m());     // Catch: Throwable -> L29
        if (r105 <= r103.size()) goto L19;
        monitor-exit(n.class);
        return;
    L19:
        int r107 = 0;
    L20:
        if (r107 >= r105) goto L27;
        File r108 = (File) ListProtector.get(r106, r107);     // Catch: Throwable -> L29
        if (r108 == null) goto L26;
        if (r108.exists() == false) goto L26;
        q1.a(r108);     // Catch: Throwable -> L29
    L26:
        r107 = r107 + 1;
    L29:
        th = move-exception;
        throw th;
    }
}
