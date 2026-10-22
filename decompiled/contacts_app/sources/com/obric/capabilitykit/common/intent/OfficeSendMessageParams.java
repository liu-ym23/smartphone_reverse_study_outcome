package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: OfficeSendMessageParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJJ\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\u0010\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0-H\u0016J\t\u0010.\u001a\u00020\u000bHÖ\u0001J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010+H\u0016J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R(\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSendMessageParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "", "targetId", "targetType", Params.CONTENT, "Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", GloableSearchConfig.KEY_VERSION, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;Ljava/lang/Integer;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;)V", "getTarget", "()Ljava/lang/String;", "setTarget", "(Ljava/lang/String;)V", "getTargetId", "setTargetId", "getTargetType", "setTargetType", "getVersion$annotations", "()V", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeSendMessageParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeSendMessageParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<OfficeSendMessageParams> CREATOR = null;
    private OfficeMessageContent content;
    private String target;
    private String targetId;
    private String targetType;
    Integer version;

    /* JADX INFO: compiled from: OfficeSendMessageParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeSendMessageParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSendMessageParams createFromParcel(Parcel r11) {
            int r0 = r11.readInt();
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r3 = r11.readString();
            String r4 = r11.readString();
            String r5 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            OfficeMessageContent r2 = null;
        L6:
            OfficeSendMessageParams r1 = new OfficeSendMessageParams(r3, r4, r5, r2, null, 16, null);
            int r6 = Math.min(r0, 1);
            ClassLoader r10 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r6) goto L13;
            if (r7 != 1) goto L12;
            Object r8 = ParcelUtils.readValueSafely(r11, r10);
            if (r8 == null) goto L12;
            r1.version = (Integer) r8;
        L12:
            r7 = r7 + 1;
        L13:
            if (r7 > r0) goto L15;
            ParcelUtils.skipValueSafely(r11, r10);
            r7 = r7 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r2 = OfficeMessageContent.CREATOR.createFromParcel(r11);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSendMessageParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSendMessageParams[] newArray(int r1) {
            return new OfficeSendMessageParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSendMessageParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public OfficeSendMessageParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OfficeSendMessageParams copy$default(OfficeSendMessageParams r3, String r4, String r5, String r6, OfficeMessageContent r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.target;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.targetId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.targetType;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.content;
    L14:
        OfficeMessageContent r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.version;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.target;
    }

    public final String component2() {
        return this.targetId;
    }

    public final String component3() {
        return this.targetType;
    }

    public final OfficeMessageContent component4() {
        return this.content;
    }

    public final Integer component5() {
        return this.version;
    }

    public final OfficeSendMessageParams copy(String r7, String r8, String r9, OfficeMessageContent r10, Integer r11) {
        return new OfficeSendMessageParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSendMessageParams) == true) goto L8;
        return false;
    L8:
        OfficeSendMessageParams r6 = (OfficeSendMessageParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetId, r6.targetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetType, r6.targetType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.targetId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.targetType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        OfficeMessageContent r10 = this.content;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.version;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeSendMessageParams(target=" + this.target + ", targetId=" + this.targetId + ", targetType=" + this.targetType + ", content=" + this.content + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(1);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.target);
        r3.writeString(this.targetId);
        r3.writeString(this.targetType);
        OfficeMessageContent r1 = this.content;
        if (r1 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeValue(this.version);
        return;
    L5:
        r3.writeInt(1);
        r1.writeToParcel(r3, r4);
        goto L6
    }

    public OfficeSendMessageParams(String r1, String r2, String r3, OfficeMessageContent r4, Integer r5) {
        this.target = r1;
        this.targetId = r2;
        this.targetType = r3;
        this.content = r4;
        this.version = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ OfficeSendMessageParams(String r2, String r3, String r4, OfficeMessageContent r5, Integer r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getTarget() {
        return this.target;
    }

    public final void setTarget(String r1) {
        this.target = r1;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final void setTargetId(String r1) {
        this.targetId = r1;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public final void setTargetType(String r1) {
        this.targetType = r1;
    }

    public final OfficeMessageContent getContent() {
        return this.content;
    }

    public final void setContent(OfficeMessageContent r1) {
        this.content = r1;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final void setVersion(Integer r1) {
        this.version = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r8) {
        if ((r8 instanceof OfficeSendMessageParams) == false) goto L5;
        String r0 = this.target;
        if (r0 != null) goto L9;
        r0 = ((OfficeSendMessageParams) r8).target;
    L9:
        String r2 = r0;
        String r1 = this.targetId;
        if (r1 != null) goto L12;
        r1 = ((OfficeSendMessageParams) r8).targetId;
    L12:
        String r3 = r1;
        String r4 = this.targetType;
        if (r4 != null) goto L15;
        r4 = ((OfficeSendMessageParams) r8).targetType;
    L15:
        String r5 = r4;
        OfficeMessageContent r6 = this.content;
        if (r6 != null) goto L18;
        r6 = ((OfficeSendMessageParams) r8).content;
    L18:
        OfficeMessageContent r7 = r6;
        Integer r9 = this.version;
        if (r9 != null) goto L22;
        r9 = ((OfficeSendMessageParams) r8).version;
    L22:
        return new OfficeSendMessageParams(r2, r3, r5, r7, r9);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.content);
    }
}
