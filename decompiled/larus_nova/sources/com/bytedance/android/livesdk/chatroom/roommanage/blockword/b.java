package com.bytedance.android.livesdk.chatroom.roommanage.blockword;

import android.widget.EditText;
import com.bytedance.android.livesdk.utils.t2;
import com.larus.apm.impl.protector.RunnableProtector;
import zg1.i1;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockWordFlowController f111334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f111335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f111336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f111337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f111338e;

    public b(BlockWordFlowController r100, EditText r101, long r102, int r103, int r104) {
        this.f111334a = r100;
        this.f111335b = r101;
        this.f111336c = r102;
        this.f111337d = r103;
        this.f111338e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockWordFlowController r100 = this.f111334a;     // Catch: Throwable -> L15
        if (r100.f111302n == false) goto L18;
        i1 r101 = r100.f111301m;     // Catch: Throwable -> L15
        if (r101 != null) goto L7;
    L9:
        t2.b(r100.f111289a, this.f111335b);     // Catch: Throwable -> L15
        BlockWordFlowController r102 = this.f111334a;     // Catch: Throwable -> L15
        EditText r103 = this.f111335b;     // Catch: Throwable -> L15
        long r110 = this.f111336c;     // Catch: Throwable -> L15
        int r104 = this.f111337d + 1;     // Catch: Throwable -> L15
        int r105 = this.f111338e;     // Catch: Throwable -> L15
        r102.getClass();     // Catch: Throwable -> L15
        if (r103 == null) goto L23;
        if (r104 > r105) goto L24;
        r103.postDelayed(new b(r102, r103, r110, r104, r105), r110);     // Catch: Throwable -> L15
        return;
    L24:
        return;
    L23:
        return;
    L7:
        if (r101.f571850b != true) goto L9;
        return;
    L18:
        return;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L25;
        throw th;
    }
}
