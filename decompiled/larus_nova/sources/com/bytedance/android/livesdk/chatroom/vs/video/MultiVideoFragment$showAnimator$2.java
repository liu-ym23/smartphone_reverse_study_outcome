package com.bytedance.android.livesdk.chatroom.vs.video;

import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class MultiVideoFragment$showAnimator$2 extends Lambda implements Function0<ObjectAnimator> {
    final /* synthetic */ MultiVideoFragment this$0;

    public MultiVideoFragment$showAnimator$2(MultiVideoFragment r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ObjectAnimator invoke() {
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.this$0.f117770k, "alpha", new float[]{0.0f, 1.0f});
        h.a(r100, new MultiVideoFragment$showAnimator$2$$special$$inlined$apply$lambda$1(this));
        r100.setDuration(300);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ObjectAnimator invoke() {
        return invoke();
    }
}
