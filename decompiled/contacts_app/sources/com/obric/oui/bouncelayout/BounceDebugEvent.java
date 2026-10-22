package com.obric.oui.bouncelayout;

import android.os.SystemClock;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BounceDebugLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceDebugEvent;", "", "viewName", "", "operation", MaterialConfigFormatNames.X, "", MaterialConfigFormatNames.Y, "message", "timeMillis", "", "(Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;J)V", "getMessage", "()Ljava/lang/String;", "getOperation", "getTimeMillis", "()J", "getViewName", "getX", "()F", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toLogMessage", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceDebugEvent {
    private final String message;
    private final String operation;
    private final long timeMillis;
    private final String viewName;
    private final float x;
    private final float y;

    public static /* synthetic */ BounceDebugEvent copy$default(BounceDebugEvent r5, String r6, String r7, float r8, float r9, String r10, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.viewName;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.operation;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.x;
    L11:
        float r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.y;
    L14:
        float r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.message;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.timeMillis;
    L20:
        String r12 = r6;
        return r5.copy(r12, r15, r0, r1, r2, r11);
    }

    public final String component1() {
        return this.viewName;
    }

    public final String component2() {
        return this.operation;
    }

    public final float component3() {
        return this.x;
    }

    public final float component4() {
        return this.y;
    }

    public final String component5() {
        return this.message;
    }

    public final long component6() {
        return this.timeMillis;
    }

    public final BounceDebugEvent copy(String r9, String r10, float r11, float r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r9, "viewName");
        Intrinsics.checkNotNullParameter(r10, "operation");
        Intrinsics.checkNotNullParameter(r13, "message");
        return new BounceDebugEvent(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof BounceDebugEvent) == true) goto L8;
        return false;
    L8:
        BounceDebugEvent r7 = (BounceDebugEvent) r6;
        if (Intrinsics.areEqual(this.viewName, r7.viewName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.operation, r7.operation) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.x), Float.valueOf(r7.x)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(this.y), Float.valueOf(r7.y)) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.message, r7.message) == true) goto L24;
        return false;
    L24:
        if (this.timeMillis == r7.timeMillis) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.viewName.hashCode() * 31) + this.operation.hashCode()) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.timeMillis);
    }

    public String toString() {
        return "BounceDebugEvent(viewName=" + this.viewName + ", operation=" + this.operation + ", x=" + this.x + ", y=" + this.y + ", message=" + this.message + ", timeMillis=" + this.timeMillis + ')';
    }

    public BounceDebugEvent(String r2, String r3, float r4, float r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "viewName");
        Intrinsics.checkNotNullParameter(r3, "operation");
        Intrinsics.checkNotNullParameter(r6, "message");
        this.viewName = r2;
        this.operation = r3;
        this.x = r4;
        this.y = r5;
        this.message = r6;
        this.timeMillis = r7;
    }

    public final String getViewName() {
        return this.viewName;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final String getMessage() {
        return this.message;
    }

    public /* synthetic */ BounceDebugEvent(String r11, String r12, float r13, float r14, String r15, long r16, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        long r8 = SystemClock.uptimeMillis();
    L6:
        this(r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final long getTimeMillis() {
        return this.timeMillis;
    }

    public final String toLogMessage() {
        return "view=" + this.viewName + " operation=" + this.operation + " x=" + this.x + " y=" + this.y + " time=" + this.timeMillis + ' ' + this.message;
    }
}
