package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0001J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0014HÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0014H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "entities", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "extraData", "", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getEntities", "()Ljava/util/List;", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "<set-?>", "", "remoteClientVersion", "getRemoteClientVersion", "()I", "component1", "component2", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchResultWithoutEntity implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;

    @NotNull
    private static final String VERSION = "1";

    @NotNull
    private final List<InAppSearchSimpleData> entities;

    @Nullable
    private Map<String, ? extends Object> extraData;
    private transient int remoteClientVersion;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchResultWithoutEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchResultWithoutEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new InAppSearchResultWithoutEntity(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchResultWithoutEntity[] newArray(int r10) {
            return new InAppSearchResultWithoutEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResultWithoutEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResultWithoutEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InAppSearchResultWithoutEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        List r11 = r10.createTypedArrayList(InAppSearchSimpleData.CREATOR);
        if (r11 != null) goto L5;
        r11 = t.i();
    L5:
        this(r11, null, 2, 0 == true ? 1 : 0);
        int r12 = r10.dataPosition();
        String r13 = r10.readString();
        if (r13 != null) goto L8;
    L11:
        r10.setDataPosition(r12);
        int r14 = 0;
    L12:
        this.remoteClientVersion = r14;
        int r15 = Integer.parseInt("1");
        if (r14 > r15) goto L16;
        r15 = r14;
    L16:
        ClassLoader r16 = InAppSearchResultWithoutEntity.class.getClassLoader();
        int r17 = 1;
    L17:
        if (r17 > r15) goto L25;
        if (r17 != 1) goto L24;
        Object r18 = r10.readValue(r16);
        if ((r18 instanceof Map) == false) goto L22;
        Map<String, ? extends Object> r19 = (Map) r18;
    L23:
        this.extraData = r19;
        goto L24
    L22:
        r19 = null;
    L24:
        r17 = r17 + 1;
    L25:
        if (r17 > r14) goto L27;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r16);
        r17 = r17 + 1;
        goto L25
    L27:
        return;
    L8:
        if (r13.length() == 0) goto L11;
        r14 = Integer.parseInt(r13);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppSearchResultWithoutEntity copy$default(InAppSearchResultWithoutEntity r10, List r11, Map r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.entities;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.extraData;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final List<InAppSearchSimpleData> component1() {
        return this.entities;
    }

    @Nullable
    public final Map<String, Object> component2() {
        return this.extraData;
    }

    @NotNull
    public final InAppSearchResultWithoutEntity copy(@NotNull List<InAppSearchSimpleData> r10, @Nullable Map<String, ? extends Object> r11) {
        q.g(r10, "entities");
        return new InAppSearchResultWithoutEntity(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof InAppSearchResultWithoutEntity) == true) goto L8;
        return false;
    L8:
        InAppSearchResultWithoutEntity r11 = (InAppSearchResultWithoutEntity) r10;
        if (q.b(this.entities, r11.entities) == true) goto L12;
        return false;
    L12:
        if (q.b(this.extraData, r11.extraData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final List<InAppSearchSimpleData> getEntities() {
        return this.entities;
    }

    @Nullable
    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final int getRemoteClientVersion() {
        return this.remoteClientVersion;
    }

    public int hashCode() {
        int r10 = this.entities.hashCode() * 31;
        Map<String, ? extends Object> r11 = this.extraData;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final void setExtraData(@Nullable Map<String, ? extends Object> r10) {
        this.extraData = r10;
    }

    @NotNull
    public String toString() {
        return "InAppSearchResultWithoutEntity(entities=" + this.entities + ", extraData=" + this.extraData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeTypedList(this.entities);
        r10.writeString("1");
        r10.writeValue(this.extraData);
    }

    public InAppSearchResultWithoutEntity(@NotNull List<InAppSearchSimpleData> r10, @Nullable Map<String, ? extends Object> r11) {
        q.g(r10, "entities");
        this.entities = r10;
        this.extraData = r11;
    }

    public /* synthetic */ InAppSearchResultWithoutEntity(List r10, Map r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }
}
