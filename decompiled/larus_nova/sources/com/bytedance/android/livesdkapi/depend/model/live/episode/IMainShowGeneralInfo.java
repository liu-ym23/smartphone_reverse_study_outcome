package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\u0004\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMainShowGeneralInfo;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IShowGeneralInfo;", "", "isCommerceReplay", "()Z", "setCommerceReplay", "(Z)V", "isCommerceReplay$annotations", "()V", "Lpy/k;", "getFirstFrame", "()Lpy/k;", "setFirstFrame", "(Lpy/k;)V", "getFirstFrame$annotations", "firstFrame", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface IMainShowGeneralInfo extends e<IShowGeneralInfo>, IShowGeneralInfo {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = "video_first_frame")
        public static /* synthetic */ void getFirstFrame$annotations() {
        }

        @FieldName(name = "is_commerce_replay")
        public static /* synthetic */ void isCommerceReplay$annotations() {
        }
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IShowGeneralInfo, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IShowGeneralInfo, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "video_first_frame")
    k getFirstFrame();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "is_commerce_replay")
    boolean isCommerceReplay();

    @FieldName(name = "is_commerce_replay#setter")
    void setCommerceReplay(boolean r100);

    @FieldName(name = "video_first_frame#setter")
    void setFirstFrame(k r100);
}
