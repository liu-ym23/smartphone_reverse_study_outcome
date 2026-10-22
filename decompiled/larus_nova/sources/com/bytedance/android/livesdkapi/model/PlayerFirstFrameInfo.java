package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerFirstFrameInfo;", "", "sei", "", "ts", "", "(Ljava/lang/String;J)V", "getSei", "()Ljava/lang/String;", "getTs", "()J", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerFirstFrameInfo {
    private final String sei;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    private final long f162634ts;

    public final String getSei() {
        return this.sei;
    }

    public final long getTs() {
        return this.f162634ts;
    }

    public PlayerFirstFrameInfo(String r100, long r101) {
        this.sei = r100;
        this.f162634ts = r101;
    }

    public /* synthetic */ PlayerFirstFrameInfo(String r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = System.currentTimeMillis();
    L5:
        this(r100, r101);
    }
}
