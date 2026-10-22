package com.bytedance.applet.debugger;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerTraceSpan;", "", "scene", "", "input", "Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;", BdpAppEventConstant.PARAMS_OUTPUT, "duration", "", DyPayConstant.KEY_START_TIME, "<init>", "(Ljava/lang/String;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Ljava/lang/Long;Ljava/lang/Long;)V", "getScene", "()Ljava/lang/String;", "getInput", "()Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;", "getOutput", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/applet/debugger/AppletDebuggerTraceSpan;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("input")
    private final t input;

    @SerializedName(BdpAppEventConstant.PARAMS_OUTPUT)
    private final t output;

    @SerializedName("scene")
    private final String scene;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.input, r101.input) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.output, r101.output) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        t r104 = this.input;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        t r107 = this.output;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.duration;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.startTime;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletDebuggerTraceSpan(scene=" + this.scene + ", input=" + this.input + ", output=" + this.output + ", duration=" + this.duration + ", startTime=" + this.startTime + ')';
    }

    public u() {
        this.scene = null;
        this.input = null;
        this.output = null;
        this.duration = null;
        this.startTime = null;
    }

    public final Long a() {
        return this.duration;
    }

    public final t b() {
        return this.input;
    }

    public final t c() {
        return this.output;
    }

    public final String d() {
        return this.scene;
    }

    public final Long e() {
        return this.startTime;
    }
}
