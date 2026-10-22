package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.ttm.player.LoadControl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s extends LoadControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f118209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f118210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f118211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f118212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f118213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f118214f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ttm.player.LoadControl
    public final int onCodecStackSelected(int r100) {
        if (r100 != 1) goto L5;
    L8:
        return 0;
    L5:
        if (r100 == 2) goto L8;
        return -1;
    }

    @Override // com.ss.ttm.player.LoadControl
    public final int onFilterStackSelected(int r100) {
        if (r100 != 1) goto L5;
    L8:
        return 0;
    L5:
        if (r100 == 2) goto L8;
        return -1;
    }

    @Override // com.ss.ttm.player.LoadControl
    public final int onTrackSelected(int r100) {
        if (r100 != 1) goto L5;
    L8:
        return 0;
    L5:
        if (r100 == 2) goto L8;
        return -1;
    }

    public s() {
        this.f118209a = 400;
        this.f118210b = 800;
        this.f118211c = 500;
        this.f118212d = 5000;
        this.f118213e = 0.9f;
    }

    @Override // com.ss.ttm.player.LoadControl
    public final boolean shouldStartPlayback(long r100, float r101, boolean r102) {
        if (r102 == false) goto L8;
        int r103 = this.f118211c;
        long r104 = (long) Math.min(r103 + ((this.f118214f * this.f118213e) * r103), this.f118212d);
        ALogger.d("ReplayPlayerLoadControl", "needBufferedMs = " + r104);
        if (r100 < r104) goto L6;
        this.f118214f++;
        ALogger.d("ReplayPlayerLoadControl", " parameters:  sdp " + this.f118209a + " sdnp " + this.f118210b + " rdi " + this.f118211c + " rdm " + this.f118212d + " rif " + this.f118213e + " rit 0");
        StringBuilder r105 = new StringBuilder(" buffer end:  rebuf count ");
        r105.append(this.f118214f);
        r105.append(", need buf ");
        r105.append(r104);
        r105.append(", now buf ");
        r105.append(r100);
        ALogger.d("ReplayPlayerLoadControl", r105.toString());
        return true;
    L6:
        return false;
    L8:
        Intrinsics.checkNotNull(null);
        throw null;
    }
}
