package com.bytedance.android.livesdk.chatroom.tetris.portrait;

import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"adaptLoad", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PortraitRow3rdTetris$initFirstShowHint$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PortraitRow3rdTetris this$0;

    public PortraitRow3rdTetris$initFirstShowHint$1(PortraitRow3rdTetris r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (Intrinsics.areEqual(o3.f().isVSVerticalStream(), Boolean.TRUE) == false) goto L5;
    L16:
        boolean r100 = true;
    L17:
        if (r100 == false) goto L36;
        PortraitRow3rdTetris r101 = this.this$0;
        if (r101.f111765u != null) goto L52;
        nm1.s r102 = pm1.f.p();
        if (r102 == null) goto L45;
        Class<? extends Widget> r103 = r102.d();
        if (r103 == null) goto L46;
        ViewGroup r104 = r101.f111763s;
        if (r104 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFirstShowHintView");
    L28:
        r101.f111765u = LiveTetris.Q(r101, r103, r104, false, null, 28);
        IVSPlayerService r105 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r105 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r106 = r105.provideVSPlayerViewControlService(((d90.d) r101.K()).f467480h);
        if (r106 == null) goto L48;
        PlayerViewControl.KEY r107 = PlayerViewControl.KEY.FirstShowHintAlpha;
        PlayerViewControl.Type r108 = PlayerViewControl.Type.ALPHA;
        PlayerViewControl.Style r109 = PlayerViewControl.Style.HIDE;
        ViewGroup r110 = r101.f111763s;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mFirstShowHintView");
    L35:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r106, r107, r108, r109, r110, 0.0f, false, false, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L52:
        return;
    L36:
        PortraitRow3rdTetris r111 = this.this$0;
        WidgetElement r112 = r111.f111765u;
        if (r112 == null) goto L53;
        r111.H(r112);
        r111.f111765u = null;
        IVSPlayerService r113 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r113 == null) goto L50;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r114 = r113.provideVSPlayerViewControlService(((d90.d) r111.K()).f467480h);
        if (r114 == null) goto L51;
        r114.c(PlayerViewControl.KEY.FirstShowHintAlpha);
        return;
    L51:
        return;
    L50:
        return;
    L53:
        return;
    L5:
        if (PadConfigUtils.c() == false) goto L15;
        MiddlewareRoomContext r115 = d90.e.l((d90.d) this.this$0.K());
        if (r115 == null) goto L11;
        com.bytedance.live.datacontext.n<PadOrientation> r116 = r115.getPadOrientation();
        if (r116 == null) goto L11;
        PadOrientation r117 = r116.getValue();
    L13:
        if (r117 != PadOrientation.LANDSCAPE) goto L15;
    L11:
        r117 = null;
    L15:
        r100 = false;
        goto L17
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
