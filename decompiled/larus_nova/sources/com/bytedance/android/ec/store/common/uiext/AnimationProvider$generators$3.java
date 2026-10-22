package com.bytedance.android.ec.store.common.uiext;

import android.view.animation.Animation;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/animation/Animation;", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class AnimationProvider$generators$3 extends FunctionReferenceImpl implements Function1<Boolean, Animation> {
    public static final AnimationProvider$generators$3 INSTANCE = null;

    static {
        INSTANCE = new AnimationProvider$generators$3();
    }

    public AnimationProvider$generators$3() {
        super(1, c.class, "generateZoomOutAnimation", "generateZoomOutAnimation(Z)Landroid/view/animation/Animation;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Animation invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }

    public final Animation invoke(boolean r100) {
        return c.a(r100, false);
    }
}
