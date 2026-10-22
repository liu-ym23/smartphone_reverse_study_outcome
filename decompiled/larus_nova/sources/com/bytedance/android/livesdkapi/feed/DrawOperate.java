package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ&\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/DrawOperate;", "", "()V", "mEnterCount", "", "getMEnterCount", "()I", "setMEnterCount", "(I)V", "mLastDuration", "", "getMLastDuration", "()Ljava/lang/String;", "setMLastDuration", "(Ljava/lang/String;)V", "mOrientation", "getMOrientation", "setMOrientation", "mPosition", "getMPosition", "setMPosition", "mReadMax", "getMReadMax", "setMReadMax", "mTotal", "getMTotal", "setMTotal", "updateDuration", "", "duration", "updateItem", "position", "total", "read", "orientation", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawOperate {
    private int mEnterCount;
    private String mLastDuration;
    private int mOrientation;
    private int mPosition;
    private int mReadMax;
    private int mTotal;

    public DrawOperate() {
        this.mLastDuration = "0";
    }

    public final int getMEnterCount() {
        return this.mEnterCount;
    }

    public final String getMLastDuration() {
        return this.mLastDuration;
    }

    public final int getMOrientation() {
        return this.mOrientation;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    public final int getMReadMax() {
        return this.mReadMax;
    }

    public final int getMTotal() {
        return this.mTotal;
    }

    public final void setMEnterCount(int r100) {
        this.mEnterCount = r100;
    }

    public final void setMLastDuration(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mLastDuration = r100;
    }

    public final void setMOrientation(int r100) {
        this.mOrientation = r100;
    }

    public final void setMPosition(int r100) {
        this.mPosition = r100;
    }

    public final void setMReadMax(int r100) {
        this.mReadMax = r100;
    }

    public final void setMTotal(int r100) {
        this.mTotal = r100;
    }

    public final void updateDuration(String r100) {
        Intrinsics.checkNotNullParameter(r100, "duration");
        this.mLastDuration = r100;
    }

    public final void updateItem(int r100, int r101, int r102, int r103) {
        this.mPosition = r100;
        this.mTotal = r101;
        this.mReadMax = r102;
        this.mOrientation = r103;
        this.mEnterCount++;
    }
}
