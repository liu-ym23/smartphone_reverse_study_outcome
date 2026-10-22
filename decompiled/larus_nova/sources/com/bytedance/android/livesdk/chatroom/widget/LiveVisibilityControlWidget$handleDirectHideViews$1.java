package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", MapController.ITEM_LAYER_TAG, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/room/api/visibilitycontrol/d;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class LiveVisibilityControlWidget$handleDirectHideViews$1 extends Lambda implements Function1<com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ LiveVisibilityControlWidget this$0;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.room.api.visibilitycontrol.d f118585a;

        public a(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
            this.f118585a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.w(this.f118585a.f99170h);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.room.api.visibilitycontrol.d f118586a;

        public b(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
            this.f118586a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.u(this.f118586a.f99170h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.w(this.f118586a.f99170h);
        }
    }

    public LiveVisibilityControlWidget$handleDirectHideViews$1(LiveVisibilityControlWidget r100, boolean r101, long r102) {
        this.this$0 = r100;
        this.$entiretyVisible = r101;
        this.$duration = r102;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (r100.f99176n == true) goto L5;
        boolean r101 = this.$entiretyVisible;
    L9:
        int r102 = !r101;
        Integer r103 = r100.f99167e.getValue();
        if (r103 != null) goto L13;
    L15:
        r100.f99167e.postValue(Integer.valueOf(r102));
        if (this.$duration <= 0) goto L22;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.setDuration(this.$duration);
        if (r101 == 0) goto L20;
        r104.addListener(new a(r100));
    L21:
        ((ArrayList) this.this$0.f118575v).add(r104);
        return;
    L20:
        r104.addListener(new b(r100));
        goto L21
    L22:
        UtilityKotlinExtentionsKt.A(r100.f99170h, r101);
        return;
    L13:
        if (r103.intValue() != r102) goto L15;
        return;
    L5:
        if (this.$entiretyVisible == true) goto L7;
        r101 = 1;
        goto L9
    L7:
        r101 = 0;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
