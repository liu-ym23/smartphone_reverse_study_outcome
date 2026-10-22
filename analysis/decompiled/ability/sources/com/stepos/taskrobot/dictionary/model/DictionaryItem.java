package com.stepos.taskrobot.dictionary.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "", "appId", "", "appVersion", "", "key", "type", HintConstants.AUTOFILL_HINT_NAME, "dataType", "value", "sort", AppAgent.CONSTRUCT, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppVersion", "()Ljava/lang/String;", "getKey", "getType", "getName", "getDataType", "getValue", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "equals", "", "other", "hashCode", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DictionaryItem {

    @SerializedName("appId")
    private final Integer appId;

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("dataType")
    private final String dataType;

    @SerializedName("key")
    private final String key;

    @SerializedName(HintConstants.AUTOFILL_HINT_NAME)
    private final String name;

    @SerializedName("sort")
    private final Integer sort;

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final String value;

    public DictionaryItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ DictionaryItem copy$default(DictionaryItem dictionaryItem, Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dictionaryItem.appId;
        }
        if ((i & 2) != 0) {
            str = dictionaryItem.appVersion;
        }
        if ((i & 4) != 0) {
            str2 = dictionaryItem.key;
        }
        if ((i & 8) != 0) {
            str3 = dictionaryItem.type;
        }
        if ((i & 16) != 0) {
            str4 = dictionaryItem.name;
        }
        if ((i & 32) != 0) {
            str5 = dictionaryItem.dataType;
        }
        if ((i & 64) != 0) {
            str6 = dictionaryItem.value;
        }
        if ((i & 128) != 0) {
            num2 = dictionaryItem.sort;
        }
        String str7 = str6;
        Integer num3 = num2;
        String str8 = str4;
        String str9 = str5;
        return dictionaryItem.copy(num, str, str2, str3, str8, str9, str7, num3);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getAppId() {
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

    public final DictionaryItem copy(Integer appId, String appVersion, String key, String type, String name, String dataType, String value, Integer sort) {
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
        return k.b(this.appId, dictionaryItem.appId) && k.b(this.appVersion, dictionaryItem.appVersion) && k.b(this.key, dictionaryItem.key) && k.b(this.type, dictionaryItem.type) && k.b(this.name, dictionaryItem.name) && k.b(this.dataType, dictionaryItem.dataType) && k.b(this.value, dictionaryItem.value) && k.b(this.sort, dictionaryItem.sort);
    }

    public final Integer getAppId() {
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
        Integer num = this.appId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
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
        Integer num2 = this.sort;
        return iHashCode7 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.appId;
        String str = this.appVersion;
        String str2 = this.key;
        String str3 = this.type;
        String str4 = this.name;
        String str5 = this.dataType;
        String str6 = this.value;
        Integer num2 = this.sort;
        StringBuilder sb = new StringBuilder("DictionaryItem(appId=");
        sb.append(num);
        sb.append(", appVersion=");
        sb.append(str);
        sb.append(", key=");
        a.A(sb, str2, ", type=", str3, ", name=");
        a.A(sb, str4, ", dataType=", str5, ", value=");
        sb.append(str6);
        sb.append(", sort=");
        sb.append(num2);
        sb.append(")");
        return sb.toString();
    }

    public DictionaryItem(Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2) {
        this.appId = num;
        this.appVersion = str;
        this.key = str2;
        this.type = str3;
        this.name = str4;
        this.dataType = str5;
        this.value = str6;
        this.sort = num2;
    }

    public /* synthetic */ DictionaryItem(Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, int i, e eVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : num2);
    }
}
