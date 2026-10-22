package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/IllegalLoadingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IllegalLoadingWidget extends LiveRecyclableWidget implements o70.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f114968a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_illegalloading;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(yn1.e.class);
    }

    public IllegalLoadingWidget() {
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof yn1.e) == false) goto L28;
        int r101 = ((yn1.e) r100).f568521a.s();
        if (r101 == 2) goto L20;
        if (r101 != 3) goto L9;
    L13:
        LottieAnimationView r102 = this.f114968a;
        if (r102 == null) goto L16;
        r102.setVisibility(8);
    L16:
        LottieAnimationView r103 = this.f114968a;
        if (r103 == null) goto L29;
        r103.cancelAnimation();
        return;
    L29:
        return;
    L9:
        if (r101 == 15) goto L20;
        if (r101 == 16) goto L13;
        return;
    L20:
        if (com.bytedance.android.live.core.utils.z.e(this.dataCenter, false) == false) goto L31;
        LottieAnimationView r104 = this.f114968a;
        if (r104 == null) goto L24;
        r104.setVisibility(0);
    L24:
        LottieAnimationView r105 = this.f114968a;
        if (r105 == null) goto L32;
        r105.playAnimation();
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f114968a = (LottieAnimationView) this.containerView.findViewById(R.id.illegal_shadow_animation);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        LottieAnimationView r101 = this.f114968a;
        if (r101 == null) goto L5;
        r101.setImageAssetsFolder("images/");
    L5:
        LottieAnimationView r102 = this.f114968a;
        if (r102 == null) goto L8;
        r102.setAnimation("illegal_live_shadow_loading.json");
    L8:
        LottieAnimationView r103 = this.f114968a;
        if (r103 == null) goto L12;
        r103.loop(true);
        return;
    }
}
