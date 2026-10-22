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
public final class LiveFoldScreenLandscapeLayoutStrategy implements IGameStickerLayoutStrategy {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f125644g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IGameStickerContainerViewProxy f125645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f125646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f125647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f125648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f125649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ILivePlayerClient f125650f;

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
        this.f125645a = null;
        IRenderView r100 = this.f125650f.getRenderView();
        if (r100 == null) goto L5;
        r100.removeRenderViewLayoutListener(this.f125646b);
    L5:
        if (r100 == null) goto L7;
        r100.removeTranslationAndScaleListener(this.f125647c);
    L7:
        GameStickerContext r101 = b();
        if (r101 == null) goto L11;
        r101.setTranslationAndScaleProperty(null);
        r101.setLandscapeInputSize(null);
        r101.setLandscapeOutputParam(null);
        return;
    }

    public static final void a(LiveFoldScreenLandscapeLayoutStrategy r100) {
        GameStickerContext r101 = r100.b();
        if (r101 == null) goto L5;
        BottomContainerParams r102 = r101.getLandscapeOutputParam();
    L6:
        r100.c("onOutputParamChange params:" + r102);
        if (r102 == null) goto L22;
        GameStickerContext r103 = r100.b();
        if (r103 == null) goto L13;
        TranslationAndScaleProperty r104 = r103.getTranslationAndScaleProperty();
        if (r104 == null) goto L13;
        r100.d(r104.getTranslationX(), r104.getTranslationY(), r104.getScaleX(), r104.getScaleY());
    L13:
        IGameStickerContainerViewProxy r105 = r100.f125645a;
        if (r105 == null) goto L16;
        r105.setMargin(r102.getContainerY(), r102.getContainerX());
    L16:
        IGameStickerContainerViewProxy r106 = r100.f125645a;
        if (r106 == null) goto L19;
        r106.setSize(r102.getContainerW(), r102.getContainerH());
    L19:
        IGameStickerContainerViewProxy r107 = r100.f125645a;
        if (r107 == null) goto L29;
        r107.onLayoutFinished();
        return;
    L29:
        return;
    L22:
        IGameStickerContainerViewProxy r108 = r100.f125645a;
        if (r108 == null) goto L25;
        r108.setSize(0, 0);
    L25:
        IGameStickerContainerViewProxy r109 = r100.f125645a;
        if (r109 == null) goto L31;
        r109.onLayoutFinished();
        return;
    L31:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void attach(IGameStickerContainerViewProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProxy");
        c(LynxViewpagerItem.BIND_ON_ATTACH);
        this.f125645a = r100;
        IRenderView r101 = this.f125650f.getRenderView();
        if (r101 == null) goto L5;
        r101.addTranslationAndScaleListener(this.f125647c);
    L5:
        if (r101 == null) goto L7;
        r101.addRenderViewLayoutListener(this.f125646b);
    L7:
        IGameStickerContext r102 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a.getDataContext(GameStickerScene.ENTER);
        if (r102 == null) goto L10;
        r102.setFoldScreenOutParamChangeListener(new AnonymousClass1(this));
    L10:
        IGameStickerContainerViewProxy r103 = this.f125645a;
        if (r103 == null) goto L13;
        r103.setTranslationAndScale(0.0f, 0.0f, 1.0f, 1.0f);
    L13:
        IGameStickerContainerViewProxy r104 = this.f125645a;
        if (r104 == null) goto L17;
        r104.setLayoutStrategy(this);
        return;
    }

    public final void c(String r100) {
        ALogger.d("FoldScreenStrategy", this.f125648d + " live foldScreen half landscape " + r100);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void requestLayout(GameStickerInfo r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        GameStickerSetting r102 = GameStickerSetting.f106270f;
        if (r102.enableLandscape(r100.getStickerType()) == true) goto L5;
        return;
    L5:
        c("requestLayout operate:" + r100.getStickerOpr() + " code:" + r101);
        if (r100.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L19:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r103 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a;
        InvisibleCode r104 = r102.isInvisibleCode(r101);
        if (r104 == null) goto L25;
        c("requestLayout invisible code:" + r104);
        GameStickerContext r105 = b();
        if (r105 == null) goto L24;
        r105.setLandscapeInputSize(null);
    L24:
        this.f125650f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerHide"));
        return;
    L25:
        c("requestLayout setFoldScreenInputSize");
        GameStickerContext r106 = b();
        if (r106 == null) goto L28;
        r106.setLandscapeInputSize(new BottomContainerSize(r102.getSizeMode(r100).ordinal(), r100.getStickerSize().getWidth(), r100.getStickerSize().getHeight()));
    L28:
        this.f125650f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerCreateOrRefresh"));
        return;
    L8:
        if (r100.getStickerOpr() == GameStickerOpr.REFRESH) goto L19;
        if (r100.getStickerOpr() != GameStickerOpr.DESTROY) goto L30;
        c("requestLayout destroy");
        IGameStickerContainerViewProxy r107 = this.f125645a;
        if (r107 == null) goto L15;
        r107.setSize(0, 0);
    L15:
        GameStickerContext r108 = b();
        if (r108 == null) goto L18;
        r108.setLandscapeInputSize(null);
    L18:
        this.f125650f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerDestroy"));
        return;
    }

    public LiveFoldScreenLandscapeLayoutStrategy(long r100, LifecycleOwner r101, ILivePlayerClient r102) {
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "player");
        this.f125648d = r100;
        this.f125649e = r101;
        this.f125650f = r102;
        this.f125646b = new c(this);
        this.f125647c = new d(this);
    }

    public final void d(float r100, float r101, float r102, float r103) {
        GameStickerContext r104 = b();
        if (r104 == null) goto L5;
        BottomContainerParams r105 = r104.getLandscapeOutputParam();
    L6:
        if (r105 == null) goto L11;
        float r106 = r101 + (((r105.getPlayerH() + r105.getContainerH()) * (r103 - 1)) * 0.5f);
        IGameStickerContainerViewProxy r107 = this.f125645a;
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
