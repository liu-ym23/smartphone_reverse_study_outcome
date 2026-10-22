package com.bytedance.android.live.revenuelink.multimsg;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.revenuelink.multimsg.api.TaskMainHandler;
import com.bytedance.android.live.revenuelink.multimsg.api.h;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f91892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.multimsg.api.f f91893l;

    public d(i r100, yz0.f r101) {
        super(r100, r101);
        this.f91892k = new h(this);
        this.f91893l = new com.bytedance.android.live.revenuelink.multimsg.api.f(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MultiMsgManager")));
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void S3(String r100, ByteBuffer r101) {
        if (this.f91851a == false) goto L11;
        if (r101 == null) goto L13;
        com.bytedance.android.live.revenuelink.multimsg.api.f r102 = this.f91893l;
        f r103 = new f();
        h r104 = this.f91892k;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "task");
        Intrinsics.checkNotNullParameter(r104, "resultHandler");
        com.bytedance.android.live.revenuelink.multimsg.api.g r105 = new com.bytedance.android.live.revenuelink.multimsg.api.g(r102, r103, r104, r101);
        Lazy r106 = TaskMainHandler.f91860a;
        Intrinsics.checkNotNullParameter(r105, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        r105.run();
        return;
    L9:
        ((Handler) TaskMainHandler.f91860a.getValue()).post(r105);
        return;
    L13:
        return;
    }
}
