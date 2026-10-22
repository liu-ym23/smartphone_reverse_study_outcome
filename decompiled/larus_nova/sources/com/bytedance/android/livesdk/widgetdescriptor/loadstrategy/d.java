package com.bytedance.android.livesdk.widgetdescriptor.loadstrategy;

import com.bytedance.android.livesdk.config.l21;
import com.bytedance.android.livesdk.config.o91;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f162402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widgetdescriptor.priority.c f162403b;

    public final void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "doAfterGroupLoaded");
        this.f162402a.d(r100);
    }

    public final void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "doAfterGroupLoaded");
        this.f162402a.b(r100);
    }

    public final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "doAfterGroupLoaded");
        this.f162402a.c(r100);
    }

    public final void d(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "doAfterGroupLoaded");
        this.f162402a.a(r100);
    }

    public d(o91 r100, com.bytedance.android.livesdk.widgetdescriptor.priority.b r101, mg2.d r102) {
        Intrinsics.checkNotNullParameter(r101, "priorityOperator");
        Intrinsics.checkNotNullParameter(r102, "componentManager");
        this.f162403b = r101;
        if (r100 == null) goto L5;
        String r103 = r100.e();
    L6:
        int r104 = l21.f120649a;
        if (Intrinsics.areEqual(r103, "inOrder") == false) goto L10;
        f r105 = new b(r102, r101, r100);
    L16:
        this.f162402a = r105;
        return;
    L10:
        if (Intrinsics.areEqual(r103, "together") == false) goto L13;
        r105 = new e(r102, r101);
        goto L16
    L13:
        if (Intrinsics.areEqual(r103, "trigger") == false) goto L15;
        r105 = new e(r102, r101);
        goto L16
    L15:
        r105 = new e(r102, r101);
        goto L16
    L5:
        r103 = null;
        goto L6
    }
}
