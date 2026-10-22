package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerContext;
import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerSetting;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOpr;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveFoldScreenFullLandscapeLayoutStrategy implements IGameStickerLayoutStrategy {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f125637g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IGameStickerContainerViewProxy f125638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gamesticker.layoutstrategy.a f125639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f125640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f125641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f125642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ILivePlayerClient f125643f;

    public static final class a {
    }

    static {
    }

    public final GameStickerContext b() {
        return (GameStickerContext) com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a.getDataContext(GameStickerScene.ENTER);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void detach() {
        c("detach");
        this.f125638a = null;
        IGameStickerContext r100 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a.getDataContext(GameStickerScene.ENTER);
        if (r100 == null) goto L5;
        r100.setFoldScreenInputSize(null);
        r100.setFoldScreenOutputParam(null);
        r100.setFoldScreenOutParamChangeListener(null);
        r100.setFoldScreenV3OutputParam(null);
    L5:
        IRenderView r101 = this.f125643f.getRenderView();
        GameStickerContext r102 = b();
        if (r102 == null) goto L8;
        r102.setFoldScreenOutParamChangeListener(null);
    L8:
        if (r101 == null) goto L10;
        r101.removeRenderViewLayoutListener(this.f125639b);
    L10:
        if (r101 == null) goto L13;
        r101.removeTranslationAndScaleListener(this.f125640c);
        return;
    }

    public static final void a(LiveFoldScreenFullLandscapeLayoutStrategy r100) {
        r100.getClass();
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r101 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a;
        GameStickerScene r102 = GameStickerScene.ENTER;
        IGameStickerContext r103 = r101.getDataContext(r102);
        BottomContainerParams r104 = null;
        if (r103 == null) goto L5;
        BottomContainerParams r105 = r103.getLandscapeOutputParam();
    L6:
        IGameStickerContext r106 = r101.getDataContext(r102);
        if (r106 == null) goto L9;
        r104 = r106.getFoldScreenV3OutputParam();
    L9:
        if (r105 != null) goto L11;
        BottomContainerParams r107 = r104;
    L12:
        r100.c("onOutputParamChange params:" + r105 + ' ' + r104);
        if (r107 == null) goto L28;
        GameStickerContext r108 = r100.b();
        if (r108 == null) goto L19;
        TranslationAndScaleProperty r109 = r108.getTranslationAndScaleProperty();
        if (r109 == null) goto L19;
        r100.e(r109.getTranslationX(), r109.getTranslationY(), r109.getScaleX(), r109.getScaleY());
    L19:
        IGameStickerContainerViewProxy r110 = r100.f125638a;
        if (r110 == null) goto L22;
        r110.setMargin(r107.getContainerY(), r107.getContainerX());
    L22:
        IGameStickerContainerViewProxy r111 = r100.f125638a;
        if (r111 == null) goto L25;
        r111.setSize(r107.getContainerW(), r107.getContainerH());
    L25:
        IGameStickerContainerViewProxy r112 = r100.f125638a;
        if (r112 == null) goto L35;
        r112.onLayoutFinished();
        return;
    L35:
        return;
    L28:
        IGameStickerContainerViewProxy r113 = r100.f125638a;
        if (r113 == null) goto L31;
        r113.setSize(0, 0);
    L31:
        IGameStickerContainerViewProxy r114 = r100.f125638a;
        if (r114 == null) goto L37;
        r114.onLayoutFinished();
        return;
    L37:
        return;
    L11:
        r107 = r105;
        goto L12
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void attach(IGameStickerContainerViewProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProxy");
        c(LynxViewpagerItem.BIND_ON_ATTACH);
        this.f125638a = r100;
        IRenderView r101 = this.f125643f.getRenderView();
        if (r101 == null) goto L5;
        r101.addRenderViewLayoutListener(this.f125639b);
    L5:
        if (r101 == null) goto L7;
        r101.addTranslationAndScaleListener(this.f125640c);
    L7:
        GameStickerContext r102 = b();
        if (r102 == null) goto L10;
        r102.setFoldScreenOutParamChangeListener(new AnonymousClass1(this));
    L10:
        IGameStickerContainerViewProxy r103 = this.f125638a;
        if (r103 == null) goto L14;
        r103.setLayoutStrategy(this);
        return;
    }

    public final void c(String r100) {
        ALogger.d("FoldScreenStrategy", this.f125641d + " live foldScreen full landscape " + r100);
    }

    public final void d(String r100) {
        this.f125643f.getEventHub().getLayoutEvent().postValue(new LayoutEvent(r100));
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void requestLayout(GameStickerInfo r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        IGameStickerContext r102 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a.getDataContext(GameStickerScene.ENTER);
        if (r102 != null) goto L5;
        return;
    L5:
        GameStickerSetting r103 = GameStickerSetting.f106270f;
        c("requestLayout operate:" + r100.getStickerOpr() + " code:" + r101);
        if (r100.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L16:
        InvisibleCode r104 = r103.isInvisibleCode(r101);
        if (r104 == null) goto L19;
        c("requestLayout invisible code " + r104);
        r102.setFoldScreenInputSize(null);
        d("GameStickerHide");
        return;
    L19:
        c("requestLayout setFoldScreenInputSize");
        r102.setFoldScreenInputSize(new BottomContainerSize(r103.getSizeMode(r100).ordinal(), r100.getStickerSize().getWidth(), r100.getStickerSize().getHeight()));
        d("GameStickerCreateOrRefresh");
        return;
    L8:
        if (r100.getStickerOpr() == GameStickerOpr.REFRESH) goto L16;
        if (r100.getStickerOpr() != GameStickerOpr.DESTROY) goto L21;
        c("requestLayout destroy");
        IGameStickerContainerViewProxy r105 = this.f125638a;
        if (r105 == null) goto L15;
        r105.setSize(0, 0);
    L15:
        r102.setFoldScreenInputSize(null);
        d("GameStickerDestroy");
        return;
    }

    public LiveFoldScreenFullLandscapeLayoutStrategy(long r100, LifecycleOwner r101, ILivePlayerClient r102) {
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "player");
        this.f125641d = r100;
        this.f125642e = r101;
        this.f125643f = r102;
        this.f125639b = new com.bytedance.android.livesdk.gamesticker.layoutstrategy.a(this);
        this.f125640c = new b(this);
    }

    public final void e(float r100, float r101, float r102, float r103) {
        GameStickerContext r104 = b();
        if (r104 == null) goto L5;
        BottomContainerParams r105 = r104.getLandscapeOutputParam();
    L6:
        if (r105 == null) goto L11;
        float r106 = r101 + (((r105.getPlayerH() + r105.getContainerH()) * (r103 - 1)) * 0.5f);
        IGameStickerContainerViewProxy r107 = this.f125638a;
        if (r107 == null) goto L12;
        r107.setTranslationAndScale(r100, r106, r102, r103);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
