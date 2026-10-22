package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jh\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020.HÖ\u0001J\u0013\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020.HÖ\u0001J\b\u00103\u001a\u00020\u0004H\u0016J\u0012\u00104\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u000101H\u0016J\t\u00106\u001a\u00020\u0007HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020.HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "canInterruptCall", "", "option", "", "", "phoneNumber", "name", "firstSentence", "targetPhoneNumber", "ext", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanInterruptCall", "()Ljava/lang/Boolean;", "setCanInterruptCall", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getFirstSentence", "setFirstSentence", "getName", "setName", "getOption", "()[Ljava/lang/String;", "setOption", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getPhoneNumber", "setPhoneNumber", "getTargetPhoneNumber", "setTargetPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhoneProxyCallParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PhoneProxyCallParams> CREATOR = null;

    @Nullable
    private Boolean canInterruptCall;

    @Nullable
    private String ext;

    @Nullable
    private String firstSentence;

    @Nullable
    private String name;

    @Nullable
    private String[] option;

    @Nullable
    private String phoneNumber;

    @Nullable
    private String targetPhoneNumber;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneProxyCallParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneProxyCallParams createFromParcel(@NotNull Parcel r12) {
            int r11 = r12.readInt();
            q.g(r12, "parcel");
            int r10 = 1;
            if (r12.readInt() != 0) goto L7;
            Boolean r13 = null;
        L11:
            PhoneProxyCallParams r14 = new PhoneProxyCallParams(r13, r12.createStringArray(), r12.readString(), r12.readString(), r12.readString(), r12.readString(), r12.readString());
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
        L12:
            if (r10 > r15) goto L14;
            r10 = r10 + 1;
        L14:
            if (r10 > r11) goto L16;
            a.d(r12, r16);
            r10 = r10 + 1;
            goto L14
        L16:
            return r14;
        L7:
            if (r12.readInt() == 0) goto L9;
            boolean r17 = true;
        L10:
            r13 = Boolean.valueOf(r17);
            goto L11
        L9:
            r17 = false;
            goto L10
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneProxyCallParams[] newArray(int r10) {
            return new PhoneProxyCallParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneProxyCallParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneProxyCallParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PhoneProxyCallParams() {
        Boolean r10 = null;
        String[] r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        this(r10, r11, r12, r13, r14, r15, r16, 127, null);
    }

    public static /* synthetic */ PhoneProxyCallParams copy$default(PhoneProxyCallParams r10, Boolean r11, String[] r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.canInterruptCall;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.option;
    L8:
        String[] r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.phoneNumber;
    L11:
        String r20 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.name;
    L14:
        String r21 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.firstSentence;
    L17:
        String r22 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.targetPhoneNumber;
    L20:
        String r23 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.ext;
    L23:
        Boolean r24 = r11;
        return r10.copy(r24, r110, r20, r21, r22, r23, r17);
    }

    @Nullable
    public final Boolean component1() {
        return this.canInterruptCall;
    }

    @Nullable
    public final String[] component2() {
        return this.option;
    }

    @Nullable
    public final String component3() {
        return this.phoneNumber;
    }

    @Nullable
    public final String component4() {
        return this.name;
    }

    @Nullable
    public final String component5() {
        return this.firstSentence;
    }

    @Nullable
    public final String component6() {
        return this.targetPhoneNumber;
    }

    @Nullable
    public final String component7() {
        return this.ext;
    }

    @NotNull
    public final PhoneProxyCallParams copy(@Nullable Boolean r10, @Nullable String[] r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16) {
        return new PhoneProxyCallParams(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhoneProxyCallParams) == true) goto L8;
        return false;
    L8:
        PhoneProxyCallParams r11 = (PhoneProxyCallParams) r10;
        if (q.b(this.canInterruptCall, r11.canInterruptCall) == true) goto L12;
        return false;
    L12:
        if (q.b(this.option, r11.option) == true) goto L15;
        return false;
    L15:
        if (q.b(this.phoneNumber, r11.phoneNumber) == true) goto L18;
        return false;
    L18:
        if (q.b(this.name, r11.name) == true) goto L21;
        return false;
    L21:
        if (q.b(this.firstSentence, r11.firstSentence) == true) goto L24;
        return false;
    L24:
        if (q.b(this.targetPhoneNumber, r11.targetPhoneNumber) == true) goto L27;
        return false;
    L27:
        if (q.b(this.ext, r11.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Nullable
    public final Boolean getCanInterruptCall() {
        return this.canInterruptCall;
    }

    @Nullable
    public final String getExt() {
        return this.ext;
    }

    @Nullable
    public final String getFirstSentence() {
        return this.firstSentence;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String[] getOption() {
        return this.option;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTargetPhoneNumber() {
        return this.targetPhoneNumber;
    }

    public int hashCode() {
        Boolean r10 = this.canInterruptCall;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String[] r14 = this.option;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.phoneNumber;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.name;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.firstSentence;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.targetPhoneNumber;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.ext;
        if (r29 == null) goto L31;
        r11 = r29.hashCode();
    L31:
        return r28 + r11;
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
        r15 = Arrays.hashCode(r14);
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.option != null) goto L5;
    L7:
        return false;
    L5:
        if (this.phoneNumber == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PhoneProxyCallParams) == true) goto L5;
        return this;
    L5:
        Boolean r11 = this.canInterruptCall;
        if (r11 != null) goto L8;
        r11 = ((PhoneProxyCallParams) r10).canInterruptCall;
    L8:
        Boolean r12 = r11;
        String[] r13 = this.option;
        if (r13 != null) goto L11;
        r13 = ((PhoneProxyCallParams) r10).option;
    L11:
        String[] r14 = r13;
        String r15 = this.phoneNumber;
        if (r15 != null) goto L14;
        r15 = ((PhoneProxyCallParams) r10).phoneNumber;
    L14:
        String r16 = r15;
        String r17 = this.name;
        if (r17 != null) goto L17;
        r17 = ((PhoneProxyCallParams) r10).name;
    L17:
        String r18 = r17;
        String r19 = this.firstSentence;
        if (r19 != null) goto L20;
        r19 = ((PhoneProxyCallParams) r10).firstSentence;
    L20:
        String r20 = r19;
        String r21 = this.targetPhoneNumber;
        if (r21 != null) goto L23;
        r21 = ((PhoneProxyCallParams) r10).targetPhoneNumber;
    L23:
        String r22 = r21;
        String r23 = this.ext;
        if (r23 != null) goto L27;
        r23 = ((PhoneProxyCallParams) r10).ext;
    L27:
        return new PhoneProxyCallParams(r12, r14, r16, r18, r20, r22, r23);
    }

    public final void setCanInterruptCall(@Nullable Boolean r10) {
        this.canInterruptCall = r10;
    }

    public final void setExt(@Nullable String r10) {
        this.ext = r10;
    }

    public final void setFirstSentence(@Nullable String r10) {
        this.firstSentence = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setOption(@Nullable String[] r10) {
        this.option = r10;
    }

    public final void setPhoneNumber(@Nullable String r10) {
        this.phoneNumber = r10;
    }

    public final void setTargetPhoneNumber(@Nullable String r10) {
        this.targetPhoneNumber = r10;
    }

    @NotNull
    public String toString() {
        return "PhoneProxyCallParams(canInterruptCall=" + this.canInterruptCall + ", option=" + Arrays.toString(this.option) + ", phoneNumber=" + this.phoneNumber + ", name=" + this.name + ", firstSentence=" + this.firstSentence + ", targetPhoneNumber=" + this.targetPhoneNumber + ", ext=" + this.ext + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        ?? r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        Boolean r13 = this.canInterruptCall;
        if (r13 != null) goto L5;
    L4:
        r10.writeInt(r12);
        r10.writeStringArray(this.option);
        r10.writeString(this.phoneNumber);
        r10.writeString(this.name);
        r10.writeString(this.firstSentence);
        r10.writeString(this.targetPhoneNumber);
        r10.writeString(this.ext);
        return;
    L5:
        r10.writeInt(1);
        r12 = r13.booleanValue();
        goto L4
    }

    public PhoneProxyCallParams(@Nullable Boolean r10, @Nullable String[] r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16) {
        this.canInterruptCall = r10;
        this.option = r11;
        this.phoneNumber = r12;
        this.name = r13;
        this.firstSentence = r14;
        this.targetPhoneNumber = r15;
        this.ext = r16;
    }

    public /* synthetic */ PhoneProxyCallParams(Boolean r10, String[] r11, String r12, String r13, String r14, String r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r17 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r17 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r17 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r17 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r17 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r17 & 64) == 0) goto L23;
        r16 = null;
    L23:
        this(r10, r11, r12, r13, r14, r15, r16);
    }
}
