package com.stepos.ailauncher.network.model;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\fHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/network/model/DictionaryItem;", "", "appId", "", "appVersion", "", "key", "type", "name", "dataType", UxipConstants.f30680s, "sort", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAppVersion", "()Ljava/lang/String;", "getKey", "getType", "getName", "getDataType", "getValue", "getSort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ChatTracker.CLICK_COPY, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/ailauncher/network/model/DictionaryItem;", "equals", "", "other", "hashCode", "toString", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DictionaryItem {

    @SerializedName("appId")
    private final Long appId;

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("dataType")
    private final String dataType;

    @SerializedName("key")
    private final String key;

    @SerializedName("name")
    private final String name;

    @SerializedName("sort")
    private final Integer sort;

    @SerializedName("type")
    private final String type;

    @SerializedName(UxipConstants.f30680s)
    private final String value;

    public DictionaryItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ DictionaryItem copy$default(DictionaryItem dictionaryItem, Long l10, String str, String str2, String str3, String str4, String str5, String str6, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = dictionaryItem.appId;
        }
        if ((i10 & 2) != 0) {
            str = dictionaryItem.appVersion;
        }
        if ((i10 & 4) != 0) {
            str2 = dictionaryItem.key;
        }
        if ((i10 & 8) != 0) {
            str3 = dictionaryItem.type;
        }
        if ((i10 & 16) != 0) {
            str4 = dictionaryItem.name;
        }
        if ((i10 & 32) != 0) {
            str5 = dictionaryItem.dataType;
        }
        if ((i10 & 64) != 0) {
            str6 = dictionaryItem.value;
        }
        if ((i10 & 128) != 0) {
            num = dictionaryItem.sort;
        }
        String str7 = str6;
        Integer num2 = num;
        String str8 = str4;
        String str9 = str5;
        return dictionaryItem.copy(l10, str, str2, str3, str8, str9, str7, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDataType() {
        return this.dataType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getSort() {
        return this.sort;
    }

    public final DictionaryItem copy(Long appId, String appVersion, String key, String type, String name, String dataType, String value, Integer sort) {
        return new DictionaryItem(appId, appVersion, key, type, name, dataType, value, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DictionaryItem)) {
            return false;
        }
        DictionaryItem dictionaryItem = (DictionaryItem) other;
        return p.d(this.appId, dictionaryItem.appId) && p.d(this.appVersion, dictionaryItem.appVersion) && p.d(this.key, dictionaryItem.key) && p.d(this.type, dictionaryItem.type) && p.d(this.name, dictionaryItem.name) && p.d(this.dataType, dictionaryItem.dataType) && p.d(this.value, dictionaryItem.value) && p.d(this.sort, dictionaryItem.sort);
    }

    public final Long getAppId() {
        return this.appId;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSort() {
        return this.sort;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        Long l10 = this.appId;
        int iHashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        String str = this.appVersion;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.key;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.dataType;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.value;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.sort;
        return iHashCode7 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "DictionaryItem(appId=" + this.appId + ", appVersion=" + this.appVersion + ", key=" + this.key + ", type=" + this.type + ", name=" + this.name + ", dataType=" + this.dataType + ", value=" + this.value + ", sort=" + this.sort + ")";
    }

    public DictionaryItem(Long l10, String str, String str2, String str3, String str4, String str5, String str6, Integer num) {
        this.appId = l10;
        this.appVersion = str;
        this.key = str2;
        this.type = str3;
        this.name = str4;
        this.dataType = str5;
        this.value = str6;
        this.sort = num;
    }

    public /* synthetic */ DictionaryItem(Long l10, String str, String str2, String str3, String str4, String str5, String str6, Integer num, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : num);
    }
}
