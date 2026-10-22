package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
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
public final class ReplayPlayerVisibilityControllerWidget$handleAlphaViews$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ float $targetAlpha;
    final /* synthetic */ boolean $visible;
    final /* synthetic */ ReplayPlayerVisibilityControllerWidget this$0;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.model.c f108496a;

        public a(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
            this.f108496a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.j(this.f108496a.f118407i);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.model.c f108497a;

        public b(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
            this.f108497a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.i(this.f108497a.f118407i);
        }
    }

    public ReplayPlayerVisibilityControllerWidget$handleAlphaViews$1(ReplayPlayerVisibilityControllerWidget r100, boolean r101, float r102, long r103) {
        this.this$0 = r100;
        this.$visible = r101;
        this.$targetAlpha = r102;
        this.$duration = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = !this.$visible ? 1 : 0;
        Integer r102 = r100.f118404f.getValue();
        if (r102 != null) goto L6;
    L8:
        r100.f118404f.postValue(Integer.valueOf(r101));
        Animator r103 = ReplayPlayerVisibilityControllerWidget.xq(this.this$0, r100.f118407i, this.$targetAlpha, this.$duration);
        if (this.$visible == false) goto L11;
        r103.addListener(new a(r100));
    L12:
        ReplayPlayerVisibilityControllerWidget.wq(this.this$0, r100.f118405g.name(), r103);
        return;
    L11:
        r103.addListener(new b(r100));
        goto L12
    L6:
        if (r102.intValue() != r101) goto L8;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
