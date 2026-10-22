package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.Animator;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", MapController.ITEM_LAYER_TAG, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class ReplayPlayerVisibilityControllerWidget$handleTopViews$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $visible;
    final /* synthetic */ ReplayPlayerVisibilityControllerWidget this$0;

    public ReplayPlayerVisibilityControllerWidget$handleTopViews$1(ReplayPlayerVisibilityControllerWidget r100, boolean r101, long r102) {
        this.this$0 = r100;
        this.$visible = r101;
        this.$duration = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        int r100 = !this.$visible ? 1 : 0;
        Integer r101 = r110.f118404f.getValue();
        if (r101 != null) goto L6;
    L8:
        r110.f118404f.postValue(Integer.valueOf(r100));
        float r102 = 0.0f;
        if (this.$visible == false) goto L11;
        float r103 = 0.0f;
    L12:
        int r104 = s.f108574e[r110.f118409k.ordinal()];
        if (r104 != 1) goto L15;
        ReplayPlayerVisibilityControllerWidget r105 = this.this$0;
        View r106 = r110.f118407i;
        Animator r107 = ReplayPlayerVisibilityControllerWidget.Bq(r105, r106, r106.getTranslationY(), r103, this.$duration);
        ReplayPlayerVisibilityControllerWidget r108 = this.this$0;
        View r109 = r110.f118407i;
        if (this.$visible == false) goto L25;
        r102 = 1.0f;
    L25:
        Animator r111 = ReplayPlayerVisibilityControllerWidget.xq(r108, r109, r102, this.$duration);
        ReplayPlayerVisibilityControllerWidget.wq(this.this$0, r110.f118405g.name(), r107);
        ReplayPlayerVisibilityControllerWidget.wq(this.this$0, r110.f118405g.name(), r111);
        return;
    L15:
        if (r104 != 2) goto L28;
        float r112 = (this.this$0.f108477q - r110.f118400b) + UtilityKotlinExtentionsKt.b(r110.f118410l);
        if (this.$visible == false) goto L20;
        float r113 = UtilityKotlinExtentionsKt.b(-65);
    L21:
        ReplayPlayerVisibilityControllerWidget.wq(this.this$0, r110.f118405g.name(), ReplayPlayerVisibilityControllerWidget.zq(this.this$0, r110.f118407i, r113, r103, r112, this.$duration));
        return;
    L20:
        r113 = 0.0f;
        goto L21
    L28:
        return;
    L11:
        r103 = UtilityKotlinExtentionsKt.b(-65);
        goto L12
    L6:
        if (r101.intValue() != r100) goto L8;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
