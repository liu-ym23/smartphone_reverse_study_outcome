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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017JJ\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\u0012\u0010-\u001a\u00020\u00012\b\u0010.\u001a\u0004\u0018\u00010+H\u0016J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R(\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", "isSystemApp", "", "proceed", "operateType", "", "updateRange", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setSystemApp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOperateType$annotations", "()V", "getOperateType", "()Ljava/lang/Integer;", "setOperateType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getProceed$annotations", "getProceed", "setProceed", "getUpdateRange$annotations", "getUpdateRange", "setUpdateRange", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemDownloadAppParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemDownloadAppParams> CREATOR = null;

    @Nullable
    private String appName;

    @Nullable
    private Boolean isSystemApp;

    @AddField
    @Nullable
    Integer operateType;

    @AddField
    @Nullable
    Boolean proceed;

    @AddField
    @Nullable
    Integer updateRange;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemDownloadAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemDownloadAppParams createFromParcel(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            String r12 = r11.readString();
            if (r11.readInt() != 0) goto L7;
            Boolean r13 = null;
        L11:
            SystemDownloadAppParams r14 = new SystemDownloadAppParams(r12, r13, null, null, null, 28, null);
            int r15 = Math.min(r10, 3);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L12:
            if (r17 > r15) goto L27;
            if (r17 != 1) goto L18;
            Object r18 = a.c(r11, r16);
            if (r18 == null) goto L26;
            r14.proceed = (Boolean) r18;
        L26:
            r17 = r17 + 1;
            goto L12
        L18:
            if (r17 != 2) goto L22;
            Object r19 = a.c(r11, r16);
            if (r19 == null) goto L26;
            r14.operateType = (Integer) r19;
            goto L26
        L22:
            if (r17 != 3) goto L26;
            Object r20 = a.c(r11, r16);
            if (r20 == null) goto L26;
            r14.updateRange = (Integer) r20;
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
        public final SystemDownloadAppParams[] newArray(int r10) {
            return new SystemDownloadAppParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemDownloadAppParams() {
        String r10 = null;
        Boolean r11 = null;
        Boolean r12 = null;
        Integer r13 = null;
        Integer r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ SystemDownloadAppParams copy$default(SystemDownloadAppParams r10, String r11, Boolean r12, Boolean r13, Integer r14, Integer r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.appName;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.isSystemApp;
    L8:
        Boolean r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.proceed;
    L11:
        Boolean r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.operateType;
    L14:
        Integer r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.updateRange;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public static /* synthetic */ void getOperateType$annotations() {
    }

    public static /* synthetic */ void getProceed$annotations() {
    }

    public static /* synthetic */ void getUpdateRange$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.appName;
    }

    @Nullable
    public final Boolean component2() {
        return this.isSystemApp;
    }

    @Nullable
    public final Boolean component3() {
        return this.proceed;
    }

    @Nullable
    public final Integer component4() {
        return this.operateType;
    }

    @Nullable
    public final Integer component5() {
        return this.updateRange;
    }

    @NotNull
    public final SystemDownloadAppParams copy(@Nullable String r10, @Nullable Boolean r11, @Nullable Boolean r12, @Nullable Integer r13, @Nullable Integer r14) {
        return new SystemDownloadAppParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemDownloadAppParams) == true) goto L8;
        return false;
    L8:
        SystemDownloadAppParams r11 = (SystemDownloadAppParams) r10;
        if (q.b(this.appName, r11.appName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.isSystemApp, r11.isSystemApp) == true) goto L15;
        return false;
    L15:
        if (q.b(this.proceed, r11.proceed) == true) goto L18;
        return false;
    L18:
        if (q.b(this.operateType, r11.operateType) == true) goto L21;
        return false;
    L21:
        if (q.b(this.updateRange, r11.updateRange) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final Integer getOperateType() {
        return this.operateType;
    }

    @Nullable
    public final Boolean getProceed() {
        return this.proceed;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Integer getUpdateRange() {
        return this.updateRange;
    }

    public int hashCode() {
        String r10 = this.appName;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.isSystemApp;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.proceed;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.operateType;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.updateRange;
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

    @Nullable
    public final Boolean isSystemApp() {
        return this.isSystemApp;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemDownloadAppParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.appName;
        if (r11 != null) goto L8;
        r11 = ((SystemDownloadAppParams) r10).appName;
    L8:
        String r12 = r11;
        Boolean r13 = this.isSystemApp;
        if (r13 != null) goto L11;
        r13 = ((SystemDownloadAppParams) r10).isSystemApp;
    L11:
        Boolean r14 = r13;
        Boolean r15 = this.proceed;
        if (r15 != null) goto L14;
        r15 = ((SystemDownloadAppParams) r10).proceed;
    L14:
        Boolean r16 = r15;
        Integer r17 = this.operateType;
        if (r17 != null) goto L17;
        r17 = ((SystemDownloadAppParams) r10).operateType;
    L17:
        Integer r18 = r17;
        Integer r19 = this.updateRange;
        if (r19 != null) goto L21;
        r19 = ((SystemDownloadAppParams) r10).updateRange;
    L21:
        return new SystemDownloadAppParams(r12, r14, r16, r18, r19);
    }

    public final void setAppName(@Nullable String r10) {
        this.appName = r10;
    }

    public final void setOperateType(@Nullable Integer r10) {
        this.operateType = r10;
    }

    public final void setProceed(@Nullable Boolean r10) {
        this.proceed = r10;
    }

    public final void setSystemApp(@Nullable Boolean r10) {
        this.isSystemApp = r10;
    }

    public final void setUpdateRange(@Nullable Integer r10) {
        this.updateRange = r10;
    }

    @NotNull
    public String toString() {
        return "SystemDownloadAppParams(appName=" + this.appName + ", isSystemApp=" + this.isSystemApp + ", proceed=" + this.proceed + ", operateType=" + this.operateType + ", updateRange=" + this.updateRange + ')';
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
        r10.writeString(this.appName);
        Boolean r12 = this.isSystemApp;
        if (r12 != null) goto L6;
        ?? r13 = 0;
    L5:
        r10.writeInt(r13);
        r10.writeValue(this.proceed);
        r10.writeValue(this.operateType);
        r10.writeValue(this.updateRange);
        return;
    L6:
        r10.writeInt(1);
        r13 = r12.booleanValue();
        goto L5
    }

    public SystemDownloadAppParams(@Nullable String r10, @Nullable Boolean r11, @Nullable Boolean r12, @Nullable Integer r13, @Nullable Integer r14) {
        this.appName = r10;
        this.isSystemApp = r11;
        this.proceed = r12;
        this.operateType = r13;
        this.updateRange = r14;
    }

    public /* synthetic */ SystemDownloadAppParams(String r10, Boolean r11, Boolean r12, Integer r13, Integer r14, int r15, DefaultConstructorMarker r16) {
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
