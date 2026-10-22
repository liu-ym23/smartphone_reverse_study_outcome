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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "destName", "", "departName", "transportMode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getTransportMode", "()Ljava/lang/Integer;", "setTransportMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class MapNaviRouteParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<MapNaviRouteParams> CREATOR = null;

    @Nullable
    private String departName;

    @Nullable
    private String destName;

    @Nullable
    private Integer transportMode;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MapNaviRouteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapNaviRouteParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            String r13 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r14 = null;
        L6:
            MapNaviRouteParams r15 = new MapNaviRouteParams(r12, r13, r14);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
            int r18 = 1;
        L7:
            if (r18 > r16) goto L9;
            r18 = r18 + 1;
        L9:
            if (r18 > r11) goto L11;
            a.d(r10, r17);
            r18 = r18 + 1;
            goto L9
        L11:
            return r15;
        L5:
            r14 = Integer.valueOf(r10.readInt());
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapNaviRouteParams[] newArray(int r10) {
            return new MapNaviRouteParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapNaviRouteParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapNaviRouteParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public MapNaviRouteParams() {
        String r10 = null;
        String r11 = null;
        Integer r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ MapNaviRouteParams copy$default(MapNaviRouteParams r10, String r11, String r12, Integer r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.destName;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.departName;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.transportMode;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final String component1() {
        return this.destName;
    }

    @Nullable
    public final String component2() {
        return this.departName;
    }

    @Nullable
    public final Integer component3() {
        return this.transportMode;
    }

    @NotNull
    public final MapNaviRouteParams copy(@Nullable String r10, @Nullable String r11, @Nullable Integer r12) {
        return new MapNaviRouteParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MapNaviRouteParams) == true) goto L8;
        return false;
    L8:
        MapNaviRouteParams r11 = (MapNaviRouteParams) r10;
        if (q.b(this.destName, r11.destName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.departName, r11.departName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.transportMode, r11.transportMode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final String getDepartName() {
        return this.departName;
    }

    @Nullable
    public final String getDestName() {
        return this.destName;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Integer getTransportMode() {
        return this.transportMode;
    }

    public int hashCode() {
        String r10 = this.destName;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.departName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.transportMode;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
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
        if ((r10 instanceof MapNaviRouteParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.destName;
        if (r11 != null) goto L8;
        r11 = ((MapNaviRouteParams) r10).destName;
    L8:
        String r12 = this.departName;
        if (r12 != null) goto L11;
        r12 = ((MapNaviRouteParams) r10).departName;
    L11:
        Integer r13 = this.transportMode;
        if (r13 != null) goto L15;
        r13 = ((MapNaviRouteParams) r10).transportMode;
    L15:
        return new MapNaviRouteParams(r11, r12, r13);
    }

    public final void setDepartName(@Nullable String r10) {
        this.departName = r10;
    }

    public final void setDestName(@Nullable String r10) {
        this.destName = r10;
    }

    public final void setTransportMode(@Nullable Integer r10) {
        this.transportMode = r10;
    }

    @NotNull
    public String toString() {
        return "MapNaviRouteParams(destName=" + this.destName + ", departName=" + this.departName + ", transportMode=" + this.transportMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.destName);
        r10.writeString(this.departName);
        Integer r12 = this.transportMode;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.intValue());
    }

    public MapNaviRouteParams(@Nullable String r10, @Nullable String r11, @Nullable Integer r12) {
        this.destName = r10;
        this.departName = r11;
        this.transportMode = r12;
    }

    public /* synthetic */ MapNaviRouteParams(String r10, String r11, Integer r12, int r13, DefaultConstructorMarker r14) {
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
