package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.versionedparcelable.AddField;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJJ\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\u0010\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0-H\u0016J\t\u0010.\u001a\u00020\u000bHÖ\u0001J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010+H\u0016J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R(\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSendMessageParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "", "targetId", "targetType", ServerElements.CONTENT, "Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;Ljava/lang/Integer;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;)V", "getTarget", "()Ljava/lang/String;", "setTarget", "(Ljava/lang/String;)V", "getTargetId", "setTargetId", "getTargetType", "setTargetType", "getVersion$annotations", "()V", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeSendMessageParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class OfficeSendMessageParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<OfficeSendMessageParams> CREATOR = null;

    @Nullable
    private OfficeMessageContent content;

    @Nullable
    private String target;

    @Nullable
    private String targetId;

    @Nullable
    private String targetType;

    @AddField
    @Nullable
    Integer version;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeSendMessageParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OfficeSendMessageParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            String r13 = r10.readString();
            String r14 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            OfficeMessageContent r15 = null;
        L6:
            OfficeSendMessageParams r16 = new OfficeSendMessageParams(r12, r13, r14, r15, null, 16, null);
            int r17 = Math.min(r11, 1);
            ClassLoader r18 = Creator.class.getClassLoader();
            int r19 = 1;
        L7:
            if (r19 > r17) goto L13;
            if (r19 != 1) goto L12;
            Object r20 = a.c(r10, r18);
            if (r20 == null) goto L12;
            r16.version = (Integer) r20;
        L12:
            r19 = r19 + 1;
        L13:
            if (r19 > r11) goto L15;
            a.d(r10, r18);
            r19 = r19 + 1;
            goto L13
        L15:
            return r16;
        L5:
            r15 = OfficeMessageContent.CREATOR.createFromParcel(r10);
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OfficeSendMessageParams[] newArray(int r10) {
            return new OfficeSendMessageParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSendMessageParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSendMessageParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public OfficeSendMessageParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        OfficeMessageContent r13 = null;
        Integer r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ OfficeSendMessageParams copy$default(OfficeSendMessageParams r10, String r11, String r12, String r13, OfficeMessageContent r14, Integer r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.targetId;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.targetType;
    L11:
        String r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.content;
    L14:
        OfficeMessageContent r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.version;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.target;
    }

    @Nullable
    public final String component2() {
        return this.targetId;
    }

    @Nullable
    public final String component3() {
        return this.targetType;
    }

    @Nullable
    public final OfficeMessageContent component4() {
        return this.content;
    }

    @Nullable
    public final Integer component5() {
        return this.version;
    }

    @NotNull
    public final OfficeSendMessageParams copy(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable OfficeMessageContent r13, @Nullable Integer r14) {
        return new OfficeSendMessageParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OfficeSendMessageParams) == true) goto L8;
        return false;
    L8:
        OfficeSendMessageParams r11 = (OfficeSendMessageParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.targetId, r11.targetId) == true) goto L15;
        return false;
    L15:
        if (q.b(this.targetType, r11.targetType) == true) goto L18;
        return false;
    L18:
        if (q.b(this.content, r11.content) == true) goto L21;
        return false;
    L21:
        if (q.b(this.version, r11.version) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final OfficeMessageContent getContent() {
        return this.content;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTarget() {
        return this.target;
    }

    @Nullable
    public final String getTargetId() {
        return this.targetId;
    }

    @Nullable
    public final String getTargetType() {
        return this.targetType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.content);
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        String r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.targetId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.targetType;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        OfficeMessageContent r20 = this.content;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.version;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
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
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof OfficeSendMessageParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((OfficeSendMessageParams) r10).target;
    L8:
        String r12 = r11;
        String r13 = this.targetId;
        if (r13 != null) goto L11;
        r13 = ((OfficeSendMessageParams) r10).targetId;
    L11:
        String r14 = r13;
        String r15 = this.targetType;
        if (r15 != null) goto L14;
        r15 = ((OfficeSendMessageParams) r10).targetType;
    L14:
        String r16 = r15;
        OfficeMessageContent r17 = this.content;
        if (r17 != null) goto L17;
        r17 = ((OfficeSendMessageParams) r10).content;
    L17:
        OfficeMessageContent r18 = r17;
        Integer r19 = this.version;
        if (r19 != null) goto L21;
        r19 = ((OfficeSendMessageParams) r10).version;
    L21:
        return new OfficeSendMessageParams(r12, r14, r16, r18, r19);
    }

    public final void setContent(@Nullable OfficeMessageContent r10) {
        this.content = r10;
    }

    public final void setTarget(@Nullable String r10) {
        this.target = r10;
    }

    public final void setTargetId(@Nullable String r10) {
        this.targetId = r10;
    }

    public final void setTargetType(@Nullable String r10) {
        this.targetType = r10;
    }

    public final void setVersion(@Nullable Integer r10) {
        this.version = r10;
    }

    @NotNull
    public String toString() {
        return "OfficeSendMessageParams(target=" + this.target + ", targetId=" + this.targetId + ", targetType=" + this.targetType + ", content=" + this.content + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(1);
        q.g(r10, "out");
        r10.writeString(this.target);
        r10.writeString(this.targetId);
        r10.writeString(this.targetType);
        OfficeMessageContent r12 = this.content;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        r10.writeValue(this.version);
        return;
    L5:
        r10.writeInt(1);
        r12.writeToParcel(r10, r11);
        goto L6
    }

    public OfficeSendMessageParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable OfficeMessageContent r13, @Nullable Integer r14) {
        this.target = r10;
        this.targetId = r11;
        this.targetType = r12;
        this.content = r13;
        this.version = r14;
    }

    public /* synthetic */ OfficeSendMessageParams(String r10, String r11, String r12, OfficeMessageContent r13, Integer r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = null;
    L17:
        this(r10, r11, r12, r13, r14);
    }
}
