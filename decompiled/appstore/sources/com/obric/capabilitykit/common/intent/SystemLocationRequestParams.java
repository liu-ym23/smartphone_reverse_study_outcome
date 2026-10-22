package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemLocationRequestParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "needHighPrecision", "", "timeout", "", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getNeedHighPrecision", "()Ljava/lang/Boolean;", "setNeedHighPrecision", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTimeout", "()Ljava/lang/Long;", "setTimeout", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/SystemLocationRequestParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemLocationRequestParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemLocationRequestParams> CREATOR = null;

    @Nullable
    private Boolean needHighPrecision;

    @Nullable
    private Long timeout;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemLocationRequestParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemLocationRequestParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            Long r12 = null;
            int r13 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r14 = null;
        L11:
            if (r10.readInt() == 0) goto L14;
            r12 = Long.valueOf(r10.readLong());
        L14:
            SystemLocationRequestParams r15 = new SystemLocationRequestParams(r14, r12);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
        L15:
            if (r13 > r16) goto L17;
            r13 = r13 + 1;
        L17:
            if (r13 > r11) goto L19;
            a.d(r10, r17);
            r13 = r13 + 1;
            goto L17
        L19:
            return r15;
        L6:
            if (r10.readInt() == 0) goto L8;
            boolean r18 = true;
        L9:
            r14 = Boolean.valueOf(r18);
            goto L11
        L8:
            r18 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemLocationRequestParams[] newArray(int r10) {
            return new SystemLocationRequestParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemLocationRequestParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemLocationRequestParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemLocationRequestParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemLocationRequestParams copy$default(SystemLocationRequestParams r10, Boolean r11, Long r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.needHighPrecision;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.timeout;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final Boolean component1() {
        return this.needHighPrecision;
    }

    @Nullable
    public final Long component2() {
        return this.timeout;
    }

    @NotNull
    public final SystemLocationRequestParams copy(@Nullable Boolean r10, @Nullable Long r11) {
        return new SystemLocationRequestParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemLocationRequestParams) == true) goto L8;
        return false;
    L8:
        SystemLocationRequestParams r11 = (SystemLocationRequestParams) r10;
        if (q.b(this.needHighPrecision, r11.needHighPrecision) == true) goto L12;
        return false;
    L12:
        if (q.b(this.timeout, r11.timeout) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Boolean getNeedHighPrecision() {
        return this.needHighPrecision;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Long getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        Boolean r10 = this.needHighPrecision;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Long r14 = this.timeout;
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
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemLocationRequestParams) == true) goto L5;
        return this;
    L5:
        Boolean r11 = this.needHighPrecision;
        if (r11 != null) goto L8;
        r11 = ((SystemLocationRequestParams) r10).needHighPrecision;
    L8:
        Long r12 = this.timeout;
        if (r12 != null) goto L12;
        r12 = ((SystemLocationRequestParams) r10).timeout;
    L12:
        return new SystemLocationRequestParams(r11, r12);
    }

    public final void setNeedHighPrecision(@Nullable Boolean r10) {
        this.needHighPrecision = r10;
    }

    public final void setTimeout(@Nullable Long r10) {
        this.timeout = r10;
    }

    @NotNull
    public String toString() {
        return "SystemLocationRequestParams(needHighPrecision=" + this.needHighPrecision + ", timeout=" + this.timeout + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        Boolean r12 = this.needHighPrecision;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Long r13 = this.timeout;
        if (r13 != null) goto L9;
        r10.writeInt(0);
        return;
    L9:
        r10.writeInt(1);
        r10.writeLong(r13.longValue());
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.booleanValue() ? 1 : 0);
        goto L6
    }

    public SystemLocationRequestParams(@Nullable Boolean r10, @Nullable Long r11) {
        this.needHighPrecision = r10;
        this.timeout = r11;
    }

    public /* synthetic */ SystemLocationRequestParams(Boolean r10, Long r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
