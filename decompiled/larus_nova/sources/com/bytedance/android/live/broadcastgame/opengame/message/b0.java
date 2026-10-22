package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.api.channel.DelayType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b0 implements com.bytedance.android.live.broadcastgame.api.model.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f60190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f60191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tlc.d f60192c;

    public final int b() {
        if (this.f60190a == false) goto L5;
        DelayType r100 = DelayType.DELAY_FLOW_STREAM;
    L7:
        return r100.getValue();
    L5:
        r100 = DelayType.NO_DELAY;
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.k
    public final long a() {
        return this.f60191b;
    }

    public b0(boolean r100, long r101, tlc.d r102) {
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f60190a = r100;
        this.f60191b = r101;
        this.f60192c = r102;
    }
}
