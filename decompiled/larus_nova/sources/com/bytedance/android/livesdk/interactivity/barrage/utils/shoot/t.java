package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class t extends r22.a<q22.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<q22.d> f134013c;

    @Override // r22.a
    public final q22.d j() {
        return (q22.d) ((LinkedList) this.f134013c).pollFirst();
    }

    @Override // r22.a
    public final Queue<q22.d> h() {
        return this.f134013c;
    }

    public t(r22.b<q22.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
        this.f134013c = new LinkedList();
    }

    @Override // r22.a
    public final void b(q22.d r100, r22.a.b<q22.d> r101) {
        q22.d r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "notifier");
        if (r102.f531407a.f516692d != null) goto L5;
        r101.a(r102);
        return;
    L5:
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r102.f531407a.f516692d, new s(r102, r101));
    }
}
