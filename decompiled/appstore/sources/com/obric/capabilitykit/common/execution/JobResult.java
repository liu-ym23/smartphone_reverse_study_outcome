package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/execution/JobResult;", "Landroid/os/Parcelable;", "questionId", "", "hasError", "", "message", "", "execRecords", "", "Lcom/obric/capabilitykit/common/execution/IntentExecutionRecord;", "(JZLjava/lang/String;Ljava/util/List;)V", "getExecRecords", "()Ljava/util/List;", "setExecRecords", "(Ljava/util/List;)V", "getHasError", "()Z", "setHasError", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getQuestionId", "()J", "setQuestionId", "(J)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class JobResult implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<JobResult> CREATOR = null;

    @NotNull
    private List<IntentExecutionRecord> execRecords;
    private boolean hasError;

    @NotNull
    private String message;
    private long questionId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<JobResult> {
        public a() {
        }

        @NotNull
        public final JobResult a(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            long r12 = r11.readLong();
            int r13 = 1;
            if (r11.readInt() == 0) goto L5;
            boolean r14 = true;
        L6:
            String r15 = r11.readString();
            int r16 = r11.readInt();
            ArrayList r17 = new ArrayList(r16);
            int r18 = 0;
        L7:
            if (r18 == r16) goto L9;
            r17.add(IntentExecutionRecord.CREATOR.createFromParcel(r11));
            r18 = r18 + 1;
            goto L7
        L9:
            JobResult r19 = new JobResult(r12, r14, r15, r17);
            int r20 = Math.min(r10, 0);
            ClassLoader r21 = a.class.getClassLoader();
        L10:
            if (r13 > r20) goto L12;
            r13 = r13 + 1;
        L12:
            if (r13 > r10) goto L14;
            be.a.d(r11, r21);
            r13 = r13 + 1;
            goto L12
        L14:
            return r19;
        L5:
            r14 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ JobResult createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ JobResult[] newArray(int r10) {
            return a(r10);
        }

        @NotNull
        public final JobResult[] a(int r10) {
            return new JobResult[r10];
        }
    }

    static {
        CREATOR = new a();
    }

    public JobResult(long r10, boolean r11, @NotNull String r12, @NotNull List<IntentExecutionRecord> r13) {
        q.g(r12, "message");
        q.g(r13, "execRecords");
        this.questionId = r10;
        this.hasError = r11;
        this.message = r12;
        this.execRecords = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JobResult copy$default(JobResult r10, long r11, boolean r12, String r13, List r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L5;
        r11 = r10.questionId;
    L5:
        long r17 = r11;
        if ((r15 & 2) == 0) goto L8;
        r12 = r10.hasError;
    L8:
        boolean r18 = r12;
        if ((r15 & 4) == 0) goto L11;
        r13 = r10.message;
    L11:
        String r19 = r13;
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.execRecords;
    L15:
        return r10.copy(r17, r18, r19, r14);
    }

    public final long component1() {
        return this.questionId;
    }

    public final boolean component2() {
        return this.hasError;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final List<IntentExecutionRecord> component4() {
        return this.execRecords;
    }

    @NotNull
    public final JobResult copy(long r10, boolean r11, @NotNull String r12, @NotNull List<IntentExecutionRecord> r13) {
        q.g(r12, "message");
        q.g(r13, "execRecords");
        return new JobResult(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof JobResult) == true) goto L8;
        return false;
    L8:
        JobResult r11 = (JobResult) r10;
        if (this.questionId == r11.questionId) goto L12;
        return false;
    L12:
        if (this.hasError == r11.hasError) goto L15;
        return false;
    L15:
        if (q.b(this.message, r11.message) == true) goto L18;
        return false;
    L18:
        if (q.b(this.execRecords, r11.execRecords) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @NotNull
    public final List<IntentExecutionRecord> getExecRecords() {
        return this.execRecords;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    @NotNull
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
        int r10 = Long.hashCode(this.questionId) * 31;
        boolean r11 = this.hasError;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return ((((r10 + r12) * 31) + this.message.hashCode()) * 31) + this.execRecords.hashCode();
    }

    public final void setExecRecords(@NotNull List<IntentExecutionRecord> r10) {
        q.g(r10, "<set-?>");
        this.execRecords = r10;
    }

    public final void setHasError(boolean r10) {
        this.hasError = r10;
    }

    public final void setMessage(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.message = r10;
    }

    public final void setQuestionId(long r10) {
        this.questionId = r10;
    }

    @NotNull
    public String toString() {
        return "JobResult(questionId=" + this.questionId + ", hasError=" + this.hasError + ", message=" + this.message + ", execRecords=" + this.execRecords + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeLong(this.questionId);
        r10.writeInt(this.hasError ? 1 : 0);
        r10.writeString(this.message);
        List<IntentExecutionRecord> r12 = this.execRecords;
        r10.writeInt(r12.size());
        Iterator<IntentExecutionRecord> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().writeToParcel(r10, r11);
        goto L4
    }
}
