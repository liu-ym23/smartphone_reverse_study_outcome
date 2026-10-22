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
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements IGameStickerLayoutStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IGameStickerContainerViewProxy f125691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f125692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f125693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f125694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f125695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ILivePlayerClient f125696f;

    public static final class a {
    }

    static {
    }

    public final GameStickerContext a() {
        return (GameStickerContext) com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a.getDataContext(GameStickerScene.ENTER);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void detach() {
        b("detach");
        this.f125691a = null;
        IRenderView r100 = this.f125696f.getRenderView();
        if (r100 == null) goto L5;
        r100.removeRenderViewLayoutListener(this.f125692b);
    L5:
        if (r100 == null) goto L7;
        r100.removeTranslationAndScaleListener(this.f125693c);
    L7:
        GameStickerContext r101 = a();
        if (r101 == null) goto L10;
        r101.setTranslationAndScaleProperty(null);
    L10:
        GameStickerContext r102 = a();
        if (r102 == null) goto L13;
        r102.setLandscapeInputSize(null);
    L13:
        GameStickerContext r103 = a();
        if (r103 == null) goto L17;
        r103.setLandscapeOutputParam(null);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void attach(IGameStickerContainerViewProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProxy");
        b(LynxViewpagerItem.BIND_ON_ATTACH);
        this.f125691a = r100;
        IRenderView r101 = this.f125696f.getRenderView();
        if (r101 == null) goto L5;
        r101.addTranslationAndScaleListener(this.f125693c);
    L5:
        if (r101 == null) goto L7;
        r101.addRenderViewLayoutListener(this.f125692b);
    L7:
        IGameStickerContainerViewProxy r102 = this.f125691a;
        if (r102 == null) goto L10;
        r102.setTranslationAndScale(0.0f, 0.0f, 1.0f, 1.0f);
    L10:
        IGameStickerContainerViewProxy r103 = this.f125691a;
        if (r103 == null) goto L14;
        r103.setLayoutStrategy(this);
        return;
    }

    public final void b(String r100) {
        ALogger.d("LayoutStrategyLandscape", this.f125694d + " live landscape LayoutStrategy " + r100);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerLayoutStrategy
    public final void requestLayout(GameStickerInfo r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        GameStickerSetting r102 = GameStickerSetting.f106270f;
        if (r102.enableLandscape(r100.getStickerType()) == true) goto L5;
        return;
    L5:
        b("requestLayout operate:" + r100.getStickerOpr() + " code:" + r101);
        if (r100.getStickerOpr() != GameStickerOpr.CREATE) goto L8;
    L19:
        com.bytedance.android.livesdk.chatroom.gamestickerv2.f r103 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.f106346a;
        InvisibleCode r104 = r102.isInvisibleCode(r101);
        if (r104 == null) goto L25;
        b("requestLayout invisible code:" + r104);
        GameStickerContext r105 = a();
        if (r105 == null) goto L24;
        r105.setLandscapeInputSize(null);
    L24:
        this.f125696f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerHide"));
        return;
    L25:
        GameStickerContext r106 = a();
        if (r106 == null) goto L28;
        r106.setLandscapeInputSize(new BottomContainerSize(r102.getSizeMode(r100).ordinal(), r100.getStickerSize().getWidth(), r100.getStickerSize().getHeight()));
    L28:
        this.f125696f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerCreateOrRefresh"));
        return;
    L8:
        if (r100.getStickerOpr() == GameStickerOpr.REFRESH) goto L19;
        if (r100.getStickerOpr() != GameStickerOpr.DESTROY) goto L30;
        IGameStickerContainerViewProxy r107 = this.f125691a;
        if (r107 == null) goto L15;
        r107.setSize(0, 0);
    L15:
        GameStickerContext r108 = a();
        if (r108 == null) goto L18;
        r108.setLandscapeInputSize(null);
    L18:
        this.f125696f.getEventHub().getLayoutEvent().setValue(new LayoutEvent("GameStickerDestroy"));
        return;
    }

    public e(long r100, LifecycleOwner r101, ILivePlayerClient r102) {
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "player");
        this.f125694d = r100;
        this.f125695e = r101;
        this.f125696f = r102;
        this.f125692b = new f(this);
        this.f125693c = new g(this);
    }

    public final void c(float r100, float r101, float r102, float r103) {
        GameStickerContext r104 = a();
        if (r104 == null) goto L5;
        BottomContainerParams r105 = r104.getLandscapeOutputParam();
    L6:
        if (r105 == null) goto L11;
        float r106 = r101 + (((r105.getPlayerH() + r105.getContainerH()) * (r103 - 1)) * 0.5f);
        IGameStickerContainerViewProxy r107 = this.f125691a;
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
