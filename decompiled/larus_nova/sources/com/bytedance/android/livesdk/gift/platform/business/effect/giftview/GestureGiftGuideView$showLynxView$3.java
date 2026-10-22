package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwy0/e;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lwy0/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class GestureGiftGuideView$showLynxView$3 extends Lambda implements Function1<wy0.e, Unit> {
    final /* synthetic */ GestureGiftGuideView this$0;

    public static final class a extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureGiftGuideView$showLynxView$3 f129320a;

        public a(GestureGiftGuideView$showLynxView$3 r100) {
            this.f129320a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final Object invoke(Object r100, CallContext r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f129320a.this$0.a();
            ViewParent r102 = this.f129320a.this$0.getParent();
            if ((r102 instanceof ViewGroup) == true) goto L5;
            r102 = null;
        L5:
            ViewGroup r103 = (ViewGroup) r102;
            if (r103 == null) goto L8;
            r103.removeView(this.f129320a.this$0);
        L8:
            return null;
        }
    }

    public GestureGiftGuideView$showLynxView$3(GestureGiftGuideView r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(wy0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.registerMethod("close", new a(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(wy0.e r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
