package com.mdisdk.mirror;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/mdisdk/mirror/PointerRecord;", "", "logicalId", "", "x", "", "y", "pressure", AppAgent.CONSTRUCT, "(IFFF)V", "getLogicalId", "()I", "getX", "()F", "setX", "(F)V", "getY", "setY", "getPressure", "setPressure", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PointerRecord {
    private final int logicalId;
    private float pressure;
    private float x;
    private float y;

    public PointerRecord(int i, float f, float f7, float f9) {
        this.logicalId = i;
        this.x = f;
        this.y = f7;
        this.pressure = f9;
    }

    public static /* synthetic */ PointerRecord copy$default(PointerRecord pointerRecord, int i, float f, float f7, float f9, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = pointerRecord.logicalId;
        }
        if ((i6 & 2) != 0) {
            f = pointerRecord.x;
        }
        if ((i6 & 4) != 0) {
            f7 = pointerRecord.y;
        }
        if ((i6 & 8) != 0) {
            f9 = pointerRecord.pressure;
        }
        return pointerRecord.copy(i, f, f7, f9);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLogicalId() {
        return this.logicalId;
    }

    /* renamed from: component2, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component3, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: component4, reason: from getter */
    public final float getPressure() {
        return this.pressure;
    }

    public final PointerRecord copy(int logicalId, float x10, float y, float pressure) {
        return new PointerRecord(logicalId, x10, y, pressure);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerRecord)) {
            return false;
        }
        PointerRecord pointerRecord = (PointerRecord) other;
        return this.logicalId == pointerRecord.logicalId && Float.compare(this.x, pointerRecord.x) == 0 && Float.compare(this.y, pointerRecord.y) == 0 && Float.compare(this.pressure, pointerRecord.pressure) == 0;
    }

    public final int getLogicalId() {
        return this.logicalId;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.hashCode(this.pressure) + a.b(this.y, a.b(this.x, Integer.hashCode(this.logicalId) * 31, 31), 31);
    }

    public final void setPressure(float f) {
        this.pressure = f;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final void setY(float f) {
        this.y = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointerRecord(logicalId=");
        sb.append(this.logicalId);
        sb.append(", x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", pressure=");
        return a.n(sb, this.pressure, ')');
    }
}
