package com.bytedance.android.livesdkapi.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitCostInfo;", "", "name", "", "(Ljava/lang/String;)V", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "getName", "()Ljava/lang/String;", "setName", "start", "getStart", "setStart", "equals", "", "other", "hashCode", "", "toString", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveInitCostInfo {
    private long duration;
    private String name;
    private long start;

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "LiveInitCostInfo(start=" + this.start + ", duration=" + this.duration + ')';
    }

    public LiveInitCostInfo() {
        this.name = "";
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final long getStart() {
        return this.start;
    }

    public LiveInitCostInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(this.name, ((LiveInitCostInfo) r100).name)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.init.LiveInitCostInfo");
    L8:
        r102 = null;
        goto L10
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setStart(long r100) {
        this.start = r100;
    }
}
