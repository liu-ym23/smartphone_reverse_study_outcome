package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.utils;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class MorePanelButtonAnimUtils$showGuideAnim$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ int $darkColor;
    final /* synthetic */ boolean $endWithShadow;
    final /* synthetic */ View $iconBgView;
    final /* synthetic */ int $lightColor;
    final /* synthetic */ float $sourceScale;
    final /* synthetic */ float $targetScale;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.utils.MorePanelButtonAnimUtils$showGuideAnim$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ MorePanelButtonAnimUtils$showGuideAnim$1 this$0;

        public AnonymousClass1(MorePanelButtonAnimUtils$showGuideAnim$1 r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final q4 r100) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            r100.d(new C17331(this));
            r100.b(new AnonymousClass2(this));
            r100.b(new AnonymousClass3(this));
            r100.b(new AnonymousClass4(this));
            r100.b(new AnonymousClass5(this, r100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public MorePanelButtonAnimUtils$showGuideAnim$1(View r100, float r101, float r102, int r103, int r104, boolean r105) {
        this.$iconBgView = r100;
        this.$sourceScale = r101;
        this.$targetScale = r102;
        this.$lightColor = r103;
        this.$darkColor = r104;
        this.$endWithShadow = r105;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(q4 r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.c(new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
