package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class MatchEffect extends FlexModelBase<IMatchEffect> implements IMatchEffect {
    private static final int HASH_CODE_37 = 37;

    @SerializedName("effect_resource")
    public k matchEffect;

    @SerializedName("show_effect")
    public boolean showEffect;

    public MatchEffect() {
        super(IMatchEffect.class);
    }

    public int hashCode() {
        int r100 = (this.showEffect ? 1 : 0) * 37;
        k r101 = this.matchEffect;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect
    public k getMatchEffect() {
        return this.matchEffect;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect
    public boolean getShowEffect() {
        return this.showEffect;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L22:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L22;
        MatchEffect r101 = (MatchEffect) r100;
        if (this.showEffect != r101.showEffect) goto L20;
        k r102 = this.matchEffect;
        if (r102 == null) goto L15;
    L16:
        if (r102 == null) goto L20;
        if (r102.equals(r101.matchEffect) == false) goto L20;
        return true;
    L15:
        if (r101.matchEffect != null) goto L16;
        return true;
    L20:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect
    public void setMatchEffect(k r100) {
        this.matchEffect = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect
    public void setShowEffect(boolean r100) {
        this.showEffect = r100;
    }
}
