package com.bytedance.android.livesdk.chatroom.helper;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.user.api.a f106483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f106484b;

    public l(com.bytedance.android.live.user.api.a r100, DataCenter r101) {
        this.f106483a = r100;
        this.f106484b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.bytedance.android.live.user.api.b.f102505a;     // Catch: Throwable -> L9
        Object r101 = this.f106483a;     // Catch: Throwable -> L9
        DataCenter r102 = this.f106484b;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "$this$share");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r102, "dataCenter");     // Catch: Throwable -> L9
        if ((r101 instanceof DataContext) == true) goto L5;
        r101 = null;
    L5:
        DataContext r103 = (DataContext) r101;     // Catch: Throwable -> L9
        if (r103 == null) goto L12;
        com.bytedance.live.datacontext.b.a(r103, com.bytedance.android.live.user.api.a.class);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
