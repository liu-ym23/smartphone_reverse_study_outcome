package com.obric.database.entity;

import android.content.ContentValues;
import com.obric.contacts.DatabaseConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSummaryComposeBetaEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/database/entity/CallSummaryComposeBetaEntity;", "", "phoneNumber", "", "callCreateTime", "", "compressResult", "", "compressContext", "compressStartId", "compressEndId", "id", "(Ljava/lang/String;JILjava/lang/String;IIJ)V", "getCallCreateTime", "()J", "getCompressContext", "()Ljava/lang/String;", "getCompressEndId", "()I", "getCompressResult", "getCompressStartId", "getId", "getPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toContentValues", "Landroid/content/ContentValues;", "toString", "CompressResult", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryComposeBetaEntity {
    private final long callCreateTime;
    private final String compressContext;
    private final int compressEndId;
    private final int compressResult;
    private final int compressStartId;
    private final long id;
    private final String phoneNumber;

    /* JADX INFO: compiled from: CallSummaryComposeBetaEntity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/database/entity/CallSummaryComposeBetaEntity$CompressResult;", "", "(Ljava/lang/String;I)V", "FAILURE", "SUCCESS", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum CompressResult extends Enum<CompressResult> {
        private static final /* synthetic */ CompressResult[] $VALUES = null;
        public static final CompressResult FAILURE = null;
        public static final CompressResult SUCCESS = null;

        private static final /* synthetic */ CompressResult[] $values() {
            return new CompressResult[]{FAILURE, SUCCESS};
        }

        public static CompressResult valueOf(String r1) {
            return (CompressResult) Enum.valueOf(CompressResult.class, r1);
        }

        public static CompressResult[] values() {
            return (CompressResult[]) $VALUES.clone();
        }

        private CompressResult(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FAILURE = new CompressResult("FAILURE", 0);
            SUCCESS = new CompressResult("SUCCESS", 1);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ CallSummaryComposeBetaEntity copy$default(CallSummaryComposeBetaEntity r10, String r11, long r12, int r14, String r15, int r16, int r17, long r18, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.phoneNumber;
    L7:
        if ((r20 & 2) == 0) goto L9;
        long r2 = r10.callCreateTime;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.compressResult;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.compressContext;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = r10.compressStartId;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r7 = r10.compressEndId;
    L27:
        if ((r20 & 64) == 0) goto L29;
        long r8 = r10.id;
    L31:
        return r10.copy(r1, r2, r4, r5, r6, r7, r8);
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.phoneNumber;
    }

    public final long component2() {
        return this.callCreateTime;
    }

    public final int component3() {
        return this.compressResult;
    }

    public final String component4() {
        return this.compressContext;
    }

    public final int component5() {
        return this.compressStartId;
    }

    public final int component6() {
        return this.compressEndId;
    }

    public final long component7() {
        return this.id;
    }

    public final CallSummaryComposeBetaEntity copy(String r12, long r13, int r15, String r16, int r17, int r18, long r19) {
        Intrinsics.checkNotNullParameter(r12, "phoneNumber");
        Intrinsics.checkNotNullParameter(r16, "compressContext");
        return new CallSummaryComposeBetaEntity(r12, r13, r15, r16, r17, r18, r19);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CallSummaryComposeBetaEntity) == true) goto L8;
        return false;
    L8:
        CallSummaryComposeBetaEntity r9 = (CallSummaryComposeBetaEntity) r8;
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L12;
        return false;
    L12:
        if (this.callCreateTime == r9.callCreateTime) goto L15;
        return false;
    L15:
        if (this.compressResult == r9.compressResult) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.compressContext, r9.compressContext) == true) goto L21;
        return false;
    L21:
        if (this.compressStartId == r9.compressStartId) goto L24;
        return false;
    L24:
        if (this.compressEndId == r9.compressEndId) goto L27;
        return false;
    L27:
        if (this.id == r9.id) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.phoneNumber.hashCode() * 31) + Long.hashCode(this.callCreateTime)) * 31) + Integer.hashCode(this.compressResult)) * 31) + this.compressContext.hashCode()) * 31) + Integer.hashCode(this.compressStartId)) * 31) + Integer.hashCode(this.compressEndId)) * 31) + Long.hashCode(this.id);
    }

    public String toString() {
        return "CallSummaryComposeBetaEntity(phoneNumber=" + this.phoneNumber + ", callCreateTime=" + this.callCreateTime + ", compressResult=" + this.compressResult + ", compressContext=" + this.compressContext + ", compressStartId=" + this.compressStartId + ", compressEndId=" + this.compressEndId + ", id=" + this.id + ')';
    }

    public CallSummaryComposeBetaEntity(String r2, long r3, int r5, String r6, int r7, int r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "phoneNumber");
        Intrinsics.checkNotNullParameter(r6, "compressContext");
        this.phoneNumber = r2;
        this.callCreateTime = r3;
        this.compressResult = r5;
        this.compressContext = r6;
        this.compressStartId = r7;
        this.compressEndId = r8;
        this.id = r9;
    }

    public /* synthetic */ CallSummaryComposeBetaEntity(String r13, long r14, int r16, String r17, int r18, int r19, long r20, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 64) == 0) goto L5;
        long r10 = 0;
    L6:
        this(r13, r14, r16, r17, r18, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final long getCallCreateTime() {
        return this.callCreateTime;
    }

    public final int getCompressResult() {
        return this.compressResult;
    }

    public final String getCompressContext() {
        return this.compressContext;
    }

    public final int getCompressStartId() {
        return this.compressStartId;
    }

    public final int getCompressEndId() {
        return this.compressEndId;
    }

    public final long getId() {
        return this.id;
    }

    public final ContentValues toContentValues() {
        ContentValues r0 = new ContentValues();
        r0.put("phone_number", this.phoneNumber);
        r0.put("call_create_time", Long.valueOf(this.callCreateTime));
        r0.put(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_RESULT, Integer.valueOf(this.compressResult));
        r0.put(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_CONTEXT, this.compressContext);
        r0.put(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_START_ID, Integer.valueOf(this.compressStartId));
        r0.put(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_END_ID, Integer.valueOf(this.compressEndId));
        return r0;
    }
}
