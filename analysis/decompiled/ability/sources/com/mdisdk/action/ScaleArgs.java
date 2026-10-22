package com.mdisdk.action;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/mdisdk/action/ScaleArgs;", "", "centerX", "", "centerY", "startDistance", "endDistance", "durationInMs", "", WindowStateInfo.KEY_DISPLAY_ID, "", AppAgent.CONSTRUCT, "(FFFFJLjava/lang/Integer;)V", "getCenterX", "()F", "getCenterY", "getStartDistance", "getEndDistance", "getDurationInMs", "()J", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(FFFFJLjava/lang/Integer;)Lcom/mdisdk/action/ScaleArgs;", "equals", "", "other", "hashCode", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ScaleArgs {
    private final float centerX;
    private final float centerY;
    private final Integer displayId;
    private final long durationInMs;
    private final float endDistance;
    private final float startDistance;

    public ScaleArgs(float f, float f7, float f9, float f10, long j5, Integer num) {
        this.centerX = f;
        this.centerY = f7;
        this.startDistance = f9;
        this.endDistance = f10;
        this.durationInMs = j5;
        this.displayId = num;
    }

    public static /* synthetic */ ScaleArgs copy$default(ScaleArgs scaleArgs, float f, float f7, float f9, float f10, long j5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            f = scaleArgs.centerX;
        }
        if ((i & 2) != 0) {
            f7 = scaleArgs.centerY;
        }
        if ((i & 4) != 0) {
            f9 = scaleArgs.startDistance;
        }
        if ((i & 8) != 0) {
            f10 = scaleArgs.endDistance;
        }
        if ((i & 16) != 0) {
            j5 = scaleArgs.durationInMs;
        }
        if ((i & 32) != 0) {
            num = scaleArgs.displayId;
        }
        Integer num2 = num;
        long j6 = j5;
        return scaleArgs.copy(f, f7, f9, f10, j6, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getCenterX() {
        return this.centerX;
    }

    /* renamed from: component2, reason: from getter */
    public final float getCenterY() {
        return this.centerY;
    }

    /* renamed from: component3, reason: from getter */
    public final float getStartDistance() {
        return this.startDistance;
    }

    /* renamed from: component4, reason: from getter */
    public final float getEndDistance() {
        return this.endDistance;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDurationInMs() {
        return this.durationInMs;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final ScaleArgs copy(float centerX, float centerY, float startDistance, float endDistance, long durationInMs, Integer displayId) {
        return new ScaleArgs(centerX, centerY, startDistance, endDistance, durationInMs, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScaleArgs)) {
            return false;
        }
        ScaleArgs scaleArgs = (ScaleArgs) other;
        return Float.compare(this.centerX, scaleArgs.centerX) == 0 && Float.compare(this.centerY, scaleArgs.centerY) == 0 && Float.compare(this.startDistance, scaleArgs.startDistance) == 0 && Float.compare(this.endDistance, scaleArgs.endDistance) == 0 && this.durationInMs == scaleArgs.durationInMs && k.b(this.displayId, scaleArgs.displayId);
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
    }

    public final float getEndDistance() {
        return this.endDistance;
    }

    public final float getStartDistance() {
        return this.startDistance;
    }

    public int hashCode() {
        int iC = a.c(a.b(this.endDistance, a.b(this.startDistance, a.b(this.centerY, Float.hashCode(this.centerX) * 31, 31), 31), 31), 31, this.durationInMs);
        Integer num = this.displayId;
        return iC + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "ScaleArgs(centerX=" + this.centerX + ", centerY=" + this.centerY + ", startDistance=" + this.startDistance + ", endDistance=" + this.endDistance + ", durationInMs=" + this.durationInMs + ", displayId=" + this.displayId + ')';
    }
}
