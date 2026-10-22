package com.bytedance.android.livesdk.widgetdescriptor.delegate;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"adapt", "", "enableSeek", "", "view", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class Portrait6thDelegate$adaptRightCardForProgressBar$1 extends Lambda implements Function2<Boolean, View, Unit> {
    final /* synthetic */ DataCenter $dataCenter;
    final /* synthetic */ RoomContext $roomContext;
    final /* synthetic */ Portrait6thDelegate this$0;

    public Portrait6thDelegate$adaptRightCardForProgressBar$1(Portrait6thDelegate r100, DataCenter r101, RoomContext r102) {
        this.this$0 = r100;
        this.$dataCenter = r101;
        this.$roomContext = r102;
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(boolean r110, View r111) {
        Intrinsics.checkNotNullParameter(r111, "view");
        IVSPlayerService r100 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = r100.provideVSPlayerViewControlService(this.$dataCenter);
    L6:
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, this.$dataCenter, 0, 2);
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (r102.isVSVerticalStream() != true) goto L11;
    L12:
        r111.setTranslationY(0.0f);
        if (r110 == false) goto L22;
        if (r103 == false) goto L22;
        rs2.d.f539098e.getClass();
        int r112 = rs2.d.f539097d + ((int) UtilityKotlinExtentionsKt.h(this.$roomContext.getVsVerticalProgressBarHeight()));
        Portrait6thDelegate r104 = this.this$0;
        ((e0) r104.i()).f467478f.getClass();
        r104.o(d90.d.a.F, rs2.d.a.a((d90.a) this.this$0.i()));
        if (r101 == null) goto L18;
        PlayerViewControl.KEY r105 = PlayerViewControl.KEY.RightCard;
        PlayerViewControl.Type r106 = PlayerViewControl.Type.BOTTOM;
        PlayerViewControl.Style r107 = PlayerViewControl.Style.ATTACH;
        float r108 = s1.G(r112) - this.$roomContext.getVsVerticalProgressBarHeight();
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r101, r105, r106, r107, r111, r108, false, false, null, 480);
    L18:
        if (r101 != null) goto L20;
        return;
    L20:
        if (r101.getVisibilityStatus() == true) goto L27;
        r101.d(PlayerViewControl.KEY.RightCard, false);
        return;
    L27:
        return;
    L22:
        if (r101 == null) goto L24;
        r101.c(PlayerViewControl.KEY.RightCard);
    L24:
        Portrait6thDelegate r113 = this.this$0;
        ((e0) r113.i()).f467478f.getClass();
        j70.f r109 = d90.d.a.F;
        rs2.d.a r114 = rs2.d.f539098e;
        d90.a r115 = (d90.a) this.this$0.i();
        r114.getClass();
        r113.o(r109, rs2.d.a.a(r115));
        r111.setTranslationY(0.0f);
        return;
    L11:
        r103 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, View r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }
}
