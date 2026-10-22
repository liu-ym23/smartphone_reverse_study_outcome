package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\b\u0010$\u001a\u00020 H\u0016J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemHeartBeatParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "questionId", "", "expiryTimestamp", "", "timeUntilNextHeartbeat", "ext", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getExpiryTimestamp", "()Ljava/lang/Long;", "setExpiryTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getQuestionId", "setQuestionId", "getTimeUntilNextHeartbeat", "setTimeUntilNextHeartbeat", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemHeartBeatParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemHeartBeatParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemHeartBeatParams> CREATOR = null;

    @Nullable
    private Long expiryTimestamp;

    @Nullable
    private String ext;

    @Nullable
    private String questionId;

    @Nullable
    private Long timeUntilNextHeartbeat;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemHeartBeatParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemHeartBeatParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            Long r13 = null;
            if (r10.readInt() != 0) goto L5;
            Long r14 = null;
        L7:
            if (r10.readInt() == 0) goto L10;
            r13 = Long.valueOf(r10.readLong());
        L10:
            SystemHeartBeatParams r15 = new SystemHeartBeatParams(r12, r14, r13, r10.readString());
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
            int r18 = 1;
        L11:
            if (r18 > r16) goto L13;
            r18 = r18 + 1;
        L13:
            if (r18 > r11) goto L15;
            a.d(r10, r17);
            r18 = r18 + 1;
            goto L13
        L15:
            return r15;
        L5:
            r14 = Long.valueOf(r10.readLong());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemHeartBeatParams[] newArray(int r10) {
            return new SystemHeartBeatParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemHeartBeatParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemHeartBeatParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemHeartBeatParams() {
        String r10 = null;
        Long r11 = null;
        Long r12 = null;
        String r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    public static /* synthetic */ SystemHeartBeatParams copy$default(SystemHeartBeatParams r10, String r11, Long r12, Long r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.questionId;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.expiryTimestamp;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.timeUntilNextHeartbeat;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.ext;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.questionId;
    }

    @Nullable
    public final Long component2() {
        return this.expiryTimestamp;
    }

    @Nullable
    public final Long component3() {
        return this.timeUntilNextHeartbeat;
    }

    @Nullable
    public final String component4() {
        return this.ext;
    }

    @NotNull
    public final SystemHeartBeatParams copy(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable String r13) {
        return new SystemHeartBeatParams(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemHeartBeatParams) == true) goto L8;
        return false;
    L8:
        SystemHeartBeatParams r11 = (SystemHeartBeatParams) r10;
        if (q.b(this.questionId, r11.questionId) == true) goto L12;
        return false;
    L12:
        if (q.b(this.expiryTimestamp, r11.expiryTimestamp) == true) goto L15;
        return false;
    L15:
        if (q.b(this.timeUntilNextHeartbeat, r11.timeUntilNextHeartbeat) == true) goto L18;
        return false;
    L18:
        if (q.b(this.ext, r11.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final Long getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    @Nullable
    public final String getExt() {
        return this.ext;
    }

    @Nullable
    public final String getQuestionId() {
        return this.questionId;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Long getTimeUntilNextHeartbeat() {
        return this.timeUntilNextHeartbeat;
    }

    public int hashCode() {
        String r10 = this.questionId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Long r14 = this.expiryTimestamp;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.timeUntilNextHeartbeat;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.ext;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.expiryTimestamp != null) goto L5;
    L7:
        return false;
    L5:
        if (this.timeUntilNextHeartbeat == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemHeartBeatParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.questionId;
        if (r11 != null) goto L8;
        r11 = ((SystemHeartBeatParams) r10).questionId;
    L8:
        Long r12 = this.expiryTimestamp;
        if (r12 != null) goto L11;
        r12 = ((SystemHeartBeatParams) r10).expiryTimestamp;
    L11:
        Long r13 = this.timeUntilNextHeartbeat;
        if (r13 != null) goto L14;
        r13 = ((SystemHeartBeatParams) r10).timeUntilNextHeartbeat;
    L14:
        String r14 = this.ext;
        if (r14 != null) goto L18;
        r14 = ((SystemHeartBeatParams) r10).ext;
    L18:
        return new SystemHeartBeatParams(r11, r12, r13, r14);
    }

    public final void setExpiryTimestamp(@Nullable Long r10) {
        this.expiryTimestamp = r10;
    }

    public final void setExt(@Nullable String r10) {
        this.ext = r10;
    }

    public final void setQuestionId(@Nullable String r10) {
        this.questionId = r10;
    }

    public final void setTimeUntilNextHeartbeat(@Nullable Long r10) {
        this.timeUntilNextHeartbeat = r10;
    }

    @NotNull
    public String toString() {
        return "SystemHeartBeatParams(questionId=" + this.questionId + ", expiryTimestamp=" + this.expiryTimestamp + ", timeUntilNextHeartbeat=" + this.timeUntilNextHeartbeat + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.questionId);
        Long r12 = this.expiryTimestamp;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Long r13 = this.timeUntilNextHeartbeat;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        r10.writeString(this.ext);
        return;
    L9:
        r10.writeInt(1);
        r10.writeLong(r13.longValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeLong(r12.longValue());
        goto L6
    }

    public SystemHeartBeatParams(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable String r13) {
        this.questionId = r10;
        this.expiryTimestamp = r11;
        this.timeUntilNextHeartbeat = r12;
        this.ext = r13;
    }

    public /* synthetic */ SystemHeartBeatParams(String r10, Long r11, Long r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
