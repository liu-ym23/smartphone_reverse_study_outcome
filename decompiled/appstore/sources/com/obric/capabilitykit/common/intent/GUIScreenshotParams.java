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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/GUIScreenshotParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "type", "", "uniqueId", "ext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getType", "setType", "getUniqueId", "setUniqueId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class GUIScreenshotParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<GUIScreenshotParams> CREATOR = null;

    @Nullable
    private String ext;

    @Nullable
    private String type;

    @Nullable
    private String uniqueId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GUIScreenshotParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GUIScreenshotParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            GUIScreenshotParams r12 = new GUIScreenshotParams(r10.readString(), r10.readString(), r10.readString());
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
        public final GUIScreenshotParams[] newArray(int r10) {
            return new GUIScreenshotParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GUIScreenshotParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GUIScreenshotParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public GUIScreenshotParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ GUIScreenshotParams copy$default(GUIScreenshotParams r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.type;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.uniqueId;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.ext;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.uniqueId;
    }

    @Nullable
    public final String component3() {
        return this.ext;
    }

    @NotNull
    public final GUIScreenshotParams copy(@Nullable String r10, @Nullable String r11, @Nullable String r12) {
        return new GUIScreenshotParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GUIScreenshotParams) == true) goto L8;
        return false;
    L8:
        GUIScreenshotParams r11 = (GUIScreenshotParams) r10;
        if (q.b(this.type, r11.type) == true) goto L12;
        return false;
    L12:
        if (q.b(this.uniqueId, r11.uniqueId) == true) goto L15;
        return false;
    L15:
        if (q.b(this.ext, r11.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final String getExt() {
        return this.ext;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUniqueId() {
        return this.uniqueId;
    }

    public int hashCode() {
        String r10 = this.type;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.uniqueId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.ext;
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
        if (this.type == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof GUIScreenshotParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.type;
        if (r11 != null) goto L8;
        r11 = ((GUIScreenshotParams) r10).type;
    L8:
        String r12 = this.uniqueId;
        if (r12 != null) goto L11;
        r12 = ((GUIScreenshotParams) r10).uniqueId;
    L11:
        String r13 = this.ext;
        if (r13 != null) goto L15;
        r13 = ((GUIScreenshotParams) r10).ext;
    L15:
        return new GUIScreenshotParams(r11, r12, r13);
    }

    public final void setExt(@Nullable String r10) {
        this.ext = r10;
    }

    public final void setType(@Nullable String r10) {
        this.type = r10;
    }

    public final void setUniqueId(@Nullable String r10) {
        this.uniqueId = r10;
    }

    @NotNull
    public String toString() {
        return "GUIScreenshotParams(type=" + this.type + ", uniqueId=" + this.uniqueId + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.type);
        r10.writeString(this.uniqueId);
        r10.writeString(this.ext);
    }

    public GUIScreenshotParams(@Nullable String r10, @Nullable String r11, @Nullable String r12) {
        this.type = r10;
        this.uniqueId = r11;
        this.ext = r12;
    }

    public /* synthetic */ GUIScreenshotParams(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
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
