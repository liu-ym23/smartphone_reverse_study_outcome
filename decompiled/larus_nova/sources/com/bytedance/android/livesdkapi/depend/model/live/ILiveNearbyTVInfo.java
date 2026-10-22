package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;", "Lvh7/c;", "", "isIdle", "()Z", "setIdle", "(Z)V", "isIdle$annotations", "()V", "", "getStatesDesc", "()Ljava/lang/String;", "setStatesDesc", "(Ljava/lang/String;)V", "getStatesDesc$annotations", "statesDesc", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ILiveNearbyTVInfo extends c<ILiveNearbyTVInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "state_desc")
        public static /* synthetic */ void getStatesDesc$annotations() {
        }

        @FieldName(name = "is_idle")
        public static /* synthetic */ void isIdle$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "state_desc")
    String getStatesDesc();

    @FieldName(name = "is_idle")
    boolean isIdle();

    @FieldName(name = "is_idle#setter")
    void setIdle(boolean r100);

    @FieldName(name = "state_desc#setter")
    void setStatesDesc(String r100);
}
