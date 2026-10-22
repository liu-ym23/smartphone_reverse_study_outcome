package com.bytedance.android.livesdkapi.depend.model.live.linker;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class CityEffect extends FlexModelBase<ICityEffect> implements ICityEffect {
    private static final int HASH_CODE_37 = 37;

    @SerializedName("city")
    public String city;

    @SerializedName("effect_resource")
    public k cityEffect;

    @SerializedName("show_effect_open_id_list")
    public List<String> showEffectOpenIdList;

    @SerializedName("show_effect_user_id_list")
    public List<Long> showEffectUserIdList;

    public CityEffect() {
        super(ICityEffect.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect
    public List<String> getShowEffectUserIdList() {
        List<String> r100 = this.showEffectOpenIdList;
        int r101 = n0.f58945a;
        o0.f58946a.getClass();
        return o0.a.h(r100);
    }

    public int hashCode() {
        k r100 = this.cityEffect;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 37;
        String r104 = this.city;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 37;
        if (getShowEffectUserIdList() == null) goto L14;
        r101 = getShowEffectUserIdList().hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffectDef
    public String getCity() {
        return this.city;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect
    public k getCityEffect() {
        return this.cityEffect;
    }

    private static /* synthetic */ Long lambda$setShowEffectUserIdList$0(String r100) {
        return Long.valueOf(d5.c(r100));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L28:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L28;
        CityEffect r101 = (CityEffect) r100;
        k r102 = this.cityEffect;
        if (r102 == null) goto L13;
    L14:
        if (r102 != null) goto L16;
    L26:
        return false;
    L16:
        if (r102.equals(r101.cityEffect) == false) goto L26;
    L18:
        if (TextUtils.equals(this.city, r101.city) == false) goto L26;
        if (getShowEffectUserIdList() != null) goto L24;
        if (r101.getShowEffectUserIdList() != null) goto L24;
        return true;
    L24:
        if (Objects.equals(getShowEffectUserIdList(), r101.getShowEffectUserIdList()) == false) goto L26;
        return true;
    L13:
        if (r101.cityEffect == null) goto L18;
        goto L14
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffectDef
    public void setCity(String r100) {
        this.city = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect
    public void setCityEffect(k r100) {
        this.cityEffect = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect
    public void setShowEffectUserIdList(List<String> r100) {
        this.showEffectOpenIdList = r100;
    }
}
