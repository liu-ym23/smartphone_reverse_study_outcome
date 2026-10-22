package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.AddField;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u008b\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020/HÖ\u0001J\t\u00105\u001a\u00020\tHÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R,\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentCalling;", "Landroid/os/Parcelable;", "questionId", "", "messageId", "actionId", "jobId", "replyFor", "intentName", "", "implClassName", "inputParamTypeName", "inputParams", "inputParamsParcel", "ext", "", "(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Parcelable;Ljava/util/Map;)V", "getActionId", "()J", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getImplClassName", "()Ljava/lang/String;", "getInputParamTypeName", "getInputParams", "getInputParamsParcel", "()Landroid/os/Parcelable;", "getIntentName", "getJobId", "getMessageId", "getQuestionId", "getReplyFor", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class IntentCalling implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<IntentCalling> CREATOR = null;
    private final long actionId;

    @AddField
    @Nullable
    public Map<String, String> ext;

    @NotNull
    private final String implClassName;

    @Nullable
    private final String inputParamTypeName;

    @Nullable
    private final String inputParams;

    @Nullable
    private final Parcelable inputParamsParcel;

    @NotNull
    private final String intentName;
    private final long jobId;
    private final long messageId;
    private final long questionId;
    private final long replyFor;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<IntentCalling> {
        public a() {
        }

        @NotNull
        public final IntentCalling a(@NotNull Parcel r22) {
            int r10 = r22.readInt();
            q.g(r22, "parcel");
            long r11 = r22.readLong();
            long r12 = r22.readLong();
            long r13 = r22.readLong();
            long r14 = r22.readLong();
            long r15 = r22.readLong();
            String r16 = r22.readString();
            String r17 = r22.readString();
            String r18 = r22.readString();
            String r19 = r22.readString();
            Parcelable r110 = r22.readParcelable(IntentCalling.class.getClassLoader());
            if (r22.readInt() != 0) goto L5;
            int r20 = r10;
            LinkedHashMap r111 = null;
        L9:
            IntentCalling r21 = new IntentCalling(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
            int r23 = r20;
            int r24 = Math.min(r23, 1);
            ClassLoader r25 = a.class.getClassLoader();
            int r26 = 1;
        L11:
            if (r26 > r24) goto L17;
            if (r26 != 1) goto L16;
            Object r27 = be.a.c(r22, r25);
            if (r27 == null) goto L16;
            r21.ext = (Map) r27;
        L16:
            r26 = r26 + 1;
        L17:
            if (r26 > r23) goto L19;
            be.a.d(r22, r25);
            r26 = r26 + 1;
            goto L17
        L19:
            return r21;
        L5:
            int r28 = r22.readInt();
            LinkedHashMap r29 = new LinkedHashMap(r28);
            int r30 = 0;
        L6:
            if (r30 == r28) goto L8;
            r29.put(r22.readString(), r22.readString());
            r30 = r30 + 1;
            r28 = r28;
            r10 = r10;
            goto L6
        L8:
            r20 = r10;
            r111 = r29;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentCalling createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentCalling[] newArray(int r10) {
            return a(r10);
        }

        @NotNull
        public final IntentCalling[] a(int r10) {
            return new IntentCalling[r10];
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentCalling(long r10, long r11, long r12, long r13, long r14, @NotNull String r16, @NotNull String r17, @Nullable String r18, @Nullable String r19, @Nullable Parcelable r20, @Nullable Map<String, String> r21) {
        q.g(r16, "intentName");
        q.g(r17, "implClassName");
        this.questionId = r10;
        this.messageId = r11;
        this.actionId = r12;
        this.jobId = r13;
        this.replyFor = r14;
        this.intentName = r16;
        this.implClassName = r17;
        this.inputParamTypeName = r18;
        this.inputParams = r19;
        this.inputParamsParcel = r20;
        this.ext = r21;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntentCalling copy$default(IntentCalling r16, long r17, long r19, long r21, long r23, long r25, String r27, String r28, String r29, String r30, Parcelable r31, Map r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r10 = r16.questionId;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r11 = r16.messageId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r12 = r16.actionId;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r13 = r16.jobId;
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r14 = r16.replyFor;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r15 = r16.intentName;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r18 = r16.implClassName;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r110 = r16.inputParamTypeName;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r111 = r16.inputParams;
    L38:
        String r35 = r111;
        if ((r33 & 512) == 0) goto L41;
        Parcelable r112 = r16.inputParamsParcel;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        Map r20 = r16.ext;
    L47:
        return r16.copy(r10, r11, r12, r13, r14, r15, r18, r110, r35, r112, r20);
    L45:
        r20 = r32;
        goto L47
    L41:
        r112 = r31;
        goto L43
    L37:
        r111 = r30;
        goto L38
    L33:
        r110 = r29;
        goto L35
    L29:
        r18 = r28;
        goto L31
    L25:
        r15 = r27;
        goto L27
    L21:
        r14 = r25;
        goto L23
    L17:
        r13 = r23;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public final long component1() {
        return this.questionId;
    }

    @Nullable
    public final Parcelable component10() {
        return this.inputParamsParcel;
    }

    @Nullable
    public final Map<String, String> component11() {
        return this.ext;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.actionId;
    }

    public final long component4() {
        return this.jobId;
    }

    public final long component5() {
        return this.replyFor;
    }

    @NotNull
    public final String component6() {
        return this.intentName;
    }

    @NotNull
    public final String component7() {
        return this.implClassName;
    }

    @Nullable
    public final String component8() {
        return this.inputParamTypeName;
    }

    @Nullable
    public final String component9() {
        return this.inputParams;
    }

    @NotNull
    public final IntentCalling copy(long r19, long r21, long r23, long r25, long r27, @NotNull String r29, @NotNull String r30, @Nullable String r31, @Nullable String r32, @Nullable Parcelable r33, @Nullable Map<String, String> r34) {
        q.g(r29, "intentName");
        q.g(r30, "implClassName");
        return new IntentCalling(r19, r21, r23, r25, r27, r29, r30, r31, r32, r33, r34);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IntentCalling) == true) goto L8;
        return false;
    L8:
        IntentCalling r11 = (IntentCalling) r10;
        if (this.questionId == r11.questionId) goto L12;
        return false;
    L12:
        if (this.messageId == r11.messageId) goto L15;
        return false;
    L15:
        if (this.actionId == r11.actionId) goto L18;
        return false;
    L18:
        if (this.jobId == r11.jobId) goto L21;
        return false;
    L21:
        if (this.replyFor == r11.replyFor) goto L24;
        return false;
    L24:
        if (q.b(this.intentName, r11.intentName) == true) goto L27;
        return false;
    L27:
        if (q.b(this.implClassName, r11.implClassName) == true) goto L30;
        return false;
    L30:
        if (q.b(this.inputParamTypeName, r11.inputParamTypeName) == true) goto L33;
        return false;
    L33:
        if (q.b(this.inputParams, r11.inputParams) == true) goto L36;
        return false;
    L36:
        if (q.b(this.inputParamsParcel, r11.inputParamsParcel) == true) goto L39;
        return false;
    L39:
        if (q.b(this.ext, r11.ext) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final long getActionId() {
        return this.actionId;
    }

    @Nullable
    public final Map<String, String> getExt() {
        return this.ext;
    }

    @NotNull
    public final String getImplClassName() {
        return this.implClassName;
    }

    @Nullable
    public final String getInputParamTypeName() {
        return this.inputParamTypeName;
    }

    @Nullable
    public final String getInputParams() {
        return this.inputParams;
    }

    @Nullable
    public final Parcelable getInputParamsParcel() {
        return this.inputParamsParcel;
    }

    @NotNull
    public final String getIntentName() {
        return this.intentName;
    }

    public final long getJobId() {
        return this.jobId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final long getReplyFor() {
        return this.replyFor;
    }

    public int hashCode() {
        int r10 = ((((((((((((Long.hashCode(this.questionId) * 31) + Long.hashCode(this.messageId)) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + Long.hashCode(this.replyFor)) * 31) + this.intentName.hashCode()) * 31) + this.implClassName.hashCode()) * 31;
        String r11 = this.inputParamTypeName;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.inputParams;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        Parcelable r18 = this.inputParamsParcel;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        Map<String, String> r21 = this.ext;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        return r20 + r12;
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setExt(@Nullable Map<String, String> r10) {
        this.ext = r10;
    }

    @NotNull
    public String toString() {
        return "IntentCalling(questionId=" + this.questionId + ", messageId=" + this.messageId + ", actionId=" + this.actionId + ", jobId=" + this.jobId + ", replyFor=" + this.replyFor + ", intentName=" + this.intentName + ", implClassName=" + this.implClassName + ", inputParamTypeName=" + this.inputParamTypeName + ", inputParams=" + this.inputParams + ", inputParamsParcel=" + this.inputParamsParcel + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(1);
        q.g(r10, "out");
        r10.writeLong(this.questionId);
        r10.writeLong(this.messageId);
        r10.writeLong(this.actionId);
        r10.writeLong(this.jobId);
        r10.writeLong(this.replyFor);
        r10.writeString(this.intentName);
        r10.writeString(this.implClassName);
        r10.writeString(this.inputParamTypeName);
        r10.writeString(this.inputParams);
        r10.writeParcelable(this.inputParamsParcel, r11);
        Map<String, String> r12 = this.ext;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L9:
        r10.writeValue(this.ext);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.size());
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, String> r14 = r13.next();
        r10.writeString(r14.getKey());
        r10.writeString(r14.getValue());
        goto L7
    }
}
