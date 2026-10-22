package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.AddField;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003JJ\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\bHÖ\u0001J\u0013\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010-H\u0016J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\bHÖ\u0001R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "needDeepSearch", "", "limitCount", "", "interactionType", "meta", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType$annotations", "()V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getLimitCount$annotations", "getLimitCount", "()Ljava/lang/Integer;", "setLimitCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMeta$annotations", "getMeta", "setMeta", "getNeedDeepSearch$annotations", "getNeedDeepSearch", "()Ljava/lang/Boolean;", "setNeedDeepSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuResult", "setQuResult", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PCGlobalSearchIntentParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PCGlobalSearchIntentParams> CREATOR = null;

    @AddField
    @Nullable
    String interactionType;

    @AddField
    @Nullable
    Integer limitCount;

    @AddField
    @Nullable
    String meta;

    @AddField
    @Nullable
    Boolean needDeepSearch;

    @Nullable
    private String quResult;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PCGlobalSearchIntentParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PCGlobalSearchIntentParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PCGlobalSearchIntentParams r12 = new PCGlobalSearchIntentParams(r10.readString(), null, null, null, null, 30, null);
            int r13 = Math.min(r11, 4);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L23;
            if (r15 != 1) goto L9;
            Object r16 = a.c(r10, r14);
            if (r16 == null) goto L22;
            r12.needDeepSearch = (Boolean) r16;
        L22:
            r15 = r15 + 1;
            goto L3
        L9:
            if (r15 != 2) goto L14;
            Object r17 = a.c(r10, r14);
            if (r17 == null) goto L22;
            r12.limitCount = (Integer) r17;
            goto L22
        L14:
            if (r15 != 3) goto L18;
            Object r18 = a.c(r10, r14);
            if (r18 == null) goto L22;
            r12.interactionType = (String) r18;
            goto L22
        L18:
            if (r15 != 4) goto L22;
            Object r19 = a.c(r10, r14);
            if (r19 == null) goto L22;
            r12.meta = (String) r19;
        L23:
            if (r15 > r11) goto L25;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L23
        L25:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PCGlobalSearchIntentParams[] newArray(int r10) {
            return new PCGlobalSearchIntentParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCGlobalSearchIntentParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCGlobalSearchIntentParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PCGlobalSearchIntentParams() {
        String r10 = null;
        Boolean r11 = null;
        Integer r12 = null;
        String r13 = null;
        String r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ PCGlobalSearchIntentParams copy$default(PCGlobalSearchIntentParams r10, String r11, Boolean r12, Integer r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.quResult;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.needDeepSearch;
    L8:
        Boolean r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.limitCount;
    L11:
        Integer r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.interactionType;
    L14:
        String r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.meta;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public static /* synthetic */ void getInteractionType$annotations() {
    }

    public static /* synthetic */ void getLimitCount$annotations() {
    }

    public static /* synthetic */ void getMeta$annotations() {
    }

    public static /* synthetic */ void getNeedDeepSearch$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.quResult;
    }

    @Nullable
    public final Boolean component2() {
        return this.needDeepSearch;
    }

    @Nullable
    public final Integer component3() {
        return this.limitCount;
    }

    @Nullable
    public final String component4() {
        return this.interactionType;
    }

    @Nullable
    public final String component5() {
        return this.meta;
    }

    @NotNull
    public final PCGlobalSearchIntentParams copy(@Nullable String r10, @Nullable Boolean r11, @Nullable Integer r12, @Nullable String r13, @Nullable String r14) {
        return new PCGlobalSearchIntentParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PCGlobalSearchIntentParams) == true) goto L8;
        return false;
    L8:
        PCGlobalSearchIntentParams r11 = (PCGlobalSearchIntentParams) r10;
        if (q.b(this.quResult, r11.quResult) == true) goto L12;
        return false;
    L12:
        if (q.b(this.needDeepSearch, r11.needDeepSearch) == true) goto L15;
        return false;
    L15:
        if (q.b(this.limitCount, r11.limitCount) == true) goto L18;
        return false;
    L18:
        if (q.b(this.interactionType, r11.interactionType) == true) goto L21;
        return false;
    L21:
        if (q.b(this.meta, r11.meta) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final String getInteractionType() {
        return this.interactionType;
    }

    @Nullable
    public final Integer getLimitCount() {
        return this.limitCount;
    }

    @Nullable
    public final String getMeta() {
        return this.meta;
    }

    @Nullable
    public final Boolean getNeedDeepSearch() {
        return this.needDeepSearch;
    }

    @Nullable
    public final String getQuResult() {
        return this.quResult;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.quResult;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.needDeepSearch;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.limitCount;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.interactionType;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.meta;
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
        if ((r10 instanceof PCGlobalSearchIntentParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.quResult;
        if (r11 != null) goto L8;
        r11 = ((PCGlobalSearchIntentParams) r10).quResult;
    L8:
        String r12 = r11;
        Boolean r13 = this.needDeepSearch;
        if (r13 != null) goto L11;
        r13 = ((PCGlobalSearchIntentParams) r10).needDeepSearch;
    L11:
        Boolean r14 = r13;
        Integer r15 = this.limitCount;
        if (r15 != null) goto L14;
        r15 = ((PCGlobalSearchIntentParams) r10).limitCount;
    L14:
        Integer r16 = r15;
        String r17 = this.interactionType;
        if (r17 != null) goto L17;
        r17 = ((PCGlobalSearchIntentParams) r10).interactionType;
    L17:
        String r18 = r17;
        String r19 = this.meta;
        if (r19 != null) goto L21;
        r19 = ((PCGlobalSearchIntentParams) r10).meta;
    L21:
        return new PCGlobalSearchIntentParams(r12, r14, r16, r18, r19);
    }

    public final void setInteractionType(@Nullable String r10) {
        this.interactionType = r10;
    }

    public final void setLimitCount(@Nullable Integer r10) {
        this.limitCount = r10;
    }

    public final void setMeta(@Nullable String r10) {
        this.meta = r10;
    }

    public final void setNeedDeepSearch(@Nullable Boolean r10) {
        this.needDeepSearch = r10;
    }

    public final void setQuResult(@Nullable String r10) {
        this.quResult = r10;
    }

    @NotNull
    public String toString() {
        return "PCGlobalSearchIntentParams(quResult=" + this.quResult + ", needDeepSearch=" + this.needDeepSearch + ", limitCount=" + this.limitCount + ", interactionType=" + this.interactionType + ", meta=" + this.meta + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(4);
        q.g(r10, "out");
        r10.writeString(this.quResult);
        r10.writeValue(this.needDeepSearch);
        r10.writeValue(this.limitCount);
        r10.writeValue(this.interactionType);
        r10.writeValue(this.meta);
    }

    public PCGlobalSearchIntentParams(@Nullable String r10, @Nullable Boolean r11, @Nullable Integer r12, @Nullable String r13, @Nullable String r14) {
        this.quResult = r10;
        this.needDeepSearch = r11;
        this.limitCount = r12;
        this.interactionType = r13;
        this.meta = r14;
    }

    public /* synthetic */ PCGlobalSearchIntentParams(String r10, Boolean r11, Integer r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
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
