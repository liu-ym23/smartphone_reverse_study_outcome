package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.AddField;
import com.obric.versionedparcelable.VersionedParcelable;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001cHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserSelectParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "candidate", "", "", "type", "sourceIntent", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCandidate", "()[Ljava/lang/String;", "setCandidate", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getSourceIntent$annotations", "()V", "getSourceIntent", "()Ljava/lang/String;", "setSourceIntent", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "component3", "copy", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserSelectParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemUserSelectParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemUserSelectParams> CREATOR = null;

    @Nullable
    private String[] candidate;

    @AddField
    @Nullable
    String sourceIntent;

    @Nullable
    private String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserSelectParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemUserSelectParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            SystemUserSelectParams r12 = new SystemUserSelectParams(r10.createStringArray(), r10.readString(), null, 4, null);
            int r13 = Math.min(r11, 1);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L9;
            if (r15 != 1) goto L8;
            Object r16 = a.c(r10, r14);
            if (r16 == null) goto L8;
            r12.sourceIntent = (String) r16;
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
        public final SystemUserSelectParams[] newArray(int r10) {
            return new SystemUserSelectParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserSelectParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserSelectParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemUserSelectParams() {
        String[] r10 = null;
        String r11 = null;
        String r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ SystemUserSelectParams copy$default(SystemUserSelectParams r10, String[] r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.candidate;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.type;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.sourceIntent;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public static /* synthetic */ void getSourceIntent$annotations() {
    }

    @Nullable
    public final String[] component1() {
        return this.candidate;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.sourceIntent;
    }

    @NotNull
    public final SystemUserSelectParams copy(@Nullable String[] r10, @Nullable String r11, @Nullable String r12) {
        return new SystemUserSelectParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemUserSelectParams) == true) goto L8;
        return false;
    L8:
        SystemUserSelectParams r11 = (SystemUserSelectParams) r10;
        if (q.b(this.candidate, r11.candidate) == true) goto L12;
        return false;
    L12:
        if (q.b(this.type, r11.type) == true) goto L15;
        return false;
    L15:
        if (q.b(this.sourceIntent, r11.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final String[] getCandidate() {
        return this.candidate;
    }

    @Nullable
    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String[] r10 = this.candidate;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.type;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.sourceIntent;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = Arrays.hashCode(r10);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.candidate != null) goto L5;
    L9:
        return false;
    L5:
        if (this.type == null) goto L9;
        if (this.sourceIntent == null) goto L9;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemUserSelectParams) == true) goto L5;
        return this;
    L5:
        String[] r11 = this.candidate;
        if (r11 != null) goto L8;
        r11 = ((SystemUserSelectParams) r10).candidate;
    L8:
        String r12 = this.type;
        if (r12 != null) goto L11;
        r12 = ((SystemUserSelectParams) r10).type;
    L11:
        String r13 = this.sourceIntent;
        if (r13 != null) goto L15;
        r13 = ((SystemUserSelectParams) r10).sourceIntent;
    L15:
        return new SystemUserSelectParams(r11, r12, r13);
    }

    public final void setCandidate(@Nullable String[] r10) {
        this.candidate = r10;
    }

    public final void setSourceIntent(@Nullable String r10) {
        this.sourceIntent = r10;
    }

    public final void setType(@Nullable String r10) {
        this.type = r10;
    }

    @NotNull
    public String toString() {
        return "SystemUserSelectParams(candidate=" + Arrays.toString(this.candidate) + ", type=" + this.type + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(1);
        q.g(r10, "out");
        r10.writeStringArray(this.candidate);
        r10.writeString(this.type);
        r10.writeValue(this.sourceIntent);
    }

    public SystemUserSelectParams(@Nullable String[] r10, @Nullable String r11, @Nullable String r12) {
        this.candidate = r10;
        this.type = r11;
        this.sourceIntent = r12;
    }

    public /* synthetic */ SystemUserSelectParams(String[] r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
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
