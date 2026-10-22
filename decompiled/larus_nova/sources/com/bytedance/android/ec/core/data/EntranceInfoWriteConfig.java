package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012@\b\u0002\u0010\u0002\u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010JA\u0010 \u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u008c\u0001\u0010%\u001a\u00020\u00002@\b\u0002\u0010\u0002\u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bRV\u0010\u0002\u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/core/data/EntranceInfoWriteConfig;", "Ljava/io/Serializable;", "ruleList", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/android/ec/core/data/ParamsWriteConfig;", "Lkotlin/collections/HashMap;", "checkKeysList", "", "enable", "", "passFiltered", "", "forceRuleList", "Lcom/bytedance/android/ec/core/data/ParamsForceRule;", "(Ljava/util/HashMap;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/ec/core/data/ParamsForceRule;)V", "getCheckKeysList", "()Ljava/util/Set;", "setCheckKeysList", "(Ljava/util/Set;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getForceRuleList", "()Lcom/bytedance/android/ec/core/data/ParamsForceRule;", "getPassFiltered", "()Ljava/util/List;", "getRuleList", "()Ljava/util/HashMap;", "setRuleList", "(Ljava/util/HashMap;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/HashMap;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/ec/core/data/ParamsForceRule;)Lcom/bytedance/android/ec/core/data/EntranceInfoWriteConfig;", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoWriteConfig implements Serializable {

    @SerializedName("check_keys")
    private Set<String> checkKeysList;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("force_rule")
    private final ParamsForceRule forceRuleList;

    @SerializedName("pass_filtered")
    private final List<String> passFiltered;

    @SerializedName("rule_list")
    private HashMap<String, Map<String, ParamsWriteConfig>> ruleList;

    public EntranceInfoWriteConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntranceInfoWriteConfig copy$default(EntranceInfoWriteConfig r100, HashMap r101, Set r102, Boolean r103, List r104, ParamsForceRule r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.ruleList;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.checkKeysList;
    L8:
        Set r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.enable;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.passFiltered;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.forceRuleList;
    L17:
        HashMap r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final HashMap<String, Map<String, ParamsWriteConfig>> component1() {
        return this.ruleList;
    }

    public final Set<String> component2() {
        return this.checkKeysList;
    }

    public final Boolean component3() {
        return this.enable;
    }

    public final List<String> component4() {
        return this.passFiltered;
    }

    public final ParamsForceRule component5() {
        return this.forceRuleList;
    }

    public final EntranceInfoWriteConfig copy(HashMap<String, Map<String, ParamsWriteConfig>> r100, Set<String> r101, Boolean r110, List<String> r111, ParamsForceRule r112) {
        return new EntranceInfoWriteConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EntranceInfoWriteConfig) == false) goto L16;
        EntranceInfoWriteConfig r101 = (EntranceInfoWriteConfig) r100;
        if (Intrinsics.areEqual(this.ruleList, r101.ruleList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.checkKeysList, r101.checkKeysList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.passFiltered, r101.passFiltered) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.forceRuleList, r101.forceRuleList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        HashMap<String, Map<String, ParamsWriteConfig>> r100 = this.ruleList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Set<String> r104 = this.checkKeysList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enable;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.passFiltered;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ParamsForceRule r113 = this.forceRuleList;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "EntranceInfoWriteConfig(ruleList=" + this.ruleList + ", checkKeysList=" + this.checkKeysList + ", enable=" + this.enable + ", passFiltered=" + this.passFiltered + ", forceRuleList=" + this.forceRuleList + ")";
    }

    public final Set<String> getCheckKeysList() {
        return this.checkKeysList;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final ParamsForceRule getForceRuleList() {
        return this.forceRuleList;
    }

    public final List<String> getPassFiltered() {
        return this.passFiltered;
    }

    public final HashMap<String, Map<String, ParamsWriteConfig>> getRuleList() {
        return this.ruleList;
    }

    public final void setCheckKeysList(Set<String> r100) {
        this.checkKeysList = r100;
    }

    public final void setRuleList(HashMap<String, Map<String, ParamsWriteConfig>> r100) {
        this.ruleList = r100;
    }

    public EntranceInfoWriteConfig(HashMap<String, Map<String, ParamsWriteConfig>> r100, Set<String> r101, Boolean r102, List<String> r103, ParamsForceRule r104) {
        this.ruleList = r100;
        this.checkKeysList = r101;
        this.enable = r102;
        this.passFiltered = r103;
        this.forceRuleList = r104;
    }

    public /* synthetic */ EntranceInfoWriteConfig(HashMap r100, Set r101, Boolean r102, List r103, ParamsForceRule r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        HashMap r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Set r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = Boolean.FALSE;
    L13:
        Boolean r106 = r102;
        if ((r110 & 8) == 0) goto L16;
        List r107 = null;
    L18:
        if ((r110 & 16) == 0) goto L20;
        ParamsForceRule r113 = null;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
