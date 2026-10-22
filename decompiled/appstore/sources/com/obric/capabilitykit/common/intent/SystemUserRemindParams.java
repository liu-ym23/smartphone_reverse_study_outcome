package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\u0012\u0010(\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010&H\u0016J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\"HÖ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u00060"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserRemindParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "options", "", "Lcom/obric/capabilitykit/common/intent/Options;", ServerElements.CONTENT, "", "title", "candidate", "([Lcom/obric/capabilitykit/common/intent/Options;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getCandidate", "()[Ljava/lang/String;", "setCandidate", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getOptions", "()[Lcom/obric/capabilitykit/common/intent/Options;", "setOptions", "([Lcom/obric/capabilitykit/common/intent/Options;)V", "[Lcom/obric/capabilitykit/common/intent/Options;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "([Lcom/obric/capabilitykit/common/intent/Options;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserRemindParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemUserRemindParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemUserRemindParams> CREATOR = null;

    @Nullable
    private String[] candidate;

    @Nullable
    private String content;

    @Nullable
    private Options[] options;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserRemindParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemUserRemindParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            if (r10.readInt() != 0) goto L5;
            Options[] r12 = null;
        L9:
            SystemUserRemindParams r13 = new SystemUserRemindParams(r12, r10.readString(), r10.readString(), r10.createStringArray());
            int r14 = Math.min(r11, 0);
            ClassLoader r15 = Creator.class.getClassLoader();
            int r16 = 1;
        L10:
            if (r16 > r14) goto L12;
            r16 = r16 + 1;
        L12:
            if (r16 > r11) goto L14;
            a.d(r10, r15);
            r16 = r16 + 1;
            goto L12
        L14:
            return r13;
        L5:
            int r17 = r10.readInt();
            Options[] r18 = new Options[r17];
            int r19 = 0;
        L6:
            if (r19 == r17) goto L8;
            r18[r19] = Options.CREATOR.createFromParcel(r10);
            r19 = r19 + 1;
            goto L6
        L8:
            r12 = r18;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemUserRemindParams[] newArray(int r10) {
            return new SystemUserRemindParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserRemindParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserRemindParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemUserRemindParams() {
        Options[] r10 = null;
        String r11 = null;
        String r12 = null;
        String[] r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    public static /* synthetic */ SystemUserRemindParams copy$default(SystemUserRemindParams r10, Options[] r11, String r12, String r13, String[] r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.options;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.content;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.title;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.candidate;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final Options[] component1() {
        return this.options;
    }

    @Nullable
    public final String component2() {
        return this.content;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final String[] component4() {
        return this.candidate;
    }

    @NotNull
    public final SystemUserRemindParams copy(@Nullable Options[] r10, @Nullable String r11, @Nullable String r12, @Nullable String[] r13) {
        return new SystemUserRemindParams(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemUserRemindParams) == true) goto L8;
        return false;
    L8:
        SystemUserRemindParams r11 = (SystemUserRemindParams) r10;
        if (q.b(this.options, r11.options) == true) goto L12;
        return false;
    L12:
        if (q.b(this.content, r11.content) == true) goto L15;
        return false;
    L15:
        if (q.b(this.title, r11.title) == true) goto L18;
        return false;
    L18:
        if (q.b(this.candidate, r11.candidate) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String[] getCandidate() {
        return this.candidate;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Options[] getOptions() {
        return this.options;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Options[] r10 = this.options;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.content;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.title;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String[] r20 = this.candidate;
        if (r20 == null) goto L19;
        r11 = Arrays.hashCode(r20);
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = Arrays.hashCode(r10);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemUserRemindParams) == true) goto L5;
        return this;
    L5:
        Options[] r11 = this.options;
        if (r11 != null) goto L8;
        r11 = ((SystemUserRemindParams) r10).options;
    L8:
        String r12 = this.content;
        if (r12 != null) goto L11;
        r12 = ((SystemUserRemindParams) r10).content;
    L11:
        String r13 = this.title;
        if (r13 != null) goto L14;
        r13 = ((SystemUserRemindParams) r10).title;
    L14:
        String[] r14 = this.candidate;
        if (r14 != null) goto L18;
        r14 = ((SystemUserRemindParams) r10).candidate;
    L18:
        return new SystemUserRemindParams(r11, r12, r13, r14);
    }

    public final void setCandidate(@Nullable String[] r10) {
        this.candidate = r10;
    }

    public final void setContent(@Nullable String r10) {
        this.content = r10;
    }

    public final void setOptions(@Nullable Options[] r10) {
        this.options = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @NotNull
    public String toString() {
        return "SystemUserRemindParams(options=" + Arrays.toString(this.options) + ", content=" + this.content + ", title=" + this.title + ", candidate=" + Arrays.toString(this.candidate) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        Options[] r13 = this.options;
        if (r13 != null) goto L5;
        r10.writeInt(0);
    L8:
        r10.writeString(this.content);
        r10.writeString(this.title);
        r10.writeStringArray(this.candidate);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r13.length;
        r10.writeInt(r14);
    L6:
        if (r12 == r14) goto L8;
        r13[r12].writeToParcel(r10, r11);
        r12 = r12 + 1;
        goto L6
    }

    public SystemUserRemindParams(@Nullable Options[] r10, @Nullable String r11, @Nullable String r12, @Nullable String[] r13) {
        this.options = r10;
        this.content = r11;
        this.title = r12;
        this.candidate = r13;
    }

    public /* synthetic */ SystemUserRemindParams(Options[] r10, String r11, String r12, String[] r13, int r14, DefaultConstructorMarker r15) {
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
