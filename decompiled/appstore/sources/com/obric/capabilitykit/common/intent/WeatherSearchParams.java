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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010!H\u0016J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/WeatherSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "location", "", "time", "startTime", "endTime", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getLocation", "setLocation", "getStartTime", "setStartTime", "getTime", "setTime", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class WeatherSearchParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<WeatherSearchParams> CREATOR = null;

    @Nullable
    private String endTime;

    @Nullable
    private String location;

    @Nullable
    private String startTime;

    @Nullable
    private String time;

    @Nullable
    private String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WeatherSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WeatherSearchParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            WeatherSearchParams r12 = new WeatherSearchParams(r10.readString(), r10.readString(), r10.readString(), r10.readString(), r10.readString());
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
        public final WeatherSearchParams[] newArray(int r10) {
            return new WeatherSearchParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WeatherSearchParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WeatherSearchParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public WeatherSearchParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ WeatherSearchParams copy$default(WeatherSearchParams r10, String r11, String r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.location;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.time;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.startTime;
    L11:
        String r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.endTime;
    L14:
        String r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.type;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @Nullable
    public final String component1() {
        return this.location;
    }

    @Nullable
    public final String component2() {
        return this.time;
    }

    @Nullable
    public final String component3() {
        return this.startTime;
    }

    @Nullable
    public final String component4() {
        return this.endTime;
    }

    @Nullable
    public final String component5() {
        return this.type;
    }

    @NotNull
    public final WeatherSearchParams copy(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14) {
        return new WeatherSearchParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WeatherSearchParams) == true) goto L8;
        return false;
    L8:
        WeatherSearchParams r11 = (WeatherSearchParams) r10;
        if (q.b(this.location, r11.location) == true) goto L12;
        return false;
    L12:
        if (q.b(this.time, r11.time) == true) goto L15;
        return false;
    L15:
        if (q.b(this.startTime, r11.startTime) == true) goto L18;
        return false;
    L18:
        if (q.b(this.endTime, r11.endTime) == true) goto L21;
        return false;
    L21:
        if (q.b(this.type, r11.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String r10 = this.location;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.time;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.startTime;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.endTime;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.type;
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof WeatherSearchParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.location;
        if (r11 != null) goto L8;
        r11 = ((WeatherSearchParams) r10).location;
    L8:
        String r12 = r11;
        String r13 = this.time;
        if (r13 != null) goto L11;
        r13 = ((WeatherSearchParams) r10).time;
    L11:
        String r14 = r13;
        String r15 = this.startTime;
        if (r15 != null) goto L14;
        r15 = ((WeatherSearchParams) r10).startTime;
    L14:
        String r16 = r15;
        String r17 = this.endTime;
        if (r17 != null) goto L17;
        r17 = ((WeatherSearchParams) r10).endTime;
    L17:
        String r18 = r17;
        String r19 = this.type;
        if (r19 != null) goto L21;
        r19 = ((WeatherSearchParams) r10).type;
    L21:
        return new WeatherSearchParams(r12, r14, r16, r18, r19);
    }

    public final void setEndTime(@Nullable String r10) {
        this.endTime = r10;
    }

    public final void setLocation(@Nullable String r10) {
        this.location = r10;
    }

    public final void setStartTime(@Nullable String r10) {
        this.startTime = r10;
    }

    public final void setTime(@Nullable String r10) {
        this.time = r10;
    }

    public final void setType(@Nullable String r10) {
        this.type = r10;
    }

    @NotNull
    public String toString() {
        return "WeatherSearchParams(location=" + this.location + ", time=" + this.time + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.location);
        r10.writeString(this.time);
        r10.writeString(this.startTime);
        r10.writeString(this.endTime);
        r10.writeString(this.type);
    }

    public WeatherSearchParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14) {
        this.location = r10;
        this.time = r11;
        this.startTime = r12;
        this.endTime = r13;
        this.type = r14;
    }

    public /* synthetic */ WeatherSearchParams(String r10, String r11, String r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
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
