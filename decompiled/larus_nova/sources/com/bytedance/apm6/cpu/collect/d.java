package com.bytedance.apm6.cpu.collect;

import androidx.camera.video.AudioStats;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import tt3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f190801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f190802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ double f190803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ double f190804g;

    public final void a() {
        if (this.f190801d == true) goto L5;
        CpuCacheItem.CpuDataType r100 = CpuCacheItem.CpuDataType.FRONT;
    L6:
        c r101 = new c(r100, this.f190802e, this.f190803f, AudioStats.AUDIO_AMPLITUDE_NONE, this.f190804g, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        r101.f190796i = ykc.c.c(com.bytedance.apm.d.getContext());
        r101.f190797j = false;
        if (f.f547554c == false) goto L9;
        nu3.b.a(r101);
        return;
    L9:
        ((LinkedList) f.f547553b).add(r101);
        return;
    L5:
        r100 = CpuCacheItem.CpuDataType.BACK;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(boolean r100, String r101, double r102, double r103) {
        this.f190801d = r100;
        this.f190802e = r101;
        this.f190803f = r102;
        this.f190804g = r103;
    }
}
