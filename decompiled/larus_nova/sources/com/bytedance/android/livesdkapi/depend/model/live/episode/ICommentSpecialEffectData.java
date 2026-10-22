package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR:\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICommentSpecialEffectData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICommentSpecialEffectDataEx;", "", "getCommentSpecialEffectType", "()I", "setCommentSpecialEffectType", "(I)V", "getCommentSpecialEffectType$annotations", "()V", "commentSpecialEffectType", "", "getSpecialEffectInterval", "()J", "setSpecialEffectInterval", "(J)V", "getSpecialEffectInterval$annotations", "specialEffectInterval", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ITimeRange;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMaskedOffsetList", "()Ljava/util/List;", "setMaskedOffsetList", "(Ljava/util/List;)V", "getMaskedOffsetList$annotations", "maskedOffsetList", "", "getMEffectTypeSdkKey", "()Ljava/lang/String;", "setMEffectTypeSdkKey", "(Ljava/lang/String;)V", "getMEffectTypeSdkKey$annotations", "mEffectTypeSdkKey", "getMMaxCommentCountPerEffect", "setMMaxCommentCountPerEffect", "getMMaxCommentCountPerEffect$annotations", "mMaxCommentCountPerEffect", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ICommentSpecialEffectData extends c<ICommentSpecialEffectData>, ICommentSpecialEffectDataEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "comment_special_effect_type")
        public static /* synthetic */ void getCommentSpecialEffectType$annotations() {
        }

        @FieldName(name = "effect_type_sdk_key")
        public static /* synthetic */ void getMEffectTypeSdkKey$annotations() {
        }

        @FieldName(name = "max_comment_count_per_effect")
        public static /* synthetic */ void getMMaxCommentCountPerEffect$annotations() {
        }

        @FieldName(name = "masked_offset_list")
        public static /* synthetic */ void getMaskedOffsetList$annotations() {
        }

        @FieldName(name = "special_effect_interval")
        public static /* synthetic */ void getSpecialEffectInterval$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "comment_special_effect_type")
    int getCommentSpecialEffectType();

    @FieldName(name = "effect_type_sdk_key")
    String getMEffectTypeSdkKey();

    @FieldName(name = "max_comment_count_per_effect")
    int getMMaxCommentCountPerEffect();

    @FieldName(name = "masked_offset_list")
    List<ITimeRange> getMaskedOffsetList();

    @FieldName(name = "special_effect_interval")
    long getSpecialEffectInterval();

    @FieldName(name = "comment_special_effect_type#setter")
    void setCommentSpecialEffectType(int r100);

    @FieldName(name = "effect_type_sdk_key#setter")
    void setMEffectTypeSdkKey(String r100);

    @FieldName(name = "max_comment_count_per_effect#setter")
    void setMMaxCommentCountPerEffect(int r100);

    @FieldName(name = "masked_offset_list#setter")
    void setMaskedOffsetList(List<? extends ITimeRange> r100);

    @FieldName(name = "special_effect_interval#setter")
    void setSpecialEffectInterval(long r100);
}
