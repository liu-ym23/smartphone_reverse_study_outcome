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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\b\u0010!\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCCommonGlobalSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "originQuery", "", "searchParams", "interactionType", "memoryScene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getMemoryScene$annotations", "()V", "getMemoryScene", "setMemoryScene", "getOriginQuery", "setOriginQuery", "getSearchParams", "setSearchParams", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PCCommonGlobalSearchParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PCCommonGlobalSearchParams> CREATOR = null;

    @Nullable
    private String interactionType;

    @AddField
    @Nullable
    String memoryScene;

    @Nullable
    private String originQuery;

    @Nullable
    private String searchParams;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PCCommonGlobalSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PCCommonGlobalSearchParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PCCommonGlobalSearchParams r12 = new PCCommonGlobalSearchParams(r10.readString(), r10.readString(), r10.readString(), null, 8, null);
            int r13 = Math.min(r11, 1);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L9;
            if (r15 != 1) goto L8;
            Object r16 = a.c(r10, r14);
            if (r16 == null) goto L8;
            r12.memoryScene = (String) r16;
        L8:
            r15 = r15 + 1;
        L9:
            if (r15 > r11) goto L11;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L9
        L11:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PCCommonGlobalSearchParams[] newArray(int r10) {
            return new PCCommonGlobalSearchParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCCommonGlobalSearchParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCCommonGlobalSearchParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PCCommonGlobalSearchParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    public static /* synthetic */ PCCommonGlobalSearchParams copy$default(PCCommonGlobalSearchParams r10, String r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.originQuery;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.searchParams;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.interactionType;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.memoryScene;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    public static /* synthetic */ void getMemoryScene$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.originQuery;
    }

    @Nullable
    public final String component2() {
        return this.searchParams;
    }

    @Nullable
    public final String component3() {
        return this.interactionType;
    }

    @Nullable
    public final String component4() {
        return this.memoryScene;
    }

    @NotNull
    public final PCCommonGlobalSearchParams copy(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13) {
        return new PCCommonGlobalSearchParams(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PCCommonGlobalSearchParams) == true) goto L8;
        return false;
    L8:
        PCCommonGlobalSearchParams r11 = (PCCommonGlobalSearchParams) r10;
        if (q.b(this.originQuery, r11.originQuery) == true) goto L12;
        return false;
    L12:
        if (q.b(this.searchParams, r11.searchParams) == true) goto L15;
        return false;
    L15:
        if (q.b(this.interactionType, r11.interactionType) == true) goto L18;
        return false;
    L18:
        if (q.b(this.memoryScene, r11.memoryScene) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getInteractionType() {
        return this.interactionType;
    }

    @Nullable
    public final String getMemoryScene() {
        return this.memoryScene;
    }

    @Nullable
    public final String getOriginQuery() {
        return this.originQuery;
    }

    @Nullable
    public final String getSearchParams() {
        return this.searchParams;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.originQuery;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.searchParams;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.interactionType;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.memoryScene;
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
        if (this.originQuery != null) goto L5;
    L7:
        return false;
    L5:
        if (this.searchParams == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PCCommonGlobalSearchParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.originQuery;
        if (r11 != null) goto L8;
        r11 = ((PCCommonGlobalSearchParams) r10).originQuery;
    L8:
        String r12 = this.searchParams;
        if (r12 != null) goto L11;
        r12 = ((PCCommonGlobalSearchParams) r10).searchParams;
    L11:
        String r13 = this.interactionType;
        if (r13 != null) goto L14;
        r13 = ((PCCommonGlobalSearchParams) r10).interactionType;
    L14:
        String r14 = this.memoryScene;
        if (r14 != null) goto L18;
        r14 = ((PCCommonGlobalSearchParams) r10).memoryScene;
    L18:
        return new PCCommonGlobalSearchParams(r11, r12, r13, r14);
    }

    public final void setInteractionType(@Nullable String r10) {
        this.interactionType = r10;
    }

    public final void setMemoryScene(@Nullable String r10) {
        this.memoryScene = r10;
    }

    public final void setOriginQuery(@Nullable String r10) {
        this.originQuery = r10;
    }

    public final void setSearchParams(@Nullable String r10) {
        this.searchParams = r10;
    }

    @NotNull
    public String toString() {
        return "PCCommonGlobalSearchParams(originQuery=" + this.originQuery + ", searchParams=" + this.searchParams + ", interactionType=" + this.interactionType + ", memoryScene=" + this.memoryScene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(1);
        q.g(r10, "out");
        r10.writeString(this.originQuery);
        r10.writeString(this.searchParams);
        r10.writeString(this.interactionType);
        r10.writeValue(this.memoryScene);
    }

    public PCCommonGlobalSearchParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13) {
        this.originQuery = r10;
        this.searchParams = r11;
        this.interactionType = r12;
        this.memoryScene = r13;
    }

    public /* synthetic */ PCCommonGlobalSearchParams(String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
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
