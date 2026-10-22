package com.obric.structure.omvvm.core.insight;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QInsightRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/obric/structure/omvvm/core/insight/QInsightRecord;", "", "uiManager", "", "uiModule", "type", "message", "cost", "", "ts", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getCost", "()J", "getMessage", "()Ljava/lang/String;", "getTs", "getType", "getUiManager", "getUiModule", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QInsightRecord {
    private final long cost;
    private final String message;
    private final long ts;
    private final String type;
    private final String uiManager;
    private final String uiModule;

    public QInsightRecord() {
        this(null, null, null, null, 0, 0, 63, null);
    }

    public static /* synthetic */ QInsightRecord copy$default(QInsightRecord r9, String r10, String r11, String r12, String r13, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.uiManager;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.uiModule;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.type;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r4 = r9.message;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r5 = r9.cost;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.ts;
    L27:
        return r9.copy(r1, r2, r3, r4, r5, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.uiManager;
    }

    public final String component2() {
        return this.uiModule;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.message;
    }

    public final long component5() {
        return this.cost;
    }

    public final long component6() {
        return this.ts;
    }

    public final QInsightRecord copy(String r11, String r12, String r13, String r14, long r15, long r17) {
        Intrinsics.checkNotNullParameter(r11, "uiManager");
        Intrinsics.checkNotNullParameter(r12, "uiModule");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "message");
        return new QInsightRecord(r11, r12, r13, r14, r15, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof QInsightRecord) == true) goto L8;
        return false;
    L8:
        QInsightRecord r9 = (QInsightRecord) r8;
        if (Intrinsics.areEqual(this.uiManager, r9.uiManager) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uiModule, r9.uiModule) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r9.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.message, r9.message) == true) goto L21;
        return false;
    L21:
        if (this.cost == r9.cost) goto L24;
        return false;
    L24:
        if (this.ts == r9.ts) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.uiManager.hashCode() * 31) + this.uiModule.hashCode()) * 31) + this.type.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.cost)) * 31) + Long.hashCode(this.ts);
    }

    public String toString() {
        return "QInsightRecord(uiManager=" + this.uiManager + ", uiModule=" + this.uiModule + ", type=" + this.type + ", message=" + this.message + ", cost=" + this.cost + ", ts=" + this.ts + ')';
    }

    public QInsightRecord(String r2, String r3, String r4, String r5, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "uiModule");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "message");
        this.uiManager = r2;
        this.uiModule = r3;
        this.type = r4;
        this.message = r5;
        this.cost = r6;
        this.ts = r8;
    }

    public final String getUiManager() {
        return this.uiManager;
    }

    public final String getUiModule() {
        return this.uiModule;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getCost() {
        return this.cost;
    }

    public /* synthetic */ QInsightRecord(String r2, String r3, String r4, String r5, long r6, long r8, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = 0;
    L18:
        if ((r10 & 32) == 0) goto L20;
        r8 = System.currentTimeMillis();
    L20:
        this(r2, r3, r4, r5, r6, r8);
    }

    public final long getTs() {
        return this.ts;
    }
}
