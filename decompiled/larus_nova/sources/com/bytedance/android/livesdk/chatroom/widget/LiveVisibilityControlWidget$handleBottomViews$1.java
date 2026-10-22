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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", MapController.ITEM_LAYER_TAG, "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/room/api/visibilitycontrol/d;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class LiveVisibilityControlWidget$handleBottomViews$1 extends Lambda implements Function1<com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ LiveVisibilityControlWidget this$0;

    public LiveVisibilityControlWidget$handleBottomViews$1(LiveVisibilityControlWidget r100, boolean r101, long r102) {
        this.this$0 = r100;
        this.$entiretyVisible = r101;
        this.$duration = r102;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.live.room.api.visibilitycontrol.d r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        if (r110.f99176n == true) goto L5;
        boolean r100 = this.$entiretyVisible;
    L9:
        int r101 = !r100;
        Integer r102 = r110.f99167e.getValue();
        if (r102 != null) goto L13;
    L15:
        r110.f99167e.postValue(Integer.valueOf(r101));
        if (com.bytedance.android.live.core.utils.z.m(this.this$0.dataCenter, true) == false) goto L18;
        int r103 = 55;
    L19:
        float r104 = 0.0f;
        if (r100 == 0) goto L22;
        float r105 = UtilityKotlinExtentionsKt.h(r103);
    L23:
        if (r100 == 0) goto L25;
        float r106 = 0.0f;
    L26:
        int r107 = e1.f118791f[r110.f99172j.ordinal()];
        if (r107 != 1) goto L29;
        long r108 = this.$duration;
        if (r108 <= 0) goto L45;
        Animator r109 = LiveVisibilityControlWidget.Aq(this.this$0, r110.f99170h, r105, r106, r108);
        LiveVisibilityControlWidget r111 = this.this$0;
        View r112 = r110.f99170h;
        if (r100 == 0) goto L44;
        r104 = 1.0f;
    L44:
        Animator r113 = LiveVisibilityControlWidget.wq(r111, r112, r104, this.$duration);
        ((ArrayList) this.this$0.f118575v).add(r109);
        ((ArrayList) this.this$0.f118575v).add(r113);
        return;
    L45:
        View r114 = r110.f99170h;
        if (r100 == 0) goto L48;
        r104 = 1.0f;
    L48:
        r114.setAlpha(r104);
        r110.f99170h.setTranslationY(r106);
        return;
    L29:
        if (r107 != 2) goto L53;
        float r115 = (this.this$0.f118572s - r110.f99163a) - UtilityKotlinExtentionsKt.h(r110.f99173k);
        long r116 = this.$duration;
        if (r116 <= 0) goto L34;
        ((ArrayList) this.this$0.f118575v).add(LiveVisibilityControlWidget.yq(this.this$0, r110.f99170h, r105, r106, r115, r116));
        return;
    L34:
        View r117 = r110.f99170h;
        if (r100 != 0) goto L38;
        r104 = r115;
    L38:
        r117.setTranslationY(r104);
        return;
    L53:
        return;
    L25:
        r106 = UtilityKotlinExtentionsKt.h(r103);
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
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
