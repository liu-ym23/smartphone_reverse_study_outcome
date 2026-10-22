package com.bytedance.android.live.impl.utils.json;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper;", "", "()V", "DefinitionItem", "EnterRoomDurationItem", "FirstFrameLoadDurationItem", "FirstRoomPerformanceDataItem", "GiftShowDateItem", "IJsonItem", "MiniWindowLoadDurationItem", "MiniWindowShowDurationItem", "PreviewClickPvItem", "PreviewShowPvItem", "StallLiveSensitivity", "StallRecordItem", "StallRoomSensitivity", "StartLiveDataItem", "StopLiveReasonDataItem", "WatchHotroomPvItem", "WatchLiveDateItem", "WatchRoomPvItem", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JsonItemHelper {
    public static final JsonItemHelper INSTANCE = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$DefinitionItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "definitionPvList", "", "", "definitionDurationList", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getDefinitionDurationList", "()Ljava/util/List;", "setDefinitionDurationList", "(Ljava/util/List;)V", "getDefinitionPvList", "setDefinitionPvList", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DefinitionItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("definition_duration")
        private List<Long> definitionDurationList;

        @SerializedName("definition_count")
        private List<Integer> definitionPvList;

        public DefinitionItem() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DefinitionItem copy$default(DefinitionItem r100, String r101, List r102, List r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.definitionPvList;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.definitionDurationList;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final List<Integer> component2() {
            return this.definitionPvList;
        }

        public final List<Long> component3() {
            return this.definitionDurationList;
        }

        public final DefinitionItem copy(String r100, List<Integer> r101, List<Long> r102) {
            return new DefinitionItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof DefinitionItem) == false) goto L12;
            DefinitionItem r101 = (DefinitionItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.definitionPvList, r101.definitionPvList) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.definitionDurationList, r101.definitionDurationList) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<Integer> r104 = this.definitionPvList;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<Long> r107 = this.definitionDurationList;
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
            return "DefinitionItem(date=" + this.date + ", definitionPvList=" + this.definitionPvList + ", definitionDurationList=" + this.definitionDurationList + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final List<Long> getDefinitionDurationList() {
            return this.definitionDurationList;
        }

        public final List<Integer> getDefinitionPvList() {
            return this.definitionPvList;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setDefinitionDurationList(List<Long> r100) {
            this.definitionDurationList = r100;
        }

        public final void setDefinitionPvList(List<Integer> r100) {
            this.definitionPvList = r100;
        }

        public DefinitionItem(String r100, List<Integer> r101, List<Long> r102) {
            this.date = r100;
            this.definitionPvList = r101;
            this.definitionDurationList = r102;
        }

        public /* synthetic */ DefinitionItem(String r100, List r101, List r102, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r110 & 2) == 0) goto L9;
            r101 = CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0});
        L9:
            if ((r110 & 4) == 0) goto L11;
            r102 = CollectionsKt.mutableListOf(new Long[]{0L, 0L, 0L, 0L, 0L});
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$EnterRoomDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "enterDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getEnterDurationSum", "()J", "setEnterDurationSum", "(J)V", "getFrequency", "()I", "setFrequency", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EnterRoomDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("enter_duration_sum")
        private long enterDurationSum;
        private int frequency;

        public EnterRoomDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ EnterRoomDurationItem copy$default(EnterRoomDurationItem r100, String r101, long r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.enterDurationSum;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.frequency;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.enterDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final EnterRoomDurationItem copy(String r100, long r101, int r102) {
            return new EnterRoomDurationItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof EnterRoomDurationItem) == false) goto L12;
            EnterRoomDurationItem r101 = (EnterRoomDurationItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.enterDurationSum == r101.enterDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r101.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.enterDurationSum;
            return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.frequency;
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "EnterRoomDurationItem(date=" + this.date + ", enterDurationSum=" + this.enterDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getEnterDurationSum() {
            return this.enterDurationSum;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setEnterDurationSum(long r100) {
            this.enterDurationSum = r100;
        }

        public final void setFrequency(int r100) {
            this.frequency = r100;
        }

        public EnterRoomDurationItem(String r100, long r101, int r102) {
            this.date = r100;
            this.enterDurationSum = r101;
            this.frequency = r102;
        }

        public /* synthetic */ EnterRoomDurationItem(String r100, long r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$FirstFrameLoadDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "loadDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getLoadDurationSum", "()J", "setLoadDurationSum", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FirstFrameLoadDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("load_duration_sum")
        private long loadDurationSum;

        public FirstFrameLoadDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ FirstFrameLoadDurationItem copy$default(FirstFrameLoadDurationItem r100, String r101, long r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.loadDurationSum;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.frequency;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.loadDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final FirstFrameLoadDurationItem copy(String r100, long r101, int r102) {
            return new FirstFrameLoadDurationItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FirstFrameLoadDurationItem) == false) goto L12;
            FirstFrameLoadDurationItem r101 = (FirstFrameLoadDurationItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.loadDurationSum == r101.loadDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r101.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.loadDurationSum;
            return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.frequency;
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "FirstFrameLoadDurationItem(date=" + this.date + ", loadDurationSum=" + this.loadDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final long getLoadDurationSum() {
            return this.loadDurationSum;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setFrequency(int r100) {
            this.frequency = r100;
        }

        public final void setLoadDurationSum(long r100) {
            this.loadDurationSum = r100;
        }

        public FirstFrameLoadDurationItem(String r100, long r101, int r102) {
            this.date = r100;
            this.loadDurationSum = r101;
            this.frequency = r102;
        }

        public /* synthetic */ FirstFrameLoadDurationItem(String r100, long r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$FirstRoomPerformanceDataItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "firstRoomPerformanceData", "Lorg/json/JSONObject;", "frequency", "", "(Ljava/lang/String;Lorg/json/JSONObject;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFirstRoomPerformanceData", "()Lorg/json/JSONObject;", "setFirstRoomPerformanceData", "(Lorg/json/JSONObject;)V", "getFrequency", "()I", "setFrequency", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FirstRoomPerformanceDataItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("first_room_performance_data")
        private JSONObject firstRoomPerformanceData;
        private int frequency;

        public FirstRoomPerformanceDataItem() {
            this(null, null, 0, 7, null);
        }

        public static /* synthetic */ FirstRoomPerformanceDataItem copy$default(FirstRoomPerformanceDataItem r100, String r101, JSONObject r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.firstRoomPerformanceData;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.frequency;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final JSONObject component2() {
            return this.firstRoomPerformanceData;
        }

        public final int component3() {
            return this.frequency;
        }

        public final FirstRoomPerformanceDataItem copy(String r100, JSONObject r101, int r102) {
            return new FirstRoomPerformanceDataItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FirstRoomPerformanceDataItem) == false) goto L12;
            FirstRoomPerformanceDataItem r101 = (FirstRoomPerformanceDataItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.firstRoomPerformanceData, r101.firstRoomPerformanceData) == true) goto L10;
            return false;
        L10:
            if (this.frequency == r101.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            JSONObject r104 = this.firstRoomPerformanceData;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((r103 + r101) * 31) + this.frequency;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "FirstRoomPerformanceDataItem(date=" + this.date + ", firstRoomPerformanceData=" + this.firstRoomPerformanceData + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final JSONObject getFirstRoomPerformanceData() {
            return this.firstRoomPerformanceData;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setFirstRoomPerformanceData(JSONObject r100) {
            this.firstRoomPerformanceData = r100;
        }

        public final void setFrequency(int r100) {
            this.frequency = r100;
        }

        public FirstRoomPerformanceDataItem(String r100, JSONObject r101, int r102) {
            this.date = r100;
            this.firstRoomPerformanceData = r101;
            this.frequency = r102;
        }

        public /* synthetic */ FirstRoomPerformanceDataItem(String r100, JSONObject r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$GiftShowDateItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftShowDateItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        /* JADX WARN: Multi-variable type inference failed */
        public GiftShowDateItem() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ GiftShowDateItem copy$default(GiftShowDateItem r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.date;
        }

        public final GiftShowDateItem copy(String r100) {
            return new GiftShowDateItem(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof GiftShowDateItem) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.date, ((GiftShowDateItem) r100).date) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "GiftShowDateItem(date=" + this.date + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public GiftShowDateItem(String r100) {
            this.date = r100;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public /* synthetic */ GiftShowDateItem(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IJsonItem {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$MiniWindowLoadDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "loadDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getLoadDurationSum", "()J", "setLoadDurationSum", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiniWindowLoadDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("load_duration_sum")
        private long loadDurationSum;

        public MiniWindowLoadDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ MiniWindowLoadDurationItem copy$default(MiniWindowLoadDurationItem r100, String r101, long r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.loadDurationSum;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.frequency;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.loadDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final MiniWindowLoadDurationItem copy(String r100, long r101, int r102) {
            return new MiniWindowLoadDurationItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof MiniWindowLoadDurationItem) == false) goto L12;
            MiniWindowLoadDurationItem r101 = (MiniWindowLoadDurationItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.loadDurationSum == r101.loadDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r101.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.loadDurationSum;
            return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.frequency;
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "MiniWindowLoadDurationItem(date=" + this.date + ", loadDurationSum=" + this.loadDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final long getLoadDurationSum() {
            return this.loadDurationSum;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setFrequency(int r100) {
            this.frequency = r100;
        }

        public final void setLoadDurationSum(long r100) {
            this.loadDurationSum = r100;
        }

        public MiniWindowLoadDurationItem(String r100, long r101, int r102) {
            this.date = r100;
            this.loadDurationSum = r101;
            this.frequency = r102;
        }

        public /* synthetic */ MiniWindowLoadDurationItem(String r100, long r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$MiniWindowShowDurationItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "showDurationSum", "", "frequency", "", "(Ljava/lang/String;JI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getShowDurationSum", "()J", "setShowDurationSum", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiniWindowShowDurationItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("show_duration_sum")
        private long showDurationSum;

        public MiniWindowShowDurationItem() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ MiniWindowShowDurationItem copy$default(MiniWindowShowDurationItem r100, String r101, long r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.showDurationSum;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.frequency;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.showDurationSum;
        }

        public final int component3() {
            return this.frequency;
        }

        public final MiniWindowShowDurationItem copy(String r100, long r101, int r102) {
            return new MiniWindowShowDurationItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof MiniWindowShowDurationItem) == false) goto L12;
            MiniWindowShowDurationItem r101 = (MiniWindowShowDurationItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.showDurationSum == r101.showDurationSum) goto L10;
            return false;
        L10:
            if (this.frequency == r101.frequency) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.showDurationSum;
            return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.frequency;
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "MiniWindowShowDurationItem(date=" + this.date + ", showDurationSum=" + this.showDurationSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final long getShowDurationSum() {
            return this.showDurationSum;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setFrequency(int r100) {
            this.frequency = r100;
        }

        public final void setShowDurationSum(long r100) {
            this.showDurationSum = r100;
        }

        public MiniWindowShowDurationItem(String r100, long r101, int r102) {
            this.date = r100;
            this.showDurationSum = r101;
            this.frequency = r102;
        }

        public /* synthetic */ MiniWindowShowDurationItem(String r100, long r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$PreviewClickPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "previewClickCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getPreviewClickCount", "()I", "setPreviewClickCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewClickPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("preview_click_count")
        private int previewClickCount;

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewClickPvItem() {
            String r100 = null;
            this(r100, 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PreviewClickPvItem copy$default(PreviewClickPvItem r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.previewClickCount;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.previewClickCount;
        }

        public final PreviewClickPvItem copy(String r100, int r101) {
            return new PreviewClickPvItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof PreviewClickPvItem) == false) goto L10;
            PreviewClickPvItem r101 = (PreviewClickPvItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.previewClickCount == r101.previewClickCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.previewClickCount;
        L5:
            r101 = 0;
            goto L7
        }

        public String toString() {
            return "PreviewClickPvItem(date=" + this.date + ", previewClickCount=" + this.previewClickCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getPreviewClickCount() {
            return this.previewClickCount;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setPreviewClickCount(int r100) {
            this.previewClickCount = r100;
        }

        public PreviewClickPvItem(String r100, int r101) {
            this.date = r100;
            this.previewClickCount = r101;
        }

        public /* synthetic */ PreviewClickPvItem(String r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$PreviewShowPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "previewShowCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getPreviewShowCount", "()I", "setPreviewShowCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewShowPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("preview_show_count")
        private int previewShowCount;

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewShowPvItem() {
            String r100 = null;
            this(r100, 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PreviewShowPvItem copy$default(PreviewShowPvItem r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.previewShowCount;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.previewShowCount;
        }

        public final PreviewShowPvItem copy(String r100, int r101) {
            return new PreviewShowPvItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof PreviewShowPvItem) == false) goto L10;
            PreviewShowPvItem r101 = (PreviewShowPvItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.previewShowCount == r101.previewShowCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.previewShowCount;
        L5:
            r101 = 0;
            goto L7
        }

        public String toString() {
            return "PreviewShowPvItem(date=" + this.date + ", previewShowCount=" + this.previewShowCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getPreviewShowCount() {
            return this.previewShowCount;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setPreviewShowCount(int r100) {
            this.previewShowCount = r100;
        }

        public PreviewShowPvItem(String r100, int r101) {
            this.date = r100;
            this.previewShowCount = r101;
        }

        public /* synthetic */ PreviewShowPvItem(String r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StallLiveSensitivity;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchLiveCount", "", "stallLiveCount", "(Ljava/lang/String;JJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getStallLiveCount", "()J", "setStallLiveCount", "(J)V", "getWatchLiveCount", "setWatchLiveCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StallLiveSensitivity implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("stall_live_count_more_than_watch_4s")
        private long stallLiveCount;

        @SerializedName("watch_live_count_more_than_4s")
        private long watchLiveCount;

        public StallLiveSensitivity() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ StallLiveSensitivity copy$default(StallLiveSensitivity r100, String r101, long r102, long r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L8;
            r102 = r100.watchLiveCount;
        L8:
            long r106 = r102;
            if ((r104 & 4) == 0) goto L11;
            r103 = r100.stallLiveCount;
        L11:
            String r107 = r101;
            return r100.copy(r107, r106, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.watchLiveCount;
        }

        public final long component3() {
            return this.stallLiveCount;
        }

        public final StallLiveSensitivity copy(String r100, long r101, long r110) {
            return new StallLiveSensitivity(r100, r101, r110);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof StallLiveSensitivity) == false) goto L12;
            StallLiveSensitivity r101 = (StallLiveSensitivity) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.watchLiveCount == r101.watchLiveCount) goto L10;
            return false;
        L10:
            if (this.stallLiveCount == r101.stallLiveCount) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.watchLiveCount;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.stallLiveCount;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "StallLiveSensitivity(date=" + this.date + ", watchLiveCount=" + this.watchLiveCount + ", stallLiveCount=" + this.stallLiveCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getStallLiveCount() {
            return this.stallLiveCount;
        }

        public final long getWatchLiveCount() {
            return this.watchLiveCount;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setStallLiveCount(long r100) {
            this.stallLiveCount = r100;
        }

        public final void setWatchLiveCount(long r100) {
            this.watchLiveCount = r100;
        }

        public StallLiveSensitivity(String r100, long r101, long r102) {
            this.date = r100;
            this.watchLiveCount = r101;
            this.stallLiveCount = r102;
        }

        public /* synthetic */ StallLiveSensitivity(String r100, long r101, long r102, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r110 & 2) == 0) goto L8;
            long r103 = 0;
        L10:
            if ((r110 & 4) == 0) goto L12;
            long r112 = 0;
        L13:
            this(r100, r103, r112);
            return;
        L12:
            r112 = r102;
            goto L13
        L8:
            r103 = r101;
            goto L10
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StallRecordItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "stallVideoUiRateSum", "", "stallUiRateSum", "frequency", "", "(Ljava/lang/String;FFI)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFrequency", "()I", "setFrequency", "(I)V", "getStallUiRateSum", "()F", "setStallUiRateSum", "(F)V", "getStallVideoUiRateSum", "setStallVideoUiRateSum", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StallRecordItem implements IJsonItem {

        @SerializedName("date")
        private String date;
        private int frequency;

        @SerializedName("stall_ui_rate_sum")
        private float stallUiRateSum;

        @SerializedName("stall_video_ui_rate_sum")
        private float stallVideoUiRateSum;

        public StallRecordItem() {
            this(null, 0.0f, 0.0f, 0, 15, null);
        }

        public static /* synthetic */ StallRecordItem copy$default(StallRecordItem r100, String r101, float r102, float r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.stallVideoUiRateSum;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.stallUiRateSum;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.frequency;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.date;
        }

        public final float component2() {
            return this.stallVideoUiRateSum;
        }

        public final float component3() {
            return this.stallUiRateSum;
        }

        public final int component4() {
            return this.frequency;
        }

        public final StallRecordItem copy(String r100, float r101, float r102, int r103) {
            return new StallRecordItem(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof StallRecordItem) == false) goto L14;
            StallRecordItem r101 = (StallRecordItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (Float.compare(this.stallVideoUiRateSum, r101.stallVideoUiRateSum) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.stallUiRateSum, r101.stallUiRateSum) == 0) goto L12;
            return false;
        L12:
            if (this.frequency == r101.frequency) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (((((r101 * 31) + Float.floatToIntBits(this.stallVideoUiRateSum)) * 31) + Float.floatToIntBits(this.stallUiRateSum)) * 31) + this.frequency;
        L5:
            r101 = 0;
            goto L7
        }

        public String toString() {
            return "StallRecordItem(date=" + this.date + ", stallVideoUiRateSum=" + this.stallVideoUiRateSum + ", stallUiRateSum=" + this.stallUiRateSum + ", frequency=" + this.frequency + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final float getStallUiRateSum() {
            return this.stallUiRateSum;
        }

        public final float getStallVideoUiRateSum() {
            return this.stallVideoUiRateSum;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setFrequency(int r100) {
            this.frequency = r100;
        }

        public final void setStallUiRateSum(float r100) {
            this.stallUiRateSum = r100;
        }

        public final void setStallVideoUiRateSum(float r100) {
            this.stallVideoUiRateSum = r100;
        }

        public StallRecordItem(String r100, float r101, float r102, int r103) {
            this.date = r100;
            this.stallVideoUiRateSum = r101;
            this.stallUiRateSum = r102;
            this.frequency = r103;
        }

        public /* synthetic */ StallRecordItem(String r100, float r101, float r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 0.0f;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 0.0f;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 0;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StallRoomSensitivity;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchRoomCount", "", "stallRoomCount", "(Ljava/lang/String;JJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getStallRoomCount", "()J", "setStallRoomCount", "(J)V", "getWatchRoomCount", "setWatchRoomCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StallRoomSensitivity implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("stall_room_count_more_than_watch_4s")
        private long stallRoomCount;

        @SerializedName("watch_room_count_more_than_4s")
        private long watchRoomCount;

        public StallRoomSensitivity() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ StallRoomSensitivity copy$default(StallRoomSensitivity r100, String r101, long r102, long r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r104 & 2) == 0) goto L8;
            r102 = r100.watchRoomCount;
        L8:
            long r106 = r102;
            if ((r104 & 4) == 0) goto L11;
            r103 = r100.stallRoomCount;
        L11:
            String r107 = r101;
            return r100.copy(r107, r106, r103);
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.watchRoomCount;
        }

        public final long component3() {
            return this.stallRoomCount;
        }

        public final StallRoomSensitivity copy(String r100, long r101, long r110) {
            return new StallRoomSensitivity(r100, r101, r110);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof StallRoomSensitivity) == false) goto L12;
            StallRoomSensitivity r101 = (StallRoomSensitivity) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.watchRoomCount == r101.watchRoomCount) goto L10;
            return false;
        L10:
            if (this.stallRoomCount == r101.stallRoomCount) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.watchRoomCount;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.stallRoomCount;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "StallRoomSensitivity(date=" + this.date + ", watchRoomCount=" + this.watchRoomCount + ", stallRoomCount=" + this.stallRoomCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getStallRoomCount() {
            return this.stallRoomCount;
        }

        public final long getWatchRoomCount() {
            return this.watchRoomCount;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setStallRoomCount(long r100) {
            this.stallRoomCount = r100;
        }

        public final void setWatchRoomCount(long r100) {
            this.watchRoomCount = r100;
        }

        public StallRoomSensitivity(String r100, long r101, long r102) {
            this.date = r100;
            this.watchRoomCount = r101;
            this.stallRoomCount = r102;
        }

        public /* synthetic */ StallRoomSensitivity(String r100, long r101, long r102, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r110 & 2) == 0) goto L8;
            long r103 = 0;
        L10:
            if ((r110 & 4) == 0) goto L12;
            long r112 = 0;
        L13:
            this(r100, r103, r112);
            return;
        L12:
            r112 = r102;
            goto L13
        L8:
            r103 = r101;
            goto L10
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StartLiveDataItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "startLiveCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getStartLiveCount", "()I", "setStartLiveCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StartLiveDataItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("start_live_count")
        private int startLiveCount;

        /* JADX WARN: Multi-variable type inference failed */
        public StartLiveDataItem() {
            String r100 = null;
            this(r100, 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ StartLiveDataItem copy$default(StartLiveDataItem r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.startLiveCount;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.startLiveCount;
        }

        public final StartLiveDataItem copy(String r100, int r101) {
            return new StartLiveDataItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof StartLiveDataItem) == false) goto L10;
            StartLiveDataItem r101 = (StartLiveDataItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.startLiveCount == r101.startLiveCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.startLiveCount;
        L5:
            r101 = 0;
            goto L7
        }

        public String toString() {
            return "StartLiveDataItem(date=" + this.date + ", startLiveCount=" + this.startLiveCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getStartLiveCount() {
            return this.startLiveCount;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setStartLiveCount(int r100) {
            this.startLiveCount = r100;
        }

        public StartLiveDataItem(String r100, int r101) {
            this.date = r100;
            this.startLiveCount = r101;
        }

        public /* synthetic */ StartLiveDataItem(String r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$StopLiveReasonDataItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "reasonCountList", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getReasonCountList", "()Ljava/util/List;", "setReasonCountList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StopLiveReasonDataItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("reason_count_list")
        private List<Integer> reasonCountList;

        /* JADX WARN: Multi-variable type inference failed */
        public StopLiveReasonDataItem() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopLiveReasonDataItem copy$default(StopLiveReasonDataItem r100, String r101, List r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.reasonCountList;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.date;
        }

        public final List<Integer> component2() {
            return this.reasonCountList;
        }

        public final StopLiveReasonDataItem copy(String r100, List<Integer> r101) {
            return new StopLiveReasonDataItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof StopLiveReasonDataItem) == false) goto L10;
            StopLiveReasonDataItem r101 = (StopLiveReasonDataItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.reasonCountList, r101.reasonCountList) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<Integer> r104 = this.reasonCountList;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "StopLiveReasonDataItem(date=" + this.date + ", reasonCountList=" + this.reasonCountList + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final List<Integer> getReasonCountList() {
            return this.reasonCountList;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setReasonCountList(List<Integer> r100) {
            this.reasonCountList = r100;
        }

        public StopLiveReasonDataItem(String r100, List<Integer> r101) {
            this.date = r100;
            this.reasonCountList = r101;
        }

        public /* synthetic */ StopLiveReasonDataItem(String r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0, 0, 0});
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$WatchHotroomPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchHotroomCount", "", "watchHotroomDurationSum", "watchNotHotroomCount", "watchNotHotroomDurationSum", "(Ljava/lang/String;JJJJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getWatchHotroomCount", "()J", "setWatchHotroomCount", "(J)V", "getWatchHotroomDurationSum", "setWatchHotroomDurationSum", "getWatchNotHotroomCount", "setWatchNotHotroomCount", "getWatchNotHotroomDurationSum", "setWatchNotHotroomDurationSum", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WatchHotroomPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("watch_hotroom_count")
        private long watchHotroomCount;

        @SerializedName("watch_hotroom_duration_sum")
        private long watchHotroomDurationSum;

        @SerializedName("watch_nothotroom_count")
        private long watchNotHotroomCount;

        @SerializedName("watch_nothotroom_duration_sum")
        private long watchNotHotroomDurationSum;

        public WatchHotroomPvItem() {
            this(null, 0, 0, 0, 0, 31, null);
        }

        public static /* synthetic */ WatchHotroomPvItem copy$default(WatchHotroomPvItem r110, String r111, long r112, long r113, long r114, long r115, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            String r100 = r110.date;
        L7:
            if ((r210 & 2) == 0) goto L9;
            long r101 = r110.watchHotroomCount;
        L11:
            if ((r210 & 4) == 0) goto L13;
            long r102 = r110.watchHotroomDurationSum;
        L15:
            if ((r210 & 8) == 0) goto L17;
            long r103 = r110.watchNotHotroomCount;
        L19:
            if ((r210 & 16) == 0) goto L21;
            long r104 = r110.watchNotHotroomDurationSum;
        L23:
            return r110.copy(r100, r101, r102, r103, r104);
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.date;
        }

        public final long component2() {
            return this.watchHotroomCount;
        }

        public final long component3() {
            return this.watchHotroomDurationSum;
        }

        public final long component4() {
            return this.watchNotHotroomCount;
        }

        public final long component5() {
            return this.watchNotHotroomDurationSum;
        }

        public final WatchHotroomPvItem copy(String r110, long r111, long r112, long r113, long r114) {
            return new WatchHotroomPvItem(r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof WatchHotroomPvItem) == false) goto L16;
            WatchHotroomPvItem r101 = (WatchHotroomPvItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.watchHotroomCount == r101.watchHotroomCount) goto L10;
            return false;
        L10:
            if (this.watchHotroomDurationSum == r101.watchHotroomDurationSum) goto L12;
            return false;
        L12:
            if (this.watchNotHotroomCount == r101.watchNotHotroomCount) goto L14;
            return false;
        L14:
            if (this.watchNotHotroomDurationSum == r101.watchNotHotroomDurationSum) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.watchHotroomCount;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.watchHotroomDurationSum;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.watchNotHotroomCount;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.watchNotHotroomDurationSum;
            return r107 + ((int) (r108 ^ (r108 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "WatchHotroomPvItem(date=" + this.date + ", watchHotroomCount=" + this.watchHotroomCount + ", watchHotroomDurationSum=" + this.watchHotroomDurationSum + ", watchNotHotroomCount=" + this.watchNotHotroomCount + ", watchNotHotroomDurationSum=" + this.watchNotHotroomDurationSum + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final long getWatchHotroomCount() {
            return this.watchHotroomCount;
        }

        public final long getWatchHotroomDurationSum() {
            return this.watchHotroomDurationSum;
        }

        public final long getWatchNotHotroomCount() {
            return this.watchNotHotroomCount;
        }

        public final long getWatchNotHotroomDurationSum() {
            return this.watchNotHotroomDurationSum;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setWatchHotroomCount(long r100) {
            this.watchHotroomCount = r100;
        }

        public final void setWatchHotroomDurationSum(long r100) {
            this.watchHotroomDurationSum = r100;
        }

        public final void setWatchNotHotroomCount(long r100) {
            this.watchNotHotroomCount = r100;
        }

        public final void setWatchNotHotroomDurationSum(long r100) {
            this.watchNotHotroomDurationSum = r100;
        }

        public WatchHotroomPvItem(String r100, long r101, long r102, long r103, long r104) {
            this.date = r100;
            this.watchHotroomCount = r101;
            this.watchHotroomDurationSum = r102;
            this.watchNotHotroomCount = r103;
            this.watchNotHotroomDurationSum = r104;
        }

        public /* synthetic */ WatchHotroomPvItem(String r110, long r111, long r112, long r113, long r114, int r210, DefaultConstructorMarker r211) {
            if ((r210 & 1) == 0) goto L5;
            String r100 = "";
        L6:
            long r101 = 0;
            if ((r210 & 2) == 0) goto L9;
            long r102 = 0;
        L11:
            if ((r210 & 4) == 0) goto L13;
            long r103 = 0;
        L15:
            if ((r210 & 8) == 0) goto L17;
            long r104 = 0;
        L19:
            if ((r210 & 16) != 0) goto L22;
            r101 = r114;
        L22:
            this(r100, r102, r103, r104, r101);
            return;
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$WatchLiveDateItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WatchLiveDateItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        /* JADX WARN: Multi-variable type inference failed */
        public WatchLiveDateItem() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ WatchLiveDateItem copy$default(WatchLiveDateItem r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.date;
        }

        public final WatchLiveDateItem copy(String r100) {
            return new WatchLiveDateItem(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof WatchLiveDateItem) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.date, ((WatchLiveDateItem) r100).date) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "WatchLiveDateItem(date=" + this.date + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public WatchLiveDateItem(String r100) {
            this.date = r100;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public /* synthetic */ WatchLiveDateItem(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$WatchRoomPvItem;", "Lcom/bytedance/android/live/impl/utils/json/JsonItemHelper$IJsonItem;", "date", "", "watchCount", "", "(Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getWatchCount", "()I", "setWatchCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WatchRoomPvItem implements IJsonItem {

        @SerializedName("date")
        private String date;

        @SerializedName("watch_count")
        private int watchCount;

        /* JADX WARN: Multi-variable type inference failed */
        public WatchRoomPvItem() {
            String r100 = null;
            this(r100, 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ WatchRoomPvItem copy$default(WatchRoomPvItem r100, String r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.date;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.watchCount;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.watchCount;
        }

        public final WatchRoomPvItem copy(String r100, int r101) {
            return new WatchRoomPvItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof WatchRoomPvItem) == false) goto L10;
            WatchRoomPvItem r101 = (WatchRoomPvItem) r100;
            if (Intrinsics.areEqual(this.date, r101.date) == true) goto L8;
            return false;
        L8:
            if (this.watchCount == r101.watchCount) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.date;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.watchCount;
        L5:
            r101 = 0;
            goto L7
        }

        public String toString() {
            return "WatchRoomPvItem(date=" + this.date + ", watchCount=" + this.watchCount + ")";
        }

        public final String getDate() {
            return this.date;
        }

        public final int getWatchCount() {
            return this.watchCount;
        }

        public final void setDate(String r100) {
            this.date = r100;
        }

        public final void setWatchCount(int r100) {
            this.watchCount = r100;
        }

        public WatchRoomPvItem(String r100, int r101) {
            this.date = r100;
            this.watchCount = r101;
        }

        public /* synthetic */ WatchRoomPvItem(String r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    private JsonItemHelper() {
    }

    static {
        INSTANCE = new JsonItemHelper();
    }
}
