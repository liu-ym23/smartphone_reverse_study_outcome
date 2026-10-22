package com.bytedance.android.livesdkapi.enterparam;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u000bJ%\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003Jí\u0001\u0010\u0019\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\t\u0010$\u001a\u00020\u001bHÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001bHÖ\u0001J(\u0010+\u001a\u00020!*\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/enterparam/CommonEnterParamsData;", "Landroid/os/Parcelable;", "enterRoom", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mobParams", "params", "firstRoomParams", "firstRoomMobParams", "firstShowRoomParams", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getEnterRoom", "()Ljava/util/HashMap;", "getFirstRoomMobParams", "getFirstRoomParams", "getFirstShowRoomParams", "getMobParams", "getParams", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "getCommonParamsBundle", "Landroid/os/Bundle;", "getFirstRoomParamsBundle", "getFirstShowRoomParamsBundle", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "toBundle", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonEnterParamsData implements Parcelable {
    public static final Parcelable.Creator<CommonEnterParamsData> CREATOR = null;
    private final HashMap<String, String> enterRoom;
    private final HashMap<String, String> firstRoomMobParams;
    private final HashMap<String, String> firstRoomParams;
    private final HashMap<String, String> firstShowRoomParams;
    private final HashMap<String, String> mobParams;
    private final HashMap<String, String> params;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static class Creator implements Parcelable.Creator<CommonEnterParamsData> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonEnterParamsData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            int r100 = r110.readInt();
            HashMap r101 = new HashMap(r100);
        L3:
            if (r100 == 0) goto L5;
            r101.put(r110.readString(), r110.readString());
            r100 = r100 - 1;
            goto L3
        L5:
            int r102 = r110.readInt();
            HashMap r103 = new HashMap(r102);
        L6:
            if (r102 == 0) goto L8;
            r103.put(r110.readString(), r110.readString());
            r102 = r102 - 1;
            goto L6
        L8:
            int r104 = r110.readInt();
            HashMap r105 = new HashMap(r104);
        L9:
            if (r104 == 0) goto L11;
            r105.put(r110.readString(), r110.readString());
            r104 = r104 - 1;
            goto L9
        L11:
            int r106 = r110.readInt();
            HashMap r107 = new HashMap(r106);
        L12:
            if (r106 == 0) goto L14;
            r107.put(r110.readString(), r110.readString());
            r106 = r106 - 1;
            goto L12
        L14:
            int r108 = r110.readInt();
            HashMap r109 = new HashMap(r108);
        L15:
            if (r108 == 0) goto L17;
            r109.put(r110.readString(), r110.readString());
            r108 = r108 - 1;
            goto L15
        L17:
            int r111 = r110.readInt();
            HashMap r112 = new HashMap(r111);
        L18:
            if (r111 == 0) goto L21;
            r112.put(r110.readString(), r110.readString());
            r111 = r111 - 1;
            goto L18
        L21:
            return new CommonEnterParamsData(r101, r103, r105, r107, r109, r112);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonEnterParamsData[] newArray(int r100) {
            return new CommonEnterParamsData[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonEnterParamsData createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonEnterParamsData[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public CommonEnterParamsData() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonEnterParamsData copy$default(CommonEnterParamsData r100, HashMap r101, HashMap r102, HashMap r103, HashMap r104, HashMap r105, HashMap r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.enterRoom;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.mobParams;
    L8:
        HashMap r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.params;
    L11:
        HashMap r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.firstRoomParams;
    L14:
        HashMap r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.firstRoomMobParams;
    L17:
        HashMap r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.firstShowRoomParams;
    L20:
        HashMap r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final HashMap<String, String> component1() {
        return this.enterRoom;
    }

    public final HashMap<String, String> component2() {
        return this.mobParams;
    }

    public final HashMap<String, String> component3() {
        return this.params;
    }

    public final HashMap<String, String> component4() {
        return this.firstRoomParams;
    }

    public final HashMap<String, String> component5() {
        return this.firstRoomMobParams;
    }

    public final HashMap<String, String> component6() {
        return this.firstShowRoomParams;
    }

    public final CommonEnterParamsData copy(HashMap<String, String> r100, HashMap<String, String> r110, HashMap<String, String> r111, HashMap<String, String> r112, HashMap<String, String> r113, HashMap<String, String> r114) {
        Intrinsics.checkNotNullParameter(r100, "enterRoom");
        Intrinsics.checkNotNullParameter(r110, "mobParams");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "firstRoomParams");
        Intrinsics.checkNotNullParameter(r113, "firstRoomMobParams");
        Intrinsics.checkNotNullParameter(r114, "firstShowRoomParams");
        return new CommonEnterParamsData(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonEnterParamsData) == false) goto L18;
        CommonEnterParamsData r101 = (CommonEnterParamsData) r100;
        if (Intrinsics.areEqual(this.enterRoom, r101.enterRoom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mobParams, r101.mobParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.firstRoomParams, r101.firstRoomParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.firstRoomMobParams, r101.firstRoomMobParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.firstShowRoomParams, r101.firstShowRoomParams) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        HashMap<String, String> r100 = this.enterRoom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, String> r104 = this.mobParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, String> r107 = this.params;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, String> r110 = this.firstRoomParams;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        HashMap<String, String> r113 = this.firstRoomMobParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        HashMap<String, String> r116 = this.firstShowRoomParams;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CommonEnterParamsData(enterRoom=" + this.enterRoom + ", mobParams=" + this.mobParams + ", params=" + this.params + ", firstRoomParams=" + this.firstRoomParams + ", firstRoomMobParams=" + this.firstRoomMobParams + ", firstShowRoomParams=" + this.firstShowRoomParams + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        HashMap<String, String> r102 = this.enterRoom;
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L4
    L6:
        HashMap<String, String> r105 = this.mobParams;
        r100.writeInt(r105.size());
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        Map.Entry<String, String> r107 = r106.next();
        r100.writeString(r107.getKey());
        r100.writeString(r107.getValue());
        goto L8
    L10:
        HashMap<String, String> r108 = this.params;
        r100.writeInt(r108.size());
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
    L12:
        if (r109.hasNext() == false) goto L14;
        Map.Entry<String, String> r110 = r109.next();
        r100.writeString(r110.getKey());
        r100.writeString(r110.getValue());
        goto L12
    L14:
        HashMap<String, String> r111 = this.firstRoomParams;
        r100.writeInt(r111.size());
        Iterator<Map.Entry<String, String>> r112 = r111.entrySet().iterator();
    L16:
        if (r112.hasNext() == false) goto L18;
        Map.Entry<String, String> r113 = r112.next();
        r100.writeString(r113.getKey());
        r100.writeString(r113.getValue());
        goto L16
    L18:
        HashMap<String, String> r114 = this.firstRoomMobParams;
        r100.writeInt(r114.size());
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();
    L20:
        if (r115.hasNext() == false) goto L22;
        Map.Entry<String, String> r116 = r115.next();
        r100.writeString(r116.getKey());
        r100.writeString(r116.getValue());
        goto L20
    L22:
        HashMap<String, String> r117 = this.firstShowRoomParams;
        r100.writeInt(r117.size());
        Iterator<Map.Entry<String, String>> r118 = r117.entrySet().iterator();
    L24:
        if (r118.hasNext() == false) goto L26;
        Map.Entry<String, String> r119 = r118.next();
        r100.writeString(r119.getKey());
        r100.writeString(r119.getValue());
        goto L24
    }

    public final Bundle getCommonParamsBundle() {
        return toBundle(this.params);
    }

    public final Bundle getFirstRoomParamsBundle() {
        return toBundle(this.firstRoomParams);
    }

    public final Bundle getFirstShowRoomParamsBundle() {
        return toBundle(this.firstShowRoomParams);
    }

    public final HashMap<String, String> getEnterRoom() {
        return this.enterRoom;
    }

    public final HashMap<String, String> getFirstRoomMobParams() {
        return this.firstRoomMobParams;
    }

    public final HashMap<String, String> getFirstRoomParams() {
        return this.firstRoomParams;
    }

    public final HashMap<String, String> getFirstShowRoomParams() {
        return this.firstShowRoomParams;
    }

    public final HashMap<String, String> getMobParams() {
        return this.mobParams;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    private final Bundle toBundle(HashMap<String, String> r100) {
        Bundle r101 = new Bundle();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r101.putString(r103.getKey(), r103.getValue());
        goto L4
    L6:
        return r101;
    }

    public CommonEnterParamsData(HashMap<String, String> r100, HashMap<String, String> r101, HashMap<String, String> r102, HashMap<String, String> r103, HashMap<String, String> r104, HashMap<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "enterRoom");
        Intrinsics.checkNotNullParameter(r101, "mobParams");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "firstRoomParams");
        Intrinsics.checkNotNullParameter(r104, "firstRoomMobParams");
        Intrinsics.checkNotNullParameter(r105, "firstShowRoomParams");
        this.enterRoom = r100;
        this.mobParams = r101;
        this.params = r102;
        this.firstRoomParams = r103;
        this.firstRoomMobParams = r104;
        this.firstShowRoomParams = r105;
    }

    public /* synthetic */ CommonEnterParamsData(HashMap r100, HashMap r101, HashMap r102, HashMap r103, HashMap r104, HashMap r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = new HashMap();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = new HashMap();
    L8:
        HashMap r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = new HashMap();
    L11:
        HashMap r105 = r102;
        if ((r111 & 8) == 0) goto L14;
        r103 = new HashMap();
    L14:
        HashMap r106 = r103;
        if ((r111 & 16) == 0) goto L17;
        r104 = new HashMap();
    L17:
        HashMap r107 = r104;
        if ((r111 & 32) == 0) goto L20;
        r110 = new HashMap();
    L20:
        HashMap r108 = r100;
        this(r108, r113, r105, r106, r107, r110);
    }
}
