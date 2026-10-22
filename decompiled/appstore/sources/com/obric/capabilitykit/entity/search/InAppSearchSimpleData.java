package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "lastModifiedTime", "type", "", "params", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Ljava/lang/String;JJILjava/util/List;)V", "getCreateTime", "()J", "getId", "()Ljava/lang/String;", "getLastModifiedTime", "getParams", "()Ljava/util/List;", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchSimpleData implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;

    @NotNull
    private static final String VERSION = "0";
    private final long createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f11367id;
    private final long lastModifiedTime;

    @NotNull
    private final List<InAppSearchEntityParam> params;
    private final int type;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchSimpleData> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchSimpleData createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new InAppSearchSimpleData(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchSimpleData[] newArray(int r10) {
            return new InAppSearchSimpleData[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchSimpleData createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchSimpleData[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchSimpleData(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        String r11 = EntityExtKt.f(r10);
        long r12 = r10.readLong();
        long r13 = r10.readLong();
        int r14 = r10.readInt();
        ArrayList r15 = r10.createTypedArrayList(InAppSearchEntityParam.CREATOR);
        q.d(r15);
        this(r11, r12, r13, r14, r15);
        int r16 = r10.dataPosition();
        String r17 = r10.readString();
        if (r17 != null) goto L5;
    L8:
        r10.setDataPosition(r16);
        int r18 = 0;
    L9:
        int r19 = Integer.parseInt("0");
        if (r18 > r19) goto L13;
        r19 = r18;
    L13:
        ClassLoader r20 = InAppSearchSimpleData.class.getClassLoader();
        int r21 = 1;
    L14:
        if (r21 > r19) goto L16;
        r21 = r21 + 1;
    L16:
        if (r21 > r18) goto L18;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r20);
        r21 = r21 + 1;
        goto L16
    L18:
        return;
    L5:
        if (r17.length() == 0) goto L8;
        r18 = Integer.parseInt(r17);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppSearchSimpleData copy$default(InAppSearchSimpleData r10, String r11, long r12, long r13, int r14, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.f11367id;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.createTime;
    L8:
        long r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.lastModifiedTime;
    L11:
        long r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.type;
    L14:
        int r110 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.params;
    L17:
        String r20 = r11;
        return r10.copy(r20, r18, r19, r110, r15);
    }

    @NotNull
    public final String component1() {
        return this.f11367id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.lastModifiedTime;
    }

    public final int component4() {
        return this.type;
    }

    @NotNull
    public final List<InAppSearchEntityParam> component5() {
        return this.params;
    }

    @NotNull
    public final InAppSearchSimpleData copy(@NotNull String r10, long r11, long r12, int r14, @NotNull List<InAppSearchEntityParam> r15) {
        q.g(r10, "id");
        q.g(r15, "params");
        return new InAppSearchSimpleData(r10, r11, r12, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof InAppSearchSimpleData) == true) goto L8;
        return false;
    L8:
        InAppSearchSimpleData r11 = (InAppSearchSimpleData) r10;
        if (q.b(this.f11367id, r11.f11367id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r11.createTime) goto L15;
        return false;
    L15:
        if (this.lastModifiedTime == r11.lastModifiedTime) goto L18;
        return false;
    L18:
        if (this.type == r11.type) goto L21;
        return false;
    L21:
        if (q.b(this.params, r11.params) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getId() {
        return this.f11367id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    @NotNull
    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.f11367id.hashCode() * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.lastModifiedTime)) * 31) + Integer.hashCode(this.type)) * 31) + this.params.hashCode();
    }

    @NotNull
    public String toString() {
        return "InAppSearchSimpleData(id=" + this.f11367id + ", createTime=" + this.createTime + ", lastModifiedTime=" + this.lastModifiedTime + ", type=" + this.type + ", params=" + this.params + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.f11367id);
        r10.writeLong(this.createTime);
        r10.writeLong(this.lastModifiedTime);
        r10.writeInt(this.type);
        r10.writeTypedList(this.params);
        r10.writeString("0");
    }

    public InAppSearchSimpleData(@NotNull String r10, long r11, long r12, int r13, @NotNull List<InAppSearchEntityParam> r14) {
        q.g(r10, "id");
        q.g(r14, "params");
        this.f11367id = r10;
        this.createTime = r11;
        this.lastModifiedTime = r12;
        this.type = r13;
        this.params = r14;
    }
}
