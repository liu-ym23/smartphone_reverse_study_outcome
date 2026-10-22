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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0019\u001a\u00020\u0013HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemOpenAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", "appletId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppletId$annotations", "()V", "getAppletId", "setAppletId", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemOpenAppParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemOpenAppParams> CREATOR = null;

    @Nullable
    private String appName;

    @AddField
    @Nullable
    String appletId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemOpenAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemOpenAppParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            SystemOpenAppParams r12 = new SystemOpenAppParams(r10.readString(), null, 2, 0 == true ? 1 : 0);
            int r13 = Math.min(r11, 1);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L9;
            if (r15 != 1) goto L8;
            Object r16 = a.c(r10, r14);
            if (r16 == null) goto L8;
            r12.appletId = (String) r16;
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
        public final SystemOpenAppParams[] newArray(int r10) {
            return new SystemOpenAppParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenAppParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenAppParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemOpenAppParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemOpenAppParams copy$default(SystemOpenAppParams r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.appName;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.appletId;
    L9:
        return r10.copy(r11, r12);
    }

    public static /* synthetic */ void getAppletId$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.appName;
    }

    @Nullable
    public final String component2() {
        return this.appletId;
    }

    @NotNull
    public final SystemOpenAppParams copy(@Nullable String r10, @Nullable String r11) {
        return new SystemOpenAppParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemOpenAppParams) == true) goto L8;
        return false;
    L8:
        SystemOpenAppParams r11 = (SystemOpenAppParams) r10;
        if (q.b(this.appName, r11.appName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.appletId, r11.appletId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getAppletId() {
        return this.appletId;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        String r10 = this.appName;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }

    public int hashCode() {
        String r10 = this.appName;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.appletId;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.appName == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemOpenAppParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.appName;
        if (r11 != null) goto L8;
        r11 = ((SystemOpenAppParams) r10).appName;
    L8:
        String r12 = this.appletId;
        if (r12 != null) goto L12;
        r12 = ((SystemOpenAppParams) r10).appletId;
    L12:
        return new SystemOpenAppParams(r11, r12);
    }

    public final void setAppName(@Nullable String r10) {
        this.appName = r10;
    }

    public final void setAppletId(@Nullable String r10) {
        this.appletId = r10;
    }

    @NotNull
    public String toString() {
        return "SystemOpenAppParams(appName=" + this.appName + ", appletId=" + this.appletId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(1);
        q.g(r10, "out");
        r10.writeString(this.appName);
        r10.writeValue(this.appletId);
    }

    public SystemOpenAppParams(@Nullable String r10, @Nullable String r11) {
        this.appName = r10;
        this.appletId = r11;
    }

    public /* synthetic */ SystemOpenAppParams(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
