package com.alibaba.gaiax.adapter;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.animation.GXLottieAnimation;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.inv.export.router.InvRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JD\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002JD\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001b"}, d2 = {"Lcom/alibaba/gaiax/adapter/GXAdapterLottieAnimation;", "Lcom/alibaba/gaiax/template/animation/GXLottieAnimation;", "()V", "executeAnimation", "", "gxState", "Lcom/alibaba/gaiax/template/GXIExpression;", "gxAnimationExpression", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "gxTemplateData", "Lorg/json/JSONObject;", "localAppendJson", "", "value", "localInitLottieLocalResourceDir", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "localPlay", "gxAnimationData", "localUri", "loopCount", "", "remotePlay", "remoteUri", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXAdapterLottieAnimation extends GXLottieAnimation {
    public GXAdapterLottieAnimation() {
    }

    private final String localAppendJson(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (StringsKt.endsWith$default(r100, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L6;
        return r100;
    L6:
        return r100.concat(InvRouter.FLOW_SUFFIX);
    }

    private final void localInitLottieLocalResourceDir(String r100, LottieAnimationView r101) {
        int r102 = StringsKt.indexOf$default(r100, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r102 <= 0) goto L10;
        boolean r103 = false;
        String r104 = r100.substring(0, r102);
        if (r104.length() <= 0) goto L7;
        r103 = true;
    L7:
        if (r103 == false) goto L11;
        r101.setImageAssetsFolder(r104 + "/images/");
        return;
    L11:
        return;
    }

    @Override // com.alibaba.gaiax.template.animation.GXLottieAnimation, com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(GXIExpression r110, GXIExpression r111, GXTemplateContext r112, GXNode r113, JSONObject r114) {
        Intrinsics.checkNotNullParameter(r112, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r113, "gxNode");
        Intrinsics.checkNotNullParameter(r114, "gxTemplateData");
        String r100 = null;
        if (r111 == null) goto L5;
        Object r115 = r111.value(r114);
    L7:
        if ((r115 instanceof JSONObject) == false) goto L9;
        JSONObject r101 = (JSONObject) r115;
    L10:
        GXIExpression r116 = getGxRemoteUri();
        if (r116 == null) goto L13;
        Object r117 = r116.value(r114);
    L15:
        if ((r117 instanceof String) == false) goto L17;
        String r102 = (String) r117;
    L18:
        if (r102 == null) goto L21;
        remotePlay(r112, r113, r114, r110, r101, r102, getLoopCount());
        return;
    L21:
        GXIExpression r118 = getGxLocalUri();
        if (r118 == null) goto L24;
        Object r119 = r118.value(r114);
    L26:
        if ((r119 instanceof String) == false) goto L28;
        r100 = (String) r119;
    L28:
        String r103 = r100;
        if (r103 == null) goto L32;
        localPlay(r112, r113, r114, r110, r101, r103, getLoopCount());
        return;
    L32:
        return;
    L24:
        r119 = null;
        goto L26
    L17:
        r102 = null;
        goto L18
    L13:
        r117 = null;
        goto L15
    L9:
        r101 = null;
        goto L10
    L5:
        r115 = null;
        goto L7
    }

    private final void localPlay(final GXTemplateContext r110, final GXNode r111, final JSONObject r112, final GXIExpression r113, final JSONObject r114, String r115, int r116) {
        View r100 = r111.getLottieView();
        if ((r100 instanceof LottieAnimationView) == false) goto L5;
        LottieAnimationView r101 = (LottieAnimationView) r100;
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        return;
    L14:
        if (r111.isAnimating() == true) goto L32;
        if (r101 != null) goto L18;
        return;
    L18:
        if (r101.getVisibility() != 0) goto L31;
        View r104 = r111.getView();
        if (r104 != null) goto L22;
    L24:
        r102 = false;
    L25:
        if (r102 == false) goto L33;
        localInitLottieLocalResourceDir(r115, r101);
        r101.removeAllAnimatorListeners();
        r101.removeAllUpdateListeners();
        r101.removeAllLottieOnCompositionLoadedListener();
        r101.setAnimation(localAppendJson(r115));
        r101.setRepeatCount(r116);
        final LottieAnimationView r105 = r101;
        r101.addAnimatorListener(new AnonymousClass1(r111, r105, r113, r110, r112, r114));
        r101.setClickable(false);
        r101.playAnimation();
        return;
    L33:
        return;
    L22:
        if (r104.getVisibility() != 0) goto L24;
    L31:
        return;
    L32:
        return;
    L9:
        if (r101.isAnimating() != true) goto L11;
        r103 = true;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    private final void remotePlay(final GXTemplateContext r110, final GXNode r111, final JSONObject r112, final GXIExpression r113, final JSONObject r114, String r115, final int r116) {
        View r100 = r111.getLottieView();
        if ((r100 instanceof LottieAnimationView) == false) goto L5;
        LottieAnimationView r101 = (LottieAnimationView) r100;
    L6:
        final LottieAnimationView r102 = r101;
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        if (r111.isAnimating() == true) goto L20;
        if (r102 != null) goto L17;
        return;
    L17:
        r102.removeAllAnimatorListeners();
        r102.removeAllUpdateListeners();
        r102.removeAllLottieOnCompositionLoadedListener();
        r111.setAnimating(true);
        final LottieTask<LottieComposition> r117 = LottieCompositionFactory.fromUrl(r102.getContext(), r115);
        r117.addListener(new C88091(r117, r111, r102, r116, r113, r110, r112, r114));
        return;
    L20:
        return;
    L9:
        if (r102.isAnimating() != true) goto L11;
        r103 = true;
        goto L11
    L5:
        r101 = null;
        goto L6
    }
}
