package com.stepos.taskrobot.dictionary.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryItem;", "", "id", "", "appId", "", "type", "key", HintConstants.AUTOFILL_HINT_NAME, "value", "sort", "", AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAppId", "()Ljava/lang/String;", "getType", "getKey", "getName", "getValue", "getSort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryItem;", "equals", "", "other", "hashCode", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LegacyDictionaryItem {

    @SerializedName("appId")
    private final String appId;

    @SerializedName("id")
    private final Long id;

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

    public LegacyDictionaryItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ LegacyDictionaryItem copy$default(LegacyDictionaryItem legacyDictionaryItem, Long l, String str, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            l = legacyDictionaryItem.id;
        }
        if ((i & 2) != 0) {
            str = legacyDictionaryItem.appId;
        }
        if ((i & 4) != 0) {
            str2 = legacyDictionaryItem.type;
        }
        if ((i & 8) != 0) {
            str3 = legacyDictionaryItem.key;
        }
        if ((i & 16) != 0) {
            str4 = legacyDictionaryItem.name;
        }
        if ((i & 32) != 0) {
            str5 = legacyDictionaryItem.value;
        }
        if ((i & 64) != 0) {
            num = legacyDictionaryItem.sort;
        }
        String str6 = str5;
        Integer num2 = num;
        String str7 = str4;
        String str8 = str2;
        return legacyDictionaryItem.copy(l, str, str8, str3, str7, str6, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getSort() {
        return this.sort;
    }

    public final LegacyDictionaryItem copy(Long id, String appId, String type, String key, String name, String value, Integer sort) {
        return new LegacyDictionaryItem(id, appId, type, key, name, value, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyDictionaryItem)) {
            return false;
        }
        LegacyDictionaryItem legacyDictionaryItem = (LegacyDictionaryItem) other;
        return k.b(this.id, legacyDictionaryItem.id) && k.b(this.appId, legacyDictionaryItem.appId) && k.b(this.type, legacyDictionaryItem.type) && k.b(this.key, legacyDictionaryItem.key) && k.b(this.name, legacyDictionaryItem.name) && k.b(this.value, legacyDictionaryItem.value) && k.b(this.sort, legacyDictionaryItem.sort);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Long getId() {
        return this.id;
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
        Long l = this.id;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.appId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.value;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.sort;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        Long l = this.id;
        String str = this.appId;
        String str2 = this.type;
        String str3 = this.key;
        String str4 = this.name;
        String str5 = this.value;
        Integer num = this.sort;
        StringBuilder sb = new StringBuilder("LegacyDictionaryItem(id=");
        sb.append(l);
        sb.append(", appId=");
        sb.append(str);
        sb.append(", type=");
        a.A(sb, str2, ", key=", str3, ", name=");
        a.A(sb, str4, ", value=", str5, ", sort=");
        sb.append(num);
        sb.append(")");
        return sb.toString();
    }

    public LegacyDictionaryItem(Long l, String str, String str2, String str3, String str4, String str5, Integer num) {
        this.id = l;
        this.appId = str;
        this.type = str2;
        this.key = str3;
        this.name = str4;
        this.value = str5;
        this.sort = num;
    }

    public /* synthetic */ LegacyDictionaryItem(Long l, String str, String str2, String str3, String str4, String str5, Integer num, int i, e eVar) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : num);
    }
}
