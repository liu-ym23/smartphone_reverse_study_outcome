package com.bytedance.android.sdk.bdticketguard.key;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, Long>> f163905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f163906b;

    public k() {
        this.f163905a = new ArrayList();
        this.f163906b = SystemClock.elapsedRealtimeNanos();
    }

    public final void a(String r100) {
        long r101 = SystemClock.elapsedRealtimeNanos();
        List<Pair<String, Long>> r102 = this.f163905a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(TuplesKt.to(r100, Long.valueOf(r101 - this.f163906b)));
        this.f163906b = r101;
    }
}
