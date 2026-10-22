package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
public final class LiveVisibilityControlWidget$handleAlphaViews$1 extends Lambda implements Function1<com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ LiveVisibilityControlWidget this$0;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.room.api.visibilitycontrol.d f118583a;

        public a(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
            this.f118583a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.w(this.f118583a.f99170h);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.room.api.visibilitycontrol.d f118584a;

        public b(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
            this.f118584a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.u(this.f118584a.f99170h);
        }
    }

    public LiveVisibilityControlWidget$handleAlphaViews$1(LiveVisibilityControlWidget r100, boolean r101, long r102) {
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
        if (r101 == 0) goto L11;
        float r102 = 1.0f;
    L12:
        int r103 = !r101;
        Integer r104 = r100.f99167e.getValue();
        if (r104 != null) goto L16;
    L18:
        r100.f99167e.postValue(Integer.valueOf(r103));
        long r105 = this.$duration;
        if (r105 <= 0) goto L25;
        Animator r106 = LiveVisibilityControlWidget.wq(this.this$0, r100.f99170h, r102, r105);
        if (r101 == 0) goto L23;
        r106.addListener(new a(r100));
    L24:
        ((ArrayList) this.this$0.f118575v).add(r106);
        return;
    L23:
        r106.addListener(new b(r100));
        goto L24
    L25:
        r100.f99170h.setAlpha(r102);
        UtilityKotlinExtentionsKt.A(r100.f99170h, r101);
        return;
    L16:
        if (r104.intValue() != r103) goto L18;
        return;
    L11:
        r102 = 0.0f;
        goto L12
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
