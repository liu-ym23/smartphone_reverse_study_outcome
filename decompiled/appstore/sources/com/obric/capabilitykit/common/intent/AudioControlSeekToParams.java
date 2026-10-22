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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/AudioControlSeekToParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "valueType", "", "time", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getTime", "()Ljava/lang/Integer;", "setTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/AudioControlSeekToParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class AudioControlSeekToParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<AudioControlSeekToParams> CREATOR = null;

    @Nullable
    private Integer time;

    @Nullable
    private String valueType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AudioControlSeekToParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AudioControlSeekToParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r13 = null;
        L6:
            AudioControlSeekToParams r14 = new AudioControlSeekToParams(r12, r13);
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L7:
            if (r17 > r15) goto L9;
            r17 = r17 + 1;
        L9:
            if (r17 > r11) goto L11;
            a.d(r10, r16);
            r17 = r17 + 1;
            goto L9
        L11:
            return r14;
        L5:
            r13 = Integer.valueOf(r10.readInt());
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AudioControlSeekToParams[] newArray(int r10) {
            return new AudioControlSeekToParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AudioControlSeekToParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AudioControlSeekToParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioControlSeekToParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AudioControlSeekToParams copy$default(AudioControlSeekToParams r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.valueType;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.time;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.valueType;
    }

    @Nullable
    public final Integer component2() {
        return this.time;
    }

    @NotNull
    public final AudioControlSeekToParams copy(@Nullable String r10, @Nullable Integer r11) {
        return new AudioControlSeekToParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AudioControlSeekToParams) == true) goto L8;
        return false;
    L8:
        AudioControlSeekToParams r11 = (AudioControlSeekToParams) r10;
        if (q.b(this.valueType, r11.valueType) == true) goto L12;
        return false;
    L12:
        if (q.b(this.time, r11.time) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Integer getTime() {
        return this.time;
    }

    @Nullable
    public final String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        String r10 = this.valueType;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Integer r14 = this.time;
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
        if (this.valueType == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof AudioControlSeekToParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.valueType;
        if (r11 != null) goto L8;
        r11 = ((AudioControlSeekToParams) r10).valueType;
    L8:
        Integer r12 = this.time;
        if (r12 != null) goto L12;
        r12 = ((AudioControlSeekToParams) r10).time;
    L12:
        return new AudioControlSeekToParams(r11, r12);
    }

    public final void setTime(@Nullable Integer r10) {
        this.time = r10;
    }

    public final void setValueType(@Nullable String r10) {
        this.valueType = r10;
    }

    @NotNull
    public String toString() {
        return "AudioControlSeekToParams(valueType=" + this.valueType + ", time=" + this.time + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.valueType);
        Integer r12 = this.time;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.intValue());
    }

    public AudioControlSeekToParams(@Nullable String r10, @Nullable Integer r11) {
        this.valueType = r10;
        this.time = r11;
    }

    public /* synthetic */ AudioControlSeekToParams(String r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
