package com.bytedance.android.livesdk.widget;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ScreenShotShareDialog$getMultiSearchAnimController$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ View $view;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.ScreenShotShareDialog$getMultiSearchAnimController$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ ScreenShotShareDialog$getMultiSearchAnimController$1 this$0;

        public AnonymousClass1(ScreenShotShareDialog$getMultiSearchAnimController$1 r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(q4 r100) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            r100.d(new C24631(this));
            r100.d(new AnonymousClass2(this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public ScreenShotShareDialog$getMultiSearchAnimController$1(View r100) {
        this.$view = r100;
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
