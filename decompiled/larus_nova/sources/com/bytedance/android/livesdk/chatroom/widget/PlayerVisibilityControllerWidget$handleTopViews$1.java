package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", MapController.ITEM_LAYER_TAG, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class PlayerVisibilityControllerWidget$handleTopViews$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ PlayerVisibilityControllerWidget this$0;

    public PlayerVisibilityControllerWidget$handleTopViews$1(PlayerVisibilityControllerWidget r100, boolean r101, long r102) {
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
        float r103 = 0.0f;
        if (r100 == 0) goto L18;
        float r104 = 0.0f;
    L19:
        int r105 = s1.f119178e[r110.f118409k.ordinal()];
        if (r105 == 1) goto L36;
        if (r105 != 2) goto L49;
        float r106 = (this.this$0.f118642q - r110.f118400b) + UtilityKotlinExtentionsKt.h(r110.f118410l);
        if (this.$duration <= 0) goto L30;
        if (r100 == 0) goto L28;
        float r107 = UtilityKotlinExtentionsKt.h(-65);
    L29:
        ((ArrayList) this.this$0.f118646u).add(PlayerVisibilityControllerWidget.yq(this.this$0, r110.f118407i, r107, r104, r106, this.$duration));
        return;
    L28:
        r107 = 0.0f;
        goto L29
    L30:
        View r111 = r110.f118407i;
        if (r100 != 0) goto L34;
        r103 = r106;
    L34:
        r111.setTranslationY(r103);
        return;
    L49:
        return;
    L36:
        if (this.$duration <= 0) goto L41;
        PlayerVisibilityControllerWidget r108 = this.this$0;
        View r109 = r110.f118407i;
        Animator r112 = PlayerVisibilityControllerWidget.Aq(r108, r109, r109.getTranslationY(), r104, this.$duration);
        PlayerVisibilityControllerWidget r113 = this.this$0;
        View r114 = r110.f118407i;
        if (r100 == 0) goto L40;
        r103 = 1.0f;
    L40:
        Animator r115 = PlayerVisibilityControllerWidget.wq(r113, r114, r103, this.$duration);
        ((ArrayList) this.this$0.f118646u).add(r112);
        ((ArrayList) this.this$0.f118646u).add(r115);
        return;
    L41:
        View r116 = r110.f118407i;
        if (r100 == 0) goto L44;
        r103 = 1.0f;
    L44:
        r116.setAlpha(r103);
        r110.f118407i.setTranslationY(r104);
        return;
    L18:
        r104 = UtilityKotlinExtentionsKt.h(-65);
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
