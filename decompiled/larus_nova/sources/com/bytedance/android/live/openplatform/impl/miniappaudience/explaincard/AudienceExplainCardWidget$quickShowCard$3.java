package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AudienceExplainCardWidget$quickShowCard$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $listener;
    final /* synthetic */ AudienceExplainCardWidget this$0;

    public AudienceExplainCardWidget$quickShowCard$3(AudienceExplainCardWidget r100, s r101) {
        this.this$0 = r100;
        this.$listener = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Animator r100 = this.this$0.f84840d;
        if (r100 == null) goto L9;
        h.a(r100, new AudienceExplainCardWidget$quickShowCard$3$$special$$inlined$run$lambda$1(this));
        s r101 = this.$listener;
        if (r101 == null) goto L7;
        r100.addListener(r101);
    L7:
        r100.start();
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
