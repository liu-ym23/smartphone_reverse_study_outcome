package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0003H&J\n\u0010 \u001a\u0004\u0018\u00010\u0013H&J\n\u0010!\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\"\u001a\u0004\u0018\u00010#H&J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\tH&J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010)\u001a\u00020'2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010+H&J\u001e\u0010,\u001a\u00020'2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH&J\u0012\u0010.\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020%H&J\u0012\u00101\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0013H&J\u0012\u00102\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010\u0003H&J\u0012\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010#H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R\u001a\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000b¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerContext;", "", "skinOutputParams", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;", "getSkinOutputParams", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;", "setSkinOutputParams", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;)V", "skinOutputParamsLiveData", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getSkinOutputParamsLiveData", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "skinRequireHeight", "", "", "", "getSkinRequireHeight", "()Ljava/util/Map;", "universalInputSize", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "getUniversalInputSize", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "setUniversalInputSize", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;)V", "universalOutputParam", "getUniversalOutputParam", "setUniversalOutputParam", "universalOutputParamLiveData", "getUniversalOutputParamLiveData", "getFoldScreenOutputParam", "Lkotlin/Pair;", "getFoldScreenV3OutputParam", "getInputSize", "getLandscapeOutputParam", "getTranslationAndScaleProperty", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/TranslationAndScaleProperty;", "isGameStickerVisible", "", "setFoldScreenInputSize", "", "size", "setFoldScreenOutParamChangeListener", "listener", "Lkotlin/Function0;", "setFoldScreenOutputParam", "params", "setFoldScreenV3OutputParam", "setGameStickerVisible", "visible", "setLandscapeInputSize", "setLandscapeOutputParam", "setTranslationAndScaleProperty", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerContext {
    Pair<Integer, Integer> getFoldScreenOutputParam();

    BottomContainerParams getFoldScreenV3OutputParam();

    BottomContainerSize getInputSize();

    BottomContainerParams getLandscapeOutputParam();

    BottomContainerParams getSkinOutputParams();

    NextLiveData<BottomContainerParams> getSkinOutputParamsLiveData();

    Map<String, Integer> getSkinRequireHeight();

    TranslationAndScaleProperty getTranslationAndScaleProperty();

    BottomContainerSize getUniversalInputSize();

    BottomContainerParams getUniversalOutputParam();

    NextLiveData<BottomContainerParams> getUniversalOutputParamLiveData();

    NextLiveData<Boolean> isGameStickerVisible();

    void setFoldScreenInputSize(BottomContainerSize r100);

    void setFoldScreenOutParamChangeListener(Function0<Unit> r100);

    void setFoldScreenOutputParam(Pair<Integer, Integer> r100);

    void setFoldScreenV3OutputParam(BottomContainerParams r100);

    void setGameStickerVisible(boolean r100);

    void setLandscapeInputSize(BottomContainerSize r100);

    void setLandscapeOutputParam(BottomContainerParams r100);

    void setSkinOutputParams(BottomContainerParams r100);

    void setTranslationAndScaleProperty(TranslationAndScaleProperty r100);

    void setUniversalInputSize(BottomContainerSize r100);

    void setUniversalOutputParam(BottomContainerParams r100);
}
