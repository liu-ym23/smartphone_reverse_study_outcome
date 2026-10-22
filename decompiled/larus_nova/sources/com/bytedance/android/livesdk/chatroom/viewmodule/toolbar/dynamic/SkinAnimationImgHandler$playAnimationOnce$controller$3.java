package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.a4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class SkinAnimationImgHandler$playAnimationOnce$controller$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HSImageView $animationView;
    final /* synthetic */ a4 $callback;

    public SkinAnimationImgHandler$playAnimationOnce$controller$3(HSImageView r100, a4 r101) {
        this.$animationView = r100;
        this.$callback = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$animationView.setController(null);
        a4 r100 = this.$callback;
        if (r100 == null) goto L6;
        r100.b(SkinLoadResultType.ERROR, null);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
