package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0001J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0014HÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0014H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "entities", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "extraData", "", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getEntities", "()Ljava/util/List;", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "<set-?>", "", "remoteClientVersion", "getRemoteClientVersion", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchResultWithoutEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private final List<InAppSearchSimpleData> entities;
    private Map<String, ? extends Object> extraData;
    private transient int remoteClientVersion;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "()V", VCardConstants.PROPERTY_VERSION, "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchResultWithoutEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResultWithoutEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InAppSearchResultWithoutEntity(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResultWithoutEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResultWithoutEntity[] newArray(int r1) {
            return new InAppSearchResultWithoutEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResultWithoutEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InAppSearchResultWithoutEntity(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        List r0 = r9.createTypedArrayList(InAppSearchSimpleData.CREATOR);
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        this(r0, null, 2, 0 == true ? 1 : 0);
        int r1 = r9.dataPosition();
        String r2 = r9.readString();
        int r3 = 0;
        if (r2 != null) goto L8;
    L11:
        Object[] r5 = true;
    L12:
        if (r5 == false) goto L14;
        r9.setDataPosition(r1);
    L15:
        this.remoteClientVersion = r3;
        int r4 = Integer.parseInt("1");
        if (r3 > r4) goto L19;
        r4 = r3;
    L19:
        ClassLoader r6 = InAppSearchResultWithoutEntity.class.getClassLoader();
        int r7 = 1;
    L20:
        if (r7 > r4) goto L28;
        if (r7 != 1) goto L27;
        Object r8 = r9.readValue(r6);
        if ((r8 instanceof Map) == false) goto L25;
        Map<String, ? extends Object> r10 = (Map) r8;
    L26:
        this.extraData = r10;
        goto L27
    L25:
        r10 = null;
    L27:
        r7 = r7 + 1;
    L28:
        if (r7 > r3) goto L30;
        ParcelUtils.INSTANCE.skipValueSafely(r9, r6);
        r7 = r7 + 1;
        goto L28
    L30:
        return;
    L14:
        r3 = Integer.parseInt(r2);
        goto L15
    L8:
        if (r2.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    public InAppSearchResultWithoutEntity(List<InAppSearchSimpleData> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "entities");
        this.entities = r2;
        this.extraData = r3;
    }

    public /* synthetic */ InAppSearchResultWithoutEntity(List r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppSearchResultWithoutEntity copy$default(InAppSearchResultWithoutEntity r0, List r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.entities;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extraData;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<InAppSearchSimpleData> component1() {
        return this.entities;
    }

    public final Map<String, Object> component2() {
        return this.extraData;
    }

    public final InAppSearchResultWithoutEntity copy(List<InAppSearchSimpleData> r1, Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r1, "entities");
        return new InAppSearchResultWithoutEntity(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InAppSearchResultWithoutEntity) == true) goto L8;
        return false;
    L8:
        InAppSearchResultWithoutEntity r6 = (InAppSearchResultWithoutEntity) r5;
        if (Intrinsics.areEqual(this.entities, r6.entities) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraData, r6.extraData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<InAppSearchSimpleData> getEntities() {
        return this.entities;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final int getRemoteClientVersion() {
        return this.remoteClientVersion;
    }

    public int hashCode() {
        int r0 = this.entities.hashCode() * 31;
        Map<String, ? extends Object> r1 = this.extraData;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final void setExtraData(Map<String, ? extends Object> r1) {
        this.extraData = r1;
    }

    public String toString() {
        return "InAppSearchResultWithoutEntity(entities=" + this.entities + ", extraData=" + this.extraData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeTypedList(this.entities);
        r1.writeString("1");
        r1.writeValue(this.extraData);
    }
}
