package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffectDef;", "Lpy/k;", "getCityEffect", "()Lpy/k;", "setCityEffect", "(Lpy/k;)V", "getCityEffect$annotations", "()V", "cityEffect", "", "", "getShowEffectUserIdList", "()Ljava/util/List;", "setShowEffectUserIdList", "(Ljava/util/List;)V", "showEffectUserIdList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ICityEffect extends c<ICityEffect>, ICityEffectDef {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "effect_resource")
        public static /* synthetic */ void getCityEffect$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "effect_resource")
    k getCityEffect();

    List<String> getShowEffectUserIdList();

    @FieldName(name = "effect_resource#setter")
    void setCityEffect(k r100);

    void setShowEffectUserIdList(List<String> r100);
}
