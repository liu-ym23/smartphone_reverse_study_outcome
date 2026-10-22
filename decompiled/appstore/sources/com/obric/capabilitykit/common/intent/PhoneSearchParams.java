package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 Jz\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\t\u00105\u001a\u00020\u000eHÖ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000eHÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000109H\u0016J\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "contactName", "telephone", "startTimestamp", "", "endTimestamp", "callType", "callConnectionType", ServerElements.CONTENT, "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCallConnectionType", "()Ljava/lang/String;", "setCallConnectionType", "(Ljava/lang/String;)V", "getCallType", "setCallType", "getContactName", "setContactName", "getContent", "setContent", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getTelephone", "setTelephone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhoneSearchParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhoneSearchParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PhoneSearchParams> CREATOR = null;

    @Nullable
    private String callConnectionType;

    @Nullable
    private String callType;

    @Nullable
    private String contactName;

    @Nullable
    private String content;

    @Nullable
    private Long endTimestamp;

    @Nullable
    private Integer maxCount;

    @Nullable
    private String query;

    @Nullable
    private Long startTimestamp;

    @Nullable
    private String telephone;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneSearchParams createFromParcel(@NotNull Parcel r13) {
            int r12 = r13.readInt();
            q.g(r13, "parcel");
            String r10 = r13.readString();
            String r11 = r13.readString();
            String r14 = r13.readString();
            if (r13.readInt() != 0) goto L5;
            Long r15 = null;
        L7:
            if (r13.readInt() != 0) goto L9;
            Long r16 = null;
        L10:
            String r17 = r13.readString();
            String r18 = r13.readString();
            String r19 = r13.readString();
            if (r13.readInt() != 0) goto L13;
            Integer r110 = null;
        L14:
            PhoneSearchParams r20 = new PhoneSearchParams(r10, r11, r14, r15, r16, r17, r18, r19, r110);
            int r21 = Math.min(r12, 0);
            ClassLoader r22 = Creator.class.getClassLoader();
            int r23 = 1;
        L15:
            if (r23 > r21) goto L17;
            r23 = r23 + 1;
        L17:
            if (r23 > r12) goto L19;
            a.d(r13, r22);
            r23 = r23 + 1;
            goto L17
        L19:
            return r20;
        L13:
            r110 = Integer.valueOf(r13.readInt());
            goto L14
        L9:
            r16 = Long.valueOf(r13.readLong());
            goto L10
        L5:
            r15 = Long.valueOf(r13.readLong());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneSearchParams[] newArray(int r10) {
            return new PhoneSearchParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneSearchParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneSearchParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PhoneSearchParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        Long r13 = null;
        Long r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        Integer r18 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, 511, null);
    }

    public static /* synthetic */ PhoneSearchParams copy$default(PhoneSearchParams r10, String r11, String r12, String r13, Long r14, Long r15, String r16, String r17, String r18, Integer r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r22 = r10.query;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r23 = r10.contactName;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r24 = r10.telephone;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Long r25 = r10.startTimestamp;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Long r26 = r10.endTimestamp;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r27 = r10.callType;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r28 = r10.callConnectionType;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r29 = r10.content;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Integer r30 = r10.maxCount;
    L39:
        return r10.copy(r22, r23, r24, r25, r26, r27, r28, r29, r30);
    L37:
        r30 = r19;
        goto L39
    L33:
        r29 = r18;
        goto L35
    L29:
        r28 = r17;
        goto L31
    L25:
        r27 = r16;
        goto L27
    L21:
        r26 = r15;
        goto L23
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r22 = r11;
        goto L7
    }

    @Nullable
    public final String component1() {
        return this.query;
    }

    @Nullable
    public final String component2() {
        return this.contactName;
    }

    @Nullable
    public final String component3() {
        return this.telephone;
    }

    @Nullable
    public final Long component4() {
        return this.startTimestamp;
    }

    @Nullable
    public final Long component5() {
        return this.endTimestamp;
    }

    @Nullable
    public final String component6() {
        return this.callType;
    }

    @Nullable
    public final String component7() {
        return this.callConnectionType;
    }

    @Nullable
    public final String component8() {
        return this.content;
    }

    @Nullable
    public final Integer component9() {
        return this.maxCount;
    }

    @NotNull
    public final PhoneSearchParams copy(@Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable Long r15, @Nullable Long r16, @Nullable String r17, @Nullable String r18, @Nullable String r19, @Nullable Integer r20) {
        return new PhoneSearchParams(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhoneSearchParams) == true) goto L8;
        return false;
    L8:
        PhoneSearchParams r11 = (PhoneSearchParams) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.contactName, r11.contactName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.telephone, r11.telephone) == true) goto L18;
        return false;
    L18:
        if (q.b(this.startTimestamp, r11.startTimestamp) == true) goto L21;
        return false;
    L21:
        if (q.b(this.endTimestamp, r11.endTimestamp) == true) goto L24;
        return false;
    L24:
        if (q.b(this.callType, r11.callType) == true) goto L27;
        return false;
    L27:
        if (q.b(this.callConnectionType, r11.callConnectionType) == true) goto L30;
        return false;
    L30:
        if (q.b(this.content, r11.content) == true) goto L33;
        return false;
    L33:
        if (q.b(this.maxCount, r11.maxCount) == true) goto L35;
        return false;
    L35:
        return true;
    }

    @Nullable
    public final String getCallConnectionType() {
        return this.callConnectionType;
    }

    @Nullable
    public final String getCallType() {
        return this.callType;
    }

    @Nullable
    public final String getContactName() {
        return this.contactName;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Nullable
    public final Integer getMaxCount() {
        return this.maxCount;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTelephone() {
        return this.telephone;
    }

    public int hashCode() {
        String r10 = this.query;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.contactName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.telephone;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.startTimestamp;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.endTimestamp;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.callType;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.callConnectionType;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.content;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.maxCount;
        if (r35 == null) goto L39;
        r11 = r35.hashCode();
    L39:
        return r34 + r11;
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
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
    public IntentParams mergeParams(@Nullable Object r12) {
        if ((r12 instanceof PhoneSearchParams) == true) goto L5;
        return this;
    L5:
        String r10 = this.query;
        if (r10 != null) goto L8;
        r10 = ((PhoneSearchParams) r12).query;
    L8:
        String r11 = r10;
        String r13 = this.contactName;
        if (r13 != null) goto L11;
        r13 = ((PhoneSearchParams) r12).contactName;
    L11:
        String r14 = r13;
        String r15 = this.telephone;
        if (r15 != null) goto L14;
        r15 = ((PhoneSearchParams) r12).telephone;
    L14:
        String r16 = r15;
        Long r17 = this.startTimestamp;
        if (r17 != null) goto L17;
        r17 = ((PhoneSearchParams) r12).startTimestamp;
    L17:
        Long r18 = r17;
        Long r19 = this.endTimestamp;
        if (r19 != null) goto L20;
        r19 = ((PhoneSearchParams) r12).endTimestamp;
    L20:
        Long r20 = r19;
        String r21 = this.callType;
        if (r21 != null) goto L23;
        r21 = ((PhoneSearchParams) r12).callType;
    L23:
        String r22 = r21;
        String r23 = this.callConnectionType;
        if (r23 != null) goto L26;
        r23 = ((PhoneSearchParams) r12).callConnectionType;
    L26:
        String r24 = r23;
        String r25 = this.content;
        if (r25 != null) goto L29;
        r25 = ((PhoneSearchParams) r12).content;
    L29:
        String r26 = r25;
        Integer r110 = this.maxCount;
        if (r110 != null) goto L33;
        r110 = ((PhoneSearchParams) r12).maxCount;
    L33:
        return new PhoneSearchParams(r11, r14, r16, r18, r20, r22, r24, r26, r110);
    }

    public final void setCallConnectionType(@Nullable String r10) {
        this.callConnectionType = r10;
    }

    public final void setCallType(@Nullable String r10) {
        this.callType = r10;
    }

    public final void setContactName(@Nullable String r10) {
        this.contactName = r10;
    }

    public final void setContent(@Nullable String r10) {
        this.content = r10;
    }

    public final void setEndTimestamp(@Nullable Long r10) {
        this.endTimestamp = r10;
    }

    public final void setMaxCount(@Nullable Integer r10) {
        this.maxCount = r10;
    }

    public final void setQuery(@Nullable String r10) {
        this.query = r10;
    }

    public final void setStartTimestamp(@Nullable Long r10) {
        this.startTimestamp = r10;
    }

    public final void setTelephone(@Nullable String r10) {
        this.telephone = r10;
    }

    @NotNull
    public String toString() {
        return "PhoneSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", callType=" + this.callType + ", callConnectionType=" + this.callConnectionType + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.query);
        r10.writeString(this.contactName);
        r10.writeString(this.telephone);
        Long r12 = this.startTimestamp;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Long r13 = this.endTimestamp;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        r10.writeString(this.callType);
        r10.writeString(this.callConnectionType);
        r10.writeString(this.content);
        Integer r14 = this.maxCount;
        if (r14 != null) goto L13;
        r10.writeInt(0);
        return;
    L13:
        r10.writeInt(1);
        r10.writeInt(r14.intValue());
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

    public PhoneSearchParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable Long r13, @Nullable Long r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable Integer r18) {
        this.query = r10;
        this.contactName = r11;
        this.telephone = r12;
        this.startTimestamp = r13;
        this.endTimestamp = r14;
        this.callType = r15;
        this.callConnectionType = r16;
        this.content = r17;
        this.maxCount = r18;
    }

    public /* synthetic */ PhoneSearchParams(String r10, String r11, String r12, Long r13, Long r14, String r15, String r16, String r17, Integer r18, int r19, DefaultConstructorMarker r110) {
        if ((r19 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r19 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r19 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r19 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r19 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r19 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r19 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r19 & 128) == 0) goto L27;
        r17 = null;
    L27:
        if ((r19 & 256) == 0) goto L29;
        r18 = null;
    L29:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
