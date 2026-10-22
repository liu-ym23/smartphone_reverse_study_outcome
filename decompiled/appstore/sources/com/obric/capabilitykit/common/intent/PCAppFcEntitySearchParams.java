package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010 \u001a\u00020\u001aHÖ\u0001J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aHÖ\u0001R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "interactionType", "domains", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getDomains", "()[Ljava/lang/String;", "setDomains", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getQuResult", "setQuResult", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PCAppFcEntitySearchParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PCAppFcEntitySearchParams> CREATOR = null;

    @Nullable
    private String[] domains;

    @Nullable
    private String interactionType;

    @Nullable
    private String quResult;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PCAppFcEntitySearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PCAppFcEntitySearchParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PCAppFcEntitySearchParams r12 = new PCAppFcEntitySearchParams(r10.readString(), r10.readString(), r10.createStringArray());
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PCAppFcEntitySearchParams[] newArray(int r10) {
            return new PCAppFcEntitySearchParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCAppFcEntitySearchParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCAppFcEntitySearchParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PCAppFcEntitySearchParams() {
        String r10 = null;
        String r11 = null;
        String[] r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ PCAppFcEntitySearchParams copy$default(PCAppFcEntitySearchParams r10, String r11, String r12, String[] r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.quResult;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.interactionType;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.domains;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final String component1() {
        return this.quResult;
    }

    @Nullable
    public final String component2() {
        return this.interactionType;
    }

    @Nullable
    public final String[] component3() {
        return this.domains;
    }

    @NotNull
    public final PCAppFcEntitySearchParams copy(@Nullable String r10, @Nullable String r11, @Nullable String[] r12) {
        return new PCAppFcEntitySearchParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PCAppFcEntitySearchParams) == true) goto L8;
        return false;
    L8:
        PCAppFcEntitySearchParams r11 = (PCAppFcEntitySearchParams) r10;
        if (q.b(this.quResult, r11.quResult) == true) goto L12;
        return false;
    L12:
        if (q.b(this.interactionType, r11.interactionType) == true) goto L15;
        return false;
    L15:
        if (q.b(this.domains, r11.domains) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final String[] getDomains() {
        return this.domains;
    }

    @Nullable
    public final String getInteractionType() {
        return this.interactionType;
    }

    @Nullable
    public final String getQuResult() {
        return this.quResult;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        String[] r10 = this.domains;
        if (r10 != null) goto L7;
        return null;
    L7:
        return n.C(r10, null, null, null, 0, null, null, 63, null);
    }

    public int hashCode() {
        String r10 = this.quResult;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.interactionType;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String[] r17 = this.domains;
        if (r17 == null) goto L15;
        r11 = Arrays.hashCode(r17);
    L15:
        return r16 + r11;
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
        if ((r10 instanceof PCAppFcEntitySearchParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.quResult;
        if (r11 != null) goto L8;
        r11 = ((PCAppFcEntitySearchParams) r10).quResult;
    L8:
        String r12 = this.interactionType;
        if (r12 != null) goto L11;
        r12 = ((PCAppFcEntitySearchParams) r10).interactionType;
    L11:
        String[] r13 = this.domains;
        if (r13 != null) goto L15;
        r13 = ((PCAppFcEntitySearchParams) r10).domains;
    L15:
        return new PCAppFcEntitySearchParams(r11, r12, r13);
    }

    public final void setDomains(@Nullable String[] r10) {
        this.domains = r10;
    }

    public final void setInteractionType(@Nullable String r10) {
        this.interactionType = r10;
    }

    public final void setQuResult(@Nullable String r10) {
        this.quResult = r10;
    }

    @NotNull
    public String toString() {
        return "PCAppFcEntitySearchParams(quResult=" + this.quResult + ", interactionType=" + this.interactionType + ", domains=" + Arrays.toString(this.domains) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.quResult);
        r10.writeString(this.interactionType);
        r10.writeStringArray(this.domains);
    }

    public PCAppFcEntitySearchParams(@Nullable String r10, @Nullable String r11, @Nullable String[] r12) {
        this.quResult = r10;
        this.interactionType = r11;
        this.domains = r12;
    }

    public /* synthetic */ PCAppFcEntitySearchParams(String r10, String r11, String[] r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
