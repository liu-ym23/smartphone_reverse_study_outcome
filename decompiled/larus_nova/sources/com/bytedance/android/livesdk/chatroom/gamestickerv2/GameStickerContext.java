package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kc0.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001QB\u0007¢\u0006\u0004\bN\u0010OJ\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\u0011\u001a\u00020\u000f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020!H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020!0$H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010)R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020!0$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00104\u001a\u0004\b6\u00107R&\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000b088\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u00107R(\u0010E\u001a\u0004\u0018\u00010\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010J\u001a\u0004\u0018\u00010\b2\b\u0010@\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR(\u0010M\u001a\u0004\u0018\u00010\b2\b\u0010@\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010G\"\u0004\bL\u0010I¨\u0006R"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/gamestickerv2/GameStickerContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerContext;", "Landroidx/lifecycle/LiveData;", "Lkc0/u;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getRevenueStickerLiveData", "info", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;", "revDataToParams", "Lkotlin/Pair;", "", "revDataToFoldParams", "getLandscapeOutputParam", "params", "", "setLandscapeOutputParam", "setFoldScreenOutputParam", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "getInputSize", "size", "setLandscapeInputSize", "setFoldScreenInputSize", "getFoldScreenOutputParam", "setFoldScreenV3OutputParam", "getFoldScreenV3OutputParam", "Lkotlin/Function0;", "listener", "setFoldScreenOutParamChangeListener", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/TranslationAndScaleProperty;", "getTranslationAndScaleProperty", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "setTranslationAndScaleProperty", "", "visible", "setGameStickerVisible", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "isGameStickerVisible", "_landscapeOutputParam", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;", "_landscapeInputSize", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "_foldScreenOutputParam", "Lkotlin/Pair;", "_foldScreenInputSize", "_foldScreenV3OutputParam", "_universalInputSize", "_foldScreenOutParamChangeListener", "Lkotlin/jvm/functions/Function0;", "_translationAndScaleProperty", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/TranslationAndScaleProperty;", "gameStickerVisible", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "universalOutputParamLiveData", "getUniversalOutputParamLiveData", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "", "skinRequireHeight", "Ljava/util/Map;", "getSkinRequireHeight", "()Ljava/util/Map;", "skinOutputParamsLiveData", "getSkinOutputParamsLiveData", "value", "getUniversalInputSize", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "setUniversalInputSize", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;)V", "universalInputSize", "getUniversalOutputParam", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;", "setUniversalOutputParam", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;)V", "universalOutputParam", "getSkinOutputParams", "setSkinOutputParams", "skinOutputParams", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameStickerContext extends DataContext implements IGameStickerContext {
    public static final a Companion = null;
    private BottomContainerSize _foldScreenInputSize;
    private Function0<Unit> _foldScreenOutParamChangeListener;
    private Pair<Integer, Integer> _foldScreenOutputParam;
    private BottomContainerParams _foldScreenV3OutputParam;
    private BottomContainerSize _landscapeInputSize;
    private BottomContainerParams _landscapeOutputParam;
    private TranslationAndScaleProperty _translationAndScaleProperty;
    private BottomContainerSize _universalInputSize;
    private NextLiveData<Boolean> gameStickerVisible;
    private final NextLiveData<BottomContainerParams> skinOutputParamsLiveData;
    private final Map<String, Integer> skinRequireHeight;
    private final NextLiveData<BottomContainerParams> universalOutputParamLiveData;

    public static final class a {
        public a() {
        }

        public static GameStickerContext a(GameStickerScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            DataContext r101 = com.bytedance.live.datacontext.d.d(r100.name());
            if ((r101 instanceof GameStickerContext) == true) goto L5;
            r101 = null;
        L5:
            GameStickerContext r102 = (GameStickerContext) r101;
            if ((r102 instanceof IGameStickerContext) == false) goto L8;
            return r102;
        L8:
            ALogger.d("GameStickerContext", r100.name() + " getShared is null");
            return null;
        }
    }

    static {
        Companion = new a();
    }

    private final LiveData<u> getRevenueStickerLiveData() {
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        return ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService().o();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public Pair<Integer, Integer> getFoldScreenOutputParam() {
        Pair<Integer, Integer> r100 = this._foldScreenOutputParam;
        LiveData<u> r101 = getRevenueStickerLiveData();
        if (r101 == null) goto L5;
        u r102 = r101.getValue();
    L6:
        StringBuilder r103 = new StringBuilder("getFoldScreenOutputParam gameParams:");
        boolean r104 = true;
        if (r100 == null) goto L9;
        boolean r105 = true;
    L10:
        r103.append(r105);
        r103.append(" revParams:");
        if (r102 != null) goto L14;
        r104 = false;
    L14:
        r103.append(r104);
        ALogger.d("GameStickerContext", r103.toString());
        Pair<Integer, Integer> r106 = this._foldScreenOutputParam;
        if (r106 == null) goto L17;
        return r106;
    L17:
        return revDataToFoldParams(r102);
    L9:
        r105 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public BottomContainerSize getInputSize() {
        BottomContainerSize r100 = this._landscapeInputSize;
        if (r100 != null) goto L5;
        r100 = this._foldScreenInputSize;
    L5:
        if (r100 == null) goto L7;
        return r100;
    L7:
        return getUniversalInputSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public BottomContainerParams getLandscapeOutputParam() {
        BottomContainerParams r100 = this._landscapeOutputParam;
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        NextLiveData r102 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService().o();
        if (r102 == null) goto L5;
        u r103 = (u) r102.getValue();
    L6:
        StringBuilder r104 = new StringBuilder("getLandscapeOutputParam gameParams:");
        boolean r105 = false;
        if (r100 == null) goto L9;
        boolean r106 = true;
    L10:
        r104.append(r106);
        r104.append(" revParams:");
        if (r103 == null) goto L13;
        r105 = true;
    L13:
        r104.append(r105);
        ALogger.d("GameStickerContext", r104.toString());
        if (r100 == null) goto L16;
        return r100;
    L16:
        return revDataToParams(r103);
    L9:
        r106 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public GameStickerContext() {
        this.gameStickerVisible = new NextLiveData();
        this.universalOutputParamLiveData = new NextLiveData();
        this.skinRequireHeight = new LinkedHashMap();
        this.skinOutputParamsLiveData = new NextLiveData();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public BottomContainerParams getSkinOutputParams() {
        return getSkinOutputParamsLiveData().getValue();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public BottomContainerParams getUniversalOutputParam() {
        return getUniversalOutputParamLiveData().getValue();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public BottomContainerParams getFoldScreenV3OutputParam() {
        return this._foldScreenV3OutputParam;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public NextLiveData<BottomContainerParams> getSkinOutputParamsLiveData() {
        return this.skinOutputParamsLiveData;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public Map<String, Integer> getSkinRequireHeight() {
        return this.skinRequireHeight;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public TranslationAndScaleProperty getTranslationAndScaleProperty() {
        return this._translationAndScaleProperty;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public BottomContainerSize getUniversalInputSize() {
        return this._universalInputSize;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public NextLiveData<BottomContainerParams> getUniversalOutputParamLiveData() {
        return this.universalOutputParamLiveData;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public NextLiveData<Boolean> isGameStickerVisible() {
        return this.gameStickerVisible;
    }

    private final Pair<Integer, Integer> revDataToFoldParams(u r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Pair(Integer.valueOf((int) r100.f502376a.f502374c), Integer.valueOf((int) r100.f502376a.f502375d));
    }

    private final BottomContainerParams revDataToParams(u r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        kc0.a r100 = r110.f502377b;
        int r101 = (int) r100.f502372a;
        int r102 = (int) r100.f502373b;
        int r103 = (int) r100.f502374c;
        int r104 = (int) r100.f502375d;
        kc0.a r111 = r110.f502376a;
        return new BottomContainerParams(r101, r102, r103, r104, (int) r111.f502372a, (int) r111.f502373b, (int) r111.f502374c, (int) r111.f502375d, null, 256, null);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setFoldScreenInputSize(BottomContainerSize r100) {
        if (FoldScreenUtils.f() == false) goto L6;
        this._foldScreenInputSize = r100;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setFoldScreenOutParamChangeListener(Function0<Unit> r100) {
        this._foldScreenOutParamChangeListener = r100;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setFoldScreenOutputParam(Pair<Integer, Integer> r100) {
        if (FoldScreenUtils.f() == false) goto L8;
        this._foldScreenOutputParam = r100;
        Function0<Unit> r101 = this._foldScreenOutParamChangeListener;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setFoldScreenV3OutputParam(BottomContainerParams r100) {
        if (FoldScreenUtils.f() == false) goto L8;
        this._foldScreenV3OutputParam = r100;
        Function0<Unit> r101 = this._foldScreenOutParamChangeListener;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setGameStickerVisible(boolean r100) {
        this.gameStickerVisible.setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setLandscapeInputSize(BottomContainerSize r100) {
        this._landscapeInputSize = r100;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setLandscapeOutputParam(BottomContainerParams r100) {
        this._landscapeOutputParam = r100;
        if (FoldScreenUtils.f() == false) goto L8;
        Function0<Unit> r101 = this._foldScreenOutParamChangeListener;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setSkinOutputParams(BottomContainerParams r100) {
        NextLiveData<BottomContainerParams> r101 = getSkinOutputParamsLiveData();
        if ((!Intrinsics.areEqual(r101.getValue(), r100)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L9;
        r101.setValue(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setTranslationAndScaleProperty(TranslationAndScaleProperty r100) {
        this._translationAndScaleProperty = r100;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setUniversalInputSize(BottomContainerSize r100) {
        this._universalInputSize = r100;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext
    public void setUniversalOutputParam(BottomContainerParams r100) {
        getUniversalOutputParamLiveData().setValue(r100);
    }
}
