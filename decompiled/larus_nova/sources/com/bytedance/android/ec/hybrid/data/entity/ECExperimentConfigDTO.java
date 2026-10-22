package com.bytedance.android.ec.hybrid.data.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECExperimentConfigDTO;", "Ljava/io/Serializable;", "()V", "abtestKeyList", "", "", "getAbtestKeyList", "()Ljava/util/List;", "setAbtestKeyList", "(Ljava/util/List;)V", "settingKeyList", "getSettingKeyList", "setSettingKeyList", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExperimentConfigDTO implements Serializable {

    @SerializedName("abtest_key_list")
    private List<String> abtestKeyList;

    @SerializedName("settings_key_list")
    private List<String> settingKeyList;

    public ECExperimentConfigDTO() {
    }

    public final List<String> getAbtestKeyList() {
        return this.abtestKeyList;
    }

    public final List<String> getSettingKeyList() {
        return this.settingKeyList;
    }

    public final void setAbtestKeyList(List<String> r100) {
        this.abtestKeyList = r100;
    }

    public final void setSettingKeyList(List<String> r100) {
        this.settingKeyList = r100;
    }
}
