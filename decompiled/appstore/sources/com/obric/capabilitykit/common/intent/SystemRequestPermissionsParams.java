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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\u0012\u0010)\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010'H\u0016J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemRequestPermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "title", "", ServerElements.CONTENT, "options", "", "Lcom/obric/capabilitykit/common/intent/Options;", "permissions", "Lcom/obric/capabilitykit/common/intent/Permission;", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Options;[Lcom/obric/capabilitykit/common/intent/Permission;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getOptions", "()[Lcom/obric/capabilitykit/common/intent/Options;", "setOptions", "([Lcom/obric/capabilitykit/common/intent/Options;)V", "[Lcom/obric/capabilitykit/common/intent/Options;", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "[Lcom/obric/capabilitykit/common/intent/Permission;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Options;[Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemRequestPermissionsParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemRequestPermissionsParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemRequestPermissionsParams> CREATOR = null;

    @Nullable
    private String content;

    @Nullable
    private Options[] options;

    @Nullable
    private Permission[] permissions;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemRequestPermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemRequestPermissionsParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            String r13 = r10.readString();
            Permission[] r14 = null;
            if (r10.readInt() != 0) goto L5;
            Options[] r15 = null;
        L9:
            if (r10.readInt() == 0) goto L14;
            int r16 = r10.readInt();
            r14 = new Permission[r16];
            int r17 = 0;
        L12:
            if (r17 == r16) goto L14;
            r14[r17] = Permission.CREATOR.createFromParcel(r10);
            r17 = r17 + 1;
        L14:
            SystemRequestPermissionsParams r18 = new SystemRequestPermissionsParams(r12, r13, r15, r14);
            int r19 = Math.min(r11, 0);
            ClassLoader r20 = Creator.class.getClassLoader();
            int r21 = 1;
        L15:
            if (r21 > r19) goto L17;
            r21 = r21 + 1;
        L17:
            if (r21 > r11) goto L19;
            a.d(r10, r20);
            r21 = r21 + 1;
            goto L17
        L19:
            return r18;
        L5:
            int r22 = r10.readInt();
            r15 = new Options[r22];
            int r23 = 0;
        L6:
            if (r23 == r22) goto L9;
            r15[r23] = Options.CREATOR.createFromParcel(r10);
            r23 = r23 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemRequestPermissionsParams[] newArray(int r10) {
            return new SystemRequestPermissionsParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemRequestPermissionsParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemRequestPermissionsParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemRequestPermissionsParams() {
        String r10 = null;
        String r11 = null;
        Options[] r12 = null;
        Permission[] r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    public static /* synthetic */ SystemRequestPermissionsParams copy$default(SystemRequestPermissionsParams r10, String r11, String r12, Options[] r13, Permission[] r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.title;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.content;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.options;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.permissions;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.content;
    }

    @Nullable
    public final Options[] component3() {
        return this.options;
    }

    @Nullable
    public final Permission[] component4() {
        return this.permissions;
    }

    @NotNull
    public final SystemRequestPermissionsParams copy(@Nullable String r10, @Nullable String r11, @Nullable Options[] r12, @Nullable Permission[] r13) {
        return new SystemRequestPermissionsParams(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemRequestPermissionsParams) == true) goto L8;
        return false;
    L8:
        SystemRequestPermissionsParams r11 = (SystemRequestPermissionsParams) r10;
        if (q.b(this.title, r11.title) == true) goto L12;
        return false;
    L12:
        if (q.b(this.content, r11.content) == true) goto L15;
        return false;
    L15:
        if (q.b(this.options, r11.options) == true) goto L18;
        return false;
    L18:
        if (q.b(this.permissions, r11.permissions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Options[] getOptions() {
        return this.options;
    }

    @Nullable
    public final Permission[] getPermissions() {
        return this.permissions;
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
        String r10 = this.title;
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
        Options[] r17 = this.options;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Permission[] r20 = this.permissions;
        if (r20 == null) goto L19;
        r11 = Arrays.hashCode(r20);
    L19:
        return r19 + r11;
    L13:
        r18 = Arrays.hashCode(r17);
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
        if ((r10 instanceof SystemRequestPermissionsParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.title;
        if (r11 != null) goto L8;
        r11 = ((SystemRequestPermissionsParams) r10).title;
    L8:
        String r12 = this.content;
        if (r12 != null) goto L11;
        r12 = ((SystemRequestPermissionsParams) r10).content;
    L11:
        Options[] r13 = this.options;
        if (r13 != null) goto L14;
        r13 = ((SystemRequestPermissionsParams) r10).options;
    L14:
        Permission[] r14 = this.permissions;
        if (r14 != null) goto L18;
        r14 = ((SystemRequestPermissionsParams) r10).permissions;
    L18:
        return new SystemRequestPermissionsParams(r11, r12, r13, r14);
    }

    public final void setContent(@Nullable String r10) {
        this.content = r10;
    }

    public final void setOptions(@Nullable Options[] r10) {
        this.options = r10;
    }

    public final void setPermissions(@Nullable Permission[] r10) {
        this.permissions = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @NotNull
    public String toString() {
        return "SystemRequestPermissionsParams(title=" + this.title + ", content=" + this.content + ", options=" + Arrays.toString(this.options) + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.title);
        r10.writeString(this.content);
        Options[] r13 = this.options;
        if (r13 != null) goto L5;
        r10.writeInt(0);
    L8:
        Permission[] r14 = this.permissions;
        if (r14 != null) goto L11;
        r10.writeInt(0);
        return;
    L11:
        r10.writeInt(1);
        int r15 = r14.length;
        r10.writeInt(r15);
    L12:
        if (r12 == r15) goto L17;
        r14[r12].writeToParcel(r10, r11);
        r12 = r12 + 1;
        goto L12
    L17:
        return;
    L5:
        r10.writeInt(1);
        int r16 = r13.length;
        r10.writeInt(r16);
        int r17 = 0;
    L6:
        if (r17 == r16) goto L8;
        r13[r17].writeToParcel(r10, r11);
        r17 = r17 + 1;
        goto L6
    }

    public SystemRequestPermissionsParams(@Nullable String r10, @Nullable String r11, @Nullable Options[] r12, @Nullable Permission[] r13) {
        this.title = r10;
        this.content = r11;
        this.options = r12;
        this.permissions = r13;
    }

    public /* synthetic */ SystemRequestPermissionsParams(String r10, String r11, Options[] r12, Permission[] r13, int r14, DefaultConstructorMarker r15) {
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
