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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJJ\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\nHÖ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\b\u0010.\u001a\u00020\u0006H\u0016J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010,H\u0016J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nHÖ\u0001R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R(\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001e\u0012\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "needScreenshot", "", "chatHistory", "targets", "subIntent", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChatHistory$annotations", "()V", "getChatHistory", "()Ljava/lang/String;", "setChatHistory", "(Ljava/lang/String;)V", "getNeedScreenshot", "()Ljava/lang/Boolean;", "setNeedScreenshot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuery", "setQuery", "getSubIntent$annotations", "getSubIntent", "()Ljava/lang/Integer;", "setSubIntent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTargets$annotations", "getTargets", "setTargets", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class MemoryProduceParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<MemoryProduceParams> CREATOR = null;

    @AddField
    @Nullable
    String chatHistory;

    @Nullable
    private Boolean needScreenshot;

    @Nullable
    private String query;

    @AddField
    @Nullable
    Integer subIntent;

    @AddField
    @Nullable
    String targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MemoryProduceParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MemoryProduceParams createFromParcel(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            String r12 = r11.readString();
            if (r11.readInt() != 0) goto L7;
            Boolean r13 = null;
        L11:
            MemoryProduceParams r14 = new MemoryProduceParams(r12, r13, null, null, null, 28, null);
            int r15 = Math.min(r10, 3);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L12:
            if (r17 > r15) goto L27;
            if (r17 != 1) goto L18;
            Object r18 = a.c(r11, r16);
            if (r18 == null) goto L26;
            r14.chatHistory = (String) r18;
        L26:
            r17 = r17 + 1;
            goto L12
        L18:
            if (r17 != 2) goto L22;
            Object r19 = a.c(r11, r16);
            if (r19 == null) goto L26;
            r14.targets = (String) r19;
            goto L26
        L22:
            if (r17 != 3) goto L26;
            Object r20 = a.c(r11, r16);
            if (r20 == null) goto L26;
            r14.subIntent = (Integer) r20;
        L27:
            if (r17 > r10) goto L29;
            a.d(r11, r16);
            r17 = r17 + 1;
            goto L27
        L29:
            return r14;
        L7:
            if (r11.readInt() == 0) goto L9;
            boolean r21 = true;
        L10:
            r13 = Boolean.valueOf(r21);
            goto L11
        L9:
            r21 = false;
            goto L10
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MemoryProduceParams[] newArray(int r10) {
            return new MemoryProduceParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryProduceParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryProduceParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public MemoryProduceParams() {
        String r10 = null;
        Boolean r11 = null;
        String r12 = null;
        String r13 = null;
        Integer r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ MemoryProduceParams copy$default(MemoryProduceParams r10, String r11, Boolean r12, String r13, String r14, Integer r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.query;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.needScreenshot;
    L8:
        Boolean r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.chatHistory;
    L11:
        String r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.targets;
    L14:
        String r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.subIntent;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public static /* synthetic */ void getChatHistory$annotations() {
    }

    public static /* synthetic */ void getSubIntent$annotations() {
    }

    public static /* synthetic */ void getTargets$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.query;
    }

    @Nullable
    public final Boolean component2() {
        return this.needScreenshot;
    }

    @Nullable
    public final String component3() {
        return this.chatHistory;
    }

    @Nullable
    public final String component4() {
        return this.targets;
    }

    @Nullable
    public final Integer component5() {
        return this.subIntent;
    }

    @NotNull
    public final MemoryProduceParams copy(@Nullable String r10, @Nullable Boolean r11, @Nullable String r12, @Nullable String r13, @Nullable Integer r14) {
        return new MemoryProduceParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MemoryProduceParams) == true) goto L8;
        return false;
    L8:
        MemoryProduceParams r11 = (MemoryProduceParams) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.needScreenshot, r11.needScreenshot) == true) goto L15;
        return false;
    L15:
        if (q.b(this.chatHistory, r11.chatHistory) == true) goto L18;
        return false;
    L18:
        if (q.b(this.targets, r11.targets) == true) goto L21;
        return false;
    L21:
        if (q.b(this.subIntent, r11.subIntent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final String getChatHistory() {
        return this.chatHistory;
    }

    @Nullable
    public final Boolean getNeedScreenshot() {
        return this.needScreenshot;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Integer getSubIntent() {
        return this.subIntent;
    }

    @Nullable
    public final String getTargets() {
        return this.targets;
    }

    public int hashCode() {
        String r10 = this.query;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.needScreenshot;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.chatHistory;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.targets;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.subIntent;
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
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof MemoryProduceParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.query;
        if (r11 != null) goto L8;
        r11 = ((MemoryProduceParams) r10).query;
    L8:
        String r12 = r11;
        Boolean r13 = this.needScreenshot;
        if (r13 != null) goto L11;
        r13 = ((MemoryProduceParams) r10).needScreenshot;
    L11:
        Boolean r14 = r13;
        String r15 = this.chatHistory;
        if (r15 != null) goto L14;
        r15 = ((MemoryProduceParams) r10).chatHistory;
    L14:
        String r16 = r15;
        String r17 = this.targets;
        if (r17 != null) goto L17;
        r17 = ((MemoryProduceParams) r10).targets;
    L17:
        String r18 = r17;
        Integer r19 = this.subIntent;
        if (r19 != null) goto L21;
        r19 = ((MemoryProduceParams) r10).subIntent;
    L21:
        return new MemoryProduceParams(r12, r14, r16, r18, r19);
    }

    public final void setChatHistory(@Nullable String r10) {
        this.chatHistory = r10;
    }

    public final void setNeedScreenshot(@Nullable Boolean r10) {
        this.needScreenshot = r10;
    }

    public final void setQuery(@Nullable String r10) {
        this.query = r10;
    }

    public final void setSubIntent(@Nullable Integer r10) {
        this.subIntent = r10;
    }

    public final void setTargets(@Nullable String r10) {
        this.targets = r10;
    }

    @NotNull
    public String toString() {
        return "MemoryProduceParams(query=" + this.query + ", needScreenshot=" + this.needScreenshot + ", chatHistory=" + this.chatHistory + ", targets=" + this.targets + ", subIntent=" + this.subIntent + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(3);
        q.g(r10, "out");
        r10.writeString(this.query);
        Boolean r12 = this.needScreenshot;
        if (r12 != null) goto L6;
        ?? r13 = 0;
    L5:
        r10.writeInt(r13);
        r10.writeValue(this.chatHistory);
        r10.writeValue(this.targets);
        r10.writeValue(this.subIntent);
        return;
    L6:
        r10.writeInt(1);
        r13 = r12.booleanValue();
        goto L5
    }

    public MemoryProduceParams(@Nullable String r10, @Nullable Boolean r11, @Nullable String r12, @Nullable String r13, @Nullable Integer r14) {
        this.query = r10;
        this.needScreenshot = r11;
        this.chatHistory = r12;
        this.targets = r13;
        this.subIntent = r14;
    }

    public /* synthetic */ MemoryProduceParams(String r10, Boolean r11, String r12, String r13, Integer r14, int r15, DefaultConstructorMarker r16) {
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
