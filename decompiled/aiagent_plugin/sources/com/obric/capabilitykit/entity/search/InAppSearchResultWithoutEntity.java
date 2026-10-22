package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppSearchResultWithoutEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private final List<InAppSearchSimpleData> entities;
    private Map<String, ? extends Object> extraData;
    private transient int remoteClientVersion;

    public static final class CREATOR implements Parcelable.Creator<InAppSearchResultWithoutEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResultWithoutEntity createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
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
    public InAppSearchResultWithoutEntity(Parcel r10) {
        o.e(r10, "parcel");
        List r0 = r10.createTypedArrayList(InAppSearchSimpleData.CREATOR);
        if (r0 != null) goto L5;
        r0 = p.b();
    L5:
        this(r0, null, 2, 0 == true ? 1 : 0);
        int r1 = r10.dataPosition();
        String r2 = r10.readString();
        int r3 = 0;
        if (r2 != null) goto L8;
    L11:
        Object[] r5 = true;
    L12:
        if (r5 == false) goto L14;
        r10.setDataPosition(r1);
    L15:
        this.remoteClientVersion = r3;
        int r4 = Integer.parseInt(VERSION);
        if (r3 > r4) goto L19;
        r4 = r3;
    L19:
        ClassLoader r6 = InAppSearchResultWithoutEntity.class.getClassLoader();
        int r7 = 1;
    L20:
        if (r7 > r4) goto L28;
        if (r7 != 1) goto L27;
        Object r8 = r10.readValue(r6);
        if (ZeusTransformUtils.instanceOf(r8, Map.class) == false) goto L25;
        Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
    L26:
        this.extraData = r9;
        goto L27
    L25:
        r9 = null;
    L27:
        r7 = r7 + 1;
    L28:
        if (r7 > r3) goto L30;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r6);
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

    public InAppSearchResultWithoutEntity(List<InAppSearchSimpleData> r3, Map<String, ? extends Object> r4) {
        List<InAppSearchSimpleData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r5, "entities");
        this.entities = r5;
        this.extraData = r6;
    }

    public /* synthetic */ InAppSearchResultWithoutEntity(List r2, Map r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static /* synthetic */ InAppSearchResultWithoutEntity copy$default(InAppSearchResultWithoutEntity r1, List r2, Map r3, int r4, Object r5) {
        List<InAppSearchSimpleData> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.entities;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.extraData;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<InAppSearchSimpleData> component1() {
        return this.entities;
    }

    public final Map<String, Object> component2() {
        return this.extraData;
    }

    public final InAppSearchResultWithoutEntity copy(List<InAppSearchSimpleData> r2, Map<String, ? extends Object> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "entities");
        return new InAppSearchResultWithoutEntity(r1, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InAppSearchResultWithoutEntity.class) == true) goto L8;
        return false;
    L8:
        InAppSearchResultWithoutEntity r6 = (InAppSearchResultWithoutEntity) ZeusTransformUtils.preCheckCast(r5, InAppSearchResultWithoutEntity.class, "com.obric.aiagent.plugin");
        if (o.a(this.entities, r6.entities) == true) goto L12;
        return false;
    L12:
        if (o.a(this.extraData, r6.extraData) == true) goto L14;
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

    public final void setExtraData(Map<String, ? extends Object> r3) {
        this.extraData = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        return "InAppSearchResultWithoutEntity(entities=" + this.entities + ", extraData=" + this.extraData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeTypedList(this.entities);
        r1.writeString(VERSION);
        r1.writeValue(this.extraData);
    }
}
