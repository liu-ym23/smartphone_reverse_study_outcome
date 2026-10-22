package com.obric.oui.bouncelayout;

import android.os.SystemClock;
import com.bytedanceos.common.model.AppInfo;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceDebugEvent;", "", "viewName", "", "operation", FixCard.FixStyle.KEY_X, "", FixCard.FixStyle.KEY_Y, "message", "timeMillis", "", "(Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;J)V", "getMessage", "()Ljava/lang/String;", "getOperation", "getTimeMillis", "()J", "getViewName", "getX", "()F", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toLogMessage", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceDebugEvent {

    @NotNull
    private final String message;

    @NotNull
    private final String operation;
    private final long timeMillis;

    @NotNull
    private final String viewName;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f12470x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f12471y;

    public BounceDebugEvent(@NotNull String r10, @NotNull String r11, float r12, float r13, @NotNull String r14, long r15) {
        q.g(r10, "viewName");
        q.g(r11, "operation");
        q.g(r14, "message");
        this.viewName = r10;
        this.operation = r11;
        this.f12470x = r12;
        this.f12471y = r13;
        this.message = r14;
        this.timeMillis = r15;
    }

    public static /* synthetic */ BounceDebugEvent copy$default(BounceDebugEvent r10, String r11, String r12, float r13, float r14, String r15, long r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.viewName;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.operation;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.f12470x;
    L11:
        float r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.f12471y;
    L14:
        float r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.message;
    L17:
        String r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.timeMillis;
    L20:
        String r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @NotNull
    public final String component1() {
        return this.viewName;
    }

    @NotNull
    public final String component2() {
        return this.operation;
    }

    public final float component3() {
        return this.f12470x;
    }

    public final float component4() {
        return this.f12471y;
    }

    @NotNull
    public final String component5() {
        return this.message;
    }

    public final long component6() {
        return this.timeMillis;
    }

    @NotNull
    public final BounceDebugEvent copy(@NotNull String r10, @NotNull String r11, float r12, float r13, @NotNull String r14, long r15) {
        q.g(r10, "viewName");
        q.g(r11, "operation");
        q.g(r14, "message");
        return new BounceDebugEvent(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BounceDebugEvent) == true) goto L8;
        return false;
    L8:
        BounceDebugEvent r11 = (BounceDebugEvent) r10;
        if (q.b(this.viewName, r11.viewName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.operation, r11.operation) == true) goto L15;
        return false;
    L15:
        if (q.b(Float.valueOf(this.f12470x), Float.valueOf(r11.f12470x)) == true) goto L18;
        return false;
    L18:
        if (q.b(Float.valueOf(this.f12471y), Float.valueOf(r11.f12471y)) == true) goto L21;
        return false;
    L21:
        if (q.b(this.message, r11.message) == true) goto L24;
        return false;
    L24:
        if (this.timeMillis == r11.timeMillis) goto L26;
        return false;
    L26:
        return true;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getOperation() {
        return this.operation;
    }

    public final long getTimeMillis() {
        return this.timeMillis;
    }

    @NotNull
    public final String getViewName() {
        return this.viewName;
    }

    public final float getX() {
        return this.f12470x;
    }

    public final float getY() {
        return this.f12471y;
    }

    public int hashCode() {
        return (((((((((this.viewName.hashCode() * 31) + this.operation.hashCode()) * 31) + Float.hashCode(this.f12470x)) * 31) + Float.hashCode(this.f12471y)) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.timeMillis);
    }

    @NotNull
    public final String toLogMessage() {
        return "view=" + this.viewName + " operation=" + this.operation + " x=" + this.f12470x + " y=" + this.f12471y + " time=" + this.timeMillis + TokenParser.SP + this.message;
    }

    @NotNull
    public String toString() {
        return "BounceDebugEvent(viewName=" + this.viewName + ", operation=" + this.operation + ", x=" + this.f12470x + ", y=" + this.f12471y + ", message=" + this.message + ", timeMillis=" + this.timeMillis + ')';
    }

    public /* synthetic */ BounceDebugEvent(String r11, String r12, float r13, float r14, String r15, long r16, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        long r10 = SystemClock.uptimeMillis();
    L6:
        this(r11, r12, r13, r14, r15, r10);
        return;
    L5:
        r10 = r16;
        goto L6
    }
}
