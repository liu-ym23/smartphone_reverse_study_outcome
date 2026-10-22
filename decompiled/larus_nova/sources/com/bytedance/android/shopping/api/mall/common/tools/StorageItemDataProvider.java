package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class StorageItemDataProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f170415a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003JP\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$FrequencyRecordItem;", "", "plan_id", "", "frequency_key_list", "", "", "show_timestamp", "close_timestamp", "(Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getClose_timestamp", "()Ljava/util/List;", "getFrequency_key_list", "getPlan_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShow_timestamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$FrequencyRecordItem;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FrequencyRecordItem {

        @SerializedName("close_timestamp")
        private final List<Long> close_timestamp;

        @SerializedName("frequency_key_list")
        private final List<String> frequency_key_list;

        @SerializedName("plan_id")
        private final Long plan_id;

        @SerializedName("show_timestamp")
        private final List<Long> show_timestamp;

        public FrequencyRecordItem() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FrequencyRecordItem copy$default(FrequencyRecordItem r100, Long r101, List r102, List r103, List r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.plan_id;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.frequency_key_list;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.show_timestamp;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.close_timestamp;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final Long component1() {
            return this.plan_id;
        }

        public final List<String> component2() {
            return this.frequency_key_list;
        }

        public final List<Long> component3() {
            return this.show_timestamp;
        }

        public final List<Long> component4() {
            return this.close_timestamp;
        }

        public final FrequencyRecordItem copy(Long r100, List<String> r101, List<Long> r102, List<Long> r103) {
            return new FrequencyRecordItem(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FrequencyRecordItem) == false) goto L14;
            FrequencyRecordItem r101 = (FrequencyRecordItem) r100;
            if (Intrinsics.areEqual(this.plan_id, r101.plan_id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.frequency_key_list, r101.frequency_key_list) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.show_timestamp, r101.show_timestamp) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.close_timestamp, r101.close_timestamp) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            Long r100 = this.plan_id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.frequency_key_list;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<Long> r107 = this.show_timestamp;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            List<Long> r110 = this.close_timestamp;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "FrequencyRecordItem(plan_id=" + this.plan_id + ", frequency_key_list=" + this.frequency_key_list + ", show_timestamp=" + this.show_timestamp + ", close_timestamp=" + this.close_timestamp + ")";
        }

        public final List<Long> getClose_timestamp() {
            return this.close_timestamp;
        }

        public final List<String> getFrequency_key_list() {
            return this.frequency_key_list;
        }

        public final Long getPlan_id() {
            return this.plan_id;
        }

        public final List<Long> getShow_timestamp() {
            return this.show_timestamp;
        }

        public FrequencyRecordItem(Long r100, List<String> r101, List<Long> r102, List<Long> r103) {
            this.plan_id = r100;
            this.frequency_key_list = r101;
            this.show_timestamp = r102;
            this.close_timestamp = r103;
        }

        public /* synthetic */ FrequencyRecordItem(Long r100, List r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0L;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$StorageValue;", "", "type", "", "value", "expiredTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getExpiredTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "()Ljava/lang/String;", "getValue", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$StorageValue;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StorageValue {

        @SerializedName("expired_time")
        private final Long expiredTime;

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public static /* synthetic */ StorageValue copy$default(StorageValue r100, String r101, String r102, Long r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.value;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.expiredTime;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.value;
        }

        public final Long component3() {
            return this.expiredTime;
        }

        public final StorageValue copy(String r100, String r101, Long r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "value");
            return new StorageValue(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof StorageValue) == false) goto L12;
            StorageValue r101 = (StorageValue) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.value, r101.value) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.expiredTime, r101.expiredTime) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.value;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.expiredTime;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "StorageValue(type=" + this.type + ", value=" + this.value + ", expiredTime=" + this.expiredTime + ")";
        }

        public final Long getExpiredTime() {
            return this.expiredTime;
        }

        public final String getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }

        public StorageValue(String r100, String r101, Long r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.type = r100;
            this.value = r101;
            this.expiredTime = r102;
        }

        public /* synthetic */ StorageValue(String r100, String r101, Long r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0083\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$XReadableType;", "", "(Ljava/lang/String;I)V", "Null", "Boolean", "Number", "Int", "String", "Map", "Array", "Long", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum XReadableType extends Enum<XReadableType> {
        private static final /* synthetic */ XReadableType[] $VALUES = null;
        public static final XReadableType Array = null;
        public static final XReadableType Boolean = null;
        public static final XReadableType Int = null;
        public static final XReadableType Long = null;
        public static final XReadableType Map = null;
        public static final XReadableType Null = null;
        public static final XReadableType Number = null;
        public static final XReadableType String = null;

        static {
            XReadableType r100 = new XReadableType("Null", 0);
            Null = r100;
            XReadableType r101 = new XReadableType("Boolean", 1);
            Boolean = r101;
            XReadableType r102 = new XReadableType("Number", 2);
            Number = r102;
            XReadableType r103 = new XReadableType("Int", 3);
            Int = r103;
            XReadableType r104 = new XReadableType("String", 4);
            String = r104;
            XReadableType r105 = new XReadableType("Map", 5);
            Map = r105;
            XReadableType r106 = new XReadableType("Array", 6);
            Array = r106;
            XReadableType r107 = new XReadableType("Long", 7);
            Long = r107;
            $VALUES = new XReadableType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static XReadableType valueOf(String r100) {
            return (XReadableType) r27.a.a(XReadableType.class, r100);
        }

        public static XReadableType[] values() {
            return (XReadableType[]) $VALUES.clone();
        }

        private XReadableType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/shopping/api/mall/common/tools/StorageItemDataProvider$FrequencyRecordItem;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends FrequencyRecordItem>> {
        public a() {
        }
    }

    public StorageItemDataProvider(Context r100) {
        this.f170415a = r100;
    }

    public final Map<String, Object> a(List<String> r100) {
        if (this.f170415a == null) goto L5;
        if (r100 != null) goto L10;
        return MapsKt.emptyMap();
    L10:
        if (r100.isEmpty() == true) goto L12;
        SharedPreferences r101 = this.f170415a.getSharedPreferences("xbridge-storage", 0);     // Catch: Exception -> L27
        if (r101 == null) goto L16;
        Gson r102 = new Gson();     // Catch: Exception -> L27
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Exception -> L27
        Iterator<T> r104 = r100.iterator();     // Catch: Exception -> L27
    L19:
        if (r104.hasNext() == false) goto L26;
        String r105 = (String) r104.next();     // Catch: Exception -> L27
        Object r106 = b(r101, r105, r102);     // Catch: Exception -> L27
        if (r106 == null) goto L19;
        if (r105 != null) goto L24;
        r105 = "";
    L24:
        r103.put(r105, r106);     // Catch: Exception -> L27
        goto L19
    L26:
        return r103;
    L16:
        return MapsKt.emptyMap();
    L28:
        return MapsKt.emptyMap();
    L12:
        return MapsKt.emptyMap();
    L5:
        return MapsKt.emptyMap();
    }

    public static Object b(SharedPreferences r100, String r101, Gson r102) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100.contains(r101) == true) goto L8;
        return null;
    L8:
        String r103 = r100.getString(r101, "");
        if (r103 != null) goto L11;
    L16:
        StorageValue r104 = (StorageValue) GsonProtectorUtils.fromJson(r102, r103, StorageValue.class);
        String r105 = r104.getValue();
        XReadableType r106 = XReadableType.valueOf(r104.getType());
        switch(x.f170469a[r106.ordinal()]) {
            case 1: goto L29;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L20;
            case 7: goto L30;
            default: goto L34;
        };
    L34:
        return null;
    L20:
        if (Intrinsics.areEqual(r101, "popup_frequency_record") == true) goto L22;
        return r105;
    L22:
        return GsonProtectorUtils.fromJson(new Gson(), r105, new a().getType());
    L30:
        return r105;
    L31:
        return Double.valueOf(CastDoubleProtector.parseDouble(r105));
    L32:
        return Long.valueOf(CastLongProtector.parseLong(r105));
    L33:
        return Integer.valueOf(CastIntegerProtector.parseInt(r105));
    L29:
        return Boolean.valueOf(Boolean.parseBoolean(r105));
    L11:
        if (r103.length() != 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 != true) goto L16;
        return null;
    L13:
        r107 = false;
        goto L14
    }
}
