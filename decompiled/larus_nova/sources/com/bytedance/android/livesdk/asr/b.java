package com.bytedance.android.livesdk.asr;

import com.bytedance.android.scope.o;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<d> f103967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f103968b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b() {
        this.f103967a = new ConcurrentLinkedQueue();
        this.f103968b = 10000;
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        a(LogLevel.INFO, "[" + r100 + "] " + r101, null);
    }

    public final void a(LogLevel r100, String r101, Throwable r102) {
        if (this.f103967a.size() < this.f103968b) goto L5;
        this.f103967a.poll();
    L5:
        this.f103967a.offer(new d(r100, r101, r102));
    }

    public final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        LogLevel r103 = LogLevel.ERROR;
        StringBuilder r104 = new StringBuilder("[");
        r104.append(r100);
        r104.append("] ");
        r104.append(r101);
        r104.append(' ');
        if (r102 == null) goto L5;
        String r105 = r102.getMessage();
    L6:
        r104.append(r105);
        a(r103, r104.toString(), r102);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
