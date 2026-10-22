package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.AddField;
import com.obric.versionedparcelable.VersionedParcelable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u00020\rHÖ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\rHÖ\u0001J\u0012\u0010:\u001a\u00020\u00012\b\u0010;\u001a\u0004\u0018\u000108H\u0016J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\rHÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R(\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010)\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006B"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSearchMeetingParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "timeType", "room", "participants", "", "agenda", "participantsId", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)V", "getAgenda", "()Ljava/lang/String;", "setAgenda", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getParticipants", "()[Ljava/lang/String;", "setParticipants", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getParticipantsId$annotations", "()V", "getParticipantsId", "setParticipantsId", "getRoom", "setRoom", "getStartTime", "setStartTime", "getTimeType", "setTimeType", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeSearchMeetingParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class OfficeSearchMeetingParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<OfficeSearchMeetingParams> CREATOR = null;

    @Nullable
    private String agenda;

    @Nullable
    private String endTime;

    @Nullable
    private String[] participants;

    @AddField
    @Nullable
    String[] participantsId;

    @Nullable
    private String room;

    @Nullable
    private String startTime;

    @Nullable
    private String timeType;

    @AddField
    @Nullable
    Integer version;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeSearchMeetingParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OfficeSearchMeetingParams createFromParcel(@NotNull Parcel r13) {
            int r12 = r13.readInt();
            q.g(r13, "parcel");
            OfficeSearchMeetingParams r10 = new OfficeSearchMeetingParams(r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.createStringArray(), r13.readString(), null, null, 192, null);
            int r11 = Math.min(r12, 2);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r11) goto L13;
            if (r15 != 1) goto L8;
            Object r16 = a.c(r13, r14);
            if (r16 == null) goto L12;
            r10.participantsId = (String[]) r16;
        L12:
            r15 = r15 + 1;
            goto L3
        L8:
            if (r15 != 2) goto L12;
            Object r17 = a.c(r13, r14);
            if (r17 == null) goto L12;
            r10.version = (Integer) r17;
        L13:
            if (r15 > r12) goto L15;
            a.d(r13, r14);
            r15 = r15 + 1;
            goto L13
        L15:
            return r10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OfficeSearchMeetingParams[] newArray(int r10) {
            return new OfficeSearchMeetingParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchMeetingParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchMeetingParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public OfficeSearchMeetingParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String[] r14 = null;
        String r15 = null;
        String[] r16 = null;
        Integer r17 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, PrivateKeyType.INVALID, null);
    }

    public static /* synthetic */ OfficeSearchMeetingParams copy$default(OfficeSearchMeetingParams r10, String r11, String r12, String r13, String r14, String[] r15, String r16, String[] r17, Integer r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.startTime;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.endTime;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.timeType;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.room;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String[] r24 = r10.participants;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.agenda;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String[] r26 = r10.participantsId;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Integer r27 = r10.version;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    public static /* synthetic */ void getParticipantsId$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.startTime;
    }

    @Nullable
    public final String component2() {
        return this.endTime;
    }

    @Nullable
    public final String component3() {
        return this.timeType;
    }

    @Nullable
    public final String component4() {
        return this.room;
    }

    @Nullable
    public final String[] component5() {
        return this.participants;
    }

    @Nullable
    public final String component6() {
        return this.agenda;
    }

    @Nullable
    public final String[] component7() {
        return this.participantsId;
    }

    @Nullable
    public final Integer component8() {
        return this.version;
    }

    @NotNull
    public final OfficeSearchMeetingParams copy(@Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String[] r15, @Nullable String r16, @Nullable String[] r17, @Nullable Integer r18) {
        return new OfficeSearchMeetingParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OfficeSearchMeetingParams) == true) goto L8;
        return false;
    L8:
        OfficeSearchMeetingParams r11 = (OfficeSearchMeetingParams) r10;
        if (q.b(this.startTime, r11.startTime) == true) goto L12;
        return false;
    L12:
        if (q.b(this.endTime, r11.endTime) == true) goto L15;
        return false;
    L15:
        if (q.b(this.timeType, r11.timeType) == true) goto L18;
        return false;
    L18:
        if (q.b(this.room, r11.room) == true) goto L21;
        return false;
    L21:
        if (q.b(this.participants, r11.participants) == true) goto L24;
        return false;
    L24:
        if (q.b(this.agenda, r11.agenda) == true) goto L27;
        return false;
    L27:
        if (q.b(this.participantsId, r11.participantsId) == true) goto L30;
        return false;
    L30:
        if (q.b(this.version, r11.version) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Nullable
    public final String getAgenda() {
        return this.agenda;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final String[] getParticipants() {
        return this.participants;
    }

    @Nullable
    public final String[] getParticipantsId() {
        return this.participantsId;
    }

    @Nullable
    public final String getRoom() {
        return this.room;
    }

    @Nullable
    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTimeType() {
        return this.timeType;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        String r10 = this.startTime;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.endTime;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.timeType;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.room;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String[] r23 = this.participants;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.agenda;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String[] r29 = this.participantsId;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.version;
        if (r32 == null) goto L35;
        r11 = r32.hashCode();
    L35:
        return r31 + r11;
    L29:
        r30 = Arrays.hashCode(r29);
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = Arrays.hashCode(r23);
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
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
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r11) {
        if ((r11 instanceof OfficeSearchMeetingParams) == true) goto L5;
        return this;
    L5:
        String r10 = this.startTime;
        if (r10 != null) goto L8;
        r10 = ((OfficeSearchMeetingParams) r11).startTime;
    L8:
        String r12 = r10;
        String r13 = this.endTime;
        if (r13 != null) goto L11;
        r13 = ((OfficeSearchMeetingParams) r11).endTime;
    L11:
        String r14 = r13;
        String r15 = this.timeType;
        if (r15 != null) goto L14;
        r15 = ((OfficeSearchMeetingParams) r11).timeType;
    L14:
        String r16 = r15;
        String r17 = this.room;
        if (r17 != null) goto L17;
        r17 = ((OfficeSearchMeetingParams) r11).room;
    L17:
        String r18 = r17;
        String[] r19 = this.participants;
        if (r19 != null) goto L20;
        r19 = ((OfficeSearchMeetingParams) r11).participants;
    L20:
        String[] r20 = r19;
        String r21 = this.agenda;
        if (r21 != null) goto L23;
        r21 = ((OfficeSearchMeetingParams) r11).agenda;
    L23:
        String r22 = r21;
        String[] r23 = this.participantsId;
        if (r23 != null) goto L26;
        r23 = ((OfficeSearchMeetingParams) r11).participantsId;
    L26:
        String[] r24 = r23;
        Integer r110 = this.version;
        if (r110 != null) goto L30;
        r110 = ((OfficeSearchMeetingParams) r11).version;
    L30:
        return new OfficeSearchMeetingParams(r12, r14, r16, r18, r20, r22, r24, r110);
    }

    public final void setAgenda(@Nullable String r10) {
        this.agenda = r10;
    }

    public final void setEndTime(@Nullable String r10) {
        this.endTime = r10;
    }

    public final void setParticipants(@Nullable String[] r10) {
        this.participants = r10;
    }

    public final void setParticipantsId(@Nullable String[] r10) {
        this.participantsId = r10;
    }

    public final void setRoom(@Nullable String r10) {
        this.room = r10;
    }

    public final void setStartTime(@Nullable String r10) {
        this.startTime = r10;
    }

    public final void setTimeType(@Nullable String r10) {
        this.timeType = r10;
    }

    public final void setVersion(@Nullable Integer r10) {
        this.version = r10;
    }

    @NotNull
    public String toString() {
        return "OfficeSearchMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", timeType=" + this.timeType + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(2);
        q.g(r10, "out");
        r10.writeString(this.startTime);
        r10.writeString(this.endTime);
        r10.writeString(this.timeType);
        r10.writeString(this.room);
        r10.writeStringArray(this.participants);
        r10.writeString(this.agenda);
        r10.writeValue(this.participantsId);
        r10.writeValue(this.version);
    }

    public OfficeSearchMeetingParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String[] r14, @Nullable String r15, @Nullable String[] r16, @Nullable Integer r17) {
        this.startTime = r10;
        this.endTime = r11;
        this.timeType = r12;
        this.room = r13;
        this.participants = r14;
        this.agenda = r15;
        this.participantsId = r16;
        this.version = r17;
    }

    public /* synthetic */ OfficeSearchMeetingParams(String r10, String r11, String r12, String r13, String[] r14, String r15, String[] r16, Integer r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r18 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r18 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r18 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r18 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r18 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r18 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r18 & 128) == 0) goto L26;
        r17 = null;
    L26:
        this(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
