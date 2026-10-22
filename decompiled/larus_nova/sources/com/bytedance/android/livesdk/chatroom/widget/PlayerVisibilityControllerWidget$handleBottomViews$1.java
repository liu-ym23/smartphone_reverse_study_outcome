package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", MapController.ITEM_LAYER_TAG, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class PlayerVisibilityControllerWidget$handleBottomViews$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ PlayerVisibilityControllerWidget this$0;

    public PlayerVisibilityControllerWidget$handleBottomViews$1(PlayerVisibilityControllerWidget r100, boolean r101, long r102) {
        this.this$0 = r100;
        this.$entiretyVisible = r101;
        this.$duration = r102;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        if (r110.f118413o == true) goto L5;
        boolean r100 = this.$entiretyVisible;
    L9:
        int r101 = !r100;
        Integer r102 = r110.f118404f.getValue();
        if (r102 != null) goto L13;
    L15:
        r110.f118404f.postValue(Integer.valueOf(r101));
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.this$0.dataCenter, true) == false) goto L18;
        int r103 = 55;
    L19:
        float r104 = 0.0f;
        if (r100 == 0) goto L22;
        float r105 = UtilityKotlinExtentionsKt.h(r103);
    L23:
        if (r100 == 0) goto L25;
        float r111 = 0.0f;
    L26:
        int r106 = s1.f119179f[r110.f118409k.ordinal()];
        if (r106 != 1) goto L29;
        long r112 = this.$duration;
        if (r112 <= 0) goto L59;
        Animator r107 = PlayerVisibilityControllerWidget.Aq(this.this$0, r110.f118407i, r105, r111, r112);
        PlayerVisibilityControllerWidget r108 = this.this$0;
        View r109 = r110.f118407i;
        if (r100 == 0) goto L58;
        r104 = 1.0f;
    L58:
        Animator r113 = PlayerVisibilityControllerWidget.wq(r108, r109, r104, this.$duration);
        ((ArrayList) this.this$0.f118646u).add(r107);
        ((ArrayList) this.this$0.f118646u).add(r113);
        return;
    L59:
        View r114 = r110.f118407i;
        if (r100 == 0) goto L62;
        r104 = 1.0f;
    L62:
        r114.setAlpha(r104);
        r110.f118407i.setTranslationY(r111);
        return;
    L29:
        if (r106 != 2) goto L67;
        float r115 = (this.this$0.f118643r - r110.f118399a) - UtilityKotlinExtentionsKt.h(r110.f118410l);
        long r116 = this.$duration;
        if (r116 > 0) goto L34;
        View r117 = r110.f118407i;
        if (r100 != 0) goto L52;
        r104 = r115;
    L52:
        r117.setTranslationY(r104);
        return;
    L34:
        if (r110.f118403e == false) goto L42;
        if (r100 == 0) goto L37;
        float r118 = r115;
    L38:
        float r119 = r118;
        if (r100 == 0) goto L41;
        r111 = 0.0f;
    L44:
        if (r110.f118405g != PlayerViewControl.KEY.GiftTray) goto L46;
        float r120 = 0.0f;
    L47:
        ((ArrayList) this.this$0.f118646u).add(PlayerVisibilityControllerWidget.yq(this.this$0, r110.f118407i, r119, r120, r115, r116));
        return;
    L46:
        r120 = r111;
        goto L47
    L41:
        r111 = r115;
        goto L44
    L37:
        r118 = 0.0f;
        goto L38
    L42:
        r119 = r105;
        goto L44
    L67:
        return;
    L25:
        r111 = UtilityKotlinExtentionsKt.h(r103);
        goto L26
    L22:
        r105 = 0.0f;
        goto L23
    L18:
        r103 = 105;
        goto L19
    L13:
        if (r102.intValue() != r101) goto L15;
        return;
    L5:
        if (this.$entiretyVisible == true) goto L7;
        r100 = 1;
        goto L9
    L7:
        r100 = 0;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
