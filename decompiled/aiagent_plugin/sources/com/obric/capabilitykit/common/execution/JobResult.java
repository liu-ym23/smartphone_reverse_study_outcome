package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class JobResult implements Parcelable {
    public static final Parcelable.Creator<JobResult> CREATOR = null;
    private List<IntentExecutionRecord> execRecords;
    private boolean hasError;
    private String message;
    private long questionId;

    public static final class a implements Parcelable.Creator<JobResult> {
        public a() {
        }

        public final JobResult a(Parcel r11) {
            int r10 = r11.readInt();
            o.e(r11, "parcel");
            long r2 = r11.readLong();
            int r8 = 1;
            if (r11.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r11.readString();
            int r0 = r11.readInt();
            ArrayList r6 = new ArrayList(r0);
            int r1 = 0;
        L7:
            if (r1 == r0) goto L9;
            r6.add(IntentExecutionRecord.CREATOR.createFromParcel(r11));
            r1 = r1 + 1;
            goto L7
        L9:
            JobResult r3 = new JobResult(r2, r4, r5, r6);
            int r7 = Math.min(r10, 0);
            ClassLoader r9 = a.class.getClassLoader();
        L10:
            if (r8 > r7) goto L12;
            r8 = r8 + 1;
        L12:
            if (r8 > r10) goto L14;
            com.obric.a.a.a(r11, r9);
            r8 = r8 + 1;
            goto L12
        L14:
            return r3;
        L5:
            r4 = false;
            goto L6
        }

        public final JobResult[] a(int r1) {
            return new JobResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ JobResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ JobResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public JobResult(long r3, boolean r5, String r6, List<IntentExecutionRecord> r7) {
        List<IntentExecutionRecord> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "message");
        o.e(r8, "execRecords");
        this.questionId = r3;
        this.hasError = r5;
        this.message = r6;
        this.execRecords = r8;
    }

    public static /* synthetic */ JobResult copy$default(JobResult r6, long r7, boolean r9, String r10, List r11, int r12, Object r13) {
        List<IntentExecutionRecord> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.questionId;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.hasError;
    L8:
        boolean r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.message;
    L11:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r14 = r6.execRecords;
    L15:
        return r6.copy(r1, r3, r4, r14);
    }

    public final long component1() {
        return this.questionId;
    }

    public final boolean component2() {
        return this.hasError;
    }

    public final String component3() {
        return this.message;
    }

    public final List<IntentExecutionRecord> component4() {
        return this.execRecords;
    }

    public final JobResult copy(long r7, boolean r9, String r10, List<IntentExecutionRecord> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "message");
        o.e(r5, "execRecords");
        return new JobResult(r7, r9, r10, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, JobResult.class) == true) goto L8;
        return false;
    L8:
        JobResult r10 = (JobResult) ZeusTransformUtils.preCheckCast(r9, JobResult.class, "com.obric.aiagent.plugin");
        if (this.questionId == r10.questionId) goto L12;
        return false;
    L12:
        if (this.hasError == r10.hasError) goto L15;
        return false;
    L15:
        if (o.a(this.message, r10.message) == true) goto L18;
        return false;
    L18:
        if (o.a(this.execRecords, r10.execRecords) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<IntentExecutionRecord> getExecRecords() {
        return this.execRecords;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = Long.hashCode(this.questionId) * 31;
        boolean r1 = this.hasError;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((r0 + r2) * 31) + this.message.hashCode()) * 31) + this.execRecords.hashCode();
    }

    public final void setExecRecords(List<IntentExecutionRecord> r3) {
        List<IntentExecutionRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.execRecords = r4;
    }

    public final void setHasError(boolean r1) {
        this.hasError = r1;
    }

    public final void setMessage(String r2) {
        o.e(r2, "<set-?>");
        this.message = r2;
    }

    public final void setQuestionId(long r1) {
        this.questionId = r1;
    }

    public String toString() {
        return "JobResult(questionId=" + this.questionId + ", hasError=" + this.hasError + ", message=" + this.message + ", execRecords=" + this.execRecords + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeLong(this.questionId);
        r4.writeInt(this.hasError ? 1 : 0);
        r4.writeString(this.message);
        List<IntentExecutionRecord> r3 = this.execRecords;
        r4.writeInt(r3.size());
        Iterator<IntentExecutionRecord> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r6.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).writeToParcel(r4, r5);
        goto L4
    }
}
