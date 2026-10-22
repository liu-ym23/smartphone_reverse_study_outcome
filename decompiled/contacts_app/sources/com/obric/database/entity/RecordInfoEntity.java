package com.obric.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordInfoEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/database/entity/RecordInfoEntity;", "", "callCreateTime", "", "path", "", "phoneNumber", "duration", "id", "(JLjava/lang/String;Ljava/lang/String;JJ)V", "getCallCreateTime", "()J", "getDuration", "getId", "getPath", "()Ljava/lang/String;", "getPhoneNumber", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecordInfoEntity {
    private final long callCreateTime;
    private final long duration;
    private final long id;
    private final String path;
    private final String phoneNumber;

    public static /* synthetic */ RecordInfoEntity copy$default(RecordInfoEntity r9, long r10, String r12, String r13, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.callCreateTime;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.path;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.phoneNumber;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r5 = r9.duration;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r7 = r9.id;
    L23:
        return r9.copy(r1, r3, r4, r5, r7);
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final long component1() {
        return this.callCreateTime;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final long component4() {
        return this.duration;
    }

    public final long component5() {
        return this.id;
    }

    public final RecordInfoEntity copy(long r11, String r13, String r14, long r15, long r17) {
        Intrinsics.checkNotNullParameter(r13, "path");
        Intrinsics.checkNotNullParameter(r14, "phoneNumber");
        return new RecordInfoEntity(r11, r13, r14, r15, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RecordInfoEntity) == true) goto L8;
        return false;
    L8:
        RecordInfoEntity r9 = (RecordInfoEntity) r8;
        if (this.callCreateTime == r9.callCreateTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r9.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L18;
        return false;
    L18:
        if (this.duration == r9.duration) goto L21;
        return false;
    L21:
        if (this.id == r9.id) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.callCreateTime) * 31) + this.path.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + Long.hashCode(this.duration)) * 31) + Long.hashCode(this.id);
    }

    public String toString() {
        return "RecordInfoEntity(callCreateTime=" + this.callCreateTime + ", path=" + this.path + ", phoneNumber=" + this.phoneNumber + ", duration=" + this.duration + ", id=" + this.id + ')';
    }

    public RecordInfoEntity(long r2, String r4, String r5, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "phoneNumber");
        this.callCreateTime = r2;
        this.path = r4;
        this.phoneNumber = r5;
        this.duration = r6;
        this.id = r8;
    }

    public /* synthetic */ RecordInfoEntity(long r12, String r14, String r15, long r16, long r18, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 16) == 0) goto L5;
        long r9 = 0;
    L6:
        this(r12, r14, r15, r16, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final long getCallCreateTime() {
        return this.callCreateTime;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getId() {
        return this.id;
    }
}
